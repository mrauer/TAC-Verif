/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.util.Arrays
 *  java.util.Objects
 *  java.util.concurrent.ConcurrentMap
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.math.raw.Nat576;

public class ASN1ObjectIdentifier
extends ASN1Primitive {
    public static final ConcurrentMap<OidHandle, ASN1ObjectIdentifier> pool = new ConcurrentHashMap<OidHandle, ASN1ObjectIdentifier>();
    public byte[] body;
    public final String identifier;

    public ASN1ObjectIdentifier(String string) {
        Objects.requireNonNull((Object)string, (String)"'identifier' cannot be null");
        int n2 = string.length();
        boolean bl = false;
        if (n2 >= 3) {
            if (string.charAt(1) != '.') {
                bl = false;
            } else {
                char c2 = string.charAt(0);
                bl = false;
                if (c2 >= '0') {
                    bl = c2 > '2' ? false : ASN1ObjectIdentifier.isValidBranchID(string, 2);
                }
            }
        }
        if (bl) {
            this.identifier = string;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline19((String)"string ", (String)string, (String)" not an OID"));
    }

    public ASN1ObjectIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, String string) {
        if (ASN1ObjectIdentifier.isValidBranchID(string, 0)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(aSN1ObjectIdentifier.identifier);
            stringBuilder.append(".");
            stringBuilder.append(string);
            this.identifier = stringBuilder.toString();
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline19((String)"string ", (String)string, (String)" not a valid OID branch"));
    }

    public ASN1ObjectIdentifier(byte[] arrby) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean bl = true;
        long l2 = 0L;
        BigInteger bigInteger = null;
        for (int i2 = 0; i2 != arrby.length; ++i2) {
            int n2 = 255 & arrby[i2];
            if (l2 <= 72057594037927808L) {
                long l3 = l2 + (long)(n2 & 127);
                if ((n2 & 128) == 0) {
                    if (bl) {
                        if (l3 < 40L) {
                            stringBuffer.append('0');
                        } else if (l3 < 80L) {
                            stringBuffer.append('1');
                            l3 -= 40L;
                        } else {
                            stringBuffer.append('2');
                            l3 -= 80L;
                        }
                        bl = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(l3);
                    l2 = 0L;
                    continue;
                }
                l2 = l3 << 7;
                continue;
            }
            if (bigInteger == null) {
                bigInteger = BigInteger.valueOf((long)l2);
            }
            BigInteger bigInteger2 = bigInteger.or(BigInteger.valueOf((long)(n2 & 127)));
            if ((n2 & 128) == 0) {
                if (bl) {
                    stringBuffer.append('2');
                    bigInteger2 = bigInteger2.subtract(BigInteger.valueOf((long)80L));
                    bl = false;
                }
                stringBuffer.append('.');
                stringBuffer.append((Object)bigInteger2);
                l2 = 0L;
                bigInteger = null;
                continue;
            }
            bigInteger = bigInteger2.shiftLeft(7);
        }
        this.identifier = stringBuffer.toString();
        this.body = Nat576.clone(arrby);
    }

    public static ASN1ObjectIdentifier getInstance(Object object) {
        if (object != null && !(object instanceof ASN1ObjectIdentifier)) {
            ASN1Primitive aSN1Primitive;
            if (object instanceof ASN1Encodable && (aSN1Primitive = ((ASN1Encodable)object).toASN1Primitive()) instanceof ASN1ObjectIdentifier) {
                return (ASN1ObjectIdentifier)aSN1Primitive;
            }
            if (object instanceof byte[]) {
                byte[] arrby = (byte[])object;
                try {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier)ASN1Primitive.fromByteArray(arrby);
                    return aSN1ObjectIdentifier;
                }
                catch (IOException iOException) {
                    StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"failed to construct object identifier from byte[]: ");
                    stringBuilder.append(iOException.getMessage());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"illegal object in getInstance: ");
            stringBuilder.append(object.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return (ASN1ObjectIdentifier)object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean isValidBranchID(String string, int n2) {
        int n3;
        int n4 = string.length();
        block0 : do {
            n3 = 0;
            while (--n4 >= n2) {
                char c2 = string.charAt(n4);
                if (c2 == '.') {
                    if (n3 != 0 && (n3 <= true || string.charAt(n4 + 1) != '0')) continue block0;
                    return false;
                }
                if ('0' > c2 || c2 > '9') return false;
                ++n3;
            }
            break;
        } while (true);
        if (n3 == 0) return false;
        return n3 <= true || string.charAt(n4 + 1) != '0';
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive == this) {
            return true;
        }
        if (!(aSN1Primitive instanceof ASN1ObjectIdentifier)) {
            return false;
        }
        return this.identifier.equals((Object)((ASN1ObjectIdentifier)aSN1Primitive).identifier);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void doOutput(ByteArrayOutputStream var1_1) {
        block14 : {
            var2_2 = this.identifier;
            var3_3 = var2_2.indexOf(46, 0);
            if (var3_3 == -1) {
                var6_4 = var2_2.substring(0);
                var5_5 = -1;
            } else {
                var4_6 = var2_2.substring(0, var3_3);
                var5_5 = var3_3 + 1;
                var6_4 = var4_6;
            }
            var7_7 = 40 * Integer.parseInt((String)var6_4);
            if (var5_5 == -1) {
                var10_8 = var5_5;
                var9_9 = null;
            } else {
                var8_10 = var2_2.indexOf(46, var5_5);
                if (var8_10 == -1) {
                    var9_9 = var2_2.substring(var5_5);
                    var10_8 = -1;
                } else {
                    var9_9 = var2_2.substring(var5_5, var8_10);
                    var10_8 = var8_10 + 1;
                }
            }
            if (var9_9.length() > 18) break block14;
            var18_11 = (long)var7_7 + Long.parseLong((String)var9_9);
            var12_12 = var1_1;
            var13_13 = this;
            ** GOTO lbl49
        }
        var11_14 = new BigInteger(var9_9).add(BigInteger.valueOf((long)var7_7));
        var12_12 = var1_1;
        this.writeField(var12_12, var11_14);
        var13_13 = this;
        do {
            block15 : {
                var14_15 = var10_8 != -1;
                if (var14_15 == false) return;
                if (var10_8 == -1) {
                    var17_18 = var10_8;
                    var16_17 = null;
                } else {
                    var15_16 = var2_2.indexOf(46, var10_8);
                    if (var15_16 == -1) {
                        var16_17 = var2_2.substring(var10_8);
                        var17_18 = -1;
                    } else {
                        var16_17 = var2_2.substring(var10_8, var15_16);
                        var17_18 = var15_16 + 1;
                    }
                }
                if (var16_17.length() > 18) break block15;
                var18_11 = Long.parseLong(var16_17);
                var10_8 = var17_18;
lbl49: // 2 sources:
                var13_13.writeField(var12_12, var18_11);
                continue;
            }
            var13_13.writeField(var12_12, new BigInteger(var16_17));
            var10_8 = var17_18;
        } while (true);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        aSN1OutputStream.writeEncoded(bl, 6, this.getBody());
    }

    @Override
    public int encodedLength() throws IOException {
        int n2 = this.getBody().length;
        return n2 + (1 + StreamUtil.calculateBodyLength(n2));
    }

    public final byte[] getBody() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this;
        synchronized (aSN1ObjectIdentifier) {
            if (this.body == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this.doOutput(byteArrayOutputStream);
                this.body = byteArrayOutputStream.toByteArray();
            }
            byte[] arrby = this.body;
            return arrby;
        }
    }

    @Override
    public int hashCode() {
        return this.identifier.hashCode();
    }

    public ASN1ObjectIdentifier intern() {
        ConcurrentMap<OidHandle, ASN1ObjectIdentifier> concurrentMap = pool;
        Object object = new Object(this.getBody()){
            public final byte[] enc;
            public final int key;
            {
                this.key = Nat576.hashCode(arrby);
                this.enc = arrby;
            }

            public boolean equals(Object object) {
                if (object instanceof OidHandle) {
                    return Arrays.equals((byte[])this.enc, (byte[])(object).enc);
                }
                return false;
            }

            public int hashCode() {
                return this.key;
            }
        };
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier)concurrentMap.get(object);
        if (aSN1ObjectIdentifier == null && (aSN1ObjectIdentifier = (ASN1ObjectIdentifier)concurrentMap.putIfAbsent(object, (Object)this)) == null) {
            aSN1ObjectIdentifier = this;
        }
        return aSN1ObjectIdentifier;
    }

    @Override
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return this.identifier;
    }

    public final void writeField(ByteArrayOutputStream byteArrayOutputStream, long l2) {
        byte[] arrby = new byte[9];
        byte by = (byte)(127 & (int)l2);
        int n2 = 8;
        arrby[n2] = by;
        while (l2 >= 128L) {
            arrby[--n2] = (byte)(128 | 127 & (int)(l2 >>= 7));
        }
        byteArrayOutputStream.write(arrby, n2, 9 - n2);
    }

    public final void writeField(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int n2;
        int n3 = (6 + bigInteger.bitLength()) / 7;
        if (n3 == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] arrby = new byte[n3];
        for (int i2 = n2 = n3 - 1; i2 >= 0; --i2) {
            arrby[i2] = (byte)(128 | 127 & bigInteger.intValue());
            bigInteger = bigInteger.shiftRight(7);
        }
        arrby[n2] = (byte)(127 & arrby[n2]);
        byteArrayOutputStream.write(arrby, 0, n3);
    }

}

