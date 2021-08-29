/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.preference.PreferenceManager
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  com.ingroupe.verify.anticovid.databinding.PopupSynchronizationNeededBinding
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.synchronization;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import com.ingroupe.verify.anticovid.databinding.PopupSynchronizationNeededBinding;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$SynchronisationUtils$CuVaixEl5WrIw9RkpoHKJdoFUCI
implements View.OnClickListener {
    public final /* synthetic */ PopupSynchronizationNeededBinding f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ AlertDialog f$2;

    public /* synthetic */ -$$Lambda$SynchronisationUtils$CuVaixEl5WrIw9RkpoHKJdoFUCI(PopupSynchronizationNeededBinding popupSynchronizationNeededBinding, Context context, AlertDialog alertDialog) {
        this.f$0 = popupSynchronizationNeededBinding;
        this.f$1 = context;
        this.f$2 = alertDialog;
    }

    public final void onClick(View view) {
        PopupSynchronizationNeededBinding popupSynchronizationNeededBinding = this.f$0;
        Context context = this.f$1;
        AlertDialog alertDialog = this.f$2;
        Intrinsics.checkNotNullParameter((Object)popupSynchronizationNeededBinding, (String)"$bindingDialog");
        Intrinsics.checkNotNullParameter((Object)context, (String)"$context");
        if (popupSynchronizationNeededBinding.checkBoxHideSynchonization.isChecked()) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
            Intrinsics.checkExpressionValueIsNotNull((Object)sharedPreferences, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)");
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putLong("HIDE_SYNC_WARNING_DATE", new Date().getTime());
            editor.apply();
        }
        alertDialog.dismiss();
    }
}

