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

public final class aa
extends d {
    public static final aa a;
    public static final String b;
    public static final e c;

    public static {
        aa aa2;
        a = aa2 = new aa();
        b = "gt-s536.*";
        c = e.a(((d)aa2).b, false, false, false, 0.0f, false, false, false, 121);
    }

    @Override
    public final String a() {
        return b;
    }

    @Override
    public final void a(Camera.Parameters parameters, float f2, float f3) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        this.b(parameters, Math.max((float)aa.c.d, (float)f3));
        d.a(parameters, f2);
    }

    @Override
    public final e b() {
        return c;
    }
}

