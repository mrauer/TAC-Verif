/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.common;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class Constants$Step
extends Enum<Constants$Step> {
    private static final /* synthetic */ Constants$Step[] $VALUES;
    public static final /* enum */ Constants$Step CERT_FREQUENCY;
    public static final /* enum */ Constants$Step CERT_STEP_1;
    public static final /* enum */ Constants$Step CERT_STEP_2;
    public static final /* enum */ Constants$Step CERT_STEP_3;
    private final long default;
    private final String text;

    public static {
        Constants$Step constants$Step;
        Constants$Step constants$Step2;
        Constants$Step constants$Step3;
        Constants$Step constants$Step4;
        CERT_STEP_1 = constants$Step = new Constants$Step("CERT_STEP_1", 72L);
        CERT_STEP_2 = constants$Step3 = new Constants$Step("CERT_STEP_2", 240L);
        CERT_STEP_3 = constants$Step4 = new Constants$Step("CERT_STEP_3", 72L);
        CERT_FREQUENCY = constants$Step2 = new Constants$Step("CERT_FREQUENCY", 24000L);
        $VALUES = new Constants$Step[]{constants$Step, constants$Step3, constants$Step4, constants$Step2};
    }

    public Constants$Step(String string2, long l3) {
        this.text = string2;
        this.default = l3;
    }

    public static Constants$Step valueOf(String string) {
        return (Constants$Step)Enum.valueOf(Constants$Step.class, (String)string);
    }

    public static Constants$Step[] values() {
        return (Constants$Step[])$VALUES.clone();
    }

    public final long getDefault() {
        return this.default;
    }

    public final String getText() {
        return this.text;
    }
}

