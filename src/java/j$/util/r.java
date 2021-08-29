/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.function.x;
import j$.util.g;
import j$.util.h;
import j$.util.j;
import j$.util.v;
import java.util.Objects;

public final class r {
    public static void a(Spliterator.a a2, Consumer consumer) {
        if (consumer instanceof j$.util.function.r) {
            a2.e((j$.util.function.r)((Object)consumer));
            return;
        }
        if (!v.a) {
            Objects.requireNonNull((Object)consumer);
            a2.e(new j(consumer));
            return;
        }
        v.a(a2.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
        throw null;
    }

    public static void b(Spliterator.b b2, Consumer consumer) {
        if (consumer instanceof x) {
            b2.c((x)((Object)consumer));
            return;
        }
        if (!v.a) {
            Objects.requireNonNull((Object)consumer);
            b2.c(new h(consumer));
            return;
        }
        v.a(b2.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
        throw null;
    }

    public static void c(Spliterator.c c2, Consumer consumer) {
        if (consumer instanceof D) {
            c2.d((D)((Object)consumer));
            return;
        }
        if (!v.a) {
            Objects.requireNonNull((Object)consumer);
            c2.d(new g(consumer));
            return;
        }
        v.a(c2.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
        throw null;
    }

    public static boolean d(Spliterator.a a2, Consumer consumer) {
        if (consumer instanceof j$.util.function.r) {
            return a2.o((j$.util.function.r)((Object)consumer));
        }
        if (!v.a) {
            Objects.requireNonNull((Object)consumer);
            return a2.o(new j(consumer));
        }
        v.a(a2.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
        throw null;
    }

    public static boolean e(Spliterator.b b2, Consumer consumer) {
        if (consumer instanceof x) {
            return b2.h((x)((Object)consumer));
        }
        if (!v.a) {
            Objects.requireNonNull((Object)consumer);
            return b2.h(new h(consumer));
        }
        v.a(b2.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
        throw null;
    }

    public static boolean f(Spliterator.c c2, Consumer consumer) {
        if (consumer instanceof D) {
            return c2.j((D)((Object)consumer));
        }
        if (!v.a) {
            Objects.requireNonNull((Object)consumer);
            return c2.j(new g(consumer));
        }
        v.a(c2.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
        throw null;
    }
}

