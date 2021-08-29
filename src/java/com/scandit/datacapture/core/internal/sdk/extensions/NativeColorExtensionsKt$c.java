/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 */
package com.scandit.datacapture.core.internal.sdk.extensions;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public final class NativeColorExtensionsKt$c
extends Lambda
implements Function1<Integer, Float> {
    public static final NativeColorExtensionsKt$c a = new NativeColorExtensionsKt$c();

    public NativeColorExtensionsKt$c() {
        super(1);
    }

    public final /* synthetic */ Object invoke(Object object) {
        return Float.valueOf((float)((float)((Number)object).intValue() / 255.0f));
    }
}

