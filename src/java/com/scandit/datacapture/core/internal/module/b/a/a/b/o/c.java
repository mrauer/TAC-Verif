/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$Parameters
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.b.a.a.b.o;

import android.hardware.Camera;
import com.scandit.datacapture.core.internal.module.b.a.a.d;
import com.scandit.datacapture.core.internal.module.b.a.a.e;
import kotlin.jvm.internal.Intrinsics;

public final class c
extends d {
    public static final c a;
    public static final String b;
    public static final e c;

    public static {
        c c2;
        a = c2 = new c();
        b = "sm-t365.*";
        c = e.a(((d)c2).b, false, true, true, 0.0f, true, false, false, 96);
    }

    @Override
    public final String a() {
        return b;
    }

    @Override
    public final void a(Camera.Parameters parameters, float f2, float f3) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        parameters.set("slow_ae", "on");
        parameters.set("sw-vdis", "off");
        parameters.set("sharpness", "0");
        parameters.set("video_recording_gamma", "on");
        parameters.set("denoise", "denoise-off");
        parameters.set("zsl", "off");
        this.b(parameters, Math.max((float)c.c.d, (float)f3));
        d.a(parameters, f2, false);
    }

    @Override
    public final e b() {
        return c;
    }
}

