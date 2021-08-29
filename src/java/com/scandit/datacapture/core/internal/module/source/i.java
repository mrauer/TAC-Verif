/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.params.ColorSpaceTransform
 *  android.hardware.camera2.params.RggbChannelVector
 *  com.scandit.datacapture.core.internal.module.source.k
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.source;

import android.annotation.TargetApi;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.ColorSpaceTransform;
import android.hardware.camera2.params.RggbChannelVector;
import com.scandit.datacapture.core.internal.module.e.a;
import com.scandit.datacapture.core.internal.module.source.k;
import kotlin.jvm.internal.Intrinsics;

@TargetApi(value=21)
public final class i {
    public static final ColorSpaceTransform d = new ColorSpaceTransform(new int[]{1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1});
    public RggbChannelVector a;
    public boolean b;
    public final k c;

    public i(k k2) {
        Intrinsics.checkNotNullParameter((Object)k2, (String)"delegate");
        this.c = k2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(CaptureRequest.Builder builder, int n2) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"requestBuilder");
        try {
            builder.set(CaptureRequest.CONTROL_AWB_MODE, (Object)n2);
            if (n2 == 1) {
                this.b = false;
            }
            if (!this.c.c()) {
                StringBuilder stringBuilder = new StringBuilder("Setting AWB Mode to ");
                stringBuilder.append(n2);
                stringBuilder.append(" failed");
                a.a(stringBuilder.toString());
            }
            return;
        }
        catch (Exception exception) {
            a.a("Exception caught in listener method. Rethrowing...", exception);
            throw exception;
        }
    }
}

