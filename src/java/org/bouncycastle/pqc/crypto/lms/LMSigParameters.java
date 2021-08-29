/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.HashMap
 *  java.util.Map
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 */
package org.bouncycastle.pqc.crypto.lms;

import j$.util.Map$-CC;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

public class LMSigParameters {
    public static final LMSigParameters lms_sha256_n32_h10;
    public static final LMSigParameters lms_sha256_n32_h15;
    public static final LMSigParameters lms_sha256_n32_h20;
    public static final LMSigParameters lms_sha256_n32_h25;
    public static final LMSigParameters lms_sha256_n32_h5;
    public static Map<Object, LMSigParameters> paramBuilders;
    public final ASN1ObjectIdentifier digestOid;
    public final int h;
    public final int m;
    public final int type;

    public static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        lms_sha256_n32_h5 = new LMSigParameters(5, 32, 5, aSN1ObjectIdentifier);
        lms_sha256_n32_h10 = new LMSigParameters(6, 32, 10, aSN1ObjectIdentifier);
        lms_sha256_n32_h15 = new LMSigParameters(7, 32, 15, aSN1ObjectIdentifier);
        lms_sha256_n32_h20 = new LMSigParameters(8, 32, 20, aSN1ObjectIdentifier);
        lms_sha256_n32_h25 = new LMSigParameters(9, 32, 25, aSN1ObjectIdentifier);
        paramBuilders = new j$.util.Map(){
            {
                LMSigParameters lMSigParameters = LMSigParameters.lms_sha256_n32_h5;
                this.put((Object)lMSigParameters.type, (Object)lMSigParameters);
                LMSigParameters lMSigParameters2 = LMSigParameters.lms_sha256_n32_h10;
                this.put((Object)lMSigParameters2.type, (Object)lMSigParameters2);
                LMSigParameters lMSigParameters3 = LMSigParameters.lms_sha256_n32_h15;
                this.put((Object)lMSigParameters3.type, (Object)lMSigParameters3);
                LMSigParameters lMSigParameters4 = LMSigParameters.lms_sha256_n32_h20;
                this.put((Object)lMSigParameters4.type, (Object)lMSigParameters4);
                LMSigParameters lMSigParameters5 = LMSigParameters.lms_sha256_n32_h25;
                this.put((Object)lMSigParameters5.type, (Object)lMSigParameters5);
            }

            @Override
            public /* synthetic */ Object compute(Object object, BiFunction biFunction) {
                return Map$-CC.$default$compute((Map)this, object, biFunction);
            }

            @Override
            public /* synthetic */ Object computeIfAbsent(Object object, Function function) {
                return Map$-CC.$default$computeIfAbsent((Map)this, object, function);
            }

            @Override
            public /* synthetic */ Object computeIfPresent(Object object, BiFunction biFunction) {
                return Map$-CC.$default$computeIfPresent((Map)this, object, biFunction);
            }

            @Override
            public /* synthetic */ void forEach(BiConsumer biConsumer) {
                Map$-CC.$default$forEach((Map)this, biConsumer);
            }

            @Override
            public /* synthetic */ Object getOrDefault(Object object, Object object2) {
                return Map$-CC.$default$getOrDefault((Map)this, object, object2);
            }

            @Override
            public /* synthetic */ Object merge(Object object, Object object2, BiFunction biFunction) {
                return Map$-CC.$default$merge((Map)this, object, object2, biFunction);
            }

            @Override
            public /* synthetic */ Object putIfAbsent(Object object, Object object2) {
                return Map$-CC.$default$putIfAbsent((Map)this, object, object2);
            }

            @Override
            public /* synthetic */ boolean remove(Object object, Object object2) {
                return Map$-CC.$default$remove((Map)this, object, object2);
            }

            @Override
            public /* synthetic */ Object replace(Object object, Object object2) {
                return Map$-CC.$default$replace((Map)this, object, object2);
            }

            @Override
            public /* synthetic */ boolean replace(Object object, Object object2, Object object3) {
                return Map$-CC.$default$replace((Map)this, object, object2, object3);
            }

            @Override
            public /* synthetic */ void replaceAll(BiFunction biFunction) {
                Map$-CC.$default$replaceAll((Map)this, biFunction);
            }
        };
    }

    public LMSigParameters(int n2, int n3, int n4, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.type = n2;
        this.m = n3;
        this.h = n4;
        this.digestOid = aSN1ObjectIdentifier;
    }

    public static LMSigParameters getParametersForType(int n2) {
        return (LMSigParameters)paramBuilders.get((Object)n2);
    }

}

