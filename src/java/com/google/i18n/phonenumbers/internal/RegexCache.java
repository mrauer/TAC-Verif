/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.regex.Pattern
 */
package com.google.i18n.phonenumbers.internal;

import j$.util.Map;
import j$.util.Map$-CC;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegexCache {
    public LRUCache<String, Pattern> cache;

    public RegexCache(int n3) {
        this.cache = new LRUCache(n3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Pattern getPatternForRegex(String string) {
        Object object;
        LRUCache<String, Pattern> lRUCache;
        LRUCache<String, Pattern> lRUCache2 = lRUCache = this.cache;
        synchronized (lRUCache2) {
            object = lRUCache.map.get((Object)string);
        }
        Pattern pattern = (Pattern)object;
        if (pattern == null) {
            LRUCache<String, Pattern> lRUCache3;
            Pattern pattern2 = Pattern.compile((String)string);
            LRUCache<String, Pattern> lRUCache4 = lRUCache3 = this.cache;
            synchronized (lRUCache4) {
                lRUCache3.map.put((Object)string, (Object)pattern2);
                return pattern2;
            }
        }
        return pattern;
    }

    public static class LRUCache<K, V> {
        public LinkedHashMap<K, V> map;
        public int size;

        public LRUCache(int n3) {
            this.size = n3;
            this.map = new Map(1 + n3 * 4 / 3, 0.75f, true){

                @Override
                public /* synthetic */ Object compute(Object object, j.BiFunction biFunction) {
                    return Map$-CC.$default$compute((java.util.Map)this, object, biFunction);
                }

                @Override
                public /* synthetic */ Object computeIfAbsent(Object object, j.Function function) {
                    return Map$-CC.$default$computeIfAbsent((java.util.Map)this, object, function);
                }

                @Override
                public /* synthetic */ Object computeIfPresent(Object object, j.BiFunction biFunction) {
                    return Map$-CC.$default$computeIfPresent((java.util.Map)this, object, biFunction);
                }

                @Override
                public /* synthetic */ void forEach(j.BiConsumer biConsumer) {
                    Map$-CC.$default$forEach((java.util.Map)this, biConsumer);
                }

                @Override
                public /* synthetic */ Object getOrDefault(Object object, Object object2) {
                    return Map$-CC.$default$getOrDefault((java.util.Map)this, object, object2);
                }

                @Override
                public /* synthetic */ Object merge(Object object, Object object2, j.BiFunction biFunction) {
                    return Map$-CC.$default$merge((java.util.Map)this, object, object2, biFunction);
                }

                @Override
                public /* synthetic */ Object putIfAbsent(Object object, Object object2) {
                    return Map$-CC.$default$putIfAbsent((java.util.Map)this, object, object2);
                }

                @Override
                public /* synthetic */ boolean remove(Object object, Object object2) {
                    return Map$-CC.$default$remove((java.util.Map)this, object, object2);
                }

                public boolean removeEldestEntry(Map.Entry<K, V> entry) {
                    return this.size() > LRUCache.this.size;
                }

                @Override
                public /* synthetic */ Object replace(Object object, Object object2) {
                    return Map$-CC.$default$replace((java.util.Map)this, object, object2);
                }

                @Override
                public /* synthetic */ boolean replace(Object object, Object object2, Object object3) {
                    return Map$-CC.$default$replace((java.util.Map)this, object, object2, object3);
                }

                @Override
                public /* synthetic */ void replaceAll(j.BiFunction biFunction) {
                    Map$-CC.$default$replaceAll((java.util.Map)this, biFunction);
                }
            };
        }

    }

}

