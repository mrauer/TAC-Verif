/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.StreamUtil;

public class DLTaggedObject
extends ASN1TaggedObject {
    public DLTaggedObject(boolean bl, int n2, ASN1Encodable aSN1Encodable) {
        super(bl, n2, aSN1Encodable);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        ASN1Primitive aSN1Primitive = this.obj.toASN1Primitive().toDLObject();
        int n2 = !this.explicit && !aSN1Primitive.isConstructed() ? 128 : 160;
        aSN1OutputStream.writeTag(bl, n2, this.tagNo);
        if (this.explicit) {
            aSN1OutputStream.writeLength(aSN1Primitive.encodedLength());
        }
        aSN1OutputStream.getDLSubStream().writePrimitive(aSN1Primitive, this.explicit);
    }

    @Override
    public int encodedLength() throws IOException {
        int n2 = this.obj.toASN1Primitive().toDLObject().encodedLength();
        if (this.explicit) {
            return n2 + (StreamUtil.calculateTagLength(this.tagNo) + StreamUtil.calculateBodyLength(n2));
        }
        return n2 - 1 + StreamUtil.calculateTagLength(this.tagNo);
    }

    @Override
    public boolean isConstructed() {
        return this.explicit || this.obj.toASN1Primitive().toDLObject().isConstructed();
        {
        }
    }

    @Override
    public ASN1Primitive toDLObject() {
        return this;
    }
}

