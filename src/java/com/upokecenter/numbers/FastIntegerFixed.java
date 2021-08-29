/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.upokecenter.numbers;

import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.FastInteger;

public final class FastIntegerFixed
implements Comparable<FastIntegerFixed> {
    public static final FastIntegerFixed One;
    public static final EInteger ValueInt32MinValue;
    public static final EInteger ValueNegativeInt32MinValue;
    public final int integerMode;
    public final EInteger largeValue;
    public final int smallValue;

    public static {
        EInteger eInteger;
        One = new FastIntegerFixed(1);
        ValueInt32MinValue = eInteger = EInteger.FromInt64(Integer.MIN_VALUE);
        ValueNegativeInt32MinValue = eInteger.Negate();
    }

    public FastIntegerFixed(int n2) {
        this(0, n2, null);
    }

    public FastIntegerFixed(int n2, int n3, EInteger eInteger) {
        this.integerMode = n2;
        this.smallValue = n3;
        this.largeValue = eInteger;
    }

    public static FastIntegerFixed Add(FastIntegerFixed fastIntegerFixed, FastIntegerFixed fastIntegerFixed2) {
        if (fastIntegerFixed.integerMode == 0 && fastIntegerFixed2.integerMode == 0) {
            int n2 = fastIntegerFixed.smallValue;
            if (n2 == 0) {
                return fastIntegerFixed2;
            }
            int n3 = fastIntegerFixed2.smallValue;
            if (n3 == 0) {
                return fastIntegerFixed;
            }
            if (n2 < 0 && n3 >= Integer.MIN_VALUE - n2 || n2 > 0 && n3 <= Integer.MAX_VALUE - n2) {
                return new FastIntegerFixed(n2 + n3);
            }
        }
        return FastIntegerFixed.FromBig(fastIntegerFixed.ToEInteger().Add(fastIntegerFixed2.ToEInteger()));
    }

    public static FastIntegerFixed FromBig(EInteger eInteger) {
        if (eInteger.CanFitInInt32()) {
            return new FastIntegerFixed(eInteger.ToInt32Unchecked());
        }
        return new FastIntegerFixed(2, 0, eInteger);
    }

    public static FastIntegerFixed FromFastInteger(FastInteger fastInteger) {
        if (fastInteger.CanFitInInt32()) {
            return new FastIntegerFixed(fastInteger.AsInt32());
        }
        return FastIntegerFixed.FromBig(fastInteger.AsEInteger());
    }

    public static FastIntegerFixed FromLong(long l2) {
        if (l2 >= Integer.MIN_VALUE && l2 <= Integer.MAX_VALUE) {
            return new FastIntegerFixed((int)l2);
        }
        return new FastIntegerFixed(2, 0, EInteger.FromInt64(l2));
    }

    public int AsInt32() {
        if (this.integerMode == 0) {
            return this.smallValue;
        }
        return this.largeValue.ToInt32Unchecked();
    }

    public long AsInt64() {
        int n2 = this.integerMode;
        if (n2 != 0) {
            if (n2 == 2) {
                return this.largeValue.ToInt64Unchecked();
            }
            throw new IllegalStateException();
        }
        return this.smallValue;
    }

    public boolean CanFitInInt32() {
        return this.integerMode == 0 || this.largeValue.CanFitInInt32();
        {
        }
    }

    public boolean CanFitInInt64() {
        int n2 = this.integerMode;
        if (n2 != 0) {
            if (n2 == 2) {
                return this.largeValue.CanFitInInt64();
            }
            throw new IllegalStateException();
        }
        return true;
    }

    public FastIntegerFixed Increment() {
        int n2;
        if (this.integerMode == 0 && (n2 = this.smallValue) != Integer.MAX_VALUE) {
            return new FastIntegerFixed(n2 + 1);
        }
        return FastIntegerFixed.Add(this, One);
    }

    public FastIntegerFixed Negate() {
        int n2 = this.integerMode;
        if (n2 != 0) {
            if (n2 == 2) {
                return FastIntegerFixed.FromBig(this.largeValue.Negate());
            }
            throw new IllegalStateException();
        }
        int n3 = this.smallValue;
        if (n3 == Integer.MIN_VALUE) {
            return FastIntegerFixed.FromBig(ValueNegativeInt32MinValue);
        }
        return new FastIntegerFixed(-n3);
    }

    public EInteger ToEInteger() {
        int n2 = this.integerMode;
        if (n2 != 0) {
            if (n2 == 2) {
                return this.largeValue;
            }
            throw new IllegalStateException();
        }
        return EInteger.FromInt32(this.smallValue);
    }

    public FastInteger ToFastInteger() {
        if (this.integerMode == 0) {
            return new FastInteger(this.smallValue);
        }
        return FastInteger.FromBig(this.largeValue);
    }

    public int compareTo(FastIntegerFixed fastIntegerFixed) {
        int n2 = this.integerMode << 2 | fastIntegerFixed.integerMode;
        if (n2 != 0) {
            if (n2 != 2) {
                if (n2 != 8 && n2 != 10) {
                    throw new IllegalStateException();
                }
                return this.largeValue.compareTo(fastIntegerFixed.ToEInteger());
            }
            return this.ToEInteger().compareTo(fastIntegerFixed.largeValue);
        }
        int n3 = this.smallValue;
        int n4 = fastIntegerFixed.smallValue;
        if (n3 == n4) {
            return 0;
        }
        if (n3 < n4) {
            return -1;
        }
        return 1;
    }

    public boolean equals(Object object) {
        FastIntegerFixed fastIntegerFixed = object instanceof FastIntegerFixed ? (FastIntegerFixed)object : null;
        if (fastIntegerFixed == null) {
            return false;
        }
        int n2 = this.integerMode;
        if (n2 != fastIntegerFixed.integerMode) {
            return false;
        }
        return !(n2 == 0 ? this.smallValue != fastIntegerFixed.smallValue : n2 == 1 && !this.largeValue.equals(fastIntegerFixed.largeValue));
    }

    public int hashCode() {
        int n2 = this.integerMode;
        int n3 = n2 + 31;
        if (n2 == 0) {
            return n3 * 31 + this.smallValue;
        }
        if (n2 == 1) {
            n3 = n3 * 31 + this.largeValue.hashCode();
        }
        return n3;
    }

    public final boolean isEvenNumber() {
        int n2 = this.integerMode;
        if (n2 != 0) {
            if (n2 == 2) {
                return this.largeValue.isEven();
            }
            throw new IllegalStateException();
        }
        return (1 & this.smallValue) == 0;
    }

    public final boolean isValueZero() {
        int n2 = this.integerMode;
        if (n2 != 0) {
            if (n2 != 2) {
                return false;
            }
            return this.largeValue.isZero();
        }
        int n3 = this.smallValue;
        boolean bl = false;
        if (n3 == 0) {
            bl = true;
        }
        return bl;
    }

    public final int signum() {
        int n2 = this.integerMode;
        if (n2 != 0) {
            if (n2 != 2) {
                return 0;
            }
            return this.largeValue.signum();
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
            if (n2 != 2) {
                return "";
            }
            return this.largeValue.toString();
        }
        return FastInteger.IntToString(this.smallValue);
    }
}

