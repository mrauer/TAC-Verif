/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package com.ingroupe.verify.anticovid.service.barcode.enums;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ErrorBarcodeEnum
extends Enum<ErrorBarcodeEnum> {
    private static final /* synthetic */ ErrorBarcodeEnum[] $VALUES;
    public static final String CANNOT_READ_FULL_MESSAGE = "Une partie du message n'a pas pu \u00eatre lue";
    public static final Companion Companion;
    public static final /* enum */ ErrorBarcodeEnum ERR01;
    public static final /* enum */ ErrorBarcodeEnum ERR02;
    public static final /* enum */ ErrorBarcodeEnum ERR03;
    public static final /* enum */ ErrorBarcodeEnum ERR04;
    public static final /* enum */ ErrorBarcodeEnum ERR05;
    public static final /* enum */ ErrorBarcodeEnum ERR06;
    public static final /* enum */ ErrorBarcodeEnum ERR07;
    public static final /* enum */ ErrorBarcodeEnum ERR08;
    public static final /* enum */ ErrorBarcodeEnum ERR09;
    public static final /* enum */ ErrorBarcodeEnum ERR10;
    public static final /* enum */ ErrorBarcodeEnum INF01;
    private final String message;

    public static {
        ErrorBarcodeEnum errorBarcodeEnum;
        ErrorBarcodeEnum errorBarcodeEnum2;
        ErrorBarcodeEnum errorBarcodeEnum3;
        ErrorBarcodeEnum errorBarcodeEnum4;
        ErrorBarcodeEnum errorBarcodeEnum5;
        ErrorBarcodeEnum errorBarcodeEnum6;
        ErrorBarcodeEnum errorBarcodeEnum7;
        ErrorBarcodeEnum errorBarcodeEnum8;
        ErrorBarcodeEnum errorBarcodeEnum9;
        ErrorBarcodeEnum errorBarcodeEnum10;
        ErrorBarcodeEnum errorBarcodeEnum11;
        ERR01 = errorBarcodeEnum8 = new ErrorBarcodeEnum("2D-Doc '{}' is not valid");
        ERR02 = errorBarcodeEnum10 = new ErrorBarcodeEnum("Header version '{}' not found");
        ERR03 = errorBarcodeEnum5 = new ErrorBarcodeEnum("Document type '{}' not found");
        ERR04 = errorBarcodeEnum3 = new ErrorBarcodeEnum("Cannot convert date '{}'");
        ERR05 = errorBarcodeEnum4 = new ErrorBarcodeEnum("Cannot get country '{}'");
        ERR06 = errorBarcodeEnum7 = new ErrorBarcodeEnum("Certificate '{}' not found");
        ERR07 = errorBarcodeEnum11 = new ErrorBarcodeEnum("Invalid format signature '{}'");
        ERR08 = errorBarcodeEnum = new ErrorBarcodeEnum("Cannot verify signature '{}'");
        ERR09 = errorBarcodeEnum9 = new ErrorBarcodeEnum("Check signature '{}' KO");
        ERR10 = errorBarcodeEnum6 = new ErrorBarcodeEnum("Cannot get medical result '{}'");
        INF01 = errorBarcodeEnum2 = new ErrorBarcodeEnum("Verify signature '{}'");
        $VALUES = new ErrorBarcodeEnum[]{errorBarcodeEnum8, errorBarcodeEnum10, errorBarcodeEnum5, errorBarcodeEnum3, errorBarcodeEnum4, errorBarcodeEnum7, errorBarcodeEnum11, errorBarcodeEnum, errorBarcodeEnum9, errorBarcodeEnum6, errorBarcodeEnum2};
        Companion = new Companion(null);
    }

    public ErrorBarcodeEnum(String string2) {
        this.message = string2;
    }

    public static ErrorBarcodeEnum valueOf(String string) {
        return (ErrorBarcodeEnum)Enum.valueOf(ErrorBarcodeEnum.class, (String)string);
    }

    public static ErrorBarcodeEnum[] values() {
        return (ErrorBarcodeEnum[])$VALUES.clone();
    }

    public final String getMessage() {
        return this.message;
    }

    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

}

