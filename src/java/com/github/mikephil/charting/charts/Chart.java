/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.github.mikephil.charting.components.XAxis
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Chart<T extends ChartData<? extends IDataSet<? extends Entry>>>
extends ViewGroup
implements ChartInterface {
    public ChartAnimator mAnimator;
    public ChartTouchListener mChartTouchListener;
    public T mData = null;
    public DefaultValueFormatter mDefaultValueFormatter = new DefaultValueFormatter(0);
    public Paint mDescPaint;
    public Description mDescription;
    public boolean mDragDecelerationEnabled = true;
    public float mDragDecelerationFrictionCoef = 0.9f;
    public boolean mDrawMarkers = true;
    public float mExtraBottomOffset = 0.0f;
    public float mExtraLeftOffset = 0.0f;
    public float mExtraRightOffset = 0.0f;
    public float mExtraTopOffset = 0.0f;
    public OnChartGestureListener mGestureListener;
    public boolean mHighLightPerTapEnabled = true;
    public IHighlighter mHighlighter;
    public Highlight[] mIndicesToHighlight;
    public Paint mInfoPaint;
    public ArrayList<Runnable> mJobs = new ArrayList();
    public Legend mLegend;
    public LegendRenderer mLegendRenderer;
    public boolean mLogEnabled = false;
    public IMarker mMarker;
    public float mMaxHighlightDistance = 0.0f;
    public String mNoDataText = "No chart data available.";
    public boolean mOffsetsCalculated = false;
    public DataRenderer mRenderer;
    public OnChartValueSelectedListener mSelectionListener;
    public boolean mTouchEnabled = true;
    public boolean mUnbind = false;
    public ViewPortHandler mViewPortHandler = new ViewPortHandler();
    public XAxis mXAxis;

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init();
    }

    public abstract void calculateOffsets();

    public void disableScroll() {
        ViewParent viewParent = this.getParent();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public ChartAnimator getAnimator() {
        return this.mAnimator;
    }

    public MPPointF getCenter() {
        return MPPointF.getInstance((float)this.getWidth() / 2.0f, (float)this.getHeight() / 2.0f);
    }

    public MPPointF getCenterOfView() {
        return this.getCenter();
    }

    public MPPointF getCenterOffsets() {
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        return MPPointF.getInstance(viewPortHandler.mContentRect.centerX(), viewPortHandler.mContentRect.centerY());
    }

    public Bitmap getChartBitmap() {
        Bitmap bitmap = Bitmap.createBitmap((int)this.getWidth(), (int)this.getHeight(), (Bitmap.Config)Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        Drawable drawable = this.getBackground();
        if (drawable != null) {
            drawable.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        this.draw(canvas);
        return bitmap;
    }

    public RectF getContentRect() {
        return this.mViewPortHandler.mContentRect;
    }

    public T getData() {
        return this.mData;
    }

    public ValueFormatter getDefaultValueFormatter() {
        return this.mDefaultValueFormatter;
    }

    public Description getDescription() {
        return this.mDescription;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.mDragDecelerationFrictionCoef;
    }

    public float getExtraBottomOffset() {
        return this.mExtraBottomOffset;
    }

    public float getExtraLeftOffset() {
        return this.mExtraLeftOffset;
    }

    public float getExtraRightOffset() {
        return this.mExtraRightOffset;
    }

    public float getExtraTopOffset() {
        return this.mExtraTopOffset;
    }

    public Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mData == null) {
            Log.e((String)"MPAndroidChart", (String)"Can't select by touch. No data set.");
            return null;
        }
        return this.getHighlighter().getHighlight(f, f2);
    }

    public Highlight[] getHighlighted() {
        return this.mIndicesToHighlight;
    }

    public IHighlighter getHighlighter() {
        return this.mHighlighter;
    }

    public ArrayList<Runnable> getJobs() {
        return this.mJobs;
    }

    public Legend getLegend() {
        return this.mLegend;
    }

    public LegendRenderer getLegendRenderer() {
        return this.mLegendRenderer;
    }

    public IMarker getMarker() {
        return this.mMarker;
    }

    public float[] getMarkerPosition(Highlight highlight) {
        float[] arrf = new float[]{highlight.mDrawX, highlight.mDrawY};
        return arrf;
    }

    @Deprecated
    public IMarker getMarkerView() {
        return this.getMarker();
    }

    @Override
    public float getMaxHighlightDistance() {
        return this.mMaxHighlightDistance;
    }

    @Override
    public abstract /* synthetic */ int getMaxVisibleCount();

    public OnChartGestureListener getOnChartGestureListener() {
        return this.mGestureListener;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.mChartTouchListener;
    }

    public DataRenderer getRenderer() {
        return this.mRenderer;
    }

    public ViewPortHandler getViewPortHandler() {
        return this.mViewPortHandler;
    }

    public XAxis getXAxis() {
        return this.mXAxis;
    }

    public float getXChartMax() {
        return this.mXAxis.mAxisMaximum;
    }

    public float getXChartMin() {
        return this.mXAxis.mAxisMinimum;
    }

    public float getXRange() {
        return this.mXAxis.mAxisRange;
    }

    public abstract /* synthetic */ float getYChartMax();

    public abstract /* synthetic */ float getYChartMin();

    public float getYMax() {
        return ((ChartData)this.mData).mYMax;
    }

    public float getYMin() {
        return ((ChartData)this.mData).mYMin;
    }

    public void highlightValue(Highlight highlight, boolean bl) {
        Entry entry;
        if (highlight == null) {
            this.mIndicesToHighlight = null;
            entry = null;
        } else {
            Entry entry2;
            if (this.mLogEnabled) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Highlighted: ");
                stringBuilder.append(highlight.toString());
                Log.i((String)"MPAndroidChart", (String)stringBuilder.toString());
            }
            if ((entry2 = ((ChartData)this.mData).getEntryForHighlight(highlight)) == null) {
                this.mIndicesToHighlight = null;
                highlight = null;
            } else {
                this.mIndicesToHighlight = new Highlight[]{highlight};
            }
            entry = entry2;
        }
        this.setLastHighlighted(this.mIndicesToHighlight);
        if (bl && this.mSelectionListener != null) {
            if (!this.valuesToHighlight()) {
                this.mSelectionListener.onNothingSelected();
            } else {
                this.mSelectionListener.onValueSelected(entry, highlight);
            }
        }
        this.invalidate();
    }

    public void init() {
        Paint paint;
        Legend legend;
        this.setWillNotDraw(false);
        this.mAnimator = new ChartAnimator(new ValueAnimator.AnimatorUpdateListener(this){
            public final /* synthetic */ Chart this$0;
            {
                this.this$0 = chart;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.this$0.postInvalidate();
            }
        });
        Context context = this.getContext();
        if (context == null) {
            Utils.mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            Utils.mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
            Log.e((String)"MPChartLib-Utils", (String)"Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)context);
            Utils.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            Utils.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            Utils.mMetrics = context.getResources().getDisplayMetrics();
        }
        this.mMaxHighlightDistance = Utils.convertDpToPixel(500.0f);
        this.mDescription = new Description();
        this.mLegend = legend = new Legend();
        this.mLegendRenderer = new LegendRenderer(this.mViewPortHandler, legend);
        this.mXAxis = new XAxis();
        this.mDescPaint = new Paint(1);
        this.mInfoPaint = paint = new Paint(1);
        paint.setColor(Color.rgb((int)247, (int)189, (int)51));
        this.mInfoPaint.setTextAlign(Paint.Align.CENTER);
        this.mInfoPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        if (this.mLogEnabled) {
            Log.i((String)"", (String)"Chart.init()");
        }
    }

    public abstract void notifyDataSetChanged();

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mUnbind) {
            this.unbindDrawables((View)this);
        }
    }

    public void onDraw(Canvas canvas) {
        if (this.mData == null) {
            if (true ^ TextUtils.isEmpty((CharSequence)this.mNoDataText)) {
                MPPointF mPPointF = this.getCenter();
                canvas.drawText(this.mNoDataText, mPPointF.x, mPPointF.y, this.mInfoPaint);
            }
            return;
        }
        if (!this.mOffsetsCalculated) {
            this.calculateOffsets();
            this.mOffsetsCalculated = true;
        }
    }

    public void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        for (int i = 0; i < this.getChildCount(); ++i) {
            this.getChildAt(i).layout(n, n2, n3, n4);
        }
    }

    public void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        int n3 = (int)Utils.convertDpToPixel(50.0f);
        this.setMeasuredDimension(Math.max((int)this.getSuggestedMinimumWidth(), (int)ViewGroup.resolveSize((int)n3, (int)n)), Math.max((int)this.getSuggestedMinimumHeight(), (int)ViewGroup.resolveSize((int)n3, (int)n2)));
    }

    public void onSizeChanged(int n, int n2, int n3, int n4) {
        if (this.mLogEnabled) {
            Log.i((String)"MPAndroidChart", (String)"OnSizeChanged()");
        }
        if (n > 0 && n2 > 0 && n < 10000 && n2 < 10000) {
            if (this.mLogEnabled) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Setting chart dimens, width: ");
                stringBuilder.append(n);
                stringBuilder.append(", height: ");
                stringBuilder.append(n2);
                Log.i((String)"MPAndroidChart", (String)stringBuilder.toString());
            }
            ViewPortHandler viewPortHandler = this.mViewPortHandler;
            float f = n;
            float f2 = n2;
            RectF rectF = viewPortHandler.mContentRect;
            float f3 = rectF.left;
            float f4 = rectF.top;
            float f5 = viewPortHandler.offsetRight();
            float f6 = viewPortHandler.offsetBottom();
            viewPortHandler.mChartHeight = f2;
            viewPortHandler.mChartWidth = f;
            viewPortHandler.restrainViewPort(f3, f4, f5, f6);
        } else if (this.mLogEnabled) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("*Avoiding* setting chart dimens! width: ");
            stringBuilder.append(n);
            stringBuilder.append(", height: ");
            stringBuilder.append(n2);
            Log.w((String)"MPAndroidChart", (String)stringBuilder.toString());
        }
        this.notifyDataSetChanged();
        Iterator iterator = this.mJobs.iterator();
        while (iterator.hasNext()) {
            this.post((Runnable)iterator.next());
        }
        this.mJobs.clear();
        super.onSizeChanged(n, n2, n3, n4);
    }

    public void setData(T t) {
        this.mData = t;
        this.mOffsetsCalculated = false;
        if (t == null) {
            return;
        }
        float f = ((ChartData)t).mYMin;
        float f2 = ((ChartData)t).mYMax;
        float f3 = ((ChartData)t).getEntryCount() < 2 ? Math.max((float)Math.abs((float)f), (float)Math.abs((float)f2)) : Math.abs((float)(f2 - f));
        float f4 = Utils.roundToNextSignificant(f3);
        int n = Float.isInfinite((float)f4) ? 0 : 2 + (int)Math.ceil((double)(-Math.log10((double)f4)));
        this.mDefaultValueFormatter.setup(n);
        for (IDataSet iDataSet : ((ChartData)this.mData).mDataSets) {
            if (!iDataSet.needsFormatter() && iDataSet.getValueFormatter() != this.mDefaultValueFormatter) continue;
            iDataSet.setValueFormatter(this.mDefaultValueFormatter);
        }
        this.notifyDataSetChanged();
        if (this.mLogEnabled) {
            Log.i((String)"MPAndroidChart", (String)"Data is set.");
        }
    }

    public void setDescription(Description description) {
        this.mDescription = description;
    }

    public void setDragDecelerationEnabled(boolean bl) {
        this.mDragDecelerationEnabled = bl;
    }

    public void setDragDecelerationFrictionCoef(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f >= 1.0f) {
            f = 0.999f;
        }
        this.mDragDecelerationFrictionCoef = f;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean bl) {
        this.setDrawMarkers(bl);
    }

    public void setDrawMarkers(boolean bl) {
        this.mDrawMarkers = bl;
    }

    public void setExtraBottomOffset(float f) {
        this.mExtraBottomOffset = Utils.convertDpToPixel(f);
    }

    public void setExtraLeftOffset(float f) {
        this.mExtraLeftOffset = Utils.convertDpToPixel(f);
    }

    public void setExtraRightOffset(float f) {
        this.mExtraRightOffset = Utils.convertDpToPixel(f);
    }

    public void setExtraTopOffset(float f) {
        this.mExtraTopOffset = Utils.convertDpToPixel(f);
    }

    public void setHardwareAccelerationEnabled(boolean bl) {
        if (bl) {
            this.setLayerType(2, null);
            return;
        }
        this.setLayerType(1, null);
    }

    public void setHighlightPerTapEnabled(boolean bl) {
        this.mHighLightPerTapEnabled = bl;
    }

    public void setHighlighter(ChartHighlighter chartHighlighter) {
        this.mHighlighter = chartHighlighter;
    }

    public void setLastHighlighted(Highlight[] arrhighlight) {
        if (arrhighlight != null && arrhighlight.length > 0 && arrhighlight[0] != null) {
            this.mChartTouchListener.mLastHighlighted = arrhighlight[0];
            return;
        }
        this.mChartTouchListener.mLastHighlighted = null;
    }

    public void setLogEnabled(boolean bl) {
        this.mLogEnabled = bl;
    }

    public void setMarker(IMarker iMarker) {
        this.mMarker = iMarker;
    }

    @Deprecated
    public void setMarkerView(IMarker iMarker) {
        this.setMarker(iMarker);
    }

    public void setMaxHighlightDistance(float f) {
        this.mMaxHighlightDistance = Utils.convertDpToPixel(f);
    }

    public void setNoDataText(String string) {
        this.mNoDataText = string;
    }

    public void setNoDataTextColor(int n) {
        this.mInfoPaint.setColor(n);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.mInfoPaint.setTypeface(typeface);
    }

    public void setOnChartGestureListener(OnChartGestureListener onChartGestureListener) {
        this.mGestureListener = onChartGestureListener;
    }

    public void setOnChartValueSelectedListener(OnChartValueSelectedListener onChartValueSelectedListener) {
        this.mSelectionListener = onChartValueSelectedListener;
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.mChartTouchListener = chartTouchListener;
    }

    public void setRenderer(DataRenderer dataRenderer) {
        if (dataRenderer != null) {
            this.mRenderer = dataRenderer;
        }
    }

    public void setTouchEnabled(boolean bl) {
        this.mTouchEnabled = bl;
    }

    public void setUnbindEnabled(boolean bl) {
        this.mUnbind = bl;
    }

    public final void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup;
            for (int i = 0; i < (viewGroup = (ViewGroup)view).getChildCount(); ++i) {
                this.unbindDrawables(viewGroup.getChildAt(i));
            }
            viewGroup.removeAllViews();
        }
    }

    public boolean valuesToHighlight() {
        Highlight[] arrhighlight = this.mIndicesToHighlight;
        boolean bl = false;
        if (arrhighlight != null) {
            int n = arrhighlight.length;
            bl = false;
            if (n > 0) {
                if (arrhighlight[0] == null) {
                    return false;
                }
                bl = true;
            }
        }
        return bl;
    }
}

