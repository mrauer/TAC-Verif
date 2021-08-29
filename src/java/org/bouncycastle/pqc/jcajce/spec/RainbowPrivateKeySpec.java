/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.security.spec.KeySpec
 */
package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.bouncycastle.pqc.crypto.rainbow.Layer;

public class RainbowPrivateKeySpec
implements KeySpec {
    public short[][] A1inv;
    public short[][] A2inv;
    public short[] b1;
    public short[] b2;
    public Layer[] layers;
    public int[] vi;

    public RainbowPrivateKeySpec(short[][] arrs, short[] arrs2, short[][] arrs3, short[] arrs4, int[] arrn, Layer[] arrlayer) {
        this.A1inv = arrs;
        this.b1 = arrs2;
        this.A2inv = arrs3;
        this.b2 = arrs4;
        this.vi = arrn;
        this.layers = arrlayer;
    }
}

