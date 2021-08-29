/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  org.bouncycastle.asn1.ASN1Primitive
 */
package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.util.Encodable;

public abstract class ASN1Object
implements ASN1Encodable,
Encodable {
    public void encodeTo(OutputStream outputStream) throws IOException {
        new ASN1OutputStream(outputStream).writeObject(this);
    }

    public void encodeTo(OutputStream outputStream, String string) throws IOException {
        ASN1OutputStream.create(outputStream, string).writePrimitive(this.toASN1Primitive(), true);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ASN1Encodable)) {
            return false;
        }
        ASN1Encodable aSN1Encodable = (ASN1Encodable)object;
        return this.toASN1Primitive().equals(aSN1Encodable.toASN1Primitive());
    }

    @Override
    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.encodeTo((OutputStream)byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getEncoded(String string) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.encodeTo((OutputStream)byteArrayOutputStream, string);
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        return this.toASN1Primitive().hashCode();
    }

    @Override
    public abstract ASN1Primitive toASN1Primitive();
}

