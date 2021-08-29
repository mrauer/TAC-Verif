/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  androidx.appcompat.widget.SwitchCompat
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
 *  dalvik.annotation.MethodParameters
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import dalvik.annotation.MethodParameters;

public final class SettingsMainBinding
implements ViewBinding {
    public final Button buttonDoSync;
    public final ConstraintLayout constraintLayoutConfAccess;
    public final ConstraintLayout constraintLayoutToken;
    public final ConstraintLayout rootView;
    public final SwitchCompat switchOtMode;
    public final SwitchCompat switchTutoResult;
    public final SwitchCompat switchTutoScan;
    public final TextView textViewConfTitle;
    public final TextView textViewSyncLabel;
    public final TextView textViewTokenText3;

    @MethodParameters(accessFlags={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, names={"rootView", "buttonDoSync", "constraintLayout3", "constraintLayoutConfAccess", "constraintLayoutSync", "constraintLayoutToken", "imageViewLogoIN", "imageViewSeparator1", "imageViewSeparator2", "imageViewSeparator3", "imageViewSeparator4", "scrollView2", "switchOtMode", "switchTutoResult", "switchTutoScan", "textViewConfText", "textViewConfTitle", "textViewSyncLabel", "textViewSyncTitle", "textViewTokenSwitchWarning", "textViewTokenText1", "textViewTokenText2", "textViewTokenText3", "textViewTokenTitle", "textViewTutoTitle"})
    public SettingsMainBinding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ScrollView scrollView, SwitchCompat switchCompat, SwitchCompat switchCompat2, SwitchCompat switchCompat3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.rootView = constraintLayout;
        this.buttonDoSync = button;
        this.constraintLayoutConfAccess = constraintLayout3;
        this.constraintLayoutToken = constraintLayout5;
        this.switchOtMode = switchCompat;
        this.switchTutoResult = switchCompat2;
        this.switchTutoScan = switchCompat3;
        this.textViewConfTitle = textView2;
        this.textViewSyncLabel = textView3;
        this.textViewTokenText3 = textView8;
    }

    public View getRoot() {
        return this.rootView;
    }
}

