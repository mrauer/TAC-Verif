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
package com.ingroupe.verify.anticovid.ui.scan;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$ScanChildFragment$5WUoL4jvi-v2iV8UR00yDa6FBjA
implements View.OnClickListener {
    public final /* synthetic */ AlertDialog f$0;

    public /* synthetic */ -$$Lambda$ScanChildFragment$5WUoL4jvi-v2iV8UR00yDa6FBjA(AlertDialog alertDialog) {
        this.f$0 = alertDialog;
    }

    public final void onClick(View view) {
        AlertDialog alertDialog = this.f$0;
        Intrinsics.checkNotNullParameter((Object)alertDialog, (String)"$dialogOTModeActivated");
        alertDialog.dismiss();
    }
}

