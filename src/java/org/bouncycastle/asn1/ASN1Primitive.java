/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.String
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OutputStream;

public abstract class ASN1Primitive
extends ASN1Object {
    public static ASN1Primitive fromByteArray(byte[] arrby) throws IOException {
        block3 : {
            ASN1InputStream aSN1InputStream = new ASN1InputStream(arrby);
            try {
                ASN1Primitive aSN1Primitive = aSN1InputStream.readObject();
                if (aSN1InputStream.available() != 0) break block3;
                return aSN1Primitive;
            }
            catch (ClassCastException classCastException) {
                throw new IOException("cannot recognise object in stream");
            }
        }
        throw new IOException("Extra data detected in stream");
    }

    public abstract boolean asn1Equals(ASN1Primitive var1);

    public abstract void encode(ASN1OutputStream var1, boolean var2) throws IOException;

    @Override
    public void encodeTo(OutputStream outputStream) throws IOException {
        this.encode(new ASN1OutputStream(outputStream), true);
    }

    @Override
    public void encodeTo(OutputStream outputStream, String string) throws IOException {
        ASN1OutputStream.create(outputStream, string).writePrimitive(this, true);
    }

    public abstract int encodedLength() throws IOException;

    @Override
    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        return object instanceof ASN1Encodable && this.asn1Equals(((ASN1Encodable)object).toASN1Primitive());
    }

    public final boolean equals(ASN1Primitive aSN1Primitive) {
        return this == aSN1Primitive || this.asn1Equals(aSN1Primitive);
        {
        }
    }

    public abstract boolean isConstructed();

    @Override
    public final ASN1Primitive toASN1Primitive() {
        return this;
    }

    public ASN1Primitive toDERObject() {
        return this;
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}

