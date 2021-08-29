/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.github.mikephil.charting.components;

import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class Legend
extends ComponentBase {
    public List<Boolean> mCalculatedLabelBreakPoints = new ArrayList(16);
    public List<FSize> mCalculatedLabelSizes = new ArrayList(16);
    public List<FSize> mCalculatedLineSizes = new ArrayList(16);
    public LegendDirection mDirection = LegendDirection.LEFT_TO_RIGHT;
    public LegendEntry[] mEntries = new LegendEntry[0];
    public float mFormLineWidth = 3.0f;
    public float mFormSize = 8.0f;
    public float mFormToTextSpace = 5.0f;
    public LegendHorizontalAlignment mHorizontalAlignment = LegendHorizontalAlignment.LEFT;
    public float mMaxSizePercent = 0.95f;
    public float mNeededHeight = 0.0f;
    public float mNeededWidth = 0.0f;
    public LegendOrientation mOrientation = LegendOrientation.HORIZONTAL;
    public LegendForm mShape = LegendForm.SQUARE;
    public float mStackSpace = 3.0f;
    public LegendVerticalAlignment mVerticalAlignment = LegendVerticalAlignment.BOTTOM;
    public float mXEntrySpace = 6.0f;

    public Legend() {
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(3.0f);
    }

}

