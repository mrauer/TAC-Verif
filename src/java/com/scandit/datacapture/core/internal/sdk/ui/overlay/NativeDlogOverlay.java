/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.ui.overlay.NativeDlogOverlay$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.ui.overlay;

import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.ui.overlay.NativeDataCaptureOverlay;
import com.scandit.datacapture.core.internal.sdk.ui.overlay.NativeDlogOverlay;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeDlogOverlay {
    public NativeDlogOverlay() {
    }

    public static NativeDlogOverlay create(NativeDataCaptureContext nativeDataCaptureContext) {
        return CppProxy.create((NativeDataCaptureContext)nativeDataCaptureContext);
    }

    public abstract NativeDataCaptureOverlay asDataCaptureOverlay();
}

