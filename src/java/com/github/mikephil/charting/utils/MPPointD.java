/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.mikephil.charting.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.mikephil.charting.utils.ObjectPool;

public class MPPointD
extends ObjectPool.Poolable {
    public static ObjectPool<MPPointD> pool;
    public double x;
    public double y;

    public static {
        ObjectPool objectPool;
        pool = objectPool = ObjectPool.create(64, new MPPointD(0.0, 0.0));
        objectPool.setReplenishPercentage(0.5f);
    }

    public MPPointD(double d2, double d3) {
        this.x = d2;
        this.y = d3;
    }

    public static MPPointD getInstance(double d2, double d3) {
        MPPointD mPPointD = pool.get();
        mPPointD.x = d2;
        mPPointD.y = d3;
        return mPPointD;
    }

    @Override
    public ObjectPool.Poolable instantiate() {
        return new MPPointD(0.0, 0.0);
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"MPPointD, x: ");
        stringBuilder.append(this.x);
        stringBuilder.append(", y: ");
        stringBuilder.append(this.y);
        return stringBuilder.toString();
    }
}

