/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.barcode.tracking.internal.module.data;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeObjectTrackerScenario
extends Enum<NativeObjectTrackerScenario> {
    public static final /* enum */ NativeObjectTrackerScenario A;
    public static final /* enum */ NativeObjectTrackerScenario B;
    private static final /* synthetic */ NativeObjectTrackerScenario[] a;

    public static {
        NativeObjectTrackerScenario nativeObjectTrackerScenario;
        NativeObjectTrackerScenario nativeObjectTrackerScenario2;
        A = nativeObjectTrackerScenario = new NativeObjectTrackerScenario();
        B = nativeObjectTrackerScenario2 = new NativeObjectTrackerScenario();
        a = new NativeObjectTrackerScenario[]{nativeObjectTrackerScenario, nativeObjectTrackerScenario2};
    }

    public static NativeObjectTrackerScenario valueOf(String string) {
        return (NativeObjectTrackerScenario)Enum.valueOf(NativeObjectTrackerScenario.class, (String)string);
    }

    public static NativeObjectTrackerScenario[] values() {
        return (NativeObjectTrackerScenario[])a.clone();
    }
}

