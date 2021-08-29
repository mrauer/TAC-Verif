/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.upokecenter.numbers;

import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.FastInteger;

public interface IShiftAccumulator {
    public FastInteger GetDigitLength();

    public void ShiftRightInt(int var1);

    public void ShiftToDigits(FastInteger var1, FastInteger var2, boolean var3);

    public void TruncateOrShiftRight(FastInteger var1, boolean var2);

    public FastInteger getDiscardedDigitCount();

    public int getLastDiscardedDigit();

    public int getOlderDiscardedDigits();

    public EInteger getShiftedInt();

    public FastInteger getShiftedIntFast();
}

