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
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McEliecePrivateKey
extends ASN1Object {
    public byte[] encField;
    public byte[] encGp;
    public byte[] encP1;
    public byte[] encP2;
    public byte[] encSInv;
    public int k;
    public int n;

    public McEliecePrivateKey(int n2, int n3, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, Permutation permutation2, GF2Matrix gF2Matrix) {
        this.n = n2;
        this.k = n3;
        this.encField = gF2mField.getEncoded();
        this.encGp = polynomialGF2mSmallM.getEncoded();
        this.encSInv = gF2Matrix.getEncoded();
        this.encP1 = permutation.getEncoded();
        this.encP2 = permutation2.getEncoded();
    }

    public McEliecePrivateKey(ASN1Sequence aSN1Sequence) {
        this.n = ((ASN1Integer)aSN1Sequence.getObjectAt(0)).intValueExact();
        this.k = ((ASN1Integer)aSN1Sequence.getObjectAt(1)).intValueExact();
        this.encField = ((ASN1OctetString)aSN1Sequence.getObjectAt((int)2)).string;
        this.encGp = ((ASN1OctetString)aSN1Sequence.getObjectAt((int)3)).string;
        this.encP1 = ((ASN1OctetString)aSN1Sequence.getObjectAt((int)4)).string;
        this.encP2 = ((ASN1OctetString)aSN1Sequence.getObjectAt((int)5)).string;
        this.encSInv = ((ASN1OctetString)aSN1Sequence.getObjectAt((int)6)).string;
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        aSN1EncodableVector.add(new ASN1Integer(this.n));
        aSN1EncodableVector.add(new ASN1Integer(this.k));
        aSN1EncodableVector.add(new DEROctetString(this.encField));
        aSN1EncodableVector.add(new DEROctetString(this.encGp));
        aSN1EncodableVector.add(new DEROctetString(this.encP1));
        aSN1EncodableVector.add(new DEROctetString(this.encP2));
        aSN1EncodableVector.add(new DEROctetString(this.encSInv));
        return new DERSequence(aSN1EncodableVector);
    }
}

