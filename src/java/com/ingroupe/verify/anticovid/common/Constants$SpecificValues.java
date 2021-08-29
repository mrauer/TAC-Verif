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
public final class Constants$SpecificValues
extends Enum<Constants$SpecificValues> {
    private static final /* synthetic */ Constants$SpecificValues[] $VALUES;
    public static final /* enum */ Constants$SpecificValues RECOVERY_END_DAY;
    public static final /* enum */ Constants$SpecificValues RECOVERY_START_DAY;
    public static final /* enum */ Constants$SpecificValues TEST_NEGATIVE_ANTIGENIC_END_HOUR;
    public static final /* enum */ Constants$SpecificValues TEST_NEGATIVE_PCR_END_HOUR;
    public static final /* enum */ Constants$SpecificValues TEST_NEGATIVE_PRIMO_ANTIGENIC_END_HOUR;
    public static final /* enum */ Constants$SpecificValues TEST_NEGATIVE_PRIMO_PCR_END_HOUR;
    public static final /* enum */ Constants$SpecificValues TEST_POSITIVE_ANTIGENIC_END_DAY;
    public static final /* enum */ Constants$SpecificValues TEST_POSITIVE_ANTIGENIC_START_DAY;
    public static final /* enum */ Constants$SpecificValues TEST_POSITIVE_PCR_END_DAY;
    public static final /* enum */ Constants$SpecificValues TEST_POSITIVE_PCR_START_DAY;
    public static final /* enum */ Constants$SpecificValues VACCINE_DELAY;
    public static final /* enum */ Constants$SpecificValues VACCINE_DELAY_JANSSEN;
    private final int default;
    private final String text;

    public static {
        Constants$SpecificValues constants$SpecificValues;
        Constants$SpecificValues constants$SpecificValues2;
        Constants$SpecificValues constants$SpecificValues3;
        Constants$SpecificValues constants$SpecificValues4;
        Constants$SpecificValues constants$SpecificValues5;
        Constants$SpecificValues constants$SpecificValues6;
        Constants$SpecificValues constants$SpecificValues7;
        Constants$SpecificValues constants$SpecificValues8;
        Constants$SpecificValues constants$SpecificValues9;
        Constants$SpecificValues constants$SpecificValues10;
        Constants$SpecificValues constants$SpecificValues11;
        Constants$SpecificValues constants$SpecificValues12;
        RECOVERY_END_DAY = constants$SpecificValues4 = new Constants$SpecificValues("recoveryEndDay", 183);
        RECOVERY_START_DAY = constants$SpecificValues11 = new Constants$SpecificValues("recoveryStartDay", 11);
        TEST_NEGATIVE_ANTIGENIC_END_HOUR = constants$SpecificValues = new Constants$SpecificValues("testNegativeAntigenicEndHour", 72);
        TEST_NEGATIVE_PCR_END_HOUR = constants$SpecificValues5 = new Constants$SpecificValues("testNegativePcrEndHour", 72);
        TEST_NEGATIVE_PRIMO_ANTIGENIC_END_HOUR = constants$SpecificValues8 = new Constants$SpecificValues("testNegativePrimoAntigenicEndHour", 72);
        TEST_NEGATIVE_PRIMO_PCR_END_HOUR = constants$SpecificValues6 = new Constants$SpecificValues("testNegativePrimoPcrEndHour", 72);
        TEST_POSITIVE_ANTIGENIC_END_DAY = constants$SpecificValues3 = new Constants$SpecificValues("testPositiveAntigenicEndDay", 183);
        TEST_POSITIVE_ANTIGENIC_START_DAY = constants$SpecificValues10 = new Constants$SpecificValues("testPositiveAntigenicStartDay", 11);
        TEST_POSITIVE_PCR_END_DAY = constants$SpecificValues9 = new Constants$SpecificValues("testPositivePcrEndDay", 183);
        TEST_POSITIVE_PCR_START_DAY = constants$SpecificValues12 = new Constants$SpecificValues("testPositivePcrStartDay", 11);
        VACCINE_DELAY = constants$SpecificValues7 = new Constants$SpecificValues("vaccineDelay", 7);
        VACCINE_DELAY_JANSSEN = constants$SpecificValues2 = new Constants$SpecificValues("vaccineDelayJanssen", 28);
        $VALUES = new Constants$SpecificValues[]{constants$SpecificValues4, constants$SpecificValues11, constants$SpecificValues, constants$SpecificValues5, constants$SpecificValues8, constants$SpecificValues6, constants$SpecificValues3, constants$SpecificValues10, constants$SpecificValues9, constants$SpecificValues12, constants$SpecificValues7, constants$SpecificValues2};
    }

    public Constants$SpecificValues(String string2, int n4) {
        this.text = string2;
        this.default = n4;
    }

    public static Constants$SpecificValues valueOf(String string) {
        return (Constants$SpecificValues)Enum.valueOf(Constants$SpecificValues.class, (String)string);
    }

    public static Constants$SpecificValues[] values() {
        return (Constants$SpecificValues[])$VALUES.clone();
    }

    public final int getDefault() {
        return this.default;
    }

    public final String getText() {
        return this.text;
    }
}

