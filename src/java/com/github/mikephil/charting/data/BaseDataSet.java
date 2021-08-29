/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.graphics.DashPathEffect
 *  android.graphics.Typeface
 *  com.github.mikephil.charting.components.YAxis
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDataSet<T extends Entry>
implements IDataSet<T> {
    public YAxis.AxisDependency mAxisDependency = YAxis.AxisDependency.LEFT;
    public List<Integer> mColors = new ArrayList();
    public boolean mDrawIcons = true;
    public boolean mDrawValues = true;
    public Legend.LegendForm mForm = Legend.LegendForm.DEFAULT;
    public float mFormLineWidth = Float.NaN;
    public float mFormSize = Float.NaN;
    public boolean mHighlightEnabled = true;
    public MPPointF mIconsOffset = new MPPointF();
    public String mLabel = "DataSet";
    public List<Integer> mValueColors = new ArrayList();
    public transient ValueFormatter mValueFormatter;
    public float mValueTextSize = 17.0f;
    public boolean mVisible = true;

    public BaseDataSet(String string) {
        this.mColors.add((Object)Color.rgb((int)140, (int)234, (int)255));
        this.mValueColors.add((Object)-16777216);
        this.mLabel = string;
    }

    @Override
    public YAxis.AxisDependency getAxisDependency() {
        return this.mAxisDependency;
    }

    @Override
    public int getColor() {
        return (Integer)this.mColors.get(0);
    }

    @Override
    public int getColor(int n) {
        List<Integer> list = this.mColors;
        return (Integer)list.get(n % list.size());
    }

    @Override
    public List<Integer> getColors() {
        return this.mColors;
    }

    @Override
    public Legend.LegendForm getForm() {
        return this.mForm;
    }

    @Override
    public DashPathEffect getFormLineDashEffect() {
        return null;
    }

    @Override
    public float getFormLineWidth() {
        return this.mFormLineWidth;
    }

    @Override
    public float getFormSize() {
        return this.mFormSize;
    }

    @Override
    public GradientColor getGradientColor() {
        return null;
    }

    @Override
    public GradientColor getGradientColor(int n) {
        throw null;
    }

    @Override
    public List<GradientColor> getGradientColors() {
        return null;
    }

    @Override
    public MPPointF getIconsOffset() {
        return this.mIconsOffset;
    }

    @Override
    public String getLabel() {
        return this.mLabel;
    }

    @Override
    public ValueFormatter getValueFormatter() {
        ValueFormatter valueFormatter = this.mValueFormatter;
        boolean bl = valueFormatter == null;
        if (bl) {
            valueFormatter = Utils.mDefaultValueFormatter;
        }
        return valueFormatter;
    }

    @Override
    public int getValueTextColor(int n) {
        List<Integer> list = this.mValueColors;
        return (Integer)list.get(n % list.size());
    }

    @Override
    public float getValueTextSize() {
        return this.mValueTextSize;
    }

    @Override
    public Typeface getValueTypeface() {
        return null;
    }

    @Override
    public boolean isDrawIconsEnabled() {
        return this.mDrawIcons;
    }

    @Override
    public boolean isDrawValuesEnabled() {
        return this.mDrawValues;
    }

    @Override
    public boolean isHighlightEnabled() {
        return this.mHighlightEnabled;
    }

    @Override
    public boolean isVisible() {
        return this.mVisible;
    }

    @Override
    public boolean needsFormatter() {
        return this.mValueFormatter == null;
    }

    @Override
    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            return;
        }
        this.mValueFormatter = valueFormatter;
    }
}

