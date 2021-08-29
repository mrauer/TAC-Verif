/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.ingroupe.verify.anticovid.auth.AcceptLanguageHeaderInterceptor
 *  com.ingroupe.verify.anticovid.auth.AddAuthorizationInterceptor
 *  com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils$Companion$sendAnalytics
 *  com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils$Companion$sendAnalytics$1
 *  com.ingroupe.verify.anticovid.synchronization.elements.Analytics$getEventFromFile
 *  com.ingroupe.verify.anticovid.synchronization.elements.Analytics$getEventFromFile$2
 *  com.ingroupe.verify.anticovid.synchronization.elements.Analytics$sendAnalytics
 *  com.ingroupe.verify.anticovid.synchronization.elements.Analytics$sendAnalytics$1
 *  java.io.File
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.Objects
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.ContinuationInterceptor$Key
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.CoroutineSingletons
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.CompletedExceptionally
 *  kotlinx.coroutines.CoroutineDispatcher
 *  kotlinx.coroutines.DispatchedCoroutine
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.Job$Key
 *  kotlinx.coroutines.JobSupportKt
 *  kotlinx.coroutines.UndispatchedCoroutine
 *  kotlinx.coroutines.internal.ScopeCoroutine
 *  kotlinx.coroutines.internal.ThreadContextKt
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
package com.ingroupe.verify.anticovid.synchronization.elements;

