/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.String
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.StreamUtil;

public class DEROctetString
extends ASN1OctetString {
    public DEROctetString(ASN1Encodable aSN1Encodable) throws IOException {
        super(aSN1Encodable.toASN1Primitive().getEncoded("DER"));
    }

    public DEROctetString(byte[] arrby) {
        super(arrby);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 4, this.string);
    }

    @Override
    public int encodedLength() {
        return 1 + StreamUtil.calculateBodyLength(this.string.length) + this.string.length;
    }

    @Override
    public boolean isConstructed() {
        return false;
    }

    @Override
    public ASN1Primitive toDERObject() {
        return this;
    }

    @Override
    public ASN1Primitive toDLObject() {
        return this;
    }
}

