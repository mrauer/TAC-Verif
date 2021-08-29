/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

public class X9FieldID
extends ASN1Object
implements X9ObjectIdentifiers {
    public ASN1ObjectIdentifier id;
    public ASN1Primitive parameters;

    public X9FieldID(int n2, int n3, int n4, int n5) {
        block5 : {
            ASN1EncodableVector aSN1EncodableVector;
            block4 : {
                block2 : {
                    block3 : {
                        this.id = X9ObjectIdentifiers.characteristic_two_field;
                        aSN1EncodableVector = new ASN1EncodableVector(3);
                        aSN1EncodableVector.add(new ASN1Integer(n2));
                        if (n4 != 0) break block2;
                        if (n5 != 0) break block3;
                        aSN1EncodableVector.add(X9ObjectIdentifiers.tpBasis);
                        aSN1EncodableVector.add(new ASN1Integer(n3));
                        break block4;
                    }
                    throw new IllegalArgumentException("inconsistent k values");
                }
                if (n4 <= n3 || n5 <= n4) break block5;
                aSN1EncodableVector.add(X9ObjectIdentifiers.ppBasis);
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(3);
                aSN1EncodableVector2.add(new ASN1Integer(n3));
                aSN1EncodableVector2.add(new ASN1Integer(n4));
                aSN1EncodableVector2.add(new ASN1Integer(n5));
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
            }
            this.parameters = new DERSequence(aSN1EncodableVector);
            return;
        }
        throw new IllegalArgumentException("inconsistent k values");
    }

    public X9FieldID(BigInteger bigInteger) {
        this.id = X9ObjectIdentifiers.prime_field;
        this.parameters = new ASN1Integer(bigInteger);
    }

    public X9FieldID(ASN1Sequence aSN1Sequence) {
        this.id = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.parameters = aSN1Sequence.getObjectAt(1).toASN1Primitive();
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.id);
        aSN1EncodableVector.add(this.parameters);
        return new DERSequence(aSN1EncodableVector);
    }
}

