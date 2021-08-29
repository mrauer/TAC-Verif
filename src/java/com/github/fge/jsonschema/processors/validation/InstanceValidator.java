/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.github.fge.jsonschema.core.tree.JsonTree
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  com.github.fge.jsonschema.processors.validation.ArraySchemaDigester
 *  com.github.fge.jsonschema.processors.validation.ObjectSchemaDigester
 *  com.google.common.collect.Collections2
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package com.github.fge.jsonschema.processors.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.fge.jackson.JacksonUtils;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.InvalidSchemaException;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.keyword.validator.KeywordValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.jsonschema.processors.data.SchemaContext;
import com.github.fge.jsonschema.processors.data.ValidatorList;
import com.github.fge.jsonschema.processors.validation.ArraySchemaDigester;
import com.github.fge.jsonschema.processors.validation.ArraySchemaSelector;
import com.github.fge.jsonschema.processors.validation.ObjectSchemaDigester;
import com.github.fge.jsonschema.processors.validation.ObjectSchemaSelector;
import com.github.fge.jsonschema.processors.validation.ValidationStack;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.collect.Collections2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class InstanceValidator
implements Processor<FullData, FullData> {
    private final Processor<SchemaContext, ValidatorList> keywordBuilder;
    private final ValidationStack stack;
    private final MessageBundle syntaxMessages;
    private final MessageBundle validationMessages;

    public InstanceValidator(MessageBundle messageBundle, MessageBundle messageBundle2, Processor<SchemaContext, ValidatorList> processor) {
        this.syntaxMessages = messageBundle;
        this.validationMessages = messageBundle2;
        this.keywordBuilder = processor;
        this.stack = new ValidationStack(messageBundle2.getMessage("err.common.validationLoop"));
    }

    private ProcessingMessage collectSyntaxErrors(ProcessingReport processingReport) {
        String string = this.syntaxMessages.getMessage("core.invalidSchema");
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        Iterator iterator = processingReport.iterator();
        while (iterator.hasNext()) {
            JsonNode jsonNode = ((ProcessingMessage)iterator.next()).asJson();
            if (!"syntax".equals((Object)jsonNode.path("domain").asText())) continue;
            arrayNode._children.add((Object)jsonNode);
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.append("\nSyntax errors:\n");
        stringBuilder.append(JacksonUtils.prettyPrint((JsonNode)arrayNode));
        return new ProcessingMessage().setMessage(stringBuilder.toString());
    }

    private void processArray(ProcessingReport processingReport, FullData fullData) throws ProcessingException {
        SchemaTree schemaTree = fullData.getSchema();
        JsonTree jsonTree = fullData.getInstance();
        JsonNode jsonNode = schemaTree.getNode();
        JsonNode jsonNode2 = jsonTree.getNode();
        ArraySchemaSelector arraySchemaSelector = new ArraySchemaSelector(ArraySchemaDigester.getInstance().digest(jsonNode));
        int n = jsonNode2.size();
        for (int i = 0; i < n; ++i) {
            FullData fullData2 = fullData.withInstance(jsonTree.append(JsonPointer.of(i, new Object[0])));
            Iterator iterator = arraySchemaSelector.selectSchemas(i).iterator();
            while (iterator.hasNext()) {
                fullData2 = fullData2.withSchema(schemaTree.append((JsonPointer)iterator.next()));
                this.process(processingReport, fullData2);
            }
        }
    }

    private void processObject(ProcessingReport processingReport, FullData fullData) throws ProcessingException {
        SchemaTree schemaTree = fullData.getSchema();
        JsonTree jsonTree = fullData.getInstance();
        JsonNode jsonNode = schemaTree.getNode();
        JsonNode jsonNode2 = jsonTree.getNode();
        ObjectSchemaSelector objectSchemaSelector = new ObjectSchemaSelector(ObjectSchemaDigester.getInstance().digest(jsonNode));
        ArrayList arrayList = Collections2.newArrayList((Iterator)jsonNode2.fieldNames());
        Collections.sort((List)arrayList);
        for (String string : arrayList) {
            FullData fullData2 = fullData.withInstance(jsonTree.append(JsonPointer.of(string, new Object[0])));
            Iterator iterator = objectSchemaSelector.selectSchemas(string).iterator();
            while (iterator.hasNext()) {
                fullData2 = fullData2.withSchema(schemaTree.append((JsonPointer)iterator.next()));
                this.process(processingReport, fullData2);
            }
        }
    }

    @Override
    public FullData process(ProcessingReport processingReport, FullData fullData) throws ProcessingException {
        this.stack.push(fullData);
        SchemaContext schemaContext = new SchemaContext(fullData);
        ValidatorList validatorList = this.keywordBuilder.process(processingReport, schemaContext);
        if (validatorList != null) {
            FullData fullData2 = new FullData(validatorList.getContext().getSchema(), fullData.getInstance(), fullData.isDeepCheck());
            Iterator<KeywordValidator> iterator = validatorList.iterator();
            while (iterator.hasNext()) {
                ((KeywordValidator)iterator.next()).validate(this, processingReport, this.validationMessages, fullData2);
            }
            if (!processingReport.isSuccess() && !fullData2.isDeepCheck()) {
                this.stack.pop();
                return fullData;
            }
            JsonNode jsonNode = fullData2.getInstance().getNode();
            if (jsonNode.isContainerNode()) {
                if (jsonNode instanceof ArrayNode) {
                    this.processArray(processingReport, fullData2);
                } else {
                    this.processObject(processingReport, fullData2);
                }
            }
            this.stack.pop();
            return fullData;
        }
        throw new InvalidSchemaException(this.collectSyntaxErrors(processingReport));
    }

    public String toString() {
        return "instance validator";
    }
}

