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

public final class ResultValidityOkViewBinding
implements ViewBinding {
    public final ConstraintLayout rootView;
    public final TextView textViewValidity;

    @MethodParameters(accessFlags={0, 0, 0}, names={"rootView", "imageView2", "textViewValidity"})
    public ResultValidityOkViewBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.textViewValidity = textView;
    }

    public View getRoot() {
        return this.rootView;
    }
}

