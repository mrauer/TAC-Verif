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
public final class RectangularViewfinderLineStyle
extends Enum<RectangularViewfinderLineStyle> {
    public static final /* enum */ RectangularViewfinderLineStyle BOLD;
    public static final /* enum */ RectangularViewfinderLineStyle LIGHT;
    private static final /* synthetic */ RectangularViewfinderLineStyle[] a;

    public static {
        RectangularViewfinderLineStyle rectangularViewfinderLineStyle;
        RectangularViewfinderLineStyle rectangularViewfinderLineStyle2;
        BOLD = rectangularViewfinderLineStyle = new RectangularViewfinderLineStyle();
        LIGHT = rectangularViewfinderLineStyle2 = new RectangularViewfinderLineStyle();
        a = new RectangularViewfinderLineStyle[]{rectangularViewfinderLineStyle, rectangularViewfinderLineStyle2};
    }

    public static RectangularViewfinderLineStyle valueOf(String string) {
        return (RectangularViewfinderLineStyle)Enum.valueOf(RectangularViewfinderLineStyle.class, (String)string);
    }

    public static RectangularViewfinderLineStyle[] values() {
        return (RectangularViewfinderLineStyle[])a.clone();
    }
}

