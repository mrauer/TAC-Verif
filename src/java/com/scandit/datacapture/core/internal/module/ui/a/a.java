/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.core.internal.module.ui.a.a$a
 *  com.scandit.datacapture.core.internal.module.ui.a.a$b
 *  com.scandit.datacapture.core.internal.module.ui.a.a$c
 *  com.scandit.datacapture.core.internal.module.ui.a.a$d
 *  com.scandit.datacapture.core.internal.module.ui.a.a$e
 *  com.scandit.datacapture.core.internal.module.ui.a.a$g
 *  com.scandit.datacapture.core.ui.animation.SpringAnimation
 *  java.lang.CharSequence
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  kotlin.Lazy
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.ui.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.R;
import com.scandit.datacapture.core.internal.module.ui.a.a;
import com.scandit.datacapture.core.ui.animation.DynamicAnimation;
import com.scandit.datacapture.core.ui.animation.SpringAnimation;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

public final class a
implements com.scandit.datacapture.core.internal.module.ui.a.c {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;

    public a(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter((Object)viewGroup, (String)"container");
        this.a = R.style.lazy((Function0)new d(viewGroup));
        this.b = R.style.lazy((Function0)new e(this));
        this.c = R.style.lazy((Function0)new c(this));
        this.d = R.style.lazy((Function0)new a(this));
        this.e = R.style.lazy((Function0)new g(this));
    }

    public final TextView a() {
        return (TextView)this.a.getValue();
    }

    @Override
    public final void a(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"text");
        this.a().setText((CharSequence)string);
    }

    @Override
    public final void a(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, (String)"then");
        ((SpringAnimation)this.d.getValue()).animateToFinalPosition(0.0f);
        SpringAnimation springAnimation = (SpringAnimation)this.e.getValue();
        springAnimation.animateToFinalPosition(((Number)this.b.getValue()).floatValue());
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = new DynamicAnimation.OnAnimationEndListener(springAnimation, (Function0)new b(this, function0)){
            public /* synthetic */ SpringAnimation a;
            public /* synthetic */ Function0 b;
            {
                this.a = springAnimation;
                this.b = function0;
            }

            public final void onAnimationEnd(DynamicAnimation<?> dynamicAnimation, boolean bl, float f2, float f3) {
                ArrayList<DynamicAnimation.OnAnimationEndListener> arrayList = this.a.k;
                int n2 = arrayList.indexOf((Object)this);
                if (n2 >= 0) {
                    arrayList.set(n2, null);
                }
                this.b.invoke();
            }
        };
        if (!springAnimation.k.contains((Object)onAnimationEndListener)) {
            springAnimation.k.add((Object)onAnimationEndListener);
        }
    }

    @Override
    public final View b() {
        return this.a();
    }

    @Override
    public final void c() {
        ((SpringAnimation)this.d.getValue()).animateToFinalPosition(1.0f);
        ((SpringAnimation)this.e.getValue()).animateToFinalPosition(((Number)this.c.getValue()).floatValue());
    }

}

