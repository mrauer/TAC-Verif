/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKey
extends ASN1Object {
    public final AlgorithmIdentifier digest;
    public final GF2Matrix g;
    public final int n;
    public final int t;

    public McElieceCCA2PublicKey(int n2, int n3, GF2Matrix gF2Matrix, AlgorithmIdentifier algorithmIdentifier) {
        this.n = n2;
        this.t = n3;
        this.g = new GF2Matrix(gF2Matrix.getEncoded());
        this.digest = algorithmIdentifier;
    }

    public McElieceCCA2PublicKey(ASN1Sequence aSN1Sequence) {
        this.n = ((ASN1Integer)aSN1Sequence.getObjectAt(0)).intValueExact();
        this.t = ((ASN1Integer)aSN1Sequence.getObjectAt(1)).intValueExact();
        this.g = new GF2Matrix(((ASN1OctetString)aSN1Sequence.getObjectAt((int)2)).string);
        this.digest = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        aSN1EncodableVector.add(new ASN1Integer(this.n));
        aSN1EncodableVector.add(new ASN1Integer(this.t));
        aSN1EncodableVector.add(new DEROctetString(this.g.getEncoded()));
        aSN1EncodableVector.add(this.digest);
        return new DERSequence(aSN1EncodableVector);
    }
}

