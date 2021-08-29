/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 */
package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.renderer.Renderer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class DataRenderer
extends Renderer {
    public ChartAnimator mAnimator;
    public Paint mHighlightPaint;
    public Paint mRenderPaint;
    public Paint mValuePaint;

    public DataRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        Paint paint;
        Paint paint2;
        Paint paint3;
        super(viewPortHandler);
        this.mAnimator = chartAnimator;
        this.mRenderPaint = paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.FILL);
        new Paint(4);
        this.mValuePaint = paint = new Paint(1);
        paint.setColor(Color.rgb((int)63, (int)63, (int)63));
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mHighlightPaint = paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(2.0f);
        this.mHighlightPaint.setColor(Color.rgb((int)255, (int)187, (int)115));
    }

    public abstract void drawValues(Canvas var1);

    public abstract void initBuffers();

    public boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return (float)chartInterface.getData().getEntryCount() < (float)chartInterface.getMaxVisibleCount() * this.mViewPortHandler.mScaleX;
    }
}

