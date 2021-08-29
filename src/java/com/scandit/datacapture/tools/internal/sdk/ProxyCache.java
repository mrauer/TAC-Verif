/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  kotlin.jvm.functions.Function0
 *  kotlin.reflect.KClass
 */
package com.scandit.datacapture.tools.internal.sdk;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;

public interface ProxyCache {
    public <K, V> V getOrPut(KClass<K> var1, Object var2, K var3, Function0<? extends V> var4);

    public <K, V> void put(KClass<K> var1, Object var2, K var3, V var4);

    public <K, V> V require(KClass<K> var1, Object var2, K var3);
}

