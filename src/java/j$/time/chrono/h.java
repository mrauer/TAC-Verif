/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package j$.time.chrono;

import j$.time.chrono.f;
import j$.time.e;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.g;
import j$.time.temporal.j;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;

public final class h
extends Enum<h>
implements f {
    public static final /* enum */ h BCE;
    public static final /* enum */ h CE;
    private static final /* synthetic */ h[] a;

    static {
        h h2;
        h h3;
        BCE = h3 = new h();
        CE = h2 = new h();
        a = new h[]{h3, h2};
    }

    public static h valueOf(String string) {
        return (h)Enum.valueOf(h.class, (String)string);
    }

    public static h[] values() {
        return (h[])a.clone();
    }

    public int F() {
        return this.ordinal();
    }

    @Override
    public long f(o o2) {
        if (o2 == j.ERA) {
            return this.F();
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
        return o2 instanceof j ? o2 == j.ERA : o2 != null && o2.F(this);
    }

    @Override
    public int i(o o2) {
        if (o2 == j.ERA) {
            return this.F();
        }
        return e.f(this, o2);
    }

    @Override
    public r p(o o2) {
        return e.k(this, o2);
    }

    @Override
    public Object t(TemporalQuery temporalQuery) {
        if (temporalQuery == g.a) {
            return ChronoUnit.ERAS;
        }
        return e.j(this, temporalQuery);
    }

    @Override
    public Temporal v(Temporal temporal) {
        return temporal.b(j.ERA, this.F());
    }
}

