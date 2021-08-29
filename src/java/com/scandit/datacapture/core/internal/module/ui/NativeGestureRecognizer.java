/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.EnumSet
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.scandit.datacapture.core.internal.module.ui.NativeGestureListener;
import com.scandit.datacapture.core.internal.module.ui.NativeGestureType;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.EnumSet;

@DjinniGenerated
public abstract class NativeGestureRecognizer {
    public abstract void setGestureListener(NativeGestureListener var1, EnumSet<NativeGestureType> var2);
}

