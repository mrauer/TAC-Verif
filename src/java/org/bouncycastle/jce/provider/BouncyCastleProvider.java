/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  j
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.InternalError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 *  java.security.Provider
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Set
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 */
package org.bouncycastle.jce.provider;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.R;
import j$.util.Map$-CC;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.BouncyCastleProviderConfiguration;

public final class BouncyCastleProvider
extends Provider
implements ConfigurableProvider {
    public static final String[] ASYMMETRIC_CIPHERS;
    public static final String[] ASYMMETRIC_GENERIC;
    public static final ProviderConfiguration CONFIGURATION;
    public static final String[] DIGESTS;
    public static final String[] KEYSTORES;
    public static final String[] SECURE_RANDOMS;
    public static final String[] SYMMETRIC_CIPHERS;
    public static final String[] SYMMETRIC_GENERIC;
    public static final String[] SYMMETRIC_MACS;
    public static final Map keyInfoConverters;
    public static final Class revChkClass;

    public static {
        CONFIGURATION = new BouncyCastleProviderConfiguration();
        keyInfoConverters = new HashMap();
        revChkClass = R.style.loadClass(BouncyCastleProvider.class, (String)"java.security.cert.PKIXRevocationChecker");
        SYMMETRIC_GENERIC = new String[]{"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT"};
        SYMMETRIC_MACS = new String[]{"SipHash", "SipHash128", "Poly1305"};
        SYMMETRIC_CIPHERS = new String[]{"AES", "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624", "GOST3412_2015", "Zuc"};
        ASYMMETRIC_GENERIC = new String[]{"X509", "IES", "COMPOSITE"};
        ASYMMETRIC_CIPHERS = new String[]{"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM", "EdEC"};
        DIGESTS = new String[]{"GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564", "Haraka"};
        KEYSTORES = new String[]{"BC", "BCFKS", "PKCS12"};
        SECURE_RANDOMS = new String[]{"DRBG"};
    }

    public BouncyCastleProvider() {
        super("BC", 1.68, "BouncyCastle Security Provider v1.68");
        AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction(this){
            public final /* synthetic */ BouncyCastleProvider this$0;
            {
                this.this$0 = bouncyCastleProvider;
            }

            public Object run() {
                String string;
                String string2;
                BouncyCastleProvider bouncyCastleProvider = this.this$0;
                bouncyCastleProvider.loadAlgorithms("org.bouncycastle.jcajce.provider.digest.", BouncyCastleProvider.DIGESTS);
                bouncyCastleProvider.loadAlgorithms("org.bouncycastle.jcajce.provider.symmetric.", BouncyCastleProvider.SYMMETRIC_GENERIC);
                bouncyCastleProvider.loadAlgorithms("org.bouncycastle.jcajce.provider.symmetric.", BouncyCastleProvider.SYMMETRIC_MACS);
                bouncyCastleProvider.loadAlgorithms("org.bouncycastle.jcajce.provider.symmetric.", BouncyCastleProvider.SYMMETRIC_CIPHERS);
                bouncyCastleProvider.loadAlgorithms("org.bouncycastle.jcajce.provider.asymmetric.", BouncyCastleProvider.ASYMMETRIC_GENERIC);
                bouncyCastleProvider.loadAlgorithms("org.bouncycastle.jcajce.provider.asymmetric.", BouncyCastleProvider.ASYMMETRIC_CIPHERS);
                bouncyCastleProvider.loadAlgorithms("org.bouncycastle.jcajce.provider.keystore.", BouncyCastleProvider.KEYSTORES);
                bouncyCastleProvider.loadAlgorithms("org.bouncycastle.jcajce.provider.drbg.", BouncyCastleProvider.SECURE_RANDOMS);
                bouncyCastleProvider.addKeyInfoConverter(org.bouncycastle.pqc.asn1.PQCObjectIdentifiers.sphincs256, new org.bouncycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyFactorySpi());
                bouncyCastleProvider.addKeyInfoConverter(org.bouncycastle.pqc.asn1.PQCObjectIdentifiers.newHope, new org.bouncycastle.pqc.jcajce.provider.newhope.NHKeyFactorySpi());
                bouncyCastleProvider.addKeyInfoConverter(org.bouncycastle.pqc.asn1.PQCObjectIdentifiers.xmss, new org.bouncycastle.pqc.jcajce.provider.xmss.XMSSKeyFactorySpi());
                bouncyCastleProvider.addKeyInfoConverter(org.bouncycastle.asn1.isara.IsaraObjectIdentifiers.id_alg_xmss, new org.bouncycastle.pqc.jcajce.provider.xmss.XMSSKeyFactorySpi());
                bouncyCastleProvider.addKeyInfoConverter(org.bouncycastle.pqc.asn1.PQCObjectIdentifiers.xmss_mt, new org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTKeyFactorySpi());
                bouncyCastleProvider.addKeyInfoConverter(org.bouncycastle.asn1.isara.IsaraObjectIdentifiers.id_alg_xmssmt, new org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTKeyFactorySpi());
                bouncyCastleProvider.addKeyInfoConverter(org.bouncycastle.pqc.asn1.PQCObjectIdentifiers.mcEliece, new org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceKeyFactorySpi());
                bouncyCastleProvider.addKeyInfoConverter(org.bouncycastle.pqc.asn1.PQCObjectIdentifiers.mcElieceCca2, new org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi());
                bouncyCastleProvider.addKeyInfoConverter(org.bouncycastle.pqc.asn1.PQCObjectIdentifiers.rainbow, new org.bouncycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi());
                bouncyCastleProvider.addKeyInfoConverter(org.bouncycastle.pqc.asn1.PQCObjectIdentifiers.qTESLA_p_I, new org.bouncycastle.pqc.jcajce.provider.qtesla.QTESLAKeyFactorySpi());
                bouncyCastleProvider.addKeyInfoConverter(org.bouncycastle.pqc.asn1.PQCObjectIdentifiers.qTESLA_p_III, new org.bouncycastle.pqc.jcajce.provider.qtesla.QTESLAKeyFactorySpi());
                bouncyCastleProvider.addKeyInfoConverter(org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.id_alg_hss_lms_hashsig, new org.bouncycastle.pqc.jcajce.provider.lms.LMSKeyFactorySpi());
                bouncyCastleProvider.put((Object)"X509Store.CERTIFICATE/COLLECTION", (Object)"org.bouncycastle.jce.provider.X509StoreCertCollection");
                bouncyCastleProvider.put((Object)"X509Store.ATTRIBUTECERTIFICATE/COLLECTION", (Object)"org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
                bouncyCastleProvider.put((Object)"X509Store.CRL/COLLECTION", (Object)"org.bouncycastle.jce.provider.X509StoreCRLCollection");
                bouncyCastleProvider.put((Object)"X509Store.CERTIFICATEPAIR/COLLECTION", (Object)"org.bouncycastle.jce.provider.X509StoreCertPairCollection");
                bouncyCastleProvider.put((Object)"X509Store.CERTIFICATE/LDAP", (Object)"org.bouncycastle.jce.provider.X509StoreLDAPCerts");
                bouncyCastleProvider.put((Object)"X509Store.CRL/LDAP", (Object)"org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
                bouncyCastleProvider.put((Object)"X509Store.ATTRIBUTECERTIFICATE/LDAP", (Object)"org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
                bouncyCastleProvider.put((Object)"X509Store.CERTIFICATEPAIR/LDAP", (Object)"org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
                bouncyCastleProvider.put((Object)"X509StreamParser.CERTIFICATE", (Object)"org.bouncycastle.jce.provider.X509CertParser");
                bouncyCastleProvider.put((Object)"X509StreamParser.ATTRIBUTECERTIFICATE", (Object)"org.bouncycastle.jce.provider.X509AttrCertParser");
                bouncyCastleProvider.put((Object)"X509StreamParser.CRL", (Object)"org.bouncycastle.jce.provider.X509CRLParser");
                bouncyCastleProvider.put((Object)"X509StreamParser.CERTIFICATEPAIR", (Object)"org.bouncycastle.jce.provider.X509CertPairParser");
                bouncyCastleProvider.put((Object)"Cipher.BROKENPBEWITHMD5ANDDES", (Object)"org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
                bouncyCastleProvider.put((Object)"Cipher.BROKENPBEWITHSHA1ANDDES", (Object)"org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
                bouncyCastleProvider.put((Object)"Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", (Object)"org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
                Class class_ = BouncyCastleProvider.revChkClass;
                bouncyCastleProvider.put((Object)"CertPathValidator.RFC3281", (Object)"org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
                bouncyCastleProvider.put((Object)"CertPathBuilder.RFC3281", (Object)"org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
                if (class_ != null) {
                    string = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8";
                    bouncyCastleProvider.put((Object)"CertPathValidator.RFC3280", (Object)string);
                    string2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi_8";
                } else {
                    string = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi";
                    bouncyCastleProvider.put((Object)"CertPathValidator.RFC3280", (Object)string);
                    string2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi";
                }
                bouncyCastleProvider.put((Object)"CertPathBuilder.RFC3280", (Object)string2);
                bouncyCastleProvider.put((Object)"CertPathValidator.PKIX", (Object)string);
                bouncyCastleProvider.put((Object)"CertPathBuilder.PKIX", (Object)string2);
                bouncyCastleProvider.put((Object)"CertStore.Collection", (Object)"org.bouncycastle.jce.provider.CertStoreCollectionSpi");
                bouncyCastleProvider.put((Object)"CertStore.LDAP", (Object)"org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
                bouncyCastleProvider.put((Object)"CertStore.Multi", (Object)"org.bouncycastle.jce.provider.MultiCertStoreSpi");
                bouncyCastleProvider.put((Object)"Alg.Alias.CertStore.X509LDAP", (Object)"LDAP");
                return null;
            }
        });
    }

    @Override
    public void addAlgorithm(String string, String string2) {
        if (!this.containsKey((Object)string)) {
            this.put((Object)string, (Object)string2);
            return;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline19((String)"duplicate provider key (", (String)string, (String)") found"));
    }

    @Override
    public void addAlgorithm(String string, ASN1ObjectIdentifier aSN1ObjectIdentifier, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(".");
        stringBuilder.append((Object)aSN1ObjectIdentifier);
        this.addAlgorithm(stringBuilder.toString(), string2);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string);
        stringBuilder2.append(".OID.");
        stringBuilder2.append((Object)aSN1ObjectIdentifier);
        this.addAlgorithm(stringBuilder2.toString(), string2);
    }

    @Override
    public void addAttributes(String string, Map<String, String> map) {
        for (String string2 : map.keySet()) {
            String string3 = GeneratedOutlineSupport.outline19((String)string, (String)" ", (String)string2);
            if (!this.containsKey((Object)string3)) {
                this.put((Object)string3, map.get((Object)string2));
                continue;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline19((String)"duplicate provider attribute key (", (String)string3, (String)") found"));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void addKeyInfoConverter(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        Map map;
        Map map2 = map = keyInfoConverters;
        synchronized (map2) {
            map.put((Object)aSN1ObjectIdentifier, (Object)asymmetricKeyInfoConverter);
            return;
        }
    }

    public /* synthetic */ Object compute(Object object, j.BiFunction biFunction) {
        return Map$-CC.$default$compute((Map)this, object, biFunction);
    }

    public /* synthetic */ Object computeIfAbsent(Object object, j.Function function) {
        return Map$-CC.$default$computeIfAbsent((Map)this, object, function);
    }

    public /* synthetic */ Object computeIfPresent(Object object, j.BiFunction biFunction) {
        return Map$-CC.$default$computeIfPresent((Map)this, object, biFunction);
    }

    public /* synthetic */ void forEach(j.BiConsumer biConsumer) {
        Map$-CC.$default$forEach((Map)this, biConsumer);
    }

    public /* synthetic */ Object getOrDefault(Object object, Object object2) {
        return Map$-CC.$default$getOrDefault((Map)this, object, object2);
    }

    public final void loadAlgorithms(String string, String[] arrstring) {
        for (int i2 = 0; i2 != arrstring.length; ++i2) {
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)string);
            stringBuilder.append(arrstring[i2]);
            stringBuilder.append("$Mappings");
            Class class_ = R.style.loadClass(BouncyCastleProvider.class, (String)stringBuilder.toString());
            if (class_ == null) continue;
            try {
                ((AlgorithmProvider)class_.newInstance()).configure(this);
                continue;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder2 = GeneratedOutlineSupport.outline26((String)"cannot create instance of ", (String)string);
                stringBuilder2.append(arrstring[i2]);
                stringBuilder2.append("$Mappings : ");
                stringBuilder2.append((Object)exception);
                throw new InternalError(stringBuilder2.toString());
            }
        }
    }

    public /* synthetic */ Object merge(Object object, Object object2, j.BiFunction biFunction) {
        return Map$-CC.$default$merge((Map)this, object, object2, biFunction);
    }

    public /* synthetic */ Object putIfAbsent(Object object, Object object2) {
        return Map$-CC.$default$putIfAbsent((Map)this, object, object2);
    }

    public /* synthetic */ boolean remove(Object object, Object object2) {
        return Map$-CC.$default$remove((Map)this, object, object2);
    }

    public /* synthetic */ Object replace(Object object, Object object2) {
        return Map$-CC.$default$replace((Map)this, object, object2);
    }

    public /* synthetic */ boolean replace(Object object, Object object2, Object object3) {
        return Map$-CC.$default$replace((Map)this, object, object2, object3);
    }

    public /* synthetic */ void replaceAll(j.BiFunction biFunction) {
        Map$-CC.$default$replaceAll((Map)this, biFunction);
    }
}

