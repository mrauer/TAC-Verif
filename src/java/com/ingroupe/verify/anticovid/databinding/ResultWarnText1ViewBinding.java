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

public final class ResultWarnText1ViewBinding
implements ViewBinding {
    public final ConstraintLayout rootView;
    public final TextView textViewValue;

    @MethodParameters(accessFlags={0, 0}, names={"rootView", "textViewValue"})
    public ResultWarnText1ViewBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.textViewValue = textView;
    }

    public View getRoot() {
        return this.rootView;
    }
}

