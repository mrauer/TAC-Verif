/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.upokecenter.numbers.DigitShiftAccumulator
 *  com.upokecenter.numbers.EDecimal
 *  com.upokecenter.numbers.EFloat
 *  com.upokecenter.numbers.EInteger
 *  com.upokecenter.numbers.ERounding
 *  com.upokecenter.numbers.FastInteger
 *  com.upokecenter.numbers.FastIntegerFixed
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package com.upokecenter.cbor;

import com.upokecenter.numbers.DigitShiftAccumulator;
import com.upokecenter.numbers.EContext;
import com.upokecenter.numbers.EDecimal;
import com.upokecenter.numbers.EFloat;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ERounding;
import com.upokecenter.numbers.FastInteger;
import com.upokecenter.numbers.FastIntegerFixed;
import java.util.Objects;

public final class CBORUtilities {
    public static final int[] ValueLeapDays;
    public static final int[] ValueNormalDays;

    public static {
        ValueNormalDays = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        ValueLeapDays = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    }

    public static int ByteArrayCompare(byte[] arrby, byte[] arrby2) {
        int n2 = -1;
        if (arrby == null) {
            if (arrby2 == null) {
                n2 = 0;
            }
            return n2;
        }
        if (arrby2 == null) {
            return 1;
        }
        int n3 = Math.min((int)arrby.length, (int)arrby2.length);
        for (int i2 = 0; i2 < n3; ++i2) {
            if (arrby[i2] == arrby2[i2]) continue;
            if (arrby[i2] < arrby2[i2]) {
                return n2;
            }
            return 1;
        }
        if (arrby.length != arrby2.length) {
            if (arrby.length < arrby2.length) {
                return n2;
            }
            return 1;
        }
        return 0;
    }

    public static String DoubleToString(double d2) {
        EFloat eFloat = EFloat.FromDouble((double)d2);
        EContext eContext = EContext.Binary64;
        Objects.requireNonNull((Object)eFloat);
        if (eContext != null && eContext.getHasMaxPrecision()) {
            if (eFloat.IsNaN()) {
                return EFloat.CreateNaN((EInteger)eFloat.unsignedMantissa, (boolean)eFloat.IsSignalingNaN(), (boolean)eFloat.isNegative(), (EContext)eContext).toString();
            }
            if (eFloat.IsInfinity()) {
                return eFloat.RoundToPrecision(eContext).toString();
            }
            EContext eContext2 = new EContext(eContext.adjustExponent, eContext.bigintPrecision, eContext.clampNormalExponents, eContext.exponentMax, eContext.exponentMin, 0, eContext.hasExponentRange, false, eContext.precisionInBits, eContext.rounding, eContext.simplified, eContext.traps);
            EFloat eFloat2 = eFloat.RoundToPrecision(eContext);
            if (eFloat2.IsInfinity()) {
                return eFloat2.toString();
            }
            if (eFloat.isZero()) {
                return eFloat.RoundToPrecision(eContext).toString();
            }
            EDecimal eDecimal = EDecimal.FromEFloat((EFloat)eFloat);
            if (eContext.bigintPrecision.compareTo(10) >= 0) {
                EInteger eInteger = eContext.bigintPrecision.ShiftRight(1).Add(EInteger.FromInt32((int)3));
                EInteger eInteger2 = eDecimal.getUnsignedMantissa();
                EInteger eInteger3 = eDecimal.getExponent();
                boolean bl = eDecimal.isNegative();
                DigitShiftAccumulator digitShiftAccumulator = new DigitShiftAccumulator(eInteger2, 0, 0);
                digitShiftAccumulator.ShiftToDigits(FastInteger.FromBig((EInteger)eInteger), null, false);
                EInteger eInteger4 = digitShiftAccumulator.getShiftedInt();
                EInteger eInteger5 = eInteger3.Add(digitShiftAccumulator.getDiscardedDigitCount().AsEInteger());
                if ((digitShiftAccumulator.bitLeftmost != 0 || digitShiftAccumulator.bitsAfterLeftmost != 0) && eInteger4.Remainder(10).ToInt32Checked() != 9) {
                    eInteger4 = eInteger4.Add(1);
                }
                EDecimal eDecimal2 = EDecimal.Create((EInteger)eInteger4, (EInteger)eInteger5);
                eDecimal = bl ? new EDecimal(eDecimal2.unsignedMantissa, eDecimal2.exponent, 1 ^ eDecimal2.flags) : eDecimal2;
            }
            EInteger eInteger = eFloat.unsignedMantissa;
            boolean bl = !eInteger.negative && eInteger.wordCount > 0 && eInteger.GetUnsignedBitLengthAsEInteger().Subtract(1).equals((Object)eInteger.GetLowBitAsEInteger());
            EInteger eInteger6 = EInteger.FromInt32((int)0);
            do {
                EInteger eInteger7;
                EDecimal eDecimal3;
                if ((eDecimal3 = eDecimal.RoundToPrecision(eContext2.WithBigPrecision(eInteger7 = eInteger6.Add(EInteger.FromInt32((int)1))))).ToEFloat(eContext2).compareTo(eFloat2) == 0) {
                    if (bl) {
                        EContext eContext3 = eContext2.WithBigPrecision(eInteger6);
                        EDecimal eDecimal4 = eDecimal.RoundToPrecision(eContext3);
                        Objects.requireNonNull((Object)eDecimal4);
                        EDecimal eDecimal5 = (EDecimal)EDecimal.GetMathValue((EContext)eContext3).NextPlus((Object)eDecimal4, eContext3);
                        if (eDecimal5.ToEFloat(eContext2).compareTo(eFloat2) == 0) {
                            eDecimal3 = eDecimal5;
                        }
                    }
                    if (eDecimal3.getExponent().signum() > 0 && eDecimal3.Abs().compareTo(EDecimal.FromInt32((int)10000000)) < 0) {
                        return eDecimal3.ToStringInternal(2);
                    }
                    return eDecimal3.toString();
                }
                eInteger6 = eInteger7;
            } while (true);
        }
        return eFloat.toString();
    }

