/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.bouncycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class AlgorithmIdentifier
extends ASN1Object {
    public ASN1ObjectIdentifier algorithm;
    public ASN1Encodable parameters;

    public AlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.algorithm = aSN1ObjectIdentifier;
    }

    public AlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.algorithm = aSN1ObjectIdentifier;
        this.parameters = aSN1Encodable;
    }

    public AlgorithmIdentifier(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() >= 1 && aSN1Sequence.size() <= 2) {
            this.algorithm = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            ASN1Encodable aSN1Encodable = aSN1Sequence.size() == 2 ? aSN1Sequence.getObjectAt(1) : null;
            this.parameters = aSN1Encodable;
            return;
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Bad sequence size: ");
        stringBuilder.append(aSN1Sequence.size());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static AlgorithmIdentifier getInstance(Object object) {
        if (object instanceof AlgorithmIdentifier) {
            return (AlgorithmIdentifier)object;
        }
        if (object != null) {
            return new AlgorithmIdentifier(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.algorithm);
        ASN1Encodable aSN1Encodable = this.parameters;
        if (aSN1Encodable != null) {
            aSN1EncodableVector.add(aSN1Encodable);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

