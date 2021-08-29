/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package com.scandit.datacapture.core.internal.module.source;

import com.scandit.datacapture.core.internal.module.source.NativeCameraDelegate;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameData;
import com.scandit.datacapture.core.source.CameraPosition;
import com.scandit.datacapture.core.source.CameraSettings;
import com.scandit.datacapture.core.source.FrameSourceState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public interface w {
    public NativeCameraDelegate a(CameraPosition var1, CameraSettings var2, Function1<? super NativeCameraFrameData, Unit> var3, Function1<? super FrameSourceState, Unit> var4);
}

