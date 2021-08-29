/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package joptsimple.internal;

import java.util.Map;

public interface OptionNameMap<V> {
    public boolean contains(String var1);

    public V get(String var1);

    public void putAll(Iterable<String> var1, V var2);

    public Map<String, V> toJavaUtilMap();
}

