/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.net.ConnectivityManager
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.Network
 *  android.net.NetworkCapabilities
 *  android.net.NetworkRequest
 *  androidx.lifecycle.LiveData
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.observer;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.lifecycle.LiveData;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

public final class NetworkLiveData
extends LiveData<Boolean> {
    public static final NetworkLiveData INSTANCE = new NetworkLiveData();
    public static Application application;
    public static ConnectivityManager.NetworkCallback networkCallBack;
    public static NetworkRequest networkRequest;
    public static int numConnected;

    public void onActive() {
        Application application = NetworkLiveData.application;
        if (application != null) {
            Object object = application.getSystemService("connectivity");
            Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager)object;
            networkCallBack = new ConnectivityManager.NetworkCallback(){

                public void onAvailable(Network network) {
                    Intrinsics.checkNotNullParameter((Object)network, (String)"network");
                    super.onAvailable(network);
                    NetworkLiveData networkLiveData = NetworkLiveData.INSTANCE;
                    NetworkLiveData.numConnected = 1 + NetworkLiveData.numConnected;
                    networkLiveData.postValue((Object)Boolean.TRUE);
                }

                public void onLost(Network network) {
                    Intrinsics.checkNotNullParameter((Object)network, (String)"network");
                    super.onLost(network);
                    NetworkLiveData networkLiveData = NetworkLiveData.INSTANCE;
                    int n2 = -1 + NetworkLiveData.numConnected;
                    if (n2 < 0) {
                        n2 = 0;
                    }
                    NetworkLiveData.numConnected = n2;
                    if (n2 == 0) {
                        networkLiveData.postValue((Object)Boolean.FALSE);
                    }
                }

                public void onUnavailable() {
                    super.onUnavailable();
                    NetworkLiveData networkLiveData = NetworkLiveData.INSTANCE;
                    int n2 = -1 + NetworkLiveData.numConnected;
                    if (n2 < 0) {
                        n2 = 0;
                    }
                    NetworkLiveData.numConnected = n2;
                    if (n2 == 0) {
                        networkLiveData.postValue((Object)Boolean.FALSE);
                    }
                }
            };
            Application application2 = NetworkLiveData.application;
            if (application2 != null) {
                NetworkCapabilities networkCapabilities;
                Intrinsics.checkNotNullParameter((Object)application2, (String)"context");
                Object object2 = application2.getSystemService("connectivity");
                Objects.requireNonNull((Object)object2, (String)"null cannot be cast to non-null type android.net.ConnectivityManager");
                ConnectivityManager connectivityManager2 = (ConnectivityManager)object2;
                Network network = connectivityManager2.getActiveNetwork();
                boolean bl = network == null ? false : ((networkCapabilities = connectivityManager2.getNetworkCapabilities(network)) == null ? false : networkCapabilities.hasCapability(12));
                this.setValue((Object)bl);
                NetworkRequest networkRequest = NetworkLiveData.networkRequest;
                if (networkRequest != null) {
                    ConnectivityManager.NetworkCallback networkCallback = networkCallBack;
                    if (networkCallback != null) {
                        connectivityManager.registerNetworkCallback(networkRequest, networkCallback);
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException((String)"networkCallBack");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException((String)"networkRequest");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"application");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"application");
        throw null;
    }

    public void onInactive() {
        Application application = NetworkLiveData.application;
        if (application != null) {
            Object object = application.getSystemService("connectivity");
            Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager)object;
            ConnectivityManager.NetworkCallback networkCallback = networkCallBack;
            if (networkCallback != null) {
                connectivityManager.unregisterNetworkCallback(networkCallback);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"networkCallBack");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"application");
        throw null;
    }

}

