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
import com.upokecenter.numbers.EContext;
import com.upokecenter.numbers.EDecimal;
import com.upokecenter.numbers.EFloat;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ERational;

public class CBORExtendedRational
implements ICBORNumber {
    @Override
    public EInteger AsEInteger(Object object) {
        return ((ERational)object).ToEInteger();
    }

    @Override
    public EDecimal AsExtendedDecimal(Object object) {
        return ((ERational)object).ToEDecimalExactIfPossible(EContext.Decimal128.WithUnlimitedExponents());
    }

    @Override
    public EFloat AsExtendedFloat(Object object) {
        EFloat eFloat;
        ERational eRational = (ERational)object;
        EContext eContext = EContext.Binary128.WithUnlimitedExponents();
        if (eRational.IsNaN()) {
            return EFloat.CreateNaN(eRational.unsignedNumerator, eRational.IsSignalingNaN(), eRational.isNegative(), eContext);
        }
        if (eRational.IsPositiveInfinity()) {
            return EFloat.PositiveInfinity.RoundToPrecision(eContext);
        }
        if (eRational.IsNegativeInfinity()) {
            return EFloat.NegativeInfinity.RoundToPrecision(eContext);
        }
        if (eRational.isZero()) {
            if (eRational.isNegative()) {
                return EFloat.NegativeZero;
            }
            return EFloat.Zero;
        }
        EFloat eFloat2 = eRational.isNegative() && eRational.isZero() ? EFloat.NegativeZero : EFloat.FromEInteger(eRational.getNumerator());
        EFloat eFloat3 = eFloat2.Divide(eFloat = EFloat.FromEInteger(eRational.denominator), null);
        if (eFloat3.IsNaN()) {
            return eFloat2.Divide(eFloat, eContext);
        }
        return eFloat3;
    }

    @Override
    public ERational AsExtendedRational(Object object) {
        return (ERational)object;
    }

    @Override
    public int AsInt32(Object object, int n2, int n3) {
        EInteger eInteger;
        int n4;
        ERational eRational = (ERational)object;
        if (eRational.isFinite() && (eInteger = eRational.ToEInteger()).CanFitInInt32() && (n4 = eInteger.ToInt32Checked()) >= n2 && n4 <= n3) {
            return n4;
        }
        throw new ArithmeticException("This Object's value is out of range");
    }

    @Override
    public long AsInt64(Object object) {
        EInteger eInteger;
        ERational eRational = (ERational)object;
        if (eRational.isFinite() && (eInteger = eRational.ToEInteger()).CanFitInInt64()) {
            return eInteger.ToInt64Checked();
        }
        throw new ArithmeticException("This Object's value is out of range");
    }

    @Override
    public boolean CanTruncatedIntFitInInt32(Object object) {
        ERational eRational = (ERational)object;
        if (!eRational.isFinite()) {
            return false;
        }
        return eRational.ToEInteger().CanFitInInt32();
    }

    @Override
    public boolean IsIntegral(Object object) {
        ERational eRational = (ERational)object;
        if (!eRational.isFinite()) {
            return false;
        }
        if (eRational.denominator.equals(EInteger.FromInt32(1))) {
            return true;
        }
        EInteger eInteger = eRational.denominator;
        return eRational.getNumerator().Remainder(eInteger).isZero();
    }

    @Override
    public int Sign(Object object) {
        return ((ERational)object).signum();
    }
}

