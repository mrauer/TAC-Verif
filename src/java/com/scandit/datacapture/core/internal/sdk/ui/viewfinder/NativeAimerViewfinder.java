/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeAimerViewfinder$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.ui.viewfinder;

import com.scandit.datacapture.core.internal.sdk.common.graphics.NativeColor;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeAimerViewfinder;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeViewfinder;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeAimerViewfinder {
    public NativeAimerViewfinder() {
    }

    public static NativeAimerViewfinder create() {
        return CppProxy.create();
    }

    public abstract NativeViewfinder asViewfinder();

    public abstract NativeColor getDotColor();

    public abstract NativeColor getFrameColor();

    public abstract void setDotColor(NativeColor var1);

    public abstract void setFrameColor(NativeColor var1);
}

