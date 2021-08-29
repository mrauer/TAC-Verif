/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ingroupe.verify.anticovid.camera.ScanViewModel
 *  com.scandit.datacapture.barcode.data.Barcode
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.camera;

import com.ingroupe.verify.anticovid.camera.ScanViewModel;
import com.scandit.datacapture.barcode.data.Barcode;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$ScanViewModel$cYsiGm25msYQCwKbWYrXkp-RUUU
implements Runnable {
    public final /* synthetic */ ScanViewModel f$0;
    public final /* synthetic */ Barcode f$1;

    public /* synthetic */ -$$Lambda$ScanViewModel$cYsiGm25msYQCwKbWYrXkp-RUUU(ScanViewModel scanViewModel, Barcode barcode) {
        this.f$0 = scanViewModel;
        this.f$1 = barcode;
    }

    public final void run() {
        ScanViewModel scanViewModel = this.f$0;
        Barcode barcode = this.f$1;
        Intrinsics.checkNotNullParameter((Object)scanViewModel, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)barcode, (String)"$firstBarcode");
        ScanViewModel.ResultListener resultListener = scanViewModel.listener;
        Intrinsics.checkNotNull((Object)resultListener);
        resultListener.onCodeScanned(barcode);
    }
}

