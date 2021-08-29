/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.mikephil.charting.components;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.utils.Utils;

public class XAxis
extends AxisBase {
    public int mLabelRotatedHeight = 1;
    public int mLabelRotatedWidth = 1;
    public XAxisPosition mPosition = XAxisPosition.TOP;

    public XAxis() {
        this.mYOffset = Utils.convertDpToPixel(4.0f);
    }

}

