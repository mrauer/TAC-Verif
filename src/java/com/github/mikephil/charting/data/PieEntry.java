/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.util.Log
 *  java.lang.Deprecated
 *  java.lang.String
 */
package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.util.Log;
import com.github.mikephil.charting.data.Entry;

@SuppressLint(value={"ParcelCreator"})
public class PieEntry
extends Entry {
    @Deprecated
    @Override
    public float getX() {
        Log.i((String)"DEPRECATED", (String)"Pie entries do not have x values");
        return this.x;
    }
}

