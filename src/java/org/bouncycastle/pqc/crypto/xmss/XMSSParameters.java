/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.pqc.crypto.xmss.DefaultXMSSOid
 */
package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.pqc.crypto.xmss.DefaultXMSSOid;
import org.bouncycastle.pqc.crypto.xmss.DigestUtil;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlus;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlusParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;

public final class XMSSParameters {
    public static final Map<Integer, XMSSParameters> paramsLookupTable;
    public final int height;
    public final int k;
    public final XMSSOid oid;
    public final String treeDigest;
    public final ASN1ObjectIdentifier treeDigestOID;
    public final int treeDigestSize;
    public final int winternitzParameter;
    public final WOTSPlusParameters wotsPlusParams;

    public static {
        HashMap hashMap = new HashMap();
        Integer n2 = 1;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        hashMap.put((Object)n2, (Object)new XMSSParameters(10, aSN1ObjectIdentifier));
        hashMap.put((Object)2, (Object)new XMSSParameters(16, aSN1ObjectIdentifier));
        hashMap.put((Object)3, (Object)new XMSSParameters(20, aSN1ObjectIdentifier));
        Integer n3 = 4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_sha512;
        hashMap.put((Object)n3, (Object)new XMSSParameters(10, aSN1ObjectIdentifier2));
        hashMap.put((Object)5, (Object)new XMSSParameters(16, aSN1ObjectIdentifier2));
        hashMap.put((Object)6, (Object)new XMSSParameters(20, aSN1ObjectIdentifier2));
        Integer n4 = 7;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_shake128;
        hashMap.put((Object)n4, (Object)new XMSSParameters(10, aSN1ObjectIdentifier3));
        hashMap.put((Object)8, (Object)new XMSSParameters(16, aSN1ObjectIdentifier3));
        hashMap.put((Object)9, (Object)new XMSSParameters(20, aSN1ObjectIdentifier3));
        Integer n5 = 10;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_shake256;
        hashMap.put((Object)n5, (Object)new XMSSParameters(10, aSN1ObjectIdentifier4));
        hashMap.put((Object)11, (Object)new XMSSParameters(16, aSN1ObjectIdentifier4));
        hashMap.put((Object)12, (Object)new XMSSParameters(20, aSN1ObjectIdentifier4));
        paramsLookupTable = Collections.unmodifiableMap((Map)hashMap);
    }

    public XMSSParameters(int n2, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (n2 >= 2) {
            int n3;
            Objects.requireNonNull((Object)aSN1ObjectIdentifier, (String)"digest == null");
            this.height = n2;
            for (int i2 = 2; i2 <= (n3 = this.height); ++i2) {
                if ((n3 - i2) % 2 != 0) continue;
                this.k = i2;
                String string = (String)DigestUtil.oidToName.get((Object)aSN1ObjectIdentifier);
                if (string != null) {
                    int n4;
                    int n5;
                    WOTSPlusParameters wOTSPlusParameters;
                    this.treeDigest = string;
                    this.treeDigestOID = aSN1ObjectIdentifier;
                    this.wotsPlusParams = wOTSPlusParameters = new WOTSPlusParameters(aSN1ObjectIdentifier);
                    this.treeDigestSize = n4 = wOTSPlusParameters.digestSize;
                    this.winternitzParameter = n5 = wOTSPlusParameters.winternitzParameter;
                    int n6 = wOTSPlusParameters.len;
                    Objects.requireNonNull((Object)string, (String)"algorithmName == null");
                    this.oid = (DefaultXMSSOid)DefaultXMSSOid.oidLookupTable.get((Object)DefaultXMSSOid.createKey((String)string, (int)n4, (int)n5, (int)n6, (int)n2));
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unrecognized digest oid: ");
                stringBuilder.append((Object)aSN1ObjectIdentifier);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw new IllegalStateException("should never happen...");
        }
        throw new IllegalArgumentException("height must be >= 2");
    }

    public WOTSPlus getWOTSPlus() {
        return new WOTSPlus(this.wotsPlusParams);
    }
}

