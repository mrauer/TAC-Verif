/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;

public interface BarDataProvider
extends BarLineScatterCandleBubbleDataProvider {
    public BarData getBarData();

    public boolean isDrawBarShadowEnabled();

    public boolean isDrawValueAboveBarEnabled();

    public boolean isHighlightFullBarEnabled();
}

