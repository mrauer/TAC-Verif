/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  kotlin.jvm.internal.Intrinsics
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.Response
 */
package com.ingroupe.verify.anticovid.synchronization;

import android.util.Log;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncResult;
import com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class ConfServiceUtils$Companion$callSynchronization$1
implements Callback<SyncResult> {
    public final /* synthetic */ boolean $backgroundWork;
    public final /* synthetic */ String $tag;
    public final /* synthetic */ ConfServiceUtils.ConfServiceListener $view;

    public ConfServiceUtils$Companion$callSynchronization$1(String string, boolean bl, ConfServiceUtils.ConfServiceListener confServiceListener) {
        this.$tag = string;
        this.$backgroundWork = bl;
        this.$view = confServiceListener;
    }

    public void onFailure(Call<SyncResult> call, Throwable throwable) {
        Intrinsics.checkNotNullParameter(call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)throwable, (String)"t");
        Log.e((String)this.$tag, (String)"callSync onFailure", (Throwable)throwable);
        if (!this.$backgroundWork) {
            this.$view.showLoading(false);
            if (call.isCanceled()) {
                this.$view.showErrorMessage(2131820629, 2131820630);
                return;
            }
            this.$view.showErrorMessage(2131820629, 2131820627);
        }
    }

    public void onResponse(Call<SyncResult> call, Response<SyncResult> response) {
        Intrinsics.checkNotNullParameter(call, (String)"call");
        Intrinsics.checkNotNullParameter(response, (String)"response");
        Log.d((String)this.$tag, (String)"callSync onResponse");
        this.$view.showLoading(false);
        if (response.code() == 200) {
            Log.d((String)this.$tag, (String)"OK :");
            SyncResult syncResult = (SyncResult)response.body();
            this.$view.saveResult(syncResult);
            return;
        }
        Log.e((String)this.$tag, (String)Intrinsics.stringPlus((String)"KO :", (Object)response.code()));
        if (!this.$backgroundWork) {
            this.$view.showErrorMessage(2131820626, 2131820628);
        }
    }
}

