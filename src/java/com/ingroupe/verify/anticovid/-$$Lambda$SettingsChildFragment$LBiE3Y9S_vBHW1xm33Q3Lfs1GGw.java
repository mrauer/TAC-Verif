/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.ingroupe.verify.anticovid.SettingsChildFragment
 *  com.ingroupe.verify.anticovid.auth.AcceptLanguageHeaderInterceptor
 *  com.ingroupe.verify.anticovid.auth.AddAuthorizationInterceptor
 *  com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncResult
 *  com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils
 *  com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils$Companion
 *  com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils$Companion$callSynchronization
 *  com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils$Companion$callSynchronization$1
 *  com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils$ConfServiceListener
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
import android.view.View;
import com.ingroupe.verify.anticovid.SettingsChildFragment;
import com.ingroupe.verify.anticovid.auth.AcceptLanguageHeaderInterceptor;
import com.ingroupe.verify.anticovid.auth.AddAuthorizationInterceptor;
import com.ingroupe.verify.anticovid.service.api.configuration.ConfigurationService;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncResult;
import com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class -$$Lambda$SettingsChildFragment$LBiE3Y9S_vBHW1xm33Q3Lfs1GGw
implements View.OnClickListener {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ SettingsChildFragment f$1;

    public /* synthetic */ -$$Lambda$SettingsChildFragment$LBiE3Y9S_vBHW1xm33Q3Lfs1GGw(Context context, SettingsChildFragment settingsChildFragment) {
        this.f$0 = context;
        this.f$1 = settingsChildFragment;
    }

    public final void onClick(View view) {
        Context context = this.f$0;
        SettingsChildFragment settingsChildFragment = this.f$1;
        Intrinsics.checkNotNullParameter((Object)context, (String)"$c");
        Intrinsics.checkNotNullParameter((Object)settingsChildFragment, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)settingsChildFragment, (String)"view");
        Intrinsics.checkNotNullParameter((Object)"settings", (String)"tag");
        settingsChildFragment.showLoading(true);
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://portail.tacv.myservices-ingroupe.com");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        OkHttpClient.Builder builder2 = new OkHttpClient.Builder();
        builder2.addInterceptor((Interceptor)new AcceptLanguageHeaderInterceptor());
        builder2.addInterceptor((Interceptor)new AddAuthorizationInterceptor(context));
        Object object = builder.client(new OkHttpClient(builder2)).addConverterFactory((Converter.Factory)GsonConverterFactory.create()).build().create(ConfigurationService.class);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Builder().baseUrl(BuildConfig.ENDPOINT_URL)\n            .client(getOkHttpClient(context))\n            .addConverterFactory(GsonConverterFactory.create()).build().create(\n                ConfigurationService::class.java\n            )");
        ((ConfigurationService)object).callSync(Intrinsics.stringPlus((String)"/api/client/configuration", (Object)"\\synchronisation\\tacv")).enqueue((Callback)new ConfServiceUtils.Companion.callSynchronization.1("settings", false, (ConfServiceUtils.ConfServiceListener)settingsChildFragment));
    }
}

