/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Error
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationTargetException
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 *  java.util.Set
 *  java.util.function.BiConsumer
 *  java.util.function.BiFunction
 *  java.util.function.Function
 */
package j$.util;

import j$.N;
import j$.r;
import j$.t;
import j$.time.e;
import j$.util.Collection$-EL;
import j$.util.List;
import j$.util.List$-CC;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

public class DesugarCollections {
    public static final Class a;
    static final Class b;
    private static final Field c;
    private static final Field d;
    private static final Constructor e;
    private static final Constructor f;

    /*
     * Exception decompiling
     */
    static {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl69 : ALOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
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

    private DesugarCollections() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void c(Iterable iterable, Consumer consumer) {
        Field field = c;
        if (field == null) {
            try {
                Collection$-EL.a((Collection)d.get((Object)iterable), consumer);
                return;
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new Error("Runtime illegal access in synchronized collection forEach fall-back.", (Throwable)illegalAccessException);
            }
        }
        try {
            Object object;
            Object object2 = object = field.get((Object)iterable);
            // MONITORENTER : object2
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new Error("Runtime illegal access in synchronized collection forEach.", (Throwable)illegalAccessException);
        }
        Collection$-EL.a((Collection)d.get((Object)iterable), consumer);
        // MONITOREXIT : object2
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    static boolean d(Collection collection, Predicate predicate) {
        Field field = c;
        if (field == null) {
            try {
                return Collection$-EL.removeIf((Collection)d.get((Object)collection), predicate);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new Error("Runtime illegal access in synchronized collection removeIf fall-back.", (Throwable)illegalAccessException);
            }
        }
        try {
            Object object;
            Object object2 = object = field.get((Object)collection);
            // MONITORENTER : object2
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new Error("Runtime illegal access in synchronized collection removeIf.", (Throwable)illegalAccessException);
        }
        boolean bl = Collection$-EL.removeIf((Collection)d.get((Object)collection), predicate);
        // MONITOREXIT : object2
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    static void e(java.util.List list, j.UnaryOperator unaryOperator) {
        Field field = c;
        if (field == null) {
            try {
                java.util.List list2 = (java.util.List)d.get((Object)list);
                if (list2 instanceof List) {
                    ((List)list2).replaceAll(unaryOperator);
                    return;
                }
                List$-CC.$default$replaceAll(list2, unaryOperator);
                return;
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new Error("Runtime illegal access in synchronized list replaceAll fall-back.", (Throwable)illegalAccessException);
            }
        }
        try {
            Object object;
            Object object2 = object = field.get((Object)list);
            // MONITORENTER : object2
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new Error("Runtime illegal access in synchronized list replaceAll.", (Throwable)illegalAccessException);
        }
        java.util.List list3 = (java.util.List)d.get((Object)list);
        if (list3 instanceof List) {
            ((List)list3).replaceAll(unaryOperator);
            return;
        }
        List$-CC.$default$replaceAll(list3, unaryOperator);
        // MONITOREXIT : object2
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    static void f(java.util.List list, Comparator comparator) {
        Field field = c;
        if (field == null) {
            try {
                e.N((java.util.List)d.get((Object)list), comparator);
                return;
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new Error("Runtime illegal access in synchronized collection sort fall-back.", (Throwable)illegalAccessException);
            }
        }
        try {
            Object object;
            Object object2 = object = field.get((Object)list);
            // MONITORENTER : object2
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new Error("Runtime illegal access in synchronized list sort.", (Throwable)illegalAccessException);
        }
        e.N((java.util.List)d.get((Object)list), comparator);
        // MONITOREXIT : object2
    }

    public static java.util.Map synchronizedMap(java.util.Map map) {
        return new a(map);
    }

    private static class a<K, V>
    implements java.util.Map<K, V>,
    Serializable,
    Map {
        private final java.util.Map a;
        final Object b;
        private transient Set c;
        private transient Set d;
        private transient Collection e;

        a(java.util.Map map) {
            Objects.requireNonNull((Object)map);
            this.a = map;
            this.b = this;
        }

        private Set a(Set set, Object object) {
            void var3_7;
            if (f == null) {
                return Collections.synchronizedSet((Set)set);
            }
            try {
                Set set2 = (Set)f.newInstance(new Object[]{set, object});
                return set2;
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InstantiationException instantiationException) {
                // empty catch block
            }
            throw new Error("Unable to instantiate a synchronized list.", (Throwable)var3_7);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void clear() {
            Object object;
            Object object2 = object = this.b;
            synchronized (object2) {
                this.a.clear();
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public Object compute(Object object, BiFunction biFunction) {
            Object object2;
            Object object3 = object2 = this.b;
            synchronized (object3) {
                return e.m(this.a, object, biFunction);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public Object compute(Object object, java.util.function.BiFunction biFunction) {
            Object object2;
            BiFunction biFunction2 = t.a(biFunction);
            Object object3 = object2 = this.b;
            synchronized (object3) {
                return e.m(this.a, object, biFunction2);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public Object computeIfAbsent(Object object, Function function) {
            Object object2;
            Object object3 = object2 = this.b;
            synchronized (object3) {
                return e.n(this.a, object, function);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public Object computeIfAbsent(Object object, java.util.function.Function function) {
            Object object2;
            Function function2 = N.a(function);
            Object object3 = object2 = this.b;
            synchronized (object3) {
                return e.n(this.a, object, function2);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public Object computeIfPresent(Object object, BiFunction biFunction) {
            Object object2;
            Object object3 = object2 = this.b;
            synchronized (object3) {
                return e.o(this.a, object, biFunction);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public Object computeIfPresent(Object object, java.util.function.BiFunction biFunction) {
            Object object2;
            BiFunction biFunction2 = t.a(biFunction);
            Object object3 = object2 = this.b;
            synchronized (object3) {
                return e.o(this.a, object, biFunction2);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public boolean containsKey(Object object) {
            Object object2;
            Object object3 = object2 = this.b;
            synchronized (object3) {
                return this.a.containsKey(object);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public boolean containsValue(Object object) {
            Object object2;
            Object object3 = object2 = this.b;
            synchronized (object3) {
                return this.a.containsValue(object);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public Set entrySet() {
            Object object;
            Object object2 = object = this.b;
            synchronized (object2) {
                if (this.d != null) return this.d;
                this.d = this.a(this.a.entrySet(), this.b);
                return this.d;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public boolean equals(Object object) {
            Object object2;
            if (this == object) {
                return true;
            }
            Object object3 = object2 = this.b;
            synchronized (object3) {
                return this.a.equals(object);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void forEach(BiConsumer biConsumer) {
            Object object;
            Object object2 = object = this.b;
            synchronized (object2) {
                e.y(this.a, biConsumer);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void forEach(java.util.function.BiConsumer biConsumer) {
            Object object;
            BiConsumer biConsumer2 = r.b(biConsumer);
            Object object2 = object = this.b;
            synchronized (object2) {
                e.y(this.a, biConsumer2);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public Object get(Object object) {
            Object object2;
            Object object3 = object2 = this.b;
            synchronized (object3) {
                return this.a.get(object);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public Object getOrDefault(Object object, Object object2) {
            Object object3;
            Object object4 = object3 = this.b;
            synchronized (object4) {
                return e.z(this.a, object, object2);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public int hashCode() {
            Object object;
            Object object2 = object = this.b;
            synchronized (object2) {
                return this.a.hashCode();
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public boolean isEmpty() {
            Object object;
            Object object2 = object = this.b;
            synchronized (object2) {
                return this.a.isEmpty();
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public Set keySet() {
            Object object;
            Object object2 = object = this.b;
            synchronized (object2) {
                if (this.c != null) return this.c;
                this.c = this.a(this.a.keySet(), this.b);
                return this.c;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public Object merge(Object object, Object object2, BiFunction biFunction) {
            Object object3;
            Object object4 = object3 = this.b;
            synchronized (object4) {
                return e.H(this.a, object, object2, biFunction);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public Object merge(Object object, Object object2, java.util.function.BiFunction biFunction) {
            Object object3;
            BiFunction biFunction2 = t.a(biFunction);
            Object object4 = object3 = this.b;
            synchronized (object4) {
                return e.H(this.a, object, object2, biFunction2);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public Object put(Object object, Object object2) {
            Object object3;
            Object object4 = object3 = this.b;
            synchronized (object4) {
                return this.a.put(object, object2);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void putAll(java.util.Map map) {
            Object object;
            Object object2 = object = this.b;
            synchronized (object2) {
                this.a.putAll(map);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public Object putIfAbsent(Object object, Object object2) {
            Object object3;
            Object object4 = object3 = this.b;
            synchronized (object4) {
                return e.I(this.a, object, object2);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public Object remove(Object object) {
            Object object2;
            Object object3 = object2 = this.b;
            synchronized (object3) {
                return this.a.remove(object);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public boolean remove(Object object, Object object2) {
            Object object3;
            Object object4 = object3 = this.b;
            synchronized (object4) {
                return e.J(this.a, object, object2);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public Object replace(Object object, Object object2) {
            Object object3;
            Object object4 = object3 = this.b;
            synchronized (object4) {
                return e.K(this.a, object, object2);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public boolean replace(Object object, Object object2, Object object3) {
            Object object4;
            Object object5 = object4 = this.b;
            synchronized (object5) {
                return e.L(this.a, object, object2, object3);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void replaceAll(BiFunction biFunction) {
            Object object;
            Object object2 = object = this.b;
            synchronized (object2) {
                e.M(this.a, biFunction);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void replaceAll(java.util.function.BiFunction biFunction) {
            Object object;
            BiFunction biFunction2 = t.a(biFunction);
            Object object2 = object = this.b;
            synchronized (object2) {
                e.M(this.a, biFunction2);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public int size() {
            Object object;
            Object object2 = object = this.b;
            synchronized (object2) {
                return this.a.size();
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public String toString() {
            Object object;
            Object object2 = object = this.b;
            synchronized (object2) {
                return this.a.toString();
            }
        }

        /*
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public Collection values() {
            void var6_6;
            Object object;
            Object object2 = object = this.b;
            // MONITORENTER : object2
            if (this.e == null) {
                Collection collection;
                Collection collection2 = this.a.values();
                Object object3 = this.b;
                if (e == null) {
                    collection = Collections.synchronizedCollection((Collection)collection2);
                } else {
                    collection = (Collection)e.newInstance(new Object[]{collection2, object3});
                }
                this.e = collection;
            }
            Collection collection = this.e;
            // MONITOREXIT : object2
            return collection;
            catch (InvocationTargetException invocationTargetException) {
                throw new Error("Unable to instantiate a synchronized list.", (Throwable)var6_6);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new Error("Unable to instantiate a synchronized list.", (Throwable)var6_6);
            }
            catch (InstantiationException instantiationException) {
                throw new Error("Unable to instantiate a synchronized list.", (Throwable)var6_6);
            }
        }
    }

}

