/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.LongPredicate
 */
package j$;

import j$.l0;
import j$.util.function.F;
import java.util.function.LongPredicate;

public final class k0
implements F {
    final /* synthetic */ LongPredicate a;

    private /* synthetic */ k0(LongPredicate longPredicate) {
        this.a = longPredicate;
    }

    public static /* synthetic */ F a(LongPredicate longPredicate) {
        if (longPredicate == null) {
            return null;
        }
        if (longPredicate instanceof l0) {
            return ((l0)longPredicate).a;
        }
        return new k0(longPredicate);
    }

    public /* synthetic */ boolean b(long l2) {
        return this.a.test(l2);
    }
}

