/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Iterator
 */
package j$.lang;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Iterator;

public interface Iterable<T> {
    public void forEach(Consumer var1);

    public Iterator iterator();

    public Spliterator spliterator();
}

