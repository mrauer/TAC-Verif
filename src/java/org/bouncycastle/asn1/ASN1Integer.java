/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.lang.ArithmeticException
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.util.Arrays
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.Properties;

public class ASN1Integer
extends ASN1Primitive {
    public final byte[] bytes;
    public final int start;

    public ASN1Integer(long l2) {
        this.bytes = BigInteger.valueOf((long)l2).toByteArray();
        this.start = 0;
    }

    public ASN1Integer(BigInteger bigInteger) {
        this.bytes = bigInteger.toByteArray();
        this.start = 0;
    }

    public ASN1Integer(byte[] arrby, boolean bl) {
        if (!ASN1Integer.isMalformed(arrby)) {
            byte[] arrby2 = bl ? Nat576.clone(arrby) : arrby;
            this.bytes = arrby2;
            this.start = ASN1Integer.signBytesToSkip(arrby);
            return;
        }
        throw new IllegalArgumentException("malformed integer");
    }

    public static ASN1Integer getInstance(Object object) {
        if (object != null && !(object instanceof ASN1Integer)) {
            if (object instanceof byte[]) {
                try {
                    ASN1Integer aSN1Integer = (ASN1Integer)ASN1Primitive.fromByteArray((byte[])object);
                    return aSN1Integer;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"encoding error in getInstance: ");
                    stringBuilder.append(exception.toString());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"illegal object in getInstance: ");
            stringBuilder.append(object.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return (ASN1Integer)object;
    }

    public static ASN1Integer getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        ASN1Primitive aSN1Primitive = aSN1TaggedObject.getObject();
        if (!bl && !(aSN1Primitive instanceof ASN1Integer)) {
            return new ASN1Integer(ASN1OctetString.getInstance((Object)aSN1Primitive).string, true);
        }
        return ASN1Integer.getInstance(aSN1Primitive);
    }

    public static int intValue(byte[] arrby, int n2, int n3) {
        int n4 = arrby.length;
        int n5 = Math.max((int)n2, (int)(n4 - 4));
        int n6 = n3 & arrby[n5];
        while (++n5 < n4) {
            n6 = n6 << 8 | 255 & arrby[n5];
        }
        return n6;
    }

    public static boolean isMalformed(byte[] arrby) {
        int n2 = arrby.length;
        if (n2 != 0) {
            if (n2 != 1) {
                return arrby[0] == arrby[1] >> 7 && !Properties.isOverrideSet("org.bouncycastle.asn1.allow_unsafe_integer");
            }
            return false;
        }
        return true;
    }

    public static int signBytesToSkip(byte[] arrby) {
        int n2;
        byte by;
        int n3 = -1 + arrby.length;
        int n4 = 0;
        while (n4 < n3 && (by = arrby[n4]) == arrby[n2 = n4 + 1] >> 7) {
            n4 = n2;
        }
        return n4;
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Integer)) {
            return false;
        }
        ASN1Integer aSN1Integer = (ASN1Integer)aSN1Primitive;
        return Arrays.equals((byte[])this.bytes, (byte[])aSN1Integer.bytes);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 2, this.bytes);
    }

    @Override
    public int encodedLength() {
        return 1 + StreamUtil.calculateBodyLength(this.bytes.length) + this.bytes.length;
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    public boolean hasValue(BigInteger bigInteger) {
        return bigInteger != null && ASN1Integer.intValue(this.bytes, this.start, -1) == bigInteger.intValue() && this.getValue().equals((Object)bigInteger);
    }

    @Override
    public int hashCode() {
        return Nat576.hashCode(this.bytes);
    }

    public int intValueExact() {
        byte[] arrby = this.bytes;
        int n2 = arrby.length;
        int n3 = this.start;
        if (n2 - n3 <= 4) {
            return ASN1Integer.intValue(arrby, n3, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    @Override
    public boolean isConstructed() {
        return false;
    }

    public long longValueExact() {
        byte[] arrby = this.bytes;
        int n2 = arrby.length;
        int n3 = this.start;
        if (n2 - n3 <= 8) {
            int n4 = arrby.length;
            int n5 = Math.max((int)n3, (int)(n4 - 8));
            long l2 = -1 & arrby[n5];
            while (++n5 < n4) {
                l2 = l2 << 8 | (long)(255 & arrby[n5]);
            }
            return l2;
        }
        throw new ArithmeticException("ASN.1 Integer out of long range");
    }

    public String toString() {
        return this.getValue().toString();
    }
}

