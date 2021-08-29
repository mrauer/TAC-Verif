/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.lang.String
 */
package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1External;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERTaggedObject;

public class DERExternal
extends ASN1External {
    public DERExternal(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Integer aSN1Integer, ASN1Primitive aSN1Primitive, int n2, ASN1Primitive aSN1Primitive2) {
        super(aSN1ObjectIdentifier, aSN1Integer, aSN1Primitive, n2, aSN1Primitive2);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        ASN1Primitive aSN1Primitive;
        ASN1Integer aSN1Integer;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.directReference;
        if (aSN1ObjectIdentifier != null) {
            byteArrayOutputStream.write(aSN1ObjectIdentifier.getEncoded("DER"));
        }
        if ((aSN1Integer = this.indirectReference) != null) {
            byteArrayOutputStream.write(aSN1Integer.getEncoded("DER"));
        }
        if ((aSN1Primitive = this.dataValueDescriptor) != null) {
            byteArrayOutputStream.write(aSN1Primitive.getEncoded("DER"));
        }
        byteArrayOutputStream.write(new DERTaggedObject(true, this.encoding, this.externalContent).getEncoded("DER"));
        aSN1OutputStream.writeEncoded(bl, 32, 8, byteArrayOutputStream.toByteArray());
    }

    @Override
    public int encodedLength() throws IOException {
        return this.getEncoded().length;
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

