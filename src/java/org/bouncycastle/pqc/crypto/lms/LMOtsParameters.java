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

public class LMOtsParameters {
    public static final LMOtsParameters sha256_n32_w1;
    public static final LMOtsParameters sha256_n32_w2;
    public static final LMOtsParameters sha256_n32_w4;
    public static final LMOtsParameters sha256_n32_w8;
    public static final Map<Object, LMOtsParameters> suppliers;
    public final ASN1ObjectIdentifier digestOID;
    public final int n;
    public final int p;
    public final int type;
    public final int w;

    public static {
        LMOtsParameters lMOtsParameters;
        LMOtsParameters lMOtsParameters2;
        LMOtsParameters lMOtsParameters3;
        LMOtsParameters lMOtsParameters4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        sha256_n32_w1 = lMOtsParameters3 = new LMOtsParameters(1, 32, 1, 265, 7, 8516, aSN1ObjectIdentifier);
        sha256_n32_w2 = lMOtsParameters = new LMOtsParameters(2, 32, 2, 133, 6, 4292, aSN1ObjectIdentifier);
        sha256_n32_w4 = lMOtsParameters2 = new LMOtsParameters(3, 32, 4, 67, 4, 2180, aSN1ObjectIdentifier);
        sha256_n32_w8 = lMOtsParameters4 = new LMOtsParameters(4, 32, 8, 34, 0, 1124, aSN1ObjectIdentifier);
        suppliers = new j$.util.Map(){
            {
                LMOtsParameters lMOtsParameters = LMOtsParameters.sha256_n32_w1;
                this.put((Object)lMOtsParameters.type, (Object)lMOtsParameters);
                LMOtsParameters lMOtsParameters2 = LMOtsParameters.sha256_n32_w2;
                this.put((Object)lMOtsParameters2.type, (Object)lMOtsParameters2);
                LMOtsParameters lMOtsParameters3 = LMOtsParameters.sha256_n32_w4;
                this.put((Object)lMOtsParameters3.type, (Object)lMOtsParameters3);
                LMOtsParameters lMOtsParameters4 = LMOtsParameters.sha256_n32_w8;
                this.put((Object)lMOtsParameters4.type, (Object)lMOtsParameters4);
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

    public LMOtsParameters(int n2, int n3, int n4, int n5, int n6, int n7, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.type = n2;
        this.n = n3;
        this.w = n4;
        this.p = n5;
        this.digestOID = aSN1ObjectIdentifier;
    }

    public static LMOtsParameters getParametersForType(int n2) {
        return (LMOtsParameters)suppliers.get((Object)n2);
    }

}