    public static String FirstCharLower(String string) {
        if (string.length() > 0 && string.charAt(0) >= 'A' && string.charAt(0) <= 'Z') {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((char)(32 + string.charAt(0)));
            stringBuilder.append(string.substring(1));
            string = stringBuilder.toString();
        }
        return string;
    }

    public static String FirstCharUpper(String string) {
        if (string.length() > 0 && string.charAt(0) >= 'a' && string.charAt(0) <= 'z') {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((char)(-32 + string.charAt(0)));
            stringBuilder.append(string.substring(1));
            string = stringBuilder.toString();
        }
        return string;
    }

    public static EInteger FloorDiv(EInteger eInteger, EInteger eInteger2) {
        if (eInteger.signum() >= 0) {
            return eInteger.Divide(eInteger2);
        }
        return EInteger.FromInt32((int)-1).Subtract(EInteger.FromInt32((int)-1).Subtract(eInteger).Divide(eInteger2));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long HalfToDoublePrecision(int n2) {
        long l2;
        long l3;
        long l4 = (long)(32768 & n2) << 48;
        int n3 = 31 & n2 >> 10;
        int n4 = n2 & 1023;
        if (n3 == 31) {
            l2 = 9218868437227405312L | (long)n4 << 42;
            do {
                return l4 | l2;
                break;
            } while (true);
        }
        if (n3 == 0) {
            if (n4 == 0) {
                return l4;
            }
            int n5 = n3 + 1;
            while (n4 < 1024) {
                n4 <<= 1;
                --n5;
            }
            l3 = (long)(n5 + 1008) << 52;
            n4 &= 1023;
        } else {
            l3 = (long)(n3 + 1008) << 52;
        }
        l2 = l3 | (long)n4 << 42;
        return l4 | l2;
    }

    public static String LongToString(long l2) {
        long l3 = l2;
        if (l3 == Long.MIN_VALUE) {
            return "-9223372036854775808";
        }
        long l4 = l3 LCMP 0L;
        if (l4 == false) {
            return "0";
        }
        if (l3 == Integer.MIN_VALUE) {
            return "-2147483648";
        }
        boolean bl = l4 < 0;
        int n2 = (int)l3;
        if ((long)n2 == l3) {
            char[] arrc = new char[12];
            int n3 = 11;
            if (bl) {
                n2 = -n2;
            }
            while (n2 > 43698) {
                int n4 = n2 / 10;
                char c2 = "0123456789ABCDEF".charAt(n2 - n4 * 10);
                int n5 = n3 - 1;
                arrc[n3] = c2;
                n3 = n5;
                n2 = n4;
            }
            while (n2 > 9) {
                int n6 = n2 * 26215 >> 18;
                char c3 = "0123456789ABCDEF".charAt(n2 - n6 * 10);
                int n7 = n3 - 1;
                arrc[n3] = c3;
                n3 = n7;
                n2 = n6;
            }
            if (n2 != 0) {
                int n8 = n3 - 1;
                arrc[n3] = "0123456789ABCDEF".charAt(n2);
                n3 = n8;
            }
            if (bl) {
                arrc[n3] = 45;
            } else {
                ++n3;
            }
            return new String(arrc, n3, 12 - n3);
        }
        char[] arrc = new char[24];
        int n9 = 23;
        if (bl) {
            l3 = -l3;
        }
        while (l3 > 43698L) {
            long l5 = l3 / 10L;
            char c4 = "0123456789ABCDEF".charAt((int)(l3 - 10L * l5));
            int n10 = n9 - 1;
            arrc[n9] = c4;
            n9 = n10;
            l3 = l5;
        }
        while (l3 > 9L) {
            long l6 = 26215L * l3 >> 18;
            char c5 = "0123456789ABCDEF".charAt((int)(l3 - l6 * 10L));
            int n11 = n9 - 1;
            arrc[n9] = c5;
            n9 = n11;
            l3 = l6;
        }
        if (l3 != 0L) {
            int n12 = n9 - 1;
            arrc[n9] = "0123456789ABCDEF".charAt((int)l3);
            n9 = n12;
        }
        if (bl) {
            arrc[n9] = 45;
        } else {
            ++n9;
        }
        return new String(arrc, n9, 24 - n9);
    }

    public static boolean NameStartsWithWord(String string, String string2) {
        boolean bl;
        block2 : {
            block4 : {
                int n2;
                block3 : {
                    n2 = string2.length();
                    int n3 = string.length();
                    bl = false;
                    if (n3 <= n2) break block2;
                    boolean bl2 = string.substring(0, n2).equals((Object)string2);
                    bl = false;
                    if (!bl2) break block2;
                    if (string.charAt(n2) < 'a') break block3;
                    char c2 = string.charAt(n2);
                    bl = false;
                    if (c2 <= 'z') break block2;
                }
                if (string.charAt(n2) < '0') break block4;
                char c3 = string.charAt(n2);
                bl = false;
                if (c3 <= '9') break block2;
            }
            bl = true;
        }
        return bl;
    }

    public static int RoundedShift(long l2, int n2) {
        long l3 = (1L << n2) - 1L;
        long l4 = 1L << n2 - 1;
        long l5 = l2 >> n2;
        long l6 = l2 & l3 LCMP l4;
        if (l6 <= 0 && (l6 != false || (l5 & 1L) == 0L)) {
            return (int)l5;
        }
        return 1 + (int)l5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long SingleToDoublePrecision(int n2) {
        long l2;
        long l3;
        long l4 = (long)(1 & n2 >> 31) << 63;
        int n3 = 255 & n2 >> 23;
        int n4 = n2 & 8388607;
        if (n3 == 255) {
            l2 = 9218868437227405312L | (long)n4 << 29;
            do {
                return l4 | l2;
                break;
            } while (true);
        }
        if (n3 == 0) {
            if (n4 == 0) {
                return l4;
            }
            int n5 = n3 + 1;
            while (n4 < 8388608) {
                n4 <<= 1;
                --n5;
            }
            l3 = (long)(n5 + 896) << 52;
            n4 &= 8388607;
        } else {
            l3 = (long)(n3 + 896) << 52;
        }
        l2 = l3 | (long)n4 << 29;
        return l4 | l2;
    }

    public static String TrimDotZero(String string) {
        if (string.length() > 2 && string.charAt(-1 + string.length()) == '0' && string.charAt(string.length() - 2) == '.') {
            string = string.substring(0, string.length() - 2);
        }
        return string;
    }
}

