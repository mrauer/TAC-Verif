/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class XMSSKeyParameters
extends AsymmetricKeyParameter {
    public final String treeDigest;

    public XMSSKeyParameters(boolean bl, String string) {
        super(bl);
        this.treeDigest = string;
    }
}

