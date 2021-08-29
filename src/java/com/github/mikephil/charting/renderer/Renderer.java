/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class Renderer {
    public ViewPortHandler mViewPortHandler;

    public Renderer(ViewPortHandler viewPortHandler) {
        this.mViewPortHandler = viewPortHandler;
    }
}

