/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.camera2.CameraManager
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Objects
 *  java.util.concurrent.CopyOnWriteArraySet
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.source;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import com.scandit.datacapture.core.data.FrameData;
import com.scandit.datacapture.core.internal.module.b.a.a.b;
import com.scandit.datacapture.core.internal.module.source.CameraFactory;
import com.scandit.datacapture.core.internal.module.source.NativeCameraApi;
import com.scandit.datacapture.core.internal.module.source.NativeFrameSource;
import com.scandit.datacapture.core.internal.module.source.NativeFrameSourceListener;
import com.scandit.datacapture.core.internal.module.source.c;
import com.scandit.datacapture.core.internal.module.source.f;
import com.scandit.datacapture.core.internal.module.source.m;
import com.scandit.datacapture.core.internal.module.source.w;
import com.scandit.datacapture.core.internal.sdk.AppAndroidEnvironment;
import com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedFuture;
import com.scandit.datacapture.core.internal.sdk.source.NativeAndroidCamera;
import com.scandit.datacapture.core.source.AndroidCameraProxyAdapter;
import com.scandit.datacapture.core.source.FrameSource;
import com.scandit.datacapture.core.source.FrameSourceListener;
import com.scandit.datacapture.core.source.FrameSourceListenerReversedAdapter;
import com.scandit.datacapture.core.source.FrameSourceState;
import com.scandit.datacapture.core.source.TorchListener;
import com.scandit.datacapture.core.source.TorchState;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class Camera
implements FrameSource {
    public static final Companion Companion = new Object(null){};
    public static final CameraFactory e;
    public final CopyOnWriteArraySet<FrameSourceListener> a;
    public CopyOnWriteArraySet<TorchListener> b;
    public CopyOnWriteArraySet<WeakReference<TorchListener>> c;
    public TorchState d;
    public final /* synthetic */ AndroidCameraProxyAdapter f;

    public static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put((Object)NativeCameraApi.CAMERA1, (Object)new c(null, null, 3));
        Context context = AppAndroidEnvironment.applicationContext;
        if (context != null) {
            Object object = context.getSystemService("camera");
            Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            CameraManager cameraManager = (CameraManager)object;
            linkedHashMap.put((Object)NativeCameraApi.CAMERA2, (Object)new m(cameraManager, null, null, 6));
            e = new CameraFactory(com.scandit.datacapture.core.internal.module.b.a.a.c.a(), (Map<NativeCameraApi, ? extends w>)linkedHashMap);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
        throw null;
    }

    public Camera(NativeAndroidCamera nativeAndroidCamera) {
        Intrinsics.checkNotNullParameter((Object)nativeAndroidCamera, (String)"impl");
        this.f = new AndroidCameraProxyAdapter(nativeAndroidCamera, null, 2);
        this.a = new CopyOnWriteArraySet();
        this.b = new CopyOnWriteArraySet();
        this.c = new CopyOnWriteArraySet();
        nativeAndroidCamera.addListenerAsync(new FrameSourceListenerReversedAdapter(new a(this), this, null, 4));
        this.d = TorchState.OFF;
    }

    @Override
    public final NativeFrameSource _frameSourceImpl() {
        return this.f.a;
    }

    public final void switchToDesiredState(FrameSourceState frameSourceState) {
        Intrinsics.checkNotNullParameter((Object)((Object)frameSourceState), (String)"desiredState");
        Intrinsics.checkNotNullParameter((Object)((Object)frameSourceState), (String)"desiredState");
        AndroidCameraProxyAdapter androidCameraProxyAdapter = this.f;
        Objects.requireNonNull((Object)androidCameraProxyAdapter);
        Intrinsics.checkNotNullParameter((Object)((Object)frameSourceState), (String)"desiredState");
        Intrinsics.checkNotNullParameter((Object)((Object)frameSourceState), (String)"desiredState");
        Intrinsics.checkNotNullParameter((Object)androidCameraProxyAdapter._switchToDesiredState(frameSourceState), (String)"$this$andThen");
    }

    public static final class a
    implements FrameSourceListener {
        public final WeakReference<Camera> a;

        public a(Camera camera) {
            Intrinsics.checkNotNullParameter((Object)camera, (String)"owner");
            this.a = new WeakReference((Object)camera);
        }

        @Override
        public final void onFrameOutput(FrameSource frameSource, FrameData frameData) {
            CopyOnWriteArraySet<FrameSourceListener> copyOnWriteArraySet;
            Intrinsics.checkNotNullParameter((Object)frameSource, (String)"frameSource");
            Intrinsics.checkNotNullParameter((Object)frameData, (String)"frame");
            Camera camera = (Camera)this.a.get();
            if (camera != null && (copyOnWriteArraySet = camera.a) != null) {
                Iterator iterator = copyOnWriteArraySet.iterator();
                while (iterator.hasNext()) {
                    ((FrameSourceListener)iterator.next()).onFrameOutput(frameSource, frameData);
                }
            }
        }

        @Override
        public final void onObservationStarted(FrameSource frameSource) {
            Intrinsics.checkNotNullParameter((Object)frameSource, (String)"frameSource");
            Intrinsics.checkNotNullParameter((Object)frameSource, (String)"frameSource");
        }

        @Override
        public final void onObservationStopped(FrameSource frameSource) {
            Intrinsics.checkNotNullParameter((Object)frameSource, (String)"frameSource");
            Intrinsics.checkNotNullParameter((Object)frameSource, (String)"frameSource");
        }

        @Override
        public final void onStateChanged(FrameSource frameSource, FrameSourceState frameSourceState) {
            CopyOnWriteArraySet<FrameSourceListener> copyOnWriteArraySet;
            Intrinsics.checkNotNullParameter((Object)frameSource, (String)"frameSource");
            Intrinsics.checkNotNullParameter((Object)((Object)frameSourceState), (String)"newState");
            Camera camera = (Camera)this.a.get();
            if (camera != null && (copyOnWriteArraySet = camera.a) != null) {
                Iterator iterator = copyOnWriteArraySet.iterator();
                while (iterator.hasNext()) {
                    ((FrameSourceListener)iterator.next()).onStateChanged(frameSource, frameSourceState);
                }
            }
        }
    }

}

