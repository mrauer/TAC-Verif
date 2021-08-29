/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.CheckBox
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelStoreOwner
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.tutorialresult.ot;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.adapter.IAdapterInterfaceClick;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.databinding.TutorialResultOtMainBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b&\u0010\u0018J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006'"}, d2={"Lcom/ingroupe/verify/anticovid/ui/tutorialresult/ot/TutorialResultOTHelpChildFragment;", "Lcom/ingroupe/verify/anticovid/common/FeatureChildFragment;", "", "Lcom/ingroupe/verify/anticovid/adapter/IAdapterInterfaceClick;", "", "getTitle", "()Ljava/lang/String;", "", "getTitleId", "()Ljava/lang/Integer;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "Landroid/view/Menu;", "menu", "createOptionsMenu", "(Landroid/view/Menu;)V", "Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "showNavigation", "()Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "position", "onItemClick", "(I)V", "Lcom/ingroupe/verify/anticovid/databinding/TutorialResultOtMainBinding;", "_binding", "Lcom/ingroupe/verify/anticovid/databinding/TutorialResultOtMainBinding;", "<init>", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class TutorialResultOTHelpChildFragment
extends FeatureChildFragment
implements IAdapterInterfaceClick {
    public TutorialResultOtMainBinding _binding;

    @Override
    public void createOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter((Object)menu, (String)"menu");
    }

    @Override
    public String getTitle() {
        return "R\u00e9sultat - Tutoriel";
    }

    @Override
    public Integer getTitleId() {
        return 2131820846;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TutorialResultOtMainBinding tutorialResultOtMainBinding;
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this._binding = tutorialResultOtMainBinding = TutorialResultOtMainBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNull((Object)tutorialResultOtMainBinding);
        ConstraintLayout constraintLayout = tutorialResultOtMainBinding.rootView;
        Intrinsics.checkNotNullExpressionValue((Object)constraintLayout, (String)"binding.root");
        FragmentActivity fragmentActivity = this.getActivity();
        SharedViewModel sharedViewModel = fragmentActivity == null ? null : (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)fragmentActivity).get(SharedViewModel.class);
        if (sharedViewModel != null) {
            return constraintLayout;
        }
        throw new Exception("Invalid Activity");
    }

    @Override
    public void onItemClick(int n2) {
    }

    public void onResume() {
        Log.d((String)"tutorialOTHelp", (String)"on Resume");
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)view, (String)"view");
        TutorialResultOtMainBinding tutorialResultOtMainBinding = this._binding;
        Intrinsics.checkNotNull((Object)tutorialResultOtMainBinding);
        tutorialResultOtMainBinding.buttonTutoToResult.setVisibility(8);
        TutorialResultOtMainBinding tutorialResultOtMainBinding2 = this._binding;
        Intrinsics.checkNotNull((Object)tutorialResultOtMainBinding2);
        tutorialResultOtMainBinding2.checkBoxShowTutoResult.setVisibility(8);
    }

    @Override
    public MainActivity.NavigationIcon showNavigation() {
        return MainActivity.NavigationIcon.BACK;
    }
}

