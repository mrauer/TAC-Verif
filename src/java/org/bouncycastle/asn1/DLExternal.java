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
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1External;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DLTaggedObject;

public class DLExternal
extends ASN1External {
    public DLExternal(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    public DLExternal(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Integer aSN1Integer, ASN1Primitive aSN1Primitive, int n2, ASN1Primitive aSN1Primitive2) {
        super(aSN1ObjectIdentifier, aSN1Integer, aSN1Primitive, n2, aSN1Primitive2);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        ASN1Primitive aSN1Primitive;
        ASN1Integer aSN1Integer;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.directReference;
        if (aSN1ObjectIdentifier != null) {
            byteArrayOutputStream.write(aSN1ObjectIdentifier.getEncoded("DL"));
        }
        if ((aSN1Integer = this.indirectReference) != null) {
            byteArrayOutputStream.write(aSN1Integer.getEncoded("DL"));
        }
        if ((aSN1Primitive = this.dataValueDescriptor) != null) {
            byteArrayOutputStream.write(aSN1Primitive.getEncoded("DL"));
        }
        byteArrayOutputStream.write(new DLTaggedObject(true, this.encoding, this.externalContent).getEncoded("DL"));
        aSN1OutputStream.writeEncoded(bl, 32, 8, byteArrayOutputStream.toByteArray());
    }

    @Override
    public int encodedLength() throws IOException {
        return this.getEncoded().length;
    }

    @Override
    public ASN1Primitive toDLObject() {
        return this;
    }
}

