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
import com.scandit.datacapture.core.internal.module.b.a.a.e;
import kotlin.jvm.internal.Intrinsics;

public final class a
extends d {
    public static final a a;
    public static final String b;
    public static final e c;

    public static {
        a a2;
        a = a2 = new a();
        b = "carbon mobile 5";
        c = e.a(((d)a2).b, false, true, false, -1.0f, false, false, false, 113);
    }

    @Override
    public final String a() {
        return b;
    }

    @Override
    public final void a(Camera.Parameters parameters, float f2, float f3) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        parameters.set("sharpness", 0);
        parameters.set("mce", "disable");
        parameters.set("contrast", 0);
        this.b(parameters, Math.max((float)a.c.d, (float)f3));
        d.a(parameters, f2, false);
    }

    @Override
    public final e b() {
        return c;
    }
}

