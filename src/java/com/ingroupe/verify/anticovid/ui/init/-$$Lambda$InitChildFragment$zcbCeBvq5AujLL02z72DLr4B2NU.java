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
package com.ingroupe.verify.anticovid.ui.init;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$InitChildFragment$zcbCeBvq5AujLL02z72DLr4B2NU
implements View.OnClickListener {
    public final /* synthetic */ AlertDialog f$0;

    public /* synthetic */ -$$Lambda$InitChildFragment$zcbCeBvq5AujLL02z72DLr4B2NU(AlertDialog alertDialog) {
        this.f$0 = alertDialog;
    }

    public final void onClick(View view) {
        AlertDialog alertDialog = this.f$0;
        Intrinsics.checkNotNullParameter((Object)alertDialog, (String)"$dialog");
        alertDialog.dismiss();
    }
}

