/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeNoViewfinder$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.ui.viewfinder;

import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeNoViewfinder;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeViewfinder;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeNoViewfinder {
    public NativeNoViewfinder() {
    }

    public static NativeNoViewfinder create() {
        return CppProxy.create();
    }

    public abstract NativeViewfinder asViewfinder();
}

