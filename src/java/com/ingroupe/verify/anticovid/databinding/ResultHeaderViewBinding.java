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

public final class ResultHeaderViewBinding
implements ViewBinding {
    public final ConstraintLayout rootView;
    public final TextView textViewGroupName;

    @MethodParameters(accessFlags={0, 0, 0}, names={"rootView", "imageView2", "textViewGroupName"})
    public ResultHeaderViewBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.textViewGroupName = textView;
    }

    public View getRoot() {
        return this.rootView;
    }
}

