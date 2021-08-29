/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  com.ingroupe.verify.anticovid.camera.ScanViewModel
 *  com.ingroupe.verify.anticovid.ui.scan.ScanChildFragment
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.scan;

import android.content.DialogInterface;
import com.ingroupe.verify.anticovid.camera.ScanViewModel;
import com.ingroupe.verify.anticovid.ui.scan.ScanChildFragment;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$ScanChildFragment$b91oYr4J6e7YGgC9GhKPpPdLzgk
implements DialogInterface.OnClickListener {
    public final /* synthetic */ ScanChildFragment f$0;

    public /* synthetic */ -$$Lambda$ScanChildFragment$b91oYr4J6e7YGgC9GhKPpPdLzgk(ScanChildFragment scanChildFragment) {
        this.f$0 = scanChildFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        ScanChildFragment scanChildFragment = this.f$0;
        Intrinsics.checkNotNullParameter((Object)scanChildFragment, (String)"this$0");
        dialogInterface.dismiss();
        ScanViewModel scanViewModel = scanChildFragment.viewModel;
        if (scanViewModel == null) {
            return;
        }
        scanViewModel.resumeScanning();
    }
}

