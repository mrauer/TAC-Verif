/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.fragment.app.FragmentActivity
 *  com.ingroupe.verify.anticovid.SettingsChildFragment
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ingroupe.verify.anticovid.SettingsChildFragment;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$SettingsChildFragment$BYfw3Y8CHFNK-v8GFcrhYy2LhEg
implements View.OnClickListener {
    public final /* synthetic */ SettingsChildFragment f$0;

    public /* synthetic */ -$$Lambda$SettingsChildFragment$BYfw3Y8CHFNK-v8GFcrhYy2LhEg(SettingsChildFragment settingsChildFragment) {
        this.f$0 = settingsChildFragment;
    }

    public final void onClick(View view) {
        SettingsChildFragment settingsChildFragment = this.f$0;
        Intrinsics.checkNotNullParameter((Object)settingsChildFragment, (String)"this$0");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        FragmentActivity fragmentActivity = settingsChildFragment.getActivity();
        String string = fragmentActivity == null ? null : fragmentActivity.getPackageName();
        intent.setData(Uri.fromParts((String)"package", (String)string, null));
        Context context = settingsChildFragment.getContext();
        if (context == null) {
            return;
        }
        context.startActivity(intent);
    }
}

