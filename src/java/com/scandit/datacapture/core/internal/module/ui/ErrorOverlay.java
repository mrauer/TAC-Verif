/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.R;
import kotlin.jvm.internal.Intrinsics;

public final class ErrorOverlay
extends FrameLayout {
    public final TextView a;

    public ErrorOverlay(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context, null, 0);
        this.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1, 17));
        this.setBackgroundColor(1996488704);
        TextView textView = new TextView(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        textView.setGravity(17);
        textView.setLayoutParams(layoutParams);
        textView.setTextAlignment(4);
        textView.setTextColor(-1);
        textView.setBackgroundColor(0);
        int n2 = R.style.pxFromDp((int)20);
        textView.setPadding(n2, n2, n2, n2);
        textView.setTextSize(25.0f);
        textView.setAlpha(0.5f);
        this.a = textView;
        this.addView((View)textView);
    }
}

