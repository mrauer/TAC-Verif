/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$FontMetrics
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathEffect
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Objects
 */
package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.renderer.AxisRenderer;
import com.github.mikephil.charting.renderer.Renderer;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;
import java.util.Objects;

public class XAxisRenderer
extends AxisRenderer {
    public RectF mGridClippingRect = new RectF();
    public RectF mLimitLineClippingRect = new RectF();
    public Path mLimitLinePath = new Path();
    public float[] mLimitLineSegmentsBuffer = new float[4];
    public float[] mRenderGridLinesBuffer = new float[2];
    public Path mRenderGridLinesPath = new Path();
    public float[] mRenderLimitLinesBuffer = new float[2];
    public XAxis mXAxis;

    public XAxisRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer) {
        super(viewPortHandler, transformer, xAxis);
        this.mXAxis = xAxis;
        this.mAxisLabelPaint.setColor(-16777216);
        this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
        this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
    }

    @Override
    public void computeAxis(float f2, float f3, boolean bl) {
        if (this.mViewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutX()) {
            float f4;
            double d2;
            Transformer transformer = this.mTrans;
            RectF rectF = this.mViewPortHandler.mContentRect;
            MPPointD mPPointD = transformer.getValuesByTouchPoint(rectF.left, rectF.top);
            Transformer transformer2 = this.mTrans;
            RectF rectF2 = this.mViewPortHandler.mContentRect;
            MPPointD mPPointD2 = transformer2.getValuesByTouchPoint(rectF2.right, rectF2.top);
            if (bl) {
                f4 = (float)mPPointD2.x;
                d2 = mPPointD.x;
            } else {
                f4 = (float)mPPointD.x;
                d2 = mPPointD2.x;
            }
            float f5 = (float)d2;
            MPPointD.pool.recycle(mPPointD);
            MPPointD.pool.recycle(mPPointD2);
            f2 = f4;
            f3 = f5;
        }
        super.computeAxisValues(f2, f3);
        this.computeSize();
    }

    @Override
    public void computeAxisValues(float f2, float f3) {
        super.computeAxisValues(f2, f3);
        this.computeSize();
    }

    public void computeSize() {
        String string = this.mXAxis.getLongestLabel();
        Paint paint = this.mAxisLabelPaint;
        Objects.requireNonNull((Object)this.mXAxis);
        paint.setTypeface(null);
        this.mAxisLabelPaint.setTextSize(this.mXAxis.mTextSize);
        FSize fSize = Utils.calcTextSize(this.mAxisLabelPaint, string);
        float f2 = fSize.width;
        float f3 = Utils.calcTextHeight(this.mAxisLabelPaint, "Q");
        Objects.requireNonNull((Object)this.mXAxis);
        FSize fSize2 = Utils.getSizeOfRotatedRectangleByDegrees(f2, f3, 0.0f);
        XAxis xAxis = this.mXAxis;
        Math.round((float)f2);
        Objects.requireNonNull((Object)xAxis);
        XAxis xAxis2 = this.mXAxis;
        Math.round((float)f3);
        Objects.requireNonNull((Object)xAxis2);
        this.mXAxis.mLabelRotatedWidth = Math.round((float)fSize2.width);
        this.mXAxis.mLabelRotatedHeight = Math.round((float)fSize2.height);
        FSize.pool.recycle(fSize2);
        FSize.pool.recycle(fSize);
    }

    public void drawGridLine(Canvas canvas, float f2, float f3, Path path) {
        path.moveTo(f2, this.mViewPortHandler.mContentRect.bottom);
        path.lineTo(f2, this.mViewPortHandler.mContentRect.top);
        canvas.drawPath(path, this.mGridPaint);
        path.reset();
    }

    public void drawLabel(Canvas canvas, String string, float f2, float f3, MPPointF mPPointF, float f4) {
        Paint paint = this.mAxisLabelPaint;
        float f5 = paint.getFontMetrics(Utils.mFontMetricsBuffer);
        paint.getTextBounds(string, 0, string.length(), Utils.mDrawTextRectBuffer);
        float f6 = 0.0f - (float)Utils.mDrawTextRectBuffer.left;
        float f7 = 0.0f + -Utils.mFontMetricsBuffer.ascent;
        Paint.Align align = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f4 != 0.0f) {
            float f8 = f6 - 0.5f * (float)Utils.mDrawTextRectBuffer.width();
            float f9 = f7 - f5 * 0.5f;
            if (mPPointF.x != 0.5f || mPPointF.y != 0.5f) {
                FSize fSize = Utils.getSizeOfRotatedRectangleByDegrees(Utils.mDrawTextRectBuffer.width(), f5, f4);
                f2 -= fSize.width * (mPPointF.x - 0.5f);
                f3 -= fSize.height * (mPPointF.y - 0.5f);
                FSize.pool.recycle(fSize);
            }
            canvas.save();
            canvas.translate(f2, f3);
            canvas.rotate(f4);
            canvas.drawText(string, f8, f9, paint);
            canvas.restore();
        } else {
            if (mPPointF.x != 0.0f || mPPointF.y != 0.0f) {
                f6 -= (float)Utils.mDrawTextRectBuffer.width() * mPPointF.x;
                f7 -= f5 * mPPointF.y;
            }
            canvas.drawText(string, f6 + f2, f7 + f3, paint);
        }
        paint.setTextAlign(align);
    }

    public void drawLabels(Canvas canvas, float f2, MPPointF mPPointF) {
        Objects.requireNonNull((Object)this.mXAxis);
        Objects.requireNonNull((Object)this.mXAxis);
        int n2 = 2 * this.mXAxis.mEntryCount;
        float[] arrf = new float[n2];
        int n3 = 0;
        for (int i2 = 0; i2 < n2; i2 += 2) {
            arrf[i2] = this.mXAxis.mEntries[i2 / 2];
        }
        this.mTrans.pointValuesToPixel(arrf);
        while (n3 < n2) {
            float f3 = arrf[n3];
            if (this.mViewPortHandler.isInBoundsX(f3)) {
                ValueFormatter valueFormatter = this.mXAxis.getValueFormatter();
                XAxis xAxis = this.mXAxis;
                String string = valueFormatter.getAxisLabel(xAxis.mEntries[n3 / 2], xAxis);
                Objects.requireNonNull((Object)this.mXAxis);
                this.drawLabel(canvas, string, f3, f2, mPPointF, 0.0f);
            }
            n3 += 2;
        }
    }

    public RectF getGridClippingRect() {
        this.mGridClippingRect.set(this.mViewPortHandler.mContentRect);
        this.mGridClippingRect.inset(-this.mAxis.mGridLineWidth, 0.0f);
        return this.mGridClippingRect;
    }

    public void renderAxisLabels(Canvas canvas) {
        XAxis xAxis = this.mXAxis;
        if (xAxis.mEnabled) {
            if (!xAxis.mDrawLabels) {
                return;
            }
            float f2 = xAxis.mYOffset;
            this.mAxisLabelPaint.setTypeface(null);
            this.mAxisLabelPaint.setTextSize(this.mXAxis.mTextSize);
            this.mAxisLabelPaint.setColor(this.mXAxis.mTextColor);
            MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
            XAxis xAxis2 = this.mXAxis;
            XAxis.XAxisPosition xAxisPosition = xAxis2.mPosition;
            if (xAxisPosition == XAxis.XAxisPosition.TOP) {
                mPPointF.x = 0.5f;
                mPPointF.y = 1.0f;
                this.drawLabels(canvas, this.mViewPortHandler.mContentRect.top - f2, mPPointF);
            } else if (xAxisPosition == XAxis.XAxisPosition.TOP_INSIDE) {
                mPPointF.x = 0.5f;
                mPPointF.y = 1.0f;
                this.drawLabels(canvas, f2 + this.mViewPortHandler.mContentRect.top + (float)xAxis2.mLabelRotatedHeight, mPPointF);
            } else if (xAxisPosition == XAxis.XAxisPosition.BOTTOM) {
                mPPointF.x = 0.5f;
                mPPointF.y = 0.0f;
                this.drawLabels(canvas, f2 + this.mViewPortHandler.mContentRect.bottom, mPPointF);
            } else if (xAxisPosition == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                mPPointF.x = 0.5f;
                mPPointF.y = 0.0f;
                this.drawLabels(canvas, this.mViewPortHandler.mContentRect.bottom - f2 - (float)xAxis2.mLabelRotatedHeight, mPPointF);
            } else {
                mPPointF.x = 0.5f;
                mPPointF.y = 1.0f;
                this.drawLabels(canvas, this.mViewPortHandler.mContentRect.top - f2, mPPointF);
                mPPointF.x = 0.5f;
                mPPointF.y = 0.0f;
                this.drawLabels(canvas, f2 + this.mViewPortHandler.mContentRect.bottom, mPPointF);
            }
            MPPointF.pool.recycle(mPPointF);
        }
    }

    public void renderAxisLine(Canvas canvas) {
        XAxis xAxis = this.mXAxis;
        if (xAxis.mDrawAxisLine) {
            XAxis.XAxisPosition xAxisPosition;
            if (!xAxis.mEnabled) {
                return;
            }
            this.mAxisLinePaint.setColor(xAxis.mAxisLineColor);
            this.mAxisLinePaint.setStrokeWidth(this.mXAxis.mAxisLineWidth);
            Paint paint = this.mAxisLinePaint;
            Objects.requireNonNull((Object)this.mXAxis);
            paint.setPathEffect(null);
            XAxis.XAxisPosition xAxisPosition2 = this.mXAxis.mPosition;
            if (xAxisPosition2 == XAxis.XAxisPosition.TOP || xAxisPosition2 == XAxis.XAxisPosition.TOP_INSIDE || xAxisPosition2 == XAxis.XAxisPosition.BOTH_SIDED) {
                RectF rectF = this.mViewPortHandler.mContentRect;
                float f2 = rectF.left;
                float f3 = rectF.top;
                canvas.drawLine(f2, f3, rectF.right, f3, this.mAxisLinePaint);
            }
            if ((xAxisPosition = this.mXAxis.mPosition) == XAxis.XAxisPosition.BOTTOM || xAxisPosition == XAxis.XAxisPosition.BOTTOM_INSIDE || xAxisPosition == XAxis.XAxisPosition.BOTH_SIDED) {
                RectF rectF = this.mViewPortHandler.mContentRect;
                float f4 = rectF.left;
                float f5 = rectF.bottom;
                canvas.drawLine(f4, f5, rectF.right, f5, this.mAxisLinePaint);
            }
        }
    }

    public void renderGridLines(Canvas canvas) {
        XAxis xAxis = this.mXAxis;
        if (xAxis.mDrawGridLines) {
            if (!xAxis.mEnabled) {
                return;
            }
            int n2 = canvas.save();
            canvas.clipRect(this.getGridClippingRect());
            if (this.mRenderGridLinesBuffer.length != 2 * this.mAxis.mEntryCount) {
                this.mRenderGridLinesBuffer = new float[2 * this.mXAxis.mEntryCount];
            }
            float[] arrf = this.mRenderGridLinesBuffer;
            int n3 = 0;
            for (int i2 = 0; i2 < arrf.length; i2 += 2) {
                float[] arrf2 = this.mXAxis.mEntries;
                int n4 = i2 / 2;
                arrf[i2] = arrf2[n4];
                arrf[i2 + 1] = arrf2[n4];
            }
            this.mTrans.pointValuesToPixel(arrf);
            this.mGridPaint.setColor(this.mXAxis.mGridColor);
            this.mGridPaint.setStrokeWidth(this.mXAxis.mGridLineWidth);
            Paint paint = this.mGridPaint;
            Objects.requireNonNull((Object)this.mXAxis);
            paint.setPathEffect(null);
            Path path = this.mRenderGridLinesPath;
            path.reset();
            while (n3 < arrf.length) {
                this.drawGridLine(canvas, arrf[n3], arrf[n3 + 1], path);
                n3 += 2;
            }
            canvas.restoreToCount(n2);
        }
    }

    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> list = this.mXAxis.mLimitLines;
        if (list != null) {
            if (list.size() <= 0) {
                return;
            }
            float[] arrf = this.mRenderLimitLinesBuffer;
            arrf[0] = 0.0f;
            arrf[1] = 0.0f;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                if (!((LimitLine)list.get((int)i2)).mEnabled) continue;
                int n2 = canvas.save();
                this.mLimitLineClippingRect.set(this.mViewPortHandler.mContentRect);
                this.mLimitLineClippingRect.inset(0.0f, 0.0f);
                canvas.clipRect(this.mLimitLineClippingRect);
                arrf[0] = 0.0f;
                arrf[1] = 0.0f;
                this.mTrans.pointValuesToPixel(arrf);
                float[] arrf2 = this.mLimitLineSegmentsBuffer;
                arrf2[0] = arrf[0];
                RectF rectF = this.mViewPortHandler.mContentRect;
                arrf2[1] = rectF.top;
                arrf2[2] = arrf[0];
                arrf2[3] = rectF.bottom;
                this.mLimitLinePath.reset();
                Path path = this.mLimitLinePath;
                float[] arrf3 = this.mLimitLineSegmentsBuffer;
                path.moveTo(arrf3[0], arrf3[1]);
                Path path2 = this.mLimitLinePath;
                float[] arrf4 = this.mLimitLineSegmentsBuffer;
                path2.lineTo(arrf4[2], arrf4[3]);
                this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
                this.mLimitLinePaint.setColor(0);
                this.mLimitLinePaint.setStrokeWidth(0.0f);
                this.mLimitLinePaint.setPathEffect(null);
                canvas.drawPath(this.mLimitLinePath, this.mLimitLinePaint);
                canvas.restoreToCount(n2);
            }
        }
    }
}

