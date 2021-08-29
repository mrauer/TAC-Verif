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
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.BigIntegers;

public class XMSSPrivateKey
extends ASN1Object {
    public final byte[] bdsState;
    public final int index;
    public final int maxIndex;
    public final byte[] publicSeed;
    public final byte[] root;
    public final byte[] secretKeyPRF;
    public final byte[] secretKeySeed;
    public final int version;

    public XMSSPrivateKey(int n2, byte[] arrby, byte[] arrby2, byte[] arrby3, byte[] arrby4, byte[] arrby5) {
        this.version = 0;
        this.index = n2;
        this.secretKeySeed = Nat576.clone(arrby);
        this.secretKeyPRF = Nat576.clone(arrby2);
        this.publicSeed = Nat576.clone(arrby3);
        this.root = Nat576.clone(arrby4);
        this.bdsState = Nat576.clone(arrby5);
        this.maxIndex = -1;
    }

    public XMSSPrivateKey(int n2, byte[] arrby, byte[] arrby2, byte[] arrby3, byte[] arrby4, byte[] arrby5, int n3) {
        this.version = 1;
        this.index = n2;
        this.secretKeySeed = Nat576.clone(arrby);
        this.secretKeyPRF = Nat576.clone(arrby2);
        this.publicSeed = Nat576.clone(arrby3);
        this.root = Nat576.clone(arrby4);
        this.bdsState = Nat576.clone(arrby5);
        this.maxIndex = n3;
    }

    public XMSSPrivateKey(ASN1Sequence aSN1Sequence) {
        block9 : {
            int n2;
            block8 : {
                ASN1Sequence aSN1Sequence2;
                block6 : {
                    block7 : {
                        ASN1Integer aSN1Integer = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
                        if (!aSN1Integer.hasValue(BigIntegers.ZERO) && !aSN1Integer.hasValue(BigIntegers.ONE)) {
                            throw new IllegalArgumentException("unknown version of sequence");
                        }
                        this.version = aSN1Integer.intValueExact();
                        if (aSN1Sequence.size() != 2 && aSN1Sequence.size() != 3) {
                            throw new IllegalArgumentException("key sequence wrong size");
                        }
                        aSN1Sequence2 = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
                        this.index = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(0)).intValueExact();
                        this.secretKeySeed = Nat576.clone(ASN1OctetString.getInstance((Object)aSN1Sequence2.getObjectAt((int)1)).string);
                        this.secretKeyPRF = Nat576.clone(ASN1OctetString.getInstance((Object)aSN1Sequence2.getObjectAt((int)2)).string);
                        this.publicSeed = Nat576.clone(ASN1OctetString.getInstance((Object)aSN1Sequence2.getObjectAt((int)3)).string);
                        this.root = Nat576.clone(ASN1OctetString.getInstance((Object)aSN1Sequence2.getObjectAt((int)4)).string);
                        if (aSN1Sequence2.size() != 6) break block6;
                        ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence2.getObjectAt(5));
                        if (aSN1TaggedObject.tagNo != 0) break block7;
                        n2 = ASN1Integer.getInstance(aSN1TaggedObject, false).intValueExact();
                        break block8;
                    }
                    throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
                }
                if (aSN1Sequence2.size() != 5) break block9;
                n2 = -1;
            }
            this.maxIndex = n2;
            if (aSN1Sequence.size() == 3) {
                this.bdsState = Nat576.clone(ASN1OctetString.getInstance((ASN1TaggedObject)ASN1TaggedObject.getInstance((Object)aSN1Sequence.getObjectAt((int)2)), (boolean)true).string);
                return;
            }
            this.bdsState = null;
            return;
        }
        throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        ASN1Integer aSN1Integer = this.maxIndex >= 0 ? new ASN1Integer(1L) : new ASN1Integer(0L);
        aSN1EncodableVector.add(aSN1Integer);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(10);
        aSN1EncodableVector2.add(new ASN1Integer(this.index));
        aSN1EncodableVector2.add(new DEROctetString(this.secretKeySeed));
        aSN1EncodableVector2.add(new DEROctetString(this.secretKeyPRF));
        aSN1EncodableVector2.add(new DEROctetString(this.publicSeed));
        aSN1EncodableVector2.add(new DEROctetString(this.root));
        int n2 = this.maxIndex;
        if (n2 >= 0) {
            aSN1EncodableVector2.add(new DERTaggedObject(false, 0, new ASN1Integer(n2)));
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector.add(new DERTaggedObject(true, 0, new DEROctetString(this.bdsState)));
        return new DERSequence(aSN1EncodableVector);
    }
}

