/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class BarChart
extends BarLineChartBase<BarData>
implements BarDataProvider {
    public boolean mDrawBarShadow = false;
    public boolean mDrawValueAboveBar = true;
    public boolean mFitBars = false;
    public boolean mHighlightFullBarEnabled = false;

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public void calcMinMax() {
        if (this.mFitBars) {
            XAxis xAxis = this.mXAxis;
            Object t2 = this.mData;
            xAxis.calculate(((BarData)t2).mXMin - ((BarData)t2).mBarWidth / 2.0f, ((BarData)t2).mXMax + ((BarData)t2).mBarWidth / 2.0f);
        } else {
            XAxis xAxis = this.mXAxis;
            Object t3 = this.mData;
            xAxis.calculate(((BarData)t3).mXMin, ((BarData)t3).mXMax);
        }
        YAxis yAxis = this.mAxisLeft;
        BarData barData = (BarData)this.mData;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.calculate(barData.getYMin(axisDependency), ((BarData)this.mData).getYMax(axisDependency));
        YAxis yAxis2 = this.mAxisRight;
        BarData barData2 = (BarData)this.mData;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.calculate(barData2.getYMin(axisDependency2), ((BarData)this.mData).getYMax(axisDependency2));
    }

    @Override
    public BarData getBarData() {
        return (BarData)this.mData;
    }

    @Override
    public Highlight getHighlightByTouchPoint(float f2, float f3) {
        if (this.mData == null) {
            Log.e((String)"MPAndroidChart", (String)"Can't select by touch. No data set.");
            return null;
        }
        Highlight highlight = this.getHighlighter().getHighlight(f2, f3);
        if (highlight != null) {
            if (!this.mHighlightFullBarEnabled) {
                return highlight;
            }
            Highlight highlight2 = new Highlight(highlight.mX, highlight.mY, highlight.mXPx, highlight.mYPx, highlight.mDataSetIndex, highlight.axis);
            highlight2.mStackIndex = -1;
            return highlight2;
        }
        return highlight;
    }

    @Override
    public void init() {
        super.init();
        this.mRenderer = new BarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.setHighlighter(new BarHighlighter(this));
        this.getXAxis().mSpaceMin = 0.5f;
        this.getXAxis().mSpaceMax = 0.5f;
    }

    @Override
    public boolean isDrawBarShadowEnabled() {
        return this.mDrawBarShadow;
    }

    @Override
    public boolean isDrawValueAboveBarEnabled() {
        return this.mDrawValueAboveBar;
    }

    @Override
    public boolean isHighlightFullBarEnabled() {
        return this.mHighlightFullBarEnabled;
    }

    public void setDrawBarShadow(boolean bl) {
        this.mDrawBarShadow = bl;
    }

    public void setDrawValueAboveBar(boolean bl) {
        this.mDrawValueAboveBar = bl;
    }

    public void setFitBars(boolean bl) {
        this.mFitBars = bl;
    }

    public void setHighlightFullBarEnabled(boolean bl) {
        this.mHighlightFullBarEnabled = bl;
    }
}

