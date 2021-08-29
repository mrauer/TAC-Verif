/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$Parameters
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.b.a.a.b.o;

import android.hardware.Camera;
import com.scandit.datacapture.core.internal.module.b.a.a.d;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class e
extends d {
    public static final e a;
    public static final String b;
    public static final com.scandit.datacapture.core.internal.module.b.a.a.e c;

    public static {
        e e2;
        a = e2 = new e();
        b = "sm-g350.*";
        c = com.scandit.datacapture.core.internal.module.b.a.a.e.a(((d)e2).b, false, false, false, 0.0f, false, false, false, 123);
    }

    @Override
    public final String a() {
        return b;
    }

    @Override
    public final void a(Camera.Parameters parameters, float f2, float f3) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        this.b(parameters, Math.max((float)e.c.d, (float)f3));
        List list = parameters.getSupportedPreviewFpsRange();
        if (list.size() != 0) {
            int[] arrn = null;
            for (int[] arrn2 : list) {
                if (arrn2[1] > 30000 || arrn2[0] >= 16000 || arrn != null && arrn2[1] <= arrn[1] && (arrn2[1] != arrn[1] || arrn2[0] <= arrn[0])) continue;
                arrn = arrn2;
            }
            if (arrn != null) {
                parameters.setPreviewFpsRange((int)arrn[0], (int)arrn[1]);
            }
        }
    }

    @Override
    public final com.scandit.datacapture.core.internal.module.b.a.a.e b() {
        return c;
    }
}

