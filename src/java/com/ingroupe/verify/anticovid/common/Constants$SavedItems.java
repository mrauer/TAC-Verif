/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.common;

public final class Constants$SavedItems
extends Enum<Constants$SavedItems> {
    private static final /* synthetic */ Constants$SavedItems[] $VALUES;
    public static final /* enum */ Constants$SavedItems CONF_DATE_EXP;
    public static final /* enum */ Constants$SavedItems CONF_NAME;
    public static final /* enum */ Constants$SavedItems CURRENT_SIREN;
    public static final /* enum */ Constants$SavedItems CURRENT_TOKEN;
    public static final /* enum */ Constants$SavedItems INFO_CGU_POLICY_SHOWN_V2;
    public static final /* enum */ Constants$SavedItems SHOW_RESULT_TUTO;
    public static final /* enum */ Constants$SavedItems SHOW_SCAN_TUTO;
    private final String text;

    public static {
        Constants$SavedItems constants$SavedItems;
        Constants$SavedItems constants$SavedItems2;
        Constants$SavedItems constants$SavedItems3;
        Constants$SavedItems constants$SavedItems4;
        Constants$SavedItems constants$SavedItems5;
        Constants$SavedItems constants$SavedItems6;
        Constants$SavedItems constants$SavedItems7;
        SHOW_SCAN_TUTO = constants$SavedItems2 = new Constants$SavedItems("SHOW_SCAN_TUTO");
        SHOW_RESULT_TUTO = constants$SavedItems5 = new Constants$SavedItems("SHOW_RESULT_TUTO");
        INFO_CGU_POLICY_SHOWN_V2 = constants$SavedItems = new Constants$SavedItems("INFO_CGU_POLICY_SHOWN_V2");
        CONF_NAME = constants$SavedItems6 = new Constants$SavedItems("CONF_NAME");
        CONF_DATE_EXP = constants$SavedItems4 = new Constants$SavedItems("CONF_DATE_EXP");
        CURRENT_TOKEN = constants$SavedItems7 = new Constants$SavedItems("CURRENT_TOKEN");
        CURRENT_SIREN = constants$SavedItems3 = new Constants$SavedItems("CURRENT_SIREN");
        $VALUES = new Constants$SavedItems[]{constants$SavedItems2, constants$SavedItems5, constants$SavedItems, constants$SavedItems6, constants$SavedItems4, constants$SavedItems7, constants$SavedItems3};
    }

    public Constants$SavedItems(String string2) {
        this.text = string2;
    }

    public static Constants$SavedItems valueOf(String string) {
        return (Constants$SavedItems)Enum.valueOf(Constants$SavedItems.class, (String)string);
    }

    public static Constants$SavedItems[] values() {
        return (Constants$SavedItems[])$VALUES.clone();
    }

    public final String getText() {
        return this.text;
    }
}

