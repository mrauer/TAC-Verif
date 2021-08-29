/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.params.StreamConfigurationMap
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Range
 *  android.util.Size
 *  android.util.SizeF
 *  java.lang.Comparable
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Set
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.source;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import com.scandit.datacapture.core.internal.module.source.q;
import com.scandit.datacapture.core.internal.module.source.v;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

public final class ae
implements q {
    public final v a;
    public final int b;
    public final String h;

    public ae(String string, CameraCharacteristics cameraCharacteristics) {
        float[] arrf;
        v v2;
        Intrinsics.checkNotNullParameter((Object)string, (String)"id");
        Intrinsics.checkNotNullParameter((Object)cameraCharacteristics, (String)"characteristics");
        this.h = string;
        this.a = v2 = new v(cameraCharacteristics);
        this.b = v2.b();
        if (Build.VERSION.SDK_INT >= 28) {
            Intrinsics.checkNotNullExpressionValue((Object)v2.a.getPhysicalCameraIds(), (String)"cameraCharacteristics.physicalCameraIds");
        }
        if ((arrf = (float[])v2.a.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS)) != null) {
            for (float f2 : arrf) {
                SizeF sizeF = (SizeF)v2.a.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
                if (sizeF == null) continue;
                Intrinsics.checkNotNullExpressionValue((Object)sizeF, (String)"size");
                Math.atan((double)((double)sizeF.getWidth() / (2.0 * (double)f2)));
                break;
            }
        }
        if ((Range)this.a.a.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE) == null) {
            new Range((Comparable)Long.valueOf((long)0L), (Comparable)Long.valueOf((long)0L));
        }
        (Range[])this.a.a.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap)this.a.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            streamConfigurationMap.getOutputSizes(35);
        }
    }

    @Override
    public final String a() {
        return this.h;
    }

    @Override
    public final Integer b() {
        return this.b;
    }
}

