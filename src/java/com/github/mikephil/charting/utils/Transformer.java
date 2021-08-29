/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  com.github.mikephil.charting.utils.MPPointD
 *  java.lang.Float
 *  java.lang.Object
 */
package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class Transformer {
    public Matrix mMatrixOffset = new Matrix();
    public Matrix mMatrixValueToPx = new Matrix();
    public Matrix mPixelToValueMatrixBuffer = new Matrix();
    public ViewPortHandler mViewPortHandler;
    public float[] ptsBuffer = new float[2];

    public Transformer(ViewPortHandler viewPortHandler) {
        new Matrix();
        new Matrix();
        this.mViewPortHandler = viewPortHandler;
    }

    public MPPointD getPixelForValues(float f3, float f4) {
        float[] arrf = this.ptsBuffer;
        arrf[0] = f3;
        arrf[1] = f4;
        this.pointValuesToPixel(arrf);
        float[] arrf2 = this.ptsBuffer;
        return MPPointD.getInstance((double)arrf2[0], (double)arrf2[1]);
    }

    public MPPointD getValuesByTouchPoint(float f3, float f4) {
        MPPointD mPPointD = MPPointD.getInstance((double)0.0, (double)0.0);
        this.getValuesByTouchPoint(f3, f4, mPPointD);
        return mPPointD;
    }

    public void getValuesByTouchPoint(float f3, float f4, MPPointD mPPointD) {
        float[] arrf = this.ptsBuffer;
        arrf[0] = f3;
        arrf[1] = f4;
        this.pixelsToValue(arrf);
        float[] arrf2 = this.ptsBuffer;
        mPPointD.x = arrf2[0];
        mPPointD.y = arrf2[1];
    }

    public void pixelsToValue(float[] arrf) {
        Matrix matrix = this.mPixelToValueMatrixBuffer;
        matrix.reset();
        this.mMatrixOffset.invert(matrix);
        matrix.mapPoints(arrf);
        this.mViewPortHandler.mMatrixTouch.invert(matrix);
        matrix.mapPoints(arrf);
        this.mMatrixValueToPx.invert(matrix);
        matrix.mapPoints(arrf);
    }

    public void pointValuesToPixel(float[] arrf) {
        this.mMatrixValueToPx.mapPoints(arrf);
        this.mViewPortHandler.mMatrixTouch.mapPoints(arrf);
        this.mMatrixOffset.mapPoints(arrf);
    }

    public void prepareMatrixOffset(boolean bl) {
        this.mMatrixOffset.reset();
        if (!bl) {
            Matrix matrix = this.mMatrixOffset;
            ViewPortHandler viewPortHandler = this.mViewPortHandler;
            matrix.postTranslate(viewPortHandler.mContentRect.left, viewPortHandler.mChartHeight - viewPortHandler.offsetBottom());
            return;
        }
        Matrix matrix = this.mMatrixOffset;
        RectF rectF = this.mViewPortHandler.mContentRect;
        matrix.setTranslate(rectF.left, -rectF.top);
        this.mMatrixOffset.postScale(1.0f, -1.0f);
    }

    public void prepareMatrixValuePx(float f3, float f4, float f5, float f6) {
        float f7 = this.mViewPortHandler.contentWidth() / f4;
        float f8 = this.mViewPortHandler.mContentRect.height() / f5;
        if (Float.isInfinite((float)f7)) {
            f7 = 0.0f;
        }
        if (Float.isInfinite((float)f8)) {
            f8 = 0.0f;
        }
        this.mMatrixValueToPx.reset();
        this.mMatrixValueToPx.postTranslate(-f3, -f6);
        this.mMatrixValueToPx.postScale(f7, -f8);
    }
}

