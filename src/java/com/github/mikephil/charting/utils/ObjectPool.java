/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.mikephil.charting.utils;

public class ObjectPool<T extends Poolable> {
    public static int ids;
    public int desiredCapacity;
    public T modelObject;
    public Object[] objects;
    public int objectsPointer;
    public int poolId;
    public float replenishPercentage;

    public ObjectPool(int n3, T t3) {
        if (n3 > 0) {
            this.desiredCapacity = n3;
            this.objects = new Object[n3];
            this.objectsPointer = 0;
            this.modelObject = t3;
            this.replenishPercentage = 1.0f;
            this.refillPool();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public static ObjectPool create(int n3, Poolable poolable) {
        Class<ObjectPool> class_ = ObjectPool.class;
        synchronized (ObjectPool.class) {
            int n4;
            ObjectPool<Poolable> objectPool = new ObjectPool<Poolable>(n3, poolable);
            objectPool.poolId = n4 = ids;
            ids = n4 + 1;
            // ** MonitorExit[var5_2] (shouldn't be in output)
            return objectPool;
        }
    }

    public T get() {
        ObjectPool objectPool = this;
        synchronized (objectPool) {
            if (this.objectsPointer == -1 && this.replenishPercentage > 0.0f) {
                this.refillPool();
            }
            Object[] arrobject = this.objects;
            int n3 = this.objectsPointer;
            Poolable poolable = (Poolable)arrobject[n3];
            poolable.currentOwnerId = -1;
            this.objectsPointer = n3 - 1;
            return (T)poolable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void recycle(T t3) {
        ObjectPool objectPool = this;
        synchronized (objectPool) {
            int n3;
            int n4 = ((Poolable)t3).currentOwnerId;
            if (n4 != -1) {
                if (n4 == this.poolId) {
                    throw new IllegalArgumentException("The object passed is already stored in this pool!");
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The object to recycle already belongs to poolId ");
                stringBuilder.append(((Poolable)t3).currentOwnerId);
                stringBuilder.append(".  Object cannot belong to two different pool instances simultaneously!");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.objectsPointer = n3 = 1 + this.objectsPointer;
            if (n3 >= this.objects.length) {
                int n5;
                int n6 = this.desiredCapacity;
                this.desiredCapacity = n5 = n6 * 2;
                Object[] arrobject = new Object[n5];
                for (int i3 = 0; i3 < n6; ++i3) {
                    arrobject[i3] = this.objects[i3];
                }
                this.objects = arrobject;
            }
            ((Poolable)t3).currentOwnerId = this.poolId;
            this.objects[this.objectsPointer] = t3;
            return;
        }
    }

    public final void refillPool() {
        float f3 = this.replenishPercentage;
        int n3 = this.desiredCapacity;
        int n4 = (int)(f3 * (float)n3);
        if (n4 < 1) {
            n3 = 1;
        } else if (n4 <= n3) {
            n3 = n4;
        }
        for (int i3 = 0; i3 < n3; ++i3) {
            this.objects[i3] = ((Poolable)this.modelObject).instantiate();
        }
        this.objectsPointer = n3 - 1;
    }

    public void setReplenishPercentage(float f3) {
        if (f3 > 1.0f) {
            f3 = 1.0f;
        } else if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        this.replenishPercentage = f3;
    }

    public static abstract class Poolable {
        public int currentOwnerId = -1;

        public abstract Poolable instantiate();
    }

}

