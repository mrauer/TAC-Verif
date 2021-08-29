/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.System
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.util.Strings;

public class DERGeneralizedTime
extends ASN1GeneralizedTime {
    public DERGeneralizedTime(byte[] arrby) {
        super(arrby);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 24, this.getDERTime());
    }

    @Override
    public int encodedLength() {
        int n2 = this.getDERTime().length;
        return n2 + (1 + StreamUtil.calculateBodyLength(n2));
    }

    public final byte[] getDERTime() {
        byte[] arrby = this.time;
        if (arrby[arrby.length - 1] == 90) {
            boolean bl;
            byte[] arrby2;
            block7 : {
                boolean bl2 = this.isDigit(10) && this.isDigit(11);
                if (!bl2) {
                    byte[] arrby3 = this.time;
                    byte[] arrby4 = new byte[4 + arrby3.length];
                    System.arraycopy((Object)arrby3, (int)0, (Object)arrby4, (int)0, (int)(arrby3.length - 1));
                    System.arraycopy((Object)Strings.toByteArray("0000Z"), (int)0, (Object)arrby4, (int)(this.time.length - 1), (int)5);
                    return arrby4;
                }
                boolean bl3 = this.isDigit(12) && this.isDigit(13);
                if (!bl3) {
                    byte[] arrby5 = this.time;
                    byte[] arrby6 = new byte[2 + arrby5.length];
                    System.arraycopy((Object)arrby5, (int)0, (Object)arrby6, (int)0, (int)(arrby5.length - 1));
                    System.arraycopy((Object)Strings.toByteArray("00Z"), (int)0, (Object)arrby6, (int)(this.time.length - 1), (int)3);
                    return arrby6;
                }
                for (int i2 = 0; i2 != (arrby2 = this.time).length; ++i2) {
                    if (arrby2[i2] != 46 || i2 != 14) continue;
                    bl = true;
                    break block7;
                }
                bl = false;
            }
            if (bl) {
                int n2;
                for (n2 = -2 + arrby2.length; n2 > 0 && this.time[n2] == 48; --n2) {
                }
                byte[] arrby7 = this.time;
                if (arrby7[n2] == 46) {
                    byte[] arrby8 = new byte[n2 + 1];
                    System.arraycopy((Object)arrby7, (int)0, (Object)arrby8, (int)0, (int)n2);
                    arrby8[n2] = 90;
                    return arrby8;
                }
                byte[] arrby9 = new byte[n2 + 2];
                int n3 = n2 + 1;
                System.arraycopy((Object)arrby7, (int)0, (Object)arrby9, (int)0, (int)n3);
                arrby9[n3] = 90;
                return arrby9;
            }
            return arrby2;
        }
        return arrby;
    }

    @Override
    public ASN1Primitive toDERObject() {
        return this;
    }

    @Override
    public ASN1Primitive toDLObject() {
        return this;
    }
}

