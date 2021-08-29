/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.crypto;

import org.bouncycastle.crypto.Digest;

public interface Xof
extends Digest {
    public int doFinal(byte[] var1, int var2, int var3);
}

