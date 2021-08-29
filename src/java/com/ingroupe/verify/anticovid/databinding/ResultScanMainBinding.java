/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.ImageView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.viewbinding.ViewBinding
 *  dalvik.annotation.MethodParameters
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import dalvik.annotation.MethodParameters;

public final class ResultScanMainBinding
implements ViewBinding {
    public final Button buttonNewScan;
    public final RecyclerView recyclerViewResult;
    public final ConstraintLayout rootView;

    @MethodParameters(accessFlags={0, 0, 0, 0}, names={"rootView", "buttonNewScan", "imageViewLogoIN", "recyclerViewResult"})
    public ResultScanMainBinding(ConstraintLayout constraintLayout, Button button, ImageView imageView, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.buttonNewScan = button;
        this.recyclerViewResult = recyclerView;
    }

    public View getRoot() {
        return this.rootView;
    }
}

