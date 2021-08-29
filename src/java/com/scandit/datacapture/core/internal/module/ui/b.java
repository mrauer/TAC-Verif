/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.view.GestureDetector
 *  android.view.MotionEvent
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.core.internal.module.d.c
 *  com.scandit.datacapture.core.internal.module.ui.b$b
 *  com.scandit.datacapture.core.internal.module.ui.b$c
 *  com.scandit.datacapture.core.internal.module.ui.b$e
 *  com.scandit.datacapture.core.internal.module.ui.d
 *  com.scandit.datacapture.core.internal.module.ui.e
 *  com.scandit.datacapture.core.internal.sdk.data.DisposableResource$a
 *  com.scandit.datacapture.core.ui.DataCaptureView$dataCaptureContextListener
 *  com.scandit.datacapture.core.ui.DataCaptureView$dataCaptureContextListener$1
 *  com.scandit.datacapture.core.ui.DataCaptureViewProxyAdapter$a
 *  java.lang.Float
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Objects
 *  java.util.concurrent.atomic.AtomicBoolean
 *  kotlin.Lazy
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 */
package com.scandit.datacapture.core.internal.module.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TextureView;
import com.google.android.material.R;
import com.scandit.datacapture.core.capture.DataCaptureContext;
import com.scandit.datacapture.core.capture.DataCaptureContextListener;
import com.scandit.datacapture.core.common.geometry.Size2;
import com.scandit.datacapture.core.internal.module.ui.GestureRecognizer;
import com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView;
import com.scandit.datacapture.core.internal.module.ui.NativeGestureRecognizer;
import com.scandit.datacapture.core.internal.module.ui.b;
import com.scandit.datacapture.core.internal.module.ui.video.NativeVideoPreview;
import com.scandit.datacapture.core.internal.sdk.data.DisposableResource;
import com.scandit.datacapture.core.internal.sdk.data.Subscription;
import com.scandit.datacapture.core.ui.DataCaptureView;
import com.scandit.datacapture.core.ui.DataCaptureViewProxyAdapter;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@SuppressLint(value={"ViewConstructor"})
public final class b
extends TextureView {
    public final Lazy a;
    public final AtomicBoolean b;
    public DisposableResource<com.scandit.datacapture.core.internal.module.d.c> c;
    public Subscription<com.scandit.datacapture.core.internal.module.d.c> d;
    public final float[] e;
    public final ArrayList<Float> f;
    public AtomicBoolean g;
    public final com.scandit.datacapture.core.internal.module.ui.d h;
    public final DataCaptureView i;

    public b(Context context, DataCaptureView dataCaptureView) {
        com.scandit.datacapture.core.internal.module.ui.d d2;
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)((Object)dataCaptureView), (String)"parentView");
        super(context);
        this.i = dataCaptureView;
        this.a = R.style.lazy((Function0)new b(this));
        this.b = new AtomicBoolean(false);
        this.c = com.scandit.datacapture.core.internal.module.d.b.b;
        this.e = new float[16];
        this.f = new ArrayList(16);
        this.g = new AtomicBoolean(false);
        this.h = d2 = new com.scandit.datacapture.core.internal.module.ui.d(context, this.a());
        this.setSurfaceTextureListener(new TextureView.SurfaceTextureListener(this){
            public /* synthetic */ b a;
            {
                this.a = b2;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n2, int n3) {
                Intrinsics.checkNotNullParameter((Object)surfaceTexture, (String)"surface");
                b b2 = this.a;
                Subscription<com.scandit.datacapture.core.internal.module.d.c> subscription = b2.c.start();
                c c2 = new c(b2);
                (subscription).use((Function1)c2);
                b2.d = subscription;
                this.a.i.onSurfaceTextureAvailable$scandit_capture_core();
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                DataCaptureView dataCaptureView;
                Intrinsics.checkNotNullParameter((Object)surfaceTexture, (String)"surface");
                b b2 = this.a;
                Subscription<com.scandit.datacapture.core.internal.module.d.c> subscription = b2.d;
                b2.d = null;
                if (subscription != null) {
                    subscription.use((Function1<com.scandit.datacapture.core.internal.module.d.c, Unit>)new e(b2, surfaceTexture, subscription));
                }
                DataCaptureView dataCaptureView2 = dataCaptureView = this.a.i;
                synchronized (dataCaptureView2) {
                    block5 : {
                        dataCaptureView.f = false;
                        DataCaptureContext dataCaptureContext = dataCaptureView.p;
                        if (dataCaptureContext == null) break block5;
                        dataCaptureContext.removeListener((DataCaptureContextListener)dataCaptureView.o);
                        return false;
                    }
                    return false;
                }
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int n2, int n3) {
                Intrinsics.checkNotNullParameter((Object)surfaceTexture, (String)"surface");
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                Intrinsics.checkNotNullParameter((Object)surfaceTexture, (String)"surface");
            }
        });
        Intrinsics.checkNotNullParameter((Object)d2, (String)"recognizer");
        DataCaptureViewProxyAdapter dataCaptureViewProxyAdapter = dataCaptureView.v;
        Objects.requireNonNull((Object)dataCaptureViewProxyAdapter);
        Intrinsics.checkNotNullParameter((Object)d2, (String)"recognizer");
        com.scandit.datacapture.core.internal.module.ui.e e2 = (com.scandit.datacapture.core.internal.module.ui.e)dataCaptureViewProxyAdapter.b.getOrPut(Reflection.getOrCreateKotlinClass(GestureRecognizer.class), (Object)null, d2, new DataCaptureViewProxyAdapter.a((GestureRecognizer)d2));
        dataCaptureViewProxyAdapter.a.setGestureRecognizer((NativeGestureRecognizer)e2);
    }

    public final float a() {
        return ((Number)this.a.getValue()).floatValue();
    }

    public final Size2 b() {
        return new Size2((float)this.getWidth() / this.a(), (float)this.getHeight() / this.a());
    }

    public final void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        NativeVideoPreview nativeVideoPreview = this.i.v.a.getVideoPreview();
        Intrinsics.checkNotNullExpressionValue((Object)nativeVideoPreview, (String)"parentView._impl().videoPreview");
        nativeVideoPreview.setViewSize(this.b());
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter((Object)motionEvent, (String)"event");
        com.scandit.datacapture.core.internal.module.ui.d d2 = this.h;
        Objects.requireNonNull((Object)d2);
        Intrinsics.checkNotNullParameter((Object)motionEvent, (String)"event");
        return d2.b.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
        {
        }
    }

    public final void onWindowVisibilityChanged(int n2) {
        if (n2 == 0 && this.isAvailable()) {
            Subscription<com.scandit.datacapture.core.internal.module.d.c> subscription = this.c.start();
            c c2 = new c(this);
            (subscription).use((Function1)c2);
            this.d = subscription;
            this.i.onSurfaceTextureAvailable$scandit_capture_core();
        }
    }

    public static final class a
    implements SurfaceTexture.OnFrameAvailableListener {
        public final WeakReference<b> a;

        public a(b b2) {
            Intrinsics.checkNotNullParameter((Object)((Object)b2), (String)"textureView");
            this.a = new WeakReference((Object)b2);
        }

        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            b b2 = (b)((Object)this.a.get());
            if (b2 != null) {
                b2.i.v.a.setNeedsRedraw();
                b2.g.set(true);
            }
        }
    }

}

