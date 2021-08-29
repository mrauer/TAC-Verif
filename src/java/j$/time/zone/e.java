/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Objects
 *  java.util.Set
 *  java.util.TimeZone
 *  java.util.concurrent.ConcurrentMap
 *  java.util.concurrent.CopyOnWriteArrayList
 */
package j$.time.zone;

import j$.time.zone.c;
import j$.time.zone.d;
import j$.util.concurrent.ConcurrentHashMap;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class e {
    private static final CopyOnWriteArrayList a;
    private static final ConcurrentMap b;

    static {
        CopyOnWriteArrayList copyOnWriteArrayList;
        a = copyOnWriteArrayList = new CopyOnWriteArrayList();
        b = new ConcurrentHashMap(512, 0.75f, 2);
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<Object>(){

            public Object run() {
                String string = System.getProperty((String)"java.time.zone.DefaultZoneRulesProvider");
                if (string != null) {
                    try {
                        e e2 = (e)e.class.cast(Class.forName((String)string, (boolean)true, (ClassLoader)e.class.getClassLoader()).newInstance());
                        e.e(e2);
                        List.this.add((Object)e2);
                    }
                    catch (Exception exception) {
                        throw new Error((Throwable)exception);
                    }
                } else {
                    e.e(new b());
                }
                return null;
            }
        });
        copyOnWriteArrayList.addAll((Collection)arrayList);
    }

    protected e() {
    }

    public static Set a() {
        return new HashSet((Collection)b.keySet());
    }

    public static c b(String string, boolean bl) {
        Objects.requireNonNull((Object)string, (String)"zoneId");
        ConcurrentMap concurrentMap = b;
        e e2 = (e)concurrentMap.get((Object)string);
        if (e2 == null) {
            if (concurrentMap.isEmpty()) {
                throw new d("No time-zone data files registered");
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown time-zone ID: ");
            stringBuilder.append(string);
            throw new d(stringBuilder.toString());
        }
        return e2.c(string, bl);
    }

    public static void e(e e2) {
        Objects.requireNonNull((Object)e2, (String)"provider");
        for (String string : e2.d()) {
            Objects.requireNonNull((Object)string, (String)"zoneId");
            if ((e)b.putIfAbsent((Object)string, (Object)e2) == null) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to register zone as one already registered with that ID: ");
            stringBuilder.append(string);
            stringBuilder.append(", currently loading from provider: ");
            stringBuilder.append((Object)e2);
            throw new d(stringBuilder.toString());
        }
        a.add((Object)e2);
    }

    protected abstract c c(String var1, boolean var2);

    protected abstract Set d();

    private static final class b
    extends e {
        private final Set c;

        b() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            String[] arrstring = TimeZone.getAvailableIDs();
            int n2 = arrstring.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                linkedHashSet.add((Object)arrstring[i2]);
            }
            this.c = Collections.unmodifiableSet((Set)linkedHashSet);
        }

        @Override
        protected c c(String string, boolean bl) {
            if (this.c.contains((Object)string)) {
                return new c(TimeZone.getTimeZone((String)string));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Not a built-in time zone: ");
            stringBuilder.append(string);
            throw new d(stringBuilder.toString());
        }

        @Override
        protected Set d() {
            return this.c;
        }
    }

}

