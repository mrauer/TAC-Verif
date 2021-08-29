/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.util.Arrays
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.UTF8;

public class DERUTF8String
extends ASN1Primitive {
    public final byte[] string;

    public DERUTF8String(byte[] arrby) {
        this.string = arrby;
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERUTF8String)) {
            return false;
        }
        DERUTF8String dERUTF8String = (DERUTF8String)aSN1Primitive;
        return Arrays.equals((byte[])this.string, (byte[])dERUTF8String.string);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 12, this.string);
    }

    @Override
    public int encodedLength() throws IOException {
        return 1 + StreamUtil.calculateBodyLength(this.string.length) + this.string.length;
    }

    @Override
    public int hashCode() {
        return Nat576.hashCode(this.string);
    }

    @Override
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        byte[] arrby = this.string;
        int n2 = arrby.length;
        char[] arrc = new char[n2];
        int n3 = 0;
        int n4 = 0;
        while (n3 < arrby.length) {
            int n5;
            block12 : {
                int n6;
                block13 : {
                    block9 : {
                        block11 : {
                            byte by;
                            block10 : {
                                n5 = n3 + 1;
                                by = arrby[n3];
                                if (by < 0) break block10;
                                if (n4 < n2) {
                                    int n7 = n4 + 1;
                                    arrc[n4] = (char)by;
                                    n3 = n5;
                                    n4 = n7;
                                    continue;
                                }
                                break block9;
                            }
                            short s2 = UTF8.firstUnitTable[by & 127];
                            n6 = s2 >>> 8;
                            byte by2 = (byte)s2;
                            while (by2 >= 0) {
                                if (n5 < arrby.length) {
                                    int n8 = n5 + 1;
                                    byte by3 = arrby[n5];
                                    n6 = n6 << 6 | by3 & 63;
                                    by2 = UTF8.transitionTable[by2 + ((by3 & 255) >>> 4)];
                                    n5 = n8;
                                    continue;
                                }
                                break block9;
                            }
                            if (by2 == -2) break block9;
                            if (n6 > 65535) break block11;
                            if (n4 >= n2) break block9;
                            int n9 = n4 + 1;
                            arrc[n4] = (char)n6;
                            n4 = n9;
                            break block12;
                        }
                        if (n4 < n2 - 1) break block13;
                    }
                    n4 = -1;
                    break;
                }
                int n10 = n4 + 1;
                arrc[n4] = (char)(55232 + (n6 >>> 10));
                n4 = n10 + 1;
                arrc[n10] = (char)(56320 | n6 & 1023);
            }
            n3 = n5;
        }
        if (n4 >= 0) {
            return new String(arrc, 0, n4);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }
}

