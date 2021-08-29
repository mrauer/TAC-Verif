/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.Objects
 */
package j$.util;

import j$.util.DesugarCollections;
import j$.util.Spliterator;
import j$.util.function.UnaryOperator;
import j$.util.u;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public final class List$-CC {
    public static void $default$replaceAll(List list, UnaryOperator unaryOperator) {
        if (DesugarCollections.b.isInstance((Object)list)) {
            DesugarCollections.e(list, unaryOperator);
            return;
        }
        Objects.requireNonNull((Object)unaryOperator);
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.set(unaryOperator.apply(listIterator.next()));
        }
    }

    public static void $default$sort(List list, Comparator comparator) {
        if (DesugarCollections.b.isInstance((Object)list)) {
            DesugarCollections.f(list, comparator);
            return;
        }
        Object[] arrobject = list.toArray();
        Arrays.sort((Object[])arrobject, (Comparator)comparator);
        ListIterator listIterator = list.listIterator();
        for (Object object : arrobject) {
            listIterator.next();
            listIterator.set(object);
        }
    }

    public static Spliterator $default$spliterator(List list) {
        Objects.requireNonNull((Object)list);
        return new u.i((Collection)list, 16);
    }
}

