/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Iterator
 */
package j$.util;

import j$.lang.Iterable;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.y;
import j$.util.stream.Stream;
import java.util.Iterator;

public interface Collection<E>
extends Iterable<E> {
    public boolean add(Object var1);

    public boolean addAll(java.util.Collection var1);

    public void clear();

    public boolean contains(Object var1);

    public boolean containsAll(java.util.Collection var1);

    public boolean equals(Object var1);

    @Override
    public void forEach(Consumer var1);

    public int hashCode();

    public boolean isEmpty();

    @Override
    public Iterator iterator();

    public Stream parallelStream();

    public boolean remove(Object var1);

    public boolean removeAll(java.util.Collection var1);

    public boolean removeIf(Predicate var1);

    public boolean retainAll(java.util.Collection var1);

    public int size();

    @Override
    public Spliterator spliterator();

    public Stream stream();

    public Object[] toArray();

    public Object[] toArray(y var1);

    public Object[] toArray(Object[] var1);
}

