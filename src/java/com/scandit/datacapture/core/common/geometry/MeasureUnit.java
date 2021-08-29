/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.common.geometry;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class MeasureUnit
extends Enum<MeasureUnit> {
    public static final /* enum */ MeasureUnit DIP;
    public static final /* enum */ MeasureUnit FRACTION;
    public static final /* enum */ MeasureUnit PIXEL;
    private static final /* synthetic */ MeasureUnit[] a;

    public static {
        MeasureUnit measureUnit;
        MeasureUnit measureUnit2;
        MeasureUnit measureUnit3;
        PIXEL = measureUnit2 = new MeasureUnit();
        DIP = measureUnit = new MeasureUnit();
        FRACTION = measureUnit3 = new MeasureUnit();
        a = new MeasureUnit[]{measureUnit2, measureUnit, measureUnit3};
    }

    public static MeasureUnit valueOf(String string) {
        return (MeasureUnit)Enum.valueOf(MeasureUnit.class, (String)string);
    }

    public static MeasureUnit[] values() {
        return (MeasureUnit[])a.clone();
    }
}

