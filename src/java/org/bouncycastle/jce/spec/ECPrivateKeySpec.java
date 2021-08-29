/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.math.BigInteger
 */
package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import org.bouncycastle.jce.spec.ECKeySpec;
import org.bouncycastle.jce.spec.ECParameterSpec;

public class ECPrivateKeySpec
extends ECKeySpec {
    public BigInteger d;

    public ECPrivateKeySpec(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.d = bigInteger;
    }
}

