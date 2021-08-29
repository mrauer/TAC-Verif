/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  com.google.common.collect.Collections2
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.EnumSet
 *  java.util.Map
 */
package com.github.fge.jsonschema.processors.format;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.keyword.validator.KeywordValidator;
import com.github.fge.jsonschema.library.Library;
import com.github.fge.jsonschema.messages.JsonSchemaValidationBundle;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.jsonschema.processors.data.SchemaContext;
import com.github.fge.jsonschema.processors.data.ValidatorList;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import com.google.common.collect.Collections2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;

public final class FormatProcessor
implements Processor<ValidatorList, ValidatorList> {
    private final Map<String, FormatAttribute> attributes;
    private final MessageBundle bundle;

    public FormatProcessor(Dictionary<FormatAttribute> dictionary) {
        this.attributes = dictionary.entries();
        this.bundle = MessageBundles.getBundle(JsonSchemaValidationBundle.class);
    }

    public FormatProcessor(Library library, ValidationConfiguration validationConfiguration) {
        this.attributes = library.getFormatAttributes().entries();
        this.bundle = validationConfiguration.getValidationMessages();
    }

    private static KeywordValidator formatValidator(FormatAttribute formatAttribute) {
        return new KeywordValidator(){

            @Override
            public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
                FormatAttribute.this.validate(processingReport, messageBundle, fullData);
            }
        };
    }

    @Override
    public ValidatorList process(ProcessingReport processingReport, ValidatorList validatorList) throws ProcessingException {
        SchemaContext schemaContext = validatorList.getContext();
        JsonNode jsonNode = schemaContext.getSchema().getNode().get("format");
        if (jsonNode == null) {
            return validatorList;
        }
        String string = jsonNode.textValue();
        FormatAttribute formatAttribute = (FormatAttribute)this.attributes.get((Object)string);
        if (formatAttribute == null) {
            processingReport.warn(validatorList.newMessage().put("domain", "validation").put("keyword", "format").setMessage(this.bundle.getMessage("warn.format.notSupported")).putArgument("attribute", string));
            return validatorList;
        }
        NodeType nodeType = schemaContext.getInstanceType();
        if (!formatAttribute.supportedTypes().contains((Object)nodeType)) {
            return validatorList;
        }
        ArrayList arrayList = Collections2.newArrayList((Iterable)validatorList);
        arrayList.add((Object)FormatProcessor.formatValidator(formatAttribute));
        return new ValidatorList(schemaContext, (Collection<KeywordValidator>)arrayList);
    }

    public String toString() {
        return "format attribute handler";
    }

}

