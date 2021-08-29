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
public final class CompositeType
extends Enum<CompositeType> {
    public static final /* enum */ CompositeType A;
    public static final /* enum */ CompositeType B;
    public static final /* enum */ CompositeType C;
    private static final /* synthetic */ CompositeType[] a;

    public static {
        CompositeType compositeType;
        CompositeType compositeType2;
        CompositeType compositeType3;
        A = compositeType2 = new CompositeType();
        B = compositeType3 = new CompositeType();
        C = compositeType = new CompositeType();
        a = new CompositeType[]{compositeType2, compositeType3, compositeType};
    }

    public static CompositeType valueOf(String string) {
        return (CompositeType)Enum.valueOf(CompositeType.class, (String)string);
    }

    public static CompositeType[] values() {
        return (CompositeType[])a.clone();
    }
}

