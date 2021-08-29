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

public final class ActionChoicesMainBinding
implements ViewBinding {
    public final ConstraintLayout clOtExpiration;
    public final ConstraintLayout clScan2ddoc;
    public final ImageView imageView2ddoc;
    public final ConstraintLayout rootView;
    public final TextView textViewOTMode;
    public final TextView textViewOtExpText1;
    public final TextView textViewScan2ddoc;

    @MethodParameters(accessFlags={0, 0, 0, 0, 0, 0, 0, 0, 0}, names={"rootView", "clOtExpiration", "clScan2ddoc", "imageView2ddoc", "imageViewLogoIN", "textViewOTMode", "textViewOtExpText1", "textViewOtExpText2", "textViewScan2ddoc"})
    public ActionChoicesMainBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.clOtExpiration = constraintLayout2;
        this.clScan2ddoc = constraintLayout3;
        this.imageView2ddoc = imageView;
        this.textViewOTMode = textView;
        this.textViewOtExpText1 = textView2;
        this.textViewScan2ddoc = textView4;
    }

    public View getRoot() {
        return this.rootView;
    }
}

