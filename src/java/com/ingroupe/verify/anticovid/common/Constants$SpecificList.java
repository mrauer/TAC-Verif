/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.common;

public final class Constants$SpecificList
extends Enum<Constants$SpecificList> {
    private static final /* synthetic */ Constants$SpecificList[] $VALUES;
    public static final /* enum */ Constants$SpecificList TEST_ANTIGENIC;
    public static final /* enum */ Constants$SpecificList TEST_MANUFACTURER;
    public static final /* enum */ Constants$SpecificList TEST_PCR;
    public static final /* enum */ Constants$SpecificList VACCINE_MANUFACTURER;
    public static final /* enum */ Constants$SpecificList VACCINE_MEDICAL_PRODUCT;
    public static final /* enum */ Constants$SpecificList VACCINE_PROPHYLAXIS;
    private final String text;

    public static {
        Constants$SpecificList constants$SpecificList;
        Constants$SpecificList constants$SpecificList2;
        Constants$SpecificList constants$SpecificList3;
        Constants$SpecificList constants$SpecificList4;
        Constants$SpecificList constants$SpecificList5;
        Constants$SpecificList constants$SpecificList6;
        TEST_ANTIGENIC = constants$SpecificList6 = new Constants$SpecificList("testAntigenicList");
        TEST_MANUFACTURER = constants$SpecificList5 = new Constants$SpecificList("testManufacturerList");
        TEST_PCR = constants$SpecificList3 = new Constants$SpecificList("testPcrList");
        VACCINE_MANUFACTURER = constants$SpecificList = new Constants$SpecificList("vaccineManufacturerList");
        VACCINE_MEDICAL_PRODUCT = constants$SpecificList2 = new Constants$SpecificList("vaccineMedicalProductList");
        VACCINE_PROPHYLAXIS = constants$SpecificList4 = new Constants$SpecificList("vaccineProphylaxisList");
        $VALUES = new Constants$SpecificList[]{constants$SpecificList6, constants$SpecificList5, constants$SpecificList3, constants$SpecificList, constants$SpecificList2, constants$SpecificList4};
    }

    public Constants$SpecificList(String string2) {
        this.text = string2;
    }

    public static Constants$SpecificList valueOf(String string) {
        return (Constants$SpecificList)Enum.valueOf(Constants$SpecificList.class, (String)string);
    }

    public static Constants$SpecificList[] values() {
        return (Constants$SpecificList[])$VALUES.clone();
    }

    public final String getText() {
        return this.text;
    }
}

