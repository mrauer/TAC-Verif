/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointPreCompInfo;
import org.bouncycastle.math.ec.PreCompCallback;
import org.bouncycastle.math.ec.PreCompInfo;

public final class FixedPointUtil$1
implements PreCompCallback {
    public final /* synthetic */ ECCurve val$c;
    public final /* synthetic */ ECPoint val$p;

    public FixedPointUtil$1(ECCurve eCCurve, ECPoint eCPoint) {
        this.val$c = eCCurve;
        this.val$p = eCPoint;
    }

    @Override
    public PreCompInfo precompute(PreCompInfo preCompInfo) {
        AbstractECLookupTable abstractECLookupTable;
        boolean bl;
        FixedPointPreCompInfo fixedPointPreCompInfo = preCompInfo instanceof FixedPointPreCompInfo ? (FixedPointPreCompInfo)preCompInfo : null;
        ECCurve eCCurve = this.val$c;
        BigInteger bigInteger = eCCurve.order;
        int n2 = bigInteger == null ? 1 + eCCurve.getFieldSize() : bigInteger.bitLength();
        int n3 = n2 > 250 ? 6 : 5;
        int n4 = 1 << n3;
        boolean bl2 = fixedPointPreCompInfo != null && (bl = (abstractECLookupTable = fixedPointPreCompInfo.lookupTable) != null && abstractECLookupTable.getSize() >= n4);
        if (bl2) {
            return fixedPointPreCompInfo;
        }
        int n5 = (n2 + n3 - 1) / n3;
        ECPoint[] arreCPoint = new ECPoint[n3 + 1];
        arreCPoint[0] = this.val$p;
        for (int i2 = 1; i2 < n3; ++i2) {
            arreCPoint[i2] = arreCPoint[i2 - 1].timesPow2(n5);
        }
        arreCPoint[n3] = arreCPoint[0].subtract(arreCPoint[1]);
        this.val$c.normalizeAll(arreCPoint);
        ECPoint[] arreCPoint2 = new ECPoint[n4];
        arreCPoint2[0] = arreCPoint[0];
        for (int i3 = n3 - 1; i3 >= 0; --i3) {
            int n6;
            ECPoint eCPoint = arreCPoint[i3];
            for (int i4 = n6 = 1 << i3; i4 < n4; i4 += n6 << 1) {
                arreCPoint2[i4] = arreCPoint2[i4 - n6].add(eCPoint);
            }
        }
        this.val$c.normalizeAll(arreCPoint2);
        FixedPointPreCompInfo fixedPointPreCompInfo2 = new FixedPointPreCompInfo();
        fixedPointPreCompInfo2.lookupTable = this.val$c.createCacheSafeLookupTable(arreCPoint2, 0, n4);
        fixedPointPreCompInfo2.offset = arreCPoint[n3];
        fixedPointPreCompInfo2.width = n3;
        return fixedPointPreCompInfo2;
    }
}

