/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.math.BigInteger
 *  java.util.Enumeration
 *  java.util.Objects
 */
package org.bouncycastle.asn1.sec;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.BigIntegers;

public class ECPrivateKey
extends ASN1Object {
    public ASN1Sequence seq;

    public ECPrivateKey(int n2, BigInteger bigInteger, DERBitString dERBitString, ASN1Encodable aSN1Encodable) {
        byte[] arrby = BigIntegers.asUnsignedByteArray((n2 + 7) / 8, bigInteger);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.add(new ASN1Integer(1L));
        aSN1EncodableVector.add(new DEROctetString(arrby));
        if (aSN1Encodable != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, aSN1Encodable));
        }
        if (dERBitString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, dERBitString));
        }
        this.seq = new DERSequence(aSN1EncodableVector);
    }

    public ECPrivateKey(ASN1Sequence aSN1Sequence) {
        this.seq = aSN1Sequence;
    }

    public static ECPrivateKey getInstance(Object object) {
        if (object instanceof ECPrivateKey) {
            return (ECPrivateKey)object;
        }
        if (object != null) {
            return new ECPrivateKey(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    public final ASN1Primitive getObjectInTag(int n2) {
        Enumeration enumeration = this.seq.getObjects();
        while (enumeration.hasMoreElements()) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable)enumeration.nextElement();
            if (!(aSN1Encodable instanceof ASN1TaggedObject)) continue;
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject)aSN1Encodable;
            if (aSN1TaggedObject.tagNo != n2) continue;
            ASN1Primitive aSN1Primitive = aSN1TaggedObject.getObject();
            Objects.requireNonNull((Object)aSN1Primitive);
            return aSN1Primitive;
        }
        return null;
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}

