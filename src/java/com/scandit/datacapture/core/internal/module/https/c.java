/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.internal.http.RealInterceptorChain
 */
package com.scandit.datacapture.core.internal.module.https;

import com.scandit.datacapture.core.internal.module.https.a;
import com.scandit.datacapture.core.internal.module.https.b;
import com.scandit.datacapture.core.internal.module.https.i;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

public final class c
implements Interceptor {
    public final b a;
    public final boolean b;

    public c(b b2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)b2, (String)"connectivity");
        this.a = b2;
        this.b = bl;
    }

    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter((Object)chain, (String)"chain");
        int n2 = this.a.a();
        if (n2 != b.b.a) {
            if (n2 == b.b.c && !this.b) {
                throw new a();
            }
            RealInterceptorChain realInterceptorChain = (RealInterceptorChain)chain;
            return realInterceptorChain.proceed(realInterceptorChain.request);
        }
        throw new i();
    }
}

