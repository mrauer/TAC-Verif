/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.ingroupe.verify.anticovid.common.FeatureChildFragment
 *  com.ingroupe.verify.anticovid.common.FeatureFragment
 *  com.ingroupe.verify.anticovid.ui.result.ResultScanChildFragment
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.result;

import android.view.View;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.FeatureFragment;
import com.ingroupe.verify.anticovid.ui.result.ResultScanChildFragment;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$ResultScanChildFragment$KKCtRPBBiXeBLI5W6n3FI1NZ9Es
implements View.OnClickListener {
    public final /* synthetic */ ResultScanChildFragment f$0;

    public /* synthetic */ -$$Lambda$ResultScanChildFragment$KKCtRPBBiXeBLI5W6n3FI1NZ9Es(ResultScanChildFragment resultScanChildFragment) {
        this.f$0 = resultScanChildFragment;
    }

    public final void onClick(View view) {
        ResultScanChildFragment resultScanChildFragment = this.f$0;
        Intrinsics.checkNotNullParameter((Object)resultScanChildFragment, (String)"this$0");
        FeatureFragment featureFragment = resultScanChildFragment.featureFragment;
        if (featureFragment == null) {
            return;
        }
        FeatureFragment.popToTag$default((FeatureFragment)featureFragment, (String)"Scan", null, (boolean)false, (int)6, null);
    }
}

