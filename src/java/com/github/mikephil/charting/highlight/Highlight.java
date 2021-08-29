/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.github.mikephil.charting.components.YAxis
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.mikephil.charting.highlight;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.mikephil.charting.components.YAxis;

public class Highlight {
    public YAxis.AxisDependency axis;
    public int mDataIndex = -1;
    public int mDataSetIndex;
    public float mDrawX;
    public float mDrawY;
    public int mStackIndex = -1;
    public float mX = Float.NaN;
    public float mXPx;
    public float mY = Float.NaN;
    public float mYPx;

    public Highlight(float f3, float f4, float f5, float f6, int n3, YAxis.AxisDependency axisDependency) {
        this.mX = f3;
        this.mY = f4;
        this.mXPx = f5;
        this.mYPx = f6;
        this.mDataSetIndex = n3;
        this.axis = axisDependency;
    }

    public boolean equalTo(Highlight highlight) {
        if (highlight == null) {
            return false;
        }
        return this.mDataSetIndex == highlight.mDataSetIndex && this.mX == highlight.mX && this.mStackIndex == highlight.mStackIndex && this.mDataIndex == highlight.mDataIndex;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Highlight, x: ");
        stringBuilder.append(this.mX);
        stringBuilder.append(", y: ");
        stringBuilder.append(this.mY);
        stringBuilder.append(", dataSetIndex: ");
        stringBuilder.append(this.mDataSetIndex);
        stringBuilder.append(", stackIndex (only stacked barentry): ");
        stringBuilder.append(this.mStackIndex);
        return stringBuilder.toString();
    }
}

