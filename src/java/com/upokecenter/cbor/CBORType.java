/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.upokecenter.cbor;

public final class CBORType
extends Enum<CBORType> {
    private static final /* synthetic */ CBORType[] $VALUES;
    public static final /* enum */ CBORType Array;
    public static final /* enum */ CBORType Boolean;
    public static final /* enum */ CBORType ByteString;
    public static final /* enum */ CBORType FloatingPoint;
    public static final /* enum */ CBORType Integer;
    public static final /* enum */ CBORType Map;
    @Deprecated
    public static final /* enum */ CBORType Number;
    public static final /* enum */ CBORType SimpleValue;
    public static final /* enum */ CBORType TextString;

    public static {
        CBORType cBORType;
        CBORType cBORType2;
        CBORType cBORType3;
        CBORType cBORType4;
        CBORType cBORType5;
        CBORType cBORType6;
        CBORType cBORType7;
        CBORType cBORType8;
        CBORType cBORType9;
        Number = cBORType2 = new CBORType();
        Boolean = cBORType4 = new CBORType();
        SimpleValue = cBORType3 = new CBORType();
        ByteString = cBORType9 = new CBORType();
        TextString = cBORType6 = new CBORType();
        Array = cBORType = new CBORType();
        Map = cBORType5 = new CBORType();
        Integer = cBORType7 = new CBORType();
        FloatingPoint = cBORType8 = new CBORType();
        $VALUES = new CBORType[]{cBORType2, cBORType4, cBORType3, cBORType9, cBORType6, cBORType, cBORType5, cBORType7, cBORType8};
    }

    public static CBORType valueOf(String string) {
        return (CBORType)Enum.valueOf(CBORType.class, (String)string);
    }

    public static CBORType[] values() {
        return (CBORType[])$VALUES.clone();
    }
}

