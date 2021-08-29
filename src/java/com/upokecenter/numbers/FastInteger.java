/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.ArithmeticException
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.upokecenter.numbers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.upokecenter.numbers.EInteger;

public final class FastInteger
implements Comparable<FastInteger> {
    public static final EInteger ValueInt32MaxValue;
    public static final EInteger ValueInt32MinValue;
    public static final EInteger ValueNegativeInt32MinValue;
    public boolean frozen;
    public int integerMode;
    public EInteger largeValue;
    public MutableNumber mnum;
    public int smallValue;

    public static {
        EInteger eInteger;
        ValueInt32MinValue = eInteger = EInteger.FromInt64(Integer.MIN_VALUE);
        ValueInt32MaxValue = EInteger.FromInt64(Integer.MAX_VALUE);
        ValueNegativeInt32MinValue = eInteger.Negate();
    }

    public FastInteger(int n2) {
        this.smallValue = n2;
    }

    public static FastInteger FromBig(EInteger eInteger) {
        if (eInteger.CanFitInInt32()) {
            return new FastInteger(eInteger.ToInt32Unchecked());
        }
        if (eInteger.signum() > 0) {
            FastInteger fastInteger = new FastInteger(0);
            fastInteger.integerMode = 1;
            fastInteger.mnum = MutableNumber.FromEInteger(eInteger);
            return fastInteger;
        }
        FastInteger fastInteger = new FastInteger(0);
        fastInteger.integerMode = 2;
        fastInteger.largeValue = eInteger;
        return fastInteger;
    }

    public static String IntToString(int n2) {
        if (n2 == Integer.MIN_VALUE) {
            return "-2147483648";
        }
        if (n2 == 0) {
            return "0";
        }
        boolean bl = n2 < 0;
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
            n2 = n4;
            n3 = n5;
        }
        while (n2 > 9) {
            int n6 = n2 * 26215 >> 18;
            char c3 = "0123456789ABCDEF".charAt(n2 - n6 * 10);
            int n7 = n3 - 1;
            arrc[n3] = c3;
            n2 = n6;
            n3 = n7;
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

    public FastInteger Abs() {
        if (!this.frozen) {
            if (this.integerMode != 0) {
                if (this.signum() < 0) {
                    this.Negate();
                }
                return this;
            }
            int n2 = this.smallValue;
            if (n2 == Integer.MIN_VALUE) {
                this.Negate();
                return this;
            }
            this.smallValue = Math.abs((int)n2);
            return this;
        }
        throw new IllegalStateException();
    }

    public FastInteger Add(FastInteger fastInteger) {
        int n2 = this.integerMode;
        if (n2 != 0) {
            int n3;
            if (n2 != 1) {
                if (n2 == 2) {
                    EInteger eInteger = fastInteger.AsEInteger();
                    this.largeValue = this.largeValue.Add(eInteger);
                    return this;
                }
                throw new IllegalStateException();
            }
            if (fastInteger.integerMode == 0 && (n3 = fastInteger.smallValue) >= 0) {
                this.mnum.Add(n3);
                return this;
            }
            this.integerMode = 2;
            this.largeValue = this.mnum.ToEInteger();
            EInteger eInteger = fastInteger.AsEInteger();
            this.largeValue = this.largeValue.Add(eInteger);
            return this;
        }
        if (fastInteger.integerMode == 0) {
            int n4 = this.smallValue;
            if (n4 < 0 && fastInteger.smallValue < Integer.MIN_VALUE - n4 || n4 > 0 && fastInteger.smallValue > Integer.MAX_VALUE - n4) {
                EInteger eInteger;
                if (fastInteger.smallValue >= 0) {
                    MutableNumber mutableNumber;
                    this.integerMode = 1;
                    this.mnum = mutableNumber = new MutableNumber(n4);
                    mutableNumber.Add(fastInteger.smallValue);
                    return this;
                }
                this.integerMode = 2;
                this.largeValue = eInteger = EInteger.FromInt32(n4);
                this.largeValue = eInteger.Add(EInteger.FromInt64(fastInteger.smallValue));
                return this;
            }
            this.smallValue = n4 + fastInteger.smallValue;
            return this;
        }
        this.integerMode = 2;
        this.largeValue = EInteger.FromInt32(this.smallValue);
        EInteger eInteger = fastInteger.AsEInteger();
        this.largeValue = this.largeValue.Add(eInteger);
        return this;
    }

    public FastInteger AddBig(EInteger eInteger) {
        int n2 = this.integerMode;
        if (n2 != 0) {
            EInteger eInteger2;
            if (n2 != 1) {
                if (n2 == 2) {
                    this.largeValue = this.largeValue.Add(eInteger);
                    return this;
                }
                throw new IllegalStateException();
            }
            this.integerMode = 2;
            this.largeValue = eInteger2 = this.mnum.ToEInteger();
            this.largeValue = eInteger2.Add(eInteger);
            return this;
        }
        if (eInteger.CanFitInInt32()) {
            this.AddInt(eInteger.ToInt32Checked());
            return this;
        }
        this.Add(FastInteger.FromBig(eInteger));
        return this;
    }

    public FastInteger AddInt(int n2) {
        int n3 = this.integerMode;
        if (n3 != 0) {
            if (n3 != 1) {
                if (n3 == 2) {
                    EInteger eInteger = EInteger.FromInt32(n2);
                    this.largeValue = this.largeValue.Add(eInteger);
                    return this;
                }
                throw new IllegalStateException();
            }
            if (n2 >= 0) {
                this.mnum.Add(n2);
                return this;
            }
            this.integerMode = 2;
            this.largeValue = this.mnum.ToEInteger();
            EInteger eInteger = EInteger.FromInt32(n2);
            this.largeValue = this.largeValue.Add(eInteger);
            return this;
        }
        int n4 = this.smallValue;
        if (n4 < 0 && n2 < Integer.MIN_VALUE - n4 || n4 > 0 && n2 > Integer.MAX_VALUE - n4) {
            EInteger eInteger;
            if (n2 >= 0) {
                MutableNumber mutableNumber;
                this.integerMode = 1;
                this.mnum = mutableNumber = new MutableNumber(n4);
                mutableNumber.Add(n2);
                return this;
            }
            this.integerMode = 2;
            this.largeValue = eInteger = EInteger.FromInt32(n4);
            this.largeValue = eInteger.Add(EInteger.FromInt32(n2));
            return this;
        }
        this.smallValue = n4 + n2;
        return this;
    }

    public EInteger AsEInteger() {
        int n2 = this.integerMode;
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 == 2) {
                    return this.largeValue;
                }
                throw new IllegalStateException();
            }
            return this.mnum.ToEInteger();
        }
        return EInteger.FromInt32(this.smallValue);
    }

    public int AsInt32() {
        int n2 = this.integerMode;
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 == 2) {
                    return this.largeValue.ToInt32Checked();
                }
                throw new IllegalStateException();
            }
            MutableNumber mutableNumber = this.mnum;
            if (mutableNumber.wordCount == 0) {
                return 0;
            }
            return mutableNumber.data[0];
        }
        return this.smallValue;
    }

    public boolean CanFitInInt32() {
        int n2 = this.integerMode;
        int n3 = 1;
        if (n2) {
            if (n2 != n3) {
                if (n2 == 2) {
                    return this.largeValue.CanFitInInt32();
                }
                throw new IllegalStateException();
            }
            MutableNumber mutableNumber = this.mnum;
            int n4 = mutableNumber.wordCount;
            if (n4 != 0) {
                if (n4 == n3 && mutableNumber.data[0] >> 31 == 0) {
                    return n3;
                }
                n3 = 0;
            }
        }
        return n3;
    }

    public int CompareToInt(int n2) {
        int n3 = this.integerMode;
        if (n3 != 0) {
            if (n3 != 1) {
                if (n3 != 2) {
                    return 0;
                }
                return this.largeValue.compareTo(EInteger.FromInt32(n2));
            }
            return this.mnum.ToEInteger().compareTo(EInteger.FromInt32(n2));
        }
        int n4 = this.smallValue;
        if (n2 == n4) {
            return 0;
        }
        if (n4 < n2) {
            return -1;
        }
        return 1;
    }

    public FastInteger Copy() {
        FastInteger fastInteger = new FastInteger(this.smallValue);
        fastInteger.integerMode = this.integerMode;
        fastInteger.largeValue = this.largeValue;
        MutableNumber mutableNumber = this.mnum;
        MutableNumber mutableNumber2 = mutableNumber != null && this.integerMode == 1 ? mutableNumber.Copy() : null;
        fastInteger.mnum = mutableNumber2;
        return fastInteger;
    }

    public FastInteger Decrement() {
        if (this.integerMode == 0) {
            MutableNumber mutableNumber;
            int n2 = this.smallValue;
            if (n2 != Integer.MIN_VALUE) {
                this.smallValue = n2 - 1;
                return this;
            }
            this.integerMode = 1;
            this.mnum = mutableNumber = MutableNumber.FromEInteger(ValueInt32MinValue);
            mutableNumber.SubtractInt(1);
            return this;
        }
        return this.SubtractInt(1);
    }

    public FastInteger Increment() {
        if (this.integerMode == 0) {
            int n2 = this.smallValue;
            if (n2 != Integer.MAX_VALUE) {
                this.smallValue = n2 + 1;
                return this;
            }
            this.integerMode = 1;
            this.mnum = MutableNumber.FromEInteger(ValueNegativeInt32MinValue);
            return this;
        }
        this.AddInt(1);
        return this;
    }

    public FastInteger Negate() {
        int n2 = this.integerMode;
        if (n2 != 0) {
            EInteger eInteger;
            if (n2 != 1) {
                if (n2 == 2) {
                    this.largeValue = this.largeValue.Negate();
                    return this;
                }
                throw new IllegalStateException();
            }
            this.integerMode = 2;
            this.largeValue = eInteger = this.mnum.ToEInteger();
            this.largeValue = eInteger.Negate();
            return this;
        }
        int n3 = this.smallValue;
        if (n3 == Integer.MIN_VALUE) {
            this.integerMode = 1;
            this.mnum = MutableNumber.FromEInteger(ValueNegativeInt32MinValue);
            return this;
        }
        this.smallValue = -n3;
        return this;
    }

    public FastInteger Remainder(int n2) {
        if (n2 != 0) {
            int n3 = this.integerMode;
            if (n3 != 0) {
                EInteger eInteger;
                EInteger eInteger2;
                if (n3 != 1) {
                    if (n3 == 2) {
                        EInteger eInteger3;
                        this.largeValue = eInteger3 = this.largeValue.Remainder(EInteger.FromInt64(n2));
                        this.smallValue = eInteger3.ToInt32Checked();
                        this.integerMode = 0;
                        return this;
                    }
                    throw new IllegalStateException();
                }
                this.largeValue = eInteger2 = this.mnum.ToEInteger();
                this.largeValue = eInteger = eInteger2.Remainder(EInteger.FromInt64(n2));
                this.smallValue = eInteger.ToInt32Checked();
                this.integerMode = 0;
                return this;
            }
            this.smallValue %= n2;
            return this;
        }
        throw new ArithmeticException();
    }

    public FastInteger SetInt(int n2) {
        this.smallValue = n2;
        this.integerMode = 0;
        return this;
    }

    public EInteger ShiftEIntegerLeftByThis(EInteger eInteger) {
        int n2 = this.integerMode;
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 == 2) {
                    return eInteger.ShiftLeft(this.largeValue);
                }
                throw new IllegalStateException();
            }
            return eInteger.ShiftLeft(this.mnum.ToEInteger());
        }
        return eInteger.ShiftLeft(this.smallValue);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public FastInteger Subtract(FastInteger var1_1) {
        block16 : {
            var2_2 = this.integerMode;
            if (var2_2 == 0) ** GOTO lbl33
            if (var2_2 != 1) {
                if (var2_2 != 2) throw new IllegalStateException();
                var33_3 = var1_1.AsEInteger();
                this.largeValue = this.largeValue.Subtract(var33_3);
                return this;
            }
            var6_4 = var1_1.integerMode;
            if (var6_4 == 1) {
                var10_5 = this.mnum;
                var11_6 = var1_1.mnum;
                var12_7 = var10_5.wordCount;
                var13_8 = var11_6.wordCount;
                if (var12_7 <= var13_8) {
                    var12_7 = var13_8;
                }
                var14_9 = var10_5.data;
                if (var14_9.length < var12_7) {
                    var32_10 = new int[var12_7 + 20];
                    System.arraycopy((Object)var14_9, (int)0, (Object)var32_10, (int)0, (int)var14_9.length);
                    var10_5.data = var32_10;
                }
                if ((var15_11 = var10_5.wordCount) >= (var16_12 = var11_6.wordCount)) {
                    var15_11 = var16_12;
                }
                var18_14 = 0;
            } else {
                if (var6_4 == 0 && (var8_28 = var1_1.smallValue) >= 0) {
                    this.mnum.SubtractInt(var8_28);
                    return this;
                }
                this.integerMode = 2;
                this.largeValue = this.mnum.ToEInteger();
                var7_29 = var1_1.AsEInteger();
                this.largeValue = this.largeValue.Subtract(var7_29);
                return this;
lbl33: // 1 sources:
                if (var1_1.integerMode != 0) {
                    this.integerMode = 2;
                    this.largeValue = EInteger.FromInt32(this.smallValue);
                    var3_32 = var1_1.AsEInteger();
                    this.largeValue = this.largeValue.Subtract(var3_32);
                    return this;
                }
                var4_30 = var1_1.smallValue;
                if (var4_30 < 0 && Integer.MAX_VALUE + var4_30 < this.smallValue || var4_30 > 0 && Integer.MIN_VALUE + var4_30 > this.smallValue) {
                    this.integerMode = 2;
                    this.largeValue = var5_31 = EInteger.FromInt32(this.smallValue);
                    this.largeValue = var5_31.Subtract(EInteger.FromInt32(var4_30));
                    return this;
                }
                this.smallValue -= var4_30;
                return this;
            }
            for (var17_13 = 0; var17_13 < var15_11; ++var17_13) {
                var27_15 = var10_5.data;
                var28_16 = var27_15[var17_13];
                var31_19 = var28_16 >> 31;
                var29_17 = var11_6.data;
                var30_18 = var28_16 - var29_17[var17_13] - var18_14;
                if (var31_19 != var30_18 >> 31 ? var31_19 == 0 : (var28_16 & Integer.MAX_VALUE) < (var30_18 & Integer.MAX_VALUE)) ** GOTO lbl-1000
                if (var28_16 != var30_18 || var29_17[var17_13] == 0) {
                    var18_14 = 0;
                } else lbl-1000: // 2 sources:
                {
                    var18_14 = 1;
                }
                var27_15[var17_13] = var30_18;
            }
            if (var18_14 == 0) break block16;
            while (var15_11 < var10_5.wordCount) {
                var22_20 = var10_5.data;
                var23_21 = var22_20[var15_11];
                var26_24 = var23_21 >> 31;
                var24_22 = var11_6.data;
                var25_23 = var23_21 - var24_22[var15_11] - var18_14;
                if (var26_24 != var25_23 >> 31 ? var26_24 == 0 : (var23_21 & Integer.MAX_VALUE) < (var25_23 & Integer.MAX_VALUE)) ** GOTO lbl-1000
                if (var23_21 != var25_23 || var24_22[var15_11] == 0) {
                    var18_14 = 0;
                } else lbl-1000: // 2 sources:
                {
                    var18_14 = 1;
                }
                var22_20[var15_11] = var25_23;
                ++var15_11;
            }
        }
        while ((var19_25 = var10_5.wordCount) != 0) {
            var20_26 = var10_5.data;
            var21_27 = var19_25 - 1;
            if (var20_26[var21_27] != 0) return this;
            var10_5.wordCount = var21_27;
        }
        return this;
    }

    public FastInteger SubtractBig(EInteger eInteger) {
        if (this.integerMode == 2) {
            this.largeValue = this.largeValue.Subtract(eInteger);
            return this;
        }
        int n2 = eInteger.signum();
        if (n2 == 0) {
            return this;
        }
        if (n2 < 0 && eInteger.compareTo(ValueInt32MinValue) > 0) {
            this.AddInt(-eInteger.ToInt32Checked());
            return this;
        }
        if (n2 > 0 && eInteger.compareTo(ValueInt32MaxValue) <= 0) {
            return this.SubtractInt(eInteger.ToInt32Checked());
        }
        return this.AddBig(eInteger.Negate());
    }

    public FastInteger SubtractInt(int n2) {
        if (n2 == Integer.MIN_VALUE) {
            return this.AddBig(ValueNegativeInt32MinValue);
        }
        if (this.integerMode == 0) {
            if (n2 < 0 && Integer.MAX_VALUE + n2 < this.smallValue || n2 > 0 && Integer.MIN_VALUE + n2 > this.smallValue) {
                EInteger eInteger;
                this.integerMode = 2;
                this.largeValue = eInteger = EInteger.FromInt32(this.smallValue);
                this.largeValue = eInteger.Subtract(EInteger.FromInt32(n2));
                return this;
            }
            this.smallValue -= n2;
            return this;
        }
        this.AddInt(-n2);
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int compareTo(FastInteger fastInteger) {
        switch (this.integerMode << 2 | fastInteger.integerMode) {
            default: {
                throw new IllegalStateException();
            }
            case 8: 
            case 9: 
            case 10: {
                return this.largeValue.compareTo(fastInteger.AsEInteger());
            }
            case 6: {
                return this.AsEInteger().compareTo(fastInteger.largeValue);
            }
            case 5: {
                MutableNumber mutableNumber = this.mnum;
                MutableNumber mutableNumber2 = fastInteger.mnum;
                int n2 = mutableNumber.wordCount;
                int n3 = mutableNumber2.wordCount;
                if (n2 != n3) {
                    if (n2 >= n3) return 1;
                    return -1;
                }
                do {
                    int n4 = n2 - 1;
                    if (n2 == 0) return 0;
                    int n5 = mutableNumber.data[n4];
                    int n6 = n5 >> 31;
                    int n7 = mutableNumber2.data[n4];
                    if (n6 == n7 >> 31 ? (n5 & Integer.MAX_VALUE) < (Integer.MAX_VALUE & n7) : n6 == 0) {
                        return -1;
                    }
                    if (n5 != n7) {
                        return 1;
                    }
                    n2 = n4;
                } while (true);
            }
            case 4: {
                return this.mnum.CompareToInt(fastInteger.smallValue);
            }
            case 2: {
                return this.AsEInteger().compareTo(fastInteger.largeValue);
            }
            case 1: {
                return -fastInteger.mnum.CompareToInt(this.smallValue);
            }
            case 0: 
        }
        int n8 = fastInteger.smallValue;
        int n9 = this.smallValue;
        if (n9 == n8) {
            return 0;
        }
        if (n9 >= n8) return 1;
        return -1;
    }

    public final boolean isEvenNumber() {
        block6 : {
            boolean bl;
            block8 : {
                block7 : {
                    int n2 = this.integerMode;
                    if (n2 == 0) break block6;
                    if (n2 != 1) {
                        if (n2 == 2) {
                            return this.largeValue.isEven();
                        }
                        throw new IllegalStateException();
                    }
                    MutableNumber mutableNumber = this.mnum;
                    if (mutableNumber.wordCount == 0) break block7;
                    int n3 = 1 & mutableNumber.data[0];
                    bl = false;
                    if (n3 != 0) break block8;
                }
                bl = true;
            }
            return bl;
        }
        int n4 = 1 & this.smallValue;
        boolean bl = false;
        if (n4 == 0) {
            bl = true;
        }
        return bl;
    }

    public final boolean isValueZero() {
        int n2 = this.integerMode;
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    return false;
                }
                return this.largeValue.isZero();
            }
            boolean bl = this.mnum.wordCount != 0;
            return bl ^ true;
        }
        return this.smallValue == 0;
    }

    public final int signum() {
        int n2 = this.integerMode;
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    return 0;
                }
                return this.largeValue.signum();
            }
            return this.mnum.wordCount != 0;
        }
        int n3 = this.smallValue;
        if (n3 == 0) {
            return 0;
        }
        if (n3 < 0) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        int n2 = this.integerMode;
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    return "";
                }
                return this.largeValue.toString();
            }
            return this.mnum.ToEInteger().toString();
        }
        return FastInteger.IntToString(this.smallValue);
    }

    public static final class MutableNumber {
        public int[] data;
        public int wordCount;

        public MutableNumber(int n2) {
            if (n2 >= 0) {
                int[] arrn = new int[4];
                this.data = arrn;
                int n3 = n2 == 0 ? 0 : 1;
                this.wordCount = n3;
                arrn[0] = n2;
                return;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"val (", (int)n2, (String)") is less than 0 "));
        }

        public static MutableNumber FromEInteger(EInteger eInteger) {
            int n2 = 0;
            MutableNumber mutableNumber = new MutableNumber(0);
            if (eInteger.signum() >= 0) {
                int n3;
                byte[] arrby = eInteger.ToBytes(true);
                int n4 = arrby.length;
                int n5 = Math.max((int)4, (int)(1 + n4 / 4));
                if (n5 > mutableNumber.data.length) {
                    mutableNumber.data = new int[n5];
                }
                mutableNumber.wordCount = n5;
                while (n2 < n4) {
                    int n6;
                    int n7;
                    int n8 = 255 & arrby[n2];
                    int n9 = n2 + 1;
                    if (n9 < n4) {
                        n8 |= (255 & arrby[n9]) << 8;
                    }
                    if ((n7 = n2 + 2) < n4) {
                        n8 |= (255 & arrby[n7]) << 16;
                    }
                    if ((n6 = n2 + 3) < n4) {
                        n8 |= (255 & arrby[n6]) << 24;
                    }
                    mutableNumber.data[n2 >> 2] = n8;
                    n2 += 4;
                }
                while ((n3 = mutableNumber.wordCount) != 0 && mutableNumber.data[n3 - 1] == 0) {
                    mutableNumber.wordCount = n3 - 1;
                }
                return mutableNumber;
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"bigintVal's sign (");
            stringBuilder.append(eInteger.signum());
            stringBuilder.append(") is less than 0 ");
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public MutableNumber Add(int var1_1) {
            block9 : {
                if (var1_1 < 0) throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"augend (", (int)var1_1, (String)") is less than 0 "));
                if (var1_1 == 0) break block9;
                if (this.wordCount == 0) {
                    if (this.data.length == 0) {
                        this.data = new int[4];
                    }
                    this.data[0] = 0;
                    this.wordCount = 1;
                }
                var4_3 = 0;
                for (var3_2 = 0; var3_2 < (var5_4 = this.wordCount); ++var3_2) {
                    var10_5 = this.data;
                    var11_6 = var10_5[var3_2];
                    var12_7 = var4_3 + (var11_6 + var1_1);
                    var13_8 = var12_7 >> 31;
                    if (var13_8 != var11_6 >> 31 ? var13_8 == 0 : (var12_7 & Integer.MAX_VALUE) < (Integer.MAX_VALUE & var11_6)) ** GOTO lbl-1000
                    if (var12_7 != var11_6 || var1_1 == 0) {
                        var4_3 = 0;
                    } else lbl-1000: // 2 sources:
                    {
                        var4_3 = 1;
                    }
                    var10_5[var3_2] = var12_7;
                    if (var4_3 == 0) {
                        return this;
                    }
                    var1_1 = 0;
                }
                if (var4_3 != 0) {
                    var6_9 = this.data;
                    if (var5_4 >= var6_9.length) {
                        var9_10 = new int[var5_4 + 20];
                        System.arraycopy((Object)var6_9, (int)0, (Object)var9_10, (int)0, (int)var6_9.length);
                        this.data = var9_10;
                    }
                    var7_11 = this.data;
                    var8_12 = this.wordCount;
                    var7_11[var8_12] = var4_3;
                    this.wordCount = var8_12 + 1;
                }
            }
            while ((var2_13 = this.wordCount) != 0) {
                if (this.data[var2_13 - 1] != 0) return this;
                this.wordCount = var2_13 - 1;
            }
            return this;
        }

        public int CompareToInt(int n2) {
            int n3 = 1;
            if (n2 >= 0) {
                int n4 = this.wordCount;
                if (n4 > n3) {
                    return n3;
                }
                int n5 = -1;
                if (n4 == 0) {
                    if (n2 == 0) {
                        n5 = 0;
                    }
                    return n5;
                }
                int[] arrn = this.data;
                if (arrn[0] == n2) {
                    return 0;
                }
                if (arrn[0] >> 31 == n2 >> 31 ? (Integer.MAX_VALUE & arrn[0]) < (n2 & Integer.MAX_VALUE) : arrn[0] >> 31 == 0) {
                    n3 = n5;
                }
            }
            return n3;
        }

        public MutableNumber Copy() {
            MutableNumber mutableNumber = new MutableNumber(0);
            int n2 = this.wordCount;
            if (n2 > mutableNumber.data.length) {
                mutableNumber.data = new int[n2];
            }
            System.arraycopy((Object)this.data, (int)0, (Object)mutableNumber.data, (int)0, (int)n2);
            mutableNumber.wordCount = this.wordCount;
            return mutableNumber;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public MutableNumber SubtractInt(int var1_1) {
            if (var1_1 < 0) throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"other (", (int)var1_1, (String)") is less than 0 "));
            if (var1_1 == 0) return this;
            if (this.wordCount == 0) {
                if (this.data.length == 0) {
                    this.data = new int[4];
                }
                this.data[0] = 0;
                this.wordCount = 1;
            }
            if ((var5_5 = (var3_3 = (var2_2 = this.data)[0]) >> 31) != (var4_4 = var3_3 - var1_1) >> 31 ? var5_5 == 0 : (var3_3 & Integer.MAX_VALUE) < (var4_4 & Integer.MAX_VALUE)) ** GOTO lbl-1000
            if (var3_3 != var4_4 || var1_1 == 0) {
                var6_6 = 0;
            } else lbl-1000: // 2 sources:
            {
                var6_6 = 1;
            }
            var2_2[0] = var4_4;
            if (var6_6 != 0) {
                for (var8_7 = 1; var8_7 < this.wordCount; ++var8_7) {
                    var9_8 = this.data;
                    var10_9 = var9_8[var8_7] - var6_6;
                    var6_6 = (var9_8[var8_7] >> 31 == var10_9 >> 31 ? (Integer.MAX_VALUE & var9_8[var8_7]) < (var10_9 & Integer.MAX_VALUE) : var9_8[var8_7] >> 31 == 0) ? 1 : 0;
                    var9_8[var8_7] = var10_9;
                }
            }
            while ((var7_10 = this.wordCount) != 0) {
                if (this.data[var7_10 - 1] != 0) return this;
                this.wordCount = var7_10 - 1;
            }
            return this;
        }

        public EInteger ToEInteger() {
            int[] arrn;
            int[] arrn2;
            int n2;
            int n3 = this.wordCount;
            if (n3 == 1 && (arrn2 = this.data)[0] >> 31 == 0) {
                return EInteger.FromInt64(arrn2[0]);
            }
            if (n3 == 2 && (arrn = this.data)[1] >> 31 == 0) {
                return EInteger.FromInt64(0xFFFFFFFFL & (long)arrn[0] | (long)arrn[1] << 32);
            }
            int[] arrn3 = this.data;
            int n4 = n3 << 1;
            short[] arrs = new short[n4];
            int n5 = 0;
            int n6 = 0;
            while (n5 < n3) {
                int n7 = arrn3[n5];
                arrs[n6] = (short)n7;
                arrs[n6 + 1] = (short)(n7 >> 16);
                ++n5;
                n6 += 2;
            }
            while (n4 != 0 && arrs[n2 = n4 - 1] == 0) {
                n4 = n2;
            }
            if (n4 == 0) {
                return EInteger.FromInt32(0);
            }
            return new EInteger(n4, arrs, false);
        }
    }

}

