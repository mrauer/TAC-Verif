/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.DashPathEffect
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$FontMetrics
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.AnimationUtils
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.github.mikephil.charting.renderer.BarChartRenderer
 *  java.lang.Boolean
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Objects
 */
package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnDrawListener;
import com.github.mikephil.charting.renderer.AxisRenderer;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.renderer.Renderer;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@SuppressLint(value={"RtlHardcoded"})
public abstract class BarLineChartBase<T extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>
extends Chart<T>
implements BarLineScatterCandleBubbleDataProvider {
    public long drawCycles = 0L;
    public boolean mAutoScaleMinMaxEnabled = false;
    public YAxis mAxisLeft;
    public YAxisRenderer mAxisRendererLeft;
    public YAxisRenderer mAxisRendererRight;
    public YAxis mAxisRight;
    public Paint mBorderPaint;
    public boolean mClipValuesToContent = false;
    public boolean mDoubleTapToZoomEnabled = true;
    public boolean mDragXEnabled = true;
    public boolean mDragYEnabled = true;
    public boolean mDrawBorders = false;
    public boolean mDrawGridBackground = false;
    public OnDrawListener mDrawListener;
    public Paint mGridBackgroundPaint;
    public boolean mHighlightPerDragEnabled = true;
    public boolean mKeepPositionOnRotation = false;
    public Transformer mLeftAxisTransformer;
    public int mMaxVisibleCount = 100;
    public float mMinOffset = 15.0f;
    public RectF mOffsetsBuffer = new RectF();
    public float[] mOnSizeChangedBuffer;
    public boolean mPinchZoomEnabled = false;
    public Transformer mRightAxisTransformer;
    public boolean mScaleXEnabled = true;
    public boolean mScaleYEnabled = true;
    public XAxisRenderer mXAxisRenderer;
    public Matrix mZoomMatrixBuffer = new Matrix();
    public MPPointD posForGetHighestVisibleX;
    public MPPointD posForGetLowestVisibleX;
    public long totalTime = 0L;

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new Matrix();
        this.posForGetLowestVisibleX = MPPointD.getInstance(0.0, 0.0);
        this.posForGetHighestVisibleX = MPPointD.getInstance(0.0, 0.0);
        this.mOnSizeChangedBuffer = new float[2];
    }

    public void calcMinMax() {
        XAxis xAxis = this.mXAxis;
        Object t2 = this.mData;
        xAxis.calculate(((BarLineScatterCandleBubbleData)t2).mXMin, ((BarLineScatterCandleBubbleData)t2).mXMax);
        YAxis yAxis = this.mAxisLeft;
        BarLineScatterCandleBubbleData barLineScatterCandleBubbleData = (BarLineScatterCandleBubbleData)this.mData;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.calculate(barLineScatterCandleBubbleData.getYMin(axisDependency), ((BarLineScatterCandleBubbleData)this.mData).getYMax(axisDependency));
        YAxis yAxis2 = this.mAxisRight;
        BarLineScatterCandleBubbleData barLineScatterCandleBubbleData2 = (BarLineScatterCandleBubbleData)this.mData;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.calculate(barLineScatterCandleBubbleData2.getYMin(axisDependency2), ((BarLineScatterCandleBubbleData)this.mData).getYMax(axisDependency2));
    }

    public void calculateLegendOffsets(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        Legend legend = this.mLegend;
        if (legend != null && legend.mEnabled) {
            int n2 = legend.mOrientation.ordinal();
            if (n2 != 0) {
                if (n2 != 1) {
                    return;
                }
                int n3 = this.mLegend.mHorizontalAlignment.ordinal();
                if (n3 != 0) {
                    if (n3 != 1) {
                        if (n3 != 2) {
                            return;
                        }
                        float f2 = rectF.right;
                        Legend legend2 = this.mLegend;
                        rectF.right = f2 + (Math.min((float)legend2.mNeededWidth, (float)(this.mViewPortHandler.mChartWidth * legend2.mMaxSizePercent)) + this.mLegend.mXOffset);
                        return;
                    }
                    int n4 = this.mLegend.mVerticalAlignment.ordinal();
                    if (n4 != 0) {
                        if (n4 != 2) {
                            return;
                        }
                        float f3 = rectF.bottom;
                        Legend legend3 = this.mLegend;
                        rectF.bottom = f3 + (Math.min((float)legend3.mNeededHeight, (float)(this.mViewPortHandler.mChartHeight * legend3.mMaxSizePercent)) + this.mLegend.mYOffset);
                        return;
                    }
                    float f4 = rectF.top;
                    Legend legend4 = this.mLegend;
                    rectF.top = f4 + (Math.min((float)legend4.mNeededHeight, (float)(this.mViewPortHandler.mChartHeight * legend4.mMaxSizePercent)) + this.mLegend.mYOffset);
                    return;
                }
                float f5 = rectF.left;
                Legend legend5 = this.mLegend;
                rectF.left = f5 + (Math.min((float)legend5.mNeededWidth, (float)(this.mViewPortHandler.mChartWidth * legend5.mMaxSizePercent)) + this.mLegend.mXOffset);
                return;
            }
            int n5 = this.mLegend.mVerticalAlignment.ordinal();
            if (n5 != 0) {
                if (n5 != 2) {
                    return;
                }
                float f6 = rectF.bottom;
                Legend legend6 = this.mLegend;
                rectF.bottom = f6 + (Math.min((float)legend6.mNeededHeight, (float)(this.mViewPortHandler.mChartHeight * legend6.mMaxSizePercent)) + this.mLegend.mYOffset);
                return;
            }
            float f7 = rectF.top;
            Legend legend7 = this.mLegend;
            rectF.top = f7 + (Math.min((float)legend7.mNeededHeight, (float)(this.mViewPortHandler.mChartHeight * legend7.mMaxSizePercent)) + this.mLegend.mYOffset);
        }
    }

    @Override
    public void calculateOffsets() {
        float f2;
        float f3;
        float f4;
        float f5;
        block6 : {
            float f6;
            block8 : {
                XAxis.XAxisPosition xAxisPosition;
                block7 : {
                    this.calculateLegendOffsets(this.mOffsetsBuffer);
                    RectF rectF = this.mOffsetsBuffer;
                    f4 = 0.0f + rectF.left;
                    f2 = 0.0f + rectF.top;
                    f5 = 0.0f + rectF.right;
                    f3 = 0.0f + rectF.bottom;
                    if (this.mAxisLeft.needsOffset()) {
                        f4 += this.mAxisLeft.getRequiredWidthSpace(this.mAxisRendererLeft.mAxisLabelPaint);
                    }
                    if (this.mAxisRight.needsOffset()) {
                        f5 += this.mAxisRight.getRequiredWidthSpace(this.mAxisRendererRight.mAxisLabelPaint);
                    }
                    XAxis xAxis = this.mXAxis;
                    if (!xAxis.mEnabled || !xAxis.mDrawLabels) break block6;
                    f6 = (float)xAxis.mLabelRotatedHeight + xAxis.mYOffset;
                    xAxisPosition = xAxis.mPosition;
                    if (xAxisPosition != XAxis.XAxisPosition.BOTTOM) break block7;
                    f3 += f6;
                    break block6;
                }
                if (xAxisPosition == XAxis.XAxisPosition.TOP) break block8;
                if (xAxisPosition != XAxis.XAxisPosition.BOTH_SIDED) break block6;
                f3 += f6;
            }
            f2 += f6;
        }
        float f7 = f2 + this.getExtraTopOffset();
        float f8 = f5 + this.getExtraRightOffset();
        float f9 = f3 + this.getExtraBottomOffset();
        float f10 = f4 + this.getExtraLeftOffset();
        float f11 = Utils.convertDpToPixel(this.mMinOffset);
        this.mViewPortHandler.restrainViewPort(Math.max((float)f11, (float)f10), Math.max((float)f11, (float)f7), Math.max((float)f11, (float)f8), Math.max((float)f11, (float)f9));
        if (this.mLogEnabled) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("offsetLeft: ");
            stringBuilder.append(f10);
            stringBuilder.append(", offsetTop: ");
            stringBuilder.append(f7);
            stringBuilder.append(", offsetRight: ");
            stringBuilder.append(f8);
            stringBuilder.append(", offsetBottom: ");
            stringBuilder.append(f9);
            Log.i((String)"MPAndroidChart", (String)stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Content: ");
            stringBuilder2.append(this.mViewPortHandler.mContentRect.toString());
            Log.i((String)"MPAndroidChart", (String)stringBuilder2.toString());
        }
        Transformer transformer = this.mRightAxisTransformer;
        Objects.requireNonNull((Object)this.mAxisRight);
        transformer.prepareMatrixOffset(false);
        Transformer transformer2 = this.mLeftAxisTransformer;
        Objects.requireNonNull((Object)this.mAxisLeft);
        transformer2.prepareMatrixOffset(false);
        this.prepareValuePxMatrix();
    }

    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        if (chartTouchListener instanceof BarLineChartTouchListener) {
            float f2;
            float f3;
            BarLineChartTouchListener barLineChartTouchListener = (BarLineChartTouchListener)chartTouchListener;
            MPPointF mPPointF = barLineChartTouchListener.mDecelerationVelocity;
            if (mPPointF.x == 0.0f && mPPointF.y == 0.0f) {
                return;
            }
            long l2 = AnimationUtils.currentAnimationTimeMillis();
            MPPointF mPPointF2 = barLineChartTouchListener.mDecelerationVelocity;
            mPPointF2.x *= ((BarLineChartBase)barLineChartTouchListener.mChart).getDragDecelerationFrictionCoef();
            MPPointF mPPointF3 = barLineChartTouchListener.mDecelerationVelocity;
            mPPointF3.y *= ((BarLineChartBase)barLineChartTouchListener.mChart).getDragDecelerationFrictionCoef();
            float f4 = (float)(l2 - barLineChartTouchListener.mDecelerationLastTime) / 1000.0f;
            MPPointF mPPointF4 = barLineChartTouchListener.mDecelerationVelocity;
            float f5 = f4 * mPPointF4.x;
            float f6 = f4 * mPPointF4.y;
            MPPointF mPPointF5 = barLineChartTouchListener.mDecelerationCurrentPoint;
            mPPointF5.x = f2 = f5 + mPPointF5.x;
            mPPointF5.y = f3 = f6 + mPPointF5.y;
            MotionEvent motionEvent = MotionEvent.obtain((long)l2, (long)l2, (int)2, (float)f2, (float)f3, (int)0);
            BarLineChartBase barLineChartBase = (BarLineChartBase)barLineChartTouchListener.mChart;
            float f7 = barLineChartBase.mDragXEnabled ? barLineChartTouchListener.mDecelerationCurrentPoint.x - barLineChartTouchListener.mTouchStartPoint.x : 0.0f;
            boolean bl = barLineChartBase.mDragYEnabled;
            float f8 = 0.0f;
            if (bl) {
                f8 = barLineChartTouchListener.mDecelerationCurrentPoint.y - barLineChartTouchListener.mTouchStartPoint.y;
            }
            barLineChartTouchListener.performDrag(motionEvent, f7, f8);
            motionEvent.recycle();
            ViewPortHandler viewPortHandler = ((BarLineChartBase)barLineChartTouchListener.mChart).getViewPortHandler();
            Matrix matrix = barLineChartTouchListener.mMatrix;
            viewPortHandler.refresh(matrix, (View)barLineChartTouchListener.mChart, false);
            barLineChartTouchListener.mMatrix = matrix;
            barLineChartTouchListener.mDecelerationLastTime = l2;
            if (!((double)Math.abs((float)barLineChartTouchListener.mDecelerationVelocity.x) >= 0.01) && !((double)Math.abs((float)barLineChartTouchListener.mDecelerationVelocity.y) >= 0.01)) {
                ((BarLineChartBase)barLineChartTouchListener.mChart).calculateOffsets();
                ((BarLineChartBase)barLineChartTouchListener.mChart).postInvalidate();
                barLineChartTouchListener.stopDeceleration();
                return;
            }
            Object t2 = barLineChartTouchListener.mChart;
            t2.postInvalidateOnAnimation();
        }
    }

    public YAxis getAxisLeft() {
        return this.mAxisLeft;
    }

    public YAxis getAxisRight() {
        return this.mAxisRight;
    }

    public OnDrawListener getDrawListener() {
        return this.mDrawListener;
    }

    public float getHighestVisibleX() {
        Transformer transformer = this.getTransformer(YAxis.AxisDependency.LEFT);
        RectF rectF = this.mViewPortHandler.mContentRect;
        transformer.getValuesByTouchPoint(rectF.right, rectF.bottom, this.posForGetHighestVisibleX);
        return (float)Math.min((double)this.mXAxis.mAxisMaximum, (double)this.posForGetHighestVisibleX.x);
    }

    public float getLowestVisibleX() {
        Transformer transformer = this.getTransformer(YAxis.AxisDependency.LEFT);
        RectF rectF = this.mViewPortHandler.mContentRect;
        transformer.getValuesByTouchPoint(rectF.left, rectF.bottom, this.posForGetLowestVisibleX);
        return (float)Math.max((double)this.mXAxis.mAxisMinimum, (double)this.posForGetLowestVisibleX.x);
    }

    @Override
    public int getMaxVisibleCount() {
        return this.mMaxVisibleCount;
    }

    public float getMinOffset() {
        return this.mMinOffset;
    }

    public YAxisRenderer getRendererLeftYAxis() {
        return this.mAxisRendererLeft;
    }

    public YAxisRenderer getRendererRightYAxis() {
        return this.mAxisRendererRight;
    }

    public XAxisRenderer getRendererXAxis() {
        return this.mXAxisRenderer;
    }

    public float getScaleX() {
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (viewPortHandler == null) {
            return 1.0f;
        }
        return viewPortHandler.mScaleX;
    }

    public float getScaleY() {
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (viewPortHandler == null) {
            return 1.0f;
        }
        return viewPortHandler.mScaleY;
    }

    @Override
    public Transformer getTransformer(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mLeftAxisTransformer;
        }
        return this.mRightAxisTransformer;
    }

    public float getVisibleXRange() {
        return Math.abs((float)(this.getHighestVisibleX() - this.getLowestVisibleX()));
    }

    @Override
    public float getYChartMax() {
        return Math.max((float)this.mAxisLeft.mAxisMaximum, (float)this.mAxisRight.mAxisMaximum);
    }

    @Override
    public float getYChartMin() {
        return Math.min((float)this.mAxisLeft.mAxisMinimum, (float)this.mAxisRight.mAxisMinimum);
    }

    @Override
    public void init() {
        Paint paint;
        Paint paint2;
        super.init();
        this.mAxisLeft = new YAxis(YAxis.AxisDependency.LEFT);
        this.mAxisRight = new YAxis(YAxis.AxisDependency.RIGHT);
        this.mLeftAxisTransformer = new Transformer(this.mViewPortHandler);
        this.mRightAxisTransformer = new Transformer(this.mViewPortHandler);
        this.mAxisRendererLeft = new YAxisRenderer(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRenderer(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new XAxisRenderer(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer);
        this.setHighlighter(new ChartHighlighter<BarLineChartBase>(this));
        this.mChartTouchListener = new BarLineChartTouchListener(this, this.mViewPortHandler.mMatrixTouch, 3.0f);
        this.mGridBackgroundPaint = paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        this.mGridBackgroundPaint.setColor(Color.rgb((int)240, (int)240, (int)240));
        this.mBorderPaint = paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setColor(-16777216);
        this.mBorderPaint.setStrokeWidth(Utils.convertDpToPixel(1.0f));
    }

    @Override
    public boolean isInverted(YAxis.AxisDependency axisDependency) {
        YAxis yAxis = axisDependency == YAxis.AxisDependency.LEFT ? this.mAxisLeft : this.mAxisRight;
        Objects.requireNonNull((Object)yAxis);
        return false;
    }

    @Override
    public void notifyDataSetChanged() {
        DataRenderer dataRenderer;
        if (this.mData == null) {
            if (this.mLogEnabled) {
                Log.i((String)"MPAndroidChart", (String)"Preparing... DATA NOT SET.");
            }
            return;
        }
        if (this.mLogEnabled) {
            Log.i((String)"MPAndroidChart", (String)"Preparing...");
        }
        if ((dataRenderer = this.mRenderer) != null) {
            dataRenderer.initBuffers();
        }
        this.calcMinMax();
        YAxisRenderer yAxisRenderer = this.mAxisRendererLeft;
        YAxis yAxis = this.mAxisLeft;
        float f2 = yAxis.mAxisMinimum;
        float f3 = yAxis.mAxisMaximum;
        Objects.requireNonNull((Object)yAxis);
        yAxisRenderer.computeAxis(f2, f3, false);
        YAxisRenderer yAxisRenderer2 = this.mAxisRendererRight;
        YAxis yAxis2 = this.mAxisRight;
        float f4 = yAxis2.mAxisMinimum;
        float f5 = yAxis2.mAxisMaximum;
        Objects.requireNonNull((Object)yAxis2);
        yAxisRenderer2.computeAxis(f4, f5, false);
        XAxisRenderer xAxisRenderer = this.mXAxisRenderer;
        XAxis xAxis = this.mXAxis;
        xAxisRenderer.computeAxis(xAxis.mAxisMinimum, xAxis.mAxisMaximum, false);
        if (this.mLegend != null) {
            LegendRenderer legendRenderer = this.mLegendRenderer;
            Object t2 = this.mData;
            Objects.requireNonNull((Object)legendRenderer.mLegend);
            legendRenderer.computedEntries.clear();
            int n2 = 0;
            Object t3 = t2;
            do {
                IBarDataSet iBarDataSet;
                int n3 = ((ChartData)t2).getDataSetCount();
                int n4 = 1;
                if (n2 >= n3) break;
                Object t4 = ((ChartData)t3).getDataSetByIndex(n2);
                List<Integer> list = t4.getColors();
                int n5 = t4.getEntryCount();
                if (t4 instanceof IBarDataSet && (iBarDataSet = (IBarDataSet)t4).isStacked()) {
                    String[] arrstring = iBarDataSet.getStackLabels();
                    for (int i2 = 0; i2 < list.size() && i2 < iBarDataSet.getStackSize(); ++i2) {
                        List<LegendEntry> list2 = legendRenderer.computedEntries;
                        LegendEntry legendEntry = new LegendEntry(arrstring[i2 % arrstring.length], t4.getForm(), t4.getFormSize(), t4.getFormLineWidth(), t4.getFormLineDashEffect(), (Integer)list.get(i2));
                        list2.add((Object)legendEntry);
                    }
                    if (iBarDataSet.getLabel() != null) {
                        List<LegendEntry> list3 = legendRenderer.computedEntries;
                        LegendEntry legendEntry = new LegendEntry(t4.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, 1122867);
                        list3.add((Object)legendEntry);
                    }
                } else {
                    ICandleDataSet iCandleDataSet;
                    if (t4 instanceof IPieDataSet) {
                        IPieDataSet iPieDataSet = (IPieDataSet)t4;
                        for (int i3 = 0; i3 < list.size() && i3 < n5; ++i3) {
                            List<LegendEntry> list4 = legendRenderer.computedEntries;
                            Objects.requireNonNull((Object)((PieEntry)iPieDataSet.getEntryForIndex(i3)));
                            LegendEntry legendEntry = new LegendEntry(null, t4.getForm(), t4.getFormSize(), t4.getFormLineWidth(), t4.getFormLineDashEffect(), (Integer)list.get(i3));
                            list4.add((Object)legendEntry);
                        }
                        if (iPieDataSet.getLabel() != null) {
                            List<LegendEntry> list5 = legendRenderer.computedEntries;
                            LegendEntry legendEntry = new LegendEntry(t4.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, 1122867);
                            list5.add((Object)legendEntry);
                        }
                    } else if (t4 instanceof ICandleDataSet && (iCandleDataSet = (ICandleDataSet)t4).getDecreasingColor() != 1122867) {
                        int n6 = iCandleDataSet.getDecreasingColor();
                        int n7 = iCandleDataSet.getIncreasingColor();
                        List<LegendEntry> list6 = legendRenderer.computedEntries;
                        LegendEntry legendEntry = new LegendEntry(null, t4.getForm(), t4.getFormSize(), t4.getFormLineWidth(), t4.getFormLineDashEffect(), n6);
                        list6.add((Object)legendEntry);
                        List<LegendEntry> list7 = legendRenderer.computedEntries;
                        LegendEntry legendEntry2 = new LegendEntry(t4.getLabel(), t4.getForm(), t4.getFormSize(), t4.getFormLineWidth(), t4.getFormLineDashEffect(), n7);
                        list7.add((Object)legendEntry2);
                    } else {
                        for (int i4 = 0; i4 < list.size() && i4 < n5; ++i4) {
                            String string = i4 < list.size() - n4 && i4 < n5 - 1 ? null : ((ChartData)t2).getDataSetByIndex(n2).getLabel();
                            String string2 = string;
                            List<LegendEntry> list8 = legendRenderer.computedEntries;
                            LegendEntry legendEntry = new LegendEntry(string2, t4.getForm(), t4.getFormSize(), t4.getFormLineWidth(), t4.getFormLineDashEffect(), (Integer)list.get(i4));
                            list8.add((Object)legendEntry);
                            n4 = 1;
                        }
                    }
                    t3 = t2;
                }
                ++n2;
            } while (true);
            Objects.requireNonNull((Object)legendRenderer.mLegend);
            Legend legend = legendRenderer.mLegend;
            List<LegendEntry> list = legendRenderer.computedEntries;
            Objects.requireNonNull((Object)legend);
            legend.mEntries = (LegendEntry[])list.toArray((Object[])new LegendEntry[list.size()]);
            Objects.requireNonNull((Object)legendRenderer.mLegend);
            legendRenderer.mLegendLabelPaint.setTextSize(legendRenderer.mLegend.mTextSize);
            legendRenderer.mLegendLabelPaint.setColor(legendRenderer.mLegend.mTextColor);
            Legend legend2 = legendRenderer.mLegend;
            Paint paint = legendRenderer.mLegendLabelPaint;
            ViewPortHandler viewPortHandler = legendRenderer.mViewPortHandler;
            float f6 = Utils.convertDpToPixel(legend2.mFormSize);
            float f7 = Utils.convertDpToPixel(legend2.mStackSpace);
            float f8 = Utils.convertDpToPixel(legend2.mFormToTextSpace);
            float f9 = Utils.convertDpToPixel(legend2.mXEntrySpace);
            float f10 = Utils.convertDpToPixel(0.0f);
            LegendEntry[] arrlegendEntry = legend2.mEntries;
            int n8 = arrlegendEntry.length;
            Utils.convertDpToPixel(legend2.mFormToTextSpace);
            LegendEntry[] arrlegendEntry2 = legend2.mEntries;
            int n9 = arrlegendEntry2.length;
            float f11 = 0.0f;
            float f12 = 0.0f;
            for (int i5 = 0; i5 < n9; ++i5) {
                float f13;
                String string;
                LegendEntry legendEntry = arrlegendEntry2[i5];
                float f14 = Float.isNaN((float)legendEntry.formSize) ? legend2.mFormSize : legendEntry.formSize;
                float f15 = Utils.convertDpToPixel(f14);
                if (f15 > f11) {
                    f11 = f15;
                }
                if ((string = legendEntry.label) == null || !((f13 = (float)((int)paint.measureText(string))) > f12)) continue;
                f12 = f13;
            }
            LegendEntry[] arrlegendEntry3 = legend2.mEntries;
            int n10 = arrlegendEntry3.length;
            float f16 = 0.0f;
            for (int i6 = 0; i6 < n10; ++i6) {
                float f17;
                String string = arrlegendEntry3[i6].label;
                if (string == null || !((f17 = (float)Utils.calcTextHeight(paint, string)) > f16)) continue;
                f16 = f17;
            }
            int n11 = legend2.mOrientation.ordinal();
            if (n11 != 0) {
                if (n11 == 1) {
                    Paint.FontMetrics fontMetrics = Utils.mFontMetrics;
                    paint.getFontMetrics(fontMetrics);
                    float f18 = fontMetrics.descent - fontMetrics.ascent;
                    float f19 = 0.0f;
                    float f20 = 0.0f;
                    float f21 = 0.0f;
                    boolean bl = false;
                    for (int i7 = 0; i7 < n8; ++i7) {
                        LegendEntry legendEntry = arrlegendEntry[i7];
                        Legend.LegendForm legendForm = legendEntry.form;
                        float f22 = f6;
                        boolean bl2 = legendForm != Legend.LegendForm.NONE;
                        float f23 = Float.isNaN((float)legendEntry.formSize) ? f22 : Utils.convertDpToPixel(legendEntry.formSize);
                        String string = legendEntry.label;
                        if (!bl) {
                            f21 = 0.0f;
                        }
                        if (bl2) {
                            if (bl) {
                                f21 += f7;
                            }
                            f21 += f23;
                        }
                        if (string != null) {
                            float f24;
                            if (bl2 && !bl) {
                                f24 = f21 + f8;
                            } else if (bl) {
                                f19 = Math.max((float)f19, (float)f21);
                                f20 += f18 + f10;
                                f24 = 0.0f;
                                bl = false;
                            } else {
                                f24 = f21;
                            }
                            float f25 = f24 + (float)((int)paint.measureText(string));
                            if (i7 < n8 - 1) {
                                float f26 = f20 + (f18 + f10);
                                f21 = f25;
                                f20 = f26;
                            } else {
                                f21 = f25;
                            }
                        } else {
                            f21 += f23;
                            if (i7 < n8 - 1) {
                                f21 += f7;
                            }
                            bl = true;
                        }
                        f19 = Math.max((float)f19, (float)f21);
                        f6 = f22;
                    }
                    legend2.mNeededWidth = f19;
                    legend2.mNeededHeight = f20;
                }
            } else {
                float f27 = f6;
                Paint.FontMetrics fontMetrics = Utils.mFontMetrics;
                paint.getFontMetrics(fontMetrics);
                float f28 = fontMetrics.descent - fontMetrics.ascent;
                Paint.FontMetrics fontMetrics2 = Utils.mFontMetrics;
                paint.getFontMetrics(fontMetrics2);
                float f29 = f10 + (fontMetrics2.ascent - fontMetrics2.top + fontMetrics2.bottom);
                viewPortHandler.contentWidth();
                legend2.mCalculatedLabelBreakPoints.clear();
                legend2.mCalculatedLabelSizes.clear();
                legend2.mCalculatedLineSizes.clear();
                float f30 = 0.0f;
                float f31 = 0.0f;
                int n12 = -1;
                float f32 = 0.0f;
                for (int i8 = 0; i8 < n8; ++i8) {
                    Paint paint2;
                    LegendEntry legendEntry = arrlegendEntry[i8];
                    Legend.LegendForm legendForm = legendEntry.form;
                    float f33 = f9;
                    boolean bl = legendForm != Legend.LegendForm.NONE;
                    float f34 = Float.isNaN((float)legendEntry.formSize) ? f27 : Utils.convertDpToPixel(legendEntry.formSize);
                    String string = legendEntry.label;
                    LegendEntry[] arrlegendEntry4 = arrlegendEntry;
                    List<Boolean> list9 = legend2.mCalculatedLabelBreakPoints;
                    float f35 = f29;
                    list9.add((Object)Boolean.FALSE);
                    float f36 = n12 == -1 ? 0.0f : f30 + f7;
                    if (string != null) {
                        legend2.mCalculatedLabelSizes.add((Object)Utils.calcTextSize(paint, string));
                        float f37 = bl ? f8 + f34 : 0.0f;
                        f30 = f36 + f37 + ((FSize)legend2.mCalculatedLabelSizes.get((int)i8)).width;
                        paint2 = paint;
                    } else {
                        List<FSize> list10 = legend2.mCalculatedLabelSizes;
                        paint2 = paint;
                        list10.add((Object)FSize.getInstance(0.0f, 0.0f));
                        if (!bl) {
                            f34 = 0.0f;
                        }
                        f30 = f36 + f34;
                        if (n12 == -1) {
                            n12 = i8;
                        }
                    }
                    if (string != null || i8 == n8 - 1) {
                        float f38 = f32 == 0.0f ? 0.0f : f33;
                        f32 += f38 + f30;
                        if (i8 == n8 - 1) {
                            legend2.mCalculatedLineSizes.add((Object)FSize.getInstance(f32, f28));
                            f31 = Math.max((float)f31, (float)f32);
                        }
                    }
                    if (string != null) {
                        n12 = -1;
                    }
                    f9 = f33;
                    arrlegendEntry = arrlegendEntry4;
                    f29 = f35;
                    paint = paint2;
                }
                float f39 = f29;
                legend2.mNeededWidth = f31;
                float f40 = f28 * (float)legend2.mCalculatedLineSizes.size();
                int n13 = legend2.mCalculatedLineSizes.size() == 0 ? 0 : -1 + legend2.mCalculatedLineSizes.size();
                legend2.mNeededHeight = f40 + f39 * (float)n13;
            }
            legend2.mNeededHeight += legend2.mYOffset;
            legend2.mNeededWidth += legend2.mXOffset;
        }
        this.calculateOffsets();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void onDraw(Canvas var1_1) {
        block80 : {
            block93 : {
                block87 : {
                    block91 : {
                        block92 : {
                            block88 : {
                                block89 : {
                                    block90 : {
                                        block86 : {
                                            block84 : {
                                                block81 : {
                                                    block85 : {
                                                        block82 : {
                                                            block83 : {
                                                                block79 : {
                                                                    block71 : {
                                                                        super.onDraw(var1_1);
                                                                        if (this.mData == null) {
                                                                            return;
                                                                        }
                                                                        var2_2 = System.currentTimeMillis();
                                                                        if (this.mDrawGridBackground) {
                                                                            var1_1.drawRect(this.mViewPortHandler.mContentRect, this.mGridBackgroundPaint);
                                                                        }
                                                                        if (this.mDrawBorders) {
                                                                            var1_1.drawRect(this.mViewPortHandler.mContentRect, this.mBorderPaint);
                                                                        }
                                                                        if (this.mAutoScaleMinMaxEnabled) {
                                                                            var221_3 = this.getLowestVisibleX();
                                                                            var222_4 = this.getHighestVisibleX();
                                                                            var223_5 = (BarLineScatterCandleBubbleData)this.mData;
                                                                            var224_6 = var223_5.mDataSets.iterator();
                                                                            while (var224_6.hasNext()) {
                                                                                ((IDataSet)var224_6.next()).calcMinMaxY(var221_3, var222_4);
                                                                            }
                                                                            var223_5.calcMinMax();
                                                                            var225_7 = this.mXAxis;
                                                                            var226_8 = (BarLineScatterCandleBubbleData)this.mData;
                                                                            var225_7.calculate(var226_8.mXMin, var226_8.mXMax);
                                                                            var227_9 = this.mAxisLeft;
                                                                            if (var227_9.mEnabled) {
                                                                                var231_10 = (BarLineScatterCandleBubbleData)this.mData;
                                                                                var232_11 = YAxis.AxisDependency.LEFT;
                                                                                var227_9.calculate(var231_10.getYMin(var232_11), ((BarLineScatterCandleBubbleData)this.mData).getYMax(var232_11));
                                                                            }
                                                                            var228_12 = this.mAxisRight;
                                                                            if (var228_12.mEnabled) {
                                                                                var229_13 = (BarLineScatterCandleBubbleData)this.mData;
                                                                                var230_14 = YAxis.AxisDependency.RIGHT;
                                                                                var228_12.calculate(var229_13.getYMin(var230_14), ((BarLineScatterCandleBubbleData)this.mData).getYMax(var230_14));
                                                                            }
                                                                            this.calculateOffsets();
                                                                        }
                                                                        var4_15 = this.mAxisLeft;
                                                                        if (var4_15.mEnabled) {
                                                                            var217_16 = this.mAxisRendererLeft;
                                                                            var218_17 = var4_15.mAxisMinimum;
                                                                            var219_18 = var4_15.mAxisMaximum;
                                                                            Objects.requireNonNull((Object)var4_15);
                                                                            var217_16.computeAxis(var218_17, var219_18, false);
                                                                        }
                                                                        var5_19 = this.mAxisRight;
                                                                        if (var5_19.mEnabled) {
                                                                            var213_20 = this.mAxisRendererRight;
                                                                            var214_21 = var5_19.mAxisMinimum;
                                                                            var215_22 = var5_19.mAxisMaximum;
                                                                            Objects.requireNonNull((Object)var5_19);
                                                                            var213_20.computeAxis(var214_21, var215_22, false);
                                                                        }
                                                                        var6_23 = this.mXAxis;
                                                                        if (var6_23.mEnabled) {
                                                                            this.mXAxisRenderer.computeAxis(var6_23.mAxisMinimum, var6_23.mAxisMaximum, false);
                                                                        }
                                                                        this.mXAxisRenderer.renderAxisLine(var1_1);
                                                                        this.mAxisRendererLeft.renderAxisLine(var1_1);
                                                                        this.mAxisRendererRight.renderAxisLine(var1_1);
                                                                        if (this.mXAxis.mDrawGridLinesBehindData) {
                                                                            this.mXAxisRenderer.renderGridLines(var1_1);
                                                                        }
                                                                        if (this.mAxisLeft.mDrawGridLinesBehindData) {
                                                                            this.mAxisRendererLeft.renderGridLines(var1_1);
                                                                        }
                                                                        if (this.mAxisRight.mDrawGridLinesBehindData) {
                                                                            this.mAxisRendererRight.renderGridLines(var1_1);
                                                                        }
                                                                        var7_24 = this.mXAxis;
                                                                        if (var7_24.mEnabled) {
                                                                            Objects.requireNonNull((Object)var7_24);
                                                                        }
                                                                        var8_25 = this.mAxisLeft;
                                                                        if (var8_25.mEnabled) {
                                                                            Objects.requireNonNull((Object)var8_25);
                                                                        }
                                                                        var9_26 = this.mAxisRight;
                                                                        if (var9_26.mEnabled) {
                                                                            Objects.requireNonNull((Object)var9_26);
                                                                        }
                                                                        var10_27 = var1_1.save();
                                                                        var1_1.clipRect(this.mViewPortHandler.mContentRect);
                                                                        var12_28 = (BarChartRenderer)this.mRenderer;
                                                                        var13_29 = var12_28.mChart.getBarData();
                                                                        for (var14_30 = 0; var14_30 < var13_29.getDataSetCount(); ++var14_30) {
                                                                            var209_31 = (IBarDataSet)var13_29.getDataSetByIndex(var14_30);
                                                                            if (!var209_31.isVisible()) continue;
                                                                            var12_28.drawDataSet(var1_1, var209_31, var14_30);
                                                                        }
                                                                        if (!this.mXAxis.mDrawGridLinesBehindData) {
                                                                            this.mXAxisRenderer.renderGridLines(var1_1);
                                                                        }
                                                                        if (!this.mAxisLeft.mDrawGridLinesBehindData) {
                                                                            this.mAxisRendererLeft.renderGridLines(var1_1);
                                                                        }
                                                                        if (!this.mAxisRight.mDrawGridLinesBehindData) {
                                                                            this.mAxisRendererRight.renderGridLines(var1_1);
                                                                        }
                                                                        if (!this.valuesToHighlight()) break block71;
                                                                        var186_32 = this.mRenderer;
                                                                        var187_33 = this.mIndicesToHighlight;
                                                                        var188_34 = (BarChartRenderer)var186_32;
                                                                        var189_35 = var188_34.mChart.getBarData();
                                                                        var190_36 = var187_33.length;
                                                                        for (var191_37 = 0; var191_37 < var190_36; ++var191_37) {
                                                                            block74 : {
                                                                                block72 : {
                                                                                    block78 : {
                                                                                        block77 : {
                                                                                            block75 : {
                                                                                                block76 : {
                                                                                                    block73 : {
                                                                                                        var192_38 = var187_33[var191_37];
                                                                                                        var193_39 = (IBarDataSet)var189_35.getDataSetByIndex(var192_38.mDataSetIndex);
                                                                                                        if (var193_39 == null || !var193_39.isHighlightEnabled()) break block72;
                                                                                                        var195_41 = (BarEntry)var193_39.getEntryForXValue(var192_38.mX, var192_38.mY);
                                                                                                        if (var195_41 != null) break block73;
                                                                                                        var194_40 = var187_33;
                                                                                                        ** GOTO lbl-1000
                                                                                                    }
                                                                                                    var196_42 = var193_39.getEntryIndex(var195_41);
                                                                                                    var197_43 = var193_39.getEntryCount();
                                                                                                    var194_40 = var187_33;
                                                                                                    Objects.requireNonNull((Object)var188_34.mAnimator);
                                                                                                    if (var196_42 >= var197_43 * 1.0f) lbl-1000: // 2 sources:
                                                                                                    {
                                                                                                        var199_44 = false;
                                                                                                    } else {
                                                                                                        var199_44 = true;
                                                                                                    }
                                                                                                    if (!var199_44) break block74;
                                                                                                    var200_45 = var188_34.mChart.getTransformer(var193_39.getAxisDependency());
                                                                                                    var188_34.mHighlightPaint.setColor(var193_39.getHighLightColor());
                                                                                                    var188_34.mHighlightPaint.setAlpha(var193_39.getHighLightAlpha());
                                                                                                    var201_46 = var192_38.mStackIndex >= 0 && (var208_53 = var195_41.mYVals != null) != false;
                                                                                                    if (!var201_46) break block75;
                                                                                                    if (!var188_34.mChart.isHighlightFullBarEnabled()) break block76;
                                                                                                    var202_47 = var195_41.mPositiveSum;
                                                                                                    var203_48 = -var195_41.mNegativeSum;
                                                                                                    break block77;
                                                                                                }
                                                                                                var206_51 = var195_41.mRanges[var192_38.mStackIndex];
                                                                                                var207_52 = var206_51.from;
                                                                                                var205_50 = var206_51.to;
                                                                                                var204_49 = var207_52;
                                                                                                break block78;
                                                                                            }
                                                                                            var202_47 = var195_41.y;
                                                                                            var203_48 = 0.0f;
                                                                                        }
                                                                                        var204_49 = var202_47;
                                                                                        var205_50 = var203_48;
                                                                                    }
                                                                                    var188_34.prepareBarHighlight(var195_41.x, var204_49, var205_50, var189_35.mBarWidth / 2.0f, var200_45);
                                                                                    var188_34.setHighlightDrawPos(var192_38, var188_34.mBarRect);
                                                                                    var1_1.drawRect(var188_34.mBarRect, var188_34.mHighlightPaint);
                                                                                    break block74;
                                                                                }
                                                                                var194_40 = var187_33;
                                                                            }
                                                                            var187_33 = var194_40;
                                                                        }
                                                                    }
                                                                    var1_1.restoreToCount(var10_27);
                                                                    Objects.requireNonNull((Object)((BarChartRenderer)this.mRenderer));
                                                                    var16_54 = this.mXAxis;
                                                                    if (var16_54.mEnabled) {
                                                                        Objects.requireNonNull((Object)var16_54);
                                                                        this.mXAxisRenderer.renderLimitLines(var1_1);
                                                                    }
                                                                    var17_55 = this.mAxisLeft;
                                                                    if (var17_55.mEnabled) {
                                                                        Objects.requireNonNull((Object)var17_55);
                                                                        this.mAxisRendererLeft.renderLimitLines(var1_1);
                                                                    }
                                                                    var18_56 = this.mAxisRight;
                                                                    if (var18_56.mEnabled) {
                                                                        Objects.requireNonNull((Object)var18_56);
                                                                        this.mAxisRendererRight.renderLimitLines(var1_1);
                                                                    }
                                                                    this.mXAxisRenderer.renderAxisLabels(var1_1);
                                                                    this.mAxisRendererLeft.renderAxisLabels(var1_1);
                                                                    this.mAxisRendererRight.renderAxisLabels(var1_1);
                                                                    if (this.mClipValuesToContent) {
                                                                        var181_57 = var1_1.save();
                                                                        var1_1.clipRect(this.mViewPortHandler.mContentRect);
                                                                        this.mRenderer.drawValues(var1_1);
                                                                        var1_1.restoreToCount(var181_57);
                                                                    } else {
                                                                        this.mRenderer.drawValues(var1_1);
                                                                    }
                                                                    var19_58 = this.mLegendRenderer;
                                                                    var20_59 = var19_58.mLegend;
                                                                    if (var20_59.mEnabled) break block79;
                                                                    var50_60 = var2_2;
                                                                    break block80;
                                                                }
                                                                var19_58.mLegendLabelPaint.setTextSize(var20_59.mTextSize);
                                                                var19_58.mLegendLabelPaint.setColor(var19_58.mLegend.mTextColor);
                                                                var21_61 = var19_58.mLegendLabelPaint;
                                                                var22_62 = var19_58.legendFontMetrics;
                                                                var21_61.getFontMetrics(var22_62);
                                                                var25_63 = var22_62.descent - var22_62.ascent;
                                                                var26_64 = var19_58.mLegendLabelPaint;
                                                                var27_65 = var19_58.legendFontMetrics;
                                                                var26_64.getFontMetrics(var27_65);
                                                                var29_66 = var27_65.ascent - var27_65.top + var27_65.bottom;
                                                                Objects.requireNonNull((Object)var19_58.mLegend);
                                                                var31_67 = var29_66 + Utils.convertDpToPixel(0.0f);
                                                                var32_68 = var25_63 - (float)Utils.calcTextHeight(var19_58.mLegendLabelPaint, "ABC") / 2.0f;
                                                                var33_69 = var19_58.mLegend;
                                                                var34_70 = var33_69.mEntries;
                                                                var35_71 = Utils.convertDpToPixel(var33_69.mFormToTextSpace);
                                                                var36_72 = Utils.convertDpToPixel(var19_58.mLegend.mXEntrySpace);
                                                                var37_73 = var19_58.mLegend;
                                                                var38_74 = var37_73.mOrientation;
                                                                var39_75 = var37_73.mHorizontalAlignment;
                                                                var40_76 = var37_73.mVerticalAlignment;
                                                                var41_77 = var37_73.mDirection;
                                                                var42_78 = Utils.convertDpToPixel(var37_73.mFormSize);
                                                                var43_79 = Utils.convertDpToPixel(var19_58.mLegend.mStackSpace);
                                                                var44_80 = var19_58.mLegend;
                                                                var45_81 = var36_72;
                                                                var46_82 = var44_80.mYOffset;
                                                                var47_83 = var44_80.mXOffset;
                                                                var48_84 = var35_71;
                                                                var49_85 = var39_75.ordinal();
                                                                var50_60 = var2_2;
                                                                if (var49_85 == 0) break block81;
                                                                if (var49_85 == 1) break block82;
                                                                if (var49_85 == 2) break block83;
                                                                var52_86 = var31_67;
                                                                var53_87 = var32_68;
                                                                var54_88 = 0.0f;
                                                                break block84;
                                                            }
                                                            var180_89 = var38_74 == Legend.LegendOrientation.VERTICAL ? var19_58.mViewPortHandler.mChartWidth : var19_58.mViewPortHandler.mContentRect.right;
                                                            var169_90 = var180_89 - var47_83;
                                                            if (var41_77 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                                                                var169_90 -= var19_58.mLegend.mNeededWidth;
                                                            }
                                                            var52_86 = var31_67;
                                                            var53_87 = var32_68;
                                                            ** GOTO lbl247
                                                        }
                                                        var170_91 = Legend.LegendOrientation.VERTICAL;
                                                        if (var38_74 == var170_91) {
                                                            var172_92 = var19_58.mViewPortHandler.mChartWidth / 2.0f;
                                                        } else {
                                                            var171_93 = var19_58.mViewPortHandler;
                                                            var172_92 = var171_93.mContentRect.left + var171_93.contentWidth() / 2.0f;
                                                        }
                                                        var173_94 = Legend.LegendDirection.LEFT_TO_RIGHT;
                                                        var174_95 = var41_77 == var173_94 ? var47_83 : -var47_83;
                                                        var54_88 = var174_95 + var172_92;
                                                        if (var38_74 != var170_91) break block85;
                                                        var53_87 = var32_68;
                                                        var175_96 = var54_88;
                                                        if (var41_77 == var173_94) {
                                                            var179_97 = -var19_58.mLegend.mNeededWidth;
                                                            var52_86 = var31_67;
                                                            var177_98 = (double)var179_97 / 2.0 + (double)var47_83;
                                                        } else {
                                                            var52_86 = var31_67;
                                                            var177_98 = (double)var19_58.mLegend.mNeededWidth / 2.0 - (double)var47_83;
                                                        }
                                                        var169_90 = (float)(var175_96 + var177_98);
                                                        ** GOTO lbl247
                                                    }
                                                    var52_86 = var31_67;
                                                    var53_87 = var32_68;
                                                    break block84;
                                                }
                                                var52_86 = var31_67;
                                                var53_87 = var32_68;
                                                if (var38_74 != Legend.LegendOrientation.VERTICAL) {
                                                    var47_83 += var19_58.mViewPortHandler.mContentRect.left;
                                                }
                                                if (var41_77 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                                                    var169_90 = var47_83 + var19_58.mLegend.mNeededWidth;
lbl247: // 3 sources:
                                                    var54_88 = var169_90;
                                                } else {
                                                    var54_88 = var47_83;
                                                }
                                            }
                                            var55_99 = var38_74.ordinal();
                                            if (var55_99 == 0) break block86;
                                            if (var55_99 != 1) break block80;
                                            var135_100 = var40_76.ordinal();
                                            if (var135_100 != 0) {
                                                if (var135_100 != 1) {
                                                    if (var135_100 != 2) {
                                                        var137_101 = 0.0f;
                                                    } else {
                                                        var168_102 = var39_75 == Legend.LegendHorizontalAlignment.CENTER ? var19_58.mViewPortHandler.mChartHeight : var19_58.mViewPortHandler.mContentRect.bottom;
                                                        var137_101 = var168_102 - (var46_82 + var19_58.mLegend.mNeededHeight);
                                                    }
                                                } else {
                                                    var166_103 = var19_58.mViewPortHandler.mChartHeight / 2.0f;
                                                    var167_104 = var19_58.mLegend;
                                                    var137_101 = var166_103 - var167_104.mNeededHeight / 2.0f + var167_104.mYOffset;
                                                }
                                            } else {
                                                var136_105 = var39_75 == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : var19_58.mViewPortHandler.mContentRect.top;
                                                var137_101 = var136_105 + var46_82;
                                            }
                                            var138_106 = var137_101;
                                            var139_107 = 0;
                                            var140_108 = false;
                                            var141_109 = 0.0f;
                                            break block87;
                                        }
                                        var56_134 = var34_70;
                                        var57_135 = var48_84;
                                        var58_136 = var43_79;
                                        var59_137 = var54_88;
                                        var60_138 = var58_136;
                                        var61_139 = var19_58.mLegend;
                                        var62_140 = var61_139.mCalculatedLineSizes;
                                        var63_141 = var61_139.mCalculatedLabelSizes;
                                        var64_142 = var61_139.mCalculatedLabelBreakPoints;
                                        var65_143 = var40_76.ordinal();
                                        if (var65_143 == 0) break block88;
                                        if (var65_143 == 1) break block89;
                                        if (var65_143 == 2) break block90;
                                        var67_144 = var56_134;
                                        var66_145 = 0.0f;
                                        break block91;
                                    }
                                    var66_145 = var19_58.mViewPortHandler.mChartHeight - var46_82 - var19_58.mLegend.mNeededHeight;
                                    break block92;
                                }
                                var66_145 = var46_82 + (var19_58.mViewPortHandler.mChartHeight - var19_58.mLegend.mNeededHeight) / 2.0f;
                                break block92;
                            }
                            var66_145 = var46_82;
                        }
                        var67_144 = var56_134;
                    }
                    var68_146 = var67_144.length;
                    var69_147 = var59_137;
                    var70_148 = 0;
                    var71_149 = 0;
                    break block93;
                }
                while (var139_107 < var34_70.length) {
                    var142_110 = var34_70[var139_107];
                    var143_111 = var142_110.form != Legend.LegendForm.NONE;
                    var144_112 = Float.isNaN((float)var142_110.formSize) != false ? var42_78 : Utils.convertDpToPixel(var142_110.formSize);
                    if (var143_111) {
                        var160_128 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        var161_129 = var41_77 == var160_128 ? var54_88 + var141_109 : var54_88 - (var144_112 - var141_109);
                        var152_120 = var161_129;
                        var162_130 = var138_106 + var53_87;
                        var163_131 = var19_58.mLegend;
                        var164_132 = var43_79;
                        var150_118 = var54_88;
                        var151_119 = var164_132;
                        var165_133 = var152_120;
                        var146_114 = var139_107;
                        var147_115 = var48_84;
                        var148_116 = var141_109;
                        var145_113 = var34_70;
                        var19_58.drawForm(var1_1, var165_133, var162_130, var142_110, var163_131);
                        if (var41_77 == var160_128) {
                            var152_120 += var144_112;
                        }
                    } else {
                        var145_113 = var34_70;
                        var146_114 = var139_107;
                        var147_115 = var48_84;
                        var148_116 = var141_109;
                        var149_117 = var43_79;
                        var150_118 = var54_88;
                        var151_119 = var149_117;
                        var152_120 = var150_118;
                    }
                    if ((var153_121 = var142_110.label) != null) {
                        if (var143_111 && !var140_108) {
                            var159_127 = var41_77 == Legend.LegendDirection.LEFT_TO_RIGHT ? var147_115 : -var147_115;
                            var152_120 += var159_127;
                        } else if (var140_108) {
                            var152_120 = var150_118;
                        }
                        if (var41_77 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            var152_120 -= (float)Utils.calcTextWidth(var19_58.mLegendLabelPaint, var153_121);
                        }
                        var156_124 = var152_120;
                        if (!var140_108) {
                            var158_126 = var138_106 + var25_63;
                            var1_1.drawText(var142_110.label, var156_124, var158_126, var19_58.mLegendLabelPaint);
                        } else {
                            var157_125 = (var138_106 += var25_63 + var52_86) + var25_63;
                            var1_1.drawText(var142_110.label, var156_124, var157_125, var19_58.mLegendLabelPaint);
                        }
                        var138_106 += var25_63 + var52_86;
                        var141_109 = 0.0f;
                    } else {
                        var141_109 = var148_116 + (var144_112 + var151_119);
                        var140_108 = true;
                    }
                    var154_122 = var146_114 + 1;
                    var48_84 = var147_115;
                    var34_70 = var145_113;
                    var139_107 = var154_122;
                    var155_123 = var150_118;
                    var43_79 = var151_119;
                    var54_88 = var155_123;
                }
                break block80;
            }
            while (var71_149 < var68_146) {
                var110_150 = var60_138;
                var111_151 = var67_144[var71_149];
                var112_152 = var69_147;
                var113_153 = var111_151.form;
                var114_154 = var68_146;
                var115_155 = var113_153 != Legend.LegendForm.NONE;
                var116_156 = Float.isNaN((float)var111_151.formSize) != false ? var42_78 : Utils.convertDpToPixel(var111_151.formSize);
                if (var71_149 < var64_142.size() && ((Boolean)var64_142.get(var71_149)).booleanValue()) {
                    var66_145 += var25_63 + var52_86;
                    var117_157 = var59_137;
                } else {
                    var117_157 = var112_152;
                }
                if (var117_157 == var59_137 && var39_75 == Legend.LegendHorizontalAlignment.CENTER && var70_148 < var62_140.size()) {
                    var134_174 = var41_77 == Legend.LegendDirection.RIGHT_TO_LEFT ? ((FSize)var62_140.get((int)var70_148)).width : -((FSize)var62_140.get((int)var70_148)).width;
                    var117_157 += var134_174 / 2.0f;
                }
                var118_158 = ++var70_148;
                var119_159 = var111_151.label == null;
                if (var115_155) {
                    if (var41_77 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        var117_157 -= var116_156;
                    }
                    var131_171 = var117_157;
                    var132_172 = var66_145 + var53_87;
                    var133_173 = var19_58.mLegend;
                    var120_160 = var39_75;
                    var122_162 = var62_140;
                    var123_163 = var45_81;
                    var124_164 = var64_142;
                    var125_165 = var71_149;
                    var121_161 = var67_144;
                    var19_58.drawForm(var1_1, var131_171, var132_172, var111_151, var133_173);
                    var117_157 = var41_77 == Legend.LegendDirection.LEFT_TO_RIGHT ? var131_171 + var116_156 : var131_171;
                } else {
                    var120_160 = var39_75;
                    var121_161 = var67_144;
                    var122_162 = var62_140;
                    var123_163 = var45_81;
                    var124_164 = var64_142;
                    var125_165 = var71_149;
                }
                if (!var119_159) {
                    if (var115_155) {
                        var130_170 = var41_77 == Legend.LegendDirection.RIGHT_TO_LEFT ? -var57_135 : var57_135;
                        var117_157 += var130_170;
                    }
                    if (var41_77 == (var127_167 = Legend.LegendDirection.RIGHT_TO_LEFT)) {
                        var117_157 -= ((FSize)var63_141.get((int)var125_165)).width;
                    }
                    var128_168 = var66_145 + var25_63;
                    var1_1.drawText(var111_151.label, var117_157, var128_168, var19_58.mLegendLabelPaint);
                    if (var41_77 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        var117_157 += ((FSize)var63_141.get((int)var125_165)).width;
                    }
                    var129_169 = var41_77 == var127_167 ? -var123_163 : var123_163;
                    var69_147 = var117_157 + var129_169;
                    var60_138 = var110_150;
                } else {
                    if (var41_77 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        var60_138 = var110_150;
                        var126_166 = -var60_138;
                    } else {
                        var126_166 = var60_138 = var110_150;
                    }
                    var69_147 = var117_157 + var126_166;
                }
                var71_149 = var125_165 + 1;
                var64_142 = var124_164;
                var70_148 = var118_158;
                var68_146 = var114_154;
                var39_75 = var120_160;
                var67_144 = var121_161;
                var45_81 = var123_163;
                var62_140 = var122_162;
            }
        }
        var72_175 = this.mDescription;
        if (var72_175 != null && var72_175.mEnabled) {
            var103_176 = this.mDescPaint;
            Objects.requireNonNull((Object)var72_175);
            var103_176.setTypeface(null);
            this.mDescPaint.setTextSize(this.mDescription.mTextSize);
            this.mDescPaint.setColor(this.mDescription.mTextColor);
            this.mDescPaint.setTextAlign(this.mDescription.mTextAlign);
            var106_177 = (float)this.getWidth() - this.mViewPortHandler.offsetRight() - this.mDescription.mXOffset;
            var107_178 = (float)this.getHeight() - this.mViewPortHandler.offsetBottom();
            var108_179 = this.mDescription;
            var109_180 = var107_178 - var108_179.mYOffset;
            var1_1.drawText(var108_179.text, var106_177, var109_180, this.mDescPaint);
        }
        if (this.mMarker != null && this.mDrawMarkers && this.valuesToHighlight()) {
            for (var89_181 = 0; var89_181 < (var90_182 = this.mIndicesToHighlight).length; ++var89_181) {
                var91_183 = var90_182[var89_181];
                var92_184 = this.mData.getDataSetByIndex(var91_183.mDataSetIndex);
                var93_185 = this.mData.getEntryForHighlight(this.mIndicesToHighlight[var89_181]);
                var94_186 = var92_184.getEntryIndex((Entry)var93_185);
                if (var93_185 == null) continue;
                var95_187 = var94_186;
                var96_188 = var92_184.getEntryCount();
                Objects.requireNonNull((Object)this.mAnimator);
                if (var95_187 > var96_188 * 1.0f) continue;
                var98_189 = this.getMarkerPosition(var91_183);
                var99_190 = this.mViewPortHandler;
                var100_191 = var98_189[0];
                var101_192 = var98_189[1];
                var102_193 = var99_190.isInBoundsX(var100_191) != false && var99_190.isInBoundsY(var101_192) != false;
                if (!var102_193) continue;
                this.mMarker.refreshContent(var93_185, var91_183);
                this.mMarker.draw(var1_1, var98_189[0], var98_189[1]);
            }
        }
        if (this.mLogEnabled == false) return;
        var73_194 = System.currentTimeMillis() - var50_60;
        this.totalTime = var75_195 = var73_194 + this.totalTime;
        this.drawCycles = var77_196 = 1L + this.drawCycles;
        var79_197 = var75_195 / var77_196;
        var81_198 = new StringBuilder();
        var81_198.append("Drawtime: ");
        var81_198.append(var73_194);
        var81_198.append(" ms, average: ");
        var81_198.append(var79_197);
        var81_198.append(" ms, cycles: ");
        var81_198.append(this.drawCycles);
        Log.i((String)"MPAndroidChart", (String)var81_198.toString());
    }

    @Override
    public void onSizeChanged(int n2, int n3, int n4, int n5) {
        float[] arrf = this.mOnSizeChangedBuffer;
        arrf[1] = 0.0f;
        arrf[0] = 0.0f;
        if (this.mKeepPositionOnRotation) {
            RectF rectF = this.mViewPortHandler.mContentRect;
            arrf[0] = rectF.left;
            arrf[1] = rectF.top;
            this.getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(this.mOnSizeChangedBuffer);
        }
        super.onSizeChanged(n2, n3, n4, n5);
        if (this.mKeepPositionOnRotation) {
            this.getTransformer(YAxis.AxisDependency.LEFT).pointValuesToPixel(this.mOnSizeChangedBuffer);
            ViewPortHandler viewPortHandler = this.mViewPortHandler;
            float[] arrf2 = this.mOnSizeChangedBuffer;
            Matrix matrix = viewPortHandler.mCenterViewPortMatrixBuffer;
            matrix.reset();
            matrix.set(viewPortHandler.mMatrixTouch);
            float f2 = arrf2[0];
            RectF rectF = viewPortHandler.mContentRect;
            float f3 = f2 - rectF.left;
            float f4 = arrf2[1] - rectF.top;
            matrix.postTranslate(-f3, -f4);
            viewPortHandler.refresh(matrix, (View)this, true);
            return;
        }
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        viewPortHandler.refresh(viewPortHandler.mMatrixTouch, (View)this, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewGroup.super.onTouchEvent(motionEvent);
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        if (chartTouchListener != null) {
            if (this.mData == null) {
                return false;
            }
            if (!this.mTouchEnabled) {
                return false;
            }
            return ((BarLineChartTouchListener)chartTouchListener).onTouch((View)this, motionEvent);
        }
        return false;
    }

    public void prepareValuePxMatrix() {
        if (this.mLogEnabled) {
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Preparing Value-Px Matrix, xmin: ");
            stringBuilder.append(this.mXAxis.mAxisMinimum);
            stringBuilder.append(", xmax: ");
            stringBuilder.append(this.mXAxis.mAxisMaximum);
            stringBuilder.append(", xdelta: ");
            stringBuilder.append(this.mXAxis.mAxisRange);
            Log.i((String)"MPAndroidChart", (String)stringBuilder.toString());
        }
        Transformer transformer = this.mRightAxisTransformer;
        XAxis xAxis = this.mXAxis;
        float f2 = xAxis.mAxisMinimum;
        float f3 = xAxis.mAxisRange;
        YAxis yAxis = this.mAxisRight;
        transformer.prepareMatrixValuePx(f2, f3, yAxis.mAxisRange, yAxis.mAxisMinimum);
        Transformer transformer2 = this.mLeftAxisTransformer;
        XAxis xAxis2 = this.mXAxis;
        float f4 = xAxis2.mAxisMinimum;
        float f5 = xAxis2.mAxisRange;
        YAxis yAxis2 = this.mAxisLeft;
        transformer2.prepareMatrixValuePx(f4, f5, yAxis2.mAxisRange, yAxis2.mAxisMinimum);
    }

    public void setAutoScaleMinMaxEnabled(boolean bl) {
        this.mAutoScaleMinMaxEnabled = bl;
    }

    public void setBorderColor(int n2) {
        this.mBorderPaint.setColor(n2);
    }

    public void setBorderWidth(float f2) {
        this.mBorderPaint.setStrokeWidth(Utils.convertDpToPixel(f2));
    }

    public void setClipValuesToContent(boolean bl) {
        this.mClipValuesToContent = bl;
    }

    public void setDoubleTapToZoomEnabled(boolean bl) {
        this.mDoubleTapToZoomEnabled = bl;
    }

    public void setDragEnabled(boolean bl) {
        this.mDragXEnabled = bl;
        this.mDragYEnabled = bl;
    }

    public void setDragOffsetX(float f2) {
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        Objects.requireNonNull((Object)viewPortHandler);
        viewPortHandler.mTransOffsetX = Utils.convertDpToPixel(f2);
    }

    public void setDragOffsetY(float f2) {
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        Objects.requireNonNull((Object)viewPortHandler);
        viewPortHandler.mTransOffsetY = Utils.convertDpToPixel(f2);
    }

    public void setDragXEnabled(boolean bl) {
        this.mDragXEnabled = bl;
    }

    public void setDragYEnabled(boolean bl) {
        this.mDragYEnabled = bl;
    }

    public void setDrawBorders(boolean bl) {
        this.mDrawBorders = bl;
    }

    public void setDrawGridBackground(boolean bl) {
        this.mDrawGridBackground = bl;
    }

    public void setGridBackgroundColor(int n2) {
        this.mGridBackgroundPaint.setColor(n2);
    }

    public void setHighlightPerDragEnabled(boolean bl) {
        this.mHighlightPerDragEnabled = bl;
    }

    public void setKeepPositionOnRotation(boolean bl) {
        this.mKeepPositionOnRotation = bl;
    }

    public void setMaxVisibleValueCount(int n2) {
        this.mMaxVisibleCount = n2;
    }

    public void setMinOffset(float f2) {
        this.mMinOffset = f2;
    }

    public void setOnDrawListener(OnDrawListener onDrawListener) {
        this.mDrawListener = onDrawListener;
    }

    public void setPinchZoom(boolean bl) {
        this.mPinchZoomEnabled = bl;
    }

    public void setRendererLeftYAxis(YAxisRenderer yAxisRenderer) {
        this.mAxisRendererLeft = yAxisRenderer;
    }

    public void setRendererRightYAxis(YAxisRenderer yAxisRenderer) {
        this.mAxisRendererRight = yAxisRenderer;
    }

    public void setScaleEnabled(boolean bl) {
        this.mScaleXEnabled = bl;
        this.mScaleYEnabled = bl;
    }

    public void setScaleXEnabled(boolean bl) {
        this.mScaleXEnabled = bl;
    }

    public void setScaleYEnabled(boolean bl) {
        this.mScaleYEnabled = bl;
    }

    public void setVisibleXRangeMaximum(float f2) {
        float f3 = this.mXAxis.mAxisRange / f2;
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (f3 < 1.0f) {
            f3 = 1.0f;
        }
        viewPortHandler.mMinScaleX = f3;
        viewPortHandler.limitTransAndScale(viewPortHandler.mMatrixTouch, viewPortHandler.mContentRect);
    }

    public void setVisibleXRangeMinimum(float f2) {
        float f3 = this.mXAxis.mAxisRange / f2;
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (f3 == 0.0f) {
            f3 = Float.MAX_VALUE;
        }
        viewPortHandler.mMaxScaleX = f3;
        viewPortHandler.limitTransAndScale(viewPortHandler.mMatrixTouch, viewPortHandler.mContentRect);
    }

    public void setXAxisRenderer(XAxisRenderer xAxisRenderer) {
        this.mXAxisRenderer = xAxisRenderer;
    }
}

