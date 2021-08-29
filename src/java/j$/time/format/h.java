/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.text.DateFormatSymbols
 *  java.util.AbstractMap
 *  java.util.AbstractMap$SimpleImmutableEntry
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentMap
 *  java.util.function.Function
 *  java.util.function.ToDoubleFunction
 *  java.util.function.ToIntFunction
 *  java.util.function.ToLongFunction
 */
package j$.time.format;

import j$.C0;
import j$.E0;
import j$.G0;
import j$.N;
import j$.time.format.m;
import j$.time.temporal.j;
import j$.time.temporal.o;
import j$.util.Comparator;
import j$.util.Comparator$-CC;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Function;
import j$.util.function.ToLongFunction;
import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

class h {
    private static final ConcurrentMap a = new ConcurrentHashMap(16, 0.75f, 2);
    private static final java.util.Comparator b = new java.util.Comparator<Map.Entry<String, Long>>(){

        @Override
        public int compare(Object object, Object object2) {
            Map.Entry entry = (Map.Entry)object;
            return ((String)((Map.Entry)object2).getKey()).length() - ((String)entry.getKey()).length();
        }

        @Override
        public /* synthetic */ java.util.Comparator reversed() {
            return Comparator$-CC.$default$reversed(this);
        }

        @Override
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator$-CC.$default$thenComparing((java.util.Comparator)this, function);
        }

