/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecT571FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecT571R1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecT571R1Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecT571FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT571R1Curve;
import org.bouncycastle.math.ec.custom.sec.SecT571R1Point;

public class SecT571R1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecT571R1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ long[] val$table;

    public SecT571R1Curve$1(SecT571R1Curve secT571R1Curve, int n2, long[] arrl) {
        this.this$0 = secT571R1Curve;
        this.val$len = n2;
        this.val$table = arrl;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        long[] arrl = new long[9];
        long[] arrl2 = new long[9];
        int n3 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            long l2 = -1 + (i2 ^ n2) >> 31;
            for (int i3 = 0; i3 < 9; ++i3) {
                long l3 = arrl[i3];
                long[] arrl3 = this.val$table;
                arrl[i3] = l3 ^ l2 & arrl3[n3 + i3];
                arrl2[i3] = arrl2[i3] ^ l2 & arrl3[i3 + (n3 + 9)];
            }
            n3 += 18;
        }
        SecT571R1Curve secT571R1Curve = this.this$0;
        SecT571FieldElement secT571FieldElement = new SecT571FieldElement(arrl);
        SecT571FieldElement secT571FieldElement2 = new SecT571FieldElement(arrl2);
        ECFieldElement[] arreCFieldElement = SecT571R1Curve.SECT571R1_AFFINE_ZS;
        Objects.requireNonNull((Object)secT571R1Curve);
        return new SecT571R1Point((ECCurve)secT571R1Curve, (ECFieldElement)secT571FieldElement, (ECFieldElement)secT571FieldElement2, arreCFieldElement);
    }
}

