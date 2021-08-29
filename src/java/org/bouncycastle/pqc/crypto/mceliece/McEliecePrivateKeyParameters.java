/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

public class McEliecePrivateKeyParameters
extends McElieceKeyParameters {
    public GF2mField field;
    public PolynomialGF2mSmallM goppaPoly;
    public int k;
    public int n;
    public Permutation p1;
    public Permutation p2;
    public GF2Matrix sInv;

    public McEliecePrivateKeyParameters(int n2, int n3, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, Permutation permutation2, GF2Matrix gF2Matrix) {
        super(true);
        this.k = n3;
        this.n = n2;
        this.field = gF2mField;
        this.goppaPoly = polynomialGF2mSmallM;
        this.sInv = gF2Matrix;
        this.p1 = permutation;
        this.p2 = permutation2;
        Nat576.createCanonicalCheckMatrix(gF2mField, polynomialGF2mSmallM);
        new PolynomialRingGF2m(gF2mField, polynomialGF2mSmallM);
    }
}

