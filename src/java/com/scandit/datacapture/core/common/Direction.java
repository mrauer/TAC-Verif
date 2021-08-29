/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.common;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class Direction
extends Enum<Direction> {
    public static final /* enum */ Direction BOTTOM_TO_TOP;
    public static final /* enum */ Direction HORIZONTAL;
    public static final /* enum */ Direction LEFT_TO_RIGHT;
    public static final /* enum */ Direction NONE;
    public static final /* enum */ Direction RIGHT_TO_LEFT;
    public static final /* enum */ Direction TOP_TO_BOTTOM;
    public static final /* enum */ Direction VERTICAL;
    private static final /* synthetic */ Direction[] a;

    public static {
        Direction direction;
        Direction direction2;
        Direction direction3;
        Direction direction4;
        Direction direction5;
        Direction direction6;
        Direction direction7;
        LEFT_TO_RIGHT = direction2 = new Direction();
        RIGHT_TO_LEFT = direction6 = new Direction();
        HORIZONTAL = direction3 = new Direction();
        TOP_TO_BOTTOM = direction = new Direction();
        BOTTOM_TO_TOP = direction7 = new Direction();
        VERTICAL = direction4 = new Direction();
        NONE = direction5 = new Direction();
        a = new Direction[]{direction2, direction6, direction3, direction, direction7, direction4, direction5};
    }

    public static Direction valueOf(String string) {
        return (Direction)Enum.valueOf(Direction.class, (String)string);
    }

    public static Direction[] values() {
        return (Direction[])a.clone();
    }
}

