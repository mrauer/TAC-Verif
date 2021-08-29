/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.upokecenter.numbers.BitShiftAccumulator
 *  com.upokecenter.numbers.EFloat$BinaryMathHelper
 *  com.upokecenter.numbers.ExtendedOrSimpleRadixMath
 *  com.upokecenter.numbers.TrappableRadixMath
 *  java.lang.ArithmeticException
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Objects
 */
package com.upokecenter.numbers;

import com.google.android.material.R;
import com.upokecenter.numbers.BitShiftAccumulator;
import com.upokecenter.numbers.EContext;
import com.upokecenter.numbers.EDecimal;
import com.upokecenter.numbers.EFloat;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ExtendedOrSimpleRadixMath;
import com.upokecenter.numbers.FastInteger;
import com.upokecenter.numbers.IRadixMath;
import com.upokecenter.numbers.IRadixMathHelper;
import com.upokecenter.numbers.NumberUtility;
import com.upokecenter.numbers.TrappableRadixMath;
import java.util.Objects;

/*
 * Exception performing whole class analysis.
 */
public final class EFloat
implements Comparable<EFloat> {
    public static final IRadixMath<EFloat> MathValue;
    public static final EFloat NaN;
    public static final EFloat NegativeInfinity;
    public static final EFloat NegativeZero;
    public static final EFloat One;
    public static final EFloat PositiveInfinity;
    public static final EFloat SignalingNaN;
    public static final EFloat Zero;
    public final EInteger exponent;
    public final int flags;
    public final EInteger unsignedMantissa;

    public static {
        NaN = EFloat.CreateWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), 4);
        NegativeInfinity = EFloat.CreateWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), 3);
        NegativeZero = EFloat.CreateWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), 1);
        One = EFloat.Create(EInteger.FromInt32(1), EInteger.FromInt32(0));
        PositiveInfinity = EFloat.CreateWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), 2);
        SignalingNaN = EFloat.CreateWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), 8);
        EFloat.Create(EInteger.FromInt32(10), EInteger.FromInt32(0));
        Zero = EFloat.Create(EInteger.FromInt32(0), EInteger.FromInt32(0));
        MathValue = new TrappableRadixMath((IRadixMath)new ExtendedOrSimpleRadixMath((IRadixMathHelper)new /* Unavailable Anonymous Inner Class!! */));
    }

    public EFloat(EInteger eInteger, EInteger eInteger2, int n2) {
        this.unsignedMantissa = eInteger;
        this.exponent = eInteger2;
        this.flags = n2;
    }

    public static EFloat Create(EInteger eInteger, EInteger eInteger2) {
        Objects.requireNonNull((Object)eInteger, (String)"mantissa");
        Objects.requireNonNull((Object)eInteger2, (String)"exponent");
        int n2 = eInteger.signum();
        if (n2 < 0) {
            eInteger = eInteger.Negate();
        }
        int n3 = n2 < 0 ? 1 : 0;
        return new EFloat(eInteger, eInteger2, n3);
    }

    public static EFloat CreateNaN(EInteger eInteger, boolean bl, boolean bl2, EContext eContext) {
        Objects.requireNonNull((Object)eInteger, (String)"diag");
        if (eInteger.signum() >= 0) {
            if (eInteger.isZero() && !bl2) {
                if (bl) {
                    return SignalingNaN;
                }
                return NaN;
            }
            int n2 = bl2 ? 1 : 0;
            int n3 = 8;
            if (eContext != null && eContext.getHasMaxPrecision()) {
                int n4 = n2 | 4;
                EFloat eFloat = EFloat.CreateWithFlags(eInteger, EInteger.FromInt32(0), n4).RoundToPrecision(eContext);
                int n5 = -5 & eFloat.flags;
                if (!bl) {
                    n3 = 4;
                }
                int n6 = n5 | n3;
                return new EFloat(eFloat.unsignedMantissa, eFloat.exponent, n6);
            }
            if (!bl) {
                n3 = 4;
            }
            int n7 = n2 | n3;
            return EFloat.CreateWithFlags(eInteger, EInteger.FromInt32(0), n7);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Diagnostic information must be 0 or greater, was: ");
        stringBuilder.append((Object)eInteger);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static EFloat CreateWithFlags(EInteger eInteger, EInteger eInteger2, int n2) {
        Objects.requireNonNull((Object)eInteger, (String)"mantissa");
        Objects.requireNonNull((Object)eInteger2, (String)"exponent");
        if (eInteger.signum() < 0) {
            eInteger = eInteger.Negate();
        }
        return new EFloat(eInteger, eInteger2, n2);
    }

    public static EFloat FromDouble(double d2) {
        int[] arrn = R.style.DoubleToIntegers((double)d2);
        int n2 = 2047 & arrn[1] >> 20;
        int n3 = arrn[1] >> 31 != 0 ? 1 : 0;
        if (n2 == 2047) {
            if ((1048575 & arrn[1]) == 0 && arrn[0] == 0) {
                if (n3 != 0) {
                    return NegativeInfinity;
                }
                return PositiveInfinity;
            }
            boolean bl = (524288 & arrn[1]) != 0;
            arrn[1] = 524287 & arrn[1];
            long l2 = 0xFFFFFFFFL & (long)arrn[0] | (long)arrn[1] << 32;
            if (l2 == 0L) {
                if (bl) {
                    return NaN;
                }
                return SignalingNaN;
            }
            int n4 = bl ? 4 : 8;
            arrn[0] = n4 | n3;
            return EFloat.CreateWithFlags(EInteger.FromInt64(l2), EInteger.FromInt32(0), arrn[0]);
        }
        arrn[1] = 1048575 & arrn[1];
        if (n2 == 0) {
            ++n2;
        } else {
            arrn[1] = 1048576 | arrn[1];
        }
        if ((arrn[1] | arrn[0]) != 0) {
            int n5 = n2 + NumberUtility.ShiftAwayTrailingZerosTwoElements(arrn);
            return EFloat.CreateWithFlags(EInteger.FromInt64(0xFFFFFFFFL & (long)arrn[0] | (long)arrn[1] << 32), EInteger.FromInt64(n5 - 1075), n3);
        }
        if (n3 != 0) {
            return NegativeZero;
        }
        return Zero;
    }

    public static EFloat FromEInteger(EInteger eInteger) {
        return EFloat.Create(eInteger, EInteger.FromInt32(0));
    }

    public EFloat Divide(EFloat eFloat, EContext eContext) {
        return MathValue.Divide(this, eFloat, eContext);
    }

    public boolean IsInfinity() {
        return (2 & this.flags) != 0;
    }

    public boolean IsNaN() {
        return (12 & this.flags) != 0;
    }

    public boolean IsQuietNaN() {
        return (4 & this.flags) != 0;
    }

    public boolean IsSignalingNaN() {
        return (8 & this.flags) != 0;
    }

    public EFloat RoundToPrecision(EContext eContext) {
        return MathValue.RoundToPrecision(this, eContext);
    }

    public double ToDouble() {
        boolean bl;
        int n2 = 3 & this.flags;
        boolean bl2 = n2 == 2;
        if (bl2) {
            return Double.POSITIVE_INFINITY;
        }
        boolean bl3 = n2 == 3;
        if (bl3) {
            return Double.NEGATIVE_INFINITY;
        }
        if (this.IsNaN()) {
            int[] arrn = new int[]{0, 2146435072};
            if (this.isNegative()) {
                arrn[1] = Integer.MIN_VALUE | arrn[1];
            }
            if (this.IsQuietNaN()) {
                arrn[1] = 524288 | arrn[1];
            } else if (this.unsignedMantissa.isZero()) {
                arrn[1] = 262144 | arrn[1];
            }
            if (!this.unsignedMantissa.isZero()) {
                FastInteger.MutableNumber mutableNumber = FastInteger.MutableNumber.FromEInteger(this.unsignedMantissa);
                int[] arrn2 = new int[2];
                System.arraycopy((Object)mutableNumber.data, (int)0, (Object)arrn2, (int)0, (int)Math.min((int)2, (int)mutableNumber.wordCount));
                arrn[0] = arrn2[0];
                arrn[1] = arrn[1] | 524287 & arrn2[1];
                if ((arrn2[0] | 524287 & arrn2[1]) == 0 && !this.IsQuietNaN()) {
                    arrn[1] = 262144 | arrn[1];
                }
            }
            return R.style.IntegersToDouble((int[])arrn);
        }
        EFloat eFloat = this.RoundToPrecision(EContext.Binary64);
        if (!eFloat.isFinite()) {
            return eFloat.ToDouble();
        }
        EInteger eInteger = eFloat.unsignedMantissa;
        if (eFloat.isNegative() && eInteger.isZero()) {
            return R.style.IntegersToDouble((int[])new int[]{0, Integer.MIN_VALUE});
        }
        if (eInteger.isZero()) {
            return 0.0;
        }
        EInteger eInteger2 = eInteger.GetUnsignedBitLengthAsEInteger();
        int n3 = eFloat.exponent.ToInt32Checked();
        if (eInteger2.compareTo(53) < 0) {
            int n4 = 53 - eInteger2.ToInt32Checked();
            if ((n3 -= n4) < -1074) {
                n4 -= -1074 - n3;
                n3 = -1074;
                bl = true;
            } else {
                bl = false;
            }
            eInteger = eInteger.ShiftLeft(n4);
            eInteger2.Add(n4);
        } else {
            bl = false;
        }
        FastInteger.MutableNumber mutableNumber = FastInteger.MutableNumber.FromEInteger(eInteger);
        int[] arrn = new int[2];
        System.arraycopy((Object)mutableNumber.data, (int)0, (Object)arrn, (int)0, (int)Math.min((int)2, (int)mutableNumber.wordCount));
        arrn[1] = 1048575 & arrn[1];
        if (!bl) {
            arrn[1] = n3 + 1075 << 20 | arrn[1];
        }
        if (this.isNegative()) {
            arrn[1] = Integer.MIN_VALUE | arrn[1];
        }
        return R.style.IntegersToDouble((int[])arrn);
    }

    public EInteger ToEInteger() {
        if (this.isFinite()) {
            EInteger eInteger;
            if (this.isZero()) {
                return EInteger.FromInt32(0);
            }
            int n2 = this.exponent.signum();
            if (n2 == 0) {
                return this.getMantissa();
            }
            if (n2 > 0) {
                EInteger eInteger2 = this.exponent;
                EInteger eInteger3 = this.getMantissa();
                if (eInteger3.isZero()) {
                    return eInteger3;
                }
                int n3 = eInteger3.signum();
                boolean bl = false;
                if (n3 < 0) {
                    bl = true;
                }
                if (bl) {
                    eInteger3 = eInteger3.Negate();
                }
                eInteger = eInteger3.ShiftLeft(eInteger2);
                if (bl) {
                    return eInteger.Negate();
                }
            } else {
                FastInteger fastInteger = FastInteger.FromBig(this.exponent);
                fastInteger.Negate();
                BitShiftAccumulator bitShiftAccumulator = new BitShiftAccumulator(this.unsignedMantissa, 0, 0);
                bitShiftAccumulator.ShiftRight(fastInteger);
                eInteger = bitShiftAccumulator.getShiftedInt();
                if (this.isNegative()) {
                    eInteger = eInteger.Negate();
                }
            }
            return eInteger;
        }
        throw new ArithmeticException("Value is infinity or NaN");
    }

    public int compareTo(EFloat eFloat) {
        return MathValue.compareTo(this, eFloat);
    }

    public boolean equals(Object object) {
        EFloat eFloat = object instanceof EFloat ? (EFloat)object : null;
        if (eFloat == null) {
            return false;
        }
        boolean bl = this.exponent.equals(eFloat.exponent);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = this.unsignedMantissa.equals(eFloat.unsignedMantissa);
            bl2 = false;
            if (bl3) {
                int n2 = this.flags;
                int n3 = eFloat.flags;
                bl2 = false;
                if (n2 == n3) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    public final EInteger getMantissa() {
        if (this.isNegative()) {
            return this.unsignedMantissa.Negate();
        }
        return this.unsignedMantissa;
    }

    public int hashCode() {
        return 403796923 + 403797019 * this.exponent.hashCode() + 403797059 * this.unsignedMantissa.hashCode() + 403797127 * this.flags;
    }

    public final boolean isFinite() {
        return (14 & this.flags) == 0;
    }

    public final boolean isNegative() {
        return (1 & this.flags) != 0;
    }

    public final boolean isZero() {
        return (14 & this.flags) == 0 && this.unsignedMantissa.isZero();
    }

    public final int signum() {
        int n2 = 14 & this.flags;
        int n3 = 1;
        if (n2 == 0 && this.unsignedMantissa.isZero()) {
            return 0;
        }
        if ((n3 & this.flags) != 0) {
            n3 = -1;
        }
        return n3;
    }

    public String toString() {
        return EDecimal.FromEFloat(this).toString();
    }

}

