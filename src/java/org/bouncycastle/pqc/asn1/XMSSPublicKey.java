/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.bouncycastle.pqc.asn1;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.raw.Nat576;

public class XMSSPublicKey
extends ASN1Object {
    public final byte[] publicSeed;
    public final byte[] root;

    public XMSSPublicKey(ASN1Sequence aSN1Sequence) {
        if (ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).hasValue(BigInteger.valueOf((long)0L))) {
            this.publicSeed = Nat576.clone(ASN1OctetString.getInstance((Object)aSN1Sequence.getObjectAt((int)1)).string);
            this.root = Nat576.clone(ASN1OctetString.getInstance((Object)aSN1Sequence.getObjectAt((int)2)).string);
            return;
        }
        throw new IllegalArgumentException("unknown version of sequence");
    }

    public XMSSPublicKey(byte[] arrby, byte[] arrby2) {
        this.publicSeed = Nat576.clone(arrby);
        this.root = Nat576.clone(arrby2);
    }

    public static XMSSPublicKey getInstance(Object object) {
        if (object instanceof XMSSPublicKey) {
            return (XMSSPublicKey)object;
        }
        if (object != null) {
            return new XMSSPublicKey(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        aSN1EncodableVector.add(new ASN1Integer(0L));
        aSN1EncodableVector.add(new DEROctetString(this.publicSeed));
        aSN1EncodableVector.add(new DEROctetString(this.root));
        return new DERSequence(aSN1EncodableVector);
    }
}

