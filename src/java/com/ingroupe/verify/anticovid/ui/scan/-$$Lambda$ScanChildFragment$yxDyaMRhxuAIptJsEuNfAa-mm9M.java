/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  com.ingroupe.verify.anticovid.common.FeatureChildFragment
 *  com.ingroupe.verify.anticovid.common.FeatureFragment
 *  com.ingroupe.verify.anticovid.ui.scan.ScanChildFragment
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.scan;

import android.content.DialogInterface;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.FeatureFragment;
import com.ingroupe.verify.anticovid.ui.scan.ScanChildFragment;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$ScanChildFragment$yxDyaMRhxuAIptJsEuNfAa-mm9M
implements DialogInterface.OnDismissListener {
    public final /* synthetic */ ScanChildFragment f$0;

    public /* synthetic */ -$$Lambda$ScanChildFragment$yxDyaMRhxuAIptJsEuNfAa-mm9M(ScanChildFragment scanChildFragment) {
        this.f$0 = scanChildFragment;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ScanChildFragment scanChildFragment = this.f$0;
        Intrinsics.checkNotNullParameter((Object)scanChildFragment, (String)"this$0");
        FeatureFragment featureFragment = scanChildFragment.featureFragment;
        if (featureFragment == null) {
            return;
        }
        FeatureFragment.popToTag$default((FeatureFragment)featureFragment, (String)"actionChoice", null, (boolean)false, (int)6, null);
    }
}

