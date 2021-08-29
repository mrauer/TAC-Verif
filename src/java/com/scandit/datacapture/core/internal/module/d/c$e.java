/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  com.scandit.datacapture.core.internal.module.d.c
 *  java.lang.Object
 *  java.lang.Runnable
 *  kotlin.jvm.functions.Function0
 */
package com.scandit.datacapture.core.internal.module.d;

import android.graphics.SurfaceTexture;
import com.scandit.datacapture.core.internal.module.b.a.a.b;
import com.scandit.datacapture.core.internal.module.d.c;
import kotlin.jvm.functions.Function0;

public final class c$e
implements Runnable {
    public /* synthetic */ c a;
    public /* synthetic */ SurfaceTexture b;
    public /* synthetic */ Function0 c;

    public c$e(c c2, SurfaceTexture surfaceTexture, Function0 function0) {
        this.a = c2;
        this.b = surfaceTexture;
        this.c = function0;
    }

    public final void run() {
        this.a.a(this.b);
        b.a a2 = this.a.i;
        if (a2 != null) {
            a2.c();
        }
        this.c.invoke();
    }
}

