/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.ingroupe.verify.anticovid.MainActivity
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid;

import android.view.View;
import com.ingroupe.verify.anticovid.MainActivity;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$MainActivity$GrRBUyUzMCoOQ5rumf-HS5SUIYI
implements View.OnClickListener {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ -$$Lambda$MainActivity$GrRBUyUzMCoOQ5rumf-HS5SUIYI(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    public final void onClick(View view) {
        MainActivity mainActivity = this.f$0;
        Intrinsics.checkNotNullParameter((Object)mainActivity, (String)"this$0");
        mainActivity.onBackPressed();
    }
}

