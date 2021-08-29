/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.upokecenter.numbers.DigitShiftAccumulator
 *  com.upokecenter.numbers.EDecimal$DecimalMathHelper
 *  com.upokecenter.numbers.ExtendedOrSimpleRadixMath
 *  com.upokecenter.numbers.RadixMath
 *  com.upokecenter.numbers.TrappableRadixMath
 *  java.lang.ArithmeticException
 *  java.lang.CharSequence
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.Objects
 */
package com.upokecenter.numbers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.upokecenter.numbers.DigitShiftAccumulator;
import com.upokecenter.numbers.EContext;
import com.upokecenter.numbers.EDecimal;
import com.upokecenter.numbers.EFloat;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ExtendedOrSimpleRadixMath;
import com.upokecenter.numbers.FastInteger;
import com.upokecenter.numbers.FastIntegerFixed;
import com.upokecenter.numbers.IRadixMath;
import com.upokecenter.numbers.IRadixMathHelper;
import com.upokecenter.numbers.NumberUtility;
import com.upokecenter.numbers.RadixMath;
import com.upokecenter.numbers.TrappableRadixMath;
import java.util.Objects;

/*
 * Exception performing whole class analysis.
 */
public final class EDecimal
implements Comparable<EDecimal> {
    public static final IRadixMath<EDecimal> ExtendedMathValue;
    public static final FastIntegerFixed FastIntZero;
    public static final IRadixMath<EDecimal> MathValue;
    public static final EDecimal NaN;
    public static final EDecimal NegativeInfinity;
    public static final EDecimal NegativeZero;
    public static final EDecimal One;
    public static final EDecimal PositiveInfinity;
    public static final EDecimal SignalingNaN;
    public static final int[] ValueTenPowers;
    public static final EDecimal Zero;
    public final FastIntegerFixed exponent;
    public final int flags;
    public final FastIntegerFixed unsignedMantissa;

    public static {
        NaN = EDecimal.CreateWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), 4);
        NegativeInfinity = EDecimal.CreateWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), 3);
        NegativeZero = EDecimal.CreateWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), 1);
        One = EDecimal.Create(EInteger.FromInt32(1), EInteger.FromInt32(0));
        PositiveInfinity = EDecimal.CreateWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), 2);
        SignalingNaN = EDecimal.CreateWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), 8);
        EDecimal.Create(EInteger.FromInt32(10), EInteger.FromInt32(0));
        Zero = EDecimal.Create(EInteger.FromInt32(0), EInteger.FromInt32(0));
        ExtendedMathValue = new RadixMath((IRadixMathHelper)new /* Unavailable Anonymous Inner Class!! */);
        FastIntZero = new FastIntegerFixed(0);
        MathValue = new TrappableRadixMath((IRadixMath)new ExtendedOrSimpleRadixMath((IRadixMathHelper)new /* Unavailable Anonymous Inner Class!! */));
        ValueTenPowers = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    }

    public EDecimal(FastIntegerFixed fastIntegerFixed, FastIntegerFixed fastIntegerFixed2, int n2) {
        this.unsignedMantissa = fastIntegerFixed;
        this.exponent = fastIntegerFixed2;
        this.flags = n2;
    }

    public static boolean AppendString(StringBuilder stringBuilder, char c2, FastInteger fastInteger) {
        if (fastInteger.CompareToInt(Integer.MAX_VALUE) <= 0 && fastInteger.signum() >= 0) {
            for (int i2 = fastInteger.AsInt32() - 1; i2 >= 0; --i2) {
                stringBuilder.append(c2);
            }
            return true;
        }
        throw new UnsupportedOperationException();
    }

    public static int CompareEDecimalToEFloat(EDecimal eDecimal, EFloat eFloat) {
        int n2;
        int n3 = 1;
        if (eFloat == null) {
            return n3;
        }
        if (eDecimal.IsNaN()) {
            return n3 ^ eFloat.IsNaN();
        }
        int n4 = eDecimal.signum();
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
            if (eDecimal.IsInfinity()) {
                if (eFloat.IsInfinity()) {
                    return 0;
                }
                if (eDecimal.isNegative()) {
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
            if (eFloat.exponent.compareTo(EInteger.FromInt64(-1000L)) < 0) {
                if (EFloat.MathValue.Abs(eFloat, null).compareTo(EFloat.One) < 0 && eDecimal.Abs(null).compareTo(One) >= 0) {
                    if (n4 > 0) {
                        return n3;
                    }
                    return -1;
                }
                EInteger eInteger = eFloat.getMantissa().GetUnsignedBitLengthAsEInteger();
                if (eFloat.exponent.Abs().compareTo(eInteger) > 0) {
                    int n5 = EDecimal.CompareEDecimalToEFloat(eDecimal, EFloat.Create(eFloat.getMantissa(), EInteger.FromInt32(-1000)));
                    if (eFloat.signum() < 0 && n5 < 0) {
                        return -1;
                    }
                    if (eFloat.signum() > 0 && n5 > 0) {
                        return n3;
                    }
                }
                EInteger eInteger2 = EDecimal.GetAdjustedExponent(eDecimal);
                EInteger eInteger3 = EDecimal.GetAdjustedExponentBinary(eFloat);
                if (eInteger2.signum() < 0 && eInteger2.compareTo(EInteger.FromInt64(-1000L)) >= 0 && eInteger3.compareTo(EInteger.FromInt64(-4000L)) < 0) {
                    if (n4 > 0) {
                        return n3;
                    }
                    return -1;
                }
                if (eInteger2.signum() < 0 && eInteger2.compareTo(EInteger.FromInt64(-1000L)) < 0 && eInteger3.compareTo(EInteger.FromInt64(-1000L)) < 0) {
                    EInteger eInteger4 = eInteger2.Add(EInteger.FromInt32(n3)).Abs();
                    EInteger eInteger5 = eInteger3.Add(EInteger.FromInt32(n3)).Abs().Multiply(1000).Divide(eInteger4);
                    if (eInteger5.compareTo(EInteger.FromInt64(3321L)) < 0) {
                        if (n4 > 0) {
                            n3 = -1;
                        }
                        return n3;
                    }
                    if (eInteger5.compareTo(EInteger.FromInt64(3322L)) >= 0) {
                        if (n4 > 0) {
                            return n3;
                        }
                        return -1;
                    }
                }
            }
            if (eFloat.exponent.compareTo(EInteger.FromInt64(1000L)) > 0) {
                EInteger eInteger = EInteger.FromInt32(n3).ShiftLeft(999);
                if (eDecimal.Abs(null).compareTo(EDecimal.FromEInteger(eInteger)) <= 0) {
                    if (n4 > 0) {
                        n3 = -1;
                    }
                    return n3;
                }
                EInteger eInteger6 = EDecimal.GetAdjustedExponent(eDecimal);
                EInteger eInteger7 = EDecimal.GetAdjustedExponentBinary(eFloat);
                if (eInteger6.signum() > 0 && eInteger6.compareTo(eInteger7) >= 0) {
                    if (n4 > 0) {
                        return n3;
                    }
                    return -1;
                }
                if (eInteger6.signum() > 0 && eInteger6.compareTo(1000) < 0 && eInteger7.compareTo(4000) >= 0) {
                    if (n4 > 0) {
                        n3 = -1;
                    }
                    return n3;
                }
                if (eInteger6.signum() > 0 && eInteger6.compareTo(EInteger.FromInt64(1000L)) >= 0 && eInteger7.compareTo(EInteger.FromInt64(1000L)) >= 0) {
                    EInteger eInteger8 = eInteger6.Add(EInteger.FromInt32(n3));
                    EInteger eInteger9 = eInteger7.Add(EInteger.FromInt32(n3)).Multiply(1000).Divide(eInteger8);
                    if (eInteger9.compareTo(EInteger.FromInt64(3321L)) < 0) {
                        if (n4 > 0) {
                            return n3;
                        }
                        return -1;
                    }
                    if (eInteger9.compareTo(EInteger.FromInt64(3322L)) >= 0) {
                        if (n4 > 0) {
                            n3 = -1;
                        }
                        return n3;
                    }
                }
            }
            return eDecimal.compareTo(EDecimal.FromEFloat(eFloat));
        }
        return 0;
    }

    public static EDecimal Create(EInteger eInteger, EInteger eInteger2) {
        Objects.requireNonNull((Object)eInteger, (String)"mantissa");
        Objects.requireNonNull((Object)eInteger2, (String)"exponent");
        FastIntegerFixed fastIntegerFixed = FastIntegerFixed.FromBig(eInteger);
        int n2 = fastIntegerFixed.signum();
        if (n2 < 0) {
            fastIntegerFixed = fastIntegerFixed.Negate();
        }
        FastIntegerFixed fastIntegerFixed2 = FastIntegerFixed.FromBig(eInteger2);
        int n3 = n2 < 0 ? 1 : 0;
        return new EDecimal(fastIntegerFixed, fastIntegerFixed2, n3);
    }

    public static EDecimal CreateNaN(EInteger eInteger, boolean bl, boolean bl2, EContext eContext) {
        Objects.requireNonNull((Object)eInteger, (String)"diag");
        if (eInteger.signum() >= 0) {
            if (eInteger.isZero() && !bl2) {
                if (bl) {
                    return SignalingNaN;
                }
                return NaN;
            }
            int n2 = 0;
            if (bl2) {
                n2 = 1;
            }
            int n3 = 8;
            if (eContext != null && eContext.getHasMaxPrecision()) {
                int n4 = n2 | 4;
                EDecimal eDecimal = new EDecimal(FastIntegerFixed.FromBig(eInteger), FastIntZero, n4).RoundToPrecision(eContext);
                int n5 = -5 & eDecimal.flags;
                if (!bl) {
                    n3 = 4;
                }
                int n6 = n5 | n3;
                return new EDecimal(eDecimal.unsignedMantissa, eDecimal.exponent, n6);
            }
            if (!bl) {
                n3 = 4;
            }
            int n7 = n2 | n3;
            return new EDecimal(FastIntegerFixed.FromBig(eInteger), FastIntZero, n7);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Diagnostic information must be 0 or greater, was: ");
        stringBuilder.append((Object)eInteger);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static EDecimal CreateWithFlags(EInteger eInteger, EInteger eInteger2, int n2) {
        Objects.requireNonNull((Object)eInteger, (String)"mantissa");
        Objects.requireNonNull((Object)eInteger2, (String)"exponent");
        return new EDecimal(FastIntegerFixed.FromBig(eInteger), FastIntegerFixed.FromBig(eInteger2), n2);
    }

    public static EDecimal CreateWithFlags(FastIntegerFixed fastIntegerFixed, FastIntegerFixed fastIntegerFixed2, int n2) {
        Objects.requireNonNull((Object)fastIntegerFixed, (String)"mantissa");
        Objects.requireNonNull((Object)fastIntegerFixed2, (String)"exponent");
        return new EDecimal(fastIntegerFixed, fastIntegerFixed2, n2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static EDecimal FromEFloat(EFloat var0) {
        block24 : {
            block26 : {
                block25 : {
                    Objects.requireNonNull((Object)var0, (String)"bigfloat");
                    if (var0.IsNaN() || var0.IsInfinity()) break block25;
                    var10_1 = var0.exponent;
                    var11_2 = var0.getMantissa();
                    if (var11_2.isZero()) {
                        if (var0.isNegative() == false) return EDecimal.Zero;
                        return EDecimal.NegativeZero;
                    }
                    if (var10_1.isZero()) {
                        return EDecimal.FromEInteger(var11_2);
                    }
                    if (var10_1.signum() > 0) {
                        var40_3 = FastInteger.FromBig(var10_1);
                        var41_4 = var11_2.signum();
                        var42_5 = false;
                        if (var41_4 < 0) {
                            var42_5 = true;
                        }
                        if (var42_5) {
                            var11_2 = var11_2.Negate();
                        }
                        do {
                            if (var40_3.signum() <= 0) {
                                if (var42_5 == false) return EDecimal.FromEInteger(var11_2);
                                var11_2 = var11_2.Negate();
                                return EDecimal.FromEInteger(var11_2);
                            }
                            var43_6 = 1000000;
                            if (var40_3.CompareToInt(var43_6) < 0) {
                                var43_6 = var40_3.AsInt32();
                            }
                            var11_2 = var11_2.ShiftLeft(var43_6);
                            var40_3.AddInt(-var43_6);
                        } while (true);
                    }
                    var12_7 = var10_1.Negate();
                    var14_8 = var12_7.signum();
                    if (var14_8 < 0) {
                        var26_9 = EInteger.FromInt32(0);
                        return EDecimal.Create(var11_2.Multiply(var26_9), var10_1);
                    }
                    if (var14_8 == 0) {
                        var26_9 = EInteger.FromInt32(1);
                        return EDecimal.Create(var11_2.Multiply(var26_9), var10_1);
                    }
                    var15_10 = FastInteger.FromBig(var12_7);
                    if (var15_10.CompareToInt(54) <= 0) {
                        var26_9 = NumberUtility.FindPowerOfFive(var15_10.AsInt32());
                        return EDecimal.Create(var11_2.Multiply(var26_9), var10_1);
                    }
                    var16_11 = EInteger.FromInt32(1);
                    var17_12 = NumberUtility.ValuePowerOfFiveCache;
                    Objects.requireNonNull((Object)var17_12);
                    if (!var12_7.CanFitInInt32()) break block26;
                    var22_13 = var17_12.GetCachedPowerInt(var12_7.ToInt32Checked());
                    ** GOTO lbl95
                }
                var2_31 = var0.isNegative();
                var3_32 = var0.IsInfinity() != false ? 2 : 0;
                var4_33 = var2_31 | var3_32;
                var5_34 = var0.IsQuietNaN() != false ? 4 : 0;
                var6_35 = var4_33 | var5_34;
                var7_36 = var0.IsSignalingNaN();
                var8_37 = 0;
                if (var7_36) {
                    var8_37 = 8;
                }
                var9_38 = var6_35 | var8_37;
                return EDecimal.CreateWithFlags(var0.unsignedMantissa, var0.exponent, var9_38);
            }
            var45_15 = var19_14 = var17_12.outputs;
            // MONITORENTER : var45_15
            var20_16 = 0;
            do {
                block28 : {
                    block29 : {
                        block27 : {
                            if (var20_16 >= var17_12.size) break block27;
                            if (!var12_7.equals(var17_12.inputs[var20_16])) break block28;
                            if (var20_16 != 0) {
                                var31_17 = var17_12.inputs;
                                var32_18 = var31_17[var20_16];
                                var31_17[var20_16] = var31_17[0];
                                var31_17[0] = var32_18;
                                var33_19 = var17_12.inputsInts;
                                var34_20 = var33_19[var20_16];
                                var33_19[var20_16] = var33_19[0];
                                var33_19[0] = var34_20;
                                var35_21 = var17_12.outputs;
                                var36_22 = var35_21[var20_16];
                                var35_21[var20_16] = var35_21[0];
                                var35_21[0] = var36_22;
                                if (var20_16 != 1) {
                                    var37_23 = var31_17[var20_16];
                                    var31_17[var20_16] = var31_17[1];
                                    var31_17[1] = var37_23;
                                    var38_24 = var33_19[var20_16];
                                    var33_19[var20_16] = var33_19[1];
                                    var33_19[1] = var38_24;
                                    var39_25 = var35_21[var20_16];
                                    var35_21[var20_16] = var35_21[1];
                                    var35_21[1] = var39_25;
                                }
                            }
                            var22_13 = var17_12.outputs[0];
                            // MONITOREXIT : var45_15
                            break block29;
                        }
                        // MONITOREXIT : var45_15
                        var22_13 = null;
                    }
                    if (var22_13 != null) {
                        var26_9 = var22_13;
                        return EDecimal.Create(var11_2.Multiply(var26_9), var10_1);
                    }
                    var23_26 = NumberUtility.ValuePowerOfFiveCache.FindCachedPowerOrSmaller(var12_7);
                    if (var23_26 != null) {
                        var15_10.SubtractBig(var23_26[0]);
                        var24_27 = var16_11 = var23_26[1];
                        break;
                    }
                    var24_27 = EInteger.FromInt32(0);
                    break;
                }
                ++var20_16;
            } while (true);
            while (var15_10.signum() > 0) {
                if (var15_10.CompareToInt(27) <= 0) {
                    var25_28 = var16_11.Multiply(NumberUtility.FindPowerOfFive(var15_10.AsInt32()));
                    break block24;
                }
                if (var15_10.CompareToInt(9999999) <= 0) {
                    var28_29 = var15_10.AsInt32();
                    var29_30 = var28_29 / 2;
                    var25_28 = var16_11.Multiply(NumberUtility.FindPowerOfFive(var29_30).Multiply(NumberUtility.FindPowerOfFive(var28_29 - var29_30)));
                    break block24;
                }
                if (var24_27.isZero()) {
                    var24_27 = NumberUtility.FindPowerOfFive(1).Pow(9999999);
                }
                var16_11 = var16_11.Multiply(var24_27);
                var15_10.AddInt(-9999999);
            }
            var25_28 = var16_11;
        }
        NumberUtility.ValuePowerOfFiveCache.AddPower(var12_7, var25_28);
        var26_9 = var25_28;
        return EDecimal.Create(var11_2.Multiply(var26_9), var10_1);
    }

    public static EDecimal FromEInteger(EInteger eInteger) {
        return EDecimal.Create(eInteger, EInteger.FromInt32(0));
    }

    public static EDecimal FromInt32(int n2) {
        if (n2 == 0) {
            return Zero;
        }
        if (n2 == Integer.MIN_VALUE) {
            return EDecimal.Create(EInteger.FromInt32(n2), EInteger.FromInt32(0));
        }
        if (n2 < 0) {
            return new EDecimal(new FastIntegerFixed(0, n2, null).Negate(), FastIntZero, 1);
        }
        return new EDecimal(new FastIntegerFixed(0, n2, null), FastIntZero, 0);
    }

    public static EDecimal FromInt64(long l2) {
        long l3 = l2 LCMP 0L;
        if (l3 == false) {
            return Zero;
        }
        if (l2 > Integer.MIN_VALUE && l2 <= Integer.MAX_VALUE) {
            if (l3 < 0) {
                return new EDecimal(new FastIntegerFixed((int)l2).Negate(), FastIntZero, 1);
            }
            return new EDecimal(new FastIntegerFixed((int)l2), FastIntZero, 0);
        }
        return EDecimal.Create(EInteger.FromInt64(l2), EInteger.FromInt32(0));
    }

    public static EInteger GetAdjustedExponent(EDecimal eDecimal) {
        if (!eDecimal.isFinite()) {
            return EInteger.FromInt32(0);
        }
        if (eDecimal.isZero()) {
            return EInteger.FromInt32(0);
        }
        return eDecimal.getExponent().Add(eDecimal.getUnsignedMantissa().GetDigitCountAsEInteger().Subtract(1));
    }

    public static EInteger GetAdjustedExponentBinary(EFloat eFloat) {
        if (!eFloat.isFinite()) {
            return EInteger.FromInt32(0);
        }
        if (eFloat.isZero()) {
            return EInteger.FromInt32(0);
        }
        return eFloat.exponent.Add(eFloat.unsignedMantissa.GetSignedBitLengthAsEInteger().Subtract(1));
    }

    public static IRadixMath<EDecimal> GetMathValue(EContext eContext) {
        if (eContext != null && eContext != EContext.UnlimitedHalfEven) {
            if (!eContext.simplified && eContext.traps == 0) {
                return ExtendedMathValue;
            }
            return MathValue;
        }
        return ExtendedMathValue;
    }

    public EDecimal Abs() {
        if (this.isNegative()) {
            return new EDecimal(this.unsignedMantissa, this.exponent, -2 & this.flags);
        }
        return this;
    }

    public EDecimal Abs(EContext eContext) {
        return ExtendedMathValue.Abs(this, null);
    }

    public EDecimal Divide(EDecimal eDecimal, EContext eContext) {
        return EDecimal.GetMathValue(eContext).Divide(this, eDecimal, eContext);
    }

    public boolean IsInfinity() {
        return (2 & this.flags) != 0;
    }

    public boolean IsNaN() {
        return (12 & this.flags) != 0;
    }

    public boolean IsSignalingNaN() {
        return (8 & this.flags) != 0;
    }

    public EDecimal RoundToPrecision(EContext eContext) {
        return EDecimal.GetMathValue(eContext).RoundToPrecision(this, eContext);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public EFloat ToEFloat(EContext var1_1) {
        block23 : {
            block25 : {
                block24 : {
                    block22 : {
                        block20 : {
                            block21 : {
                                block18 : {
                                    block19 : {
                                        var2_2 = var1_1;
                                        var3_3 = this.getExponent();
                                        var4_4 = this.getUnsignedMantissa();
                                        if (this.IsNaN()) {
                                            return EFloat.CreateNaN(this.getUnsignedMantissa(), this.IsSignalingNaN(), this.isNegative(), var2_2);
                                        }
                                        var5_5 = this.flags;
                                        var6_6 = (var5_5 & 3) == 2;
                                        if (var6_6) {
                                            return EFloat.PositiveInfinity.RoundToPrecision(var2_2);
                                        }
                                        var7_7 = (var5_5 & 3) == 3;
                                        if (var7_7) {
                                            return EFloat.NegativeInfinity.RoundToPrecision(var2_2);
                                        }
                                        if (var4_4.isZero()) {
                                            if (this.isNegative() == false) return EFloat.Zero.RoundToPrecision(var2_2);
                                            return EFloat.NegativeZero.RoundToPrecision(var2_2);
                                        }
                                        if (var3_3.isZero()) {
                                            return this.WithThisSign(EFloat.FromEInteger(var4_4)).RoundToPrecision(var2_2);
                                        }
                                        if (var3_3.signum() > 0) {
                                            if (var2_2 == EContext.Binary32) {
                                                if (var3_3.compareTo(39) <= 0) return this.WithThisSign(EFloat.FromEInteger(var4_4.Multiply(NumberUtility.FindPowerOfTenFromBig(var3_3)))).RoundToPrecision(var2_2);
                                                if (this.isNegative() == false) return EFloat.PositiveInfinity;
                                                return EFloat.NegativeInfinity;
                                            }
                                            if (var2_2 != EContext.Binary64) return this.WithThisSign(EFloat.FromEInteger(var4_4.Multiply(NumberUtility.FindPowerOfTenFromBig(var3_3)))).RoundToPrecision(var2_2);
                                            if (var3_3.compareTo(309) <= 0) return this.WithThisSign(EFloat.FromEInteger(var4_4.Multiply(NumberUtility.FindPowerOfTenFromBig(var3_3)))).RoundToPrecision(var2_2);
                                            if (this.isNegative() == false) return EFloat.PositiveInfinity;
                                            return EFloat.NegativeInfinity;
                                        }
                                        var8_8 = var4_4.signum() < 0;
                                        if (var8_8) {
                                            var4_4 = var4_4.Negate();
                                        }
                                        var9_9 = NumberUtility.FindPowerOfTenFromBig(var3_3.Negate());
                                        if (var2_2 == null) {
                                            var2_2 = EContext.UnlimitedHalfEven;
                                        }
                                        if (var2_2.getHasMaxPrecision()) break block18;
                                        var50_10 = var4_4.Gcd(var9_9);
                                        var51_11 = var50_10.compareTo(EInteger.FromInt32(1)) != 0 ? var9_9.Divide(var50_10) : var9_9;
                                        var52_12 = var51_11.isZero() != false || var51_11.GetUnsignedBit(0) != false && var51_11.compareTo(EInteger.FromInt32(1)) != 0 ? false : var51_11.GetUnsignedBitLengthAsEInteger().equals(var51_11.GetLowBitAsEInteger().Add(1));
                                        if (var52_12) break block19;
                                        var10_13 = var2_2.WithBigPrecision(EInteger.FromInt32(53)).WithBlankFlags();
                                        var11_14 = true;
                                        break block20;
                                    }
                                    var4_4 = var4_4.Divide(var50_10);
                                    var10_13 = var2_2;
                                    var9_9 = var51_11;
                                    break block21;
                                }
                                var10_13 = var2_2;
                            }
                            var11_14 = false;
                        }
                        var12_15 = var10_13.getHasMaxPrecision() != false ? var10_13.bigintPrecision.Add(2) : var10_13.bigintPrecision;
                        var13_16 = EInteger.FromInt32(1).ShiftLeft(var12_15);
                        var14_17 = EInteger.FromInt32(1).ShiftLeft(var12_15.Subtract(1));
                        var15_18 = var10_13.getHasMaxPrecision() != false ? var4_4.DivRem(var9_9) : null;
                        var16_19 = new FastInteger(0);
                        if (var10_13.getHasMaxPrecision()) break block22;
                        var47_20 = var9_9.GetLowBitAsEInteger();
                        var48_21 = var4_4.ShiftLeft(var47_20);
                        var16_19.SubtractBig(var47_20);
                        var15_18 = var48_21.DivRem(var9_9);
                        break block23;
                    }
                    if (var15_18[0].compareTo(var13_16) >= 0) break block24;
                    if (var15_18[0].compareTo(var14_17) >= 0) break block23;
                    break block25;
                }
                do {
                    block26 : {
                        if (!var10_13.getClampNormalExponents() || var12_15.signum() <= 0) ** GOTO lbl-1000
                        var39_26 = var4_4.GetUnsignedBitLengthAsEInteger();
                        var40_27 = var9_9.GetUnsignedBitLengthAsEInteger();
                        if (var9_9.compareTo(var4_4) >= 0) break block26;
                        if (var40_27.compareTo(var39_26) >= 0 || (var44_30 = var39_26.Subtract(var40_27)).compareTo(var12_15.Add(1)) <= 0) ** GOTO lbl-1000
                        var45_31 = var44_30.Subtract(var12_15).Subtract(1);
                        var9_9 = var9_9.ShiftLeft(var45_31);
                        var16_19.AddBig(var45_31);
                        ** GOTO lbl82
                    }
                    if (var39_26.compareTo(var40_27) >= 0 && var12_15.compareTo(EInteger.FromInt32(Integer.MAX_VALUE).Subtract(var40_27)) <= 0 && var39_26.compareTo(var41_28 = var40_27.Add(var12_15)) < 0) {
                        var42_29 = var41_28.Subtract(var39_26);
                        var9_9 = var9_9.ShiftLeft(var42_29);
                        var16_19.AddBig(var42_29);
lbl82: // 2 sources:
                        var33_22 = true;
                    } else lbl-1000: // 3 sources:
                    {
                        var33_22 = false;
                    }
                    if (!var33_22) {
                        var9_9 = var9_9.ShiftLeft(1);
                        var16_19.Increment();
                    }
                    if (!(var15_18 = var4_4.DivRem(var9_9))[1].isZero() || (var34_23 = var15_18[0].GetUnsignedBitLengthAsEInteger()).compareTo(var35_24 = var14_17.GetUnsignedBitLengthAsEInteger()) >= 0) continue;
                    var36_25 = var35_24.Subtract(var34_23);
                    var15_18[0] = var15_18[0].ShiftLeft(var36_25);
                    var16_19.AddBig(var36_25);
                } while (var15_18[0].compareTo(var13_16) >= 0);
                break block23;
            }
            do {
                block27 : {
                    if (var4_4.compareTo(var9_9) >= 0) break block27;
                    var29_40 = var4_4.GetUnsignedBitLengthAsEInteger();
                    if (var29_40.compareTo(var30_41 = var9_9.GetUnsignedBitLengthAsEInteger()) >= 0) ** GOTO lbl-1000
                    var31_42 = var30_41.Subtract(var29_40);
                    var4_4 = var4_4.ShiftLeft(var31_42);
                    var16_19.SubtractBig(var31_42);
                    ** GOTO lbl108
                }
                if (var10_13.getClampNormalExponents() && var12_15.signum() > 0 && (var24_36 = var4_4.GetUnsignedBitLengthAsEInteger()).compareTo(var25_37 = var9_9.GetUnsignedBitLengthAsEInteger()) >= 0 && var12_15.compareTo(EInteger.FromInt32(Integer.MAX_VALUE).Subtract(var25_37)) <= 0 && var24_36.compareTo(var26_38 = var25_37.Add(var12_15)) < 0) {
                    var27_39 = var26_38.Subtract(var24_36);
                    var4_4 = var4_4.ShiftLeft(var27_39);
                    var16_19.SubtractBig(var27_39);
lbl108: // 2 sources:
                    var18_32 = true;
                } else lbl-1000: // 2 sources:
                {
                    var18_32 = false;
                }
                if (!var18_32) {
                    var4_4 = var4_4.ShiftLeft(1);
                    var16_19.Decrement();
                }
                if (!(var15_18 = var4_4.DivRem(var9_9))[1].isZero() || (var19_33 = var15_18[0].GetUnsignedBitLengthAsEInteger()).compareTo(var20_34 = var14_17.GetUnsignedBitLengthAsEInteger()) >= 0) continue;
                var21_35 = var20_34.Subtract(var19_33);
                var15_18[0] = var15_18[0].ShiftLeft(var21_35);
                var16_19.SubtractBig(var21_35);
            } while (var15_18[0].compareTo(var14_17) < 0);
        }
        if (!var15_18[1].isZero() && var15_18[0].isEven()) {
            var15_18[0] = var15_18[0].Add(EInteger.FromInt32(1));
        }
        var17_43 = this.WithThisSign(EFloat.Create(var15_18[0], var16_19.AsEInteger())).RoundToPrecision(var10_13);
        if (var11_14 == false) return var17_43;
        if (var2_2.hasFlags == false) return var17_43;
        var2_2.setFlags(var2_2.flags | var10_13.flags);
        return var17_43;
    }

    public EInteger ToEInteger() {
        if (this.isFinite()) {
            int n2 = this.getExponent().signum();
            if (this.isZero()) {
                return EInteger.FromInt32(0);
            }
            if (n2 == 0) {
                return this.getMantissa();
            }
            if (n2 > 0) {
                return this.getMantissa().Multiply(NumberUtility.FindPowerOfTenFromBig(this.getExponent()));
            }
            FastInteger fastInteger = this.exponent.ToFastInteger();
            fastInteger.Negate();
            DigitShiftAccumulator digitShiftAccumulator = new DigitShiftAccumulator(this.unsignedMantissa.ToEInteger(), 0, 0);
            digitShiftAccumulator.TruncateOrShiftRight(fastInteger, true);
            EInteger eInteger = digitShiftAccumulator.getShiftedInt();
            if (this.isNegative()) {
                eInteger = eInteger.Negate();
            }
            return eInteger;
        }
        throw new ArithmeticException("Value is infinity or NaN");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final String ToStringInternal(int var1_1) {
        block75 : {
            block73 : {
                block74 : {
                    var2_2 = this.flags;
                    var3_3 = 1;
                    var4_4 = (var2_2 & var3_3) != 0 ? var3_3 : 0;
                    if (!this.isFinite()) {
                        var132_5 = this.flags;
                        if ((var132_5 & 2) != 0) {
                            if (var4_4 == 0) return "Infinity";
                            return "-Infinity";
                        }
                        if ((var132_5 & 8) != 0) {
                            if (this.unsignedMantissa.isValueZero()) {
                                if (var4_4 == 0) return "sNaN";
                                return "-sNaN";
                            }
                            if (var4_4 != 0) {
                                var139_6 = GeneratedOutlineSupport.outline24((String)"-sNaN");
                                var139_6.append((Object)this.unsignedMantissa);
                                return var139_6.toString();
                            }
                            var137_7 = GeneratedOutlineSupport.outline24((String)"sNaN");
                            var137_7.append((Object)this.unsignedMantissa);
                            return var137_7.toString();
                        }
                        if ((var132_5 & 4) != 0) {
                            if (this.unsignedMantissa.isValueZero()) {
                                if (var4_4 == 0) return "NaN";
                                return "-NaN";
                            }
                            if (var4_4 != 0) {
                                var135_8 = GeneratedOutlineSupport.outline24((String)"-NaN");
                                var135_8.append((Object)this.unsignedMantissa);
                                return var135_8.toString();
                            }
                            var133_9 = GeneratedOutlineSupport.outline24((String)"NaN");
                            var133_9.append((Object)this.unsignedMantissa);
                            return var133_9.toString();
                        }
                    }
                    var5_10 = -this.exponent.signum();
                    var6_11 = this.unsignedMantissa.toString();
                    if (var5_10 == 0) {
                        if (var4_4 == 0) return var6_11;
                        return GeneratedOutlineSupport.outline18((String)"-", (String)var6_11);
                    }
                    var7_12 = this.unsignedMantissa.isValueZero();
                    if (var1_1 == 2 && var7_12 && var5_10 < 0) {
                        if (var4_4 == 0) return var6_11;
                        return GeneratedOutlineSupport.outline18((String)"-", (String)var6_11);
                    }
                    if (var1_1 == 0 && var6_11.length() < 100 && this.exponent.CanFitInInt32() && (var113_13 = this.exponent.AsInt32()) > -100 && var113_13 < 100) {
                        var114_14 = var113_13 + var6_11.length() - var3_3;
                        if (var5_10 >= 0 && var114_14 >= -6 && var5_10 > 0) {
                            var115_15 = var113_13 + var6_11.length();
                            if (var115_15 < 0) {
                                var116_16 = new StringBuilder(6 + var6_11.length());
                                if (var4_4 != 0) {
                                    var116_16.append("-0.");
                                } else {
                                    var116_16.append("0.");
                                }
                                var118_17 = -var115_15;
                                var119_18 = 0;
                                do {
                                    if (var119_18 >= var118_17) {
                                        var116_16.append(var6_11);
                                        return var116_16.toString();
                                    }
                                    var116_16.append('0');
                                    ++var119_18;
                                } while (true);
                            }
                            if (var115_15 == 0) {
                                var123_19 = new StringBuilder(6 + var6_11.length());
                                if (var4_4 != 0) {
                                    var123_19.append("-0.");
                                } else {
                                    var123_19.append("0.");
                                }
                                var123_19.append(var6_11);
                                return var123_19.toString();
                            }
                            if (var115_15 > 0 && var115_15 <= var6_11.length()) {
                                var127_20 = new StringBuilder(6 + var6_11.length());
                                if (var4_4 != 0) {
                                    var127_20.append('-');
                                }
                                var127_20.append((CharSequence)var6_11, 0, var115_15 + 0);
                                var127_20.append('.');
                                var127_20.append((CharSequence)var6_11, var115_15, var115_15 + (var6_11.length() - var115_15));
                                return var127_20.toString();
                            }
                        }
                    }
                    var8_21 = FastInteger.FromBig(this.getExponent());
                    var9_22 = new FastInteger(var6_11.length());
                    var10_23 = var8_21.Copy();
                    var8_21.Add(var9_22);
                    var8_21.Decrement();
                    var13_24 = new FastInteger(var3_3);
                    var14_25 = new FastInteger(-6);
                    if (var1_1 != var3_3) break block73;
                    var92_26 = var8_21.Copy();
                    if (var8_21.signum() >= 0) {
                        var3_3 = 0;
                    }
                    var93_27 = var8_21.Copy().Abs();
                    var93_27.Remainder(3);
                    var95_28 = var93_27.AsInt32();
                    if (!var7_12 || var8_21.compareTo(var14_25) >= 0 && var5_10 >= 0) break block74;
                    if (var95_28 == 1) {
                        if (var3_3 != 0) {
                            var13_24.Increment();
                            var92_26.Increment();
                        } else {
                            var13_24.AddInt(2);
                            var92_26.AddInt(2);
                        }
                    } else if (var95_28 == 2) {
                        if (var3_3 == 0) {
                            var13_24.Increment();
                            var92_26.Increment();
                        } else {
                            var13_24.AddInt(2);
                            var92_26.AddInt(2);
                        }
                    }
                    var14_25.Increment();
                    ** GOTO lbl112
                }
                if (var95_28 == 1) {
                    if (var3_3 == 0) {
                        var13_24.Increment();
                        var92_26.Decrement();
lbl112: // 2 sources:
                        var15_29 = 2;
                    } else {
                        var15_29 = 2;
                        var13_24.AddInt(var15_29);
                        var92_26.AddInt(-2);
                    }
                } else {
                    if (var95_28 == 2) {
                        if (var3_3 != 0) {
                            var13_24.Increment();
                            var92_26.Decrement();
                        } else {
                            var13_24.AddInt(2);
                            var92_26.AddInt(-2);
                        }
                    }
                    var15_29 = 2;
                }
                var8_21 = var92_26;
                break block75;
            }
            var15_29 = 2;
        }
        var16_30 = Integer.MAX_VALUE;
        if (var1_1 != var15_29 && (var8_21.compareTo(var14_25) < 0 || var5_10 < 0)) {
            if (var1_1 == 1 && var7_12 && var13_24.CompareToInt(1) > 0) {
                var57_31 = new StringBuilder();
                if (var4_4 != 0) {
                    var57_31.append('-');
                }
                var57_31.append(var6_11);
                var57_31.append('.');
                EDecimal.AppendString(var57_31, '0', var13_24.Copy().Decrement());
            } else {
                var55_32 = var13_24.Copy();
                var56_33 = var55_32.CompareToInt(var6_11.length());
                if (var56_33 > 0) {
                    var55_32.SubtractInt(var6_11.length());
                    var84_34 = new StringBuilder();
                    if (var4_4 != 0) {
                        var84_34.append('-');
                    }
                    var84_34.append(var6_11);
                    EDecimal.AppendString(var84_34, '0', var55_32);
                    var57_31 = var84_34;
                } else if (var56_33 < 0) {
                    if (var55_32.CanFitInInt32() == false) throw new UnsupportedOperationException();
                    var75_35 = var55_32.AsInt32();
                    if (var55_32.signum() < 0) {
                        var75_35 = 0;
                    }
                    var76_36 = new FastInteger(var6_11.length());
                    var76_36.AddInt(6);
                    if (var76_36.CompareToInt(var16_30) <= 0) {
                        var16_30 = var76_36.AsInt32();
                    }
                    var78_37 = new StringBuilder(var16_30);
                    if (var4_4 != 0) {
                        var78_37.append('-');
                    }
                    var78_37.append((CharSequence)var6_11, 0, var75_35 + 0);
                    var78_37.append('.');
                    var78_37.append((CharSequence)var6_11, var75_35, var75_35 + (var6_11.length() - var75_35));
                    var57_31 = var78_37;
                } else {
                    if (var8_21.signum() == 0 && var4_4 == 0) {
                        return var6_11;
                    }
                    if (var8_21.signum() == 0 && var4_4 != 0) {
                        return GeneratedOutlineSupport.outline18((String)"-", (String)var6_11);
                    }
                    var57_31 = new StringBuilder();
                    if (var4_4 != 0) {
                        var57_31.append('-');
                    }
                    var57_31.append(var6_11);
                }
            }
            if (var8_21.signum() == 0) return var57_31.toString();
            var59_38 = var8_21.signum() < 0 ? "E-" : "E+";
            var57_31.append(var59_38);
            var8_21.Abs();
            var62_39 = new StringBuilder();
        } else {
            if (var5_10 > 0) {
                var22_48 = var10_23.Copy();
                var22_48.Add(var9_22);
                var24_49 = var22_48.CompareToInt(0);
                if (var24_49 < 0) {
                    var25_50 = new FastInteger(var6_11.length());
                    var25_50.AddInt(6);
                    if (var25_50.CompareToInt(var16_30) <= 0) {
                        var16_30 = var25_50.AsInt32();
                    }
                    var27_51 = new StringBuilder(var16_30);
                    if (var4_4 != 0) {
                        var27_51.append('-');
                    }
                    var27_51.append("0.");
                    var29_52 = var22_48.Copy();
                    var29_52.Negate();
                    EDecimal.AppendString(var27_51, '0', var29_52);
                    var27_51.append(var6_11);
                    return var27_51.toString();
                }
                if (var24_49 == 0) {
                    var34_53 = new FastInteger(var6_11.length());
                    var34_53.AddInt(6);
                    if (var34_53.CompareToInt(var16_30) <= 0) {
                        var16_30 = var34_53.AsInt32();
                    }
                    var27_51 = new StringBuilder(var16_30);
                    if (var4_4 != 0) {
                        var27_51.append('-');
                    }
                    var27_51.append("0.");
                    var27_51.append(var6_11);
                    return var27_51.toString();
                }
                if (var22_48.CompareToInt(var6_11.length()) > 0) {
                    if (var9_22.CanFitInInt32() == false) throw new UnsupportedOperationException();
                    var46_54 = var9_22.AsInt32();
                    if (var46_54 < 0) {
                        var46_54 = 0;
                    }
                    var47_55 = new FastInteger(var6_11.length());
                    var47_55.AddInt(6);
                    if (var47_55.CompareToInt(var16_30) <= 0) {
                        var16_30 = var47_55.AsInt32();
                    }
                    var49_56 = new StringBuilder(var16_30);
                    if (var4_4 != 0) {
                        var49_56.append('-');
                    }
                    var49_56.append((CharSequence)var6_11, 0, var46_54 + 0);
                    EDecimal.AppendString(var49_56, '0', var22_48.Copy().SubtractInt(var49_56.length()));
                    var49_56.append('.');
                    var49_56.append((CharSequence)var6_11, var46_54, var46_54 + (var6_11.length() - var46_54));
                    var27_51 = var49_56;
                    return var27_51.toString();
                }
                if (var22_48.CanFitInInt32() == false) throw new UnsupportedOperationException();
                var39_57 = var22_48.AsInt32();
                if (var39_57 < 0) {
                    var39_57 = 0;
                }
                var40_58 = new FastInteger(var6_11.length());
                var40_58.AddInt(6);
                if (var40_58.CompareToInt(var16_30) <= 0) {
                    var16_30 = var40_58.AsInt32();
                }
                var27_51 = new StringBuilder(var16_30);
                if (var4_4 != 0) {
                    var27_51.append('-');
                }
                var27_51.append((CharSequence)var6_11, 0, var39_57 + 0);
                var27_51.append('.');
                var27_51.append((CharSequence)var6_11, var39_57, var39_57 + (var6_11.length() - var39_57));
                return var27_51.toString();
            }
            if (var1_1 == 2 && var5_10 < 0) {
                var17_59 = var10_23.Copy();
                var18_60 = new StringBuilder();
                if (var4_4 != 0) {
                    var18_60.append('-');
                }
                var18_60.append(var6_11);
                EDecimal.AppendString(var18_60, '0', var17_59);
                return var18_60.toString();
            }
            if (var4_4 != 0) return GeneratedOutlineSupport.outline18((String)"-", (String)var6_11);
            return var6_11;
        }
        while (var8_21.signum() != 0) {
            var67_40 = var8_21.Copy();
            var67_40.Remainder(10);
            var62_39.append((char)(48 + var67_40.AsInt32()));
            var70_41 = var8_21.integerMode;
            if (var70_41 != 0) {
                if (var70_41 != 1) {
                    if (var70_41 != 2) throw new IllegalStateException();
                    var8_21.largeValue = var73_44 = var8_21.largeValue.Divide(EInteger.FromInt64(10));
                    if (!var73_44.isZero()) continue;
                    var8_21.integerMode = 0;
                    var8_21.smallValue = 0;
                    continue;
                }
                var8_21.integerMode = 2;
                var8_21.largeValue = var71_42 = var8_21.mnum.ToEInteger();
                var8_21.largeValue = var72_43 = var71_42.Divide(EInteger.FromInt64(10));
                if (!var72_43.isZero()) continue;
                var8_21.integerMode = 0;
                var8_21.smallValue = 0;
                continue;
            }
            var8_21.smallValue /= 10;
        }
        var63_45 = var62_39.length();
        var64_46 = var62_39.toString();
        var65_47 = 0;
        while (var65_47 < var63_45) {
            var57_31.append(var64_46.charAt(var63_45 - 1 - var65_47));
            ++var65_47;
        }
        return var57_31.toString();
    }

    public final EFloat WithThisSign(EFloat eFloat) {
        if (this.isNegative()) {
            eFloat = new EFloat(eFloat.unsignedMantissa, eFloat.exponent, 1 ^ eFloat.flags);
        }
        return eFloat;
    }

    public int compareTo(EDecimal eDecimal) {
        return ExtendedMathValue.compareTo(this, eDecimal);
    }

    public boolean equals(Object object) {
        EDecimal eDecimal = object instanceof EDecimal ? (EDecimal)object : null;
        return eDecimal != null && this.flags == eDecimal.flags && this.unsignedMantissa.equals(eDecimal.unsignedMantissa) && this.exponent.equals(eDecimal.exponent);
    }

    public final EInteger getExponent() {
        return this.exponent.ToEInteger();
    }

    public final EInteger getMantissa() {
        if (this.isNegative()) {
            return this.unsignedMantissa.ToEInteger().Negate();
        }
        return this.unsignedMantissa.ToEInteger();
    }

    public final EInteger getUnsignedMantissa() {
        return this.unsignedMantissa.ToEInteger();
    }

    public int hashCode() {
        return 964453631 + 964453723 * this.exponent.hashCode() + 964453939 * this.unsignedMantissa.hashCode() + 964453967 * this.flags;
    }

    public final boolean isFinite() {
        return (14 & this.flags) == 0;
    }

    public final boolean isNegative() {
        return (1 & this.flags) != 0;
    }

    public final boolean isZero() {
        return (14 & this.flags) == 0 && this.unsignedMantissa.isValueZero();
    }

    public final int signum() {
        int n2 = 14 & this.flags;
        int n3 = 1;
        if (n2 == 0 && this.unsignedMantissa.isValueZero()) {
            return 0;
        }
        if ((n3 & this.flags) != 0) {
            n3 = -1;
        }
        return n3;
    }

    public String toString() {
        return this.ToStringInternal(0);
    }

}

