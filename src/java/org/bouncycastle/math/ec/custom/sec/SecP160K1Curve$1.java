/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecP160K1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecP160K1Point
 *  org.bouncycastle.math.ec.custom.sec.SecP160R2FieldElement
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP160K1Curve;
import org.bouncycastle.math.ec.custom.sec.SecP160K1Point;
import org.bouncycastle.math.ec.custom.sec.SecP160R2FieldElement;

public class SecP160K1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecP160K1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ int[] val$table;

    public SecP160K1Curve$1(SecP160K1Curve secP160K1Curve, int n2, int[] arrn) {
        this.this$0 = secP160K1Curve;
        this.val$len = n2;
        this.val$table = arrn;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        int[] arrn = new int[5];
        int[] arrn2 = new int[5];
        int n3 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            int n4 = -1 + (i2 ^ n2) >> 31;
            for (int i3 = 0; i3 < 5; ++i3) {
                int n5 = arrn[i3];
                int[] arrn3 = this.val$table;
                arrn[i3] = n5 ^ n4 & arrn3[n3 + i3];
                arrn2[i3] = arrn2[i3] ^ n4 & arrn3[i3 + (n3 + 5)];
            }
            n3 += 10;
        }
        SecP160K1Curve secP160K1Curve = this.this$0;
        SecP160R2FieldElement secP160R2FieldElement = new SecP160R2FieldElement(arrn);
        SecP160R2FieldElement secP160R2FieldElement2 = new SecP160R2FieldElement(arrn2);
        ECFieldElement[] arreCFieldElement = SecP160K1Curve.SECP160K1_AFFINE_ZS;
        Objects.requireNonNull((Object)secP160K1Curve);
        return new SecP160K1Point((ECCurve)secP160K1Curve, (ECFieldElement)secP160R2FieldElement, (ECFieldElement)secP160R2FieldElement2, arreCFieldElement);
    }
}

