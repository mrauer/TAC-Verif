/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  org.bouncycastle.math.ec.WNafUtil$1
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompCallback;
import org.bouncycastle.math.ec.PreCompInfo;
import org.bouncycastle.math.ec.WNafUtil;

public abstract class WNafUtil {
    public static final int[] DEFAULT_WINDOW_SIZE_CUTOFFS = new int[]{13, 41, 121, 337, 897, 2305};

    public static void configureBasepoint(ECPoint eCPoint) {
        int n2;
        ECCurve eCCurve = eCPoint.curve;
        if (eCCurve == null) {
            return;
        }
        BigInteger bigInteger = eCCurve.order;
        int n3 = bigInteger == null ? 1 + eCCurve.getFieldSize() : bigInteger.bitLength();
        int[] arrn = DEFAULT_WINDOW_SIZE_CUTOFFS;
        for (n2 = 0; n2 < arrn.length && n3 >= arrn[n2]; ++n2) {
        }
        eCCurve.precompute(eCPoint, "bc_wnaf", (PreCompCallback)new 1(Math.min((int)16, (int)(3 + Math.max((int)2, (int)Math.min((int)16, (int)(n2 + 2)))))));
    }
}

