/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
 *  dalvik.annotation.MethodParameters
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import dalvik.annotation.MethodParameters;

public final class TutorialScan2ddocMainBinding
implements ViewBinding {
    public final Button buttonTutoToScan;
    public final CheckBox checkBoxShowTutoScan;
    public final ConstraintLayout rootView;

    @MethodParameters(accessFlags={0, 0, 0, 0, 0, 0, 0, 0}, names={"rootView", "buttonTutoToScan", "checkBoxShowTutoScan", "imageView10", "imageViewLogoIN", "textViewLine1", "textViewLine2", "textViewTitle"})
    public TutorialScan2ddocMainBinding(ConstraintLayout constraintLayout, Button button, CheckBox checkBox, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.buttonTutoToScan = button;
        this.checkBoxShowTutoScan = checkBox;
    }

    public View getRoot() {
        return this.rootView;
    }
}

