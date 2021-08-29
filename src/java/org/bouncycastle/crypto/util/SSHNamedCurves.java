/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Enumeration
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Set
 *  java.util.Vector
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.x9.X9ECParameters
 */
package org.bouncycastle.crypto.util;

import j$.util.Map;
import j$.util.Map$-CC;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.math.ec.ECCurve;

public class SSHNamedCurves {
    public static HashMap<ECCurve, String> curveMap;
    public static final java.util.Map<String, String> curveNameToSSHName;
    public static final java.util.Map<String, ASN1ObjectIdentifier> oidMap;
    public static final java.util.Map<ASN1ObjectIdentifier, String> oidToName;

    public static {
        oidMap = Collections.unmodifiableMap((java.util.Map)new Map(){
            {
                this.put((Object)"nistp256", (Object)SECObjectIdentifiers.secp256r1);
                this.put((Object)"nistp384", (Object)SECObjectIdentifiers.secp384r1);
                this.put((Object)"nistp521", (Object)SECObjectIdentifiers.secp521r1);
                this.put((Object)"nistk163", (Object)SECObjectIdentifiers.sect163k1);
                this.put((Object)"nistp192", (Object)SECObjectIdentifiers.secp192r1);
                this.put((Object)"nistp224", (Object)SECObjectIdentifiers.secp224r1);
                this.put((Object)"nistk233", (Object)SECObjectIdentifiers.sect233k1);
                this.put((Object)"nistb233", (Object)SECObjectIdentifiers.sect233r1);
                this.put((Object)"nistk283", (Object)SECObjectIdentifiers.sect283k1);
                this.put((Object)"nistk409", (Object)SECObjectIdentifiers.sect409k1);
                this.put((Object)"nistb409", (Object)SECObjectIdentifiers.sect409r1);
                this.put((Object)"nistt571", (Object)SECObjectIdentifiers.sect571k1);
            }

            @Override
            public /* synthetic */ Object compute(Object object, BiFunction biFunction) {
                return Map$-CC.$default$compute((java.util.Map)this, object, biFunction);
            }

            @Override
            public /* synthetic */ Object computeIfAbsent(Object object, Function function) {
                return Map$-CC.$default$computeIfAbsent((java.util.Map)this, object, function);
            }

            @Override
            public /* synthetic */ Object computeIfPresent(Object object, BiFunction biFunction) {
                return Map$-CC.$default$computeIfPresent((java.util.Map)this, object, biFunction);
            }

            @Override
            public /* synthetic */ void forEach(j.BiConsumer biConsumer) {
                Map$-CC.$default$forEach((java.util.Map)this, biConsumer);
            }

            @Override
            public /* synthetic */ Object getOrDefault(Object object, Object object2) {
                return Map$-CC.$default$getOrDefault((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ Object merge(Object object, Object object2, BiFunction biFunction) {
                return Map$-CC.$default$merge((java.util.Map)this, object, object2, biFunction);
            }

            @Override
            public /* synthetic */ Object putIfAbsent(Object object, Object object2) {
                return Map$-CC.$default$putIfAbsent((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ boolean remove(Object object, Object object2) {
                return Map$-CC.$default$remove((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ Object replace(Object object, Object object2) {
                return Map$-CC.$default$replace((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ boolean replace(Object object, Object object2, Object object3) {
                return Map$-CC.$default$replace((java.util.Map)this, object, object2, object3);
            }

            @Override
            public /* synthetic */ void replaceAll(BiFunction biFunction) {
                Map$-CC.$default$replaceAll((java.util.Map)this, biFunction);
            }
        });
        curveNameToSSHName = Collections.unmodifiableMap((java.util.Map)new Map(){
            {
                String[][] arrarrstring = new String[][]{{"secp256r1", "nistp256"}, {"secp384r1", "nistp384"}, {"secp521r1", "nistp521"}, {"sect163k1", "nistk163"}, {"secp192r1", "nistp192"}, {"secp224r1", "nistp224"}, {"sect233k1", "nistk233"}, {"sect233r1", "nistb233"}, {"sect283k1", "nistk283"}, {"sect409k1", "nistk409"}, {"sect409r1", "nistb409"}, {"sect571k1", "nistt571"}};
                for (int i2 = 0; i2 != 12; ++i2) {
                    String[] arrstring = arrarrstring[i2];
                    this.put((Object)arrstring[0], (Object)arrstring[1]);
                }
            }

            @Override
            public /* synthetic */ Object compute(Object object, BiFunction biFunction) {
                return Map$-CC.$default$compute((java.util.Map)this, object, biFunction);
            }

            @Override
            public /* synthetic */ Object computeIfAbsent(Object object, Function function) {
                return Map$-CC.$default$computeIfAbsent((java.util.Map)this, object, function);
            }

            @Override
            public /* synthetic */ Object computeIfPresent(Object object, BiFunction biFunction) {
                return Map$-CC.$default$computeIfPresent((java.util.Map)this, object, biFunction);
            }

            @Override
            public /* synthetic */ void forEach(j.BiConsumer biConsumer) {
                Map$-CC.$default$forEach((java.util.Map)this, biConsumer);
            }

            @Override
            public /* synthetic */ Object getOrDefault(Object object, Object object2) {
                return Map$-CC.$default$getOrDefault((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ Object merge(Object object, Object object2, BiFunction biFunction) {
                return Map$-CC.$default$merge((java.util.Map)this, object, object2, biFunction);
            }

            @Override
            public /* synthetic */ Object putIfAbsent(Object object, Object object2) {
                return Map$-CC.$default$putIfAbsent((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ boolean remove(Object object, Object object2) {
                return Map$-CC.$default$remove((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ Object replace(Object object, Object object2) {
                return Map$-CC.$default$replace((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ boolean replace(Object object, Object object2, Object object3) {
                return Map$-CC.$default$replace((java.util.Map)this, object, object2, object3);
            }

            @Override
            public /* synthetic */ void replaceAll(BiFunction biFunction) {
                Map$-CC.$default$replaceAll((java.util.Map)this, biFunction);
            }
        });
        curveMap = new Map(){
            {
                Enumeration enumeration = CustomNamedCurves.names.elements();
                while (enumeration.hasMoreElements()) {
                    String string = (String)enumeration.nextElement();
                    this.put((Object)CustomNamedCurves.getByName((String)string).curve, (Object)string);
                }
            }

            @Override
            public /* synthetic */ Object compute(Object object, BiFunction biFunction) {
                return Map$-CC.$default$compute((java.util.Map)this, object, biFunction);
            }

            @Override
            public /* synthetic */ Object computeIfAbsent(Object object, Function function) {
                return Map$-CC.$default$computeIfAbsent((java.util.Map)this, object, function);
            }

            @Override
            public /* synthetic */ Object computeIfPresent(Object object, BiFunction biFunction) {
                return Map$-CC.$default$computeIfPresent((java.util.Map)this, object, biFunction);
            }

            @Override
            public /* synthetic */ void forEach(j.BiConsumer biConsumer) {
                Map$-CC.$default$forEach((java.util.Map)this, biConsumer);
            }

            @Override
            public /* synthetic */ Object getOrDefault(Object object, Object object2) {
                return Map$-CC.$default$getOrDefault((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ Object merge(Object object, Object object2, BiFunction biFunction) {
                return Map$-CC.$default$merge((java.util.Map)this, object, object2, biFunction);
            }

            @Override
            public /* synthetic */ Object putIfAbsent(Object object, Object object2) {
                return Map$-CC.$default$putIfAbsent((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ boolean remove(Object object, Object object2) {
                return Map$-CC.$default$remove((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ Object replace(Object object, Object object2) {
                return Map$-CC.$default$replace((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ boolean replace(Object object, Object object2, Object object3) {
                return Map$-CC.$default$replace((java.util.Map)this, object, object2, object3);
            }

            @Override
            public /* synthetic */ void replaceAll(BiFunction biFunction) {
                Map$-CC.$default$replaceAll((java.util.Map)this, biFunction);
            }
        };
        oidToName = Collections.unmodifiableMap((java.util.Map)new Map(){
            {
                for (String string : SSHNamedCurves.oidMap.keySet()) {
                    this.put(SSHNamedCurves.oidMap.get((Object)string), (Object)string);
                }
            }

            @Override
            public /* synthetic */ Object compute(Object object, BiFunction biFunction) {
                return Map$-CC.$default$compute((java.util.Map)this, object, biFunction);
            }

            @Override
            public /* synthetic */ Object computeIfAbsent(Object object, Function function) {
                return Map$-CC.$default$computeIfAbsent((java.util.Map)this, object, function);
            }

            @Override
            public /* synthetic */ Object computeIfPresent(Object object, BiFunction biFunction) {
                return Map$-CC.$default$computeIfPresent((java.util.Map)this, object, biFunction);
            }

            @Override
            public /* synthetic */ void forEach(j.BiConsumer biConsumer) {
                Map$-CC.$default$forEach((java.util.Map)this, biConsumer);
            }

            @Override
            public /* synthetic */ Object getOrDefault(Object object, Object object2) {
                return Map$-CC.$default$getOrDefault((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ Object merge(Object object, Object object2, BiFunction biFunction) {
                return Map$-CC.$default$merge((java.util.Map)this, object, object2, biFunction);
            }

            @Override
            public /* synthetic */ Object putIfAbsent(Object object, Object object2) {
                return Map$-CC.$default$putIfAbsent((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ boolean remove(Object object, Object object2) {
                return Map$-CC.$default$remove((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ Object replace(Object object, Object object2) {
                return Map$-CC.$default$replace((java.util.Map)this, object, object2);
            }

            @Override
            public /* synthetic */ boolean replace(Object object, Object object2, Object object3) {
                return Map$-CC.$default$replace((java.util.Map)this, object, object2, object3);
            }

            @Override
            public /* synthetic */ void replaceAll(BiFunction biFunction) {
                Map$-CC.$default$replaceAll((java.util.Map)this, biFunction);
            }
        });
    }

}

