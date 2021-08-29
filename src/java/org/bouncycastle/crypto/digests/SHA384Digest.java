/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.digests.LongDigest;
import org.bouncycastle.math.raw.Nat576;

public class SHA384Digest
extends LongDigest {
    @Override
    public int doFinal(byte[] arrby, int n2) {
        this.finish();
        Nat576.longToBigEndian(this.H1, arrby, n2);
        Nat576.longToBigEndian(this.H2, arrby, n2 + 8);
        Nat576.longToBigEndian(this.H3, arrby, n2 + 16);
        Nat576.longToBigEndian(this.H4, arrby, n2 + 24);
        Nat576.longToBigEndian(this.H5, arrby, n2 + 32);
        Nat576.longToBigEndian(this.H6, arrby, n2 + 40);
        this.reset();
        return 48;
    }

    @Override
    public String getAlgorithmName() {
        return "SHA-384";
    }

    @Override
    public int getDigestSize() {
        return 48;
    }

    @Override
    public void reset() {
        super.reset();
        this.H1 = -3766243637369397544L;
        this.H2 = 7105036623409894663L;
        this.H3 = -7973340178411365097L;
        this.H4 = 1526699215303891257L;
        this.H5 = 7436329637833083697L;
        this.H6 = -8163818279084223215L;
        this.H7 = -2662702644619276377L;
        this.H8 = 5167115440072839076L;
    }
}

