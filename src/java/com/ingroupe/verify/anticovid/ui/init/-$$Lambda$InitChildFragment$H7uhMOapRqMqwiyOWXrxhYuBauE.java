/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ingroupe.verify.anticovid.common.FeatureChildFragment
 *  com.ingroupe.verify.anticovid.common.FeatureFragment
 *  com.ingroupe.verify.anticovid.ui.init.InitChildFragment
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.init;

import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.FeatureFragment;
import com.ingroupe.verify.anticovid.ui.init.InitChildFragment;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$InitChildFragment$H7uhMOapRqMqwiyOWXrxhYuBauE
implements Runnable {
    public final /* synthetic */ InitChildFragment f$0;

    public /* synthetic */ -$$Lambda$InitChildFragment$H7uhMOapRqMqwiyOWXrxhYuBauE(InitChildFragment initChildFragment) {
        this.f$0 = initChildFragment;
    }

    public final void run() {
        InitChildFragment initChildFragment = this.f$0;
        Intrinsics.checkNotNullParameter((Object)initChildFragment, (String)"this$0");
        FeatureFragment featureFragment = initChildFragment.featureFragment;
        if (featureFragment == null) {
            return;
        }
        FeatureFragment.replaceFragment$default((FeatureFragment)featureFragment, (String)"actionChoice", (Serializable[])new Serializable[0], null, (int)4, null);
    }
}

