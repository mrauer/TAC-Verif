/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.common;

import com.scandit.datacapture.core.internal.sdk.common.NativeContextStatus;
import kotlin.jvm.internal.Intrinsics;

public final class ContextStatus {
    public final String a;
    public final int b;

    public ContextStatus(NativeContextStatus nativeContextStatus) {
        Intrinsics.checkNotNullParameter((Object)nativeContextStatus, (String)"status");
        String string = nativeContextStatus.getMessage();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"status.message");
        this.a = string;
        this.b = nativeContextStatus.getCode();
    }
}

