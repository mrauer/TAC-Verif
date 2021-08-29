/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.util.Arrays
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.math.raw.Nat576;

public class DERGraphicString
extends ASN1Primitive {
    public final byte[] string;

    public DERGraphicString(byte[] arrby) {
        this.string = Nat576.clone(arrby);
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERGraphicString)) {
            return false;
        }
        DERGraphicString dERGraphicString = (DERGraphicString)aSN1Primitive;
        return Arrays.equals((byte[])this.string, (byte[])dERGraphicString.string);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 25, this.string);
    }

    @Override
    public int encodedLength() {
        return 1 + StreamUtil.calculateBodyLength(this.string.length) + this.string.length;
    }

    @Override
    public int hashCode() {
        return Nat576.hashCode(this.string);
    }

    @Override
    public boolean isConstructed() {
        return false;
    }
}

