/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util;

import j$.util.function.Consumer;

public interface Iterator<E> {
    public void forEachRemaining(Consumer var1);

    public boolean hasNext();

    public Object next();

    public void remove();
}

