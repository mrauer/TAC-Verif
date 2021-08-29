/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.math.BigInteger
 */
package org.bouncycastle.crypto.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Strings;

public class SSHBuilder {
    public final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    public byte[] getBytes() {
        return this.bos.toByteArray();
    }

    public void writeBigNum(BigInteger bigInteger) {
        this.writeBlock(bigInteger.toByteArray());
    }

    public void writeBlock(byte[] arrby) {
        int n2 = arrby.length;
        this.bos.write(255 & n2 >>> 24);
        this.bos.write(255 & n2 >>> 16);
        this.bos.write(255 & n2 >>> 8);
        this.bos.write(n2 & 255);
        try {
            this.bos.write(arrby);
            return;
        }
        catch (IOException iOException) {
            throw new IllegalStateException(iOException.getMessage(), (Throwable)iOException);
        }
    }

    public void writeString(String string) {
        this.writeBlock(Strings.toByteArray(string));
    }
}

