/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.widget.ImageButton
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.ui.control;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.widget.ImageButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

public class a
extends ImageButton {
    public boolean a;
    public Function0<Unit> b;

    public a(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context);
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter((Object)motionEvent, (String)"event");
        int n2 = motionEvent.getAction();
        int n3 = 1;
        int n4 = n2 == 0 ? n3 : 0;
        if (n4 != 0 && !this.a) {
            this.a = n3;
            Function0<Unit> function0 = this.b;
            if (function0 != null) {
                function0.invoke();
            }
        } else {
            if (motionEvent.getAction() != n3 && motionEvent.getAction() != 3) {
                n3 = 0;
            }
            if (n3 != 0 && this.a) {
                this.a = false;
                Function0<Unit> function0 = this.b;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}

