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
public final class NativeRegionStrategy
extends Enum<NativeRegionStrategy> {
    public static final /* enum */ NativeRegionStrategy AREA;
    public static final /* enum */ NativeRegionStrategy DEFAULT;
    public static final /* enum */ NativeRegionStrategy MATCH_WITH_SCAN_AREA;
    public static final /* enum */ NativeRegionStrategy POINT;
    public static final /* enum */ NativeRegionStrategy SPOT;
    private static final /* synthetic */ NativeRegionStrategy[] a;

    public static {
        NativeRegionStrategy nativeRegionStrategy;
        NativeRegionStrategy nativeRegionStrategy2;
        NativeRegionStrategy nativeRegionStrategy3;
        NativeRegionStrategy nativeRegionStrategy4;
        NativeRegionStrategy nativeRegionStrategy5;
        DEFAULT = nativeRegionStrategy5 = new NativeRegionStrategy();
        POINT = nativeRegionStrategy3 = new NativeRegionStrategy();
        SPOT = nativeRegionStrategy2 = new NativeRegionStrategy();
        AREA = nativeRegionStrategy4 = new NativeRegionStrategy();
        MATCH_WITH_SCAN_AREA = nativeRegionStrategy = new NativeRegionStrategy();
        a = new NativeRegionStrategy[]{nativeRegionStrategy5, nativeRegionStrategy3, nativeRegionStrategy2, nativeRegionStrategy4, nativeRegionStrategy};
    }

    public static NativeRegionStrategy valueOf(String string) {
        return (NativeRegionStrategy)Enum.valueOf(NativeRegionStrategy.class, (String)string);
    }

    public static NativeRegionStrategy[] values() {
        return (NativeRegionStrategy[])a.clone();
    }
}

