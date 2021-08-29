/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.graphics.SurfaceTexture
 *  android.hardware.Camera
 *  android.hardware.Camera$Area
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.Camera$Parameters
 *  android.hardware.Camera$PreviewCallback
 *  android.hardware.Camera$Size
 *  android.os.Handler
 *  android.os.Message
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.core.internal.module.source.a$c
 *  com.scandit.datacapture.core.internal.module.source.a$d
 *  com.scandit.datacapture.core.internal.module.source.a$e
 *  com.scandit.datacapture.core.internal.module.source.a$f
 *  com.scandit.datacapture.core.internal.module.source.a$h
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.EnumSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Objects
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.collections.IndexedValue
 *  kotlin.collections.IndexingIterable
 *  kotlin.collections.IndexingIterator
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.ranges.RangesKt___RangesKt
 */
package com.scandit.datacapture.core.internal.module.source;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import com.google.android.material.R;
import com.scandit.datacapture.core.common.geometry.Point;
import com.scandit.datacapture.core.common.geometry.Rect;
import com.scandit.datacapture.core.common.geometry.Size2;
import com.scandit.datacapture.core.internal.module.b.a$a;
import com.scandit.datacapture.core.internal.module.b.a.a.b;
import com.scandit.datacapture.core.internal.module.source.NativeCameraApi;
import com.scandit.datacapture.core.internal.module.source.NativeCameraDelegate;
import com.scandit.datacapture.core.internal.module.source.NativeCameraDelegateSettings;
import com.scandit.datacapture.core.internal.module.source.NativeFocusMode;
import com.scandit.datacapture.core.internal.module.source.a;
import com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedPromise;
import com.scandit.datacapture.core.internal.sdk.data.DisposableResource;
import com.scandit.datacapture.core.internal.sdk.data.Subscription;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameData;
import com.scandit.datacapture.core.source.CameraPosition;
import com.scandit.datacapture.core.source.FrameSourceState;
import com.scandit.datacapture.core.source.TorchState;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.IndexingIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt___RangesKt;

