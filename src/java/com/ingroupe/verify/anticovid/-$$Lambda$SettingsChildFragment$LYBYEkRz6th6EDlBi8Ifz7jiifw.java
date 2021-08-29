/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.SharedPreferences
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.appcompat.view.ContextThemeWrapper
 *  androidx.fragment.app.FragmentActivity
 *  com.ingroupe.verify.anticovid.SettingsChildFragment
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.FragmentActivity;
import com.ingroupe.verify.anticovid.-$$Lambda$SettingsChildFragment$az1ZepHNOkIhmdiO5LDJcDXCEDo;
import com.ingroupe.verify.anticovid.-$$Lambda$SettingsChildFragment$knXFAX_av58pYHH-7lJviTK2Wz0;
import com.ingroupe.verify.anticovid.-$$Lambda$SettingsChildFragment$ziNVQtir3mePESJ0bM9x60mMgwo;
import com.ingroupe.verify.anticovid.SettingsChildFragment;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$SettingsChildFragment$LYBYEkRz6th6EDlBi8Ifz7jiifw
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SettingsChildFragment f$0;
    public final /* synthetic */ SharedPreferences f$1;

    public /* synthetic */ -$$Lambda$SettingsChildFragment$LYBYEkRz6th6EDlBi8Ifz7jiifw(SettingsChildFragment settingsChildFragment, SharedPreferences sharedPreferences) {
        this.f$0 = settingsChildFragment;
        this.f$1 = sharedPreferences;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
        SettingsChildFragment settingsChildFragment = this.f$0;
        SharedPreferences sharedPreferences = this.f$1;
        Intrinsics.checkNotNullParameter((Object)settingsChildFragment, (String)"this$0");
        if (!bl) {
            Button button;
            int n3;
            Context context = settingsChildFragment.getContext();
            if (context == null) {
                return;
            }
            View view = LayoutInflater.from((Context)context).inflate(2131492980, null, false);
            Button button2 = (Button)view.findViewById(n3 = 2131296360);
            if (button2 != null && (button = (Button)view.findViewById(n3 = 2131296363)) != null && (TextView)view.findViewById(n3 = 2131296782) != null && (TextView)view.findViewById(n3 = 2131296783) != null) {
                ScrollView scrollView = (ScrollView)view;
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)new ContextThemeWrapper((Context)settingsChildFragment.getActivity(), 2131886082));
                builder.setView((View)scrollView);
                AlertDialog alertDialog = builder.create();
                Intrinsics.checkNotNullExpressionValue((Object)alertDialog, (String)"Builder(\n                            ContextThemeWrapper(\n                                activity,\n                                R.style.AlertDialogCustom\n                            )\n                        )\n                            .setView(bindingOTModeDialog.root)\n                            .create()");
                alertDialog.show();
                alertDialog.setOnDismissListener((DialogInterface.OnDismissListener)new -$$Lambda$SettingsChildFragment$knXFAX_av58pYHH-7lJviTK2Wz0(settingsChildFragment, context));
                button2.setOnClickListener((View.OnClickListener)new -$$Lambda$SettingsChildFragment$az1ZepHNOkIhmdiO5LDJcDXCEDo(sharedPreferences, alertDialog, settingsChildFragment, context));
                button.setOnClickListener((View.OnClickListener)new -$$Lambda$SettingsChildFragment$ziNVQtir3mePESJ0bM9x60mMgwo(alertDialog));
                return;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n3)));
        }
    }
}

