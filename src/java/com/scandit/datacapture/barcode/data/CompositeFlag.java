/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.barcode.data;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class CompositeFlag
extends Enum<CompositeFlag> {
    public static final /* enum */ CompositeFlag GS1_TYPE_A;
    public static final /* enum */ CompositeFlag GS1_TYPE_B;
    public static final /* enum */ CompositeFlag GS1_TYPE_C;
    public static final /* enum */ CompositeFlag LINKED;
    public static final /* enum */ CompositeFlag NONE;
    public static final /* enum */ CompositeFlag UNKNOWN;
    private static final /* synthetic */ CompositeFlag[] a;

    public static {
        CompositeFlag compositeFlag;
        CompositeFlag compositeFlag2;
        CompositeFlag compositeFlag3;
        CompositeFlag compositeFlag4;
        CompositeFlag compositeFlag5;
        CompositeFlag compositeFlag6;
        NONE = compositeFlag3 = new CompositeFlag();
        UNKNOWN = compositeFlag4 = new CompositeFlag();
        LINKED = compositeFlag5 = new CompositeFlag();
        GS1_TYPE_A = compositeFlag = new CompositeFlag();
        GS1_TYPE_B = compositeFlag6 = new CompositeFlag();
        GS1_TYPE_C = compositeFlag2 = new CompositeFlag();
        a = new CompositeFlag[]{compositeFlag3, compositeFlag4, compositeFlag5, compositeFlag, compositeFlag6, compositeFlag2};
    }

    public static CompositeFlag valueOf(String string) {
        return (CompositeFlag)Enum.valueOf(CompositeFlag.class, (String)string);
    }

    public static CompositeFlag[] values() {
        return (CompositeFlag[])a.clone();
    }
}

