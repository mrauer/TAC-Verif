/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  kotlin.UByte
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 */
package dgca.verifier.app.decoder.base45;

import kotlin.UByte;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public final class Base45Decoder$decodeThreeChars$1
extends Lambda
implements Function1<Integer, UByte> {
    public static final Base45Decoder$decodeThreeChars$1 INSTANCE = new Base45Decoder$decodeThreeChars$1();

    public Base45Decoder$decodeThreeChars$1() {
        super(1);
    }

    public Object invoke(Object object) {
        return new UByte((byte)((Number)object).intValue());
    }
}

