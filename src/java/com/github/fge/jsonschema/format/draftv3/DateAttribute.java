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

public final class DateAttribute
extends AbstractDateFormatAttribute {
    private static final FormatAttribute INSTANCE = new DateAttribute();

    private DateAttribute() {
        super("date", "yyyy-MM-dd");
    }

    public static FormatAttribute getInstance() {
        return INSTANCE;
    }

    @Override
    public DateTimeFormatter getFormatter() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendFixedDecimal(DateTimeFieldType.YEAR_TYPE, 4);
        dateTimeFormatterBuilder.appendLiteral('-');
        dateTimeFormatterBuilder.appendFixedDecimal(DateTimeFieldType.MONTH_OF_YEAR_TYPE, 2);
        dateTimeFormatterBuilder.appendLiteral('-');
        dateTimeFormatterBuilder.appendFixedDecimal(DateTimeFieldType.DAY_OF_MONTH_TYPE, 2);
        return dateTimeFormatterBuilder.toFormatter();
    }
}

