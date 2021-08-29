/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  org.bouncycastle.math.ec.FixedPointPreCompInfo
 *  org.bouncycastle.math.ec.FixedPointUtil
 *  org.bouncycastle.math.ec.FixedPointUtil$1
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointPreCompInfo;
import org.bouncycastle.math.ec.FixedPointUtil;
import org.bouncycastle.math.ec.PreCompCallback;
import org.bouncycastle.math.ec.PreCompInfo;
import org.bouncycastle.math.raw.Nat576;

public abstract class AbstractECMultiplier {
    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger) {
        int n2 = bigInteger.signum();
        if (n2 != 0 && !eCPoint.isInfinity()) {
            BigInteger bigInteger2 = bigInteger.abs();
            ECCurve eCCurve = eCPoint.curve;
            BigInteger bigInteger3 = eCCurve.order;
            int n3 = bigInteger3 == null ? 1 + eCCurve.getFieldSize() : bigInteger3.bitLength();
            if (bigInteger2.bitLength() <= n3) {
                ECCurve eCCurve2 = eCPoint.curve;
                FixedPointPreCompInfo fixedPointPreCompInfo = (FixedPointPreCompInfo)eCCurve2.precompute(eCPoint, "bc_fixed_point", (PreCompCallback)new FixedPointUtil.1(eCCurve2, eCPoint));
                AbstractECLookupTable abstractECLookupTable = fixedPointPreCompInfo.lookupTable;
                int n4 = fixedPointPreCompInfo.width;
                int n5 = (-1 + (n3 + n4)) / n4;
                ECPoint eCPoint2 = eCCurve.getInfinity();
                int n6 = n4 * n5;
                int[] arrn = Nat576.fromBigInteger(n6, bigInteger2);
                int n7 = n6 - 1;
                for (int i2 = 0; i2 < n5; ++i2) {
                    int n8 = 0;
                    for (int i3 = n7 - i2; i3 >= 0; i3 -= n5) {
                        int n9 = arrn[i3 >>> 5] >>> (i3 & 31);
                        n8 = n9 ^ (n8 ^ n9 >>> 1) << 1;
                    }
                    eCPoint2 = eCPoint2.twicePlus(abstractECLookupTable.lookup(n8));
                }
                ECPoint eCPoint3 = eCPoint2.add(fixedPointPreCompInfo.offset);
                if (n2 <= 0) {
                    eCPoint3 = eCPoint3.negate();
                }
                if (eCPoint3.implIsValid(false, false)) {
                    return eCPoint3;
                }
                throw new IllegalStateException("Invalid result");
            }
            throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
        }
        return eCPoint.curve.getInfinity();
    }
}

