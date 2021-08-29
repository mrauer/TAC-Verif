/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.StreamUtil;

public class DLBitString
extends ASN1BitString {
    public DLBitString(byte[] arrby, int n2) {
        super(arrby, n2);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 3, (byte)this.padBits, this.data);
    }

    @Override
    public int encodedLength() {
        return 1 + (1 + StreamUtil.calculateBodyLength(1 + this.data.length) + this.data.length);
    }

    @Override
    public boolean isConstructed() {
        return false;
    }

    @Override
    public ASN1Primitive toDLObject() {
        return this;
    }
}

