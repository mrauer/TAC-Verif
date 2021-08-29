/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlusParameters;

public final class WOTSPlusPublicKeyParameters {
    public final byte[][] publicKey;

    public WOTSPlusPublicKeyParameters(WOTSPlusParameters wOTSPlusParameters, byte[][] arrby) {
        Objects.requireNonNull((Object)wOTSPlusParameters, (String)"params == null");
        if (!Nat576.hasNullPointer(arrby)) {
            if (arrby.length == wOTSPlusParameters.len) {
                for (int i2 = 0; i2 < arrby.length; ++i2) {
                    if (arrby[i2].length == wOTSPlusParameters.digestSize) {
                        continue;
                    }
                    throw new IllegalArgumentException("wrong publicKey format");
                }
                this.publicKey = Nat576.cloneArray(arrby);
                return;
            }
            throw new IllegalArgumentException("wrong publicKey size");
        }
        throw new NullPointerException("publicKey byte array == null");
    }
}

