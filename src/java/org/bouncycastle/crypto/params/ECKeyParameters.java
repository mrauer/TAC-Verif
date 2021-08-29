/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package org.bouncycastle.crypto.params;

import java.util.Objects;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;

public class ECKeyParameters
extends AsymmetricKeyParameter {
    public final ECDomainParameters parameters;

    public ECKeyParameters(boolean bl, ECDomainParameters eCDomainParameters) {
        super(bl);
        Objects.requireNonNull((Object)eCDomainParameters, (String)"'parameters' cannot be null");
        this.parameters = eCDomainParameters;
    }
}

