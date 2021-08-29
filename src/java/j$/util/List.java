/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.ListIterator
 */
package j$.util;

import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.function.UnaryOperator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public interface List<E>
extends Collection<E> {
    public void add(int var1, Object var2);

    @Override
    public boolean add(Object var1);

    public boolean addAll(int var1, java.util.Collection var2);

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

    public Object get(int var1);

    @Override
    public int hashCode();

    public int indexOf(Object var1);

    @Override
    public boolean isEmpty();

    @Override
    public Iterator iterator();

    public int lastIndexOf(Object var1);

    public ListIterator listIterator();

    public ListIterator listIterator(int var1);

    public Object remove(int var1);

    @Override
    public boolean remove(Object var1);

    @Override
    public boolean removeAll(java.util.Collection var1);

    public void replaceAll(UnaryOperator var1);

    @Override
    public boolean retainAll(java.util.Collection var1);

    public Object set(int var1, Object var2);

    @Override
    public int size();

    public void sort(Comparator var1);

    @Override
    public Spliterator spliterator();

    public java.util.List subList(int var1, int var2);

    @Override
    public Object[] toArray();

    @Override
    public Object[] toArray(Object[] var1);
}

