/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.NativeAllocation$CppProxy
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package com.scandit.datacapture.core.internal.module;

import com.scandit.datacapture.core.internal.module.NativeAllocation;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.nio.ByteBuffer;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeAllocation {
    public NativeAllocation() {
    }

    public static NativeAllocation allocate(int n2) {
        return CppProxy.allocate((int)n2);
    }

    public abstract ByteBuffer getBuffer();

    public abstract void release();
}

