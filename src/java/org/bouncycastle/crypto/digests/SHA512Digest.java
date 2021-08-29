/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.digests.LongDigest;
import org.bouncycastle.math.raw.Nat576;

public class SHA512Digest
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
        Nat576.longToBigEndian(this.H7, arrby, n2 + 48);
        Nat576.longToBigEndian(this.H8, arrby, n2 + 56);
        this.reset();
        return 64;
    }

    @Override
    public String getAlgorithmName() {
        return "SHA-512";
    }

    @Override
    public int getDigestSize() {
        return 64;
    }

    @Override
    public void reset() {
        super.reset();
        this.H1 = 7640891576956012808L;
        this.H2 = -4942790177534073029L;
        this.H3 = 4354685564936845355L;
        this.H4 = -6534734903238641935L;
        this.H5 = 5840696475078001361L;
        this.H6 = -7276294671716946913L;
        this.H7 = 2270897969802886507L;
        this.H8 = 6620516959819538809L;
    }
}

