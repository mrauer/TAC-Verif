/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 */
package org.bouncycastle.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import j$.util.Iterator;
import j$.util.Iterator$-CC;
import j$.util.function.Consumer;
import java.util.NoSuchElementException;

public class Arrays$Iterator<T>
implements java.util.Iterator<T>,
Iterator {
    public final T[] dataArray;
    public int position = 0;

    public Arrays$Iterator(T[] arrT) {
        this.dataArray = arrT;
    }

    @Override
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator$-CC.$default$forEachRemaining(this, consumer);
    }

    @Override
    public boolean hasNext() {
        return this.position < this.dataArray.length;
    }

    public T next() {
        int n2 = this.position;
        T[] arrT = this.dataArray;
        if (n2 != arrT.length) {
            this.position = n2 + 1;
            return arrT[n2];
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Out of elements: ");
        stringBuilder.append(this.position);
        throw new NoSuchElementException(stringBuilder.toString());
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove element from an Array.");
    }
}

