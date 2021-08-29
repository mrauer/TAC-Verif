/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.ImageView
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
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import dalvik.annotation.MethodParameters;

public final class TutorialResultLiteMainBinding
implements ViewBinding {
    public final Button buttonTutoToResult;
    public final CheckBox checkBoxShowTutoResult;
    public final ConstraintLayout rootView;
    public final WebView webViewTuto;

    @MethodParameters(accessFlags={0, 0, 0, 0, 0}, names={"rootView", "buttonTutoToResult", "checkBoxShowTutoResult", "imageViewLogoIN", "webViewTuto"})
    public TutorialResultLiteMainBinding(ConstraintLayout constraintLayout, Button button, CheckBox checkBox, ImageView imageView, WebView webView) {
        this.rootView = constraintLayout;
        this.buttonTutoToResult = button;
        this.checkBoxShowTutoResult = checkBox;
        this.webViewTuto = webView;
    }

    @MethodParameters(accessFlags={0, 0, 0}, names={"inflater", "parent", "attachToParent"})
    public static TutorialResultLiteMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        ImageView imageView;
        CheckBox checkBox;
        int n2;
        Button button;
        WebView webView;
        View view = layoutInflater.inflate(2131493029, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        if ((button = (Button)view.findViewById(n2 = 2131296366)) != null && (checkBox = (CheckBox)view.findViewById(n2 = 2131296379)) != null && (imageView = (ImageView)view.findViewById(n2 = 2131296519)) != null && (webView = (WebView)view.findViewById(n2 = 2131296886)) != null) {
            TutorialResultLiteMainBinding tutorialResultLiteMainBinding = new TutorialResultLiteMainBinding((ConstraintLayout)view, button, checkBox, imageView, webView);
            return tutorialResultLiteMainBinding;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
    }

    public View getRoot() {
        return this.rootView;
    }
}

