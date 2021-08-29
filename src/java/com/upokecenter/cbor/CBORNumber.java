/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.upokecenter.cbor.CBORDouble
 *  com.upokecenter.cbor.CBOREInteger
 *  com.upokecenter.cbor.CBORExtendedDecimal
 *  com.upokecenter.cbor.CBORExtendedFloat
 *  com.upokecenter.cbor.CBORExtendedRational
 *  com.upokecenter.cbor.CBORInteger
 *  com.upokecenter.numbers.EDecimal
 *  com.upokecenter.numbers.EFloat
 *  com.upokecenter.numbers.EInteger
 *  com.upokecenter.numbers.ERational
 *  com.upokecenter.numbers.FastIntegerFixed
 *  java.lang.Comparable
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package com.upokecenter.cbor;

import com.upokecenter.cbor.CBORDouble;
import com.upokecenter.cbor.CBOREInteger;
import com.upokecenter.cbor.CBORExtendedDecimal;
import com.upokecenter.cbor.CBORExtendedFloat;
import com.upokecenter.cbor.CBORExtendedRational;
import com.upokecenter.cbor.CBORInteger;
import com.upokecenter.cbor.CBORObject;
import com.upokecenter.cbor.CBORType;
import com.upokecenter.cbor.CBORUtilities;
import com.upokecenter.cbor.ICBORNumber;
import com.upokecenter.numbers.EContext;
import com.upokecenter.numbers.EDecimal;
import com.upokecenter.numbers.EFloat;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ERational;
import com.upokecenter.numbers.FastIntegerFixed;
import java.util.Objects;

