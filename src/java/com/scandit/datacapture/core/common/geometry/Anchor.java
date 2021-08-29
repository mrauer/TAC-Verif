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
public final class Anchor
extends Enum<Anchor> {
    public static final /* enum */ Anchor BOTTOM_CENTER;
    public static final /* enum */ Anchor BOTTOM_LEFT;
    public static final /* enum */ Anchor BOTTOM_RIGHT;
    public static final /* enum */ Anchor CENTER;
    public static final /* enum */ Anchor CENTER_LEFT;
    public static final /* enum */ Anchor CENTER_RIGHT;
    public static final /* enum */ Anchor TOP_CENTER;
    public static final /* enum */ Anchor TOP_LEFT;
    public static final /* enum */ Anchor TOP_RIGHT;
    private static final /* synthetic */ Anchor[] a;

    public static {
        Anchor anchor;
        Anchor anchor2;
        Anchor anchor3;
        Anchor anchor4;
        Anchor anchor5;
        Anchor anchor6;
        Anchor anchor7;
        Anchor anchor8;
        Anchor anchor9;
        TOP_LEFT = anchor8 = new Anchor();
        TOP_CENTER = anchor6 = new Anchor();
        TOP_RIGHT = anchor7 = new Anchor();
        CENTER_LEFT = anchor4 = new Anchor();
        CENTER = anchor2 = new Anchor();
        CENTER_RIGHT = anchor9 = new Anchor();
        BOTTOM_LEFT = anchor5 = new Anchor();
        BOTTOM_CENTER = anchor = new Anchor();
        BOTTOM_RIGHT = anchor3 = new Anchor();
        a = new Anchor[]{anchor8, anchor6, anchor7, anchor4, anchor2, anchor9, anchor5, anchor, anchor3};
    }

    public static Anchor valueOf(String string) {
        return (Anchor)Enum.valueOf(Anchor.class, (String)string);
    }

    public static Anchor[] values() {
        return (Anchor[])a.clone();
    }
}

