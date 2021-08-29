/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.UUID
 */
package com.github.fge.jsonschema.format.extra;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.format.AbstractFormatAttribute;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.UUID;

public final class UUIDFormatAttribute
extends AbstractFormatAttribute {
    private static final FormatAttribute instance = new UUIDFormatAttribute();

    private UUIDFormatAttribute() {
        super("uuid", NodeType.STRING, new NodeType[0]);
    }

    public static FormatAttribute getInstance() {
        return instance;
    }

    @Override
    public void validate(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        String string = GeneratedOutlineSupport.outline8((FullData)fullData);
        try {
            UUID.fromString((String)string);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.format.UUID.invalid").putArgument("value", string));
            return;
        }
    }
}

