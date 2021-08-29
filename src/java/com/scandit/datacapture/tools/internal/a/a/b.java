/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.tools.internal.a.a;

public abstract class b<T> {
    public final boolean a(T t2, T t3) {
        if (t2 == t3) {
            return true;
        }
        if (t2 != null && t3 != null) {
            return this.b(t2, t3);
        }
        return false;
    }

    public abstract int b(T var1);

    public abstract boolean b(T var1, T var2);
}

