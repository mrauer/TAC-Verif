/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ArithmeticException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package com.upokecenter.cbor;

import com.upokecenter.cbor.ICBORNumber;
import com.upokecenter.numbers.EDecimal;
import com.upokecenter.numbers.EFloat;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ERational;

public class CBORInteger
implements ICBORNumber {
    @Override
    public EInteger AsEInteger(Object object) {
        return EInteger.FromInt64((Long)object);
    }

    @Override
    public EDecimal AsExtendedDecimal(Object object) {
        return EDecimal.FromInt64((Long)object);
    }

    @Override
    public EFloat AsExtendedFloat(Object object) {
        long l2 = (Long)object;
        return EFloat.FromEInteger(EInteger.FromInt64(l2));
    }

    @Override
    public ERational AsExtendedRational(Object object) {
        long l2 = (Long)object;
        return ERational.FromEInteger(EInteger.FromInt64(l2));
    }

    @Override
    public int AsInt32(Object object, int n2, int n3) {
        long l2 = (Long)object;
        if (l2 >= (long)n2 && l2 <= (long)n3) {
            return (int)l2;
        }
        throw new ArithmeticException("This Object's value is out of range");
    }

    @Override
    public long AsInt64(Object object) {
        return (Long)object;
    }

    @Override
    public boolean CanTruncatedIntFitInInt32(Object object) {
        long l2 = (Long)object;
        return l2 >= Integer.MIN_VALUE && l2 <= Integer.MAX_VALUE;
    }

    @Override
    public boolean IsIntegral(Object object) {
        return true;
    }

    @Override
    public int Sign(Object object) {
        long l2 = (Long)object LCMP 0L;
        if (l2 == false) {
            return 0;
        }
        if (l2 < 0) {
            return -1;
        }
        return 1;
    }
}

