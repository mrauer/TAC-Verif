/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.webkit.WebView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
 *  dalvik.annotation.MethodParameters
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.databinding;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import dalvik.annotation.MethodParameters;

public final class ResultWarnWebviewViewBinding
implements ViewBinding {
    public final ConstraintLayout constraintLayoutMessage;
    public final ConstraintLayout rootView;
    public final TextView textViewMessageTitle;
    public final WebView webViewMessageDetail;

    @MethodParameters(accessFlags={0, 0, 0, 0, 0}, names={"rootView", "constraintLayoutMessage", "textViewClick", "textViewMessageTitle", "webViewMessageDetail"})
    public ResultWarnWebviewViewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, WebView webView) {
        this.rootView = constraintLayout;
        this.constraintLayoutMessage = constraintLayout2;
        this.textViewMessageTitle = textView2;
        this.webViewMessageDetail = webView;
    }

    public View getRoot() {
        return this.rootView;
    }
}

