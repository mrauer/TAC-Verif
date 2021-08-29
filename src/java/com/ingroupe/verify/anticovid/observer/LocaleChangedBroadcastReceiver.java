/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.util.Log
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelStoreOwner
 *  com.ingroupe.verify.anticovid.MainActivity
 *  com.ingroupe.verify.anticovid.common.SharedViewModel
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.observer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import kotlin.jvm.internal.Intrinsics;

public final class LocaleChangedBroadcastReceiver
extends BroadcastReceiver {
    public MainActivity main;

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)intent, (String)"intent");
        Log.d((String)"LocaleChangedBr", (String)"new Locale");
        MainActivity mainActivity = this.main;
        if (mainActivity == null) {
            return;
        }
        SharedViewModel sharedViewModel = (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)mainActivity).get(SharedViewModel.class);
        Intrinsics.checkNotNullExpressionValue((Object)sharedViewModel, (String)"run {\n            ViewModelProvider(this).get(SharedViewModel::class.java)\n        }");
        sharedViewModel.reloadConfiguration = true;
    }
}

