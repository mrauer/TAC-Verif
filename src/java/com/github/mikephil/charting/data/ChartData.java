/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.mikephil.charting.components.YAxis
 *  com.github.mikephil.charting.data.Entry
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.github.mikephil.charting.data;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ChartData<T extends IDataSet<? extends Entry>> {
    public List<T> mDataSets;
    public float mLeftAxisMax = -3.4028235E38f;
    public float mLeftAxisMin = Float.MAX_VALUE;
    public float mRightAxisMax = -3.4028235E38f;
    public float mRightAxisMin = Float.MAX_VALUE;
    public float mXMax = -3.4028235E38f;
    public float mXMin = Float.MAX_VALUE;
    public float mYMax = -3.4028235E38f;
    public float mYMin = Float.MAX_VALUE;

    public ChartData() {
        this.mDataSets = new ArrayList();
    }

    public /* varargs */ ChartData(T ... arrT) {
        ArrayList arrayList = new ArrayList();
        int n3 = arrT.length;
        for (int i3 = 0; i3 < n3; ++i3) {
            arrayList.add(arrT[i3]);
        }
        this.mDataSets = arrayList;
        this.calcMinMax();
    }

    public void calcMinMax() {
        IDataSet iDataSet;
        block18 : {
            IDataSet iDataSet22;
            IDataSet iDataSet3;
            block17 : {
                List<T> list = this.mDataSets;
                if (list == null) {
                    return;
                }
                this.mYMax = -3.4028235E38f;
                this.mYMin = Float.MAX_VALUE;
                this.mXMax = -3.4028235E38f;
                this.mXMin = Float.MAX_VALUE;
                for (IDataSet iDataSet4 : list) {
                    if (this.mYMax < iDataSet4.getYMax()) {
                        this.mYMax = iDataSet4.getYMax();
                    }
                    if (this.mYMin > iDataSet4.getYMin()) {
                        this.mYMin = iDataSet4.getYMin();
                    }
                    if (this.mXMax < iDataSet4.getXMax()) {
                        this.mXMax = iDataSet4.getXMax();
                    }
                    if (this.mXMin > iDataSet4.getXMin()) {
                        this.mXMin = iDataSet4.getXMin();
                    }
                    if (iDataSet4.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                        if (this.mLeftAxisMax < iDataSet4.getYMax()) {
                            this.mLeftAxisMax = iDataSet4.getYMax();
                        }
                        if (!(this.mLeftAxisMin > iDataSet4.getYMin())) continue;
                        this.mLeftAxisMin = iDataSet4.getYMin();
                        continue;
                    }
                    if (this.mRightAxisMax < iDataSet4.getYMax()) {
                        this.mRightAxisMax = iDataSet4.getYMax();
                    }
                    if (!(this.mRightAxisMin > iDataSet4.getYMin())) continue;
                    this.mRightAxisMin = iDataSet4.getYMin();
                }
                this.mLeftAxisMax = -3.4028235E38f;
                this.mLeftAxisMin = Float.MAX_VALUE;
                this.mRightAxisMax = -3.4028235E38f;
                this.mRightAxisMin = Float.MAX_VALUE;
                for (IDataSet iDataSet22 : this.mDataSets) {
                    if (iDataSet22.getAxisDependency() != YAxis.AxisDependency.LEFT) continue;
                    break block17;
                }
                iDataSet22 = null;
            }
            if (iDataSet22 != null) {
                this.mLeftAxisMax = iDataSet22.getYMax();
                this.mLeftAxisMin = iDataSet22.getYMin();
                for (IDataSet iDataSet5 : this.mDataSets) {
                    if (iDataSet5.getAxisDependency() != YAxis.AxisDependency.LEFT) continue;
                    if (iDataSet5.getYMin() < this.mLeftAxisMin) {
                        this.mLeftAxisMin = iDataSet5.getYMin();
                    }
                    if (!(iDataSet5.getYMax() > this.mLeftAxisMax)) continue;
                    this.mLeftAxisMax = iDataSet5.getYMax();
                }
            }
            Iterator iterator = this.mDataSets.iterator();
            do {
                boolean bl = iterator.hasNext();
                iDataSet = null;
                if (!bl) break block18;
            } while ((iDataSet3 = (IDataSet)iterator.next()).getAxisDependency() != YAxis.AxisDependency.RIGHT);
            iDataSet = iDataSet3;
        }
        if (iDataSet != null) {
            this.mRightAxisMax = iDataSet.getYMax();
            this.mRightAxisMin = iDataSet.getYMin();
            for (IDataSet iDataSet6 : this.mDataSets) {
                if (iDataSet6.getAxisDependency() != YAxis.AxisDependency.RIGHT) continue;
                if (iDataSet6.getYMin() < this.mRightAxisMin) {
                    this.mRightAxisMin = iDataSet6.getYMin();
                }
                if (!(iDataSet6.getYMax() > this.mRightAxisMax)) continue;
                this.mRightAxisMax = iDataSet6.getYMax();
            }
        }
    }

    public T getDataSetByIndex(int n3) {
        List<T> list = this.mDataSets;
        if (list != null && n3 >= 0 && n3 < list.size()) {
            return (T)((IDataSet)this.mDataSets.get(n3));
        }
        return null;
    }

    public int getDataSetCount() {
        List<T> list = this.mDataSets;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getEntryCount() {
        Iterator iterator = this.mDataSets.iterator();
        int n3 = 0;
        while (iterator.hasNext()) {
            n3 += ((IDataSet)iterator.next()).getEntryCount();
        }
        return n3;
    }

    public Entry getEntryForHighlight(Highlight highlight) {
        if (highlight.mDataSetIndex >= this.mDataSets.size()) {
            return null;
        }
        return ((IDataSet)this.mDataSets.get(highlight.mDataSetIndex)).getEntryForXValue(highlight.mX, highlight.mY);
    }

    public float getYMax(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f3 = this.mLeftAxisMax;
            if (f3 == -3.4028235E38f) {
                f3 = this.mRightAxisMax;
            }
            return f3;
        }
        float f4 = this.mRightAxisMax;
        if (f4 == -3.4028235E38f) {
            f4 = this.mLeftAxisMax;
        }
        return f4;
    }

    public float getYMin(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f3 = this.mLeftAxisMin;
            if (f3 == Float.MAX_VALUE) {
                f3 = this.mRightAxisMin;
            }
            return f3;
        }
        float f4 = this.mRightAxisMin;
        if (f4 == Float.MAX_VALUE) {
            f4 = this.mLeftAxisMin;
        }
        return f4;
    }
}

