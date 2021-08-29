/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 *  java.util.concurrent.ConcurrentMap
 */
package j$.time;

import j$.time.ZoneId;
import j$.time.e;
import j$.time.g;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.i;
import j$.time.temporal.j;
import j$.time.temporal.l;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.zone.c;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

public final class ZoneOffset
extends ZoneId
implements TemporalAccessor,
l,
Comparable<ZoneOffset>,
Serializable {
    public static final ZoneOffset UTC;
    private static final ConcurrentMap b;
    private static final ConcurrentMap c;
    public static final ZoneOffset d;
    public static final ZoneOffset e;
    private final int f;
    private final transient String g;

    static {
        b = new ConcurrentHashMap(16, 0.75f, 4);
        c = new ConcurrentHashMap(16, 0.75f, 4);
        UTC = ZoneOffset.O(0);
        d = ZoneOffset.O(-64800);
        e = ZoneOffset.O(64800);
    }

    private ZoneOffset(int n2) {
        String string;
        this.f = n2;
        if (n2 == 0) {
            string = "Z";
        } else {
            int n3 = Math.abs((int)n2);
            StringBuilder stringBuilder = new StringBuilder();
            int n4 = n3 / 3600;
            int n5 = n3 / 60 % 60;
            String string2 = n2 < 0 ? "-" : "+";
            stringBuilder.append(string2);
            String string3 = n4 < 10 ? "0" : "";
            stringBuilder.append(string3);
            stringBuilder.append(n4);
            String string4 = ":0";
            String string5 = n5 < 10 ? string4 : ":";
            stringBuilder.append(string5);
            stringBuilder.append(n5);
            int n6 = n3 % 60;
            if (n6 != 0) {
                if (n6 >= 10) {
                    string4 = ":";
                }
                stringBuilder.append(string4);
                stringBuilder.append(n6);
            }
            string = stringBuilder.toString();
        }
        this.g = string;
    }

    public static ZoneOffset K(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull((Object)temporalAccessor, (String)"temporal");
        ZoneOffset zoneOffset = (ZoneOffset)temporalAccessor.t(j$.time.temporal.e.a);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to obtain ZoneOffset from TemporalAccessor: ");
        stringBuilder.append((Object)temporalAccessor);
        stringBuilder.append(" of type ");
        stringBuilder.append(temporalAccessor.getClass().getName());
        throw new g(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     */
    public static ZoneOffset M(String string) {
        int n2;
        int n3;
        int n4;
        block10 : {
            block7 : {
                block6 : {
                    block11 : {
                        block8 : {
                            block9 : {
                                Objects.requireNonNull((Object)string, (String)"offsetId");
                                ZoneOffset zoneOffset = (ZoneOffset)c.get((Object)string);
                                if (zoneOffset != null) {
                                    return zoneOffset;
                                }
                                int n5 = string.length();
                                if (n5 == 2) break block6;
                                if (n5 == 3) break block7;
                                if (n5 == 5) break block8;
                                if (n5 == 6) break block9;
                                if (n5 != 7) {
                                    if (n5 != 9) {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("Invalid ID for ZoneOffset, invalid format: ");
                                        stringBuilder.append(string);
                                        throw new g(stringBuilder.toString());
                                    }
                                    n3 = ZoneOffset.P(string, 1, false);
                                    n2 = ZoneOffset.P(string, 4, true);
                                    n4 = ZoneOffset.P(string, 7, true);
                                } else {
                                    n3 = ZoneOffset.P(string, 1, false);
                                    n2 = ZoneOffset.P(string, 3, false);
                                    n4 = ZoneOffset.P(string, 5, false);
                                }
                                break block10;
                            }
                            n3 = ZoneOffset.P(string, 1, false);
                            n2 = ZoneOffset.P(string, 4, true);
                            break block11;
                        }
                        n3 = ZoneOffset.P(string, 1, false);
                        n2 = ZoneOffset.P(string, 3, false);
                    }
                    n4 = 0;
                    break block10;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string.charAt(0));
                stringBuilder.append("0");
                stringBuilder.append(string.charAt(1));
                string = stringBuilder.toString();
            }
            n3 = ZoneOffset.P(string, 1, false);
            n2 = 0;
            n4 = 0;
        }
        char c2 = string.charAt(0);
        if (c2 != '+' && c2 != '-') {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid ID for ZoneOffset, plus/minus not found when expected: ");
            stringBuilder.append(string);
            throw new g(stringBuilder.toString());
        }
        if (c2 == '-') {
            return ZoneOffset.N(-n3, -n2, -n4);
        }
        return ZoneOffset.N(n3, n2, n4);
    }

    public static ZoneOffset N(int n2, int n3, int n4) {
        if (n2 >= -18 && n2 <= 18) {
            if (n2 > 0) {
                if (n3 < 0 || n4 < 0) {
                    throw new g("Zone offset minutes and seconds must be positive because hours is positive");
                }
            } else if (n2 < 0) {
                if (n3 > 0 || n4 > 0) {
                    throw new g("Zone offset minutes and seconds must be negative because hours is negative");
                }
            } else if (n3 > 0 && n4 < 0 || n3 < 0 && n4 > 0) {
                throw new g("Zone offset minutes and seconds must have the same sign");
            }
            if (n3 >= -59 && n3 <= 59) {
                if (n4 >= -59 && n4 <= 59) {
                    if (Math.abs((int)n2) == 18 && (n3 | n4) != 0) {
                        throw new g("Zone offset not in valid range: -18:00 to +18:00");
                    }
                    return ZoneOffset.O(n4 + (n2 * 3600 + n3 * 60));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Zone offset seconds not in valid range: value ");
                stringBuilder.append(n4);
                stringBuilder.append(" is not in the range -59 to 59");
                throw new g(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Zone offset minutes not in valid range: value ");
            stringBuilder.append(n3);
            stringBuilder.append(" is not in the range -59 to 59");
            throw new g(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Zone offset hours not in valid range: value ");
        stringBuilder.append(n2);
        stringBuilder.append(" is not in the range -18 to 18");
        throw new g(stringBuilder.toString());
    }

    public static ZoneOffset O(int n2) {
        if (n2 >= -64800 && n2 <= 64800) {
            if (n2 % 900 == 0) {
                ConcurrentMap concurrentMap = b;
                Integer n3 = n2;
                ZoneOffset zoneOffset = (ZoneOffset)concurrentMap.get((Object)n3);
                if (zoneOffset == null) {
                    concurrentMap.putIfAbsent((Object)n3, (Object)new ZoneOffset(n2));
                    zoneOffset = (ZoneOffset)concurrentMap.get((Object)n3);
                    c.putIfAbsent((Object)zoneOffset.g, (Object)zoneOffset);
                }
                return zoneOffset;
            }
            return new ZoneOffset(n2);
        }
        throw new g("Zone offset not in valid range: -18:00 to +18:00");
    }

    private static int P(CharSequence charSequence, int n2, boolean bl) {
        if (bl && charSequence.charAt(n2 - 1) != ':') {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid ID for ZoneOffset, colon not found when expected: ");
            stringBuilder.append((Object)charSequence);
            throw new g(stringBuilder.toString());
        }
        char c2 = charSequence.charAt(n2);
        char c4 = charSequence.charAt(n2 + 1);
        if (c2 >= '0' && c2 <= '9' && c4 >= '0' && c4 <= '9') {
            return 10 * (c2 - 48) + (c4 - 48);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid ID for ZoneOffset, non numeric characters found: ");
        stringBuilder.append((Object)charSequence);
        throw new g(stringBuilder.toString());
    }

    @Override
    public c G() {
        return c.j(this);
    }

    public int L() {
        return this.f;
    }

    public int compareTo(Object object) {
        return ((ZoneOffset)object).f - this.f;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof ZoneOffset) {
            return this.f == ((ZoneOffset)object).f;
        }
        return false;
    }

    @Override
    public long f(o o2) {
        if (o2 == j.OFFSET_SECONDS) {
            return this.f;
        }
        if (!(o2 instanceof j)) {
            return o2.v(this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append((Object)o2);
        throw new q(stringBuilder.toString());
    }

    @Override
    public boolean h(o o2) {
        if (o2 instanceof j) {
            return o2 == j.OFFSET_SECONDS;
        }
        return o2 != null && o2.F(this);
    }

    @Override
    public int hashCode() {
        return this.f;
    }

    @Override
    public int i(o o2) {
        if (o2 == j.OFFSET_SECONDS) {
            return this.f;
        }
        if (!(o2 instanceof j)) {
            return e.k(this, o2).a(this.f(o2), o2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append((Object)o2);
        throw new q(stringBuilder.toString());
    }

    @Override
    public String m() {
        return this.g;
    }

    @Override
    public r p(o o2) {
        return e.k(this, o2);
    }

    @Override
    public Object t(TemporalQuery temporalQuery) {
        if (temporalQuery != j$.time.temporal.e.a) {
            if (temporalQuery == i.a) {
                return this;
            }
            return e.j(this, temporalQuery);
        }
        return this;
    }

    @Override
    public String toString() {
        return this.g;
    }

    @Override
    public Temporal v(Temporal temporal) {
        return temporal.b(j.OFFSET_SECONDS, this.f);
    }
}

