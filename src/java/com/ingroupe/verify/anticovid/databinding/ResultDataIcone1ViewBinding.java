/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
 *  dalvik.annotation.MethodParameters
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import dalvik.annotation.MethodParameters;

public final class ResultDataIcone1ViewBinding
implements ViewBinding {
    public final ConstraintLayout rootView;
    public final TextView textViewLabel;
    public final TextView textViewValue;

    @MethodParameters(accessFlags={0, 0, 0, 0}, names={"rootView", "imageView4", "textViewLabel", "textViewValue"})
    public ResultDataIcone1ViewBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.textViewLabel = textView;
        this.textViewValue = textView2;
    }

    public View getRoot() {
        return this.rootView;
    }
}

