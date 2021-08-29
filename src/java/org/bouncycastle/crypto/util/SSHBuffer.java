/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.bouncycastle.crypto.util;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat576;

public class SSHBuffer {
    public final byte[] buffer;
    public int pos = 0;

    public SSHBuffer(byte[] arrby) {
        this.buffer = arrby;
    }

    public BigInteger readBigNumPositive() {
        byte[] arrby;
        int n2 = this.pos;
        int n3 = this.readU32();
        int n4 = n2 + n3;
        if (n4 <= (arrby = this.buffer).length) {
            int n5;
            this.pos = n5 = n3 + n2;
            return new BigInteger(1, Nat576.copyOfRange(arrby, n2, n5));
        }
        throw new IllegalArgumentException("not enough data for big num");
    }

    public byte[] readBlock() {
        int n2 = this.readU32();
        if (n2 == 0) {
            return new byte[0];
        }
        int n3 = this.pos;
        byte[] arrby = this.buffer;
        if (n3 <= arrby.length - n2) {
            int n4;
            this.pos = n4 = n2 + n3;
            return Nat576.copyOfRange(arrby, n3, n4);
        }
        throw new IllegalArgumentException("not enough data for block");
    }

    public int readU32() {
        int n2 = this.pos;
        byte[] arrby = this.buffer;
        if (n2 <= -4 + arrby.length) {
            int n3;
            int n4;
            int n5;
            this.pos = n5 = n2 + 1;
            int n6 = (255 & arrby[n2]) << 24;
            this.pos = n4 = n5 + 1;
            int n7 = n6 | (255 & arrby[n5]) << 16;
            this.pos = n3 = n4 + 1;
            int n8 = n7 | (255 & arrby[n4]) << 8;
            this.pos = n3 + 1;
            return n8 | 255 & arrby[n3];
        }
        throw new IllegalArgumentException("4 bytes for U32 exceeds buffer.");
    }
}

