/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$CameraInfo
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.module.source;

import android.hardware.Camera;
import com.scandit.datacapture.core.internal.module.source.f;
import java.util.ArrayList;

public final class ad
implements f {
    public static final ad a = new ad();

    @Override
    public final Iterable<Camera.CameraInfo> a() {
        int n2 = Camera.getNumberOfCameras();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < n2; ++i2) {
            try {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo((int)i2, (Camera.CameraInfo)cameraInfo);
                arrayList.add((Object)cameraInfo);
                continue;
            }
            catch (RuntimeException runtimeException) {
                runtimeException.printStackTrace();
            }
        }
        return arrayList;
    }
}

