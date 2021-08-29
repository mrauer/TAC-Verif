/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Enumeration
 */
package org.bouncycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class SubjectPublicKeyInfo
extends ASN1Object {
    public AlgorithmIdentifier algId;
    public DERBitString keyData;

    public SubjectPublicKeyInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            Enumeration enumeration = aSN1Sequence.getObjects();
            this.algId = AlgorithmIdentifier.getInstance(enumeration.nextElement());
            this.keyData = DERBitString.getInstance(enumeration.nextElement());
            return;
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Bad sequence size: ");
        stringBuilder.append(aSN1Sequence.size());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable) throws IOException {
        this.keyData = new DERBitString(aSN1Encodable);
        this.algId = algorithmIdentifier;
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] arrby) {
        this.keyData = new DERBitString(arrby);
        this.algId = algorithmIdentifier;
    }

    public static SubjectPublicKeyInfo getInstance(Object object) {
        if (object instanceof SubjectPublicKeyInfo) {
            return (SubjectPublicKeyInfo)object;
        }
        if (object != null) {
            return new SubjectPublicKeyInfo(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    public ASN1Primitive parsePublicKey() throws IOException {
        return ASN1Primitive.fromByteArray(this.keyData.getOctets());
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.algId);
        aSN1EncodableVector.add(this.keyData);
        return new DERSequence(aSN1EncodableVector);
    }
}

