/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.System
 */
package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public final class Ed25519PublicKeyParameters
extends AsymmetricKeyParameter {
    public final byte[] data;

    public Ed25519PublicKeyParameters(byte[] arrby, int n2) {
        super(false);
        byte[] arrby2 = new byte[32];
        this.data = arrby2;
        System.arraycopy((Object)arrby, (int)n2, (Object)arrby2, (int)0, (int)32);
    }
}

