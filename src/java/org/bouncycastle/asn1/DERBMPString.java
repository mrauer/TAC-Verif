/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.String
 *  java.util.Arrays
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.StreamUtil;

public class DERBMPString
extends ASN1Primitive {
    public final char[] string;

    public DERBMPString(char[] arrc) {
        this.string = arrc;
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERBMPString)) {
            return false;
        }
        DERBMPString dERBMPString = (DERBMPString)aSN1Primitive;
        return Arrays.equals((char[])this.string, (char[])dERBMPString.string);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        int n2;
        int n3 = this.string.length;
        if (bl) {
            aSN1OutputStream.os.write(30);
        }
        aSN1OutputStream.writeLength(n3 * 2);
        byte[] arrby = new byte[8];
        int n4 = n3 & -4;
        for (n2 = 0; n2 < n4; n2 += 4) {
            char[] arrc = this.string;
            char c2 = arrc[n2];
            char c3 = arrc[n2 + 1];
            char c4 = arrc[n2 + 2];
            char c5 = arrc[n2 + 3];
            arrby[0] = (byte)(c2 >> 8);
            arrby[1] = (byte)c2;
            arrby[2] = (byte)(c3 >> 8);
            arrby[3] = (byte)c3;
            arrby[4] = (byte)(c4 >> 8);
            arrby[5] = (byte)c4;
            arrby[6] = (byte)(c5 >> 8);
            arrby[7] = (byte)c5;
            aSN1OutputStream.os.write(arrby, 0, 8);
        }
        if (n2 < n3) {
            int n5 = 0;
            do {
                char c6 = this.string[n2];
                int n6 = n5 + 1;
                arrby[n5] = (byte)(c6 >> 8);
                n5 = n6 + 1;
                arrby[n6] = (byte)c6;
            } while (++n2 < n3);
            aSN1OutputStream.os.write(arrby, 0, n5);
        }
    }

    @Override
    public int encodedLength() {
        return 1 + StreamUtil.calculateBodyLength(2 * this.string.length) + 2 * this.string.length;
    }

    @Override
    public int hashCode() {
        char[] arrc = this.string;
        if (arrc == null) {
            return 0;
        }
        int n2 = arrc.length;
        int n3 = n2 + 1;
        while (--n2 >= 0) {
            n3 = n3 * 257 ^ arrc[n2];
        }
        return n3;
    }

    @Override
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return new String(this.string);
    }
}

