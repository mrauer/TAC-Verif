/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.upokecenter.numbers.EInteger
 *  com.upokecenter.numbers.ERounding
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package com.upokecenter.numbers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ERounding;
import java.util.Objects;

public final class EContext {
    public static final EContext Binary128;
    public static final EContext Binary32;
    public static final EContext Binary64;
    public static final EContext Decimal128;
    public static final EContext ForRoundingDown;
    public static final EContext ForRoundingHalfEven;
    public static final EContext UnlimitedHalfEven;
    public final boolean adjustExponent;
    public final EInteger bigintPrecision;
    public final boolean clampNormalExponents;
    public final EInteger exponentMax;
    public final EInteger exponentMin;
    public int flags;
    public final boolean hasExponentRange;
    public final boolean hasFlags;
    public final boolean precisionInBits;
    public final ERounding rounding;
    public final boolean simplified;
    public final int traps;

    public static {
        ERounding eRounding = ERounding.HalfUp;
        EContext.ForPrecisionAndRounding(9, eRounding);
        EInteger eInteger = EInteger.FromInt32((int)0);
        EInteger eInteger2 = EInteger.FromInt32((int)0);
        EInteger eInteger3 = EInteger.FromInt32((int)0);
        Objects.requireNonNull((Object)eInteger, (String)"bigintPrecision");
        Objects.requireNonNull((Object)eInteger3, (String)"exponentMin");
        Objects.requireNonNull((Object)eInteger2, (String)"exponentMax");
        if (eInteger.signum() >= 0) {
            if (eInteger3.compareTo(eInteger2) <= 0) {
                EContext eContext = new EContext(true, eInteger, true, eInteger2, eInteger3, 0, true, false, false, eRounding, false, 0);
                EInteger eInteger4 = eContext.bigintPrecision;
                boolean bl = eContext.clampNormalExponents;
                EInteger eInteger5 = eContext.exponentMax;
                EInteger eInteger6 = eContext.exponentMin;
                int n2 = eContext.flags;
                boolean bl2 = eContext.hasFlags;
                boolean bl3 = eContext.precisionInBits;
                ERounding eRounding2 = eContext.rounding;
                boolean bl4 = eContext.simplified;
                int n3 = eContext.traps;
                Objects.requireNonNull((Object)eInteger4, (String)"bigintPrecision");
                Objects.requireNonNull((Object)eInteger6, (String)"exponentMin");
                Objects.requireNonNull((Object)eInteger5, (String)"exponentMax");
                if (eInteger4.signum() >= 0) {
                    if (eInteger6.compareTo(eInteger5) <= 0) {
                        EInteger eInteger7 = EInteger.FromInt32((int)0).Subtract(EInteger.FromInt64((long)Integer.MAX_VALUE));
                        new EContext(false, eInteger4, bl, EInteger.FromInt32((int)1).Add(EInteger.FromInt64((long)Integer.MAX_VALUE)), eInteger7, n2, true, bl2, bl3, eRounding2, bl4, n3);
                        ERounding eRounding3 = ERounding.HalfEven;
                        Binary128 = EContext.ForPrecisionAndRounding(113, eRounding3).WithExponentClamp(true).WithExponentRange(-16382, 16383);
                        EContext.ForPrecisionAndRounding(11, eRounding3).WithExponentClamp(true).WithExponentRange(-14, 15);
                        Binary32 = EContext.ForPrecisionAndRounding(24, eRounding3).WithExponentClamp(true).WithExponentRange(-126, 127);
                        Binary64 = EContext.ForPrecisionAndRounding(53, eRounding3).WithExponentClamp(true).WithExponentRange(-1022, 1023);
                        EInteger eInteger8 = EInteger.FromInt32((int)96);
                        EInteger eInteger9 = EInteger.FromInt32((int)28);
                        EInteger eInteger10 = EInteger.FromInt32((int)0);
                        Objects.requireNonNull((Object)eInteger8, (String)"bigintPrecision");
                        Objects.requireNonNull((Object)eInteger10, (String)"exponentMin");
                        Objects.requireNonNull((Object)eInteger9, (String)"exponentMax");
                        if (eInteger8.signum() >= 0) {
                            if (eInteger10.compareTo(eInteger9) <= 0) {
                                Objects.requireNonNull((Object)eInteger8, (String)"bigintPrecision");
                                Objects.requireNonNull((Object)eInteger10, (String)"exponentMin");
                                Objects.requireNonNull((Object)eInteger9, (String)"exponentMax");
                                if (eInteger8.signum() >= 0) {
                                    if (eInteger10.compareTo(eInteger9) <= 0) {
                                        EContext eContext2;
                                        Decimal128 = eContext2 = new EContext(34, eRounding3, -6143, 6144, true);
                                        EInteger eInteger11 = EInteger.FromInt32((int)7);
                                        EInteger eInteger12 = EInteger.FromInt32((int)96);
                                        EInteger eInteger13 = EInteger.FromInt32((int)-95);
                                        Objects.requireNonNull((Object)eInteger11, (String)"bigintPrecision");
                                        Objects.requireNonNull((Object)eInteger13, (String)"exponentMin");
                                        Objects.requireNonNull((Object)eInteger12, (String)"exponentMax");
                                        if (eInteger11.signum() >= 0) {
                                            if (eInteger13.compareTo(eInteger12) <= 0) {
                                                EInteger eInteger14 = EInteger.FromInt32((int)16);
                                                EInteger eInteger15 = EInteger.FromInt32((int)384);
                                                EInteger eInteger16 = EInteger.FromInt32((int)-383);
                                                Objects.requireNonNull((Object)eInteger14, (String)"bigintPrecision");
                                                Objects.requireNonNull((Object)eInteger16, (String)"exponentMin");
                                                Objects.requireNonNull((Object)eInteger15, (String)"exponentMax");
                                                if (eInteger14.signum() >= 0) {
                                                    if (eInteger16.compareTo(eInteger15) <= 0) {
                                                        EContext.ForPrecision(0);
                                                        UnlimitedHalfEven = EContext.ForPrecision(0).WithRounding(eRounding3);
                                                        EInteger eInteger17 = EInteger.FromInt32((int)0);
                                                        EInteger eInteger18 = EInteger.FromInt32((int)0);
                                                        EInteger eInteger19 = EInteger.FromInt32((int)0);
                                                        Objects.requireNonNull((Object)eInteger17, (String)"bigintPrecision");
                                                        Objects.requireNonNull((Object)eInteger19, (String)"exponentMin");
                                                        Objects.requireNonNull((Object)eInteger18, (String)"exponentMax");
                                                        if (eInteger17.signum() >= 0) {
                                                            if (eInteger19.compareTo(eInteger18) <= 0) {
                                                                EContext eContext3;
                                                                ForRoundingHalfEven = eContext3 = new EContext(true, eInteger17, false, eInteger18, eInteger19, 0, false, false, false, eRounding3, false, 0);
                                                                ERounding eRounding4 = ERounding.Down;
                                                                EInteger eInteger20 = EInteger.FromInt32((int)0);
                                                                EInteger eInteger21 = EInteger.FromInt32((int)0);
                                                                EInteger eInteger22 = EInteger.FromInt32((int)0);
                                                                Objects.requireNonNull((Object)eInteger20, (String)"bigintPrecision");
                                                                Objects.requireNonNull((Object)eInteger22, (String)"exponentMin");
                                                                Objects.requireNonNull((Object)eInteger21, (String)"exponentMax");
                                                                if (eInteger20.signum() >= 0) {
                                                                    if (eInteger22.compareTo(eInteger21) <= 0) {
                                                                        EContext eContext4;
                                                                        ForRoundingDown = eContext4 = new EContext(true, eInteger20, false, eInteger21, eInteger22, 0, false, false, false, eRounding4, false, 0);
                                                                        return;
                                                                    }
                                                                    StringBuilder stringBuilder = new StringBuilder();
                                                                    stringBuilder.append("exponentMinSmall (");
                                                                    stringBuilder.append((Object)eInteger22);
                                                                    stringBuilder.append(") is more than ");
                                                                    stringBuilder.append((Object)eInteger21);
                                                                    throw new IllegalArgumentException(stringBuilder.toString());
                                                                }
                                                                StringBuilder stringBuilder = new StringBuilder();
                                                                stringBuilder.append("precision (");
                                                                stringBuilder.append((Object)eInteger20);
                                                                stringBuilder.append(") is less than 0");
                                                                throw new IllegalArgumentException(stringBuilder.toString());
                                                            }
                                                            StringBuilder stringBuilder = new StringBuilder();
                                                            stringBuilder.append("exponentMinSmall (");
                                                            stringBuilder.append((Object)eInteger19);
                                                            stringBuilder.append(") is more than ");
                                                            stringBuilder.append((Object)eInteger18);
                                                            throw new IllegalArgumentException(stringBuilder.toString());
                                                        }
                                                        StringBuilder stringBuilder = new StringBuilder();
                                                        stringBuilder.append("precision (");
                                                        stringBuilder.append((Object)eInteger17);
                                                        stringBuilder.append(") is less than 0");
                                                        throw new IllegalArgumentException(stringBuilder.toString());
                                                    }
                                                    StringBuilder stringBuilder = new StringBuilder();
                                                    stringBuilder.append("exponentMinSmall (");
                                                    stringBuilder.append((Object)eInteger16);
                                                    stringBuilder.append(") is more than ");
                                                    stringBuilder.append((Object)eInteger15);
                                                    throw new IllegalArgumentException(stringBuilder.toString());
                                                }
                                                StringBuilder stringBuilder = new StringBuilder();
                                                stringBuilder.append("precision (");
                                                stringBuilder.append((Object)eInteger14);
                                                stringBuilder.append(") is less than 0");
                                                throw new IllegalArgumentException(stringBuilder.toString());
                                            }
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("exponentMinSmall (");
                                            stringBuilder.append((Object)eInteger13);
                                            stringBuilder.append(") is more than ");
                                            stringBuilder.append((Object)eInteger12);
                                            throw new IllegalArgumentException(stringBuilder.toString());
                                        }
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("precision (");
                                        stringBuilder.append((Object)eInteger11);
                                        stringBuilder.append(") is less than 0");
                                        throw new IllegalArgumentException(stringBuilder.toString());
                                    }
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("exponentMinSmall (");
                                    stringBuilder.append((Object)eInteger10);
                                    stringBuilder.append(") is more than ");
                                    stringBuilder.append((Object)eInteger9);
                                    throw new IllegalArgumentException(stringBuilder.toString());
                                }
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("precision (");
                                stringBuilder.append((Object)eInteger8);
                                stringBuilder.append(") is less than 0");
                                throw new IllegalArgumentException(stringBuilder.toString());
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("exponentMinSmall (");
                            stringBuilder.append((Object)eInteger10);
                            stringBuilder.append(") is more than ");
                            stringBuilder.append((Object)eInteger9);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("precision (");
                        stringBuilder.append((Object)eInteger8);
                        stringBuilder.append(") is less than 0");
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("exponentMinSmall (");
                    stringBuilder.append((Object)eInteger6);
                    stringBuilder.append(") is more than ");
                    stringBuilder.append((Object)eInteger5);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("precision (");
                stringBuilder.append((Object)eInteger4);
                stringBuilder.append(") is less than 0");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("exponentMinSmall (");
            stringBuilder.append((Object)eInteger3);
            stringBuilder.append(") is more than ");
            stringBuilder.append((Object)eInteger2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("precision (");
        stringBuilder.append((Object)eInteger);
        stringBuilder.append(") is less than 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public EContext(int n2, ERounding eRounding, int n3, int n4, boolean bl) {
        this(true, EInteger.FromInt32((int)n2), bl, EInteger.FromInt32((int)n4), EInteger.FromInt32((int)n3), 0, true, false, false, eRounding, false, 0);
    }

    public EContext(boolean bl, EInteger eInteger, boolean bl2, EInteger eInteger2, EInteger eInteger3, int n2, boolean bl3, boolean bl4, boolean bl5, ERounding eRounding, boolean bl6, int n3) {
        Objects.requireNonNull((Object)eInteger, (String)"bigintPrecision");
        Objects.requireNonNull((Object)eInteger3, (String)"exponentMin");
        Objects.requireNonNull((Object)eInteger2, (String)"exponentMax");
        if (eInteger.signum() >= 0) {
            if (eInteger3.compareTo(eInteger2) <= 0) {
                this.adjustExponent = bl;
                this.bigintPrecision = eInteger;
                this.clampNormalExponents = bl2;
                this.exponentMax = eInteger2;
                this.exponentMin = eInteger3;
                this.flags = n2;
                this.hasExponentRange = bl3;
                this.hasFlags = bl4;
                this.precisionInBits = bl5;
                this.rounding = eRounding;
                this.simplified = bl6;
                this.traps = n3;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("exponentMinSmall (");
            stringBuilder.append((Object)eInteger3);
            stringBuilder.append(") is more than ");
            stringBuilder.append((Object)eInteger2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("precision (");
        stringBuilder.append((Object)eInteger);
        stringBuilder.append(") is less than 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static EContext ForPrecision(int n2) {
        ERounding eRounding = ERounding.HalfUp;
        EInteger eInteger = EInteger.FromInt32((int)n2);
        EInteger eInteger2 = EInteger.FromInt32((int)0);
        EInteger eInteger3 = EInteger.FromInt32((int)0);
        Objects.requireNonNull((Object)eInteger, (String)"bigintPrecision");
        Objects.requireNonNull((Object)eInteger3, (String)"exponentMin");
        Objects.requireNonNull((Object)eInteger2, (String)"exponentMax");
        if (eInteger.signum() >= 0) {
            if (eInteger3.compareTo(eInteger2) <= 0) {
                EContext eContext = new EContext(true, eInteger, false, eInteger2, eInteger3, 0, false, false, false, eRounding, false, 0);
                return eContext;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("exponentMinSmall (");
            stringBuilder.append((Object)eInteger3);
            stringBuilder.append(") is more than ");
            stringBuilder.append((Object)eInteger2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("precision (");
        stringBuilder.append((Object)eInteger);
        stringBuilder.append(") is less than 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static EContext ForPrecisionAndRounding(int n2, ERounding eRounding) {
        EInteger eInteger = EInteger.FromInt32((int)n2);
        EInteger eInteger2 = EInteger.FromInt32((int)0);
        EInteger eInteger3 = EInteger.FromInt32((int)0);
        Objects.requireNonNull((Object)eInteger, (String)"bigintPrecision");
        Objects.requireNonNull((Object)eInteger3, (String)"exponentMin");
        Objects.requireNonNull((Object)eInteger2, (String)"exponentMax");
        if (eInteger.signum() >= 0) {
            if (eInteger3.compareTo(eInteger2) <= 0) {
                EContext eContext = new EContext(true, eInteger, false, eInteger2, eInteger3, 0, false, false, false, eRounding, false, 0);
                return eContext;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("exponentMinSmall (");
            stringBuilder.append((Object)eInteger3);
            stringBuilder.append(") is more than ");
            stringBuilder.append((Object)eInteger2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("precision (");
        stringBuilder.append((Object)eInteger);
        stringBuilder.append(") is less than 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static EContext ForRounding(ERounding eRounding) {
        if (eRounding == ERounding.HalfEven) {
            return ForRoundingHalfEven;
        }
        if (eRounding == ERounding.Down) {
            return ForRoundingDown;
        }
        EInteger eInteger = EInteger.FromInt32((int)0);
        EInteger eInteger2 = EInteger.FromInt32((int)0);
        EInteger eInteger3 = EInteger.FromInt32((int)0);
        Objects.requireNonNull((Object)eInteger, (String)"bigintPrecision");
        Objects.requireNonNull((Object)eInteger3, (String)"exponentMin");
        Objects.requireNonNull((Object)eInteger2, (String)"exponentMax");
        if (eInteger.signum() >= 0) {
            if (eInteger3.compareTo(eInteger2) <= 0) {
                EContext eContext = new EContext(true, eInteger, false, eInteger2, eInteger3, 0, false, false, false, eRounding, false, 0);
                return eContext;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("exponentMinSmall (");
            stringBuilder.append((Object)eInteger3);
            stringBuilder.append(") is more than ");
            stringBuilder.append((Object)eInteger2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("precision (");
        stringBuilder.append((Object)eInteger);
        stringBuilder.append(") is less than 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public EContext Copy() {
        EContext eContext = new EContext(this.adjustExponent, this.bigintPrecision, this.clampNormalExponents, this.exponentMax, this.exponentMin, this.flags, this.hasExponentRange, this.hasFlags, this.precisionInBits, this.rounding, this.simplified, this.traps);
        return eContext;
    }

    public boolean ExponentWithinRange(EInteger eInteger) {
        Objects.requireNonNull((Object)eInteger, (String)"exponent");
        if (!this.hasExponentRange) {
            return true;
        }
        if (this.bigintPrecision.isZero()) {
            return eInteger.compareTo(this.getEMax()) <= 0;
        }
        EInteger eInteger2 = this.adjustExponent ? eInteger.Add(this.bigintPrecision).Subtract(EInteger.FromInt32((int)1)) : eInteger;
        return eInteger2.compareTo(this.getEMin()) >= 0 && eInteger.compareTo(this.getEMax()) <= 0;
    }

    public EContext WithBigExponentRange(EInteger eInteger, EInteger eInteger2) {
        EContext eContext = new EContext(this.adjustExponent, this.bigintPrecision, this.clampNormalExponents, eInteger2, eInteger, this.flags, true, this.hasFlags, this.precisionInBits, this.rounding, this.simplified, this.traps);
        return eContext;
    }

    public EContext WithBigPrecision(EInteger eInteger) {
        EContext eContext = new EContext(this.adjustExponent, eInteger, this.clampNormalExponents, this.exponentMax, this.exponentMin, this.flags, this.hasExponentRange, this.hasFlags, this.precisionInBits, this.rounding, this.simplified, this.traps);
        return eContext;
    }

    public EContext WithBlankFlags() {
        EContext eContext = new EContext(this.adjustExponent, this.bigintPrecision, this.clampNormalExponents, this.exponentMax, this.exponentMin, 0, this.hasExponentRange, true, this.precisionInBits, this.rounding, this.simplified, this.traps);
        return eContext;
    }

    public EContext WithExponentClamp(boolean bl) {
        EContext eContext = new EContext(this.adjustExponent, this.bigintPrecision, bl, this.exponentMax, this.exponentMin, this.flags, this.hasExponentRange, this.hasFlags, this.precisionInBits, this.rounding, this.simplified, this.traps);
        return eContext;
    }

    public EContext WithExponentRange(int n2, int n3) {
        return this.WithBigExponentRange(EInteger.FromInt32((int)n2), EInteger.FromInt32((int)n3));
    }

    public EContext WithRounding(ERounding eRounding) {
        EContext eContext = new EContext(this.adjustExponent, this.bigintPrecision, this.clampNormalExponents, this.exponentMax, this.exponentMin, this.flags, this.hasExponentRange, this.hasFlags, this.precisionInBits, eRounding, this.simplified, this.traps);
        return eContext;
    }

    public EContext WithUnlimitedExponents() {
        EContext eContext = new EContext(this.adjustExponent, this.bigintPrecision, this.clampNormalExponents, this.exponentMax, this.exponentMin, this.flags, false, this.hasFlags, this.precisionInBits, this.rounding, this.simplified, this.traps);
        return eContext;
    }

    public final boolean getClampNormalExponents() {
        return this.hasExponentRange && this.clampNormalExponents;
    }

    public final EInteger getEMax() {
        if (this.hasExponentRange) {
            return this.exponentMax;
        }
        return EInteger.FromInt32((int)0);
    }

    public final EInteger getEMin() {
        if (this.hasExponentRange) {
            return this.exponentMin;
        }
        return EInteger.FromInt32((int)0);
    }

    public final boolean getHasMaxPrecision() {
        return true ^ this.bigintPrecision.isZero();
    }

    public final void setFlags(int n2) {
        if (this.hasFlags) {
            this.flags = n2;
            return;
        }
        throw new IllegalStateException("Can't set flags");
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"[PrecisionContext ExponentMax=");
        stringBuilder.append((Object)this.exponentMax);
        stringBuilder.append(", Traps=");
        stringBuilder.append(this.traps);
        stringBuilder.append(", ExponentMin=");
        stringBuilder.append((Object)this.exponentMin);
        stringBuilder.append(", HasExponentRange=");
        stringBuilder.append(this.hasExponentRange);
        stringBuilder.append(", BigintPrecision=");
        stringBuilder.append((Object)this.bigintPrecision);
        stringBuilder.append(", Rounding=");
        stringBuilder.append((Object)this.rounding);
        stringBuilder.append(", ClampNormalExponents=");
        stringBuilder.append(this.clampNormalExponents);
        stringBuilder.append(", Flags=");
        stringBuilder.append(this.flags);
        stringBuilder.append(", HasFlags=");
        stringBuilder.append(this.hasFlags);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

