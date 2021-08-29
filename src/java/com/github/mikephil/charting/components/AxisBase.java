/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.github.mikephil.charting.components;

import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class AxisBase
extends ComponentBase {
    public int mAxisLineColor = -7829368;
    public float mAxisLineWidth = 1.0f;
    public float mAxisMaximum = 0.0f;
    public float mAxisMinimum = 0.0f;
    public float mAxisRange = 0.0f;
    public ValueFormatter mAxisValueFormatter;
    public float[] mCenteredEntries = new float[0];
    public boolean mCustomAxisMin = false;
    public int mDecimals;
    public boolean mDrawAxisLine = true;
    public boolean mDrawGridLines = true;
    public boolean mDrawGridLinesBehindData = true;
    public boolean mDrawLabels = true;
    public float[] mEntries = new float[0];
    public int mEntryCount;
    public float mGranularity = 1.0f;
    public boolean mGranularityEnabled = false;
    public int mGridColor = -7829368;
    public float mGridLineWidth = 1.0f;
    public int mLabelCount = 6;
    public List<LimitLine> mLimitLines;
    public float mSpaceMax = 0.0f;
    public float mSpaceMin = 0.0f;

    public AxisBase() {
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(5.0f);
        this.mLimitLines = new ArrayList();
    }

    public void calculate(float f, float f2) {
        float f3 = f2 + this.mSpaceMax;
        float f4 = this.mCustomAxisMin ? this.mAxisMinimum : f - this.mSpaceMin;
        if (Math.abs((float)(f3 - f4)) == 0.0f) {
            f3 += 1.0f;
            f4 -= 1.0f;
        }
        this.mAxisMinimum = f4;
        this.mAxisMaximum = f3;
        this.mAxisRange = Math.abs((float)(f3 - f4));
    }

    public String getFormattedLabel(int n) {
        if (n >= 0 && n < this.mEntries.length) {
            return this.getValueFormatter().getAxisLabel(this.mEntries[n], this);
        }
        return "";
    }

    public String getLongestLabel() {
        String string = "";
        for (int i = 0; i < this.mEntries.length; ++i) {
            String string2 = this.getFormattedLabel(i);
            if (string2 == null || string.length() >= string2.length()) continue;
            string = string2;
        }
        return string;
    }

    public ValueFormatter getValueFormatter() {
        ValueFormatter valueFormatter = this.mAxisValueFormatter;
        if (valueFormatter == null || valueFormatter instanceof DefaultAxisValueFormatter && ((DefaultAxisValueFormatter)valueFormatter).digits != this.mDecimals) {
            this.mAxisValueFormatter = new DefaultAxisValueFormatter(this.mDecimals);
        }
        return this.mAxisValueFormatter;
    }
}

