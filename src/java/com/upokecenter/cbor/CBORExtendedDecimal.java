/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ArithmeticException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.upokecenter.cbor;

import com.upokecenter.cbor.ICBORNumber;
import com.upokecenter.numbers.EContext;
import com.upokecenter.numbers.EDecimal;
import com.upokecenter.numbers.EFloat;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ERational;
import java.util.Objects;

public class CBORExtendedDecimal
implements ICBORNumber {
    @Override
    public EInteger AsEInteger(Object object) {
        return ((EDecimal)object).ToEInteger();
    }

    @Override
    public EDecimal AsExtendedDecimal(Object object) {
        return (EDecimal)object;
    }

    @Override
    public EFloat AsExtendedFloat(Object object) {
        EDecimal eDecimal = (EDecimal)object;
        Objects.requireNonNull((Object)eDecimal);
        return eDecimal.ToEFloat(EContext.UnlimitedHalfEven);
    }

    @Override
    public ERational AsExtendedRational(Object object) {
        return ERational.FromEDecimal((EDecimal)object);
    }

    @Override
    public int AsInt32(Object object, int n2, int n3) {
        int n4;
        EDecimal eDecimal = (EDecimal)object;
        if (this.CanTruncatedIntFitInInt32(object) && (n4 = eDecimal.ToEInteger().ToInt32Checked()) >= n2 && n4 <= n3) {
            return n4;
        }
        throw new ArithmeticException("This Object's value is out of range");
    }

    @Override
    public long AsInt64(Object object) {
        EDecimal eDecimal = (EDecimal)object;
        boolean bl = !eDecimal.isFinite() ? false : (eDecimal.isZero() ? true : (eDecimal.getExponent().compareTo(EInteger.FromInt64(21L)) >= 0 ? false : eDecimal.ToEInteger().CanFitInInt64()));
        if (bl) {
            return eDecimal.ToEInteger().ToInt64Checked();
        }
        throw new ArithmeticException("This Object's value is out of range");
    }

    @Override
    public boolean CanTruncatedIntFitInInt32(Object object) {
        EDecimal eDecimal = (EDecimal)object;
        if (!eDecimal.isFinite()) {
            return false;
        }
        if (eDecimal.isZero()) {
            return true;
        }
        if (eDecimal.getExponent().compareTo(EInteger.FromInt64(11L)) >= 0) {
            return false;
        }
        return eDecimal.ToEInteger().CanFitInInt32();
    }

    @Override
    public boolean IsIntegral(Object object) {
        EDecimal eDecimal = (EDecimal)object;
        return eDecimal.isFinite() && (eDecimal.getExponent().signum() >= 0 || eDecimal.compareTo(EDecimal.FromEInteger(eDecimal.ToEInteger())) == 0);
    }

    @Override
    public int Sign(Object object) {
        EDecimal eDecimal = (EDecimal)object;
        if (eDecimal.IsNaN()) {
            return 2;
        }
        return eDecimal.signum();
    }
}

