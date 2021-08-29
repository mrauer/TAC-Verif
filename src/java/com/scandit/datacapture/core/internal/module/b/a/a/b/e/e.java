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
package com.scandit.datacapture.core.internal.module.b.a.a.b.e;

import android.hardware.Camera;
import com.scandit.datacapture.core.internal.module.b.a.a.d;
import kotlin.jvm.internal.Intrinsics;

public final class e
extends d {
    public static final e a;
    public static final String b;
    public static final com.scandit.datacapture.core.internal.module.b.a.a.e c;

    public static {
        e e2;
        a = e2 = new e();
        b = "m100";
        c = com.scandit.datacapture.core.internal.module.b.a.a.e.a(((d)e2).b, false, true, true, 0.0f, false, false, false, 112);
    }

    @Override
    public final String a() {
        return b;
    }

    @Override
    public final void a(Camera.Parameters parameters, float f2, float f3) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        this.b(parameters, Math.max((float)e.c.d, (float)f3));
        d.a(parameters, f2, false);
    }

    @Override
    public final com.scandit.datacapture.core.internal.module.b.a.a.e b() {
        return c;
    }
}

