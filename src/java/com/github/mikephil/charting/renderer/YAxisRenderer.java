/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathEffect
 *  android.graphics.RectF
 *  android.graphics.Typeface
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
import android.graphics.RectF;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.renderer.AxisRenderer;
import com.github.mikephil.charting.renderer.Renderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;
import java.util.Objects;

public class YAxisRenderer
extends AxisRenderer {
    public Path mDrawZeroLinePath = new Path();
    public float[] mGetTransformedPositionsBuffer = new float[2];
    public RectF mGridClippingRect = new RectF();
    public RectF mLimitLineClippingRect = new RectF();
    public Path mRenderGridLinesPath = new Path();
    public Path mRenderLimitLines = new Path();
    public float[] mRenderLimitLinesBuffer = new float[2];
    public YAxis mYAxis;
    public RectF mZeroLineClippingRect = new RectF();
    public Paint mZeroLinePaint;

    public YAxisRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, transformer, yAxis);
        this.mYAxis = yAxis;
        if (this.mViewPortHandler != null) {
            Paint paint;
            this.mAxisLabelPaint.setColor(-16777216);
            this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
            this.mZeroLinePaint = paint = new Paint(1);
            paint.setColor(-7829368);
            this.mZeroLinePaint.setStrokeWidth(1.0f);
            this.mZeroLinePaint.setStyle(Paint.Style.STROKE);
        }
    }

    public void drawYLabels(Canvas canvas, float f2, float[] arrf, float f3) {
        YAxis yAxis = this.mYAxis;
        int n2 = true ^ yAxis.mDrawBottomYLabelEntry;
        boolean bl = yAxis.mDrawTopYLabelEntry;
        int n3 = yAxis.mEntryCount;
        if (!bl) {
            --n3;
        }
        while (n2 < n3) {
            canvas.drawText(this.mYAxis.getFormattedLabel(n2), f2, f3 + arrf[1 + n2 * 2], this.mAxisLabelPaint);
            ++n2;
        }
    }

    public RectF getGridClippingRect() {
        this.mGridClippingRect.set(this.mViewPortHandler.mContentRect);
        this.mGridClippingRect.inset(0.0f, -this.mAxis.mGridLineWidth);
        return this.mGridClippingRect;
    }

    public float[] getTransformedPositions() {
        int n2 = this.mGetTransformedPositionsBuffer.length;
        int n3 = this.mYAxis.mEntryCount;
        if (n2 != n3 * 2) {
            this.mGetTransformedPositionsBuffer = new float[n3 * 2];
        }
        float[] arrf = this.mGetTransformedPositionsBuffer;
        for (int i2 = 0; i2 < arrf.length; i2 += 2) {
            arrf[i2 + 1] = this.mYAxis.mEntries[i2 / 2];
        }
        this.mTrans.pointValuesToPixel(arrf);
        return arrf;
    }

    public Path linePath(Path path, int n2, float[] arrf) {
        float f2 = this.mViewPortHandler.mContentRect.left;
        int n3 = n2 + 1;
        path.moveTo(f2, arrf[n3]);
        path.lineTo(this.mViewPortHandler.mContentRect.right, arrf[n3]);
        return path;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void renderAxisLabels(Canvas var1_1) {
        block3 : {
            block4 : {
                var2_2 = this.mYAxis;
                if (var2_2.mEnabled == false) return;
                if (!var2_2.mDrawLabels) {
                    return;
                }
                var3_3 = this.getTransformedPositions();
                var4_4 = this.mAxisLabelPaint;
                Objects.requireNonNull((Object)this.mYAxis);
                var4_4.setTypeface(null);
                this.mAxisLabelPaint.setTextSize(this.mYAxis.mTextSize);
                this.mAxisLabelPaint.setColor(this.mYAxis.mTextColor);
                var7_5 = this.mYAxis.mXOffset;
                var8_6 = (float)Utils.calcTextHeight(this.mAxisLabelPaint, "A") / 2.5f;
                var9_7 = this.mYAxis;
                var10_8 = var8_6 + var9_7.mYOffset;
                var11_9 = var9_7.mAxisDependency;
                var12_10 = var9_7.mPosition;
                if (var11_9 != YAxis.AxisDependency.LEFT) break block3;
                if (var12_10 != YAxis.YAxisLabelPosition.OUTSIDE_CHART) break block4;
                this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
                var13_11 = this.mViewPortHandler.mContentRect.left;
                ** GOTO lbl34
            }
            this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
            var15_12 = this.mViewPortHandler.mContentRect.left;
            ** GOTO lbl30
        }
        if (var12_10 == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
            this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
            var15_12 = this.mViewPortHandler.mContentRect.right;
lbl30: // 2 sources:
            var14_13 = var15_12 + var7_5;
        } else {
            this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
            var13_11 = this.mViewPortHandler.mContentRect.right;
lbl34: // 2 sources:
            var14_13 = var13_11 - var7_5;
        }
        this.drawYLabels(var1_1, var14_13, var3_3, var10_8);
    }

    public void renderAxisLine(Canvas canvas) {
        YAxis yAxis = this.mYAxis;
        if (yAxis.mEnabled) {
            if (!yAxis.mDrawAxisLine) {
                return;
            }
            this.mAxisLinePaint.setColor(yAxis.mAxisLineColor);
            this.mAxisLinePaint.setStrokeWidth(this.mYAxis.mAxisLineWidth);
            if (this.mYAxis.mAxisDependency == YAxis.AxisDependency.LEFT) {
                RectF rectF = this.mViewPortHandler.mContentRect;
                float f2 = rectF.left;
                canvas.drawLine(f2, rectF.top, f2, rectF.bottom, this.mAxisLinePaint);
                return;
            }
            RectF rectF = this.mViewPortHandler.mContentRect;
            float f3 = rectF.right;
            canvas.drawLine(f3, rectF.top, f3, rectF.bottom, this.mAxisLinePaint);
        }
    }

    public void renderGridLines(Canvas canvas) {
        YAxis yAxis = this.mYAxis;
        if (!yAxis.mEnabled) {
            return;
        }
        if (yAxis.mDrawGridLines) {
            int n2 = canvas.save();
            canvas.clipRect(this.getGridClippingRect());
            float[] arrf = this.getTransformedPositions();
            this.mGridPaint.setColor(this.mYAxis.mGridColor);
            this.mGridPaint.setStrokeWidth(this.mYAxis.mGridLineWidth);
            Paint paint = this.mGridPaint;
            Objects.requireNonNull((Object)this.mYAxis);
            paint.setPathEffect(null);
            Path path = this.mRenderGridLinesPath;
            path.reset();
            for (int i2 = 0; i2 < arrf.length; i2 += 2) {
                canvas.drawPath(this.linePath(path, i2, arrf), this.mGridPaint);
                path.reset();
            }
            canvas.restoreToCount(n2);
        }
        Objects.requireNonNull((Object)this.mYAxis);
    }

    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> list = this.mYAxis.mLimitLines;
        if (list != null) {
            if (list.size() <= 0) {
                return;
            }
            float[] arrf = this.mRenderLimitLinesBuffer;
            arrf[0] = 0.0f;
            arrf[1] = 0.0f;
            Path path = this.mRenderLimitLines;
            path.reset();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                if (!((LimitLine)list.get((int)i2)).mEnabled) continue;
                int n2 = canvas.save();
                this.mLimitLineClippingRect.set(this.mViewPortHandler.mContentRect);
                this.mLimitLineClippingRect.inset(0.0f, 0.0f);
                canvas.clipRect(this.mLimitLineClippingRect);
                this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
                this.mLimitLinePaint.setColor(0);
                this.mLimitLinePaint.setStrokeWidth(0.0f);
                this.mLimitLinePaint.setPathEffect(null);
                arrf[1] = 0.0f;
                this.mTrans.pointValuesToPixel(arrf);
                path.moveTo(this.mViewPortHandler.mContentRect.left, arrf[1]);
                path.lineTo(this.mViewPortHandler.mContentRect.right, arrf[1]);
                canvas.drawPath(path, this.mLimitLinePaint);
                path.reset();
                canvas.restoreToCount(n2);
            }
        }
    }
}

