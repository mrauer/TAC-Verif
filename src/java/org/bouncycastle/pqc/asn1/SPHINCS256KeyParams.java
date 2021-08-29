/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class SPHINCS256KeyParams
extends ASN1Object {
    public final AlgorithmIdentifier treeDigest;
    public final ASN1Integer version;

    public SPHINCS256KeyParams(ASN1Sequence aSN1Sequence) {
        this.version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.treeDigest = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public SPHINCS256KeyParams(AlgorithmIdentifier algorithmIdentifier) {
        this.version = new ASN1Integer(0L);
        this.treeDigest = algorithmIdentifier;
    }

    public static final SPHINCS256KeyParams getInstance(Object object) {
        if (object instanceof SPHINCS256KeyParams) {
            return (SPHINCS256KeyParams)object;
        }
        if (object != null) {
            return new SPHINCS256KeyParams(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.treeDigest);
        return new DERSequence(aSN1EncodableVector);
    }
}

