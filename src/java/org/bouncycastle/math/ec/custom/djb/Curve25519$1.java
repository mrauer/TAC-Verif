/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.custom.djb.Curve25519
 *  org.bouncycastle.math.ec.custom.djb.Curve25519FieldElement
 *  org.bouncycastle.math.ec.custom.djb.Curve25519Point
 */
package org.bouncycastle.math.ec.custom.djb;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.djb.Curve25519;
import org.bouncycastle.math.ec.custom.djb.Curve25519FieldElement;
import org.bouncycastle.math.ec.custom.djb.Curve25519Point;

public class Curve25519$1
extends AbstractECLookupTable {
    public final /* synthetic */ Curve25519 this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ int[] val$table;

    public Curve25519$1(Curve25519 curve25519, int n2, int[] arrn) {
        this.this$0 = curve25519;
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
        Curve25519 curve25519 = this.this$0;
        Curve25519FieldElement curve25519FieldElement = new Curve25519FieldElement(arrn);
        Curve25519FieldElement curve25519FieldElement2 = new Curve25519FieldElement(arrn2);
        ECFieldElement[] arreCFieldElement = Curve25519.CURVE25519_AFFINE_ZS;
        Objects.requireNonNull((Object)curve25519);
        return new Curve25519Point((ECCurve)curve25519, (ECFieldElement)curve25519FieldElement, (ECFieldElement)curve25519FieldElement2, arreCFieldElement);
    }
}

