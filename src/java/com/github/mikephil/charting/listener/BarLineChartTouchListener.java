/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.util.Log
 *  android.view.GestureDetector
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.animation.AnimationUtils
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.github.mikephil.charting.charts.BarLineChartBase
 *  com.github.mikephil.charting.components.YAxis
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Objects;

public class BarLineChartTouchListener
extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>> {
    public IDataSet mClosestDataSetToTouch;
    public MPPointF mDecelerationCurrentPoint = MPPointF.getInstance(0.0f, 0.0f);
    public long mDecelerationLastTime = 0L;
    public MPPointF mDecelerationVelocity = MPPointF.getInstance(0.0f, 0.0f);
    public float mDragTriggerDist;
    public Matrix mMatrix = new Matrix();
    public float mMinScalePointerDistance;
    public float mSavedDist = 1.0f;
    public Matrix mSavedMatrix = new Matrix();
    public float mSavedXDist = 1.0f;
    public float mSavedYDist = 1.0f;
    public MPPointF mTouchPointCenter = MPPointF.getInstance(0.0f, 0.0f);
    public MPPointF mTouchStartPoint = MPPointF.getInstance(0.0f, 0.0f);
    public VelocityTracker mVelocityTracker;

    public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> barLineChartBase, Matrix matrix, float f) {
        super(barLineChartBase);
        this.mMatrix = matrix;
        this.mDragTriggerDist = Utils.convertDpToPixel(f);
        this.mMinScalePointerDistance = Utils.convertDpToPixel(3.5f);
    }

    public static float spacing(MotionEvent motionEvent) {
        float f = motionEvent.getX(0) - motionEvent.getX(1);
        float f2 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float)Math.sqrt((double)(f * f + f2 * f2));
    }

    public MPPointF getTrans(float f, float f2) {
        ViewPortHandler viewPortHandler = ((BarLineChartBase)this.mChart).getViewPortHandler();
        float f3 = f - viewPortHandler.mContentRect.left;
        this.inverted();
        return MPPointF.getInstance(f3, -((float)((BarLineChartBase)this.mChart).getMeasuredHeight() - f2 - viewPortHandler.offsetBottom()));
    }

    public final boolean inverted() {
        IDataSet iDataSet;
        if (this.mClosestDataSetToTouch == null) {
            BarLineChartBase barLineChartBase = (BarLineChartBase)this.mChart;
            Objects.requireNonNull((Object)barLineChartBase.mAxisLeft);
            Objects.requireNonNull((Object)barLineChartBase.mAxisRight);
        }
        if ((iDataSet = this.mClosestDataSetToTouch) != null) {
            ((BarLineChartBase)this.mChart).isInverted(iDataSet.getAxisDependency());
        }
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase)this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartDoubleTapped(motionEvent);
        }
        Object t = this.mChart;
        if (((BarLineChartBase)t).mDoubleTapToZoomEnabled && ((BarLineScatterCandleBubbleData)((BarLineChartBase)t).getData()).getEntryCount() > 0) {
            MPPointF mPPointF = this.getTrans(motionEvent.getX(), motionEvent.getY());
            Object t2 = this.mChart;
            BarLineChartBase barLineChartBase = (BarLineChartBase)t2;
            boolean bl = ((BarLineChartBase)t2).mScaleXEnabled;
            float f = 1.4f;
            float f2 = bl ? f : 1.0f;
            if (!((BarLineChartBase)t2).mScaleYEnabled) {
                f = 1.0f;
            }
            float f3 = mPPointF.x;
            float f4 = mPPointF.y;
            ViewPortHandler viewPortHandler = barLineChartBase.mViewPortHandler;
            float f5 = -f4;
            Matrix matrix = barLineChartBase.mZoomMatrixBuffer;
            Objects.requireNonNull((Object)viewPortHandler);
            matrix.reset();
            matrix.set(viewPortHandler.mMatrixTouch);
            matrix.postScale(f2, f, f3, f5);
            barLineChartBase.mViewPortHandler.refresh(barLineChartBase.mZoomMatrixBuffer, (View)barLineChartBase, false);
            barLineChartBase.calculateOffsets();
            barLineChartBase.postInvalidate();
            if (((BarLineChartBase)this.mChart).mLogEnabled) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Double-Tap, Zooming In, x: ");
                stringBuilder.append(mPPointF.x);
                stringBuilder.append(", y: ");
                stringBuilder.append(mPPointF.y);
                Log.i((String)"BarlineChartTouch", (String)stringBuilder.toString());
            }
            MPPointF.pool.recycle(mPPointF);
        }
        return GestureDetector.SimpleOnGestureListener.super.onDoubleTap(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.mLastGesture = ChartTouchListener.ChartGesture.FLING;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase)this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartFling(motionEvent, motionEvent2, f, f2);
        }
        return GestureDetector.SimpleOnGestureListener.super.onFling(motionEvent, motionEvent2, f, f2);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase)this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartLongPressed(motionEvent);
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase)this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartSingleTapped(motionEvent);
        }
        Object t = this.mChart;
        if (!((BarLineChartBase)t).mHighLightPerTapEnabled) {
            return false;
        }
        Highlight highlight = ((BarLineChartBase)t).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
        if (highlight != null && !highlight.equalTo(this.mLastHighlighted)) {
            ((Chart)this.mChart).highlightValue(highlight, true);
            this.mLastHighlighted = highlight;
        } else {
            ((Chart)this.mChart).highlightValue(null, true);
            this.mLastHighlighted = null;
        }
        return GestureDetector.SimpleOnGestureListener.super.onSingleTapUp(motionEvent);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @SuppressLint(value={"ClickableViewAccessibility"})
    public boolean onTouch(View var1_1, MotionEvent var2_2) {
        block63 : {
            block64 : {
                block58 : {
                    block59 : {
                        block73 : {
                            block79 : {
                                block80 : {
                                    block78 : {
                                        block74 : {
                                            block76 : {
                                                block77 : {
                                                    block75 : {
                                                        block69 : {
                                                            block71 : {
                                                                block72 : {
                                                                    block70 : {
                                                                        block66 : {
                                                                            block68 : {
                                                                                block67 : {
                                                                                    block65 : {
                                                                                        block60 : {
                                                                                            block61 : {
                                                                                                block62 : {
                                                                                                    if (this.mVelocityTracker == null) {
                                                                                                        this.mVelocityTracker = VelocityTracker.obtain();
                                                                                                    }
                                                                                                    this.mVelocityTracker.addMovement(var2_2);
                                                                                                    var3_3 = var2_2.getActionMasked();
                                                                                                    var4_4 = 3;
                                                                                                    if (var3_3 == var4_4 && (var90_5 = this.mVelocityTracker) != null) {
                                                                                                        var90_5.recycle();
                                                                                                        this.mVelocityTracker = null;
                                                                                                    }
                                                                                                    if (this.mTouchMode == 0) {
                                                                                                        this.mGestureDetector.onTouchEvent(var2_2);
                                                                                                    }
                                                                                                    var5_6 = (BarLineChartBase)this.mChart;
                                                                                                    var6_7 = var5_6.mDragXEnabled;
                                                                                                    var7_8 = 0;
                                                                                                    var8_9 = var6_7 || var5_6.mDragYEnabled;
                                                                                                    if (!(var8_9 || var5_6.mScaleXEnabled || var5_6.mScaleYEnabled)) {
                                                                                                        return true;
                                                                                                    }
                                                                                                    var9_10 = 255 & var2_2.getAction();
                                                                                                    if (var9_10 == 0) break block58;
                                                                                                    if (var9_10 == 1) break block59;
                                                                                                    if (var9_10 == 2) break block60;
                                                                                                    if (var9_10 == var4_4) break block61;
                                                                                                    if (var9_10 == 5) break block62;
                                                                                                    if (var9_10 != 6) break block63;
                                                                                                    var82_11 = this.mVelocityTracker;
                                                                                                    var82_11.computeCurrentVelocity(1000, (float)Utils.mMaximumFlingVelocity);
                                                                                                    var83_12 = var2_2.getActionIndex();
                                                                                                    var84_13 = var2_2.getPointerId(var83_12);
                                                                                                    var85_14 = var82_11.getXVelocity(var84_13);
                                                                                                    var86_15 = var82_11.getYVelocity(var84_13);
                                                                                                    var87_16 = var2_2.getPointerCount();
                                                                                                    break block64;
                                                                                                }
                                                                                                if (var2_2.getPointerCount() >= 2) {
                                                                                                    ((BarLineChartBase)this.mChart).disableScroll();
                                                                                                    this.saveTouchStart(var2_2);
                                                                                                    this.mSavedXDist = Math.abs((float)(var2_2.getX(0) - var2_2.getX(1)));
                                                                                                    this.mSavedYDist = Math.abs((float)(var2_2.getY(0) - var2_2.getY(1)));
                                                                                                    this.mSavedDist = var76_18 = BarLineChartTouchListener.spacing(var2_2);
                                                                                                    if (var76_18 > 10.0f) {
                                                                                                        var80_19 = (BarLineChartBase)this.mChart;
                                                                                                        if (var80_19.mPinchZoomEnabled) {
                                                                                                            this.mTouchMode = 4;
                                                                                                        } else {
                                                                                                            var81_20 = var80_19.mScaleXEnabled;
                                                                                                            if (var81_20 != var80_19.mScaleYEnabled) {
                                                                                                                if (var81_20) {
                                                                                                                    var4_4 = 2;
                                                                                                                }
                                                                                                                this.mTouchMode = var4_4;
                                                                                                            } else {
                                                                                                                if (this.mSavedXDist > this.mSavedYDist) {
                                                                                                                    var4_4 = 2;
                                                                                                                }
                                                                                                                this.mTouchMode = var4_4;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    var77_21 = this.mTouchPointCenter;
                                                                                                    var78_22 = var2_2.getX(0) + var2_2.getX(1);
                                                                                                    var79_23 = var2_2.getY(0) + var2_2.getY(1);
                                                                                                    var77_21.x = var78_22 / 2.0f;
                                                                                                    var77_21.y = var79_23 / 2.0f;
                                                                                                }
                                                                                                break block63;
                                                                                            }
                                                                                            this.mTouchMode = 0;
                                                                                            var75_24 = this.mChart.getOnChartGestureListener();
                                                                                            if (var75_24 != null) {
                                                                                                var75_24.onChartGestureEnd(var2_2, this.mLastGesture);
                                                                                            }
                                                                                            break block63;
                                                                                        }
                                                                                        var23_25 = this.mTouchMode;
                                                                                        if (var23_25 != 1) break block65;
                                                                                        ((BarLineChartBase)this.mChart).disableScroll();
                                                                                        var72_26 = ((BarLineChartBase)this.mChart).mDragXEnabled != false ? var2_2.getX() - this.mTouchStartPoint.x : 0.0f;
                                                                                        var73_27 = ((BarLineChartBase)this.mChart).mDragYEnabled;
                                                                                        var74_28 = 0.0f;
                                                                                        if (var73_27) {
                                                                                            var74_28 = var2_2.getY() - this.mTouchStartPoint.y;
                                                                                        }
                                                                                        this.performDrag(var2_2, var72_26, var74_28);
                                                                                        break block63;
                                                                                    }
                                                                                    if (var23_25 == 2 || var23_25 == var4_4 || var23_25 == 4) break block66;
                                                                                    if (var23_25 != 0 || !(Math.abs((float)((float)Math.sqrt((double)((var57_33 = (var53_29 = var2_2.getX()) - (var54_30 = this.mTouchStartPoint.x)) * var57_33 + (var58_34 = (var55_31 = var2_2.getY()) - (var56_32 = this.mTouchStartPoint.y)) * var58_34)))) > this.mDragTriggerDist)) break block63;
                                                                                    var59_35 = (BarLineChartBase)this.mChart;
                                                                                    var60_36 = var59_35.mDragXEnabled || var59_35.mDragYEnabled;
                                                                                    if (!var60_36) break block63;
                                                                                    var61_37 = var59_35.mViewPortHandler;
                                                                                    var62_38 = var61_37.isFullyZoomedOutX() != false && var61_37.isFullyZoomedOutY() != false;
                                                                                    if (!var62_38) break block67;
                                                                                    var70_39 = ((BarLineChartBase)this.mChart).mViewPortHandler;
                                                                                    var71_40 = var70_39.mTransOffsetX <= 0.0f && var70_39.mTransOffsetY <= 0.0f;
                                                                                    var63_41 = false;
                                                                                    if (var71_40) break block68;
                                                                                }
                                                                                var63_41 = true;
                                                                            }
                                                                            if (var63_41) {
                                                                                var67_42 = Math.abs((float)(var2_2.getX() - this.mTouchStartPoint.x));
                                                                                var68_43 = Math.abs((float)(var2_2.getY() - this.mTouchStartPoint.y));
                                                                                var69_44 = (BarLineChartBase)this.mChart;
                                                                                if ((var69_44.mDragXEnabled || var68_43 >= var67_42) && (var69_44.mDragYEnabled || var68_43 <= var67_42)) {
                                                                                    this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                                                                                    this.mTouchMode = 1;
                                                                                }
                                                                            } else {
                                                                                var64_45 = (BarLineChartBase)this.mChart;
                                                                                var65_46 = var64_45.mHighlightPerDragEnabled;
                                                                                if (var65_46) {
                                                                                    this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                                                                                    if (var65_46 && (var66_47 = var64_45.getHighlightByTouchPoint(var2_2.getX(), var2_2.getY())) != null && !var66_47.equalTo(this.mLastHighlighted)) {
                                                                                        this.mLastHighlighted = var66_47;
                                                                                        ((BarLineChartBase)this.mChart).highlightValue(var66_47, true);
                                                                                        ** GOTO lbl239
                                                                                    }
                                                                                }
                                                                            }
                                                                            break block63;
                                                                        }
                                                                        ((BarLineChartBase)this.mChart).disableScroll();
                                                                        var24_48 = (BarLineChartBase)this.mChart;
                                                                        if (!var24_48.mScaleXEnabled && !var24_48.mScaleYEnabled || var2_2.getPointerCount() < 2) break block63;
                                                                        var25_49 = ((BarLineChartBase)this.mChart).getOnChartGestureListener();
                                                                        var26_50 = BarLineChartTouchListener.spacing(var2_2);
                                                                        if (!(var26_50 > this.mMinScalePointerDistance)) break block63;
                                                                        var27_51 = this.mTouchPointCenter;
                                                                        var28_52 = this.getTrans(var27_51.x, var27_51.y);
                                                                        var29_53 = ((BarLineChartBase)this.mChart).getViewPortHandler();
                                                                        var30_54 = this.mTouchMode;
                                                                        var31_55 = 1.0f;
                                                                        if (var30_54 != 4) break block69;
                                                                        this.mLastGesture = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                                                                        var44_56 = var26_50 / this.mSavedDist;
                                                                        var45_57 = var44_56 < var31_55;
                                                                        var46_58 = var45_57 != false ? var29_53.mScaleX > var29_53.mMinScaleX : var29_53.mScaleX < var29_53.mMaxScaleX;
                                                                        if (!var45_57) break block70;
                                                                        var52_59 = var29_53.mScaleY FCMPL var29_53.mMinScaleY;
                                                                        var48_60 = false;
                                                                        if (var52_59 <= 0) break block71;
                                                                        break block72;
                                                                    }
                                                                    var47_61 = var29_53.mScaleY FCMPG var29_53.mMaxScaleY;
                                                                    var48_60 = false;
                                                                    if (var47_61 >= 0) break block71;
                                                                }
                                                                var48_60 = true;
                                                            }
                                                            var49_62 = (BarLineChartBase)this.mChart;
                                                            var50_63 = var49_62.mScaleXEnabled != false ? var44_56 : var31_55;
                                                            if (var49_62.mScaleYEnabled) {
                                                                var31_55 = var44_56;
                                                            }
                                                            if (var48_60 || var46_58) {
                                                                this.mMatrix.set(this.mSavedMatrix);
                                                                this.mMatrix.postScale(var50_63, var31_55, var28_52.x, var28_52.y);
                                                                if (var25_49 != null) {
                                                                    var25_49.onChartScale(var2_2, var50_63, var31_55);
                                                                }
                                                            }
                                                            break block73;
                                                        }
                                                        if (var30_54 != 2 || !((BarLineChartBase)this.mChart).mScaleXEnabled) break block74;
                                                        this.mLastGesture = ChartTouchListener.ChartGesture.X_ZOOM;
                                                        var38_64 = Math.abs((float)(var2_2.getX(0) - var2_2.getX(1))) / this.mSavedXDist;
                                                        var39_65 = var38_64 < var31_55;
                                                        if (!var39_65) break block75;
                                                        var43_66 = var29_53.mScaleX FCMPL var29_53.mMinScaleX;
                                                        var41_67 = false;
                                                        if (var43_66 <= 0) break block76;
                                                        break block77;
                                                    }
                                                    var40_68 = var29_53.mScaleX FCMPG var29_53.mMaxScaleX;
                                                    var41_67 = false;
                                                    if (var40_68 >= 0) break block76;
                                                }
                                                var41_67 = true;
                                            }
                                            if (var41_67) {
                                                this.mMatrix.set(this.mSavedMatrix);
                                                this.mMatrix.postScale(var38_64, var31_55, var28_52.x, var28_52.y);
                                                if (var25_49 != null) {
                                                    var25_49.onChartScale(var2_2, var38_64, var31_55);
                                                }
                                            }
                                            break block73;
                                        }
                                        if (var30_54 != var4_4 || !((BarLineChartBase)this.mChart).mScaleYEnabled) break block73;
                                        this.mLastGesture = ChartTouchListener.ChartGesture.Y_ZOOM;
                                        var32_69 = Math.abs((float)(var2_2.getY(0) - var2_2.getY(1))) / this.mSavedYDist;
                                        var33_70 = var32_69 < var31_55;
                                        if (!var33_70) break block78;
                                        var37_71 = var29_53.mScaleY FCMPL var29_53.mMinScaleY;
                                        var35_72 = false;
                                        if (var37_71 <= 0) break block79;
                                        break block80;
                                    }
                                    var34_73 = var29_53.mScaleY FCMPG var29_53.mMaxScaleY;
                                    var35_72 = false;
                                    if (var34_73 >= 0) break block79;
                                }
                                var35_72 = true;
                            }
                            if (var35_72) {
                                this.mMatrix.set(this.mSavedMatrix);
                                this.mMatrix.postScale(var31_55, var32_69, var28_52.x, var28_52.y);
                                if (var25_49 != null) {
                                    var25_49.onChartScale(var2_2, var31_55, var32_69);
                                }
                            }
                        }
                        MPPointF.pool.recycle(var28_52);
                        break block63;
                    }
                    var14_74 = this.mVelocityTracker;
                    var15_75 = var2_2.getPointerId(0);
                    var14_74.computeCurrentVelocity(1000, (float)Utils.mMaximumFlingVelocity);
                    var16_76 = var14_74.getYVelocity(var15_75);
                    var17_77 = var14_74.getXVelocity(var15_75);
                    if ((Math.abs((float)var17_77) > (float)Utils.mMinimumFlingVelocity || Math.abs((float)var16_76) > (float)Utils.mMinimumFlingVelocity) && this.mTouchMode == 1 && ((BarLineChartBase)this.mChart).mDragDecelerationEnabled) {
                        this.stopDeceleration();
                        this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
                        this.mDecelerationCurrentPoint.x = var2_2.getX();
                        this.mDecelerationCurrentPoint.y = var2_2.getY();
                        var22_78 = this.mDecelerationVelocity;
                        var22_78.x = var17_77;
                        var22_78.y = var16_76;
                        this.mChart.postInvalidateOnAnimation();
                    }
                    if ((var18_79 = this.mTouchMode) == 2 || var18_79 == var4_4 || var18_79 == 4 || var18_79 == 5) {
                        ((BarLineChartBase)this.mChart).calculateOffsets();
                        ((BarLineChartBase)this.mChart).postInvalidate();
                    }
                    this.mTouchMode = 0;
                    var19_80 = ((BarLineChartBase)this.mChart).getParent();
                    if (var19_80 != null) {
                        var19_80.requestDisallowInterceptTouchEvent(false);
                    }
                    if ((var20_81 = this.mVelocityTracker) != null) {
                        var20_81.recycle();
                        this.mVelocityTracker = null;
                    }
                    if ((var21_82 = this.mChart.getOnChartGestureListener()) != null) {
                        var21_82.onChartGestureEnd(var2_2, this.mLastGesture);
                    }
                    break block63;
                }
                var10_83 = this.mChart.getOnChartGestureListener();
                if (var10_83 != null) {
                    var10_83.onChartGestureStart(var2_2, this.mLastGesture);
                }
                this.stopDeceleration();
                this.saveTouchStart(var2_2);
                break block63;
            }
            while (var7_8 < var87_16) {
                if (var7_8 != var83_12 && var85_14 * var82_11.getXVelocity(var88_17 = var2_2.getPointerId(var7_8)) + var86_15 * var82_11.getYVelocity(var88_17) < 0.0f) {
                    var82_11.clear();
                    break;
                }
                ++var7_8;
            }
            this.mTouchMode = 5;
        }
        var11_84 = ((BarLineChartBase)this.mChart).getViewPortHandler();
        var12_85 = this.mMatrix;
        var11_84.refresh(var12_85, (View)this.mChart, true);
        this.mMatrix = var12_85;
        return true;
    }

    public final void performDrag(MotionEvent motionEvent, float f, float f2) {
        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
        this.mMatrix.set(this.mSavedMatrix);
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase)this.mChart).getOnChartGestureListener();
        this.inverted();
        this.mMatrix.postTranslate(f, f2);
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartTranslate(motionEvent, f, f2);
        }
    }

    public final void saveTouchStart(MotionEvent motionEvent) {
        this.mSavedMatrix.set(this.mMatrix);
        this.mTouchStartPoint.x = motionEvent.getX();
        this.mTouchStartPoint.y = motionEvent.getY();
        BarLineChartBase barLineChartBase = (BarLineChartBase)this.mChart;
        Highlight highlight = barLineChartBase.getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
        IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSet = highlight != null ? (IBarLineScatterCandleBubbleDataSet)((BarLineScatterCandleBubbleData)barLineChartBase.mData).getDataSetByIndex(highlight.mDataSetIndex) : null;
        this.mClosestDataSetToTouch = iBarLineScatterCandleBubbleDataSet;
    }

    public void stopDeceleration() {
        MPPointF mPPointF = this.mDecelerationVelocity;
        mPPointF.x = 0.0f;
        mPPointF.y = 0.0f;
    }
}

