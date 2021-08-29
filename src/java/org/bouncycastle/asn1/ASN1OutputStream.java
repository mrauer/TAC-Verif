/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Enumeration
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.DEROutputStream
 *  org.bouncycastle.asn1.DLOutputStream
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.DLOutputStream;

public class ASN1OutputStream {
    public OutputStream os;

    public ASN1OutputStream(OutputStream outputStream) {
        this.os = outputStream;
    }

    public static ASN1OutputStream create(OutputStream outputStream, String string) {
        if (string.equals((Object)"DER")) {
            return new DEROutputStream(outputStream);
        }
        if (string.equals((Object)"DL")) {
            return new DLOutputStream(outputStream);
        }
        return new ASN1OutputStream(outputStream);
    }

    public DEROutputStream getDERSubStream() {
        return new DEROutputStream(this.os);
    }

    public ASN1OutputStream getDLSubStream() {
        return new DLOutputStream(this.os);
    }

    public final void writeElements(Enumeration enumeration) throws IOException {
        while (enumeration.hasMoreElements()) {
            this.writePrimitive(((ASN1Encodable)enumeration.nextElement()).toASN1Primitive(), true);
        }
    }

    public final void writeEncoded(boolean bl, int n2, byte by, byte[] arrby) throws IOException {
        if (bl) {
            this.os.write(n2);
        }
        this.writeLength(1 + arrby.length);
        this.os.write((int)by);
        int n3 = arrby.length;
        this.os.write(arrby, 0, n3);
    }

    public final void writeEncoded(boolean bl, int n2, int n3, byte[] arrby) throws IOException {
        this.writeTag(bl, n2, n3);
        this.writeLength(arrby.length);
        int n4 = arrby.length;
        this.os.write(arrby, 0, n4);
    }

    public final void writeEncoded(boolean bl, int n2, byte[] arrby) throws IOException {
        if (bl) {
            this.os.write(n2);
        }
        this.writeLength(arrby.length);
        int n3 = arrby.length;
        this.os.write(arrby, 0, n3);
    }

    public final void writeEncodedIndef(boolean bl, int n2, ASN1Encodable[] arraSN1Encodable) throws IOException {
        if (bl) {
            this.os.write(n2);
        }
        this.os.write(128);
        int n3 = arraSN1Encodable.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            this.writePrimitive(arraSN1Encodable[i2].toASN1Primitive(), true);
        }
        this.os.write(0);
        this.os.write(0);
    }

    public final void writeLength(int n2) throws IOException {
        if (n2 > 127) {
            int n3 = n2;
            int n4 = 1;
            while ((n3 >>>= 8) != 0) {
                ++n4;
            }
            byte by = (byte)(n4 | 128);
            this.os.write((int)by);
            for (int i2 = 8 * (n4 - 1); i2 >= 0; i2 -= 8) {
                byte by2 = (byte)(n2 >> i2);
                this.os.write((int)by2);
            }
        } else {
            byte by = (byte)n2;
            this.os.write((int)by);
        }
    }

    public void writeObject(ASN1Encodable aSN1Encodable) throws IOException {
        this.writePrimitive(aSN1Encodable.toASN1Primitive(), true);
    }

    public void writePrimitive(ASN1Primitive aSN1Primitive, boolean bl) throws IOException {
        aSN1Primitive.encode(this, bl);
    }

    public final void writeTag(boolean bl, int n2, int n3) throws IOException {
        if (!bl) {
            return;
        }
        if (n3 < 31) {
            int n4 = n2 | n3;
            this.os.write(n4);
            return;
        }
        int n5 = 31 | n2;
        this.os.write(n5);
        if (n3 < 128) {
            this.os.write(n3);
            return;
        }
        byte[] arrby = new byte[5];
        int n6 = 4;
        arrby[n6] = (byte)(n3 & 127);
        do {
            arrby[--n6] = (byte)(128 | (n3 >>= 7) & 127);
        } while (n3 > 127);
        int n7 = 5 - n6;
        this.os.write(arrby, n6, n7);
    }
}

