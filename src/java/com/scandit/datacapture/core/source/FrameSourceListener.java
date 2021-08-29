/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.source;

import com.scandit.datacapture.core.data.FrameData;
import com.scandit.datacapture.core.source.FrameSource;
import com.scandit.datacapture.core.source.FrameSourceState;

public interface FrameSourceListener {
    public void onFrameOutput(FrameSource var1, FrameData var2);

    public void onObservationStarted(FrameSource var1);

    public void onObservationStopped(FrameSource var1);

    public void onStateChanged(FrameSource var1, FrameSourceState var2);
}

