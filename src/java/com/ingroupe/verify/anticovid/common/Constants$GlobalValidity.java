/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.common;

public final class Constants$GlobalValidity
extends Enum<Constants$GlobalValidity> {
    private static final /* synthetic */ Constants$GlobalValidity[] $VALUES;
    public static final /* enum */ Constants$GlobalValidity INFO;
    public static final /* enum */ Constants$GlobalValidity KO;
    public static final /* enum */ Constants$GlobalValidity OK;
    private final String text;

    public static {
        Constants$GlobalValidity constants$GlobalValidity;
        Constants$GlobalValidity constants$GlobalValidity2;
        Constants$GlobalValidity constants$GlobalValidity3;
        OK = constants$GlobalValidity2 = new Constants$GlobalValidity("ok");
        KO = constants$GlobalValidity3 = new Constants$GlobalValidity("ko");
        INFO = constants$GlobalValidity = new Constants$GlobalValidity("info");
        $VALUES = new Constants$GlobalValidity[]{constants$GlobalValidity2, constants$GlobalValidity3, constants$GlobalValidity};
    }

    public Constants$GlobalValidity(String string2) {
        this.text = string2;
    }

    public static Constants$GlobalValidity valueOf(String string) {
        return (Constants$GlobalValidity)Enum.valueOf(Constants$GlobalValidity.class, (String)string);
    }

    public static Constants$GlobalValidity[] values() {
        return (Constants$GlobalValidity[])$VALUES.clone();
    }

    public final String getText() {
        return this.text;
    }
}

