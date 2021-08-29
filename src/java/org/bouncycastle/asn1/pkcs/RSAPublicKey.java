/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.util.Enumeration
 *  java.util.Objects
 */
package org.bouncycastle.asn1.pkcs;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class RSAPublicKey
extends ASN1Object {
    public BigInteger modulus;
    public BigInteger publicExponent;

    public RSAPublicKey(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            Enumeration enumeration = aSN1Sequence.getObjects();
            ASN1Integer aSN1Integer = ASN1Integer.getInstance(enumeration.nextElement());
            Objects.requireNonNull((Object)aSN1Integer);
            this.modulus = new BigInteger(1, aSN1Integer.bytes);
            ASN1Integer aSN1Integer2 = ASN1Integer.getInstance(enumeration.nextElement());
            Objects.requireNonNull((Object)aSN1Integer2);
            this.publicExponent = new BigInteger(1, aSN1Integer2.bytes);
            return;
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Bad sequence size: ");
        stringBuilder.append(aSN1Sequence.size());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(new ASN1Integer(this.modulus));
        aSN1EncodableVector.add(new ASN1Integer(this.publicExponent));
        return new DERSequence(aSN1EncodableVector);
    }
}

