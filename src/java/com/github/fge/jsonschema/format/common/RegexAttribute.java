/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.format.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.util.RegexECMA262Helper;
import com.github.fge.jsonschema.format.AbstractFormatAttribute;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;

public final class RegexAttribute
extends AbstractFormatAttribute {
    private static final FormatAttribute INSTANCE = new RegexAttribute();

    private RegexAttribute() {
        super("regex", NodeType.STRING, new NodeType[0]);
    }

    public static FormatAttribute getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        String string = GeneratedOutlineSupport.outline8((FullData)fullData);
        if (!RegexECMA262Helper.regexIsValid(string)) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.format.invalidRegex").putArgument("value", string));
        }
    }
}

