/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  java.lang.Object
 */
package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import com.github.mikephil.charting.listener.ChartTouchListener;

public interface OnChartGestureListener {
    public void onChartDoubleTapped(MotionEvent var1);

    public void onChartFling(MotionEvent var1, MotionEvent var2, float var3, float var4);

    public void onChartGestureEnd(MotionEvent var1, ChartTouchListener.ChartGesture var2);

    public void onChartGestureStart(MotionEvent var1, ChartTouchListener.ChartGesture var2);

    public void onChartLongPressed(MotionEvent var1);

    public void onChartScale(MotionEvent var1, float var2, float var3);

    public void onChartSingleTapped(MotionEvent var1);

    public void onChartTranslate(MotionEvent var1, float var2, float var3);
}

