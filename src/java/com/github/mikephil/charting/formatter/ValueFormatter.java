/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.mikephil.charting.components.AxisBase
 *  com.github.mikephil.charting.data.BarEntry
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseEntry;

public abstract class ValueFormatter {
    public String getAxisLabel(float f3, AxisBase axisBase) {
        return this.getFormattedValue(f3);
    }

    public String getBarLabel(BarEntry barEntry) {
        return this.getFormattedValue(barEntry.y);
    }

    public String getFormattedValue(float f3) {
        return String.valueOf((float)f3);
    }
}

