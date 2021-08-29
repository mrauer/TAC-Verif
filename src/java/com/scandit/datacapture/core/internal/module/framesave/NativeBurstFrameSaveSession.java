/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.framesave.NativeBurstFrameSaveSession$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.framesave;

import com.scandit.datacapture.core.internal.module.framesave.NativeBurstFrameSaveConfiguration;
import com.scandit.datacapture.core.internal.module.framesave.NativeBurstFrameSaveSession;
import com.scandit.datacapture.core.internal.module.framesave.NativeFrameSaveSession;
import com.scandit.datacapture.core.internal.module.framesave.NativeFrameSaveSessionListener;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBurstFrameSaveSession {
    public NativeBurstFrameSaveSession() {
    }

    public static NativeBurstFrameSaveSession create(NativeBurstFrameSaveConfiguration nativeBurstFrameSaveConfiguration) {
        return CppProxy.create((NativeBurstFrameSaveConfiguration)nativeBurstFrameSaveConfiguration);
    }

    public abstract void addListenerAsync(NativeFrameSaveSessionListener var1);

    public abstract void addToContext(NativeDataCaptureContext var1);

    public abstract NativeFrameSaveSession asFrameSaveSession();

    public abstract void disable();

    public abstract boolean empty();

    public abstract void enable();

    public abstract void flushPendingTasks();

    public abstract boolean isCollectingFrames();

    public abstract void removeFromContext(NativeDataCaptureContext var1);

    public abstract void removeListenerAsync(NativeFrameSaveSessionListener var1);

    public abstract void save();
}

