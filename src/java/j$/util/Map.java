/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Map
 *  java.util.Set
 */
package j$.util;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collection;
import java.util.Set;

public interface Map<K, V> {
    public void clear();

    public Object compute(Object var1, BiFunction var2);

    public Object computeIfAbsent(Object var1, Function var2);

    public Object computeIfPresent(Object var1, BiFunction var2);

    public boolean containsKey(Object var1);

    public boolean containsValue(Object var1);

    public Set entrySet();

    public boolean equals(Object var1);

    public void forEach(BiConsumer var1);

    public Object get(Object var1);

    public Object getOrDefault(Object var1, Object var2);

    public int hashCode();

    public boolean isEmpty();

    public Set keySet();

    public Object merge(Object var1, Object var2, BiFunction var3);

    public Object put(Object var1, Object var2);

    public void putAll(java.util.Map var1);

    public Object putIfAbsent(Object var1, Object var2);

    public Object remove(Object var1);

    public boolean remove(Object var1, Object var2);

    public Object replace(Object var1, Object var2);

    public boolean replace(Object var1, Object var2, Object var3);

    public void replaceAll(BiFunction var1);

    public int size();

    public Collection values();
}