import android.content.Context;
import com.google.android.material.R;
import com.ingroupe.verify.anticovid.auth.AcceptLanguageHeaderInterceptor;
import com.ingroupe.verify.anticovid.auth.AddAuthorizationInterceptor;
import com.ingroupe.verify.anticovid.service.api.configuration.ConfigurationService;
import com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils;
import com.ingroupe.verify.anticovid.synchronization.elements.Analytics;
import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchedCoroutine;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class Analytics {
    public static final Analytics INSTANCE = new Analytics();

    public final <T> T executeActionOnAtomicFile(Function0<? extends T> function0) {
        Analytics analytics = this;
        synchronized (analytics) {
            Object object = function0.invoke();
            return (T)object;
        }
    }

    public final Object getVerifEvents(Context context, Continuation<? super List<String>> continuation) {
        Object object;
        block16 : {
            block14 : {
                DispatchedCoroutine dispatchedCoroutine;
                block15 : {
                    boolean bl;
                    block12 : {
                        CoroutineContext coroutineContext;
                        CoroutineContext coroutineContext2;
                        getEventFromFile.2 var5_5;
                        block13 : {
                            File file = new File(new File(context.getFilesDir(), "TacVerifAnalytics"), "verif_events");
                            CoroutineDispatcher coroutineDispatcher = Dispatchers.IO;
                            var5_5 = new getEventFromFile.2(file, null);
                            coroutineContext2 = continuation.getContext();
                            coroutineContext = coroutineContext2.plus((CoroutineContext)coroutineDispatcher);
                            Job job = (Job)coroutineContext.get((CoroutineContext.Key)Job.Key);
                            if (job != null && !job.isActive()) {
                                throw job.getCancellationException();
                            }
                            if (coroutineContext != coroutineContext2) break block13;
                            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(coroutineContext, continuation);
                            object = R.style.startUndispatchedOrReturn((ScopeCoroutine)scopeCoroutine, (Object)scopeCoroutine, (Function2)var5_5);
                            break block14;
                        }
                        ContinuationInterceptor.Key key = ContinuationInterceptor.Key.$$INSTANCE;
                        if (Intrinsics.areEqual((Object)((ContinuationInterceptor)coroutineContext.get((CoroutineContext.Key)key)), (Object)((ContinuationInterceptor)coroutineContext2.get((CoroutineContext.Key)key)))) {
                            UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(coroutineContext, continuation);
                            Object object2 = ThreadContextKt.updateThreadContext((CoroutineContext)coroutineContext, null);
                            try {
                                Object object3 = R.style.startUndispatchedOrReturn((ScopeCoroutine)undispatchedCoroutine, (Object)undispatchedCoroutine, (Function2)var5_5);
                                object = object3;
                            }
                            finally {
                                ThreadContextKt.restoreThreadContext((CoroutineContext)coroutineContext, (Object)object2);
                            }
                        }
                        dispatchedCoroutine = new DispatchedCoroutine(coroutineContext, continuation);
                        dispatchedCoroutine.initParentJob$kotlinx_coroutines_core();
                        R.style.startCoroutineCancellable$default((Function2)var5_5, (Object)dispatchedCoroutine, (Continuation)dispatchedCoroutine, null, (int)4);
                        do {
                            int n2;
                            if ((n2 = dispatchedCoroutine._decision) == 0) continue;
                            if (n2 == 2) {
                                bl = false;
                                break block12;
                            }
                            throw new IllegalStateException("Already suspended".toString());
                        } while (!DispatchedCoroutine._decision$FU.compareAndSet((Object)dispatchedCoroutine, 0, 1));
                        bl = true;
                    }
                    if (!bl) break block15;
                    object = CoroutineSingletons.COROUTINE_SUSPENDED;
                    break block14;
                }
                object = JobSupportKt.unboxState((Object)dispatchedCoroutine.getState$kotlinx_coroutines_core());
                if (object instanceof CompletedExceptionally) break block16;
            }
            if (object == CoroutineSingletons.COROUTINE_SUSPENDED) {
                Intrinsics.checkNotNullParameter(continuation, (String)"frame");
            }
            return object;
        }
        throw ((CompletedExceptionally)object).cause;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final Object sendAnalytics(Context var1_1, ConfServiceUtils.ConfServiceListener var2_2, String var3_3, boolean var4_4, Continuation<? super Unit> var5_5) {
        if (!(var5_5 instanceof sendAnalytics.1)) ** GOTO lbl-1000
        var6_6 = (sendAnalytics.1)var5_5;
        var21_7 = var6_6.label;
        if ((var21_7 & Integer.MIN_VALUE) != 0) {
            var6_6.label = var21_7 + Integer.MIN_VALUE;
        } else lbl-1000: // 2 sources:
        {
            var6_6 = new sendAnalytics.1(this, var5_5);
        }
        var7_8 = var6_6.result;
        var8_9 = CoroutineSingletons.COROUTINE_SUSPENDED;
        var9_10 = var6_6.label;
        if (var9_10 != 0) {
            if (var9_10 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            var4_4 = var6_6.Z$0;
            var1_1 = (Context)var6_6.L$3;
            var13_11 = (ConfServiceUtils.Companion)var6_6.L$2;
            var3_3 = (String)var6_6.L$1;
            var12_12 = (ConfServiceUtils.ConfServiceListener)var6_6.L$0;
            R.style.throwOnFailure((Object)var7_8);
        } else {
            R.style.throwOnFailure((Object)var7_8);
            var10_13 = ConfServiceUtils.Companion;
            var6_6.L$0 = var2_2;
            var6_6.L$1 = var3_3;
            var6_6.L$2 = var10_13;
            var6_6.L$3 = var1_1;
            var6_6.Z$0 = var4_4;
            var6_6.label = 1;
            var11_14 = this.getVerifEvents(var1_1, (Continuation<? super List<String>>)var6_6);
            if (var11_14 == var8_9) {
                return var8_9;
            }
            var12_12 = var2_2;
            var13_11 = var10_13;
            var7_8 = var11_14;
        }
        var14_15 = (List)var7_8;
        Objects.requireNonNull((Object)var13_11);
        Intrinsics.checkNotNullParameter((Object)var1_1, (String)"context");
        Intrinsics.checkNotNullParameter((Object)var14_15, (String)"logs");
        Intrinsics.checkNotNullParameter((Object)var12_12, (String)"listener");
        Intrinsics.checkNotNullParameter((Object)var3_3, (String)"tag");
        var12_12.showLoading(true);
        Intrinsics.checkNotNullParameter((Object)var1_1, (String)"context");
        var16_16 = new Retrofit.Builder().baseUrl("https://portail.tacv.myservices-ingroupe.com");
        Intrinsics.checkNotNullParameter((Object)var1_1, (String)"context");
        var17_17 = new OkHttpClient.Builder();
        var17_17.addInterceptor((Interceptor)new AcceptLanguageHeaderInterceptor());
        var17_17.addInterceptor((Interceptor)new AddAuthorizationInterceptor(var1_1));
        var20_18 = var16_16.client(new OkHttpClient(var17_17)).addConverterFactory((Converter.Factory)GsonConverterFactory.create()).build().create(ConfigurationService.class);
        Intrinsics.checkNotNullExpressionValue((Object)var20_18, (String)"Builder().baseUrl(BuildConfig.ENDPOINT_URL)\n            .client(getOkHttpClient(context))\n            .addConverterFactory(GsonConverterFactory.create()).build().create(\n                ConfigurationService::class.java\n            )");
        ((ConfigurationService)var20_18).sendAnalytics(Intrinsics.stringPlus((String)"/api/client/configuration", (Object)"\\synchronisation"), (List<String>)var14_15).enqueue((Callback)new ConfServiceUtils.Companion.sendAnalytics.1(var3_3, var4_4, var12_12, var1_1));
        return Unit.INSTANCE;
    }
}

