/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.common.NativeContextStatusCompat$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.common;

import com.scandit.datacapture.core.internal.sdk.common.NativeContextStatusCompat;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeContextStatusCompat {
    public NativeContextStatusCompat() {
    }

    public static boolean isSuccessOrUnknown(int n2) {
        return CppProxy.isSuccessOrUnknown((int)n2);
    }

    public static boolean isValid(int n2) {
        return CppProxy.isValid((int)n2);
    }
}

