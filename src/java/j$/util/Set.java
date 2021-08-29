/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Iterator
 */
package j$.util;

import j$.util.Collection;
import j$.util.Spliterator;
import java.util.Iterator;

public interface Set<E>
extends Collection<E> {
    @Override
    public boolean add(Object var1);

    @Override
    public boolean addAll(java.util.Collection var1);

    @Override
    public void clear();

    @Override
    public boolean contains(Object var1);

    @Override
    public boolean containsAll(java.util.Collection var1);

    @Override
    public boolean equals(Object var1);

    @Override
    public int hashCode();

    @Override
    public boolean isEmpty();

    @Override
    public Iterator iterator();

    @Override
    public boolean remove(Object var1);

    @Override
    public boolean removeAll(java.util.Collection var1);

    @Override
    public boolean retainAll(java.util.Collection var1);

    @Override
    public int size();

    @Override
    public Spliterator spliterator();

    @Override
    public Object[] toArray();

    @Override
    public Object[] toArray(Object[] var1);
}

