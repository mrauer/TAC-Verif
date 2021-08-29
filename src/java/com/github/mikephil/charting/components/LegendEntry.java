/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.DashPathEffect
 *  com.github.mikephil.charting.components.Legend
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.components.Legend;

public class LegendEntry {
    public Legend.LegendForm form = Legend.LegendForm.DEFAULT;
    public int formColor = 1122867;
    public DashPathEffect formLineDashEffect = null;
    public float formLineWidth = Float.NaN;
    public float formSize = Float.NaN;
    public String label;

    public LegendEntry() {
    }

    public LegendEntry(String string, Legend.LegendForm legendForm, float f3, float f4, DashPathEffect dashPathEffect, int n3) {
        this.label = string;
        this.form = legendForm;
        this.formSize = f3;
        this.formLineWidth = f4;
        this.formLineDashEffect = dashPathEffect;
        this.formColor = n3;
    }
}

