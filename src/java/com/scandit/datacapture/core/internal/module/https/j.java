/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.Network
 *  android.net.NetworkCapabilities
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.https;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.scandit.datacapture.core.internal.module.https.b;
import com.scandit.datacapture.core.internal.sdk.AppAndroidEnvironment;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

public final class j
implements b {
    public final ConnectivityManager b;

    public j() {
        Context context = AppAndroidEnvironment.applicationContext;
        if (context != null) {
            Object object = context.getSystemService("connectivity");
            Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type android.net.ConnectivityManager");
            this.b = (ConnectivityManager)object;
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
        throw null;
    }

    @Override
    public final int a() {
        NetworkCapabilities networkCapabilities;
        Network network = this.b.getActiveNetwork();
        if (network != null && (networkCapabilities = this.b.getNetworkCapabilities(network)) != null) {
            boolean bl = networkCapabilities.hasTransport(1);
            boolean bl2 = networkCapabilities.hasTransport(0);
            if (bl) {
                return b.b.b;
            }
            if (bl2) {
                return b.b.c;
            }
        }
        return b.b.a;
    }
}

