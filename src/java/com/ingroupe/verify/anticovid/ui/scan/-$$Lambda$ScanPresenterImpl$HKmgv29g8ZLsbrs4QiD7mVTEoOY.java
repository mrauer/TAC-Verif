/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  com.ingroupe.verify.anticovid.MainActivity
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.scan;

import android.content.Context;
import android.content.DialogInterface;
import com.ingroupe.verify.anticovid.MainActivity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$ScanPresenterImpl$HKmgv29g8ZLsbrs4QiD7mVTEoOY
implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ -$$Lambda$ScanPresenterImpl$HKmgv29g8ZLsbrs4QiD7mVTEoOY(Context context, Function0 function0) {
        this.f$0 = context;
        this.f$1 = function0;
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        Context context = this.f$0;
        Function0 function0 = this.f$1;
        Intrinsics.checkNotNullParameter((Object)context, (String)"$context");
        Intrinsics.checkNotNullParameter((Object)function0, (String)"$lmbd");
        dialogInterface.dismiss();
        ((MainActivity)context).changeMode(true);
        function0.invoke();
    }
}

