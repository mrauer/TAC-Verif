/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 */
package com.scandit.datacapture.core.internal.sdk.extensions;

import com.google.android.material.R;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public final class NativeColorExtensionsKt$b
extends Lambda
implements Function1<Float, Integer> {
    public static final NativeColorExtensionsKt$b a = new NativeColorExtensionsKt$b();

    public NativeColorExtensionsKt$b() {
        super(1);
    }

    public final /* synthetic */ Object invoke(Object object) {
        return R.style.roundToInt((float)(255.0f * ((Number)object).floatValue()));
    }
}

