/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Objects
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DLBitString;
import org.bouncycastle.math.raw.Nat576;

public abstract class ASN1BitString
extends ASN1Primitive {
    public static final char[] table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final byte[] data;
    public final int padBits;

    public ASN1BitString(byte[] arrby, int n2) {
        Objects.requireNonNull((Object)arrby, (String)"'data' cannot be null");
        if (arrby.length == 0 && n2 != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (n2 <= 7 && n2 >= 0) {
            this.data = Nat576.clone(arrby);
            this.padBits = n2;
            return;
        }
        throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1BitString)) {
            return false;
        }
        ASN1BitString aSN1BitString = (ASN1BitString)aSN1Primitive;
        if (this.padBits != aSN1BitString.padBits) {
            return false;
        }
        byte[] arrby = this.data;
        int n2 = arrby.length;
        byte[] arrby2 = aSN1BitString.data;
        if (n2 != arrby2.length) {
            return false;
        }
        int n3 = n2 - 1;
        if (n3 < 0) {
            return true;
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            if (arrby[i2] == arrby2[i2]) continue;
            return false;
        }
        byte by = arrby[n3];
        int n4 = this.padBits;
        byte by2 = (byte)(by & 255 << n4);
        byte by3 = (byte)(arrby2[n3] & 255 << n4);
        boolean bl = false;
        if (by2 == by3) {
            bl = true;
        }
        return bl;
    }

    public byte[] getBytes() {
        byte[] arrby = this.data;
        if (arrby.length == 0) {
            return arrby;
        }
        byte[] arrby2 = Nat576.clone(arrby);
        int n2 = -1 + this.data.length;
        arrby2[n2] = (byte)(arrby2[n2] & 255 << this.padBits);
        return arrby2;
    }

    public byte[] getOctets() {
        if (this.padBits == 0) {
            return Nat576.clone(this.data);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    @Override
    public int hashCode() {
        int n2;
        byte[] arrby = this.data;
        int n3 = -1 + arrby.length;
        if (n3 < 0) {
            return 1;
        }
        byte by = (byte)(arrby[n3] & 255 << this.padBits);
        if (arrby == null) {
            n2 = 0;
        } else {
            int n4 = n3 + 1;
            while (--n3 >= 0) {
                n4 = n4 * 257 ^ arrby[0 + n3];
            }
            n2 = n4;
        }
        return by ^ n2 * 257 ^ this.padBits;
    }

    @Override
    public ASN1Primitive toDERObject() {
        return new DERBitString(this.data, this.padBits);
    }

    @Override
    public ASN1Primitive toDLObject() {
        return new DLBitString(this.data, this.padBits);
    }

    public String toString() {
        byte[] arrby;
        StringBuffer stringBuffer = new StringBuffer("#");
        try {
            arrby = this.getEncoded();
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Internal error encoding BitString: ");
            stringBuilder.append(iOException.getMessage());
            throw new ASN1ParsingException(stringBuilder.toString(), iOException);
        }
        for (int i2 = 0; i2 != arrby.length; ++i2) {
            char[] arrc = table;
            stringBuffer.append(arrc[15 & arrby[i2] >>> 4]);
            stringBuffer.append(arrc[15 & arrby[i2]]);
        }
        return stringBuffer.toString();
    }
}

