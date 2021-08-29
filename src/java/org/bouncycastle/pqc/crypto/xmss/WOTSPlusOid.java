/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 */
package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;

public final class WOTSPlusOid
implements XMSSOid {
    public static final Map<String, WOTSPlusOid> oidLookupTable;
    public final int oid;
    public final String stringRepresentation;

    public static {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)WOTSPlusOid.createKey("SHA-256", 32, 16, 67), (Object)new WOTSPlusOid(16777217, "WOTSP_SHA2-256_W16"));
        hashMap.put((Object)WOTSPlusOid.createKey("SHA-512", 64, 16, 131), (Object)new WOTSPlusOid(33554434, "WOTSP_SHA2-512_W16"));
        hashMap.put((Object)WOTSPlusOid.createKey("SHAKE128", 32, 16, 67), (Object)new WOTSPlusOid(50331651, "WOTSP_SHAKE128_W16"));
        hashMap.put((Object)WOTSPlusOid.createKey("SHAKE256", 64, 16, 131), (Object)new WOTSPlusOid(67108868, "WOTSP_SHAKE256_W16"));
        oidLookupTable = Collections.unmodifiableMap((Map)hashMap);
    }

    public WOTSPlusOid(int n2, String string) {
        this.oid = n2;
        this.stringRepresentation = string;
    }

    public static String createKey(String string, int n2, int n3, int n4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("-");
        stringBuilder.append(n2);
        stringBuilder.append("-");
        stringBuilder.append(n3);
        stringBuilder.append("-");
        stringBuilder.append(n4);
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

