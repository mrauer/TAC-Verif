/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.util.t
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Objects
 *  java.util.Set
 *  java.util.SortedSet
 */
package j$.util;

import j$.util.Collection;
import j$.util.Collection$-CC;
import j$.util.List$-CC;
import j$.util.Set$-CC;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import j$.util.u;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

public final class Collection$-EL {
    public static void a(java.util.Collection collection, Consumer consumer) {
        if (collection instanceof Collection) {
            ((Collection)collection).forEach(consumer);
            return;
        }
        Objects.requireNonNull((Object)consumer);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }

    public static Spliterator b(java.util.Collection collection) {
        if (collection instanceof Collection) {
            return ((Collection)collection).spliterator();
        }
        if (collection instanceof LinkedHashSet) {
            return u.m((java.util.Collection)((LinkedHashSet)collection), 17);
        }
        if (collection instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet)collection;
            return new j.t(sortedSet, (java.util.Collection)sortedSet, 21);
        }
        if (collection instanceof Set) {
            return Set$-CC.$default$spliterator((Set)collection);
        }
        if (collection instanceof List) {
            return List$-CC.$default$spliterator((List)collection);
        }
        return Collection$-CC.$default$spliterator(collection);
    }

    public static /* synthetic */ boolean removeIf(java.util.Collection collection, Predicate predicate) {
        if (collection instanceof Collection) {
            return ((Collection)collection).removeIf(predicate);
        }
        return Collection$-CC.$default$removeIf(collection, predicate);
    }

    public static /* synthetic */ Stream stream(java.util.Collection collection) {
        if (collection instanceof Collection) {
            return ((Collection)collection).stream();
        }
        return Collection$-CC.$default$stream(collection);
    }
}

