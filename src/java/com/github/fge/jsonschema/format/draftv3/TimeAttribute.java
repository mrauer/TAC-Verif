/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  org.joda.time.DateTimeFieldType
 *  org.joda.time.format.DateTimeFormatter
 *  org.joda.time.format.DateTimeFormatterBuilder
 */
package com.github.fge.jsonschema.format.draftv3;

import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.format.helpers.AbstractDateFormatAttribute;
import org.joda.time.DateTimeFieldType;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

public final class TimeAttribute
extends AbstractDateFormatAttribute {
    private static final FormatAttribute INSTANCE = new TimeAttribute();

    private TimeAttribute() {
        super("time", "HH:mm:ss");
    }

    public static FormatAttribute getInstance() {
        return INSTANCE;
    }

    @Override
    public DateTimeFormatter getFormatter() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendFixedDecimal(DateTimeFieldType.HOUR_OF_DAY_TYPE, 2);
        dateTimeFormatterBuilder.appendLiteral(':');
        dateTimeFormatterBuilder.appendFixedDecimal(DateTimeFieldType.MINUTE_OF_HOUR_TYPE, 2);
        dateTimeFormatterBuilder.appendLiteral(':');
        dateTimeFormatterBuilder.appendFixedDecimal(DateTimeFieldType.SECOND_OF_MINUTE_TYPE, 2);
        return dateTimeFormatterBuilder.toFormatter();
    }
}

