/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.source;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeNoiseReduction
extends Enum<NativeNoiseReduction> {
    public static final /* enum */ NativeNoiseReduction FAST;
    public static final /* enum */ NativeNoiseReduction HIGH_QUALITY;
    public static final /* enum */ NativeNoiseReduction OFF;
    private static final /* synthetic */ NativeNoiseReduction[] a;

    public static {
        NativeNoiseReduction nativeNoiseReduction;
        NativeNoiseReduction nativeNoiseReduction2;
        NativeNoiseReduction nativeNoiseReduction3;
        OFF = nativeNoiseReduction2 = new NativeNoiseReduction();
        FAST = nativeNoiseReduction = new NativeNoiseReduction();
        HIGH_QUALITY = nativeNoiseReduction3 = new NativeNoiseReduction();
        a = new NativeNoiseReduction[]{nativeNoiseReduction2, nativeNoiseReduction, nativeNoiseReduction3};
    }

    public static NativeNoiseReduction valueOf(String string) {
        return (NativeNoiseReduction)Enum.valueOf(NativeNoiseReduction.class, (String)string);
    }

    public static NativeNoiseReduction[] values() {
        return (NativeNoiseReduction[])a.clone();
    }
}

