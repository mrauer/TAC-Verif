/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Byte
 *  java.lang.CharSequence
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 */
package com.scandit.datacapture.core.internal.module.capture;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class a$a
extends Lambda
implements Function1<Byte, CharSequence> {
    public static final a$a a = new a$a();

    public a$a() {
        super(1);
    }

    public final /* synthetic */ Object invoke(Object object) {
        byte by = ((Number)object).byteValue();
        Object[] arrobject = new Object[]{by};
        String string = String.format((String)"%02x", (Object[])Arrays.copyOf((Object[])arrobject, (int)1));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.String.format(this, *args)");
        return string;
    }
}

