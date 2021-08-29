/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InputStream
 */
package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.LimitedInputStream;

public class IndefiniteLengthInputStream
extends LimitedInputStream {
    public int _b1;
    public int _b2;
    public boolean _eofOn00 = true;
    public boolean _eofReached = false;

    public IndefiniteLengthInputStream(InputStream inputStream, int n2) throws IOException {
        int n3;
        super(inputStream, n2);
        this._b1 = inputStream.read();
        this._b2 = n3 = inputStream.read();
        if (n3 >= 0) {
            this.checkForEof();
            return;
        }
        throw new EOFException();
    }

    public final boolean checkForEof() {
        if (!this._eofReached && this._eofOn00 && this._b1 == 0 && this._b2 == 0) {
            this._eofReached = true;
            this.setParentEofDetect(true);
        }
        return this._eofReached;
    }

    public int read() throws IOException {
        if (this.checkForEof()) {
            return -1;
        }
        int n2 = this._in.read();
        if (n2 >= 0) {
            int n3 = this._b1;
            this._b1 = this._b2;
            this._b2 = n2;
            return n3;
        }
        throw new EOFException();
    }

    public int read(byte[] arrby, int n2, int n3) throws IOException {
        if (!this._eofOn00 && n3 >= 3) {
            if (this._eofReached) {
                return -1;
            }
            int n4 = this._in.read(arrby, n2 + 2, n3 - 2);
            if (n4 >= 0) {
                int n5;
                arrby[n2] = (byte)this._b1;
                arrby[n2 + 1] = (byte)this._b2;
                this._b1 = this._in.read();
                this._b2 = n5 = this._in.read();
                if (n5 >= 0) {
                    return n4 + 2;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }
        return InputStream.super.read(arrby, n2, n3);
    }
}

