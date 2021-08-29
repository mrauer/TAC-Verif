/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.common;

public final class Constants$Criticity
extends Enum<Constants$Criticity> {
    private static final /* synthetic */ Constants$Criticity[] $VALUES;
    public static final /* enum */ Constants$Criticity CRITICAL;
    public static final /* enum */ Constants$Criticity INFO;
    private final String text;

    public static {
        Constants$Criticity constants$Criticity;
        Constants$Criticity constants$Criticity2;
        INFO = constants$Criticity2 = new Constants$Criticity("info");
        CRITICAL = constants$Criticity = new Constants$Criticity("critical");
        $VALUES = new Constants$Criticity[]{constants$Criticity2, constants$Criticity};
    }

    public Constants$Criticity(String string2) {
        this.text = string2;
    }

    public static Constants$Criticity valueOf(String string) {
        return (Constants$Criticity)Enum.valueOf(Constants$Criticity.class, (String)string);
    }

    public static Constants$Criticity[] values() {
        return (Constants$Criticity[])$VALUES.clone();
    }
}

