/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.String
 */
package org.bouncycastle.crypto.digests;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.bouncycastle.crypto.digests.GeneralDigest;
import org.bouncycastle.math.raw.Nat576;

public class SHA1Digest
extends GeneralDigest {
    public int H1;
    public int H2;
    public int H3;
    public int H4;
    public int H5;
    public int[] X = new int[80];
    public int xOff;

    public SHA1Digest() {
        this.reset();
    }

    @Override
    public int doFinal(byte[] arrby, int n2) {
        this.finish();
        Nat576.intToBigEndian(this.H1, arrby, n2);
        Nat576.intToBigEndian(this.H2, arrby, n2 + 4);
        Nat576.intToBigEndian(this.H3, arrby, n2 + 8);
        Nat576.intToBigEndian(this.H4, arrby, n2 + 12);
        Nat576.intToBigEndian(this.H5, arrby, n2 + 16);
        this.reset();
        return 20;
    }

    public final int f(int n2, int n3, int n4) {
        return n3 & n2 | n4 & n2;
    }

    public final int g(int n2, int n3, int n4) {
        return n2 & n3 | n2 & n4 | n3 & n4;
    }

    @Override
    public String getAlgorithmName() {
        return "SHA-1";
    }

    @Override
    public int getDigestSize() {
        return 20;
    }

    @Override
    public void processBlock() {
        for (int i2 = 16; i2 < 80; ++i2) {
            int[] arrn = this.X;
            int n2 = arrn[i2 - 3] ^ arrn[i2 - 8] ^ arrn[i2 - 14] ^ arrn[i2 - 16];
            arrn[i2] = n2 << 1 | n2 >>> 31;
        }
        int n3 = this.H1;
        int n4 = this.H2;
        int n5 = this.H3;
        int n6 = this.H4;
        int n7 = this.H5;
        int n8 = 0;
        for (int i3 = 0; i3 < 4; ++i3) {
            int n9 = (n3 << 5 | n3 >>> 27) + this.f(n4, n5, n6);
            int[] arrn = this.X;
            int n10 = n8 + 1;
            int n11 = GeneratedOutlineSupport.outline1((int)n9, (int)arrn[n8], (int)1518500249, (int)n7);
            int n12 = n4 << 30 | n4 >>> 2;
            int n13 = (n11 << 5 | n11 >>> 27) + this.f(n3, n12, n5);
            int[] arrn2 = this.X;
            int n14 = n10 + 1;
            int n15 = GeneratedOutlineSupport.outline1((int)n13, (int)arrn2[n10], (int)1518500249, (int)n6);
            int n16 = n3 << 30 | n3 >>> 2;
            int n17 = (n15 << 5 | n15 >>> 27) + this.f(n11, n16, n12);
            int[] arrn3 = this.X;
            int n18 = n14 + 1;
            int n19 = GeneratedOutlineSupport.outline1((int)n17, (int)arrn3[n14], (int)1518500249, (int)n5);
            n7 = n11 << 30 | n11 >>> 2;
            int n20 = (n19 << 5 | n19 >>> 27) + this.f(n15, n7, n16);
            int[] arrn4 = this.X;
            int n21 = n18 + 1;
            n4 = GeneratedOutlineSupport.outline1((int)n20, (int)arrn4[n18], (int)1518500249, (int)n12);
            n6 = n15 << 30 | n15 >>> 2;
            int n22 = (n4 << 5 | n4 >>> 27) + this.f(n19, n6, n7);
            int[] arrn5 = this.X;
            int n23 = n21 + 1;
            n3 = GeneratedOutlineSupport.outline1((int)n22, (int)arrn5[n21], (int)1518500249, (int)n16);
            n5 = n19 << 30 | n19 >>> 2;
            n8 = n23;
        }
        for (int i4 = 0; i4 < 4; ++i4) {
            int n24 = (n3 << 5 | n3 >>> 27) + (n6 ^ (n4 ^ n5));
            int[] arrn = this.X;
            int n25 = n8 + 1;
            int n26 = GeneratedOutlineSupport.outline1((int)n24, (int)arrn[n8], (int)1859775393, (int)n7);
            int n27 = n4 << 30 | n4 >>> 2;
            int n28 = (n26 << 5 | n26 >>> 27) + (n5 ^ (n3 ^ n27));
            int n29 = n25 + 1;
            int n30 = GeneratedOutlineSupport.outline1((int)n28, (int)arrn[n25], (int)1859775393, (int)n6);
            int n31 = n3 << 30 | n3 >>> 2;
            int n32 = (n30 << 5 | n30 >>> 27) + (n27 ^ (n26 ^ n31));
            int n33 = n29 + 1;
            int n34 = GeneratedOutlineSupport.outline1((int)n32, (int)arrn[n29], (int)1859775393, (int)n5);
            n7 = n26 << 30 | n26 >>> 2;
            int n35 = (n34 << 5 | n34 >>> 27) + (n31 ^ (n30 ^ n7));
            int n36 = n33 + 1;
            n4 = GeneratedOutlineSupport.outline1((int)n35, (int)arrn[n33], (int)1859775393, (int)n27);
            n6 = n30 << 30 | n30 >>> 2;
            int n37 = (n4 << 5 | n4 >>> 27) + (n7 ^ (n34 ^ n6));
            int n38 = n36 + 1;
            n3 = GeneratedOutlineSupport.outline1((int)n37, (int)arrn[n36], (int)1859775393, (int)n31);
            n5 = n34 << 30 | n34 >>> 2;
            n8 = n38;
        }
        for (int i5 = 0; i5 < 4; ++i5) {
            int n39 = (n3 << 5 | n3 >>> 27) + this.g(n4, n5, n6);
            int[] arrn = this.X;
            int n40 = n8 + 1;
            int n41 = GeneratedOutlineSupport.outline1((int)n39, (int)arrn[n8], (int)-1894007588, (int)n7);
            int n42 = n4 << 30 | n4 >>> 2;
            int n43 = (n41 << 5 | n41 >>> 27) + this.g(n3, n42, n5);
            int[] arrn6 = this.X;
            int n44 = n40 + 1;
            int n45 = GeneratedOutlineSupport.outline1((int)n43, (int)arrn6[n40], (int)-1894007588, (int)n6);
            int n46 = n3 << 30 | n3 >>> 2;
            int n47 = (n45 << 5 | n45 >>> 27) + this.g(n41, n46, n42);
            int[] arrn7 = this.X;
            int n48 = n44 + 1;
            int n49 = GeneratedOutlineSupport.outline1((int)n47, (int)arrn7[n44], (int)-1894007588, (int)n5);
            n7 = n41 << 30 | n41 >>> 2;
            int n50 = (n49 << 5 | n49 >>> 27) + this.g(n45, n7, n46);
            int[] arrn8 = this.X;
            int n51 = n48 + 1;
            n4 = GeneratedOutlineSupport.outline1((int)n50, (int)arrn8[n48], (int)-1894007588, (int)n42);
            n6 = n45 << 30 | n45 >>> 2;
            int n52 = (n4 << 5 | n4 >>> 27) + this.g(n49, n6, n7);
            int[] arrn9 = this.X;
            int n53 = n51 + 1;
            n3 = GeneratedOutlineSupport.outline1((int)n52, (int)arrn9[n51], (int)-1894007588, (int)n46);
            n5 = n49 << 30 | n49 >>> 2;
            n8 = n53;
        }
        for (int i6 = 0; i6 <= 3; ++i6) {
            int n54 = (n3 << 5 | n3 >>> 27) + (n6 ^ (n4 ^ n5));
            int[] arrn = this.X;
            int n55 = n8 + 1;
            int n56 = GeneratedOutlineSupport.outline1((int)n54, (int)arrn[n8], (int)-899497514, (int)n7);
            int n57 = n4 << 30 | n4 >>> 2;
            int n58 = (n56 << 5 | n56 >>> 27) + (n5 ^ (n3 ^ n57));
            int n59 = n55 + 1;
            int n60 = GeneratedOutlineSupport.outline1((int)n58, (int)arrn[n55], (int)-899497514, (int)n6);
            int n61 = n3 << 30 | n3 >>> 2;
            int n62 = (n60 << 5 | n60 >>> 27) + (n57 ^ (n56 ^ n61));
            int n63 = n59 + 1;
            int n64 = GeneratedOutlineSupport.outline1((int)n62, (int)arrn[n59], (int)-899497514, (int)n5);
            n7 = n56 << 30 | n56 >>> 2;
            int n65 = (n64 << 5 | n64 >>> 27) + (n61 ^ (n60 ^ n7));
            int n66 = n63 + 1;
            n4 = GeneratedOutlineSupport.outline1((int)n65, (int)arrn[n63], (int)-899497514, (int)n57);
            n6 = n60 << 30 | n60 >>> 2;
            int n67 = (n4 << 5 | n4 >>> 27) + (n7 ^ (n64 ^ n6));
            int n68 = n66 + 1;
            n3 = GeneratedOutlineSupport.outline1((int)n67, (int)arrn[n66], (int)-899497514, (int)n61);
            n5 = n64 << 30 | n64 >>> 2;
            n8 = n68;
        }
        this.H1 = n3 + this.H1;
        this.H2 = n4 + this.H2;
        this.H3 = n5 + this.H3;
        this.H4 = n6 + this.H4;
        this.H5 = n7 + this.H5;
        this.xOff = 0;
        for (int i7 = 0; i7 < 16; ++i7) {
            this.X[i7] = 0;
        }
    }

    @Override
    public void processLength(long l2) {
        if (this.xOff > 14) {
            this.processBlock();
        }
        int[] arrn = this.X;
        arrn[14] = (int)(l2 >>> 32);
        arrn[15] = (int)l2;
    }

    @Override
    public void processWord(byte[] arrby, int n2) {
        int n3;
        int n4 = arrby[n2] << 24;
        int n5 = n2 + 1;
        int n6 = n4 | (255 & arrby[n5]) << 16;
        int n7 = n5 + 1;
        int n8 = n6 | (255 & arrby[n7]) << 8 | 255 & arrby[n7 + 1];
        int[] arrn = this.X;
        int n9 = this.xOff;
        arrn[n9] = n8;
        this.xOff = n3 = n9 + 1;
        if (n3 == 16) {
            this.processBlock();
        }
    }

    @Override
    public void reset() {
        int[] arrn;
        super.reset();
        this.H1 = 1732584193;
        this.H2 = -271733879;
        this.H3 = -1732584194;
        this.H4 = 271733878;
        this.H5 = -1009589776;
        this.xOff = 0;
        for (int i2 = 0; i2 != (arrn = this.X).length; ++i2) {
            arrn[i2] = 0;
        }
    }
}

