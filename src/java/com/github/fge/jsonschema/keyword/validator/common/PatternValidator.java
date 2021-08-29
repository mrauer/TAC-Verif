/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.keyword.validator.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.util.RegexECMA262Helper;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;

public final class PatternValidator
extends AbstractKeywordValidator {
    public PatternValidator(JsonNode jsonNode) {
        super("pattern");
    }

    @Override
    public String toString() {
        return this.keyword;
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        String string;
        String string2 = fullData.getSchema().getNode().get(this.keyword).textValue();
        if (!RegexECMA262Helper.regMatch(string2, string = GeneratedOutlineSupport.outline8((FullData)fullData))) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.common.pattern.noMatch").putArgument("regex", string2).putArgument("string", string));
        }
    }
}

