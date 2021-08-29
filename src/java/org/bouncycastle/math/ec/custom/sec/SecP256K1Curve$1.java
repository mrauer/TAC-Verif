/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecP256K1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecP256K1Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP256K1Curve;
import org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP256K1Point;

public class SecP256K1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecP256K1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ int[] val$table;

    public SecP256K1Curve$1(SecP256K1Curve secP256K1Curve, int n2, int[] arrn) {
        this.this$0 = secP256K1Curve;
        this.val$len = n2;
        this.val$table = arrn;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        int[] arrn = new int[8];
        int[] arrn2 = new int[8];
        int n3 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            int n4 = -1 + (i2 ^ n2) >> 31;
            for (int i3 = 0; i3 < 8; ++i3) {
                int n5 = arrn[i3];
                int[] arrn3 = this.val$table;
                arrn[i3] = n5 ^ n4 & arrn3[n3 + i3];
                arrn2[i3] = arrn2[i3] ^ n4 & arrn3[i3 + (n3 + 8)];
            }
            n3 += 16;
        }
        SecP256K1Curve secP256K1Curve = this.this$0;
        SecP256K1FieldElement secP256K1FieldElement = new SecP256K1FieldElement(arrn);
        SecP256K1FieldElement secP256K1FieldElement2 = new SecP256K1FieldElement(arrn2);
        ECFieldElement[] arreCFieldElement = SecP256K1Curve.SECP256K1_AFFINE_ZS;
        Objects.requireNonNull((Object)secP256K1Curve);
        return new SecP256K1Point((ECCurve)secP256K1Curve, (ECFieldElement)secP256K1FieldElement, (ECFieldElement)secP256K1FieldElement2, arreCFieldElement);
    }
}

