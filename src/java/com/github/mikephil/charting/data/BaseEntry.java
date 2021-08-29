/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.github.mikephil.charting.data;

public abstract class BaseEntry {
    public Object mData = null;
    public float y = 0.0f;

    public BaseEntry() {
    }

    public BaseEntry(float f3) {
        this.y = f3;
    }

    public float getY() {
        return this.y;
    }
}

