/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 */
package org.bouncycastle.jcajce.provider.config;

import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public interface ConfigurableProvider {
    public void addAlgorithm(String var1, String var2);

    public void addAlgorithm(String var1, ASN1ObjectIdentifier var2, String var3);

    public void addAttributes(String var1, Map<String, String> var2);

    public void addKeyInfoConverter(ASN1ObjectIdentifier var1, AsymmetricKeyInfoConverter var2);
}

