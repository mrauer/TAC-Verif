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
import kotlin.jvm.internal.Intrinsics;

public final class m
extends d {
    public static final m a;
    public static final String c;
    public static final e d;

    public static {
        m m2;
        a = m2 = new m();
        c = "i9000.*";
        d = e.a(m2.b, false, true, true, -1.0f, true, false, false, 96);
    }

    @Override
    public final String a() {
        return c;
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
}

