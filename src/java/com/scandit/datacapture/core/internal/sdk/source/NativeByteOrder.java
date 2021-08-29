/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.sdk.source;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeByteOrder
extends Enum<NativeByteOrder> {
    public static final /* enum */ NativeByteOrder BIG_ENDIAN;
    public static final /* enum */ NativeByteOrder LITTLE_ENDIAN;
    private static final /* synthetic */ NativeByteOrder[] a;

    public static {
        NativeByteOrder nativeByteOrder;
        NativeByteOrder nativeByteOrder2;
        BIG_ENDIAN = nativeByteOrder2 = new NativeByteOrder();
        LITTLE_ENDIAN = nativeByteOrder = new NativeByteOrder();
        a = new NativeByteOrder[]{nativeByteOrder2, nativeByteOrder};
    }

    public static NativeByteOrder valueOf(String string) {
        return (NativeByteOrder)Enum.valueOf(NativeByteOrder.class, (String)string);
    }

    public static NativeByteOrder[] values() {
        return (NativeByteOrder[])a.clone();
    }
}

