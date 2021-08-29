/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnClickListener
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.synchronization;

import android.content.Context;
import android.view.View;
import com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$SynchronisationUtils$p-yKyUvtD_B4tKuBP5MtPRuX_48
implements View.OnClickListener {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ -$$Lambda$SynchronisationUtils$p-yKyUvtD_B4tKuBP5MtPRuX_48(Context context) {
        this.f$0 = context;
    }

    public final void onClick(View view) {
        Context context = this.f$0;
        Intrinsics.checkNotNullParameter((Object)context, (String)"$context");
        SynchronisationUtils.INSTANCE.showPopup(context, false);
    }
}

