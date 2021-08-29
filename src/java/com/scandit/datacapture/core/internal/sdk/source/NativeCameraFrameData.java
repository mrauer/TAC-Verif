/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameData$CppProxy
 *  java.lang.Float
 *  java.lang.Object
 *  java.util.HashMap
 */
package com.scandit.datacapture.core.internal.sdk.source;

import com.scandit.datacapture.core.internal.module.common.geometry.NativeAxis;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraCaptureParameterKey;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameData;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameDataPool;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.HashMap;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeCameraFrameData {
    public NativeCameraFrameData() {
    }

    public static NativeCameraFrameData create(int n2, int n3, byte[] arrby, NativeCameraFrameDataPool nativeCameraFrameDataPool, int n4, NativeAxis nativeAxis, HashMap<NativeCameraCaptureParameterKey, Float> hashMap) {
        return CppProxy.create((int)n2, (int)n3, (byte[])arrby, (NativeCameraFrameDataPool)nativeCameraFrameDataPool, (int)n4, (NativeAxis)nativeAxis, hashMap);
    }

    public static NativeCameraFrameData createFromArgbBuffer(int n2, int n3, byte[] arrby, NativeCameraFrameDataPool nativeCameraFrameDataPool, int n4, NativeAxis nativeAxis, int n5, HashMap<NativeCameraCaptureParameterKey, Float> hashMap) {
        return CppProxy.createFromArgbBuffer((int)n2, (int)n3, (byte[])arrby, (NativeCameraFrameDataPool)nativeCameraFrameDataPool, (int)n4, (NativeAxis)nativeAxis, (int)n5, hashMap);
    }

    public static NativeCameraFrameData createFromNv21Buffer(int n2, int n3, byte[] arrby, NativeCameraFrameDataPool nativeCameraFrameDataPool, int n4, NativeAxis nativeAxis, HashMap<NativeCameraCaptureParameterKey, Float> hashMap) {
        return CppProxy.createFromNv21Buffer((int)n2, (int)n3, (byte[])arrby, (NativeCameraFrameDataPool)nativeCameraFrameDataPool, (int)n4, (NativeAxis)nativeAxis, hashMap);
    }

    public static NativeCameraFrameData createFromYuv420Buffer(int n2, int n3, byte[] arrby, NativeCameraFrameDataPool nativeCameraFrameDataPool, int n4, NativeAxis nativeAxis, HashMap<NativeCameraCaptureParameterKey, Float> hashMap) {
        return CppProxy.createFromYuv420Buffer((int)n2, (int)n3, (byte[])arrby, (NativeCameraFrameDataPool)nativeCameraFrameDataPool, (int)n4, (NativeAxis)nativeAxis, hashMap);
    }

    public static byte[] getByteBuffer(NativeFrameData nativeFrameData) {
        return CppProxy.getByteBuffer((NativeFrameData)nativeFrameData);
    }

    public abstract NativeFrameData asFrameData();

    public abstract void release();

    public abstract void retain();

    public abstract byte[] takeBuffer();
}

