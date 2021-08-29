/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Map
 *  java.util.Set
 */
package org.bouncycastle.jce.provider;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.config.ProviderConfigurationPermission;
import org.bouncycastle.jce.spec.ECParameterSpec;

public class BouncyCastleProviderConfiguration
implements ProviderConfiguration {
    public volatile Set acceptableNamedCurves;
    public volatile Map additionalECParameters;
    public ThreadLocal ecThreadSpec = new ThreadLocal();

    public static {
        new ProviderConfigurationPermission("BC", "threadLocalEcImplicitlyCa");
        new ProviderConfigurationPermission("BC", "ecImplicitlyCa");
        new ProviderConfigurationPermission("BC", "threadLocalDhDefaultParams");
        new ProviderConfigurationPermission("BC", "DhDefaultParams");
        new ProviderConfigurationPermission("BC", "acceptableEcCurves");
        new ProviderConfigurationPermission("BC", "additionalEcParameters");
    }

    public BouncyCastleProviderConfiguration() {
        new ThreadLocal();
        this.acceptableNamedCurves = new HashSet();
        this.additionalECParameters = new HashMap();
    }

    public Map getAdditionalECParameters() {
        return Collections.unmodifiableMap((Map)this.additionalECParameters);
    }

    public ECParameterSpec getEcImplicitlyCa() {
        ECParameterSpec eCParameterSpec = (ECParameterSpec)this.ecThreadSpec.get();
        if (eCParameterSpec != null) {
            return eCParameterSpec;
        }
        return null;
    }
}

