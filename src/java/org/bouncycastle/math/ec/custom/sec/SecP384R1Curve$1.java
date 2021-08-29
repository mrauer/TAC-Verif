/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecP384R1Curve
 *  org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecP384R1Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP384R1Curve;
import org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP384R1Point;

public class SecP384R1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecP384R1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ int[] val$table;

    public SecP384R1Curve$1(SecP384R1Curve secP384R1Curve, int n2, int[] arrn) {
        this.this$0 = secP384R1Curve;
        this.val$len = n2;
        this.val$table = arrn;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        int[] arrn = new int[12];
        int[] arrn2 = new int[12];
        int n3 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            int n4 = -1 + (i2 ^ n2) >> 31;
            for (int i3 = 0; i3 < 12; ++i3) {
                int n5 = arrn[i3];
                int[] arrn3 = this.val$table;
                arrn[i3] = n5 ^ n4 & arrn3[n3 + i3];
                arrn2[i3] = arrn2[i3] ^ n4 & arrn3[i3 + (n3 + 12)];
            }
            n3 += 24;
        }
        SecP384R1Curve secP384R1Curve = this.this$0;
        SecP384R1FieldElement secP384R1FieldElement = new SecP384R1FieldElement(arrn);
        SecP384R1FieldElement secP384R1FieldElement2 = new SecP384R1FieldElement(arrn2);
        ECFieldElement[] arreCFieldElement = SecP384R1Curve.SECP384R1_AFFINE_ZS;
        Objects.requireNonNull((Object)secP384R1Curve);
        return new SecP384R1Point((ECCurve)secP384R1Curve, (ECFieldElement)secP384R1FieldElement, (ECFieldElement)secP384R1FieldElement2, arreCFieldElement);
    }
}

