/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
 *  dalvik.annotation.MethodParameters
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.databinding;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import dalvik.annotation.MethodParameters;

public final class ResultDataFormat1ViewBinding
implements ViewBinding {
    public final ConstraintLayout rootView;
    public final TextView textViewLabel;
    public final TextView textViewValue;

    @MethodParameters(accessFlags={0, 0, 0}, names={"rootView", "textViewLabel", "textViewValue"})
    public ResultDataFormat1ViewBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.textViewLabel = textView;
        this.textViewValue = textView2;
    }

    @MethodParameters(accessFlags={0, 0, 0}, names={"inflater", "parent", "attachToParent"})
    public static ResultDataFormat1ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        int n2;
        TextView textView;
        TextView textView2;
        View view = layoutInflater.inflate(2131492988, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        if ((textView = (TextView)view.findViewById(n2 = 2131296803)) != null && (textView2 = (TextView)view.findViewById(n2 = 2131296845)) != null) {
            return new ResultDataFormat1ViewBinding((ConstraintLayout)view, textView, textView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
    }

    public View getRoot() {
        return this.rootView;
    }
}

