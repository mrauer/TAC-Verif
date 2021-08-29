/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.Hashtable
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.x9.X9ECParameters
 *  org.bouncycastle.asn1.x9.X9ECPoint
 *  org.bouncycastle.crypto.params.ECDomainParameters
 *  org.bouncycastle.math.ec.ECCurve$Fp
 */
package org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WNafUtil;

/*
 * Exception performing whole class analysis.
 */
public class ECGOST3410NamedCurves {
    public static final Hashtable names;
    public static final Hashtable objIds;
    public static final Hashtable params;

    public static {
        Hashtable hashtable;
        Hashtable hashtable2;
        Hashtable hashtable3;
        objIds = hashtable = new Hashtable();
        params = hashtable3 = new Hashtable();
        names = hashtable2 = new Hashtable();
        BigInteger bigInteger = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        BigInteger bigInteger2 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        BigInteger bigInteger3 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316");
        BigInteger bigInteger4 = new BigInteger("166");
        BigInteger bigInteger5 = ECConstants.ONE;
        ECCurve.Fp fp = new /* Unavailable Anonymous Inner Class!! */;
        ECPoint eCPoint = fp.createPoint(new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612"));
        WNafUtil.configureBasepoint(eCPoint);
        ECDomainParameters eCDomainParameters = new ECDomainParameters((ECCurve)fp, eCPoint, bigInteger2, bigInteger5, null);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A;
        hashtable3.put((Object)aSN1ObjectIdentifier, (Object)eCDomainParameters);
        BigInteger bigInteger6 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        BigInteger bigInteger7 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        ECCurve.Fp fp2 = new /* Unavailable Anonymous Inner Class!! */;
        ECPoint eCPoint2 = fp2.createPoint(new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612"));
        WNafUtil.configureBasepoint(eCPoint2);
        ECDomainParameters eCDomainParameters2 = new ECDomainParameters((ECCurve)fp2, eCPoint2, bigInteger7, bigInteger5, null);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA;
        hashtable3.put((Object)aSN1ObjectIdentifier2, (Object)eCDomainParameters2);
        BigInteger bigInteger8 = new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823193");
        BigInteger bigInteger9 = new BigInteger("57896044618658097711785492504343953927102133160255826820068844496087732066703");
        ECCurve.Fp fp3 = new /* Unavailable Anonymous Inner Class!! */;
        ECPoint eCPoint3 = fp3.createPoint(new BigInteger("1"), new BigInteger("28792665814854611296992347458380284135028636778229113005756334730996303888124"));
        WNafUtil.configureBasepoint(eCPoint3);
        ECDomainParameters eCDomainParameters3 = new ECDomainParameters((ECCurve)fp3, eCPoint3, bigInteger9, bigInteger5, null);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B;
        hashtable3.put((Object)aSN1ObjectIdentifier3, (Object)eCDomainParameters3);
        BigInteger bigInteger10 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        BigInteger bigInteger11 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        ECCurve.Fp fp4 = new /* Unavailable Anonymous Inner Class!! */;
        ECPoint eCPoint4 = fp4.createPoint(new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247"));
        WNafUtil.configureBasepoint(eCPoint4);
        ECDomainParameters eCDomainParameters4 = new ECDomainParameters((ECCurve)fp4, eCPoint4, bigInteger11, bigInteger5, null);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB;
        hashtable3.put((Object)aSN1ObjectIdentifier4, (Object)eCDomainParameters4);
        BigInteger bigInteger12 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        BigInteger bigInteger13 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        ECCurve.Fp fp5 = new /* Unavailable Anonymous Inner Class!! */;
        ECPoint eCPoint5 = fp5.createPoint(new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247"));
        WNafUtil.configureBasepoint(eCPoint5);
        ECDomainParameters eCDomainParameters5 = new ECDomainParameters((ECCurve)fp5, eCPoint5, bigInteger13, bigInteger5, null);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C;
        hashtable3.put((Object)aSN1ObjectIdentifier5, (Object)eCDomainParameters5);
        BigInteger bigInteger14 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFD97", 16);
        BigInteger bigInteger15 = new BigInteger("400000000000000000000000000000000FD8CDDFC87B6635C115AF556C360C67", 16);
        BigInteger bigInteger16 = new BigInteger("C2173F1513981673AF4892C23035A27CE25E2013BF95AA33B22C656F277E7335", 16);
        BigInteger bigInteger17 = new BigInteger("295F9BAE7428ED9CCC20E7C359A9D41A22FCCD9108E17BF7BA9337A6F8AE9513", 16);
        BigInteger bigInteger18 = ECConstants.FOUR;
        ECCurve.Fp fp6 = new /* Unavailable Anonymous Inner Class!! */;
        ECPoint eCPoint6 = fp6.createPoint(new BigInteger("91E38443A5E82C0D880923425712B2BB658B9196932E02C78B2582FE742DAA28", 16), new BigInteger("32879423AB1A0375895786C4BB46E9565FDE0B5344766740AF268ADB32322E5C", 16));
        WNafUtil.configureBasepoint(eCPoint6);
        ECDomainParameters eCDomainParameters6 = new ECDomainParameters((ECCurve)fp6, eCPoint6, bigInteger15, bigInteger18, null);
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetA;
        hashtable3.put((Object)aSN1ObjectIdentifier6, (Object)eCDomainParameters6);
        BigInteger bigInteger19 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC7", 16);
        BigInteger bigInteger20 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF27E69532F48D89116FF22B8D4E0560609B4B38ABFAD2B85DCACDB1411F10B275", 16);
        ECCurve.Fp fp7 = new /* Unavailable Anonymous Inner Class!! */;
        ECPoint eCPoint7 = fp7.createPoint(new BigInteger("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003"), new BigInteger("7503CFE87A836AE3A61B8816E25450E6CE5E1C93ACF1ABC1778064FDCBEFA921DF1626BE4FD036E93D75E6A50E3A41E98028FE5FC235F5B889A589CB5215F2A4", 16));
        WNafUtil.configureBasepoint(eCPoint7);
        ECDomainParameters eCDomainParameters7 = new ECDomainParameters((ECCurve)fp7, eCPoint7, bigInteger20, bigInteger5, null);
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetA;
        hashtable3.put((Object)aSN1ObjectIdentifier7, (Object)eCDomainParameters7);
        BigInteger bigInteger21 = new BigInteger("8000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006F", 16);
        BigInteger bigInteger22 = new BigInteger("800000000000000000000000000000000000000000000000000000000000000149A1EC142565A545ACFDB77BD9D40CFA8B996712101BEA0EC6346C54374F25BD", 16);
        ECCurve.Fp fp8 = new /* Unavailable Anonymous Inner Class!! */;
        ECPoint eCPoint8 = fp8.createPoint(new BigInteger("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002"), new BigInteger("1A8F7EDA389B094C2C071E3647A8940F3C123B697578C213BE6DD9E6C8EC7335DCB228FD1EDF4A39152CBCAAF8C0398828041055F94CEEEC7E21340780FE41BD", 16));
        WNafUtil.configureBasepoint(eCPoint8);
        ECDomainParameters eCDomainParameters8 = new ECDomainParameters((ECCurve)fp8, eCPoint8, bigInteger22, bigInteger5, null);
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetB;
        hashtable3.put((Object)aSN1ObjectIdentifier8, (Object)eCDomainParameters8);
        BigInteger bigInteger23 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC7", 16);
        BigInteger bigInteger24 = new BigInteger("3FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC98CDBA46506AB004C33A9FF5147502CC8EDA9E7A769A12694623CEF47F023ED", 16);
        ECCurve.Fp fp9 = new /* Unavailable Anonymous Inner Class!! */;
        ECPoint eCPoint9 = fp9.createPoint(new BigInteger("E2E31EDFC23DE7BDEBE241CE593EF5DE2295B7A9CBAEF021D385F7074CEA043AA27272A7AE602BF2A7B9033DB9ED3610C6FB85487EAE97AAC5BC7928C1950148", 16), new BigInteger("F5CE40D95B5EB899ABBCCFF5911CB8577939804D6527378B8C108C3D2090FF9BE18E2D33E3021ED2EF32D85822423B6304F726AA854BAE07D0396E9A9ADDC40F", 16));
        WNafUtil.configureBasepoint(eCPoint9);
        ECDomainParameters eCDomainParameters9 = new ECDomainParameters((ECCurve)fp9, eCPoint9, bigInteger24, bigInteger18, null);
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetC;
        hashtable3.put((Object)aSN1ObjectIdentifier9, (Object)eCDomainParameters9);
        hashtable.put((Object)"GostR3410-2001-CryptoPro-A", (Object)aSN1ObjectIdentifier);
        hashtable.put((Object)"GostR3410-2001-CryptoPro-B", (Object)aSN1ObjectIdentifier3);
        hashtable.put((Object)"GostR3410-2001-CryptoPro-C", (Object)aSN1ObjectIdentifier5);
        hashtable.put((Object)"GostR3410-2001-CryptoPro-XchA", (Object)aSN1ObjectIdentifier2);
        hashtable.put((Object)"GostR3410-2001-CryptoPro-XchB", (Object)aSN1ObjectIdentifier4);
        hashtable.put((Object)"Tc26-Gost-3410-12-256-paramSetA", (Object)aSN1ObjectIdentifier6);
        hashtable.put((Object)"Tc26-Gost-3410-12-512-paramSetA", (Object)aSN1ObjectIdentifier7);
        hashtable.put((Object)"Tc26-Gost-3410-12-512-paramSetB", (Object)aSN1ObjectIdentifier8);
        hashtable.put((Object)"Tc26-Gost-3410-12-512-paramSetC", (Object)aSN1ObjectIdentifier9);
        hashtable2.put((Object)aSN1ObjectIdentifier, (Object)"GostR3410-2001-CryptoPro-A");
        hashtable2.put((Object)aSN1ObjectIdentifier3, (Object)"GostR3410-2001-CryptoPro-B");
        hashtable2.put((Object)aSN1ObjectIdentifier5, (Object)"GostR3410-2001-CryptoPro-C");
        hashtable2.put((Object)aSN1ObjectIdentifier2, (Object)"GostR3410-2001-CryptoPro-XchA");
        hashtable2.put((Object)aSN1ObjectIdentifier4, (Object)"GostR3410-2001-CryptoPro-XchB");
        hashtable2.put((Object)aSN1ObjectIdentifier6, (Object)"Tc26-Gost-3410-12-256-paramSetA");
        hashtable2.put((Object)aSN1ObjectIdentifier7, (Object)"Tc26-Gost-3410-12-512-paramSetA");
        hashtable2.put((Object)aSN1ObjectIdentifier8, (Object)"Tc26-Gost-3410-12-512-paramSetB");
        hashtable2.put((Object)aSN1ObjectIdentifier9, (Object)"Tc26-Gost-3410-12-512-paramSetC");
    }

    public static X9ECParameters getByOIDX9(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        ECDomainParameters eCDomainParameters = (ECDomainParameters)params.get((Object)aSN1ObjectIdentifier);
        if (eCDomainParameters == null) {
            return null;
        }
        X9ECParameters x9ECParameters = new X9ECParameters(eCDomainParameters.curve, new X9ECPoint(eCDomainParameters.G, false), eCDomainParameters.n, eCDomainParameters.h, eCDomainParameters.getSeed());
        return x9ECParameters;
    }

    public static String getName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String)names.get((Object)aSN1ObjectIdentifier);
    }
}

