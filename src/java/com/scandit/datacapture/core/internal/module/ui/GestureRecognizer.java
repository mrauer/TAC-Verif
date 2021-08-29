/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.EnumSet
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.scandit.datacapture.core.internal.module.ui.GestureListener;
import com.scandit.datacapture.core.internal.module.ui.NativeGestureType;
import java.util.EnumSet;

public interface GestureRecognizer {
    public void a(GestureListener var1, EnumSet<NativeGestureType> var2);
}

