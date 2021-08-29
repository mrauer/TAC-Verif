/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.String
 */
package com.sun.mail.util;

import com.sun.mail.util.QPEncoderStream;
import java.io.IOException;
import java.io.OutputStream;

public class QEncoderStream
extends QPEncoderStream {
    public static final /* synthetic */ int $r8$clinit;
    public String specials;

    public QEncoderStream(OutputStream outputStream, boolean bl) {
        super(outputStream, Integer.MAX_VALUE);
        String string = bl ? "=_?\"#$%&'(),.:;<>@[\\]^`{|}~" : "=_?";
        this.specials = string;
    }

    @Override
    public void write(int n2) throws IOException {
        int n3 = n2 & 255;
        if (n3 == 32) {
            this.output(95, false);
            return;
        }
        if (n3 >= 32 && n3 < 127 && this.specials.indexOf(n3) < 0) {
            this.output(n3, false);
            return;
        }
        this.output(n3, true);
    }
}

