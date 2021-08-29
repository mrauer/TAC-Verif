/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.upokecenter.numbers;

public final class ERounding
extends Enum<ERounding> {
    private static final /* synthetic */ ERounding[] $VALUES;
    public static final /* enum */ ERounding Ceiling;
    public static final /* enum */ ERounding Down;
    public static final /* enum */ ERounding Floor;
    public static final /* enum */ ERounding HalfDown;
    public static final /* enum */ ERounding HalfEven;
    public static final /* enum */ ERounding HalfUp;
    public static final /* enum */ ERounding None;
    @Deprecated
    public static final /* enum */ ERounding Odd;
    public static final /* enum */ ERounding OddOrZeroFiveUp;
    public static final /* enum */ ERounding Up;
    @Deprecated
    public static final /* enum */ ERounding ZeroFiveUp;

    public static {
        ERounding eRounding;
        ERounding eRounding2;
        ERounding eRounding3;
        ERounding eRounding4;
        ERounding eRounding5;
        ERounding eRounding6;
        ERounding eRounding7;
        ERounding eRounding8;
        ERounding eRounding9;
        ERounding eRounding10;
        ERounding eRounding11;
        None = eRounding11 = new ERounding();
        Up = eRounding8 = new ERounding();
        Down = eRounding6 = new ERounding();
        HalfUp = eRounding9 = new ERounding();
        HalfDown = eRounding3 = new ERounding();
        HalfEven = eRounding4 = new ERounding();
        Ceiling = eRounding10 = new ERounding();
        Floor = eRounding5 = new ERounding();
        Odd = eRounding = new ERounding();
        ZeroFiveUp = eRounding7 = new ERounding();
        OddOrZeroFiveUp = eRounding2 = new ERounding();
        $VALUES = new ERounding[]{eRounding11, eRounding8, eRounding6, eRounding9, eRounding3, eRounding4, eRounding10, eRounding5, eRounding, eRounding7, eRounding2};
    }

    public static ERounding valueOf(String string) {
        return (ERounding)Enum.valueOf(ERounding.class, (String)string);
    }

    public static ERounding[] values() {
        return (ERounding[])$VALUES.clone();
    }
}

