/*
 * Decompiled with CFR 0.0.
 */
package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;

public class BarData
extends BarLineScatterCandleBubbleData<IBarDataSet> {
    public float mBarWidth = 0.85f;

    public BarData() {
    }

    public /* varargs */ BarData(IBarDataSet ... arriBarDataSet) {
        super((IBarLineScatterCandleBubbleDataSet[])arriBarDataSet);
    }
}

