/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.https;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeHttpsTaskState
extends Enum<NativeHttpsTaskState> {
    public static final /* enum */ NativeHttpsTaskState ACTIVE;
    public static final /* enum */ NativeHttpsTaskState CANCELLED;
    public static final /* enum */ NativeHttpsTaskState COMPLETED;
    private static final /* synthetic */ NativeHttpsTaskState[] a;

    public static {
        NativeHttpsTaskState nativeHttpsTaskState;
        NativeHttpsTaskState nativeHttpsTaskState2;
        NativeHttpsTaskState nativeHttpsTaskState3;
        ACTIVE = nativeHttpsTaskState = new NativeHttpsTaskState();
        CANCELLED = nativeHttpsTaskState3 = new NativeHttpsTaskState();
        COMPLETED = nativeHttpsTaskState2 = new NativeHttpsTaskState();
        a = new NativeHttpsTaskState[]{nativeHttpsTaskState, nativeHttpsTaskState3, nativeHttpsTaskState2};
    }

    public static NativeHttpsTaskState valueOf(String string) {
        return (NativeHttpsTaskState)Enum.valueOf(NativeHttpsTaskState.class, (String)string);
    }

    public static NativeHttpsTaskState[] values() {
        return (NativeHttpsTaskState[])a.clone();
    }
}

