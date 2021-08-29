/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecT283FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecT283K1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecT283K1Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecT283FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT283K1Curve;
import org.bouncycastle.math.ec.custom.sec.SecT283K1Point;

public class SecT283K1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecT283K1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ long[] val$table;

    public SecT283K1Curve$1(SecT283K1Curve secT283K1Curve, int n2, long[] arrl) {
        this.this$0 = secT283K1Curve;
        this.val$len = n2;
        this.val$table = arrl;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        long[] arrl = new long[5];
        long[] arrl2 = new long[5];
        int n3 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            long l2 = -1 + (i2 ^ n2) >> 31;
            for (int i3 = 0; i3 < 5; ++i3) {
                long l3 = arrl[i3];
                long[] arrl3 = this.val$table;
                arrl[i3] = l3 ^ l2 & arrl3[n3 + i3];
                arrl2[i3] = arrl2[i3] ^ l2 & arrl3[i3 + (n3 + 5)];
            }
            n3 += 10;
        }
        SecT283K1Curve secT283K1Curve = this.this$0;
        SecT283FieldElement secT283FieldElement = new SecT283FieldElement(arrl);
        SecT283FieldElement secT283FieldElement2 = new SecT283FieldElement(arrl2);
        ECFieldElement[] arreCFieldElement = SecT283K1Curve.SECT283K1_AFFINE_ZS;
        Objects.requireNonNull((Object)secT283K1Curve);
        return new SecT283K1Point((ECCurve)secT283K1Curve, (ECFieldElement)secT283FieldElement, (ECFieldElement)secT283FieldElement2, arreCFieldElement);
    }
}

