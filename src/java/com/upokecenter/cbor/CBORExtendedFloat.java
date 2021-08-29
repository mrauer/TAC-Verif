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

public class CBORExtendedFloat
implements ICBORNumber {
    @Override
    public EInteger AsEInteger(Object object) {
        return ((EFloat)object).ToEInteger();
    }

    @Override
    public EDecimal AsExtendedDecimal(Object object) {
        return EDecimal.FromEFloat((EFloat)object);
    }

    @Override
    public EFloat AsExtendedFloat(Object object) {
        return (EFloat)object;
    }

    @Override
    public ERational AsExtendedRational(Object object) {
        return ERational.FromEFloat((EFloat)object);
    }

    @Override
    public int AsInt32(Object object, int n2, int n3) {
        int n4;
        EFloat eFloat = (EFloat)object;
        if (this.CanTruncatedIntFitInInt32(object) && (n4 = eFloat.ToEInteger().ToInt32Checked()) >= n2 && n4 <= n3) {
            return n4;
        }
        throw new ArithmeticException("This Object's value is out of range");
    }

    @Override
    public long AsInt64(Object object) {
        EFloat eFloat = (EFloat)object;
        boolean bl = !eFloat.isFinite() ? false : (eFloat.isZero() ? true : (eFloat.exponent.compareTo(EInteger.FromInt64(65L)) >= 0 ? false : eFloat.ToEInteger().CanFitInInt64()));
        if (bl) {
            return eFloat.ToEInteger().ToInt64Checked();
        }
        throw new ArithmeticException("This Object's value is out of range");
    }

    @Override
    public boolean CanTruncatedIntFitInInt32(Object object) {
        EFloat eFloat = (EFloat)object;
        if (!eFloat.isFinite()) {
            return false;
        }
        if (eFloat.isZero()) {
            return true;
        }
        if (eFloat.exponent.compareTo(EInteger.FromInt64(33L)) >= 0) {
            return false;
        }
        return eFloat.ToEInteger().CanFitInInt32();
    }

    @Override
    public boolean IsIntegral(Object object) {
        EFloat eFloat = (EFloat)object;
        if (!eFloat.isFinite()) {
            return false;
        }
        if (eFloat.exponent.signum() >= 0) {
            return true;
        }
        int n2 = EFloat.FromEInteger(eFloat.ToEInteger()).compareTo(eFloat);
        boolean bl = false;
        if (n2 == 0) {
            bl = true;
        }
        return bl;
    }

    @Override
    public int Sign(Object object) {
        EFloat eFloat = (EFloat)object;
        if (eFloat.IsNaN()) {
            return 2;
        }
        return eFloat.signum();
    }
}

