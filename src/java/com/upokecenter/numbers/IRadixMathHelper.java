/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.upokecenter.numbers;

import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.FastInteger;
import com.upokecenter.numbers.FastIntegerFixed;
import com.upokecenter.numbers.IShiftAccumulator;

public interface IRadixMathHelper<T> {
    public T CreateNewWithFlags(EInteger var1, EInteger var2, int var3);

    public T CreateNewWithFlagsFastInt(FastIntegerFixed var1, FastIntegerFixed var2, int var3);

    public IShiftAccumulator CreateShiftAccumulatorWithDigitsFastInt(FastIntegerFixed var1, int var2, int var3);

    public FastInteger DivisionShift(EInteger var1, EInteger var2);

    public int GetArithmeticSupport();

    public FastInteger GetDigitLength(EInteger var1);

    public EInteger GetExponent(T var1);

    public FastIntegerFixed GetExponentFastInt(T var1);

    public int GetFlags(T var1);

    public EInteger GetMantissa(T var1);

    public FastIntegerFixed GetMantissaFastInt(T var1);

    public int GetRadix();

    public int GetSign(T var1);

    public EInteger MultiplyByRadixPower(EInteger var1, FastInteger var2);

    public T ValueOf(int var1);
}

