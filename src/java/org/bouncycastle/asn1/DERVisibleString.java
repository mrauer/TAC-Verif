/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
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

public class DERVisibleString
extends ASN1Primitive {
    public final byte[] string;

    public DERVisibleString(byte[] arrby) {
        this.string = arrby;
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERVisibleString)) {
            return false;
        }
        return Arrays.equals((byte[])this.string, (byte[])((DERVisibleString)aSN1Primitive).string);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 26, this.string);
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

    public String toString() {
        return Strings.fromByteArray(this.string);
    }
}

