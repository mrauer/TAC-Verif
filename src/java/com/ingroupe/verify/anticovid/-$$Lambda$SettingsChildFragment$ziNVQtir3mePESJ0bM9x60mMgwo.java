/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.app.AlertDialog
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$SettingsChildFragment$ziNVQtir3mePESJ0bM9x60mMgwo
implements View.OnClickListener {
    public final /* synthetic */ AlertDialog f$0;

    public /* synthetic */ -$$Lambda$SettingsChildFragment$ziNVQtir3mePESJ0bM9x60mMgwo(AlertDialog alertDialog) {
        this.f$0 = alertDialog;
    }

    public final void onClick(View view) {
        AlertDialog alertDialog = this.f$0;
        Intrinsics.checkNotNullParameter((Object)alertDialog, (String)"$dialogDeactivateOTMode");
        alertDialog.dismiss();
    }
}

