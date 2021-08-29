/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.IllegalStateException
 *  java.lang.String
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.StreamUtil;

public class DERSet
extends ASN1Set {
    public int bodyLength;

    public DERSet() {
        this.bodyLength = -1;
    }

    public DERSet(boolean bl, ASN1Encodable[] arraSN1Encodable) {
        if (bl) {
            super(bl, arraSN1Encodable);
            this.bodyLength = -1;
            return;
        }
        throw new IllegalStateException("DERSet elements should always be in sorted order");
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        int n2;
        if (bl) {
            aSN1OutputStream.os.write(49);
        }
        DEROutputStream dEROutputStream = aSN1OutputStream.getDERSubStream();
        int n3 = this.elements.length;
        int n4 = this.bodyLength;
        if (n4 < 0 && n3 <= 16) {
            ASN1Primitive[] arraSN1Primitive = new ASN1Primitive[n3];
            int n5 = 0;
            for (int i2 = 0; i2 < n3; ++i2) {
                ASN1Primitive aSN1Primitive;
                arraSN1Primitive[i2] = aSN1Primitive = this.elements[i2].toASN1Primitive().toDERObject();
                n5 += aSN1Primitive.encodedLength();
            }
            this.bodyLength = n5;
            aSN1OutputStream.writeLength(n5);
            while (n2 < n3) {
                arraSN1Primitive[n2].encode(dEROutputStream, true);
                ++n2;
            }
        } else {
            aSN1OutputStream.writeLength(this.getBodyLength());
            for (n2 = 0; n2 < n3; ++n2) {
                this.elements[n2].toASN1Primitive().toDERObject().encode(dEROutputStream, true);
            }
        }
    }

    @Override
    public int encodedLength() throws IOException {
        int n2 = this.getBodyLength();
        return n2 + (1 + StreamUtil.calculateBodyLength(n2));
    }

    public final int getBodyLength() throws IOException {
        if (this.bodyLength < 0) {
            int n2 = this.elements.length;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                n3 += this.elements[i2].toASN1Primitive().toDERObject().encodedLength();
            }
            this.bodyLength = n3;
        }
        return this.bodyLength;
    }

    @Override
    public ASN1Primitive toDERObject() {
        if (this.isSorted) {
            return this;
        }
        return super.toDERObject();
    }

    @Override
    public ASN1Primitive toDLObject() {
        return this;
    }
}

