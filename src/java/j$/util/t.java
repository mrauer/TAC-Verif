/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.SortedSet
 */
package j$.util;

import j$.util.u;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;

class t
extends u.i<E> {
    final /* synthetic */ SortedSet f;

    t(SortedSet sortedSet, Collection collection, int n3) {
        this.f = sortedSet;
        super(collection, n3);
    }

    @Override
    public Comparator getComparator() {
        return this.f.comparator();
    }
}

