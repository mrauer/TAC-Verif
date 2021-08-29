/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecT113FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecT113R1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecT113R1Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecT113FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT113R1Curve;
import org.bouncycastle.math.ec.custom.sec.SecT113R1Point;

public class SecT113R1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecT113R1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ long[] val$table;

    public SecT113R1Curve$1(SecT113R1Curve secT113R1Curve, int n2, long[] arrl) {
        this.this$0 = secT113R1Curve;
        this.val$len = n2;
        this.val$table = arrl;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        long[] arrl = new long[2];
        long[] arrl2 = new long[2];
        int n3 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            long l2 = -1 + (i2 ^ n2) >> 31;
            for (int i3 = 0; i3 < 2; ++i3) {
                long l3 = arrl[i3];
                long[] arrl3 = this.val$table;
                arrl[i3] = l3 ^ l2 & arrl3[n3 + i3];
                arrl2[i3] = arrl2[i3] ^ l2 & arrl3[i3 + (n3 + 2)];
            }
            n3 += 4;
        }
        SecT113R1Curve secT113R1Curve = this.this$0;
        SecT113FieldElement secT113FieldElement = new SecT113FieldElement(arrl);
        SecT113FieldElement secT113FieldElement2 = new SecT113FieldElement(arrl2);
        ECFieldElement[] arreCFieldElement = SecT113R1Curve.SECT113R1_AFFINE_ZS;
        Objects.requireNonNull((Object)secT113R1Curve);
        return new SecT113R1Point((ECCurve)secT113R1Curve, (ECFieldElement)secT113FieldElement, (ECFieldElement)secT113FieldElement2, arreCFieldElement);
    }
}

