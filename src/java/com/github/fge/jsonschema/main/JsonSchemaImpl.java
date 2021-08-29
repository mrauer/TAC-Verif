/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.core.tree.JsonTree
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  com.github.fge.jsonschema.core.tree.SimpleJsonTree
 *  java.lang.Object
 */
package com.github.fge.jsonschema.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.ProcessingResult;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.report.ReportProvider;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.tree.SimpleJsonTree;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.jsonschema.processors.validation.ValidationProcessor;

public final class JsonSchemaImpl
implements JsonSchema {
    private final ValidationProcessor processor;
    private final ReportProvider reportProvider;
    private final SchemaTree schema;

    public JsonSchemaImpl(ValidationProcessor validationProcessor, SchemaTree schemaTree, ReportProvider reportProvider) {
        this.processor = validationProcessor;
        this.schema = schemaTree;
        this.reportProvider = reportProvider;
    }

    private ProcessingReport doValidate(JsonNode jsonNode, boolean bl) throws ProcessingException {
        FullData fullData = new FullData(this.schema, (JsonTree)new SimpleJsonTree(jsonNode), bl);
        ProcessingReport processingReport = this.reportProvider.newReport();
        return ProcessingResult.of(this.processor, processingReport, fullData).getReport();
    }

    private ProcessingReport doValidateUnchecked(JsonNode jsonNode, boolean bl) {
        FullData fullData = new FullData(this.schema, (JsonTree)new SimpleJsonTree(jsonNode), bl);
        ProcessingReport processingReport = this.reportProvider.newReport();
        return ProcessingResult.uncheckedResult(this.processor, processingReport, fullData).getReport();
    }

    @Override
    public boolean validInstance(JsonNode jsonNode) throws ProcessingException {
        return this.doValidate(jsonNode, false).isSuccess();
    }

    @Override
    public boolean validInstanceUnchecked(JsonNode jsonNode) {
        return this.doValidateUnchecked(jsonNode, false).isSuccess();
    }

    @Override
    public ProcessingReport validate(JsonNode jsonNode) throws ProcessingException {
        return this.validate(jsonNode, false);
    }

    @Override
    public ProcessingReport validate(JsonNode jsonNode, boolean bl) throws ProcessingException {
        return this.doValidate(jsonNode, bl);
    }

    @Override
    public ProcessingReport validateUnchecked(JsonNode jsonNode) {
        return this.doValidateUnchecked(jsonNode, false);
    }

    @Override
    public ProcessingReport validateUnchecked(JsonNode jsonNode, boolean bl) {
        return this.doValidateUnchecked(jsonNode, bl);
    }
}

