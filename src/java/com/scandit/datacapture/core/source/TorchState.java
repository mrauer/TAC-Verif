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
public final class TorchState
extends Enum<TorchState> {
    public static final /* enum */ TorchState AUTO;
    public static final /* enum */ TorchState OFF;
    public static final /* enum */ TorchState ON;
    private static final /* synthetic */ TorchState[] a;

    public static {
        TorchState torchState;
        TorchState torchState2;
        TorchState torchState3;
        ON = torchState2 = new TorchState();
        OFF = torchState3 = new TorchState();
        AUTO = torchState = new TorchState();
        a = new TorchState[]{torchState2, torchState3, torchState};
    }

    public static TorchState valueOf(String string) {
        return (TorchState)Enum.valueOf(TorchState.class, (String)string);
    }

    public static TorchState[] values() {
        return (TorchState[])a.clone();
    }
}

