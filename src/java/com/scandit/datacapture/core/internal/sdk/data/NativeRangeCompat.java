/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.data.NativeRangeCompat$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.data;

import com.scandit.datacapture.core.data.Range;
import com.scandit.datacapture.core.internal.sdk.data.NativeRangeCompat;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeRangeCompat {
    public NativeRangeCompat() {
    }

    public static Range create(short s2, short s3, short s4) {
        return CppProxy.create((short)s2, (short)s3, (short)s4);
    }

    public static boolean isValid(Range range) {
        return CppProxy.isValid((Range)range);
    }
}

