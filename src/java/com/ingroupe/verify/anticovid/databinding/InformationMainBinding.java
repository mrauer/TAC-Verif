/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.viewbinding.ViewBinding
 *  dalvik.annotation.MethodParameters
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import dalvik.annotation.MethodParameters;

public final class InformationMainBinding
implements ViewBinding {
    public final RecyclerView recyclerViewContact;
    public final ConstraintLayout rootView;
    public final TextView textViewContactTitle;
    public final TextView textViewLegal2;
    public final TextView textViewLegal4;
    public final TextView textViewLinkCgu;
    public final TextView textViewLinkPolConf;

    @MethodParameters(accessFlags={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, names={"rootView", "constraintLayoutCgu", "constraintLayoutPolConf", "imageViewLogoIN", "imageViewSeparatorInfo", "recyclerViewContact", "scrollView2", "textViewCguTitle", "textViewContactTitle", "textViewLegal1", "textViewLegal2", "textViewLegal3", "textViewLegal4", "textViewLegal5", "textViewLinkCgu", "textViewLinkPolConf", "textViewLinkPolDesc", "textViewLinkPolText1", "textViewLinkPolText2", "textViewPolConfTitle"})
    public InformationMainBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        this.rootView = constraintLayout;
        this.recyclerViewContact = recyclerView;
        this.textViewContactTitle = textView2;
        this.textViewLegal2 = textView4;
        this.textViewLegal4 = textView6;
        this.textViewLinkCgu = textView8;
        this.textViewLinkPolConf = textView9;
    }

    public View getRoot() {
        return this.rootView;
    }
}

