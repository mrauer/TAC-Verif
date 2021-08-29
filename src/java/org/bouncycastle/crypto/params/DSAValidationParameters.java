/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Arrays
 */
package org.bouncycastle.crypto.params;

import java.util.Arrays;
import org.bouncycastle.math.raw.Nat576;

public class DSAValidationParameters {
    public int counter;
    public byte[] seed;

    public DSAValidationParameters(byte[] arrby, int n2) {
        this.seed = Nat576.clone(arrby);
        this.counter = n2;
    }

    public boolean equals(Object object) {
        if (!(object instanceof DSAValidationParameters)) {
            return false;
        }
        DSAValidationParameters dSAValidationParameters = (DSAValidationParameters)object;
        if (dSAValidationParameters.counter != this.counter) {
            return false;
        }
        return Arrays.equals((byte[])this.seed, (byte[])dSAValidationParameters.seed);
    }

    public int hashCode() {
        return this.counter ^ Nat576.hashCode(this.seed);
    }
}

