/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.math.raw.Nat576;

public class NHPrivateKeyParameters
extends AsymmetricKeyParameter {
    public final short[] secData;

    public NHPrivateKeyParameters(short[] arrs) {
        super(true);
        this.secData = Nat576.clone(arrs);
    }

    public short[] getSecData() {
        return Nat576.clone(this.secData);
    }
}

