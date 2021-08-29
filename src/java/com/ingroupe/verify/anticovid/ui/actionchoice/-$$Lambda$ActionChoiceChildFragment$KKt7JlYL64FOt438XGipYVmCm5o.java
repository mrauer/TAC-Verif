/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.fragment.app.FragmentActivity
 *  com.ingroupe.verify.anticovid.common.FeatureChildFragment
 *  com.ingroupe.verify.anticovid.common.FeatureFragment
 *  com.ingroupe.verify.anticovid.ui.actionchoice.ActionChoiceChildFragment
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.actionchoice;

import android.content.SharedPreferences;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.FeatureFragment;
import com.ingroupe.verify.anticovid.ui.actionchoice.ActionChoiceChildFragment;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$ActionChoiceChildFragment$KKt7JlYL64FOt438XGipYVmCm5o
implements View.OnClickListener {
    public final /* synthetic */ ActionChoiceChildFragment f$0;

    public /* synthetic */ -$$Lambda$ActionChoiceChildFragment$KKt7JlYL64FOt438XGipYVmCm5o(ActionChoiceChildFragment actionChoiceChildFragment) {
        this.f$0 = actionChoiceChildFragment;
    }

    public final void onClick(View view) {
        ActionChoiceChildFragment actionChoiceChildFragment = this.f$0;
        Intrinsics.checkNotNullParameter((Object)actionChoiceChildFragment, (String)"this$0");
        FragmentActivity fragmentActivity = actionChoiceChildFragment.getActivity();
        SharedPreferences sharedPreferences = fragmentActivity == null ? null : fragmentActivity.getPreferences(0);
        Boolean bl = sharedPreferences == null ? null : Boolean.valueOf((boolean)sharedPreferences.getBoolean(Constants$SavedItems.SHOW_SCAN_TUTO.getText(), true));
        if (Intrinsics.areEqual(bl, (Object)Boolean.TRUE)) {
            FeatureFragment featureFragment = actionChoiceChildFragment.featureFragment;
            if (featureFragment == null) {
                return;
            }
            FeatureFragment.replaceFragment$default((FeatureFragment)featureFragment, (String)"tutorialScan2DDoc", (Serializable[])new Serializable[0], null, (int)4, null);
            return;
        }
        FeatureFragment featureFragment = actionChoiceChildFragment.featureFragment;
        if (featureFragment == null) {
            return;
        }
        FeatureFragment.replaceFragment$default((FeatureFragment)featureFragment, (String)"Scan", (Serializable[])new Serializable[0], null, (int)4, null);
    }
}

