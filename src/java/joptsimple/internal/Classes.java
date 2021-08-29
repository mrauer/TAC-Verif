/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.Void
 *  java.util.HashMap
 *  java.util.Map
 */
package joptsimple.internal;

import java.util.HashMap;
import java.util.Map;

public final class Classes {
    public static final Map<Class<?>, Class<?>> WRAPPERS;

    public static {
        HashMap hashMap;
        WRAPPERS = hashMap = new HashMap(13);
        hashMap.put((Object)Boolean.TYPE, Boolean.class);
        hashMap.put((Object)Byte.TYPE, Byte.class);
        hashMap.put((Object)Character.TYPE, Character.class);
        hashMap.put((Object)Double.TYPE, Double.class);
        hashMap.put((Object)Float.TYPE, Float.class);
        hashMap.put((Object)Integer.TYPE, Integer.class);
        hashMap.put((Object)Long.TYPE, Long.class);
        hashMap.put((Object)Short.TYPE, Short.class);
        hashMap.put((Object)Void.TYPE, Void.class);
    }
}

