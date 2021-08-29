/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.tools.internal.a.a.d$m
 *  com.scandit.datacapture.tools.internal.a.a.d$o
 *  com.scandit.datacapture.tools.internal.a.a.d$t
 *  com.scandit.datacapture.tools.internal.a.a.d$v
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Objects
 *  java.util.WeakHashMap
 *  java.util.concurrent.ConcurrentMap
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 */
package com.scandit.datacapture.tools.internal.sdk;

import com.scandit.datacapture.tools.internal.a.a.c;
import com.scandit.datacapture.tools.internal.a.a.d;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

public final class GuavaMapMakerProxyCache
implements ProxyCache {
    public final Map<KClass<? extends Object>, ConcurrentMap<Object, Object>> a = new LinkedHashMap();
    public final Map<KClass<? extends Object>, WeakHashMap<Object, ConcurrentMap<Object, Object>>> b = new LinkedHashMap();

    /*
     * Enabled aggressive block sorting
     */
    public static ConcurrentMap<Object, Object> a() {
        block12 : {
            void var9_9;
            block7 : {
                d d2;
                block9 : {
                    d.l l2;
                    c c2;
                    block11 : {
                        d.l l3;
                        block10 : {
                            block8 : {
                                block6 : {
                                    c2 = new c();
                                    l2 = d.l.b;
                                    d.l l4 = c2.d;
                                    boolean bl = l4 == null;
                                    c.a(bl, "Key strength was already set to %s", (Object)l4);
                                    Objects.requireNonNull((Object)((Object)l2));
                                    c2.d = l2;
                                    l3 = d.l.a;
                                    if (l2 != l3) {
                                        c2.a = true;
                                    }
                                    d.l l5 = c2.e;
                                    boolean bl2 = false;
                                    if (l5 == null) {
                                        bl2 = true;
                                    }
                                    c.a(bl2, "Value strength was already set to %s", (Object)l5);
                                    Objects.requireNonNull((Object)((Object)l2));
                                    c2.e = l2;
                                    if (l2 != l3) {
                                        c2.a = true;
                                    }
                                    if (c2.a) break block6;
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16, 0.75f, 4);
                                    break block7;
                                }
                                if (c2.d() != l3 || c2.f() != l3) break block8;
                                d2 = new d(c2, d.a.a);
                                break block9;
                            }
                            if (c2.d() != l3 || c2.f() != l2) break block10;
                            d2 = new d(c2, d.a.a);
                            break block9;
                        }
                        if (c2.d() != l2 || c2.f() != l3) break block11;
                        d2 = new d(c2, d.a.a);
                        break block9;
                    }
                    if (c2.d() != l2 || c2.f() != l2) break block12;
                    d2 = new d(c2, d.a.a);
                }
                d d3 = d2;
            }
            Intrinsics.checkNotNullExpressionValue((Object)var9_9, (String)"MapMaker()\n             \u2026               .makeMap()");
            return var9_9;
        }
        throw new AssertionError();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final <K> ConcurrentMap<Object, Object> a(KClass<K> kClass, Object object) {
        GuavaMapMakerProxyCache guavaMapMakerProxyCache = this;
        synchronized (guavaMapMakerProxyCache) {
            ConcurrentMap<Object, Object> concurrentMap;
            if (object == null) {
                Map<KClass<? extends Object>, ConcurrentMap<Object, Object>> map = this.a;
                ConcurrentMap<Object, Object> concurrentMap2 = map.get(kClass);
                if (concurrentMap2 != null) return concurrentMap2;
                concurrentMap2 = GuavaMapMakerProxyCache.a();
                map.put(kClass, concurrentMap2);
                return concurrentMap2;
            }
            WeakHashMap weakHashMap = (WeakHashMap)this.b.get(kClass);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap();
                this.b.put(kClass, (Object)weakHashMap);
            }
            if ((concurrentMap = weakHashMap.get(object)) == null) {
                concurrentMap = GuavaMapMakerProxyCache.a();
                weakHashMap.put(object, concurrentMap);
            }
            Intrinsics.checkNotNullExpressionValue(concurrentMap, (String)"scopedCache.getOrPut(scope) { createCache() }");
            return concurrentMap;
        }
    }

    @Override
    public final <K, V> V getOrPut(KClass<K> kClass, Object object, K k2, Function0<? extends V> function0) {
        Object object2;
        Intrinsics.checkNotNullParameter(kClass, (String)"keyClass");
        Intrinsics.checkNotNullParameter(k2, (String)"key");
        Intrinsics.checkNotNullParameter(function0, (String)"defaultValue");
        ConcurrentMap<Object, Object> concurrentMap = this.a(kClass, null);
        Object object3 = concurrentMap.get(k2);
        if (object3 == null && (object2 = concurrentMap.putIfAbsent(k2, object3 = function0.invoke())) != null) {
            object3 = object2;
        }
        Objects.requireNonNull((Object)object3, (String)"null cannot be cast to non-null type V");
        return (V)object3;
    }

    @Override
    public final <K, V> void put(KClass<K> kClass, Object object, K k2, V v2) {
        Intrinsics.checkNotNullParameter(kClass, (String)"keyClass");
        Intrinsics.checkNotNullParameter(k2, (String)"key");
        Intrinsics.checkNotNullParameter(v2, (String)"value");
        this.a(kClass, null).put(k2, v2);
    }

    @Override
    public final <K, V> V require(KClass<K> kClass, Object object, K k2) {
        Intrinsics.checkNotNullParameter(kClass, (String)"keyClass");
        Intrinsics.checkNotNullParameter(k2, (String)"key");
        Object object2 = this.a(kClass, null).get(k2);
        if (object2 != null) {
            return (V)object2;
        }
        StringBuilder stringBuilder = new StringBuilder("Cache for class ");
        stringBuilder.append(kClass);
        stringBuilder.append(" contains no key ");
        stringBuilder.append(k2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}

