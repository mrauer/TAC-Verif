/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

public class McElieceCCA2PrivateKeyParameters
extends McElieceCCA2KeyParameters {
    public GF2mField field;
    public PolynomialGF2mSmallM goppaPoly;
    public GF2Matrix h;
    public int k;
    public int n;
    public Permutation p;

    public McElieceCCA2PrivateKeyParameters(int n2, int n3, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, String string) {
        GF2Matrix gF2Matrix = Nat576.createCanonicalCheckMatrix(gF2mField, polynomialGF2mSmallM);
        super(true, string);
        this.n = n2;
        this.k = n3;
        this.field = gF2mField;
        this.goppaPoly = polynomialGF2mSmallM;
        this.h = gF2Matrix;
        this.p = permutation;
        new PolynomialRingGF2m(gF2mField, polynomialGF2mSmallM);
    }
}

