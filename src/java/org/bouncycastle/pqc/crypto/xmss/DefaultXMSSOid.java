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

public final class DefaultXMSSOid
implements XMSSOid {
    public static final Map<String, DefaultXMSSOid> oidLookupTable;
    public final int oid;
    public final String stringRepresentation;

    public static {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)DefaultXMSSOid.createKey("SHA-256", 32, 16, 67, 10), (Object)new DefaultXMSSOid(1, "XMSS_SHA2_10_256"));
        hashMap.put((Object)DefaultXMSSOid.createKey("SHA-256", 32, 16, 67, 16), (Object)new DefaultXMSSOid(2, "XMSS_SHA2_16_256"));
        hashMap.put((Object)DefaultXMSSOid.createKey("SHA-256", 32, 16, 67, 20), (Object)new DefaultXMSSOid(3, "XMSS_SHA2_20_256"));
        hashMap.put((Object)DefaultXMSSOid.createKey("SHA-512", 64, 16, 131, 10), (Object)new DefaultXMSSOid(4, "XMSS_SHA2_10_512"));
        hashMap.put((Object)DefaultXMSSOid.createKey("SHA-512", 64, 16, 131, 16), (Object)new DefaultXMSSOid(5, "XMSS_SHA2_16_512"));
        hashMap.put((Object)DefaultXMSSOid.createKey("SHA-512", 64, 16, 131, 20), (Object)new DefaultXMSSOid(6, "XMSS_SHA2_20_512"));
        hashMap.put((Object)DefaultXMSSOid.createKey("SHAKE128", 32, 16, 67, 10), (Object)new DefaultXMSSOid(7, "XMSS_SHAKE_10_256"));
        hashMap.put((Object)DefaultXMSSOid.createKey("SHAKE128", 32, 16, 67, 16), (Object)new DefaultXMSSOid(8, "XMSS_SHAKE_16_256"));
        hashMap.put((Object)DefaultXMSSOid.createKey("SHAKE128", 32, 16, 67, 20), (Object)new DefaultXMSSOid(9, "XMSS_SHAKE_20_256"));
        hashMap.put((Object)DefaultXMSSOid.createKey("SHAKE256", 64, 16, 131, 10), (Object)new DefaultXMSSOid(10, "XMSS_SHAKE_10_512"));
        hashMap.put((Object)DefaultXMSSOid.createKey("SHAKE256", 64, 16, 131, 16), (Object)new DefaultXMSSOid(11, "XMSS_SHAKE_16_512"));
        hashMap.put((Object)DefaultXMSSOid.createKey("SHAKE256", 64, 16, 131, 20), (Object)new DefaultXMSSOid(12, "XMSS_SHAKE_20_512"));
        oidLookupTable = Collections.unmodifiableMap((Map)hashMap);
    }

    public DefaultXMSSOid(int n2, String string) {
        this.oid = n2;
        this.stringRepresentation = string;
    }

    public static String createKey(String string, int n2, int n3, int n4, int n5) {
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

