/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.scandit.datacapture.core.capture;

import com.scandit.datacapture.core.capture.DataCaptureContext;
import com.scandit.datacapture.core.source.FrameSource;

public final class DataCaptureContext$g
implements Runnable {
    public /* synthetic */ DataCaptureContext a;
    public /* synthetic */ FrameSource b;
    public /* synthetic */ Runnable c;

    public DataCaptureContext$g(DataCaptureContext dataCaptureContext, FrameSource frameSource, Runnable runnable) {
        this.a = dataCaptureContext;
        this.b = frameSource;
        this.c = runnable;
    }

    public final void run() {
        this.a.a = this.b;
        Runnable runnable = this.c;
        if (runnable != null) {
            runnable.run();
        }
    }
}

