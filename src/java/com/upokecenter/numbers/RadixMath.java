/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ArithmeticException
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.Objects
 */
package com.upokecenter.numbers;

import com.upokecenter.numbers.EContext;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ERounding;
import com.upokecenter.numbers.FastInteger;
import com.upokecenter.numbers.FastIntegerFixed;
import com.upokecenter.numbers.IRadixMath;
import com.upokecenter.numbers.IRadixMathHelper;
import com.upokecenter.numbers.IShiftAccumulator;
import java.util.Objects;

public class RadixMath<T>
implements IRadixMath<T> {
    public static final int[] BitMasks = new int[]{Integer.MAX_VALUE, 1073741823, 536870911, 268435455, 134217727, 67108863, 33554431, 16777215, 8388607, 4194303, 2097151, 1048575, 524287, 262143, 131071, 65535, 32767, 16383, 8191, 4095, 2047, 1023, 511, 255, 127, 63, 31, 15, 7, 3, 1};
    public static final long[] BitMasks64 = new long[]{Long.MAX_VALUE, 0x3FFFFFFFFFFFFFFFL, 0x1FFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFFFL, 0x3FFFFFFFFFFFFFFL, 0x1FFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFFL, 0x3FFFFFFFFFFFFFL, 0x1FFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFL, 0x3FFFFFFFFFFFFL, 0x1FFFFFFFFFFFFL, 0xFFFFFFFFFFFFL, 0x7FFFFFFFFFFFL, 0x3FFFFFFFFFFFL, 0x1FFFFFFFFFFFL, 0xFFFFFFFFFFFL, 0x7FFFFFFFFFFL, 0x3FFFFFFFFFFL, 0x1FFFFFFFFFFL, 0xFFFFFFFFFFL, 0x7FFFFFFFFFL, 0x3FFFFFFFFFL, 0x1FFFFFFFFFL, 0xFFFFFFFFFL, 0x7FFFFFFFFL, 0x3FFFFFFFFL, 0x1FFFFFFFFL, 0xFFFFFFFFL, Integer.MAX_VALUE, 0x3FFFFFFFL, 0x1FFFFFFFL, 0xFFFFFFFL, 0x7FFFFFFL, 0x3FFFFFFL, 0x1FFFFFFL, 0xFFFFFFL, 0x7FFFFFL, 0x3FFFFFL, 0x1FFFFFL, 1048575L, 524287L, 262143L, 131071L, 65535L, 32767L, 16383L, 8191L, 4095L, 2047L, 1023L, 511L, 255L, 127L, 63L, 31L, 15L, 7L, 3L, 1L};
    public static final EContext DefaultUnlimited;
    public static final int[] OverflowMaxes;
    public static final long[] OverflowMaxes64;
    public static final FastInteger ValueFastIntegerTwo;
    public static final int[] ValueTenPowers;
    public static final long[] ValueTenPowers64;
    public static EInteger valueMaxDigits;
    public final IRadixMathHelper<T> helper;
    public final int support;
    public final int thisRadix;

    public static {
        OverflowMaxes = new int[]{Integer.MAX_VALUE, 214748364, 21474836, 2147483, 214748, 21474, 2147, 214, 21, 2};
        EInteger.FromInt32(0).Subtract(EInteger.FromInt64(1L));
        ValueTenPowers = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        OverflowMaxes64 = new long[]{Long.MAX_VALUE, 0xCCCCCCCCCCCCCCCL, 92233720368547758L, 9223372036854775L, 922337203685477L, 92233720368547L, 9223372036854L, 922337203685L, 92233720368L, 9223372036L, 922337203L, 92233720L, 9223372L, 922337L, 92233L, 9223L, 922L, 92L, 9L};
        ValueTenPowers64 = new long[]{1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
        valueMaxDigits = EInteger.FromInt64(5726623058L);
        ValueFastIntegerTwo = new FastInteger(2);
        DefaultUnlimited = EContext.UnlimitedHalfEven.WithRounding(ERounding.HalfEven);
    }

    public RadixMath(IRadixMathHelper<T> iRadixMathHelper) {
        this.helper = iRadixMathHelper;
        this.support = iRadixMathHelper.GetArithmeticSupport();
        this.thisRadix = iRadixMathHelper.GetRadix();
    }

    public static boolean IsNullOrSimpleContext(EContext eContext) {
        return eContext == null || eContext == EContext.UnlimitedHalfEven || !eContext.hasExponentRange && !eContext.getHasMaxPrecision() && eContext.traps == 0 && !eContext.hasFlags;
        {
        }
    }

    public static <TMath> EInteger RescaleByExponentDiff(EInteger eInteger, EInteger eInteger2, EInteger eInteger3, IRadixMathHelper<TMath> iRadixMathHelper) {
        if (eInteger.signum() == 0) {
            return EInteger.FromInt32(0);
        }
        FastInteger fastInteger = FastInteger.FromBig(eInteger2).SubtractBig(eInteger3).Abs();
        if (!fastInteger.CanFitInInt32()) {
            FastInteger fastInteger2 = FastInteger.FromBig(eInteger);
            if (iRadixMathHelper.GetRadix() != 10 || fastInteger.compareTo(fastInteger2) > 0) {
                return null;
            }
        }
        return iRadixMathHelper.MultiplyByRadixPower(eInteger, fastInteger);
    }

    @Override
    public T Abs(T t2, EContext eContext) {
        int n2 = this.helper.GetFlags(t2);
        if ((n2 & 8) != 0) {
            return this.SignalingNaNInvalid(t2, eContext);
        }
        if ((n2 & 4) != 0) {
            return this.ReturnQuietNaN(t2, eContext);
        }
        if ((n2 & 1) != 0) {
            IRadixMathHelper<T> iRadixMathHelper = this.helper;
            return this.RoundToPrecision(iRadixMathHelper.CreateNewWithFlags(iRadixMathHelper.GetMantissa(t2), this.helper.GetExponent(t2), n2 & -2), eContext);
        }
        return this.RoundToPrecision(t2, eContext);
    }

    @Override
    public T Add(T t2, T t3, EContext eContext) {
        Objects.requireNonNull(t2, (String)"thisValue");
        Objects.requireNonNull(t3, (String)"other");
        return this.AddEx(t2, t3, eContext, false);
    }

    public final T AddCore(EInteger eInteger, EInteger eInteger2, EInteger eInteger3, int n2, int n3, EContext eContext) {
        EInteger eInteger4;
        int n4;
        int n5;
        int n6 = 1;
        int n7 = (n2 & n6) != 0 ? n6 : 0;
        if (n7 != (n4 = (n3 & n6) != 0 ? n6 : 0)) {
            eInteger4 = eInteger.Subtract(eInteger2);
            int n8 = eInteger4.signum();
            int n9 = n8 == 0 ? n4 : (n8 < 0 ? n6 : 0);
            n5 = n9 ^ n7;
            if (n8 < 0) {
                eInteger4 = eInteger4.Negate();
            }
        } else {
            eInteger4 = eInteger.Add(eInteger2);
            n5 = n7;
        }
        if (n5 != 0 && eInteger4.isZero()) {
            if (!(n7 != 0 && n4 != 0 || (n7 ^ n4) != 0 && eContext != null && eContext.rounding == ERounding.Floor)) {
                n6 = 0;
            }
            n5 &= n6;
        }
        return this.helper.CreateNewWithFlags(eInteger4, eInteger3, n5);
    }

    /*
     * Exception decompiling
     */
    @Override
    public T AddEx(T var1_1, T var2_2, EContext var3_3, boolean var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.b.a.a.i.b(Op03SimpleStatement.java:414)
        // org.benf.cfr.reader.b.a.a.b.ad.a(Misc.java:226)
        // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:623)
        // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:52)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:576)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    @Override
    public T Divide(T var1_1, T var2_2, EContext var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.b.a.a.i.b(Op03SimpleStatement.java:414)
        // org.benf.cfr.reader.b.a.a.b.ad.a(Misc.java:226)
        // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:623)
        // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:52)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:576)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public final T EnsureSign(T t2, boolean bl) {
        if (t2 == null) {
            return t2;
        }
        int n2 = this.helper.GetFlags(t2);
        if (bl && (n2 & 1) == 0 || !bl && (n2 & 1) != 0) {
            int n3 = bl | n2 & -2;
            IRadixMathHelper<T> iRadixMathHelper = this.helper;
            t2 = iRadixMathHelper.CreateNewWithFlags(iRadixMathHelper.GetMantissa(t2), this.helper.GetExponent(t2), n3);
        }
        return t2;
    }

    @Override
    public IRadixMathHelper<T> GetHelper() {
        return this.helper;
    }

    public final T HandleNotANumber(T t2, T t3, EContext eContext) {
        int n2 = this.helper.GetFlags(t2);
        int n3 = this.helper.GetFlags(t3);
        if ((n2 & 8) != 0) {
            return this.SignalingNaNInvalid(t2, eContext);
        }
        if ((n3 & 8) != 0) {
            return this.SignalingNaNInvalid(t3, eContext);
        }
        if ((n2 & 4) != 0) {
            return this.ReturnQuietNaN(t2, eContext);
        }
        if ((n3 & 4) != 0) {
            return this.ReturnQuietNaN(t3, eContext);
        }
        return null;
    }

    public final boolean IsHigherThanBitLength(EInteger eInteger, FastInteger fastInteger) {
        return fastInteger.compareTo(FastInteger.FromBig(eInteger.GetUnsignedBitLengthAsEInteger())) < 0;
    }

    public final boolean IsNullOrInt32FriendlyContext(EContext eContext) {
        boolean bl;
        block3 : {
            block2 : {
                block5 : {
                    block4 : {
                        if (eContext == null) break block2;
                        boolean bl2 = eContext.hasFlags;
                        bl = false;
                        if (bl2) break block3;
                        int n2 = eContext.traps;
                        bl = false;
                        if (n2 != 0) break block3;
                        if (!eContext.hasExponentRange) break block4;
                        int n3 = eContext.getEMin().compareTo(-10);
                        bl = false;
                        if (n3 >= 0) break block3;
                        int n4 = eContext.getEMax().compareTo(0);
                        bl = false;
                        if (n4 < 0) break block3;
                    }
                    ERounding eRounding = eContext.rounding;
                    ERounding eRounding2 = ERounding.Floor;
                    bl = false;
                    if (eRounding == eRounding2) break block3;
                    if (!eContext.getHasMaxPrecision() || this.thisRadix >= 10 && !eContext.precisionInBits && eContext.bigintPrecision.compareTo(10) >= 0) break block2;
                    if (this.thisRadix >= 2) break block5;
                    boolean bl3 = eContext.precisionInBits;
                    bl = false;
                    if (!bl3) break block3;
                }
                int n5 = eContext.bigintPrecision.compareTo(32);
                bl = false;
                if (n5 < 0) break block3;
            }
            bl = true;
        }
        return bl;
    }

    @Override
    public T Multiply(T t2, T t3, EContext eContext) {
        int n2 = this.helper.GetFlags(t2);
        int n3 = this.helper.GetFlags(t3);
        int n4 = 14 & (n2 | n3);
        int n5 = 1;
        if (n4 != 0) {
            T t4 = this.HandleNotANumber(t2, t3, eContext);
            if (t4 != null) {
                return t4;
            }
            if ((n2 & 2) != 0) {
                int n6 = (n2 & n5) != 0 ? n5 : 0;
                if ((n3 & 1) == 0) {
                    n5 = 0;
                }
                boolean bl = n6 ^ n5;
                if ((n3 & 14) == 0 && this.helper.GetMantissa(t3).isZero()) {
                    return this.SignalInvalid(eContext);
                }
                return this.EnsureSign(t2, bl);
            }
            if ((n3 & 2) != 0) {
                int n7 = (n2 & 1) != 0 ? n5 : 0;
                if ((n3 & n5) == 0) {
                    n5 = 0;
                }
                boolean bl = n7 ^ n5;
                if ((n2 & 14) == 0 && this.helper.GetMantissa(t2).isZero()) {
                    return this.SignalInvalid(eContext);
                }
                return this.EnsureSign(t3, bl);
            }
        }
        EInteger eInteger = this.helper.GetExponent(t3);
        EInteger eInteger2 = this.helper.GetExponent(t2).Add(eInteger);
        EInteger eInteger3 = this.helper.GetMantissa(t3);
        int n8 = n2 & n5 ^ n3 & n5;
        IRadixMathHelper<T> iRadixMathHelper = this.helper;
        T t5 = iRadixMathHelper.CreateNewWithFlags(iRadixMathHelper.GetMantissa(t2).Multiply(eInteger3), eInteger2, n8);
        if (eContext != null && eContext != EContext.UnlimitedHalfEven) {
            t5 = this.RoundToPrecision(t5, eContext);
        }
        return t5;
    }

    @Override
    public T NextPlus(T t2, EContext eContext) {
        FastInteger fastInteger;
        if (eContext == null) {
            return this.SignalInvalidWithMessage(eContext, "ctx is null");
        }
        if (!eContext.getHasMaxPrecision()) {
            return this.SignalInvalidWithMessage(eContext, "ctx has unlimited precision");
        }
        if (!eContext.hasExponentRange) {
            return this.SignalInvalidWithMessage(eContext, "doesn't satisfy ctx.getHasExponentRange()");
        }
        int n2 = this.helper.GetFlags(t2);
        if ((n2 & 8) != 0) {
            return this.SignalingNaNInvalid(t2, eContext);
        }
        if ((n2 & 4) != 0) {
            return this.ReturnQuietNaN(t2, eContext);
        }
        if ((n2 & 2) != 0) {
            if ((n2 & 1) != 0) {
                EInteger eInteger;
                EInteger eInteger2 = eContext.getEMax();
                EInteger eInteger3 = eContext.bigintPrecision;
                if (eContext.adjustExponent) {
                    eInteger2 = eInteger2.Add(EInteger.FromInt32(1)).Subtract(eInteger3);
                }
                if ((eInteger = this.TryMultiplyByRadixPower(EInteger.FromInt32(1), FastInteger.FromBig(eContext.bigintPrecision))) == null) {
                    return this.SignalInvalidWithMessage(eContext, "Result requires too much memory");
                }
                EInteger eInteger4 = eInteger.Subtract(EInteger.FromInt32(1));
                t2 = this.helper.CreateNewWithFlags(eInteger4, eInteger2, 1);
            }
            return t2;
        }
        FastInteger fastInteger2 = FastInteger.FromBig(eContext.getEMin());
        if (eContext.adjustExponent) {
            fastInteger2.SubtractBig(eContext.bigintPrecision).Increment();
        }
        if ((fastInteger = FastInteger.FromBig(this.helper.GetExponent(t2))).compareTo(fastInteger2) <= 0) {
            fastInteger2 = fastInteger.Copy().SubtractInt(2);
        }
        return this.Add(t2, this.helper.CreateNewWithFlags(EInteger.FromInt32(1), fastInteger2.AsEInteger(), 0), eContext.WithRounding(ERounding.Ceiling));
    }

    public final FastInteger OverestimateDigitLength(EInteger eInteger) {
        int n2 = this.thisRadix;
        if (n2 == 2) {
            return FastInteger.FromBig(eInteger.GetUnsignedBitLengthAsEInteger());
        }
        if (n2 == 10) {
            EInteger eInteger2 = eInteger.GetUnsignedBitLengthAsEInteger();
            if (eInteger2.compareTo(2135) <= 0) {
                return new FastInteger(1 + (631305 * eInteger2.ToInt32Checked() >> 21));
            }
            return FastInteger.FromBig(eInteger2.Divide(EInteger.FromInt32(3)));
        }
        return this.helper.GetDigitLength(eInteger);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public T Quantize(T var1_1, T var2_2, EContext var3_3) {
        block22 : {
            block21 : {
                var4_4 = this.helper.GetFlags(var1_1);
                if ((14 & (var4_4 | (var5_5 = this.helper.GetFlags(var2_2)))) != 0) {
                    var33_6 = this.HandleNotANumber(var1_1, var2_2, var3_3);
                    if (var33_6 != null) {
                        return var33_6;
                    }
                    if ((2 & (var4_4 & var5_5)) == 0) return this.SignalInvalid(var3_3);
                    return this.RoundToPrecision(var1_1, var3_3);
                }
                var6_7 = this.helper.GetExponent(var2_2);
                if (var3_3 != null && !var3_3.ExponentWithinRange(var6_7)) {
                    var30_8 = new StringBuilder();
                    var30_8.append("Exponent not within exponent range: ");
                    var30_8.append((Object)var6_7);
                    return this.SignalInvalidWithMessage(var3_3, var30_8.toString());
                }
                var7_9 = var3_3 == null ? EContext.ForRounding(ERounding.HalfEven) : var3_3.Copy();
                var8_10 = var7_9.WithBlankFlags();
                var9_11 = this.helper.GetMantissa(var1_1);
                var10_12 = this.helper.GetExponent(var1_1);
                var11_13 = var10_12.compareTo(var6_7);
                var12_14 = this.helper.GetFlags(var1_1);
                var13_15 = 1;
                var14_16 = var12_14 & 1;
                if (var11_13 == 0) {
                    var15_17 = this.RoundToPrecision(var1_1, var8_10);
                } else if (var9_11.isZero()) {
                    var15_17 = this.RoundToPrecision(this.helper.CreateNewWithFlags(EInteger.FromInt32(0), var6_7, var14_16), var8_10);
                } else if (var11_13 > 0) {
                    var26_18 = FastInteger.FromBig(var10_12).SubtractBig(var6_7);
                    if (var8_10.bigintPrecision.signum() > 0) {
                        var28_19 = FastInteger.FromBig(var8_10.bigintPrecision);
                        var28_19.AddInt(10);
                        if (var26_18.compareTo(var28_19) > 0) {
                            return this.SignalInvalidWithMessage(var3_3, "Result too high for current precision");
                        }
                    }
                    if ((var27_20 = this.TryMultiplyByRadixPower(var9_11, var26_18)) == null) {
                        return this.SignalInvalidWithMessage(var3_3, "Result requires too much memory");
                    }
                    var15_17 = this.RoundToPrecision(this.helper.CreateNewWithFlags(var27_20, var6_7, var14_16), var8_10);
                } else {
                    var15_17 = this.RoundToPrecisionInternal(var1_1, 0, 0, FastInteger.FromBig(var6_7).SubtractBig(var10_12), false, var8_10);
                }
                if ((16 & var8_10.flags) != 0) {
                    return this.SignalInvalid(var3_3);
                }
                if (var15_17 == null) return this.SignalInvalid(var3_3);
                if (!this.helper.GetExponent(var15_17).equals(var6_7)) {
                    return this.SignalInvalid(var3_3);
                }
                var16_21 = var14_16 != 0 ? var13_15 : 0;
                var17_22 = this.EnsureSign(var15_17, (boolean)var16_21);
                if (var3_3 == null) return var17_22;
                if (var3_3.hasFlags == false) return var17_22;
                var18_23 = -9 & var8_10.flags;
                if (var11_13 >= 0 || this.helper.GetMantissa(var17_22).isZero()) break block21;
                var19_24 = var3_3.getHasMaxPrecision() == false ? var13_15 : 0;
                if (var19_24 != 0) ** GOTO lbl-1000
                var20_25 = FastInteger.FromBig(this.helper.GetExponent(var17_22));
                var21_26 = FastInteger.FromBig(var3_3.getEMin());
                if (var3_3.adjustExponent) {
                    var23_27 = this.helper;
                    var20_25.Add(var23_27.GetDigitLength(var23_27.GetMantissa(var17_22)));
                    var20_25.SubtractInt(var13_15);
                }
                if (var20_25.compareTo(var21_26) < 0) {
                    var22_28 = var13_15;
                } else lbl-1000: // 2 sources:
                {
                    var22_28 = 0;
                }
                if (var22_28 != 0) break block22;
            }
            var13_15 = 0;
        }
        if (var13_15 != 0) {
            var18_23 |= 4;
        }
        var3_3.setFlags(var18_23 | var3_3.flags);
        return var17_22;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final T ReturnQuietNaN(T var1_1, EContext var2_2) {
        var3_3 = this.helper.GetMantissa(var1_1);
        if (var3_3.isZero() || var2_2 == null || !var2_2.getHasMaxPrecision()) ** GOTO lbl-1000
        var7_4 = FastInteger.FromBig(var2_2.bigintPrecision);
        if (this.helper.GetDigitLength(var3_3).compareTo(var7_4) < 0) ** GOTO lbl-1000
        var8_5 = this.TryMultiplyByRadixPower(EInteger.FromInt32(1), var7_4);
        if (var8_5 == null) {
            return this.SignalInvalidWithMessage(var2_2, "Result requires too much memory");
        }
        if (var3_3.compareTo(var8_5) >= 0) {
            var3_3 = var3_3.Remainder(var8_5);
            var4_6 = true;
        } else lbl-1000: // 3 sources:
        {
            var4_6 = false;
        }
        var5_7 = this.helper.GetFlags(var1_1);
        if (!var4_6 && (var5_7 & 4) != 0) {
            return var1_1;
        }
        var6_8 = 4 | var5_7 & 1;
        return this.helper.CreateNewWithFlags(var3_3, EInteger.FromInt32(0), var6_8);
    }

    public final boolean RoundGivenAccum(IShiftAccumulator iShiftAccumulator, ERounding eRounding, boolean bl) {
        return this.RoundGivenDigits(iShiftAccumulator.getLastDiscardedDigit(), iShiftAccumulator.getOlderDiscardedDigits(), eRounding, bl, iShiftAccumulator.getShiftedIntFast());
    }

    /*
     * Enabled aggressive block sorting
     */
    public final boolean RoundGivenDigits(int n2, int n3, ERounding eRounding, boolean bl, FastInteger fastInteger) {
        boolean bl2;
        block24 : {
            block19 : {
                int n4;
                ERounding eRounding2;
                block22 : {
                    block23 : {
                        block17 : {
                            block21 : {
                                block20 : {
                                    block18 : {
                                        block16 : {
                                            n4 = this.thisRadix;
                                            ERounding eRounding3 = ERounding.HalfUp;
                                            bl2 = true;
                                            if (eRounding != eRounding3) break block16;
                                            if (n2 >= n4 / 2) {
                                                return false | bl2;
                                            }
                                            break block17;
                                        }
                                        if (eRounding == ERounding.HalfEven) {
                                            int n5 = n4 / 2;
                                            if (n2 < n5) return false;
                                            if (n2 > n5) return bl2;
                                            if (n3 == 0) return false | bl2 ^ fastInteger.isEvenNumber();
                                            return bl2;
                                        }
                                        if (eRounding != ERounding.HalfDown) break block18;
                                        int n6 = n4 / 2;
                                        if (n2 > n6) return false | bl2;
                                        if (n2 == n6 && n3 != 0) {
                                            return false | bl2;
                                        }
                                        break block19;
                                    }
                                    if (eRounding != ERounding.Ceiling) break block20;
                                    if (!bl && (n2 | n3) != 0) {
                                        return false | bl2;
                                    }
                                    break block19;
                                }
                                if (eRounding != ERounding.Floor) break block21;
                                if (bl && (n2 | n3) != 0) {
                                    return false | bl2;
                                }
                                break block19;
                            }
                            if (eRounding != ERounding.Up) break block22;
                            if ((n2 | n3) != 0) break block23;
                        }
                        bl2 = false;
                        return false | bl2;
                    }
                    return false | bl2;
                }
                if (eRounding != ERounding.Odd && (eRounding != (eRounding2 = ERounding.OddOrZeroFiveUp) || n4 != 2)) {
                    int n7;
                    if (eRounding != ERounding.ZeroFiveUp) {
                        if (eRounding != eRounding2) return false;
                        if (n4 == 2) return false;
                    }
                    if ((n2 | n3) == 0) return false;
                    if (n4 == 2) {
                        return bl2;
                    }
                    FastIntegerFixed fastIntegerFixed = FastIntegerFixed.FromFastInteger(fastInteger);
                    if (n4 < 0) throw new UnsupportedOperationException();
                    int n8 = fastIntegerFixed.integerMode == 0 && (n7 = fastIntegerFixed.smallValue) >= 0 ? n7 % n4 : fastIntegerFixed.ToEInteger().Remainder(EInteger.FromInt32(n4)).ToInt32Checked();
                    if (n8 == 0) return bl2;
                    if (n8 != n4 / 2) return false;
                    return bl2;
                }
                if ((n2 | n3) != 0 && fastInteger.isEvenNumber()) break block24;
            }
            bl2 = false;
            return false | bl2;
        }
        return false | bl2;
    }

    @Override
    public T RoundToPrecision(T t2, EContext eContext) {
        return this.RoundToPrecisionInternal(t2, 0, 0, null, false, eContext);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final T RoundToPrecisionInternal(T var1_1, int var2_2, int var3_3, FastInteger var4_4, boolean var5_5, EContext var6_6) {
        block117 : {
            block116 : {
                block115 : {
                    block108 : {
                        block114 : {
                            block113 : {
                                block109 : {
                                    block112 : {
                                        block111 : {
                                            block110 : {
                                                block106 : {
                                                    block107 : {
                                                        block102 : {
                                                            block105 : {
                                                                block104 : {
                                                                    block103 : {
                                                                        block99 : {
                                                                            block93 : {
                                                                                block97 : {
                                                                                    block101 : {
                                                                                        block100 : {
                                                                                            block98 : {
                                                                                                block96 : {
                                                                                                    block95 : {
                                                                                                        block94 : {
                                                                                                            var7_7 = var6_6;
                                                                                                            var8_8 = var7_7 == null || !var6_6.getHasMaxPrecision() && !var7_7.hasExponentRange;
                                                                                                            var9_9 = this.helper.GetFlags(var1_1);
                                                                                                            if ((var9_9 & 14) != 0) {
                                                                                                                if ((var9_9 & 8) != 0) {
                                                                                                                    if (var7_7 == null) return this.ReturnQuietNaN(var1_1, var7_7);
                                                                                                                    if (var7_7.hasFlags == false) return this.ReturnQuietNaN(var1_1, var7_7);
                                                                                                                    var7_7.setFlags(64 | var7_7.flags);
                                                                                                                    return this.ReturnQuietNaN(var1_1, var7_7);
                                                                                                                }
                                                                                                                if ((var9_9 & 4) != 0) {
                                                                                                                    return this.ReturnQuietNaN(var1_1, var7_7);
                                                                                                                }
                                                                                                                if ((var9_9 & 2) != 0) {
                                                                                                                    return var1_1;
                                                                                                                }
                                                                                                            }
                                                                                                            if (var8_8 && (var2_2 | var3_3) == 0 && (var4_4 == null || var4_4.isValueZero())) {
                                                                                                                if (var5_5 == false) return var1_1;
                                                                                                                if ((var9_9 & 1) == 0) return var1_1;
                                                                                                                if (!this.helper.GetMantissa(var1_1).isZero()) {
                                                                                                                    return var1_1;
                                                                                                                }
                                                                                                            }
                                                                                                            if (var8_8 && (var7_7 == null || !var7_7.hasFlags && var7_7.traps == 0) && (var4_4 == null || var4_4.isValueZero())) {
                                                                                                                var123_10 = var7_7 == null ? ERounding.HalfDown : var7_7.rounding;
                                                                                                                var124_11 = (var9_9 & 1) != 0;
                                                                                                                var125_12 = var5_5 != false && var124_11 != false && this.helper.GetMantissa(var1_1).isZero() != false && var123_10 != ERounding.Floor;
                                                                                                                if (!var125_12) {
                                                                                                                    if (var123_10 == ERounding.Down) {
                                                                                                                        return var1_1;
                                                                                                                    }
                                                                                                                    var126_13 = this.thisRadix;
                                                                                                                    if (var126_13 == 10 && var123_10 == ERounding.HalfEven) {
                                                                                                                        if (var2_2 < 5) {
                                                                                                                            return var1_1;
                                                                                                                        }
                                                                                                                        if (var2_2 > 5 || var3_3 != 0) {
                                                                                                                            var129_14 = this.helper.GetMantissaFastInt(var1_1);
                                                                                                                            return this.helper.CreateNewWithFlagsFastInt(FastIntegerFixed.Add(var129_14, FastIntegerFixed.One), this.helper.GetExponentFastInt(var1_1), var9_9);
                                                                                                                        }
                                                                                                                    }
                                                                                                                    if (var126_13 == 2 && var123_10 == ERounding.HalfEven && var2_2 == 0) {
                                                                                                                        return var1_1;
                                                                                                                    }
                                                                                                                    var127_15 = FastInteger.FromBig(this.helper.GetMantissa(var1_1));
                                                                                                                    if (!this.RoundGivenDigits(var2_2, var3_3, var123_10, var124_11, var127_15)) {
                                                                                                                        return var1_1;
                                                                                                                    }
                                                                                                                    var128_16 = this.helper.GetMantissaFastInt(var1_1);
                                                                                                                    return this.helper.CreateNewWithFlagsFastInt(FastIntegerFixed.Add(var128_16, FastIntegerFixed.One), this.helper.GetExponentFastInt(var1_1), var9_9);
                                                                                                                }
                                                                                                            }
                                                                                                            if (this.IsNullOrInt32FriendlyContext(var7_7) && (var2_2 | var3_3) == 0 && (var4_4 == null || var4_4.isValueZero()) && this.helper.GetExponentFastInt(var1_1).isValueZero()) {
                                                                                                                var122_17 = this.helper.GetMantissaFastInt(var1_1);
                                                                                                                if (var122_17.isValueZero() && var5_5 && (var9_9 & 1) != 0) {
                                                                                                                    return this.helper.ValueOf(0);
                                                                                                                }
                                                                                                                if (var122_17.CanFitInInt32()) {
                                                                                                                    return var1_1;
                                                                                                                }
                                                                                                            }
                                                                                                            if (var7_7 == null) {
                                                                                                                var7_7 = RadixMath.DefaultUnlimited;
                                                                                                            }
                                                                                                            var10_18 = var7_7.precisionInBits;
                                                                                                            var11_19 = var7_7.bigintPrecision.CanFitInInt32() != false ? new FastInteger(var7_7.bigintPrecision.ToInt32Checked()) : FastInteger.FromBig(var7_7.bigintPrecision);
                                                                                                            var12_20 = this.thisRadix != 2 && var7_7.bigintPrecision.isZero() == false;
                                                                                                            var13_21 = var10_18 & var12_20;
                                                                                                            if (var7_7.hasExponentRange) {
                                                                                                                var14_22 = var7_7.getEMax().CanFitInInt32() != false ? new FastInteger(var7_7.getEMax().ToInt32Checked()) : FastInteger.FromBig(var7_7.getEMax());
                                                                                                                var15_23 = var7_7.getEMin().CanFitInInt32() ? new FastInteger(var7_7.getEMin().ToInt32Checked()) : FastInteger.FromBig(var7_7.getEMin());
                                                                                                            } else {
                                                                                                                var14_22 = null;
                                                                                                                var15_23 = null;
                                                                                                            }
                                                                                                            var16_24 = var7_7.rounding;
                                                                                                            var17_25 = true ^ var7_7.getHasMaxPrecision();
                                                                                                            if (var13_21 || var11_19.signum() <= 0 || var4_4 != null && !var4_4.isValueZero()) break block93;
                                                                                                            var94_26 = this.helper.GetMantissaFastInt(var1_1);
                                                                                                            if (!var5_5 || (var9_9 & 1) == 0 || !var94_26.isValueZero()) break block94;
                                                                                                            var121_27 = var7_7.rounding;
                                                                                                            var95_28 = var9_9;
                                                                                                            if (var121_27 == ERounding.Floor) break block95;
                                                                                                            var19_29 = this.EnsureSign(var1_1, false);
                                                                                                            var20_30 = 0;
                                                                                                            break block96;
                                                                                                        }
                                                                                                        var95_28 = var9_9;
                                                                                                    }
                                                                                                    var19_29 = var1_1;
                                                                                                    var20_30 = var95_28;
                                                                                                }
                                                                                                var21_31 = this.helper.CreateShiftAccumulatorWithDigitsFastInt(var94_26, var2_2, var3_3);
                                                                                                var96_32 = var21_31.GetDigitLength();
                                                                                                if (var96_32.compareTo(var11_19) > 0) break block97;
                                                                                                var97_33 = var7_7.rounding;
                                                                                                var98_34 = var20_30 & 1;
                                                                                                var18_35 = var13_21;
                                                                                                var99_36 = var98_34 != 0;
                                                                                                if (this.RoundGivenAccum(var21_31, var97_33, var99_36)) break block98;
                                                                                                if (var7_7.hasFlags && (var2_2 | var3_3) != 0) {
                                                                                                    var7_7.setFlags(3 | var7_7.flags);
                                                                                                }
                                                                                                if (!var7_7.hasExponentRange) {
                                                                                                    return var19_29;
                                                                                                }
                                                                                                var114_37 = this.helper.GetExponentFastInt(var19_29);
                                                                                                if (var7_7.adjustExponent) {
                                                                                                    var117_38 = var114_37.ToFastInteger();
                                                                                                    var117_38.Add(var11_19);
                                                                                                    var115_39 = var117_38.Decrement();
                                                                                                    var119_40 = var15_23.Copy();
                                                                                                    var119_40.Add(var11_19);
                                                                                                    var116_41 = var119_40.Decrement();
                                                                                                } else {
                                                                                                    var115_39 = var114_37.ToFastInteger();
                                                                                                    var116_41 = var15_23;
                                                                                                }
                                                                                                if (var115_39.compareTo(var14_22) <= 0 && var115_39.compareTo(var116_41) >= 0) {
                                                                                                    return var19_29;
                                                                                                }
                                                                                                break block99;
                                                                                            }
                                                                                            if (var7_7.hasFlags && (var2_2 | var3_3) != 0) {
                                                                                                var7_7.setFlags(3 | var7_7.flags);
                                                                                            }
                                                                                            var100_42 = var94_26.Increment();
                                                                                            var101_43 = var96_32.compareTo(var11_19);
                                                                                            if (var101_43 < 0) ** GOTO lbl-1000
                                                                                            if (var101_43 != 0) break block100;
                                                                                            var113_44 = this.thisRadix;
                                                                                            var111_45 = 1;
                                                                                            if ((var113_44 & var111_45) != 0 || var100_42.isEvenNumber()) break block101;
                                                                                            ** GOTO lbl-1000
                                                                                        }
                                                                                        var111_45 = 1;
                                                                                    }
                                                                                    if ((var112_46 = this.TryMultiplyByRadixPower(EInteger.FromInt32(var111_45), var11_19)) == null) {
                                                                                        return this.SignalInvalidWithMessage(var7_7, "Result requires too much memory");
                                                                                    }
                                                                                    if (var100_42.ToEInteger().compareTo(var112_46) >= 0) {
                                                                                        var102_47 = false;
                                                                                    } else lbl-1000: // 3 sources:
                                                                                    {
                                                                                        var102_47 = true;
                                                                                    }
                                                                                    if (var102_47) {
                                                                                        if (!var7_7.hasExponentRange) {
                                                                                            var110_48 = this.helper;
                                                                                            return var110_48.CreateNewWithFlagsFastInt(var100_42, var110_48.GetExponentFastInt(var19_29), var20_30);
                                                                                        }
                                                                                        var103_49 = this.helper.GetExponentFastInt(var19_29);
                                                                                        if (var7_7.adjustExponent) {
                                                                                            var106_50 = var103_49.ToFastInteger();
                                                                                            var106_50.Add(var11_19);
                                                                                            var104_51 = var106_50.Decrement();
                                                                                            var108_52 = var15_23.Copy();
                                                                                            var108_52.Add(var11_19);
                                                                                            var105_53 = var108_52.Decrement();
                                                                                        } else {
                                                                                            var104_51 = var103_49.ToFastInteger();
                                                                                            var105_53 = var15_23;
                                                                                        }
                                                                                        if (var104_51.compareTo(var14_22) <= 0 && var104_51.compareTo(var105_53) >= 0) {
                                                                                            return this.helper.CreateNewWithFlagsFastInt(var100_42, var103_49, var20_30);
                                                                                        }
                                                                                    }
                                                                                    break block99;
                                                                                }
                                                                                var18_35 = var13_21;
                                                                                break block99;
                                                                            }
                                                                            var18_35 = var13_21;
                                                                            var19_29 = var1_1;
                                                                            var20_30 = var9_9;
                                                                            var21_31 = null;
                                                                        }
                                                                        if (var5_5 && (var20_30 & 1) != 0 && var16_24 != ERounding.Floor && this.helper.GetMantissa(var19_29).isZero()) {
                                                                            var19_29 = this.EnsureSign(var19_29, false);
                                                                            var20_30 = 0;
                                                                        }
                                                                        var22_54 = (var20_30 & 1) != 0 ? 1 : 0;
                                                                        var23_55 = this.helper.GetMantissaFastInt(var19_29);
                                                                        var24_56 = var23_55.isValueZero() != false && (var2_2 | var3_3) == 0;
                                                                        var25_57 = this.helper.GetExponentFastInt(var19_29).ToFastInteger();
                                                                        if (var21_31 == null) {
                                                                            var21_31 = this.helper.CreateShiftAccumulatorWithDigitsFastInt(var23_55, var2_2, var3_3);
                                                                        }
                                                                        if (!var18_35) break block102;
                                                                        var87_58 = this.thisRadix;
                                                                        if (var87_58 != 2) break block103;
                                                                        var27_59 = var11_19;
                                                                        break block104;
                                                                    }
                                                                    if (var87_58 != 10 || var11_19.CompareToInt(2135) > 0) break block105;
                                                                    var27_59 = new FastInteger(1 + (631305 * (var11_19.AsInt32() - 1) >> 21));
                                                                }
                                                                var26_60 = var15_23;
                                                                break block106;
                                                            }
                                                            var88_61 = this.helper;
                                                            var89_62 = EInteger.FromInt32(1);
                                                            var90_63 = var11_19.Copy();
                                                            break block107;
                                                        }
                                                        var26_60 = var15_23;
                                                        var27_59 = var11_19;
                                                        break block106;
                                                    }
                                                    while (var90_63.signum() > 0) {
                                                        var91_64 = var15_23;
                                                        var92_65 = 1000000;
                                                        if (var90_63.CompareToInt(var92_65) < 0) {
                                                            var92_65 = var90_63.AsInt32();
                                                        }
                                                        var89_62 = var89_62.ShiftLeft(var92_65);
                                                        var90_63.SubtractInt(var92_65);
                                                        var15_23 = var91_64;
                                                    }
                                                    var26_60 = var15_23;
                                                    var27_59 = var88_61.GetDigitLength(var89_62.Subtract(EInteger.FromInt32(1)).Subtract(1));
                                                }
                                                var28_66 = var16_24 != ERounding.HalfEven && var16_24 != ERounding.HalfUp && var16_24 != ERounding.HalfDown;
                                                if (!var17_25) {
                                                    var21_31.ShiftToDigits(var27_59, var4_4, var28_66);
                                                } else {
                                                    if (var4_4 != null && var4_4.signum() != 0) {
                                                        var21_31.TruncateOrShiftRight(var4_4, var28_66);
                                                    }
                                                    var27_59 = var21_31.GetDigitLength();
                                                }
                                                if (var18_35) {
                                                    while (this.IsHigherThanBitLength(var21_31.getShiftedInt(), var11_19)) {
                                                        var21_31.ShiftRightInt(1);
                                                    }
                                                }
                                                var29_67 = var21_31.getDiscardedDigitCount().Copy();
                                                var25_57.Add(var29_67);
                                                if (var7_7.adjustExponent) {
                                                    var85_68 = var25_57.Copy();
                                                    var31_69 = var29_67;
                                                    var85_68.Add(var21_31.GetDigitLength());
                                                    var32_70 = var85_68.Decrement();
                                                } else {
                                                    var31_69 = var29_67;
                                                    var32_70 = var25_57.Copy();
                                                }
                                                if (var18_35 && var14_22 != null && var32_70.compareTo(var14_22) == 0) {
                                                    var81_71 = var27_59.Copy();
                                                    var33_72 = var28_66;
                                                    var81_71.Subtract(var21_31.GetDigitLength());
                                                    var83_73 = this.TryMultiplyByRadixPower(var21_31.getShiftedInt(), var81_71);
                                                    if (var83_73 == null) {
                                                        return this.SignalInvalidWithMessage(var7_7, "Result requires too much memory");
                                                    }
                                                    if (this.IsHigherThanBitLength(var83_73, var11_19)) {
                                                        var32_70.Increment();
                                                    }
                                                } else {
                                                    var33_72 = var28_66;
                                                }
                                                if (var14_22 != null && var32_70.compareTo(var14_22) > 0) {
                                                    if (var24_56 == false) return this.SignalOverflow(var7_7, (boolean)var22_54);
                                                    if (var7_7.hasFlags) {
                                                        var7_7.setFlags(32 | var7_7.flags);
                                                    }
                                                    if (var7_7.getClampNormalExponents() == false) return this.helper.CreateNewWithFlagsFastInt(var23_55, FastIntegerFixed.FromFastInteger(var14_22), var20_30);
                                                    if (var7_7.adjustExponent == false) return this.helper.CreateNewWithFlagsFastInt(var23_55, FastIntegerFixed.FromFastInteger(var14_22), var20_30);
                                                    var79_74 = var14_22.Copy();
                                                    var79_74.Increment().Subtract(var27_59);
                                                    if (var14_22.compareTo(var79_74) <= 0) return this.helper.CreateNewWithFlagsFastInt(var23_55, FastIntegerFixed.FromFastInteger(var14_22), var20_30);
                                                    var14_22 = var79_74;
                                                    return this.helper.CreateNewWithFlagsFastInt(var23_55, FastIntegerFixed.FromFastInteger(var14_22), var20_30);
                                                }
                                                if (var26_60 == null || var32_70.compareTo(var58_75 = var26_60) >= 0) break block108;
                                                if (var7_7.adjustExponent) {
                                                    var77_76 = var58_75.Copy();
                                                    var77_76.Subtract(var27_59);
                                                    var59_77 = var77_76.Increment();
                                                } else {
                                                    var59_77 = var58_75;
                                                }
                                                var60_78 = var32_70;
                                                if (!var7_7.hasFlags || var21_31.getShiftedInt().isZero()) break block109;
                                                if (!this.RoundGivenAccum(var21_31, var16_24, (boolean)var22_54)) break block110;
                                                var72_79 = var21_31.getShiftedInt();
                                                var34_80 = var11_19;
                                                var73_81 = var72_79.Add(EInteger.FromInt32(1));
                                                if (var17_25 || !var73_81.isEven() && (1 & this.thisRadix) == 0) break block111;
                                                var74_82 = this.helper.GetDigitLength(var73_81);
                                                if (var18_35 || var74_82.compareTo(var27_59) > 0) {
                                                    var74_82 = var27_59.Copy();
                                                }
                                                if (var7_7.adjustExponent) {
                                                    var75_83 = var25_57.Copy();
                                                    var75_83.Add(var74_82);
                                                    var71_84 = var75_83.Decrement();
                                                } else {
                                                    var71_84 = var25_57;
                                                }
                                                break block112;
                                            }
                                            var34_80 = var11_19;
                                        }
                                        var71_84 = var60_78;
                                    }
                                    if (var71_84.compareTo(var58_75) >= 0) break block113;
                                    var36_85 = 4;
                                    break block114;
                                }
                                var34_80 = var11_19;
                            }
                            var36_85 = 0;
                        }
                        if (var25_57.Copy().compareTo(var59_77) < 0) {
                            var61_86 = var59_77.Copy();
                            var61_86.Subtract(var25_57);
                            var21_31.TruncateOrShiftRight(var61_86, var33_72);
                            var63_87 = var21_31.getShiftedIntFast();
                            var64_88 = (var21_31.getLastDiscardedDigit() | var21_31.getOlderDiscardedDigits()) != 0;
                            if (var64_88 && var16_24 == ERounding.None) {
                                return this.SignalInvalidWithMessage(var7_7, "Rounding was required");
                            }
                            if (var21_31.getDiscardedDigitCount().signum() != 0 || var64_88) {
                                if (var7_7.hasFlags) {
                                    if (!var24_56) {
                                        var36_85 |= 2;
                                    }
                                    if (var64_88) {
                                        var36_85 |= 3;
                                    }
                                }
                                if (this.RoundGivenAccum(var21_31, var16_24, (boolean)var22_54)) {
                                    var63_87.Increment();
                                }
                            }
                            if (var7_7.hasFlags) {
                                if (var63_87.isValueZero()) {
                                    var36_85 |= 32;
                                }
                                if ((var36_85 & 5) == 5) {
                                    var36_85 |= 10;
                                }
                                var7_7.setFlags(var36_85 | var7_7.flags);
                            }
                            if (var7_7.getClampNormalExponents()) {
                                var65_89 = var14_22.Copy();
                                if (var7_7.adjustExponent) {
                                    var65_89.Increment().Subtract(var27_59);
                                }
                                if (var59_77.compareTo(var65_89) > 0) {
                                    if (!var63_87.isValueZero()) {
                                        var66_90 = var59_77.Copy();
                                        var66_90.Subtract(var65_89);
                                        var68_91 = this.TryMultiplyByRadixPowerFastInt(FastIntegerFixed.FromFastInteger(var63_87), var66_90);
                                        if (var68_91 == null) {
                                            return this.SignalInvalidWithMessage(var7_7, "Result requires too much memory");
                                        }
                                        if (var7_7.hasFlags == false) return this.helper.CreateNewWithFlagsFastInt(var68_91, FastIntegerFixed.FromFastInteger(var65_89), var22_54);
                                        var7_7.setFlags(32 | var7_7.flags);
                                        return this.helper.CreateNewWithFlagsFastInt(var68_91, FastIntegerFixed.FromFastInteger(var65_89), var22_54);
                                    }
                                    if (var7_7.hasFlags) {
                                        var7_7.setFlags(32 | var7_7.flags);
                                    }
                                    var59_77 = var65_89;
                                }
                            }
                            if (var7_7.hasFlags == false) return this.helper.CreateNewWithFlagsFastInt(FastIntegerFixed.FromFastInteger(var63_87), FastIntegerFixed.FromFastInteger(var59_77), var22_54);
                            var7_7.setFlags(var36_85 | var7_7.flags);
                            return this.helper.CreateNewWithFlagsFastInt(FastIntegerFixed.FromFastInteger(var63_87), FastIntegerFixed.FromFastInteger(var59_77), var22_54);
                        }
                        var35_92 = var33_72;
                        break block115;
                    }
                    var34_80 = var11_19;
                    var35_92 = var33_72;
                    var36_85 = 0;
                }
                var37_93 = var21_31.getDiscardedDigitCount().signum() != 0 || (var21_31.getLastDiscardedDigit() | var21_31.getOlderDiscardedDigits()) != 0;
                if (!var37_93) break block116;
                if (!var23_55.isValueZero()) {
                    var36_85 |= 2;
                    if (var16_24 == ERounding.None) {
                        return this.SignalInvalidWithMessage(var7_7, "Rounding was required");
                    }
                }
                var23_55 = FastIntegerFixed.FromFastInteger(var21_31.getShiftedIntFast());
                if ((var21_31.getLastDiscardedDigit() | var21_31.getOlderDiscardedDigits()) != 0) {
                    var36_85 |= 3;
                    if (var16_24 == ERounding.None) {
                        return this.SignalInvalidWithMessage(var7_7, "Rounding was required");
                    }
                }
                if (!this.RoundGivenAccum(var21_31, var16_24, (boolean)var22_54)) break block116;
                var23_55 = var23_55.Increment();
                var39_94 = false | var18_35;
                if (var17_25 || !var23_55.isEvenNumber() && (1 & this.thisRadix) == 0 || !var18_35 && var21_31.GetDigitLength().compareTo(var27_59) < 0) ** GOTO lbl-1000
                var21_31 = this.helper.CreateShiftAccumulatorWithDigitsFastInt(var23_55, 0, 0);
                var51_95 = var21_31.GetDigitLength();
                if (!var18_35 && var51_95.compareTo(var27_59) <= 0) lbl-1000: // 2 sources:
                {
                    var38_96 = var34_80;
                } else {
                    var52_97 = var51_95.Copy();
                    var52_97.Subtract(var27_59);
                    var21_31.TruncateOrShiftRight(var52_97, var35_92);
                    if (var18_35) {
                        while (this.IsHigherThanBitLength(var57_98 = var21_31.getShiftedInt(), var38_96 = var34_80)) {
                            var21_31.ShiftRightInt(1);
                            var34_80 = var38_96;
                        }
                    } else {
                        var38_96 = var34_80;
                    }
                    if (var21_31.getDiscardedDigitCount().signum() != 0) {
                        var25_57.Add(var21_31.getDiscardedDigitCount());
                        var55_99 = var21_31.getDiscardedDigitCount();
                        var31_69.Add(var55_99);
                        var23_55 = FastIntegerFixed.FromFastInteger(var21_31.getShiftedIntFast());
                        var39_94 |= var18_35 ^ true;
                    }
                }
                break block117;
            }
            var38_96 = var34_80;
            var39_94 = false;
        }
        if (var14_22 != null && var39_94) {
            var44_100 = var25_57.Copy();
            if (var7_7.adjustExponent) {
                var44_100.Add(var21_31.GetDigitLength());
                var44_100.Decrement();
            }
            if (var18_35 && var44_100.compareTo(var14_22) == 0) {
                var45_101 = var27_59.Copy();
                var45_101.Subtract(var21_31.GetDigitLength());
                var47_102 = this.TryMultiplyByRadixPower(var21_31.getShiftedInt(), var45_101);
                if (var47_102 == null) {
                    return this.SignalInvalidWithMessage(var7_7, "Result requires too much memory");
                }
                if (this.IsHigherThanBitLength(var47_102, var38_96)) {
                    var44_100.Increment();
                }
            }
            if (var44_100.compareTo(var14_22) > 0) {
                return this.SignalOverflow(var7_7, (boolean)var22_54);
            }
        }
        if (var7_7.hasFlags) {
            var7_7.setFlags(var36_85 | var7_7.flags);
        }
        if (var7_7.getClampNormalExponents() == false) return this.helper.CreateNewWithFlagsFastInt(var23_55, FastIntegerFixed.FromFastInteger(var25_57), var22_54);
        var40_103 = var14_22.Copy();
        if (var7_7.adjustExponent) {
            var40_103.Increment().Subtract(var27_59);
        }
        if (var25_57.compareTo(var40_103) <= 0) return this.helper.CreateNewWithFlagsFastInt(var23_55, FastIntegerFixed.FromFastInteger(var25_57), var22_54);
        if (!var23_55.isValueZero()) {
            var41_104 = var25_57.Copy();
            var41_104.Subtract(var40_103);
            var23_55 = this.TryMultiplyByRadixPowerFastInt(var23_55, var41_104);
            if (var23_55 == null) {
                return this.SignalInvalidWithMessage(var7_7, "Result requires too much memory");
            }
        }
        if (var7_7.hasFlags) {
            var7_7.setFlags(32 | var7_7.flags);
        }
        var25_57 = var40_103;
        return this.helper.CreateNewWithFlagsFastInt(var23_55, FastIntegerFixed.FromFastInteger(var25_57), var22_54);
    }

    public final T SignalInvalid(EContext eContext) {
        if (eContext != null && eContext.hasFlags) {
            eContext.setFlags(64 | eContext.flags);
        }
        if (this.support != 0) {
            return this.helper.CreateNewWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), 4);
        }
        throw new ArithmeticException("Invalid operation");
    }

    public final T SignalInvalidWithMessage(EContext eContext, String string) {
        if (eContext != null && eContext.hasFlags) {
            eContext.setFlags(64 | eContext.flags);
        }
        if (this.support != 0) {
            return this.helper.CreateNewWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), 4);
        }
        throw new ArithmeticException(string);
    }

    public final T SignalOverflow(EContext eContext, boolean bl) {
        ERounding eRounding = eContext.rounding;
        if (eContext.hasFlags) {
            eContext.setFlags(19 | eContext.flags);
        }
        if (eRounding == ERounding.None) {
            return this.SignalInvalidWithMessage(eContext, "Rounding was required");
        }
        if (eContext.getHasMaxPrecision() && eContext.hasExponentRange && (eRounding == ERounding.Down || eRounding == ERounding.ZeroFiveUp || eRounding == ERounding.OddOrZeroFiveUp || eRounding == ERounding.Odd || eRounding == ERounding.Ceiling && bl || eRounding == ERounding.Floor && !bl)) {
            EInteger.FromInt32(0);
            FastInteger fastInteger = FastInteger.FromBig(eContext.bigintPrecision);
            EInteger eInteger = this.TryMultiplyByRadixPower(EInteger.FromInt32(1), fastInteger);
            if (eInteger == null) {
                return this.SignalInvalidWithMessage(eContext, "Result requires too much memory");
            }
            EInteger eInteger2 = eInteger.Subtract(EInteger.FromInt32(1));
            FastInteger fastInteger2 = FastInteger.FromBig(eContext.getEMax());
            if (eContext.adjustExponent) {
                fastInteger2.Increment().Subtract(fastInteger);
            }
            return this.helper.CreateNewWithFlags(eInteger2, fastInteger2.AsEInteger(), (int)bl);
        }
        if (this.support == 0) {
            return null;
        }
        return this.helper.CreateNewWithFlags(EInteger.FromInt32(0), EInteger.FromInt32(0), bl | 2);
    }

    public final T SignalingNaNInvalid(T t2, EContext eContext) {
        if (eContext != null && eContext.hasFlags) {
            eContext.setFlags(64 | eContext.flags);
        }
        return this.ReturnQuietNaN(t2, eContext);
    }

    public final EInteger TryMultiplyByRadixPower(EInteger eInteger, FastInteger fastInteger) {
        if (eInteger.isZero()) {
            return eInteger;
        }
        if (!fastInteger.CanFitInInt32()) {
            FastInteger fastInteger2 = FastInteger.FromBig(valueMaxDigits);
            if (this.thisRadix != 10 || fastInteger.compareTo(fastInteger2) > 0) {
                return null;
            }
        }
        return this.helper.MultiplyByRadixPower(eInteger, fastInteger);
    }

    public final FastIntegerFixed TryMultiplyByRadixPowerFastInt(FastIntegerFixed fastIntegerFixed, FastInteger fastInteger) {
        if (fastIntegerFixed.isValueZero()) {
            return fastIntegerFixed;
        }
        if (!fastInteger.CanFitInInt32()) {
            FastInteger fastInteger2 = FastInteger.FromBig(valueMaxDigits);
            if (this.thisRadix != 10 || fastInteger.compareTo(fastInteger2) > 0) {
                return null;
            }
        }
        return FastIntegerFixed.FromBig(this.helper.MultiplyByRadixPower(fastIntegerFixed.ToEInteger(), fastInteger));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public int compareTo(T var1_1, T var2_2) {
        block45 : {
            block47 : {
                block48 : {
                    block46 : {
                        block33 : {
                            block44 : {
                                block40 : {
                                    block43 : {
                                        block41 : {
                                            block42 : {
                                                block34 : {
                                                    block39 : {
                                                        block35 : {
                                                            block38 : {
                                                                block36 : {
                                                                    block37 : {
                                                                        var3_3 = 1;
                                                                        if (var2_2 == null) {
                                                                            return var3_3;
                                                                        }
                                                                        var4_4 = this.helper.GetFlags(var1_1);
                                                                        if ((14 & (var4_4 | (var5_5 = this.helper.GetFlags(var2_2)))) != 0) {
                                                                            if ((var4_4 & 12) != 0) {
                                                                                if ((var5_5 & 12) == 0) return var3_3;
                                                                                return 0;
                                                                            }
                                                                            if ((var5_5 & 12) != 0) {
                                                                                return -1;
                                                                            }
                                                                            if ((var4_4 & 2) != 0) {
                                                                                if ((var4_4 & 3) == (var5_5 & 3)) {
                                                                                    return 0;
                                                                                }
                                                                                if ((var4_4 & 1) != 0) return -1;
                                                                                return var3_3;
                                                                            }
                                                                            if ((var5_5 & 2) == 0) {
                                                                                return 2;
                                                                            }
                                                                            if ((var4_4 & 3) == (var5_5 & 3)) {
                                                                                return 0;
                                                                            }
                                                                            if ((var5_5 & 1) != 0) return var3_3;
                                                                            return -1;
                                                                        }
                                                                        var6_6 = this.helper;
                                                                        var7_7 = var6_6.GetSign(var1_1);
                                                                        if (var7_7 != (var8_8 = var6_6.GetSign(var2_2))) {
                                                                            if (var7_7 >= var8_8) return var3_3;
                                                                            return -1;
                                                                        }
                                                                        if (var8_8 == 0) return 0;
                                                                        if (var7_7 == 0) {
                                                                            return 0;
                                                                        }
                                                                        var9_9 = var6_6.GetExponentFastInt(var1_1);
                                                                        var10_10 = var6_6.GetExponentFastInt(var2_2);
                                                                        var11_11 = var6_6.GetMantissaFastInt(var1_1);
                                                                        var12_12 = var6_6.GetMantissaFastInt(var2_2);
                                                                        var13_13 = var9_9.compareTo(var10_10);
                                                                        var14_14 = var11_11.compareTo(var12_12);
                                                                        if (var14_14 == 0) {
                                                                            if (var7_7 >= 0) return var13_13;
                                                                            return -var13_13;
                                                                        }
                                                                        if (var13_13 == 0) {
                                                                            if (var7_7 >= 0) return var14_14;
                                                                            return -var14_14;
                                                                        }
                                                                        if (!var9_9.CanFitInInt32() || !var10_10.CanFitInInt32()) break block33;
                                                                        if (!var11_11.CanFitInInt32() || !var12_12.CanFitInInt32()) break block34;
                                                                        var89_16 = var9_9.AsInt32();
                                                                        var90_17 = var10_10.AsInt32();
                                                                        var91_18 = var6_6.GetRadix();
                                                                        if (var89_16 < -1073741822 || var89_16 > 1073741822 || var90_17 < -1073741822 || var90_17 > 1073741822) break block35;
                                                                        var93_19 = var89_16 > var90_17 ? var89_16 - var90_17 : var90_17 - var89_16;
                                                                        if (var93_19 > 9 || var91_18 != 10) break block36;
                                                                        var101_20 = RadixMath.ValueTenPowers[var93_19];
                                                                        var102_21 = RadixMath.OverflowMaxes[var93_19];
                                                                        if (var13_13 <= 0) break block37;
                                                                        var106_22 = var11_11.AsInt32();
                                                                        var107_23 = var12_12.AsInt32();
                                                                        if (var106_22 > var102_21) break block35;
                                                                        var108_24 = var106_22 * var101_20;
                                                                        if (var108_24 == var107_23) ** GOTO lbl-1000
                                                                        if (var108_24 >= var107_23) ** GOTO lbl-1000
                                                                        ** GOTO lbl-1000
                                                                    }
                                                                    var103_25 = var11_11.AsInt32();
                                                                    var104_26 = var12_12.AsInt32();
                                                                    if (var104_26 > var102_21) break block35;
                                                                    var105_27 = var104_26 * var101_20;
                                                                    if (var103_25 == var105_27) ** GOTO lbl-1000
                                                                    if (var103_25 >= var105_27) ** GOTO lbl-1000
                                                                    ** GOTO lbl-1000
                                                                }
                                                                if (var93_19 > 30 || var91_18 != 2) break block35;
                                                                var94_28 = RadixMath.BitMasks[var93_19];
                                                                if (var13_13 <= 0) break block38;
                                                                var98_29 = var11_11.AsInt32();
                                                                var99_30 = var12_12.AsInt32();
                                                                if ((var94_28 & var98_29) != var98_29) break block35;
                                                                var100_31 = var98_29 << var93_19;
                                                                if (var100_31 == var99_30) ** GOTO lbl-1000
                                                                if (var100_31 >= var99_30) ** GOTO lbl-1000
                                                                ** GOTO lbl-1000
                                                            }
                                                            var95_32 = var11_11.AsInt32();
                                                            var96_33 = var12_12.AsInt32();
                                                            if ((var94_28 & var96_33) == var96_33) {
                                                                var97_34 = var96_33 << var93_19;
                                                                ** if (var95_32 != var97_34) goto lbl-1000
                                                            }
                                                            break block35;
lbl-1000: // 4 sources:
                                                            {
                                                                var92_35 = 0;
                                                                ** GOTO lbl95
                                                            }
lbl-1000: // 1 sources:
                                                            {
                                                                if (var95_32 < var97_34) lbl-1000: // 4 sources:
                                                                {
                                                                    var92_35 = -var7_7;
                                                                } else lbl-1000: // 4 sources:
                                                                {
                                                                    var92_35 = var7_7;
                                                                }
                                                            }
                                                            break block39;
                                                        }
                                                        var92_35 = 2;
                                                    }
                                                    if (var92_35 <= var3_3) {
                                                        return var92_35;
                                                    }
                                                    break block33;
                                                }
                                                if (!var11_11.CanFitInInt64() || !var12_12.CanFitInInt64()) break block33;
                                                var53_36 = var9_9.AsInt32();
                                                var54_37 = var10_10.AsInt32();
                                                var55_38 = var6_6.GetRadix();
                                                if (var53_36 < -1073741822 || var53_36 > 1073741822 || var54_37 < -1073741822 || var54_37 > 1073741822) break block40;
                                                var57_39 = var53_36 > var54_37 ? (long)(var53_36 - var54_37) : (long)(var54_37 - var53_36);
                                                if (var57_39 > 18L || var55_38 != 10) break block41;
                                                var73_40 = RadixMath.ValueTenPowers64;
                                                var74_41 = (int)var57_39;
                                                var75_42 = var73_40[var74_41];
                                                var77_43 = RadixMath.OverflowMaxes64[var74_41];
                                                if (var13_13 <= 0) break block42;
                                                var84_44 = var11_11.AsInt64();
                                                var86_45 = var12_12.AsInt64();
                                                if (var84_44 > var77_43) break block40;
                                                var88_46 = var84_44 * var75_42 LCMP var86_45;
                                                if (var88_46 == false) ** GOTO lbl-1000
                                                if (var88_46 >= 0) ** GOTO lbl-1000
                                                ** GOTO lbl-1000
                                            }
                                            var79_47 = var11_11.AsInt64();
                                            var81_48 = var12_12.AsInt64();
                                            if (var81_48 > var77_43) break block40;
                                            var83_49 = var79_47 LCMP var81_48 * var75_42;
                                            if (var83_49 == false) ** GOTO lbl-1000
                                            if (var83_49 >= 0) ** GOTO lbl-1000
                                            ** GOTO lbl-1000
                                        }
                                        if (var57_39 > 62L || var55_38 != 2) break block40;
                                        var59_50 = RadixMath.BitMasks64;
                                        var60_51 = (int)var57_39;
                                        var61_52 = var59_50[var60_51];
                                        if (var13_13 <= 0) break block43;
                                        var68_53 = var11_11.AsInt64();
                                        var70_54 = var12_12.AsInt64();
                                        if ((var61_52 & var68_53) != var68_53) break block40;
                                        var72_55 = var68_53 << var60_51 LCMP var70_54;
                                        if (var72_55 == false) ** GOTO lbl-1000
                                        if (var72_55 >= 0) ** GOTO lbl-1000
                                        ** GOTO lbl-1000
                                    }
                                    var63_56 = var11_11.AsInt64();
                                    var65_57 = var12_12.AsInt64();
                                    if ((var61_52 & var65_57) == var65_57) {
                                        var67_58 = var63_56 LCMP var65_57 << var60_51;
                                        ** if (var67_58 != false) goto lbl-1000
                                    }
                                    break block40;
lbl-1000: // 4 sources:
                                    {
                                        var56_59 = 0;
                                        ** GOTO lbl156
                                    }
lbl-1000: // 1 sources:
                                    {
                                        if (var67_58 < 0) lbl-1000: // 4 sources:
                                        {
                                            var56_59 = -var7_7;
                                        } else lbl-1000: // 4 sources:
                                        {
                                            var56_59 = var7_7;
                                        }
                                    }
                                    break block44;
                                }
                                var56_59 = 2;
                            }
                            if (var56_59 <= var3_3) {
                                return var56_59;
                            }
                        }
                        var15_60 = var9_9.ToEInteger();
                        var16_61 = var10_10.ToEInteger();
                        var17_62 = var11_11.ToEInteger();
                        var18_63 = var12_12.ToEInteger();
                        var19_64 = FastInteger.FromBig(var15_60);
                        var20_65 = FastInteger.FromBig(var16_61);
                        var21_66 = var19_64.Copy();
                        var21_66.Subtract(var20_65);
                        var23_67 = var21_66.Abs();
                        if (var23_67.CompareToInt(100) < 0) break block45;
                        var27_68 = var6_6.GetDigitLength(var17_62);
                        var28_69 = var6_6.GetDigitLength(var18_63);
                        var29_70 = var19_64.Copy();
                        var29_70.Add(var27_68);
                        var31_71 = var29_70.Decrement();
                        var32_72 = var20_65.Copy();
                        var32_72.Add(var28_69);
                        var3_3 = var31_71.compareTo(var32_72.Decrement());
                        if (var3_3 != 0) {
                            if (var7_7 >= 0) return var3_3;
                            return -var3_3;
                        }
                        if (var27_68.compareTo(var28_69) <= 0) {
                            var27_68 = var28_69;
                        }
                        if (var23_67.Copy().compareTo(var27_68) <= 0) break block45;
                        var34_73 = var19_64.compareTo(var20_65);
                        if (var34_73 >= 0) break block46;
                        if (var18_63.isZero()) break block47;
                        var44_74 = var6_6.GetDigitLength(var17_62);
                        var45_75 = var19_64.Copy();
                        var45_75.Add(var44_74);
                        var45_75.AddInt(2);
                        if (var45_75.compareTo(var20_65) >= 0) break block47;
                        var48_76 = var20_65.Copy().SubtractInt(8);
                        var48_76.Subtract(var44_74);
                        var48_76.Subtract(var27_68);
                        var51_77 = var48_76.Copy();
                        var51_77.Subtract(var20_65);
                        if (var51_77.Abs().compareTo(var23_67) >= 0) break block47;
                        break block48;
                    }
                    if (var34_73 > 0 && !var17_62.isZero()) {
                        var35_78 = var6_6.GetDigitLength(var18_63);
                        var36_79 = var20_65.Copy();
                        var36_79.Add(var35_78);
                        var36_79.AddInt(2);
                        if (var36_79.compareTo(var19_64) < 0) {
                            var39_80 = var19_64.Copy().SubtractInt(8);
                            var39_80.Subtract(var35_78);
                            var39_80.Subtract(var27_68);
                            var42_81 = var39_80.Copy();
                            var42_81.Subtract(var19_64);
                            if (var42_81.Abs().compareTo(var23_67) < 0) {
                                if (var7_7 >= 0) return 1;
                                return -1;
                            }
                        }
                    }
                    break block47;
                }
                if (var7_7 >= 0) return -1;
                return 1;
            }
            var13_13 = var15_60.compareTo(var16_61);
        }
        if (var13_13 > 0) {
            var26_82 = RadixMath.RescaleByExponentDiff(var17_62, var15_60, var16_61, var6_6);
            if (var26_82 == null) throw new OutOfMemoryError("Result requires too much memory");
            var25_15 = var26_82.compareTo(var18_63);
            if (var7_7 >= 0) return var25_15;
            return -var25_15;
        } else {
            var24_83 = RadixMath.RescaleByExponentDiff(var18_63, var15_60, var16_61, var6_6);
            if (var24_83 == null) throw new OutOfMemoryError("Result requires too much memory");
            var25_15 = var17_62.compareTo(var24_83);
            if (var7_7 >= 0) return var25_15;
        }
        return -var25_15;
    }
}