public final class a
extends NativeCameraDelegate {
    public SurfaceTexture a;
    public Camera b;
    public b c;
    public DisposableResource<com.scandit.datacapture.core.internal.module.d.c> d;
    public com.scandit.datacapture.core.internal.module.source.e e;
    public Subscription<com.scandit.datacapture.core.internal.module.d.c> f;
    public Size2 h;
    public final Camera.CameraInfo i;
    public final com.scandit.datacapture.core.internal.module.b.a.a.b j;
    public final Function1<NativeCameraFrameData, Unit> k;

    public a(Camera.CameraInfo cameraInfo, com.scandit.datacapture.core.internal.module.b.a.a.b b2, Function1<? super NativeCameraFrameData, Unit> function1, Function1<? super FrameSourceState, Unit> function12) {
        Intrinsics.checkNotNullParameter((Object)cameraInfo, (String)"cameraInfo");
        Intrinsics.checkNotNullParameter((Object)b2, (String)"cameraProfile");
        Intrinsics.checkNotNullParameter(function1, (String)"frameDataCallback");
        Intrinsics.checkNotNullParameter(function12, (String)"errorCallback");
        this.i = cameraInfo;
        this.j = b2;
        this.k = function1;
        this.d = com.scandit.datacapture.core.internal.module.d.b.b;
        this.h = new Size2(0.0f, 0.0f);
    }

    public static String a(Camera.Parameters parameters, boolean bl) {
        if (!bl) {
            return "off";
        }
        List list = parameters.getSupportedFlashModes();
        if (list != null) {
            if (list.contains((Object)"torch")) {
                return "torch";
            }
            if (list.contains((Object)"on")) {
                return "on";
            }
        }
        return "off";
    }

    public static String a(List<String> list) {
        if (list.contains((Object)"continuous-picture")) {
            return "continuous-picture";
        }
        if (list.contains((Object)"continuous-video")) {
            return "continuous-video";
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(Camera.Parameters parameters, float f2) {
        if (!(f2 < 1.0f)) {
            Object object;
            if (!parameters.isZoomSupported()) {
                return;
            }
            int n2 = (int)(f2 * 100.0f);
            List list = parameters.getZoomRatios();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"camParams.zoomRatios");
            IndexingIterator indexingIterator = (IndexingIterator)((IndexingIterable)ArraysKt___ArraysJvmKt.withIndex((Iterable)list)).iterator();
            if (!indexingIterator.hasNext()) {
                object = null;
            } else {
                Object object2 = indexingIterator.next();
                if (indexingIterator.hasNext()) {
                    int n3 = Math.abs((int)(((Number)((IndexedValue)object2).value).intValue() - n2));
                    do {
                        Object object3 = indexingIterator.next();
                        int n4 = Math.abs((int)(((Number)((IndexedValue)object3).value).intValue() - n2));
                        if (n3 <= n4) continue;
                        object2 = object3;
                        n3 = n4;
                    } while (indexingIterator.hasNext());
                }
                object = object2;
            }
            IndexedValue indexedValue = (IndexedValue)object;
            if (indexedValue != null) {
                parameters.setZoom(indexedValue.index);
            }
        }
    }

    public static final /* synthetic */ void a(a a2, Function1 function1) {
        Camera camera = a2.b;
        if (camera != null && a2.a != null) {
            IOException iOException2;
            block4 : {
                try {
                    camera.startPreview();
                    function1.invoke((Object)Boolean.TRUE);
                    return;
                }
                catch (RuntimeException runtimeException) {
                }
                catch (IOException iOException2) {
                    break block4;
                }
                com.scandit.datacapture.core.internal.module.e.a.a("Either the Camera object has been released or a hardware or other low-level error occurred", (Exception)((Object)runtimeException));
                function1.invoke((Object)Boolean.FALSE);
                return;
            }
            com.scandit.datacapture.core.internal.module.e.a.a((Exception)((Object)iOException2));
            function1.invoke((Object)Boolean.FALSE);
            return;
        }
        function1.invoke((Object)Boolean.FALSE);
    }

    public static boolean a(Camera.Parameters parameters, Size2 size2) {
        Object object2;
        block2 : {
            List list = parameters.getSupportedPreviewSizes();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"supportedSizes");
            for (Object object2 : list) {
                Camera.Size size = (Camera.Size)object2;
                boolean bl = (float)size.height == size2.getHeight() && (float)size.width == size2.getWidth();
                if (!bl) continue;
                break block2;
            }
            object2 = null;
        }
        Camera.Size size = (Camera.Size)object2;
        if (size != null) {
            parameters.setPreviewSize(size.width, size.height);
            return true;
        }
        return false;
    }

    public static void b(Camera.Parameters parameters, float f2) {
        boolean bl;
        int n2 = parameters.getMinExposureCompensation();
        int n3 = parameters.getMaxExposureCompensation();
        float f3 = parameters.getExposureCompensationStep();
        if ((n2 != 0 || n3 != 0) && f3 != 0.0f && (bl = !Float.isInfinite((float)f3) && !Float.isNaN((float)f3))) {
            parameters.setExposureCompensation(RangesKt___RangesKt.coerceIn((int)R.style.roundToInt((float)(f2 / f3)), (int)n2, (int)n3));
            return;
        }
        parameters.setExposureCompensation(0);
    }

    /*
     * Exception decompiling
     */
    public final Camera.Parameters a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl13 : ACONST_NULL : trying to set 1 previously set to 0
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

    public final void a(Camera.Parameters parameters, Rect rect) {
        ArrayList arrayList;
        if (this.j.b().e) {
            return;
        }
        if (rect == null) {
            arrayList = null;
        } else {
            List list = R.style.listOf((Object)rect);
            ArrayList arrayList2 = new ArrayList(R.style.collectionSizeOrDefault((Iterable)list, (int)10));
            for (Rect rect2 : list) {
                Intrinsics.checkNotNullParameter((Object)rect2, (String)"$this$toGraphicRect");
                float f2 = -1000;
                float f3 = 2000;
                Point point = rect2.getOrigin();
                Intrinsics.checkNotNullExpressionValue((Object)point, (String)"origin");
                int n2 = R.style.roundToInt((float)(f2 + f3 * point.getX()));
                Point point2 = rect2.getOrigin();
                Intrinsics.checkNotNullExpressionValue((Object)point2, (String)"origin");
                int n3 = R.style.roundToInt((float)(f2 + f3 * point2.getY()));
                Point point3 = rect2.getOrigin();
                Intrinsics.checkNotNullExpressionValue((Object)point3, (String)"origin");
                float f4 = f2 + f3 * point3.getX();
                Size2 size2 = rect2.getSize();
                Intrinsics.checkNotNullExpressionValue((Object)size2, (String)"size");
                int n4 = R.style.roundToInt((float)(f4 + f3 * size2.getWidth()));
                Point point4 = rect2.getOrigin();
                Intrinsics.checkNotNullExpressionValue((Object)point4, (String)"origin");
                float f5 = f2 + f3 * point4.getY();
                Size2 size22 = rect2.getSize();
                Intrinsics.checkNotNullExpressionValue((Object)size22, (String)"size");
                android.graphics.Rect rect3 = new android.graphics.Rect(n2, n3, n4, R.style.roundToInt((float)(f5 + f3 * size22.getHeight())));
                rect3.sort();
                arrayList2.add((Object)rect3);
            }
            arrayList = new ArrayList(R.style.collectionSizeOrDefault((Iterable)arrayList2, (int)10));
            Iterator iterator = arrayList2.iterator();
            while (iterator.hasNext()) {
                arrayList.add((Object)new Camera.Area((android.graphics.Rect)iterator.next(), 1000));
            }
        }
        if (parameters.getMaxNumFocusAreas() > 0) {
            parameters.setFocusAreas(arrayList);
        }
        if (parameters.getMaxNumMeteringAreas() > 0) {
            parameters.setMeteringAreas(arrayList);
        }
    }

    public final void a(NativeCameraDelegateSettings nativeCameraDelegateSettings, Function1<? super Boolean, Unit> function1) {
        this.b();
        if (this.b == null) {
            function1.invoke((Object)Boolean.FALSE);
            return;
        }
        Camera.Parameters parameters = this.a();
        if (parameters == null) {
            function1.invoke((Object)Boolean.FALSE);
            return;
        }
        Size2 size2 = nativeCameraDelegateSettings.frameResolution;
        Intrinsics.checkNotNullExpressionValue((Object)size2, (String)"settings.frameResolution");
        if (!a.a(parameters, size2)) {
            function1.invoke((Object)Boolean.FALSE);
            return;
        }
        Camera.Size size = parameters.getPreviewSize();
        com.scandit.datacapture.core.internal.module.source.e e2 = new com.scandit.datacapture.core.internal.module.source.e(this.b, size.width, size.height, this.k, this);
        e2.e = false;
        this.e = e2;
        parameters.setPreviewFormat(17);
        if (!this.a(parameters)) {
            function1.invoke((Object)Boolean.FALSE);
            return;
        }
        if (this.c == null) {
            this.c = new Handler(this){
                public final WeakReference<a> a;
                {
                    Intrinsics.checkNotNullParameter((Object)a2, (String)"delegate");
                    this.a = new WeakReference((Object)a2);
                }

                public final void handleMessage(Message message) {
                    IOException iOException2;
                    Function1 function1;
                    block11 : {
                        Intrinsics.checkNotNullParameter((Object)message, (String)"msg");
                        a a2 = (a)this.a.get();
                        if (a2 == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue((Object)a2, (String)"this.delegate.get() ?: return");
                        int n2 = message.what;
                        if (n2 != 1) {
                            com.scandit.datacapture.core.internal.module.source.e e2;
                            if (n2 != 2) {
                                if (n2 != 3) {
                                    return;
                                }
                                Object object = message.obj;
                                Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type (kotlin.Boolean) -> kotlin.Unit");
                                TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)object, (int)1);
                                a.a(a2, (Function1)object);
                                Camera camera = a2.b;
                                if (camera != null) {
                                    camera.stopPreview();
                                }
                                return;
                            }
                            Subscription<com.scandit.datacapture.core.internal.module.d.c> subscription = a2.f;
                            if (subscription != null) {
                                subscription.use((Function1<com.scandit.datacapture.core.internal.module.d.c, Unit>)new d(true));
                            }
                            if ((e2 = a2.e) != null) {
                                e2.e = true;
                            }
                            Object object = message.obj;
                            Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type (kotlin.Boolean) -> kotlin.Unit");
                            TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)object, (int)1);
                            a.a(a2, (Function1)object);
                            return;
                        }
                        Object object = message.obj;
                        Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type kotlin.Pair<android.graphics.SurfaceTexture, (kotlin.Boolean) -> kotlin.Unit>");
                        Pair pair = (Pair)object;
                        SurfaceTexture surfaceTexture = (SurfaceTexture)pair.first;
                        function1 = (Function1)pair.second;
                        a2.a = surfaceTexture;
                        Camera camera = a2.b;
                        if (camera == null) {
                            function1.invoke((Object)Boolean.FALSE);
                            return;
                        }
                        try {
                            camera.setPreviewTexture(surfaceTexture);
                            camera.setDisplayOrientation(0);
                            function1.invoke((Object)Boolean.TRUE);
                            return;
                        }
                        catch (RuntimeException runtimeException) {
                        }
                        catch (IOException iOException2) {
                            break block11;
                        }
                        com.scandit.datacapture.core.internal.module.e.a.a("Either the Camera object has been released or a hardware or other low-level error occurred", (Exception)((Object)runtimeException));
                        function1.invoke((Object)Boolean.FALSE);
                        return;
                    }
                    com.scandit.datacapture.core.internal.module.e.a.a((Exception)((Object)iOException2));
                    function1.invoke((Object)Boolean.FALSE);
                }
            };
        }
        Subscription<com.scandit.datacapture.core.internal.module.d.c> subscription = this.d.start();
        e e3 = new e(this, function1, nativeCameraDelegateSettings);
        (subscription).use(e3);
        this.f = subscription;
        this.j.a(parameters, nativeCameraDelegateSettings.maxFrameRate, -1.0f);
        a.a(parameters, nativeCameraDelegateSettings.zoomFactor);
        if (nativeCameraDelegateSettings.torchState == TorchState.ON) {
            parameters.setFlashMode(a.a(parameters, true));
        }
        a.b(parameters, nativeCameraDelegateSettings.exposureTargetBias);
        this.a(parameters);
    }

    public final void a(boolean bl) {
        Camera.Parameters parameters = this.a();
        String string = parameters != null ? parameters.getFlashMode() : null;
        boolean bl2 = string != null;
        if (!bl2) {
            return;
        }
        Camera.Parameters parameters2 = this.a();
        if (parameters2 == null) {
            return;
        }
        try {
            parameters2.setFlashMode(a.a(parameters2, bl));
            this.a(parameters2);
            return;
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a(exception);
            return;
        }
    }

    public final boolean a(Camera.Parameters parameters) {
        Camera camera = this.b;
        if (camera == null) {
            com.scandit.datacapture.core.internal.module.e.a.a("No camera. failed to set camera parameters");
            return false;
        }
        try {
            camera.setParameters(parameters);
            Camera.Size size = parameters.getPreviewSize();
            this.h = new Size2(size.width, size.height);
            return true;
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a("Failed to set camera parameters");
            return false;
        }
    }

    public final void b(Function1<? super Boolean, Unit> function1) {
        Camera camera;
        b b2;
        com.scandit.datacapture.core.internal.module.source.e e2 = this.e;
        if (e2 != null && (camera = e2.h) != null) {
            camera.setPreviewCallbackWithBuffer(e2.g);
        }
        if ((b2 = this.c) != null) {
            b2.sendMessage(b2.obtainMessage(2, function1));
        }
    }

    /*
     * Exception decompiling
     */
    public final boolean b() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl69 : ALOAD_0 : trying to set 1 previously set to 0
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

    @Override
    public final void bootUpWithSettings(NativeCameraDelegateSettings nativeCameraDelegateSettings, NativeWrappedPromise nativeWrappedPromise) {
        Intrinsics.checkNotNullParameter((Object)nativeCameraDelegateSettings, (String)"settings");
        Intrinsics.checkNotNullParameter((Object)nativeWrappedPromise, (String)"whenDone");
        try {
            this.a(nativeCameraDelegateSettings, (Function1<? super Boolean, Unit>)new c(this, nativeCameraDelegateSettings, nativeWrappedPromise));
            return;
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
            throw exception;
        }
    }

    @Override
    public final NativeCameraApi getCameraApi() {
        return NativeCameraApi.CAMERA1;
    }

    @Override
    public final CameraPosition getCameraPosition() {
        int n2 = this.i.facing;
        if (n2 != 0) {
            if (n2 == 1) {
                return CameraPosition.USER_FACING;
            }
            StringBuilder stringBuilder = new StringBuilder("Unsupported Camera API 1 facing ");
            stringBuilder.append(this.i.facing);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        return CameraPosition.WORLD_FACING;
    }

    @Override
    public final int getCameraToNativeDeviceOrientation() {
        Camera.CameraInfo cameraInfo = this.i;
        if (cameraInfo.facing == 0) {
            return cameraInfo.orientation;
        }
        return -cameraInfo.orientation;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final ArrayList<Size2> getFrameResolutions() {
        ArrayList arrayList;
        block4 : {
            block3 : {
                try {
                    List list;
                    Camera.Parameters parameters = this.a();
                    if (parameters == null || (list = parameters.getSupportedPreviewSizes()) == null) break block3;
                    ArrayList arrayList2 = new ArrayList(R.style.collectionSizeOrDefault((Iterable)list, (int)10));
                    for (Camera.Size size : list) {
                        arrayList2.add((Object)new Size2(size.width, size.height));
                    }
                    Intrinsics.checkNotNullParameter((Object)arrayList2, (String)"$this$toArrayList");
                    arrayList = new ArrayList((Collection)arrayList2);
                    break block4;
                }
                catch (Exception exception) {
                    com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
                    throw exception;
                }
            }
            arrayList = null;
        }
        if (arrayList != null) return arrayList;
        return new ArrayList();
    }

    @Override
    public final EnumSet<NativeFocusMode> getSupportedFocusModesBits() {
        EnumSet enumSet = EnumSet.noneOf(NativeFocusMode.class);
        boolean bl = this.j.b().b;
        Camera.Parameters parameters = this.a();
        if (parameters != null) {
            block6 : for (String string : parameters.getSupportedFocusModes()) {
                if (string == null) continue;
                switch (string.hashCode()) {
                    default: {
                        continue block6;
                    }
                    case 910005312: {
                        if (!string.equals((Object)"continuous-picture")) continue block6;
                        break;
                    }
                    case 97445748: {
                        if (!string.equals((Object)"fixed")) continue block6;
                        enumSet.add((Object)NativeFocusMode.FIXED);
                        continue block6;
                    }
                    case 3005871: {
                        if (!string.equals((Object)"auto")) continue block6;
                        enumSet.add((Object)NativeFocusMode.AUTO);
                        continue block6;
                    }
                    case -194628547: {
                        if (!string.equals((Object)"continuous-video")) continue block6;
                    }
                }
                if (bl) continue;
                enumSet.add((Object)NativeFocusMode.AUTO);
            }
            if (this.j.e()) {
                enumSet.add((Object)NativeFocusMode.FIXED);
            }
        }
        Intrinsics.checkNotNullExpressionValue((Object)enumSet, (String)"result");
        return enumSet;
    }

    @Override
    public final boolean goToSleep() {
        block5 : {
            Camera camera;
            try {
                camera = this.b;
                if (camera == null) break block5;
            }
            catch (Exception exception) {
                try {
                    com.scandit.datacapture.core.internal.module.e.a.a(exception);
                    return false;
                }
                catch (Exception exception2) {
                    com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception2);
                    throw exception2;
                }
            }
            camera.stopPreview();
        }
        return true;
    }

    @Override
    public final boolean hasManualLensPositionControl() {
        return false;
    }

    @Override
    public final boolean hasNoFocusSystem() {
        Camera.Parameters parameters;
        block5 : {
            block4 : {
                try {
                    if (this.b()) break block4;
                    return false;
                }
                catch (Exception exception) {
                    com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
                    throw exception;
                }
            }
            parameters = this.a();
            if (parameters != null) break block5;
            return false;
        }
        List list = parameters.getSupportedFocusModes();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"camParams.supportedFocusModes");
        String string = a.a((List<String>)list);
        return string == null;
    }

    @Override
    public final boolean isTorchAvailable() {
        Camera.Parameters parameters = this.a();
        String string = parameters != null ? parameters.getFlashMode() : null;
        return string != null;
    }

    @Override
    public final boolean setFixedLensPosition(float f2) {
        return false;
    }

    @Override
    public final boolean shouldMirrorAroundYAxis() {
        return this.i.facing == 1;
    }

    @Override
    public final boolean shouldUseContinuous(boolean bl) {
        block4 : {
            try {
                if (!this.j.b().b) {
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
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public final void shutDown() {
        try {
            var4_1 = this.e;
            if (var4_1 != null) {
                var5_2 = var4_1.h;
                if (var5_2 != null) {
                    var5_2.setPreviewCallbackWithBuffer(null);
                }
                var4_1.c = true;
            }
            if ((var6_3 = this.b) != null) {
                var6_3.release();
            }
            ** GOTO lbl14
        }
        catch (Exception var1_4) {
            try {
                com.scandit.datacapture.core.internal.module.e.a.a(var1_4);
lbl14: // 2 sources:
                this.b = null;
                var3_5 = this.f;
                if (var3_5 != null) {
                    var3_5.dispose();
                }
                this.a = null;
                return;
            }
            catch (Exception var2_6) {
                com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", var2_6);
                throw var2_6;
            }
        }
    }

    @Override
    public final boolean startContinuousFocusInArea(Rect rect) {
        Camera.Parameters parameters;
        String string;
        block7 : {
            block6 : {
                block5 : {
                    try {
                        if (this.b()) break block5;
                        return false;
                    }
                    catch (Exception exception) {
                        com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
                        throw exception;
                    }
                }
                parameters = this.a();
                if (parameters != null) break block6;
                return false;
            }
            List list = parameters.getSupportedFocusModes();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"camParams.supportedFocusModes");
            string = a.a((List<String>)list);
            if (string != null) break block7;
            return false;
        }
        parameters.setFocusMode(string);
        this.a(parameters, rect);
        boolean bl = this.a(parameters);
        return bl;
    }

    /*
     * Exception decompiling
     */
    @Override
    public final boolean startSingleShotFocusInArea(Rect var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl46 : FAKE_TRY : trying to set 1 previously set to 0
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

    @Override
    public final void startWithSettings(NativeCameraDelegateSettings nativeCameraDelegateSettings, NativeWrappedPromise nativeWrappedPromise) {
        Intrinsics.checkNotNullParameter((Object)nativeCameraDelegateSettings, (String)"settings");
        Intrinsics.checkNotNullParameter((Object)nativeWrappedPromise, (String)"whenDone");
        try {
            this.a(nativeCameraDelegateSettings, (Function1<? super Boolean, Unit>)new f(this, nativeCameraDelegateSettings, nativeWrappedPromise));
            return;
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
            throw exception;
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public final void updateSettings(NativeCameraDelegateSettings var1_1, FrameSourceState var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    @Override
    public final void wakeUp(NativeWrappedPromise nativeWrappedPromise) {
        Intrinsics.checkNotNullParameter((Object)nativeWrappedPromise, (String)"whenDone");
        try {
            this.b((Function1<? super Boolean, Unit>)new h(this, nativeWrappedPromise));
            return;
        }
        catch (Exception exception) {
            com.scandit.datacapture.core.internal.module.e.a.a("Exception caught in listener method. Rethrowing...", exception);
            throw exception;
        }
    }

}

