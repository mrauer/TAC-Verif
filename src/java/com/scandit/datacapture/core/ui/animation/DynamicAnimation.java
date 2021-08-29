/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.scandit.datacapture.core.ui.animation.DynamicAnimation$10
 *  com.scandit.datacapture.core.ui.animation.DynamicAnimation$11
 *  com.scandit.datacapture.core.ui.animation.DynamicAnimation$12
 *  com.scandit.datacapture.core.ui.animation.DynamicAnimation$13
 *  com.scandit.datacapture.core.ui.animation.DynamicAnimation$14
 *  com.scandit.datacapture.core.ui.animation.DynamicAnimation$2
 *  com.scandit.datacapture.core.ui.animation.DynamicAnimation$4
 *  com.scandit.datacapture.core.ui.animation.SpringAnimation
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Objects
 */
package com.scandit.datacapture.core.ui.animation;

import android.view.View;
import com.scandit.datacapture.core.ui.animation.AnimationHandler;
import com.scandit.datacapture.core.ui.animation.DynamicAnimation;
import com.scandit.datacapture.core.ui.animation.FloatPropertyCompat;
import com.scandit.datacapture.core.ui.animation.SpringAnimation;
import com.scandit.datacapture.core.ui.animation.SpringForce;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public abstract class DynamicAnimation<T extends DynamicAnimation<T>>
implements AnimationHandler.b {
    public static final ViewProperty ALPHA;
    public static final ViewProperty ROTATION;
    public static final ViewProperty ROTATION_X;
    public static final ViewProperty ROTATION_Y;
    public static final ViewProperty SCALE_X;
    public static final ViewProperty SCALE_Y;
    public static final ViewProperty Y;
    public float a = 0.0f;
    public float b = Float.MAX_VALUE;
    public boolean c = false;
    public float e = -3.4028235E38f;
    public boolean f = false;
    public Object g;
    public FloatPropertyCompat h;
    public long i = 0L;
    public float j;
    public final ArrayList<OnAnimationEndListener> k = new ArrayList();
    public final ArrayList<OnAnimationUpdateListener> l = new ArrayList();

    public static {
        SCALE_X = new 10("scaleX");
        SCALE_Y = new 11("scaleY");
        ROTATION = new 12("rotation");
        ROTATION_X = new 13("rotationX");
        ROTATION_Y = new 14("rotationY");
        Y = new 2("y");
        ALPHA = new 4("alpha");
    }

    public <K> DynamicAnimation(K k2, FloatPropertyCompat<K> floatPropertyCompat) {
        this.g = k2;
        this.h = floatPropertyCompat;
        if (floatPropertyCompat != ROTATION && floatPropertyCompat != ROTATION_X && floatPropertyCompat != ROTATION_Y) {
            if (floatPropertyCompat == ALPHA) {
                this.j = 0.00390625f;
                return;
            }
            if (floatPropertyCompat != SCALE_X && floatPropertyCompat != SCALE_Y) {
                this.j = 1.0f;
                return;
            }
            this.j = 0.00390625f;
            return;
        }
        this.j = 0.1f;
    }

    public static <T> void a(ArrayList<T> arrayList) {
        for (int i2 = -1 + arrayList.size(); i2 >= 0; --i2) {
            if (arrayList.get(i2) != null) continue;
            arrayList.remove(i2);
        }
    }

    public final void a(float f2) {
        this.h.setValue(this.g, f2);
        for (int i2 = 0; i2 < this.l.size(); ++i2) {
            if (this.l.get(i2) == null) continue;
            (this.l.get(i2)).onAnimationUpdate(this, this.b, this.a);
        }
        DynamicAnimation.a(this.l);
    }

    @Override
    public boolean doAnimationFrame(long l2) {
        float f2;
        float f3;
        float f4;
        float f5;
        boolean bl;
        long l3 = this.i;
        if (l3 == 0L) {
            this.i = l2;
            this.a(this.b);
            return false;
        }
        long l4 = l2 - l3;
        this.i = l2;
        SpringAnimation springAnimation = (SpringAnimation)this;
        if (springAnimation.g != Float.MAX_VALUE) {
            SpringForce springForce = springAnimation.f;
            double d2 = springAnimation.b;
            double d3 = springAnimation.a;
            long l5 = l4 / 2L;
            a a2 = springForce.a(d2, d3, l5);
            SpringForce springForce2 = springAnimation.f;
            springForce2.i = springAnimation.g;
            springAnimation.g = Float.MAX_VALUE;
            a a3 = springForce2.a(a2.a, a2.b, l5);
            springAnimation.b = a3.a;
            springAnimation.a = a3.b;
        } else {
            a a4 = springAnimation.f.a(springAnimation.b, springAnimation.a, l4);
            springAnimation.b = a4.a;
            springAnimation.a = a4.b;
        }
        springAnimation.b = f4 = Math.max((float)springAnimation.b, (float)springAnimation.e);
        springAnimation.b = f3 = Math.min((float)f4, (float)Float.MAX_VALUE);
        float f6 = springAnimation.a;
        SpringForce springForce = springAnimation.f;
        Objects.requireNonNull((Object)springForce);
        boolean bl2 = (double)Math.abs((float)f6) < springForce.e && (double)Math.abs((float)(f3 - (float)springForce.i)) < springForce.d;
        if (bl2) {
            springAnimation.b = (float)springAnimation.f.i;
            springAnimation.a = 0.0f;
            bl = true;
        } else {
            bl = false;
        }
        this.b = f2 = Math.min((float)this.b, (float)Float.MAX_VALUE);
        this.b = f5 = Math.max((float)f2, (float)this.e);
        this.a(f5);
        if (bl) {
            this.c = false;
            AnimationHandler animationHandler = AnimationHandler.a();
            animationHandler.b.remove((Object)this);
            int n2 = animationHandler.c.indexOf((Object)this);
            if (n2 >= 0) {
                animationHandler.c.set(n2, null);
                animationHandler.g = true;
            }
            this.i = 0L;
            this.f = false;
            for (int i2 = 0; i2 < this.k.size(); ++i2) {
                if (this.k.get(i2) == null) continue;
                (this.k.get(i2)).onAnimationEnd(this, false, this.b, this.a);
            }
            DynamicAnimation.a(this.k);
        }
        return bl;
    }

    public static abstract class ViewProperty
    extends FloatPropertyCompat<View> {
        public ViewProperty(String string, byte by) {
            super(string);
        }
    }

}

