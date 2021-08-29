/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.mikephil.charting.data.BarEntry
 *  com.github.mikephil.charting.data.Entry
 *  com.github.mikephil.charting.interfaces.datasets.IBarDataSet
 *  java.lang.Math
 *  java.lang.Object
 */
package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

public class BarBuffer {
    public final float[] buffer;
    public int index = 0;
    public float mBarWidth;
    public boolean mContainsStacks;
    public boolean mInverted;
    public float phaseX = 1.0f;
    public float phaseY = 1.0f;

    public BarBuffer(int n3, int n4, boolean bl) {
        this.buffer = new float[n3];
        this.mContainsStacks = false;
        this.mInverted = false;
        this.mBarWidth = 1.0f;
        this.mContainsStacks = bl;
    }

    public void addBar(float f3, float f4, float f5, float f6) {
        int n3;
        int n4;
        int n5;
        float[] arrf = this.buffer;
        int n6 = this.index;
        this.index = n3 = n6 + 1;
        arrf[n6] = f3;
        this.index = n5 = n3 + 1;
        arrf[n3] = f4;
        this.index = n4 = n5 + 1;
        arrf[n5] = f5;
        this.index = n4 + 1;
        arrf[n4] = f6;
    }

    public void feed(IBarDataSet iBarDataSet) {
        float f3 = (float)iBarDataSet.getEntryCount() * this.phaseX;
        float f4 = this.mBarWidth / 2.0f;
        int n3 = 0;
        while ((float)n3 < f3) {
            BarEntry barEntry = (BarEntry)iBarDataSet.getEntryForIndex(n3);
            if (barEntry != null) {
                float f5 = barEntry.x;
                float f6 = barEntry.y;
                float[] arrf = barEntry.mYVals;
                if (this.mContainsStacks && arrf != null) {
                    float f7 = -barEntry.mNegativeSum;
                    float f8 = 0.0f;
                    for (int i3 = 0; i3 < arrf.length; ++i3) {
                        float f9;
                        float f10;
                        float f11;
                        float f12 = arrf[i3];
                        float f13 = f12 FCMPL 0.0f;
                        if (f13 == false && (f8 == 0.0f || f7 == 0.0f)) {
                            f11 = f12;
                            f10 = f7;
                            f7 = f11;
                        } else if (f13 >= 0) {
                            f11 = f12 + f8;
                            f10 = f7;
                            f7 = f8;
                            f8 = f11;
                        } else {
                            f11 = f7 + Math.abs((float)f12);
                            f10 = f7 + Math.abs((float)f12);
                        }
                        float f14 = f5 - f4;
                        float f15 = f5 + f4;
                        if (this.mInverted) {
                            f9 = f7 >= f11 ? f7 : f11;
                            if (!(f7 <= f11)) {
                                f7 = f11;
                            }
                        } else {
                            float f16 = f7 >= f11 ? f7 : f11;
                            if (!(f7 <= f11)) {
                                f7 = f11;
                            }
                            float f17 = f7;
                            f7 = f16;
                            f9 = f17;
                        }
                        float f18 = this.phaseY;
                        this.addBar(f14, f7 * f18, f15, f9 * f18);
                        f7 = f10;
                    }
                } else {
                    float f19;
                    float f20 = f5 - f4;
                    float f21 = f5 + f4;
                    if (this.mInverted) {
                        f19 = f6 >= 0.0f ? f6 : 0.0f;
                        if (!(f6 <= 0.0f)) {
                            f6 = 0.0f;
                        }
                    } else {
                        float f22 = f6 >= 0.0f ? f6 : 0.0f;
                        if (!(f6 <= 0.0f)) {
                            f6 = 0.0f;
                        }
                        float f23 = f6;
                        f6 = f22;
                        f19 = f23;
                    }
                    if (f6 > 0.0f) {
                        f6 *= this.phaseY;
                    } else {
                        f19 *= this.phaseY;
                    }
                    this.addBar(f20, f6, f21, f19);
                }
            }
            ++n3;
        }
        this.index = 0;
    }
}

