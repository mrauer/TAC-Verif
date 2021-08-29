/*
 * Decompiled with CFR 0.0.
 */
package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;

public class MPPointF
extends ObjectPool.Poolable {
    public static ObjectPool<MPPointF> pool;
    public float x;
    public float y;

    public static {
        ObjectPool objectPool;
        pool = objectPool = ObjectPool.create(32, new MPPointF(0.0f, 0.0f));
        objectPool.setReplenishPercentage(0.5f);
    }

    public MPPointF() {
    }

    public MPPointF(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public static MPPointF getInstance(float f, float f2) {
        MPPointF mPPointF = pool.get();
        mPPointF.x = f;
        mPPointF.y = f2;
        return mPPointF;
    }

    @Override
    public ObjectPool.Poolable instantiate() {
        return new MPPointF(0.0f, 0.0f);
    }
}

