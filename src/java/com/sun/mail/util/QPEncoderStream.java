/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.FilterOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 */
package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class QPEncoderStream
extends FilterOutputStream {
    public static final char[] hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public int bytesPerLine;
    public int count = 0;

    public QPEncoderStream(OutputStream outputStream, int n2) {
        super(outputStream);
        this.bytesPerLine = n2 - 1;
    }

    public void close() throws IOException {
        this.flush();
        this.out.close();
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void output(int n2, boolean bl) throws IOException {
        int n3;
        if (bl) {
            int n4;
            this.count = n4 = 3 + this.count;
            if (n4 > this.bytesPerLine) {
                this.out.write(61);
                this.out.write(13);
                this.out.write(10);
                this.count = 3;
            }
            this.out.write(61);
            OutputStream outputStream = this.out;
            char[] arrc = hex;
            outputStream.write((int)arrc[n2 >> 4]);
            this.out.write((int)arrc[n2 & 15]);
            return;
        }
        this.count = n3 = 1 + this.count;
        if (n3 > this.bytesPerLine) {
            this.out.write(61);
            this.out.write(13);
            this.out.write(10);
            this.count = 1;
        }
        this.out.write(n2);
    }

    public void write(int n2) throws IOException {
        throw null;
    }

    public void write(byte[] arrby) throws IOException {
        this.write(arrby, 0, arrby.length);
    }

    public void write(byte[] arrby, int n2, int n3) throws IOException {
        for (int i2 = 0; i2 < n3; ++i2) {
            this.write(arrby[n2 + i2]);
        }
    }
}

