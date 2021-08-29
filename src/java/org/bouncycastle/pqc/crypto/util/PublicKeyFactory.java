/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.x509.AlgorithmIdentifier
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 *  org.bouncycastle.pqc.crypto.util.PublicKeyFactory$LMSConverter
 *  org.bouncycastle.pqc.crypto.util.PublicKeyFactory$NHConverter
 *  org.bouncycastle.pqc.crypto.util.PublicKeyFactory$QTeslaConverter
 *  org.bouncycastle.pqc.crypto.util.PublicKeyFactory$SPHINCSConverter
 *  org.bouncycastle.pqc.crypto.util.PublicKeyFactory$XMSSConverter
 *  org.bouncycastle.pqc.crypto.util.PublicKeyFactory$XMSSMTConverter
 */
package org.bouncycastle.pqc.crypto.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;

/*
 * Exception performing whole class analysis.
 */
public class PublicKeyFactory {
    public static Map converters;

    public static {
        HashMap hashMap = new HashMap();
        converters = hashMap;
        hashMap.put((Object)PQCObjectIdentifiers.qTESLA_p_I, (Object)new /* Unavailable Anonymous Inner Class!! */);
        converters.put((Object)PQCObjectIdentifiers.qTESLA_p_III, (Object)new /* Unavailable Anonymous Inner Class!! */);
        converters.put((Object)PQCObjectIdentifiers.sphincs256, (Object)new /* Unavailable Anonymous Inner Class!! */);
        converters.put((Object)PQCObjectIdentifiers.newHope, (Object)new /* Unavailable Anonymous Inner Class!! */);
        converters.put((Object)PQCObjectIdentifiers.xmss, (Object)new /* Unavailable Anonymous Inner Class!! */);
        converters.put((Object)PQCObjectIdentifiers.xmss_mt, (Object)new /* Unavailable Anonymous Inner Class!! */);
        converters.put((Object)IsaraObjectIdentifiers.id_alg_xmss, (Object)new /* Unavailable Anonymous Inner Class!! */);
        converters.put((Object)IsaraObjectIdentifiers.id_alg_xmssmt, (Object)new /* Unavailable Anonymous Inner Class!! */);
        converters.put((Object)PKCSObjectIdentifiers.id_alg_hss_lms_hashsig, (Object)new /* Unavailable Anonymous Inner Class!! */);
    }

    public static AsymmetricKeyParameter createKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        AlgorithmIdentifier algorithmIdentifier = subjectPublicKeyInfo.algId;
        SubjectPublicKeyInfoConverter subjectPublicKeyInfoConverter = (SubjectPublicKeyInfoConverter)converters.get((Object)algorithmIdentifier.algorithm);
        if (subjectPublicKeyInfoConverter != null) {
            return subjectPublicKeyInfoConverter.getPublicKeyParameters(subjectPublicKeyInfo, null);
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"algorithm identifier in public key not recognised: ");
        stringBuilder.append((Object)algorithmIdentifier.algorithm);
        throw new IOException(stringBuilder.toString());
    }

    public static abstract class SubjectPublicKeyInfoConverter {
        public SubjectPublicKeyInfoConverter() {
        }

        public SubjectPublicKeyInfoConverter(1 var1_1) {
        }

        public abstract AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo var1, Object var2) throws IOException;
    }

}

