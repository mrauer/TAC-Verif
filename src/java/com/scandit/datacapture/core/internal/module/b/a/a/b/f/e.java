/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$Parameters
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.b.a.a.b.f;

import android.hardware.Camera;
import com.scandit.datacapture.core.internal.module.b.a.a.d;
import java.util.Iterator;
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
        b = "nexus 5|nexus 6p";
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
        for (int[] arrn : parameters.getSupportedPreviewFpsRange()) {
            if (arrn[0] != 7000 || arrn[1] != 30000) continue;
            parameters.setPreviewFpsRange(7000, 30000);
            return;
        }
        int[] arrn = null;
        Iterator iterator = parameters.getSupportedPreviewFpsRange().iterator();
        int n2 = 30000;
        while (iterator.hasNext()) {
            int[] arrn2 = (int[])iterator.next();
            if (arrn2[0] >= n2 || arrn2[1] != 30000) continue;
            n2 = arrn2[0];
            arrn = arrn2;
        }
        if (arrn != null) {
            parameters.setPreviewFpsRange((int)arrn[0], (int)arrn[1]);
            return;
        }
        d.a(parameters, f2, false);
    }

    @Override
    public final com.scandit.datacapture.core.internal.module.b.a.a.e b() {
        return c;
    }
}

