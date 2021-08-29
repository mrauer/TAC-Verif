/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  androidx.work.CoroutineWorker
 *  androidx.work.ListenableWorker
 *  androidx.work.ListenableWorker$Result
 *  androidx.work.ListenableWorker$Result$Success
 *  androidx.work.WorkerParameters
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
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
package com.ingroupe.verify.anticovid.synchronization;

import android.content.Context;
import android.util.Log;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.ingroupe.verify.anticovid.auth.AcceptLanguageHeaderInterceptor;
import com.ingroupe.verify.anticovid.auth.AddAuthorizationInterceptor;
import com.ingroupe.verify.anticovid.service.api.configuration.ConfigurationService;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncResult;
import com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils;
import com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils$Companion$callSynchronization$1;
import com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils;
import com.ingroupe.verify.anticovid.synchronization.elements.Blacklist;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(bv={1, 0, 3}, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2={"Lcom/ingroupe/verify/anticovid/synchronization/SyncWorker;", "Landroidx/work/CoroutineWorker;", "Lcom/ingroupe/verify/anticovid/synchronization/ConfServiceUtils$ConfServiceListener;", "Lcom/ingroupe/verify/anticovid/synchronization/SynchronisationUtils$SyncListener;", "Landroidx/work/ListenableWorker$Result;", "doWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "title", "message", "", "showErrorMessage", "(II)V", "Lcom/ingroupe/verify/anticovid/service/api/configuration/sync/SyncResult;", "syncResult", "saveResult", "(Lcom/ingroupe/verify/anticovid/service/api/configuration/sync/SyncResult;)V", "", "show", "showLoading", "(Z)V", "onSynchronizationDone", "()V", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class SyncWorker
extends CoroutineWorker
implements ConfServiceUtils.ConfServiceListener,
SynchronisationUtils.SyncListener {
    public SyncWorker(Context context, WorkerParameters workerParameters) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"appContext");
        Intrinsics.checkNotNullParameter((Object)workerParameters, (String)"workerParams");
        super(context, workerParameters);
    }

    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        SynchronisationUtils synchronisationUtils = SynchronisationUtils.INSTANCE;
        Context context = ((ListenableWorker)this).mAppContext;
        Intrinsics.checkNotNullExpressionValue((Object)context, (String)"applicationContext");
        if (synchronisationUtils.isSyncNeeded(context)) {
            Context context2 = ((ListenableWorker)this).mAppContext;
            Intrinsics.checkNotNullExpressionValue((Object)context2, (String)"applicationContext");
            Intrinsics.checkNotNullParameter((Object)context2, (String)"context");
            Intrinsics.checkNotNullParameter((Object)this, (String)"view");
            Intrinsics.checkNotNullParameter((Object)"SyncWorkerTag", (String)"tag");
            Intrinsics.checkNotNullParameter((Object)context2, (String)"context");
            Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://portail.tacv.myservices-ingroupe.com");
            Intrinsics.checkNotNullParameter((Object)context2, (String)"context");
            OkHttpClient.Builder builder2 = new OkHttpClient.Builder();
            builder2.addInterceptor((Interceptor)new AcceptLanguageHeaderInterceptor());
            builder2.addInterceptor((Interceptor)new AddAuthorizationInterceptor(context2));
            Object object = builder.client(new OkHttpClient(builder2)).addConverterFactory((Converter.Factory)GsonConverterFactory.create()).build().create(ConfigurationService.class);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Builder().baseUrl(BuildConfig.ENDPOINT_URL)\n            .client(getOkHttpClient(context))\n            .addConverterFactory(GsonConverterFactory.create()).build().create(\n                ConfigurationService::class.java\n            )");
            ((ConfigurationService)object).callSync(Intrinsics.stringPlus((String)"/api/client/configuration", (Object)"\\synchronisation\\tacv")).enqueue((Callback)new ConfServiceUtils$Companion$callSynchronization$1("SyncWorkerTag", true, this));
        }
        Context context3 = ((ListenableWorker)this).mAppContext;
        Intrinsics.checkNotNullExpressionValue((Object)context3, (String)"applicationContext");
        Blacklist.cleanDuplicateMap(context3);
        ListenableWorker.Result.Success success = new ListenableWorker.Result.Success();
        Intrinsics.checkNotNullExpressionValue((Object)success, (String)"success()");
        return success;
    }

    @Override
    public void onSynchronizationDone() {
    }

    @Override
    public void saveResult(SyncResult syncResult) {
        SynchronisationUtils synchronisationUtils = SynchronisationUtils.INSTANCE;
        Context context = ((ListenableWorker)this).mAppContext;
        Intrinsics.checkNotNullExpressionValue((Object)context, (String)"applicationContext");
        synchronisationUtils.saveSynchronization(syncResult, context, this, this, "SyncWorkerTag", true);
    }

    @Override
    public void showErrorMessage(int n2, int n3) {
        Log.i((String)"SyncWorkerTag", (String)"Error during syncWork");
    }

    @Override
    public void showLoading(boolean bl) {
    }
}

