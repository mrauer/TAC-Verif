/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.LimitedInputStream;
import org.bouncycastle.util.io.Streams;

public class DefiniteLengthInputStream
extends LimitedInputStream {
    public static final byte[] EMPTY_BYTES = new byte[0];
    public final int _originalLength;
    public int _remaining;

    public DefiniteLengthInputStream(InputStream inputStream, int n2, int n3) {
        super(inputStream, n3);
        if (n2 >= 0) {
            this._originalLength = n2;
            this._remaining = n2;
            if (n2 == 0) {
                this.setParentEofDetect(true);
            }
            return;
        }
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    public int read() throws IOException {
        if (this._remaining == 0) {
            return -1;
        }
        int n2 = this._in.read();
        if (n2 >= 0) {
            int n3;
            this._remaining = n3 = this._remaining - 1;
            if (n3 == 0) {
                this.setParentEofDetect(true);
            }
            return n2;
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"DEF length ");
        stringBuilder.append(this._originalLength);
        stringBuilder.append(" object truncated by ");
        stringBuilder.append(this._remaining);
        throw new EOFException(stringBuilder.toString());
    }

    public int read(byte[] arrby, int n2, int n3) throws IOException {
        int n4 = this._remaining;
        if (n4 == 0) {
            return -1;
        }
        int n5 = Math.min((int)n3, (int)n4);
        int n6 = this._in.read(arrby, n2, n5);
        if (n6 >= 0) {
            int n7;
            this._remaining = n7 = this._remaining - n6;
            if (n7 == 0) {
                this.setParentEofDetect(true);
            }
            return n6;
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"DEF length ");
        stringBuilder.append(this._originalLength);
        stringBuilder.append(" object truncated by ");
        stringBuilder.append(this._remaining);
        throw new EOFException(stringBuilder.toString());
    }

    public byte[] toByteArray() throws IOException {
        int n2 = this._remaining;
        if (n2 == 0) {
            return EMPTY_BYTES;
        }
        int n3 = this._limit;
        if (n2 < n3) {
            int n4;
            byte[] arrby = new byte[n2];
            this._remaining = n4 = n2 - Streams.readFully(this._in, arrby, 0, n2);
            if (n4 == 0) {
                this.setParentEofDetect(true);
                return arrby;
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"DEF length ");
            stringBuilder.append(this._originalLength);
            stringBuilder.append(" object truncated by ");
            stringBuilder.append(this._remaining);
            throw new EOFException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"corrupted stream - out of bounds length found: ");
        stringBuilder.append(this._remaining);
        stringBuilder.append(" >= ");
        stringBuilder.append(n3);
        throw new IOException(stringBuilder.toString());
    }
}

