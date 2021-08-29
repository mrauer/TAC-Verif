/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.concurrent;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;

public interface ConcurrentMap<K, V>
extends Map<K, V> {
    @Override
    public Object compute(Object var1, BiFunction var2);

    @Override
    public Object computeIfAbsent(Object var1, Function var2);

    @Override
    public Object computeIfPresent(Object var1, BiFunction var2);

    @Override
    public void forEach(BiConsumer var1);

    @Override
    public Object getOrDefault(Object var1, Object var2);

    @Override
    public Object merge(Object var1, Object var2, BiFunction var3);

    @Override
    public Object putIfAbsent(Object var1, Object var2);

    @Override
    public boolean remove(Object var1, Object var2);

    @Override
    public Object replace(Object var1, Object var2);

    @Override
    public boolean replace(Object var1, Object var2, Object var3);

    @Override
    public void replaceAll(BiFunction var1);
}

