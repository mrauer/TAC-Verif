/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.upokecenter.numbers;

import com.upokecenter.numbers.EContext;
import com.upokecenter.numbers.IRadixMathHelper;

public interface IRadixMath<T> {
    public T Abs(T var1, EContext var2);

    public T Add(T var1, T var2, EContext var3);

    public T AddEx(T var1, T var2, EContext var3, boolean var4);

    public T Divide(T var1, T var2, EContext var3);

    public IRadixMathHelper<T> GetHelper();

    public T Multiply(T var1, T var2, EContext var3);

    public T NextPlus(T var1, EContext var2);

    public T Quantize(T var1, T var2, EContext var3);

    public T RoundToPrecision(T var1, EContext var2);

    public int compareTo(T var1, T var2);
}

