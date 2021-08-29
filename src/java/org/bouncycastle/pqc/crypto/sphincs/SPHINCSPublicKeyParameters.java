/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;

public class SPHINCSPublicKeyParameters
extends SPHINCSKeyParameters {
    public final byte[] keyData;

    public SPHINCSPublicKeyParameters(byte[] arrby, String string) {
        super(false, string);
        this.keyData = Nat576.clone(arrby);
    }

    public byte[] getKeyData() {
        return Nat576.clone(this.keyData);
    }
}

