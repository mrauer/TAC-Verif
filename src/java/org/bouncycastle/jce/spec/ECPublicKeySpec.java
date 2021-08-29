/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.jce.spec;

import org.bouncycastle.jce.spec.ECKeySpec;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class ECPublicKeySpec
extends ECKeySpec {
    public ECPoint q;

    public ECPublicKeySpec(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        if (eCPoint.curve != null) {
            eCPoint = eCPoint.normalize();
        }
        this.q = eCPoint;
    }
}

