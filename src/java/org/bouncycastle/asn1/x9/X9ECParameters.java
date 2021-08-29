/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.bouncycastle.asn1.x9;

import com.google.android.material.R;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x9.X9Curve;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9FieldID;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.GF2Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.math.raw.Nat576;

public class X9ECParameters
extends ASN1Object
implements X9ObjectIdentifiers {
    public static final BigInteger ONE = BigInteger.valueOf((long)1L);
    public ECCurve curve;
    public X9FieldID fieldID;
    public X9ECPoint g;
    public BigInteger h;
    public BigInteger n;
    public byte[] seed;

    public X9ECParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer && ((ASN1Integer)aSN1Sequence.getObjectAt(0)).hasValue(ONE)) {
            ASN1Encodable aSN1Encodable;
            this.n = ((ASN1Integer)aSN1Sequence.getObjectAt(4)).getValue();
            if (aSN1Sequence.size() == 6) {
                this.h = ((ASN1Integer)aSN1Sequence.getObjectAt(5)).getValue();
            }
            X9FieldID x9FieldID = (aSN1Encodable = aSN1Sequence.getObjectAt(1)) instanceof X9FieldID ? (X9FieldID)aSN1Encodable : (aSN1Encodable != null ? new X9FieldID(ASN1Sequence.getInstance(aSN1Encodable)) : null);
            X9Curve x9Curve = new X9Curve(x9FieldID, this.n, this.h, ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(2)));
            this.curve = x9Curve.curve;
            ASN1Encodable aSN1Encodable2 = aSN1Sequence.getObjectAt(3);
            this.g = aSN1Encodable2 instanceof X9ECPoint ? (X9ECPoint)aSN1Encodable2 : new X9ECPoint(this.curve, ((ASN1OctetString)aSN1Encodable2).string);
            this.seed = Nat576.clone(x9Curve.seed);
            return;
        }
        throw new IllegalArgumentException("bad version in X9ECParameters");
    }

    public X9ECParameters(ECCurve eCCurve, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, x9ECPoint, bigInteger, bigInteger2, null);
    }

    public X9ECParameters(ECCurve eCCurve, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] arrby) {
        block4 : {
            block6 : {
                X9FieldID x9FieldID;
                block3 : {
                    int[] arrn;
                    block5 : {
                        block2 : {
                            this.curve = eCCurve;
                            this.g = x9ECPoint;
                            this.n = bigInteger;
                            this.h = bigInteger2;
                            this.seed = Nat576.clone(arrby);
                            if (!R.style.isFpField((FiniteField)eCCurve.field)) break block2;
                            x9FieldID = new X9FieldID(eCCurve.field.getCharacteristic());
                            break block3;
                        }
                        if (!R.style.isF2mCurve((ECCurve)eCCurve)) break block4;
                        arrn = ((PolynomialExtensionField)eCCurve.field).getMinimalPolynomial().getExponentsPresent();
                        if (arrn.length != 3) break block5;
                        x9FieldID = new X9FieldID(arrn[2], arrn[1], 0, 0);
                        break block3;
                    }
                    if (arrn.length != 5) break block6;
                    x9FieldID = new X9FieldID(arrn[4], arrn[1], arrn[2], arrn[3]);
                }
                this.fieldID = x9FieldID;
                return;
            }
            throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
        }
        throw new IllegalArgumentException("'curve' is of an unsupported type");
    }

    public static X9ECParameters getInstance(Object object) {
        if (object instanceof X9ECParameters) {
            return (X9ECParameters)object;
        }
        if (object != null) {
            return new X9ECParameters(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    public ECPoint getG() {
        return this.g.getPoint();
    }

    public byte[] getSeed() {
        return Nat576.clone(this.seed);
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.add(new ASN1Integer(ONE));
        aSN1EncodableVector.add(this.fieldID);
        aSN1EncodableVector.add(new X9Curve(this.curve, this.seed));
        aSN1EncodableVector.add(this.g);
        aSN1EncodableVector.add(new ASN1Integer(this.n));
        BigInteger bigInteger = this.h;
        if (bigInteger != null) {
            aSN1EncodableVector.add(new ASN1Integer(bigInteger));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

