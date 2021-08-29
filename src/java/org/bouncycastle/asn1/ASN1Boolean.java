/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.String
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;

public class ASN1Boolean
extends ASN1Primitive {
    public static final ASN1Boolean FALSE = new ASN1Boolean(0);
    public static final ASN1Boolean TRUE = new ASN1Boolean(-1);
    public final byte value;

    public ASN1Boolean(byte by) {
        this.value = by;
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Boolean)) {
            return false;
        }
        ASN1Boolean aSN1Boolean = (ASN1Boolean)aSN1Primitive;
        boolean bl = this.isTrue();
        boolean bl2 = aSN1Boolean.isTrue();
        boolean bl3 = false;
        if (bl == bl2) {
            bl3 = true;
        }
        return bl3;
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        byte by = this.value;
        if (bl) {
            aSN1OutputStream.os.write(1);
        }
        aSN1OutputStream.writeLength(1);
        aSN1OutputStream.os.write((int)by);
    }

    @Override
    public int encodedLength() {
        return 3;
    }

    @Override
    public int hashCode() {
        return (int)this.isTrue();
    }

    @Override
    public boolean isConstructed() {
        return false;
    }

    public boolean isTrue() {
        return this.value != 0;
    }

    @Override
    public ASN1Primitive toDERObject() {
        if (this.isTrue()) {
            return TRUE;
        }
        return FALSE;
    }

    public String toString() {
        if (this.isTrue()) {
            return "TRUE";
        }
        return "FALSE";
    }
}

