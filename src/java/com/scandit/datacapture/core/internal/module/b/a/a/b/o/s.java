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
import com.scandit.datacapture.core.internal.module.b.a.a.a;
import com.scandit.datacapture.core.internal.module.b.a.a.d;
import com.scandit.datacapture.core.internal.module.b.a.a.e;
import kotlin.jvm.internal.Intrinsics;

public final class s
extends d {
    public static final s a;
    public static final String b;
    public static final e c;

    public static {
        s s2;
        a = s2 = new s();
        b = "sm-g891a";
        c = e.a(((d)s2).b, false, false, true, 0.0f, true, false, false, 96);
        a a2 = ((d)s2).c;
        String string = a2.b;
        String string2 = a2.c;
        Intrinsics.checkNotNullParameter((Object)"object-tracking-picture", (String)"focusModeContinuousPicture");
        Intrinsics.checkNotNullParameter((Object)string, (String)"focusModeContinuousVideo");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"focusModeAuto");
        Intrinsics.checkNotNullParameter((Object)"object-tracking-picture", (String)"focusModeContinuousPicture");
        Intrinsics.checkNotNullParameter((Object)string, (String)"focusModeContinuousVideo");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"focusModeAuto");
    }

    @Override
    public final String a() {
        return b;
    }

    @Override
    public final void a(Camera.Parameters parameters, float f2, float f3) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        parameters.set("phase-af", "on");
        parameters.set("dynamic-range-control", "on");
        parameters.set("slow_ae", "on");
        parameters.set("sw-vdis", "off");
        parameters.set("sharpness", "0");
        parameters.set("video_recording_gamma", "on");
        parameters.set("denoise", "denoise-off");
        parameters.set("zsl", "off");
        this.b(parameters, Math.max((float)s.c.d, (float)f3));
        d.a(parameters, f2, false);
    }

    @Override
    public final e b() {
        return c;
    }
}

