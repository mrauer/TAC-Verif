/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.ui.NativeTapToFocus$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.scandit.datacapture.core.common.geometry.PointWithUnit;
import com.scandit.datacapture.core.internal.module.ui.NativeFocusGesture;
import com.scandit.datacapture.core.internal.module.ui.NativeFocusGestureListener;
import com.scandit.datacapture.core.internal.module.ui.NativeTapToFocus;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeTapToFocus {
    public NativeTapToFocus() {
    }

    public static NativeTapToFocus create() {
        return CppProxy.create();
    }

    public abstract void addListener(NativeFocusGestureListener var1);

    public abstract NativeFocusGesture asFocusGesture();

    public abstract String toJson();

    public abstract void triggerFocus(PointWithUnit var1);
}

