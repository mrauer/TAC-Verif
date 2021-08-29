/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.SharedPreferences
 *  androidx.appcompat.widget.SwitchCompat
 *  com.ingroupe.verify.anticovid.SettingsChildFragment
 *  com.ingroupe.verify.anticovid.databinding.SettingsMainBinding
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import androidx.appcompat.widget.SwitchCompat;
import com.ingroupe.verify.anticovid.SettingsChildFragment;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.databinding.SettingsMainBinding;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$SettingsChildFragment$knXFAX_av58pYHH-7lJviTK2Wz0
implements DialogInterface.OnDismissListener {
    public final /* synthetic */ SettingsChildFragment f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ -$$Lambda$SettingsChildFragment$knXFAX_av58pYHH-7lJviTK2Wz0(SettingsChildFragment settingsChildFragment, Context context) {
        this.f$0 = settingsChildFragment;
        this.f$1 = context;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        SettingsChildFragment settingsChildFragment = this.f$0;
        Context context = this.f$1;
        Intrinsics.checkNotNullParameter((Object)settingsChildFragment, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)context, (String)"$c");
        SettingsMainBinding settingsMainBinding = settingsChildFragment._binding;
        Intrinsics.checkNotNull((Object)settingsMainBinding);
        SwitchCompat switchCompat = settingsMainBinding.switchOtMode;
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        SharedPreferences sharedPreferences = ((Activity)context).getPreferences(0);
        String string = sharedPreferences == null ? null : sharedPreferences.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
        boolean bl = false;
        if (string != null) {
            bl = true;
        }
        switchCompat.setChecked(bl);
    }
}

