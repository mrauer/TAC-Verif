/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.crypto.mceliece.McElieceKeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKeyParameters
extends McElieceKeyParameters {
    public GF2Matrix g;
    public int n;
    public int t;

    public McEliecePublicKeyParameters(int n2, int n3, GF2Matrix gF2Matrix) {
        super(false);
        this.n = n2;
        this.t = n3;
        this.g = new GF2Matrix(gF2Matrix);
    }
}

