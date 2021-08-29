/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Objects
 *  java.util.Set
 */
package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.e;
import j$.time.chrono.g;
import j$.time.format.DateTimeFormatter;
import j$.time.format.i;
import j$.time.format.j;
import j$.time.format.k;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.o;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

final class d {
    private DateTimeFormatter a;
    private boolean b = true;
    private boolean c = true;
    private final ArrayList d;
    private ArrayList e;

    d(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList;
        this.d = arrayList = new ArrayList();
        this.e = null;
        this.a = dateTimeFormatter;
        arrayList.add((Object)new j());
    }

    static boolean c(char c2, char c4) {
        return c2 == c4 || Character.toUpperCase((char)c2) == Character.toUpperCase((char)c4) || Character.toLowerCase((char)c2) == Character.toLowerCase((char)c4);
        {
        }
    }

    private j e() {
        ArrayList arrayList = this.d;
        return (j)arrayList.get(-1 + arrayList.size());
    }

    void a(Consumer consumer) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add((Object)consumer);
    }

    boolean b(char c2, char c4) {
        if (this.b) {
            return c2 == c4;
        }
        return d.c(c2, c4);
    }

    d d() {
        d d2 = new d(this.a);
        d2.b = this.b;
        d2.c = this.c;
        return d2;
    }

    void f(boolean bl) {
        ArrayList arrayList;
        int n2;
        if (bl) {
            arrayList = this.d;
            n2 = -2 + arrayList.size();
        } else {
            arrayList = this.d;
            n2 = -1 + arrayList.size();
        }
        arrayList.remove(n2);
    }

    i g() {
        return this.a.c();
    }

    e h() {
        e e2 = this.e().c;
        if (e2 == null && (e2 = this.a.b()) == null) {
            e2 = g.a;
        }
        return e2;
    }

    Locale i() {
        return this.a.d();
    }

    Long j(o o2) {
        return (Long)this.e().a.get((Object)o2);
    }

    boolean k() {
        return this.b;
    }

    boolean l() {
        return this.c;
    }

    void m(boolean bl) {
        this.b = bl;
    }

    void n(ZoneId zoneId) {
        Objects.requireNonNull((Object)zoneId, (String)"zone");
        this.e().b = zoneId;
    }

    int o(o o2, long l2, int n2, int n3) {
        Objects.requireNonNull((Object)o2, (String)"field");
        Long l3 = (Long)this.e().a.put((Object)o2, (Object)l2);
        if (l3 != null && l3 != l2) {
            n3 = n2;
        }
        return n3;
    }

    void p() {
        this.e().d = true;
    }

    void q(boolean bl) {
        this.c = bl;
    }

    void r() {
        ArrayList arrayList = this.d;
        j j2 = this.e();
        Objects.requireNonNull((Object)j2);
        j j3 = new j();
        j3.a.putAll(j2.a);
        j3.b = j2.b;
        j3.c = j2.c;
        j3.d = j2.d;
        arrayList.add((Object)j3);
    }

    boolean s(CharSequence charSequence, int n2, CharSequence charSequence2, int n3, int n4) {
        if (n2 + n4 <= charSequence.length()) {
            if (n3 + n4 > charSequence2.length()) {
                return false;
            }
            if (this.b) {
                for (int i2 = 0; i2 < n4; ++i2) {
                    if (charSequence.charAt(n2 + i2) == charSequence2.charAt(n3 + i2)) continue;
                    return false;
                }
            } else {
                for (int i4 = 0; i4 < n4; ++i4) {
                    char c2;
                    char c4 = charSequence.charAt(n2 + i4);
                    if (c4 == (c2 = charSequence2.charAt(n3 + i4)) || Character.toUpperCase((char)c4) == Character.toUpperCase((char)c2) || Character.toLowerCase((char)c4) == Character.toLowerCase((char)c2)) continue;
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    TemporalAccessor t(k k2, Set set) {
        j j2 = this.e();
        j2.c = this.h();
        ZoneId zoneId = j2.b;
        if (zoneId == null) {
            zoneId = this.a.e();
        }
        j2.b = zoneId;
        j2.m(k2, set);
        return j2;
    }

    public String toString() {
        return this.e().toString();
    }
}

