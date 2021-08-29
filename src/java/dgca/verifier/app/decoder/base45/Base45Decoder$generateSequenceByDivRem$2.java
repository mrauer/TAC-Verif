/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 */
package dgca.verifier.app.decoder.base45;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public final class Base45Decoder$generateSequenceByDivRem$2
extends Lambda
implements Function1<Long, Integer> {
    public static final Base45Decoder$generateSequenceByDivRem$2 INSTANCE = new Base45Decoder$generateSequenceByDivRem$2();

    public Base45Decoder$generateSequenceByDivRem$2() {
        super(1);
    }

    public Object invoke(Object object) {
        return (int)(((Number)object).longValue() % (long)256);
    }
}

