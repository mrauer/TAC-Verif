/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.util.Log
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt__IndentKt
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.Response
 */
package com.ingroupe.verify.anticovid.synchronization;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfAbout;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfVersions;
import com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class ConfServiceUtils$Companion$callConfiguration$1
implements Callback<ConfResult> {
    public final /* synthetic */ boolean $backgroundWork;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ ConfServiceUtils.ConfServiceListener $listener;
    public final /* synthetic */ String $tag;

    public ConfServiceUtils$Companion$callConfiguration$1(String string, boolean bl, ConfServiceUtils.ConfServiceListener confServiceListener, Context context) {
        this.$tag = string;
        this.$backgroundWork = bl;
        this.$listener = confServiceListener;
        this.$context = context;
    }

    public void onFailure(Call<ConfResult> call, Throwable throwable) {
        Intrinsics.checkNotNullParameter(call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)throwable, (String)"t");
        Log.e((String)this.$tag, (String)"callConfiguration onFailure", (Throwable)throwable);
        if (!this.$backgroundWork) {
            this.$listener.showLoading(false);
            if (call.isCanceled()) {
                this.$listener.showErrorMessage(2131820629, 2131820630);
                return;
            }
            this.$listener.showErrorMessage(2131820629, 2131820627);
        }
    }

    public void onResponse(Call<ConfResult> call, Response<ConfResult> response) {
        Intrinsics.checkNotNullParameter(call, (String)"call");
        Intrinsics.checkNotNullParameter(response, (String)"response");
        Log.d((String)this.$tag, (String)"callConfiguration onResponse");
        if (response.code() == 200) {
            String string;
            Integer n2;
            Integer n3;
            ConfVersions confVersions;
            Integer n4;
            Integer n5;
            String string2;
            Log.d((String)this.$tag, (String)"OK");
            ConfResult confResult = (ConfResult)response.body();
            Context context = this.$context;
            ConfAbout confAbout = confResult == null ? null : confResult.getConfAbout();
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.ingroupe.verify.CONFIG_KEY", 0);
            if (confAbout == null) {
                return;
            }
            int n6 = sharedPreferences.getInt("LAST_CGU_VERSION", 2);
            int n7 = sharedPreferences.getInt("LAST_PRIVACY_POLICY_VERSION", 2);
            String string3 = confAbout.getLastCGUVersion();
            int n8 = string3 == null || (n3 = StringsKt__IndentKt.toIntOrNull((String)string3)) == null ? 0 : n3;
            boolean bl = n8 > n6;
            String string4 = confAbout.getLastPrivacyPolicyVersion();
            int n9 = string4 == null || (n2 = StringsKt__IndentKt.toIntOrNull((String)string4)) == null ? 0 : n2;
            if (n9 > n7) {
                bl = true;
            }
            int n10 = (confVersions = confAbout.getAndroidConfiguration()) == null || (string = confVersions.getLastMinorVersion()) == null || (n4 = StringsKt__IndentKt.toIntOrNull((String)string)) == null ? 0 : n4;
            boolean bl2 = n10 > 59;
            ConfVersions confVersions2 = confAbout.getAndroidConfiguration();
            int n11 = confVersions2 == null || (string2 = confVersions2.getLastMajorVersion()) == null || (n5 = StringsKt__IndentKt.toIntOrNull((String)string2)) == null ? 0 : n5;
            boolean bl3 = false;
            if (n11 > 59) {
                bl3 = true;
            }
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("INFORM_NEW_CGU_OR_POLICY", bl);
            String string5 = confAbout.getLastCGUVersion();
            if (string5 != null) {
                n6 = Integer.parseInt((String)string5);
            }
            editor.putInt("LAST_CGU_VERSION", n6);
            String string6 = confAbout.getLastPrivacyPolicyVersion();
            if (string6 != null) {
                n7 = Integer.parseInt((String)string6);
            }
            editor.putInt("LAST_PRIVACY_POLICY_VERSION", n7);
            editor.putInt("LAST_APP_VERSION_SYNCHRONIZED", 59);
            editor.putBoolean("INFORM_NEW_MINOR_APP_VERSION", bl2);
            editor.putBoolean("INFORM_NEW_MAJOR_APP_VERSION", bl3);
            editor.apply();
            return;
        }
        Log.e((String)this.$tag, (String)Intrinsics.stringPlus((String)"KO :", (Object)response.code()));
        if (!this.$backgroundWork) {
            this.$listener.showErrorMessage(2131820626, 2131820628);
        }
    }
}

