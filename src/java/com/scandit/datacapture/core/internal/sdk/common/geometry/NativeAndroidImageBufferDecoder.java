/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.common.geometry.NativeAndroidImageBufferDecoder$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.common.geometry;

import com.scandit.datacapture.core.internal.sdk.common.geometry.NativeAndroidImageBufferDecoder;
import com.scandit.datacapture.core.internal.sdk.common.geometry.NativeImageBuffer;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeAndroidImageBufferDecoder {
    public NativeAndroidImageBufferDecoder() {
    }

    public static NativeImageBuffer toARGB32ImageBuffer(byte[] arrby, int n2, int n3, int n4) {
        return CppProxy.toARGB32ImageBuffer((byte[])arrby, (int)n2, (int)n3, (int)n4);
    }

    public static NativeImageBuffer toBGRA32ImageBuffer(byte[] arrby, int n2, int n3, int n4) {
        return CppProxy.toBGRA32ImageBuffer((byte[])arrby, (int)n2, (int)n3, (int)n4);
    }

    public static NativeImageBuffer toNV21ImageBuffer(byte[] arrby, int n2, int n3) {
        return CppProxy.toNV21ImageBuffer((byte[])arrby, (int)n2, (int)n3);
    }
}

