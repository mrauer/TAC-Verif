/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.service.document.enums;

public final class ErrorDocEnum
extends Enum<ErrorDocEnum> {
    private static final /* synthetic */ ErrorDocEnum[] $VALUES;
    public static final /* enum */ ErrorDocEnum ERR01;
    public static final /* enum */ ErrorDocEnum ERR02;
    public static final /* enum */ ErrorDocEnum ERR03;
    public static final /* enum */ ErrorDocEnum INF01;
    private final String message;

    public static {
        ErrorDocEnum errorDocEnum;
        ErrorDocEnum errorDocEnum2;
        ErrorDocEnum errorDocEnum3;
        ErrorDocEnum errorDocEnum4;
        INF01 = errorDocEnum3 = new ErrorDocEnum("Document with type {0} and criteria {1} found.");
        ERR01 = errorDocEnum = new ErrorDocEnum("Document with type {0} and criteria {1} not found.");
        ERR02 = errorDocEnum4 = new ErrorDocEnum("Cannot get barcode 2ddoc {0} from 2D-DOC API.");
        ERR03 = errorDocEnum2 = new ErrorDocEnum("Could not decode DCC");
        $VALUES = new ErrorDocEnum[]{errorDocEnum3, errorDocEnum, errorDocEnum4, errorDocEnum2};
    }

    public ErrorDocEnum(String string2) {
        this.message = string2;
    }

    public static ErrorDocEnum valueOf(String string) {
        return (ErrorDocEnum)Enum.valueOf(ErrorDocEnum.class, (String)string);
    }

    public static ErrorDocEnum[] values() {
        return (ErrorDocEnum[])$VALUES.clone();
    }

    public final String getMessage() {
        return this.message;
    }
}

