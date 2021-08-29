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
public final class LaserlineViewfinderStyle
extends Enum<LaserlineViewfinderStyle> {
    public static final /* enum */ LaserlineViewfinderStyle ANIMATED;
    public static final /* enum */ LaserlineViewfinderStyle LEGACY;
    private static final /* synthetic */ LaserlineViewfinderStyle[] a;

    public static {
        LaserlineViewfinderStyle laserlineViewfinderStyle;
        LaserlineViewfinderStyle laserlineViewfinderStyle2;
        LEGACY = laserlineViewfinderStyle = new LaserlineViewfinderStyle();
        ANIMATED = laserlineViewfinderStyle2 = new LaserlineViewfinderStyle();
        a = new LaserlineViewfinderStyle[]{laserlineViewfinderStyle, laserlineViewfinderStyle2};
    }

    public static LaserlineViewfinderStyle valueOf(String string) {
        return (LaserlineViewfinderStyle)Enum.valueOf(LaserlineViewfinderStyle.class, (String)string);
    }

    public static LaserlineViewfinderStyle[] values() {
        return (LaserlineViewfinderStyle[])a.clone();
    }
}

