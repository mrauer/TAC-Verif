/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.pqc.crypto.xmss.WOTSPlusOid
 */
package org.bouncycastle.pqc.crypto.xmss;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.xmss.DigestUtil;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlusOid;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;

public final class WOTSPlusParameters {
    public final int digestSize;
    public final int len;
    public final int len1;
    public final int len2;
    public final XMSSOid oid;
    public final ASN1ObjectIdentifier treeDigest;
    public final int winternitzParameter;

    public WOTSPlusParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        int n2;
        int n3;
        int n4;
        Objects.requireNonNull((Object)aSN1ObjectIdentifier, (String)"treeDigest == null");
        this.treeDigest = aSN1ObjectIdentifier;
        Digest digest = DigestUtil.getDigest(aSN1ObjectIdentifier);
        String string = digest.getAlgorithmName();
        int n5 = string.equals((Object)"SHAKE128") ? 32 : (string.equals((Object)"SHAKE256") ? 64 : digest.getDigestSize());
        this.digestSize = n5;
        this.winternitzParameter = 16;
        this.len1 = n4 = (int)Math.ceil((double)((double)(n5 * 8) / (double)Nat576.log2(16)));
        this.len2 = n2 = 1 + (int)Math.floor((double)(Nat576.log2(n4 * (16 - 1)) / Nat576.log2(16)));
        this.len = n3 = n4 + n2;
        String string2 = digest.getAlgorithmName();
        Objects.requireNonNull((Object)string2, (String)"algorithmName == null");
        WOTSPlusOid wOTSPlusOid = (WOTSPlusOid)WOTSPlusOid.oidLookupTable.get((Object)WOTSPlusOid.createKey((String)string2, (int)n5, (int)16, (int)n3));
        this.oid = wOTSPlusOid;
        if (wOTSPlusOid != null) {
            return;
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"cannot find OID for digest algorithm: ");
        stringBuilder.append(digest.getAlgorithmName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}

