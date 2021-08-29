/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.asn1.cryptopro;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class GOST3410PublicKeyAlgParameters
extends ASN1Object {
    public ASN1ObjectIdentifier digestParamSet;
    public ASN1ObjectIdentifier encryptionParamSet;
    public ASN1ObjectIdentifier publicKeyParamSet;

    public GOST3410PublicKeyAlgParameters(ASN1Sequence aSN1Sequence) {
        this.publicKeyParamSet = (ASN1ObjectIdentifier)aSN1Sequence.getObjectAt(0);
        this.digestParamSet = (ASN1ObjectIdentifier)aSN1Sequence.getObjectAt(1);
        if (aSN1Sequence.size() > 2) {
            this.encryptionParamSet = (ASN1ObjectIdentifier)aSN1Sequence.getObjectAt(2);
        }
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.publicKeyParamSet);
        aSN1EncodableVector.add(this.digestParamSet);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.encryptionParamSet;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.add(aSN1ObjectIdentifier);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

