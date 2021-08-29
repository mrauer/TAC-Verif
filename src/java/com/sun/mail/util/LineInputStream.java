/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.FilterInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.PushbackInputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.nio.charset.Charset
 *  java.nio.charset.StandardCharsets
 */
package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class LineInputStream
extends FilterInputStream {
    public boolean allowutf8 = false;
    public byte[] lineBuffer = null;

    public LineInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public String readLine() throws IOException {
        int n2;
        byte[] arrby = this.lineBuffer;
        if (arrby == null) {
            this.lineBuffer = arrby = new byte[128];
        }
        int n3 = arrby.length;
        int n4 = 0;
        while ((n2 = this.in.read()) != -1 && n2 != 10) {
            int n5 = 1;
            if (n2 == 13) {
                int n6;
                if (this.in.markSupported()) {
                    this.in.mark(2);
                }
                if ((n6 = this.in.read()) == 13) {
                    n6 = this.in.read();
                } else {
                    n5 = 0;
                }
                if (n6 == 10) break;
                if (this.in.markSupported()) {
                    this.in.reset();
                    break;
                }
                if (!(this.in instanceof PushbackInputStream)) {
                    this.in = new PushbackInputStream(this.in, 2);
                }
                if (n6 != -1) {
                    ((PushbackInputStream)this.in).unread(n6);
                }
                if (n5 == 0) break;
                ((PushbackInputStream)this.in).unread(13);
                break;
            }
            if (--n3 < 0) {
                arrby = arrby.length < 1048576 ? new byte[2 * arrby.length] : new byte[1048576 + arrby.length];
                n3 = arrby.length - n4 - n5;
                System.arraycopy((Object)this.lineBuffer, (int)0, (Object)arrby, (int)0, (int)n4);
                this.lineBuffer = arrby;
            }
            int n7 = n4 + 1;
            arrby[n4] = (byte)n2;
            n4 = n7;
        }
        if (n2 == -1 && n4 == 0) {
            return null;
        }
        if (this.allowutf8) {
            return new String(arrby, 0, n4, StandardCharsets.UTF_8);
        }
        return new String(arrby, 0, 0, n4);
    }
}

