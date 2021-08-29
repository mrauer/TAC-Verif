/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Enumeration
 *  java.util.Objects
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Exception;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1Set$1;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.StreamUtil;

public class BERTaggedObject
extends ASN1TaggedObject {
    public BERTaggedObject(boolean bl, int n2, ASN1Encodable aSN1Encodable) {
        super(bl, n2, aSN1Encodable);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeTag(bl, 160, this.tagNo);
        aSN1OutputStream.os.write(128);
        if (!this.explicit) {
            Enumeration enumeration;
            ASN1Encodable aSN1Encodable = this.obj;
            if (aSN1Encodable instanceof ASN1OctetString) {
                enumeration = aSN1Encodable instanceof BEROctetString ? ((BEROctetString)aSN1Encodable).getObjects() : new BEROctetString(((ASN1OctetString)aSN1Encodable).string).getObjects();
            } else if (aSN1Encodable instanceof ASN1Sequence) {
                enumeration = ((ASN1Sequence)aSN1Encodable).getObjects();
            } else {
                if (!(aSN1Encodable instanceof ASN1Set)) {
                    StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"not implemented: ");
                    stringBuilder.append(this.obj.getClass().getName());
                    throw new ASN1Exception(stringBuilder.toString());
                }
                ASN1Set aSN1Set = (ASN1Set)aSN1Encodable;
                Objects.requireNonNull((Object)aSN1Set);
                enumeration = new ASN1Set$1(aSN1Set);
            }
            aSN1OutputStream.writeElements(enumeration);
        } else {
            aSN1OutputStream.writePrimitive(this.obj.toASN1Primitive(), true);
        }
        aSN1OutputStream.os.write(0);
        aSN1OutputStream.os.write(0);
    }

    @Override
    public int encodedLength() throws IOException {
        int n2 = this.obj.toASN1Primitive().encodedLength();
        if (this.explicit) {
            return n2 + (StreamUtil.calculateTagLength(this.tagNo) + StreamUtil.calculateBodyLength(n2));
        }
        return n2 - 1 + StreamUtil.calculateTagLength(this.tagNo);
    }

    @Override
    public boolean isConstructed() {
        return this.explicit || this.obj.toASN1Primitive().isConstructed();
        {
        }
    }
}

