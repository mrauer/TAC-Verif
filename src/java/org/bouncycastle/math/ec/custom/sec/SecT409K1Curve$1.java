/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecT409FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecT409K1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecT409K1Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecT409FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT409K1Curve;
import org.bouncycastle.math.ec.custom.sec.SecT409K1Point;

public class SecT409K1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecT409K1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ long[] val$table;

    public SecT409K1Curve$1(SecT409K1Curve secT409K1Curve, int n2, long[] arrl) {
        this.this$0 = secT409K1Curve;
        this.val$len = n2;
        this.val$table = arrl;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        long[] arrl = new long[7];
        long[] arrl2 = new long[7];
        int n3 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            long l2 = -1 + (i2 ^ n2) >> 31;
            for (int i3 = 0; i3 < 7; ++i3) {
                long l3 = arrl[i3];
                long[] arrl3 = this.val$table;
                arrl[i3] = l3 ^ l2 & arrl3[n3 + i3];
                arrl2[i3] = arrl2[i3] ^ l2 & arrl3[i3 + (n3 + 7)];
            }
            n3 += 14;
        }
        SecT409K1Curve secT409K1Curve = this.this$0;
        SecT409FieldElement secT409FieldElement = new SecT409FieldElement(arrl);
        SecT409FieldElement secT409FieldElement2 = new SecT409FieldElement(arrl2);
        ECFieldElement[] arreCFieldElement = SecT409K1Curve.SECT409K1_AFFINE_ZS;
        Objects.requireNonNull((Object)secT409K1Curve);
        return new SecT409K1Point((ECCurve)secT409K1Curve, (ECFieldElement)secT409FieldElement, (ECFieldElement)secT409FieldElement2, arreCFieldElement);
    }
}

