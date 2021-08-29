/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecP224K1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecP224K1FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecP224K1Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP224K1Curve;
import org.bouncycastle.math.ec.custom.sec.SecP224K1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP224K1Point;

public class SecP224K1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecP224K1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ int[] val$table;

    public SecP224K1Curve$1(SecP224K1Curve secP224K1Curve, int n2, int[] arrn) {
        this.this$0 = secP224K1Curve;
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
        SecP224K1Curve secP224K1Curve = this.this$0;
        SecP224K1FieldElement secP224K1FieldElement = new SecP224K1FieldElement(arrn);
        SecP224K1FieldElement secP224K1FieldElement2 = new SecP224K1FieldElement(arrn2);
        ECFieldElement[] arreCFieldElement = SecP224K1Curve.SECP224K1_AFFINE_ZS;
        Objects.requireNonNull((Object)secP224K1Curve);
        return new SecP224K1Point((ECCurve)secP224K1Curve, (ECFieldElement)secP224K1FieldElement, (ECFieldElement)secP224K1FieldElement2, arreCFieldElement);
    }
}

