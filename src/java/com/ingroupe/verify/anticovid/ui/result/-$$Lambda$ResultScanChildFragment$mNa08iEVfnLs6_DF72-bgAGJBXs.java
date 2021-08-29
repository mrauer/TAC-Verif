/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ingroupe.verify.anticovid.common.FeatureChildFragment
 *  com.ingroupe.verify.anticovid.common.FeatureFragment
 *  com.ingroupe.verify.anticovid.ui.result.ResultScanChildFragment
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.result;

import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.FeatureFragment;
import com.ingroupe.verify.anticovid.ui.result.ResultScanChildFragment;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$ResultScanChildFragment$mNa08iEVfnLs6_DF72-bgAGJBXs
implements Runnable {
    public final /* synthetic */ ResultScanChildFragment f$0;

    public /* synthetic */ -$$Lambda$ResultScanChildFragment$mNa08iEVfnLs6_DF72-bgAGJBXs(ResultScanChildFragment resultScanChildFragment) {
        this.f$0 = resultScanChildFragment;
    }

    public final void run() {
        ResultScanChildFragment resultScanChildFragment = this.f$0;
        Intrinsics.checkNotNullParameter((Object)resultScanChildFragment, (String)"this$0");
        FeatureFragment featureFragment = resultScanChildFragment.featureFragment;
        String string = featureFragment == null ? null : featureFragment.currentTag;
        if (Intrinsics.areEqual((Object)string, (Object)"resultScanF")) {
            FeatureFragment featureFragment2 = resultScanChildFragment.featureFragment;
            if (featureFragment2 == null) {
                return;
            }
            FeatureFragment.popToTag$default((FeatureFragment)featureFragment2, (String)"actionChoice", null, (boolean)false, (int)6, null);
        }
    }
}

