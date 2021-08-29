/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ConcurrentModificationException
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 */
package j$.util;

import j$.time.e;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class Map$-CC {
    public static Object $default$compute(Map map, Object object, BiFunction biFunction) {
        Objects.requireNonNull((Object)biFunction);
        Object object2 = map.get(object);
        Object object3 = biFunction.apply(object, object2);
        if (object3 == null) {
            if (object2 == null && !map.containsKey(object)) {
                return null;
            }
            map.remove(object);
            return null;
        }
        map.put(object, object3);
        return object3;
    }

    public static Object $default$computeIfAbsent(Map map, Object object, Function function) {
        Object object2;
        Objects.requireNonNull((Object)function);
        Object object3 = map.get(object);
        if (object3 == null && (object2 = function.apply(object)) != null) {
            map.put(object, object2);
            return object2;
        }
        return object3;
    }

    public static Object $default$computeIfPresent(Map map, Object object, BiFunction biFunction) {
        Objects.requireNonNull((Object)biFunction);
        Object object2 = map.get(object);
        if (object2 != null) {
            Object object3 = biFunction.apply(object, object2);
            if (object3 != null) {
                map.put(object, object3);
                return object3;
            }
            map.remove(object);
        }
        return null;
    }

    public static void $default$forEach(Map map, BiConsumer biConsumer) {
        Objects.requireNonNull((Object)biConsumer);
        for (Map.Entry entry : map.entrySet()) {
            Object object;
            Object object2;
            try {
                object2 = entry.getKey();
                object = entry.getValue();
            }
            catch (IllegalStateException illegalStateException) {
                throw new ConcurrentModificationException((Throwable)illegalStateException);
            }
            biConsumer.accept(object2, object);
        }
    }

    public static Object $default$getOrDefault(Map map, Object object, Object object2) {
        Object object3 = map.get(object);
        if (object3 != null || map.containsKey(object)) {
            object2 = object3;
        }
        return object2;
    }

    public static Object $default$merge(Map map, Object object, Object object2, BiFunction biFunction) {
        Objects.requireNonNull((Object)biFunction);
        Objects.requireNonNull((Object)object2);
        Object object3 = map.get(object);
        if (object3 != null) {
            object2 = biFunction.apply(object3, object2);
        }
        if (object2 == null) {
            map.remove(object);
            return object2;
        }
        map.put(object, object2);
        return object2;
    }

    public static Object $default$putIfAbsent(Map map, Object object, Object object2) {
        Object object3 = map.get(object);
        if (object3 == null) {
            object3 = map.put(object, object2);
        }
        return object3;
    }

    public static boolean $default$remove(Map map, Object object, Object object2) {
        Object object3 = map.get(object);
        if (e.x(object3, object2) && (object3 != null || map.containsKey(object))) {
            map.remove(object);
            return true;
        }
        return false;
    }

    public static Object $default$replace(Map map, Object object, Object object2) {
        Object object3 = map.get(object);
        if (object3 != null || map.containsKey(object)) {
            object3 = map.put(object, object2);
        }
        return object3;
    }

    public static boolean $default$replace(Map map, Object object, Object object2, Object object3) {
        Object object4 = map.get(object);
        if (e.x(object4, object2) && (object4 != null || map.containsKey(object))) {
            map.put(object, object3);
            return true;
        }
        return false;
    }

    public static void $default$replaceAll(Map map, BiFunction biFunction) {
        Objects.requireNonNull((Object)biFunction);
        for (Map.Entry entry : map.entrySet()) {
            Object object;
            Object object2;
            try {
                object2 = entry.getKey();
                object = entry.getValue();
            }
            catch (IllegalStateException illegalStateException) {
                throw new ConcurrentModificationException((Throwable)illegalStateException);
            }
            Object object3 = biFunction.apply(object2, object);
            try {
                entry.setValue(object3);
            }
            catch (IllegalStateException illegalStateException) {
                throw new ConcurrentModificationException((Throwable)illegalStateException);
            }
        }
    }
}

