/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView;
import com.scandit.datacapture.core.internal.module.ui.NativeSwipeToZoom;
import com.scandit.datacapture.core.internal.module.ui.NativeTapToFocus;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeDataCaptureViewDeserializerHelper {
    public abstract NativeSwipeToZoom createSwipeToZoom();

    public abstract NativeTapToFocus createTapToFocus();

    public abstract NativeDataCaptureView createView(NativeDataCaptureContext var1);

    public abstract void createdNullFocusGesture();

    public abstract void createdNullZoomGesture();

    public abstract void updateViewFromJson(NativeDataCaptureView var1, NativeJsonValue var2);
}

