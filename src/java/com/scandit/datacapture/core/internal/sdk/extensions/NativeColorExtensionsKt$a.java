/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Number
 *  java.lang.Object
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 */
package com.scandit.datacapture.core.internal.sdk.extensions;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public final class NativeColorExtensionsKt$a
extends Lambda
implements Function1<Integer, Integer> {
    public static final NativeColorExtensionsKt$a a = new NativeColorExtensionsKt$a();

    public NativeColorExtensionsKt$a() {
        super(1);
    }

    public final /* synthetic */ Object invoke(Object object) {
        return Math.max((int)0, (int)Math.min((int)((Number)object).intValue(), (int)255));
    }
}

