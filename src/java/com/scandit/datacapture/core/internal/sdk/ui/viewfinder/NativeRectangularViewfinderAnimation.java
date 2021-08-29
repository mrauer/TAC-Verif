/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeRectangularViewfinderAnimation$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.sdk.ui.viewfinder;

import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeRectangularViewfinderAnimation;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeRectangularViewfinderAnimation {
    public NativeRectangularViewfinderAnimation() {
    }

    public static NativeRectangularViewfinderAnimation create(boolean bl) {
        return CppProxy.create((boolean)bl);
    }

    public abstract boolean isLooping();

    public abstract String toJson();
}

