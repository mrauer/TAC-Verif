/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.uritemplate.expression;

public final class ExpressionType
extends Enum<ExpressionType> {
    private static final /* synthetic */ ExpressionType[] $VALUES;
    public static final /* enum */ ExpressionType FRAGMENT;
    public static final /* enum */ ExpressionType NAME_LABELS;
    public static final /* enum */ ExpressionType PATH_PARAMETERS;
    public static final /* enum */ ExpressionType PATH_SEGMENTS;
    public static final /* enum */ ExpressionType QUERY_CONT;
    public static final /* enum */ ExpressionType QUERY_STRING;
    public static final /* enum */ ExpressionType RESERVED;
    public static final /* enum */ ExpressionType SIMPLE;
    private final String ifEmpty;
    private final boolean named;
    private final String prefix;
    private final boolean rawExpand;
    private final char separator;

    public static {
        ExpressionType expressionType;
        ExpressionType expressionType2;
        ExpressionType expressionType3;
        ExpressionType expressionType4;
        ExpressionType expressionType5;
        ExpressionType expressionType6;
        ExpressionType expressionType7;
        ExpressionType expressionType8;
        SIMPLE = expressionType4 = new ExpressionType("", ',', false, "", false);
        RESERVED = expressionType2 = new ExpressionType("", ',', false, "", true);
        NAME_LABELS = expressionType3 = new ExpressionType(".", '.', false, "", false);
        PATH_SEGMENTS = expressionType7 = new ExpressionType("/", '/', false, "", false);
        PATH_PARAMETERS = expressionType5 = new ExpressionType(";", ';', true, "", false);
        QUERY_STRING = expressionType = new ExpressionType("?", '&', true, "=", false);
        QUERY_CONT = expressionType6 = new ExpressionType("&", '&', true, "=", false);
        FRAGMENT = expressionType8 = new ExpressionType("#", ',', false, "", true);
        $VALUES = new ExpressionType[]{expressionType4, expressionType2, expressionType3, expressionType7, expressionType5, expressionType, expressionType6, expressionType8};
    }

    public ExpressionType(String string2, char c4, boolean bl, String string3, boolean bl2) {
        this.prefix = string2;
        this.separator = c4;
        this.named = bl;
        this.ifEmpty = string3;
        this.rawExpand = bl2;
    }

    public static ExpressionType valueOf(String string) {
        return (ExpressionType)Enum.valueOf(ExpressionType.class, (String)string);
    }

    public static ExpressionType[] values() {
        return (ExpressionType[])$VALUES.clone();
    }
}

