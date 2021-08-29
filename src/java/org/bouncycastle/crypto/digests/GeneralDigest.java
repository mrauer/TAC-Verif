/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 */
package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.Digest;

public abstract class GeneralDigest
implements Digest {
    public long byteCount;
    public final byte[] xBuf = new byte[4];
    public int xBufOff = 0;

    public void finish() {
        long l2 = this.byteCount << 3;
        byte by = -128;
        do {
            this.update(by);
            if (this.xBufOff == 0) break;
            by = 0;
        } while (true);
        this.processLength(l2);
        this.processBlock();
    }

    public abstract void processBlock();

    public abstract void processLength(long var1);

    public abstract void processWord(byte[] var1, int var2);

    public void reset() {
        byte[] arrby;
        this.byteCount = 0L;
        this.xBufOff = 0;
        for (int i2 = 0; i2 < (arrby = this.xBuf).length; ++i2) {
            arrby[i2] = 0;
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
        this.byteCount = 1L + this.byteCount;
    }

    @Override
    public void update(byte[] arrby, int n2, int n3) {
        int n4;
        int n5;
        block5 : {
            n4 = Math.max((int)0, (int)n3);
            int n6 = this.xBufOff;
            n5 = 0;
            if (n6 != 0) {
                int n7 = 0;
                while (n7 < n4) {
                    int n8;
                    byte[] arrby2 = this.xBuf;
                    int n9 = this.xBufOff;
                    this.xBufOff = n8 = n9 + 1;
                    int n10 = n7 + 1;
                    arrby2[n9] = arrby[n7 + n2];
                    if (n8 == 4) {
                        this.processWord(arrby2, 0);
                        this.xBufOff = 0;
                        n5 = n10;
                        break block5;
                    }
                    n7 = n10;
                }
                n5 = n7;
            }
        }
        int n11 = n5 + (-4 & n4 - n5);
        while (n5 < n11) {
            this.processWord(arrby, n2 + n5);
            n5 += 4;
        }
        while (n5 < n4) {
            byte[] arrby3 = this.xBuf;
            int n12 = this.xBufOff;
            this.xBufOff = n12 + 1;
            int n13 = n5 + 1;
            arrby3[n12] = arrby[n5 + n2];
            n5 = n13;
        }
        this.byteCount += (long)n4;
    }
}

