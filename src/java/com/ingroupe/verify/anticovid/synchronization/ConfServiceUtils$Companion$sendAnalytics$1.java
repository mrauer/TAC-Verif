/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  com.ingroupe.verify.anticovid.synchronization.elements.Analytics$deleteOldStats
 *  com.ingroupe.verify.anticovid.synchronization.elements.Analytics$deleteOldStats$1
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.Response
 */
package com.ingroupe.verify.anticovid.synchronization;

import android.content.Context;
import android.util.Log;
import com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils;
import com.ingroupe.verify.anticovid.synchronization.elements.Analytics;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class ConfServiceUtils$Companion$sendAnalytics$1
implements Callback<Unit> {
    public final /* synthetic */ boolean $backgroundWork;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ ConfServiceUtils.ConfServiceListener $listener;
    public final /* synthetic */ String $tag;

    public ConfServiceUtils$Companion$sendAnalytics$1(String string, boolean bl, ConfServiceUtils.ConfServiceListener confServiceListener, Context context) {
        this.$tag = string;
        this.$backgroundWork = bl;
        this.$listener = confServiceListener;
        this.$context = context;
    }

    public void onFailure(Call<Unit> call, Throwable throwable) {
        Intrinsics.checkNotNullParameter(call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)throwable, (String)"t");
        Log.e((String)this.$tag, (String)"sendLogs onFailure", (Throwable)throwable);
        if (!this.$backgroundWork) {
            this.$listener.showLoading(false);
            if (call.isCanceled()) {
                this.$listener.showErrorMessage(2131820629, 2131820630);
                return;
            }
            this.$listener.showErrorMessage(2131820629, 2131820627);
        }
    }

    public void onResponse(Call<Unit> call, Response<Unit> response) {
        Intrinsics.checkNotNullParameter(call, (String)"call");
        Intrinsics.checkNotNullParameter(response, (String)"response");
        Log.d((String)this.$tag, (String)"sendLogs onResponse");
        this.$listener.showLoading(false);
        if (response.code() == 200) {
            Log.d((String)this.$tag, (String)"OK");
            Analytics analytics = Analytics.INSTANCE;
            Context context = this.$context;
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            analytics.executeActionOnAtomicFile(new Analytics.deleteOldStats.1(context));
            return;
        }
        Log.e((String)this.$tag, (String)Intrinsics.stringPlus((String)"KO :", (Object)response.code()));
        if (!this.$backgroundWork) {
            this.$listener.showErrorMessage(2131820626, 2131820628);
        }
    }
}

