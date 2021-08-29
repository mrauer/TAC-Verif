/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.time.temporal;

import j$.time.temporal.Temporal;
import j$.time.temporal.j;
import j$.time.temporal.l;
import j$.time.temporal.o;
import j$.time.temporal.r;

public final class a
implements l {
    public static final /* synthetic */ a a;

    static /* synthetic */ {
        a = new a();
    }

    private /* synthetic */ a() {
    }

    @Override
    public final Temporal v(Temporal temporal) {
        j j2 = j.DAY_OF_MONTH;
        return temporal.b(j2, temporal.p(j2).d());
    }
}

