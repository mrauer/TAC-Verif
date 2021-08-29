/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.OrientationEventListener
 */
package com.scandit.datacapture.core.ui;

import android.content.Context;
import android.view.OrientationEventListener;
import com.scandit.datacapture.core.ui.DataCaptureView;

public final class DataCaptureView$orientationEventListener$1
extends OrientationEventListener {
    public /* synthetic */ DataCaptureView a;

    public DataCaptureView$orientationEventListener$1(DataCaptureView dataCaptureView, Context context, Context context2) {
        this.a = dataCaptureView;
        super(context2);
    }

    public final void onOrientationChanged(int n2) {
        int n3 = this.a.a();
        DataCaptureView dataCaptureView = this.a;
        if (n3 != dataCaptureView.m) {
            dataCaptureView.a(dataCaptureView.getMeasuredWidth(), this.a.getMeasuredHeight());
            DataCaptureView dataCaptureView2 = this.a;
            dataCaptureView2.m = dataCaptureView2.a();
        }
    }
}

