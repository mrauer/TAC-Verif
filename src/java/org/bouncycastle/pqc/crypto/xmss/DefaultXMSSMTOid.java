/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 */
package org.bouncycastle.pqc.crypto.xmss;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;

public final class DefaultXMSSMTOid
implements XMSSOid {
    public static final Map<String, DefaultXMSSMTOid> oidLookupTable;
    public final int oid;
    public final String stringRepresentation;

    public static {
        HashMap hashMap = new HashMap();
        GeneratedOutlineSupport.outline32((int)1, (String)"XMSSMT_SHA2_20/2_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-256", 32, 16, 67, 20, 2));
        GeneratedOutlineSupport.outline32((int)2, (String)"XMSSMT_SHA2_20/4_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-256", 32, 16, 67, 20, 4));
        GeneratedOutlineSupport.outline32((int)3, (String)"XMSSMT_SHA2_40/2_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-256", 32, 16, 67, 40, 2));
        GeneratedOutlineSupport.outline32((int)4, (String)"XMSSMT_SHA2_40/4_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-256", 32, 16, 67, 40, 2));
        GeneratedOutlineSupport.outline32((int)5, (String)"XMSSMT_SHA2_40/8_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-256", 32, 16, 67, 40, 4));
        GeneratedOutlineSupport.outline32((int)6, (String)"XMSSMT_SHA2_60/3_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-256", 32, 16, 67, 60, 8));
        GeneratedOutlineSupport.outline32((int)7, (String)"XMSSMT_SHA2_60/6_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-256", 32, 16, 67, 60, 6));
        GeneratedOutlineSupport.outline32((int)8, (String)"XMSSMT_SHA2_60/12_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-256", 32, 16, 67, 60, 12));
        GeneratedOutlineSupport.outline32((int)9, (String)"XMSSMT_SHA2_20/2_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-512", 64, 16, 131, 20, 2));
        GeneratedOutlineSupport.outline32((int)10, (String)"XMSSMT_SHA2_20/4_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-512", 64, 16, 131, 20, 4));
        GeneratedOutlineSupport.outline32((int)11, (String)"XMSSMT_SHA2_40/2_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-512", 64, 16, 131, 40, 2));
        GeneratedOutlineSupport.outline32((int)12, (String)"XMSSMT_SHA2_40/4_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-512", 64, 16, 131, 40, 4));
        GeneratedOutlineSupport.outline32((int)13, (String)"XMSSMT_SHA2_40/8_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-512", 64, 16, 131, 40, 8));
        GeneratedOutlineSupport.outline32((int)14, (String)"XMSSMT_SHA2_60/3_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-512", 64, 16, 131, 60, 3));
        GeneratedOutlineSupport.outline32((int)15, (String)"XMSSMT_SHA2_60/6_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-512", 64, 16, 131, 60, 6));
        GeneratedOutlineSupport.outline32((int)16, (String)"XMSSMT_SHA2_60/12_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHA-512", 64, 16, 131, 60, 12));
        GeneratedOutlineSupport.outline32((int)17, (String)"XMSSMT_SHAKE_20/2_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE128", 32, 16, 67, 20, 2));
        GeneratedOutlineSupport.outline32((int)18, (String)"XMSSMT_SHAKE_20/4_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE128", 32, 16, 67, 20, 4));
        GeneratedOutlineSupport.outline32((int)19, (String)"XMSSMT_SHAKE_40/2_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE128", 32, 16, 67, 40, 2));
        GeneratedOutlineSupport.outline32((int)20, (String)"XMSSMT_SHAKE_40/4_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE128", 32, 16, 67, 40, 4));
        GeneratedOutlineSupport.outline32((int)21, (String)"XMSSMT_SHAKE_40/8_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE128", 32, 16, 67, 40, 8));
        GeneratedOutlineSupport.outline32((int)22, (String)"XMSSMT_SHAKE_60/3_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE128", 32, 16, 67, 60, 3));
        GeneratedOutlineSupport.outline32((int)23, (String)"XMSSMT_SHAKE_60/6_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE128", 32, 16, 67, 60, 6));
        GeneratedOutlineSupport.outline32((int)24, (String)"XMSSMT_SHAKE_60/12_256", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE128", 32, 16, 67, 60, 12));
        GeneratedOutlineSupport.outline32((int)25, (String)"XMSSMT_SHAKE_20/2_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE256", 64, 16, 131, 20, 2));
        GeneratedOutlineSupport.outline32((int)26, (String)"XMSSMT_SHAKE_20/4_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE256", 64, 16, 131, 20, 4));
        GeneratedOutlineSupport.outline32((int)27, (String)"XMSSMT_SHAKE_40/2_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE256", 64, 16, 131, 40, 2));
        GeneratedOutlineSupport.outline32((int)28, (String)"XMSSMT_SHAKE_40/4_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE256", 64, 16, 131, 40, 4));
        GeneratedOutlineSupport.outline32((int)29, (String)"XMSSMT_SHAKE_40/8_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE256", 64, 16, 131, 40, 8));
        GeneratedOutlineSupport.outline32((int)30, (String)"XMSSMT_SHAKE_60/3_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE256", 64, 16, 131, 60, 3));
        GeneratedOutlineSupport.outline32((int)31, (String)"XMSSMT_SHAKE_60/6_512", (HashMap)hashMap, (String)DefaultXMSSMTOid.createKey("SHAKE256", 64, 16, 131, 60, 6));
        hashMap.put((Object)DefaultXMSSMTOid.createKey("SHAKE256", 64, 16, 131, 60, 12), (Object)new DefaultXMSSMTOid(32, "XMSSMT_SHAKE_60/12_512"));
        oidLookupTable = Collections.unmodifiableMap((Map)hashMap);
    }

    public DefaultXMSSMTOid(int n2, String string) {
        this.oid = n2;
        this.stringRepresentation = string;
    }

    public static String createKey(String string, int n2, int n3, int n4, int n5, int n6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("-");
        stringBuilder.append(n2);
        stringBuilder.append("-");
        stringBuilder.append(n3);
        stringBuilder.append("-");
        stringBuilder.append(n4);
        stringBuilder.append("-");
        stringBuilder.append(n5);
        stringBuilder.append("-");
        stringBuilder.append(n6);
        return stringBuilder.toString();
    }

    @Override
    public int getOid() {
        return this.oid;
    }

    public String toString() {
        return this.stringRepresentation;
    }
}

