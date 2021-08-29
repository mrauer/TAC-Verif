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

public class DERT61String
extends ASN1Primitive {
    public byte[] string;

    public DERT61String(byte[] arrby) {
        this.string = Nat576.clone(arrby);
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERT61String)) {
            return false;
        }
        return Arrays.equals((byte[])this.string, (byte[])((DERT61String)aSN1Primitive).string);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 20, this.string);
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

