/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.common.collect.ImmutableList
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  org.joda.time.DateTime
 *  org.joda.time.format.DateTimeFormat
 *  org.joda.time.format.DateTimeFormatter
 *  org.joda.time.format.DateTimeFormatterBuilder
 *  org.joda.time.format.DateTimeParser
 */
package com.github.fge.jsonschema.format.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.format.AbstractFormatAttribute;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.collect.ImmutableList;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

public class RFC3339DateTimeAttribute
extends AbstractFormatAttribute {
    private static final DateTimeFormatter FORMATTER;
    private static final FormatAttribute INSTANCE;
    private static final ImmutableList<String> RFC3339_FORMATS;

    public static {
        RFC3339_FORMATS = ImmutableList.of((Object)"yyyy-MM-dd'T'HH:mm:ss((+|-)HH:mm|Z)", (Object)"yyyy-MM-dd'T'HH:mm:ss.[0-9]{1,12}((+|-)HH:mm|Z)");
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendLiteral('.');
        dateTimeFormatterBuilder.appendFractionOfSecond(1, 12);
        DateTimeParser dateTimeParser = dateTimeFormatterBuilder.toParser();
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        DateTimeFormat.parsePatternTo((DateTimeFormatterBuilder)dateTimeFormatterBuilder2, (String)"yyyy-MM-dd'T'HH:mm:ss");
        dateTimeFormatterBuilder2.appendOptional(dateTimeParser);
        dateTimeFormatterBuilder2.appendTimeZoneOffset("Z", true, 2, 2);
        FORMATTER = dateTimeFormatterBuilder2.toFormatter();
        INSTANCE = new RFC3339DateTimeAttribute();
    }

    private RFC3339DateTimeAttribute() {
        super("date-time", NodeType.STRING, new NodeType[0]);
    }

    public static FormatAttribute getInstance() {
        return INSTANCE;
    }

    private boolean isOffSetStrictRFC3339(String string) {
        if (string.endsWith("Z")) {
            return true;
        }
        return string.length() == 6 && string.contains((CharSequence)":");
    }

    @Override
    public void validate(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        String string = GeneratedOutlineSupport.outline8((FullData)fullData);
        try {
            FORMATTER.parseDateTime(string);
            String string2 = string.substring(19);
            if (string2.startsWith(".")) {
                string2 = string2.contains((CharSequence)"Z") ? string2.substring(string2.indexOf("Z")) : (string2.contains((CharSequence)"+") ? string2.substring(string2.indexOf("+")) : string2.substring(string2.indexOf("-")));
            }
            if (this.isOffSetStrictRFC3339(string2)) {
                return;
            }
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.format.invalidDate").putArgument("value", string).putArgument("expected", RFC3339_FORMATS));
            return;
        }
    }
}

