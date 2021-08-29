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

public final class ContactViewBinding
implements ViewBinding {
    public final ConstraintLayout rootView;
    public final TextView textViewContactDetails;
    public final TextView textViewContactMail;
    public final TextView textViewContactName;
    public final TextView textViewContactTel;

    @MethodParameters(accessFlags={0, 0, 0, 0, 0}, names={"rootView", "textViewContactDetails", "textViewContactMail", "textViewContactName", "textViewContactTel"})
    public ContactViewBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.textViewContactDetails = textView;
        this.textViewContactMail = textView2;
        this.textViewContactName = textView3;
        this.textViewContactTel = textView4;
    }

    public View getRoot() {
        return this.rootView;
    }
}