public final class CBORNumber
implements Comparable<CBORNumber> {
    public static final ICBORNumber[] NumberInterfaces;
    public final Kind kind;
    public final Object value;

    public static {
        ICBORNumber[] arriCBORNumber = new ICBORNumber[]{new CBORInteger(), new CBORDouble(), new CBOREInteger(), new CBORExtendedDecimal(), new CBORExtendedFloat(), new CBORExtendedRational()};
        NumberInterfaces = arriCBORNumber;
    }

    public CBORNumber(Kind kind, Object object) {
        this.kind = kind;
        this.value = object;
    }

    public static CBORNumber BignumToNumber(CBORObject cBORObject) {
        EInteger eInteger;
        int n2;
        boolean bl;
        int n3;
        boolean bl2;
        block17 : {
            block15 : {
                EInteger eInteger2;
                block16 : {
                    boolean bl3;
                    if (cBORObject.getType() != CBORType.ByteString) {
                        return null;
                    }
                    boolean bl4 = cBORObject.isTagged();
                    n3 = -1;
                    n2 = 0;
                    if (!bl4) break block15;
                    eInteger2 = EInteger.FromInt32((int)3);
                    if (eInteger2.signum() < 0) break block16;
                    if (!cBORObject.isTagged()) {
                        bl3 = false;
                    } else {
                        EInteger eInteger3;
                        if (!cBORObject.isTagged()) {
                            eInteger3 = EInteger.FromInt32((int)n3);
                        } else {
                            int n4;
                            CBORObject cBORObject2 = (CBORObject)cBORObject.itemValue;
                            CBORObject cBORObject3 = cBORObject;
                            while (cBORObject2.isTagged()) {
                                CBORObject cBORObject4 = (CBORObject)cBORObject2.itemValue;
                                cBORObject3 = cBORObject2;
                                cBORObject2 = cBORObject4;
                            }
                            int n5 = cBORObject3.tagHigh;
                            eInteger3 = n5 == 0 && (n4 = cBORObject3.tagLow) >= 0 && n4 < 65536 ? EInteger.FromInt64((long)n4) : CBORObject.LowHighToEInteger(cBORObject3.tagLow, n5);
                        }
                        bl3 = eInteger3.equals((Object)eInteger2);
                    }
                    if (!bl3) break block15;
                    bl = true;
                    break block17;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("bigTagValue (");
                stringBuilder.append((Object)eInteger2);
                stringBuilder.append(") is less than 0");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            bl = false;
        }
        byte[] arrby = cBORObject.GetByteString();
        if (arrby.length <= 7) {
            long l2 = 0L;
            while (n2 < arrby.length) {
                l2 = l2 << 8 | 255L & (long)arrby[n2];
                ++n2;
            }
            if (bl) {
                l2 = -l2 - 1L;
            }
            return new CBORNumber(Kind.Integer, l2);
        }
        int n6 = arrby.length;
        if ((1 & arrby[0] >> 7) != 0) {
            ++n6;
            bl2 = true;
        } else {
            bl2 = false;
        }
        byte[] arrby2 = new byte[n6];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            arrby2[i2] = arrby[arrby.length - 1 - i2];
            if (!bl) continue;
            arrby2[i2] = (byte)(255 & arrby2[i2]);
        }
        if (bl2) {
            int n7 = n6 - 1;
            if (!bl) {
                n3 = 0;
            }
            arrby2[n7] = n3;
        }
        if ((eInteger = EInteger.FromBytes((byte[])arrby2, (boolean)true)).CanFitInInt64()) {
            return new CBORNumber(Kind.Integer, eInteger.ToInt64Checked());
        }
        return new CBORNumber(Kind.EInteger, (Object)eInteger);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static CBORNumber FromCBORObject(CBORObject var0) {
        block58 : {
            if (CBORNumber.IsUntaggedInteger(var0)) {
                if (var0.CanValueFitInInt64() == false) return new CBORNumber(Kind.EInteger, (Object)var0.AsEIntegerValue());
                return new CBORNumber(Kind.Integer, var0.AsInt64Value());
            }
            if (!var0.isTagged() && var0.getType() == CBORType.FloatingPoint) {
                var31_1 = var0.AsDoubleValue();
                return new CBORNumber(Kind.Double, var31_1);
            }
            if (var0.HasOneTag(2) != false) return CBORNumber.BignumToNumber(var0);
            if (var0.HasOneTag(3)) {
                return CBORNumber.BignumToNumber(var0);
            }
            var1_2 = 4;
            var2_3 = var0.HasOneTag(var1_2);
            var3_4 = 1;
            if (var2_3 || var0.HasOneTag(5) || var0.HasOneTag(264) || var0.HasOneTag(265) || var0.HasOneTag(268) || var0.HasOneTag(269)) break block58;
            if (!var0.HasOneTag(30)) {
                if (var0.HasOneTag(270) == false) return null;
            }
            var16_5 = var0.getMostOuterTag().ToInt32Checked();
            if (var0.getType() != CBORType.Array) {
                return null;
            }
            if (var16_5 == 270) {
                if (var0.size() != 3) {
                    return null;
                }
                if (!CBORNumber.IsUntaggedInteger(var0.get(2))) {
                    return null;
                }
            } else if (var0.size() != 2) {
                return null;
            }
            if (!CBORNumber.IsUntaggedIntegerOrBignum(var0.get(0))) {
                return null;
            }
            if (!CBORNumber.IsUntaggedIntegerOrBignum(var0.get(var3_4))) {
                return null;
            }
            var17_6 = CBORNumber.IntegerOrBignum(var0.get(0));
            var18_7 = CBORNumber.IntegerOrBignum(var0.get(var3_4));
            if (var18_7.signum() <= 0) {
                return null;
            }
            var19_8 = new ERational(var17_6, var18_7);
            if (var16_5 != 270) return new CBORNumber(Kind.ERational, (Object)var19_8);
            if (var17_6.signum() < 0) {
                return null;
            }
            if (!var0.get(2).CanValueFitInInt32()) {
                return null;
            }
            var21_9 = var0.get(2).AsInt32Value();
            switch (var21_9) {
                default: {
                    return null;
                }
                case 4: 
                case 5: 
                case 6: 
                case 7: {
                    if (var18_7.compareTo(var3_4) != 0) {
                        return null;
                    }
                    var25_10 = var21_9 >= 6 ? var3_4 : 0;
                    if (var21_9 == 5) ** GOTO lbl52
                    var26_11 = 0;
                    if (var21_9 != 7) ** GOTO lbl53
lbl52: // 2 sources:
                    var26_11 = var3_4;
lbl53: // 2 sources:
                    if (var17_6.signum() < 0) {
                        var27_14 = new StringBuilder();
                        var27_14.append("Diagnostic information must be 0 or greater, was: ");
                        var27_14.append((Object)var17_6);
                        throw new IllegalArgumentException(var27_14.toString());
                    }
                    if (!var17_6.isZero() || var26_11 != 0) ** GOTO lbl61
                    var22_12 = var25_10 != 0 ? ERational.SignalingNaN : ERational.NaN;
                    ** GOTO lbl84
lbl61: // 1 sources:
                    if (var25_10 != 0) {
                        var1_2 = 8;
                    }
                    var30_13 = var1_2 | var26_11;
                    var19_8 = new ERational(var17_6, EInteger.FromInt32((int)var3_4), var30_13);
                    return new CBORNumber(Kind.ERational, (Object)var19_8);
                }
                case 3: {
                    var24_15 = var17_6.isZero();
                    var20_16 = null;
                    if (var24_15 == false) return var20_16;
                    if (var18_7.compareTo(var3_4) != 0) {
                        return null;
                    }
                    var19_8 = ERational.NegativeInfinity;
                    return new CBORNumber(Kind.ERational, (Object)var19_8);
                }
                case 2: {
                    var23_17 = var17_6.isZero();
                    var20_16 = null;
                    if (var23_17 == false) return var20_16;
                    if (var18_7.compareTo(var3_4) != 0) {
                        return null;
                    }
                    var19_8 = ERational.PositiveInfinity;
                    return new CBORNumber(Kind.ERational, (Object)var19_8);
                }
                case 1: {
                    var22_12 = new ERational(var19_8.unsignedNumerator, var19_8.denominator, var3_4 ^ var19_8.flags);
lbl84: // 2 sources:
                    var19_8 = var22_12;
                }
                case 0: 
            }
            return new CBORNumber(Kind.ERational, (Object)var19_8);
        }
        var4_18 = var0.getMostOuterTag().ToInt32Checked();
        if (var0.getType() != CBORType.Array) {
            return null;
        }
        if (var4_18 != 268 && var4_18 != 269) {
            if (var0.size() != 2) {
                return null;
            }
        } else {
            if (var0.size() != 3) {
                return null;
            }
            if (!CBORNumber.IsUntaggedInteger(var0.get(2))) {
                return null;
            }
        }
        if (var4_18 != var1_2 && var4_18 != 5 ? CBORNumber.IsUntaggedIntegerOrBignum(var0.get(0)) == false : CBORNumber.IsUntaggedInteger(var0.get(0)) == false) {
            return null;
        }
        if (!CBORNumber.IsUntaggedIntegerOrBignum(var0.get(var3_4))) {
            return null;
        }
        var5_19 = CBORNumber.IntegerOrBignum(var0.get(0));
        var6_20 = CBORNumber.IntegerOrBignum(var0.get(var3_4));
        var7_21 = var4_18 != var1_2 && var4_18 != 264 && var4_18 != 268 ? 0 : var3_4;
        var8_22 = var7_21 != 0 ? EDecimal.Create((EInteger)var6_20, (EInteger)var5_19) : null;
        var9_23 = var7_21 == 0 ? EFloat.Create((EInteger)var6_20, (EInteger)var5_19) : null;
        if (var4_18 == 268 || var4_18 == 269) {
            if (var6_20.signum() < 0) {
                return null;
            }
            if (!var0.get(2).CanValueFitInInt32()) {
                return null;
            }
            var10_24 = var0.get(2).AsInt32Value();
            switch (var10_24) {
                default: {
                    return null;
                }
                case 4: 
                case 5: 
                case 6: 
                case 7: {
                    if (!var5_19.isZero()) {
                        return null;
                    }
                    if (var7_21 != 0) {
                        var15_25 = var10_24 >= 6 ? var3_4 : 0;
                        if (var10_24 != 5 && var10_24 != 7) {
                            var3_4 = 0;
                        }
                        var8_22 = EDecimal.CreateNaN((EInteger)var6_20, (boolean)var15_25, (boolean)var3_4, null);
                        break;
                    }
                    var14_26 = var10_24 >= 6 ? var3_4 : 0;
                    if (var10_24 != 5 && var10_24 != 7) {
                        var3_4 = 0;
                    }
                    var9_23 = EFloat.CreateNaN((EInteger)var6_20, (boolean)var14_26, (boolean)var3_4, null);
                    break;
                }
                case 3: {
                    var13_27 = var5_19.isZero();
                    var11_28 = null;
                    if (var13_27 == false) return var11_28;
                    if (!var6_20.isZero()) {
                        return null;
                    }
                    if (var7_21 != 0) {
                        var8_22 = EDecimal.NegativeInfinity;
                        break;
                    }
                    var9_23 = EFloat.NegativeInfinity;
                    break;
                }
                case 2: {
                    var12_29 = var5_19.isZero();
                    var11_28 = null;
                    if (var12_29 == false) return var11_28;
                    if (!var6_20.isZero()) {
                        return null;
                    }
                    if (var7_21 != 0) {
                        var8_22 = EDecimal.PositiveInfinity;
                        break;
                    }
                    var9_23 = EFloat.PositiveInfinity;
                    break;
                }
                case 1: {
                    if (var7_21 != 0) {
                        var8_22 = new EDecimal(var8_22.unsignedMantissa, var8_22.exponent, var3_4 ^ var8_22.flags);
                        break;
                    }
                    var9_23 = new EFloat(var9_23.unsignedMantissa, var9_23.exponent, var3_4 ^ var9_23.flags);
                }
                case 0: 
            }
        }
        if (var7_21 == 0) return new CBORNumber(Kind.EFloat, (Object)var9_23);
        return new CBORNumber(Kind.EDecimal, (Object)var8_22);
    }

    public static ICBORNumber GetNumberInterface(Kind kind) {
        int n2 = kind.ordinal();
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            if (n2 == 5) {
                                return NumberInterfaces[5];
                            }
                            throw new IllegalStateException();
                        }
                        return NumberInterfaces[4];
                    }
                    return NumberInterfaces[3];
                }
                return NumberInterfaces[2];
            }
            return NumberInterfaces[1];
        }
        return NumberInterfaces[0];
    }

    public static EInteger IntegerOrBignum(CBORObject cBORObject) {
        if (CBORNumber.IsUntaggedInteger(cBORObject)) {
            return cBORObject.AsEIntegerValue();
        }
        CBORNumber cBORNumber = CBORNumber.BignumToNumber(cBORObject);
        return cBORNumber.GetNumberInterface().AsEInteger(cBORNumber.value);
    }

    public static boolean IsUntaggedInteger(CBORObject cBORObject) {
        return !cBORObject.isTagged() && cBORObject.getType() == CBORType.Integer;
    }

    public static boolean IsUntaggedIntegerOrBignum(CBORObject cBORObject) {
        return CBORNumber.IsUntaggedInteger(cBORObject) || (cBORObject.HasOneTag(2) || cBORObject.HasOneTag(3)) && cBORObject.getType() == CBORType.ByteString;
        {
        }
    }

    public ICBORNumber GetNumberInterface() {
        return CBORNumber.GetNumberInterface(this.kind);
    }

    public String ToJSONString() {
        int n2 = this.kind.ordinal();
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            if (n2 == 5) {
                                EDecimal eDecimal = ((ERational)this.value).ToEDecimalExactIfPossible(EContext.Decimal128.WithUnlimitedExponents());
                                if (!eDecimal.isFinite()) {
                                    return "null";
                                }
                                return eDecimal.toString();
                            }
                            throw new IllegalStateException();
                        }
                        EFloat eFloat = (EFloat)this.value;
                        if (!eFloat.IsInfinity()) {
                            if (eFloat.IsNaN()) {
                                return "null";
                            }
                            if (eFloat.isFinite() && eFloat.exponent.Abs().compareTo(EInteger.FromInt64((long)2500L)) > 0) {
                                double d2 = eFloat.ToDouble();
                                if (d2 != Double.NEGATIVE_INFINITY && d2 != Double.POSITIVE_INFINITY) {
                                    if (Double.isNaN((double)d2)) {
                                        return "null";
                                    }
                                    return CBORUtilities.TrimDotZero(CBORUtilities.DoubleToString(d2));
                                }
                                return "null";
                            }
                            return eFloat.toString();
                        }
                        return "null";
                    }
                    EDecimal eDecimal = (EDecimal)this.value;
                    if (!eDecimal.IsInfinity()) {
                        if (eDecimal.IsNaN()) {
                            return "null";
                        }
                        return eDecimal.toString();
                    }
                    return "null";
                }
                return ((EInteger)this.value).toString();
            }
            double d3 = (Double)this.value;
            if (d3 != Double.NEGATIVE_INFINITY && d3 != Double.POSITIVE_INFINITY) {
                if (Double.isNaN((double)d3)) {
                    return "null";
                }
                return CBORUtilities.TrimDotZero(CBORUtilities.DoubleToString(d3));
            }
            return "null";
        }
        return CBORUtilities.LongToString((Long)this.value);
    }

    /*
     * Enabled aggressive block sorting
     */
    public int compareTo(Object object) {
        int n2;
        int n3;
        CBORNumber cBORNumber = (CBORNumber)object;
        if (cBORNumber == null) {
            return 1;
        }
        if (this == cBORNumber) {
            return 0;
        }
        Kind kind = this.kind;
        Kind kind2 = cBORNumber.kind;
        Object object2 = this.value;
        Object object3 = cBORNumber.value;
        if (kind == kind2) {
            int n4 = kind.ordinal();
            if (n4 != 0) {
                if (n4 != 1) {
                    if (n4 == 2) {
                        return ((EInteger)object2).compareTo((EInteger)object3);
                    }
                    if (n4 == 3) {
                        return ((EDecimal)object2).compareTo((EDecimal)object3);
                    }
                    if (n4 == 4) return ((EFloat)object2).compareTo((EFloat)object3);
                    if (n4 != 5) throw new IllegalStateException("Unexpected data type");
                    return ((ERational)object2).compareTo((ERational)object3);
                }
                double d2 = (Double)object2;
                double d3 = (Double)object3;
                if (Double.isNaN((double)d2)) {
                    if (!Double.isNaN((double)d3)) return 1;
                    return 0;
                }
                if (Double.isNaN((double)d3)) {
                    return -1;
                }
                if (d2 == d3) {
                    return 0;
                }
                if (!(d2 < d3)) return 1;
                return -1;
            }
            long l2 = (Long)object2 LCMP (Long)object3;
            if (l2 == false) {
                return 0;
            }
            if (l2 >= 0) return 1;
            return -1;
        }
        int n5 = CBORNumber.GetNumberInterface(kind).Sign(object2);
        if (n5 != (n3 = CBORNumber.GetNumberInterface(kind2).Sign(object3)) && n5 != 2 && n3 != 2) {
            if (n5 >= n3) return 1;
            return -1;
        }
        if (n5 == 2 && n3 == 2) {
            return 0;
        }
        if (n5 == 2) {
            return 1;
        }
        if (n3 == 2) {
            return -1;
        }
        Kind kind3 = Kind.ERational;
        if (kind == kind3) {
            ERational eRational = CBORNumber.GetNumberInterface(kind).AsExtendedRational(object2);
            if (kind2 != Kind.EDecimal) return eRational.CompareToBinary(CBORNumber.GetNumberInterface(kind2).AsExtendedFloat(object3));
            return eRational.CompareToDecimal(CBORNumber.GetNumberInterface(kind2).AsExtendedDecimal(object3));
        }
        if (kind2 == kind3) {
            ERational eRational = CBORNumber.GetNumberInterface(kind2).AsExtendedRational(object3);
            n2 = kind == Kind.EDecimal ? eRational.CompareToDecimal(CBORNumber.GetNumberInterface(kind).AsExtendedDecimal(object2)) : eRational.CompareToBinary(CBORNumber.GetNumberInterface(kind).AsExtendedFloat(object2));
            return -n2;
        }
        Kind kind4 = Kind.EDecimal;
        if (kind != kind4 && kind2 != kind4) {
            Kind kind5 = Kind.EFloat;
            if (kind == kind5) return CBORNumber.GetNumberInterface(kind).AsExtendedFloat(object2).compareTo(CBORNumber.GetNumberInterface(kind2).AsExtendedFloat(object3));
            if (kind2 == kind5) return CBORNumber.GetNumberInterface(kind).AsExtendedFloat(object2).compareTo(CBORNumber.GetNumberInterface(kind2).AsExtendedFloat(object3));
            Kind kind6 = Kind.Double;
            if (kind == kind6) return CBORNumber.GetNumberInterface(kind).AsExtendedFloat(object2).compareTo(CBORNumber.GetNumberInterface(kind2).AsExtendedFloat(object3));
            if (kind2 == kind6) return CBORNumber.GetNumberInterface(kind).AsExtendedFloat(object2).compareTo(CBORNumber.GetNumberInterface(kind2).AsExtendedFloat(object3));
            return CBORNumber.GetNumberInterface(kind).AsEInteger(object2).compareTo(CBORNumber.GetNumberInterface(kind2).AsEInteger(object3));
        }
        Kind kind7 = Kind.EFloat;
        if (kind == kind7) {
            EFloat eFloat = (EFloat)object2;
            EDecimal eDecimal = (EDecimal)object3;
            Objects.requireNonNull((Object)eDecimal);
            n2 = EDecimal.CompareEDecimalToEFloat((EDecimal)eDecimal, (EFloat)eFloat);
            return -n2;
        }
        if (kind2 != kind7) return CBORNumber.GetNumberInterface(kind).AsExtendedDecimal(object2).compareTo(CBORNumber.GetNumberInterface(kind2).AsExtendedDecimal(object3));
        EFloat eFloat = (EFloat)object3;
        EDecimal eDecimal = (EDecimal)object2;
        Objects.requireNonNull((Object)eDecimal);
        return EDecimal.CompareEDecimalToEFloat((EDecimal)eDecimal, (EFloat)eFloat);
    }

    public String toString() {
        if (this.kind.ordinal() != 0) {
            Object object = this.value;
            if (object == null) {
                return "";
            }
            return object.toString();
        }
        return CBORUtilities.LongToString((Long)this.value);
    }

    public static final class Kind
    extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES;
        public static final /* enum */ Kind Double;
        public static final /* enum */ Kind EDecimal;
        public static final /* enum */ Kind EFloat;
        public static final /* enum */ Kind EInteger;
        public static final /* enum */ Kind ERational;
        public static final /* enum */ Kind Integer;

        public static {
            Kind kind;
            Kind kind2;
            Kind kind3;
            Kind kind4;
            Kind kind5;
            Kind kind6;
            Integer = kind6 = new Kind();
            Double = kind4 = new Kind();
            EInteger = kind2 = new Kind();
            EDecimal = kind5 = new Kind();
            EFloat = kind3 = new Kind();
            ERational = kind = new Kind();
            $VALUES = new Kind[]{kind6, kind4, kind2, kind5, kind3, kind};
        }

        public static Kind valueOf(String string) {
            return (Kind)Enum.valueOf(Kind.class, (String)string);
        }

        public static Kind[] values() {
            return (Kind[])$VALUES.clone();
        }
    }

}

