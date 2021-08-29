/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  java.lang.String
 */
package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.utils.Utils;

public class Description
extends ComponentBase {
    public Paint.Align mTextAlign = Paint.Align.RIGHT;
    public String text = "Description Label";

    public Description() {
        this.mTextSize = Utils.convertDpToPixel(8.0f);
    }
}

