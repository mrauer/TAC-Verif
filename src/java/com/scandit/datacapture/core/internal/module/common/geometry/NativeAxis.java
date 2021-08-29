/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.common.geometry;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeAxis
extends Enum<NativeAxis> {
    public static final /* enum */ NativeAxis NONE;
    public static final /* enum */ NativeAxis X;
    public static final /* enum */ NativeAxis Y;
    private static final /* synthetic */ NativeAxis[] a;

    public static {
        NativeAxis nativeAxis;
        NativeAxis nativeAxis2;
        NativeAxis nativeAxis3;
        NONE = nativeAxis3 = new NativeAxis();
        X = nativeAxis2 = new NativeAxis();
        Y = nativeAxis = new NativeAxis();
        a = new NativeAxis[]{nativeAxis3, nativeAxis2, nativeAxis};
    }

    public static NativeAxis valueOf(String string) {
        return (NativeAxis)Enum.valueOf(NativeAxis.class, (String)string);
    }

    public static NativeAxis[] values() {
        return (NativeAxis[])a.clone();
    }
}

