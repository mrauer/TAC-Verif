/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.upokecenter.numbers;

import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.FastInteger;

public final class NumberUtility {
    public static final EInteger ValueBigInt36;
    public static final EInteger[] ValueBigIntPowersOfFive;
    public static final EInteger[] ValueBigIntPowersOfTen;
    public static final EInteger ValueFivePower40;
    public static final PowerCache ValuePowerOfFiveCache;
    public static final PowerCache ValuePowerOfTenCache;

    public static {
        EInteger[] arreInteger = new EInteger[]{EInteger.FromInt32(1), EInteger.FromInt32(10), EInteger.FromInt64(100L), EInteger.FromInt64(1000L), EInteger.FromInt64(10000L), EInteger.FromInt64(100000L), EInteger.FromInt64(1000000L), EInteger.FromInt64(10000000L), EInteger.FromInt64(100000000L), EInteger.FromInt64(1000000000L), EInteger.FromInt64(10000000000L), EInteger.FromInt64(100000000000L), EInteger.FromInt64(1000000000000L), EInteger.FromInt64(10000000000000L), EInteger.FromInt64(100000000000000L), EInteger.FromInt64(1000000000000000L), EInteger.FromInt64(10000000000000000L), EInteger.FromInt64(100000000000000000L), EInteger.FromInt64(1000000000000000000L)};
        ValueBigIntPowersOfTen = arreInteger;
        EInteger[] arreInteger2 = new EInteger[]{EInteger.FromInt32(1), EInteger.FromInt64(5L), EInteger.FromInt64(25L), EInteger.FromInt64(125L), EInteger.FromInt64(625L), EInteger.FromInt64(3125L), EInteger.FromInt64(15625L), EInteger.FromInt64(78125L), EInteger.FromInt64(390625L), EInteger.FromInt64(1953125L), EInteger.FromInt64(9765625L), EInteger.FromInt64(48828125L), EInteger.FromInt64(244140625L), EInteger.FromInt64(1220703125L), EInteger.FromInt64(6103515625L), EInteger.FromInt64(30517578125L), EInteger.FromInt64(152587890625L), EInteger.FromInt64(762939453125L), EInteger.FromInt64(3814697265625L), EInteger.FromInt64(19073486328125L), EInteger.FromInt64(95367431640625L), EInteger.FromInt64(476837158203125L), EInteger.FromInt64(2384185791015625L), EInteger.FromInt64(11920928955078125L), EInteger.FromInt64(59604644775390625L), EInteger.FromInt64(298023223876953125L), EInteger.FromInt64(1490116119384765625L), EInteger.FromInt64(7450580596923828125L)};
        ValueBigIntPowersOfFive = arreInteger2;
        ValuePowerOfFiveCache = new PowerCache();
        ValuePowerOfTenCache = new PowerCache();
        ValueBigInt36 = EInteger.FromInt64(36L);
        ValueFivePower40 = EInteger.FromInt64(95367431640625L).Multiply(EInteger.FromInt64(95367431640625L));
    }

