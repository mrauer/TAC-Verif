/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.sec.SecP160R2Curve
 *  org.bouncycastle.math.ec.custom.sec.SecP160R2FieldElement
 *  org.bouncycastle.math.ec.custom.sec.SecP160R2Point
 */
package org.bouncycastle.math.ec.custom.sec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP160R2Curve;
import org.bouncycastle.math.ec.custom.sec.SecP160R2FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP160R2Point;

public class SecP160R2Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SecP160R2Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ int[] val$table;

    public SecP160R2Curve$1(SecP160R2Curve secP160R2Curve, int n2, int[] arrn) {
        this.this$0 = secP160R2Curve;
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
        SecP160R2Curve secP160R2Curve = this.this$0;
        SecP160R2FieldElement secP160R2FieldElement = new SecP160R2FieldElement(arrn);
        SecP160R2FieldElement secP160R2FieldElement2 = new SecP160R2FieldElement(arrn2);
        ECFieldElement[] arreCFieldElement = SecP160R2Curve.SECP160R2_AFFINE_ZS;
        Objects.requireNonNull((Object)secP160R2Curve);
        return new SecP160R2Point((ECCurve)secP160R2Curve, (ECFieldElement)secP160R2FieldElement, (ECFieldElement)secP160R2FieldElement2, arreCFieldElement);
    }
}

