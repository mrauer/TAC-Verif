/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.capture;

import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeDataCaptureContextFrameListener {
    public abstract void onFrameProcessingFinished(NativeDataCaptureContext var1, NativeFrameData var2);

    public abstract void onFrameProcessingStarted(NativeDataCaptureContext var1, NativeFrameData var2);

    public abstract void onObservationStarted(NativeDataCaptureContext var1);

    public abstract void onObservationStopped(NativeDataCaptureContext var1);
}

