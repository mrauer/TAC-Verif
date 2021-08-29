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
package com.scandit.datacapture.core.internal.module.b.a.a.a;

import android.hardware.Camera;
import com.scandit.datacapture.core.internal.module.b.a.a.d;
import com.scandit.datacapture.core.internal.module.b.a.a.e;
import kotlin.jvm.internal.Intrinsics;

public class b
extends d {
    public final String a = "scandit-phase_af|scandit-phase_af-initial_trigger";
    public final e b;

    public b() {
        this.b = e.a(((d)this).b, false, false, true, 0.0f, false, false, false, 112);
    }

    @Override
    public String a() {
        return this.a;
    }

    @Override
    public final void a(Camera.Parameters parameters, float f2, float f3) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        parameters.set("phase-af", "on");
        parameters.set("dynamic-range-control", "on");
        this.b(parameters, Math.max((float)this.b().d, (float)f3));
        d.a(parameters, f2, false);
    }

    @Override
    public e b() {
        return this.b;
    }
}

