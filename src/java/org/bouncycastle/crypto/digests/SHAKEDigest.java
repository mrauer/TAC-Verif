/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Arrays
 */
package org.bouncycastle.crypto.digests;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class SHAKEDigest
implements Xof,
Digest {
    public static long[] KeccakRoundConstants = new long[]{1L, 32898L, -9223372036854742902L, -9223372034707259392L, 32907L, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138L, 136L, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778L, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};
    public int bitsInQueue;
    public byte[] dataQueue;
    public int fixedOutputLength;
    public int rate;
    public boolean squeezing;
    public long[] state;

    public SHAKEDigest(int n2) {
        if (n2 != 128 && n2 != 256) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"'bitLength' ", (int)n2, (String)" not supported for SHAKE"));
        }
        this.state = new long[25];
        this.dataQueue = new byte[192];
        this.init(n2);
    }

    public final void KeccakAbsorb(byte[] arrby, int n2) {
        int n3 = this.rate >>> 6;
        for (int i2 = 0; i2 < n3; ++i2) {
            long[] arrl = this.state;
            arrl[i2] = arrl[i2] ^ Nat576.littleEndianToLong(arrby, n2);
            n2 += 8;
        }
        byte[] arrby2 = this.dumpState();
        Strings.fromByteArray(Hex.encode(arrby2, 0, arrby2.length)).toLowerCase();
        this.KeccakPermutation();
    }

    public final void KeccakExtract() {
        this.KeccakPermutation();
        this.dumpState();
        long[] arrl = this.state;
        int n2 = this.rate >>> 6;
        byte[] arrby = this.dataQueue;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l2 = arrl[0 + i2];
            Nat576.intToLittleEndian((int)(0xFFFFFFFFL & l2), arrby, n3);
            Nat576.intToLittleEndian((int)(l2 >>> 32), arrby, n3 + 4);
            n3 += 8;
        }
        this.bitsInQueue = this.rate;
    }

    public final void KeccakPermutation() {
        long[] arrl = this.state;
        long l2 = arrl[0];
        int n2 = 1;
        long l3 = arrl[n2];
        long l4 = arrl[2];
        int n3 = 3;
        long l5 = arrl[n3];
        long l6 = arrl[4];
        long l7 = arrl[5];
        long l8 = arrl[6];
        long l9 = arrl[7];
        long l10 = arrl[8];
        long l11 = arrl[9];
        long l12 = arrl[10];
        long l13 = arrl[11];
        long l14 = arrl[12];
        long l15 = arrl[13];
        long l16 = arrl[14];
        long l17 = arrl[15];
        long l18 = arrl[16];
        long l19 = arrl[17];
        long l20 = arrl[18];
        long l21 = arrl[19];
        long l22 = arrl[20];
        long l23 = arrl[21];
        long l24 = arrl[22];
        long l25 = arrl[23];
        int n4 = 24;
        long l26 = arrl[n4];
        for (int i2 = 0; i2 < n4; ++i2) {
            long l27 = l22 ^ (l17 ^ (l12 ^ (l2 ^ l7)));
            long l28 = l23 ^ (l18 ^ (l13 ^ (l3 ^ l8)));
            long l29 = l24 ^ (l19 ^ (l14 ^ (l4 ^ l9)));
            long l30 = l25 ^ (l20 ^ (l15 ^ (l5 ^ l10)));
            long l31 = l26 ^ (l21 ^ (l16 ^ (l6 ^ l11)));
            long l32 = l31 ^ (l28 << n2 | l28 >>> -1);
            long l33 = l27 ^ (l29 << n2 | l29 >>> -1);
            long l34 = l28 ^ (l30 << n2 | l30 >>> -1);
            long l35 = l29 ^ (l31 << n2 | l31 >>> -1);
            long l36 = l30 ^ (l27 << n2 | l27 >>> -1);
            long l37 = l2 ^ l32;
            long l38 = l7 ^ l32;
            long l39 = l12 ^ l32;
            long l40 = l17 ^ l32;
            long l41 = l22 ^ l32;
            long l42 = l3 ^ l33;
            long l43 = l8 ^ l33;
            long l44 = l13 ^ l33;
            long l45 = l18 ^ l33;
            long l46 = l23 ^ l33;
            long l47 = l4 ^ l34;
            long l48 = l9 ^ l34;
            long l49 = l14 ^ l34;
            long l50 = l19 ^ l34;
            long l51 = l24 ^ l34;
            long l52 = l5 ^ l35;
            long l53 = l10 ^ l35;
            long l54 = l15 ^ l35;
            long l55 = l20 ^ l35;
            long l56 = l25 ^ l35;
            long l57 = l6 ^ l36;
            long l58 = l11 ^ l36;
            long l59 = l16 ^ l36;
            long l60 = l21 ^ l36;
            long l61 = l26 ^ l36;
            long l62 = l42 << n2 | l42 >>> 63;
            long l63 = l43 << 44 | l43 >>> 20;
            long l64 = l58 << 20 | l58 >>> 44;
            long l65 = l51 << 61 | l51 >>> n3;
            long l66 = l59 << 39 | l59 >>> 25;
            long l67 = l41 << 18 | l41 >>> 46;
            long l68 = l47 << 62 | l47 >>> 2;
            long l69 = l49 << 43;
            long l70 = l49 >>> 21;
            long[] arrl2 = arrl;
            long l71 = l69 | l70;
            long l72 = l54 << 25 | l54 >>> 39;
            long l73 = l60 << 8 | l60 >>> 56;
            long l74 = l56 << 56 | l56 >>> 8;
            long l75 = l40 << 41 | l40 >>> 23;
            long l76 = l57 << 27 | l57 >>> 37;
            long l77 = l61 << 14 | l61 >>> 50;
            long l78 = l46 << 2 | l46 >>> 62;
            long l79 = l53 << 55 | l53 >>> 9;
            long l80 = l45 << 45 | l45 >>> 19;
            long l81 = l38 << 36 | l38 >>> 28;
            long l82 = l52 << 28 | l52 >>> 36;
            long l83 = l55 << 21 | l55 >>> 43;
            long l84 = l50 << 15 | l50 >>> 49;
            long l85 = l44 << 10 | l44 >>> 54;
            long l86 = l48 << 6 | l48 >>> 58;
            long l87 = l39 << 3 | l39 >>> 61;
            long l88 = l37 ^ l71 & l63;
            long l89 = l63 ^ l83 & l71;
            l4 = l71 ^ l77 & l83;
            long l90 = l83 ^ l37 & l77;
            long l91 = l77 ^ l63 & l37;
            long l92 = l82 ^ l87 & l64;
            long l93 = l64 ^ l80 & l87;
            long l94 = l87 ^ l65 & l80;
            long l95 = l80 ^ l82 & l65;
            long l96 = l65 ^ l64 & l82;
            l12 = l62 ^ l72 & l86;
            long l97 = l86 ^ l73 & l72;
            long l98 = l72 ^ l67 & l73;
            long l99 = l73 ^ l62 & l67;
            long l100 = l67 ^ l86 & l62;
            long l101 = l76 ^ l85 & l81;
            long l102 = l81 ^ l84 & l85;
            long l103 = l85 ^ l74 & l84;
            long l104 = l84 ^ l76 & l74;
            long l105 = l74 ^ l81 & l76;
            long l106 = l68 ^ l66 & l79;
            l21 = l105;
            long l107 = l79 ^ l75 & l66;
            long l108 = l66 ^ l78 & l75;
            long l109 = l75 ^ l68 & l78;
            long l110 = l78 ^ l79 & l68;
            long l111 = l88 ^ KeccakRoundConstants[i2];
            l7 = l92;
            l14 = l98;
            l13 = l97;
            l22 = l106;
            l25 = l109;
            l15 = l99;
            arrl = arrl2;
            l10 = l95;
            l6 = l91;
            l19 = l103;
            l17 = l101;
            n4 = 24;
            n2 = 1;
            l3 = l89;
            l20 = l104;
            l18 = l102;
            l24 = l108;
            l11 = l96;
            l23 = l107;
            l26 = l110;
            l2 = l111;
            n3 = 3;
            l5 = l90;
            l16 = l100;
            l9 = l94;
            l8 = l93;
        }
        long[] arrl3 = arrl;
        arrl3[0] = l2;
        arrl3[1] = l3;
        arrl3[2] = l4;
        arrl3[3] = l5;
        arrl3[4] = l6;
        arrl3[5] = l7;
        arrl3[6] = l8;
        arrl3[7] = l9;
        arrl3[8] = l10;
        arrl3[9] = l11;
        arrl3[10] = l12;
        arrl3[11] = l13;
        arrl3[12] = l14;
        arrl3[13] = l15;
        arrl3[14] = l16;
        arrl3[15] = l17;
        arrl3[16] = l18;
        arrl3[17] = l19;
        arrl3[18] = l20;
        arrl3[19] = l21;
        arrl3[20] = l22;
        arrl3[21] = l23;
        arrl3[22] = l24;
        arrl3[23] = l25;
        arrl3[24] = l26;
    }

    @Override
    public int doFinal(byte[] arrby, int n2) {
        int n3 = this.fixedOutputLength / 8;
        this.doFinal(arrby, n2, n3);
        return n3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public int doFinal(byte[] arrby, int n2, int n3) {
        int n4;
        long l2;
        boolean bl = this.squeezing;
        if (!bl) {
            int n5 = this.bitsInQueue;
            if (n5 % 8 != 0) throw new IllegalStateException("attempt to absorb with odd length queue");
            if (bl) throw new IllegalStateException("attempt to absorb while squeezing");
            this.dataQueue[n5 >>> 3] = 15;
            this.bitsInQueue = n5 + 4;
        }
        long l3 = 8L * (long)n3;
        if (!bl) {
            this.padAndSwitchToSqueezingPhase();
        }
        this.dumpState();
        long l4 = l3 % 8L;
        if (l4 != l2) throw new IllegalStateException("outputLength not a multiple of 8");
        for (l2 = 0L; l2 < l3; l2 += (long)n4) {
            if (this.bitsInQueue == 0) {
                this.KeccakExtract();
            }
            n4 = (int)Math.min((long)this.bitsInQueue, (long)(l3 - l2));
            System.arraycopy((Object)this.dataQueue, (int)((this.rate - this.bitsInQueue) / 8), (Object)arrby, (int)(n2 + (int)(l2 / 8L)), (int)(n4 / 8));
            this.bitsInQueue -= n4;
        }
        this.dumpState();
        this.init(this.fixedOutputLength);
        return n3;
    }

    public byte[] dumpState() {
        long[] arrl;
        byte[] arrby = new byte[8 * this.state.length];
        int n2 = 0;
        for (int i2 = 0; i2 != (arrl = this.state).length; ++i2) {
            long l2 = arrl[i2];
            Nat576.intToLittleEndian((int)(0xFFFFFFFFL & l2), arrby, n2);
            Nat576.intToLittleEndian((int)(l2 >>> 32), arrby, n2 + 4);
            n2 += 8;
        }
        return arrby;
    }

    @Override
    public String getAlgorithmName() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"SHAKE");
        stringBuilder.append(this.fixedOutputLength);
        return stringBuilder.toString();
    }

    @Override
    public int getDigestSize() {
        return this.fixedOutputLength / 8;
    }

    public final void init(int n2) {
        if (n2 != 128 && n2 != 224 && n2 != 256 && n2 != 288 && n2 != 384 && n2 != 512) {
            throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
        }
        this.initSponge(1600 - (n2 << 1));
    }

    public final void initSponge(int n2) {
        if (n2 > 0 && n2 < 1600 && n2 % 64 == 0) {
            long[] arrl;
            this.rate = n2;
            for (int i2 = 0; i2 < (arrl = this.state).length; ++i2) {
                arrl[i2] = 0L;
            }
            Arrays.fill((byte[])this.dataQueue, (byte)0);
            this.bitsInQueue = 0;
            this.squeezing = false;
            this.fixedOutputLength = (1600 - n2) / 2;
            return;
        }
        throw new IllegalStateException("invalid rate value");
    }

    public final void padAndSwitchToSqueezingPhase() {
        int n2;
        byte[] arrby = this.dataQueue;
        int n3 = this.bitsInQueue;
        int n4 = n3 >>> 3;
        arrby[n4] = (byte)(arrby[n4] | (byte)(1 << (n3 & 7)));
        this.bitsInQueue = n2 = n3 + 1;
        if (n2 == this.rate) {
            this.KeccakAbsorb(arrby, 0);
        } else {
            int n5 = n2 >>> 6;
            int n6 = n2 & 63;
            int n7 = 0;
            for (int i2 = 0; i2 < n5; ++i2) {
                long[] arrl = this.state;
                arrl[i2] = arrl[i2] ^ Nat576.littleEndianToLong(this.dataQueue, n7);
                n7 += 8;
            }
            this.dumpState();
            if (n6 > 0) {
                long l2 = (1L << n6) - 1L;
                long[] arrl = this.state;
                arrl[n5] = arrl[n5] ^ l2 & Nat576.littleEndianToLong(this.dataQueue, n7);
            }
        }
        long[] arrl = this.state;
        int n8 = this.rate - 1 >>> 6;
        arrl[n8] = Long.MIN_VALUE ^ arrl[n8];
        this.bitsInQueue = 0;
        this.squeezing = true;
    }

    @Override
    public void update(byte by) {
        int n2 = this.bitsInQueue;
        if (n2 % 8 == 0) {
            if (!this.squeezing) {
                int n3;
                byte[] arrby = this.dataQueue;
                arrby[n2 >>> 3] = by;
                this.bitsInQueue = n3 = n2 + 8;
                if (n3 == this.rate) {
                    this.KeccakAbsorb(arrby, 0);
                    this.bitsInQueue = 0;
                }
                return;
            }
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
        throw new IllegalStateException("attempt to absorb with odd length queue");
    }

    @Override
    public void update(byte[] arrby, int n2, int n3) {
        int n4 = this.bitsInQueue;
        if (n4 % 8 == 0) {
            if (!this.squeezing) {
                int n5;
                int n6 = this.rate >>> 3;
                int n7 = n4 >>> 3;
                int n8 = n6 - n7;
                if (n3 < n8) {
                    System.arraycopy((Object)arrby, (int)n2, (Object)this.dataQueue, (int)n7, (int)n3);
                    n5 = this.bitsInQueue + (n3 << 3);
                } else {
                    int n9;
                    int n10;
                    if (n7 > 0) {
                        System.arraycopy((Object)arrby, (int)n2, (Object)this.dataQueue, (int)n7, (int)n8);
                        n10 = n8 + 0;
                        this.KeccakAbsorb(this.dataQueue, 0);
                    } else {
                        n10 = 0;
                    }
                    while ((n9 = n3 - n10) >= n6) {
                        this.KeccakAbsorb(arrby, n2 + n10);
                        n10 += n6;
                    }
                    System.arraycopy((Object)arrby, (int)(n2 + n10), (Object)this.dataQueue, (int)0, (int)n9);
                    n5 = n9 << 3;
                }
                this.bitsInQueue = n5;
                return;
            }
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
        throw new IllegalStateException("attempt to absorb with odd length queue");
    }
}

