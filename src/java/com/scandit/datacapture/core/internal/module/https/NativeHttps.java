/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.https.NativeHttps$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.https;

import com.scandit.datacapture.core.internal.module.https.NativeHttps;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsSessionFactory;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeHttps {
    public NativeHttps() {
    }

    public static void setFactory(NativeHttpsSessionFactory nativeHttpsSessionFactory) {
        CppProxy.setFactory((NativeHttpsSessionFactory)nativeHttpsSessionFactory);
    }
}

