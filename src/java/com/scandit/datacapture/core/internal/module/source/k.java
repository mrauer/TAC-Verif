/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Rect
 *  android.graphics.SurfaceTexture
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  android.hardware.camera2.CameraManager
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.CaptureResult
 *  android.hardware.camera2.CaptureResult$Key
 *  android.hardware.camera2.TotalCaptureResult
 *  android.hardware.camera2.params.ColorSpaceTransform
 *  android.hardware.camera2.params.MeteringRectangle
 *  android.hardware.camera2.params.RggbChannelVector
 *  android.hardware.camera2.params.StreamConfigurationMap
 *  android.hardware.camera2.params.TonemapCurve
 *  android.media.Image
 *  android.media.Image$Plane
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  android.os.Handler
 *  android.os.Message
 *  android.util.Size
 *  com.scandit.datacapture.core.internal.module.source.k$g
 *  com.scandit.datacapture.core.internal.module.source.k$h
 *  com.scandit.datacapture.core.internal.module.source.k$i
 *  com.scandit.datacapture.core.internal.module.source.k$j
 *  com.scandit.datacapture.core.internal.module.source.k$k
 *  com.scandit.datacapture.core.internal.module.source.k$l
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.EnumSet
 *  java.util.Iterator
 *  java.util.Objects
 *  java.util.concurrent.atomic.AtomicBoolean
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt___ArraysKt$asSequence$
 *  kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined
 *  kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence
 *  kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$4
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.EmptySequence
 */
package com.scandit.datacapture.core.internal.module.source;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.ColorSpaceTransform;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.RggbChannelVector;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.hardware.camera2.params.TonemapCurve;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.Message;
import android.util.Size;
import com.scandit.datacapture.core.common.geometry.Point;
import com.scandit.datacapture.core.common.geometry.Rect;
import com.scandit.datacapture.core.common.geometry.Size2;
import com.scandit.datacapture.core.internal.module.b.a$a;
import com.scandit.datacapture.core.internal.module.b.a.a.b;
import com.scandit.datacapture.core.internal.module.source.NativeCameraApi;
import com.scandit.datacapture.core.internal.module.source.NativeCameraDelegate;
import com.scandit.datacapture.core.internal.module.source.NativeCameraDelegateSettings;
import com.scandit.datacapture.core.internal.module.source.NativeFocusMode;
import com.scandit.datacapture.core.internal.module.source.NativeTonemapCurve;
import com.scandit.datacapture.core.internal.module.source.k;
import com.scandit.datacapture.core.internal.module.source.o;
import com.scandit.datacapture.core.internal.module.source.p;
import com.scandit.datacapture.core.internal.module.source.q;
import com.scandit.datacapture.core.internal.module.source.r;
import com.scandit.datacapture.core.internal.module.source.s;
import com.scandit.datacapture.core.internal.module.source.t;
import com.scandit.datacapture.core.internal.module.source.u;
import com.scandit.datacapture.core.internal.module.source.v;
import com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedPromise;
import com.scandit.datacapture.core.internal.sdk.data.DisposableResource;
import com.scandit.datacapture.core.internal.sdk.data.Subscription;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameData;
import com.scandit.datacapture.core.source.CameraPosition;
import com.scandit.datacapture.core.source.FrameSourceState;
import com.scandit.datacapture.core.source.TorchState;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt$asSequence$;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.EmptySequence;

