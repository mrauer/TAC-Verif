/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec;

import org.bouncycastle.math.ec.ECPoint;

public abstract class AbstractECLookupTable {
    public abstract int getSize();

    public abstract ECPoint lookup(int var1);
}

