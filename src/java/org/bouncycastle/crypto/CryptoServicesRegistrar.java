/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.math.BigInteger
 *  java.security.SecureRandom
 *  java.util.HashMap
 *  java.util.Map
 */
package org.bouncycastle.crypto;

import j$.util.DesugarCollections;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.CryptoServicesPermission;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAValidationParameters;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public final class CryptoServicesRegistrar {
    public static final Object cacheLock;
    public static SecureRandom defaultSecureRandom;
    public static final Map<String, Object[]> globalProperties;
    public static final ThreadLocal<Map<String, Object[]>> threadProperties;

    public static {
        new CryptoServicesPermission("globalConfig");
        new CryptoServicesPermission("threadLocalConfig");
        new CryptoServicesPermission("defaultRandomConfig");
        threadProperties = new ThreadLocal();
        globalProperties = DesugarCollections.synchronizedMap((Map)new HashMap());
        cacheLock = new Object();
        DSAParameters dSAParameters = new DSAParameters(new BigInteger("fca682ce8e12caba26efccf7110e526db078b05edecbcd1eb4a208f3ae1617ae01f35b91a47e6df63413c5e12ed0899bcd132acd50d99151bdc43ee737592e17", 16), new BigInteger("962eddcc369cba8ebb260ee6b6a126d9346e38c5", 16), new BigInteger("678471b27a9cf44ee91a49c5147db1a9aaf244f05a434d6486931d2d14271b9e35030b71fd73da179069b32e2935630e1c2062354d0da20a6c416e50be794ca4", 16), new DSAValidationParameters(Hex.decodeStrict("b869c82b35d70e1b1ff91b28e37a62ecdc34409b"), 123));
        DSAParameters dSAParameters2 = new DSAParameters(new BigInteger("e9e642599d355f37c97ffd3567120b8e25c9cd43e927b3a9670fbec5d890141922d2c3b3ad2480093799869d1e846aab49fab0ad26d2ce6a22219d470bce7d777d4a21fbe9c270b57f607002f3cef8393694cf45ee3688c11a8c56ab127a3daf", 16), new BigInteger("9cdbd84c9f1ac2f38d0f80f42ab952e7338bf511", 16), new BigInteger("30470ad5a005fb14ce2d9dcd87e38bc7d1b1c5facbaecbe95f190aa7a31d23c4dbbcbe06174544401a5b2c020965d8c2bd2171d3668445771f74ba084d2029d83c1c158547f3a9f1a2715be23d51ae4d3e5a1f6a7064f316933a346d3f529252", 16), new DSAValidationParameters(Hex.decodeStrict("77d0f8c4dad15eb8c4f2f8d6726cefd96d5bb399"), 263));
        DSAParameters dSAParameters3 = new DSAParameters(new BigInteger("fd7f53811d75122952df4a9c2eece4e7f611b7523cef4400c31e3f80b6512669455d402251fb593d8d58fabfc5f5ba30f6cb9b556cd7813b801d346ff26660b76b9950a5a49f9fe8047b1022c24fbba9d7feb7c61bf83b57e7c6a8a6150f04fb83f6d3c51ec3023554135a169132f675f3ae2b61d72aeff22203199dd14801c7", 16), new BigInteger("9760508f15230bccb292b982a2eb840bf0581cf5", 16), new BigInteger("f7e1a085d69b3ddecbbcab5c36b857b97994afbbfa3aea82f9574c0b3d0782675159578ebad4594fe67107108180b449167123e84c281613b7cf09328cc8a6e13c167a8b547c8d28e0a3ae1e2bb3a675916ea37f0bfa213562f1fb627a01243bcca4f1bea8519089a883dfe15ae59f06928b665e807b552564014c3bfecf492a", 16), new DSAValidationParameters(Hex.decodeStrict("8d5155894229d5e689ee01e6018a237e2cae64cd"), 92));
        DSAParameters dSAParameters4 = new DSAParameters(new BigInteger("95475cf5d93e596c3fcd1d902add02f427f5f3c7210313bb45fb4d5bb2e5fe1cbd678cd4bbdd84c9836be1f31c0777725aeb6c2fc38b85f48076fa76bcd8146cc89a6fb2f706dd719898c2083dc8d896f84062e2c9c94d137b054a8d8096adb8d51952398eeca852a0af12df83e475aa65d4ec0c38a9560d5661186ff98b9fc9eb60eee8b030376b236bc73be3acdbd74fd61c1d2475fa3077b8f080467881ff7e1ca56fee066d79506ade51edbb5443a563927dbc4ba520086746175c8885925ebc64c6147906773496990cb714ec667304e261faee33b3cbdf008e0c3fa90650d97d3909c9275bf4ac86ffcb3d03e6dfc8ada5934242dd6d3bcca2a406cb0b", 16), new BigInteger("f8183668ba5fc5bb06b5981e6d8b795d30b8978d43ca0ec572e37e09939a9773", 16), new BigInteger("42debb9da5b3d88cc956e08787ec3f3a09bba5f48b889a74aaf53174aa0fbe7e3c5b8fcd7a53bef563b0e98560328960a9517f4014d3325fc7962bf1e049370d76d1314a76137e792f3f0db859d095e4a5b932024f079ecf2ef09c797452b0770e1350782ed57ddf794979dcef23cb96f183061965c4ebc93c9c71c56b925955a75f94cccf1449ac43d586d0beee43251b0b2287349d68de0d144403f13e802f4146d882e057af19b6f6275c6676c8fa0e3ca2713a3257fd1b27d0639f695e347d8d1cf9ac819a26ca9b04cb0eb9b7b035988d15bbac65212a55239cfc7e58fae38d7250ab9991ffbc97134025fe8ce04c4399ad96569be91a546f4978693c7a", 16), new DSAValidationParameters(Hex.decodeStrict("b0b4417601b59cbc9d8ac8f935cadaec4f5fbb2f23785609ae466748d9b5a536"), 497));
        CryptoServicesRegistrar.localSetGlobalProperty(Property.DSA_DEFAULT_PARAMS, dSAParameters, dSAParameters2, dSAParameters3, dSAParameters4);
        Property property = Property.DH_DEFAULT_PARAMS;
        DHParameters[] arrdHParameters = new DHParameters[]{CryptoServicesRegistrar.toDH(dSAParameters), CryptoServicesRegistrar.toDH(dSAParameters2), CryptoServicesRegistrar.toDH(dSAParameters3), CryptoServicesRegistrar.toDH(dSAParameters4)};
        CryptoServicesRegistrar.localSetGlobalProperty(property, arrdHParameters);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static SecureRandom getSecureRandom() {
        Object object;
        Object object2 = object = cacheLock;
        synchronized (object2) {
            SecureRandom secureRandom = defaultSecureRandom;
            if (secureRandom != null) {
                return secureRandom;
            }
        }
        SecureRandom secureRandom = new SecureRandom();
        object2 = object;
        synchronized (object2) {
            if (defaultSecureRandom != null) return defaultSecureRandom;
            defaultSecureRandom = secureRandom;
            return defaultSecureRandom;
        }
    }

    public static /* varargs */ <T> void localSetGlobalProperty(Property property, T ... arrT) {
        if (property.type.isAssignableFrom(arrT[0].getClass())) {
            ThreadLocal<Map<String, Object[]>> threadLocal = threadProperties;
            Map map = (Map)threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set((Object)map);
            }
            map.put((Object)property.name, arrT);
            globalProperties.put((Object)property.name, arrT);
            return;
        }
        throw new IllegalArgumentException("Bad property value passed");
    }

    public static DHParameters toDH(DSAParameters dSAParameters) {
        int n2 = dSAParameters.p.bitLength();
        int n3 = n2 > 1024 ? (n2 <= 2048 ? 224 : (n2 <= 3072 ? 256 : (n2 <= 7680 ? 384 : 512))) : 160;
        int n4 = n3;
        DHParameters dHParameters = new DHParameters(dSAParameters.p, dSAParameters.g, dSAParameters.q, n4, 0, null, new DHValidationParameters(Nat576.clone(dSAParameters.validation.seed), dSAParameters.validation.counter));
        return dHParameters;
    }

    public static final class Property {
        public static final Property DH_DEFAULT_PARAMS = new Property("dhDefaultParams", DHParameters.class);
        public static final Property DSA_DEFAULT_PARAMS = new Property("dsaDefaultParams", DSAParameters.class);
        public final String name;
        public final Class type;

        public Property(String string, Class class_) {
            this.name = string;
            this.type = class_;
        }
    }

}

