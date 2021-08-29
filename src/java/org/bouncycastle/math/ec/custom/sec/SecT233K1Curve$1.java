/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecT233FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecT233K1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecT233K1Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecT233FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT233K1Curve;
import org.bouncycastle.math.ec.custom.sec.SecT233K1Point;

public class SecT233K1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecT233K1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ long[] val$table;

    public SecT233K1Curve$1(SecT233K1Curve secT233K1Curve, int n2, long[] arrl) {
        this.this$0 = secT233K1Curve;
        this.val$len = n2;
        this.val$table = arrl;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        long[] arrl = new long[4];
        long[] arrl2 = new long[4];
        int n3 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            long l2 = -1 + (i2 ^ n2) >> 31;
            for (int i3 = 0; i3 < 4; ++i3) {
                long l3 = arrl[i3];
                long[] arrl3 = this.val$table;
                arrl[i3] = l3 ^ l2 & arrl3[n3 + i3];
                arrl2[i3] = arrl2[i3] ^ l2 & arrl3[i3 + (n3 + 4)];
            }
            n3 += 8;
        }
        SecT233K1Curve secT233K1Curve = this.this$0;
        SecT233FieldElement secT233FieldElement = new SecT233FieldElement(arrl);
        SecT233FieldElement secT233FieldElement2 = new SecT233FieldElement(arrl2);
        ECFieldElement[] arreCFieldElement = SecT233K1Curve.SECT233K1_AFFINE_ZS;
        Objects.requireNonNull((Object)secT233K1Curve);
        return new SecT233K1Point((ECCurve)secT233K1Curve, (ECFieldElement)secT233FieldElement, (ECFieldElement)secT233FieldElement2, arreCFieldElement);
    }
}

