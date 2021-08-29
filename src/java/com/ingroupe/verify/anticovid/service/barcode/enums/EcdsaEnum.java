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

public final class EcdsaEnum
extends Enum<EcdsaEnum> {
    private static final /* synthetic */ EcdsaEnum[] $VALUES;
    public static final Companion Companion;
    public static final /* enum */ EcdsaEnum P_256;
    public static final /* enum */ EcdsaEnum P_384;
    public static final /* enum */ EcdsaEnum P_521;
    private final String algorithm;
    private final int length;
    private final int padding;

    public static {
        EcdsaEnum ecdsaEnum;
        EcdsaEnum ecdsaEnum2;
        EcdsaEnum ecdsaEnum3;
        P_256 = ecdsaEnum2 = new EcdsaEnum(103, 1, "SHA256withECDSA");
        P_384 = ecdsaEnum3 = new EcdsaEnum(154, 6, "SHA384withECDSA");
        P_521 = ecdsaEnum = new EcdsaEnum(212, 4, "SHA512withECDSA");
        $VALUES = new EcdsaEnum[]{ecdsaEnum2, ecdsaEnum3, ecdsaEnum};
        Companion = new Companion(null);
    }

    public EcdsaEnum(int n3, int n4, String string2) {
        this.length = n3;
        this.padding = n4;
        this.algorithm = string2;
    }

    public static EcdsaEnum valueOf(String string) {
        return (EcdsaEnum)Enum.valueOf(EcdsaEnum.class, (String)string);
    }

    public static EcdsaEnum[] values() {
        return (EcdsaEnum[])$VALUES.clone();
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final int getLength() {
        return this.length;
    }

    public final int getPadding() {
        return this.padding;
    }

    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

}

