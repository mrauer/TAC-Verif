/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.capture.NativeDeviceIdUtils$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.capture;

import com.scandit.datacapture.core.internal.module.capture.NativeDeviceIdUtils;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeDeviceIdUtils {
    public NativeDeviceIdUtils() {
    }

    public static String hashDeviceId(String string) {
        return CppProxy.hashDeviceId((String)string);
    }
}

