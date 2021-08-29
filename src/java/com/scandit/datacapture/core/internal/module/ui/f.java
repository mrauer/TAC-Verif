/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.ui;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scandit.datacapture.core.internal.module.ui.NativeNotificationPresenter;
import com.scandit.datacapture.core.internal.module.ui.f;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

public final class f
extends NativeNotificationPresenter {
    public TextView a;
    public final WeakReference<RelativeLayout> b;
    public final float c;

    public f(WeakReference<RelativeLayout> weakReference, float f2) {
        Intrinsics.checkNotNullParameter(weakReference, (String)"layout");
        this.b = weakReference;
        this.c = f2;
    }

    public static final /* synthetic */ void a(f f2) {
        TextView textView = f2.a;
        if (textView != null) {
            textView.animate().cancel();
            RelativeLayout relativeLayout = (RelativeLayout)f2.b.get();
            if (relativeLayout != null) {
                relativeLayout.removeView((View)textView);
            }
        }
    }

    @Override
    public final void showNotification(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"message");
        RelativeLayout relativeLayout = (RelativeLayout)this.b.get();
        if (relativeLayout != null) {
            relativeLayout.post(new Runnable(relativeLayout, this, string){
                public /* synthetic */ RelativeLayout a;
                public /* synthetic */ f b;
                public /* synthetic */ String c;
                {
                    this.a = relativeLayout;
                    this.b = f2;
                    this.c = string;
                }

                public final void run() {
                    f.a(this.b);
                    f f2 = this.b;
                    RelativeLayout relativeLayout = this.a;
                    Intrinsics.checkNotNullExpressionValue((Object)relativeLayout, (String)"layout");
                    android.content.Context context = relativeLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue((Object)context, (String)"layout.context");
                    String string = this.c;
                    TextView textView = new TextView(context);
                    textView.setBackgroundColor(-1);
                    textView.setAlpha(0.0f);
                    textView.setTextColor(-16777216);
                    textView.setTextSize(2, 14.0f);
                    textView.setText((java.lang.CharSequence)string);
                    float f3 = f2.c;
                    int n2 = (int)(4.0f * f3);
                    int n3 = (int)(f3 * 2.0f);
                    textView.setPadding(n2, n3, n2, n3);
                    f f4 = this.b;
                    android.widget.RelativeLayout$LayoutParams layoutParams = new android.widget.RelativeLayout$LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(14);
                    layoutParams.topMargin = (int)(24.0f * f4.c);
                    RelativeLayout relativeLayout2 = (RelativeLayout)f4.b.get();
                    if (relativeLayout2 != null) {
                        relativeLayout2.addView((View)textView, (android.view.ViewGroup$LayoutParams)layoutParams);
                    }
                    f f5 = this.b;
                    textView.animate().alpha(1.0f).setDuration(200L).setListener((android.animation.Animator$AnimatorListener)new android.animation.AnimatorListenerAdapter(f5, (View)textView){
                        public /* synthetic */ f a;
                        public /* synthetic */ View b;
                        {
                            this.a = f2;
                            this.b = view;
                        }

                        public final void onAnimationEnd(android.animation.Animator animator) {
                            f f2 = this.a;
                            this.b.animate().alpha(0.0f).setStartDelay(1000L).setDuration(200L).setListener((android.animation.Animator$AnimatorListener)new android.animation.AnimatorListenerAdapter(f2){
                                public /* synthetic */ f a;
                                {
                                    this.a = f2;
                                }

                                public final void onAnimationEnd(android.animation.Animator animator) {
                                    f.a(this.a);
                                }
                            }).start();
                        }
                    }).start();
                    f2.a = textView;
                }
            });
        }
    }
}

