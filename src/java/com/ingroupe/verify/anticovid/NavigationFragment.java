/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.fragment.app.Fragment
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.ingroupe.verify.anticovid.InformationChildFragment;
import com.ingroupe.verify.anticovid.SettingsChildFragment;
import com.ingroupe.verify.anticovid.common.FeatureFragment;
import com.ingroupe.verify.anticovid.ui.actionchoice.ActionChoiceChildFragment;
import com.ingroupe.verify.anticovid.ui.init.InitChildFragment;
import com.ingroupe.verify.anticovid.ui.result.ResultScanChildFragment;
import com.ingroupe.verify.anticovid.ui.scan.ScanChildFragment;
import com.ingroupe.verify.anticovid.ui.statistic.StatisticChildFragment;
import com.ingroupe.verify.anticovid.ui.tutorialresult.lite.TutorialResultLiteChildFragment;
import com.ingroupe.verify.anticovid.ui.tutorialresult.lite.TutorialResultLiteHelpChildFragment;
import com.ingroupe.verify.anticovid.ui.tutorialresult.ot.TutorialResultOTChildFragment;
import com.ingroupe.verify.anticovid.ui.tutorialresult.ot.TutorialResultOTHelpChildFragment;
import com.ingroupe.verify.anticovid.ui.tutorialscan2ddoc.TutorialScan2DDocChildFragment;
import com.ingroupe.verify.anticovid.ui.tutorialscan2ddoc.TutorialScan2DDocHelpChildFragment;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2={"Lcom/ingroupe/verify/anticovid/NavigationFragment;", "Lcom/ingroupe/verify/anticovid/common/FeatureFragment;", "", "tag", "", "Ljava/io/Serializable;", "args", "Landroidx/fragment/app/Fragment;", "createFragment", "(Ljava/lang/String;[Ljava/io/Serializable;)Landroidx/fragment/app/Fragment;", "", "getLayoutId", "()I", "getFirstTag", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "<init>", "()V", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class NavigationFragment
extends FeatureFragment {
    @Override
    public Fragment createFragment(String string, Serializable[] arrserializable) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"tag");
        Intrinsics.checkNotNullParameter((Object)arrserializable, (String)"args");
        switch (string.hashCode()) {
            default: {
                break;
            }
            case 1968600364: {
                if (!string.equals((Object)"information")) break;
                return new InformationChildFragment();
            }
            case 1963709660: {
                if (!string.equals((Object)"tutorialScanHelp")) break;
                return new TutorialScan2DDocHelpChildFragment();
            }
            case 1434631203: {
                if (!string.equals((Object)"settings")) break;
                return new SettingsChildFragment();
            }
            case 1055380931: {
                if (!string.equals((Object)"tutorialOT")) break;
                return new TutorialResultOTChildFragment();
            }
            case 1038862199: {
                if (!string.equals((Object)"actionChoice")) break;
                return new ActionChoiceChildFragment();
            }
            case 936607652: {
                if (!string.equals((Object)"tutorialOTHelp")) break;
                return new TutorialResultOTHelpChildFragment();
            }
            case 724118379: {
                if (!string.equals((Object)"tutorialScan2DDoc")) break;
                return new TutorialScan2DDocChildFragment();
            }
            case 3237136: {
                if (!string.equals((Object)"init")) break;
                return new InitChildFragment();
            }
            case 2570909: {
                if (!string.equals((Object)"Scan")) break;
                return new ScanChildFragment();
            }
            case -77293264: {
                if (!string.equals((Object)"Statistic")) break;
                return new StatisticChildFragment();
            }
            case -365779637: {
                if (!string.equals((Object)"tutorialResult2DDoc")) break;
                return new TutorialResultLiteChildFragment();
            }
            case -548676788: {
                if (!string.equals((Object)"resultScanF")) break;
                return new ResultScanChildFragment();
            }
            case -1812226308: {
                if (!string.equals((Object)"tutorialResultHelp")) break;
                return new TutorialResultLiteHelpChildFragment();
            }
        }
        Log.w((String)"NavigationFragment", (String)"TAG not found");
        return new InitChildFragment();
    }

    @Override
    public String getFirstTag() {
        return "init";
    }

    @Override
    public int getLayoutId() {
        return 2131296415;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return layoutInflater.inflate(2131492963, viewGroup, false);
    }
}

