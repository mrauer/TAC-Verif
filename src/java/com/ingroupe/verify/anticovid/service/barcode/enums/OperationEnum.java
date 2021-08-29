/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.service.barcode.enums;

public final class OperationEnum
extends Enum<OperationEnum> {
    private static final /* synthetic */ OperationEnum[] $VALUES;
    public static final /* enum */ OperationEnum CONVERT_HEX_TO_DATE;
    public static final /* enum */ OperationEnum CONVERT_STRING_TO_DATE;
    public static final /* enum */ OperationEnum DECODE_BASE16;
    public static final /* enum */ OperationEnum DECODE_BASE32;
    public static final /* enum */ OperationEnum DECODE_BASE36;
    public static final /* enum */ OperationEnum GET_COUNTRY;
    public static final /* enum */ OperationEnum REMOVE_SLASH;
    public static final /* enum */ OperationEnum TRANSLATE_BOOLEAN;

    public static {
        OperationEnum operationEnum;
        OperationEnum operationEnum2;
        OperationEnum operationEnum3;
        OperationEnum operationEnum4;
        OperationEnum operationEnum5;
        OperationEnum operationEnum6;
        OperationEnum operationEnum7;
        OperationEnum operationEnum8;
        CONVERT_HEX_TO_DATE = operationEnum2 = new OperationEnum();
        CONVERT_STRING_TO_DATE = operationEnum8 = new OperationEnum();
        DECODE_BASE16 = operationEnum3 = new OperationEnum();
        DECODE_BASE32 = operationEnum5 = new OperationEnum();
        DECODE_BASE36 = operationEnum7 = new OperationEnum();
        GET_COUNTRY = operationEnum = new OperationEnum();
        REMOVE_SLASH = operationEnum6 = new OperationEnum();
        TRANSLATE_BOOLEAN = operationEnum4 = new OperationEnum();
        $VALUES = new OperationEnum[]{operationEnum2, operationEnum8, operationEnum3, operationEnum5, operationEnum7, operationEnum, operationEnum6, operationEnum4};
    }

    public static OperationEnum valueOf(String string) {
        return (OperationEnum)Enum.valueOf(OperationEnum.class, (String)string);
    }

    public static OperationEnum[] values() {
        return (OperationEnum[])$VALUES.clone();
    }
}

