/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.ui.viewfinder;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class RectangularViewfinderStyle
extends Enum<RectangularViewfinderStyle> {
    public static final /* enum */ RectangularViewfinderStyle LEGACY;
    public static final /* enum */ RectangularViewfinderStyle ROUNDED;
    public static final /* enum */ RectangularViewfinderStyle SQUARE;
    private static final /* synthetic */ RectangularViewfinderStyle[] a;

    public static {
        RectangularViewfinderStyle rectangularViewfinderStyle;
        RectangularViewfinderStyle rectangularViewfinderStyle2;
        RectangularViewfinderStyle rectangularViewfinderStyle3;
        LEGACY = rectangularViewfinderStyle2 = new RectangularViewfinderStyle();
        SQUARE = rectangularViewfinderStyle = new RectangularViewfinderStyle();
        ROUNDED = rectangularViewfinderStyle3 = new RectangularViewfinderStyle();
        a = new RectangularViewfinderStyle[]{rectangularViewfinderStyle2, rectangularViewfinderStyle, rectangularViewfinderStyle3};
    }

    public static RectangularViewfinderStyle valueOf(String string) {
        return (RectangularViewfinderStyle)Enum.valueOf(RectangularViewfinderStyle.class, (String)string);
    }

    public static RectangularViewfinderStyle[] values() {
        return (RectangularViewfinderStyle[])a.clone();
    }
}

