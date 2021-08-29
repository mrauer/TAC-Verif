/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DLBitString;
import org.bouncycastle.asn1.StreamUtil;

public class DERBitString
extends ASN1BitString {
    public DERBitString(ASN1Encodable aSN1Encodable) throws IOException {
        super(aSN1Encodable.toASN1Primitive().getEncoded("DER"), 0);
    }

    public DERBitString(byte[] arrby) {
        super(arrby, 0);
    }

    public DERBitString(byte[] arrby, int n2) {
        super(arrby, n2);
    }

    public static DERBitString getInstance(Object object) {
        if (object != null && !(object instanceof DERBitString)) {
            if (object instanceof DLBitString) {
                DLBitString dLBitString = (DLBitString)object;
                return new DERBitString(dLBitString.data, dLBitString.padBits);
            }
            if (object instanceof byte[]) {
                try {
                    DERBitString dERBitString = (DERBitString)ASN1Primitive.fromByteArray((byte[])object);
                    return dERBitString;
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
        return (DERBitString)object;
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        int n2;
        int n3;
        byte[] arrby = this.data;
        int n4 = arrby.length;
        if (n4 != 0 && (n2 = this.padBits) != 0 && arrby[n3 = n4 - 1] != (byte)(arrby[n3] & 255 << n2)) {
            byte by = (byte)(arrby[n3] & 255 << n2);
            byte by2 = (byte)n2;
            if (bl) {
                aSN1OutputStream.os.write(3);
            }
            aSN1OutputStream.writeLength(n3 + 2);
            aSN1OutputStream.os.write((int)by2);
            aSN1OutputStream.os.write(arrby, 0, n3);
            aSN1OutputStream.os.write((int)by);
            return;
        }
        aSN1OutputStream.writeEncoded(bl, 3, (byte)this.padBits, arrby);
    }

    @Override
    public int encodedLength() {
        return 1 + (1 + StreamUtil.calculateBodyLength(1 + this.data.length) + this.data.length);
    }

    @Override
    public boolean isConstructed() {
        return false;
    }

    @Override
    public ASN1Primitive toDERObject() {
        return this;
    }

    @Override
    public ASN1Primitive toDLObject() {
        return this;
    }
}

