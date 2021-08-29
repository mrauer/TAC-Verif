/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.upokecenter.numbers.EDecimal
 *  com.upokecenter.numbers.EFloat
 *  com.upokecenter.numbers.EInteger
 *  com.upokecenter.numbers.ERational
 *  java.lang.Object
 */
package com.upokecenter.cbor;

import com.upokecenter.numbers.EDecimal;
import com.upokecenter.numbers.EFloat;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ERational;

public interface ICBORNumber {
    public EInteger AsEInteger(Object var1);

    public EDecimal AsExtendedDecimal(Object var1);

    public EFloat AsExtendedFloat(Object var1);

    public ERational AsExtendedRational(Object var1);

    public int AsInt32(Object var1, int var2, int var3);

    public long AsInt64(Object var1);

    public boolean CanTruncatedIntFitInInt32(Object var1);

    public boolean IsIntegral(Object var1);

    public int Sign(Object var1);
}

