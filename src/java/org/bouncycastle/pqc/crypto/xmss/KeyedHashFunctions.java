/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.crypto.Xof
 */
package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.xmss.DigestUtil;

public final class KeyedHashFunctions {
    public final Digest digest;
    public final int digestSize;

    public KeyedHashFunctions(ASN1ObjectIdentifier aSN1ObjectIdentifier, int n2) {
        Objects.requireNonNull((Object)aSN1ObjectIdentifier, (String)"digest == null");
        this.digest = DigestUtil.getDigest(aSN1ObjectIdentifier);
        this.digestSize = n2;
    }

    public byte[] PRF(byte[] arrby, byte[] arrby2) {
        if (arrby.length == this.digestSize) {
            if (arrby2.length == 32) {
                return this.coreDigest(3, arrby, arrby2);
            }
            throw new IllegalArgumentException("wrong address length");
        }
        throw new IllegalArgumentException("wrong key length");
    }

    public final byte[] coreDigest(int n2, byte[] arrby, byte[] arrby2) {
        byte[] arrby3 = Nat576.toBytesBigEndian(n2, this.digestSize);
        this.digest.update(arrby3, 0, arrby3.length);
        this.digest.update(arrby, 0, arrby.length);
        this.digest.update(arrby2, 0, arrby2.length);
        int n3 = this.digestSize;
        byte[] arrby4 = new byte[n3];
        Digest digest = this.digest;
        if (digest instanceof Xof) {
            ((Xof)digest).doFinal(arrby4, 0, n3);
            return arrby4;
        }
        digest.doFinal(arrby4, 0);
        return arrby4;
    }
}

