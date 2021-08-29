/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 */
package org.bouncycastle.util.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class Streams {
    public static byte[] readAll(InputStream inputStream) throws IOException {
        int n2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrby = new byte[4096];
        while ((n2 = inputStream.read(arrby, 0, 4096)) >= 0) {
            byteArrayOutputStream.write(arrby, 0, n2);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int readFully(InputStream inputStream, byte[] arrby, int n2, int n3) throws IOException {
        int n4;
        int n5;
        for (n4 = 0; n4 < n3; n4 += n5) {
            n5 = inputStream.read(arrby, n2 + n4, n3 - n4);
            if (n5 >= 0) continue;
            return n4;
        }
        return n4;
    }
}

