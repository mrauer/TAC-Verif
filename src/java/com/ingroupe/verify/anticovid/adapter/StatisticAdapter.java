/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.Guideline
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  androidx.viewbinding.ViewBinding
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.github.mikephil.charting.charts.BarChart
 *  com.github.mikephil.charting.components.XAxis
 *  com.github.mikephil.charting.components.YAxis
 *  com.github.mikephil.charting.data.BarData
 *  com.github.mikephil.charting.data.BarDataSet
 *  com.github.mikephil.charting.data.BarEntry
 *  com.github.mikephil.charting.interfaces.datasets.IBarDataSet
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseDataSet;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.ingroupe.verify.anticovid.adapter.StatisticAdapter$drawChart$xFormatter$1;
import com.ingroupe.verify.anticovid.adapter.StatisticAdapter$drawChart$yFormatter$1;
import com.ingroupe.verify.anticovid.common.model.StatsDay;
import com.ingroupe.verify.anticovid.databinding.StatisticFirstViewBinding;
import com.ingroupe.verify.anticovid.databinding.StatisticViewBinding;
import j$.time.LocalDate;
import j$.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

public final class StatisticAdapter
extends RecyclerView.Adapter<MyViewHolder> {
    public final Context context;
    public final Map<Long, StatsDay> stats;

    public StatisticAdapter(Map<Long, StatsDay> map, Context context) {
        Intrinsics.checkNotNullParameter(map, (String)"stats");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        this.stats = map;
        this.context = context;
    }

    public int getItemCount() {
        return this.stats.size();
    }

    public int getItemViewType(int n2) {
        if (n2 == 0) {
            return 2131493005;
        }
        return 2131493007;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        MyViewHolder myViewHolder = (MyViewHolder)viewHolder;
        Intrinsics.checkNotNullParameter((Object)((Object)myViewHolder), (String)"holder");
        LocalDate localDate = LocalDate.now().minusDays(n2);
        long l2 = localDate.toEpochDay();
        ViewBinding viewBinding = myViewHolder.binding;
        if (viewBinding instanceof StatisticFirstViewBinding) {
            BarChart barChart = ((StatisticFirstViewBinding)viewBinding).chart1;
            Intrinsics.checkNotNullExpressionValue((Object)barChart, (String)"holder.binding as StatisticFirstViewBinding).chart1");
            barChart.getDescription().mEnabled = false;
            barChart.getLegend().mEnabled = true;
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : this.stats.entrySet()) {
                float f2 = ((Number)entry.getKey()).longValue();
                float[] arrf = new float[]{((StatsDay)entry.getValue()).nbTotal, ((StatsDay)entry.getValue()).nbDuplicate};
                arrayList.add((Object)new BarEntry(f2, arrf));
            }
            BarDataSet barDataSet = new BarDataSet((List)arrayList, "");
            barDataSet.mDrawIcons = false;
            Object[] arrobject = new Integer[2];
            Context context = this.context;
            arrobject[0] = context.getColor(2131034221);
            arrobject[1] = this.context.getColor(2131034225);
            barDataSet.mColors = ArraysKt___ArraysJvmKt.listOf((Object[])arrobject);
            String[] arrstring = new String[]{this.context.getString(2131820835), this.context.getString(2131820834)};
            barDataSet.mStackLabels = arrstring;
            StatisticAdapter$drawChart$xFormatter$1 statisticAdapter$drawChart$xFormatter$1 = new StatisticAdapter$drawChart$xFormatter$1();
            XAxis xAxis = barChart.getXAxis();
            xAxis.mPosition = XAxis.XAxisPosition.BOTTOM;
            xAxis.mDrawGridLines = false;
            xAxis.mAxisValueFormatter = statisticAdapter$drawChart$xFormatter$1;
            StatisticAdapter$drawChart$yFormatter$1 statisticAdapter$drawChart$yFormatter$1 = new StatisticAdapter$drawChart$yFormatter$1();
            YAxis yAxis = barChart.getAxisLeft();
            yAxis.mCustomAxisMin = true;
            yAxis.mAxisMinimum = 0.0f;
            yAxis.mAxisRange = Math.abs((float)(yAxis.mAxisMaximum - 0.0f));
            yAxis.mGranularity = 1.0f;
            yAxis.mGranularityEnabled = true;
            yAxis.mAxisValueFormatter = statisticAdapter$drawChart$yFormatter$1;
            barChart.getAxisRight().mEnabled = false;
            BarData barData = new BarData(new IBarDataSet[]{barDataSet});
            Iterator iterator = barData.mDataSets.iterator();
            while (iterator.hasNext()) {
                ((IDataSet)iterator.next()).setValueFormatter(statisticAdapter$drawChart$yFormatter$1);
            }
            barChart.setData(barData);
            barChart.invalidate();
            TextView textView = ((StatisticFirstViewBinding)myViewHolder.binding).textViewDate;
            Context context2 = this.context;
            Object[] arrobject2 = new Object[]{localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))};
            textView.setText((CharSequence)context2.getString(2131820833, arrobject2));
            TextView textView2 = ((StatisticFirstViewBinding)myViewHolder.binding).textViewCount;
            Object object = this.stats.get((Object)l2);
            Intrinsics.checkNotNull((Object)object);
            textView2.setText((CharSequence)String.valueOf((int)((StatsDay)object).nbTotal));
            TextView textView3 = ((StatisticFirstViewBinding)myViewHolder.binding).textViewCountDuplicate;
            Object object2 = this.stats.get((Object)l2);
            Intrinsics.checkNotNull((Object)object2);
            textView3.setText((CharSequence)String.valueOf((int)((StatsDay)object2).nbDuplicate));
        } else if (viewBinding instanceof StatisticViewBinding) {
            TextView textView = ((StatisticViewBinding)viewBinding).textViewDate;
            Context context = this.context;
            Object[] arrobject = new Object[]{localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))};
            textView.setText((CharSequence)context.getString(2131820837, arrobject));
            TextView textView4 = ((StatisticViewBinding)myViewHolder.binding).textViewCount;
            Object object = this.stats.get((Object)l2);
            Intrinsics.checkNotNull((Object)object);
            textView4.setText((CharSequence)String.valueOf((int)((StatsDay)object).nbTotal));
            TextView textView5 = ((StatisticViewBinding)myViewHolder.binding).textViewCountDuplicate;
            Object object3 = this.stats.get((Object)l2);
            Intrinsics.checkNotNull((Object)object3);
            textView5.setText((CharSequence)String.valueOf((int)((StatsDay)object3).nbDuplicate));
        }
        myViewHolder.binding.getRoot().setTag((Object)n2);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        Intrinsics.checkNotNullParameter((Object)viewGroup, (String)"parent");
        int n3 = 2131296781;
        if (n2 == 2131493005) {
            View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131493005, (ViewGroup)viewGroup, (boolean)false);
            BarChart barChart = (BarChart)view.findViewById(2131296377);
            if (barChart != null) {
                Guideline guideline = (Guideline)view.findViewById(2131296495);
                if (guideline != null) {
                    Guideline guideline2 = (Guideline)view.findViewById(2131296496);
                    if (guideline2 != null) {
                        TextView textView = (TextView)view.findViewById(2131296777);
                        if (textView != null) {
                            TextView textView2 = (TextView)view.findViewById(2131296778);
                            if (textView2 != null) {
                                TextView textView3;
                                TextView textView4 = (TextView)view.findViewById(n3);
                                if (textView4 != null && (textView3 = (TextView)view.findViewById(n3 = 2131296789)) != null) {
                                    StatisticFirstViewBinding statisticFirstViewBinding = new StatisticFirstViewBinding((ConstraintLayout)view, barChart, guideline, guideline2, textView, textView2, textView4, textView3);
                                    Intrinsics.checkNotNullExpressionValue((Object)statisticFirstViewBinding, (String)"inflate(\n                        LayoutInflater.from(parent.context),\n                        parent,\n                        false\n                    )");
                                    return new MyViewHolder(statisticFirstViewBinding);
                                }
                            } else {
                                n3 = 2131296778;
                            }
                        } else {
                            n3 = 2131296777;
                        }
                    } else {
                        n3 = 2131296496;
                    }
                } else {
                    n3 = 2131296495;
                }
            } else {
                n3 = 2131296377;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n3)));
        }
        View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131493007, (ViewGroup)viewGroup, (boolean)false);
        Guideline guideline = (Guideline)view.findViewById(2131296495);
        if (guideline != null) {
            Guideline guideline3 = (Guideline)view.findViewById(2131296496);
            if (guideline3 != null) {
                TextView textView = (TextView)view.findViewById(2131296777);
                if (textView != null) {
                    TextView textView5 = (TextView)view.findViewById(2131296778);
                    if (textView5 != null) {
                        TextView textView6 = (TextView)view.findViewById(n3);
                        if (textView6 != null) {
                            StatisticViewBinding statisticViewBinding = new StatisticViewBinding((ConstraintLayout)view, guideline, guideline3, textView, textView5, textView6);
                            Intrinsics.checkNotNullExpressionValue((Object)statisticViewBinding, (String)"inflate(\n                        LayoutInflater.from(parent.context),\n                        parent,\n                        false\n                    )");
                            return new MyViewHolder(statisticViewBinding);
                        }
                    } else {
                        n3 = 2131296778;
                    }
                } else {
                    n3 = 2131296777;
                }
            } else {
                n3 = 2131296496;
            }
        } else {
            n3 = 2131296495;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n3)));
    }

    public static class MyViewHolder
    extends RecyclerView.ViewHolder {
        public final ViewBinding binding;

        public MyViewHolder(ViewBinding viewBinding) {
            Intrinsics.checkNotNullParameter((Object)viewBinding, (String)"binding");
            super(viewBinding.getRoot());
            this.binding = viewBinding;
        }
    }

}

