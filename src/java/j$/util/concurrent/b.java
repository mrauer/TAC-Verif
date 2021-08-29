/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Error
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.Modifier
 *  sun.misc.Unsafe
 */
package j$.util.concurrent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

final class b {
    private static final Unsafe a;

    static {
        Field field = b.b();
        field.setAccessible(true);
        try {
            a = (Unsafe)field.get(null);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new Error("Couldn't get the Unsafe", (Throwable)illegalAccessException);
        }
    }

    public static final int a(Unsafe unsafe, Object object, long l2, int n2) {
        int n3;
        while (!unsafe.compareAndSwapInt(object, l2, n3 = unsafe.getIntVolatile(object, l2), n3 + n2)) {
        }
        return n3;
    }

    private static Field b() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            return field;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                if (!Modifier.isStatic((int)field.getModifiers()) || !Unsafe.class.isAssignableFrom(field.getType())) continue;
                return field;
            }
            throw new Error("Couldn't find the Unsafe", (Throwable)noSuchFieldException);
        }
    }

    public static Unsafe c() {
        return a;
    }
}

