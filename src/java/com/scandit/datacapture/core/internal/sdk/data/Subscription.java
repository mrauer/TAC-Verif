/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package com.scandit.datacapture.core.internal.sdk.data;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public interface Subscription<T> {
    public void dispose();

    public void use(Function1<? super T, Unit> var1);
}

