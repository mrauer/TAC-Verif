/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.opengl.GLES10
 *  android.os.Handler
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Objects
 *  java.util.concurrent.atomic.AtomicBoolean
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.CallableReference
 *  kotlin.jvm.internal.FunctionReference
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KDeclarationContainer
 */
package com.scandit.datacapture.core.internal.module.ui;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES10;
import android.os.Handler;
import com.scandit.datacapture.core.common.geometry.Size2;
import com.scandit.datacapture.core.internal.module.d.c;
import com.scandit.datacapture.core.internal.module.d.c$d;
import com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView;
import com.scandit.datacapture.core.internal.module.ui.b;
import com.scandit.datacapture.core.internal.module.ui.video.NativePreviewShaderFormat;
import com.scandit.datacapture.core.internal.module.ui.video.NativeVideoPreview;
import com.scandit.datacapture.core.internal.sdk.common.graphics.NativeTextureBinding;
import com.scandit.datacapture.core.internal.sdk.ui.NativeNeedsRedrawDelegate;
import com.scandit.datacapture.core.internal.sdk.ui.NeedsRedrawListener;
import com.scandit.datacapture.core.internal.sdk.ui.NeedsRedrawListenerReversedAdapter;
import com.scandit.datacapture.core.ui.DataCaptureView;
import com.scandit.datacapture.core.ui.DataCaptureViewProxyAdapter;
import com.scandit.datacapture.core.ui.DataCaptureViewProxyAdapter$b;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public final class b$c
extends Lambda
implements Function1<c, Unit> {
    public final /* synthetic */ b a;

    public b$c(b b2) {
        this.a = b2;
        super(1);
    }

    public final Object invoke(Object object) {
        c c2 = (c)object;
        Intrinsics.checkNotNullParameter((Object)c2, (String)"$receiver");
        SurfaceTexture surfaceTexture = this.a.getSurfaceTexture();
        Intrinsics.checkNotNullExpressionValue((Object)surfaceTexture, (String)"surfaceTexture");
        Function1<c.b, Unit> function1 = new Function1<c.b, Unit>(this.a){

            public final String getName() {
                return "doRender";
            }

            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(b.class);
            }

            public final String getSignature() {
                return "doRender(Lcom/scandit/datacapture/core/internal/module/gl/GlRenderThread$RenderData;)V";
            }

            public final Object invoke(Object object) {
                c.b b2 = object;
                Intrinsics.checkNotNullParameter((Object)b2, (String)"p1");
                b b3 = (b)((Object)((CallableReference)this).receiver);
                AtomicBoolean atomicBoolean = b3.b;
                int n2 = 0;
                if (atomicBoolean.compareAndSet(false, true)) {
                    NativeVideoPreview nativeVideoPreview = b3.i.v.a.getVideoPreview();
                    nativeVideoPreview.setViewSize(b3.b());
                    nativeVideoPreview.setFrameSize(b2.c);
                    nativeVideoPreview.setInputFormat(NativePreviewShaderFormat.OES_EXTERNAL);
                    GLES10.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                }
                NativeVideoPreview nativeVideoPreview = b3.i.v.a.getVideoPreview();
                GLES10.glViewport((int)0, (int)0, (int)b3.getWidth(), (int)b3.getHeight());
                GLES10.glClear((int)17408);
                if (b3.g.get() && b2.e) {
                    Intrinsics.checkNotNullExpressionValue((Object)nativeVideoPreview, (String)"videoPreview");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add((Object)new NativeTextureBinding(36197, b2.b));
                    b2.a.getTransformMatrix(b3.e);
                    float[] arrf = new float[9];
                    float[] arrf2 = b3.e;
                    arrf[0] = arrf2[0];
                    arrf[1] = arrf2[4];
                    arrf[2] = arrf2[12];
                    arrf[3] = arrf2[1];
                    arrf[4] = arrf2[5];
                    arrf[5] = arrf2[13];
                    arrf[6] = arrf2[2];
                    arrf[7] = arrf2[6];
                    arrf[8] = arrf2[15];
                    float f2 = b2.d;
                    Matrix matrix = new Matrix();
                    matrix.setValues(arrf);
                    matrix.postTranslate(-0.5f, -0.5f);
                    matrix.postRotate(f2);
                    matrix.postTranslate(0.5f, 0.5f);
                    matrix.getValues(arrf);
                    float[] arrf3 = b3.e;
                    arrf3[0] = arrf[0];
                    arrf3[4] = arrf[1];
                    arrf3[12] = arrf[2];
                    arrf3[1] = arrf[3];
                    arrf3[5] = arrf[4];
                    arrf3[13] = arrf[5];
                    arrf3[2] = arrf[6];
                    arrf3[6] = arrf[7];
                    arrf3[15] = arrf[8];
                    b3.f.clear();
                    float[] arrf4 = b3.e;
                    while (n2 < 16) {
                        float f3 = arrf4[n2];
                        b3.f.add((Object)Float.valueOf((float)f3));
                        ++n2;
                    }
                    nativeVideoPreview.setTextureCoordinateTransformation(b3.f);
                    nativeVideoPreview.draw((ArrayList<NativeTextureBinding>)arrayList);
                }
                b3.i.v.a.draw();
                return Unit.INSTANCE;
            }
        };
        b.a a2 = new b.a(this.a);
        boolean bl = this.a.i.get_optimizesRendering$scandit_capture_core();
        Function1<NeedsRedrawListener, Unit> function12 = new Function1<NeedsRedrawListener, Unit>(this){
            public /* synthetic */ b$c a;
            {
                this.a = b$c;
                super(1);
            }

            public final Object invoke(Object object) {
                NeedsRedrawListener needsRedrawListener = (NeedsRedrawListener)object;
                Intrinsics.checkNotNullParameter((Object)needsRedrawListener, (String)"listener");
                DataCaptureView dataCaptureView = this.a.a.i;
                Objects.requireNonNull((Object)((Object)dataCaptureView));
                Intrinsics.checkNotNullParameter((Object)needsRedrawListener, (String)"listener");
                DataCaptureViewProxyAdapter dataCaptureViewProxyAdapter = dataCaptureView.v;
                Objects.requireNonNull((Object)dataCaptureViewProxyAdapter);
                Intrinsics.checkNotNullParameter((Object)needsRedrawListener, (String)"listener");
                NeedsRedrawListenerReversedAdapter needsRedrawListenerReversedAdapter = dataCaptureViewProxyAdapter.b.getOrPut(Reflection.getOrCreateKotlinClass(NeedsRedrawListener.class), null, needsRedrawListener, new DataCaptureViewProxyAdapter$b(needsRedrawListener));
                dataCaptureViewProxyAdapter.a.setNeedsRedrawDelegate(needsRedrawListenerReversedAdapter);
                return Unit.INSTANCE;
            }
        };
        Intrinsics.checkNotNullParameter((Object)surfaceTexture, (String)"surface");
        Intrinsics.checkNotNullParameter((Object)function1, (String)"doOnFrame");
        Intrinsics.checkNotNullParameter((Object)a2, (String)"doOnFrameAvailable");
        Intrinsics.checkNotNullParameter((Object)function12, (String)"setNeedsRedrawListener");
        Handler handler = c2.g;
        c$d c$d = new c$d(c2, surfaceTexture, (Function1)function1, a2, bl, (Function1)function12);
        handler.post((Runnable)c$d);
        return Unit.INSTANCE;
    }

}

