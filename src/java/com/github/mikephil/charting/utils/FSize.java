/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;

public final class FSize
extends ObjectPool.Poolable {
    public static ObjectPool<FSize> pool;
    public float height;
    public float width;

    public static {
        ObjectPool objectPool;
        pool = objectPool = ObjectPool.create(256, new FSize(0.0f, 0.0f));
        objectPool.setReplenishPercentage(0.5f);
    }

    public FSize() {
    }

    public FSize(float f, float f2) {
        this.width = f;
        this.height = f2;
    }

    public static FSize getInstance(float f, float f2) {
        FSize fSize = pool.get();
        fSize.width = f;
        fSize.height = f2;
        return fSize;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        boolean bl = object instanceof FSize;
        boolean bl2 = false;
        if (bl) {
            FSize fSize = (FSize)object;
            float f = this.width FCMPL fSize.width;
            bl2 = false;
            if (f == false) {
                float f2 = this.height FCMPL fSize.height;
                bl2 = false;
                if (f2 == false) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    public int hashCode() {
        return Float.floatToIntBits((float)this.width) ^ Float.floatToIntBits((float)this.height);
    }

    @Override
    public ObjectPool.Poolable instantiate() {
        return new FSize(0.0f, 0.0f);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.width);
        stringBuilder.append("x");
        stringBuilder.append(this.height);
        return stringBuilder.toString();
    }
}

