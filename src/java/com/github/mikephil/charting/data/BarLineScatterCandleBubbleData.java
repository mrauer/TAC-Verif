/*
 * Decompiled with CFR 0.0.
 */
package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;

public abstract class BarLineScatterCandleBubbleData<T extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>
extends ChartData<T> {
    public BarLineScatterCandleBubbleData() {
    }

    public /* varargs */ BarLineScatterCandleBubbleData(T ... arrT) {
        super(arrT);
    }
}

