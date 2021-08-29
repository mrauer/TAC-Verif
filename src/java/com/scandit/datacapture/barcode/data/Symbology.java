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
public final class Symbology
extends Enum<Symbology> {
    public static final /* enum */ Symbology AZTEC;
    public static final /* enum */ Symbology CODABAR;
    public static final /* enum */ Symbology CODE11;
    public static final /* enum */ Symbology CODE128;
    public static final /* enum */ Symbology CODE25;
    public static final /* enum */ Symbology CODE32;
    public static final /* enum */ Symbology CODE39;
    public static final /* enum */ Symbology CODE93;
    public static final /* enum */ Symbology DATA_MATRIX;
    public static final /* enum */ Symbology DOT_CODE;
    public static final /* enum */ Symbology EAN13_UPCA;
    public static final /* enum */ Symbology EAN8;
    public static final /* enum */ Symbology GS1_DATABAR;
    public static final /* enum */ Symbology GS1_DATABAR_EXPANDED;
    public static final /* enum */ Symbology GS1_DATABAR_LIMITED;
    public static final /* enum */ Symbology IATA_TWO_OF_FIVE;
    public static final /* enum */ Symbology INTERLEAVED_TWO_OF_FIVE;
    public static final /* enum */ Symbology KIX;
    public static final /* enum */ Symbology LAPA4SC;
    public static final /* enum */ Symbology MATRIX_TWO_OF_FIVE;
    public static final /* enum */ Symbology MAXI_CODE;
    public static final /* enum */ Symbology MICRO_PDF417;
    public static final /* enum */ Symbology MICRO_QR;
    public static final /* enum */ Symbology MSI_PLESSEY;
    public static final /* enum */ Symbology PDF417;
    public static final /* enum */ Symbology QR;
    public static final /* enum */ Symbology RM4SCC;
    public static final /* enum */ Symbology UPCE;
    public static final /* enum */ Symbology USPS_INTELLIGENT_MAIL;
    private static final /* synthetic */ Symbology[] a;

    public static {
        Symbology symbology;
        Symbology symbology2;
        Symbology symbology3;
        Symbology symbology4;
        Symbology symbology5;
        Symbology symbology6;
        Symbology symbology7;
        Symbology symbology8;
        Symbology symbology9;
        Symbology symbology10;
        Symbology symbology11;
        Symbology symbology12;
        Symbology symbology13;
        Symbology symbology14;
        Symbology symbology15;
        Symbology symbology16;
        Symbology symbology17;
        Symbology symbology18;
        Symbology symbology19;
        Symbology symbology20;
        Symbology symbology21;
        Symbology symbology22;
        Symbology symbology23;
        Symbology symbology24;
        Symbology symbology25;
        Symbology symbology26;
        Symbology symbology27;
        Symbology symbology28;
        Symbology symbology29;
        EAN13_UPCA = symbology26 = new Symbology();
        UPCE = symbology28 = new Symbology();
        EAN8 = symbology3 = new Symbology();
        CODE39 = symbology21 = new Symbology();
        CODE93 = symbology19 = new Symbology();
        CODE128 = symbology14 = new Symbology();
        CODE11 = symbology27 = new Symbology();
        CODE25 = symbology18 = new Symbology();
        CODABAR = symbology13 = new Symbology();
        INTERLEAVED_TWO_OF_FIVE = symbology25 = new Symbology();
        MSI_PLESSEY = symbology6 = new Symbology();
        QR = symbology9 = new Symbology();
        DATA_MATRIX = symbology17 = new Symbology();
        AZTEC = symbology = new Symbology();
        MAXI_CODE = symbology12 = new Symbology();
        DOT_CODE = symbology23 = new Symbology();
        KIX = symbology8 = new Symbology();
        RM4SCC = symbology16 = new Symbology();
        GS1_DATABAR = symbology5 = new Symbology();
        GS1_DATABAR_EXPANDED = symbology11 = new Symbology();
        GS1_DATABAR_LIMITED = symbology22 = new Symbology();
        PDF417 = symbology7 = new Symbology();
        MICRO_PDF417 = symbology10 = new Symbology();
        MICRO_QR = symbology29 = new Symbology();
        CODE32 = symbology2 = new Symbology();
        LAPA4SC = symbology20 = new Symbology();
        IATA_TWO_OF_FIVE = symbology24 = new Symbology();
        MATRIX_TWO_OF_FIVE = symbology4 = new Symbology();
        USPS_INTELLIGENT_MAIL = symbology15 = new Symbology();
        a = new Symbology[]{symbology26, symbology28, symbology3, symbology21, symbology19, symbology14, symbology27, symbology18, symbology13, symbology25, symbology6, symbology9, symbology17, symbology, symbology12, symbology23, symbology8, symbology16, symbology5, symbology11, symbology22, symbology7, symbology10, symbology29, symbology2, symbology20, symbology24, symbology4, symbology15};
    }

    public static Symbology valueOf(String string) {
        return (Symbology)Enum.valueOf(Symbology.class, (String)string);
    }

    public static Symbology[] values() {
        return (Symbology[])a.clone();
    }
}