@TargetApi(value=21)
public final class k
extends NativeCameraDelegate {
    public final com.scandit.datacapture.core.internal.module.b.a.a.b A;
    public final Function1<NativeCameraFrameData, Unit> B;
    public final Function1<FrameSourceState, Unit> C;
    public final boolean D;
    public final int E;
    public final /* synthetic */ t F;
    public SurfaceTexture a;
    public DisposableResource<com.scandit.datacapture.core.internal.module.d.c> b;
    public f c;
    public Subscription<com.scandit.datacapture.core.internal.module.d.c> d;
    public CameraDevice e;
    public CameraCaptureSession f;
    public NativeCameraDelegateSettings g;
    public final v h;
    public Size2 i;
    public boolean j;
    public int k;
    public com.scandit.datacapture.core.internal.module.source.i l;
    public r m;
    public o n;
    public boolean o;
    public boolean p;
    public int q;
    public Rect r;
    public int s;
    public Handler t;
    public CaptureRequest.Builder u;
    public a v;
    public p w;
    public e x;
    public final CameraManager y;
    public final q z;

    public k(CameraManager cameraManager, q q2, com.scandit.datacapture.core.internal.module.b.a.a.b b2, Function1<? super NativeCameraFrameData, Unit> function1, Function1<? super FrameSourceState, Unit> function12, boolean bl, int n2) {
        Intrinsics.checkNotNullParameter((Object)cameraManager, (String)"cameraManager");
        Intrinsics.checkNotNullParameter((Object)q2, (String)"cameraApi2Info");
        Intrinsics.checkNotNullParameter((Object)b2, (String)"cameraProfile");
        Intrinsics.checkNotNullParameter(function1, (String)"frameDataCallback");
        Intrinsics.checkNotNullParameter(function12, (String)"errorCallback");
        this.F = new t();
        this.y = cameraManager;
        this.z = q2;
        this.A = b2;
        this.B = function1;
        this.C = function12;
        this.D = bl;
        this.E = n2;
        this.b = com.scandit.datacapture.core.internal.module.d.b.b;
        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(q2.a());
        Intrinsics.checkNotNullExpressionValue((Object)cameraCharacteristics, (String)"cameraManager.getCameraC\u2026istics(cameraApi2Info.id)");
        this.h = new v(cameraCharacteristics);
        this.i = new Size2(0.0f, 0.0f);
        this.l = new com.scandit.datacapture.core.internal.module.source.i(this);
        this.m = new r(this);
        this.n = new o(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final void k(k k2) {
        block7 : {
            CaptureRequest.Builder builder;
            if (k2.q != 1) {
                Rect rect = k2.r;
                k2.a(rect, 4);
                k2.a(rect);
                k2.r = rect;
                k2.c();
                return;
            }
            Rect rect = k2.r;
            k2.a(rect, 1);
            k2.a(rect);
            k2.r = rect;
            CaptureRequest.Builder builder2 = k2.u;
            if (builder2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
                throw null;
            }
            builder2.set(CaptureRequest.CONTROL_AF_TRIGGER, (Object)1);
            try {
                CameraCaptureSession cameraCaptureSession = k2.f;
                if (cameraCaptureSession != null) {
                    CaptureRequest.Builder builder3 = k2.u;
                    if (builder3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
                        throw null;
                    }
                    CaptureRequest captureRequest = builder3.build();
                    a a2 = k2.v;
                    if (a2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)"cameraCaptureSessionCaptureCallback");
                        throw null;
                    }
                    cameraCaptureSession.capture(captureRequest, (CameraCaptureSession.CaptureCallback)a2, k2.t);
                }
                if ((builder = k2.u) == null) break block7;
            }
            catch (CameraAccessException cameraAccessException) {
                com.scandit.datacapture.core.internal.module.e.a.a((Exception)((Object)cameraAccessException));
                return;
            }
            builder.set(CaptureRequest.CONTROL_AF_TRIGGER, (Object)0);
            k2.c();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
        throw null;
    }

    public final void a(Rect rect) {
        long l2;
        NativeCameraDelegateSettings nativeCameraDelegateSettings = this.g;
        long l3 = nativeCameraDelegateSettings != null ? nativeCameraDelegateSettings.exposureDuration : 0L;
        if (l3 <= 0L && (l2 = nativeCameraDelegateSettings != null ? nativeCameraDelegateSettings.frameDuration : 0L) <= 0L) {
            CaptureRequest.Builder builder = this.u;
            if (builder != null) {
                builder.set(CaptureRequest.CONTROL_AE_MODE, (Object)1);
                CaptureRequest.Builder builder2 = this.u;
                if (builder2 != null) {
                    CaptureRequest.Key key = CaptureRequest.CONTROL_AE_REGIONS;
                    Integer n2 = (Integer)this.h.a.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
                    int n3 = n2 != null ? n2 : 0;
                    builder2.set(key, (Object)this.b(rect, n3));
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
            throw null;
        }
    }

    public final void a(Rect rect, int n2) {
        CaptureRequest.Builder builder = this.u;
        if (builder != null) {
            CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
            Integer n3 = (Integer)this.h.a.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
            int n4 = n3 != null ? n3 : 0;
            builder.set(key, (Object)this.b(rect, n4));
            CaptureRequest.Builder builder2 = this.u;
            if (builder2 != null) {
                builder2.set(CaptureRequest.CONTROL_AF_MODE, (Object)n2);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
        throw null;
    }

    public final void a(NativeCameraDelegateSettings nativeCameraDelegateSettings, Function1<? super Boolean, Unit> function1) {
        if (this.e != null) {
            function1.invoke((Object)Boolean.FALSE);
            return;
        }
        this.g = nativeCameraDelegateSettings;
        Size2 size2 = nativeCameraDelegateSettings.frameResolution;
        Intrinsics.checkNotNullExpressionValue((Object)size2, (String)"settings.frameResolution");
        this.i = size2;
        if (this.c == null) {
            this.c = new Handler(this){
                public final WeakReference<k> a;
                {
                    Intrinsics.checkNotNullParameter((Object)k2, (String)"delegate");
                    this.a = new WeakReference((Object)k2);
                }

                public final void handleMessage(Message message) {
                    Intrinsics.checkNotNullParameter((Object)message, (String)"msg");
                    k k2 = (k)this.a.get();
                    if (k2 == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)k2, (String)"this.delegate.get() ?: return");
                    if (message.what != 1) {
                        return;
                    }
                    Object object = message.obj;
                    Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type kotlin.Pair<android.graphics.SurfaceTexture, (kotlin.Boolean) -> kotlin.Unit>");
                    Pair pair = (Pair)object;
                    k2.a = (SurfaceTexture)pair.first;
                    k2.b((Function1<? super Boolean, Unit>)((Function1)pair.second));
                }
            };
        }
        Subscription<com.scandit.datacapture.core.internal.module.d.c> subscription = this.b.start();
        h h2 = new h(this, function1, nativeCameraDelegateSettings);
        (subscription).use(h2);
        this.d = subscription;
        this.t = new Handler();
        this.w = new p();
        try {
            this.y.openCamera(this.z.a(), new CameraDevice.StateCallback(this, function1){
                public AtomicBoolean a;
                public final Function1<Boolean, Unit> b;
                public /* synthetic */ k c;
                {
                    Intrinsics.checkNotNullParameter(function1, (String)"completion");
                    this.c = k2;
                    this.b = function1;
                    this.a = new AtomicBoolean(false);
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public final void onDisconnected(CameraDevice cameraDevice) {
                    Intrinsics.checkNotNullParameter((Object)cameraDevice, (String)"camera");
                    com.scandit.datacapture.core.internal.module.e.a.a("CameraDevice disconnected");
                    if (!this.a.compareAndSet(false, true)) {
                        this.c.C.invoke((Object)FrameSourceState.OFF);
                        return;
                    }
                    k k2 = this.c;
                    Objects.requireNonNull((Object)k2);
                    try {
                        CameraCaptureSession cameraCaptureSession = k2.f;
                        if (cameraCaptureSession != null) {
                            cameraCaptureSession.abortCaptures();
                        }
                    }
                    catch (CameraAccessException cameraAccessException) {
                        cameraAccessException.printStackTrace();
                    }
                    k k3 = this.c;
                    CameraDevice cameraDevice2 = k3.e;
                    if (cameraDevice2 != null) {
                        cameraDevice2.close();
                    }
                    k3.a = null;
                    k3.e = null;
                    k3.f = null;
                    k3.t = null;
                    k3.g = null;
                    this.b.invoke((Object)Boolean.FALSE);
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public final void onError(CameraDevice cameraDevice, int n2) {
                    Intrinsics.checkNotNullParameter((Object)cameraDevice, (String)"camera");
                    com.scandit.datacapture.core.internal.module.e.a.a("Failed to open camera with camera API 2");
                    if (!this.a.compareAndSet(false, true)) {
                        this.c.C.invoke((Object)FrameSourceState.OFF);
                        return;
                    }
                    k k2 = this.c;
                    Objects.requireNonNull((Object)k2);
                    try {
                        CameraCaptureSession cameraCaptureSession = k2.f;
                        if (cameraCaptureSession != null) {
                            cameraCaptureSession.abortCaptures();
                        }
                    }
                    catch (CameraAccessException cameraAccessException) {
                        cameraAccessException.printStackTrace();
                    }
                    k k3 = this.c;
                    CameraDevice cameraDevice2 = k3.e;
                    if (cameraDevice2 != null) {
                        cameraDevice2.close();
                    }
                    k3.a = null;
                    k3.e = null;
                    k3.f = null;
                    k3.t = null;
                    k3.g = null;
                    this.b.invoke((Object)Boolean.FALSE);
                }

                public final void onOpened(CameraDevice cameraDevice) {
                    Intrinsics.checkNotNullParameter((Object)cameraDevice, (String)"camera");
                    if (this.a.compareAndSet(false, true)) {
                        k k2 = this.c;
                        k2.e = cameraDevice;
                        k2.b(this.b);
                    }
                }
            }, this.t);
            return;
        }
        catch (SecurityException securityException) {
            com.scandit.datacapture.core.internal.module.e.a.a((Exception)((Object)securityException));
            function1.invoke((Object)Boolean.FALSE);
            return;
        }
        catch (CameraAccessException cameraAccessException) {
            com.scandit.datacapture.core.internal.module.e.a.a((Exception)((Object)cameraAccessException));
            function1.invoke((Object)Boolean.FALSE);
            return;
        }
    }

    public final void a(TorchState torchState) {
        int n2 = com.scandit.datacapture.core.internal.module.source.l.a[torchState.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                this.F.k = true;
                this.b(false);
                return;
            }
            this.F.k = false;
            this.b(true);
            return;
        }
        this.F.k = false;
        this.b(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(Function1<? super Boolean, Unit> function1) {
        try {
            CameraCaptureSession cameraCaptureSession = this.f;
            if (cameraCaptureSession == null) {
                com.scandit.datacapture.core.internal.module.e.a.a("No camera capture session to wake up");
                function1.invoke((Object)Boolean.FALSE);
                return;
            }
            this.v = new CameraCaptureSession.CaptureCallback(this, function1){
                public AtomicBoolean a;
                public final Function1<Boolean, Unit> b;
                public /* synthetic */ k c;
                {
                    Intrinsics.checkNotNullParameter(function1, (String)"completion");
                    this.c = k2;
                    this.b = function1;
                    this.a = new AtomicBoolean(false);
                }

                /*
                 * Unable to fully structure code
                 * Enabled aggressive block sorting
                 * Lifted jumps to return sites
                 */
                public final void onCaptureCompleted(CameraCaptureSession var1_1, CaptureRequest var2_2, TotalCaptureResult var3_3) {
                    block10 : {
                        block11 : {
                            block12 : {
                                Intrinsics.checkNotNullParameter((Object)var1_1, (String)"session");
                                Intrinsics.checkNotNullParameter((Object)var2_2, (String)"request");
                                Intrinsics.checkNotNullParameter((Object)var3_3, (String)"totalResult");
                                var4_4 = this.c;
                                var5_5 = (Integer)var3_3.get(CaptureResult.CONTROL_AF_MODE);
                                var6_6 = var5_5 != null ? var5_5 : 0;
                                var4_4.q = var6_6;
                                if (!this.c.F.k) break block10;
                                var10_7 = (Long)var3_3.get(CaptureResult.SENSOR_EXPOSURE_TIME);
                                if (var10_7 == null) {
                                    var10_7 = 0L;
                                }
                                var11_8 = 1.0E-9f * (float)var10_7.longValue();
                                var12_9 = (Integer)var3_3.get(CaptureResult.SENSOR_SENSITIVITY);
                                if (var12_9 == null) {
                                    var12_9 = 0;
                                }
                                var13_10 = var12_9.intValue();
                                var14_11 = (Float)var3_3.get(CaptureResult.LENS_FOCUS_DISTANCE);
                                if (var14_11 == null) {
                                    var14_11 = Float.valueOf((float)0.0f);
                                }
                                Intrinsics.checkNotNullExpressionValue((Object)var14_11, (String)"totalResult.get(CaptureR\u2026ENS_FOCUS_DISTANCE) ?: 0f");
                                var15_12 = var14_11.floatValue();
                                var16_13 = this.c.h.k();
                                var17_14 = this.c.h.j();
                                var18_15 = 1.0f - (var15_12 - var16_13) / (var17_14 - var16_13);
                                var19_16 = var18_15 > 1.0f ? 1.0f : (var18_15 < 0.0f ? 0.0f : var18_15);
                                var20_17 = this.c;
                                var21_18 = (Integer)var3_3.get(CaptureResult.FLASH_STATE);
                                var22_19 = var21_18 != null ? var21_18 : 0;
                                var20_17.k = var22_19;
                                var23_20 = this.c;
                                var24_21 = var23_20.F;
                                var25_22 = var24_21.g;
                                var26_23 = 6;
                                var27_24 = var11_8 + var25_22 * var26_23;
                                var28_25 = 7;
                                var24_21.g = var29_26 = var27_24 / var28_25;
                                var24_21.h = var30_27 = (var13_10 + var26_23 * var24_21.h) / var28_25;
                                var31_28 = 1.0f / (var29_26 * var30_27);
                                var32_29 = var24_21.i;
                                var33_30 = u.a[var32_29 - 1];
                                if (var33_30 == 1) break block11;
                                if (var33_30 == 2) break block12;
                                if (var33_30 != 3) ** GOTO lbl-1000
                                if (var19_16 < 0.3f) {
                                    var24_21.j = 60 + var24_21.f;
                                }
                                if (var24_21.f > var24_21.j) {
                                    var24_21.i = t.a.a;
                                    var47_31 = new StringBuilder("CAM2_AT FD:");
                                    var47_31.append(var19_16);
                                    var47_31.append(", EST:");
                                    var47_31.append(var31_28);
                                    var47_31.append(" DELAY_TO_OFF -> OFF");
                                    com.scandit.datacapture.core.internal.module.e.a.b(var47_31.toString());
                                }
                                ** GOTO lbl75
                            }
                            if (var31_28 > 0.65f) {
                                var24_21.j = 60 + var24_21.f;
                                var24_21.i = t.a.c;
                                var42_32 = new StringBuilder("CAM2_AT FD:");
                                var42_32.append(var19_16);
                                var42_32.append(", EST:");
                                var42_32.append(var31_28);
                                var42_32.append(" ON -> DELAY_TO_OFF");
                                com.scandit.datacapture.core.internal.module.e.a.b(var42_32.toString());
                            }
                            ** GOTO lbl75
                        }
                        if (var31_28 < 0.2f) {
                            var24_21.i = t.a.b;
                            var37_33 = new StringBuilder("CAM2_AT FD:");
                            var37_33.append(var19_16);
                            var37_33.append(", EST:");
                            var37_33.append(var31_28);
                            var37_33.append(" OFF -> ON");
                            com.scandit.datacapture.core.internal.module.e.a.b(var37_33.toString());
lbl75: // 3 sources:
                            var34_34 = true;
                        } else lbl-1000: // 2 sources:
                        {
                            var34_34 = false;
                        }
                        var23_20.j = var34_34;
                        var35_35 = this.c.F;
                        var35_35.f = var36_36 = 1 + var35_35.f;
                        if (var36_36 < 0) {
                            var35_35.f = 0;
                        }
                    }
                    var7_37 = this.c.l;
                    Objects.requireNonNull((Object)var7_37);
                    Intrinsics.checkNotNullParameter((Object)var3_3, (String)"result");
                    var7_37.a = (RggbChannelVector)var3_3.get(CaptureResult.COLOR_CORRECTION_GAINS);
                    var9_38 = this.c.x;
                    if (var9_38 != null) {
                        var9_38.e = var3_3;
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException((String)"imageReaderOnImageAvailableListener");
                    throw null;
                }

                public final void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long l2, long l3) {
                    Intrinsics.checkNotNullParameter((Object)cameraCaptureSession, (String)"session");
                    Intrinsics.checkNotNullParameter((Object)captureRequest, (String)"request");
                    if (this.a.compareAndSet(false, true)) {
                        this.b.invoke((Object)Boolean.TRUE);
                    }
                    super.onCaptureStarted(cameraCaptureSession, captureRequest, l2, l3);
                }
            };
            CaptureRequest.Builder builder = this.u;
            if (builder == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
                throw null;
            }
            CaptureRequest captureRequest = builder.build();
            a a2 = this.v;
            if (a2 != null) {
                cameraCaptureSession.setRepeatingRequest(captureRequest, (CameraCaptureSession.CaptureCallback)a2, this.t);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"cameraCaptureSessionCaptureCallback");
            throw null;
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a(exception);
            function1.invoke((Object)Boolean.FALSE);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public final void b(Function1<? super Boolean, Unit> var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl141 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b(boolean bl) {
        try {
            CaptureRequest.Builder builder = this.u;
            if (builder == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
                throw null;
            }
            CaptureRequest.Key key = CaptureRequest.FLASH_MODE;
            int n2 = bl ? 2 : 0;
            builder.set(key, (Object)n2);
            if (this.c()) return;
            {
                StringBuilder stringBuilder = new StringBuilder("Setting torch to ");
                stringBuilder.append(bl);
                stringBuilder.append(" failed");
                com.scandit.datacapture.core.internal.module.e.a.a(stringBuilder.toString());
                return;
            }
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
            throw exception;
        }
    }

    public final MeteringRectangle[] b(Rect rect, int n2) {
        MeteringRectangle[] arrmeteringRectangle = null;
        if (rect != null) {
            NativeCameraDelegateSettings nativeCameraDelegateSettings;
            if (n2 == 0) {
                return null;
            }
            android.graphics.Rect rect2 = (android.graphics.Rect)this.h.a.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            if (rect2 == null) {
                rect2 = new android.graphics.Rect();
            }
            if ((nativeCameraDelegateSettings = this.g) != null && nativeCameraDelegateSettings.zoomAffectsMeteringArea) {
                CaptureRequest.Builder builder = this.u;
                if (builder != null) {
                    android.graphics.Rect rect3 = (android.graphics.Rect)builder.get(CaptureRequest.SCALER_CROP_REGION);
                    if (rect3 == null) {
                        rect3 = rect2;
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)rect3, (String)"requestBuilder.get(Captu\u2026ION) ?: activeSensorArray");
                    float f2 = (float)rect3.width() / (float)rect2.width();
                    Point point = rect.getOrigin();
                    Intrinsics.checkNotNullExpressionValue((Object)point, (String)"rect.origin");
                    float f3 = 0.5f + f2 * (point.getX() - 0.5f);
                    Point point2 = rect.getOrigin();
                    Intrinsics.checkNotNullExpressionValue((Object)point2, (String)"rect.origin");
                    float f4 = 0.5f + f2 * (point2.getY() - 0.5f);
                    Size2 size2 = rect.getSize();
                    Intrinsics.checkNotNullExpressionValue((Object)size2, (String)"rect.size");
                    float f5 = f2 * size2.getWidth();
                    Size2 size22 = rect.getSize();
                    Intrinsics.checkNotNullExpressionValue((Object)size22, (String)"rect.size");
                    float f6 = f2 * size22.getHeight();
                    MeteringRectangle[] arrmeteringRectangle2 = new MeteringRectangle[]{a$a.a(new Rect(new Point(f3, f4), new Size2(f5, f6)), rect2)};
                    return arrmeteringRectangle2;
                }
                Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
                throw null;
            }
            arrmeteringRectangle = new MeteringRectangle[]{a$a.a(rect, rect2)};
        }
        return arrmeteringRectangle;
    }

    @Override
    public final void bootUpWithSettings(NativeCameraDelegateSettings nativeCameraDelegateSettings, NativeWrappedPromise nativeWrappedPromise) {
        Intrinsics.checkNotNullParameter((Object)nativeCameraDelegateSettings, (String)"settings");
        Intrinsics.checkNotNullParameter((Object)nativeWrappedPromise, (String)"whenDone");
        try {
            this.a(nativeCameraDelegateSettings, (Function1<? super Boolean, Unit>)new g(this, nativeCameraDelegateSettings, nativeWrappedPromise));
            return;
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
            throw exception;
        }
    }

    public final void c(boolean bl) {
        NativeCameraDelegateSettings nativeCameraDelegateSettings = this.g;
        float f2 = 1.0f;
        float f3 = nativeCameraDelegateSettings != null ? nativeCameraDelegateSettings.zoomFactor : f2;
        Float f4 = (Float)this.h.a.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        float f5 = f4 != null ? f4.floatValue() : f2;
        if (!(f2 > f5)) {
            android.graphics.Rect rect;
            if (!(f3 < f2)) {
                f2 = f3 > f5 ? f5 : f3;
            }
            if ((rect = (android.graphics.Rect)this.h.a.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)) == null) {
                rect = new android.graphics.Rect();
            }
            int n2 = (int)((float)rect.width() / f2);
            int n3 = (int)((float)rect.height() / f2);
            int n4 = (rect.width() - n2) / 2;
            int n5 = (rect.height() - n3) / 2;
            if (this.A.b().f && rect.left - n4 < 16 && rect.top - n5 < 16 && rect.width() - n2 < 32 && rect.height() - n3 < 32) {
                n2 = -32 + rect.width();
                n3 = rect.height() - 32;
                n4 = 16 + rect.left;
                n5 = 16 + rect.top;
            }
            android.graphics.Rect rect2 = new android.graphics.Rect(n4, n5, n2 + n4, n3 + n5);
            CaptureRequest.Builder builder = this.u;
            if (builder != null) {
                builder.set(CaptureRequest.SCALER_CROP_REGION, (Object)rect2);
                if (bl && !this.c()) {
                    com.scandit.datacapture.core.internal.module.e.a.a("Updating zoom failed");
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
            throw null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot coerce value to an empty range: maximum ");
        stringBuilder.append(f5);
        stringBuilder.append(" is less than minimum ");
        stringBuilder.append(f2);
        stringBuilder.append('.');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean c() {
        if (this.e == null) {
            return false;
        }
        try {
            CameraCaptureSession cameraCaptureSession = this.f;
            if (cameraCaptureSession == null) return true;
            CaptureRequest.Builder builder = this.u;
            if (builder == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
                throw null;
            }
            CaptureRequest captureRequest = builder.build();
            a a2 = this.v;
            if (a2 != null) {
                cameraCaptureSession.setRepeatingRequest(captureRequest, (CameraCaptureSession.CaptureCallback)a2, this.t);
                return true;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"cameraCaptureSessionCaptureCallback");
            throw null;
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a(exception);
            return false;
        }
    }

    @Override
    public final NativeCameraApi getCameraApi() {
        return NativeCameraApi.CAMERA2;
    }

    @Override
    public final CameraPosition getCameraPosition() {
        Integer n2 = this.z.b();
        if (n2 != null && n2 == 1) {
            return CameraPosition.WORLD_FACING;
        }
        if (n2 != null && n2 == 0) {
            return CameraPosition.USER_FACING;
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported Camera API 2 facing ");
        stringBuilder.append(this.h.b());
        throw new AssertionError((Object)stringBuilder.toString());
    }

    @Override
    public final int getCameraToNativeDeviceOrientation() {
        if (this.h.b() == 1) {
            return this.h.c();
        }
        return -this.h.c();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final ArrayList<Size2> getFrameResolutions() {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap)this.h.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) return new ArrayList();
        Size[] arrsize = streamConfigurationMap.getOutputSizes(35);
        if (arrsize == null) return new ArrayList();
        ArrayList arrayList = new ArrayList(arrsize.length);
        int n2 = arrsize.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Size size = arrsize[i2];
            Intrinsics.checkNotNullExpressionValue((Object)size, (String)"it");
            arrayList.add((Object)new Size2(size.getWidth(), size.getHeight()));
        }
        try {
            Intrinsics.checkNotNullParameter((Object)arrayList, (String)"$this$toArrayList");
            return new ArrayList((Collection)arrayList);
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
            throw exception;
        }
    }

    @Override
    public final EnumSet<NativeFocusMode> getSupportedFocusModesBits() {
        EnumSet enumSet = EnumSet.noneOf(NativeFocusMode.class);
        boolean bl = this.A.b().b;
        int[] arrn = (int[])this.h.a.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        int n2 = 0;
        if (arrn == null) {
            arrn = new int[]{};
        }
        int n3 = arrn.length;
        while (n2 < n3) {
            int n4 = arrn[n2];
            if (n4 != 0) {
                if (n4 != 1) {
                    if (!(n4 != 3 && n4 != 4 || bl)) {
                        enumSet.add((Object)NativeFocusMode.AUTO);
                    }
                } else {
                    enumSet.add((Object)NativeFocusMode.AUTO);
                }
            } else {
                enumSet.add((Object)NativeFocusMode.FIXED);
            }
            ++n2;
        }
        if (this.A.e()) {
            enumSet.add((Object)NativeFocusMode.FIXED);
        }
        Intrinsics.checkNotNullExpressionValue((Object)enumSet, (String)"result");
        return enumSet;
    }

    @Override
    public final boolean goToSleep() {
        block3 : {
            CameraCaptureSession cameraCaptureSession;
            try {
                cameraCaptureSession = this.f;
                if (cameraCaptureSession == null) break block3;
            }
            catch (CameraAccessException cameraAccessException) {
                cameraAccessException.printStackTrace();
                return false;
            }
            cameraCaptureSession.abortCaptures();
        }
        return true;
    }

    @Override
    public final boolean hasManualLensPositionControl() {
        if (this.D) {
            return true;
        }
        Integer n2 = (Integer)this.h.a.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (n2 == null || n2 != 1) {
            if (n2 != null && n2 == 3) {
                return true;
            }
            if (this.h.b() == 1 && this.A.e()) {
                return true;
            }
            int[] arrn = (int[])this.h.a.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            Integer n3 = null;
            if (arrn != null) {
                Object object;
                block6 : {
                    boolean bl;
                    Object object2;
                    Intrinsics.checkNotNullParameter((Object)arrn, (String)"$this$asSequence");
                    boolean bl2 = arrn.length == 0;
                    Object object3 = bl2 ? EmptySequence.INSTANCE : new ArraysKt___ArraysKt$asSequence$.inlined.Sequence.4(arrn);
                    Iterator iterator = object3.iterator();
                    do {
                        boolean bl3 = iterator.hasNext();
                        object = null;
                        if (!bl3) break block6;
                    } while (!(bl = ((Number)(object2 = iterator.next())).intValue() == 1));
                    object = object2;
                }
                n3 = (Integer)object;
            }
            return n3 != null;
        }
        return true;
    }

    @Override
    public final boolean hasNoFocusSystem() {
        boolean bl;
        int[] arrn = (int[])this.h.a.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (arrn == null) {
            arrn = new int[]{};
        }
        ArrayList arrayList = new ArrayList();
        int n2 = arrn.length;
        int n3 = 0;
        do {
            bl = true;
            if (n3 >= n2) break;
            int n4 = arrn[n3];
            if (n4 != 0) {
                bl = false;
            }
            if (!bl) {
                arrayList.add((Object)n4);
            }
            ++n3;
        } while (true);
        if (arrayList.isEmpty()) {
            return bl;
        }
        return false;
    }

    @Override
    public final boolean isTorchAvailable() {
        Boolean bl = (Boolean)this.h.a.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bl != null) {
            return bl;
        }
        return false;
    }

    @Override
    public final boolean setFixedLensPosition(float f2) {
        Integer n2;
        boolean bl = this.D;
        int n3 = 1;
        if (!(bl || (n2 = (Integer)this.h.a.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)) != null && n2 == n3 || n2 != null && n2 == 3 || this.h.b() == n3 && this.A.e())) {
            Integer n4;
            int[] arrn = (int[])this.h.a.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (arrn != null) {
                Object object3;
                block8 : {
                    Intrinsics.checkNotNullParameter((Object)arrn, (String)"$this$asSequence");
                    int n5 = arrn.length == 0 ? n3 : 0;
                    Object object2 = n5 != 0 ? EmptySequence.INSTANCE : new ArraysKt___ArraysKt$asSequence$.inlined.Sequence.4(arrn);
                    for (Object object3 : object2) {
                        int n6 = ((Number)object3).intValue() == n3 ? n3 : 0;
                        if (n6 == 0) continue;
                        break block8;
                    }
                    object3 = null;
                }
                n4 = (Integer)object3;
            } else {
                n4 = null;
            }
            if (n4 == null) {
                n3 = 0;
            }
        }
        if (n3 == 0) {
            com.scandit.datacapture.core.internal.module.e.a.b("setFixedLensPosition() has no effect on a device without manual lens position control");
            return false;
        }
        CaptureRequest.Builder builder = this.u;
        if (builder != null) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, (Object)0);
            CaptureRequest.Builder builder2 = this.u;
            if (builder2 != null) {
                builder2.set(CaptureRequest.LENS_FOCUS_DISTANCE, (Object)Float.valueOf((float)((this.h.j() - this.h.k()) * (1.0f - f2) + this.h.k())));
                return this.c();
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
        throw null;
    }

    @Override
    public final boolean shouldMirrorAroundYAxis() {
        return this.h.b() == 0;
    }

    @Override
    public final boolean shouldUseContinuous(boolean bl) {
        block4 : {
            try {
                if (!this.A.b().b) {
                    return true;
                }
                if (!bl) break block4;
            }
            catch (Exception exception) {
                com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
                throw exception;
            }
            boolean bl2 = a$a.a(b.a.a());
            if (!bl2) break block4;
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void shutDown() {
        try {
            CameraDevice cameraDevice = this.e;
            if (cameraDevice != null) {
                cameraDevice.close();
            }
            this.a = null;
            this.e = null;
            this.f = null;
            this.t = null;
            this.g = null;
            return;
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
            throw exception;
        }
    }

    @Override
    public final boolean startContinuousFocusInArea(Rect rect) {
        this.a(rect, 4);
        this.a(rect);
        this.r = rect;
        return this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final boolean startSingleShotFocusInArea(Rect rect) {
        block6 : {
            CaptureRequest.Builder builder;
            this.a(rect, 1);
            this.a(rect);
            this.r = rect;
            CaptureRequest.Builder builder2 = this.u;
            if (builder2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
                throw null;
            }
            builder2.set(CaptureRequest.CONTROL_AF_TRIGGER, (Object)1);
            try {
                CameraCaptureSession cameraCaptureSession = this.f;
                if (cameraCaptureSession != null) {
                    CaptureRequest.Builder builder3 = this.u;
                    if (builder3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
                        throw null;
                    }
                    CaptureRequest captureRequest = builder3.build();
                    a a2 = this.v;
                    if (a2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)"cameraCaptureSessionCaptureCallback");
                        throw null;
                    }
                    cameraCaptureSession.capture(captureRequest, (CameraCaptureSession.CaptureCallback)a2, this.t);
                }
                if ((builder = this.u) == null) break block6;
            }
            catch (CameraAccessException cameraAccessException) {
                com.scandit.datacapture.core.internal.module.e.a.a((Exception)((Object)cameraAccessException));
                return false;
            }
            builder.set(CaptureRequest.CONTROL_AF_TRIGGER, (Object)0);
            return this.c();
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"requestBuilder");
        throw null;
    }

    @Override
    public final void startWithSettings(NativeCameraDelegateSettings nativeCameraDelegateSettings, NativeWrappedPromise nativeWrappedPromise) {
        Intrinsics.checkNotNullParameter((Object)nativeCameraDelegateSettings, (String)"settings");
        Intrinsics.checkNotNullParameter((Object)nativeWrappedPromise, (String)"whenDone");
        try {
            this.a(nativeCameraDelegateSettings, (Function1<? super Boolean, Unit>)new k(this, nativeCameraDelegateSettings, nativeWrappedPromise));
            return;
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
            throw exception;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void updateSettings(NativeCameraDelegateSettings nativeCameraDelegateSettings, FrameSourceState frameSourceState) {
        Intrinsics.checkNotNullParameter((Object)nativeCameraDelegateSettings, (String)"settings");
        Intrinsics.checkNotNullParameter((Object)((Object)frameSourceState), (String)"currentState");
        try {
            this.g = nativeCameraDelegateSettings;
            this.c(true);
            TorchState torchState = nativeCameraDelegateSettings.torchState;
            Intrinsics.checkNotNullExpressionValue((Object)((Object)torchState), (String)"settings.torchState");
            this.a(torchState);
            if (true ^ Intrinsics.areEqual((Object)nativeCameraDelegateSettings.frameResolution, (Object)this.i)) {
                int n2 = com.scandit.datacapture.core.internal.module.source.l.b[frameSourceState.ordinal()];
                if (n2 != 1) {
                    if (n2 != 2) {
                        return;
                    }
                    this.shutDown();
                    this.a(nativeCameraDelegateSettings, (Function1<? super Boolean, Unit>)i.a);
                    return;
                }
                try {
                    CameraCaptureSession cameraCaptureSession = this.f;
                    if (cameraCaptureSession != null) {
                        cameraCaptureSession.abortCaptures();
                    }
                }
                catch (CameraAccessException cameraAccessException) {
                    cameraAccessException.printStackTrace();
                }
                this.shutDown();
                this.a(nativeCameraDelegateSettings, (Function1<? super Boolean, Unit>)new j(this));
            }
            return;
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
            throw exception;
        }
    }

    @Override
    public final void wakeUp(NativeWrappedPromise nativeWrappedPromise) {
        Intrinsics.checkNotNullParameter((Object)nativeWrappedPromise, (String)"whenDone");
        try {
            this.a((Function1<? super Boolean, Unit>)new l(this, nativeWrappedPromise));
            return;
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
            throw exception;
        }
    }

}

