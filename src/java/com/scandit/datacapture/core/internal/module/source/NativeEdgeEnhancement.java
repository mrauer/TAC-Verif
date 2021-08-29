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
public final class NativeEdgeEnhancement
extends Enum<NativeEdgeEnhancement> {
    public static final /* enum */ NativeEdgeEnhancement FAST;
    public static final /* enum */ NativeEdgeEnhancement HIGH_QUALITY;
    public static final /* enum */ NativeEdgeEnhancement OFF;
    private static final /* synthetic */ NativeEdgeEnhancement[] a;

    public static {
        NativeEdgeEnhancement nativeEdgeEnhancement;
        NativeEdgeEnhancement nativeEdgeEnhancement2;
        NativeEdgeEnhancement nativeEdgeEnhancement3;
        OFF = nativeEdgeEnhancement3 = new NativeEdgeEnhancement();
        FAST = nativeEdgeEnhancement = new NativeEdgeEnhancement();
        HIGH_QUALITY = nativeEdgeEnhancement2 = new NativeEdgeEnhancement();
        a = new NativeEdgeEnhancement[]{nativeEdgeEnhancement3, nativeEdgeEnhancement, nativeEdgeEnhancement2};
    }

    public static NativeEdgeEnhancement valueOf(String string) {
        return (NativeEdgeEnhancement)Enum.valueOf(NativeEdgeEnhancement.class, (String)string);
    }

    public static NativeEdgeEnhancement[] values() {
        return (NativeEdgeEnhancement[])a.clone();
    }
}

