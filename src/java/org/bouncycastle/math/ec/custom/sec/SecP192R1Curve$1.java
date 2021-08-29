/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecP192R1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecP192R1FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecP192R1Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP192R1Curve;
import org.bouncycastle.math.ec.custom.sec.SecP192R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP192R1Point;

public class SecP192R1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecP192R1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ int[] val$table;

    public SecP192R1Curve$1(SecP192R1Curve secP192R1Curve, int n2, int[] arrn) {
        this.this$0 = secP192R1Curve;
        this.val$len = n2;
        this.val$table = arrn;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        int[] arrn = new int[6];
        int[] arrn2 = new int[6];
        int n3 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            int n4 = -1 + (i2 ^ n2) >> 31;
            for (int i3 = 0; i3 < 6; ++i3) {
                int n5 = arrn[i3];
                int[] arrn3 = this.val$table;
                arrn[i3] = n5 ^ n4 & arrn3[n3 + i3];
                arrn2[i3] = arrn2[i3] ^ n4 & arrn3[i3 + (n3 + 6)];
            }
            n3 += 12;
        }
        SecP192R1Curve secP192R1Curve = this.this$0;
        SecP192R1FieldElement secP192R1FieldElement = new SecP192R1FieldElement(arrn);
        SecP192R1FieldElement secP192R1FieldElement2 = new SecP192R1FieldElement(arrn2);
        ECFieldElement[] arreCFieldElement = SecP192R1Curve.SECP192R1_AFFINE_ZS;
        Objects.requireNonNull((Object)secP192R1Curve);
        return new SecP192R1Point((ECCurve)secP192R1Curve, (ECFieldElement)secP192R1FieldElement, (ECFieldElement)secP192R1FieldElement2, arreCFieldElement);
    }
}

