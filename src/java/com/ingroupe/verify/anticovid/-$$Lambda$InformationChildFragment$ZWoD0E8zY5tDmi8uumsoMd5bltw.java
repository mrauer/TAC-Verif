/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.ingroupe.verify.anticovid.InformationChildFragment
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.ingroupe.verify.anticovid.InformationChildFragment;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfAbout;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$InformationChildFragment$ZWoD0E8zY5tDmi8uumsoMd5bltw
implements View.OnClickListener {
    public final /* synthetic */ ConfAbout f$0;
    public final /* synthetic */ InformationChildFragment f$1;

    public /* synthetic */ -$$Lambda$InformationChildFragment$ZWoD0E8zY5tDmi8uumsoMd5bltw(ConfAbout confAbout, InformationChildFragment informationChildFragment) {
        this.f$0 = confAbout;
        this.f$1 = informationChildFragment;
    }

    public final void onClick(View view) {
        ConfAbout confAbout = this.f$0;
        InformationChildFragment informationChildFragment = this.f$1;
        Intrinsics.checkNotNullParameter((Object)confAbout, (String)"$conf");
        Intrinsics.checkNotNullParameter((Object)informationChildFragment, (String)"this$0");
        informationChildFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)confAbout.getCgu())));
    }
}

