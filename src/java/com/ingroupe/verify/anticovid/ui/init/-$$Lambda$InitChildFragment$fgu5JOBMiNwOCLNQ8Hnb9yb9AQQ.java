/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.app.AlertDialog
 *  com.ingroupe.verify.anticovid.ui.init.InitChildFragment
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.init;

import android.content.SharedPreferences;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.ui.init.InitChildFragment;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$InitChildFragment$fgu5JOBMiNwOCLNQ8Hnb9yb9AQQ
implements View.OnClickListener {
    public final /* synthetic */ InitChildFragment f$0;
    public final /* synthetic */ SharedPreferences f$1;
    public final /* synthetic */ AlertDialog f$2;

    public /* synthetic */ -$$Lambda$InitChildFragment$fgu5JOBMiNwOCLNQ8Hnb9yb9AQQ(InitChildFragment initChildFragment, SharedPreferences sharedPreferences, AlertDialog alertDialog) {
        this.f$0 = initChildFragment;
        this.f$1 = sharedPreferences;
        this.f$2 = alertDialog;
    }

    public final void onClick(View view) {
        InitChildFragment initChildFragment = this.f$0;
        SharedPreferences sharedPreferences = this.f$1;
        AlertDialog alertDialog = this.f$2;
        Intrinsics.checkNotNullParameter((Object)initChildFragment, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)alertDialog, (String)"$dialog");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(Constants$SavedItems.INFO_CGU_POLICY_SHOWN_V2.getText(), true);
        editor.apply();
        alertDialog.dismiss();
    }
}

