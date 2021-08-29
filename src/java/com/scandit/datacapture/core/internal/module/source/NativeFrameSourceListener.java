/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.source;

import com.scandit.datacapture.core.internal.module.source.NativeFrameSource;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.core.source.FrameSourceState;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeFrameSourceListener {
    public abstract void onFrameOutputAndroid(NativeFrameSource var1, NativeFrameData var2);

    public abstract void onObservationStarted(NativeFrameSource var1);

    public abstract void onObservationStopped(NativeFrameSource var1);

    public abstract void onStateChanged(NativeFrameSource var1, FrameSourceState var2);
}

