/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.capture;

import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeDataCaptureMode {
    public abstract NativeDataCaptureContext getContext();

    public abstract boolean isAttachedToContext();

    public abstract boolean isEnabled();

    public abstract void onContextAttached(NativeDataCaptureContext var1);

    public abstract void onContextDetached(NativeDataCaptureContext var1);

    public abstract void setEnabled(boolean var1);
}

