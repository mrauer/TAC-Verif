/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.opengl.EGL14
 *  android.opengl.EGLContext
 *  android.opengl.EGLDisplay
 *  android.opengl.EGLSurface
 *  android.opengl.GLES20
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.Objects
 *  java.util.concurrent.atomic.AtomicBoolean
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.d;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import com.scandit.datacapture.core.common.geometry.Size2;
import com.scandit.datacapture.core.internal.module.b.a.a.b;
import com.scandit.datacapture.core.internal.sdk.ui.NeedsRedrawListener;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class c
extends HandlerThread
implements Choreographer.FrameCallback,
NeedsRedrawListener {
    public static final /* synthetic */ int $r8$clinit;
    public Size2 a = new Size2(0.0f, 0.0f);
    public int b;
    public SurfaceTexture c;
    public SurfaceTexture d;
    public EGLSurface e;
    public int f;
    public final Handler g;
    public Function1<? super b, Unit> h;
    public b.a i;
    public final AtomicBoolean j = new AtomicBoolean(false);
    public Choreographer k;
    public boolean l;
    public boolean m;
    public long n = -1L;
    public boolean o = true;

    public c() {
        super("com.scandit.gl-render-thread");
        this.start();
        this.g = new Handler(this){
            public final WeakReference<c> a;
            {
                Intrinsics.checkNotNullParameter((Object)c2, (String)"parent");
                super(c2.getLooper());
                this.a = new WeakReference((Object)c2);
            }

            public final void handleMessage(Message message) {
                SurfaceTexture surfaceTexture;
                Intrinsics.checkNotNullParameter((Object)message, (String)"msg");
                c c2 = (c)this.a.get();
                if (c2 == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue((Object)c2, (String)"this.parent.get() ?: return");
                int n2 = message.what;
                if (n2 != 1) {
                    if (n2 != 2) {
                        return;
                    }
                    SurfaceTexture surfaceTexture2 = c2.c;
                    if (surfaceTexture2 != null) {
                        surfaceTexture2.release();
                    }
                    c2.c = null;
                    b.a a2 = c2.i;
                    if (a2 != null) {
                        EGL14.eglDestroySurface((EGLDisplay)a2.a, (EGLSurface)a2.d);
                        EGL14.eglDestroyContext((EGLDisplay)a2.a, (EGLContext)a2.b);
                    }
                    c2.i = null;
                    return;
                }
                Object object = message.obj;
                Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type com.scandit.datacapture.core.internal.module.gl.GlRenderThread.SurfaceTextureData");
                c c3 = object;
                c2.a = new Size2(c3.b, c3.c);
                c2.b = c3.d;
                b.a a3 = c2.i;
                if (a3 != null) {
                    a3.c();
                }
                if ((surfaceTexture = c2.c) != null) {
                    c3.a.invoke((Object)surfaceTexture);
                }
            }
        };
    }

    public final void a(SurfaceTexture surfaceTexture) {
        EGLSurface eGLSurface;
        if (true ^ Intrinsics.areEqual((Object)this.d, (Object)surfaceTexture)) {
            return;
        }
        b.a a2 = this.i;
        if (a2 != null && (eGLSurface = this.e) != null) {
            EGL14.eglDestroySurface((EGLDisplay)a2.a, (EGLSurface)eGLSurface);
            b.a.w("destroySurface");
        }
        this.e = null;
        this.d = null;
        this.j.set(false);
        this.h = null;
    }

    public final void doFrame(long l2) {
        SurfaceTexture surfaceTexture;
        Function1<? super b, Unit> function1;
        if (this.l) {
            this.m = false;
            if (l2 <= this.n) {
                return;
            }
            this.n = l2;
        } else {
            Choreographer choreographer = this.k;
            if (choreographer != null) {
                choreographer.postFrameCallback((Choreographer.FrameCallback)this);
            }
        }
        if (!this.j.get()) {
            return;
        }
        EGLSurface eGLSurface = this.e;
        if (eGLSurface == null) {
            return;
        }
        b.a a2 = this.i;
        if (a2 == null) {
            return;
        }
        Intrinsics.checkNotNullParameter((Object)eGLSurface, (String)"readAndWriteSurface");
        EGL14.eglMakeCurrent((EGLDisplay)a2.a, (EGLSurface)eGLSurface, (EGLSurface)eGLSurface, (EGLContext)a2.b);
        int n2 = EGL14.eglGetError();
        boolean bl = false;
        if (n2 == 12288) {
            bl = true;
        }
        if (!bl) {
            return;
        }
        SurfaceTexture surfaceTexture2 = this.c;
        if (surfaceTexture2 != null) {
            surfaceTexture2.updateTexImage();
        }
        if (this.o && (function1 = this.h) != null && (surfaceTexture = this.c) != null) {
            function1.invoke(new Object(surfaceTexture, this.f, this.a, this.b){
                public final SurfaceTexture a;
                public final int b;
                public final Size2 c;
                public final int d;
                public final boolean e;
                {
                    Intrinsics.checkNotNullParameter((Object)surfaceTexture, (String)"surfaceTexture");
                    Intrinsics.checkNotNullParameter((Object)size2, (String)"frameSize");
                    this.a = surfaceTexture;
                    this.b = n2;
                    this.c = size2;
                    this.d = n3;
                    this.e = true;
                }

                public final boolean equals(Object object) {
                    block2 : {
                        block3 : {
                            if (this == object) break block2;
                            if (!(object instanceof b)) break block3;
                            b b2 = object;
                            if (Intrinsics.areEqual((Object)this.a, (Object)b2.a) && this.b == b2.b && Intrinsics.areEqual((Object)this.c, (Object)b2.c) && this.d == b2.d && this.e == b2.e) break block2;
                        }
                        return false;
                    }
                    return true;
                }

                public final int hashCode() {
                    SurfaceTexture surfaceTexture = this.a;
                    int n2 = surfaceTexture != null ? surfaceTexture.hashCode() : 0;
                    int n3 = 31 * (n2 * 31 + this.b);
                    Size2 size2 = this.c;
                    int n4 = 0;
                    if (size2 != null) {
                        n4 = size2.hashCode();
                    }
                    int n5 = 31 * (31 * (n3 + n4) + this.d);
                    int n6 = this.e ? 1 : 0;
                    if (n6 != 0) {
                        n6 = 1;
                    }
                    return n5 + n6;
                }

                public final String toString() {
                    StringBuilder stringBuilder = new StringBuilder("RenderData(surfaceTexture=");
                    stringBuilder.append((Object)this.a);
                    stringBuilder.append(", targetTexture=");
                    stringBuilder.append(this.b);
                    stringBuilder.append(", frameSize=");
                    stringBuilder.append((Object)this.c);
                    stringBuilder.append(", sensorToNativeRotation=");
                    stringBuilder.append(this.d);
                    stringBuilder.append(", hasValidPreviewFrame=");
                    stringBuilder.append(this.e);
                    stringBuilder.append(")");
                    return stringBuilder.toString();
                }
            });
        }
        if (!this.j.get()) {
            return;
        }
        Intrinsics.checkNotNullParameter((Object)eGLSurface, (String)"surface");
        EGL14.eglSwapBuffers((EGLDisplay)a2.a, (EGLSurface)eGLSurface);
    }

    public final void onLooperPrepared() {
        b.a a2;
        this.i = a2 = new b.a();
        if (a2 != null) {
            a2.c();
        }
        int[] arrn = new int[1];
        GLES20.glGenTextures((int)1, (int[])arrn, (int)0);
        int n2 = arrn[0];
        GLES20.glBindTexture((int)36197, (int)n2);
        GLES20.glTexParameteri((int)36197, (int)10241, (int)9729);
        GLES20.glTexParameteri((int)36197, (int)10240, (int)9729);
        GLES20.glTexParameteri((int)36197, (int)10242, (int)33071);
        GLES20.glTexParameteri((int)36197, (int)10243, (int)33071);
        this.f = n2;
        this.c = new SurfaceTexture(this.f);
        this.k = Choreographer.getInstance();
    }

    @Override
    public final void setNeedsRedrawInMillis(int n2) {
        if (n2 == 0 && !this.m) {
            this.m = true;
            Choreographer choreographer = this.k;
            if (choreographer != null) {
                choreographer.postFrameCallback((Choreographer.FrameCallback)this);
            }
            return;
        }
        Choreographer choreographer = this.k;
        if (choreographer != null) {
            choreographer.postFrameCallbackDelayed((Choreographer.FrameCallback)this, (long)n2);
        }
    }

}

