/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.tutorialscan2ddoc;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.databinding.TutorialScan2ddocMainBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2={"Lcom/ingroupe/verify/anticovid/ui/tutorialscan2ddoc/TutorialScan2DDocHelpChildFragment;", "Lcom/ingroupe/verify/anticovid/common/FeatureChildFragment;", "", "getTitle", "()Ljava/lang/String;", "", "getTitleId", "()Ljava/lang/Integer;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "createOptionsMenu", "(Landroid/view/Menu;)V", "Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "showNavigation", "()Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "Lcom/ingroupe/verify/anticovid/databinding/TutorialScan2ddocMainBinding;", "_binding", "Lcom/ingroupe/verify/anticovid/databinding/TutorialScan2ddocMainBinding;", "<init>", "()V", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class TutorialScan2DDocHelpChildFragment
extends FeatureChildFragment {
    public TutorialScan2ddocMainBinding _binding;

    @Override
    public void createOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter((Object)menu, (String)"menu");
    }

    @Override
    public String getTitle() {
        return "Scan du 2D-Doc";
    }

    @Override
    public Integer getTitleId() {
        return 2131820848;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView;
        CheckBox checkBox;
        ImageView imageView;
        ImageView imageView2;
        TextView textView2;
        TextView textView3;
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View view = layoutInflater.inflate(2131493031, viewGroup, false);
        int n2 = 2131296367;
        Button button = (Button)view.findViewById(n2);
        if (button != null && (checkBox = (CheckBox)view.findViewById(n2 = 2131296380)) != null && (imageView = (ImageView)view.findViewById(n2 = 2131296510)) != null && (imageView2 = (ImageView)view.findViewById(n2 = 2131296519)) != null && (textView2 = (TextView)view.findViewById(n2 = 2131296809)) != null && (textView = (TextView)view.findViewById(n2 = 2131296810)) != null && (textView3 = (TextView)view.findViewById(n2 = 2131296836)) != null) {
            TutorialScan2ddocMainBinding tutorialScan2ddocMainBinding;
            ConstraintLayout constraintLayout = (ConstraintLayout)view;
            this._binding = tutorialScan2ddocMainBinding = new TutorialScan2ddocMainBinding(constraintLayout, button, checkBox, imageView, imageView2, textView2, textView, textView3);
            Intrinsics.checkNotNull((Object)tutorialScan2ddocMainBinding);
            Intrinsics.checkNotNullExpressionValue((Object)constraintLayout, (String)"binding.root");
            return constraintLayout;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)view, (String)"view");
        TutorialScan2ddocMainBinding tutorialScan2ddocMainBinding = this._binding;
        Intrinsics.checkNotNull((Object)tutorialScan2ddocMainBinding);
        tutorialScan2ddocMainBinding.buttonTutoToScan.setVisibility(4);
        TutorialScan2ddocMainBinding tutorialScan2ddocMainBinding2 = this._binding;
        Intrinsics.checkNotNull((Object)tutorialScan2ddocMainBinding2);
        tutorialScan2ddocMainBinding2.checkBoxShowTutoScan.setVisibility(4);
    }

    @Override
    public MainActivity.NavigationIcon showNavigation() {
        return MainActivity.NavigationIcon.BACK;
    }
}

