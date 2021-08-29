/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Toast
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.common;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.ingroupe.verify.anticovid.common.Utils;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$Utils$Companion$XVDshywCycEp0EY3_-OkrT4ZVlQ
implements Runnable {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ -$$Lambda$Utils$Companion$XVDshywCycEp0EY3_-OkrT4ZVlQ(Activity activity, int n3, int n4) {
        this.f$0 = activity;
        this.f$1 = n3;
        this.f$2 = n4;
    }

    public final void run() {
        Toast toast;
        Activity activity = this.f$0;
        int n3 = this.f$1;
        int n4 = this.f$2;
        Intrinsics.checkNotNullParameter((Object)activity, (String)"$activity");
        View view = activity.getLayoutInflater().inflate(n3, (ViewGroup)activity.findViewById(n4));
        Toast toast2 = Utils.currentViewToast;
        if (toast2 != null) {
            toast2.cancel();
        }
        Utils.currentViewToast = toast = new Toast((Context)activity);
        toast.setView(view);
        Toast toast3 = Utils.currentViewToast;
        if (toast3 == null) {
            return;
        }
        toast3.show();
    }
}

