/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecP224R1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecP224R1FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecP224R1Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP224R1Curve;
import org.bouncycastle.math.ec.custom.sec.SecP224R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP224R1Point;

public class SecP224R1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecP224R1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ int[] val$table;

    public SecP224R1Curve$1(SecP224R1Curve secP224R1Curve, int n2, int[] arrn) {
        this.this$0 = secP224R1Curve;
        this.val$len = n2;
        this.val$table = arrn;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        int[] arrn = new int[7];
        int[] arrn2 = new int[7];
        int n3 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            int n4 = -1 + (i2 ^ n2) >> 31;
            for (int i3 = 0; i3 < 7; ++i3) {
                int n5 = arrn[i3];
                int[] arrn3 = this.val$table;
                arrn[i3] = n5 ^ n4 & arrn3[n3 + i3];
                arrn2[i3] = arrn2[i3] ^ n4 & arrn3[i3 + (n3 + 7)];
            }
            n3 += 14;
        }
        SecP224R1Curve secP224R1Curve = this.this$0;
        SecP224R1FieldElement secP224R1FieldElement = new SecP224R1FieldElement(arrn);
        SecP224R1FieldElement secP224R1FieldElement2 = new SecP224R1FieldElement(arrn2);
        ECFieldElement[] arreCFieldElement = SecP224R1Curve.SECP224R1_AFFINE_ZS;
        Objects.requireNonNull((Object)secP224R1Curve);
        return new SecP224R1Point((ECCurve)secP224R1Curve, (ECFieldElement)secP224R1FieldElement, (ECFieldElement)secP224R1FieldElement2, arreCFieldElement);
    }
}

