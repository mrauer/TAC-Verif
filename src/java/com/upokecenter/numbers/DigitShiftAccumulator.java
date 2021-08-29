/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.upokecenter.numbers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.FastInteger;
import com.upokecenter.numbers.IShiftAccumulator;
import com.upokecenter.numbers.NumberUtility;

public final class DigitShiftAccumulator
implements IShiftAccumulator {
    public static final long[] TenPowersLong = new long[]{1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
    public static final EInteger ValueTen = EInteger.FromInt32(10);
    public static final int[] ValueTenPowers = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
    public int bitLeftmost;
    public int bitsAfterLeftmost;
    public FastInteger discardedBitCount;
    public boolean isSmall;
    public FastInteger knownDigitLength;
    public EInteger shiftedBigInt;
    public int shiftedSmall;

    public DigitShiftAccumulator(int n2, int n3, int n4) {
        this.shiftedSmall = n2;
        if (n2 >= 0) {
            boolean bl;
            this.isSmall = bl = true;
            if (n4 == 0) {
                bl = false;
            }
            this.bitsAfterLeftmost = bl ? 1 : 0;
            this.bitLeftmost = n3;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline20((StringBuilder)GeneratedOutlineSupport.outline24((String)"shiftedSmall ("), (int)this.shiftedSmall, (String)") is less than 0"));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public DigitShiftAccumulator(EInteger eInteger, int n2, int n3) {
        boolean bl = eInteger.CanFitInInt32();
        boolean bl2 = true;
        if (bl) {
            int n4;
            this.shiftedSmall = n4 = eInteger.ToInt32Checked();
            if (n4 < 0) throw new IllegalArgumentException(GeneratedOutlineSupport.outline20((StringBuilder)GeneratedOutlineSupport.outline24((String)"shiftedSmall ("), (int)this.shiftedSmall, (String)") is less than 0"));
            this.isSmall = bl2;
        } else {
            this.shiftedBigInt = eInteger;
            this.isSmall = false;
        }
        if (n3 == 0) {
            bl2 = false;
        }
        this.bitsAfterLeftmost = bl2 ? 1 : 0;
        this.bitLeftmost = n2;
    }

    public static int FastParseLong(String string, int n2, int n3) {
        if (n3 <= 9) {
            int n4 = 0;
            for (int i2 = 0; i2 < n3; ++i2) {
                n4 = -48 + string.charAt(n2 + i2) + n4 * 10;
            }
            return n4;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"length (", (int)n3, (String)") is more than 9 "));
    }

    public static int LongDigitLength(long l2) {
        long l3 = l2 LCMP 1000000000L;
        if (l3 >= 0) {
            if (l2 >= 1000000000000000000L) {
                return 19;
            }
            if (l2 >= 100000000000000000L) {
                return 18;
            }
            if (l2 >= 10000000000000000L) {
                return 17;
            }
            if (l2 >= 1000000000000000L) {
                return 16;
            }
            if (l2 >= 100000000000000L) {
                return 15;
            }
            if (l2 >= 10000000000000L) {
                return 14;
            }
            if (l2 >= 1000000000000L) {
                return 13;
            }
            if (l2 >= 100000000000L) {
                return 12;
            }
            if (l2 >= 10000000000L) {
                return 11;
            }
            if (l3 >= 0) {
                return 10;
            }
            return 9;
        }
        int n2 = (int)l2;
        if (n2 >= 100000000) {
            return 9;
        }
        if (n2 >= 10000000) {
            return 8;
        }
        if (n2 >= 1000000) {
            return 7;
        }
        if (n2 >= 100000) {
            return 6;
        }
        if (n2 >= 10000) {
            return 5;
        }
        if (n2 >= 1000) {
            return 4;
        }
        if (n2 >= 100) {
            return 3;
        }
        if (n2 >= 10) {
            return 2;
        }
        return 1;
    }

    public final FastInteger CalcKnownDigitLength() {
        if (this.isSmall) {
            int n2;
            int n3 = this.shiftedSmall;
            int n4 = 10;
            if (n3 < 100000) {
                n2 = n3 >= 10000 ? 5 : (n3 >= 1000 ? 4 : (n3 >= 100 ? 3 : (n3 >= n4 ? 2 : 1)));
            } else {
                if (n3 < 1000000000) {
                    n4 = n3 >= 100000000 ? 9 : (n3 >= 10000000 ? 8 : (n3 >= 1000000 ? 7 : 6));
                }
                n2 = n4;
            }
            return new FastInteger(n2);
        }
        return FastInteger.FromBig(this.shiftedBigInt.GetDigitCountAsEInteger());
    }

    @Override
    public FastInteger GetDigitLength() {
        FastInteger fastInteger = this.knownDigitLength;
        if (fastInteger == null) {
            fastInteger = this.CalcKnownDigitLength();
        }
        this.knownDigitLength = fastInteger;
        return fastInteger;
    }

    public void ShiftRight(FastInteger fastInteger) {
        if (fastInteger.CanFitInInt32()) {
            int n2 = fastInteger.AsInt32();
            if (n2 < 0) {
                return;
            }
            this.ShiftRightInt(n2);
            return;
        }
        if (fastInteger.signum() <= 0) {
            return;
        }
        EInteger eInteger = fastInteger.AsEInteger();
        while (eInteger.signum() > 0) {
            int n3 = 1000000;
            if (eInteger.compareTo(EInteger.FromInt64(1000000L)) < 0) {
                n3 = eInteger.ToInt32Checked();
            }
            this.ShiftRightInt(n3);
            eInteger = eInteger.Subtract(EInteger.FromInt32(n3));
            if (!(this.isSmall ? this.shiftedSmall == 0 : this.shiftedBigInt.isZero())) continue;
            return;
        }
    }

    public final void ShiftRightBig(int n2, boolean bl) {
        int n3 = n2;
        if (n3 <= 0) {
            return;
        }
        boolean bl2 = this.shiftedBigInt.isZero();
        int n4 = 1;
        if (bl2) {
            FastInteger fastInteger = this.discardedBitCount;
            if (fastInteger == null) {
                fastInteger = new FastInteger(0);
            }
            this.discardedBitCount = fastInteger;
            fastInteger.AddInt(n3);
            this.bitsAfterLeftmost |= this.bitLeftmost;
            this.bitLeftmost = 0;
            this.knownDigitLength = new FastInteger(n4);
            return;
        }
        if (bl) {
            EInteger eInteger;
            if (n3 > 50) {
                EInteger eInteger2 = this.shiftedBigInt.GetUnsignedBitLengthAsEInteger();
                int n5 = eInteger2.CanFitInInt32() ? eInteger2.ToInt32Checked() : Integer.MAX_VALUE;
                int n6 = n5 >= 160 && (n3 <= 100 || n5 >= 326) && this.GetDigitLength().Copy().SubtractInt(n3).CompareToInt(-2) >= 0 ? 0 : n4;
                if (n6 != 0) {
                    int n7;
                    FastInteger fastInteger = this.discardedBitCount;
                    if (fastInteger == null) {
                        fastInteger = new FastInteger(0);
                    }
                    this.discardedBitCount = fastInteger;
                    fastInteger.AddInt(n3);
                    this.bitsAfterLeftmost = n7 = this.bitsAfterLeftmost | this.bitLeftmost;
                    this.bitsAfterLeftmost = n7 | n4 ^ this.shiftedBigInt.isZero();
                    this.bitLeftmost = 0;
                    this.knownDigitLength = new FastInteger(n4);
                    this.isSmall = n4;
                    this.shiftedSmall = 0;
                    return;
                }
            }
            if (this.shiftedBigInt.isEven() && this.bitLeftmost == 0) {
                EInteger[] arreInteger = this.shiftedBigInt.DivRem(NumberUtility.FindPowerOfTen(n2));
                eInteger = arreInteger[0];
                this.bitLeftmost |= n4 ^ arreInteger[n4].isZero();
            } else {
                this.bitLeftmost = n4;
                eInteger = this.shiftedBigInt.Divide(NumberUtility.FindPowerOfTen(n2));
            }
            this.bitsAfterLeftmost |= this.bitLeftmost;
            FastInteger fastInteger = this.discardedBitCount;
            if (fastInteger == null) {
                fastInteger = new FastInteger(n3);
            } else {
                fastInteger.AddInt(n3);
            }
            this.discardedBitCount = fastInteger;
            if (eInteger.isZero()) {
                this.isSmall = n4;
                this.shiftedBigInt = null;
                this.shiftedSmall = 0;
                this.knownDigitLength = new FastInteger(n4);
                return;
            }
            if (eInteger.CanFitInInt32()) {
                this.isSmall = n4;
                this.shiftedSmall = eInteger.ToInt32Unchecked();
                this.shiftedBigInt = null;
                this.UpdateKnownLengthInt(n2);
                return;
            }
            this.isSmall = false;
            this.shiftedBigInt = eInteger;
            this.UpdateKnownLengthInt(n2);
            return;
        }
        if (n3 == n4) {
            EInteger[] arreInteger = this.shiftedBigInt.DivRem(EInteger.FromInt32(10));
            EInteger eInteger = arreInteger[0];
            EInteger eInteger3 = arreInteger[n4];
            this.bitsAfterLeftmost |= this.bitLeftmost;
            this.bitLeftmost = eInteger3.ToInt32Checked();
            this.shiftedBigInt = eInteger;
            FastInteger fastInteger = this.discardedBitCount;
            if (fastInteger == null) {
                fastInteger = new FastInteger(0);
            }
            this.discardedBitCount = fastInteger;
            fastInteger.AddInt(n3);
            this.UpdateKnownLengthInt(n2);
            return;
        }
        if (n3 >= 2 && n3 <= 8) {
            EInteger[] arreInteger = this.shiftedBigInt.DivRem(NumberUtility.FindPowerOfTen(n2));
            EInteger eInteger = arreInteger[0];
            int n8 = arreInteger[n4].ToInt32Checked();
            int n9 = ValueTenPowers[n3 - 1];
            int n10 = n8 / n9;
            int n11 = n8 - n9 * n10;
            this.bitsAfterLeftmost |= n11 | this.bitLeftmost;
            this.bitLeftmost = n10;
            this.shiftedBigInt = eInteger;
            FastInteger fastInteger = this.discardedBitCount;
            if (fastInteger != null) {
                fastInteger.AddInt(n3);
            } else {
                fastInteger = new FastInteger(n3);
            }
            this.discardedBitCount = fastInteger;
            this.UpdateKnownLengthInt(n2);
            int n12 = this.bitsAfterLeftmost;
            int n13 = 0;
            if (n12 != 0) {
                n13 = n4;
            }
            this.bitsAfterLeftmost = n13;
            if (this.shiftedBigInt.CanFitInInt32()) {
                this.isSmall = n4;
                this.shiftedSmall = this.shiftedBigInt.ToInt32Unchecked();
                this.shiftedBigInt = null;
            }
            return;
        }
        FastInteger fastInteger = this.knownDigitLength;
        if (fastInteger == null) {
            fastInteger = this.CalcKnownDigitLength();
        }
        this.knownDigitLength = fastInteger;
        if (new FastInteger(n3).Decrement().compareTo(this.knownDigitLength) >= 0) {
            this.bitsAfterLeftmost |= n4 ^ this.shiftedBigInt.isZero();
            this.isSmall = n4;
            this.shiftedSmall = 0;
            this.knownDigitLength = new FastInteger(n4);
            FastInteger fastInteger2 = this.discardedBitCount;
            if (fastInteger2 == null) {
                fastInteger2 = new FastInteger(0);
            }
            this.discardedBitCount = fastInteger2;
            fastInteger2.AddInt(n3);
            this.bitsAfterLeftmost |= this.bitLeftmost;
            this.bitLeftmost = 0;
            return;
        }
        if (this.shiftedBigInt.CanFitInInt32()) {
            this.isSmall = n4;
            this.shiftedSmall = this.shiftedBigInt.ToInt32Checked();
            this.ShiftRightSmall(n2);
            return;
        }
        if (this.shiftedBigInt.CanFitInInt64()) {
            long l2 = this.shiftedBigInt.ToInt64Unchecked();
            if (n3 <= 0) {
                return;
            }
            long l3 = l2 LCMP 0L;
            if (l3 == false) {
                this.shiftedSmall = 0;
                this.isSmall = n4;
                FastInteger fastInteger3 = this.discardedBitCount;
                if (fastInteger3 == null) {
                    fastInteger3 = new FastInteger(0);
                }
                this.discardedBitCount = fastInteger3;
                fastInteger3.AddInt(n3);
                this.bitsAfterLeftmost |= this.bitLeftmost;
                this.bitLeftmost = 0;
                this.knownDigitLength = new FastInteger(n4);
                return;
            }
            if (n3 >= 2 && n3 <= 8) {
                int[] arrn = ValueTenPowers;
                if (l2 >= (long)arrn[n3]) {
                    long l4 = arrn[n3];
                    long l5 = arrn[n3 - 1];
                    FastInteger fastInteger4 = this.discardedBitCount;
                    if (fastInteger4 == null) {
                        fastInteger4 = new FastInteger(0);
                    }
                    this.discardedBitCount = fastInteger4;
                    fastInteger4.AddInt(n3);
                    long l6 = l2 / l4;
                    long l7 = l2 - l4 * l6;
                    long l8 = l7 / l5;
                    this.bitLeftmost = (int)l8;
                    int n14 = this.bitsAfterLeftmost;
                    int n15 = l7 - l8 * l5 == 0L ? 0 : n4;
                    this.bitsAfterLeftmost = n15 | n14;
                    long l9 = l6 LCMP Integer.MAX_VALUE;
                    int n16 = 0;
                    if (l9 <= 0) {
                        n16 = n4;
                    }
                    this.isSmall = n16;
                    if (n16 != 0) {
                        this.shiftedSmall = (int)l6;
                        FastInteger fastInteger5 = l6 < 10L ? new FastInteger(n4) : new FastInteger(DigitShiftAccumulator.LongDigitLength(l6));
                        this.knownDigitLength = fastInteger5;
                        return;
                    }
                    this.shiftedBigInt = EInteger.FromInt64(l6);
                    FastInteger fastInteger6 = l6 < 10L ? new FastInteger(n4) : this.CalcKnownDigitLength();
                    this.knownDigitLength = fastInteger6;
                    return;
                }
                int n17 = this.shiftedSmall;
                int n18 = n3 - 1;
                if (n17 >= arrn[n18]) {
                    int n19 = arrn[n18];
                    FastInteger fastInteger7 = this.discardedBitCount;
                    if (fastInteger7 != null) {
                        fastInteger7.AddInt(n3);
                    } else {
                        this.discardedBitCount = new FastInteger(n3);
                    }
                    long l10 = n19;
                    long l11 = l2 / l10;
                    this.bitLeftmost = (int)l11;
                    int n20 = this.bitsAfterLeftmost;
                    int n21 = l2 - l11 * l10 == 0L ? 0 : n4;
                    this.bitsAfterLeftmost = n21 | n20;
                    this.isSmall = n4;
                    this.shiftedSmall = 0;
                    this.knownDigitLength = new FastInteger(n4);
                    return;
                }
                FastInteger fastInteger8 = this.discardedBitCount;
                if (fastInteger8 != null) {
                    fastInteger8.AddInt(n3);
                } else {
                    this.discardedBitCount = new FastInteger(n3);
                }
                this.bitLeftmost = 0;
                int n22 = this.bitsAfterLeftmost;
                int n23 = l3 == false ? 0 : n4;
                this.bitsAfterLeftmost = n22 | n23;
                this.isSmall = n4;
                this.shiftedSmall = 0;
                this.knownDigitLength = new FastInteger(n4);
                return;
            }
            this.knownDigitLength = new FastInteger(DigitShiftAccumulator.LongDigitLength(l2));
            FastInteger fastInteger9 = this.discardedBitCount;
            if (fastInteger9 != null) {
                fastInteger9.AddInt(n3);
            } else {
                this.discardedBitCount = new FastInteger(n3);
            }
            int n24 = 0;
            while (n3 > 0) {
                long l12;
                long l13;
                if (l2 == 0L) {
                    this.bitsAfterLeftmost |= this.bitLeftmost;
                    this.bitLeftmost = 0;
                    break;
                }
                if (l2 < 43698L) {
                    l13 = 26215L * l2 >> 18;
                    l12 = 10L;
                } else {
                    l12 = 10L;
                    l13 = l2 / l12;
                }
                Long.signum((long)l13);
                int n25 = (int)(l2 - l13 * l12);
                this.bitsAfterLeftmost |= this.bitLeftmost;
                this.bitLeftmost = n25;
                --n3;
                ++n24;
                l2 = l13;
            }
            int n26 = l2 <= Integer.MAX_VALUE ? n4 : 0;
            this.isSmall = n26;
            if (n26 != 0) {
                this.shiftedSmall = (int)l2;
            } else {
                this.shiftedBigInt = EInteger.FromInt64(l2);
            }
            this.UpdateKnownLengthInt(n24);
            int n27 = this.bitsAfterLeftmost;
            int n28 = 0;
            if (n27 != 0) {
                n28 = n4;
            }
            this.bitsAfterLeftmost = n28;
            return;
        }
        String string = this.shiftedBigInt.toString();
        int n29 = string.length();
        int n30 = n3 > n29 ? n3 - n29 : 0;
        FastInteger fastInteger10 = this.discardedBitCount;
        if (fastInteger10 == null) {
            fastInteger10 = new FastInteger(0);
        }
        this.discardedBitCount = fastInteger10;
        fastInteger10.AddInt(n3);
        this.bitsAfterLeftmost |= this.bitLeftmost;
        int n31 = Math.min((int)n29, (int)n3);
        if (n3 >= n29) {
            this.isSmall = n4;
            this.shiftedSmall = 0;
            this.knownDigitLength = new FastInteger(n4);
        } else {
            int n32 = n29 - n31;
            if (n32 <= 9) {
                this.isSmall = n4;
                this.shiftedSmall = DigitShiftAccumulator.FastParseLong(string, 0, n32);
            } else {
                this.shiftedBigInt = EInteger.FromSubstring(string, 0, n32);
            }
            this.UpdateKnownLengthInt(n31);
        }
        for (int i2 = string.length() - n4; i2 >= 0; --i2) {
            this.bitsAfterLeftmost |= this.bitLeftmost;
            this.bitLeftmost = -48 + string.charAt(i2);
            if (--n31 <= 0) break;
        }
        if (this.bitsAfterLeftmost == 0) {
            n4 = 0;
        }
        this.bitsAfterLeftmost = n4;
        if (n30 > 0) {
            this.bitsAfterLeftmost = n4 | this.bitLeftmost;
            this.bitLeftmost = 0;
        }
    }

    @Override
    public void ShiftRightInt(int n2) {
        if (this.isSmall) {
            this.ShiftRightSmall(n2);
            return;
        }
        this.ShiftRightBig(n2, false);
    }

    public final void ShiftRightSmall(int n2) {
        if (n2 <= 0) {
            return;
        }
        int n3 = this.shiftedSmall;
        if (n3 == 0) {
            FastInteger fastInteger = this.discardedBitCount;
            if (fastInteger == null) {
                fastInteger = new FastInteger(0);
            }
            this.discardedBitCount = fastInteger;
            fastInteger.AddInt(n2);
            this.bitsAfterLeftmost |= this.bitLeftmost;
            this.bitLeftmost = 0;
            this.knownDigitLength = new FastInteger(1);
            return;
        }
        int n4 = 8;
        if (n2 >= 2 && n2 <= n4) {
            int[] arrn = ValueTenPowers;
            if (n3 >= arrn[n2]) {
                int n5;
                int n6 = arrn[n2];
                int n7 = arrn[n2 - 1];
                FastInteger fastInteger = this.discardedBitCount;
                if (fastInteger == null) {
                    fastInteger = new FastInteger(0);
                }
                this.discardedBitCount = fastInteger;
                fastInteger.AddInt(n2);
                int n8 = this.shiftedSmall;
                int n9 = n8 / n6;
                int n10 = n8 - n6 * n9;
                this.bitLeftmost = n5 = n10 / n7;
                this.bitsAfterLeftmost |= n10 - n5 * n7;
                this.shiftedSmall = n9;
                FastInteger fastInteger2 = n9 < 10 ? new FastInteger(1) : this.CalcKnownDigitLength();
                this.knownDigitLength = fastInteger2;
                return;
            }
            int n11 = n2 - 1;
            if (n3 >= arrn[n11]) {
                int n12;
                int n13 = arrn[n11];
                FastInteger fastInteger = this.discardedBitCount;
                if (fastInteger != null) {
                    fastInteger.AddInt(n2);
                } else {
                    this.discardedBitCount = new FastInteger(n2);
                }
                int n14 = this.shiftedSmall;
                this.bitLeftmost = n12 = n14 / n13;
                this.bitsAfterLeftmost |= n14 - n12 * n13;
                this.shiftedSmall = 0;
                this.knownDigitLength = new FastInteger(1);
                return;
            }
            FastInteger fastInteger = this.discardedBitCount;
            if (fastInteger != null) {
                fastInteger.AddInt(n2);
            } else {
                this.discardedBitCount = new FastInteger(n2);
            }
            int n15 = this.shiftedSmall;
            this.bitLeftmost = 0;
            this.bitsAfterLeftmost = n15 | this.bitsAfterLeftmost;
            this.shiftedSmall = 0;
            this.knownDigitLength = new FastInteger(1);
            return;
        }
        if (n3 >= 1000000000) {
            n4 = 10;
        } else if (n3 >= 100000000) {
            n4 = 9;
        } else if (n3 < 10000000) {
            n4 = n3 >= 1000000 ? 7 : (n3 >= 100000 ? 6 : (n3 >= 10000 ? 5 : (n3 >= 1000 ? 4 : (n3 >= 100 ? 3 : (n3 >= 10 ? 2 : 1)))));
        }
        this.knownDigitLength = new FastInteger(n4);
        FastInteger fastInteger = this.discardedBitCount;
        if (fastInteger != null) {
            fastInteger.AddInt(n2);
        } else {
            this.discardedBitCount = new FastInteger(n2);
        }
        int n16 = 0;
        while (n2 > 0) {
            int n17 = this.shiftedSmall;
            if (n17 == 0) {
                this.bitsAfterLeftmost |= this.bitLeftmost;
                this.bitLeftmost = 0;
                this.knownDigitLength = new FastInteger(1);
                break;
            }
            int n18 = n17 % 10;
            this.bitsAfterLeftmost |= this.bitLeftmost;
            this.bitLeftmost = n18;
            --n2;
            ++n16;
            this.shiftedSmall = n17 / 10;
        }
        this.UpdateKnownLengthInt(n16);
        int n19 = this.bitsAfterLeftmost;
        int n20 = 0;
        if (n19 != 0) {
            n20 = 1;
        }
        this.bitsAfterLeftmost = n20;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void ShiftToDigits(FastInteger fastInteger, FastInteger fastInteger2, boolean bl) {
        if (fastInteger2 != null && fastInteger2.signum() > 0) {
            FastInteger fastInteger3 = this.knownDigitLength;
            if (fastInteger3 == null) {
                fastInteger3 = this.CalcKnownDigitLength();
            }
            this.knownDigitLength = fastInteger3;
            if (fastInteger3.compareTo(fastInteger) <= 0) {
                this.TruncateOrShiftRight(fastInteger2, bl);
                return;
            }
            FastInteger fastInteger4 = fastInteger3.Copy();
            fastInteger4.Subtract(fastInteger);
            if (fastInteger4.compareTo(fastInteger2) <= 0) {
                this.TruncateOrShiftRight(fastInteger2, bl);
                return;
            }
            this.TruncateOrShiftRight(fastInteger4, bl);
            return;
        }
        if (fastInteger.CanFitInInt32()) {
            int n2 = fastInteger.AsInt32();
            if (n2 < 0) throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"intval (", (int)n2, (String)") is less than 0"));
            boolean bl2 = this.isSmall;
            int n3 = 9;
            if (bl2) {
                int n4 = this.shiftedSmall;
                if (n4 >= 1000000000) {
                    n3 = 10;
                } else if (n4 < 100000000) {
                    n3 = n4 >= 10000000 ? 8 : (n4 >= 1000000 ? 7 : (n4 >= 100000 ? 6 : (n4 >= 10000 ? 5 : (n4 >= 1000 ? 4 : (n4 >= 100 ? 3 : (n4 >= 10 ? 2 : 1))))));
                }
                this.knownDigitLength = new FastInteger(n3);
                if (n3 <= n2) return;
                int n5 = n3 - n2;
                this.UpdateKnownLengthInt(n5);
                FastInteger fastInteger5 = this.discardedBitCount;
                if (fastInteger5 != null) {
                    fastInteger5.AddInt(n5);
                } else {
                    fastInteger5 = new FastInteger(n5);
                }
                this.discardedBitCount = fastInteger5;
                for (int i2 = 0; i2 < n5; ++i2) {
                    int n6 = this.shiftedSmall;
                    int n7 = n6 % 10;
                    this.shiftedSmall = n6 / 10;
                    this.bitsAfterLeftmost |= this.bitLeftmost;
                    this.bitLeftmost = n7;
                }
                int n8 = this.bitsAfterLeftmost;
                int n9 = 0;
                if (n8 != 0) {
                    n9 = 1;
                }
                this.bitsAfterLeftmost = n9;
                return;
            }
            FastInteger fastInteger6 = this.knownDigitLength;
            if (fastInteger6 != null && fastInteger6.CompareToInt(n2) <= 0) {
                return;
            }
            FastInteger fastInteger7 = this.knownDigitLength;
            if (fastInteger7 == null) {
                fastInteger7 = this.CalcKnownDigitLength();
            }
            this.knownDigitLength = fastInteger7;
            if (fastInteger7.CompareToInt(n2) <= 0) {
                return;
            }
            FastInteger fastInteger8 = this.knownDigitLength.Copy().SubtractInt(n2);
            if (bl && fastInteger8.CanFitInInt32()) {
                this.TruncateOrShiftRight(fastInteger8, bl);
                return;
            }
            if (fastInteger8.CompareToInt(1) == 0) {
                EInteger[] arreInteger = this.shiftedBigInt.DivRem(ValueTen);
                EInteger eInteger = arreInteger[0];
                EInteger eInteger2 = arreInteger[1];
                this.bitsAfterLeftmost |= this.bitLeftmost;
                this.bitLeftmost = eInteger2.ToInt32Checked();
                this.shiftedBigInt = eInteger;
                FastInteger fastInteger9 = this.discardedBitCount;
                if (fastInteger9 == null) {
                    fastInteger9 = new FastInteger(0);
                }
                this.discardedBitCount = fastInteger9;
                fastInteger9.Add(fastInteger8);
                this.UpdateKnownLength(fastInteger8);
                int n10 = this.bitsAfterLeftmost;
                int n11 = 0;
                if (n10 != 0) {
                    n11 = 1;
                }
                this.bitsAfterLeftmost = n11;
                return;
            }
            if (fastInteger8.CompareToInt(n3) <= 0) {
                int n12 = fastInteger8.AsInt32();
                EInteger eInteger = NumberUtility.FindPowerOfTen(n12);
                EInteger[] arreInteger = this.shiftedBigInt.DivRem(eInteger);
                EInteger eInteger3 = arreInteger[0];
                int n13 = arreInteger[1].ToInt32Checked();
                this.bitsAfterLeftmost |= this.bitLeftmost;
                for (int i3 = 0; i3 < n12; ++i3) {
                    if (i3 == n12 - 1) {
                        this.bitLeftmost = n13 % 10;
                        continue;
                    }
                    int n14 = n13 < 43698 ? n13 * 26215 >> 18 : n13 / 10;
                    this.bitsAfterLeftmost |= n13 - n14 * 10;
                    n13 = n14;
                }
                this.shiftedBigInt = eInteger3;
                FastInteger fastInteger10 = this.discardedBitCount;
                if (fastInteger10 == null) {
                    fastInteger10 = new FastInteger(0);
                }
                this.discardedBitCount = fastInteger10;
                fastInteger10.Add(fastInteger8);
                this.UpdateKnownLength(fastInteger8);
                int n15 = this.bitsAfterLeftmost;
                int n16 = 0;
                if (n15 != 0) {
                    n16 = 1;
                }
                this.bitsAfterLeftmost = n16;
                return;
            }
            if (fastInteger8.CanFitInInt32()) {
                EInteger eInteger;
                if (this.shiftedBigInt.isEven() && this.bitsAfterLeftmost == 0) {
                    EInteger eInteger4 = NumberUtility.FindPowerOfTen(fastInteger8.AsInt32() - 1);
                    EInteger[] arreInteger = this.shiftedBigInt.DivRem(eInteger4);
                    eInteger = arreInteger[0];
                    EInteger eInteger5 = arreInteger[1];
                    this.bitsAfterLeftmost |= this.bitLeftmost;
                    if (!eInteger5.isZero()) {
                        this.bitsAfterLeftmost = 1 | this.bitsAfterLeftmost;
                    }
                } else {
                    EInteger eInteger6 = NumberUtility.FindPowerOfTen(fastInteger8.AsInt32() - 1);
                    this.bitsAfterLeftmost = 1 | this.bitsAfterLeftmost;
                    eInteger = this.shiftedBigInt.Divide(eInteger6);
                }
                EInteger[] arreInteger = eInteger.DivRem(ValueTen);
                EInteger eInteger7 = arreInteger[0];
                this.bitLeftmost = arreInteger[1].ToInt32Checked();
                this.shiftedBigInt = eInteger7;
                FastInteger fastInteger11 = this.discardedBitCount;
                if (fastInteger11 == null) {
                    fastInteger11 = new FastInteger(0);
                }
                this.discardedBitCount = fastInteger11;
                fastInteger11.Add(fastInteger8);
                this.UpdateKnownLength(fastInteger8);
                int n17 = this.bitsAfterLeftmost;
                int n18 = 0;
                if (n17 != 0) {
                    n18 = 1;
                }
                this.bitsAfterLeftmost = n18;
                return;
            }
            String string = this.shiftedBigInt.toString();
            int n19 = string.length();
            this.knownDigitLength = new FastInteger(n19);
            if (n19 <= n2) return;
            int n20 = n19 - n2;
            this.UpdateKnownLengthInt(n20);
            int n21 = n19 - n20;
            FastInteger fastInteger12 = this.discardedBitCount;
            if (fastInteger12 == null) {
                fastInteger12 = new FastInteger(0);
            }
            this.discardedBitCount = fastInteger12;
            if (n20 <= Integer.MAX_VALUE) {
                fastInteger12.AddInt(n20);
            } else {
                fastInteger12.AddBig(EInteger.FromInt32(n20));
            }
            for (int i4 = string.length() - 1; i4 >= 0; --i4) {
                this.bitsAfterLeftmost |= this.bitLeftmost;
                this.bitLeftmost = -48 + string.charAt(i4);
                if (--n20 <= 0) break;
            }
            if (n21 <= n3) {
                this.isSmall = true;
                this.shiftedSmall = DigitShiftAccumulator.FastParseLong(string, 0, n21);
            } else {
                this.shiftedBigInt = EInteger.FromSubstring(string, 0, n21);
            }
            int n22 = this.bitsAfterLeftmost;
            int n23 = 0;
            if (n22 != 0) {
                n23 = 1;
            }
            this.bitsAfterLeftmost = n23;
            return;
        }
        FastInteger fastInteger13 = this.knownDigitLength;
        if (fastInteger13 == null) {
            fastInteger13 = this.CalcKnownDigitLength();
        }
        this.knownDigitLength = fastInteger13;
        EInteger eInteger = fastInteger13.AsEInteger().Subtract(fastInteger.AsEInteger());
        if (eInteger.signum() <= 0) return;
        this.ShiftRight(FastInteger.FromBig(eInteger));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void TruncateOrShiftRight(FastInteger var1_1, boolean var2_2) {
        block25 : {
            block26 : {
                block27 : {
                    block28 : {
                        block29 : {
                            if (!var2_2 || !var1_1.CanFitInInt32()) break block25;
                            var3_3 = var1_1.AsInt32();
                            if (var3_3 < 0) {
                                return;
                            }
                            if (this.isSmall) break block26;
                            if (!this.shiftedBigInt.CanFitInInt64()) {
                                this.ShiftRightBig(var3_3, true);
                                return;
                            }
                            var21_4 = this.shiftedBigInt.ToInt64Checked();
                            if (var3_3 <= 0) {
                                return;
                            }
                            var23_5 = var21_4 LCMP 0L;
                            if (var23_5 == false || var3_3 >= 21) break block27;
                            if (var3_3 < 1 || var3_3 > (var27_6 = DigitShiftAccumulator.TenPowersLong).length - 1) break block28;
                            if (var21_4 < var27_6[var3_3]) break block29;
                            var31_7 = var27_6[var3_3];
                            var33_8 = this.discardedBitCount;
                            if (var33_8 != null) {
                                var33_8.AddInt(var3_3);
                            } else {
                                this.discardedBitCount = new FastInteger(var3_3);
                            }
                            var34_9 = var21_4 / var31_7;
                            this.bitsAfterLeftmost |= this.bitLeftmost;
                            if ((var21_4 & 1L) == 1L) ** GOTO lbl-1000
                            Long.signum((long)var34_9);
                            if (var21_4 - var31_7 * var34_9 == 0L) {
                                var37_10 = 0;
                            } else lbl-1000: // 2 sources:
                            {
                                var37_10 = 1;
                            }
                            this.bitLeftmost = var37_10;
                            var38_11 = var34_9 LCMP Integer.MAX_VALUE;
                            var39_12 = false;
                            if (var38_11 <= 0) {
                                var39_12 = true;
                            }
                            this.isSmall = var39_12;
                            if (var39_12) {
                                this.shiftedSmall = (int)var34_9;
                            } else {
                                this.shiftedBigInt = EInteger.FromInt64(var34_9);
                            }
                            this.UpdateKnownLengthInt(var3_3);
                            return;
                        }
                        var28_13 = this.discardedBitCount;
                        if (var28_13 != null) {
                            var28_13.AddInt(var3_3);
                        } else {
                            this.discardedBitCount = new FastInteger(var3_3);
                        }
                        this.bitsAfterLeftmost |= this.bitLeftmost;
                        var29_14 = var23_5 == false ? 0 : 1;
                        this.bitLeftmost = var29_14;
                        this.isSmall = true;
                        this.shiftedSmall = (int)0L;
                        this.UpdateKnownLengthInt(var3_3);
                        return;
                    }
                    if (this.isSmall) {
                        this.ShiftRightSmall(var3_3);
                        return;
                    }
                    this.ShiftRightBig(var3_3, false);
                    return;
                }
                var24_15 = this.discardedBitCount;
                if (var24_15 == null) {
                    var24_15 = new FastInteger(0);
                }
                this.discardedBitCount = var24_15;
                var24_15.AddInt(var3_3);
                this.bitsAfterLeftmost |= this.bitLeftmost;
                var26_16 = var23_5 == false ? 0 : 1;
                this.bitLeftmost = var26_16;
                this.shiftedSmall = 0;
                this.isSmall = true;
                this.knownDigitLength = new FastInteger(1);
                return;
            }
            if (var3_3 <= 0) {
                return;
            }
            var4_17 = this.shiftedSmall;
            if (var4_17 != 0 && var3_3 < 11) {
                if (var3_3 >= 1 && var3_3 <= 8) {
                    var8_18 = DigitShiftAccumulator.ValueTenPowers;
                    if (var4_17 >= var8_18[var3_3]) {
                        var12_19 = var8_18[var3_3];
                        var13_20 = this.discardedBitCount;
                        if (var13_20 != null) {
                            var13_20.AddInt(var3_3);
                        } else {
                            this.discardedBitCount = new FastInteger(var3_3);
                        }
                        var14_21 = this.bitsAfterLeftmost;
                        var15_22 = this.bitLeftmost;
                        this.bitsAfterLeftmost = var14_21 | var15_22;
                        var16_23 = this.shiftedSmall;
                        if ((var16_23 & 1) == 1) {
                            this.bitLeftmost = 1;
                            this.shiftedSmall = var16_23 / var12_19;
                        } else {
                            var17_24 = var16_23 / var12_19;
                            var18_25 = var16_23 - var12_19 * var17_24;
                            this.shiftedSmall = var17_24;
                            var19_26 = var18_25 == 0 ? 0 : 1;
                            this.bitLeftmost = var15_22 | var19_26;
                        }
                        this.UpdateKnownLengthInt(var3_3);
                        return;
                    }
                    var9_27 = this.discardedBitCount;
                    if (var9_27 != null) {
                        var9_27.AddInt(var3_3);
                    } else {
                        this.discardedBitCount = new FastInteger(var3_3);
                    }
                    this.bitsAfterLeftmost |= this.bitLeftmost;
                    var10_28 = this.shiftedSmall == 0 ? 0 : 1;
                    this.bitLeftmost = var10_28;
                    this.shiftedSmall = 0;
                    this.knownDigitLength = new FastInteger(1);
                    return;
                }
                this.ShiftRightSmall(var3_3);
                return;
            }
            var5_29 = this.discardedBitCount;
            if (var5_29 == null) {
                var5_29 = new FastInteger(0);
            }
            this.discardedBitCount = var5_29;
            var5_29.AddInt(var3_3);
            this.bitsAfterLeftmost |= this.bitLeftmost;
            var7_30 = this.shiftedSmall == 0 ? 0 : 1;
            this.bitLeftmost = var7_30;
            this.shiftedSmall = 0;
            this.knownDigitLength = new FastInteger(1);
            return;
        }
        this.ShiftRight(var1_1);
    }

    public final void UpdateKnownLength(FastInteger fastInteger) {
        FastInteger fastInteger2 = this.knownDigitLength;
        if (fastInteger2 != null) {
            fastInteger2.Subtract(fastInteger);
            if (this.knownDigitLength.CompareToInt(1) < 0) {
                this.knownDigitLength.SetInt(1);
            }
        }
    }

    public final void UpdateKnownLengthInt(int n2) {
        FastInteger fastInteger = this.knownDigitLength;
        if (fastInteger != null) {
            fastInteger.SubtractInt(n2);
            if (this.knownDigitLength.CompareToInt(1) < 0) {
                this.knownDigitLength.SetInt(1);
            }
        }
    }

    @Override
    public final FastInteger getDiscardedDigitCount() {
        FastInteger fastInteger = this.discardedBitCount;
        if (fastInteger == null) {
            fastInteger = new FastInteger(0);
        }
        this.discardedBitCount = fastInteger;
        return fastInteger;
    }

    @Override
    public final int getLastDiscardedDigit() {
        return this.bitLeftmost;
    }

    @Override
    public final int getOlderDiscardedDigits() {
        return this.bitsAfterLeftmost;
    }

    @Override
    public final EInteger getShiftedInt() {
        if (this.isSmall) {
            return EInteger.FromInt32(this.shiftedSmall);
        }
        return this.shiftedBigInt;
    }

    @Override
    public final FastInteger getShiftedIntFast() {
        if (this.isSmall) {
            return new FastInteger(this.shiftedSmall);
        }
        return FastInteger.FromBig(this.shiftedBigInt);
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"[this.bitLeftmost=");
        stringBuilder.append(this.bitLeftmost);
        stringBuilder.append(", this.bitsAfterLeftmost=");
        stringBuilder.append(this.bitsAfterLeftmost);
        stringBuilder.append(", this.discardedBitCount=");
        stringBuilder.append((Object)this.discardedBitCount);
        stringBuilder.append(", this.isSmall=");
        stringBuilder.append(this.isSmall);
        stringBuilder.append(", this.knownDigitLength=");
        stringBuilder.append((Object)this.knownDigitLength);
        stringBuilder.append(", this.shiftedBigInt=");
        stringBuilder.append((Object)this.shiftedBigInt);
        stringBuilder.append(", this.shiftedSmall=");
        return GeneratedOutlineSupport.outline20((StringBuilder)stringBuilder, (int)this.shiftedSmall, (String)"]");
    }
}

