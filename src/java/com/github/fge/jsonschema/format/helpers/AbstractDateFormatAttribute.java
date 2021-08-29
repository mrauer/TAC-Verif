/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  org.joda.time.LocalDate
 *  org.joda.time.format.DateTimeFormatter
 */
package com.github.fge.jsonschema.format.helpers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.format.AbstractFormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;

public abstract class AbstractDateFormatAttribute
extends AbstractFormatAttribute {
    private final String format;

    public AbstractDateFormatAttribute(String string, String string2) {
        super(string, NodeType.STRING, new NodeType[0]);
        this.format = string2;
    }

    public abstract DateTimeFormatter getFormatter();

    @Override
    public final void validate(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        DateTimeFormatter dateTimeFormatter = this.getFormatter();
        String string = GeneratedOutlineSupport.outline8((FullData)fullData);
        try {
            dateTimeFormatter.parseLocalDate(string);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.format.invalidDate").putArgument("value", string).putArgument("expected", this.format));
            return;
        }
    }
}

