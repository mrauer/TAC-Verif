/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1ApplicationSpecific;
import org.bouncycastle.asn1.ASN1OutputStream;

public class DLApplicationSpecific
extends ASN1ApplicationSpecific {
    public DLApplicationSpecific(boolean bl, int n2, byte[] arrby) {
        super(bl, n2, arrby);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        int n2 = this.isConstructed ? 96 : 64;
        aSN1OutputStream.writeEncoded(bl, n2, this.tag, this.octets);
    }
}

