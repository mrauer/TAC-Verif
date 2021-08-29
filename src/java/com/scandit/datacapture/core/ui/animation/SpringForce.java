/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.ui.animation.DynamicAnimation
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.ui.animation;

import com.scandit.datacapture.core.ui.animation.DynamicAnimation;

public final class SpringForce {
    public double a = 1.0;
    public double b = Math.sqrt((double)1500.0);
    public boolean c = false;
    public double d;
    public double e;
    public double f;
    public double g;
    public double h;
    public double i = Double.MAX_VALUE;
    public final DynamicAnimation.a j = new DynamicAnimation.a();

    public SpringForce() {
    }

    public SpringForce(float f2) {
        this.i = f2;
    }

    public final DynamicAnimation.a a(double d2, double d3, long l2) {
        double d4;
        double d5;
        if (!this.c) {
            if (this.i != Double.MAX_VALUE) {
                double d6 = this.a;
                if (d6 > 1.0) {
                    double d7 = -d6;
                    double d8 = this.b;
                    this.f = d7 * d8 + d8 * Math.sqrt((double)(d6 * d6 - 1.0));
                    double d9 = this.a;
                    double d10 = -d9;
                    double d11 = this.b;
                    this.g = d10 * d11 - d11 * Math.sqrt((double)(d9 * d9 - 1.0));
                } else if (d6 >= 0.0 && d6 < 1.0) {
                    this.h = this.b * Math.sqrt((double)(1.0 - d6 * d6));
                }
                this.c = true;
            } else {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
        }
        double d12 = (double)l2 / 1000.0;
        double d13 = d2 - this.i;
        double d14 = this.a;
        if (d14 > 1.0) {
            double d15 = this.g;
            double d16 = d15 * d13 - d3;
            double d17 = this.f;
            double d18 = d13 - d16 / (d15 - d17);
            double d19 = (d13 * d15 - d3) / (d15 - d17);
            d4 = d18 * Math.pow((double)2.718281828459045, (double)(d15 * d12)) + d19 * Math.pow((double)2.718281828459045, (double)(d12 * this.f));
            double d20 = this.g;
            double d21 = d18 * d20 * Math.pow((double)2.718281828459045, (double)(d20 * d12));
            double d22 = this.f;
            d5 = d21 + d19 * d22 * Math.pow((double)2.718281828459045, (double)(d22 * d12));
        } else if (d14 == 1.0) {
            double d23 = this.b;
            double d24 = d3 + d23 * d13;
            double d25 = d13 + d24 * d12;
            double d26 = d25 * Math.pow((double)2.718281828459045, (double)(d12 * -d23));
            double d27 = d25 * Math.pow((double)2.718281828459045, (double)(d12 * -this.b));
            double d28 = this.b;
            d5 = d27 * -d28 + d24 * Math.pow((double)2.718281828459045, (double)(d12 * -d28));
            d4 = d26;
        } else {
            double d29 = 1.0 / this.h;
            double d30 = this.b;
            double d31 = d29 * (d3 + d13 * (d14 * d30));
            double d32 = Math.pow((double)2.718281828459045, (double)(d12 * (d30 * -d14))) * (d13 * Math.cos((double)(d12 * this.h)) + d31 * Math.sin((double)(d12 * this.h)));
            double d33 = this.b;
            double d34 = d32 * -d33;
            double d35 = this.a;
            double d36 = d34 * d35;
            double d37 = Math.pow((double)2.718281828459045, (double)(d12 * (d33 * -d35)));
            double d38 = this.h;
            double d39 = d13 * -d38 * Math.sin((double)(d38 * d12));
            double d40 = this.h;
            d5 = d36 + d37 * (d39 + d31 * d40 * Math.cos((double)(d40 * d12)));
            d4 = d32;
        }
        DynamicAnimation.a a2 = this.j;
        a2.a = (float)(d4 + this.i);
        a2.b = (float)d5;
        return a2;
    }
}

