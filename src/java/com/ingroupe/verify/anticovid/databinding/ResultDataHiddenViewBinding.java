/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
 *  dalvik.annotation.MethodParameters
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import dalvik.annotation.MethodParameters;

public final class ResultDataHiddenViewBinding
implements ViewBinding {
    public final ConstraintLayout rootView;

    @MethodParameters(accessFlags={0}, names={"rootView"})
    public ResultDataHiddenViewBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public View getRoot() {
        return this.rootView;
    }
}

