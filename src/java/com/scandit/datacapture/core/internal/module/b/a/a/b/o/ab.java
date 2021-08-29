/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$Parameters
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.b.a.a.b.o;

import android.hardware.Camera;
import com.scandit.datacapture.core.internal.module.b.a.a.d;
import com.scandit.datacapture.core.internal.module.b.a.a.e;
import com.scandit.datacapture.core.internal.module.source.NativeCameraApi;
import kotlin.jvm.internal.Intrinsics;

public final class ab
extends d {
    public static final ab a;
    public static final String b;
    public static final e d;

    public static {
        ab ab2;
        a = ab2 = new ab();
        b = "sm-g388.*";
        d = e.a(((d)ab2).b, false, true, true, -2.0f, true, false, false, 96);
    }

    @Override
    public final String a() {
        return b;
    }

    @Override
    public final void a(Camera.Parameters parameters, float f2, float f3) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        parameters.set("slow_ae", "off");
        parameters.set("sw-vdis", "off");
        parameters.set("dynamic-range-control", "on");
        parameters.set("phase-af", "on");
        this.b(parameters, f3);
        d.a(parameters, f2, true);
    }

    @Override
    public final e b() {
        return d;
    }

    @Override
    public final NativeCameraApi c() {
        return NativeCameraApi.CAMERA2;
    }
}

