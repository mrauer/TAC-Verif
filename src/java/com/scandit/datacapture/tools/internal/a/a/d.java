/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.tools.internal.a.a.d$1
 *  com.scandit.datacapture.tools.internal.a.a.d$aa
 *  com.scandit.datacapture.tools.internal.a.a.d$d
 *  com.scandit.datacapture.tools.internal.a.a.d$i
 *  com.scandit.datacapture.tools.internal.a.a.d$l$1
 *  com.scandit.datacapture.tools.internal.a.a.d$l$2
 *  com.scandit.datacapture.tools.internal.a.a.d$o
 *  com.scandit.datacapture.tools.internal.a.a.d$r
 *  com.scandit.datacapture.tools.internal.a.a.d$x
 *  j
 *  java.io.Serializable
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.ref.Reference
 *  java.lang.ref.ReferenceQueue
 *  java.util.AbstractCollection
 *  java.util.AbstractMap
 *  java.util.AbstractSet
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NoSuchElementException
 *  java.util.Objects
 *  java.util.Set
 *  java.util.concurrent.ConcurrentMap
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.concurrent.atomic.AtomicReferenceArray
 *  java.util.concurrent.locks.ReentrantLock
 */
package com.scandit.datacapture.tools.internal.a.a;

import com.google.android.material.R;
import com.scandit.datacapture.tools.internal.a.a.b;
import com.scandit.datacapture.tools.internal.a.a.c;
import com.scandit.datacapture.tools.internal.a.a.d;
import j$.lang.Iterable$-CC;
import j$.util.Collection$-CC;
import j$.util.Iterator$-CC;
import j$.util.Map;
import j$.util.Set;
import j$.util.Set$-CC;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentMap$-CC;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Exception performing whole class analysis.
 */
