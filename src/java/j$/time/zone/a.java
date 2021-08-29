/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDateTime
 *  java.io.Serializable
 *  java.lang.Comparable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.List
 *  java.util.Objects
 */
package j$.time.zone;

import j$.time.Instant;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.e;
import j$.time.i;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class a
implements Comparable<a>,
Serializable {
    private final j.LocalDateTime a;
    private final ZoneOffset b;
    private final ZoneOffset c;

    a(long l2, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.a = j.LocalDateTime.Q((long)l2, (int)0, (ZoneOffset)zoneOffset);
        this.b = zoneOffset;
        this.c = zoneOffset2;
    }

    a(j.LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.a = localDateTime;
        this.b = zoneOffset;
        this.c = zoneOffset2;
    }

    public ZoneOffset F() {
        return this.b;
    }

    List G() {
        if (this.H()) {
            return Collections.emptyList();
        }
        Object[] arrobject = new ZoneOffset[]{this.b, this.c};
        return Arrays.asList((Object[])arrobject);
    }

    public boolean H() {
        return this.c.L() > this.b.L();
    }

    public long I() {
        j.LocalDateTime localDateTime = this.a;
        ZoneOffset zoneOffset = this.b;
        Objects.requireNonNull((Object)localDateTime);
        return e.l((ChronoLocalDateTime)localDateTime, zoneOffset);
    }

    public int compareTo(Object object) {
        a a2 = (a)object;
        return this.t().F(a2.t());
    }

    public j.LocalDateTime e() {
        return this.a.V((long)(this.c.L() - this.b.L()));
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof a) {
            a a2 = (a)object;
            return this.a.equals((Object)a2.a) && this.b.equals(a2.b) && this.c.equals(a2.c);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode() ^ Integer.rotateLeft((int)this.c.hashCode(), (int)16);
    }

    public j.LocalDateTime i() {
        return this.a;
    }

    public i p() {
        return i.t(this.c.L() - this.b.L());
    }

    public Instant t() {
        j.LocalDateTime localDateTime = this.a;
        return Instant.N(localDateTime.X(this.b), localDateTime.c().K());
    }

    public String toString() {
        StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("Transition[");
        String string = this.H() ? "Gap" : "Overlap";
        stringBuilder.append(string);
        stringBuilder.append(" at ");
        stringBuilder.append((Object)this.a);
        stringBuilder.append((Object)this.b);
        stringBuilder.append(" to ");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public ZoneOffset v() {
        return this.c;
    }
}

