/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.source.NativeBitmapInfo$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.source;

import com.scandit.datacapture.core.internal.sdk.source.NativeBitmapConfig;
import com.scandit.datacapture.core.internal.sdk.source.NativeBitmapInfo;
import com.scandit.datacapture.core.internal.sdk.source.NativeByteOrder;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBitmapInfo {
    public NativeBitmapInfo() {
    }

    public static NativeBitmapInfo create(NativeBitmapConfig nativeBitmapConfig, NativeByteOrder nativeByteOrder, byte[] arrby, int n2, int n3, int n4, int n5) {
        return CppProxy.create((NativeBitmapConfig)nativeBitmapConfig, (NativeByteOrder)nativeByteOrder, (byte[])arrby, (int)n2, (int)n3, (int)n4, (int)n5);
    }
}

