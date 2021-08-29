/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.CaptureResult
 *  android.hardware.camera2.CaptureResult$Key
 *  android.hardware.camera2.TotalCaptureResult
 *  android.media.Image
 *  android.media.Image$Plane
 *  com.scandit.datacapture.core.internal.module.source.p$c
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.HashMap
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Stack
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.source;

import android.annotation.TargetApi;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import com.scandit.datacapture.core.internal.module.common.geometry.NativeAxis;
import com.scandit.datacapture.core.internal.module.source.p;
import com.scandit.datacapture.core.internal.module.source.z;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraCaptureParameterKey;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameData;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameDataPool;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/*
 * Exception performing whole class analysis.
 */
@TargetApi(value=21)
public final class p {
    public final a a;
    public final c b;
    public final Map<NativeCameraFrameData, NativeFrameData> c;

    public p() {
        this.a = new a(3);
        this.b = new /* Unavailable Anonymous Inner Class!! */;
        this.c = new LinkedHashMap();
    }

    public final NativeCameraFrameData a(Image image, TotalCaptureResult totalCaptureResult, int n2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)image, (String)"image");
        boolean bl2 = this.a.a.size() == 0;
        if (!bl2) {
            HashMap hashMap;
            int n3;
            int n4 = image.getWidth();
            int n5 = image.getHeight();
            Image.Plane plane = image.getPlanes()[0];
            Intrinsics.checkNotNullExpressionValue((Object)plane, (String)"planes[0]");
            ByteBuffer byteBuffer = plane.getBuffer();
            Image.Plane plane2 = image.getPlanes()[1];
            Intrinsics.checkNotNullExpressionValue((Object)plane2, (String)"planes[1]");
            ByteBuffer byteBuffer2 = plane2.getBuffer();
            Image.Plane plane3 = image.getPlanes()[2];
            Intrinsics.checkNotNullExpressionValue((Object)plane3, (String)"planes[2]");
            ByteBuffer byteBuffer3 = plane3.getBuffer();
            int n6 = byteBuffer.remaining();
            int n7 = byteBuffer2.remaining();
            int n8 = byteBuffer3.remaining();
            a a2 = this.a;
            int n9 = n8 + (n6 + n7);
            byte[] arrby = (byte[])a2.a.pop();
            if (arrby.length != n9) {
                arrby = new byte[n9];
            }
            Intrinsics.checkNotNullExpressionValue((Object)arrby, (String)"byteArray");
            byteBuffer.get(arrby, 0, n6);
            byteBuffer3.get(arrby, n6, n8);
            byteBuffer2.get(arrby, n6 + n8, n7);
            c c2 = this.b;
            NativeAxis nativeAxis = bl ? NativeAxis.Y : NativeAxis.NONE;
            NativeAxis nativeAxis2 = nativeAxis;
            if (totalCaptureResult != null) {
                Float f2;
                Integer n10;
                int n11;
                Float f3;
                Long l2;
                Integer n12;
                Float f4;
                Intrinsics.checkNotNullParameter((Object)totalCaptureResult, (String)"$this$extractCaptureParameters");
                HashMap hashMap2 = new HashMap();
                Long l3 = (Long)totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
                n3 = n4;
                Float f5 = l3 != null ? Float.valueOf((float)((float)(1.0E-9 * (double)l3.longValue()))) : null;
                if (f5 != null) {
                    float f6 = f5.floatValue();
                    hashMap2.put((Object)NativeCameraCaptureParameterKey.EXPOSURE_TIME, (Object)Float.valueOf((float)f6));
                }
                if ((f3 = (Float)totalCaptureResult.get(CaptureResult.LENS_APERTURE)) != null) {
                    float f7 = f3.floatValue();
                    hashMap2.put((Object)NativeCameraCaptureParameterKey.F_NUMBER, (Object)Float.valueOf((float)f7));
                }
                if ((n12 = (Integer)totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE)) == null) {
                    n11 = z.a;
                } else {
                    Intrinsics.checkNotNullExpressionValue((Object)n12, (String)"get(CaptureResult.CONTRO\u2026eturn FocusState.INACTIVE");
                    int n13 = n12;
                    if (n13 != 0) {
                        n11 = n13 != 3 ? (n13 != 4 ? (n13 != 5 ? z.a : z.d) : z.c) : z.b;
                    } else {
                        Integer n14 = (Integer)totalCaptureResult.getRequest().get(CaptureRequest.CONTROL_AF_MODE);
                        Integer n15 = (Integer)totalCaptureResult.get(CaptureResult.LENS_STATE);
                        Float f8 = (Float)totalCaptureResult.get(CaptureResult.LENS_FOCUS_DISTANCE);
                        Float f9 = (Float)totalCaptureResult.getRequest().get(CaptureRequest.LENS_FOCUS_DISTANCE);
                        n11 = n14 != null && n15 != null && f8 != null && f9 != null ? (n14 != 0 ? z.a : (n15 == 1 ? z.b : (Math.abs((float)(f9.floatValue() - f8.floatValue())) < 0.05f ? z.e : z.f))) : z.f;
                    }
                }
                Float f10 = n11 == z.e ? (Float)totalCaptureResult.getRequest().get(CaptureRequest.LENS_FOCUS_DISTANCE) : (Float)totalCaptureResult.get(CaptureResult.LENS_FOCUS_DISTANCE);
                if (f10 != null) {
                    float f11 = f10.floatValue();
                    hashMap2.put((Object)NativeCameraCaptureParameterKey.FOCUS_DISTANCE, (Object)Float.valueOf((float)f11));
                }
                if ((f2 = (n10 = (Integer)totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY)) != null ? Float.valueOf((float)n10.intValue()) : null) != null) {
                    float f12 = f2.floatValue();
                    hashMap2.put((Object)NativeCameraCaptureParameterKey.ISO, (Object)Float.valueOf((float)f12));
                }
                if ((f4 = (l2 = (Long)totalCaptureResult.get(CaptureResult.SENSOR_ROLLING_SHUTTER_SKEW)) != null ? Float.valueOf((float)((float)(1.0E-9 * (double)l2.longValue()))) : null) != null) {
                    float f13 = f4.floatValue();
                    hashMap2.put((Object)NativeCameraCaptureParameterKey.ROLLING_SHUTTER_SKEW, (Object)Float.valueOf((float)f13));
                }
                hashMap = hashMap2;
            } else {
                n3 = n4;
                hashMap = new HashMap();
            }
            NativeCameraFrameData nativeCameraFrameData = NativeCameraFrameData.create(n3, n5, arrby, (NativeCameraFrameDataPool)c2, n2, nativeAxis2, (HashMap<NativeCameraCaptureParameterKey, Float>)hashMap);
            Map<NativeCameraFrameData, NativeFrameData> map = this.c;
            Intrinsics.checkNotNullExpressionValue((Object)nativeCameraFrameData, (String)"it");
            NativeFrameData nativeFrameData = nativeCameraFrameData.asFrameData();
            Intrinsics.checkNotNullExpressionValue((Object)nativeFrameData, (String)"it.asFrameData()");
            map.put((Object)nativeCameraFrameData, (Object)nativeFrameData);
            return nativeCameraFrameData;
        }
        return null;
    }

    public static final class a {
        public final Stack<byte[]> a;

        public a(int n2) {
            Stack stack = new Stack();
            for (int i2 = 0; i2 < 3; ++i2) {
                stack.push((Object)new byte[0]);
            }
            this.a = stack;
        }
    }

}

