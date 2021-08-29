/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.Camera$PreviewCallback
 *  android.os.Handler
 *  android.os.Message
 *  com.scandit.datacapture.core.internal.module.source.a
 *  com.scandit.datacapture.core.internal.module.source.e$c
 *  java.lang.Float
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Objects
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.source;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import com.scandit.datacapture.core.internal.module.common.geometry.NativeAxis;
import com.scandit.datacapture.core.internal.module.source.a;
import com.scandit.datacapture.core.internal.module.source.e;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraCaptureParameterKey;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameData;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameDataPool;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*
 * Exception performing whole class analysis.
 */
public final class e {
    public final b a;
    public final ArrayList<byte[]> b;
    public boolean c;
    public final c d;
    public boolean e;
    public final Map<NativeCameraFrameData, NativeFrameData> f;
    public final Camera.PreviewCallback g;
    public final Camera h;
    public int i;
    public int j;
    public final Function1<NativeCameraFrameData, Unit> k;
    public final a l;

    public e(Camera camera, int n2, int n3, Function1<? super NativeCameraFrameData, Unit> function1, a a2) {
        Camera.PreviewCallback previewCallback;
        Intrinsics.checkNotNullParameter(function1, (String)"frameDataCallback");
        Intrinsics.checkNotNullParameter((Object)a2, (String)"delegate");
        this.h = camera;
        this.i = n2;
        this.j = n3;
        this.k = function1;
        this.l = a2;
        this.b = new ArrayList();
        this.d = new /* Unavailable Anonymous Inner Class!! */;
        this.e = true;
        this.f = new LinkedHashMap();
        this.g = previewCallback = new Camera.PreviewCallback(this){
            public /* synthetic */ e a;
            {
                this.a = e2;
            }

            public final void onPreviewFrame(byte[] arrby, Camera camera) {
                NativeCameraFrameData nativeCameraFrameData;
                e e2 = this.a;
                Intrinsics.checkNotNullExpressionValue((Object)arrby, (String)"data");
                if (!e2.c && arrby.length == e2.f()) {
                    int n2 = e2.i;
                    int n3 = e2.j;
                    c c2 = e2.d;
                    Camera.CameraInfo cameraInfo = e2.l.i;
                    int n4 = cameraInfo.facing;
                    int n5 = n4 == 0 ? cameraInfo.orientation : -cameraInfo.orientation;
                    int n6 = n5;
                    int n7 = 1;
                    if (n4 != n7) {
                        n7 = 0;
                    }
                    NativeAxis nativeAxis = n7 != 0 ? NativeAxis.Y : NativeAxis.NONE;
                    nativeCameraFrameData = NativeCameraFrameData.create(n2, n3, arrby, (NativeCameraFrameDataPool)c2, n6, nativeAxis, (HashMap<NativeCameraCaptureParameterKey, Float>)new HashMap());
                    Map<NativeCameraFrameData, NativeFrameData> map = e2.f;
                    Intrinsics.checkNotNullExpressionValue((Object)nativeCameraFrameData, (String)"it");
                    NativeFrameData nativeFrameData = nativeCameraFrameData.asFrameData();
                    Intrinsics.checkNotNullExpressionValue((Object)nativeFrameData, (String)"it.asFrameData()");
                    map.put((Object)nativeCameraFrameData, (Object)nativeFrameData);
                } else {
                    nativeCameraFrameData = null;
                }
                if (nativeCameraFrameData != null) {
                    nativeCameraFrameData.retain();
                    try {
                        e e3 = this.a;
                        if (e3.e) {
                            e3.k.invoke((Object)nativeCameraFrameData);
                        }
                        return;
                    }
                    finally {
                        nativeCameraFrameData.release();
                    }
                }
            }
        };
        this.a = new b(this);
        if (camera != null) {
            camera.setPreviewCallbackWithBuffer(previewCallback);
        }
        this.e();
    }

    public final void a(int n2, int n3) {
        if (true ^ this.c) {
            if (this.i == n2 && this.j == n3) {
                return;
            }
            Camera camera = this.h;
            if (camera != null) {
                camera.setPreviewCallbackWithBuffer(null);
            }
            this.b.clear();
            this.i = n2;
            this.j = n3;
            this.e();
            return;
        }
        throw new IllegalStateException("Trying to change frame size on a stopped pool".toString());
    }

    public final void a(byte[] arrby) {
        Camera camera;
        if (this.c) {
            return;
        }
        if (arrby.length == this.f() && (camera = this.h) != null) {
            camera.addCallbackBuffer(arrby);
        }
    }

    public final void e() {
        int n2 = this.f();
        for (int i2 = 0; i2 < 3; ++i2) {
            byte[] arrby = new byte[n2];
            this.b.add((Object)arrby);
            this.a(arrby);
        }
    }

    public final int f() {
        return 3 * (this.i * this.j) / 2;
    }

    public static final class b
    extends Handler {
        public final WeakReference<e> a;

        public b(e e2) {
            Intrinsics.checkNotNullParameter((Object)e2, (String)"pool");
            this.a = new WeakReference((Object)e2);
        }

        public final void handleMessage(Message message) {
            Intrinsics.checkNotNullParameter((Object)message, (String)"msg");
            e e2 = (e)this.a.get();
            if (e2 == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue((Object)e2, (String)"this.pool.get() ?: return");
            Object object = message.obj;
            Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type kotlin.ByteArray");
            e2.a((byte[])object);
        }
    }

}

