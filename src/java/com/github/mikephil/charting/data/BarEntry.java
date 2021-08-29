/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  java.lang.Math
 */
package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Range;

@SuppressLint(value={"ParcelCreator"})
public class BarEntry
extends Entry {
    public float mNegativeSum;
    public float mPositiveSum;
    public Range[] mRanges;
    public float[] mYVals;

    public BarEntry(float f2, float[] arrf) {
        int n2 = arrf.length;
        int n3 = 0;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < n2; ++i2) {
            f3 += arrf[i2];
        }
        super(f2, f3);
        this.mYVals = arrf;
        int n4 = arrf.length;
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (int i3 = 0; i3 < n4; ++i3) {
            float f6 = arrf[i3];
            if (f6 <= 0.0f) {
                f4 += Math.abs((float)f6);
                continue;
            }
            f5 += f6;
        }
        this.mNegativeSum = f4;
        this.mPositiveSum = f5;
        float[] arrf2 = this.mYVals;
        if (arrf2 != null) {
            Range[] arrrange;
            if (arrf2.length == 0) {
                return;
            }
            this.mRanges = new Range[arrf2.length];
            float f7 = -f4;
            float f8 = 0.0f;
            while (n3 < (arrrange = this.mRanges).length) {
                float f9 = arrf2[n3];
                if (f9 < 0.0f) {
                    float f10 = f7 - f9;
                    arrrange[n3] = new Range(f7, f10);
                    f7 = f10;
                } else {
                    float f11 = f9 + f8;
                    arrrange[n3] = new Range(f8, f11);
                    f8 = f11;
                }
                ++n3;
            }
        }
    }

    @Override
    public float getY() {
        return this.y;
    }
}

