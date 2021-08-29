/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.serialization.NativeStructSerializer$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.common.buffer.EncodingRange;
import com.scandit.datacapture.core.common.geometry.FloatWithUnit;
import com.scandit.datacapture.core.common.geometry.MarginsWithUnit;
import com.scandit.datacapture.core.common.geometry.Point;
import com.scandit.datacapture.core.common.geometry.PointWithUnit;
import com.scandit.datacapture.core.common.geometry.Quadrilateral;
import com.scandit.datacapture.core.common.geometry.Rect;
import com.scandit.datacapture.core.common.geometry.RectWithUnit;
import com.scandit.datacapture.core.common.geometry.SizeWithAspect;
import com.scandit.datacapture.core.common.geometry.SizeWithUnit;
import com.scandit.datacapture.core.internal.module.serialization.NativeStructSerializer;
import com.scandit.datacapture.core.internal.sdk.common.NativeContextStatus;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeStructSerializer {
    public NativeStructSerializer() {
    }

    public static String contextStatusToJson(NativeContextStatus nativeContextStatus) {
        return CppProxy.contextStatusToJson((NativeContextStatus)nativeContextStatus);
    }

    public static String encodingRangeToJson(EncodingRange encodingRange) {
        return CppProxy.encodingRangeToJson((EncodingRange)encodingRange);
    }

    public static String floatWithUnitToJson(FloatWithUnit floatWithUnit) {
        return CppProxy.floatWithUnitToJson((FloatWithUnit)floatWithUnit);
    }

    public static String marginsWithUnitToJson(MarginsWithUnit marginsWithUnit) {
        return CppProxy.marginsWithUnitToJson((MarginsWithUnit)marginsWithUnit);
    }

    public static String pointToJson(Point point) {
        return CppProxy.pointToJson((Point)point);
    }

    public static String pointWithUnitToJson(PointWithUnit pointWithUnit) {
        return CppProxy.pointWithUnitToJson((PointWithUnit)pointWithUnit);
    }

    public static String quadrilateralToJson(Quadrilateral quadrilateral) {
        return CppProxy.quadrilateralToJson((Quadrilateral)quadrilateral);
    }

    public static String rectToJson(Rect rect) {
        return CppProxy.rectToJson((Rect)rect);
    }

    public static String rectWithUnitToJson(RectWithUnit rectWithUnit) {
        return CppProxy.rectWithUnitToJson((RectWithUnit)rectWithUnit);
    }

    public static String sizeWithAspectToJson(SizeWithAspect sizeWithAspect) {
        return CppProxy.sizeWithAspectToJson((SizeWithAspect)sizeWithAspect);
    }

    public static String sizeWithUnitToJson(SizeWithUnit sizeWithUnit) {
        return CppProxy.sizeWithUnitToJson((SizeWithUnit)sizeWithUnit);
    }
}

