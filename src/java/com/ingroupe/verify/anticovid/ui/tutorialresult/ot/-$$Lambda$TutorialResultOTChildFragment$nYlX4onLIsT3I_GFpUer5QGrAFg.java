/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  androidx.fragment.app.FragmentActivity
 *  com.ingroupe.verify.anticovid.common.FeatureChildFragment
 *  com.ingroupe.verify.anticovid.common.FeatureFragment
 *  com.ingroupe.verify.anticovid.databinding.TutorialResultOtMainBinding
 *  com.ingroupe.verify.anticovid.ui.tutorialresult.ot.TutorialResultOTChildFragment
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.tutorialresult.ot;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.CheckBox;
import androidx.fragment.app.FragmentActivity;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.FeatureFragment;
import com.ingroupe.verify.anticovid.databinding.TutorialResultOtMainBinding;
import com.ingroupe.verify.anticovid.ui.tutorialresult.ot.TutorialResultOTChildFragment;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$TutorialResultOTChildFragment$nYlX4onLIsT3I_GFpUer5QGrAFg
implements View.OnClickListener {
    public final /* synthetic */ TutorialResultOTChildFragment f$0;

    public /* synthetic */ -$$Lambda$TutorialResultOTChildFragment$nYlX4onLIsT3I_GFpUer5QGrAFg(TutorialResultOTChildFragment tutorialResultOTChildFragment) {
        this.f$0 = tutorialResultOTChildFragment;
    }

    public final void onClick(View view) {
        TutorialResultOTChildFragment tutorialResultOTChildFragment = this.f$0;
        Intrinsics.checkNotNullParameter((Object)tutorialResultOTChildFragment, (String)"this$0");
        FragmentActivity fragmentActivity = tutorialResultOTChildFragment.getActivity();
        SharedPreferences sharedPreferences = fragmentActivity == null ? null : fragmentActivity.getPreferences(0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String string = Constants$SavedItems.SHOW_RESULT_TUTO.getText();
            TutorialResultOtMainBinding tutorialResultOtMainBinding = tutorialResultOTChildFragment._binding;
            Intrinsics.checkNotNull((Object)tutorialResultOtMainBinding);
            editor.putBoolean(string, true ^ tutorialResultOtMainBinding.checkBoxShowTutoResult.isChecked());
            editor.apply();
        }
        FeatureFragment featureFragment = tutorialResultOTChildFragment.featureFragment;
        if (featureFragment == null) {
            return;
        }
        FeatureFragment.replaceFragment$default((FeatureFragment)featureFragment, (String)"resultScanF", (Serializable[])new Serializable[0], null, (int)4, null);
    }
}

