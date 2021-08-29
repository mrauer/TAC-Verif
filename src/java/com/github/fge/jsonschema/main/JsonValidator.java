/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.MissingNode
 *  com.github.fge.jackson.jsonpointer.JsonPointer
 *  com.github.fge.jsonschema.core.exceptions.JsonReferenceException
 *  com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle
 *  com.github.fge.jsonschema.core.report.ProcessingMessage
 *  com.github.fge.jsonschema.core.tree.JsonTree
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  com.github.fge.jsonschema.core.tree.SimpleJsonTree
 *  com.github.fge.jsonschema.main.JsonSchemaImpl
 *  com.github.fge.jsonschema.processors.data.FullData
 *  com.github.fge.jsonschema.processors.validation.ValidationProcessor
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URI
 *  java.util.Objects
 */
package com.github.fge.jsonschema.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.JsonReferenceException;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.load.SchemaLoader;
import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.processing.ProcessingResult;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.report.ReportProvider;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.tree.SimpleJsonTree;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaImpl;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.jsonschema.processors.validation.ValidationProcessor;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import java.net.URI;
import java.util.Objects;

public final class JsonValidator {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    private final SchemaLoader loader;
    private final ValidationProcessor processor;
    private final ReportProvider reportProvider;

    public JsonValidator(SchemaLoader schemaLoader, ValidationProcessor validationProcessor, ReportProvider reportProvider) {
        this.loader = schemaLoader;
        this.processor = validationProcessor;
        this.reportProvider = reportProvider;
    }

    private FullData buildData(JsonNode jsonNode, JsonNode jsonNode2, boolean bl) {
        MessageBundle messageBundle = BUNDLE;
        messageBundle.checkNotNull((Object)jsonNode, "nullSchema");
        messageBundle.checkNotNull((Object)jsonNode2, "nullInstance");
        return new FullData(this.loader.load(jsonNode), (JsonTree)new SimpleJsonTree(jsonNode2), bl);
    }

    public JsonSchema buildJsonSchema(JsonNode jsonNode, JsonPointer jsonPointer) throws ProcessingException {
        SchemaTree schemaTree = this.loader.load(jsonNode).setPointer(jsonPointer);
        JsonNode jsonNode2 = schemaTree.getNode();
        Objects.requireNonNull((Object)jsonNode2);
        if (!(jsonNode2 instanceof MissingNode)) {
            return new JsonSchemaImpl(this.processor, schemaTree, this.reportProvider);
        }
        throw new JsonReferenceException(new ProcessingMessage().setMessage(BUNDLE.getMessage("danglingRef")));
    }

    public JsonSchema buildJsonSchema(String string) throws ProcessingException {
        JsonRef jsonRef = JsonRef.fromString(string);
        if (jsonRef.isLegal()) {
            SchemaTree schemaTree = this.loader.get(jsonRef.getLocator()).setPointer(jsonRef.getPointer());
            JsonNode jsonNode = schemaTree.getNode();
            Objects.requireNonNull((Object)jsonNode);
            if (!(jsonNode instanceof MissingNode)) {
                return new JsonSchemaImpl(this.processor, schemaTree, this.reportProvider);
            }
            throw new JsonReferenceException(new ProcessingMessage().setMessage(BUNDLE.getMessage("danglingRef")));
        }
        throw new JsonReferenceException(new ProcessingMessage().setMessage(BUNDLE.getMessage("illegalJsonRef")));
    }

    public Processor<FullData, FullData> getProcessor() {
        return this.processor;
    }

    public ProcessingReport validate(JsonNode jsonNode, JsonNode jsonNode2) throws ProcessingException {
        return this.validate(jsonNode, jsonNode2, false);
    }

    public ProcessingReport validate(JsonNode jsonNode, JsonNode jsonNode2, boolean bl) throws ProcessingException {
        ProcessingReport processingReport = this.reportProvider.newReport();
        FullData fullData = this.buildData(jsonNode, jsonNode2, bl);
        return ProcessingResult.of(this.processor, processingReport, fullData).getReport();
    }

    public ProcessingReport validateUnchecked(JsonNode jsonNode, JsonNode jsonNode2) {
        return this.validateUnchecked(jsonNode, jsonNode2, false);
    }

    public ProcessingReport validateUnchecked(JsonNode jsonNode, JsonNode jsonNode2, boolean bl) {
        ProcessingReport processingReport = this.reportProvider.newReport();
        FullData fullData = this.buildData(jsonNode, jsonNode2, bl);
        return ProcessingResult.uncheckedResult(this.processor, processingReport, fullData).getReport();
    }
}

