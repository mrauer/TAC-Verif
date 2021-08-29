/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  org.bouncycastle.asn1.IndefiniteLengthInputStream
 */
package org.bouncycastle.asn1;

import java.io.InputStream;
import org.bouncycastle.asn1.IndefiniteLengthInputStream;

public abstract class LimitedInputStream
extends InputStream {
    public final InputStream _in;
    public int _limit;

    public LimitedInputStream(InputStream inputStream, int n2) {
        this._in = inputStream;
        this._limit = n2;
    }

    public void setParentEofDetect(boolean bl) {
        InputStream inputStream = this._in;
        if (inputStream instanceof IndefiniteLengthInputStream) {
            IndefiniteLengthInputStream indefiniteLengthInputStream = (IndefiniteLengthInputStream)inputStream;
            indefiniteLengthInputStream._eofOn00 = bl;
            indefiniteLengthInputStream.checkForEof();
        }
    }
}

