/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class SPHINCSKeyParameters
extends AsymmetricKeyParameter {
    public final String treeDigest;

    public SPHINCSKeyParameters(boolean bl, String string) {
        super(bl);
        this.treeDigest = string;
    }
}