        @Override
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator$-CC.$default$thenComparing(this, function, comparator);
        }

        @Override
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator$-CC.$default$thenComparing((java.util.Comparator)this, comparator);
        }

        public /* synthetic */ java.util.Comparator thenComparing(java.util.function.Function function) {
            return Comparator$-CC.$default$thenComparing((java.util.Comparator)this, N.a(function));
        }

        public /* synthetic */ java.util.Comparator thenComparing(java.util.function.Function function, java.util.Comparator comparator) {
            return Comparator$-CC.$default$thenComparing(this, N.a(function), comparator);
        }

        @Override
        public /* synthetic */ java.util.Comparator thenComparingDouble(j$.util.function.ToDoubleFunction toDoubleFunction) {
            return Comparator$-CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator$-CC.$default$thenComparingDouble(this, C0.a(toDoubleFunction));
        }

        @Override
        public /* synthetic */ java.util.Comparator thenComparingInt(j$.util.function.ToIntFunction toIntFunction) {
            return Comparator$-CC.$default$thenComparingInt(this, toIntFunction);
        }

        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator$-CC.$default$thenComparingInt(this, E0.a(toIntFunction));
        }

        @Override
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator$-CC.$default$thenComparingLong(this, toLongFunction);
        }

        public /* synthetic */ java.util.Comparator thenComparingLong(java.util.function.ToLongFunction toLongFunction) {
            return Comparator$-CC.$default$thenComparingLong(this, G0.a(toLongFunction));
        }
    };
    public static final /* synthetic */ int c;

    h() {
    }

    private Object b(o o2, Locale locale) {
        ConcurrentMap concurrentMap = a;
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry((Object)o2, (Object)locale);
        Object object = concurrentMap.get((Object)simpleImmutableEntry);
        if (object == null) {
            int n2;
            Object object2;
            HashMap hashMap = new HashMap();
            j j2 = j.ERA;
            if (o2 == j2) {
                DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance((Locale)locale);
                HashMap hashMap2 = new HashMap();
                HashMap hashMap3 = new HashMap();
                String[] arrstring = dateFormatSymbols.getEras();
                for (n2 = 0; n2 < arrstring.length; ++n2) {
                    if (arrstring[n2].isEmpty()) continue;
                    long l2 = n2;
                    hashMap2.put((Object)l2, (Object)arrstring[n2]);
                    hashMap3.put((Object)l2, (Object)h.c(arrstring[n2]));
                }
                if (!hashMap2.isEmpty()) {
                    hashMap.put((Object)m.FULL, (Object)hashMap2);
                    hashMap.put((Object)m.SHORT, (Object)hashMap2);
                    hashMap.put((Object)m.NARROW, (Object)hashMap3);
                }
                object2 = new b((Map)hashMap);
            } else if (o2 == j.MONTH_OF_YEAR) {
                DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance((Locale)locale);
                HashMap hashMap4 = new HashMap();
                HashMap hashMap5 = new HashMap();
                String[] arrstring = dateFormatSymbols.getMonths();
                for (int i2 = 0; i2 < arrstring.length; ++i2) {
                    if (arrstring[i2].isEmpty()) continue;
                    long l3 = 1L + (long)i2;
                    hashMap4.put((Object)l3, (Object)arrstring[i2]);
                    hashMap5.put((Object)l3, (Object)h.c(arrstring[i2]));
                }
                if (!hashMap4.isEmpty()) {
                    hashMap.put((Object)m.FULL, (Object)hashMap4);
                    hashMap.put((Object)m.NARROW, (Object)hashMap5);
                }
                HashMap hashMap6 = new HashMap();
                String[] arrstring2 = dateFormatSymbols.getShortMonths();
                while (n2 < arrstring2.length) {
                    if (!arrstring2[n2].isEmpty()) {
                        hashMap6.put((Object)(1L + (long)n2), (Object)arrstring2[n2]);
                    }
                    ++n2;
                }
                if (!hashMap6.isEmpty()) {
                    hashMap.put((Object)m.SHORT, (Object)hashMap6);
                }
                object2 = new b((Map)hashMap);
            } else if (o2 == j.DAY_OF_WEEK) {
                DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance((Locale)locale);
                HashMap hashMap7 = new HashMap();
                String[] arrstring = dateFormatSymbols.getWeekdays();
                hashMap7.put((Object)1L, (Object)arrstring[2]);
                hashMap7.put((Object)2L, (Object)arrstring[3]);
                hashMap7.put((Object)3L, (Object)arrstring[4]);
                hashMap7.put((Object)4L, (Object)arrstring[5]);
                hashMap7.put((Object)5L, (Object)arrstring[6]);
                hashMap7.put((Object)6L, (Object)arrstring[7]);
                hashMap7.put((Object)7L, (Object)arrstring[1]);
                hashMap.put((Object)m.FULL, (Object)hashMap7);
                HashMap hashMap8 = new HashMap();
                hashMap8.put((Object)1L, (Object)h.c(arrstring[2]));
                hashMap8.put((Object)2L, (Object)h.c(arrstring[3]));
                hashMap8.put((Object)3L, (Object)h.c(arrstring[4]));
                hashMap8.put((Object)4L, (Object)h.c(arrstring[5]));
                hashMap8.put((Object)5L, (Object)h.c(arrstring[6]));
                hashMap8.put((Object)6L, (Object)h.c(arrstring[7]));
                hashMap8.put((Object)7L, (Object)h.c(arrstring[1]));
                hashMap.put((Object)m.NARROW, (Object)hashMap8);
                HashMap hashMap9 = new HashMap();
                String[] arrstring3 = dateFormatSymbols.getShortWeekdays();
                hashMap9.put((Object)1L, (Object)arrstring3[2]);
                hashMap9.put((Object)2L, (Object)arrstring3[3]);
                hashMap9.put((Object)3L, (Object)arrstring3[4]);
                hashMap9.put((Object)4L, (Object)arrstring3[5]);
                hashMap9.put((Object)5L, (Object)arrstring3[6]);
                hashMap9.put((Object)6L, (Object)arrstring3[7]);
                hashMap9.put((Object)7L, (Object)arrstring3[1]);
                hashMap.put((Object)m.SHORT, (Object)hashMap9);
                object2 = new b((Map)hashMap);
            } else if (o2 == j.AMPM_OF_DAY) {
                DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance((Locale)locale);
                HashMap hashMap10 = new HashMap();
                HashMap hashMap11 = new HashMap();
                String[] arrstring = dateFormatSymbols.getAmPmStrings();
                while (n2 < arrstring.length) {
                    if (!arrstring[n2].isEmpty()) {
                        long l4 = n2;
                        hashMap10.put((Object)l4, (Object)arrstring[n2]);
                        hashMap11.put((Object)l4, (Object)h.c(arrstring[n2]));
                    }
                    ++n2;
                }
                if (!hashMap10.isEmpty()) {
                    hashMap.put((Object)m.FULL, (Object)hashMap10);
                    hashMap.put((Object)m.SHORT, (Object)hashMap10);
                    hashMap.put((Object)m.NARROW, (Object)hashMap11);
                }
                object2 = new b((Map)hashMap);
            } else {
                object2 = "";
            }
            concurrentMap.putIfAbsent((Object)simpleImmutableEntry, object2);
            object = concurrentMap.get((Object)simpleImmutableEntry);
        }
        return object;
    }

    private static String c(String string) {
        return string.substring(0, Character.charCount((int)string.codePointAt(0)));
    }

    public String d(o o2, long l2, m m2, Locale locale) {
        Object object = this.b(o2, locale);
        if (object instanceof b) {
            return ((b)object).a(l2, m2);
        }
        return null;
    }

    public Iterator e(o o2, m m2, Locale locale) {
        Object object = this.b(o2, locale);
        if (object instanceof b) {
            return ((b)object).b(m2);
        }
        return null;
    }

    static final class b {
        private final Map a;
        private final Map b;

        b(Map map) {
            this.a = map;
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry entry2 : ((Map)entry.getValue()).entrySet()) {
                    String string = (String)entry2.getValue();
                    String string2 = (String)entry2.getValue();
                    Long l2 = (Long)entry2.getKey();
                    hashMap2.put((Object)string, (Object)new AbstractMap.SimpleImmutableEntry((Object)string2, (Object)l2));
                }
                ArrayList arrayList2 = new ArrayList(hashMap2.values());
                Collections.sort((List)arrayList2, (java.util.Comparator)b);
                hashMap.put((Object)((m)((Object)entry.getKey())), (Object)arrayList2);
                arrayList.addAll((Collection)arrayList2);
                hashMap.put(null, (Object)arrayList);
            }
            Collections.sort((List)arrayList, (java.util.Comparator)b);
            this.b = hashMap;
        }

        String a(long l2, m m2) {
            Map map = (Map)this.a.get((Object)m2);
            if (map != null) {
                return (String)map.get((Object)l2);
            }
            return null;
        }

        Iterator b(m m2) {
            List list = (List)this.b.get((Object)m2);
            if (list != null) {
                return list.iterator();
            }
            return null;
        }
    }

}

