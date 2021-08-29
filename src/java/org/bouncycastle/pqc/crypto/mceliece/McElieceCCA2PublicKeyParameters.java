/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKeyParameters
extends McElieceCCA2KeyParameters {
    public GF2Matrix matrixG;
    public int n;
    public int t;

    public McElieceCCA2PublicKeyParameters(int n2, int n3, GF2Matrix gF2Matrix, String string) {
        super(false, string);
        this.n = n2;
        this.t = n3;
        this.matrixG = new GF2Matrix(gF2Matrix);
    }
}

