/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.math.BigInteger
 *  java.util.Enumeration
 */
package org.bouncycastle.asn1.pkcs;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DLSet;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.BigIntegers;

public class PrivateKeyInfo
extends ASN1Object {
    public ASN1Set attributes;
    public ASN1OctetString privateKey;
    public AlgorithmIdentifier privateKeyAlgorithm;
    public ASN1BitString publicKey;
    public ASN1Integer version;

    public PrivateKeyInfo(ASN1Sequence aSN1Sequence) {
        block7 : {
            ASN1Integer aSN1Integer;
            Enumeration enumeration = aSN1Sequence.getObjects();
            this.version = aSN1Integer = ASN1Integer.getInstance(enumeration.nextElement());
            int n2 = aSN1Integer.intValueExact();
            if (n2 < 0 || n2 > 1) break block7;
            this.privateKeyAlgorithm = AlgorithmIdentifier.getInstance(enumeration.nextElement());
            this.privateKey = ASN1OctetString.getInstance(enumeration.nextElement());
            int n3 = -1;
            while (enumeration.hasMoreElements()) {
                block8 : {
                    ASN1TaggedObject aSN1TaggedObject;
                    block19 : {
                        int n4;
                        block15 : {
                            ASN1Set aSN1Set;
                            block17 : {
                                ASN1Primitive aSN1Primitive;
                                block18 : {
                                    block16 : {
                                        block9 : {
                                            block10 : {
                                                block11 : {
                                                    block14 : {
                                                        DERBitString dERBitString;
                                                        block13 : {
                                                            ASN1Primitive aSN1Primitive2;
                                                            block12 : {
                                                                aSN1TaggedObject = (ASN1TaggedObject)enumeration.nextElement();
                                                                n4 = aSN1TaggedObject.tagNo;
                                                                if (n4 <= n3) break block8;
                                                                if (n4 == 0) break block9;
                                                                if (n4 != 1) break block10;
                                                                if (n2 < 1) break block11;
                                                                aSN1Primitive2 = aSN1TaggedObject.getObject();
                                                                if (!(aSN1Primitive2 instanceof DERBitString)) break block12;
                                                                dERBitString = DERBitString.getInstance(aSN1Primitive2);
                                                                break block13;
                                                            }
                                                            byte[] arrby = ASN1OctetString.getInstance((Object)aSN1Primitive2).string;
                                                            if (arrby.length < 1) break block14;
                                                            byte by = arrby[0];
                                                            int n5 = arrby.length - 1;
                                                            byte[] arrby2 = new byte[n5];
                                                            if (n5 != 0) {
                                                                System.arraycopy((Object)arrby, (int)1, (Object)arrby2, (int)0, (int)(arrby.length - 1));
                                                            }
                                                            dERBitString = new DERBitString(arrby2, by);
                                                        }
                                                        this.publicKey = dERBitString;
                                                        break block15;
                                                    }
                                                    throw new IllegalArgumentException("truncated BIT STRING detected");
                                                }
                                                throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
                                            }
                                            throw new IllegalArgumentException("unknown optional field in private key info");
                                        }
                                        aSN1Primitive = aSN1TaggedObject.getObject();
                                        if (!aSN1TaggedObject.explicit) break block16;
                                        aSN1Set = aSN1TaggedObject instanceof BERTaggedObject ? new BERSet(aSN1Primitive) : new DLSet(aSN1Primitive);
                                        break block17;
                                    }
                                    if (!(aSN1Primitive instanceof ASN1Set)) break block18;
                                    aSN1Set = (ASN1Set)aSN1Primitive;
                                    if (!(aSN1TaggedObject instanceof BERTaggedObject)) {
                                        aSN1Set = (ASN1Set)aSN1Set.toDLObject();
                                    }
                                    break block17;
                                }
                                if (!(aSN1Primitive instanceof ASN1Sequence)) break block19;
                                ASN1Encodable[] arraSN1Encodable = ((ASN1Sequence)aSN1Primitive).toArrayInternal();
                                ASN1Set aSN1Set2 = aSN1TaggedObject instanceof BERTaggedObject ? new BERSet(false, arraSN1Encodable) : new DLSet(false, arraSN1Encodable);
                                aSN1Set = aSN1Set2;
                            }
                            this.attributes = aSN1Set;
                        }
                        n3 = n4;
                        continue;
                    }
                    StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unknown object in getInstance: ");
                    stringBuilder.append(aSN1TaggedObject.getClass().getName());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                throw new IllegalArgumentException("invalid optional field in private key info");
            }
            return;
        }
        throw new IllegalArgumentException("invalid version for private key info");
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable, ASN1Set aSN1Set, byte[] arrby) throws IOException {
        BigInteger bigInteger = arrby != null ? BigIntegers.ONE : BigIntegers.ZERO;
        this.version = new ASN1Integer(bigInteger);
        this.privateKeyAlgorithm = algorithmIdentifier;
        this.privateKey = new DEROctetString(aSN1Encodable);
        this.attributes = aSN1Set;
        DERBitString dERBitString = arrby == null ? null : new DERBitString(arrby);
        this.publicKey = dERBitString;
    }

    public static PrivateKeyInfo getInstance(Object object) {
        if (object instanceof PrivateKeyInfo) {
            return (PrivateKeyInfo)object;
        }
        if (object != null) {
            return new PrivateKeyInfo(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    public ASN1Encodable parsePrivateKey() throws IOException {
        return ASN1Primitive.fromByteArray(this.privateKey.string);
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1BitString aSN1BitString;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.privateKeyAlgorithm);
        aSN1EncodableVector.add(this.privateKey);
        ASN1Set aSN1Set = this.attributes;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Set));
        }
        if ((aSN1BitString = this.publicKey) != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1BitString));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

