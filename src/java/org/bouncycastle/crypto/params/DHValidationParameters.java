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

public class DHValidationParameters {
    public int counter;
    public byte[] seed;

    public DHValidationParameters(byte[] arrby, int n2) {
        this.seed = Nat576.clone(arrby);
        this.counter = n2;
    }

    public boolean equals(Object object) {
        if (!(object instanceof DHValidationParameters)) {
            return false;
        }
        DHValidationParameters dHValidationParameters = (DHValidationParameters)object;
        if (dHValidationParameters.counter != this.counter) {
            return false;
        }
        return Arrays.equals((byte[])this.seed, (byte[])dHValidationParameters.seed);
    }

    public int hashCode() {
        return this.counter ^ Nat576.hashCode(this.seed);
    }
}

