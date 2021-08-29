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

public class XMSSMTKeyParams
extends ASN1Object {
    public final int height;
    public final int layers;
    public final AlgorithmIdentifier treeDigest;
    public final ASN1Integer version;

    public XMSSMTKeyParams(int n2, int n3, AlgorithmIdentifier algorithmIdentifier) {
        this.version = new ASN1Integer(0L);
        this.height = n2;
        this.layers = n3;
        this.treeDigest = algorithmIdentifier;
    }

    public XMSSMTKeyParams(ASN1Sequence aSN1Sequence) {
        this.version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.height = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).intValueExact();
        this.layers = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2)).intValueExact();
        this.treeDigest = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
    }

    public static XMSSMTKeyParams getInstance(Object object) {
        if (object instanceof XMSSMTKeyParams) {
            return (XMSSMTKeyParams)object;
        }
        if (object != null) {
            return new XMSSMTKeyParams(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(new ASN1Integer(this.height));
        aSN1EncodableVector.add(new ASN1Integer(this.layers));
        aSN1EncodableVector.add(this.treeDigest);
        return new DERSequence(aSN1EncodableVector);
    }
}

