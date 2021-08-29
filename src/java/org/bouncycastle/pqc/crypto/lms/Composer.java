/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.util.Encodable;

public class Composer {
    public final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    public byte[] build() {
        return this.bos.toByteArray();
    }

    public Composer bytes(Encodable encodable) {
        try {
            this.bos.write(encodable.getEncoded());
            return this;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception.getMessage(), (Throwable)exception);
        }
    }

    public Composer bytes(byte[] arrby) {
        try {
            this.bos.write(arrby);
            return this;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception.getMessage(), (Throwable)exception);
        }
    }

    public Composer u32str(int n2) {
        this.bos.write((int)((byte)(n2 >>> 24)));
        this.bos.write((int)((byte)(n2 >>> 16)));
        this.bos.write((int)((byte)(n2 >>> 8)));
        this.bos.write((int)((byte)n2));
        return this;
    }
}

