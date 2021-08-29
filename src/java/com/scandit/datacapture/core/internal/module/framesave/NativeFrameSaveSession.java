/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.framesave;

import com.scandit.datacapture.core.internal.module.framesave.NativeFrameSaveSessionListener;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeFrameSaveSession {
    public abstract void addListenerAsync(NativeFrameSaveSessionListener var1);

    public abstract void addToContext(NativeDataCaptureContext var1);

    public abstract boolean empty();

    public abstract boolean isCollectingFrames();

    public abstract void removeFromContext(NativeDataCaptureContext var1);

    public abstract void removeListenerAsync(NativeFrameSaveSessionListener var1);
}

