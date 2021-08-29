/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.digests.GeneralDigest;
import org.bouncycastle.math.raw.Nat576;

public class SHA256Digest
extends GeneralDigest {
    public static final int[] K = new int[]{1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    public int H1;
    public int H2;
    public int H3;
    public int H4;
    public int H5;
    public int H6;
    public int H7;
    public int H8;
    public int[] X = new int[64];
    public int xOff;

    public SHA256Digest() {
        this.reset();
    }

    public static int Ch(int n2, int n3, int n4) {
        return n3 & n2 ^ n4 & n2;
    }

    public static int Maj(int n2, int n3, int n4) {
        return n2 & n3 | n4 & (n2 ^ n3);
    }

    public static int Sum0(int n2) {
        return (n2 >>> 2 | n2 << 30) ^ (n2 >>> 13 | n2 << 19) ^ (n2 >>> 22 | n2 << 10);
    }

    public static int Sum1(int n2) {
        return (n2 >>> 6 | n2 << 26) ^ (n2 >>> 11 | n2 << 21) ^ (n2 >>> 25 | n2 << 7);
    }

    @Override
    public int doFinal(byte[] arrby, int n2) {
        this.finish();
        Nat576.intToBigEndian(this.H1, arrby, n2);
        Nat576.intToBigEndian(this.H2, arrby, n2 + 4);
        Nat576.intToBigEndian(this.H3, arrby, n2 + 8);
        Nat576.intToBigEndian(this.H4, arrby, n2 + 12);
        Nat576.intToBigEndian(this.H5, arrby, n2 + 16);
        Nat576.intToBigEndian(this.H6, arrby, n2 + 20);
        Nat576.intToBigEndian(this.H7, arrby, n2 + 24);
        Nat576.intToBigEndian(this.H8, arrby, n2 + 28);
        this.reset();
        return 32;
    }

    @Override
    public String getAlgorithmName() {
        return "SHA-256";
    }

    @Override
    public int getDigestSize() {
        return 32;
    }

    @Override
    public void processBlock() {
        for (int i2 = 16; i2 <= 63; ++i2) {
            int[] arrn = this.X;
            int n2 = arrn[i2 - 2];
            int n3 = ((n2 >>> 17 | n2 << 15) ^ (n2 >>> 19 | n2 << 13) ^ n2 >>> 10) + arrn[i2 - 7];
            int n4 = arrn[i2 - 15];
            arrn[i2] = n3 + ((n4 >>> 7 | n4 << 25) ^ (n4 >>> 18 | n4 << 14) ^ n4 >>> 3) + arrn[i2 - 16];
        }
        int n5 = this.H1;
        int n6 = this.H2;
        int n7 = this.H3;
        int n8 = this.H4;
        int n9 = this.H5;
        int n10 = this.H6;
        int n11 = this.H7;
        int n12 = this.H8;
        int n13 = 0;
        for (int i3 = 0; i3 < 8; ++i3) {
            int n14 = SHA256Digest.Sum1(n9) + SHA256Digest.Ch(n9, n10, n11);
            int[] arrn = K;
            int n15 = n12 + (n14 + arrn[n13] + this.X[n13]);
            int n16 = n8 + n15;
            int n17 = n15 + (SHA256Digest.Sum0(n5) + SHA256Digest.Maj(n5, n6, n7));
            int n18 = n13 + 1;
            int n19 = n11 + (SHA256Digest.Sum1(n16) + SHA256Digest.Ch(n16, n9, n10) + arrn[n18] + this.X[n18]);
            int n20 = n7 + n19;
            int n21 = n19 + (SHA256Digest.Sum0(n17) + SHA256Digest.Maj(n17, n5, n6));
            int n22 = n18 + 1;
            int n23 = n10 + (SHA256Digest.Sum1(n20) + SHA256Digest.Ch(n20, n16, n9) + arrn[n22] + this.X[n22]);
            int n24 = n6 + n23;
            int n25 = n23 + (SHA256Digest.Sum0(n21) + SHA256Digest.Maj(n21, n17, n5));
            int n26 = n22 + 1;
            int n27 = n9 + (SHA256Digest.Sum1(n24) + SHA256Digest.Ch(n24, n20, n16) + arrn[n26] + this.X[n26]);
            int n28 = n5 + n27;
            int n29 = n27 + (SHA256Digest.Sum0(n25) + SHA256Digest.Maj(n25, n21, n17));
            int n30 = n26 + 1;
            int n31 = n16 + (SHA256Digest.Sum1(n28) + SHA256Digest.Ch(n28, n24, n20) + arrn[n30] + this.X[n30]);
            int n32 = n17 + n31;
            int n33 = n31 + (SHA256Digest.Sum0(n29) + SHA256Digest.Maj(n29, n25, n21));
            int n34 = n30 + 1;
            int n35 = n20 + (SHA256Digest.Sum1(n32) + SHA256Digest.Ch(n32, n28, n24) + arrn[n34] + this.X[n34]);
            int n36 = n21 + n35;
            int n37 = n35 + (SHA256Digest.Sum0(n33) + SHA256Digest.Maj(n33, n29, n25));
            int n38 = n34 + 1;
            int n39 = n24 + (SHA256Digest.Sum1(n36) + SHA256Digest.Ch(n36, n32, n28) + arrn[n38] + this.X[n38]);
            int n40 = n25 + n39;
            int n41 = n39 + (SHA256Digest.Sum0(n37) + SHA256Digest.Maj(n37, n33, n29));
            int n42 = n38 + 1;
            int n43 = n28 + (SHA256Digest.Sum1(n40) + SHA256Digest.Ch(n40, n36, n32) + arrn[n42] + this.X[n42]);
            int n44 = n29 + n43;
            int n45 = n43 + (SHA256Digest.Sum0(n41) + SHA256Digest.Maj(n41, n37, n33));
            n13 = n42 + 1;
            n9 = n44;
            n5 = n45;
            n10 = n40;
            n6 = n41;
            n11 = n36;
            n7 = n37;
            n12 = n32;
            n8 = n33;
        }
        this.H1 = n5 + this.H1;
        this.H2 = n6 + this.H2;
        this.H3 = n7 + this.H3;
        this.H4 = n8 + this.H4;
        this.H5 = n9 + this.H5;
        this.H6 = n10 + this.H6;
        this.H7 = n11 + this.H7;
        this.H8 = n12 + this.H8;
        this.xOff = 0;
        for (int i4 = 0; i4 < 16; ++i4) {
            this.X[i4] = 0;
        }
    }

    @Override
    public void processLength(long l2) {
        if (this.xOff > 14) {
            this.processBlock();
        }
        int[] arrn = this.X;
        arrn[14] = (int)(l2 >>> 32);
        arrn[15] = (int)(l2 & -1L);
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
        this.H1 = 1779033703;
        this.H2 = -1150833019;
        this.H3 = 1013904242;
        this.H4 = -1521486534;
        this.H5 = 1359893119;
        this.H6 = -1694144372;
        this.H7 = 528734635;
        this.H8 = 1541459225;
        this.xOff = 0;
        for (int i2 = 0; i2 != (arrn = this.X).length; ++i2) {
            arrn[i2] = 0;
        }
    }
}

