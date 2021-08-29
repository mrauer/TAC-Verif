/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.scandit.datacapture.core.common.geometry.Point;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeGestureListener {
    public abstract boolean onDoubleTap(Point var1);

    public abstract boolean onSwipeDown();

    public abstract boolean onSwipeUp();

    public abstract boolean onTap(Point var1);
}

