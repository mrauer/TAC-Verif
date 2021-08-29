/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.util.Arrays
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public abstract class ASN1ApplicationSpecific
extends ASN1Primitive {
    public final boolean isConstructed;
    public final byte[] octets;
    public final int tag;

    public ASN1ApplicationSpecific(boolean bl, int n2, byte[] arrby) {
        this.isConstructed = bl;
        this.tag = n2;
        this.octets = Nat576.clone(arrby);
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1ApplicationSpecific)) {
            return false;
        }
        ASN1ApplicationSpecific aSN1ApplicationSpecific = (ASN1ApplicationSpecific)aSN1Primitive;
        boolean bl = this.isConstructed;
        boolean bl2 = aSN1ApplicationSpecific.isConstructed;
        boolean bl3 = false;
        if (bl == bl2) {
            int n2 = this.tag;
            int n3 = aSN1ApplicationSpecific.tag;
            bl3 = false;
            if (n2 == n3) {
                boolean bl4 = Arrays.equals((byte[])this.octets, (byte[])aSN1ApplicationSpecific.octets);
                bl3 = false;
                if (bl4) {
                    bl3 = true;
                }
            }
        }
        return bl3;
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        int n2 = this.isConstructed ? 96 : 64;
        aSN1OutputStream.writeEncoded(bl, n2, this.tag, this.octets);
    }

    @Override
    public int encodedLength() throws IOException {
        return StreamUtil.calculateTagLength(this.tag) + StreamUtil.calculateBodyLength(this.octets.length) + this.octets.length;
    }

    @Override
    public int hashCode() {
        return this.isConstructed ^ this.tag ^ Nat576.hashCode(this.octets);
    }

    @Override
    public boolean isConstructed() {
        return this.isConstructed;
    }

    public String toString() {
        String string;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        if (this.isConstructed) {
            stringBuffer.append("CONSTRUCTED ");
        }
        stringBuffer.append("APPLICATION ");
        stringBuffer.append(Integer.toString((int)this.tag));
        stringBuffer.append("]");
        if (this.octets != null) {
            stringBuffer.append(" #");
            byte[] arrby = this.octets;
            string = Strings.fromByteArray(Hex.encode(arrby, 0, arrby.length));
        } else {
            string = " #null";
        }
        stringBuffer.append(string);
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }
}

