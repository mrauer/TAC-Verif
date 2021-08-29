/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  com.scandit.datacapture.core.internal.module.source.k
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.source;

import android.annotation.TargetApi;
import com.scandit.datacapture.core.internal.module.source.NativeTonemapCurve;
import com.scandit.datacapture.core.internal.module.source.k;
import kotlin.jvm.internal.Intrinsics;

@TargetApi(value=21)
public final class r {
    public static final float[] c = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] d = new float[]{0.0f, 0.0f, 0.0667f, 0.292f, 0.1333f, 0.4002f, 0.2f, 0.4812f, 0.2667f, 0.5484f, 0.3333f, 0.6069f, 0.4f, 0.6594f, 0.4667f, 0.7072f, 0.5333f, 0.7515f, 0.6f, 0.7928f, 0.6667f, 0.8317f, 0.7333f, 0.8685f, 0.8f, 0.9035f, 0.8667f, 0.937f, 0.9333f, 0.9691f, 1.0f, 1.0f};
    public static final float[] e = new float[]{0.0f, 0.0f, 0.0667f, 0.292f, 0.1333f, 0.4002f, 0.2f, 0.4812f, 0.2667f, 0.5484f, 0.3333f, 0.6069f, 0.4f, 0.6594f, 0.4667f, 0.7072f, 0.5333f, 0.7515f, 0.6f, 0.7928f, 0.6667f, 0.8317f, 0.7333f, 0.8685f, 0.8f, 0.9035f, 0.8667f, 0.937f, 0.9333f, 0.9691f, 1.0f, 1.0f};
    public NativeTonemapCurve a;
    public final k b;

    public r(k k2) {
        Intrinsics.checkNotNullParameter((Object)k2, (String)"delegate");
        this.b = k2;
        this.a = NativeTonemapCurve.NONE;
    }
}

