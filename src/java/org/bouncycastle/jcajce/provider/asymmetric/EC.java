/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package org.bouncycastle.jcajce.provider.asymmetric;

import java.util.HashMap;
import java.util.Map;

public class EC {
    public static final Map<String, String> generalEcAttributes;

    public static {
        HashMap hashMap;
        generalEcAttributes = hashMap = new HashMap();
        hashMap.put((Object)"SupportedKeyClasses", (Object)"java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey");
        hashMap.put((Object)"SupportedKeyFormats", (Object)"PKCS#8|X.509");
    }
}

