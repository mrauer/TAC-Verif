/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.List;

public class BarDataSet
implements IBarDataSet {
    public int mBarBorderColor = -16777216;
    public int mBarShadowColor = Color.rgb((int)215, (int)215, (int)215);
    public int mEntryCountStacks;
    public int mHighLightAlpha = 120;
    public int mHighLightColor = Color.rgb((int)255, (int)187, (int)115);
    public String[] mStackLabels;
    public int mStackSize = 1;

    public BarDataSet(List<BarEntry> list, String string) {
        super(list, string);
        int n2 = 0;
        this.mEntryCountStacks = 0;
        this.mStackLabels = new String[]{"Stack"};
        this.mHighLightColor = Color.rgb((int)0, (int)0, (int)0);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            float[] arrf = ((BarEntry)list.get((int)i2)).mYVals;
            if (arrf == null || arrf.length <= this.mStackSize) continue;
            this.mStackSize = arrf.length;
        }
        this.mEntryCountStacks = 0;
        while (n2 < list.size()) {
            float[] arrf = ((BarEntry)list.get((int)n2)).mYVals;
            this.mEntryCountStacks = arrf == null ? 1 + this.mEntryCountStacks : (this.mEntryCountStacks += arrf.length);
            ++n2;
        }
    }

    @Override
    public int getBarBorderColor() {
        return this.mBarBorderColor;
    }

    @Override
    public float getBarBorderWidth() {
        return 0.0f;
    }

    @Override
    public int getBarShadowColor() {
        return this.mBarShadowColor;
    }

    @Override
    public int getHighLightAlpha() {
        return this.mHighLightAlpha;
    }

    @Override
    public int getHighLightColor() {
        return this.mHighLightColor;
    }

    @Override
    public String[] getStackLabels() {
        return this.mStackLabels;
    }

    @Override
    public int getStackSize() {
        return this.mStackSize;
    }

    @Override
    public boolean isStacked() {
        return this.mStackSize > 1;
    }
}

