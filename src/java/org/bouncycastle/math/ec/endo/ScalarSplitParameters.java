/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec.endo;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.math.BigInteger;

public class ScalarSplitParameters {
    public ScalarSplitParameters(BigInteger[] arrbigInteger, BigInteger[] arrbigInteger2, BigInteger bigInteger, BigInteger bigInteger2, int n2) {
        ScalarSplitParameters.checkVector(arrbigInteger, "v1");
        ScalarSplitParameters.checkVector(arrbigInteger2, "v2");
        arrbigInteger[0];
        arrbigInteger[1];
        arrbigInteger2[0];
        arrbigInteger2[1];
    }

    public static void checkVector(BigInteger[] arrbigInteger, String string) {
        if (arrbigInteger != null && arrbigInteger.length == 2 && arrbigInteger[0] != null && arrbigInteger[1] != null) {
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline19((String)"'", (String)string, (String)"' must consist of exactly 2 (non-null) values"));
    }
}

