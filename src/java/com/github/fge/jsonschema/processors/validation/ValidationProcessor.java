/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.processors.validation;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.jsonschema.processors.data.SchemaContext;
import com.github.fge.jsonschema.processors.data.ValidatorList;
import com.github.fge.jsonschema.processors.validation.InstanceValidator;
import com.github.fge.msgsimple.bundle.MessageBundle;

public final class ValidationProcessor
implements Processor<FullData, FullData> {
    private final Processor<SchemaContext, ValidatorList> processor;
    private final MessageBundle syntaxMessages;
    private final MessageBundle validationMessages;

    public ValidationProcessor(ValidationConfiguration validationConfiguration, Processor<SchemaContext, ValidatorList> processor) {
        this.syntaxMessages = validationConfiguration.getSyntaxMessages();
        this.validationMessages = validationConfiguration.getValidationMessages();
        this.processor = processor;
    }

    @Override
    public FullData process(ProcessingReport processingReport, FullData fullData) throws ProcessingException {
        return new InstanceValidator(this.syntaxMessages, this.validationMessages, this.processor).process(processingReport, fullData);
    }

    public String toString() {
        return "validation processor";
    }
}

