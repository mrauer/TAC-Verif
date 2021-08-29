/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.time.temporal;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.j;
import j$.time.temporal.l;
import j$.time.temporal.o;

public final class b
implements l {
    public final /* synthetic */ int a;

    public /* synthetic */ b(int n2) {
        this.a = n2;
    }

    @Override
    public final Temporal v(Temporal temporal) {
        int n2 = this.a;
        int n3 = temporal.i(j.DAY_OF_WEEK);
        if (n3 == n2) {
            return temporal;
        }
        int n4 = n3 - n2;
        int n5 = n4 >= 0 ? 7 - n4 : -n4;
        return temporal.g(n5, ChronoUnit.DAYS);
    }
}

