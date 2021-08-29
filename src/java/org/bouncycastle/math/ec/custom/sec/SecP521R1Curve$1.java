/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecP521R1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecP521R1Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP521R1Curve;
import org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP521R1Point;

public class SecP521R1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecP521R1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ int[] val$table;

    public SecP521R1Curve$1(SecP521R1Curve secP521R1Curve, int n2, int[] arrn) {
        this.this$0 = secP521R1Curve;
        this.val$len = n2;
        this.val$table = arrn;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        int[] arrn = new int[17];
        int[] arrn2 = new int[17];
        int n3 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            int n4 = -1 + (i2 ^ n2) >> 31;
            for (int i3 = 0; i3 < 17; ++i3) {
                int n5 = arrn[i3];
                int[] arrn3 = this.val$table;
                arrn[i3] = n5 ^ n4 & arrn3[n3 + i3];
                arrn2[i3] = arrn2[i3] ^ n4 & arrn3[i3 + (n3 + 17)];
            }
            n3 += 34;
        }
        SecP521R1Curve secP521R1Curve = this.this$0;
        SecP521R1FieldElement secP521R1FieldElement = new SecP521R1FieldElement(arrn);
        SecP521R1FieldElement secP521R1FieldElement2 = new SecP521R1FieldElement(arrn2);
        ECFieldElement[] arreCFieldElement = SecP521R1Curve.SECP521R1_AFFINE_ZS;
        Objects.requireNonNull((Object)secP521R1Curve);
        return new SecP521R1Point((ECCurve)secP521R1Curve, (ECFieldElement)secP521R1FieldElement, (ECFieldElement)secP521R1FieldElement2, arreCFieldElement);
    }
}

