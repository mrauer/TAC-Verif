/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.Guideline
 *  androidx.viewbinding.ViewBinding
 *  dalvik.annotation.MethodParameters
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import dalvik.annotation.MethodParameters;

public final class StatisticViewBinding
implements ViewBinding {
    public final ConstraintLayout rootView;
    public final TextView textViewCount;
    public final TextView textViewCountDuplicate;
    public final TextView textViewDate;

    @MethodParameters(accessFlags={0, 0, 0, 0, 0, 0}, names={"rootView", "guidelineStat", "guidelineStatDuplicate", "textViewCount", "textViewCountDuplicate", "textViewDate"})
    public StatisticViewBinding(ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.textViewCount = textView;
        this.textViewCountDuplicate = textView2;
        this.textViewDate = textView3;
    }

    public View getRoot() {
        return this.rootView;
    }
}

