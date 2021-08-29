/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  com.github.mikephil.charting.charts.Chart
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.mikephil.charting.listener;

import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;

public abstract class ChartTouchListener<T extends Chart<?>>
extends GestureDetector.SimpleOnGestureListener
implements View.OnTouchListener {
    public T mChart;
    public GestureDetector mGestureDetector;
    public ChartGesture mLastGesture = ChartGesture.NONE;
    public Highlight mLastHighlighted;
    public int mTouchMode = 0;

    public ChartTouchListener(T t3) {
        this.mChart = t3;
        this.mGestureDetector = new GestureDetector(t3.getContext(), (GestureDetector.OnGestureListener)this);
    }

    public static final class ChartGesture
    extends Enum<ChartGesture> {
        private static final /* synthetic */ ChartGesture[] $VALUES;
        public static final /* enum */ ChartGesture DOUBLE_TAP;
        public static final /* enum */ ChartGesture DRAG;
        public static final /* enum */ ChartGesture FLING;
        public static final /* enum */ ChartGesture LONG_PRESS;
        public static final /* enum */ ChartGesture NONE;
        public static final /* enum */ ChartGesture PINCH_ZOOM;
        public static final /* enum */ ChartGesture ROTATE;
        public static final /* enum */ ChartGesture SINGLE_TAP;
        public static final /* enum */ ChartGesture X_ZOOM;
        public static final /* enum */ ChartGesture Y_ZOOM;

        public static {
            ChartGesture chartGesture;
            ChartGesture chartGesture2;
            ChartGesture chartGesture3;
            ChartGesture chartGesture4;
            ChartGesture chartGesture5;
            ChartGesture chartGesture6;
            ChartGesture chartGesture7;
            ChartGesture chartGesture8;
            ChartGesture chartGesture9;
            ChartGesture chartGesture10;
            NONE = chartGesture3 = new ChartGesture();
            DRAG = chartGesture9 = new ChartGesture();
            X_ZOOM = chartGesture2 = new ChartGesture();
            Y_ZOOM = chartGesture6 = new ChartGesture();
            PINCH_ZOOM = chartGesture10 = new ChartGesture();
            ROTATE = chartGesture5 = new ChartGesture();
            SINGLE_TAP = chartGesture8 = new ChartGesture();
            DOUBLE_TAP = chartGesture7 = new ChartGesture();
            LONG_PRESS = chartGesture4 = new ChartGesture();
            FLING = chartGesture = new ChartGesture();
            $VALUES = new ChartGesture[]{chartGesture3, chartGesture9, chartGesture2, chartGesture6, chartGesture10, chartGesture5, chartGesture8, chartGesture7, chartGesture4, chartGesture};
        }

        public static ChartGesture valueOf(String string) {
            return (ChartGesture)Enum.valueOf(ChartGesture.class, (String)string);
        }

        public static ChartGesture[] values() {
            return (ChartGesture[])$VALUES.clone();
        }
    }

}

