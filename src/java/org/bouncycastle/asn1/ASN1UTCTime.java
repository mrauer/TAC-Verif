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
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.Strings;

public class ASN1UTCTime
extends ASN1Primitive {
    public byte[] time;

    public ASN1UTCTime(byte[] arrby) {
        if (arrby.length >= 2) {
            this.time = arrby;
            if (this.isDigit(0) && this.isDigit(1)) {
                return;
            }
            throw new IllegalArgumentException("illegal characters in UTCTime string");
        }
        throw new IllegalArgumentException("UTCTime string too short");
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1UTCTime)) {
            return false;
        }
        return Arrays.equals((byte[])this.time, (byte[])((ASN1UTCTime)aSN1Primitive).time);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 23, this.time);
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

    public String toString() {
        return Strings.fromByteArray(this.time);
    }
}

