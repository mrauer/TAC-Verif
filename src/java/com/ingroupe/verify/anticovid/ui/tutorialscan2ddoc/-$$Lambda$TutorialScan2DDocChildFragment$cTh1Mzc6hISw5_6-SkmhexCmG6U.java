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
 *  com.ingroupe.verify.anticovid.ui.tutorialscan2ddoc.TutorialScan2DDocChildFragment
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.tutorialscan2ddoc;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.CheckBox;
import androidx.fragment.app.FragmentActivity;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.FeatureFragment;
import com.ingroupe.verify.anticovid.ui.tutorialscan2ddoc.TutorialScan2DDocChildFragment;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$TutorialScan2DDocChildFragment$cTh1Mzc6hISw5_6-SkmhexCmG6U
implements View.OnClickListener {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ TutorialScan2DDocChildFragment f$1;

    public /* synthetic */ -$$Lambda$TutorialScan2DDocChildFragment$cTh1Mzc6hISw5_6-SkmhexCmG6U(View view, TutorialScan2DDocChildFragment tutorialScan2DDocChildFragment) {
        this.f$0 = view;
        this.f$1 = tutorialScan2DDocChildFragment;
    }

    public final void onClick(View view) {
        FeatureFragment featureFragment;
        SharedPreferences sharedPreferences;
        FragmentActivity fragmentActivity;
        View view2 = this.f$0;
        TutorialScan2DDocChildFragment tutorialScan2DDocChildFragment = this.f$1;
        Intrinsics.checkNotNullParameter((Object)tutorialScan2DDocChildFragment, (String)"this$0");
        CheckBox checkBox = (CheckBox)view2.findViewById(2131296380);
        if (checkBox != null && (sharedPreferences = (fragmentActivity = tutorialScan2DDocChildFragment.getActivity()) == null ? null : fragmentActivity.getPreferences(0)) != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(Constants$SavedItems.SHOW_SCAN_TUTO.getText(), true ^ checkBox.isChecked());
            editor.apply();
        }
        if ((featureFragment = tutorialScan2DDocChildFragment.featureFragment) == null) {
            return;
        }
        FeatureFragment.replaceFragment$default((FeatureFragment)featureFragment, (String)"Scan", (Serializable[])new Serializable[0], null, (int)4, null);
    }
}

