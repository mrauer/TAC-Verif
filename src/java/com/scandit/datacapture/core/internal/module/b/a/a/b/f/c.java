/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$Parameters
 *  android.hardware.Camera$Size
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.b.a.a.b.f;

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
        b = "glass 2";
        c = e.a(((d)c2).b, false, false, false, 0.0f, false, false, false, 121);
    }

    @Override
    public final String a() {
        return b;
    }

    @Override
    public final void a(Camera.Parameters parameters, float f2, float f3) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        d.a(parameters, f2, false);
        this.b(parameters, Math.max((float)c.c.d, (float)f3));
        parameters.setPreviewSize(Math.max((int)parameters.getPreviewSize().width, (int)parameters.getPreviewSize().height), Math.min((int)parameters.getPreviewSize().width, (int)parameters.getPreviewSize().height));
    }

    @Override
    public final e b() {
        return c;
    }
}

