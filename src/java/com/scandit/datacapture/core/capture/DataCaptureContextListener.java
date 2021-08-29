/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.capture;

import com.scandit.datacapture.core.capture.DataCaptureContext;
import com.scandit.datacapture.core.capture.DataCaptureMode;
import com.scandit.datacapture.core.common.ContextStatus;
import com.scandit.datacapture.core.source.FrameSource;

public interface DataCaptureContextListener {
    public void onFrameSourceChanged(DataCaptureContext var1, FrameSource var2);

    public void onModeAdded(DataCaptureContext var1, DataCaptureMode var2);

    public void onModeRemoved(DataCaptureContext var1, DataCaptureMode var2);

    public void onObservationStarted(DataCaptureContext var1);

    public void onObservationStopped(DataCaptureContext var1);

    public void onStatusChanged(DataCaptureContext var1, ContextStatus var2);
}

