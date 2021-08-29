/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.source;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class FocusGestureStrategy
extends Enum<FocusGestureStrategy> {
    public static final /* enum */ FocusGestureStrategy AUTO_ON_LOCATION;
    public static final /* enum */ FocusGestureStrategy MANUAL;
    public static final /* enum */ FocusGestureStrategy MANUAL_UNTIL_CAPTURE;
    public static final /* enum */ FocusGestureStrategy NONE;
    private static final /* synthetic */ FocusGestureStrategy[] a;

    public static {
        FocusGestureStrategy focusGestureStrategy;
        FocusGestureStrategy focusGestureStrategy2;
        FocusGestureStrategy focusGestureStrategy3;
        FocusGestureStrategy focusGestureStrategy4;
        NONE = focusGestureStrategy = new FocusGestureStrategy();
        MANUAL = focusGestureStrategy4 = new FocusGestureStrategy();
        MANUAL_UNTIL_CAPTURE = focusGestureStrategy2 = new FocusGestureStrategy();
        AUTO_ON_LOCATION = focusGestureStrategy3 = new FocusGestureStrategy();
        a = new FocusGestureStrategy[]{focusGestureStrategy, focusGestureStrategy4, focusGestureStrategy2, focusGestureStrategy3};
    }

    public static FocusGestureStrategy valueOf(String string) {
        return (FocusGestureStrategy)Enum.valueOf(FocusGestureStrategy.class, (String)string);
    }

    public static FocusGestureStrategy[] values() {
        return (FocusGestureStrategy[])a.clone();
    }
}