    public static int CountTrailingZeros(int n2) {
        if (n2 == 0) {
            return 32;
        }
        int n3 = n2 << 16;
        int n4 = 0;
        if (n3 == 0) {
            n2 >>= 16;
            n4 = 16;
        }
        if (n2 << 24 == 0) {
            n2 >>= 8;
            n4 += 8;
        }
        if (n2 << 28 == 0) {
            n2 >>= 4;
            n4 += 4;
        }
        if (n2 << 30 == 0) {
            n2 >>= 2;
            n4 += 2;
        }
        if (n2 << 31 == 0) {
            ++n4;
        }
        return n4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static EInteger FindPowerOfFive(int n2) {
        EInteger[] arreInteger;
        if (n2 < 0) {
            return EInteger.FromInt32(0);
        }
        if (n2 <= 27) {
            return ValueBigIntPowersOfFive[n2];
        }
        if (n2 == 40) {
            return ValueFivePower40;
        }
        PowerCache powerCache = ValuePowerOfFiveCache;
        EInteger eInteger = powerCache.GetCachedPowerInt(n2);
        if (eInteger != null) {
            return eInteger;
        }
        EInteger eInteger2 = EInteger.FromInt32(n2);
        if (n2 <= 54) {
            if ((n2 & 1) == 0) {
                EInteger eInteger3 = ValueBigIntPowersOfFive[n2 >> 1];
                EInteger eInteger4 = eInteger3.Multiply(eInteger3);
                powerCache.AddPower(eInteger2, eInteger4);
                return eInteger4;
            }
            EInteger[] arreInteger2 = ValueBigIntPowersOfFive;
            EInteger eInteger5 = arreInteger2[27].Multiply(arreInteger2[n2 - 27]);
            powerCache.AddPower(eInteger2, eInteger5);
            return eInteger5;
        }
        if (n2 > 40 && n2 <= 94) {
            EInteger eInteger6 = ValueFivePower40.Multiply(NumberUtility.FindPowerOfFive(n2 - 40));
            powerCache.AddPower(eInteger2, eInteger6);
            return eInteger6;
        }
        EInteger eInteger7 = EInteger.FromInt32(0);
        int n3 = n2;
        boolean bl = true;
        while ((arreInteger = ValuePowerOfFiveCache.FindCachedPowerIntOrSmaller(n3)) != null) {
            EInteger eInteger8 = arreInteger[0];
            EInteger eInteger9 = arreInteger[1];
            n3 -= eInteger8.ToInt32Checked();
            eInteger7 = bl ? arreInteger[1] : eInteger7.Multiply(eInteger9);
            bl = false;
        }
        EInteger eInteger10 = !bl ? eInteger7 : EInteger.FromInt32(1);
        while (n3 > 0) {
            block19 : {
                EInteger eInteger11;
                block18 : {
                    block17 : {
                        if (n3 > 27) break block17;
                        eInteger11 = ValueBigIntPowersOfFive[n3];
                        if (!bl) {
                            eInteger11 = eInteger10.Multiply(eInteger11);
                        }
                        break block18;
                    }
                    if (n3 > 9999999) break block19;
                    EInteger eInteger12 = ValueBigIntPowersOfFive[1].Pow(n3);
                    if (n3 != n2) {
                        EInteger eInteger13 = EInteger.FromInt32(n3);
                        ValuePowerOfFiveCache.AddPower(eInteger13, eInteger12);
                    }
                    if (bl) {
                        eInteger10 = eInteger12;
                        break;
                    }
                    eInteger11 = eInteger10.Multiply(eInteger12);
                }
                eInteger10 = eInteger11;
                break;
            }
            if (eInteger7.isZero()) {
                eInteger7 = NumberUtility.FindPowerOfFive(9999999);
            }
            eInteger10 = bl ? eInteger7 : eInteger10.Multiply(eInteger7);
            n3 -= 9999999;
            bl = false;
        }
        ValuePowerOfFiveCache.AddPower(eInteger2, eInteger10);
        return eInteger10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static EInteger FindPowerOfTen(int n2) {
        EInteger[] arreInteger;
        if (n2 < 0) {
            return EInteger.FromInt32(0);
        }
        if (n2 <= 18) {
            return ValueBigIntPowersOfTen[n2];
        }
        PowerCache powerCache = ValuePowerOfTenCache;
        EInteger eInteger = powerCache.GetCachedPowerInt(n2);
        if (eInteger != null) {
            return eInteger;
        }
        EInteger eInteger2 = EInteger.FromInt32(n2);
        if (n2 <= 27) {
            EInteger eInteger3 = ValueBigIntPowersOfFive[n2].ShiftLeft(n2);
            powerCache.AddPower(eInteger2, eInteger3);
            return eInteger3;
        }
        if (n2 <= 36) {
            if ((n2 & 1) == 0) {
                EInteger eInteger4 = ValueBigIntPowersOfTen[n2 >> 1];
                EInteger eInteger5 = eInteger4.Multiply(eInteger4);
                powerCache.AddPower(eInteger2, eInteger5);
                return eInteger5;
            }
            EInteger[] arreInteger2 = ValueBigIntPowersOfTen;
            EInteger eInteger6 = arreInteger2[18].Multiply(arreInteger2[n2 - 18]);
            powerCache.AddPower(eInteger2, eInteger6);
            return eInteger6;
        }
        EInteger eInteger7 = EInteger.FromInt32(0);
        int n3 = n2;
        boolean bl = true;
        while ((arreInteger = ValuePowerOfTenCache.FindCachedPowerOrSmaller(EInteger.FromInt32(n3))) != null) {
            EInteger eInteger8 = arreInteger[0];
            EInteger eInteger9 = arreInteger[1];
            n3 -= eInteger8.ToInt32Checked();
            eInteger7 = bl ? arreInteger[1] : eInteger7.Multiply(eInteger9);
            bl = false;
        }
        EInteger eInteger10 = !bl ? eInteger7 : EInteger.FromInt32(1);
        while (n3 > 0) {
            block18 : {
                EInteger eInteger11;
                block17 : {
                    block16 : {
                        if (n3 > 18) break block16;
                        eInteger11 = ValueBigIntPowersOfTen[n3];
                        if (!bl) {
                            eInteger11 = eInteger10.Multiply(eInteger11);
                        }
                        break block17;
                    }
                    if (n3 > 9999999) break block18;
                    EInteger eInteger12 = NumberUtility.FindPowerOfFive(n3).ShiftLeft(n3);
                    if (n3 != n2) {
                        EInteger eInteger13 = EInteger.FromInt32(n3);
                        ValuePowerOfTenCache.AddPower(eInteger13, eInteger12);
                    }
                    if (bl) {
                        eInteger10 = eInteger12;
                        break;
                    }
                    eInteger11 = eInteger10.Multiply(eInteger12);
                }
                eInteger10 = eInteger11;
                break;
            }
            if (eInteger7.isZero()) {
                eInteger7 = NumberUtility.FindPowerOfTen(9999999);
            }
            eInteger10 = bl ? eInteger7 : eInteger10.Multiply(eInteger7);
            n3 -= 9999999;
            bl = false;
        }
        ValuePowerOfTenCache.AddPower(eInteger2, eInteger10);
        return eInteger10;
    }

    public static EInteger FindPowerOfTenFromBig(EInteger eInteger) {
        int n2 = eInteger.signum();
        if (n2 < 0) {
            return EInteger.FromInt32(0);
        }
        if (n2 == 0) {
            return EInteger.FromInt32(1);
        }
        if (eInteger.compareTo(ValueBigInt36) <= 0) {
            return NumberUtility.FindPowerOfTen(eInteger.ToInt32Checked());
        }
        FastInteger fastInteger = FastInteger.FromBig(eInteger);
        EInteger eInteger2 = EInteger.FromInt32(1);
        EInteger eInteger3 = EInteger.FromInt32(0);
        while (fastInteger.signum() > 0) {
            if (fastInteger.CompareToInt(18) <= 0) {
                return eInteger2.Multiply(NumberUtility.FindPowerOfTen(fastInteger.AsInt32()));
            }
            if (fastInteger.CompareToInt(9999999) <= 0) {
                int n3 = fastInteger.AsInt32();
                return eInteger2.Multiply(NumberUtility.FindPowerOfFive(n3).ShiftLeft(n3));
            }
            if (eInteger3.isZero()) {
                eInteger3 = NumberUtility.FindPowerOfFive(9999999).ShiftLeft(9999999);
            }
            eInteger2 = eInteger2.Multiply(eInteger3);
            fastInteger.AddInt(-9999999);
        }
        return eInteger2;
    }

    public static EInteger ReduceTrailingZeros(EInteger eInteger, FastInteger fastInteger, int n2, FastInteger fastInteger2, FastInteger fastInteger3, FastInteger fastInteger4) {
        if (eInteger.isZero()) {
            fastInteger.SetInt(0);
            return eInteger;
        }
        EInteger eInteger2 = EInteger.FromInt32(n2);
        FastInteger fastInteger5 = new FastInteger(0);
        int n3 = 0;
        while (!(eInteger.isZero() || fastInteger3 != null && fastInteger2.compareTo(fastInteger3) == 0 || fastInteger4 != null && fastInteger.compareTo(fastInteger4) == 0)) {
            if (n2 == 2) {
                if (n3 < Integer.MAX_VALUE) {
                    if (eInteger.GetSignedBit(n3)) break;
                    ++n3;
                    fastInteger5.Increment();
                } else {
                    if (!eInteger.isEven()) break;
                    eInteger = eInteger.ShiftRight(1);
                }
            } else {
                EInteger[] arreInteger = eInteger.DivRem(eInteger2);
                EInteger eInteger3 = arreInteger[0];
                if (!arreInteger[1].isZero()) break;
                eInteger = eInteger3;
            }
            fastInteger.Increment();
            if (fastInteger2 == null) continue;
            fastInteger2.Decrement();
        }
        if (n2 == 2 && !fastInteger5.isValueZero()) {
            while (fastInteger5.CompareToInt(1000000) > 0) {
                eInteger = eInteger.ShiftRight(1000000);
                fastInteger5.SubtractInt(1000000);
            }
            eInteger = eInteger.ShiftRight(fastInteger5.AsInt32());
        }
        return eInteger;
    }

    public static int ShiftAwayTrailingZerosTwoElements(int[] arrn) {
        int n2 = arrn[0];
        int n3 = arrn[1];
        int n4 = NumberUtility.CountTrailingZeros(n2);
        if (n4 == 0) {
            return 0;
        }
        if (n4 < 32) {
            int n5 = n3 << 32 - n4;
            int n6 = n2 >> n4;
            int n7 = Integer.MAX_VALUE >> n4 - 1;
            arrn[0] = n5 | n6 & n7;
            arrn[1] = n7 & n3 >> n4;
            return n4;
        }
        int n8 = NumberUtility.CountTrailingZeros(n3);
        arrn[0] = n8 == 32 ? 0 : (n8 > 0 ? n3 >> n8 & Integer.MAX_VALUE >> n8 - 1 : n3);
        arrn[1] = 0;
        return n8 + 32;
    }

    public static final class PowerCache {
        public final EInteger[] inputs = new EInteger[128];
        public final int[] inputsInts = new int[128];
        public final EInteger[] outputs = new EInteger[128];
        public int size;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void AddPower(EInteger eInteger, EInteger eInteger2) {
            EInteger[] arreInteger;
            EInteger[] arreInteger2 = arreInteger = this.outputs;
            synchronized (arreInteger2) {
                int n2 = this.size;
                int n3 = -1;
                if (n2 < 128) {
                    while (n2 > 0) {
                        EInteger[] arreInteger3 = this.inputs;
                        int n4 = n2 - 1;
                        arreInteger3[n2] = arreInteger3[n4];
                        int[] arrn = this.inputsInts;
                        arrn[n2] = arrn[n4];
                        EInteger[] arreInteger4 = this.outputs;
                        arreInteger4[n2] = arreInteger4[n4];
                        n2 = n4;
                    }
                    this.inputs[0] = eInteger;
                    int[] arrn = this.inputsInts;
                    if (eInteger.CanFitInInt32()) {
                        n3 = eInteger.ToInt32Checked();
                    }
                    arrn[0] = n3;
                    this.outputs[0] = eInteger2;
                    this.size = 1 + this.size;
                } else {
                    int n5 = 127;
                    while (n5 > 0) {
                        EInteger[] arreInteger5 = this.inputs;
                        int n6 = n5 - 1;
                        arreInteger5[n5] = arreInteger5[n6];
                        int[] arrn = this.inputsInts;
                        arrn[n5] = arrn[n6];
                        EInteger[] arreInteger6 = this.outputs;
                        arreInteger6[n5] = arreInteger6[n6];
                        n5 = n6;
                    }
                    this.inputs[0] = eInteger;
                    int[] arrn = this.inputsInts;
                    if (eInteger.CanFitInInt32()) {
                        n3 = eInteger.ToInt32Checked();
                    }
                    arrn[0] = n3;
                    this.outputs[0] = eInteger2;
                }
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public EInteger[] FindCachedPowerIntOrSmaller(int n2) {
            EInteger[] arreInteger;
            EInteger[] arreInteger2 = arreInteger = this.outputs;
            synchronized (arreInteger2) {
                EInteger[] arreInteger3 = null;
                int n3 = 0;
                int n4 = -1;
                while (n3 < this.size) {
                    int[] arrn = this.inputsInts;
                    if (arrn[n3] >= 0 && arrn[n3] <= n2 && (n4 == -1 || arrn[n3] >= n4)) {
                        arreInteger3 = new EInteger[]{this.inputs[n3], this.outputs[n3]};
                        n4 = arrn[n3];
                    }
                    ++n3;
                }
                return arreInteger3;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public EInteger[] FindCachedPowerOrSmaller(EInteger eInteger) {
            EInteger[] arreInteger;
            if (eInteger.CanFitInInt32()) {
                return this.FindCachedPowerIntOrSmaller(eInteger.ToInt32Checked());
            }
            EInteger[] arreInteger2 = arreInteger = this.outputs;
            synchronized (arreInteger2) {
                EInteger[] arreInteger3 = null;
                int n2 = 0;
                EInteger eInteger2 = null;
                while (n2 < this.size) {
                    if (this.inputs[n2].compareTo(eInteger) <= 0 && (eInteger2 == null || this.inputs[n2].compareTo(eInteger2) >= 0)) {
                        arreInteger3 = new EInteger[2];
                        EInteger[] arreInteger4 = this.inputs;
                        arreInteger3[0] = arreInteger4[n2];
                        arreInteger3[1] = this.outputs[n2];
                        eInteger2 = arreInteger4[n2];
                    }
                    ++n2;
                }
                return arreInteger3;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public EInteger GetCachedPowerInt(int n2) {
            EInteger[] arreInteger;
            EInteger[] arreInteger2 = arreInteger = this.outputs;
            synchronized (arreInteger2) {
                int n3 = 0;
                while (n3 < this.size) {
                    int[] arrn = this.inputsInts;
                    if (arrn[n3] >= 0 && arrn[n3] == n2) {
                        if (n3 == 0) return this.outputs[0];
                        EInteger[] arreInteger3 = this.inputs;
                        EInteger eInteger = arreInteger3[n3];
                        arreInteger3[n3] = arreInteger3[0];
                        arreInteger3[0] = eInteger;
                        int n4 = arrn[n3];
                        arrn[n3] = arrn[0];
                        arrn[0] = n4;
                        EInteger[] arreInteger4 = this.outputs;
                        EInteger eInteger2 = arreInteger4[n3];
                        arreInteger4[n3] = arreInteger4[0];
                        arreInteger4[0] = eInteger2;
                        if (n3 == 1) return this.outputs[0];
                        EInteger eInteger3 = arreInteger3[n3];
                        arreInteger3[n3] = arreInteger3[1];
                        arreInteger3[1] = eInteger3;
                        int n5 = arrn[n3];
                        arrn[n3] = arrn[1];
                        arrn[1] = n5;
                        EInteger eInteger4 = arreInteger4[n3];
                        arreInteger4[n3] = arreInteger4[1];
                        arreInteger4[1] = eInteger4;
                        return this.outputs[0];
                    }
                    ++n3;
                }
                return null;
            }
        }
    }

}

