/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.sdk.capture;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeLicensedFeature
extends Enum<NativeLicensedFeature> {
    public static final /* enum */ NativeLicensedFeature AUGMENTED_REALITY;
    public static final /* enum */ NativeLicensedFeature CASE;
    public static final /* enum */ NativeLicensedFeature HIDE_LOGO;
    public static final /* enum */ NativeLicensedFeature OCR;
    public static final /* enum */ NativeLicensedFeature SHOW_MUST_GO_ONLINE_MESSAGE;
    public static final /* enum */ NativeLicensedFeature SHOW_TEST_LICENSE_MESSAGE;
    private static final /* synthetic */ NativeLicensedFeature[] a;

    public static {
        NativeLicensedFeature nativeLicensedFeature;
        NativeLicensedFeature nativeLicensedFeature2;
        NativeLicensedFeature nativeLicensedFeature3;
        NativeLicensedFeature nativeLicensedFeature4;
        NativeLicensedFeature nativeLicensedFeature5;
        NativeLicensedFeature nativeLicensedFeature6;
        OCR = nativeLicensedFeature3 = new NativeLicensedFeature();
        HIDE_LOGO = nativeLicensedFeature = new NativeLicensedFeature();
        SHOW_TEST_LICENSE_MESSAGE = nativeLicensedFeature5 = new NativeLicensedFeature();
        CASE = nativeLicensedFeature6 = new NativeLicensedFeature();
        SHOW_MUST_GO_ONLINE_MESSAGE = nativeLicensedFeature4 = new NativeLicensedFeature();
        AUGMENTED_REALITY = nativeLicensedFeature2 = new NativeLicensedFeature();
        a = new NativeLicensedFeature[]{nativeLicensedFeature3, nativeLicensedFeature, nativeLicensedFeature5, nativeLicensedFeature6, nativeLicensedFeature4, nativeLicensedFeature2};
    }

    public static NativeLicensedFeature valueOf(String string) {
        return (NativeLicensedFeature)Enum.valueOf(NativeLicensedFeature.class, (String)string);
    }

    public static NativeLicensedFeature[] values() {
        return (NativeLicensedFeature[])a.clone();
    }
}

