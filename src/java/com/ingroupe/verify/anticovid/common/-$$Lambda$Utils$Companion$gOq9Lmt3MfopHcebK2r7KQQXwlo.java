/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.common;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.ingroupe.verify.anticovid.common.Utils;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$Utils$Companion$gOq9Lmt3MfopHcebK2r7KQQXwlo
implements Runnable {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ -$$Lambda$Utils$Companion$gOq9Lmt3MfopHcebK2r7KQQXwlo(Activity activity, String string, int n3) {
        this.f$0 = activity;
        this.f$1 = string;
        this.f$2 = n3;
    }

    public final void run() {
        Toast toast;
        Activity activity = this.f$0;
        String string = this.f$1;
        int n3 = this.f$2;
        Intrinsics.checkNotNullParameter((Object)activity, (String)"$activity");
        Intrinsics.checkNotNullParameter((Object)string, (String)"$text");
        Toast toast2 = Utils.currentTextToast;
        if (toast2 != null) {
            toast2.cancel();
        }
        Utils.currentTextToast = toast = Toast.makeText((Context)activity, (CharSequence)string, (int)n3);
        if (toast == null) {
            return;
        }
        toast.show();
    }
}

