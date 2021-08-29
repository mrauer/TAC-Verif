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
import com.scandit.datacapture.core.internal.module.b.a.a.a.a;
import com.scandit.datacapture.core.internal.module.b.a.a.d;
import com.scandit.datacapture.core.internal.module.b.a.a.e;
import kotlin.jvm.internal.Intrinsics;

public final class p
extends a {
    public static final p a;
    public static final String b;
    public static final e c;

    public static {
        p p2;
        a = p2 = new p();
        b = "(sm-g900|gt-i9600|sm-g870|sm-g800).*";
        c = e.a(((d)p2).b, false, true, false, 0.0f, true, false, false, 105);
    }

    @Override
    public final String a() {
        return b;
    }

    @Override
    public final void a(Camera.Parameters parameters, float f2, float f3) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        super.a(parameters, f2, f3);
        parameters.set("slow_ae", "off");
        parameters.set("sw-vdis", "off");
        parameters.set("dynamic-range-control", "on");
        parameters.set("phase-af", "on");
        this.b(parameters, Math.max((float)p.c.d, (float)f3));
        d.a(parameters, f2, true);
    }

    @Override
    public final e b() {
        return c;
    }
}

