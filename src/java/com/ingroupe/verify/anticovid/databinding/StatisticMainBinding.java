/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ImageView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.viewbinding.ViewBinding
 *  dalvik.annotation.MethodParameters
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import dalvik.annotation.MethodParameters;

public final class StatisticMainBinding
implements ViewBinding {
    public final ConstraintLayout rootView;
    public final RecyclerView rvStats;

    @MethodParameters(accessFlags={0, 0, 0}, names={"rootView", "imageViewLogoIN", "rvStats"})
    public StatisticMainBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.rvStats = recyclerView;
    }

    public View getRoot() {
        return this.rootView;
    }
}

