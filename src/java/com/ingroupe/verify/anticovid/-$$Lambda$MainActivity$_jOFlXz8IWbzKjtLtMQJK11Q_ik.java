/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.fragment.app.FragmentManager
 *  com.ingroupe.verify.anticovid.MainActivity
 *  com.ingroupe.verify.anticovid.dialog.LoadingAnimDialog
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.dialog.LoadingAnimDialog;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$MainActivity$_jOFlXz8IWbzKjtLtMQJK11Q_ik
implements Runnable {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ MainActivity f$1;

    public /* synthetic */ -$$Lambda$MainActivity$_jOFlXz8IWbzKjtLtMQJK11Q_ik(boolean bl, MainActivity mainActivity) {
        this.f$0 = bl;
        this.f$1 = mainActivity;
    }

    public final void run() {
        boolean bl;
        boolean bl2;
        LoadingAnimDialog loadingAnimDialog;
        LoadingAnimDialog loadingAnimDialog2;
        boolean bl3 = this.f$0;
        MainActivity mainActivity = this.f$1;
        Intrinsics.checkNotNullParameter((Object)mainActivity, (String)"this$0");
        Log.d((String)"MainActivity", (String)"is running");
        if (bl3 && (bl = (loadingAnimDialog = LoadingAnimDialog.getInstance()) != null && !loadingAnimDialog.isAdded())) {
            LoadingAnimDialog loadingAnimDialog3 = LoadingAnimDialog.getInstance();
            if (loadingAnimDialog3 != null) {
                loadingAnimDialog3.show(mainActivity.getSupportFragmentManager(), "MainActivity");
            }
            Log.d((String)"MainActivity", (String)"loadingAnimDialog?.show()");
            return;
        }
        if (!bl3 && (bl2 = (loadingAnimDialog2 = LoadingAnimDialog.getInstance()) != null && loadingAnimDialog2.isAdded())) {
            LoadingAnimDialog loadingAnimDialog4 = LoadingAnimDialog.getInstance();
            if (loadingAnimDialog4 != null) {
                loadingAnimDialog4.dismissInternal(true, false);
            }
            Log.d((String)"MainActivity", (String)"loadingAnimDialog?.dismiss()");
        }
    }
}

