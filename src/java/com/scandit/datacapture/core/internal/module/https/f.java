/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Objects
 *  javax.net.ssl.X509TrustManager
 *  kotlin.collections.ArrayAsCollection
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.https;

import com.scandit.datacapture.core.internal.module.https.NativeHttpsSession;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsSessionConfiguration;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsSessionFactory;
import com.scandit.datacapture.core.internal.module.https.a.a;
import com.scandit.datacapture.core.internal.module.https.a.c;
import com.scandit.datacapture.core.internal.module.https.a.d;
import com.scandit.datacapture.core.internal.module.https.a.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.ArrayAsCollection;
import kotlin.jvm.internal.Intrinsics;

public final class f
extends NativeHttpsSessionFactory {
    @Override
    public final NativeHttpsSession create(NativeHttpsSessionConfiguration nativeHttpsSessionConfiguration) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter((Object)nativeHttpsSessionConfiguration, (String)"config");
        Object[] arrobject = new X509TrustManager[]{new c(), new a()};
        Intrinsics.checkNotNullParameter((Object)arrobject, (String)"elements");
        arrayList = new ArrayList((Collection)new ArrayAsCollection(arrobject, true));
        try {
            arrayList.add((Object)new com.scandit.datacapture.core.internal.module.https.a.f("scandit.pem"));
        }
        catch (Exception exception) {}
        Object[] arrobject = arrayList.toArray((Object[])new X509TrustManager[0]);
        Objects.requireNonNull((Object)arrobject, (String)"null cannot be cast to non-null type kotlin.Array<T>");
        Object[] arrobject2 = (X509TrustManager[])arrobject;
        return new com.scandit.datacapture.core.internal.module.https.e(nativeHttpsSessionConfiguration, new e((X509TrustManager[])Arrays.copyOf((Object[])arrobject2, (int)arrobject2.length)));
    }
}

