/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.DashPathEffect
 *  android.graphics.Typeface
 *  com.github.mikephil.charting.components.Legend
 *  com.github.mikephil.charting.components.YAxis
 *  com.github.mikephil.charting.data.DataSet
 *  com.github.mikephil.charting.data.Entry
 *  com.github.mikephil.charting.utils.MPPointF
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import java.util.List;

public interface IDataSet<T extends Entry> {
    public void calcMinMaxY(float var1, float var2);

    public YAxis.AxisDependency getAxisDependency();

    public int getColor();

    public int getColor(int var1);

    public List<Integer> getColors();

    public List<T> getEntriesForXValue(float var1);

    public int getEntryCount();

    public T getEntryForIndex(int var1);

    public T getEntryForXValue(float var1, float var2);

    public T getEntryForXValue(float var1, float var2, DataSet.Rounding var3);

    public int getEntryIndex(T var1);

    public Legend.LegendForm getForm();

    public DashPathEffect getFormLineDashEffect();

    public float getFormLineWidth();

    public float getFormSize();

    public GradientColor getGradientColor();

    public GradientColor getGradientColor(int var1);

    public List<GradientColor> getGradientColors();

    public MPPointF getIconsOffset();

    public String getLabel();

    public ValueFormatter getValueFormatter();

    public int getValueTextColor(int var1);

    public float getValueTextSize();

    public Typeface getValueTypeface();

    public float getXMax();

    public float getXMin();

    public float getYMax();

    public float getYMin();

    public boolean isDrawIconsEnabled();

    public boolean isDrawValuesEnabled();

    public boolean isHighlightEnabled();

    public boolean isVisible();

    public boolean needsFormatter();

    public void setValueFormatter(ValueFormatter var1);
}

