/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.util.Arrays
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.math.raw.Nat576;

public class ASN1GeneralizedTime
extends ASN1Primitive {
    public byte[] time;

    public ASN1GeneralizedTime(byte[] arrby) {
        if (arrby.length >= 4) {
            this.time = arrby;
            if (this.isDigit(0) && this.isDigit(1) && this.isDigit(2) && this.isDigit(3)) {
                return;
            }
            throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
        }
        throw new IllegalArgumentException("GeneralizedTime string too short");
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1GeneralizedTime)) {
            return false;
        }
        return Arrays.equals((byte[])this.time, (byte[])((ASN1GeneralizedTime)aSN1Primitive).time);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 24, this.time);
    }

    @Override
    public int encodedLength() {
        int n2 = this.time.length;
        return n2 + (1 + StreamUtil.calculateBodyLength(n2));
    }

    @Override
    public int hashCode() {
        return Nat576.hashCode(this.time);
    }

    @Override
    public boolean isConstructed() {
        return false;
    }

    public final boolean isDigit(int n2) {
        byte[] arrby = this.time;
        return arrby.length > n2 && arrby[n2] >= 48 && arrby[n2] <= 57;
    }

    @Override
    public ASN1Primitive toDERObject() {
        return new DERGeneralizedTime(this.time);
    }

    @Override
    public ASN1Primitive toDLObject() {
        return new DERGeneralizedTime(this.time);
    }
}

