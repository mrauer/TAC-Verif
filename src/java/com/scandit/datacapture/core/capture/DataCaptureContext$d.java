/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.Set
 */
package com.scandit.datacapture.core.capture;

import com.scandit.datacapture.core.capture.DataCaptureContext;
import com.scandit.datacapture.core.capture.DataCaptureMode;
import java.util.Set;

public final class DataCaptureContext$d
implements Runnable {
    public /* synthetic */ DataCaptureContext a;
    public /* synthetic */ DataCaptureMode b;

    public DataCaptureContext$d(DataCaptureContext dataCaptureContext, DataCaptureMode dataCaptureMode) {
        this.a = dataCaptureContext;
        this.b = dataCaptureMode;
    }

    public final void run() {
        this.b._setDataCaptureContext(this.a);
        this.a.b.add((Object)this.b);
    }
}

