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
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.math.raw.Nat576;

public class ASN1Enumerated
extends ASN1Primitive {
    public static ASN1Enumerated[] cache = new ASN1Enumerated[12];
    public final byte[] bytes;

    public ASN1Enumerated(byte[] arrby) {
        if (!ASN1Integer.isMalformed(arrby)) {
            if ((128 & arrby[0]) == 0) {
                this.bytes = Nat576.clone(arrby);
                ASN1Integer.signBytesToSkip(arrby);
                return;
            }
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        throw new IllegalArgumentException("malformed enumerated");
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Enumerated)) {
            return false;
        }
        ASN1Enumerated aSN1Enumerated = (ASN1Enumerated)aSN1Primitive;
        return Arrays.equals((byte[])this.bytes, (byte[])aSN1Enumerated.bytes);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 10, this.bytes);
    }

    @Override
    public int encodedLength() {
        return 1 + StreamUtil.calculateBodyLength(this.bytes.length) + this.bytes.length;
    }

    @Override
    public int hashCode() {
        return Nat576.hashCode(this.bytes);
    }

    @Override
    public boolean isConstructed() {
        return false;
    }
}

