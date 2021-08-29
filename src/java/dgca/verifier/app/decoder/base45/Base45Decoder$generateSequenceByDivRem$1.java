/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 */
package dgca.verifier.app.decoder.base45;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public final class Base45Decoder$generateSequenceByDivRem$1
extends Lambda
implements Function1<Long, Long> {
    public static final Base45Decoder$generateSequenceByDivRem$1 INSTANCE = new Base45Decoder$generateSequenceByDivRem$1();

    public Base45Decoder$generateSequenceByDivRem$1() {
        super(1);
    }

    public Object invoke(Object object) {
        long l2 = ((Number)object).longValue();
        if (l2 >= 256L) {
            return l2 / (long)256;
        }
        return null;
    }
}

