/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.util.Arrays
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.math.raw.Nat576;

public class DERUniversalString
extends ASN1Primitive {
    public static final char[] table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final byte[] string;

    public DERUniversalString(byte[] arrby) {
        this.string = Nat576.clone(arrby);
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERUniversalString)) {
            return false;
        }
        return Arrays.equals((byte[])this.string, (byte[])((DERUniversalString)aSN1Primitive).string);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 28, this.string);
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
        byte[] arrby;
        StringBuffer stringBuffer = new StringBuffer("#");
        try {
            arrby = this.getEncoded();
        }
        catch (IOException iOException) {
            throw new ASN1ParsingException("internal error encoding UniversalString");
        }
        for (int i2 = 0; i2 != arrby.length; ++i2) {
            char[] arrc = table;
            stringBuffer.append(arrc[15 & arrby[i2] >>> 4]);
            stringBuffer.append(arrc[15 & arrby[i2]]);
        }
        return stringBuffer.toString();
    }
}

