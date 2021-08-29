/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.ArithmeticException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Comparator
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 *  java.util.Optional
 *  java.util.OptionalDouble
 *  java.util.OptionalInt
 *  java.util.OptionalLong
 *  java.util.concurrent.ConcurrentMap
 */
package j$.time;

import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.d;
import j$.time.temporal.f;
import j$.time.temporal.g;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.util.Comparator;
import j$.util.Comparator$-CC;
import j$.util.List$-CC;
import j$.util.Map;
import j$.util.Map$-CC;
import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentMap$-CC;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.p;
import j$.util.stream.A2;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.concurrent.ConcurrentMap;

public class e {
    public static /* synthetic */ int A(int n2, int n3) {
        int n4 = n2 % n3;
        if (n4 == 0) {
            return 0;
        }
        if ((1 | (n2 ^ n3) >> 31) > 0) {
            return n4;
        }
        return n4 + n3;
    }

    public static /* synthetic */ int B(long l2) {
        int n2 = (int)l2;
        if (l2 == (long)n2) {
            return n2;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long C(long l2, long l3) {
        long l4 = l2 + l3;
        long l5 = l3 ^ l2 LCMP 0L;
        boolean bl = true;
        boolean bl2 = l5 < 0 ? bl : false;
        if ((l2 ^ l4) < 0L) {
            bl = false;
        }
        if (bl2 | bl) {
            return l4;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long D(long l2, long l3) {
        long l4 = l2 % l3;
        if (l4 == 0L) {
            return 0L;
        }
        if ((1L | (l2 ^ l3) >> 63) > 0L) {
            return l4;
        }
        return l4 + l3;
    }

    public static /* synthetic */ long E(long l2, long l3) {
        long l4 = l2 / l3;
        if (l2 - l3 * l4 == 0L) {
            return l4;
        }
        if ((1L | (l2 ^ l3) >> 63) < 0L) {
            --l4;
        }
        return l4;
    }

    public static /* synthetic */ long F(long l2, long l3) {
        int n2 = Long.numberOfLeadingZeros((long)l2) + Long.numberOfLeadingZeros((long)l2) + Long.numberOfLeadingZeros((long)l3) + Long.numberOfLeadingZeros((long)l3);
        if (n2 > 65) {
            return l2 * l3;
        }
        if (n2 >= 64) {
            long l4 = l2 LCMP 0L;
            boolean bl = true;
            boolean bl2 = l4 >= 0 ? bl : false;
            if (l3 == Long.MIN_VALUE) {
                bl = false;
            }
            if (bl | bl2) {
                long l5 = l2 * l3;
                if (l4 == false || l5 / l2 == l3) {
                    return l5;
                }
            }
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long G(long l2, long l3) {
        long l4 = l2 - l3;
        long l5 = l3 ^ l2 LCMP 0L;
        boolean bl = true;
        boolean bl2 = l5 >= 0 ? bl : false;
        if ((l2 ^ l4) < 0L) {
            bl = false;
        }
        if (bl2 | bl) {
            return l4;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ Object H(java.util.Map map, Object object, Object object2, BiFunction biFunction) {
        if (map instanceof Map) {
            return ((Map)map).merge(object, object2, biFunction);
        }
        if (map instanceof ConcurrentMap) {
            return ConcurrentMap$-CC.$default$merge((ConcurrentMap)map, object, object2, biFunction);
        }
        return Map$-CC.$default$merge(map, object, object2, biFunction);
    }

    public static /* synthetic */ Object I(java.util.Map map, Object object, Object object2) {
        if (map instanceof Map) {
            return ((Map)map).putIfAbsent(object, object2);
        }
        return Map$-CC.$default$putIfAbsent(map, object, object2);
    }

    public static /* synthetic */ boolean J(java.util.Map map, Object object, Object object2) {
        if (map instanceof Map) {
            return ((Map)map).remove(object, object2);
        }
        return Map$-CC.$default$remove(map, object, object2);
    }

    public static /* synthetic */ Object K(java.util.Map map, Object object, Object object2) {
        if (map instanceof Map) {
            return ((Map)map).replace(object, object2);
        }
        return Map$-CC.$default$replace(map, object, object2);
    }

    public static /* synthetic */ boolean L(java.util.Map map, Object object, Object object2, Object object3) {
        if (map instanceof Map) {
            return ((Map)map).replace(object, object2, object3);
        }
        return Map$-CC.$default$replace(map, object, object2, object3);
    }

    public static /* synthetic */ void M(java.util.Map map, BiFunction biFunction) {
        if (map instanceof Map) {
            ((Map)map).replaceAll(biFunction);
            return;
        }
        if (map instanceof ConcurrentMap) {
            ConcurrentMap$-CC.$default$replaceAll((ConcurrentMap)map, biFunction);
            return;
        }
        Map$-CC.$default$replaceAll(map, biFunction);
    }

    public static /* synthetic */ void N(List list, java.util.Comparator comparator) {
        if (list instanceof j$.util.List) {
            ((j$.util.List)list).sort(comparator);
            return;
        }
        List$-CC.$default$sort(list, comparator);
    }

    public static /* synthetic */ java.util.Comparator O(java.util.Comparator comparator, java.util.Comparator comparator2) {
        if (comparator instanceof Comparator) {
            return ((Comparator)comparator).thenComparing(comparator2);
        }
        return Comparator$-CC.$default$thenComparing(comparator, comparator2);
    }

    public static void a(j.A2 a2) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void b(j.A2 a2) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void c(j.A2 a2) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static Temporal d(ChronoLocalDateTime chronoLocalDateTime, Temporal temporal) {
        return temporal.b(j$.time.temporal.j.EPOCH_DAY, chronoLocalDateTime.d().toEpochDay()).b(j$.time.temporal.j.NANO_OF_DAY, chronoLocalDateTime.c().T());
    }

    public static int e(ChronoLocalDateTime chronoLocalDateTime, ChronoLocalDateTime chronoLocalDateTime2) {
        int n2 = chronoLocalDateTime.d().E(chronoLocalDateTime2.d());
        if (n2 == 0 && (n2 = chronoLocalDateTime.c().F(chronoLocalDateTime2.c())) == 0) {
            n2 = chronoLocalDateTime.a().j(chronoLocalDateTime2.a());
        }
        return n2;
    }

    public static int f(TemporalAccessor temporalAccessor, o o2) {
        r r2 = temporalAccessor.p(o2);
        if (r2.g()) {
            long l2 = temporalAccessor.f(o2);
            if (r2.h(l2)) {
                return (int)l2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid value for ");
            stringBuilder.append((Object)o2);
            stringBuilder.append(" (valid values ");
            stringBuilder.append((Object)r2);
            stringBuilder.append("): ");
            stringBuilder.append(l2);
            throw new j$.time.g(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid field ");
        stringBuilder.append((Object)o2);
        stringBuilder.append(" for get() method, use getLong() instead");
        throw new q(stringBuilder.toString());
    }

    public static long g(Spliterator spliterator) {
        if ((64 & spliterator.characteristics()) == 0) {
            return -1L;
        }
        return spliterator.estimateSize();
    }

    public static boolean h(Spliterator spliterator, int n2) {
        return (n2 & spliterator.characteristics()) == n2;
    }

    public static Object i(ChronoLocalDateTime chronoLocalDateTime, TemporalQuery temporalQuery) {
        if (temporalQuery != f.a && temporalQuery != i.a && temporalQuery != j$.time.temporal.e.a) {
            if (temporalQuery == h.a) {
                return chronoLocalDateTime.c();
            }
            if (temporalQuery == d.a) {
                return chronoLocalDateTime.a();
            }
            if (temporalQuery == g.a) {
                return ChronoUnit.NANOS;
            }
            return temporalQuery.queryFrom(chronoLocalDateTime);
        }
        return null;
    }

    public static Object j(TemporalAccessor temporalAccessor, TemporalQuery temporalQuery) {
        if (temporalQuery != f.a && temporalQuery != d.a && temporalQuery != g.a) {
            return temporalQuery.queryFrom(temporalAccessor);
        }
        return null;
    }

    public static r k(TemporalAccessor temporalAccessor, o o2) {
        if (o2 instanceof j$.time.temporal.j) {
            if (temporalAccessor.h(o2)) {
                return o2.p();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported field: ");
            stringBuilder.append((Object)o2);
            throw new q(stringBuilder.toString());
        }
        Objects.requireNonNull((Object)o2, (String)"field");
        return o2.H(temporalAccessor);
    }

    public static long l(ChronoLocalDateTime chronoLocalDateTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull((Object)zoneOffset, (String)"offset");
        return 86400L * chronoLocalDateTime.d().toEpochDay() + (long)chronoLocalDateTime.c().U() - (long)zoneOffset.L();
    }

    public static /* synthetic */ Object m(java.util.Map map, Object object, BiFunction biFunction) {
        if (map instanceof Map) {
            return ((Map)map).compute(object, biFunction);
        }
        if (map instanceof ConcurrentMap) {
            return ConcurrentMap$-CC.$default$compute((ConcurrentMap)map, object, biFunction);
        }
        return Map$-CC.$default$compute(map, object, biFunction);
    }

    public static /* synthetic */ Object n(java.util.Map map, Object object, Function function) {
        if (map instanceof Map) {
            return ((Map)map).computeIfAbsent(object, function);
        }
        if (map instanceof ConcurrentMap) {
            return ConcurrentMap$-CC.$default$computeIfAbsent((ConcurrentMap)map, object, function);
        }
        return Map$-CC.$default$computeIfAbsent(map, object, function);
    }

    public static /* synthetic */ Object o(java.util.Map map, Object object, BiFunction biFunction) {
        if (map instanceof Map) {
            return ((Map)map).computeIfPresent(object, biFunction);
        }
        if (map instanceof ConcurrentMap) {
            return ConcurrentMap$-CC.$default$computeIfPresent((ConcurrentMap)map, object, biFunction);
        }
        return Map$-CC.$default$computeIfPresent(map, object, biFunction);
    }

    public static Optional p(java.util.Optional optional) {
        if (optional == null) {
            return null;
        }
        if (optional.isPresent()) {
            return Optional.d(optional.get());
        }
        return Optional.a();
    }

    public static j$.util.o q(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        if (optionalDouble.isPresent()) {
            return j$.util.o.d(optionalDouble.getAsDouble());
        }
        return j$.util.o.a();
    }

    public static p r(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        if (optionalInt.isPresent()) {
            return p.d(optionalInt.getAsInt());
        }
        return p.a();
    }

    public static j$.util.q s(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        if (optionalLong.isPresent()) {
            return j$.util.q.d(optionalLong.getAsLong());
        }
        return j$.util.q.a();
    }

    public static java.util.Optional t(Optional optional) {
        if (optional == null) {
            return null;
        }
        if (optional.c()) {
            return java.util.Optional.of((Object)optional.b());
        }
        return java.util.Optional.empty();
    }

    public static OptionalDouble u(j$.util.o o2) {
        if (o2 == null) {
            return null;
        }
        if (o2.c()) {
            return OptionalDouble.of((double)o2.b());
        }
        return OptionalDouble.empty();
    }

    public static OptionalInt v(p p2) {
        if (p2 == null) {
            return null;
        }
        if (p2.c()) {
            return OptionalInt.of((int)p2.b());
        }
        return OptionalInt.empty();
    }

    public static OptionalLong w(j$.util.q q2) {
        if (q2 == null) {
            return null;
        }
        if (q2.c()) {
            return OptionalLong.of((long)q2.b());
        }
        return OptionalLong.empty();
    }

    public static boolean x(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }

    public static /* synthetic */ void y(java.util.Map map, BiConsumer biConsumer) {
        if (map instanceof Map) {
            ((Map)map).forEach(biConsumer);
            return;
        }
        if (map instanceof ConcurrentMap) {
            ConcurrentMap$-CC.$default$forEach((ConcurrentMap)map, biConsumer);
            return;
        }
        Map$-CC.$default$forEach(map, biConsumer);
    }

    public static /* synthetic */ Object z(java.util.Map map, Object object, Object object2) {
        if (map instanceof Map) {
            return ((Map)map).getOrDefault(object, object2);
        }
        if (map instanceof ConcurrentMap) {
            return ConcurrentMap$-CC.$default$getOrDefault((ConcurrentMap)map, object, object2);
        }
        return Map$-CC.$default$getOrDefault(map, object, object2);
    }
}

