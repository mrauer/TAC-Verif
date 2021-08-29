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
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.raw.Nat576;

public class RainbowPublicKey
extends ASN1Object {
    public byte[][] coeffQuadratic;
    public byte[] coeffScalar;
    public byte[][] coeffSingular;
    public ASN1Integer docLength;
    public ASN1ObjectIdentifier oid;
    public ASN1Integer version;

    public RainbowPublicKey(int n2, short[][] arrs, short[][] arrs2, short[] arrs3) {
        this.version = new ASN1Integer(0L);
        this.docLength = new ASN1Integer(n2);
        this.coeffQuadratic = Nat576.convertArray(arrs);
        this.coeffSingular = Nat576.convertArray(arrs2);
        this.coeffScalar = Nat576.convertArray(arrs3);
    }

    public RainbowPublicKey(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        } else {
            this.oid = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        }
        this.docLength = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
        ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(2));
        this.coeffQuadratic = new byte[aSN1Sequence2.size()][];
        for (int i2 = 0; i2 < aSN1Sequence2.size(); ++i2) {
            this.coeffQuadratic[i2] = ASN1OctetString.getInstance((Object)aSN1Sequence2.getObjectAt((int)i2)).string;
        }
        ASN1Sequence aSN1Sequence3 = (ASN1Sequence)aSN1Sequence.getObjectAt(3);
        this.coeffSingular = new byte[aSN1Sequence3.size()][];
        for (int i3 = 0; i3 < aSN1Sequence3.size(); ++i3) {
            this.coeffSingular[i3] = ASN1OctetString.getInstance((Object)aSN1Sequence3.getObjectAt((int)i3)).string;
        }
        this.coeffScalar = ASN1OctetString.getInstance((Object)((ASN1Sequence)aSN1Sequence.getObjectAt((int)4)).getObjectAt((int)0)).string;
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        byte[][] arrby;
        byte[][] arrby2;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        ASN1Primitive aSN1Primitive = this.version;
        if (aSN1Primitive == null) {
            aSN1Primitive = this.oid;
        }
        aSN1EncodableVector.add(aSN1Primitive);
        aSN1EncodableVector.add(this.docLength);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(10);
        int n2 = 0;
        for (int i2 = 0; i2 < (arrby2 = this.coeffQuadratic).length; ++i2) {
            aSN1EncodableVector2.add(new DEROctetString(arrby2[i2]));
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector(10);
        while (n2 < (arrby = this.coeffSingular).length) {
            aSN1EncodableVector3.add(new DEROctetString(arrby[n2]));
            ++n2;
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector3));
        ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector(10);
        aSN1EncodableVector4.add(new DEROctetString(this.coeffScalar));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector4));
        return new DERSequence(aSN1EncodableVector);
    }
}

