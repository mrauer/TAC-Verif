/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  org.bouncycastle.asn1.x9.X9ECParameters
 */
package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.x9.X9ECParameters;

public abstract class X9ECParametersHolder {
    public X9ECParameters params;

    public abstract X9ECParameters createParameters();

    public X9ECParameters getParameters() {
        X9ECParametersHolder x9ECParametersHolder = this;
        synchronized (x9ECParametersHolder) {
            if (this.params == null) {
                this.params = this.createParameters();
            }
            X9ECParameters x9ECParameters = this.params;
            return x9ECParameters;
        }
    }
}

