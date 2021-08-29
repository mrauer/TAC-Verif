/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecT239FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecT239K1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecT239K1Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecT239FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT239K1Curve;
import org.bouncycastle.math.ec.custom.sec.SecT239K1Point;

public class SecT239K1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecT239K1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ long[] val$table;

    public SecT239K1Curve$1(SecT239K1Curve secT239K1Curve, int n2, long[] arrl) {
        this.this$0 = secT239K1Curve;
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
        SecT239K1Curve secT239K1Curve = this.this$0;
        SecT239FieldElement secT239FieldElement = new SecT239FieldElement(arrl);
        SecT239FieldElement secT239FieldElement2 = new SecT239FieldElement(arrl2);
        ECFieldElement[] arreCFieldElement = SecT239K1Curve.SECT239K1_AFFINE_ZS;
        Objects.requireNonNull((Object)secT239K1Curve);
        return new SecT239K1Point((ECCurve)secT239K1Curve, (ECFieldElement)secT239FieldElement, (ECFieldElement)secT239FieldElement2, arreCFieldElement);
    }
}

