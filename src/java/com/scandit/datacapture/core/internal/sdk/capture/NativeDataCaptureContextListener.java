/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.capture;

import com.scandit.datacapture.core.internal.module.source.NativeFrameSource;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureMode;
import com.scandit.datacapture.core.internal.sdk.common.NativeContextStatus;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeDataCaptureContextListener {
    public abstract void onFrameSourceChanged(NativeDataCaptureContext var1, NativeFrameSource var2);

    public abstract void onModeAdded(NativeDataCaptureContext var1, NativeDataCaptureMode var2);

    public abstract void onModeRemoved(NativeDataCaptureContext var1, NativeDataCaptureMode var2);

    public abstract void onObservationStarted(NativeDataCaptureContext var1);

    public abstract void onObservationStopped(NativeDataCaptureContext var1);

    public abstract void onStatusChanged(NativeDataCaptureContext var1, NativeContextStatus var2);
}

