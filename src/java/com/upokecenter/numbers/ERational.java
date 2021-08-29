/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.ArithmeticException
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package com.upokecenter.numbers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.upokecenter.numbers.EContext;
import com.upokecenter.numbers.EDecimal;
import com.upokecenter.numbers.EFloat;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ERounding;
import com.upokecenter.numbers.NumberUtility;
import java.util.Objects;

public final class ERational
implements Comparable<ERational> {
    public static final ERational NaN = new ERational(EInteger.FromInt32(0), EInteger.FromInt32(1), 4);
    public static final ERational NegativeInfinity = new ERational(EInteger.FromInt32(0), EInteger.FromInt32(1), 3);
    public static final ERational PositiveInfinity;
    public static final ERational SignalingNaN;
    public final EInteger denominator;
    public final int flags;
    public final EInteger unsignedNumerator;

    public static {
        EInteger.FromInt32(0);
        EInteger.FromInt32(1);
        ERational.FromEInteger(EInteger.FromInt32(1));
        PositiveInfinity = new ERational(EInteger.FromInt32(0), EInteger.FromInt32(1), 2);
        SignalingNaN = new ERational(EInteger.FromInt32(0), EInteger.FromInt32(1), 8);
        ERational.FromEInteger(EInteger.FromInt32(10));
        ERational.FromEInteger(EInteger.FromInt32(0));
    }

    public ERational(EInteger eInteger, EInteger eInteger2) {
        Objects.requireNonNull((Object)eInteger, (String)"numerator");
        Objects.requireNonNull((Object)eInteger2, (String)"denominator");
        if (!eInteger2.isZero()) {
            int n2;
            int n3 = eInteger.signum();
            int n4 = 1;
            int n5 = n3 < 0 ? n4 : 0;
            if (n5 == (n2 = eInteger2.signum() < 0 ? n4 : 0)) {
                n4 = 0;
            }
            this.flags = n4;
            if (n5 != 0) {
                eInteger = eInteger.Negate();
            }
            if (n2 != 0) {
                eInteger2 = eInteger2.Negate();
            }
            this.unsignedNumerator = eInteger;
            this.denominator = eInteger2;
            return;
        }
        throw new IllegalArgumentException("denominator is zero");
    }

    public ERational(EInteger eInteger, EInteger eInteger2, int n2) {
        this.unsignedNumerator = eInteger;
        this.denominator = eInteger2;
        this.flags = n2;
    }

    public static ERational FromEDecimal(EDecimal eDecimal) {
        Objects.requireNonNull((Object)eDecimal, (String)"ef");
        if (!eDecimal.isFinite()) {
            int n2 = eDecimal.isNegative();
            if (eDecimal.IsInfinity()) {
                n2 |= 2;
            }
            if (eDecimal.IsSignalingNaN()) {
                n2 |= 8;
            }
            int n3 = 4 & eDecimal.flags;
            boolean bl = false;
            if (n3 != 0) {
                bl = true;
            }
            if (bl) {
                n2 |= 4;
            }
            return new ERational(eDecimal.getUnsignedMantissa(), EInteger.FromInt32(1), n2);
        }
        EInteger eInteger = eDecimal.getMantissa();
        EInteger eInteger2 = eDecimal.getExponent();
        if (eInteger2.isZero()) {
            return ERational.FromEInteger(eInteger);
        }
        int n4 = eInteger.signum();
        boolean bl = false;
        if (n4 < 0) {
            bl = true;
        }
        EInteger eInteger3 = eInteger.Abs();
        EInteger eInteger4 = EInteger.FromInt32(1);
        if (eInteger2.signum() < 0) {
            eInteger4 = NumberUtility.FindPowerOfTenFromBig(eInteger2.Negate());
        } else {
            eInteger3 = eInteger3.Multiply(NumberUtility.FindPowerOfTenFromBig(eInteger2));
        }
        if (bl) {
            eInteger3 = eInteger3.Negate();
        }
        return new ERational(eInteger3, eInteger4);
    }

    public static ERational FromEFloat(EFloat eFloat) {
        Objects.requireNonNull((Object)eFloat, (String)"ef");
        if (!eFloat.isFinite()) {
            boolean bl = eFloat.isNegative();
            int n2 = 0;
            if (bl) {
                n2 = 1;
            }
            if (eFloat.IsInfinity()) {
                n2 |= 2;
            }
            if (eFloat.IsSignalingNaN()) {
                n2 |= 8;
            }
            if (eFloat.IsQuietNaN()) {
                n2 |= 4;
            }
            return new ERational(eFloat.unsignedMantissa, EInteger.FromInt32(1), n2);
        }
        EInteger eInteger = eFloat.getMantissa();
        EInteger eInteger2 = eFloat.exponent;
        if (eInteger2.isZero()) {
            return ERational.FromEInteger(eInteger);
        }
        int n3 = eInteger.signum();
        boolean bl = false;
        if (n3 < 0) {
            bl = true;
        }
        EInteger eInteger3 = eInteger.Abs();
        EInteger eInteger4 = EInteger.FromInt32(1);
        if (eInteger2.signum() < 0) {
            eInteger4 = eInteger4.ShiftLeft(eInteger2.Negate());
        } else {
            eInteger3 = eInteger3.ShiftLeft(eInteger2);
        }
        if (bl) {
            eInteger3 = eInteger3.Negate();
        }
        return new ERational(eInteger3, eInteger4);
    }

    public static ERational FromEInteger(EInteger eInteger) {
        return new ERational(eInteger, EInteger.FromInt32(1));
    }

    public int CompareToBinary(EFloat eFloat) {
        int n2;
        int n3 = 1;
        if (eFloat == null) {
            return n3;
        }
        if (this.IsNaN()) {
            return n3 ^ eFloat.IsNaN();
        }
        int n4 = this.signum();
        if (n4 != (n2 = eFloat.signum())) {
            if (n4 < n2) {
                n3 = -1;
            }
            return n3;
        }
        if (n2 != 0) {
            if (n4 == 0) {
                return 0;
            }
            if (this.IsInfinity()) {
                if (eFloat.IsInfinity()) {
                    return 0;
                }
                if (this.isNegative()) {
                    n3 = -1;
                }
                return n3;
            }
            if (eFloat.IsInfinity()) {
                if (eFloat.isNegative()) {
                    return n3;
                }
                return -1;
            }
            EInteger eInteger = eFloat.exponent;
            if (eInteger.isZero()) {
                EInteger eInteger2 = eFloat.getMantissa();
                EInteger eInteger3 = this.denominator.Multiply(eInteger2);
                return this.getNumerator().compareTo(eInteger3);
            }
            if (eInteger.Abs().compareTo(EInteger.FromInt64(1000L)) > 0) {
                EInteger[] arreInteger = this.unsignedNumerator.DivRem(this.denominator);
                EInteger eInteger4 = arreInteger[0];
                EInteger eInteger5 = arreInteger[n3];
                EFloat eFloat2 = eFloat.isNegative() ? new EFloat(eFloat.unsignedMantissa, eFloat.exponent, -2 & eFloat.flags) : eFloat;
                EFloat eFloat3 = EFloat.FromEInteger(eInteger4);
                if (eInteger5.isZero()) {
                    int n5 = eFloat3.compareTo(eFloat2);
                    if (this.isNegative()) {
                        n5 = -n5;
                    }
                    return n5;
                }
                if (eFloat3.compareTo(eFloat2) > 0) {
                    if (this.isNegative()) {
                        n3 = -1;
                    }
                    return n3;
                }
                if (EFloat.FromEInteger(eInteger4.Add(EInteger.FromInt32(n3))).compareTo(eFloat2) < 0) {
                    if (this.isNegative()) {
                        return n3;
                    }
                    return -1;
                }
                if (EFloat.FromEInteger(this.unsignedNumerator).Divide(EFloat.FromEInteger(this.denominator), EContext.ForPrecisionAndRounding(256, ERounding.Down)).compareTo(eFloat2) > 0) {
                    if (this.isNegative()) {
                        n3 = -1;
                    }
                    return n3;
                }
                if (eFloat.exponent.signum() > 0 && this.unsignedNumerator.GetSignedBitLengthAsEInteger().Subtract(n3).compareTo(eFloat.exponent) < 0) {
                    if (this.isNegative()) {
                        return n3;
                    }
                    return -1;
                }
            }
            ERational eRational = ERational.FromEFloat(eFloat);
            return this.getNumerator().Multiply(eRational.denominator).compareTo(this.denominator.Multiply(eRational.getNumerator()));
        }
        return 0;
    }

    public int CompareToDecimal(EDecimal eDecimal) {
        int n2;
        int n3 = 1;
        if (eDecimal == null) {
            return n3;
        }
        if (this.IsNaN()) {
            return n3 ^ eDecimal.IsNaN();
        }
        int n4 = this.signum();
        if (n4 != (n2 = eDecimal.signum())) {
            if (n4 < n2) {
                n3 = -1;
            }
            return n3;
        }
        if (n2 != 0) {
            if (n4 == 0) {
                return 0;
            }
            if (this.IsInfinity()) {
                if (eDecimal.IsInfinity()) {
                    return 0;
                }
                if (this.isNegative()) {
                    n3 = -1;
                }
                return n3;
            }
            if (eDecimal.IsInfinity()) {
                if (eDecimal.isNegative()) {
                    return n3;
                }
                return -1;
            }
            if (eDecimal.getExponent().isZero()) {
                EInteger eInteger = eDecimal.getMantissa();
                EInteger eInteger2 = this.denominator.Multiply(eInteger);
                return this.getNumerator().compareTo(eInteger2);
            }
            if (eDecimal.getExponent().Abs().compareTo(EInteger.FromInt64(50L)) > 0) {
                EInteger[] arreInteger = this.unsignedNumerator.DivRem(this.denominator);
                EInteger eInteger = arreInteger[0];
                EInteger eInteger3 = arreInteger[n3];
                EDecimal eDecimal2 = eDecimal.Abs();
                EDecimal eDecimal3 = EDecimal.FromEInteger(eInteger);
                if (eInteger3.isZero()) {
                    int n5 = eDecimal3.compareTo(eDecimal2);
                    if (this.isNegative()) {
                        n5 = -n5;
                    }
                    return n5;
                }
                if (eDecimal3.compareTo(eDecimal2) > 0) {
                    if (this.isNegative()) {
                        n3 = -1;
                    }
                    return n3;
                }
                if (EDecimal.FromEInteger(eInteger.Add(EInteger.FromInt32(n3))).compareTo(eDecimal2) < 0) {
                    if (this.isNegative()) {
                        return n3;
                    }
                    return -1;
                }
                if (EDecimal.FromEInteger(this.unsignedNumerator).Divide(EDecimal.FromEInteger(this.denominator), EContext.ForPrecisionAndRounding(20, ERounding.Down)).compareTo(eDecimal2) > 0) {
                    if (this.isNegative()) {
                        n3 = -1;
                    }
                    return n3;
                }
                if (eDecimal.getExponent().signum() > 0 && this.unsignedNumerator.GetDigitCountAsEInteger().Subtract(n3).compareTo(eDecimal.getExponent()) < 0) {
                    if (this.isNegative()) {
                        return n3;
                    }
                    return -1;
                }
            }
            ERational eRational = ERational.FromEDecimal(eDecimal);
            return this.getNumerator().Multiply(eRational.denominator).compareTo(this.denominator.Multiply(eRational.getNumerator()));
        }
        return 0;
    }

    public boolean IsInfinity() {
        return (2 & this.flags) != 0;
    }

    public boolean IsNaN() {
        return (12 & this.flags) != 0;
    }

    public boolean IsNegativeInfinity() {
        return (3 & this.flags) == 3;
    }

    public boolean IsPositiveInfinity() {
        return (3 & this.flags) == 2;
    }

    public boolean IsSignalingNaN() {
        return (8 & this.flags) != 0;
    }

    public EDecimal ToEDecimalExactIfPossible(EContext eContext) {
        EDecimal eDecimal;
        if (this.IsNaN()) {
            return EDecimal.CreateNaN(this.unsignedNumerator, this.IsSignalingNaN(), this.isNegative(), eContext);
        }
        if (this.IsPositiveInfinity()) {
            return EDecimal.PositiveInfinity.RoundToPrecision(eContext);
        }
        if (this.IsNegativeInfinity()) {
            return EDecimal.NegativeInfinity.RoundToPrecision(eContext);
        }
        if (this.isNegative() && this.isZero()) {
            return EDecimal.NegativeZero;
        }
        EDecimal eDecimal2 = this.isNegative() && this.isZero() ? EDecimal.NegativeZero : EDecimal.FromEInteger(this.getNumerator());
        EDecimal eDecimal3 = eDecimal2.Divide(eDecimal = EDecimal.FromEInteger(this.denominator), null);
        if (eDecimal3.IsNaN()) {
            eDecimal3 = eDecimal2.Divide(eDecimal, eContext);
        }
        return eDecimal3;
    }

    public EInteger ToEInteger() {
        if (this.isFinite()) {
            return this.getNumerator().Divide(this.denominator);
        }
        throw new ArithmeticException("Value is infinity or NaN");
    }

    public int compareTo(ERational eRational) {
        int n2;
        int n3 = 1;
        if (eRational == null) {
            return n3;
        }
        if (this == eRational) {
            return 0;
        }
        if (this.IsNaN()) {
            return n3 ^ eRational.IsNaN();
        }
        if (eRational.IsNaN()) {
            return -1;
        }
        int n4 = this.signum();
        if (n4 != (n2 = eRational.signum())) {
            if (n4 < n2) {
                n3 = -1;
            }
            return n3;
        }
        if (n2 != 0) {
            if (n4 == 0) {
                return 0;
            }
            if (this.IsInfinity()) {
                if (eRational.IsInfinity()) {
                    return 0;
                }
                if (this.isNegative()) {
                    n3 = -1;
                }
                return n3;
            }
            if (eRational.IsInfinity()) {
                if (eRational.isNegative()) {
                    return n3;
                }
                return -1;
            }
            int n5 = this.denominator.compareTo(eRational.denominator);
            int n6 = this.unsignedNumerator.compareTo(eRational.unsignedNumerator);
            if (n4 < 0) {
                n6 = -n6;
            }
            if (n6 == 0) {
                if (n4 < 0) {
                    return n5;
                }
                return -n5;
            }
            if (n5 == 0) {
                return n6;
            }
            return this.getNumerator().Multiply(eRational.denominator).compareTo(this.denominator.Multiply(eRational.getNumerator()));
        }
        return 0;
    }

    public boolean equals(Object object) {
        EInteger eInteger;
        EInteger eInteger2;
        ERational eRational = object instanceof ERational ? (ERational)object : null;
        return eRational != null && ((eInteger2 = this.unsignedNumerator) == null ? eRational.unsignedNumerator == null : eInteger2.equals(eRational.unsignedNumerator)) && ((eInteger = this.denominator) == null ? eRational.denominator == null : eInteger.equals(eRational.denominator)) && this.flags == eRational.flags;
    }

    public final EInteger getNumerator() {
        if (this.isNegative()) {
            return this.unsignedNumerator.Negate();
        }
        return this.unsignedNumerator;
    }

    public int hashCode() {
        EInteger eInteger;
        EInteger eInteger2 = this.unsignedNumerator;
        int n2 = 1857066527;
        if (eInteger2 != null) {
            n2 += 1857066539 * eInteger2.hashCode();
        }
        if ((eInteger = this.denominator) != null) {
            n2 += 1857066551 * eInteger.hashCode();
        }
        return n2 + 1857066623 * this.flags;
    }

    public final boolean isFinite() {
        return !this.IsNaN() && !this.IsInfinity();
    }

    public final boolean isNegative() {
        return (1 & this.flags) != 0;
    }

    public final boolean isZero() {
        return (14 & this.flags) == 0 && this.unsignedNumerator.isZero();
    }

    /*
     * Enabled aggressive block sorting
     */
    public final int signum() {
        if ((14 & this.flags) != 0) {
            if (!this.isNegative()) return 1;
            return -1;
        }
        if (this.unsignedNumerator.isZero()) {
            return 0;
        }
        if (this.isNegative()) return -1;
        return 1;
    }

    public String toString() {
        StringBuilder stringBuilder;
        if (!this.isFinite()) {
            if (this.IsSignalingNaN()) {
                if (this.unsignedNumerator.isZero()) {
                    if (this.isNegative()) {
                        return "-sNaN";
                    }
                    return "sNaN";
                }
                if (this.isNegative()) {
                    StringBuilder stringBuilder2 = GeneratedOutlineSupport.outline24((String)"-sNaN");
                    stringBuilder2.append((Object)this.unsignedNumerator);
                    return stringBuilder2.toString();
                }
                StringBuilder stringBuilder3 = GeneratedOutlineSupport.outline24((String)"sNaN");
                stringBuilder3.append((Object)this.unsignedNumerator);
                return stringBuilder3.toString();
            }
            boolean bl = (4 & this.flags) != 0;
            if (bl) {
                if (this.unsignedNumerator.isZero()) {
                    if (this.isNegative()) {
                        return "-NaN";
                    }
                    return "NaN";
                }
                if (this.isNegative()) {
                    StringBuilder stringBuilder4 = GeneratedOutlineSupport.outline24((String)"-NaN");
                    stringBuilder4.append((Object)this.unsignedNumerator);
                    return stringBuilder4.toString();
                }
                StringBuilder stringBuilder5 = GeneratedOutlineSupport.outline24((String)"NaN");
                stringBuilder5.append((Object)this.unsignedNumerator);
                return stringBuilder5.toString();
            }
            if (this.IsInfinity()) {
                if (this.isNegative()) {
                    return "-Infinity";
                }
                return "Infinity";
            }
        }
        if (this.getNumerator().isZero() && this.isNegative()) {
            stringBuilder = GeneratedOutlineSupport.outline24((String)"-0/");
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append((Object)this.getNumerator());
            stringBuilder.append("/");
        }
        stringBuilder.append((Object)this.denominator);
        return stringBuilder.toString();
    }
}

