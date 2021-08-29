/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.mikephil.charting.interfaces.datasets;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;

public interface IBarDataSet
extends IBarLineScatterCandleBubbleDataSet<BarEntry> {
    public int getBarBorderColor();

    public float getBarBorderWidth();

    public int getBarShadowColor();

    public int getHighLightAlpha();

    public String[] getStackLabels();

    public int getStackSize();

    public boolean isStacked();
}

