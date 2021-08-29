/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.pqc.crypto.xmss.DefaultXMSSMTOid
 */
package org.bouncycastle.pqc.crypto.xmss;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.pqc.crypto.xmss.DefaultXMSSMTOid;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlusParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;
import org.bouncycastle.pqc.crypto.xmss.XMSSParameters;

public final class XMSSMTParameters {
    public static final Map<Integer, XMSSMTParameters> paramsLookupTable;
    public final int height;
    public final int layers;
    public final XMSSOid oid;
    public final XMSSParameters xmssParams;

    public static {
        HashMap hashMap = new HashMap();
        Integer n2 = 1;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        hashMap.put((Object)n2, (Object)new XMSSMTParameters(20, 2, aSN1ObjectIdentifier));
        GeneratedOutlineSupport.outline31((int)20, (int)4, (ASN1ObjectIdentifier)aSN1ObjectIdentifier, (HashMap)hashMap, (Integer)2);
        GeneratedOutlineSupport.outline31((int)40, (int)2, (ASN1ObjectIdentifier)aSN1ObjectIdentifier, (HashMap)hashMap, (Integer)3);
        GeneratedOutlineSupport.outline31((int)40, (int)4, (ASN1ObjectIdentifier)aSN1ObjectIdentifier, (HashMap)hashMap, (Integer)4);
        GeneratedOutlineSupport.outline31((int)40, (int)8, (ASN1ObjectIdentifier)aSN1ObjectIdentifier, (HashMap)hashMap, (Integer)5);
        GeneratedOutlineSupport.outline31((int)60, (int)3, (ASN1ObjectIdentifier)aSN1ObjectIdentifier, (HashMap)hashMap, (Integer)6);
        GeneratedOutlineSupport.outline31((int)60, (int)6, (ASN1ObjectIdentifier)aSN1ObjectIdentifier, (HashMap)hashMap, (Integer)7);
        GeneratedOutlineSupport.outline31((int)60, (int)12, (ASN1ObjectIdentifier)aSN1ObjectIdentifier, (HashMap)hashMap, (Integer)8);
        Integer n3 = 9;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_sha512;
        hashMap.put((Object)n3, (Object)new XMSSMTParameters(20, 2, aSN1ObjectIdentifier2));
        GeneratedOutlineSupport.outline31((int)20, (int)4, (ASN1ObjectIdentifier)aSN1ObjectIdentifier2, (HashMap)hashMap, (Integer)10);
        GeneratedOutlineSupport.outline31((int)40, (int)2, (ASN1ObjectIdentifier)aSN1ObjectIdentifier2, (HashMap)hashMap, (Integer)11);
        GeneratedOutlineSupport.outline31((int)40, (int)4, (ASN1ObjectIdentifier)aSN1ObjectIdentifier2, (HashMap)hashMap, (Integer)12);
        GeneratedOutlineSupport.outline31((int)40, (int)8, (ASN1ObjectIdentifier)aSN1ObjectIdentifier2, (HashMap)hashMap, (Integer)13);
        GeneratedOutlineSupport.outline31((int)60, (int)3, (ASN1ObjectIdentifier)aSN1ObjectIdentifier2, (HashMap)hashMap, (Integer)14);
        GeneratedOutlineSupport.outline31((int)60, (int)6, (ASN1ObjectIdentifier)aSN1ObjectIdentifier2, (HashMap)hashMap, (Integer)15);
        GeneratedOutlineSupport.outline31((int)60, (int)12, (ASN1ObjectIdentifier)aSN1ObjectIdentifier2, (HashMap)hashMap, (Integer)16);
        Integer n4 = 17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_shake128;
        hashMap.put((Object)n4, (Object)new XMSSMTParameters(20, 2, aSN1ObjectIdentifier3));
        GeneratedOutlineSupport.outline31((int)20, (int)4, (ASN1ObjectIdentifier)aSN1ObjectIdentifier3, (HashMap)hashMap, (Integer)18);
        GeneratedOutlineSupport.outline31((int)40, (int)2, (ASN1ObjectIdentifier)aSN1ObjectIdentifier3, (HashMap)hashMap, (Integer)19);
        GeneratedOutlineSupport.outline31((int)40, (int)4, (ASN1ObjectIdentifier)aSN1ObjectIdentifier3, (HashMap)hashMap, (Integer)20);
        GeneratedOutlineSupport.outline31((int)40, (int)8, (ASN1ObjectIdentifier)aSN1ObjectIdentifier3, (HashMap)hashMap, (Integer)21);
        GeneratedOutlineSupport.outline31((int)60, (int)3, (ASN1ObjectIdentifier)aSN1ObjectIdentifier3, (HashMap)hashMap, (Integer)22);
        GeneratedOutlineSupport.outline31((int)60, (int)6, (ASN1ObjectIdentifier)aSN1ObjectIdentifier3, (HashMap)hashMap, (Integer)23);
        GeneratedOutlineSupport.outline31((int)60, (int)12, (ASN1ObjectIdentifier)aSN1ObjectIdentifier3, (HashMap)hashMap, (Integer)24);
        Integer n5 = 25;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_shake256;
        hashMap.put((Object)n5, (Object)new XMSSMTParameters(20, 2, aSN1ObjectIdentifier4));
        GeneratedOutlineSupport.outline31((int)20, (int)4, (ASN1ObjectIdentifier)aSN1ObjectIdentifier4, (HashMap)hashMap, (Integer)26);
        GeneratedOutlineSupport.outline31((int)40, (int)2, (ASN1ObjectIdentifier)aSN1ObjectIdentifier4, (HashMap)hashMap, (Integer)27);
        GeneratedOutlineSupport.outline31((int)40, (int)4, (ASN1ObjectIdentifier)aSN1ObjectIdentifier4, (HashMap)hashMap, (Integer)28);
        GeneratedOutlineSupport.outline31((int)40, (int)8, (ASN1ObjectIdentifier)aSN1ObjectIdentifier4, (HashMap)hashMap, (Integer)29);
        GeneratedOutlineSupport.outline31((int)60, (int)3, (ASN1ObjectIdentifier)aSN1ObjectIdentifier4, (HashMap)hashMap, (Integer)30);
        GeneratedOutlineSupport.outline31((int)60, (int)6, (ASN1ObjectIdentifier)aSN1ObjectIdentifier4, (HashMap)hashMap, (Integer)31);
        GeneratedOutlineSupport.outline31((int)60, (int)12, (ASN1ObjectIdentifier)aSN1ObjectIdentifier4, (HashMap)hashMap, (Integer)32);
        paramsLookupTable = Collections.unmodifiableMap((Map)hashMap);
    }

    public XMSSMTParameters(int n2, int n3, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.height = n2;
        this.layers = n3;
        if (n2 >= 2) {
            if (n2 % n3 == 0) {
                int n4 = n2 / n3;
                if (n4 != 1) {
                    XMSSParameters xMSSParameters;
                    this.xmssParams = xMSSParameters = new XMSSParameters(n4, aSN1ObjectIdentifier);
                    String string = xMSSParameters.treeDigest;
                    int n5 = xMSSParameters.treeDigestSize;
                    int n6 = xMSSParameters.winternitzParameter;
                    int n7 = xMSSParameters.wotsPlusParams.len;
                    Objects.requireNonNull((Object)string, (String)"algorithmName == null");
                    this.oid = (DefaultXMSSMTOid)DefaultXMSSMTOid.oidLookupTable.get((Object)DefaultXMSSMTOid.createKey((String)string, (int)n5, (int)n6, (int)n7, (int)n2, (int)n3));
                    return;
                }
                throw new IllegalArgumentException("height / layers must be greater than 1");
            }
            throw new IllegalArgumentException("layers must divide totalHeight without remainder");
        }
        throw new IllegalArgumentException("totalHeight must be > 1");
    }
}

