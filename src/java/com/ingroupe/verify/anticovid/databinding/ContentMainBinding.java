/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
 *  dalvik.annotation.MethodParameters
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import dalvik.annotation.MethodParameters;

public final class ContentMainBinding
implements ViewBinding {
    public final ConstraintLayout clCustomSnackbar;
    public final ConstraintLayout rootView;
    public final TextView textViewCsLine1;
    public final TextView textViewCsLine2;

    @MethodParameters(accessFlags={0, 0, 0, 0, 0}, names={"rootView", "clCustomSnackbar", "mainContainer", "textViewCsLine1", "textViewCsLine2"})
    public ContentMainBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clCustomSnackbar = constraintLayout2;
        this.textViewCsLine1 = textView;
        this.textViewCsLine2 = textView2;
    }

    public View getRoot() {
        return this.rootView;
    }
}

