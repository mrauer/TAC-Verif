/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 */
package org.bouncycastle.jcajce.provider.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public abstract class AsymmetricAlgorithmProvider
extends AlgorithmProvider {
    public void addSignatureAlgorithm(ConfigurableProvider configurableProvider, String string, String string2, String string3, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String string4 = GeneratedOutlineSupport.outline19((String)string, (String)"WITH", (String)string2);
        String string5 = GeneratedOutlineSupport.outline19((String)string, (String)"with", (String)string2);
        String string6 = GeneratedOutlineSupport.outline19((String)string, (String)"With", (String)string2);
        String string7 = GeneratedOutlineSupport.outline19((String)string, (String)"/", (String)string2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Signature.");
        stringBuilder.append(string4);
        configurableProvider.addAlgorithm(stringBuilder.toString(), string3);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Alg.Alias.Signature.");
        stringBuilder2.append(string5);
        configurableProvider.addAlgorithm(stringBuilder2.toString(), string4);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Alg.Alias.Signature.");
        stringBuilder3.append(string6);
        configurableProvider.addAlgorithm(stringBuilder3.toString(), string4);
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("Alg.Alias.Signature.");
        stringBuilder4.append(string7);
        configurableProvider.addAlgorithm(stringBuilder4.toString(), string4);
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("Alg.Alias.Signature.");
        stringBuilder5.append((Object)aSN1ObjectIdentifier);
        configurableProvider.addAlgorithm(stringBuilder5.toString(), string4);
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append("Alg.Alias.Signature.OID.");
        stringBuilder6.append((Object)aSN1ObjectIdentifier);
        configurableProvider.addAlgorithm(stringBuilder6.toString(), string4);
    }

    public void addSignatureAlgorithm(ConfigurableProvider configurableProvider, String string, String string2, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Signature.");
        stringBuilder.append(string);
        configurableProvider.addAlgorithm(stringBuilder.toString(), string2);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Alg.Alias.Signature.");
        stringBuilder2.append((Object)aSN1ObjectIdentifier);
        configurableProvider.addAlgorithm(stringBuilder2.toString(), string);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Alg.Alias.Signature.OID.");
        stringBuilder3.append((Object)aSN1ObjectIdentifier);
        configurableProvider.addAlgorithm(stringBuilder3.toString(), string);
    }

    public void registerOid(ConfigurableProvider configurableProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, String string, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Alg.Alias.KeyFactory.");
        stringBuilder.append((Object)aSN1ObjectIdentifier);
        configurableProvider.addAlgorithm(stringBuilder.toString(), string);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Alg.Alias.KeyPairGenerator.");
        stringBuilder2.append((Object)aSN1ObjectIdentifier);
        configurableProvider.addAlgorithm(stringBuilder2.toString(), string);
        configurableProvider.addKeyInfoConverter(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
    }

    public void registerOidAlgorithmParameterGenerator(ConfigurableProvider configurableProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Alg.Alias.AlgorithmParameterGenerator.");
        stringBuilder.append((Object)aSN1ObjectIdentifier);
        configurableProvider.addAlgorithm(stringBuilder.toString(), string);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
        stringBuilder2.append((Object)aSN1ObjectIdentifier);
        configurableProvider.addAlgorithm(stringBuilder2.toString(), string);
    }

    public void registerOidAlgorithmParameters(ConfigurableProvider configurableProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Alg.Alias.AlgorithmParameters.");
        stringBuilder.append((Object)aSN1ObjectIdentifier);
        configurableProvider.addAlgorithm(stringBuilder.toString(), string);
    }
}

