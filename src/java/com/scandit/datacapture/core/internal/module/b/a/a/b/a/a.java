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
package com.scandit.datacapture.core.internal.module.b.a.a.b.a;

import android.hardware.Camera;
import com.scandit.datacapture.core.internal.module.b.a.a.d;
import kotlin.jvm.internal.Intrinsics;

public final class a
extends com.scandit.datacapture.core.internal.module.b.a.a.a.a {
    public static final a a = new a();
    public static final String b = "5033[a-z](_eea)?";

    @Override
    public final String a() {
        return b;
    }

    @Override
    public final void a(Camera.Parameters parameters, float f2, float f3) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        super.a(parameters, f2, f3);
        d.a(parameters, f2);
    }
}

