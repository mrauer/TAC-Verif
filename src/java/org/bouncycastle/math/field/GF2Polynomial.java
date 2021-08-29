/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Arrays
 */
package org.bouncycastle.math.field;

import java.util.Arrays;
import org.bouncycastle.math.raw.Nat576;

public class GF2Polynomial {
    public final int[] exponents;

    public GF2Polynomial(int[] arrn) {
        this.exponents = (int[])arrn.clone();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof GF2Polynomial)) {
            return false;
        }
        GF2Polynomial gF2Polynomial = (GF2Polynomial)object;
        return Arrays.equals((int[])this.exponents, (int[])gF2Polynomial.exponents);
    }

    public int getDegree() {
        int[] arrn = this.exponents;
        return arrn[-1 + arrn.length];
    }

    public int[] getExponentsPresent() {
        int[] arrn = this.exponents;
        if (arrn == null) {
            return null;
        }
        return (int[])arrn.clone();
    }

    public int hashCode() {
        return Nat576.hashCode(this.exponents);
    }
}

