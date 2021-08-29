/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.core.internal.module.ui.control.TorchButton
 *  com.scandit.datacapture.core.source.Camera
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.ui.control;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.material.R;
import com.scandit.datacapture.core.internal.module.ui.control.TorchButton;
import com.scandit.datacapture.core.source.Camera;
import com.scandit.datacapture.core.source.FrameSource;
import com.scandit.datacapture.core.ui.control.TorchSwitchControl;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

public final class ControlLayout
extends LinearLayout {
    public static final a a = new a(0);
    public static final RelativeLayout.LayoutParams d;
    public static final LinearLayout.LayoutParams e;
    public final ArrayList<?> b;
    public FrameSource c;

    public static {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams.topMargin = R.style.pxFromDp((int)15);
        layoutParams.leftMargin = R.style.pxFromDp((int)15);
        d = layoutParams;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(R.style.pxFromDp((int)40), R.style.pxFromDp((int)40));
        layoutParams2.gravity = 17;
        layoutParams2.rightMargin = R.style.pxFromDp((int)15);
        e = layoutParams2;
    }

    public ControlLayout(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context);
        this.b = new ArrayList();
        this.setOrientation(0);
    }

    public final void a(FrameSource frameSource) {
        this.c = frameSource;
        ArrayList<?> arrayList = this.b;
        ArrayList arrayList2 = new ArrayList();
        for (Object object : arrayList) {
            if (!(object instanceof TorchSwitchControl)) continue;
            arrayList2.add(object);
        }
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            TorchButton torchButton = ((TorchSwitchControl)iterator.next()).b;
            FrameSource frameSource2 = !(frameSource instanceof Camera) ? null : frameSource;
            torchButton.a((Camera)frameSource2);
        }
    }

    public static final class a {
        public a(byte by) {
        }
    }

}

