/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  org.bouncycastle.asn1.ASN1Primitive
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;

public class DLOutputStream
extends ASN1OutputStream {
    public DLOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override
    public ASN1OutputStream getDLSubStream() {
        return this;
    }

    @Override
    public void writePrimitive(ASN1Primitive aSN1Primitive, boolean bl) throws IOException {
        aSN1Primitive.toDLObject().encode((ASN1OutputStream)this, bl);
    }
}

