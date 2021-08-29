/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.common.collect.ImmutableList
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  org.joda.time.DateTime
 *  org.joda.time.DateTimeFieldType
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
import org.joda.time.DateTimeFieldType;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

public final class DateTimeAttribute
extends AbstractFormatAttribute {
    private static final ImmutableList<String> FORMATS = ImmutableList.of((Object)"yyyy-MM-dd'T'HH:mm:ssZ", (Object)"yyyy-MM-dd'T'HH:mm:ss.[0-9]{1,12}Z");
    private static final DateTimeFormatter FORMATTER;
    private static final FormatAttribute INSTANCE;

    public static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendLiteral('.');
        dateTimeFormatterBuilder.appendFractionOfSecond(1, 12);
        DateTimeParser dateTimeParser = dateTimeFormatterBuilder.toParser();
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder2.appendFixedDecimal(DateTimeFieldType.YEAR_TYPE, 4);
        dateTimeFormatterBuilder2.appendLiteral('-');
        dateTimeFormatterBuilder2.appendFixedDecimal(DateTimeFieldType.MONTH_OF_YEAR_TYPE, 2);
        dateTimeFormatterBuilder2.appendLiteral('-');
        dateTimeFormatterBuilder2.appendFixedDecimal(DateTimeFieldType.DAY_OF_MONTH_TYPE, 2);
        dateTimeFormatterBuilder2.appendLiteral('T');
        dateTimeFormatterBuilder2.appendFixedDecimal(DateTimeFieldType.HOUR_OF_DAY_TYPE, 2);
        dateTimeFormatterBuilder2.appendLiteral(':');
        dateTimeFormatterBuilder2.appendFixedDecimal(DateTimeFieldType.MINUTE_OF_HOUR_TYPE, 2);
        dateTimeFormatterBuilder2.appendLiteral(':');
        dateTimeFormatterBuilder2.appendFixedDecimal(DateTimeFieldType.SECOND_OF_MINUTE_TYPE, 2);
        dateTimeFormatterBuilder2.appendOptional(dateTimeParser);
        dateTimeFormatterBuilder2.appendTimeZoneOffset("Z", false, 2, 2);
        FORMATTER = dateTimeFormatterBuilder2.toFormatter();
        INSTANCE = new DateTimeAttribute();
    }

    private DateTimeAttribute() {
        super("date-time", NodeType.STRING, new NodeType[0]);
    }

    public static FormatAttribute getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        String string = GeneratedOutlineSupport.outline8((FullData)fullData);
        try {
            FORMATTER.parseDateTime(string);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.format.invalidDate").putArgument("value", string).putArgument("expected", FORMATS));
            return;
        }
    }
}

