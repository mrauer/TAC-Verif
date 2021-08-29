/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ArithmeticException
 *  java.lang.Object
 *  java.lang.String
 */
package com.upokecenter.cbor;

import com.upokecenter.cbor.ICBORNumber;
import com.upokecenter.numbers.EDecimal;
import com.upokecenter.numbers.EFloat;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ERational;

public class CBOREInteger
implements ICBORNumber {
    @Override
    public EInteger AsEInteger(Object object) {
        return (EInteger)object;
    }

    @Override
    public EDecimal AsExtendedDecimal(Object object) {
        return EDecimal.FromEInteger((EInteger)object);
    }

    @Override
    public EFloat AsExtendedFloat(Object object) {
        return EFloat.FromEInteger((EInteger)object);
    }

    @Override
    public ERational AsExtendedRational(Object object) {
        return ERational.FromEInteger((EInteger)object);
    }

    @Override
    public int AsInt32(Object object, int n2, int n3) {
        int n4;
        EInteger eInteger = (EInteger)object;
        if (eInteger.CanFitInInt32() && (n4 = eInteger.ToInt32Checked()) >= n2 && n4 <= n3) {
            return n4;
        }
        throw new ArithmeticException("This Object's value is out of range");
    }

    @Override
    public long AsInt64(Object object) {
        EInteger eInteger = (EInteger)object;
        if (eInteger.CanFitInInt64()) {
            return eInteger.ToInt64Checked();
        }
        throw new ArithmeticException("This Object's value is out of range");
    }

    @Override
    public boolean CanTruncatedIntFitInInt32(Object object) {
        return ((EInteger)object).CanFitInInt32();
    }

    @Override
    public boolean IsIntegral(Object object) {
        return true;
    }

    @Override
    public int Sign(Object object) {
        return ((EInteger)object).signum();
    }
}

