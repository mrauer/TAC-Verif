/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.math.raw.Nat576;

public abstract class LongDigest
implements Digest {
    public static final long[] K = new long[]{4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    public long H1;
    public long H2;
    public long H3;
    public long H4;
    public long H5;
    public long H6;
    public long H7;
    public long H8;
    public long[] W = new long[80];
    public long byteCount1;
    public long byteCount2;
    public int wOff;
    public byte[] xBuf = new byte[8];
    public int xBufOff = 0;

    public LongDigest() {
        this.reset();
    }

    public final long Ch(long l2, long l3, long l4) {
        return l3 & l2 ^ l4 & l2;
    }

    public final long Maj(long l2, long l3, long l4) {
        return l2 & l3 ^ l2 & l4 ^ l3 & l4;
    }

    public final long Sum0(long l2) {
        return (l2 << 36 | l2 >>> 28) ^ (l2 << 30 | l2 >>> 34) ^ (l2 << 25 | l2 >>> 39);
    }

    public final long Sum1(long l2) {
        return (l2 << 50 | l2 >>> 14) ^ (l2 << 46 | l2 >>> 18) ^ (l2 << 23 | l2 >>> 41);
    }

    public final void adjustByteCounts() {
        long l2 = this.byteCount1;
        if (l2 > 0x1FFFFFFFFFFFFFFFL) {
            this.byteCount2 += l2 >>> 61;
            this.byteCount1 = l2 & 0x1FFFFFFFFFFFFFFFL;
        }
    }

    public void finish() {
        this.adjustByteCounts();
        long l2 = this.byteCount1 << 3;
        long l3 = this.byteCount2;
        byte by = -128;
        do {
            this.update(by);
            if (this.xBufOff == 0) break;
            by = 0;
        } while (true);
        if (this.wOff > 14) {
            this.processBlock();
        }
        long[] arrl = this.W;
        arrl[14] = l3;
        arrl[15] = l2;
        this.processBlock();
    }

    public void processBlock() {
        this.adjustByteCounts();
        for (int i2 = 16; i2 <= 79; ++i2) {
            long[] arrl = this.W;
            long l2 = arrl[i2 - 2];
            long l3 = ((l2 << 45 | l2 >>> 19) ^ (l2 << 3 | l2 >>> 61) ^ l2 >>> 6) + arrl[i2 - 7];
            long l4 = arrl[i2 - 15];
            arrl[i2] = l3 + ((l4 << 63 | l4 >>> 1) ^ (l4 << 56 | l4 >>> 8) ^ l4 >>> 7) + arrl[i2 - 16];
        }
        long l5 = this.H1;
        long l6 = this.H2;
        long l7 = this.H3;
        long l8 = this.H4;
        long l9 = this.H5;
        long l10 = this.H6;
        long l11 = this.H7;
        long l12 = this.H8;
        long l13 = l10;
        long l14 = l8;
        int n2 = 0;
        long l15 = l6;
        long l16 = l7;
        long l17 = l9;
        int n3 = 0;
        long l18 = l12;
        long l19 = l5;
        long l20 = l11;
        while (n3 < 10) {
            long l21 = this.Sum1(l17);
            long l22 = l17;
            int n4 = n3;
            long l23 = l13;
            long l24 = l17;
            long l25 = l21 + this.Ch(l22, l23, l20);
            long[] arrl = K;
            long l26 = l25 + arrl[n2];
            long[] arrl2 = this.W;
            int n5 = n2 + 1;
            long l27 = l18 + (l26 + arrl2[n2]);
            long l28 = l14 + l27;
            long l29 = l27 + (this.Sum0(l19) + this.Maj(l19, l15, l16));
            long l30 = this.Sum1(l28) + this.Ch(l28, l24, l13) + arrl[n5];
            long[] arrl3 = this.W;
            int n6 = n5 + 1;
            long l31 = l20 + (l30 + arrl3[n5]);
            long l32 = l16 + l31;
            long l33 = this.Sum0(l29);
            long l34 = l19;
            long l35 = l19;
            long l36 = l31 + (l33 + this.Maj(l29, l34, l15));
            long l37 = this.Sum1(l32) + this.Ch(l32, l28, l24) + arrl[n6];
            long[] arrl4 = this.W;
            int n7 = n6 + 1;
            long l38 = l13 + (l37 + arrl4[n6]);
            long l39 = l15 + l38;
            long l40 = l38 + (this.Sum0(l36) + this.Maj(l36, l29, l35));
            long l41 = this.Sum1(l39) + this.Ch(l39, l32, l28) + arrl[n7];
            long[] arrl5 = this.W;
            int n8 = n7 + 1;
            long l42 = l24 + (l41 + arrl5[n7]);
            long l43 = l35 + l42;
            long l44 = l42 + (this.Sum0(l40) + this.Maj(l40, l36, l29));
            long l45 = this.Sum1(l43) + this.Ch(l43, l39, l32) + arrl[n8];
            long[] arrl6 = this.W;
            int n9 = n8 + 1;
            long l46 = l28 + (l45 + arrl6[n8]);
            long l47 = l29 + l46;
            long l48 = l46 + (this.Sum0(l44) + this.Maj(l44, l40, l36));
            long l49 = this.Sum1(l47) + this.Ch(l47, l43, l39) + arrl[n9];
            long[] arrl7 = this.W;
            int n10 = n9 + 1;
            long l50 = l32 + (l49 + arrl7[n9]);
            long l51 = l36 + l50;
            long l52 = l50 + (this.Sum0(l48) + this.Maj(l48, l44, l40));
            long l53 = this.Sum1(l51) + this.Ch(l51, l47, l43) + arrl[n10];
            long[] arrl8 = this.W;
            int n11 = n10 + 1;
            long l54 = l39 + (l53 + arrl8[n10]);
            long l55 = l40 + l54;
            long l56 = l54 + (this.Sum0(l52) + this.Maj(l52, l48, l44));
            long l57 = this.Sum1(l55) + this.Ch(l55, l51, l47) + arrl[n11];
            long[] arrl9 = this.W;
            int n12 = n11 + 1;
            long l58 = l43 + (l57 + arrl9[n11]);
            long l59 = l44 + l58;
            long l60 = l58 + (this.Sum0(l56) + this.Maj(l56, l52, l48));
            n3 = n4 + 1;
            l16 = l52;
            n2 = n12;
            l17 = l59;
            l20 = l51;
            l13 = l55;
            l14 = l48;
            l18 = l47;
            l15 = l56;
            l19 = l60;
        }
        long l61 = l17;
        this.H1 = l19 + this.H1;
        this.H2 = l15 + this.H2;
        this.H3 = l16 + this.H3;
        this.H4 = l14 + this.H4;
        this.H5 = l61 + this.H5;
        this.H6 = l13 + this.H6;
        this.H7 = l20 + this.H7;
        this.H8 = l18 + this.H8;
        this.wOff = 0;
        for (int i3 = 0; i3 < 16; ++i3) {
            this.W[i3] = 0L;
        }
    }

    public void processWord(byte[] arrby, int n2) {
        int n3;
        long[] arrl = this.W;
        int n4 = this.wOff;
        int n5 = Nat576.bigEndianToInt(arrby, n2);
        int n6 = Nat576.bigEndianToInt(arrby, n2 + 4);
        arrl[n4] = (0xFFFFFFFFL & (long)n5) << 32 | 0xFFFFFFFFL & (long)n6;
        this.wOff = n3 = 1 + this.wOff;
        if (n3 == 16) {
            this.processBlock();
        }
    }

    public void reset() {
        long[] arrl;
        byte[] arrby;
        this.byteCount1 = 0L;
        this.byteCount2 = 0L;
        int n2 = 0;
        this.xBufOff = 0;
        for (int i2 = 0; i2 < (arrby = this.xBuf).length; ++i2) {
            arrby[i2] = 0;
        }
        this.wOff = 0;
        while (n2 != (arrl = this.W).length) {
            arrl[n2] = 0L;
            ++n2;
        }
    }

    @Override
    public void update(byte by) {
        int n2;
        byte[] arrby = this.xBuf;
        int n3 = this.xBufOff;
        this.xBufOff = n2 = n3 + 1;
        arrby[n3] = by;
        if (n2 == arrby.length) {
            this.processWord(arrby, 0);
            this.xBufOff = 0;
        }
        this.byteCount1 = 1L + this.byteCount1;
    }

    @Override
    public void update(byte[] arrby, int n2, int n3) {
        while (this.xBufOff != 0 && n3 > 0) {
            this.update(arrby[n2]);
            ++n2;
            --n3;
        }
        while (n3 > this.xBuf.length) {
            this.processWord(arrby, n2);
            byte[] arrby2 = this.xBuf;
            n2 += arrby2.length;
            n3 -= arrby2.length;
            this.byteCount1 += (long)arrby2.length;
        }
        while (n3 > 0) {
            this.update(arrby[n2]);
            ++n2;
            --n3;
        }
    }
}

