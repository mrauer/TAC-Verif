/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.core.internal.module.b.a.a.c$a
 *  java.lang.Object
 *  kotlin.Lazy
 *  kotlin.jvm.functions.Function0
 */
package com.scandit.datacapture.core.internal.module.b.a.a;

import com.google.android.material.R;
import com.scandit.datacapture.core.internal.module.b.a.a.b;
import com.scandit.datacapture.core.internal.module.b.a.a.c;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

public final class c {
    public static final c a;
    public static final Lazy b;

    public static {
        b = R.style.lazy((Function0)a.a);
    }

    public static final b a() {
        return (b)b.getValue();
    }
}

