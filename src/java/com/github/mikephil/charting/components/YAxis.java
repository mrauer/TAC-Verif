/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  java.lang.Enum
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.utils.Utils;

public class YAxis
extends AxisBase {
    public AxisDependency mAxisDependency;
    public boolean mDrawBottomYLabelEntry = true;
    public boolean mDrawTopYLabelEntry = true;
    public float mMaxWidth = Float.POSITIVE_INFINITY;
    public YAxisLabelPosition mPosition = YAxisLabelPosition.OUTSIDE_CHART;
    public float mSpacePercentBottom = 10.0f;
    public float mSpacePercentTop = 10.0f;
    public int mZeroLineColor = -7829368;
    public float mZeroLineWidth = 1.0f;

    public YAxis(AxisDependency axisDependency) {
        this.mAxisDependency = axisDependency;
        this.mYOffset = 0.0f;
    }

    @Override
    public void calculate(float f2, float f3) {
        float f4;
        if (Math.abs((float)(f3 - f2)) == 0.0f) {
            f3 += 1.0f;
            f2 -= 1.0f;
        }
        float f5 = Math.abs((float)(f3 - f2));
        float f6 = this.mCustomAxisMin ? this.mAxisMinimum : f2 - f5 / 100.0f * this.mSpacePercentBottom;
        this.mAxisMinimum = f6;
        this.mAxisMaximum = f4 = f3 + f5 / 100.0f * this.mSpacePercentTop;
        this.mAxisRange = Math.abs((float)(f6 - f4));
    }

    public float getRequiredWidthSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        String string = this.getLongestLabel();
        float f2 = (float)((int)paint.measureText(string)) + 2.0f * this.mXOffset;
        float f3 = this.mMaxWidth;
        if (f3 > 0.0f && f3 != Float.POSITIVE_INFINITY) {
            f3 = Utils.convertDpToPixel(f3);
        }
        if (!((double)f3 > 0.0)) {
            f3 = f2;
        }
        return Math.max((float)0.0f, (float)Math.min((float)f2, (float)f3));
    }

    public boolean needsOffset() {
        return this.mEnabled && this.mDrawLabels && this.mPosition == YAxisLabelPosition.OUTSIDE_CHART;
    }

}

