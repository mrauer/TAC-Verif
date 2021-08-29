/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
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

public final class BitShiftAccumulator
implements IShiftAccumulator {
    public int bitLeftmost;
    public int bitsAfterLeftmost;
    public FastInteger discardedBitCount;
    public boolean isSmall;
    public FastInteger knownBitLength;
    public EInteger shiftedBigInt;
    public int shiftedSmall;

    public BitShiftAccumulator(int n2, int n3, int n4) {
        this.shiftedSmall = n2;
        if (n2 >= 0) {
            boolean bl;
            this.isSmall = bl = true;
            this.discardedBitCount = new FastInteger(0);
            boolean bl2 = n4 != 0 ? bl : false;
            this.bitsAfterLeftmost = bl2 ? 1 : 0;
            if (n3 == 0) {
                bl = false;
            }
            this.bitLeftmost = bl ? 1 : 0;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline20((StringBuilder)GeneratedOutlineSupport.outline24((String)"shiftedSmall ("), (int)this.shiftedSmall, (String)") is less than 0"));
    }

    public BitShiftAccumulator(EInteger eInteger, int n2, int n3) {
        if (eInteger.signum() >= 0) {
            boolean bl = eInteger.CanFitInInt32();
            boolean bl2 = true;
            if (bl) {
                this.isSmall = bl2;
                this.shiftedSmall = eInteger.ToInt32Checked();
            } else {
                this.shiftedBigInt = eInteger;
            }
            this.discardedBitCount = new FastInteger(0);
            boolean bl3 = n3 != 0 ? bl2 : false;
            this.bitsAfterLeftmost = bl3 ? 1 : 0;
            if (n2 == 0) {
                bl2 = false;
            }
            this.bitLeftmost = bl2 ? 1 : 0;
            return;
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"bigint's sign (");
        stringBuilder.append(eInteger.signum());
        stringBuilder.append(") is less than 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final FastInteger CalcKnownBitLength() {
        if (this.isSmall) {
            int n2 = 32;
            for (int i2 = 31; i2 >= 0 && (this.shiftedSmall & 1 << i2) == 0; --i2) {
                --n2;
            }
            if (n2 == 0) {
                ++n2;
            }
            return new FastInteger(n2);
        }
        if (this.shiftedBigInt.isZero()) {
            return new FastInteger(1);
        }
        return FastInteger.FromBig(this.shiftedBigInt.GetSignedBitLengthAsEInteger());
    }

    @Override
    public FastInteger GetDigitLength() {
        FastInteger fastInteger = this.knownBitLength;
        if (fastInteger == null) {
            fastInteger = this.CalcKnownBitLength();
        }
        this.knownBitLength = fastInteger;
        FastInteger fastInteger2 = new FastInteger(fastInteger.smallValue);
        fastInteger2.integerMode = fastInteger.integerMode;
        fastInteger2.largeValue = fastInteger.largeValue;
        FastInteger.MutableNumber mutableNumber = fastInteger.mnum;
        FastInteger.MutableNumber mutableNumber2 = mutableNumber != null && fastInteger.integerMode == 1 ? mutableNumber.Copy() : null;
        fastInteger2.mnum = mutableNumber2;
        fastInteger2.frozen = true;
        return fastInteger2;
    }

    public void ShiftRight(FastInteger fastInteger) {
        if (fastInteger.signum() <= 0) {
            return;
        }
        if (fastInteger.CanFitInInt32()) {
            this.ShiftRightInt(fastInteger.AsInt32());
            return;
        }
        EInteger eInteger = fastInteger.AsEInteger();
        while (eInteger.signum() > 0) {
            int n2 = 1000000;
            if (eInteger.compareTo(EInteger.FromInt64(1000000L)) < 0) {
                n2 = eInteger.ToInt32Checked();
            }
            this.ShiftRightInt(n2);
            eInteger = eInteger.Subtract(EInteger.FromInt32(n2));
            if (!(this.isSmall ? this.shiftedSmall == 0 : this.shiftedBigInt.isZero())) continue;
            return;
        }
    }

    @Override
    public void ShiftRightInt(int n2) {
        boolean bl = this.isSmall;
        int n3 = 1;
        int n4 = 32;
        if (bl) {
            int n5;
            int n6;
            int n7;
            if (n2 <= 0) {
                return;
            }
            if (this.shiftedSmall == 0) {
                this.discardedBitCount.AddInt(n2);
                this.bitsAfterLeftmost |= this.bitLeftmost;
                this.bitLeftmost = 0;
                this.knownBitLength = new FastInteger(n3);
                return;
            }
            for (int i2 = 31; i2 >= 0 && (this.shiftedSmall & n3 << i2) == 0; --i2) {
                --n4;
            }
            int n8 = Math.min((int)n4, (int)n2);
            int n9 = n2 > n4 ? n3 : 0;
            this.knownBitLength = new FastInteger(n4 - n8);
            this.discardedBitCount.AddInt(n2);
            this.bitsAfterLeftmost = n5 = this.bitsAfterLeftmost | this.bitLeftmost;
            int n10 = n8 > n3 && this.shiftedSmall << n3 + (32 - n8) != 0 ? n3 : 0;
            this.bitsAfterLeftmost = n6 = n5 | n10;
            int n11 = this.shiftedSmall;
            this.bitLeftmost = n7 = n3 & n11 >> n8 - 1;
            this.shiftedSmall = n11 >> n8;
            if (n9 != 0) {
                this.bitsAfterLeftmost = n6 | n7;
                this.bitLeftmost = 0;
            }
            if (this.bitsAfterLeftmost == 0) {
                n3 = 0;
            }
            this.bitsAfterLeftmost = n3;
            return;
        }
        if (n2 <= 0) {
            return;
        }
        if (this.shiftedBigInt.isZero()) {
            this.discardedBitCount.AddInt(n2);
            this.bitsAfterLeftmost |= this.bitLeftmost;
            this.bitLeftmost = 0;
            this.isSmall = n3;
            this.shiftedSmall = 0;
            this.knownBitLength = new FastInteger(n3);
            return;
        }
        FastInteger fastInteger = this.knownBitLength;
        if (fastInteger == null) {
            fastInteger = this.CalcKnownBitLength();
        }
        this.knownBitLength = fastInteger;
        this.discardedBitCount.AddInt(n2);
        if (this.knownBitLength.CompareToInt(n2) < 0) {
            int n12;
            this.bitsAfterLeftmost = n12 = this.bitsAfterLeftmost | this.bitLeftmost;
            this.bitsAfterLeftmost = n12 | n3 ^ this.shiftedBigInt.isZero();
            this.bitLeftmost = 0;
            this.isSmall = n3;
            this.shiftedSmall = 0;
            this.knownBitLength = new FastInteger(n3);
            return;
        }
        this.knownBitLength.SubtractInt(n2);
        if (n2 == n3) {
            int n13 = n3 ^ this.shiftedBigInt.isEven();
            this.shiftedBigInt = this.shiftedBigInt.ShiftRight(n3);
            this.bitsAfterLeftmost |= this.bitLeftmost;
            this.bitLeftmost = n13;
        } else {
            int n14;
            this.bitsAfterLeftmost |= this.bitLeftmost;
            EInteger eInteger = this.shiftedBigInt.GetLowBitAsEInteger();
            if (eInteger.compareTo(n14 = n2 - 1) < 0) {
                this.bitsAfterLeftmost = n3 | this.bitsAfterLeftmost;
                this.bitLeftmost = this.shiftedBigInt.GetSignedBit(n14) ? 1 : 0;
            } else {
                this.bitLeftmost = eInteger.compareTo(n14) > 0 ? 0 : n3;
            }
            this.shiftedBigInt = this.shiftedBigInt.ShiftRight(n2);
        }
        if (this.knownBitLength.CompareToInt(n4) < 0) {
            this.isSmall = n3;
            this.shiftedSmall = this.shiftedBigInt.ToInt32Checked();
        }
        if (this.bitsAfterLeftmost == 0) {
            n3 = 0;
        }
        this.bitsAfterLeftmost = n3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void ShiftToDigits(FastInteger fastInteger, FastInteger fastInteger2, boolean bl) {
        if (fastInteger.signum() >= 0) {
            if (fastInteger2 != null && fastInteger2.signum() > 0) {
                FastInteger fastInteger3 = this.knownBitLength;
                if (fastInteger3 == null) {
                    fastInteger3 = this.CalcKnownBitLength();
                }
                this.knownBitLength = fastInteger3;
                if (fastInteger3.compareTo(fastInteger) <= 0) {
                    this.ShiftRight(fastInteger2);
                    return;
                }
                FastInteger fastInteger4 = this.knownBitLength.Copy();
                fastInteger4.Subtract(fastInteger);
                if (fastInteger4.compareTo(fastInteger2) <= 0) {
                    this.ShiftRight(fastInteger2);
                    return;
                }
                this.ShiftRight(fastInteger4);
                return;
            }
            if (fastInteger.CanFitInInt32()) {
                int n2;
                int n3 = fastInteger.AsInt32();
                if (n3 < 0) throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"bits (", (int)n3, (String)") is less than 0"));
                boolean bl2 = this.isSmall;
                int n4 = 1;
                if (bl2) {
                    FastInteger fastInteger5 = this.knownBitLength;
                    if (fastInteger5 != null && fastInteger5.CompareToInt(n3) <= 0) {
                        return;
                    }
                    FastInteger fastInteger6 = this.knownBitLength;
                    if (fastInteger6 == null) {
                        fastInteger6 = this.CalcKnownBitLength();
                    }
                    this.knownBitLength = fastInteger6;
                    if (fastInteger6.CompareToInt(n3) <= 0) {
                        return;
                    }
                    int n5 = this.knownBitLength.AsInt32();
                    if (n5 > n3) {
                        int n6;
                        int n7;
                        int n8 = n5 - n3;
                        this.knownBitLength = new FastInteger(n3);
                        this.discardedBitCount.AddInt(n8);
                        this.bitsAfterLeftmost = n6 = this.bitsAfterLeftmost | this.bitLeftmost;
                        int n9 = n8 > n4 && this.shiftedSmall << n4 + (32 - n8) != 0 ? n4 : 0;
                        this.bitsAfterLeftmost = n7 = n6 | n9;
                        int n10 = this.shiftedSmall;
                        this.bitLeftmost = n4 & n10 >> n8 - 1;
                        if (n7 == 0) {
                            n4 = 0;
                        }
                        this.bitsAfterLeftmost = n4;
                        this.shiftedSmall = n10 >> n8;
                        return;
                    }
                    this.knownBitLength = new FastInteger(n5);
                    return;
                }
                FastInteger fastInteger7 = this.knownBitLength;
                if (fastInteger7 != null && fastInteger7.CompareToInt(n3) <= 0) {
                    return;
                }
                FastInteger fastInteger8 = this.knownBitLength;
                if (fastInteger8 == null) {
                    fastInteger8 = this.CalcKnownBitLength();
                }
                this.knownBitLength = fastInteger8;
                if (fastInteger8.CompareToInt(n3) <= 0) {
                    return;
                }
                if (this.knownBitLength.CompareToInt(n3) <= 0) return;
                if (this.knownBitLength.CanFitInInt32()) {
                    n2 = this.knownBitLength.AsInt32() - n3;
                } else {
                    FastInteger fastInteger9 = this.knownBitLength.Copy().SubtractInt(n3);
                    if (!fastInteger9.CanFitInInt32()) {
                        this.ShiftRight(fastInteger9);
                        return;
                    }
                    n2 = fastInteger9.AsInt32();
                }
                FastInteger fastInteger10 = this.knownBitLength;
                fastInteger10.smallValue = n3;
                fastInteger10.integerMode = 0;
                this.discardedBitCount.AddInt(n2);
                if (n2 == n4) {
                    int n11 = n4 ^ this.shiftedBigInt.isEven();
                    this.shiftedBigInt = this.shiftedBigInt.ShiftRight(n4);
                    this.bitsAfterLeftmost |= this.bitLeftmost;
                    this.bitLeftmost = n11;
                } else {
                    int n12;
                    this.bitsAfterLeftmost |= this.bitLeftmost;
                    EInteger eInteger = this.shiftedBigInt.GetLowBitAsEInteger();
                    if (eInteger.compareTo(n12 = n2 - 1) < 0) {
                        this.bitsAfterLeftmost = n4 | this.bitsAfterLeftmost;
                        this.bitLeftmost = this.shiftedBigInt.GetSignedBit(n12) ? 1 : 0;
                    } else {
                        this.bitLeftmost = eInteger.compareTo(n12) > 0 ? 0 : n4;
                    }
                    this.shiftedBigInt = this.shiftedBigInt.ShiftRight(n2);
                }
                if (n3 < 32) {
                    this.isSmall = n4;
                    this.shiftedSmall = this.shiftedBigInt.ToInt32Checked();
                }
                if (this.bitsAfterLeftmost == 0) {
                    n4 = 0;
                }
                this.bitsAfterLeftmost = n4;
                return;
            }
            FastInteger fastInteger11 = this.knownBitLength;
            if (fastInteger11 == null) {
                fastInteger11 = this.CalcKnownBitLength();
            }
            this.knownBitLength = fastInteger11;
            EInteger eInteger = fastInteger11.AsEInteger().Subtract(fastInteger.AsEInteger());
            if (eInteger.signum() <= 0) return;
            this.ShiftRight(FastInteger.FromBig(eInteger));
            return;
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"bits's sign (");
        stringBuilder.append(fastInteger.signum());
        stringBuilder.append(") is less than 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    public void TruncateOrShiftRight(FastInteger fastInteger, boolean bl) {
        this.ShiftRight(fastInteger);
    }

    @Override
    public final FastInteger getDiscardedDigitCount() {
        return this.discardedBitCount;
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
}

