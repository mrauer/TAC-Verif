/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.gm.SM2P256V1Curve
 *  org.bouncycastle.math.ec.custom.gm.SM2P256V1FieldElement
 *  org.bouncycastle.math.ec.custom.gm.SM2P256V1Point
 */
package org.bouncycastle.math.ec.custom.gm;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.gm.SM2P256V1Curve;
import org.bouncycastle.math.ec.custom.gm.SM2P256V1FieldElement;
import org.bouncycastle.math.ec.custom.gm.SM2P256V1Point;

public class SM2P256V1Curve$1
extends AbstractECLookupTable {
    public final /* synthetic */ SM2P256V1Curve this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ int[] val$table;

    public SM2P256V1Curve$1(SM2P256V1Curve sM2P256V1Curve, int n2, int[] arrn) {
        this.this$0 = sM2P256V1Curve;
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
        SM2P256V1Curve sM2P256V1Curve = this.this$0;
        SM2P256V1FieldElement sM2P256V1FieldElement = new SM2P256V1FieldElement(arrn);
        SM2P256V1FieldElement sM2P256V1FieldElement2 = new SM2P256V1FieldElement(arrn2);
        ECFieldElement[] arreCFieldElement = SM2P256V1Curve.SM2P256V1_AFFINE_ZS;
        Objects.requireNonNull((Object)sM2P256V1Curve);
        return new SM2P256V1Point((ECCurve)sM2P256V1Curve, (ECFieldElement)sM2P256V1FieldElement, (ECFieldElement)sM2P256V1FieldElement2, arreCFieldElement);
    }
}

