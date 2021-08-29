/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.util.Arrays
 *  org.bouncycastle.crypto.digests.SHAKEDigest
 */
package org.bouncycastle.util;

import java.util.Arrays;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.math.raw.Nat576;

public class Fingerprint {
    public static char[] encodingTable = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public final byte[] fingerprint;

    public Fingerprint(byte[] arrby) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.update(arrby, 0, arrby.length);
        byte[] arrby2 = new byte[20];
        sHAKEDigest.doFinal(arrby2, 0, 20);
        this.fingerprint = arrby2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof Fingerprint) {
            return Arrays.equals((byte[])((Fingerprint)object).fingerprint, (byte[])this.fingerprint);
        }
        return false;
    }

    public int hashCode() {
        return Nat576.hashCode(this.fingerprint);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 != this.fingerprint.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(":");
            }
            stringBuffer.append(encodingTable[15 & this.fingerprint[i2] >>> 4]);
            stringBuffer.append(encodingTable[15 & this.fingerprint[i2]]);
        }
        return stringBuffer.toString();
    }
}

