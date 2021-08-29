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
public final class SizingMode
extends Enum<SizingMode> {
    public static final /* enum */ SizingMode HEIGHT_AND_ASPECT_RATIO;
    public static final /* enum */ SizingMode SHORTER_DIMENSION_AND_ASPECT_RATIO;
    public static final /* enum */ SizingMode WIDTH_AND_ASPECT_RATIO;
    public static final /* enum */ SizingMode WIDTH_AND_HEIGHT;
    private static final /* synthetic */ SizingMode[] a;

    public static {
        SizingMode sizingMode;
        SizingMode sizingMode2;
        SizingMode sizingMode3;
        SizingMode sizingMode4;
        WIDTH_AND_HEIGHT = sizingMode3 = new SizingMode();
        WIDTH_AND_ASPECT_RATIO = sizingMode4 = new SizingMode();
        HEIGHT_AND_ASPECT_RATIO = sizingMode2 = new SizingMode();
        SHORTER_DIMENSION_AND_ASPECT_RATIO = sizingMode = new SizingMode();
        a = new SizingMode[]{sizingMode3, sizingMode4, sizingMode2, sizingMode};
    }

    public static SizingMode valueOf(String string) {
        return (SizingMode)Enum.valueOf(SizingMode.class, (String)string);
    }

    public static SizingMode[] values() {
        return (SizingMode[])a.clone();
    }
}

