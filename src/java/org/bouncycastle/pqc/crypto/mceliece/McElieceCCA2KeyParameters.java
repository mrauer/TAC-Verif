/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class McElieceCCA2KeyParameters
extends AsymmetricKeyParameter {
    public String params;

    public McElieceCCA2KeyParameters(boolean bl, String string) {
        super(bl);
        this.params = string;
    }
}

