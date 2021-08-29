/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.framesave.NativeSequenceFrameSaveSession$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.framesave;

import com.scandit.datacapture.core.internal.module.framesave.NativeFrameSaveSession;
import com.scandit.datacapture.core.internal.module.framesave.NativeFrameSaveSessionListener;
import com.scandit.datacapture.core.internal.module.framesave.NativeSequenceFrameSaveConfiguration;
import com.scandit.datacapture.core.internal.module.framesave.NativeSequenceFrameSaveSession;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeSequenceFrameSaveSession {
    public NativeSequenceFrameSaveSession() {
    }

    public static NativeSequenceFrameSaveSession create(NativeSequenceFrameSaveConfiguration nativeSequenceFrameSaveConfiguration) {
        return CppProxy.create((NativeSequenceFrameSaveConfiguration)nativeSequenceFrameSaveConfiguration);
    }

    public abstract void addListenerAsync(NativeFrameSaveSessionListener var1);

    public abstract void addToContext(NativeDataCaptureContext var1);

    public abstract NativeFrameSaveSession asFrameSaveSession();

    public abstract boolean empty();

    public abstract void flushPendingTasks();

    public abstract boolean isCollectingFrames();

    public abstract void removeFromContext(NativeDataCaptureContext var1);

    public abstract void removeListenerAsync(NativeFrameSaveSessionListener var1);

    public abstract void start();

    public abstract void stop();
}

