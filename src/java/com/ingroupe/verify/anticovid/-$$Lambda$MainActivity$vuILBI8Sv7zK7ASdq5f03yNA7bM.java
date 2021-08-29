/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.lifecycle.Observer
 *  com.ingroupe.verify.anticovid.MainActivity
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Interceptor
 *  okhttp3.OkHttpClient
 *  okhttp3.OkHttpClient$Builder
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.Converter
 *  retrofit2.Converter$Factory
 *  retrofit2.Retrofit
 *  retrofit2.Retrofit$Builder
 *  retrofit2.converter.gson.GsonConverterFactory
 */
package com.ingroupe.verify.anticovid;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.auth.AcceptLanguageHeaderInterceptor;
import com.ingroupe.verify.anticovid.auth.AddAuthorizationInterceptor;
import com.ingroupe.verify.anticovid.service.api.configuration.ConfigurationService;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncResult;
import com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils;
import com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils$Companion$callSynchronization$1;
import com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class -$$Lambda$MainActivity$vuILBI8Sv7zK7ASdq5f03yNA7bM
implements Observer {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ -$$Lambda$MainActivity$vuILBI8Sv7zK7ASdq5f03yNA7bM(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    public final void onChanged(Object object) {
        MainActivity mainActivity = this.f$0;
        Boolean bl = (Boolean)object;
        Intrinsics.checkNotNullParameter((Object)mainActivity, (String)"this$0");
        Intrinsics.checkNotNullExpressionValue((Object)bl, (String)"it");
        if (bl.booleanValue() && SynchronisationUtils.INSTANCE.isSyncNeeded((Context)mainActivity)) {
            Intrinsics.checkNotNullParameter((Object)mainActivity, (String)"context");
            Intrinsics.checkNotNullParameter((Object)mainActivity, (String)"view");
            Intrinsics.checkNotNullParameter((Object)"MainActivity", (String)"tag");
            Intrinsics.checkNotNullParameter((Object)mainActivity, (String)"context");
            Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://portail.tacv.myservices-ingroupe.com");
            Intrinsics.checkNotNullParameter((Object)mainActivity, (String)"context");
            OkHttpClient.Builder builder2 = new OkHttpClient.Builder();
            builder2.addInterceptor((Interceptor)new AcceptLanguageHeaderInterceptor());
            builder2.addInterceptor((Interceptor)new AddAuthorizationInterceptor((Context)mainActivity));
            Object object2 = builder.client(new OkHttpClient(builder2)).addConverterFactory((Converter.Factory)GsonConverterFactory.create()).build().create(ConfigurationService.class);
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"Builder().baseUrl(BuildConfig.ENDPOINT_URL)\n            .client(getOkHttpClient(context))\n            .addConverterFactory(GsonConverterFactory.create()).build().create(\n                ConfigurationService::class.java\n            )");
            ((ConfigurationService)object2).callSync(Intrinsics.stringPlus((String)"/api/client/configuration", (Object)"\\synchronisation\\tacv")).enqueue((Callback)new ConfServiceUtils$Companion$callSynchronization$1("MainActivity", true, (ConfServiceUtils.ConfServiceListener)mainActivity));
        }
    }
}

