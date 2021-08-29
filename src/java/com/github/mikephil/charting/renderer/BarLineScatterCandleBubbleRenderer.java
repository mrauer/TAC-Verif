/*
 * Decompiled with CFR 0.0.
 */
package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class BarLineScatterCandleBubbleRenderer
extends DataRenderer {
    public BarLineScatterCandleBubbleRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
    }

    public boolean shouldDrawValues(IDataSet iDataSet) {
        return iDataSet.isVisible() && (iDataSet.isDrawValuesEnabled() || iDataSet.isDrawIconsEnabled());
    }
}

