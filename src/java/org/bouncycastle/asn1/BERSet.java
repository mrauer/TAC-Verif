/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;

public class BERSet
extends ASN1Set {
    public BERSet(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public BERSet(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector, false);
    }

    public BERSet(boolean bl, ASN1Encodable[] arraSN1Encodable) {
        super(bl, arraSN1Encodable);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncodedIndef(bl, 49, this.elements);
    }

    @Override
    public int encodedLength() throws IOException {
        int n2 = this.elements.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 += this.elements[i2].toASN1Primitive().encodedLength();
        }
        return 2 + (n3 + 2);
    }
}

