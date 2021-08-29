/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.common.FeatureFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2={"Lcom/ingroupe/verify/anticovid/common/FeatureChildFragment;", "Landroidx/fragment/app/Fragment;", "", "getTitle", "()Ljava/lang/String;", "", "getTitleId", "()Ljava/lang/Integer;", "Landroid/view/Menu;", "menu", "", "createOptionsMenu", "(Landroid/view/Menu;)V", "Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "showNavigation", "()Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lcom/ingroupe/verify/anticovid/common/FeatureFragment;", "featureFragment", "Lcom/ingroupe/verify/anticovid/common/FeatureFragment;", "getFeatureFragment", "()Lcom/ingroupe/verify/anticovid/common/FeatureFragment;", "setFeatureFragment", "(Lcom/ingroupe/verify/anticovid/common/FeatureFragment;)V", "<init>", "()V", "app_prodRelease"}, k=1, mv={1, 5, 1})
public abstract class FeatureChildFragment
extends Fragment {
    public FeatureFragment featureFragment;

    public abstract void createOptionsMenu(Menu var1);

    public abstract String getTitle();

    public abstract Integer getTitleId();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity != null) {
            fragmentActivity.invalidateOptionsMenu();
        }
        FragmentActivity fragmentActivity2 = this.getActivity();
        if (fragmentActivity2 != null) {
            fragmentActivity2.setRequestedOrientation(1);
        }
        return null;
    }

    public abstract MainActivity.NavigationIcon showNavigation();
}

