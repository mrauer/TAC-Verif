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
 *  com.ingroupe.verify.anticovid.databinding.TutorialResultLiteMainBinding
 *  com.ingroupe.verify.anticovid.ui.tutorialresult.lite.TutorialResultLiteChildFragment
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.tutorialresult.lite;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.CheckBox;
import androidx.fragment.app.FragmentActivity;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.FeatureFragment;
import com.ingroupe.verify.anticovid.databinding.TutorialResultLiteMainBinding;
import com.ingroupe.verify.anticovid.ui.tutorialresult.lite.TutorialResultLiteChildFragment;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$TutorialResultLiteChildFragment$QDpJN5fzajznmHqrVPTKopqdGMo
implements View.OnClickListener {
    public final /* synthetic */ TutorialResultLiteChildFragment f$0;

    public /* synthetic */ -$$Lambda$TutorialResultLiteChildFragment$QDpJN5fzajznmHqrVPTKopqdGMo(TutorialResultLiteChildFragment tutorialResultLiteChildFragment) {
        this.f$0 = tutorialResultLiteChildFragment;
    }

    public final void onClick(View view) {
        TutorialResultLiteChildFragment tutorialResultLiteChildFragment = this.f$0;
        Intrinsics.checkNotNullParameter((Object)tutorialResultLiteChildFragment, (String)"this$0");
        FragmentActivity fragmentActivity = tutorialResultLiteChildFragment.getActivity();
        SharedPreferences sharedPreferences = fragmentActivity == null ? null : fragmentActivity.getPreferences(0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String string = Constants$SavedItems.SHOW_RESULT_TUTO.getText();
            TutorialResultLiteMainBinding tutorialResultLiteMainBinding = tutorialResultLiteChildFragment._binding;
            Intrinsics.checkNotNull((Object)tutorialResultLiteMainBinding);
            editor.putBoolean(string, true ^ tutorialResultLiteMainBinding.checkBoxShowTutoResult.isChecked());
            editor.apply();
        }
        FeatureFragment featureFragment = tutorialResultLiteChildFragment.featureFragment;
        if (featureFragment == null) {
            return;
        }
        FeatureFragment.replaceFragment$default((FeatureFragment)featureFragment, (String)"resultScanF", (Serializable[])new Serializable[0], null, (int)4, null);
    }
}

