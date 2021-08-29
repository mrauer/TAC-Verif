/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.tutorialscan2ddoc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.ui.tutorialscan2ddoc.-$$Lambda$TutorialScan2DDocChildFragment$cTh1Mzc6hISw5_6-SkmhexCmG6U;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2={"Lcom/ingroupe/verify/anticovid/ui/tutorialscan2ddoc/TutorialScan2DDocChildFragment;", "Lcom/ingroupe/verify/anticovid/common/FeatureChildFragment;", "", "getTitle", "()Ljava/lang/String;", "", "getTitleId", "()Ljava/lang/Integer;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/view/Menu;", "menu", "", "createOptionsMenu", "(Landroid/view/Menu;)V", "Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "showNavigation", "()Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "<init>", "()V", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class TutorialScan2DDocChildFragment
extends FeatureChildFragment {
    public static final /* synthetic */ int $r8$clinit;

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
        return 2131820847;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View view = layoutInflater.inflate(2131493031, viewGroup, false);
        View view2 = view.findViewById(2131296367);
        Objects.requireNonNull((Object)view2, (String)"null cannot be cast to non-null type android.widget.Button");
        ((Button)view2).setOnClickListener((View.OnClickListener)new -$$Lambda$TutorialScan2DDocChildFragment$cTh1Mzc6hISw5_6-SkmhexCmG6U(view, this));
        return view;
    }

    @Override
    public MainActivity.NavigationIcon showNavigation() {
        return MainActivity.NavigationIcon.BACK;
    }
}

