/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1ApplicationSpecific;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1ParsingException;

public class BERApplicationSpecific
extends ASN1ApplicationSpecific {
    public BERApplicationSpecific(int n2, ASN1EncodableVector aSN1EncodableVector) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 != aSN1EncodableVector.elementCount; ++i2) {
            try {
                byteArrayOutputStream.write(((ASN1Object)aSN1EncodableVector.get(i2)).getEncoded("BER"));
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("malformed object: ");
                stringBuilder.append((Object)iOException);
                throw new ASN1ParsingException(stringBuilder.toString(), iOException);
            }
        }
        super(true, n2, byteArrayOutputStream.toByteArray());
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        int n2 = this.isConstructed ? 96 : 64;
        int n3 = this.tag;
        byte[] arrby = this.octets;
        aSN1OutputStream.writeTag(bl, n2, n3);
        aSN1OutputStream.os.write(128);
        int n4 = arrby.length;
        aSN1OutputStream.os.write(arrby, 0, n4);
        aSN1OutputStream.os.write(0);
        aSN1OutputStream.os.write(0);
    }
}

