/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.capture;

import com.scandit.datacapture.core.capture.DataCaptureContext;
import com.scandit.datacapture.core.data.FrameData;

public interface DataCaptureContextFrameListener {
    public void onFrameProcessingFinished(DataCaptureContext var1, FrameData var2);

    public void onFrameProcessingStarted(DataCaptureContext var1, FrameData var2);

    public void onObservationStarted(DataCaptureContext var1);

    public void onObservationStopped(DataCaptureContext var1);
}

