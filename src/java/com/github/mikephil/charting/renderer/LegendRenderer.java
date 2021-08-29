/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.DashPathEffect
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$FontMetrics
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathEffect
 *  java.lang.Float
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Objects
 */
package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.renderer.Renderer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LegendRenderer
extends Renderer {
    public List<LegendEntry> computedEntries = new ArrayList(16);
    public Paint.FontMetrics legendFontMetrics = new Paint.FontMetrics();
    public Legend mLegend;
    public Paint mLegendFormPaint;
    public Paint mLegendLabelPaint;
    public Path mLineFormPath = new Path();

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        Paint paint;
        Paint paint2;
        super(viewPortHandler);
        this.mLegend = legend;
        this.mLegendLabelPaint = paint2 = new Paint(1);
        paint2.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        this.mLegendFormPaint = paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
    }

    public void drawForm(Canvas canvas, float f, float f2, LegendEntry legendEntry, Legend legend) {
        block4 : {
            int n;
            block7 : {
                float f3;
                block5 : {
                    float f4;
                    block6 : {
                        int n2 = legendEntry.formColor;
                        if (n2 == 1122868 || n2 == 1122867) break block4;
                        if (n2 == 0) {
                            return;
                        }
                        n = canvas.save();
                        Legend.LegendForm legendForm = legendEntry.form;
                        if (legendForm == Legend.LegendForm.DEFAULT) {
                            legendForm = legend.mShape;
                        }
                        this.mLegendFormPaint.setColor(legendEntry.formColor);
                        float f5 = Float.isNaN((float)legendEntry.formSize) ? legend.mFormSize : legendEntry.formSize;
                        f4 = Utils.convertDpToPixel(f5);
                        f3 = f4 / 2.0f;
                        int n3 = legendForm.ordinal();
                        if (n3 == 2) break block5;
                        if (n3 == 3) break block6;
                        if (n3 == 4) break block5;
                        if (n3 == 5) {
                            float f6 = Float.isNaN((float)legendEntry.formLineWidth) ? legend.mFormLineWidth : legendEntry.formLineWidth;
                            float f7 = Utils.convertDpToPixel(f6);
                            DashPathEffect dashPathEffect = legendEntry.formLineDashEffect;
                            if (dashPathEffect == null) {
                                Objects.requireNonNull((Object)legend);
                                dashPathEffect = null;
                            }
                            this.mLegendFormPaint.setStyle(Paint.Style.STROKE);
                            this.mLegendFormPaint.setStrokeWidth(f7);
                            this.mLegendFormPaint.setPathEffect((PathEffect)dashPathEffect);
                            this.mLineFormPath.reset();
                            this.mLineFormPath.moveTo(f, f2);
                            this.mLineFormPath.lineTo(f + f4, f2);
                            canvas.drawPath(this.mLineFormPath, this.mLegendFormPaint);
                        }
                        break block7;
                    }
                    this.mLegendFormPaint.setStyle(Paint.Style.FILL);
                    canvas.drawRect(f, f2 - f3, f + f4, f2 + f3, this.mLegendFormPaint);
                    break block7;
                }
                this.mLegendFormPaint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(f + f3, f2, f3, this.mLegendFormPaint);
            }
            canvas.restoreToCount(n);
        }
    }
}

