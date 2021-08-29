/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.barcode.data;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class Checksum
extends Enum<Checksum> {
    public static final /* enum */ Checksum MOD10;
    public static final /* enum */ Checksum MOD103;
    public static final /* enum */ Checksum MOD10_AND_MOD10;
    public static final /* enum */ Checksum MOD10_AND_MOD11;
    public static final /* enum */ Checksum MOD11;
    public static final /* enum */ Checksum MOD16;
    public static final /* enum */ Checksum MOD43;
    public static final /* enum */ Checksum MOD47;
    private static final /* synthetic */ Checksum[] a;

    public static {
        Checksum checksum;
        Checksum checksum2;
        Checksum checksum3;
        Checksum checksum4;
        Checksum checksum5;
        Checksum checksum6;
        Checksum checksum7;
        Checksum checksum8;
        MOD10 = checksum6 = new Checksum();
        MOD11 = checksum7 = new Checksum();
        MOD47 = checksum5 = new Checksum();
        MOD103 = checksum3 = new Checksum();
        MOD10_AND_MOD10 = checksum = new Checksum();
        MOD10_AND_MOD11 = checksum4 = new Checksum();
        MOD43 = checksum8 = new Checksum();
        MOD16 = checksum2 = new Checksum();
        a = new Checksum[]{checksum6, checksum7, checksum5, checksum3, checksum, checksum4, checksum8, checksum2};
    }

    public static Checksum valueOf(String string) {
        return (Checksum)Enum.valueOf(Checksum.class, (String)string);
    }

    public static Checksum[] values() {
        return (Checksum[])a.clone();
    }
}

