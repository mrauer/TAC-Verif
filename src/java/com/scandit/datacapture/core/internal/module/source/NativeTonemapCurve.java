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
public final class NativeTonemapCurve
extends Enum<NativeTonemapCurve> {
    public static final /* enum */ NativeTonemapCurve GAMMA22;
    public static final /* enum */ NativeTonemapCurve LINEAR;
    public static final /* enum */ NativeTonemapCurve NONE;
    public static final /* enum */ NativeTonemapCurve SRGB;
    private static final /* synthetic */ NativeTonemapCurve[] a;

    public static {
        NativeTonemapCurve nativeTonemapCurve;
        NativeTonemapCurve nativeTonemapCurve2;
        NativeTonemapCurve nativeTonemapCurve3;
        NativeTonemapCurve nativeTonemapCurve4;
        NONE = nativeTonemapCurve3 = new NativeTonemapCurve();
        LINEAR = nativeTonemapCurve = new NativeTonemapCurve();
        GAMMA22 = nativeTonemapCurve2 = new NativeTonemapCurve();
        SRGB = nativeTonemapCurve4 = new NativeTonemapCurve();
        a = new NativeTonemapCurve[]{nativeTonemapCurve3, nativeTonemapCurve, nativeTonemapCurve2, nativeTonemapCurve4};
    }

    public static NativeTonemapCurve valueOf(String string) {
        return (NativeTonemapCurve)Enum.valueOf(NativeTonemapCurve.class, (String)string);
    }

    public static NativeTonemapCurve[] values() {
        return (NativeTonemapCurve[])a.clone();
    }
}

