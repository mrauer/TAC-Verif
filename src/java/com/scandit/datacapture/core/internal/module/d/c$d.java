/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.opengl.EGL14
 *  android.opengl.EGLConfig
 *  android.opengl.EGLDisplay
 *  android.opengl.EGLSurface
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  com.scandit.datacapture.core.internal.module.d.c
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicBoolean
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.d;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Choreographer;
import com.scandit.datacapture.core.internal.module.b.a.a.b;
import com.scandit.datacapture.core.internal.module.d.c;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class c$d
implements Runnable {
    public /* synthetic */ c a;
    public /* synthetic */ SurfaceTexture b;
    public /* synthetic */ Function1 c;
    public /* synthetic */ SurfaceTexture.OnFrameAvailableListener d;
    public /* synthetic */ boolean e;
    public /* synthetic */ Function1 f;

    public c$d(c c2, SurfaceTexture surfaceTexture, Function1 function1, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, boolean bl, Function1 function12) {
        this.a = c2;
        this.b = surfaceTexture;
        this.c = function1;
        this.d = onFrameAvailableListener;
        this.e = bl;
        this.f = function12;
    }

    public final void run() {
        b.a a2;
        b.a a3;
        EGLSurface eGLSurface;
        c c2 = this.a;
        SurfaceTexture surfaceTexture = this.b;
        Function1 function1 = this.c;
        SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = this.d;
        boolean bl = this.e;
        Function1 function12 = this.f;
        SurfaceTexture surfaceTexture2 = c2.d;
        if (surfaceTexture2 != null) {
            c2.a(surfaceTexture2);
        }
        if ((a2 = c2.i) != null) {
            a2.c();
        }
        if ((a3 = c2.i) != null) {
            Intrinsics.checkNotNullParameter((Object)surfaceTexture, (String)"surface");
            int[] arrn = new int[]{12344};
            eGLSurface = EGL14.eglCreateWindowSurface((EGLDisplay)a3.a, (EGLConfig)a3.c, (Object)surfaceTexture, (int[])arrn, (int)0);
            b.a.w("createWindowSurface");
            if (eGLSurface == null) {
                throw new IllegalStateException("returned EGL surface is null".toString());
            }
        } else {
            eGLSurface = null;
        }
        c2.e = eGLSurface;
        c2.d = surfaceTexture;
        c2.j.set(true);
        Choreographer choreographer = c2.k;
        if (choreographer != null) {
            choreographer.postFrameCallback((Choreographer.FrameCallback)c2);
        }
        c2.h = function1;
        SurfaceTexture surfaceTexture3 = c2.c;
        if (surfaceTexture3 != null) {
            surfaceTexture3.setOnFrameAvailableListener(onFrameAvailableListener);
        }
        c2.l = bl;
        if (bl) {
            function12.invoke((Object)c2);
        }
    }
}

