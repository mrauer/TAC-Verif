/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.mikephil.charting.components.YAxis
 *  java.lang.Object
 */
package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider
extends ChartInterface {
    @Override
    public BarLineScatterCandleBubbleData getData();

    public Transformer getTransformer(YAxis.AxisDependency var1);

    public boolean isInverted(YAxis.AxisDependency var1);
}

