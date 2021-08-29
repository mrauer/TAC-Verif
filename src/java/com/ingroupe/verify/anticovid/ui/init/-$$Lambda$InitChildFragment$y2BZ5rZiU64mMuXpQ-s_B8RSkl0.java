/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  com.ingroupe.verify.anticovid.ui.init.InitChildFragment
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.init;

import android.content.DialogInterface;
import com.ingroupe.verify.anticovid.ui.init.InitChildFragment;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$InitChildFragment$y2BZ5rZiU64mMuXpQ-s_B8RSkl0
implements DialogInterface.OnDismissListener {
    public final /* synthetic */ InitChildFragment f$0;

    public /* synthetic */ -$$Lambda$InitChildFragment$y2BZ5rZiU64mMuXpQ-s_B8RSkl0(InitChildFragment initChildFragment) {
        this.f$0 = initChildFragment;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        InitChildFragment initChildFragment = this.f$0;
        Intrinsics.checkNotNullParameter((Object)initChildFragment, (String)"this$0");
        initChildFragment.checkCameraPermission();
    }
}

