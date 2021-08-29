/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecT163FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecT163R1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecT163R1Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecT163FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT163R1Curve;
import org.bouncycastle.math.ec.custom.sec.SecT163R1Point;

public class SecT163R1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecT163R1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ long[] val$table;

    public SecT163R1Curve$1(SecT163R1Curve secT163R1Curve, int n2, long[] arrl) {
        this.this$0 = secT163R1Curve;
        this.val$len = n2;
        this.val$table = arrl;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        long[] arrl = new long[3];
        long[] arrl2 = new long[3];
        int n3 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            long l2 = -1 + (i2 ^ n2) >> 31;
            for (int i3 = 0; i3 < 3; ++i3) {
                long l3 = arrl[i3];
                long[] arrl3 = this.val$table;
                arrl[i3] = l3 ^ l2 & arrl3[n3 + i3];
                arrl2[i3] = arrl2[i3] ^ l2 & arrl3[i3 + (n3 + 3)];
            }
            n3 += 6;
        }
        SecT163R1Curve secT163R1Curve = this.this$0;
        SecT163FieldElement secT163FieldElement = new SecT163FieldElement(arrl);
        SecT163FieldElement secT163FieldElement2 = new SecT163FieldElement(arrl2);
        ECFieldElement[] arreCFieldElement = SecT163R1Curve.SECT163R1_AFFINE_ZS;
        Objects.requireNonNull((Object)secT163R1Curve);
        return new SecT163R1Point((ECCurve)secT163R1Curve, (ECFieldElement)secT163FieldElement, (ECFieldElement)secT163FieldElement2, arreCFieldElement);
    }
}

