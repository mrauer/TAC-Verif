/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.source;

import android.content.Context;
import com.scandit.datacapture.core.internal.sdk.AppAndroidEnvironment;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

public final class h {
    public static final /* synthetic */ int $r8$clinit;

    public static {
        Context context = AppAndroidEnvironment.applicationContext;
        if (context != null) {
            Objects.requireNonNull((Object)context.getSystemService("camera"), (String)"null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
        throw null;
    }
}

