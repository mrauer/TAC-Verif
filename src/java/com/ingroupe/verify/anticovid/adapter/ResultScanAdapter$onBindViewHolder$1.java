/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
 *  com.ingroupe.verify.anticovid.adapter.ResultScanAdapter
 *  com.ingroupe.verify.anticovid.adapter.ResultScanAdapter$MyViewHolder
 *  com.ingroupe.verify.anticovid.databinding.ResultWarnWebviewViewBinding
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.adapter;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ingroupe.verify.anticovid.adapter.ResultScanAdapter;
import com.ingroupe.verify.anticovid.databinding.ResultWarnWebviewViewBinding;

public final class ResultScanAdapter$onBindViewHolder$1
extends WebViewClient {
    public final /* synthetic */ ResultScanAdapter.MyViewHolder $holder;

    public ResultScanAdapter$onBindViewHolder$1(ResultScanAdapter.MyViewHolder myViewHolder) {
        this.$holder = myViewHolder;
    }

    public void onPageFinished(WebView webView, String string) {
        super.onPageFinished(webView, string);
        ((ResultWarnWebviewViewBinding)this.$holder.binding).rootView.requestLayout();
    }
}

