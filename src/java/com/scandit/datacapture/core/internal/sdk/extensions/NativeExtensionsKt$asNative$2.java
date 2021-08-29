/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Runnable
 */
package com.scandit.datacapture.core.internal.sdk.extensions;

import com.scandit.datacapture.core.internal.sdk.common.async.NativeBoolCallable;

public final class NativeExtensionsKt$asNative$2
extends NativeBoolCallable {
    public /* synthetic */ Runnable a;

    public NativeExtensionsKt$asNative$2(Runnable runnable) {
        this.a = runnable;
    }

    @Override
    public final void run(boolean bl) {
        this.a.run();
    }
}

