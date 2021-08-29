/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 */
package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;

public class BarHighlighter
extends ChartHighlighter<BarDataProvider> {
    public BarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    @Override
    public BarLineScatterCandleBubbleData getData() {
        return ((BarDataProvider)this.mChart).getBarData();
    }

    @Override
    public float getDistance(float f2, float f3, float f4, float f5) {
        return Math.abs((float)(f2 - f4));
    }

    @Override
    public Highlight getHighlight(float f2, float f3) {
        Highlight highlight = super.getHighlight(f2, f3);
        if (highlight == null) {
            return null;
        }
        MPPointD mPPointD = this.mChart.getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(f2, f3);
        IBarDataSet iBarDataSet = (IBarDataSet)((BarDataProvider)this.mChart).getBarData().getDataSetByIndex(highlight.mDataSetIndex);
        if (iBarDataSet.isStacked()) {
            return this.getStackedHighlight(highlight, iBarDataSet, (float)mPPointD.x, (float)mPPointD.y);
        }
        MPPointD.pool.recycle(mPPointD);
        return highlight;
    }

    public Highlight getStackedHighlight(Highlight highlight, IBarDataSet iBarDataSet, float f2, float f3) {
        BarEntry barEntry = (BarEntry)iBarDataSet.getEntryForXValue(f2, f3);
        if (barEntry == null) {
            return null;
        }
        if (barEntry.mYVals == null) {
            return highlight;
        }
        Range[] arrrange = barEntry.mRanges;
        if (arrrange.length > 0) {
            BarHighlighter barHighlighter;
            int n2;
            block9 : {
                int n3;
                if (arrrange.length == 0) {
                    n3 = 0;
                } else {
                    int n4;
                    int n5 = arrrange.length;
                    int n6 = 0;
                    n2 = 0;
                    do {
                        n4 = 1;
                        if (n6 >= n5) break;
                        Range range = arrrange[n6];
                        if (!(f3 > range.from) || !(f3 <= range.to)) {
                            n4 = 0;
                        }
                        if (n4 != 0) {
                            barHighlighter = this;
                            break block9;
                        }
                        ++n2;
                        ++n6;
                    } while (true);
                    int n7 = Math.max((int)(arrrange.length - n4), (int)0);
                    float f4 = f3 FCMPL arrrange[n7].to;
                    n3 = 0;
                    if (f4 > 0) {
                        n3 = n7;
                    }
                }
                barHighlighter = this;
                n2 = n3;
            }
            MPPointD mPPointD = ((BarDataProvider)barHighlighter.mChart).getTransformer(iBarDataSet.getAxisDependency()).getPixelForValues(highlight.mX, arrrange[n2].to);
            Highlight highlight2 = new Highlight(barEntry.x, barEntry.y, (float)mPPointD.x, (float)mPPointD.y, highlight.mDataSetIndex, highlight.axis);
            highlight2.mStackIndex = n2;
            MPPointD.pool.recycle(mPPointD);
            return highlight2;
        }
        return null;
    }
}

