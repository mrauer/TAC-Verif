/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.ui;

import com.scandit.datacapture.core.capture.DataCaptureContext;
import com.scandit.datacapture.core.capture.DataCaptureContextListener;
import com.scandit.datacapture.core.capture.DataCaptureMode;
import com.scandit.datacapture.core.common.ContextStatus;
import com.scandit.datacapture.core.internal.module.ui.control.ControlLayout;
import com.scandit.datacapture.core.source.FrameSource;
import com.scandit.datacapture.core.ui.DataCaptureView;
import kotlin.jvm.internal.Intrinsics;

public final class DataCaptureView$dataCaptureContextListener$1
implements DataCaptureContextListener {
    public /* synthetic */ DataCaptureView a;

    public DataCaptureView$dataCaptureContextListener$1(DataCaptureView dataCaptureView) {
        this.a = dataCaptureView;
    }

    @Override
    public final void onFrameSourceChanged(DataCaptureContext dataCaptureContext, FrameSource frameSource) {
        Intrinsics.checkNotNullParameter((Object)dataCaptureContext, (String)"dataCaptureContext");
        this.a.getControlLayout$scandit_capture_core().a(frameSource);
    }

    @Override
    public final void onModeAdded(DataCaptureContext dataCaptureContext, DataCaptureMode dataCaptureMode) {
        Intrinsics.checkNotNullParameter((Object)dataCaptureContext, (String)"dataCaptureContext");
        Intrinsics.checkNotNullParameter((Object)dataCaptureMode, (String)"dataCaptureMode");
        Intrinsics.checkNotNullParameter((Object)dataCaptureContext, (String)"dataCaptureContext");
        Intrinsics.checkNotNullParameter((Object)dataCaptureMode, (String)"dataCaptureMode");
    }

    @Override
    public final void onModeRemoved(DataCaptureContext dataCaptureContext, DataCaptureMode dataCaptureMode) {
        Intrinsics.checkNotNullParameter((Object)dataCaptureContext, (String)"dataCaptureContext");
        Intrinsics.checkNotNullParameter((Object)dataCaptureMode, (String)"dataCaptureMode");
        Intrinsics.checkNotNullParameter((Object)dataCaptureContext, (String)"dataCaptureContext");
        Intrinsics.checkNotNullParameter((Object)dataCaptureMode, (String)"dataCaptureMode");
    }

    @Override
    public final void onObservationStarted(DataCaptureContext dataCaptureContext) {
        Intrinsics.checkNotNullParameter((Object)dataCaptureContext, (String)"dataCaptureContext");
        this.a.getControlLayout$scandit_capture_core().a(dataCaptureContext.a);
    }

    @Override
    public final void onObservationStopped(DataCaptureContext dataCaptureContext) {
        Intrinsics.checkNotNullParameter((Object)dataCaptureContext, (String)"dataCaptureContext");
        this.a.getControlLayout$scandit_capture_core().a(null);
    }

    @Override
    public final void onStatusChanged(DataCaptureContext dataCaptureContext, ContextStatus contextStatus) {
        Intrinsics.checkNotNullParameter((Object)dataCaptureContext, (String)"dataCaptureContext");
        Intrinsics.checkNotNullParameter((Object)contextStatus, (String)"contextStatus");
        Intrinsics.checkNotNullParameter((Object)dataCaptureContext, (String)"dataCaptureContext");
        Intrinsics.checkNotNullParameter((Object)contextStatus, (String)"contextStatus");
    }
}

