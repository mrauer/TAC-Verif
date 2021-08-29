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
public final class FrameSourceState
extends Enum<FrameSourceState> {
    public static final /* enum */ FrameSourceState BOOTING_UP;
    public static final /* enum */ FrameSourceState GOING_TO_SLEEP;
    public static final /* enum */ FrameSourceState OFF;
    public static final /* enum */ FrameSourceState ON;
    public static final /* enum */ FrameSourceState SHUTTING_DOWN;
    public static final /* enum */ FrameSourceState STANDBY;
    public static final /* enum */ FrameSourceState STARTING;
    public static final /* enum */ FrameSourceState STOPPING;
    public static final /* enum */ FrameSourceState WAKING_UP;
    private static final /* synthetic */ FrameSourceState[] a;

    public static {
        FrameSourceState frameSourceState;
        FrameSourceState frameSourceState2;
        FrameSourceState frameSourceState3;
        FrameSourceState frameSourceState4;
        FrameSourceState frameSourceState5;
        FrameSourceState frameSourceState6;
        FrameSourceState frameSourceState7;
        FrameSourceState frameSourceState8;
        FrameSourceState frameSourceState9;
        OFF = frameSourceState7 = new FrameSourceState();
        ON = frameSourceState5 = new FrameSourceState();
        STARTING = frameSourceState6 = new FrameSourceState();
        STOPPING = frameSourceState = new FrameSourceState();
        STANDBY = frameSourceState8 = new FrameSourceState();
        BOOTING_UP = frameSourceState4 = new FrameSourceState();
        WAKING_UP = frameSourceState9 = new FrameSourceState();
        GOING_TO_SLEEP = frameSourceState2 = new FrameSourceState();
        SHUTTING_DOWN = frameSourceState3 = new FrameSourceState();
        a = new FrameSourceState[]{frameSourceState7, frameSourceState5, frameSourceState6, frameSourceState, frameSourceState8, frameSourceState4, frameSourceState9, frameSourceState2, frameSourceState3};
    }

    public static FrameSourceState valueOf(String string) {
        return (FrameSourceState)Enum.valueOf(FrameSourceState.class, (String)string);
    }

    public static FrameSourceState[] values() {
        return (FrameSourceState[])a.clone();
    }
}

