/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.mikephil.charting.data.BarEntry
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.adapter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import kotlin.jvm.internal.Intrinsics;

public final class StatisticAdapter$drawChart$yFormatter$1
extends ValueFormatter {
    @Override
    public String getAxisLabel(float f2, AxisBase axisBase) {
        Intrinsics.checkNotNullParameter((Object)axisBase, (String)"axis");
        return String.valueOf((int)((int)f2));
    }

    @Override
    public String getBarLabel(BarEntry barEntry) {
        return String.valueOf((Object)((int)barEntry.y));
    }

    @Override
    public String getFormattedValue(float f2) {
        return String.valueOf((int)((int)f2));
    }
}

