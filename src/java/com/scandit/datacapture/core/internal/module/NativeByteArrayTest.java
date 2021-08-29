/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.NativeByteArrayTest$CppProxy
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package com.scandit.datacapture.core.internal.module;

import com.scandit.datacapture.core.internal.module.NativeByteArrayTest;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.nio.ByteBuffer;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeByteArrayTest {
    public NativeByteArrayTest() {
    }

    public static int getArraySize(byte[] arrby) {
        return CppProxy.getArraySize((byte[])arrby);
    }

    public static byte getElementAtIndex(byte[] arrby, int n2) {
        return CppProxy.getElementAtIndex((byte[])arrby, (int)n2);
    }

    public static void multiply(ByteBuffer byteBuffer, int n2) {
        CppProxy.multiply((ByteBuffer)byteBuffer, (int)n2);
    }
}

