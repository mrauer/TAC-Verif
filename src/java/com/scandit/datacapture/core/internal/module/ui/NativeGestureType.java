/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeGestureType
extends Enum<NativeGestureType> {
    public static final /* enum */ NativeGestureType DOUBLE_TAP;
    public static final /* enum */ NativeGestureType SWIPE_DOWN;
    public static final /* enum */ NativeGestureType SWIPE_UP;
    public static final /* enum */ NativeGestureType TAP;
    private static final /* synthetic */ NativeGestureType[] a;

    public static {
        NativeGestureType nativeGestureType;
        NativeGestureType nativeGestureType2;
        NativeGestureType nativeGestureType3;
        NativeGestureType nativeGestureType4;
        TAP = nativeGestureType4 = new NativeGestureType();
        DOUBLE_TAP = nativeGestureType3 = new NativeGestureType();
        SWIPE_UP = nativeGestureType2 = new NativeGestureType();
        SWIPE_DOWN = nativeGestureType = new NativeGestureType();
        a = new NativeGestureType[]{nativeGestureType4, nativeGestureType3, nativeGestureType2, nativeGestureType};
    }

    public static NativeGestureType valueOf(String string) {
        return (NativeGestureType)Enum.valueOf(NativeGestureType.class, (String)string);
    }

    public static NativeGestureType[] values() {
        return (NativeGestureType[])a.clone();
    }
}

