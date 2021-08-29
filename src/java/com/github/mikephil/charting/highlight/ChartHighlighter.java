/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.mikephil.charting.components.YAxis
 *  com.github.mikephil.charting.data.DataSet
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider>
implements IHighlighter {
    public T mChart;
    public List<Highlight> mHighlightBuffer = new ArrayList();

    public ChartHighlighter(T t) {
        this.mChart = t;
    }

    public List<Highlight> buildHighlights(IDataSet iDataSet, int n, float f, DataSet.Rounding rounding) {
        Object t;
        ArrayList arrayList = new ArrayList();
        List list = iDataSet.getEntriesForXValue(f);
        if (list.size() == 0 && (t = iDataSet.getEntryForXValue(f, Float.NaN, rounding)) != null) {
            list = iDataSet.getEntriesForXValue(((Entry)t).getX());
        }
        if (list.size() == 0) {
            return arrayList;
        }
        for (Entry entry : list) {
            MPPointD mPPointD = this.mChart.getTransformer(iDataSet.getAxisDependency()).getPixelForValues(entry.getX(), entry.getY());
            Highlight highlight = new Highlight(entry.getX(), entry.getY(), (float)mPPointD.x, (float)mPPointD.y, n, iDataSet.getAxisDependency());
            arrayList.add((Object)highlight);
        }
        return arrayList;
    }

    public BarLineScatterCandleBubbleData getData() {
        return this.mChart.getData();
    }

    public float getDistance(float f, float f2, float f3, float f4) {
        return (float)Math.hypot((double)(f - f3), (double)(f2 - f4));
    }

    @Override
    public Highlight getHighlight(float f, float f2) {
        MPPointD mPPointD = this.mChart.getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(f, f2);
        float f3 = (float)mPPointD.x;
        MPPointD.pool.recycle(mPPointD);
        return this.getHighlightForX(f3, f, f2);
    }

    public Highlight getHighlightForX(float f, float f2, float f3) {
        YAxis.AxisDependency axisDependency;
        List<Highlight> list;
        this.mHighlightBuffer.clear();
        BarLineScatterCandleBubbleData barLineScatterCandleBubbleData = this.getData();
        int n = 0;
        if (barLineScatterCandleBubbleData == null) {
            list = this.mHighlightBuffer;
        } else {
            int n2 = barLineScatterCandleBubbleData.getDataSetCount();
            for (int i = 0; i < n2; ++i) {
                Object t = barLineScatterCandleBubbleData.getDataSetByIndex(i);
                if (!t.isHighlightEnabled()) continue;
                this.mHighlightBuffer.addAll(this.buildHighlights((IDataSet)t, i, f, DataSet.Rounding.CLOSEST));
            }
            list = this.mHighlightBuffer;
        }
        boolean bl = list.isEmpty();
        Highlight highlight = null;
        if (bl) {
            return null;
        }
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.LEFT;
        float f4 = this.getMinimumDistance(list, f3, axisDependency2);
        if (!(f4 < this.getMinimumDistance(list, f3, axisDependency = YAxis.AxisDependency.RIGHT))) {
            axisDependency2 = axisDependency;
        }
        float f5 = this.mChart.getMaxHighlightDistance();
        while (n < list.size()) {
            float f6;
            Highlight highlight2 = (Highlight)list.get(n);
            if ((axisDependency2 == null || highlight2.axis == axisDependency2) && (f6 = this.getDistance(f2, f3, highlight2.mXPx, highlight2.mYPx)) < f5) {
                highlight = highlight2;
                f5 = f6;
            }
            ++n;
        }
        return highlight;
    }

    public float getMinimumDistance(List<Highlight> list, float f, YAxis.AxisDependency axisDependency) {
        float f2 = Float.MAX_VALUE;
        for (int i = 0; i < list.size(); ++i) {
            float f3;
            Highlight highlight = (Highlight)list.get(i);
            if (highlight.axis != axisDependency || !((f3 = Math.abs((float)(highlight.mYPx - f))) < f2)) continue;
            f2 = f3;
        }
        return f2;
    }
}

