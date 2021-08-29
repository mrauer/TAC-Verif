/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.cfg.ValidationConfiguration
 *  com.github.fge.jsonschema.core.keyword.syntax.SyntaxProcessor
 *  com.github.fge.jsonschema.core.report.DevNullProcessingReport
 *  com.github.fge.jsonschema.core.report.ListProcessingReport
 *  com.github.fge.jsonschema.core.tree.CanonicalSchemaTree
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.ValueHolder
 *  com.github.fge.jsonschema.library.Library
 *  com.github.fge.jsonschema.processors.syntax.SyntaxValidator$1
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  com.google.common.base.Function
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.github.fge.jsonschema.processors.syntax;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.core.keyword.syntax.SyntaxProcessor;
import com.github.fge.jsonschema.core.processing.ProcessingResult;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.processing.ProcessorMap;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.report.DevNullProcessingReport;
import com.github.fge.jsonschema.core.report.ListProcessingReport;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.CanonicalSchemaTree;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.tree.key.SchemaKey;
import com.github.fge.jsonschema.core.util.AsJson;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.ValueHolder;
import com.github.fge.jsonschema.library.Library;
import com.github.fge.jsonschema.processors.syntax.SyntaxValidator;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.base.Function;
import java.util.Map;
import java.util.Set;

public final class SyntaxValidator {
    private static final Function<ValueHolder<SchemaTree>, JsonRef> FUNCTION = new 1();
    private final Processor<ValueHolder<SchemaTree>, ValueHolder<SchemaTree>> processor;

    public SyntaxValidator(ValidationConfiguration validationConfiguration) {
        MessageBundle messageBundle = validationConfiguration.getSyntaxMessages();
        ProcessorMap processorMap = new ProcessorMap(FUNCTION);
        Dictionary dictionary = validationConfiguration.getDefaultLibrary().getSyntaxCheckers();
        processorMap.setDefaultProcessor(new SyntaxProcessor(validationConfiguration.getSyntaxMessages(), dictionary));
        for (Map.Entry entry : validationConfiguration.getLibraries().entrySet()) {
            processorMap.addEntry((JsonRef)entry.getKey(), new SyntaxProcessor(messageBundle, ((Library)entry.getValue()).getSyntaxCheckers()));
        }
        this.processor = processorMap.getProcessor();
    }

    private ProcessingResult<ValueHolder<SchemaTree>> getResult(JsonNode jsonNode, ProcessingReport processingReport) {
        ValueHolder<SchemaTree> valueHolder = SyntaxValidator.holder(jsonNode);
        return ProcessingResult.uncheckedResult(this.processor, processingReport, valueHolder);
    }

    private static ValueHolder<SchemaTree> holder(JsonNode jsonNode) {
        return ValueHolder.hold((String)"schema", (AsJson)new CanonicalSchemaTree(SchemaKey.anonymousKey(), jsonNode));
    }

    public Processor<ValueHolder<SchemaTree>, ValueHolder<SchemaTree>> getProcessor() {
        return this.processor;
    }

    public boolean schemaIsValid(JsonNode jsonNode) {
        return this.getResult(jsonNode, (ProcessingReport)new DevNullProcessingReport()).isSuccess();
    }

    public ProcessingReport validateSchema(JsonNode jsonNode) {
        return this.getResult(jsonNode, (ProcessingReport)new ListProcessingReport()).getReport();
    }
}

