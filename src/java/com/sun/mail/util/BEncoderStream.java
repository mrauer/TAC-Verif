/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.FilterOutputStream
 *  java.io.OutputStream
 */
package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class BEncoderStream
extends FilterOutputStream {
    public static byte[] newline = new byte[]{13, 10};
    public static final char[] pem_array = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    public byte[] buffer = new byte[3];
    public int bufsize = 0;
    public int bytesPerLine = 76;
    public int count = 0;
    public int lineLimit = 57;
    public boolean noCRLF = true;
    public byte[] outbuf = new byte[76];

    public BEncoderStream(OutputStream outputStream) {
        super(outputStream);
    }

    public static byte[] encode(byte[] arrby, int n2, int n3, byte[] arrby2) {
        if (arrby2 == null) {
            arrby2 = new byte[BEncoderStream.encodedSize(n3)];
        }
        int n4 = 0;
        while (n3 >= 3) {
            int n5 = n2 + 1;
            int n6 = (255 & arrby[n2]) << 8;
            int n7 = n5 + 1;
            int n8 = (n6 | 255 & arrby[n5]) << 8;
            int n9 = n7 + 1;
            int n10 = n8 | 255 & arrby[n7];
            int n11 = n4 + 3;
            char[] arrc = pem_array;
            arrby2[n11] = (byte)arrc[n10 & 63];
            int n12 = n10 >> 6;
            arrby2[n4 + 2] = (byte)arrc[n12 & 63];
            int n13 = n12 >> 6;
            arrby2[n4 + 1] = (byte)arrc[n13 & 63];
            int n14 = n13 >> 6;
            arrby2[n4 + 0] = (byte)arrc[n14 & 63];
            n3 -= 3;
            n4 += 4;
            n2 = n9;
        }
        if (n3 == 1) {
            int n15 = (255 & arrby[n2]) << 4;
            arrby2[n4 + 3] = 61;
            arrby2[n4 + 2] = 61;
            int n16 = n4 + 1;
            char[] arrc = pem_array;
            arrby2[n16] = (byte)arrc[n15 & 63];
            int n17 = n15 >> 6;
            arrby2[n4 + 0] = (byte)arrc[n17 & 63];
            return arrby2;
        }
        if (n3 == 2) {
            int n18 = n2 + 1;
            int n19 = ((255 & arrby[n2]) << 8 | 255 & arrby[n18]) << 2;
            arrby2[n4 + 3] = 61;
            int n20 = n4 + 2;
            char[] arrc = pem_array;
            arrby2[n20] = (byte)arrc[n19 & 63];
            int n21 = n19 >> 6;
            arrby2[n4 + 1] = (byte)arrc[n21 & 63];
            int n22 = n21 >> 6;
            arrby2[n4 + 0] = (byte)arrc[n22 & 63];
        }
        return arrby2;
    }

    public static int encodedSize(int n2) {
        return 4 * ((n2 + 2) / 3);
    }

    public void close() {
        BEncoderStream bEncoderStream = this;
        synchronized (bEncoderStream) {
            this.flush();
            if (this.count > 0 && !this.noCRLF) {
                this.out.write(newline);
                this.out.flush();
            }
            this.out.close();
            return;
        }
    }

    public final void encode() {
        int n2;
        int n3 = BEncoderStream.encodedSize(this.bufsize);
        this.out.write(BEncoderStream.encode(this.buffer, 0, this.bufsize, this.outbuf), 0, n3);
        this.count = n2 = n3 + this.count;
        if (n2 >= this.bytesPerLine) {
            if (!this.noCRLF) {
                this.out.write(newline);
            }
            this.count = 0;
        }
    }

    public void flush() {
        BEncoderStream bEncoderStream = this;
        synchronized (bEncoderStream) {
            if (this.bufsize > 0) {
                this.encode();
                this.bufsize = 0;
            }
            this.out.flush();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void write(int n2) {
        BEncoderStream bEncoderStream = this;
        synchronized (bEncoderStream) {
            int n3;
            byte[] arrby = this.buffer;
            int n4 = this.bufsize;
            this.bufsize = n3 = n4 + 1;
            arrby[n4] = (byte)n2;
            if (n3 == 3) {
                this.encode();
                this.bufsize = 0;
            }
            return;
        }
    }

    public void write(byte[] arrby) {
        this.write(arrby, 0, arrby.length);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void write(byte[] arrby, int n2, int n3) {
        BEncoderStream bEncoderStream = this;
        synchronized (bEncoderStream) {
            int n4;
            int n5 = n3 + n2;
            while (this.bufsize != 0 && n2 < n5) {
                int n6 = n2 + 1;
                this.write(arrby[n2]);
                n2 = n6;
            }
            int n7 = 3 * ((this.bytesPerLine - this.count) / 4);
            int n8 = n2 + n7;
            if (n8 <= n5) {
                int n9 = BEncoderStream.encodedSize(n7);
                if (!this.noCRLF) {
                    byte[] arrby2 = this.outbuf;
                    int n10 = n9 + 1;
                    arrby2[n9] = 13;
                    n9 = n10 + 1;
                    arrby2[n10] = 10;
                }
                this.out.write(BEncoderStream.encode(arrby, n2, n7, this.outbuf), 0, n9);
                this.count = 0;
                n2 = n8;
            }
            while (n2 + (n4 = this.lineLimit) <= n5) {
                this.out.write(BEncoderStream.encode(arrby, n2, n4, this.outbuf));
                n2 += this.lineLimit;
            }
            if (n2 + 3 <= n5) {
                int n11 = 3 * ((n5 - n2) / 3);
                int n12 = BEncoderStream.encodedSize(n11);
                this.out.write(BEncoderStream.encode(arrby, n2, n11, this.outbuf), 0, n12);
                n2 += n11;
                this.count = n12 + this.count;
            }
            while (n2 < n5) {
                this.write(arrby[n2]);
                ++n2;
            }
            return;
        }
    }
}

