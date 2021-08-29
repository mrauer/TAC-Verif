/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Handler
 *  android.util.Log
 *  com.ingroupe.verify.anticovid.MainActivity
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import com.ingroupe.verify.anticovid.-$$Lambda$MainActivity$_jOFlXz8IWbzKjtLtMQJK11Q_ik;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.common.ShowLoadingAnimEvent;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$MainActivity$z2xoq5y0JZOkQFtVgxslC3eLBao
implements Runnable {
    public final /* synthetic */ ShowLoadingAnimEvent f$0;
    public final /* synthetic */ MainActivity f$1;

    public /* synthetic */ -$$Lambda$MainActivity$z2xoq5y0JZOkQFtVgxslC3eLBao(ShowLoadingAnimEvent showLoadingAnimEvent, MainActivity mainActivity) {
        this.f$0 = showLoadingAnimEvent;
        this.f$1 = mainActivity;
    }

    public final void run() {
        ShowLoadingAnimEvent showLoadingAnimEvent = this.f$0;
        MainActivity mainActivity = this.f$1;
        Intrinsics.checkNotNullParameter((Object)showLoadingAnimEvent, (String)"$showLoadingAnimEvent");
        Intrinsics.checkNotNullParameter((Object)mainActivity, (String)"this$0");
        if (Intrinsics.areEqual((Object)showLoadingAnimEvent.activity, (Object)mainActivity)) {
            boolean bl = showLoadingAnimEvent.show;
            Log.d((String)"MainActivity", (String)Intrinsics.stringPlus((String)"show progress bar ", (Object)bl));
            mainActivity.showProgressBarHandler.post((Runnable)new -$$Lambda$MainActivity$_jOFlXz8IWbzKjtLtMQJK11Q_ik(bl, mainActivity));
        }
    }
}

