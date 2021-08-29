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
import org.bouncycastle.asn1.ASN1Sequence;

public class BERSequence
extends ASN1Sequence {
    public BERSequence() {
    }

    public BERSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncodedIndef(bl, 48, this.elements);
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

