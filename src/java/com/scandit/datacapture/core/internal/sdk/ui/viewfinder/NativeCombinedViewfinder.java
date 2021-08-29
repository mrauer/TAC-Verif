/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeCombinedViewfinder$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.ui.viewfinder;

import com.scandit.datacapture.core.common.geometry.PointWithUnit;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeCombinedViewfinder;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeViewfinder;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeCombinedViewfinder {
    public NativeCombinedViewfinder() {
    }

    public static NativeCombinedViewfinder create() {
        return CppProxy.create();
    }

    public abstract void addViewfinder(NativeViewfinder var1, PointWithUnit var2);

    public abstract NativeViewfinder asViewfinder();

    public abstract void removeAll();

    public abstract void removeViewfinder(NativeViewfinder var1);
}

