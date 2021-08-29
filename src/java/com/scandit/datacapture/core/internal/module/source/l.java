/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.source;

import com.scandit.datacapture.core.internal.module.source.NativeEdgeEnhancement;
import com.scandit.datacapture.core.internal.module.source.NativeMacroAfMode;
import com.scandit.datacapture.core.internal.module.source.NativeNoiseReduction;
import com.scandit.datacapture.core.source.FrameSourceState;
import com.scandit.datacapture.core.source.TorchState;

public final class l {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public static final /* synthetic */ int[] c;
    public static final /* synthetic */ int[] d;
    public static final /* synthetic */ int[] e;

    public static /* synthetic */ {
        TorchState.values();
        int[] arrn = new int[3];
        a = arrn;
        arrn[TorchState.OFF.ordinal()] = 1;
        arrn[TorchState.ON.ordinal()] = 2;
        FrameSourceState.values();
        int[] arrn2 = new int[9];
        b = arrn2;
        arrn2[FrameSourceState.ON.ordinal()] = 1;
        arrn2[FrameSourceState.STANDBY.ordinal()] = 2;
        NativeEdgeEnhancement.values();
        int[] arrn3 = new int[3];
        c = arrn3;
        arrn3[NativeEdgeEnhancement.OFF.ordinal()] = 1;
        arrn3[NativeEdgeEnhancement.FAST.ordinal()] = 2;
        arrn3[NativeEdgeEnhancement.HIGH_QUALITY.ordinal()] = 3;
        NativeNoiseReduction.values();
        int[] arrn4 = new int[3];
        d = arrn4;
        arrn4[NativeNoiseReduction.OFF.ordinal()] = 1;
        arrn4[NativeNoiseReduction.FAST.ordinal()] = 2;
        arrn4[NativeNoiseReduction.HIGH_QUALITY.ordinal()] = 3;
        NativeMacroAfMode.values();
        int[] arrn5 = new int[3];
        e = arrn5;
        arrn5[NativeMacroAfMode.MACRO.ordinal()] = 1;
        arrn5[NativeMacroAfMode.MANUAL_THEN_CONTINUOUS.ordinal()] = 2;
    }
}

