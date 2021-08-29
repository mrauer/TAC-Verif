/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.math.raw.Nat576;

public class NHPublicKeyParameters
extends AsymmetricKeyParameter {
    public final byte[] pubData;

    public NHPublicKeyParameters(byte[] arrby) {
        super(false);
        this.pubData = Nat576.clone(arrby);
    }

    public byte[] getPubData() {
        return Nat576.clone(this.pubData);
    }
}

