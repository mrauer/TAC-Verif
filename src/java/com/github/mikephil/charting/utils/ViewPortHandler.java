/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.view.View
 *  java.lang.Math
 *  java.lang.Object
 */
package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

public class ViewPortHandler {
    public Matrix mCenterViewPortMatrixBuffer = new Matrix();
    public float mChartHeight = 0.0f;
    public float mChartWidth = 0.0f;
    public RectF mContentRect = new RectF();
    public final Matrix mMatrixTouch = new Matrix();
    public float mMaxScaleX = Float.MAX_VALUE;
    public float mMaxScaleY = Float.MAX_VALUE;
    public float mMinScaleX = 1.0f;
    public float mMinScaleY = 1.0f;
    public float mScaleX = 1.0f;
    public float mScaleY = 1.0f;
    public float mTransOffsetX = 0.0f;
    public float mTransOffsetY = 0.0f;
    public float mTransX = 0.0f;
    public float mTransY = 0.0f;
    public final float[] matrixBuffer = new float[9];

    public float contentWidth() {
        return this.mContentRect.width();
    }

    public boolean isFullyZoomedOutX() {
        float f3 = this.mScaleX;
        float f4 = this.mMinScaleX;
        return !(f3 > f4) && !(f4 > 1.0f);
    }

    public boolean isFullyZoomedOutY() {
        float f3 = this.mScaleY;
        float f4 = this.mMinScaleY;
        return !(f3 > f4) && !(f4 > 1.0f);
    }

    public boolean isInBoundsBottom(float f3) {
        float f4 = (float)((int)(f3 * 100.0f)) / 100.0f;
        return this.mContentRect.bottom >= f4;
    }

    public boolean isInBoundsLeft(float f3) {
        return this.mContentRect.left <= f3 + 1.0f;
    }

    public boolean isInBoundsRight(float f3) {
        float f4 = (float)((int)(f3 * 100.0f)) / 100.0f;
        return this.mContentRect.right >= f4 - 1.0f;
    }

    public boolean isInBoundsTop(float f3) {
        return this.mContentRect.top <= f3;
    }

    public boolean isInBoundsX(float f3) {
        return this.isInBoundsLeft(f3) && this.isInBoundsRight(f3);
    }

    public boolean isInBoundsY(float f3) {
        return this.isInBoundsTop(f3) && this.isInBoundsBottom(f3);
    }

    public void limitTransAndScale(Matrix matrix, RectF rectF) {
        float f3;
        float f4;
        matrix.getValues(this.matrixBuffer);
        float[] arrf = this.matrixBuffer;
        float f5 = arrf[2];
        float f6 = arrf[0];
        float f7 = arrf[5];
        float f8 = arrf[4];
        this.mScaleX = Math.min((float)Math.max((float)this.mMinScaleX, (float)f6), (float)this.mMaxScaleX);
        this.mScaleY = Math.min((float)Math.max((float)this.mMinScaleY, (float)f8), (float)this.mMaxScaleY);
        float f9 = 0.0f;
        if (rectF != null) {
            f9 = rectF.width();
            f4 = rectF.height();
        } else {
            f4 = 0.0f;
        }
        this.mTransX = Math.min((float)Math.max((float)f5, (float)(-f9 * (this.mScaleX - 1.0f) - this.mTransOffsetX)), (float)this.mTransOffsetX);
        this.mTransY = f3 = Math.max((float)Math.min((float)f7, (float)(f4 * (this.mScaleY - 1.0f) + this.mTransOffsetY)), (float)(-this.mTransOffsetY));
        float[] arrf2 = this.matrixBuffer;
        arrf2[2] = this.mTransX;
        arrf2[0] = this.mScaleX;
        arrf2[5] = f3;
        arrf2[4] = this.mScaleY;
        matrix.setValues(arrf2);
    }

    public float offsetBottom() {
        return this.mChartHeight - this.mContentRect.bottom;
    }

    public float offsetRight() {
        return this.mChartWidth - this.mContentRect.right;
    }

    public Matrix refresh(Matrix matrix, View view, boolean bl) {
        this.mMatrixTouch.set(matrix);
        this.limitTransAndScale(this.mMatrixTouch, this.mContentRect);
        if (bl) {
            view.invalidate();
        }
        matrix.set(this.mMatrixTouch);
        return matrix;
    }

    public void restrainViewPort(float f3, float f4, float f5, float f6) {
        this.mContentRect.set(f3, f4, this.mChartWidth - f5, this.mChartHeight - f6);
    }
}

