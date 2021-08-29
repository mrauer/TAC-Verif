/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.security.spec.KeySpec
 */
package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;

public class RainbowPublicKeySpec
implements KeySpec {
    public short[][] coeffquadratic;
    public short[] coeffscalar;
    public short[][] coeffsingular;
    public int docLength;

    public RainbowPublicKeySpec(int n2, short[][] arrs, short[][] arrs2, short[] arrs3) {
        this.docLength = n2;
        this.coeffquadratic = arrs;
        this.coeffsingular = arrs2;
        this.coeffscalar = arrs3;
    }
}

