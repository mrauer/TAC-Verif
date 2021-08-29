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

public final class x
extends d {
    public static final x a;
    public static final String b;
    public static final e c;

    public static {
        x x2;
        a = x2 = new x();
        b = "sm-t320.*";
        c = e.a(((d)x2).b, false, true, false, -1.0f, false, false, false, 112);
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
        this.b(parameters, Math.max((float)x.c.d, (float)f3));
        d.a(parameters, f2, false);
    }

    @Override
    public final e b() {
        return c;
    }
}

