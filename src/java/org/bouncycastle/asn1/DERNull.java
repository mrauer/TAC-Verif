/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1OutputStream;

public class DERNull
extends ASN1Null {
    public static final DERNull INSTANCE = new DERNull();
    public static final byte[] zeroBytes = new byte[0];

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 5, zeroBytes);
    }

    @Override
    public int encodedLength() {
        return 2;
    }

    @Override
    public boolean isConstructed() {
        return false;
    }
}

