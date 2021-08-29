/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.github.mikephil.charting.data.BarDataSet
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
package com.github.mikephil.charting.data;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseDataSet;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

public abstract class DataSet<T extends Entry>
extends BaseDataSet<T> {
    public List<T> mValues = null;
    public float mXMax = -3.4028235E38f;
    public float mXMin = Float.MAX_VALUE;
    public float mYMax = -3.4028235E38f;
    public float mYMin = Float.MAX_VALUE;

    public DataSet(List<T> list, String string) {
        List<T> list2;
        super(string);
        this.mValues = list;
        if (list == null) {
            this.mValues = new ArrayList();
        }
        if ((list2 = this.mValues) != null) {
            if (list2.isEmpty()) {
                return;
            }
            this.mYMax = -3.4028235E38f;
            this.mYMin = Float.MAX_VALUE;
            this.mXMax = -3.4028235E38f;
            this.mXMin = Float.MAX_VALUE;
            for (Entry entry : this.mValues) {
                float f2;
                BarDataSet barDataSet = (BarDataSet)this;
                BarEntry barEntry = (BarEntry)entry;
                if (barEntry == null || Float.isNaN((float)barEntry.y)) continue;
                if (barEntry.mYVals == null) {
                    float f3 = barEntry.y;
                    if (f3 < barDataSet.mYMin) {
                        barDataSet.mYMin = f3;
                    }
                    if (f3 > barDataSet.mYMax) {
                        barDataSet.mYMax = f3;
                    }
                } else {
                    float f4;
                    float f5 = -barEntry.mNegativeSum;
                    if (f5 < barDataSet.mYMin) {
                        barDataSet.mYMin = f5;
                    }
                    if ((f4 = barEntry.mPositiveSum) > barDataSet.mYMax) {
                        barDataSet.mYMax = f4;
                    }
                }
                if ((f2 = barEntry.x) < barDataSet.mXMin) {
                    barDataSet.mXMin = f2;
                }
                if (!(f2 > barDataSet.mXMax)) continue;
                barDataSet.mXMax = f2;
            }
        }
    }

    @Override
    public void calcMinMaxY(float f2, float f3) {
        List<T> list = this.mValues;
        if (list != null) {
            if (list.isEmpty()) {
                return;
            }
            this.mYMax = -3.4028235E38f;
            this.mYMin = Float.MAX_VALUE;
            int n2 = this.getEntryIndex(f3, Float.NaN, Rounding.UP);
            for (int i2 = this.getEntryIndex((float)f2, (float)Float.NaN, Rounding.DOWN); i2 <= n2; ++i2) {
                Entry entry = (Entry)this.mValues.get(i2);
                if (entry.getY() < this.mYMin) {
                    this.mYMin = entry.getY();
                }
                if (!(entry.getY() > this.mYMax)) continue;
                this.mYMax = entry.getY();
            }
        }
    }

    @Override
    public List<T> getEntriesForXValue(float f2) {
        ArrayList arrayList = new ArrayList();
        int n2 = -1 + this.mValues.size();
        int n3 = 0;
        while (n3 <= n2) {
            int n4 = (n2 + n3) / 2;
            Entry entry = (Entry)this.mValues.get(n4);
            if (f2 == entry.getX()) {
                Entry entry2;
                while (n4 > 0 && ((Entry)this.mValues.get(n4 - 1)).getX() == f2) {
                    --n4;
                }
                int n5 = this.mValues.size();
                while (n4 < n5 && (entry2 = (Entry)this.mValues.get(n4)).getX() == f2) {
                    arrayList.add((Object)entry2);
                    ++n4;
                }
                break;
            }
            if (f2 > entry.getX()) {
                n3 = n4 + 1;
                continue;
            }
            n2 = n4 - 1;
        }
        return arrayList;
    }

    @Override
    public int getEntryCount() {
        return this.mValues.size();
    }

    @Override
    public T getEntryForIndex(int n2) {
        return (T)((Entry)this.mValues.get(n2));
    }

    @Override
    public T getEntryForXValue(float f2, float f3) {
        return this.getEntryForXValue(f2, f3, Rounding.CLOSEST);
    }

    @Override
    public T getEntryForXValue(float f2, float f3, Rounding rounding) {
        int n2 = this.getEntryIndex(f2, f3, rounding);
        if (n2 > -1) {
            return (T)((Entry)this.mValues.get(n2));
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int getEntryIndex(float f2, float f3, Rounding rounding) {
        List<T> list = this.mValues;
        if (list == null) return -1;
        if (list.isEmpty()) {
            return -1;
        }
        int n2 = 0;
        int n3 = -1 + this.mValues.size();
        while (n2 < n3) {
            int n4 = (n2 + n3) / 2;
            float f4 = ((Entry)this.mValues.get(n4)).getX() - f2;
            List<T> list2 = this.mValues;
            int n5 = n4 + 1;
            float f5 = ((Entry)list2.get(n5)).getX() - f2;
            float f6 = Math.abs((float)f4);
            float f7 = Math.abs((float)f5);
            if (!(f7 < f6)) {
                double d2;
                if (f6 < f7 || (d2 = (double)f4) >= 0.0) {
                    n3 = n4;
                    continue;
                }
                if (!(d2 < 0.0)) continue;
            }
            n2 = n5;
        }
        if (n3 == -1) return n3;
        float f8 = ((Entry)this.mValues.get(n3)).getX();
        if (rounding == Rounding.UP) {
            if (f8 < f2 && n3 < -1 + this.mValues.size()) {
                ++n3;
            }
        } else if (rounding == Rounding.DOWN && f8 > f2 && n3 > 0) {
            --n3;
        }
        if (Float.isNaN((float)f3)) return n3;
        while (n3 > 0 && ((Entry)this.mValues.get(n3 - 1)).getX() == f8) {
            --n3;
        }
        float f9 = ((Entry)this.mValues.get(n3)).getY();
        do {
            Entry entry;
            int n6 = n3;
            do {
                if (++n3 >= this.mValues.size()) {
                    return n6;
                }
                entry = (Entry)this.mValues.get(n3);
                if (entry.getX() == f8) continue;
                return n6;
            } while (!(Math.abs((float)(entry.getY() - f3)) < Math.abs((float)(f9 - f3))));
            f9 = f3;
        } while (true);
    }

    @Override
    public int getEntryIndex(Entry entry) {
        return this.mValues.indexOf((Object)entry);
    }

    @Override
    public float getXMax() {
        return this.mXMax;
    }

    @Override
    public float getXMin() {
        return this.mXMin;
    }

    @Override
    public float getYMax() {
        return this.mYMax;
    }

    @Override
    public float getYMin() {
        return this.mYMin;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"DataSet, label: ");
        String string = this.mLabel;
        if (string == null) {
            string = "";
        }
        stringBuilder.append(string);
        stringBuilder.append(", entries: ");
        stringBuilder.append(this.mValues.size());
        stringBuilder.append("\n");
        stringBuffer2.append(stringBuilder.toString());
        stringBuffer.append(stringBuffer2.toString());
        for (int i2 = 0; i2 < this.mValues.size(); ++i2) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(((Entry)this.mValues.get(i2)).toString());
            stringBuilder2.append(" ");
            stringBuffer.append(stringBuilder2.toString());
        }
        return stringBuffer.toString();
    }

}

