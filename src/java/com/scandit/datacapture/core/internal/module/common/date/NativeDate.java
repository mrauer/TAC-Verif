/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.common.date.NativeDate$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.common.date;

import com.scandit.datacapture.core.internal.module.common.date.NativeDate;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeDate {
    public NativeDate() {
    }

    public static NativeDate create(int n2, int n3, int n4) {
        return CppProxy.create((int)n2, (int)n3, (int)n4);
    }

    public abstract int day();

    public abstract int month();

    public abstract long secondsSinceEpochUInt64();

    public abstract int year();
}

