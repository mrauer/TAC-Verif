/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.scandit.datacapture.core.common.geometry.PointWithUnit;
import com.scandit.datacapture.core.internal.module.ui.NativeFocusGestureListener;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeFocusGesture {
    public abstract void addListener(NativeFocusGestureListener var1);

    public abstract String toJson();

    public abstract void triggerFocus(PointWithUnit var1);
}

