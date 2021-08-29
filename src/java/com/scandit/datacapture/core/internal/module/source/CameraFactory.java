/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.core.internal.module.source.CameraFactory$a
 *  com.scandit.datacapture.core.internal.module.source.CameraFactory$b
 *  com.scandit.datacapture.core.source.Camera
 *  java.lang.Boolean
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.json.JSONObject
 */
package com.scandit.datacapture.core.internal.module.source;

import com.google.android.material.R;
import com.scandit.datacapture.core.common.geometry.Point;
import com.scandit.datacapture.core.internal.module.serialization.NativeEnumDeserializer;
import com.scandit.datacapture.core.internal.module.serialization.NativeEnumSerializer;
import com.scandit.datacapture.core.internal.module.source.CameraFactory;
import com.scandit.datacapture.core.internal.module.source.NativeCameraApi;
import com.scandit.datacapture.core.internal.module.source.NativeCameraDelegate;
import com.scandit.datacapture.core.internal.module.source.NativeCameraSettings;
import com.scandit.datacapture.core.internal.module.source.NativeFocusSettings;
import com.scandit.datacapture.core.internal.module.source.NativeFocusStrategy;
import com.scandit.datacapture.core.internal.module.source.NativeNoiseReduction;
import com.scandit.datacapture.core.internal.module.source.NativeRegionStrategy;
import com.scandit.datacapture.core.internal.module.source.NativeTonemapCurve;
import com.scandit.datacapture.core.internal.module.source.ab;
import com.scandit.datacapture.core.internal.module.source.w;
import com.scandit.datacapture.core.internal.module.source.x;
import com.scandit.datacapture.core.internal.module.source.y;
import com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedFuture;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.core.internal.sdk.source.NativeAndroidCamera;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameData;
import com.scandit.datacapture.core.source.AndroidCameraProxyAdapter;
import com.scandit.datacapture.core.source.Camera;
import com.scandit.datacapture.core.source.CameraPosition;
import com.scandit.datacapture.core.source.CameraSettings;
import com.scandit.datacapture.core.source.FocusGestureStrategy;
import com.scandit.datacapture.core.source.FrameSourceState;
import com.scandit.datacapture.core.source.VideoResolution;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class CameraFactory {
    public final Map<CameraPosition, Camera> a;
    public final com.scandit.datacapture.core.internal.module.b.a.a.b b;
    public final Map<NativeCameraApi, w> c;

    public CameraFactory(com.scandit.datacapture.core.internal.module.b.a.a.b b2, Map<NativeCameraApi, ? extends w> map) {
        Intrinsics.checkNotNullParameter((Object)b2, (String)"cameraProfile");
        Intrinsics.checkNotNullParameter(map, (String)"cameraDelegateFactories");
        this.b = b2;
        this.c = map;
        this.a = new LinkedHashMap();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Camera a(CameraPosition cameraPosition, CameraSettings cameraSettings) {
        NativeTonemapCurve nativeTonemapCurve;
        String string;
        Boolean bl;
        Integer n2;
        String string2;
        Camera camera;
        NativeNoiseReduction nativeNoiseReduction;
        Boolean bl2;
        Intrinsics.checkNotNullParameter((Object)((Object)cameraPosition), (String)"position");
        int n3 = x.a[cameraPosition.ordinal()];
        if (n3 != 1) {
            if (n3 != 2) {
                if (n3 != 3) throw new NoWhenBranchMatchedException();
                return null;
            }
            camera = this.b(CameraPosition.WORLD_FACING, cameraSettings);
        } else {
            camera = this.b(CameraPosition.USER_FACING, cameraSettings);
        }
        if (camera == null) return null;
        if (cameraSettings == null) return camera;
        Intrinsics.checkNotNullParameter((Object)cameraSettings, (String)"settings");
        Intrinsics.checkNotNullParameter((Object)cameraSettings, (String)"settings");
        AndroidCameraProxyAdapter androidCameraProxyAdapter = camera.f;
        Objects.requireNonNull((Object)androidCameraProxyAdapter);
        Intrinsics.checkNotNullParameter((Object)cameraSettings, (String)"settings");
        Intrinsics.checkNotNullParameter((Object)cameraSettings, (String)"source");
        HashMap<String, Object> hashMap = cameraSettings.b;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (!(true ^ y.b.contains(entry.getKey()))) continue;
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        Object object = R.style.b((Object)linkedHashMap);
        Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type org.json.JSONObject");
        String string3 = ((JSONObject)object).toString(0);
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"(jsonObjectFromObject(ob\u2026s JSONObject).toString(0)");
        NativeJsonValue nativeJsonValue = NativeJsonValue.fromString(string3);
        VideoResolution videoResolution = cameraSettings.e;
        Float f2 = cameraSettings.a("minFrameRate");
        float f3 = f2 != null ? f2.floatValue() : 15.0f;
        float f4 = f3;
        Float f5 = cameraSettings.a("manualLensPosition");
        float f6 = f5 != null ? f5.floatValue() : -1.0f;
        float f7 = f6;
        Object object2 = cameraSettings.getProperty("focusStrategy");
        if (!(object2 instanceof String)) {
            object2 = null;
        }
        if ((string2 = (String)object2) == null) {
            string2 = ab.a(NativeFocusStrategy.AUTO);
        }
        Intrinsics.checkNotNullParameter((Object)string2, (String)"json");
        NativeFocusStrategy nativeFocusStrategy = NativeEnumDeserializer.focusStrategyFromJsonString(string2);
        Intrinsics.checkNotNullExpressionValue((Object)((Object)nativeFocusStrategy), (String)"NativeEnumDeserializer.f\u2026ategyFromJsonString(json)");
        NativeFocusSettings nativeFocusSettings = new NativeFocusSettings(f7, nativeFocusStrategy, false, nativeJsonValue, null, cameraSettings.h);
        Object object3 = cameraSettings.getProperty("api");
        if (!(object3 instanceof Integer)) {
            object3 = null;
        }
        int n4 = (n2 = (Integer)object3) != null ? n2 : 0;
        Object object4 = cameraSettings.getProperty("overwriteWithHighestResolution");
        if (!(object4 instanceof Boolean)) {
            object4 = null;
        }
        boolean bl3 = (bl2 = (Boolean)object4) != null ? bl2 : false;
        Float f8 = cameraSettings.a("exposureTargetBias");
        float f9 = f8 != null ? f8.floatValue() : 0.0f;
        float f10 = f9;
        Object object5 = cameraSettings.getProperty("colorCorrection");
        if (!(object5 instanceof Boolean)) {
            object5 = null;
        }
        boolean bl4 = (bl = (Boolean)object5) != null ? bl : true;
        boolean bl5 = bl4;
        Object object6 = cameraSettings.getProperty("toneMappingCurve");
        if (!(object6 instanceof NativeTonemapCurve)) {
            object6 = null;
        }
        if ((nativeTonemapCurve = (NativeTonemapCurve)((Object)object6)) == null) {
            nativeTonemapCurve = NativeTonemapCurve.NONE;
        }
        NativeTonemapCurve nativeTonemapCurve2 = nativeTonemapCurve;
        Object object7 = cameraSettings.getProperty("noiseReductionMode");
        if (!(object7 instanceof NativeNoiseReduction)) {
            object7 = null;
        }
        if ((nativeNoiseReduction = (NativeNoiseReduction)((Object)object7)) == null) {
            nativeNoiseReduction = NativeNoiseReduction.OFF;
        }
        NativeNoiseReduction nativeNoiseReduction2 = nativeNoiseReduction;
        Object object8 = cameraSettings.getProperty("regionStrategy");
        if (!(object8 instanceof String)) {
            object8 = null;
        }
        if ((string = (String)object8) == null) {
            NativeRegionStrategy nativeRegionStrategy = NativeRegionStrategy.DEFAULT;
            Intrinsics.checkNotNullParameter((Object)((Object)nativeRegionStrategy), (String)"regionStrategy");
            Intrinsics.checkNotNullParameter((Object)((Object)nativeRegionStrategy), (String)"$this$toJson");
            string = NativeEnumSerializer.regionStrategyToString(nativeRegionStrategy);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"NativeEnumSerializer.regionStrategyToString(this)");
        }
        Intrinsics.checkNotNullParameter((Object)string, (String)"json");
        NativeRegionStrategy nativeRegionStrategy = NativeEnumDeserializer.regionStrategyFromJsonString(string);
        Intrinsics.checkNotNullExpressionValue((Object)((Object)nativeRegionStrategy), (String)"NativeEnumDeserializer.r\u2026ategyFromJsonString(json)");
        NativeCameraSettings nativeCameraSettings = new NativeCameraSettings(videoResolution, f4, 30.0f, 1.0f, 2.0f, nativeFocusSettings, n4, bl3, f10, bl5, nativeTonemapCurve2, nativeNoiseReduction2, nativeRegionStrategy, 1.0f, nativeJsonValue);
        NativeWrappedFuture nativeWrappedFuture = androidCameraProxyAdapter.b.applySettingsAsyncAndroid(nativeCameraSettings);
        Intrinsics.checkNotNullExpressionValue((Object)nativeWrappedFuture, (String)"_1");
        R.style.andThen((NativeWrappedFuture)nativeWrappedFuture, null);
        return camera;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Camera b(CameraPosition cameraPosition, CameraSettings cameraSettings) {
        CameraFactory cameraFactory = this;
        synchronized (cameraFactory) {
            Camera camera;
            NativeCameraApi nativeCameraApi;
            block18 : {
                Camera camera2;
                block19 : {
                    Object object;
                    int n2;
                    block20 : {
                        block17 : {
                            camera = (Camera)this.a.get((Object)cameraPosition);
                            Map<NativeCameraApi, w> map = this.c;
                            nativeCameraApi = NativeCameraApi.CAMERA2;
                            if (map.get((Object)nativeCameraApi) != null) break block17;
                            nativeCameraApi = NativeCameraApi.CAMERA1;
                            break block18;
                        }
                        if (cameraSettings == null) break block19;
                        object = cameraSettings.getProperty("api");
                        if (!Intrinsics.areEqual((Object)object, (Object)(n2 = 1))) break block20;
                        nativeCameraApi = NativeCameraApi.CAMERA1;
                        break block18;
                    }
                    if (Intrinsics.areEqual((Object)object, (Object)2)) break block18;
                    Float f2 = cameraSettings.a("manualLensPosition");
                    float f3 = f2 != null ? f2.floatValue() : -1.0f;
                    if (!(f3 >= 0.0f) && cameraSettings.e != VideoResolution.UHD4K) {
                        n2 = 0;
                    }
                    if (n2 != 0 && this.b.d()) break block18;
                }
                if ((camera2 = (Camera)this.a.get((Object)cameraPosition)) != null) {
                    nativeCameraApi = camera2.f.b.getApi();
                    Intrinsics.checkNotNullExpressionValue((Object)((Object)nativeCameraApi), (String)"_impl().api");
                } else {
                    nativeCameraApi = this.b.c();
                }
            }
            if (camera != null) {
                NativeCameraApi nativeCameraApi2 = camera.f.b.getApi();
                Intrinsics.checkNotNullExpressionValue((Object)((Object)nativeCameraApi2), (String)"_impl().api");
                if (nativeCameraApi2 == nativeCameraApi) return (Camera)this.a.get((Object)cameraPosition);
            }
            b b2 = new b(this, cameraPosition);
            a a2 = new a(this, cameraPosition);
            w w2 = (w)this.c.get((Object)nativeCameraApi);
            if (w2 == null) {
                return null;
            }
            NativeCameraDelegate nativeCameraDelegate = w2.a(cameraPosition, cameraSettings, (Function1<? super NativeCameraFrameData, Unit>)b2, (Function1<? super FrameSourceState, Unit>)a2);
            if (nativeCameraDelegate == null) {
                return null;
            }
            if (camera == null) {
                Map<CameraPosition, Camera> map = this.a;
                Intrinsics.checkNotNullParameter((Object)nativeCameraDelegate, (String)"delegate");
                NativeAndroidCamera nativeAndroidCamera = NativeAndroidCamera.create(nativeCameraDelegate, nativeCameraDelegate.getCameraPosition());
                Intrinsics.checkNotNullExpressionValue((Object)nativeAndroidCamera, (String)"NativeAndroidCamera.crea\u2026 delegate.cameraPosition)");
                map.put((Object)cameraPosition, (Object)new Camera(nativeAndroidCamera));
                return (Camera)this.a.get((Object)cameraPosition);
            } else {
                camera.f.b.setDelegate(nativeCameraDelegate);
            }
            return (Camera)this.a.get((Object)cameraPosition);
        }
    }
}

