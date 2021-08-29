/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.ui.NativeSwipeToZoom$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.scandit.datacapture.core.internal.module.ui.NativeSwipeToZoom;
import com.scandit.datacapture.core.internal.module.ui.NativeZoomGesture;
import com.scandit.datacapture.core.internal.module.ui.NativeZoomGestureListener;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeSwipeToZoom {
    public NativeSwipeToZoom() {
    }

    public static NativeSwipeToZoom create() {
        return CppProxy.create();
    }

    public abstract void addListener(NativeZoomGestureListener var1);

    public abstract NativeZoomGesture asZoomGesture();

    public abstract String toJson();

    public abstract void triggerZoomIn();

    public abstract void triggerZoomOut();
}

