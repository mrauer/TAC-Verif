/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.util.Range
 *  android.util.Rational
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.source;

import android.annotation.TargetApi;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import android.util.Rational;
import kotlin.jvm.internal.Intrinsics;

@TargetApi(value=21)
public final class v {
    public final CameraCharacteristics a;

    public v(CameraCharacteristics cameraCharacteristics) {
        Intrinsics.checkNotNullParameter((Object)cameraCharacteristics, (String)"cameraCharacteristics");
        this.a = cameraCharacteristics;
    }

    public final int b() {
        Integer n2 = (Integer)this.a.get(CameraCharacteristics.LENS_FACING);
        if (n2 != null) {
            return n2;
        }
        return 1;
    }

    public final int c() {
        Integer n2 = (Integer)this.a.get(CameraCharacteristics.SENSOR_ORIENTATION);
        if (n2 != null) {
            return n2;
        }
        return 0;
    }

    public final float j() {
        Float f2 = (Float)this.a.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
        if (f2 != null) {
            return f2.floatValue();
        }
        return 0.0f;
    }

    public final float k() {
        Float f2 = (Float)this.a.get(CameraCharacteristics.LENS_INFO_HYPERFOCAL_DISTANCE);
        if (f2 != null) {
            return f2.floatValue();
        }
        return 0.0f;
    }

    public final Range<Integer>[] n() {
        Range[] arrrange = (Range[])this.a.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (arrrange == null) {
            arrrange = new Range[]{};
        }
        return arrrange;
    }

    public final Range<Integer> o() {
        Range range = (Range)this.a.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        if (range != null) {
            return range;
        }
        throw new IllegalArgumentException("Exposure compensation range should be non-null on all devices.".toString());
    }

    public final Rational p() {
        Rational rational = (Rational)this.a.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        if (rational != null) {
            return rational;
        }
        throw new IllegalArgumentException("Exposure compensation step should be non-null on all devices.".toString());
    }
}

