/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.lang.ArithmeticException
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.upokecenter.cbor;

import com.google.android.material.R;
import com.upokecenter.cbor.ICBORNumber;
import com.upokecenter.numbers.EDecimal;
import com.upokecenter.numbers.EFloat;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ERational;
import com.upokecenter.numbers.FastIntegerFixed;
import com.upokecenter.numbers.NumberUtility;

public class CBORDouble
implements ICBORNumber {
    @Override
    public EInteger AsEInteger(Object object) {
        long l2 = Double.doubleToRawLongBits((double)((Double)object));
        int n2 = (int)(l2 & 0xFFFFFFFFL);
        int n3 = (int)(0xFFFFFFFFL & l2 >> 32);
        int n4 = 2047 & n3 >> 20;
        boolean bl = n3 >> 31 != 0;
        if (n4 != 2047) {
            int n5 = n3 & 1048575;
            if (n4 == 0) {
                ++n4;
            } else {
                n5 |= 1048576;
            }
            if ((n5 | n2) != 0) {
                while ((n2 & 1) == 0) {
                    n2 = Integer.MAX_VALUE & n2 >> 1 | n5 << 31;
                    n5 >>= 1;
                    ++n4;
                }
            }
            int n6 = n4 - 1075;
            byte[] arrby = new byte[]{(byte)(n2 & 255), (byte)(255 & n2 >> 8), (byte)(255 & n2 >> 16), (byte)(255 & n2 >> 24), (byte)(n5 & 255), (byte)(255 & n5 >> 8), (byte)(255 & n5 >> 16), (byte)(255 & n5 >> 24), 0};
            EInteger eInteger = EInteger.FromBytes(arrby, true);
            if (n6 == 0) {
                if (bl) {
                    return eInteger.Negate();
                }
            } else if (n6 > 0) {
                eInteger = eInteger.ShiftLeft(n6);
                if (bl) {
                    return eInteger.Negate();
                }
            } else {
                eInteger = eInteger.ShiftRight(-n6);
                if (bl) {
                    eInteger = eInteger.Negate();
                }
            }
            return eInteger;
        }
        throw new ArithmeticException("Value is infinity or NaN");
    }

    @Override
    public EDecimal AsExtendedDecimal(Object object) {
        double d2 = (Double)object;
        int[] arrn = R.style.DoubleToIntegers((double)d2);
        int n2 = 2047 & arrn[1] >> 20;
        int n3 = arrn[1] >> 31 != 0 ? 1 : 0;
        if (n2 == 2047) {
            if ((1048575 & arrn[1]) == 0 && arrn[0] == 0) {
                if (n3 != 0) {
                    return EDecimal.NegativeInfinity;
                }
                return EDecimal.PositiveInfinity;
            }
            boolean bl = (524288 & arrn[1]) != 0;
            arrn[1] = 524287 & arrn[1];
            long l2 = 0xFFFFFFFFL & (long)arrn[0] | (long)arrn[1] << 32;
            int n4 = bl ? 4 : 8;
            int n5 = n4 | n3;
            if (l2 == 0L) {
                if (bl) {
                    return EDecimal.NaN;
                }
                return EDecimal.SignalingNaN;
            }
            return new EDecimal(FastIntegerFixed.FromLong(l2), EDecimal.FastIntZero, n5);
        }
        arrn[1] = 1048575 & arrn[1];
        if (n2 == 0) {
            ++n2;
        } else {
            arrn[1] = 1048576 | arrn[1];
        }
        if ((arrn[1] | arrn[0]) != 0) {
            int n6 = -1075 + (n2 + NumberUtility.ShiftAwayTrailingZerosTwoElements(arrn));
            long l3 = 0xFFFFFFFFL & (long)arrn[0] | (long)arrn[1] << 32;
            if (n6 == 0) {
                if (n3 != 0) {
                    l3 = -l3;
                }
                return EDecimal.FromInt64(l3);
            }
            if (n6 > 0) {
                EInteger eInteger = EInteger.FromInt64(l3).ShiftLeft(n6);
                if (n3 != 0) {
                    eInteger = eInteger.Negate();
                }
                return EDecimal.FromEInteger(eInteger);
            }
            EInteger eInteger = EInteger.FromInt64(l3).Multiply(NumberUtility.FindPowerOfFive(-n6));
            if (n3 != 0) {
                eInteger = eInteger.Negate();
            }
            return EDecimal.Create(eInteger, EInteger.FromInt32(n6));
        }
        if (n3 != 0) {
            return EDecimal.NegativeZero;
        }
        return EDecimal.Zero;
    }

    @Override
    public EFloat AsExtendedFloat(Object object) {
        return EFloat.FromDouble((Double)object);
    }

    @Override
    public ERational AsExtendedRational(Object object) {
        double d2 = (Double)object;
        return ERational.FromEFloat(EFloat.FromDouble(d2));
    }

    @Override
    public int AsInt32(Object object, int n2, int n3) {
        double d2 = (Double)object;
        if (!Double.isNaN((double)d2)) {
            double d3 = d2 < 0.0 ? Math.ceil((double)d2) : Math.floor((double)d2);
            if (d3 >= (double)n2 && d3 <= (double)n3) {
                return (int)d3;
            }
            throw new ArithmeticException("This Object's value is out of range");
        }
        throw new ArithmeticException("This Object's value is out of range");
    }

    @Override
    public long AsInt64(Object object) {
        double d2 = (Double)object;
        if (!Double.isNaN((double)d2)) {
            double d3 = d2 < 0.0 ? Math.ceil((double)d2) : Math.floor((double)d2);
            if (d3 >= -9.223372036854776E18 && d3 < 9.223372036854776E18) {
                return (long)d3;
            }
            throw new ArithmeticException("This Object's value is out of range");
        }
        throw new ArithmeticException("This Object's value is out of range");
    }

    @Override
    public boolean CanTruncatedIntFitInInt32(Object object) {
        double d2 = (Double)object;
        boolean bl = Double.isNaN((double)d2);
        boolean bl2 = false;
        if (!bl) {
            if (Double.valueOf((double)d2).isInfinite()) {
                return false;
            }
            double d3 = d2 < 0.0 ? Math.ceil((double)d2) : Math.floor((double)d2);
            double d4 = d3 DCMPL -2.147483648E9;
            bl2 = false;
            if (d4 >= 0) {
                double d5 = d3 DCMPG 2.147483647E9;
                bl2 = false;
                if (d5 <= 0) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    @Override
    public boolean IsIntegral(Object object) {
        double d2 = (Double)object;
        boolean bl = Double.isNaN((double)d2);
        boolean bl2 = false;
        if (!bl) {
            if (Double.valueOf((double)d2).isInfinite()) {
                return false;
            }
            double d3 = d2 < 0.0 ? Math.ceil((double)d2) : Math.floor((double)d2);
            double d4 = d2 DCMPL d3;
            bl2 = false;
            if (d4 == false) {
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    public int Sign(Object object) {
        double d2 = (Double)object;
        if (Double.isNaN((double)d2)) {
            return 2;
        }
        if (d2 == 0.0) {
            return 0;
        }
        if (d2 < 0.0) {
            return -1;
        }
        return 1;
    }
}

