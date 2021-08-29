/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.ingroupe.verify.anticovid.ui.init.InitChildFragment
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.init;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfAbout;
import com.ingroupe.verify.anticovid.ui.init.InitChildFragment;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$InitChildFragment$GJOAp1mWP5Q_N3PZ_1SxCsV7gXo
implements View.OnClickListener {
    public final /* synthetic */ ConfAbout f$0;
    public final /* synthetic */ InitChildFragment f$1;

    public /* synthetic */ -$$Lambda$InitChildFragment$GJOAp1mWP5Q_N3PZ_1SxCsV7gXo(ConfAbout confAbout, InitChildFragment initChildFragment) {
        this.f$0 = confAbout;
        this.f$1 = initChildFragment;
    }

    public final void onClick(View view) {
        ConfAbout confAbout = this.f$0;
        InitChildFragment initChildFragment = this.f$1;
        Intrinsics.checkNotNullParameter((Object)initChildFragment, (String)"this$0");
        String string = confAbout == null ? null : confAbout.getPrivacyPolicy();
        initChildFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)string)));
    }
}

