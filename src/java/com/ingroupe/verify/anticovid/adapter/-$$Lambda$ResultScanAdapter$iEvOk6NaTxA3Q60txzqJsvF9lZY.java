/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.webkit.WebView
 *  androidx.viewbinding.ViewBinding
 *  com.ingroupe.verify.anticovid.adapter.ResultScanAdapter
 *  com.ingroupe.verify.anticovid.adapter.ResultScanAdapter$MyViewHolder
 *  com.ingroupe.verify.anticovid.databinding.ResultWarnWebviewViewBinding
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.adapter;

import android.view.View;
import android.webkit.WebView;
import androidx.viewbinding.ViewBinding;
import com.ingroupe.verify.anticovid.adapter.ResultScanAdapter;
import com.ingroupe.verify.anticovid.databinding.ResultWarnWebviewViewBinding;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$ResultScanAdapter$iEvOk6NaTxA3Q60txzqJsvF9lZY
implements View.OnClickListener {
    public final /* synthetic */ ResultScanAdapter.MyViewHolder f$0;

    public /* synthetic */ -$$Lambda$ResultScanAdapter$iEvOk6NaTxA3Q60txzqJsvF9lZY(ResultScanAdapter.MyViewHolder myViewHolder) {
        this.f$0 = myViewHolder;
    }

    public final void onClick(View view) {
        ResultScanAdapter.MyViewHolder myViewHolder = this.f$0;
        Intrinsics.checkNotNullParameter((Object)myViewHolder, (String)"$holder");
        WebView webView = ((ResultWarnWebviewViewBinding)myViewHolder.binding).webViewMessageDetail;
        int n3 = webView.getVisibility() == 0 ? 8 : 0;
        webView.setVisibility(n3);
    }
}

