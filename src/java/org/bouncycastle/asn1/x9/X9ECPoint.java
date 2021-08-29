/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat576;

public class X9ECPoint
extends ASN1Object {
    public ECCurve c;
    public final ASN1OctetString encoding;
    public ECPoint p;

    public X9ECPoint(ECCurve eCCurve, byte[] arrby) {
        this.c = eCCurve;
        this.encoding = new DEROctetString(Nat576.clone(arrby));
    }

    public X9ECPoint(ECPoint eCPoint, boolean bl) {
        this.p = eCPoint.normalize();
        this.encoding = new DEROctetString(eCPoint.getEncoded(bl));
    }

    public ECPoint getPoint() {
        X9ECPoint x9ECPoint = this;
        synchronized (x9ECPoint) {
            if (this.p == null) {
                this.p = this.c.decodePoint(this.encoding.string).normalize();
            }
            ECPoint eCPoint = this.p;
            return eCPoint;
        }
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        return this.encoding;
    }
}

