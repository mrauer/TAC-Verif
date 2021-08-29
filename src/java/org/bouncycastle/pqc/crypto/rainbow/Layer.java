/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.pqc.crypto.rainbow;

import org.bouncycastle.math.raw.Nat576;

public class Layer {
    public short[][][] coeff_alpha;
    public short[][][] coeff_beta;
    public short[] coeff_eta;
    public short[][] coeff_gamma;
    public int oi;
    public int vi;
    public int viNext;

    public Layer(byte by, byte by2, short[][][] arrs, short[][][] arrs2, short[][] arrs3, short[] arrs4) {
        int n2;
        int n3;
        this.vi = n2 = by & 255;
        this.viNext = n3 = by2 & 255;
        this.oi = n3 - n2;
        this.coeff_alpha = arrs;
        this.coeff_beta = arrs2;
        this.coeff_gamma = arrs3;
        this.coeff_eta = arrs4;
    }

    public boolean equals(Object object) {
        if (object != null && object instanceof Layer) {
            Layer layer = (Layer)object;
            if (this.vi == layer.vi && this.viNext == layer.viNext && this.oi == layer.oi && Nat576.equals(this.coeff_alpha, layer.coeff_alpha) && Nat576.equals(this.coeff_beta, layer.coeff_beta) && Nat576.equals(this.coeff_gamma, layer.coeff_gamma) && Nat576.equals(this.coeff_eta, layer.coeff_eta)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return 37 * (37 * (37 * (37 * (37 * (37 * this.vi + this.viNext) + this.oi) + Nat576.hashCode(this.coeff_alpha)) + Nat576.hashCode(this.coeff_beta)) + Nat576.hashCode(this.coeff_gamma)) + Nat576.hashCode(this.coeff_eta);
    }
}