public final class d<K, V, E extends f<K, V, E>, S extends k<K, V, E, S>>
extends AbstractMap<K, V>
implements Serializable,
ConcurrentMap<K, V>,
Map,
j$.util.concurrent.ConcurrentMap {
    public static y<Object, Object, Object> g;
    public final transient k<K, V, E, S>[] a;
    public final b<Object> b;
    public final transient g<K, V, E, S> c;
    public transient int d;
    public transient int e;
    public int f;
    public transient java.util.Set<K> h;
    public transient Collection<V> i;
    public transient java.util.Set<Map.Entry<K, V>> j;

    public static {
        g = new 1();
    }

    public d(c c2, g<K, V, E, S> g2) {
        int n2;
        int n3;
        k<K, V, E, S>[] arrk;
        this.f = Math.min((int)4, (int)65536);
        this.b = (b)R.style.a(null, c2.d().a());
        this.c = g2;
        int n4 = Math.min((int)16, (int)1073741824);
        int n5 = 0;
        for (n3 = n2 = 1; n3 < this.f; n3 <<= 1) {
            ++n5;
        }
        this.e = 32 - n5;
        this.d = n3 - 1;
        this.a = new k[n3];
        int n6 = n4 / n3;
        if (n3 * n6 < n4) {
            ++n6;
        }
        do {
            if (n2 >= n6) break;
            n2 <<= 1;
        } while (true);
        for (int i2 = 0; i2 < (arrk = this.a).length; ++i2) {
            arrk[i2] = this.c.a(this, n2, -1);
        }
    }

    public static ArrayList a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator iterator = collection.iterator();
        Objects.requireNonNull((Object)iterator);
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
        return arrayList;
    }

    public final int a(Object object) {
        b<Object> b2 = this.b;
        Objects.requireNonNull(b2);
        int n2 = b2.b(object);
        int n3 = n2 + (-12931 ^ n2 << 15);
        int n4 = n3 ^ n3 >>> 10;
        int n5 = n4 + (n4 << 3);
        int n6 = n5 ^ n5 >>> 6;
        int n7 = n6 + ((n6 << 2) + (n6 << 14));
        return n7 ^ n7 >>> 16;
    }

    public final k<K, V, E, S> a(int n2) {
        return this.a[n2 >>> this.e & this.d];
    }

    public final b<Object> b() {
        return this.c.a().a();
    }

    @Override
    public final void clear() {
        for (k<K, V, E, S> k2 : this.a) {
            if (k2.a == 0) continue;
            k2.lock();
            AtomicReferenceArray atomicReferenceArray = k2.c;
            int n2 = 0;
            do {
                if (n2 >= atomicReferenceArray.length()) break;
                atomicReferenceArray.set(n2, null);
                ++n2;
            } while (true);
            try {
                k2.c();
                k2.d.set(0);
                k2.b = 1 + k2.b;
                k2.a = 0;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
                k2.unlock();
            }
        }
    }

    @Override
    public /* synthetic */ Object compute(Object object, j.BiFunction biFunction) {
        return ConcurrentMap$-CC.$default$compute(this, object, biFunction);
    }

    @Override
    public /* synthetic */ Object computeIfAbsent(Object object, Function function) {
        return ConcurrentMap$-CC.$default$computeIfAbsent(this, object, function);
    }

    @Override
    public /* synthetic */ Object computeIfPresent(Object object, j.BiFunction biFunction) {
        return ConcurrentMap$-CC.$default$computeIfPresent(this, object, biFunction);
    }

    @Override
    public final boolean containsKey(Object object) {
        boolean bl;
        k<K, V, E, S> k2;
        block5 : {
            if (object == null) {
                return false;
            }
            int n2 = this.a(object);
            k2 = this.a(n2);
            Objects.requireNonNull(k2);
            try {
                int n3 = k2.a;
                bl = false;
                if (n3 == 0) break block5;
            }
            catch (Throwable throwable) {
                k2.e();
                throw throwable;
            }
            E e2 = k2.d(object, n2);
            bl = false;
            if (e2 == null) break block5;
            Object v2 = e2.d();
            bl = false;
            if (v2 == null) break block5;
            bl = true;
        }
        k2.e();
        return bl;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public final boolean containsValue(Object var1_1) {
        if (var1_1 == null) {
            return false;
        }
        var2_2 = this.a;
        var3_3 = -1L;
        for (var5_4 = 0; var5_4 < 3; ++var5_4) {
            var6_5 = 0L;
            for (k<K, V, E, S> var10_8 : var2_2) {
                var12_9 = var10_8.c;
                for (var13_10 = 0; var13_10 < var12_9.length(); ++var13_10) {
                    var14_12 = (f)var12_9.get(var13_10);
                    while (var14_11 != null) {
                        if (var14_11.a() == null) {
                            var10_8.d();
lbl14: // 2 sources:
                            do {
                                var15_14 = null;
                                break;
                            } while (true);
                        } else {
                            var15_14 = var14_11.d();
                            if (var15_14 == null) {
                                var10_8.d();
                                ** continue;
                            }
                        }
                        if (var15_14 != null && this.b().a(var1_1, var15_14)) {
                            return true;
                        }
                        var14_13 = var14_11.c();
                    }
                }
                var6_5 += (long)var10_8.b;
            }
            if (var6_5 != var3_3) {
                var3_3 = var6_5;
                continue;
            }
            return false;
        }
        return false;
    }

    @Override
    public final java.util.Set<Map.Entry<K, V>> entrySet() {
        d d2;
        java.util.Set<Map.Entry<K, V>> set = this.j;
        if (set != null) {
            return set;
        }
        this.j = d2 = new /* Unavailable Anonymous Inner Class!! */;
        return d2;
    }

    @Override
    public /* synthetic */ void forEach(j.BiConsumer biConsumer) {
        ConcurrentMap$-CC.$default$forEach(this, biConsumer);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final V get(Object object) {
        if (object == null) {
            return null;
        }
        int n2 = this.a(object);
        k<K, V, E, S> k2 = this.a(n2);
        Objects.requireNonNull(k2);
        E e2 = k2.d(object, n2);
        V v2 = null;
        if (e2 == null) {
            return v2;
        }
        v2 = e2.d();
        if (v2 != null) return v2;
        k2.d();
        return v2;
    }

    @Override
    public /* synthetic */ Object getOrDefault(Object object, Object object2) {
        return ConcurrentMap$-CC.$default$getOrDefault(this, object, object2);
    }

    @Override
    public final boolean isEmpty() {
        k<K, V, E, S>[] arrk = this.a;
        long l2 = 0L;
        for (int i2 = 0; i2 < arrk.length; ++i2) {
            if (arrk[i2].a != 0) {
                return false;
            }
            l2 += (long)arrk[i2].b;
        }
        if (l2 != 0L) {
            for (int i3 = 0; i3 < arrk.length; ++i3) {
                if (arrk[i3].a != 0) {
                    return false;
                }
                l2 -= (long)arrk[i3].b;
            }
            if (l2 != 0L) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final java.util.Set<K> keySet() {
        i i2;
        java.util.Set<K> set = this.h;
        if (set != null) {
            return set;
        }
        this.h = i2 = new /* Unavailable Anonymous Inner Class!! */;
        return i2;
    }

    @Override
    public /* synthetic */ Object merge(Object object, Object object2, j.BiFunction biFunction) {
        return ConcurrentMap$-CC.$default$merge(this, object, object2, biFunction);
    }

    @Override
    public final V put(K k2, V v2) {
        Objects.requireNonNull(k2);
        Objects.requireNonNull(v2);
        int n2 = this.a(k2);
        return this.a(n2).a(k2, n2, v2, false);
    }

    @Override
    public final void putAll(java.util.Map<? extends K, ? extends V> map) {
        for (Map.Entry entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public final V putIfAbsent(K k2, V v2) {
        Objects.requireNonNull(k2);
        Objects.requireNonNull(v2);
        int n2 = this.a(k2);
        return this.a(n2).a(k2, n2, v2, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final V remove(Object object) {
        k<K, V, E, S> k2;
        block6 : {
            AtomicReferenceArray atomicReferenceArray;
            f f2;
            f f3;
            boolean bl;
            int n2;
            if (object == null) {
                return null;
            }
            int n3 = this.a(object);
            k2 = this.a(n3);
            k2.lock();
            try {
                k2.f();
                atomicReferenceArray = k2.c;
                n2 = n3 & atomicReferenceArray.length() - 1;
                f3 = (f)atomicReferenceArray.get(n2);
                for (f2 = f3; f2 != null; f2 = f2.c()) {
                    Object k3 = f2.a();
                    if (f2.b() != n3 || k3 == null || !k2.e.b.a(object, k3)) continue;
                }
                break block6;
            }
            catch (Throwable throwable) {
                k2.unlock();
                throw throwable;
            }
            Object v2 = f2.d();
            if (v2 != null || (bl = f2.d() == null)) {
                k2.b = 1 + k2.b;
                f f4 = k2.b(f3, f2);
                int n4 = k2.a - 1;
                atomicReferenceArray.set(n2, f4);
                k2.a = n4;
                k2.unlock();
                return v2;
            }
        }
        k2.unlock();
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public final boolean remove(Object var1_1, Object var2_2) {
        block6 : {
            if (var1_1 == null) return false;
            if (var2_2 == null) {
                return false;
            }
            var3_3 = this.a(var1_1);
            var4_4 = this.a(var3_3);
            var4_4.lock();
            try {
                var4_4.f();
                var6_5 = var4_4.c;
                var7_6 = var3_3 & var6_5.length() - 1;
                var8_7 = (f)var6_5.get(var7_6);
                var9_8 = var8_7;
                do {
                    block7 : {
                        block8 : {
                            var10_9 = false;
                            if (var9_8 == null) break block6;
                            var11_10 = var9_8.a();
                            if (var9_8.b() != var3_3 || var11_10 == null || !var4_4.e.b.a(var1_1, var11_10)) break block7;
                            var12_11 = var9_8.d();
                            if (!var4_4.e.b().a(var2_2, var12_11)) break block8;
                            var10_9 = true;
                            ** GOTO lbl-1000
                        }
                        var15_12 = var9_8.d() == null;
                    }
                    var9_8 = var9_8.c();
                } while (true);
            }
            catch (Throwable var5_15) {
                var4_4.unlock();
                throw var5_15;
            }
            var10_9 = false;
            if (!var15_12) {
                var10_9 = false;
            } else lbl-1000: // 2 sources:
            {
                var4_4.b = 1 + var4_4.b;
                var13_13 = var4_4.b(var8_7, var9_8);
                var14_14 = var4_4.a - 1;
                var6_5.set(var7_6, var13_13);
                var4_4.a = var14_14;
            }
        }
        var4_4.unlock();
        return var10_9;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final V replace(K k2, V v2) {
        Objects.requireNonNull(k2);
        Objects.requireNonNull(v2);
        int n2 = this.a(k2);
        k<K, V, E, S> k3 = this.a(n2);
        k3.lock();
        try {
            k3.f();
            AtomicReferenceArray atomicReferenceArray = k3.c;
            int n3 = n2 & atomicReferenceArray.length() - 1;
            f f2 = (f)atomicReferenceArray.get(n3);
            for (f f3 = f2; f3 != null; f3 = f3.c()) {
                Object k4 = f3.a();
                if (f3.b() != n2 || k4 == null || !k3.e.b.a(k2, k4)) continue;
                Object v3 = f3.d();
                if (v3 == null) {
                    boolean bl = f3.d() == null;
                    if (!bl) return null;
                    k3.b = 1 + k3.b;
                    f f4 = k3.b(f2, f3);
                    int n4 = k3.a - 1;
                    atomicReferenceArray.set(n3, f4);
                    k3.a = n4;
                    return null;
                }
                k3.b = 1 + k3.b;
                k3.e.c.a(k3.a(), f3, v2);
                return v3;
            }
            return null;
        }
        finally {
            k3.unlock();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final boolean replace(K k2, V v2, V v3) {
        Objects.requireNonNull(k2);
        Objects.requireNonNull(v3);
        if (v2 == null) {
            return false;
        }
        int n2 = this.a(k2);
        k<K, V, E, S> k3 = this.a(n2);
        k3.lock();
        try {
            k3.f();
            AtomicReferenceArray atomicReferenceArray = k3.c;
            int n3 = n2 & atomicReferenceArray.length() - 1;
            f f2 = (f)atomicReferenceArray.get(n3);
            for (f f3 = f2; f3 != null; f3 = f3.c()) {
                Object k4 = f3.a();
                if (f3.b() != n2 || k4 == null || !k3.e.b.a(k2, k4)) continue;
                Object v4 = f3.d();
                if (v4 == null) {
                    boolean bl = f3.d() == null;
                    if (!bl) return false;
                    k3.b = 1 + k3.b;
                    f f4 = k3.b(f2, f3);
                    int n4 = k3.a - 1;
                    atomicReferenceArray.set(n3, f4);
                    k3.a = n4;
                    return false;
                }
                if (!k3.e.b().a(v2, v4)) return false;
                k3.b = 1 + k3.b;
                k3.e.c.a(k3.a(), f3, v3);
                return true;
            }
            return false;
        }
        finally {
            k3.unlock();
        }
    }

    @Override
    public /* synthetic */ void replaceAll(j.BiFunction biFunction) {
        ConcurrentMap$-CC.$default$replaceAll(this, biFunction);
    }

    @Override
    public final int size() {
        k<K, V, E, S>[] arrk = this.a;
        long l2 = 0L;
        for (int i2 = 0; i2 < arrk.length; ++i2) {
            l2 += (long)arrk[i2].a;
        }
        if (l2 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (l2 < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)l2;
    }

    @Override
    public final Collection<V> values() {
        Collection<V> collection = this.i;
        if (collection != null) {
            return collection;
        }
        s s2 = new s(this);
        this.i = s2;
        return s2;
    }

    /*
     * Exception performing whole class analysis.
     */
    public abstract class e<T>
    implements Iterator<T>,
    j$.util.Iterator {
        public int a;
        public int b;
        public k<K, V, E, S> c;
        public AtomicReferenceArray<E> d;
        public E e;
        public d<K, V, E, S> f;
        public d<K, V, E, S> g;
        public /* synthetic */ d h;

        public e(d d2) {
            this.h = d2;
            this.a = -1 + d2.a.length;
            this.b = -1;
            this.b();
        }

        public final d<K, V, E, S> a() {
            d<K, V, E, S> d2 = this.f;
            if (d2 != null) {
                this.g = d2;
                this.b();
                return this.g;
            }
            throw new NoSuchElementException();
        }

        public final boolean a(E e2) {
            Object k2;
            Object var5_3;
            block6 : {
                k2 = e2.a();
                if (e2.a() != null) break block6;
                var5_3 = null;
            }
            var5_3 = e2.d();
            if (var5_3 != null) {
                this.f = new /* Unavailable Anonymous Inner Class!! */;
                return true;
            }
            this.c.e();
            return false;
            finally {
                this.c.e();
            }
        }

        public final void b() {
            int n2;
            this.f = null;
            if (this.c()) {
                return;
            }
            if (this.d()) {
                return;
            }
            while ((n2 = this.a) >= 0) {
                k<K, V, E, S>[] arrk = this.h.a;
                this.a = n2 - 1;
                k k2 = arrk[n2];
                this.c = k2;
                if (k2.a == 0) continue;
                AtomicReferenceArray atomicReferenceArray = this.c.c;
                this.d = atomicReferenceArray;
                this.b = -1 + atomicReferenceArray.length();
                if (!this.d()) continue;
            }
        }

        public final boolean c() {
            E e2 = this.e;
            if (e2 != null) {
                E e3;
                while ((e3 = (this.e = e2.c())) != null) {
                    if (this.a(e3)) {
                        return true;
                    }
                    e2 = this.e;
                }
            }
            return false;
        }

        public final boolean d() {
            int n2;
            while ((n2 = this.b) >= 0) {
                AtomicReferenceArray<E> atomicReferenceArray = this.d;
                this.b = n2 - 1;
                f f2 = (f)atomicReferenceArray.get(n2);
                this.e = f2;
                if (f2 == null || !this.a(f2) && !this.c()) continue;
                return true;
            }
            return false;
        }

        @Override
        public /* synthetic */ void forEachRemaining(j.Consumer consumer) {
            Iterator$-CC.$default$forEachRemaining(this, consumer);
        }

        @Override
        public boolean hasNext() {
            return this.f != null;
        }

        @Override
        public void remove() {
            d<K, V, E, S> d2 = this.g;
            boolean bl = d2 != null;
            if (bl) {
                this.h.remove(d2.a);
                this.g = null;
                return;
            }
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    public static interface f<K, V, E extends f<K, V, E>> {
        public K a();

        public int b();

        public E c();

        public V d();
    }

    public static interface g<K, V, E extends f<K, V, E>, S extends k<K, V, E, S>> {
        public E a(S var1, E var2, E var3);

        public E a(S var1, K var2, int var3, E var4);

        public S a(d<K, V, E, S> var1, int var2, int var3);

        public l a();

        public void a(S var1, E var2, V var3);
    }

    public static abstract class j<E>
    extends AbstractSet<E>
    implements Set {
        public j(byte by) {
        }

        @Override
        public /* synthetic */ void forEach(j.Consumer consumer) {
            Iterable$-CC.$default$forEach((Iterable)this, consumer);
        }

        @Override
        public /* synthetic */ j.Stream parallelStream() {
            return Collection$-CC.$default$parallelStream((Collection)this);
        }

        @Override
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection$-CC.$default$removeIf((Collection)this, predicate);
        }

        @Override
        public /* synthetic */ j.Spliterator spliterator() {
            return Set$-CC.$default$spliterator((java.util.Set)this);
        }

        @Override
        public /* synthetic */ j.Stream stream() {
            return Collection$-CC.$default$stream((Collection)this);
        }

        @Override
        public Object[] toArray() {
            return d.a((Collection)this).toArray();
        }

        @Override
        public <T> T[] toArray(T[] arrT) {
            return d.a((Collection)this).toArray((Object[])arrT);
        }
    }

    public static abstract class k<K, V, E extends f<K, V, E>, S extends k<K, V, E, S>>
    extends ReentrantLock {
        public static final /* synthetic */ int $r8$clinit;
        public volatile int a;
        public int b;
        public volatile AtomicReferenceArray<E> c;
        public final AtomicInteger d = new AtomicInteger();
        public d<K, V, E, S> e;
        public int f;
        public int g;

        public k(d<K, V, E, S> d2, int n2, int n3) {
            int n4;
            this.e = d2;
            this.g = n3;
            AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(n2);
            this.f = n4 = 3 * atomicReferenceArray.length() / 4;
            if (n4 == this.g) {
                this.f = n4 + 1;
            }
            this.c = atomicReferenceArray;
        }

        public static <K, V, E extends f<K, V, E>> boolean a(E e2) {
            return (e2).d() == null;
        }

        public static <T> void c(ReferenceQueue<T> referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        public abstract S a();

        /*
         * Exception decompiling
         */
        public final V a(K var1_1, int var2_2, V var3_3, boolean var4_4) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [9[FORLOOP]], but top level block is 3[TRYBLOCK]
            // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
            // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
            // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
            // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
            // org.benf.cfr.reader.b.a(Driver.java:128)
            // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
            // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
            // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
            // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
            // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
            // java.lang.Thread.run(Thread.java:923)
            throw new IllegalStateException("Decompilation failed");
        }

        public final void a(E e2, V v2) {
            this.e.c.a(this.a(), e2, v2);
        }

        public final void a(ReferenceQueue<K> referenceQueue) {
            Reference reference;
            int n2 = 0;
            while ((reference = referenceQueue.poll()) != null) {
                int n3;
                f f2;
                AtomicReferenceArray<E> atomicReferenceArray;
                f f3 = (f)reference;
                d<K, V, E, S> d2 = this.e;
                int n4 = f3.b();
                k<K, V, E, S> k2 = d2.a(n4);
                k2.lock();
                try {
                    atomicReferenceArray = k2.c;
                    n3 = n4 & -1 + atomicReferenceArray.length();
                }
                catch (Throwable throwable) {
                    k2.unlock();
                    throw throwable;
                }
                for (f<K, V, E> f4 = f2 = (f)atomicReferenceArray.get((int)n3); f4 != null; f4 = f4.c()) {
                    if (f4 != f3) continue;
                    k2.b = 1 + k2.b;
                    f f5 = k2.b(f2, f4);
                    int n5 = -1 + k2.a;
                    atomicReferenceArray.set(n3, (Object)f5);
                    k2.a = n5;
                    break;
                }
                k2.unlock();
                if (++n2 == 16) break;
            }
        }

        public final E b(E e2, E e3) {
            int n2 = this.a;
            E e4 = e3.c();
            while (e2 != e3) {
                E e5 = this.e.c.a(this.a(), e2, e4);
                if (e5 != null) {
                    e4 = e5;
                } else {
                    --n2;
                }
                e2 = e2.c();
            }
            this.a = n2;
            return e4;
        }

        public void b() {
        }

        public final void b(ReferenceQueue<V> referenceQueue) {
            Reference reference;
            int n2 = 0;
            while ((reference = referenceQueue.poll()) != null) {
                f f2;
                int n3;
                AtomicReferenceArray<E> atomicReferenceArray;
                y y2 = (y)reference;
                d<K, V, E, S> d2 = this.e;
                E e2 = y2.a();
                int n4 = e2.b();
                k<K, V, E, S> k2 = d2.a(n4);
                K k3 = e2.a();
                k2.lock();
                try {
                    atomicReferenceArray = k2.c;
                    n3 = n4 & -1 + atomicReferenceArray.length();
                }
                catch (Throwable throwable) {
                    k2.unlock();
                    throw throwable;
                }
                for (f<K, V, E> f3 = f2 = (f)atomicReferenceArray.get((int)n3); f3 != null; f3 = f3.c()) {
                    K k4 = f3.a();
                    if (f3.b() != n4 || k4 == null) continue;
                    if (!k2.e.b.a(k3, k4)) continue;
                    if ((f3).e() != y2) break;
                    k2.b = 1 + k2.b;
                    f f4 = k2.b(f2, f3);
                    int n5 = -1 + k2.a;
                    atomicReferenceArray.set(n3, (Object)f4);
                    k2.a = n5;
                    break;
                }
                k2.unlock();
                if (++n2 == 16) break;
            }
        }

        public void c() {
        }

        public final E d(Object object, int n2) {
            if (this.a != 0) {
                AtomicReferenceArray<E> atomicReferenceArray = this.c;
                for (f<K, V, E> f2 = (f)atomicReferenceArray.get((int)(n2 & -1 + atomicReferenceArray.length())); f2 != null; f2 = f2.c()) {
                    if (f2.b() != n2) continue;
                    K k2 = f2.a();
                    if (k2 == null) {
                        this.d();
                        continue;
                    }
                    if (!this.e.b.a(object, k2)) continue;
                    return (E)f2;
                }
            }
            return null;
        }

        public final void d() {
            if (this.tryLock()) {
                try {
                    this.b();
                    return;
                }
                finally {
                    this.unlock();
                }
            }
        }

        public final void e() {
            if ((63 & this.d.incrementAndGet()) == 0) {
                this.f();
            }
        }

        public final void f() {
            if (this.tryLock()) {
                try {
                    this.b();
                    this.d.set(0);
                    return;
                }
                finally {
                    this.unlock();
                }
            }
        }
    }

    public static abstract class l
    extends Enum<l> {
        public static final /* enum */ l a;
        public static final /* enum */ l b;
        private static final /* synthetic */ l[] c;

        public static {
            1 var0 = new 1("STRONG");
            a = var0;
            2 var1_1 = new 2("WEAK");
            b = var1_1;
            c = new l[]{var0, var1_1};
        }

        public l(byte by) {
        }

        public static l valueOf(String string) {
            return (l)Enum.valueOf(l.class, (String)string);
        }

        public static l[] values() {
            return (l[])c.clone();
        }

        public abstract b<Object> a();
    }

    /*
     * Exception performing whole class analysis.
     */
    public final class s
    extends AbstractCollection<V>
    implements j$.util.Collection {
        public /* synthetic */ d a;

        public s(d d2) {
            this.a = d2;
        }

        @Override
        public final void clear() {
            this.a.clear();
        }

        @Override
        public final boolean contains(Object object) {
            return this.a.containsValue(object);
        }

        @Override
        public /* synthetic */ void forEach(j.Consumer consumer) {
            Iterable$-CC.$default$forEach((Iterable)this, consumer);
        }

        @Override
        public final boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override
        public final Iterator<V> iterator() {
            return new /* Unavailable Anonymous Inner Class!! */;
        }

        @Override
        public /* synthetic */ j.Stream parallelStream() {
            return Collection$-CC.$default$parallelStream((Collection)this);
        }

        @Override
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection$-CC.$default$removeIf((Collection)this, predicate);
        }

        @Override
        public final int size() {
            return this.a.size();
        }

        @Override
        public /* synthetic */ j.Spliterator spliterator() {
            return Collection$-CC.$default$spliterator((Collection)this);
        }

        @Override
        public /* synthetic */ j.Stream stream() {
            return Collection$-CC.$default$stream((Collection)this);
        }

        @Override
        public final Object[] toArray() {
            return d.a((Collection)this).toArray();
        }

        public final <T> T[] toArray(T[] arrT) {
            return d.a((Collection)this).toArray((Object[])arrT);
        }
    }

    public static interface y<K, V, E extends f<K, V, E>> {
        public E a();

        public y<K, V, E> a(ReferenceQueue<V> var1, E var2);

        public void clear();

        public V get();
    }

}

