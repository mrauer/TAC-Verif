/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetrics
 *  android.graphics.Rect
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  com.github.mikephil.charting.formatter.DefaultValueFormatter
 *  com.github.mikephil.charting.utils.FSize
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.mikephil.charting.utils;

import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.FSize;

public abstract class Utils {
    public static Rect mCalcTextHeightRect;
    public static Rect mCalcTextSizeRect;
    public static ValueFormatter mDefaultValueFormatter;
    public static Rect mDrawTextRectBuffer;
    public static Rect mDrawableBoundsCache;
    public static Paint.FontMetrics mFontMetrics;
    public static Paint.FontMetrics mFontMetricsBuffer;
    public static int mMaximumFlingVelocity = 8000;
    public static DisplayMetrics mMetrics;
    public static int mMinimumFlingVelocity = 50;

    public static {
        Double.longBitsToDouble((long)1L);
        Float.intBitsToFloat((int)1);
        mCalcTextHeightRect = new Rect();
        mFontMetrics = new Paint.FontMetrics();
        mCalcTextSizeRect = new Rect();
        mDefaultValueFormatter = new DefaultValueFormatter(1);
        mDrawableBoundsCache = new Rect();
        mDrawTextRectBuffer = new Rect();
        mFontMetricsBuffer = new Paint.FontMetrics();
    }

    public static int calcTextHeight(Paint paint, String string) {
        Rect rect = mCalcTextHeightRect;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(string, 0, string.length(), rect);
        return rect.height();
    }

    public static FSize calcTextSize(Paint paint, String string) {
        FSize fSize = FSize.getInstance((float)0.0f, (float)0.0f);
        Rect rect = mCalcTextSizeRect;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(string, 0, string.length(), rect);
        fSize.width = rect.width();
        fSize.height = rect.height();
        return fSize;
    }

    public static int calcTextWidth(Paint paint, String string) {
        return (int)paint.measureText(string);
    }

    public static float convertDpToPixel(float f3) {
        DisplayMetrics displayMetrics = mMetrics;
        if (displayMetrics == null) {
            Log.e((String)"MPChartLib-Utils", (String)"Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
            return f3;
        }
        return f3 * displayMetrics.density;
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(float f3, float f4, float f5) {
        double d4 = f5 * 0.017453292f;
        return FSize.getInstance((float)(Math.abs((float)(f3 * (float)Math.cos((double)d4))) + Math.abs((float)(f4 * (float)Math.sin((double)d4)))), (float)(Math.abs((float)(f3 * (float)Math.sin((double)d4))) + Math.abs((float)(f4 * (float)Math.cos((double)d4)))));
    }

    public static float roundToNextSignificant(double d4) {
        if (!Double.isInfinite((double)d4) && !Double.isNaN((double)d4) && d4 != 0.0) {
            double d5 = d4 < 0.0 ? -d4 : d4;
            float f3 = (float)Math.pow((double)10.0, (double)(1 - (int)Math.ceil((double)((float)Math.log10((double)d5)))));
            return (float)Math.round((double)(d4 * (double)f3)) / f3;
        }
        return 0.0f;
    }
}

