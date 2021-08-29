/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ArithmeticException
 *  java.lang.Object
 *  java.lang.String
 */
package com.upokecenter.numbers;

import com.upokecenter.numbers.EContext;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ERounding;
import com.upokecenter.numbers.FastInteger;
import com.upokecenter.numbers.IRadixMath;
import com.upokecenter.numbers.IRadixMathHelper;
import com.upokecenter.numbers.NumberUtility;

public final class SimpleRadixMath<T>
implements IRadixMath<T> {
    public final IRadixMath<T> wrapper;

    public SimpleRadixMath(IRadixMath<T> iRadixMath) {
        this.wrapper = iRadixMath;
    }

    public static EContext GetContextWithFlags(EContext eContext) {
        if (eContext == null) {
            return eContext;
        }
        return eContext.WithBlankFlags();
    }

    @Override
    public T Abs(T t2, EContext eContext) {
        T t3 = this.HandleNotANumber(t2, t2, eContext);
        if (t3 != null) {
            return t3;
        }
        EContext eContext2 = SimpleRadixMath.GetContextWithFlags(eContext);
        T t4 = this.RoundBeforeOp(t2, eContext2);
        return this.PostProcess(this.wrapper.Abs(t4, eContext2), eContext, eContext2);
    }

    @Override
    public T Add(T t2, T t3, EContext eContext) {
        T t4;
        T t5 = this.HandleNotANumber(t2, t3, eContext);
        if (t5 != null) {
            return t5;
        }
        EContext eContext2 = SimpleRadixMath.GetContextWithFlags(eContext);
        T t6 = this.RoundBeforeOp(t2, eContext2);
        T t7 = this.RoundBeforeOp(t3, eContext2);
        boolean bl = this.GetHelper().GetSign(t6) == 0;
        boolean bl2 = this.GetHelper().GetSign(t7) == 0;
        if (bl) {
            if (bl2) {
                t7 = this.wrapper.RoundToPrecision(this.GetHelper().ValueOf(0), eContext2);
            }
            t4 = this.RoundToPrecision(t7, eContext2);
        } else {
            t4 = !bl2 ? this.wrapper.AddEx(t6, t7, eContext2, true) : this.RoundToPrecision(t6, eContext2);
        }
        return this.PostProcess(t4, eContext, eContext2);
    }

    @Override
    public T AddEx(T t2, T t3, EContext eContext, boolean bl) {
        return this.Add(t2, t3, eContext);
    }

    @Override
    public T Divide(T t2, T t3, EContext eContext) {
        T t4 = this.HandleNotANumber(t2, t3, eContext);
        if (t4 != null) {
            return t4;
        }
        EContext eContext2 = SimpleRadixMath.GetContextWithFlags(eContext);
        T t5 = this.RoundBeforeOp(t2, eContext2);
        T t6 = this.RoundBeforeOp(t3, eContext2);
        return this.PostProcessEx(this.wrapper.Divide(t5, t6, eContext2), eContext, eContext2, true, false);
    }

    @Override
    public IRadixMathHelper<T> GetHelper() {
        return this.wrapper.GetHelper();
    }

    public final T HandleNotANumber(T t2, T t3, EContext eContext) {
        int n2 = this.GetHelper().GetFlags(t2);
        int n3 = this.GetHelper().GetFlags(t3);
        if ((n2 & 8) != 0) {
            if (eContext != null && eContext.hasFlags) {
                eContext.setFlags(64 | eContext.flags);
            }
            return this.ReturnQuietNaN(t2, eContext);
        }
        if ((n3 & 8) != 0) {
            if (eContext != null && eContext.hasFlags) {
                eContext.setFlags(64 | eContext.flags);
            }
            return this.ReturnQuietNaN(t3, eContext);
        }
        if ((n2 & 4) != 0) {
            return this.ReturnQuietNaN(t2, eContext);
        }
        if ((n3 & 4) != 0) {
            return this.ReturnQuietNaN(t3, eContext);
        }
        return null;
    }

    @Override
    public T Multiply(T t2, T t3, EContext eContext) {
        T t4 = this.HandleNotANumber(t2, t3, eContext);
        if (t4 != null) {
            return t4;
        }
        EContext eContext2 = SimpleRadixMath.GetContextWithFlags(eContext);
        T t5 = this.RoundBeforeOp(t2, eContext2);
        T t6 = this.RoundBeforeOp(t3, eContext2);
        return this.PostProcess(this.wrapper.Multiply(t5, t6, eContext2), eContext, eContext2);
    }

    @Override
    public T NextPlus(T t2, EContext eContext) {
        T t3 = this.HandleNotANumber(t2, t2, eContext);
        if (t3 != null) {
            return t3;
        }
        EContext eContext2 = SimpleRadixMath.GetContextWithFlags(eContext);
        T t4 = this.RoundBeforeOp(t2, eContext2);
        return this.PostProcess(this.wrapper.NextPlus(t4, eContext2), eContext, eContext2);
    }

    public final T PostProcess(T t2, EContext eContext, EContext eContext2) {
        return this.PostProcessEx(t2, eContext, eContext2, false, false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final T PostProcessEx(T t2, EContext eContext, EContext eContext2, boolean bl, boolean bl2) {
        int n2 = this.GetHelper().GetFlags(t2);
        if (eContext != null && eContext2 != null && eContext.hasFlags) {
            if (!eContext2.getClampNormalExponents()) {
                eContext2.setFlags(-33 & eContext2.flags);
            }
            eContext.setFlags(eContext.flags | eContext2.flags);
            if ((4 & eContext2.flags) != 0) {
                eContext.setFlags(15 | eContext.flags);
            }
        }
        if ((n2 & 14) != 0) {
            if (eContext.flags != 0) return t2;
            t2 = this.SignalInvalid(eContext);
            return t2;
        }
        EInteger eInteger = this.GetHelper().GetMantissa(t2).Abs();
        if (eInteger.isZero()) {
            if (!bl2) return this.wrapper.RoundToPrecision(this.GetHelper().ValueOf(0), eContext);
            return this.GetHelper().CreateNewWithFlags(eInteger, this.GetHelper().GetExponent(t2), 0);
        }
        if (bl2) {
            return t2;
        }
        EInteger eInteger2 = this.GetHelper().GetExponent(t2);
        if (eInteger2.signum() > 0) {
            FastInteger fastInteger = FastInteger.FromBig(eInteger2);
            if (eContext != null && eContext.getHasMaxPrecision()) {
                if (!eContext.ExponentWithinRange(eInteger2)) {
                    return t2;
                }
                FastInteger fastInteger2 = FastInteger.FromBig(eContext.bigintPrecision);
                fastInteger2.Subtract(this.GetHelper().GetDigitLength(eInteger));
                if (fastInteger2.signum() > 0 && fastInteger2.compareTo(fastInteger) >= 0) {
                    EInteger eInteger3 = this.GetHelper().MultiplyByRadixPower(eInteger, fastInteger);
                    return this.GetHelper().CreateNewWithFlags(eInteger3, EInteger.FromInt32(0), n2);
                }
                if (!bl) return t2;
                EInteger eInteger4 = NumberUtility.ReduceTrailingZeros(eInteger, fastInteger, this.GetHelper().GetRadix(), null, null, null);
                return this.GetHelper().CreateNewWithFlags(eInteger4, fastInteger.AsEInteger(), n2);
            }
            EInteger eInteger5 = this.GetHelper().MultiplyByRadixPower(eInteger, fastInteger);
            return this.GetHelper().CreateNewWithFlags(eInteger5, EInteger.FromInt32(0), n2);
        }
        if (!bl || eInteger2.signum() >= 0) return t2;
        FastInteger fastInteger = FastInteger.FromBig(eInteger2);
        EInteger eInteger6 = NumberUtility.ReduceTrailingZeros(eInteger, fastInteger, this.GetHelper().GetRadix(), null, null, new FastInteger(0));
        t2 = this.GetHelper().CreateNewWithFlags(eInteger6, fastInteger.AsEInteger(), n2);
        return t2;
    }

    @Override
    public T Quantize(T t2, T t3, EContext eContext) {
        T t4 = this.HandleNotANumber(t2, t2, eContext);
        if (t4 != null) {
            return t4;
        }
        EContext eContext2 = SimpleRadixMath.GetContextWithFlags(eContext);
        T t5 = this.RoundBeforeOp(t2, eContext2);
        T t6 = this.RoundBeforeOp(t3, eContext2);
        EContext eContext3 = eContext2 == null ? null : eContext2.WithBlankFlags();
        this.wrapper.RoundToPrecision(t6, eContext3);
        if (eContext3 != null && (4 & eContext3.flags) != 0) {
            return this.SignalInvalid(eContext);
        }
        return this.PostProcessEx(this.wrapper.Quantize(t5, t6, eContext2), eContext, eContext2, false, true);
    }

    public final T ReturnQuietNaN(T t2, EContext eContext) {
        boolean bl;
        EInteger eInteger;
        EInteger eInteger2 = this.GetHelper().GetMantissa(t2).Abs();
        if (!eInteger2.isZero() && eContext != null && eContext.getHasMaxPrecision() && eInteger2.compareTo(eInteger = this.GetHelper().MultiplyByRadixPower(EInteger.FromInt32(1), FastInteger.FromBig(eContext.bigintPrecision))) >= 0) {
            eInteger2 = eInteger2.Remainder(eInteger);
            bl = true;
        } else {
            bl = false;
        }
        int n2 = this.GetHelper().GetFlags(t2);
        if (!bl && (n2 & 4) != 0) {
            return t2;
        }
        int n3 = 4 | n2 & 1;
        return this.GetHelper().CreateNewWithFlags(eInteger2, EInteger.FromInt32(0), n3);
    }

    public final T RoundBeforeOp(T t2, EContext eContext) {
        if (eContext != null && eContext.getHasMaxPrecision()) {
            int n2 = this.GetHelper().GetFlags(t2);
            if ((n2 & 14) != 0) {
                return t2;
            }
            FastInteger fastInteger = FastInteger.FromBig(eContext.bigintPrecision);
            EInteger eInteger = this.GetHelper().GetMantissa(t2).Abs();
            FastInteger fastInteger2 = this.GetHelper().GetDigitLength(eInteger);
            EContext eContext2 = eContext.WithBlankFlags();
            EContext eContext3 = new EContext(eContext2.adjustExponent, eContext2.bigintPrecision, eContext2.clampNormalExponents, eContext2.exponentMax, eContext2.exponentMin, eContext2.flags, eContext2.hasExponentRange, true, eContext2.precisionInBits, eContext2.rounding, eContext2.simplified, 0);
            if (fastInteger2.compareTo(fastInteger) <= 0) {
                return t2;
            }
            T t3 = this.wrapper.RoundToPrecision(t2, eContext3);
            if ((1 & eContext3.flags) != 0 && eContext.hasFlags) {
                eContext.setFlags(259 | eContext.flags);
            }
            if ((2 & eContext3.flags) != 0 && eContext.hasFlags) {
                eContext.setFlags(2 | eContext.flags);
            }
            if ((16 & eContext3.flags) != 0) {
                int n3 = (n2 & 1) != 0 ? 1 : 0;
                eContext.setFlags(256 | eContext.flags);
                ERounding eRounding = eContext.rounding;
                if (eContext.hasFlags) {
                    eContext.setFlags(19 | eContext.flags);
                }
                if (eContext.getHasMaxPrecision() && eContext.hasExponentRange && (eRounding == ERounding.Down || eRounding == ERounding.ZeroFiveUp || eRounding == ERounding.OddOrZeroFiveUp || eRounding == ERounding.Odd || eRounding == ERounding.Ceiling && n3 != 0 || eRounding == ERounding.Floor && n3 == 0)) {
                    EInteger.FromInt32(0);
                    FastInteger fastInteger3 = FastInteger.FromBig(eContext.bigintPrecision);
                    EInteger eInteger2 = this.GetHelper().MultiplyByRadixPower(EInteger.FromInt32(1), fastInteger3).Subtract(EInteger.FromInt32(1));
                    FastInteger fastInteger4 = FastInteger.FromBig(eContext.getEMax()).Increment();
                    fastInteger4.Subtract(fastInteger3);
                    return this.GetHelper().CreateNewWithFlags(eInteger2, fastInteger4.AsEInteger(), n3);
                }
                if (this.GetHelper().GetArithmeticSupport() == 0) {
                    return null;
                }
                t3 = this.GetHelper().CreateNewWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), n3 | 2);
            }
            return t3;
        }
        return t2;
    }

    @Override
    public T RoundToPrecision(T t2, EContext eContext) {
        T t3 = this.HandleNotANumber(t2, t2, eContext);
        if (t3 != null) {
            return t3;
        }
        EContext eContext2 = SimpleRadixMath.GetContextWithFlags(eContext);
        T t4 = this.RoundBeforeOp(t2, eContext2);
        return this.PostProcess(this.wrapper.RoundToPrecision(t4, eContext2), eContext, eContext2);
    }

    public final T SignalInvalid(EContext eContext) {
        if (this.GetHelper().GetArithmeticSupport() != 0) {
            if (eContext != null && eContext.hasFlags) {
                eContext.setFlags(64 | eContext.flags);
            }
            return this.GetHelper().CreateNewWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), 4);
        }
        throw new ArithmeticException("Invalid operation");
    }

    @Override
    public int compareTo(T t2, T t3) {
        return this.wrapper.compareTo(t2, t3);
    }
}

