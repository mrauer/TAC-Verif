/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.scandit.datacapture.core.common.geometry.Anchor;
import com.scandit.datacapture.core.common.geometry.MarginsWithUnit;
import com.scandit.datacapture.core.common.geometry.Point;
import com.scandit.datacapture.core.common.geometry.PointWithUnit;
import com.scandit.datacapture.core.internal.module.ui.NativeContextStatusListener;
import com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView;
import com.scandit.datacapture.core.internal.module.ui.NativeFocusGesture;
import com.scandit.datacapture.core.internal.module.ui.NativeGestureRecognizer;
import com.scandit.datacapture.core.internal.module.ui.NativeHintPresenter;
import com.scandit.datacapture.core.internal.module.ui.NativeNotificationPresenter;
import com.scandit.datacapture.core.internal.module.ui.NativeZoomGesture;
import com.scandit.datacapture.core.internal.module.ui.video.NativeVideoPreview;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.ui.NativeNeedsRedrawDelegate;
import com.scandit.datacapture.core.internal.sdk.ui.overlay.NativeDataCaptureOverlay;
import com.scandit.datacapture.core.ui.LogoStyle;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeDataCaptureView {
    public NativeDataCaptureView() {
    }

    public static NativeDataCaptureView create(float f2) {
        return CppProxy.create((float)f2);
    }

    public abstract void addOverlay(NativeDataCaptureOverlay var1);

    public abstract void attachToWindow();

    public abstract void detachFromWindow();

    public abstract void draw();

    public abstract NativeDataCaptureContext getDataCaptureContext();

    public abstract NativeFocusGesture getFocusGesture();

    public abstract NativeHintPresenter getHintPresenter();

    public abstract Anchor getLogoAnchor();

    public abstract PointWithUnit getLogoOffset();

    public abstract LogoStyle getLogoStyle();

    public abstract NativeNotificationPresenter getNotificationPresenter();

    public abstract PointWithUnit getPointOfInterest();

    public abstract MarginsWithUnit getScanAreaMargins();

    public abstract NativeVideoPreview getVideoPreview();

    public abstract NativeZoomGesture getZoomGesture();

    public abstract boolean isLogoHidden();

    public abstract Point mapFramePointToView(Point var1);

    public abstract void releaseGlResources();

    public abstract void removeOverlay(NativeDataCaptureOverlay var1);

    public abstract void setContextStatusListener(NativeContextStatusListener var1);

    public abstract void setDataCaptureContext(NativeDataCaptureContext var1);

    public abstract void setFocusGesture(NativeFocusGesture var1);

    public abstract void setGestureRecognizer(NativeGestureRecognizer var1);

    public abstract void setHintPresenter(NativeHintPresenter var1);

    public abstract void setLogoAnchor(Anchor var1);

    public abstract void setLogoHidden(boolean var1);

    public abstract void setLogoOffset(PointWithUnit var1);

    public abstract void setLogoStyle(LogoStyle var1);

    public abstract void setNeedsRedraw();

    public abstract void setNeedsRedrawDelegate(NativeNeedsRedrawDelegate var1);

    public abstract void setNotificationPresenter(NativeNotificationPresenter var1);

    public abstract void setPointOfInterest(PointWithUnit var1);

    public abstract void setPreviewOrientation(int var1);

    public abstract void setScanAreaMargins(MarginsWithUnit var1);

    public abstract void setZoomGesture(NativeZoomGesture var1);
}

