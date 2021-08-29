/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;

public class SPHINCSPrivateKeyParameters
extends SPHINCSKeyParameters {
    public final byte[] keyData;

    public SPHINCSPrivateKeyParameters(byte[] arrby, String string) {
        super(true, string);
        this.keyData = Nat576.clone(arrby);
    }

    public byte[] getKeyData() {
        return Nat576.clone(this.keyData);
    }
}

