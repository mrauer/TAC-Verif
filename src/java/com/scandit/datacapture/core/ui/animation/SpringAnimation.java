/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.AndroidRuntimeException
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.ui.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import com.scandit.datacapture.core.ui.animation.AnimationHandler;
import com.scandit.datacapture.core.ui.animation.DynamicAnimation;
import com.scandit.datacapture.core.ui.animation.FloatPropertyCompat;
import com.scandit.datacapture.core.ui.animation.SpringForce;
import java.util.ArrayList;

public final class SpringAnimation
extends DynamicAnimation<SpringAnimation> {
    public SpringForce f = null;
    public float g = Float.MAX_VALUE;

    public <K> SpringAnimation(K k2, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k2, floatPropertyCompat);
    }

    public final void animateToFinalPosition(float f2) {
        double d2;
        if (this.c) {
            this.g = f2;
            return;
        }
        if (this.f == null) {
            this.f = new SpringForce(f2);
        }
        SpringForce springForce = this.f;
        springForce.i = d2 = (double)f2;
        if (springForce != null) {
            double d3 = (float)d2;
            if (!(d3 > (double)Float.MAX_VALUE)) {
                if (!(d3 < (double)this.e)) {
                    double d4;
                    springForce.d = d4 = Math.abs((double)(0.75f * this.j));
                    springForce.e = d4 * 62.5;
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        boolean bl = this.c;
                        if (!bl && !bl) {
                            float f3;
                            this.c = true;
                            if (!((DynamicAnimation)this).f) {
                                this.b = this.h.getValue(((DynamicAnimation)this).g);
                            }
                            if (!((f3 = this.b) > Float.MAX_VALUE) && !(f3 < this.e)) {
                                AnimationHandler animationHandler = AnimationHandler.a();
                                if (animationHandler.c.size() == 0) {
                                    if (animationHandler.e == null) {
                                        animationHandler.e = new AnimationHandler.AnimationFrameCallbackProvider(animationHandler.d){
                                            public final Choreographer b;
                                            public final Choreographer.FrameCallback c;
                                            {
                                                this.b = Choreographer.getInstance();
                                                this.c = new Choreographer.FrameCallback(this){
                                                    public /* synthetic */ AnimationHandler.c a;
                                                    {
                                                        this.a = c2;
                                                    }

                                                    public final void doFrame(long l2) {
                                                        AnimationHandler.a a2 = this.a.a;
                                                        a2.a.f = android.os.SystemClock.uptimeMillis();
                                                        AnimationHandler animationHandler = a2.a;
                                                        long l3 = animationHandler.f;
                                                        long l4 = android.os.SystemClock.uptimeMillis();
                                                        int n2 = 0;
                                                        do {
                                                            int n3 = animationHandler.c.size();
                                                            int n4 = 1;
                                                            if (n2 >= n3) break;
                                                            AnimationHandler.b b2 = (AnimationHandler.b)animationHandler.c.get(n2);
                                                            if (b2 != null) {
                                                                java.lang.Long l5 = (java.lang.Long)animationHandler.b.get((Object)b2);
                                                                if (l5 != null) {
                                                                    if (l5 < l4) {
                                                                        animationHandler.b.remove((Object)b2);
                                                                    } else {
                                                                        n4 = 0;
                                                                    }
                                                                }
                                                                if (n4 != 0) {
                                                                    b2.doAnimationFrame(l3);
                                                                }
                                                            }
                                                            ++n2;
                                                        } while (true);
                                                        if (animationHandler.g) {
                                                            for (int i2 = animationHandler.c.size() - n4; i2 >= 0; --i2) {
                                                                if (animationHandler.c.get(i2) != null) continue;
                                                                animationHandler.c.remove(i2);
                                                            }
                                                            animationHandler.g = false;
                                                        }
                                                        if (a2.a.c.size() > 0) {
                                                            AnimationHandler animationHandler2 = a2.a;
                                                            if (animationHandler2.e == null) {
                                                                animationHandler2.e = new /* invalid duplicate definition of identical inner class */;
                                                            }
                                                            AnimationHandler.c c2 = animationHandler2.e;
                                                            c2.b.postFrameCallback(c2.c);
                                                        }
                                                    }
                                                };
                                            }
                                        };
                                    }
                                    AnimationHandler.c c2 = animationHandler.e;
                                    c2.b.postFrameCallback(c2.c);
                                }
                                if (!animationHandler.c.contains((Object)this)) {
                                    animationHandler.c.add((Object)this);
                                    return;
                                }
                            } else {
                                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
                            }
                        }
                        return;
                    }
                    throw new AndroidRuntimeException("Animations may only be started on the main thread");
                }
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }
}

