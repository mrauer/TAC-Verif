/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.Typeface
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Objects
 */
package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.Renderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;
import java.util.Objects;

public class BarChartRenderer
extends BarLineScatterCandleBubbleRenderer {
    public Paint mBarBorderPaint;
    public BarBuffer[] mBarBuffers;
    public RectF mBarRect = new RectF();
    public RectF mBarShadowRectBuffer = new RectF();
    public BarDataProvider mChart;
    public Paint mShadowPaint;

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        Paint paint;
        Paint paint2;
        Paint paint3;
        super(chartAnimator, viewPortHandler);
        this.mChart = barDataProvider;
        this.mHighlightPaint = paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setColor(Color.rgb((int)0, (int)0, (int)0));
        this.mHighlightPaint.setAlpha(120);
        this.mShadowPaint = paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.mBarBorderPaint = paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.STROKE);
    }

    public void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int n2) {
        float[] arrf;
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(iBarDataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(iBarDataSet.getBarBorderWidth()));
        float f2 = iBarDataSet.getBarBorderWidth() FCMPL 0.0f;
        int n3 = 1;
        int n4 = f2 > 0 ? n3 : 0;
        Objects.requireNonNull((Object)this.mAnimator);
        Objects.requireNonNull((Object)this.mAnimator);
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
            float f3 = this.mChart.getBarData().mBarWidth / 2.0f;
            int n5 = Math.min((int)((int)Math.ceil((double)(1.0f * (float)iBarDataSet.getEntryCount()))), (int)iBarDataSet.getEntryCount());
            for (int i2 = 0; i2 < n5; ++i2) {
                float f4 = ((BarEntry)iBarDataSet.getEntryForIndex((int)i2)).x;
                RectF rectF = this.mBarShadowRectBuffer;
                rectF.left = f4 - f3;
                rectF.right = f4 + f3;
                transformer.mMatrixValueToPx.mapRect(rectF);
                transformer.mViewPortHandler.mMatrixTouch.mapRect(rectF);
                transformer.mMatrixOffset.mapRect(rectF);
                if (!this.mViewPortHandler.isInBoundsLeft(this.mBarShadowRectBuffer.right)) continue;
                if (!this.mViewPortHandler.isInBoundsRight(this.mBarShadowRectBuffer.left)) break;
                RectF rectF2 = this.mBarShadowRectBuffer;
                RectF rectF3 = this.mViewPortHandler.mContentRect;
                rectF2.top = rectF3.top;
                rectF2.bottom = rectF3.bottom;
                canvas.drawRect(rectF2, this.mShadowPaint);
            }
        }
        BarBuffer barBuffer = this.mBarBuffers[n2];
        barBuffer.phaseX = 1.0f;
        barBuffer.phaseY = 1.0f;
        barBuffer.mInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
        barBuffer.mBarWidth = this.mChart.getBarData().mBarWidth;
        barBuffer.feed(iBarDataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        if (iBarDataSet.getColors().size() != n3) {
            n3 = 0;
        }
        int n6 = 0;
        if (n3 != 0) {
            this.mRenderPaint.setColor(iBarDataSet.getColor());
        }
        while (n6 < (arrf = barBuffer.buffer).length) {
            ViewPortHandler viewPortHandler = this.mViewPortHandler;
            int n7 = n6 + 2;
            if (viewPortHandler.isInBoundsLeft(arrf[n7])) {
                if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[n6])) {
                    return;
                }
                if (n3 == 0) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(n6 / 4));
                }
                if (iBarDataSet.getGradientColor() != null) {
                    GradientColor gradientColor = iBarDataSet.getGradientColor();
                    Paint paint = this.mRenderPaint;
                    float[] arrf2 = barBuffer.buffer;
                    float f5 = arrf2[n6];
                    float f6 = arrf2[n6 + 3];
                    float f7 = arrf2[n6];
                    float f8 = arrf2[n6 + 1];
                    Objects.requireNonNull((Object)gradientColor);
                    LinearGradient linearGradient = new LinearGradient(f5, f6, f7, f8, 0, 0, Shader.TileMode.MIRROR);
                    paint.setShader((Shader)linearGradient);
                }
                if (iBarDataSet.getGradientColors() != null) {
                    Paint paint = this.mRenderPaint;
                    float[] arrf3 = barBuffer.buffer;
                    float f9 = arrf3[n6];
                    float f10 = arrf3[n6 + 3];
                    float f11 = arrf3[n6];
                    float f12 = arrf3[n6 + 1];
                    int n8 = n6 / 4;
                    Objects.requireNonNull((Object)iBarDataSet.getGradientColor(n8));
                    Objects.requireNonNull((Object)iBarDataSet.getGradientColor(n8));
                    LinearGradient linearGradient = new LinearGradient(f9, f10, f11, f12, 0, 0, Shader.TileMode.MIRROR);
                    paint.setShader((Shader)linearGradient);
                }
                float[] arrf4 = barBuffer.buffer;
                float f13 = arrf4[n6];
                int n9 = n6 + 1;
                float f14 = arrf4[n9];
                float f15 = arrf4[n7];
                int n10 = n6 + 3;
                canvas.drawRect(f13, f14, f15, arrf4[n10], this.mRenderPaint);
                if (n4 != 0) {
                    float[] arrf5 = barBuffer.buffer;
                    canvas.drawRect(arrf5[n6], arrf5[n9], arrf5[n7], arrf5[n10], this.mBarBorderPaint);
                }
            }
            n6 += 4;
        }
    }

    public void drawValue(Canvas canvas, String string, float f2, float f3, int n2) {
        this.mValuePaint.setColor(n2);
        canvas.drawText(string, f2, f3, this.mValuePaint);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void drawValues(Canvas var1_1) {
        if (this.isDrawingValuesAllowed(this.mChart) == false) return;
        var2_2 = this.mChart.getBarData().mDataSets;
        var3_3 = Utils.convertDpToPixel(4.5f);
        var4_4 = this.mChart.isDrawValueAboveBarEnabled();
        var5_5 = 0;
        block0 : do {
            block17 : {
                block16 : {
                    if (var5_5 >= this.mChart.getBarData().getDataSetCount()) return;
                    var6_6 = (IBarDataSet)var2_2.get(var5_5);
                    if (this.shouldDrawValues(var6_6)) break block16;
                    var21_19 = var2_2;
                    var29_26 = var3_3;
                    var30_27 = var4_4;
                    ** GOTO lbl139
                }
                this.mValuePaint.setTypeface(var6_6.getValueTypeface());
                this.mValuePaint.setTextSize(var6_6.getValueTextSize());
                var8_7 = this.mChart.isInverted(var6_6.getAxisDependency());
                var9_8 = Utils.calcTextHeight(this.mValuePaint, "8");
                var10_9 = var4_4 != false ? -var3_3 : var9_8 + var3_3;
                var11_10 = var4_4 != false ? var9_8 + var3_3 : -var3_3;
                if (var8_7) {
                    var10_9 = -var10_9 - var9_8;
                    var11_10 = -var11_10 - var9_8;
                }
                var12_11 = var10_9;
                var13_12 = var11_10;
                var14_13 = this.mBarBuffers[var5_5];
                Objects.requireNonNull((Object)this.mAnimator);
                var16_14 = var6_6.getValueFormatter();
                var17_15 = var6_6.getIconsOffset();
                var18_16 = MPPointF.pool.get();
                var18_16.x = var19_17 = var17_15.x;
                var18_16.y = var17_15.y;
                var18_16.x = Utils.convertDpToPixel(var19_17);
                var18_16.y = Utils.convertDpToPixel(var18_16.y);
                if (var6_6.isStacked()) break block17;
                var75_72 = 0;
                do {
                    var76_73 = var75_72;
                    var77_74 = var14_13.buffer.length;
                    Objects.requireNonNull((Object)this.mAnimator);
                    if (!(var76_73 < var77_74 * 1.0f) || !this.mViewPortHandler.isInBoundsRight(var80_76 = ((var79_75 = var14_13.buffer)[var75_72] + var79_75[var75_72 + 2]) / 2.0f)) break;
                    var81_77 = this.mViewPortHandler;
                    var82_78 = var14_13.buffer;
                    var83_79 = var75_72 + 1;
                    if (!var81_77.isInBoundsY(var82_78[var83_79]) || !this.mViewPortHandler.isInBoundsLeft(var80_76)) ** GOTO lbl-1000
                    var88_84 = var75_72 / 4;
                    var89_85 = (BarEntry)var6_6.getEntryForIndex(var88_84);
                    var90_86 = var89_85.y;
                    if (var6_6.isDrawValuesEnabled()) {
                        var91_87 = var16_14.getBarLabel(var89_85);
                        var92_88 = var90_86 >= 0.0f ? var12_11 + var14_13.buffer[var83_79] : var13_12 + var14_13.buffer[var75_72 + 3];
                        var93_89 = var92_88;
                        var94_90 = var6_6.getValueTextColor(var88_84);
                        var84_80 = var75_72;
                        var86_82 = var2_2;
                        var87_83 = var18_16;
                        var85_81 = var16_14;
                        this.drawValue(var1_1, var91_87, var80_76, var93_89, var94_90);
                    } else lbl-1000: // 2 sources:
                    {
                        var84_80 = var75_72;
                        var85_81 = var16_14;
                        var86_82 = var2_2;
                        var87_83 = var18_16;
                    }
                    var75_72 = var84_80 + 4;
                    var18_16 = var87_83;
                    var16_14 = var85_81;
                    var2_2 = var86_82;
                } while (true);
                var21_19 = var2_2;
                var22_20 = var18_16;
                ** GOTO lbl135
            }
            var20_18 = var16_14;
            var21_19 = var2_2;
            var22_20 = var18_16;
            var23_21 = this.mChart.getTransformer(var6_6.getAxisDependency());
            var24_22 = 0;
            var25_23 = 0;
            do {
                block15 : {
                    block22 : {
                        block23 : {
                            block18 : {
                                block19 : {
                                    block20 : {
                                        block21 : {
                                            var26_24 = var24_22;
                                            var27_25 = var6_6.getEntryCount();
                                            Objects.requireNonNull((Object)this.mAnimator);
                                            if (!(var26_24 < var27_25 * 1.0f)) break block18;
                                            var31_28 = (BarEntry)var6_6.getEntryForIndex(var24_22);
                                            var32_29 = var31_28.mYVals;
                                            var33_30 = var14_13.buffer;
                                            var34_31 = (var33_30[var25_23] + var33_30[var25_23 + 2]) / 2.0f;
                                            var35_32 = var6_6.getValueTextColor(var24_22);
                                            if (var32_29 != null) break block19;
                                            if (!this.mViewPortHandler.isInBoundsRight(var34_31)) break block18;
                                            var65_62 = this.mViewPortHandler;
                                            var66_63 = var14_13.buffer;
                                            var67_64 = var25_23 + 1;
                                            if (!var65_62.isInBoundsY(var66_63[var67_64]) || !this.mViewPortHandler.isInBoundsLeft(var34_31)) break block20;
                                            if (!var6_6.isDrawValuesEnabled()) break block21;
                                            var71_68 = var20_18.getBarLabel(var31_28);
                                            var72_69 = var14_13.buffer[var67_64];
                                            var73_70 = var31_28.y >= 0.0f ? var12_11 : var13_12;
                                            var74_71 = var72_69 + var73_70;
                                            var38_35 = var3_3;
                                            var40_37 = var32_29;
                                            var37_34 = var24_22;
                                            var39_36 = var4_4;
                                            var41_38 = var23_21;
                                            this.drawValue(var1_1, var71_68, var34_31, var74_71, var35_32);
                                            break block22;
                                        }
                                        var38_35 = var3_3;
                                        var39_36 = var4_4;
                                        var40_37 = var32_29;
                                        var37_34 = var24_22;
                                        var49_46 = var23_21;
                                        break block15;
                                    }
                                    var68_65 = var24_22;
                                    var69_66 = var3_3;
                                    var70_67 = var4_4;
                                    var24_22 = var68_65;
                                    var4_4 = var70_67;
                                    var3_3 = var69_66;
                                    continue;
                                }
                                var36_33 = var34_31;
                                var37_34 = var24_22;
                                var38_35 = var3_3;
                                var39_36 = var4_4;
                                var40_37 = var32_29;
                                var41_38 = var23_21;
                                var42_39 = 2 * var40_37.length;
                                var43_40 = new float[var42_39];
                                var44_41 = -var31_28.mNegativeSum;
                                var45_42 = 0.0f;
                                var47_44 = 0;
                                break block23;
                            }
                            var29_26 = var3_3;
                            var30_27 = var4_4;
                            MPPointF.pool.recycle(var22_20);
lbl139: // 2 sources:
                            ++var5_5;
                            var2_2 = var21_19;
                            var4_4 = var30_27;
                            var3_3 = var29_26;
                            continue block0;
                        }
                        for (var46_43 = 0; var46_43 < var42_39; var46_43 += 2, ++var47_44) {
                            var61_58 = var40_37[var47_44];
                            var62_59 = var61_58 FCMPL 0.0f;
                            if (var62_59 == false && (var45_42 == 0.0f || var44_41 == 0.0f)) {
                                var64_61 = var44_41;
                                var44_41 = var61_58;
                                var63_60 = var64_61;
                            } else if (var62_59 >= 0) {
                                var63_60 = var44_41;
                                var44_41 = var45_42 += var61_58;
                            } else {
                                var63_60 = var44_41 - var61_58;
                            }
                            var43_40[var46_43 + 1] = var44_41 * 1.0f;
                            var44_41 = var63_60;
                        }
                        var41_38.pointValuesToPixel(var43_40);
                        var48_45 = 0;
                        while (var48_45 < var42_39) {
                            var50_47 = var40_37[var48_45 / 2];
                            var51_48 = var50_47 == 0.0f && var44_41 == 0.0f && var45_42 > 0.0f || var50_47 < 0.0f;
                            var52_49 = var43_40[var48_45 + 1];
                            var53_50 = var51_48 != false ? var13_12 : var12_11;
                            var54_51 = var52_49 + var53_50;
                            var55_52 = this.mViewPortHandler;
                            var49_46 = var41_38;
                            var56_53 = var36_33;
                            if (var55_52.isInBoundsRight(var56_53)) {
                                if (this.mViewPortHandler.isInBoundsY(var54_51) && this.mViewPortHandler.isInBoundsLeft(var56_53) && var6_6.isDrawValuesEnabled()) {
                                    var60_57 = var20_18.getFormattedValue(var50_47);
                                    var57_54 = var48_45;
                                    var58_55 = var43_40;
                                    var59_56 = var42_39;
                                    this.drawValue(var1_1, var60_57, var56_53, var54_51, var35_32);
                                } else {
                                    var57_54 = var48_45;
                                    var58_55 = var43_40;
                                    var59_56 = var42_39;
                                }
                                var48_45 = var57_54 + 2;
                                var36_33 = var56_53;
                                var41_38 = var49_46;
                                var42_39 = var59_56;
                                var43_40 = var58_55;
                                continue;
                            }
                            break block15;
                        }
                    }
                    var49_46 = var41_38;
                }
                var25_23 = var40_37 == null ? (var25_23 += 4) : (var25_23 += 4 * var40_37.length);
                var24_22 = var37_34 + 1;
                var4_4 = var39_36;
                var3_3 = var38_35;
                var23_21 = var49_46;
            } while (true);
            break;
        } while (true);
    }

    @Override
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[barData.getDataSetCount()];
        for (int i2 = 0; i2 < this.mBarBuffers.length; ++i2) {
            IBarDataSet iBarDataSet = (IBarDataSet)barData.getDataSetByIndex(i2);
            BarBuffer[] arrbarBuffer = this.mBarBuffers;
            int n2 = 4 * iBarDataSet.getEntryCount();
            int n3 = iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1;
            arrbarBuffer[i2] = new BarBuffer(n2 * n3, barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    public void prepareBarHighlight(float f2, float f3, float f4, float f5, Transformer transformer) {
        float f6 = f2 - f5;
        float f7 = f2 + f5;
        this.mBarRect.set(f6, f3, f7, f4);
        RectF rectF = this.mBarRect;
        Objects.requireNonNull((Object)this.mAnimator);
        Objects.requireNonNull((Object)transformer);
        rectF.top = 1.0f * rectF.top;
        rectF.bottom = 1.0f * rectF.bottom;
        transformer.mMatrixValueToPx.mapRect(rectF);
        transformer.mViewPortHandler.mMatrixTouch.mapRect(rectF);
        transformer.mMatrixOffset.mapRect(rectF);
    }

    public void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        float f2 = rectF.centerX();
        float f3 = rectF.top;
        highlight.mDrawX = f2;
        highlight.mDrawY = f3;
    }
}

