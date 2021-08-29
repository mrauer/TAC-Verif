/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.Objects
 */
package com.github.mikephil.charting.renderer;

import android.graphics.Paint;
import android.graphics.RectF;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.renderer.Renderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Objects;

public abstract class AxisRenderer
extends Renderer {
    public AxisBase mAxis;
    public Paint mAxisLabelPaint;
    public Paint mAxisLinePaint;
    public Paint mGridPaint;
    public Paint mLimitLinePaint;
    public Transformer mTrans;

    public AxisRenderer(ViewPortHandler viewPortHandler, Transformer transformer, AxisBase axisBase) {
        super(viewPortHandler);
        this.mTrans = transformer;
        this.mAxis = axisBase;
        if (viewPortHandler != null) {
            Paint paint;
            Paint paint2;
            Paint paint3;
            this.mAxisLabelPaint = new Paint(1);
            this.mGridPaint = paint2 = new Paint();
            paint2.setColor(-7829368);
            this.mGridPaint.setStrokeWidth(1.0f);
            this.mGridPaint.setStyle(Paint.Style.STROKE);
            this.mGridPaint.setAlpha(90);
            this.mAxisLinePaint = paint = new Paint();
            paint.setColor(-16777216);
            this.mAxisLinePaint.setStrokeWidth(1.0f);
            this.mAxisLinePaint.setStyle(Paint.Style.STROKE);
            this.mLimitLinePaint = paint3 = new Paint(1);
            paint3.setStyle(Paint.Style.STROKE);
        }
    }

    public void computeAxis(float f, float f2, boolean bl) {
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (viewPortHandler != null && viewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutY()) {
            double d2;
            float f3;
            Transformer transformer = this.mTrans;
            RectF rectF = this.mViewPortHandler.mContentRect;
            MPPointD mPPointD = transformer.getValuesByTouchPoint(rectF.left, rectF.top);
            Transformer transformer2 = this.mTrans;
            RectF rectF2 = this.mViewPortHandler.mContentRect;
            MPPointD mPPointD2 = transformer2.getValuesByTouchPoint(rectF2.left, rectF2.bottom);
            if (!bl) {
                f3 = (float)mPPointD2.y;
                d2 = mPPointD.y;
            } else {
                f3 = (float)mPPointD.y;
                d2 = mPPointD2.y;
            }
            float f4 = (float)d2;
            MPPointD.pool.recycle(mPPointD);
            MPPointD.pool.recycle(mPPointD2);
            f = f3;
            f2 = f4;
        }
        this.computeAxisValues(f, f2);
    }

    public void computeAxisValues(float f, float f2) {
        int n = this.mAxis.mLabelCount;
        double d2 = Math.abs((float)(f2 - f));
        if (n != 0 && !(d2 <= 0.0) && !Double.isInfinite((double)d2)) {
            double d3;
            int n2;
            double d4;
            double d5;
            double d6 = Utils.roundToNextSignificant(d2 / (double)n);
            AxisBase axisBase = this.mAxis;
            if (axisBase.mGranularityEnabled && d6 < (d5 = (double)axisBase.mGranularity)) {
                d6 = d5;
            }
            if ((int)(d6 / (d4 = (double)Utils.roundToNextSignificant(Math.pow((double)10.0, (double)((int)Math.log10((double)d6)))))) > 5) {
                d6 = Math.floor((double)(d4 * 10.0));
            }
            Objects.requireNonNull((Object)this.mAxis);
            Objects.requireNonNull((Object)this.mAxis);
            double d7 = d6 DCMPL 0.0;
            double d8 = d7 == false ? 0.0 : d6 * Math.ceil((double)((double)f / d6));
            Objects.requireNonNull((Object)this.mAxis);
            if (d7 == false) {
                d3 = 0.0;
            } else {
                d3 = d6 * Math.floor((double)((double)f2 / d6));
                if (d3 != Double.POSITIVE_INFINITY) {
                    double d9 = d3 + 0.0;
                    long l = Double.doubleToRawLongBits((double)d9);
                    long l2 = d9 >= 0.0 ? 1L : -1L;
                    d3 = Double.longBitsToDouble((long)(l + l2));
                }
            }
            if (d7 != false) {
                n2 = 0;
                for (double d10 = d8; d10 <= d3; d10 += d6) {
                    ++n2;
                }
            } else {
                n2 = 0;
            }
            AxisBase axisBase2 = this.mAxis;
            axisBase2.mEntryCount = n2;
            if (axisBase2.mEntries.length < n2) {
                axisBase2.mEntries = new float[n2];
            }
            for (int i = 0; i < n2; ++i) {
                if (d8 == 0.0) {
                    d8 = 0.0;
                }
                this.mAxis.mEntries[i] = (float)d8;
                d8 += d6;
            }
            this.mAxis.mDecimals = d6 < 1.0 ? (int)Math.ceil((double)(-Math.log10((double)d6))) : 0;
            Objects.requireNonNull((Object)this.mAxis);
            return;
        }
        AxisBase axisBase = this.mAxis;
        axisBase.mEntries = new float[0];
        axisBase.mCenteredEntries = new float[0];
        axisBase.mEntryCount = 0;
    }
}

