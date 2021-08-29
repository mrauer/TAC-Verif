/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Object
 *  java.util.Comparator
 */
package j$.util.stream;

import j$.util.Optional;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.K;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.function.y;
import j$.util.stream.C1;
import j$.util.stream.H1;
import j$.util.stream.l1;
import j$.util.stream.m1;
import j$.util.stream.s1;
import java.util.Comparator;

public interface Stream<T>
extends l1<T, Stream<T>> {
    public s1 A(Function var1);

    public Stream O(j.Predicate var1);

    public Stream R(j.Consumer var1);

    public Object S(m1 var1);

    public boolean T(j.Predicate var1);

    public H1 U(Function var1);

    public boolean a(j.Predicate var1);

    public boolean b0(j.Predicate var1);

    public long count();

    public H1 d0(ToLongFunction var1);

    public Stream distinct();

    public C1 e(Function var1);

    public j.Optional findAny();

    public j.Optional findFirst();

    public void forEach(j.Consumer var1);

    public void g(j.Consumer var1);

    public s1 g0(ToDoubleFunction var1);

    public Object k(K var1, BiConsumer var2, BiConsumer var3);

    public Stream limit(long var1);

    public C1 m(ToIntFunction var1);

    public Stream map(Function var1);

    public j.Optional max(Comparator var1);

    public j.Optional min(Comparator var1);

    public Stream o(Function var1);

    public j.Optional r(BinaryOperator var1);

    public Object reduce(Object var1, BinaryOperator var2);

    public Stream skip(long var1);

    public Stream sorted();

    public Stream sorted(Comparator var1);

    public Object[] toArray();

    public Object[] toArray(y var1);

    public Object y(Object var1, j.BiFunction var2, BinaryOperator var3);
}

