/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  androidx.viewbinding.ViewBinding
 *  dalvik.annotation.MethodParameters
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import dalvik.annotation.MethodParameters;

public final class PopupSynchronizationNeededBinding
implements ViewBinding {
    public final Button buttonAccept;
    public final CheckBox checkBoxHideSynchonization;
    public final ScrollView rootView;

    @MethodParameters(accessFlags={0, 0, 0, 0, 0, 0}, names={"rootView", "buttonAccept", "checkBoxHideSynchonization", "textViewSynchronizationText1", "textViewSynchronizationText2", "textViewSynchronizationTitle"})
    public PopupSynchronizationNeededBinding(ScrollView scrollView, Button button, CheckBox checkBox, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = scrollView;
        this.buttonAccept = button;
        this.checkBoxHideSynchonization = checkBox;
    }

    public View getRoot() {
        return this.rootView;
    }
}

