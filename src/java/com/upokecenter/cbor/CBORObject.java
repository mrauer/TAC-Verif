/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.upokecenter.numbers.EDecimal
 *  com.upokecenter.numbers.EFloat
 *  com.upokecenter.numbers.EInteger
 *  com.upokecenter.numbers.ERational
 *  com.upokecenter.numbers.ERounding
 *  com.upokecenter.numbers.FastIntegerFixed
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.ArithmeticException
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.Array
 *  java.net.URI
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 *  java.util.UUID
 */
package com.upokecenter.cbor;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.R;
import com.upokecenter.cbor.CBOREncodeOptions;
import com.upokecenter.cbor.CBORException;
import com.upokecenter.cbor.CBORJson;
import com.upokecenter.cbor.CBORNumber;
import com.upokecenter.cbor.CBORType;
import com.upokecenter.cbor.CBORUtilities;
import com.upokecenter.cbor.ICBORNumber;
import com.upokecenter.cbor.JSONOptions;
import com.upokecenter.cbor.OptionsParser;
import com.upokecenter.cbor.PODOptions;
import com.upokecenter.cbor.PropertyMap;
import com.upokecenter.cbor.StringOutput;
import com.upokecenter.cbor.URIUtility$ParseMode;
import com.upokecenter.numbers.EContext;
import com.upokecenter.numbers.EDecimal;
import com.upokecenter.numbers.EFloat;
import com.upokecenter.numbers.EInteger;
import com.upokecenter.numbers.ERational;
import com.upokecenter.numbers.ERounding;
import com.upokecenter.numbers.FastIntegerFixed;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public final class CBORObject
implements Comparable<CBORObject> {
    public static final CBORObject False = CBORObject.ConstructSimpleValue(20);
    public static final CBORObject[] FixedObjects;
    public static final CBORObject Null;
    public static final CBORObject True;
    public static final EInteger UInt64MaxValue;
    public static final int[] ValueExpectedLengths;
    public final Object itemValue;
    public final int itemtypeValue;
    public final int tagHigh;
    public final int tagLow;

    public static {
        CBORObject.FromObject(Double.NaN);
        CBORObject.FromObject(Double.NEGATIVE_INFINITY);
        Null = CBORObject.ConstructSimpleValue(22);
        CBORObject.FromObject(Double.POSITIVE_INFINITY);
        True = CBORObject.ConstructSimpleValue(21);
        UInt64MaxValue = EInteger.FromInt32((int)1).ShiftLeft(64).Subtract(EInteger.FromInt64((long)1L));
        ValueExpectedLengths = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 5, 9, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 5, 9, -1, -1, -1, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 0, 0, 0, 0, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 0, 0, 0, 0, -1, -1, -1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 5, 9, -1, -1, -1, -1};
        CBORObject[] arrcBORObject = new CBORObject[256];
        for (int i2 = 0; i2 < 24; ++i2) {
            arrcBORObject[i2] = new CBORObject(0, i2);
        }
        for (int i3 = 32; i3 < 56; ++i3) {
            arrcBORObject[i3] = new CBORObject(0, -1 - (i3 - 32));
        }
        arrcBORObject[96] = new CBORObject(3, "");
        for (int i4 = 224; i4 < 248; ++i4) {
            arrcBORObject[i4] = new CBORObject(7, i4 - 224);
        }
        FixedObjects = arrcBORObject;
        Objects.requireNonNull((Object)"allowempty=1", (String)"paramString");
        OptionsParser optionsParser = new OptionsParser("allowempty=1");
        optionsParser.GetBoolean("resolvereferences", false);
        optionsParser.GetBoolean("useindeflengthstrings", false);
        optionsParser.GetBoolean("allowduplicatekeys", false);
        optionsParser.GetBoolean("allowempty", false);
        optionsParser.GetBoolean("ctap2canonical", false);
    }

    public CBORObject(int n2, Object object) {
        this.itemtypeValue = n2;
        this.itemValue = object;
        this.tagLow = 0;
        this.tagHigh = 0;
    }

    public CBORObject(CBORObject cBORObject, int n2, int n3) {
        this.itemtypeValue = 6;
        this.itemValue = cBORObject;
        this.tagLow = n2;
        this.tagHigh = n3;
    }

    public static boolean CBORArrayEquals(List<CBORObject> list, List<CBORObject> list2) {
        if (list == null) {
            return list2 == null;
        }
        if (list2 == null) {
            return false;
        }
        int n2 = list.size();
        if (n2 != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            CBORObject cBORObject = (CBORObject)list.get(i2);
            CBORObject cBORObject2 = (CBORObject)list2.get(i2);
            if (cBORObject != null ? cBORObject.equals(cBORObject2) : cBORObject2 == null) continue;
            return false;
        }
        return true;
    }

    public static int CBORArrayHashCode(List<CBORObject> list) {
        if (list == null) {
            return 0;
        }
        int n2 = list.size();
        int n3 = 589 + n2;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 = n3 * 31 + ((CBORObject)list.get(i2)).hashCode();
        }
        return n3;
    }

    public static void CheckCBORLength(int n2, int n3) {
        if (n3 >= n2) {
            if (n3 <= n2) {
                return;
            }
            throw new CBORException("Too many bytes");
        }
        throw new CBORException("Premature end of data");
    }

    public static CBORObject ConstructSimpleValue(int n2) {
        return new CBORObject(7, n2);
    }

    /*
     * Exception decompiling
     */
    public static CBORObject DecodeFromBytes(byte[] var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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

    public static CBORObject FromObject(double d2) {
        return new CBORObject(8, Double.doubleToRawLongBits((double)d2));
    }

    public static CBORObject FromObject(int n2) {
        if (n2 >= 0 && n2 < 24) {
            return FixedObjects[n2];
        }
        return CBORObject.FromObject((long)n2);
    }

    public static CBORObject FromObject(long l2) {
        if (l2 >= 0L && l2 < 24L) {
            return FixedObjects[(int)l2];
        }
        return new CBORObject(0, l2);
    }

    public static CBORObject FromObject(EInteger eInteger) {
        byte[] arrby;
        if (eInteger.CanFitInInt64()) {
            return CBORObject.FromObject(eInteger.ToInt64Checked());
        }
        if (eInteger.GetSignedBitLengthAsEInteger().compareTo(64) <= 0) {
            return new CBORObject(1, (Object)eInteger);
        }
        int n2 = eInteger.signum() < 0 ? 3 : 2;
        if (eInteger.isZero()) {
            arrby = new byte[]{0};
        } else {
            int n3;
            if (eInteger.signum() < 0) {
                eInteger = eInteger.Add(1).Negate();
            }
            arrby = eInteger.ToBytes(false);
            for (n3 = 0; n3 < arrby.length && arrby[n3] == 0; ++n3) {
            }
            if (n3 > 0) {
                int n4 = arrby.length - n3;
                byte[] arrby2 = new byte[n4];
                System.arraycopy((Object)arrby, (int)n3, (Object)arrby2, (int)0, (int)n4);
                arrby = arrby2;
            }
        }
        return CBORObject.FromObjectAndTag((Object)arrby, n2);
    }

    public static CBORObject FromObject(Object object) {
        return CBORObject.FromObject(object, PODOptions.Default, 0);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static CBORObject FromObject(Object var0, PODOptions var1_1, int var2_2) {
        block81 : {
            block80 : {
                block78 : {
                    block79 : {
                        block69 : {
                            block75 : {
                                block77 : {
                                    block76 : {
                                        block74 : {
                                            block70 : {
                                                block73 : {
                                                    block72 : {
                                                        block71 : {
                                                            Objects.requireNonNull((Object)var1_1, (String)"options");
                                                            if (var2_2 >= 100) throw new CBORException("Nesting depth too high");
                                                            if (var0 == null) {
                                                                return CBORObject.Null;
                                                            }
                                                            if (var0 instanceof CBORObject) {
                                                                return (CBORObject)var0;
                                                            }
                                                            if (var0 instanceof String) {
                                                                return CBORObject.FromObject((String)var0);
                                                            }
                                                            if (var0 instanceof Integer) {
                                                                return CBORObject.FromObject((Integer)var0);
                                                            }
                                                            if (var0 instanceof Long) {
                                                                return CBORObject.FromObject((Long)var0);
                                                            }
                                                            var4_3 = var0 instanceof EInteger != false ? (EInteger)var0 : null;
                                                            if (var4_3 != null) {
                                                                return CBORObject.FromObject(var4_3);
                                                            }
                                                            var5_4 = var0 instanceof EDecimal != false ? (EDecimal)var0 : null;
                                                            var6_5 = 4;
                                                            var7_6 = 0;
                                                            if (var5_4 != null) {
                                                                if (!(var5_4.IsInfinity() || var5_4.IsNaN() || var5_4.isNegative() && var5_4.isZero())) {
                                                                    if (var5_4.getExponent().GetSignedBitLengthAsEInteger().compareTo(64) > 0) {
                                                                        var6_5 = 264;
                                                                    }
                                                                    var159_7 = CBORObject.NewArray();
                                                                    var159_7.Add((Object)var5_4.getExponent());
                                                                    var159_7.Add((Object)var5_4.getMantissa());
                                                                    return CBORObject.FromObjectAndTag((Object)var159_7, var6_5);
                                                                }
                                                                var152_8 = var5_4.isNegative();
                                                                if (var5_4.IsInfinity()) {
                                                                    var152_8 += 2;
                                                                }
                                                                var153_9 = var6_5 & var5_4.flags;
                                                                var154_10 = false;
                                                                if (var153_9 != 0) {
                                                                    var154_10 = true;
                                                                }
                                                                if (var154_10) {
                                                                    var152_8 += 4;
                                                                }
                                                                if (var5_4.IsSignalingNaN()) {
                                                                    var152_8 += 6;
                                                                }
                                                                var155_11 = CBORObject.NewArray();
                                                                var155_11.Add((Object)var5_4.getExponent());
                                                                var155_11.Add((Object)var5_4.getUnsignedMantissa());
                                                                var155_11.Add(var152_8);
                                                                var6_5 = 268;
                                                                var159_7 = var155_11;
                                                                return CBORObject.FromObjectAndTag((Object)var159_7, var6_5);
                                                            }
                                                            var8_12 = var0 instanceof EFloat != false ? (EFloat)var0 : null;
                                                            var9_13 = 5;
                                                            if (var8_12 != null) {
                                                                if (!(var8_12.IsInfinity() || var8_12.IsNaN() || var8_12.isNegative() && var8_12.isZero())) {
                                                                    if (var8_12.exponent.GetSignedBitLengthAsEInteger().compareTo(64) > 0) {
                                                                        var9_13 = 265;
                                                                    }
                                                                    var149_14 = CBORObject.NewArray();
                                                                    var149_14.Add((Object)var8_12.exponent);
                                                                    var149_14.Add((Object)var8_12.getMantissa());
                                                                    return CBORObject.FromObjectAndTag((Object)var149_14, var9_13);
                                                                }
                                                                var144_15 = var8_12.isNegative();
                                                                if (var8_12.IsInfinity()) {
                                                                    var144_15 += 2;
                                                                }
                                                                if (var8_12.IsQuietNaN()) {
                                                                    var144_15 += 4;
                                                                }
                                                                if (var8_12.IsSignalingNaN()) {
                                                                    var144_15 += 6;
                                                                }
                                                                var145_16 = CBORObject.NewArray();
                                                                var145_16.Add((Object)var8_12.exponent);
                                                                var145_16.Add((Object)var8_12.unsignedMantissa);
                                                                var145_16.Add(var144_15);
                                                                var9_13 = 269;
                                                                var149_14 = var145_16;
                                                                return CBORObject.FromObjectAndTag((Object)var149_14, var9_13);
                                                            }
                                                            var10_17 = var0 instanceof ERational != false ? (ERational)var0 : null;
                                                            if (var10_17 != null) {
                                                                if (!(var10_17.IsInfinity() || var10_17.IsNaN() || var10_17.isNegative() && var10_17.isZero())) {
                                                                    var141_18 = 30;
                                                                    var137_19 = CBORObject.NewArray();
                                                                    var137_19.Add((Object)var10_17.getNumerator());
                                                                    var137_19.Add((Object)var10_17.denominator);
                                                                    return CBORObject.FromObjectAndTag((Object)var137_19, var141_18);
                                                                }
                                                                var134_20 = var10_17.isNegative();
                                                                if (var10_17.IsInfinity()) {
                                                                    var134_20 += 2;
                                                                }
                                                                var135_21 = var6_5 & var10_17.flags;
                                                                var136_22 = false;
                                                                if (var135_21 != 0) {
                                                                    var136_22 = true;
                                                                }
                                                                if (var136_22) {
                                                                    var134_20 += 4;
                                                                }
                                                                if (var10_17.IsSignalingNaN()) {
                                                                    var134_20 += 6;
                                                                }
                                                                var137_19 = CBORObject.NewArray();
                                                                var137_19.Add((Object)var10_17.unsignedNumerator);
                                                                var137_19.Add((Object)var10_17.denominator);
                                                                var137_19.Add(var134_20);
                                                                var141_18 = 270;
                                                                return CBORObject.FromObjectAndTag((Object)var137_19, var141_18);
                                                            }
                                                            if (var0 instanceof Short) {
                                                                var133_23 = (Short)var0;
                                                                if (var133_23 < 0) return CBORObject.FromObject((long)var133_23);
                                                                if (var133_23 >= 24) return CBORObject.FromObject((long)var133_23);
                                                                return CBORObject.FixedObjects[var133_23];
                                                            }
                                                            if (var0 instanceof Character) {
                                                                return CBORObject.FromObject(((Character)var0).charValue());
                                                            }
                                                            if (var0 instanceof Boolean) {
                                                                if ((Boolean)var0 == false) return CBORObject.False;
                                                                return CBORObject.True;
                                                            }
                                                            if (var0 instanceof Byte) {
                                                                return CBORObject.FromObject(255 & (Byte)var0);
                                                            }
                                                            if (var0 instanceof Float) {
                                                                return new CBORObject(8, CBORUtilities.SingleToDoublePrecision(Float.floatToRawIntBits((float)((Float)var0).floatValue())));
                                                            }
                                                            if (var0 instanceof Double) {
                                                                return CBORObject.FromObject((Double)var0);
                                                            }
                                                            var11_24 = var0 instanceof byte[] != false ? (byte[])var0 : null;
                                                            if (var11_24 != null) {
                                                                return CBORObject.FromObject(var11_24);
                                                            }
                                                            if (var0 instanceof Map) {
                                                                var128_25 = CBORObject.NewMap();
                                                                var129_26 = ((Map)var0).entrySet().iterator();
                                                                while (var129_26.hasNext() != false) {
                                                                    var130_27 = (Map.Entry)var129_26.next();
                                                                    var131_28 = var130_27.getKey();
                                                                    var132_29 = var2_2 + 1;
                                                                    var128_25.set(CBORObject.FromObject(var131_28, var1_1, var132_29), CBORObject.FromObject(var130_27.getValue(), var1_1, var132_29));
                                                                }
                                                                return var128_25;
                                                            }
                                                            if (var0.getClass().isArray()) {
                                                                var125_30 = Array.getLength((Object)var0);
                                                                var126_31 = CBORObject.NewArray();
                                                                while (var7_6 < var125_30) {
                                                                    var126_31.Add(CBORObject.FromObject(Array.get((Object)var0, (int)var7_6), var1_1, var2_2 + 1));
                                                                    ++var7_6;
                                                                }
                                                                return var126_31;
                                                            }
                                                            if (var0 instanceof Iterable) {
                                                                var121_32 = CBORObject.NewArray();
                                                                var122_33 = ((Iterable)var0).iterator();
                                                                while (var122_33.hasNext() != false) {
                                                                    var121_32.Add(CBORObject.FromObject(var122_33.next(), var1_1, var2_2 + 1));
                                                                }
                                                                return var121_32;
                                                            }
                                                            if (var0 instanceof Enum) {
                                                                var119_34 = (Enum)var0;
                                                                return CBORObject.FromObject((Object)var119_34.ordinal());
                                                            }
                                                            if (!(var0 instanceof Date)) break block69;
                                                            var38_35 = (Date)var0;
                                                            var39_36 = new int[7];
                                                            var40_37 = new EInteger[1];
                                                            var42_38 = var38_35.getTime();
                                                            var44_39 = (int)(var42_38 % 1000L);
                                                            if (var44_39 < 0) {
                                                                var44_39 += 1000;
                                                            }
                                                            var45_40 = var44_39 * 1000000;
                                                            var46_41 = EDecimal.FromInt64((long)var42_38);
                                                            var47_42 = EDecimal.FromInt32((int)1000);
                                                            Objects.requireNonNull((Object)var46_41);
                                                            var49_43 = var46_41.Divide(var47_42, EContext.ForRounding(ERounding.None));
                                                            var50_44 = ERounding.Floor;
                                                            var51_45 = var49_43.isFinite();
                                                            var52_46 = null;
                                                            if (!var51_45) break block70;
                                                            var107_47 = var49_43.exponent.CanFitInInt32();
                                                            var52_46 = null;
                                                            if (!var107_47) break block70;
                                                            var108_48 = var49_43.unsignedMantissa.CanFitInInt32();
                                                            var52_46 = null;
                                                            if (!var108_48) break block70;
                                                            var109_49 = var49_43.exponent.AsInt32();
                                                            if (var109_49 != 0) break block71;
                                                            var52_46 = var49_43;
                                                            break block70;
                                                        }
                                                        var110_50 = var49_43.unsignedMantissa.AsInt32();
                                                        var52_46 = null;
                                                        if (var109_49 < -100) break block70;
                                                        var52_46 = null;
                                                        if (var109_49 > 100) break block70;
                                                        if (var50_44 != ERounding.Down) break block72;
                                                        var118_51 = 0 - var109_49;
                                                        var52_46 = null;
                                                        if (var118_51 < 1) break block70;
                                                        var52_46 = null;
                                                        if (var118_51 > 9) break block70;
                                                        var117_52 = new EDecimal(new FastIntegerFixed(var110_50 / EDecimal.ValueTenPowers[var118_51]), new FastIntegerFixed(0, 0, null), var49_43.flags);
                                                        break block73;
                                                    }
                                                    var111_53 = ERounding.HalfEven;
                                                    var52_46 = null;
                                                    if (var50_44 != var111_53) break block70;
                                                    var52_46 = null;
                                                    if (var110_50 == Integer.MAX_VALUE) break block70;
                                                    var112_54 = 0 - var109_49;
                                                    var52_46 = null;
                                                    if (var112_54 < 1) break block70;
                                                    var52_46 = null;
                                                    if (var112_54 > 9) break block70;
                                                    var113_55 = EDecimal.ValueTenPowers[var112_54 - 1];
                                                    var115_57 = (var114_56 = var110_50 / var113_55) > 43698 ? var114_56 / 10 : var114_56 * 26215 >> 18;
                                                    var116_58 = var114_56 - var115_57 * 10;
                                                    if (var116_58 > var9_13 || var116_58 == var9_13 && var110_50 - var114_56 * var113_55 != 0 || var116_58 == var9_13 && (var115_57 & 1) == 1) {
                                                        ++var115_57;
                                                    }
                                                    var117_52 = new EDecimal(new FastIntegerFixed(var115_57), new FastIntegerFixed(0, 0, null), var49_43.flags);
                                                }
                                                var52_46 = var117_52;
                                            }
                                            if (var52_46 == null) {
                                                var53_59 = EDecimal.Create((EInteger)EInteger.FromInt32((int)1), (EInteger)EInteger.FromInt32((int)0));
                                                var54_60 = EContext.ForRounding(var50_44);
                                                var52_46 = (EDecimal)EDecimal.GetMathValue((EContext)var54_60).Quantize((Object)var49_43, (Object)var53_59, var54_60);
                                            }
                                            var55_61 = var52_46.ToEInteger();
                                            var56_62 = var49_43.Abs();
                                            var57_63 = EDecimal.FromEInteger((EInteger)var55_61).Abs();
                                            var58_64 = EContext.UnlimitedHalfEven;
                                            var59_65 = var57_63.flags;
                                            if ((var59_65 & 12) == 0) {
                                                var106_66 = var59_65 ^ 1;
                                                var57_63 = EDecimal.CreateWithFlags((FastIntegerFixed)var57_63.unsignedMantissa, (FastIntegerFixed)var57_63.exponent, (int)var106_66);
                                            }
                                            var60_67 = (EDecimal)EDecimal.GetMathValue((EContext)var58_64).Add((Object)var56_62, (Object)var57_63, var58_64);
                                            Objects.requireNonNull((Object)var60_67);
                                            var62_68 = EDecimal.FromInt32((int)1000000000);
                                            if (var60_67.isFinite() && var62_68.isFinite()) {
                                                var100_69 = var62_68.flags ^ var60_67.flags;
                                                if (var60_67.unsignedMantissa.CanFitInInt32() && var62_68.unsignedMantissa.CanFitInInt32()) {
                                                    var101_70 = var60_67.unsignedMantissa.AsInt32();
                                                    var102_71 = var62_68.unsignedMantissa.AsInt32();
                                                    var103_72 = (long)var101_70 * (long)var102_71;
                                                    var105_73 = FastIntegerFixed.Add((FastIntegerFixed)var60_67.exponent, (FastIntegerFixed)var62_68.exponent);
                                                    var63_74 = var103_72 >> 31 == 0L ? new EDecimal(new FastIntegerFixed((int)var103_72), var105_73, var100_69) : new EDecimal(FastIntegerFixed.FromBig((EInteger)EInteger.FromInt64((long)var103_72)), var105_73, var100_69);
                                                } else {
                                                    var63_74 = new EDecimal(FastIntegerFixed.FromBig((EInteger)var60_67.unsignedMantissa.ToEInteger().Multiply(var62_68.unsignedMantissa.ToEInteger())), FastIntegerFixed.Add((FastIntegerFixed)var60_67.exponent, (FastIntegerFixed)var62_68.exponent), var100_69);
                                                }
                                            } else {
                                                var63_74 = (EDecimal)EDecimal.GetMathValue((EContext)var58_64).Multiply((Object)var60_67, (Object)var62_68, var58_64);
                                            }
                                            if (var63_74.isFinite() == false) throw new ArithmeticException("Value is infinity or NaN");
                                            if (!var63_74.isFinite()) ** GOTO lbl-1000
                                            if (var63_74.unsignedMantissa.isValueZero()) ** GOTO lbl-1000
                                            if (var63_74.getExponent().signum() < 0) {
                                                var64_75 = var63_74.getExponent();
                                                ** if (var63_74.getUnsignedMantissa().GetDigitCountAsEInteger().compareTo((EInteger)var64_75) > 0) goto lbl-1000
                                            }
                                            ** GOTO lbl-1000
lbl-1000: // 2 sources:
                                            {
                                                var65_76 = true;
                                                ** GOTO lbl239
                                            }
lbl-1000: // 3 sources:
                                            {
                                                var65_76 = false;
                                            }
lbl239: // 2 sources:
                                            if (!var65_76) break block74;
                                            var71_77 = 3;
                                            var70_78 = 0;
                                            break block75;
                                        }
                                        var66_79 = var63_74.exponent;
                                        var67_80 = var66_79.integerMode;
                                        if (var67_80 == 0) break block76;
                                        if (var67_80 != 2) ** GOTO lbl-1000
                                        var69_81 = var66_79.largeValue.compareTo(EInteger.FromInt32((int)10));
                                        break block77;
                                    }
                                    var68_82 = var66_79.smallValue;
                                    if (10 == var68_82) lbl-1000: // 2 sources:
                                    {
                                        var69_81 = 0;
                                    } else {
                                        var69_81 = var68_82 < 10 ? -1 : 1;
                                    }
                                }
                                if (var69_81 >= 0) throw new ArithmeticException("Value out of range: ");
                                var70_78 = var63_74.ToEInteger().ToInt32Checked();
                                var71_77 = 3;
                            }
                            var72_83 = new EInteger[var71_77];
                            var73_84 = CBORUtilities.FloorDiv(var55_61, EInteger.FromInt32((int)86400)).Add(1);
                            var74_85 = EInteger.FromInt32((int)86400);
                            var75_86 = var55_61.Subtract(CBORUtilities.FloorDiv(var55_61, var74_85).Multiply(var74_85)).ToInt32Checked();
                            var76_87 = EInteger.FromInt32((int)1970);
                            var77_88 = var76_87.Remainder(4).signum() == 0 && (var76_87.Remainder(100).signum() != 0 || var76_87.Remainder(400).signum() == 0) ? CBORUtilities.ValueLeapDays : CBORUtilities.ValueNormalDays;
                            if (var73_84.compareTo(101) <= 0) break block78;
                            var99_89 = var73_84.Subtract(100).Divide(EInteger.FromInt32((int)146097));
                            var73_84 = var73_84.Subtract(var99_89.Multiply(146097));
                            var76_87 = var76_87.Add(var99_89.Multiply(400));
                            break block78;
                        }
                        if (!(var0 instanceof URI)) break block79;
                        var31_111 = ((URI)var0).toString();
                        var33_113 = false;
                        break block80;
                    }
                    if (var0 instanceof UUID) {
                        var24_118 = (UUID)var0;
                        var26_119 = new byte[16];
                        var27_120 = var24_118.getLeastSignificantBits();
                        var29_121 = var24_118.getMostSignificantBits();
                        var26_119[0] = (byte)(255L & var29_121 >> 56);
                        var26_119[1] = (byte)(255L & var29_121 >> 48);
                        var26_119[2] = (byte)(255L & var29_121 >> 40);
                        var26_119[3] = (byte)(255L & var29_121 >> 32);
                        var26_119[4] = (byte)(255L & var29_121 >> 24);
                        var26_119[var9_13] = (byte)(255L & var29_121 >> 16);
                        var26_119[6] = (byte)(255L & var29_121 >> 8);
                        var26_119[7] = (byte)(var29_121 & 255L);
                        var26_119[8] = (byte)(255L & var27_120 >> 56);
                        var26_119[9] = (byte)(255L & var27_120 >> 48);
                        var26_119[10] = (byte)(255L & var27_120 >> 40);
                        var26_119[11] = (byte)(255L & var27_120 >> 32);
                        var26_119[12] = (byte)(255L & var27_120 >> 24);
                        var26_119[13] = (byte)(255L & var27_120 >> 16);
                        var26_119[14] = (byte)(255L & var27_120 >> 8);
                        var26_119[15] = (byte)(var27_120 & 255L);
                        return CBORObject.FromObjectAndTag((Object)var26_119, 37);
                    }
                    break block81;
                }
                var78_90 = var73_84;
                var79_91 = var77_88;
                var80_92 = var76_87;
                var81_93 = 1;
                do {
                    var82_94 = EInteger.FromInt32((int)var79_91[var81_93]);
                    if (var78_90.signum() > 0 && var78_90.compareTo(var82_94) <= 0) {
                        var72_83[0] = var80_92;
                        var72_83[1] = EInteger.FromInt32((int)var81_93);
                        var72_83[2] = var78_90;
                        var39_36[0] = var72_83[1].ToInt32Checked();
                        var39_36[1] = var72_83[2].ToInt32Checked();
                        var39_36[2] = var75_86 / 3600;
                        var39_36[3] = var75_86 % 3600 / 60;
                        var39_36[4] = var75_86 % 60;
                        var39_36[var9_13] = var70_78 / 100;
                        var39_36[6] = 0;
                        var40_37[0] = var72_83[0];
                        var39_36[var9_13] = var45_40;
                        var85_97 = var40_37[0];
                        if (var39_36[6] != 0) throw new UnsupportedOperationException("Local time offsets not supported");
                        var86_98 = var85_97.ToInt32Checked();
                        if (var86_98 < 0) throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"year (", (int)var86_98, (String)") is not greater or equal to 0"));
                        if (var86_98 > 9999) throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"year (", (int)var86_98, (String)") is not less or equal to 9999"));
                        var87_99 = var39_36[0];
                        var88_100 = var39_36[1];
                        var89_101 = var39_36[2];
                        var90_102 = var39_36[3];
                        var91_103 = var39_36[4];
                        var92_104 = var39_36[var9_13];
                        var93_105 = new char[32];
                        var93_105[0] = (char)GeneratedOutlineSupport.outline2((int)var86_98, (int)1000, (int)10, (int)48);
                        var93_105[1] = (char)GeneratedOutlineSupport.outline2((int)var86_98, (int)100, (int)10, (int)48);
                        var93_105[2] = (char)GeneratedOutlineSupport.outline2((int)var86_98, (int)10, (int)10, (int)48);
                        var93_105[3] = (char)(48 + var86_98 % 10);
                        var93_105[4] = 45;
                        var93_105[var9_13] = (char)GeneratedOutlineSupport.outline2((int)var87_99, (int)10, (int)10, (int)48);
                        var93_105[6] = (char)(48 + var87_99 % 10);
                        var93_105[7] = 45;
                        var93_105[8] = (char)GeneratedOutlineSupport.outline2((int)var88_100, (int)10, (int)10, (int)48);
                        var93_105[9] = (char)(48 + var88_100 % 10);
                        var93_105[10] = 84;
                        var93_105[11] = (char)GeneratedOutlineSupport.outline2((int)var89_101, (int)10, (int)10, (int)48);
                        var93_105[12] = (char)(48 + var89_101 % 10);
                        var93_105[13] = 58;
                        var93_105[14] = (char)GeneratedOutlineSupport.outline2((int)var90_102, (int)10, (int)10, (int)48);
                        var93_105[15] = (char)(48 + var90_102 % 10);
                        var93_105[16] = 58;
                        var93_105[17] = (char)GeneratedOutlineSupport.outline2((int)var91_103, (int)10, (int)10, (int)48);
                        var93_105[18] = (char)(48 + var91_103 % 10);
                        var94_106 = 20;
                        if (var92_104 <= 0) {
                            var93_105[19] = 90;
                            return CBORObject.FromObjectAndTag((Object)new String(var93_105, 0, var94_106), 0);
                        }
                        var93_105[19] = 46;
                        var96_108 = var94_106;
                        for (var95_107 = 100000000; var95_107 > 0 && var92_104 != 0; var92_104 -= var97_109 * var95_107, ++var94_106, var95_107 /= 10) {
                            var97_109 = var92_104 / var95_107 % 10;
                            var98_110 = var96_108 + 1;
                            var93_105[var96_108] = (char)(var97_109 + 48);
                            var96_108 = var98_110;
                        }
                        var93_105[var96_108] = 90;
                        return CBORObject.FromObjectAndTag((Object)new String(var93_105, 0, ++var94_106), 0);
                    }
                    if (var78_90.compareTo(var82_94) > 0) {
                        var78_90 = var78_90.Subtract(var82_94);
                        if (var81_93 == 12) {
                            var84_96 = (var80_92 = var80_92.Add(1)).Remainder(4).signum() == 0 && (var80_92.Remainder(100).signum() != 0 || var80_92.Remainder(400).signum() == 0) ? CBORUtilities.ValueLeapDays : CBORUtilities.ValueNormalDays;
                            var79_91 = var84_96;
                            var81_93 = 1;
                        } else {
                            ++var81_93;
                        }
                    }
                    if (var78_90.signum() > 0) continue;
                    if (--var81_93 <= 0) {
                        var80_92 = var80_92.Add(-1);
                        var81_93 = 12;
                    }
                    var83_95 = var80_92.Remainder(4).signum() == 0 && (var80_92.Remainder(100).signum() != 0 || var80_92.Remainder(400).signum() == 0) ? CBORUtilities.ValueLeapDays : CBORUtilities.ValueNormalDays;
                    var78_90 = var78_90.Add(var83_95[var81_93]);
                    var79_91 = var83_95;
                } while (true);
            }
            for (var32_112 = 0; var32_112 < var31_111.length(); var33_113 |= var37_114, ++var32_112) {
                var37_114 = var31_111.charAt(var32_112) >= '';
            }
            var34_115 = var33_113 != false ? 266 : 32;
            var35_116 = R.style.SplitIRI((String)var31_111, (int)0, (int)var31_111.length(), (URIUtility$ParseMode)URIUtility$ParseMode.IRIStrict);
            var36_117 = var35_116 != null && var35_116[0] >= 0;
            if (var36_117 != false) return CBORObject.FromObjectAndTag((Object)var31_111, var34_115);
            var34_115 = 267;
            return CBORObject.FromObjectAndTag((Object)var31_111, var34_115);
        }
        var12_122 = CBORObject.NewMap();
        var13_123 = ((ArrayList)PropertyMap.GetProperties(var0, true)).iterator();
        while (var13_123.hasNext() != false) {
            var14_124 = (Map.Entry)var13_123.next();
            var15_125 = (String)var14_124.getKey();
            var16_126 = var14_124.getValue();
            var17_127 = var2_2 + 1;
            var19_128 = CBORObject.FromObject(var16_126, var1_1, var17_127);
            Objects.requireNonNull((Object)var15_125, (String)"value");
            Objects.requireNonNull((Object)var19_128, (String)"value");
            var22_129 = CBORObject.FromObject(var15_125);
            if (var12_122.getItemType() != var9_13) throw new IllegalStateException("Not a map");
            var12_122.AsMap().put((Object)var22_129, (Object)var19_128);
        }
        return var12_122;
        catch (Throwable var18_130) {
            throw var18_130;
        }
    }

    public static CBORObject FromObject(String string) {
        if (R.style.GetUtf8Length((String)string, (boolean)false) >= 0L) {
            return new CBORObject(3, string);
        }
        throw new IllegalArgumentException("String contains an unpaired surrogate code point.");
    }

    public static CBORObject FromObject(byte[] arrby) {
        if (arrby == null) {
            return Null;
        }
        System.arraycopy((Object)arrby, (int)0, (Object)new byte[arrby.length], (int)0, (int)arrby.length);
        return new CBORObject(2, arrby);
    }

    public static CBORObject FromObjectAndTag(Object object, int n2) {
        if (n2 >= 0) {
            return new CBORObject(CBORObject.FromObject(object), n2, 0);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"smallTag (", (int)n2, (String)") is less than 0"));
    }

    public static CBORObject FromObjectAndTag(Object object, EInteger eInteger) {
        if (eInteger.signum() >= 0) {
            if (eInteger.compareTo(UInt64MaxValue) <= 0) {
                int n2;
                int n3;
                CBORObject cBORObject = CBORObject.FromObject(object);
                if (eInteger.CanFitInInt32()) {
                    return CBORObject.FromObjectAndTag((Object)cBORObject, eInteger.ToInt32Checked());
                }
                byte[] arrby = eInteger.ToBytes(true);
                int n4 = 0;
                int n5 = 0;
                do {
                    int n6 = arrby.length;
                    int n7 = Math.min((int)n2, (int)n6);
                    n3 = 0;
                    if (n4 >= n7) break;
                    n5 |= (255 & arrby[n4]) << n4 * 8;
                    ++n4;
                } while (true);
                for (n2 = 4; n2 < Math.min((int)8, (int)arrby.length); ++n2) {
                    n3 |= (255 & arrby[n2]) << n2 * 8;
                }
                return new CBORObject(cBORObject, n5, n3);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("tag more than 18446744073709551615 (");
            stringBuilder.append((Object)eInteger);
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"tagEInt's sign (");
        stringBuilder.append(eInteger.signum());
        stringBuilder.append(") is less than 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static byte[] GetDoubleBytes(long var0, int var2_1) {
        block15 : {
            block19 : {
                block17 : {
                    block18 : {
                        block16 : {
                            block14 : {
                                block13 : {
                                    var3_2 = (int)(2047L & var0 >> 52);
                                    var4_3 = var0 & 0xFFFFFFFFFFFFFL;
                                    var6_4 = var0 >> 48;
                                    var8_5 = 32768 & (int)var6_4;
                                    var9_6 = var3_2 - 1008;
                                    if (var3_2 != 2047) break block13;
                                    var11_7 = (int)(var4_3 >> 42);
                                    if ((0x3FFFFFFFFFFL & var4_3) != 0L) ** GOTO lbl-1000
                                    var8_5 |= 31744;
                                    ** GOTO lbl22
                                }
                                if (var9_6 >= 31 || var9_6 < -10) ** GOTO lbl-1000
                                if (var9_6 <= 0) break block14;
                                if ((0x3FFFFFFFFFFL & var4_3) != 0L) ** GOTO lbl-1000
                                var8_5 |= var9_6 << 10;
                                var11_7 = CBORUtilities.RoundedShift(var4_3, 42);
                                ** GOTO lbl22
                            }
                            var10_9 = 42 - (var9_6 - 1);
                            if ((var4_3 & (1L << var10_9) - 1L) == 0L) {
                                var11_7 = CBORUtilities.RoundedShift(var4_3 | 0x10000000000000L, var10_9);
lbl22: // 3 sources:
                                var12_8 = var8_5 | var11_7;
                            } else lbl-1000: // 4 sources:
                            {
                                var12_8 = -1;
                            }
                            if (var12_8 != -1) {
                                if (var2_1 != 0) {
                                    var22_10 = new byte[]{(byte)var2_1, -7, (byte)(255 & var12_8 >> 8), (byte)(var12_8 & 255)};
                                    return var22_10;
                                }
                                var21_11 = new byte[]{-7, (byte)(255 & var12_8 >> 8), (byte)(var12_8 & 255)};
                                return var21_11;
                            }
                            var13_12 = var3_2 - 896;
                            var14_13 = var3_2 == 2047 ? (var4_3 & 0x1FFFFFFFL) == 0L : var13_12 >= -23 && var13_12 < 255 && (var13_12 > 0 ? (var4_3 & 0x1FFFFFFFL) == 0L : (var4_3 & (1L << 29 - (var13_12 - 1)) - 1L) == 0L);
                            if (!var14_13) break block15;
                            var17_14 = Integer.MIN_VALUE & (int)(var0 >> 32);
                            if (var3_2 != 2047) break block16;
                            var18_15 = (int)(var4_3 >> 29);
                            if (var4_3 != 0L && var18_15 == 0) {
                                var18_15 = 2139095041;
                            } else {
                                var17_14 |= 2139095040;
                            }
                            break block17;
                        }
                        if (var13_12 < 255) break block18;
                        var17_14 |= 2139095040;
                        break block19;
                    }
                    if (var13_12 < -23) break block19;
                    if (var13_12 > 0) {
                        var17_14 |= var13_12 << 23;
                        var18_15 = CBORUtilities.RoundedShift(var4_3, 29);
                    } else {
                        var18_15 = CBORUtilities.RoundedShift(var4_3 | 0x10000000000000L, 29 - (var13_12 - 1));
                    }
                }
                var17_14 |= var18_15;
            }
            if (var2_1 != 0) {
                var20_16 = new byte[]{(byte)var2_1, -6, (byte)(255 & var17_14 >> 24), (byte)(255 & var17_14 >> 16), (byte)(255 & var17_14 >> 8), (byte)(var17_14 & 255)};
                return var20_16;
            }
            var19_17 = new byte[]{-6, (byte)(255 & var17_14 >> 24), (byte)(255 & var17_14 >> 16), (byte)(255 & var17_14 >> 8), (byte)(var17_14 & 255)};
            return var19_17;
        }
        if (var2_1 != 0) {
            var16_18 = new byte[]{(byte)var2_1, -5, (byte)(255L & var0 >> 56), (byte)(var6_4 & 255L), (byte)(255L & var0 >> 40), (byte)(255L & var0 >> 32), (byte)(255L & var0 >> 24), (byte)(255L & var0 >> 16), (byte)(255L & var0 >> 8), (byte)(var0 & 255L)};
            return var16_18;
        }
        var15_19 = new byte[]{-5, (byte)(255L & var0 >> 56), (byte)(var6_4 & 255L), (byte)(255L & var0 >> 40), (byte)(255L & var0 >> 32), (byte)(255L & var0 >> 24), (byte)(255L & var0 >> 16), (byte)(255L & var0 >> 8), (byte)(var0 & 255L)};
        return var15_19;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static CBORObject GetFixedLengthObject(int var0, byte[] var1_1) {
        block32 : {
            block33 : {
                var2_2 = CBORObject.FixedObjects[var0];
                if (var2_2 != null) {
                    return var2_2;
                }
                var3_3 = var0 >> 5;
                if (var0 >= 97 && var0 < 120 && (var44_4 = CBORObject.GetOptimizedStringIfShortAscii(var1_1, 0)) != null) {
                    return new CBORObject(3, var44_4);
                }
                var4_5 = var0 & 28;
                var5_6 = 1;
                if (var4_5 != 24) break block32;
                switch (var0 & 31) {
                    default: {
                        throw new CBORException("Unexpected data encountered");
                    }
                    case 27: {
                        var41_7 = (255L & (long)var1_1[var5_6]) << 56 | (255L & (long)var1_1[2]) << 48 | (255L & (long)var1_1[3]) << 40 | (255L & (long)var1_1[4]) << 32 | (255L & (long)var1_1[5]) << 24 | (255L & (long)var1_1[6]) << 16 | (255L & (long)var1_1[7]) << 8;
                        var43_8 = var1_1[8];
                        ** GOTO lbl20
                    }
                    case 26: {
                        var41_7 = (255L & (long)var1_1[var5_6]) << 24 | (255L & (long)var1_1[2]) << 16 | (255L & (long)var1_1[3]) << 8;
                        var43_8 = var1_1[4];
lbl20: // 2 sources:
                        var5_6 = 1;
                        ** GOTO lbl25
                    }
                    case 25: {
                        var41_7 = (255L & (long)var1_1[var5_6]) << 8;
                        var43_8 = var1_1[2];
lbl25: // 2 sources:
                        var37_9 = var41_7 | 255L & (long)var43_8;
                        break block33;
                    }
                    case 24: 
                }
                var37_9 = 255 & var1_1[var5_6];
            }
            if (var3_3 == 0) {
                if (var37_9 >> 63 != 0L) return CBORObject.FromObject(CBORObject.LowHighToEInteger((int)(var37_9 & 0xFFFFFFFFL), (int)(0xFFFFFFFFL & var37_9 >> 32)));
                return new CBORObject(0, var37_9);
            }
            if (var3_3 != var5_6) {
                if (var3_3 != 7) throw new CBORException("Unexpected data encountered");
                if (var0 >= 249 && var0 <= 251) {
                    if (var0 == 249) {
                        var37_9 = CBORUtilities.HalfToDoublePrecision((int)var37_9);
                        return new CBORObject(8, var37_9);
                    }
                    if (var0 != 250) return new CBORObject(8, var37_9);
                    var37_9 = CBORUtilities.SingleToDoublePrecision((int)var37_9);
                    return new CBORObject(8, var37_9);
                }
                if (var0 != 248) throw new CBORException("Unexpected data encountered");
                var40_10 = (int)var37_9;
                if (var40_10 < 32) throw new CBORException("Invalid overlong simple value");
                return new CBORObject(7, var40_10);
            }
            if (var37_9 >> 63 == 0L) {
                return new CBORObject(0, -1L - var37_9);
            }
            var39_11 = CBORObject.LowHighToEInteger((int)(var37_9 & 0xFFFFFFFFL), (int)(0xFFFFFFFFL & var37_9 >> 32));
            return CBORObject.FromObject(EInteger.FromInt64((long)-1L).Subtract(var39_11));
        }
        if (var3_3 == 2) {
            var35_12 = var0 - 64;
            var36_13 = new byte[var35_12];
            System.arraycopy((Object)var1_1, (int)1, (Object)var36_13, (int)0, (int)var35_12);
            return new CBORObject(2, var36_13);
        }
        var6_14 = 0;
        if (var3_3 == 3) {
            var7_15 = var0 - 96;
            var8_16 = new StringBuilder(var7_15);
            if (1 > var1_1.length) {
                var9_33 = GeneratedOutlineSupport.outline25((String)"offset (", (int)1, (String)") is more than ");
                var9_33.append(var1_1.length);
                throw new IllegalArgumentException(var9_33.toString());
            }
            if (var7_15 < 0) throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"bytesCount (", (int)var7_15, (String)") is less than 0"));
            if (var7_15 > var1_1.length) {
                var11_32 = GeneratedOutlineSupport.outline25((String)"bytesCount (", (int)var7_15, (String)") is more than ");
                var11_32.append(var1_1.length);
                throw new IllegalArgumentException(var11_32.toString());
            }
            if (var1_1.length - 1 < var7_15) {
                var13_31 = GeneratedOutlineSupport.outline24((String)"data.length minus offset (");
                var13_31.append(-1 + var1_1.length);
                var13_31.append(") is less than ");
                var13_31.append(var7_15);
                throw new IllegalArgumentException(var13_31.toString());
            }
        } else {
            if (var0 == 128) {
                return CBORObject.NewArray();
            }
            if (var0 != 160) throw new CBORException("Unexpected data encountered");
            return CBORObject.NewMap();
        }
        var17_17 = var7_15 + 1;
        var18_18 = 1;
        do {
            var19_21 = 0;
            var20_22 = var18_18;
            var21_23 = 0;
            do {
                block31 : {
                    var22_24 = 128;
                    var23_25 = 191;
                    while (var20_22 < var17_17) {
                        block36 : {
                            block35 : {
                                block34 : {
                                    var24_26 = 255 & var1_1[var20_22];
                                    ++var20_22;
                                    if (var6_14 != 0) break block31;
                                    if ((var24_26 & 127) == var24_26) {
                                        var8_16.append((char)var24_26);
                                        continue;
                                    }
                                    if (var24_26 < 194 || var24_26 > 223) break block34;
                                    var31_30 = var24_26 - 192 << 6;
                                    var32_19 = 1;
                                    break block35;
                                }
                                if (var24_26 < 224 || var24_26 > 239) break block36;
                                var22_24 = var24_26 == 224 ? 160 : 128;
                                var23_25 = var24_26 == 237 ? 159 : 191;
                                var31_30 = var24_26 - 224 << 12;
                                var32_19 = 2;
                            }
                            var33_20 = var32_19;
                            var19_21 = var31_30;
                            var6_14 = var33_20;
                            continue;
                        }
                        if (var24_26 < 240) return new CBORObject(3, var8_16.toString());
                        if (var24_26 > 244) return new CBORObject(3, var8_16.toString());
                        var22_24 = var24_26 == 240 ? 144 : 128;
                        var23_25 = var24_26 == 244 ? 143 : 191;
                        var19_21 = var24_26 - 240 << 18;
                        var6_14 = 3;
                    }
                    return new CBORObject(3, var8_16.toString());
                }
                if (var24_26 < var22_24) return new CBORObject(3, var8_16.toString());
                if (var24_26 > var23_25) {
                    return new CBORObject(3, var8_16.toString());
                }
                var19_21 += var24_26 - 128 << 6 * (var6_14 - ++var21_23);
            } while (var21_23 != var6_14);
            if (var19_21 <= 65535) {
                var8_16.append((char)var19_21);
            } else {
                var25_27 = var19_21 - 65536;
                var26_28 = 55296 + (var25_27 >> 10);
                var27_29 = 56320 + (var25_27 & 1023);
                var8_16.append((char)var26_28);
                var8_16.append((char)var27_29);
            }
            var6_14 = 0;
            var18_18 = var20_22;
        } while (true);
    }

    public static byte[] GetOptimizedBytesIfShortAscii(String string, int n2) {
        if (string.length() <= 255) {
            int n3;
            int n4;
            int n5 = string.length();
            int n6 = 1;
            int n7 = n5 < 24 ? n6 : 2;
            if (n2 >= 0) {
                ++n7;
            }
            byte[] arrby = new byte[n7 + n5];
            if (n2 >= 0) {
                arrby[0] = (byte)n2;
                n4 = n6;
            } else {
                n4 = 0;
            }
            if (n5 < 24) {
                arrby[n4] = (byte)(96 + string.length());
                n3 = n4 + n6;
            } else {
                arrby[n4] = 120;
                arrby[n4 + 1] = (byte)string.length();
                n3 = n4 + 2;
            }
            for (int i2 = 0; i2 < string.length(); ++i2) {
                char c2 = string.charAt(i2);
                if (c2 >= '') {
                    n6 = 0;
                    break;
                }
                arrby[i2 + n3] = (byte)c2;
            }
            if (n6 != 0) {
                return arrby;
            }
        }
        return null;
    }

    public static String GetOptimizedStringIfShortAscii(byte[] arrby, int n2) {
        int n3;
        int n4 = arrby.length;
        if (n4 > n2 && (n3 = 255 & arrby[n2]) >= 96 && n3 < 120) {
            int n5 = n2 + 1;
            CBORObject.CheckCBORLength(n5 + (n3 - 96), n4);
            for (int i2 = n5; i2 < n4; ++i2) {
                if ((-128 & arrby[i2]) == 0) continue;
                return null;
            }
            char[] arrc = new char[n4 - n5];
            for (int i3 = n5; i3 < n4; ++i3) {
                arrc[i3 - n5] = (char)(255 & arrby[i3]);
            }
            return new String(arrc);
        }
        return null;
    }

    public static byte[] GetPositiveInt64Bytes(int n2, long l2) {
        if (l2 >= 0L) {
            if (l2 < 24L) {
                byte[] arrby = new byte[]{(byte)((byte)l2 | (byte)(n2 << 5))};
                return arrby;
            }
            if (l2 <= 255L) {
                byte[] arrby = new byte[]{(byte)(24 | n2 << 5), (byte)(l2 & 255L)};
                return arrby;
            }
            if (l2 <= 65535L) {
                byte[] arrby = new byte[]{(byte)(25 | n2 << 5), (byte)(255L & l2 >> 8), (byte)(l2 & 255L)};
                return arrby;
            }
            if (l2 <= 0xFFFFFFFFL) {
                byte[] arrby = new byte[]{(byte)(26 | n2 << 5), (byte)(255L & l2 >> 24), (byte)(255L & l2 >> 16), (byte)(255L & l2 >> 8), (byte)(l2 & 255L)};
                return arrby;
            }
            byte[] arrby = new byte[]{(byte)(27 | n2 << 5), (byte)(255L & l2 >> 56), (byte)(255L & l2 >> 48), (byte)(255L & l2 >> 40), (byte)(255L & l2 >> 32), (byte)(255L & l2 >> 24), (byte)(255L & l2 >> 16), (byte)(255L & l2 >> 8), (byte)(l2 & 255L)};
            return arrby;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("value (");
        stringBuilder.append(l2);
        stringBuilder.append(") is less than 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static int ListCompare(List<CBORObject> list, List<CBORObject> list2) {
        int n2;
        int n3 = -1;
        if (list == null) {
            if (list2 == null) {
                n3 = 0;
            }
            return n3;
        }
        if (list2 == null) {
            return 1;
        }
        int n4 = list.size();
        if (n4 != (n2 = list2.size())) {
            if (n4 < n2) {
                return n3;
            }
            return 1;
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = ((CBORObject)list.get(i2)).compareTo((CBORObject)list2.get(i2));
            if (n5 == 0) continue;
            return n5;
        }
        return 0;
    }

    public static EInteger LowHighToEInteger(int n2, int n3) {
        if (n3 != 0) {
            byte[] arrby = new byte[9];
            arrby[7] = (byte)(255 & n3 >> 24);
            arrby[6] = (byte)(255 & n3 >> 16);
            arrby[5] = (byte)(255 & n3 >> 8);
            arrby[4] = (byte)(n3 & 255);
            arrby[3] = (byte)(255 & n2 >> 24);
            arrby[2] = (byte)(255 & n2 >> 16);
            arrby[1] = (byte)(255 & n2 >> 8);
            arrby[0] = (byte)(n2 & 255);
            arrby[8] = 0;
            return EInteger.FromBytes((byte[])arrby, (boolean)true);
        }
        if (n2 != 0) {
            byte[] arrby = new byte[5];
            arrby[3] = (byte)(255 & n2 >> 24);
            arrby[2] = (byte)(255 & n2 >> 16);
            arrby[1] = (byte)(255 & n2 >> 8);
            arrby[0] = (byte)(n2 & 255);
            arrby[4] = 0;
            return EInteger.FromBytes((byte[])arrby, (boolean)true);
        }
        return EInteger.FromInt32((int)0);
    }

    public static CBORObject NewArray() {
        return new CBORObject(4, (Object)new ArrayList());
    }

    public static CBORObject NewMap() {
        return new CBORObject(5, (Object)new HashMap());
    }

    public static List<Object> PushObject(List<Object> arrayList, Object object, Object object2) {
        if (arrayList == null) {
            arrayList = new ArrayList();
            arrayList.add(object);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() != object2) continue;
            throw new IllegalArgumentException("Circular reference in data structure");
        }
        arrayList.add(object2);
        return arrayList;
    }

    public static List<Object> WriteChildObject(Object object, CBORObject cBORObject, OutputStream outputStream, List<Object> list, CBOREncodeOptions cBOREncodeOptions) throws IOException {
        if (cBORObject == null) {
            outputStream.write(246);
            return list;
        }
        int n2 = cBORObject.getItemType();
        if (n2 == 4) {
            List<Object> list2 = CBORObject.PushObject(list, object, cBORObject.getThisItem());
            cBORObject.WriteTags(outputStream);
            CBORObject.WriteObjectArray(cBORObject.AsList(), outputStream, list2, cBOREncodeOptions);
            list2.remove(-1 + list2.size());
            return list2;
        }
        if (n2 == 5) {
            List<Object> list3 = CBORObject.PushObject(list, object, cBORObject.getThisItem());
            cBORObject.WriteTags(outputStream);
            CBORObject.WriteObjectMap(cBORObject.AsMap(), outputStream, list3, cBOREncodeOptions);
            list3.remove(-1 + list3.size());
            return list3;
        }
        cBORObject.WriteTo(outputStream, cBOREncodeOptions);
        return list;
    }

    public static void WriteObjectArray(List<CBORObject> list, OutputStream outputStream, List<Object> list2, CBOREncodeOptions cBOREncodeOptions) throws IOException {
        CBORObject.WritePositiveInt(4, list.size(), outputStream);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            list2 = CBORObject.WriteChildObject(list, (CBORObject)iterator.next(), outputStream, list2, cBOREncodeOptions);
        }
    }

    public static void WriteObjectMap(Map<CBORObject, CBORObject> map, OutputStream outputStream, List<Object> list, CBOREncodeOptions cBOREncodeOptions) throws IOException {
        CBORObject.WritePositiveInt(5, map.size(), outputStream);
        for (Map.Entry entry : map.entrySet()) {
            CBORObject cBORObject = (CBORObject)entry.getKey();
            list = CBORObject.WriteChildObject(map, (CBORObject)entry.getValue(), outputStream, CBORObject.WriteChildObject(map, cBORObject, outputStream, list, cBOREncodeOptions), cBOREncodeOptions);
        }
    }

    public static int WritePositiveInt(int n2, int n3, OutputStream outputStream) throws IOException {
        if (n3 >= 0) {
            byte[] arrby;
            if (n3 < 24) {
                arrby = new byte[]{(byte)((byte)n3 | (byte)(n2 << 5))};
            } else if (n3 <= 255) {
                byte[] arrby2 = new byte[]{(byte)(24 | n2 << 5), (byte)(n3 & 255)};
                arrby = arrby2;
            } else {
                byte[] arrby3 = n3 <= 65535 ? new byte[]{(byte)(25 | n2 << 5), (byte)(255 & n3 >> 8), (byte)(n3 & 255)} : new byte[]{(byte)(26 | n2 << 5), (byte)(255 & n3 >> 24), (byte)(255 & n3 >> 16), (byte)(255 & n3 >> 8), (byte)(n3 & 255)};
                arrby = arrby3;
            }
            outputStream.write(arrby, 0, arrby.length);
            return arrby.length;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"value (", (int)n3, (String)") is less than 0"));
    }

    public static int WritePositiveInt64(int n2, long l2, OutputStream outputStream) throws IOException {
        byte[] arrby = CBORObject.GetPositiveInt64Bytes(n2, l2);
        outputStream.write(arrby, 0, arrby.length);
        return arrby.length;
    }

    public CBORObject Add(CBORObject cBORObject) {
        if (this.getItemType() == 4) {
            this.AsList().add((Object)cBORObject);
            return this;
        }
        throw new IllegalStateException("Not an array");
    }

    public CBORObject Add(Object object) {
        if (this.getItemType() == 4) {
            this.AsList().add((Object)CBORObject.FromObject(object));
            return this;
        }
        throw new IllegalStateException("Not an array");
    }

    public long AsDoubleBits() {
        if (this.getType().ordinal() == 8) {
            return (Long)this.getThisItem();
        }
        throw new IllegalStateException("Not a floating-point type");
    }

    public double AsDoubleValue() {
        if (this.getType().ordinal() == 8) {
            return Double.longBitsToDouble((long)((Long)this.getThisItem()));
        }
        throw new IllegalStateException("Not a floating-point type");
    }

    public EInteger AsEIntegerValue() {
        int n2 = this.getItemType();
        if (n2 != 0) {
            if (n2 == 1) {
                return (EInteger)this.getThisItem();
            }
            throw new IllegalStateException("Not an integer type");
        }
        return EInteger.FromInt64((long)((Long)this.getThisItem()));
    }

    public int AsInt32() {
        CBORNumber cBORNumber = CBORNumber.FromCBORObject(this);
        if (cBORNumber != null) {
            return cBORNumber.GetNumberInterface().AsInt32(cBORNumber.value, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        throw new IllegalStateException("not a number type");
    }

    public int AsInt32Value() {
        int n2 = this.getItemType();
        if (n2 != 0) {
            if (n2 == 1) {
                return ((EInteger)this.getThisItem()).ToInt32Checked();
            }
            throw new IllegalStateException("Not an integer type");
        }
        long l2 = (Long)this.getThisItem();
        if (l2 >= Integer.MIN_VALUE && l2 <= Integer.MAX_VALUE) {
            return (int)l2;
        }
        throw new ArithmeticException();
    }

    public long AsInt64() {
        CBORNumber cBORNumber = CBORNumber.FromCBORObject(this);
        if (cBORNumber != null) {
            return cBORNumber.GetNumberInterface().AsInt64(cBORNumber.value);
        }
        throw new IllegalStateException("Not a number type");
    }

    public long AsInt64Value() {
        int n2 = this.getItemType();
        if (n2 != 0) {
            if (n2 == 1) {
                return ((EInteger)this.getThisItem()).ToInt64Checked();
            }
            throw new IllegalStateException("Not an integer type");
        }
        return (Long)this.getThisItem();
    }

    public List<CBORObject> AsList() {
        return (List)this.getThisItem();
    }

    public Map<CBORObject, CBORObject> AsMap() {
        return (Map)this.getThisItem();
    }

    public String AsString() {
        if (this.getItemType() == 3) {
            return (String)this.getThisItem();
        }
        throw new IllegalStateException("Not a String type");
    }

    public boolean CanTruncatedIntFitInInt32() {
        CBORNumber cBORNumber = CBORNumber.FromCBORObject(this);
        return cBORNumber != null && cBORNumber.GetNumberInterface().CanTruncatedIntFitInInt32(cBORNumber.value);
    }

    public boolean CanValueFitInInt32() {
        int n2 = this.getItemType();
        if (n2 != 0) {
            if (n2 != 1) {
                return false;
            }
            return ((EInteger)this.getThisItem()).CanFitInInt32();
        }
        long l2 = (Long)this.getThisItem();
        long l3 = l2 LCMP Integer.MIN_VALUE;
        boolean bl = false;
        if (l3 >= 0) {
            long l4 = l2 LCMP Integer.MAX_VALUE;
            bl = false;
            if (l4 <= 0) {
                bl = true;
            }
        }
        return bl;
    }

    public boolean CanValueFitInInt64() {
        int n2 = this.getItemType();
        if (n2 != 0) {
            if (n2 != 1) {
                return false;
            }
            return ((EInteger)this.getThisItem()).CanFitInInt64();
        }
        return true;
    }

    public boolean ContainsKey(CBORObject cBORObject) {
        if (cBORObject == null) {
            cBORObject = Null;
        }
        if (this.getItemType() == 5) {
            return this.AsMap().containsKey((Object)cBORObject);
        }
        return false;
    }

    public byte[] EncodeToBytes() {
        return this.EncodeToBytes(CBOREncodeOptions.Default);
    }

    /*
     * Exception decompiling
     */
    public byte[] EncodeToBytes(CBOREncodeOptions var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl250.3 : FAKE_TRY : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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

    public byte[] GetByteString() {
        if (this.getItemType() == 2) {
            return (byte[])this.getThisItem();
        }
        throw new IllegalStateException("Not a byte String");
    }

    public boolean HasMostOuterTag(int n2) {
        if (n2 >= 0) {
            return this.isTagged() && this.tagHigh == 0 && this.tagLow == n2;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"tagValue (", (int)n2, (String)") is less than 0"));
    }

    public boolean HasOneTag(int n2) {
        boolean bl = this.isTagged() && !((CBORObject)this.itemValue).isTagged();
        return bl && this.HasMostOuterTag(n2);
    }

    public boolean HasTag(int n2) {
        if (n2 >= 0) {
            CBORObject cBORObject = this;
            do {
                if (!cBORObject.isTagged()) {
                    return false;
                }
                if (cBORObject.tagHigh == 0 && n2 == cBORObject.tagLow) {
                    return true;
                }
                cBORObject = (CBORObject)cBORObject.itemValue;
            } while (true);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"tagValue (", (int)n2, (String)") is less than 0"));
    }

    public String ToJSONString() {
        JSONOptions jSONOptions = JSONOptions.Default;
        int n2 = this.getType().ordinal();
        if (n2 != 1 && n2 != 2) {
            if (n2 != 7) {
                if (n2 != 8) {
                    StringBuilder stringBuilder = new StringBuilder();
                    try {
                        CBORJson.WriteJSONToInternal(this, new StringOutput(stringBuilder), jSONOptions);
                    }
                    catch (IOException iOException) {
                        throw new IllegalStateException("Internal error", (Throwable)iOException);
                    }
                    return stringBuilder.toString();
                }
                double d2 = this.AsDoubleValue();
                return new CBORNumber(CBORNumber.Kind.Double, d2).ToJSONString();
            }
            return this.AsEIntegerValue().toString();
        }
        if (this.isTrue()) {
            return "true";
        }
        if (this.isFalse()) {
            return "false";
        }
        return "null";
    }

    public CBORObject Untag() {
        CBORObject cBORObject = this;
        while (cBORObject.itemtypeValue == 6) {
            cBORObject = (CBORObject)cBORObject.itemValue;
        }
        return cBORObject;
    }

    public final void WriteTags(OutputStream outputStream) throws IOException {
        CBORObject cBORObject = this;
        while (cBORObject.isTagged()) {
            int n2 = cBORObject.tagLow;
            int n3 = cBORObject.tagHigh;
            if (n3 == 0 && n2 >> 16 == 0) {
                CBORObject.WritePositiveInt(6, n2, outputStream);
            } else if (n3 == 0) {
                CBORObject.WritePositiveInt64(6, 0xFFFFFFFFL & (long)n2, outputStream);
            } else {
                int n4 = n3 >> 16;
                if (n4 == 0) {
                    CBORObject.WritePositiveInt64(6, 0xFFFFFFFFL & (long)n2 | (0xFFFFFFFFL & (long)n3) << 32, outputStream);
                } else {
                    byte[] arrby = new byte[]{-37, (byte)(255 & n3 >> 24), (byte)(n4 & 255), (byte)(255 & n3 >> 8), (byte)(n3 & 255), (byte)(255 & n2 >> 24), (byte)(255 & n2 >> 16), (byte)(255 & n2 >> 8), (byte)(n2 & 255)};
                    outputStream.write(arrby, 0, 9);
                }
            }
            cBORObject = (CBORObject)cBORObject.itemValue;
        }
    }

    public void WriteTo(OutputStream outputStream, CBOREncodeOptions cBOREncodeOptions) throws IOException {
        Objects.requireNonNull((Object)outputStream, (String)"stream");
        Objects.requireNonNull((Object)cBOREncodeOptions, (String)"options");
        this.WriteTags(outputStream);
        int n2 = this.getItemType();
        int n3 = 3;
        switch (n2) {
            default: {
                throw new IllegalArgumentException("Unexpected data type");
            }
            case 8: {
                byte[] arrby = CBORObject.GetDoubleBytes(this.AsDoubleBits(), 0);
                outputStream.write(arrby, 0, arrby.length);
                return;
            }
            case 7: {
                int n4 = (Integer)this.getThisItem();
                if (n4 < 24) {
                    outputStream.write((int)((byte)(n4 + 224)));
                    return;
                }
                outputStream.write(248);
                outputStream.write((int)((byte)n4));
                return;
            }
            case 5: {
                CBORObject.WriteObjectMap(this.AsMap(), outputStream, null, cBOREncodeOptions);
                return;
            }
            case 4: {
                CBORObject.WriteObjectArray(this.AsList(), outputStream, null, cBOREncodeOptions);
                return;
            }
            case 3: {
                String string = (String)this.getThisItem();
                if (string == null) {
                    outputStream.write(246);
                    return;
                }
                CBORObject.WritePositiveInt64(n3, R.style.GetUtf8Length((String)string, (boolean)true), outputStream);
                R.style.WriteUtf8((String)string, (int)0, (int)string.length(), (OutputStream)outputStream, (boolean)true);
                return;
            }
            case 2: {
                byte[] arrby = (byte[])this.getThisItem();
                if (this.getItemType() == 2) {
                    n3 = 2;
                }
                CBORObject.WritePositiveInt(n3, arrby.length, outputStream);
                outputStream.write(arrby, 0, arrby.length);
                return;
            }
            case 1: {
                int n5;
                int n6;
                int n7;
                EInteger eInteger = (EInteger)this.getThisItem();
                if (eInteger == null) {
                    outputStream.write(246);
                    return;
                }
                if (eInteger.signum() < 0) {
                    eInteger = eInteger.Add(EInteger.FromInt32((int)1)).Negate();
                    n5 = 1;
                } else {
                    n5 = 0;
                }
                if (eInteger.CanFitInInt64()) {
                    CBORObject.WritePositiveInt64(n5, eInteger.ToInt64Checked(), outputStream);
                    return;
                }
                byte[] arrby = eInteger.ToBytes(true);
                int n8 = arrby.length;
                while (n8 > 0 && arrby[n7 = n8 - 1] == 0) {
                    n8 = n7;
                }
                if (n8 != 0) {
                    int n9 = n8 >> 1;
                    int n10 = n8 - 1;
                    int n11 = 0;
                    while (n11 < n9) {
                        byte by = arrby[n11];
                        arrby[n11] = arrby[n10];
                        arrby[n10] = by;
                        ++n11;
                        --n10;
                    }
                }
                switch (n8) {
                    default: {
                        n6 = n5 == 0 ? -62 : -61;
                    }
                    case 8: {
                        outputStream.write((int)((byte)(27 | n5 << 5)));
                        outputStream.write(arrby, 0, n8);
                        return;
                    }
                    case 7: {
                        outputStream.write((int)((byte)(27 | n5 << 5)));
                        outputStream.write(0);
                        outputStream.write(arrby, 0, n8);
                        return;
                    }
                    case 6: {
                        outputStream.write((int)((byte)(27 | n5 << 5)));
                        outputStream.write(0);
                        outputStream.write(0);
                        outputStream.write(arrby, 0, n8);
                        return;
                    }
                    case 5: {
                        outputStream.write((int)((byte)(27 | n5 << 5)));
                        outputStream.write(0);
                        outputStream.write(0);
                        outputStream.write(0);
                        outputStream.write(arrby, 0, n8);
                        return;
                    }
                    case 4: {
                        outputStream.write((int)((byte)(26 | n5 << 5)));
                        outputStream.write(arrby, 0, n8);
                        return;
                    }
                    case 3: {
                        outputStream.write((int)((byte)(26 | n5 << 5)));
                        outputStream.write(0);
                        outputStream.write(arrby, 0, n8);
                        return;
                    }
                    case 2: {
                        outputStream.write((int)((byte)(25 | n5 << 5)));
                        outputStream.write(arrby, 0, n8);
                        return;
                    }
                    case 1: {
                        CBORObject.WritePositiveInt(n5, 255 & arrby[0], outputStream);
                        return;
                    }
                    case 0: {
                        outputStream.write((int)((byte)(n5 << 5)));
                        return;
                    }
                }
                outputStream.write(n6);
                CBORObject.WritePositiveInt(2, n8, outputStream);
                outputStream.write(arrby, 0, n8);
                return;
            }
            case 0: 
        }
        long l2 = (Long)this.getThisItem();
        if (l2 >= 0L) {
            CBORObject.WritePositiveInt64(0, l2, outputStream);
            return;
        }
        CBORObject.WritePositiveInt64(1, -(l2 + 1L), outputStream);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public int compareTo(CBORObject var1_1) {
        block41 : {
            block42 : {
                block40 : {
                    var2_2 = 1;
                    if (var1_1 == null) {
                        return var2_2;
                    }
                    if (this == var1_1) {
                        return 0;
                    }
                    var3_3 = this.itemtypeValue;
                    var4_4 = var1_1.itemtypeValue;
                    var5_5 = this.itemValue;
                    var6_6 = var1_1.itemValue;
                    if (var3_3 != var4_4) break block40;
                    switch (var3_3) {
                        default: {
                            throw new IllegalStateException("Unexpected data type");
                        }
                        case 8: {
                            return CBORUtilities.ByteArrayCompare(CBORObject.GetDoubleBytes(this.AsDoubleBits(), 0), CBORObject.GetDoubleBytes(var1_1.AsDoubleBits(), 0));
                        }
                        case 7: {
                            var35_7 = (Integer)var5_5;
                            var36_8 = (Integer)var6_6;
                            if (var35_7 == var36_8) {
                                return 0;
                            }
                            if (var35_7 >= var36_8) return var2_2;
                            return -1;
                        }
                        case 6: {
                            var2_2 = this.getMostOuterTag().compareTo(var1_1.getMostOuterTag());
                            if (var2_2 != 0) return var2_2;
                            return ((CBORObject)var5_5).compareTo((CBORObject)var6_6);
                        }
                        case 5: {
                            var22_9 = (Map)var5_5;
                            var23_10 = (Map)var6_6;
                            if (var22_9 == null) {
                                if (var23_10 != null) return -1;
                                return 0;
                            }
                            if (var23_10 == null) {
                                return var2_2;
                            }
                            if (var22_9 == var23_10) {
                                return 0;
                            }
                            var24_11 = var22_9.size();
                            var25_12 = var23_10.size();
                            if (var24_11 == 0 && var25_12 == 0) {
                                return 0;
                            }
                            if (var24_11 == 0) return -1;
                            if (var25_12 == 0) {
                                return var2_2;
                            }
                            if (var24_11 != var25_12) {
                                if (var24_11 >= var25_12) return var2_2;
                                return -1;
                            }
                            var26_13 = new ArrayList((Collection)var22_9.keySet());
                            var27_14 = new ArrayList((Collection)var23_10.keySet());
                            Collections.sort((List)var26_13);
                            Collections.sort((List)var27_14);
                            var28_15 = var26_13.size();
                            var27_14.size();
                            var30_16 = 0;
                            while (var30_16 < var28_15) {
                                var31_20 = (CBORObject)var26_13.get(var30_16);
                                var32_17 = (CBORObject)var27_14.get(var30_16);
                                if (var31_20 == null) return -1;
                                var33_18 = var31_20.compareTo(var32_17);
                                if (var33_18 != 0) {
                                    return var33_18;
                                }
                                var34_19 = ((CBORObject)var22_9.get((Object)var31_20)).compareTo((CBORObject)var23_10.get((Object)var32_17));
                                if (var34_19 != 0) {
                                    return var34_19;
                                }
                                ++var30_16;
                            }
                            return 0;
                        }
                        case 4: {
                            return CBORObject.ListCompare((List<CBORObject>)((ArrayList)var5_5), (List<CBORObject>)((ArrayList)var6_6));
                        }
                        case 3: {
                            var17_21 = (String)var5_5;
                            var18_22 = (String)var6_6;
                            if (var17_21 != null) ** GOTO lbl75
                            if (var18_22 != null) ** GOTO lbl149
                            break block41;
lbl75: // 1 sources:
                            if (var18_22 == null) ** GOTO lbl95
                            if (var17_21.length() != 0) ** GOTO lbl79
                            if (var18_22.length() != 0) ** GOTO lbl149
                            break block41;
lbl79: // 1 sources:
                            if (var18_22.length() != 0) ** GOTO lbl82
                            if (var17_21.length() != 0) ** GOTO lbl95
                            break block41;
lbl82: // 1 sources:
                            if (var17_21.length() >= 64 || var18_22.length() >= 64) ** GOTO lbl94
                            for (var19_23 = 0; var19_23 < var17_21.length(); ++var19_23) {
                                if ((-128 & var17_21.charAt(var19_23)) == 0) {
                                    continue;
                                }
                                ** GOTO lbl94
                            }
                            for (var20_24 = 0; var20_24 < var18_22.length(); ++var20_24) {
                                if ((-128 & var18_22.charAt(var20_24)) == 0) {
                                    continue;
                                }
                                ** GOTO lbl94
                            }
                            if (var17_21.length() == var18_22.length()) break block42;
                            if (var17_21.length() >= var18_22.length()) ** GOTO lbl95
                            ** GOTO lbl149
lbl94: // 3 sources:
                            var2_2 = -2;
lbl95: // 7 sources:
                            do {
                                if (var2_2 >= -1) return var2_2;
                                return CBORUtilities.ByteArrayCompare(this.EncodeToBytes(), var1_1.EncodeToBytes());
                                break;
                            } while (true);
                        }
                        case 2: {
                            var14_26 = (byte[])var5_5;
                            var15_27 = (byte[])var6_6;
                            if (var14_26 == null) {
                                if (var15_27 != null) return -1;
                                return 0;
                            }
                            if (var15_27 == null) {
                                return var2_2;
                            }
                            if (var14_26.length != var15_27.length) {
                                if (var14_26.length >= var15_27.length) return var2_2;
                                return -1;
                            }
                            var16_28 = 0;
                            while (var16_28 < var14_26.length) {
                                if (var14_26[var16_28] != var15_27[var16_28]) {
                                    if (var14_26[var16_28] >= var15_27[var16_28]) return var2_2;
                                    return -1;
                                }
                                ++var16_28;
                            }
                            return 0;
                        }
                        case 1: {
                            return CBORUtilities.ByteArrayCompare(this.EncodeToBytes(), var1_1.EncodeToBytes());
                        }
                        case 0: {
                            var7_29 = (Long)var5_5;
                            var9_30 = (Long)var6_6;
                            var11_31 = var7_29 LCMP 0L;
                            if (var11_31 >= 0 && var9_30 >= 0L) {
                                var13_32 = var7_29 LCMP var9_30;
                                if (var13_32 == false) {
                                    return 0;
                                }
                                if (var13_32 >= 0) return var2_2;
                                return -1;
                            }
                            if (var11_31 <= 0 && var9_30 <= 0L) {
                                var12_33 = var7_29 LCMP var9_30;
                                if (var12_33 == false) {
                                    return 0;
                                }
                                if (var12_33 >= 0) return -1;
                                return var2_2;
                            }
                            if (var11_31 >= 0) return -1;
                            if (var9_30 < 0L) return -1;
                            return var2_2;
                        }
                    }
                }
                if (var4_4 == 0) {
                    if (var3_3 == var2_2) return CBORUtilities.ByteArrayCompare(this.EncodeToBytes(), var1_1.EncodeToBytes());
                }
                if (var3_3 == 0 && var4_4 == var2_2) {
                    return CBORUtilities.ByteArrayCompare(this.EncodeToBytes(), var1_1.EncodeToBytes());
                }
                if (var3_3 >= var4_4) return var2_2;
                return -1;
            }
            for (var21_25 = 0; var21_25 < var17_21.length(); ++var21_25) {
                if (var17_21.charAt(var21_25) == var18_22.charAt(var21_25)) continue;
                if (var17_21.charAt(var21_25) >= var18_22.charAt(var21_25)) ** GOTO lbl95
lbl149: // 4 sources:
                var2_2 = -1;
                ** GOTO lbl95
            }
        }
        var2_2 = 0;
        ** while (true)
    }

    public boolean equals(CBORObject cBORObject) {
        boolean bl;
        block36 : {
            block37 : {
                byte[] arrby;
                byte[] arrby2;
                block35 : {
                    block26 : {
                        block27 : {
                            block28 : {
                                boolean bl2;
                                block25 : {
                                    block34 : {
                                        Map map;
                                        Map<CBORObject, CBORObject> map2;
                                        block33 : {
                                            block29 : {
                                                boolean bl3;
                                                block30 : {
                                                    block32 : {
                                                        Object object;
                                                        Object object2;
                                                        block31 : {
                                                            if (!(cBORObject instanceof CBORObject)) {
                                                                cBORObject = null;
                                                            }
                                                            if (cBORObject == null) {
                                                                return false;
                                                            }
                                                            if (this == cBORObject) {
                                                                return true;
                                                            }
                                                            int n2 = this.itemtypeValue;
                                                            if (n2 != cBORObject.itemtypeValue) {
                                                                return false;
                                                            }
                                                            if (n2 == 2) break block26;
                                                            if (n2 == 8) break block27;
                                                            if (n2 == 4) break block28;
                                                            if (n2 == 5) break block29;
                                                            if (n2 != 6) {
                                                                boolean bl4;
                                                                Object object3 = this.itemValue;
                                                                Object object4 = cBORObject.itemValue;
                                                                if (object3 == null) {
                                                                    bl4 = false;
                                                                    if (object4 == null) {
                                                                        return true;
                                                                    }
                                                                } else {
                                                                    bl4 = object3.equals(object4);
                                                                }
                                                                return bl4;
                                                            }
                                                            int n3 = this.tagLow;
                                                            int n4 = cBORObject.tagLow;
                                                            bl3 = false;
                                                            if (n3 != n4) break block30;
                                                            int n5 = this.tagHigh;
                                                            int n6 = cBORObject.tagHigh;
                                                            bl3 = false;
                                                            if (n5 != n6) break block30;
                                                            object = this.itemValue;
                                                            object2 = cBORObject.itemValue;
                                                            if (object != null) break block31;
                                                            bl3 = false;
                                                            if (object2 != null) break block30;
                                                            break block32;
                                                        }
                                                        boolean bl5 = object.equals(object2);
                                                        bl3 = false;
                                                        if (!bl5) break block30;
                                                    }
                                                    bl3 = true;
                                                }
                                                return bl3;
                                            }
                                            Object object = cBORObject.itemValue;
                                            boolean bl6 = object instanceof Map;
                                            map = null;
                                            if (bl6) {
                                                map = (Map)object;
                                            }
                                            if ((map2 = this.AsMap()) != null) break block33;
                                            bl2 = false;
                                            if (map != null) break block25;
                                            break block34;
                                        }
                                        if (map == null) {
                                            return false;
                                        }
                                        if (map2.size() != map.size()) {
                                            return false;
                                        }
                                        for (Map.Entry entry : map2.entrySet()) {
                                            CBORObject cBORObject2 = (CBORObject)map.get(entry.getKey());
                                            boolean bl7 = cBORObject2 == null ? map.containsKey(entry.getKey()) : true;
                                            bl2 = false;
                                            if (!bl7) break block25;
                                            CBORObject cBORObject3 = (CBORObject)entry.getValue();
                                            if (cBORObject3 == null) {
                                                bl2 = false;
                                                if (cBORObject2 == null) {
                                                    continue;
                                                }
                                                break block25;
                                            }
                                            if (cBORObject3.equals(cBORObject2)) continue;
                                            return false;
                                        }
                                    }
                                    bl2 = true;
                                }
                                return bl2;
                            }
                            List<CBORObject> list = this.AsList();
                            Object object = cBORObject.itemValue;
                            boolean bl8 = object instanceof List;
                            List list2 = null;
                            if (bl8) {
                                list2 = (List)object;
                            }
                            return CBORObject.CBORArrayEquals(list, (List<CBORObject>)list2);
                        }
                        long l2 = this.AsDoubleBits() LCMP cBORObject.AsDoubleBits();
                        boolean bl9 = false;
                        if (l2 == false) {
                            bl9 = true;
                        }
                        return bl9;
                    }
                    arrby2 = (byte[])this.itemValue;
                    Object object = cBORObject.itemValue;
                    boolean bl10 = object instanceof byte[];
                    arrby = null;
                    if (bl10) {
                        arrby = (byte[])object;
                    }
                    if (arrby2 != null) break block35;
                    bl = false;
                    if (arrby != null) break block36;
                    break block37;
                }
                if (arrby == null) {
                    return false;
                }
                if (arrby2.length != arrby.length) {
                    return false;
                }
                for (int i2 = 0; i2 < arrby2.length; ++i2) {
                    if (arrby2[i2] == arrby[i2]) continue;
                    return false;
                }
            }
            bl = true;
        }
        return bl;
    }

    public boolean equals(Object object) {
        CBORObject cBORObject = object instanceof CBORObject ? (CBORObject)object : null;
        return this.equals(cBORObject);
    }

    public CBORObject get(int n2) {
        if (this.getItemType() == 4) {
            List<CBORObject> list = this.AsList();
            if (n2 >= 0 && n2 < list.size()) {
                return (CBORObject)list.get(n2);
            }
            throw new IllegalArgumentException("index");
        }
        if (this.getItemType() == 5) {
            CBORObject cBORObject;
            Map<CBORObject, CBORObject> map = this.AsMap();
            if (!map.containsKey((Object)(cBORObject = CBORObject.FromObject(n2)))) {
                return null;
            }
            return (CBORObject)map.get((Object)cBORObject);
        }
        throw new IllegalStateException("Not an array or map");
    }

    public CBORObject get(CBORObject cBORObject) {
        Objects.requireNonNull((Object)cBORObject, (String)"key");
        if (this.getItemType() == 5) {
            Map<CBORObject, CBORObject> map = this.AsMap();
            if (!map.containsKey((Object)cBORObject)) {
                return null;
            }
            return (CBORObject)map.get((Object)cBORObject);
        }
        if (this.getItemType() == 4) {
            if (cBORObject.isIntegral()) {
                if (cBORObject.CanTruncatedIntFitInInt32()) {
                    List<CBORObject> list = this.AsList();
                    int n2 = cBORObject.AsInt32();
                    if (n2 >= 0 && n2 < list.size()) {
                        return (CBORObject)list.get(n2);
                    }
                    throw new IllegalArgumentException("key");
                }
                throw new IllegalArgumentException("key");
            }
            throw new IllegalArgumentException("Not an integer");
        }
        throw new IllegalStateException("Not an array or map");
    }

    public final int getItemType() {
        int n2;
        CBORObject cBORObject = this;
        while ((n2 = cBORObject.itemtypeValue) == 6) {
            cBORObject = (CBORObject)cBORObject.itemValue;
        }
        return n2;
    }

    public final EInteger getMostOuterTag() {
        int n2;
        if (!this.isTagged()) {
            return EInteger.FromInt32((int)-1);
        }
        int n3 = this.tagHigh;
        if (n3 == 0 && (n2 = this.tagLow) >= 0 && n2 < 65536) {
            return EInteger.FromInt32((int)n2);
        }
        return CBORObject.LowHighToEInteger(this.tagLow, n3);
    }

    public final Object getThisItem() {
        CBORObject cBORObject = this;
        while (cBORObject.itemtypeValue == 6) {
            cBORObject = (CBORObject)cBORObject.itemValue;
        }
        return cBORObject.itemValue;
    }

    public final CBORType getType() {
        switch (this.getItemType()) {
            default: {
                throw new IllegalStateException("Unexpected data type");
            }
            case 8: {
                return CBORType.FloatingPoint;
            }
            case 7: {
                if ((Integer)this.getThisItem() != 21 && (Integer)this.getThisItem() != 20) {
                    return CBORType.SimpleValue;
                }
                return CBORType.Boolean;
            }
            case 5: {
                return CBORType.Map;
            }
            case 4: {
                return CBORType.Array;
            }
            case 3: {
                return CBORType.TextString;
            }
            case 2: {
                return CBORType.ByteString;
            }
            case 0: 
            case 1: 
        }
        return CBORType.Integer;
    }

    public int hashCode() {
        int n2;
        block12 : {
            int n3;
            block14 : {
                long l2;
                block15 : {
                    Object object;
                    block13 : {
                        int n4;
                        object = this.itemValue;
                        n2 = 651869431;
                        if (object == null) break block12;
                        int n5 = this.itemtypeValue;
                        if (n5 == 0) break block13;
                        switch (n5) {
                            int n6;
                            default: {
                                n3 = object.hashCode();
                                break block14;
                            }
                            case 8: {
                                l2 = this.AsDoubleBits();
                                break block15;
                            }
                            case 7: {
                                n3 = (Integer)object;
                                break block14;
                            }
                            case 6: {
                                n3 = this.tagLow + this.tagHigh + 651869483 * object.hashCode();
                                break block14;
                            }
                            case 5: {
                                n3 = 19 * this.AsMap().size();
                                break block14;
                            }
                            case 4: {
                                n3 = CBORObject.CBORArrayHashCode(this.AsList());
                                break block14;
                            }
                            case 3: {
                                String string = (String)object;
                                int n7 = string.length();
                                int n8 = n7 + 589;
                                for (n6 = 0; n6 < n7; ++n6) {
                                    n8 = n8 * 31 + string.charAt(n6);
                                }
                                n4 = n8;
                                break;
                            }
                            case 2: {
                                byte[] arrby = (byte[])this.getThisItem();
                                if (arrby == null) {
                                    n4 = 0;
                                    break;
                                }
                                int n9 = 589 + arrby.length;
                                while (n6 < arrby.length) {
                                    n9 = n9 * 31 + arrby[n6];
                                    ++n6;
                                }
                                n4 = n9;
                            }
                        }
                        n3 = n4;
                        break block14;
                    }
                    l2 = (Long)object;
                }
                n3 = (int)(l2 | l2 >> 32);
            }
            n2 += n3 * 651869479;
        }
        return n2;
    }

    public final boolean isFalse() {
        return this.getItemType() == 7 && (Integer)this.getThisItem() == 20;
    }

    public final boolean isIntegral() {
        CBORNumber cBORNumber = CBORNumber.FromCBORObject(this);
        return cBORNumber != null && cBORNumber.GetNumberInterface().IsIntegral(cBORNumber.value);
    }

    public final boolean isNull() {
        return this.getItemType() == 7 && (Integer)this.getThisItem() == 22;
    }

    public final boolean isTagged() {
        return this.itemtypeValue == 6;
    }

    public final boolean isTrue() {
        return this.getItemType() == 7 && (Integer)this.getThisItem() == 21;
    }

    public final boolean isUndefined() {
        return this.getItemType() == 7 && (Integer)this.getThisItem() == 23;
    }

    public void set(CBORObject cBORObject, CBORObject cBORObject2) {
        Objects.requireNonNull((Object)cBORObject, (String)"value");
        Objects.requireNonNull((Object)cBORObject2, (String)"value");
        if (this.getItemType() == 5) {
            this.AsMap().put((Object)cBORObject, (Object)cBORObject2);
            return;
        }
        if (this.getItemType() == 4) {
            if (cBORObject.isIntegral()) {
                if (cBORObject.CanTruncatedIntFitInInt32()) {
                    List<CBORObject> list = this.AsList();
                    int n2 = cBORObject.AsInt32();
                    if (n2 >= 0 && n2 < list.size()) {
                        list.set(n2, (Object)cBORObject2);
                        return;
                    }
                    throw new IllegalArgumentException("key");
                }
                throw new IllegalArgumentException("key");
            }
            throw new IllegalArgumentException("Not an integer");
        }
        throw new IllegalStateException("Not an array or map");
    }

    public final int size() {
        if (this.getItemType() == 4) {
            return this.AsList().size();
        }
        if (this.getItemType() == 5) {
            return this.AsMap().size();
        }
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder;
        block40 : {
            CBORType cBORType = this.getType();
            if (this.isTagged()) {
                stringBuilder = cBORType == CBORType.TextString ? new StringBuilder(16 + Math.min((int)this.AsString().length(), (int)4096)) : new StringBuilder();
                CBORObject cBORObject = this;
                while (cBORObject.isTagged()) {
                    int n2 = cBORObject.tagLow;
                    int n3 = cBORObject.tagHigh;
                    if (n3 == 0 && n2 >> 16 == 0) {
                        stringBuilder.append(CBORUtilities.LongToString(n2));
                    } else {
                        stringBuilder.append(CBORObject.LowHighToEInteger(n2, n3).toString());
                    }
                    stringBuilder.append('(');
                    cBORObject = (CBORObject)cBORObject.itemValue;
                }
            } else {
                stringBuilder = null;
            }
            int n4 = cBORType.ordinal();
            boolean bl = true;
            int n5 = 0;
            switch (n4) {
                default: {
                    if (stringBuilder != null) break;
                    return this.getThisItem().toString();
                }
                case 8: {
                    double d2 = this.AsDoubleValue();
                    String string = d2 == Double.NEGATIVE_INFINITY ? "-Infinity" : (d2 == Double.POSITIVE_INFINITY ? "Infinity" : (Double.isNaN((double)d2) ? "NaN" : CBORUtilities.TrimDotZero(CBORUtilities.DoubleToString(d2))));
                    if (stringBuilder == null) {
                        return string;
                    }
                    stringBuilder.append(string);
                    break block40;
                }
                case 7: {
                    String string = this.CanValueFitInInt64() ? CBORUtilities.LongToString(this.AsInt64Value()) : this.AsEIntegerValue().toString();
                    if (stringBuilder == null) {
                        return string;
                    }
                    stringBuilder.append(string);
                    break block40;
                }
                case 6: {
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder();
                    }
                    stringBuilder.append("{");
                    for (Map.Entry entry : this.AsMap().entrySet()) {
                        CBORObject cBORObject = (CBORObject)entry.getKey();
                        CBORObject cBORObject2 = (CBORObject)entry.getValue();
                        if (!bl) {
                            stringBuilder.append(", ");
                        }
                        stringBuilder.append(cBORObject.toString());
                        stringBuilder.append(": ");
                        stringBuilder.append(cBORObject2.toString());
                        bl = false;
                    }
                    stringBuilder.append("}");
                    break block40;
                }
                case 5: {
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder();
                    }
                    stringBuilder.append("[");
                    for (CBORObject cBORObject : this.AsList()) {
                        if (!bl) {
                            stringBuilder.append(", ");
                        }
                        stringBuilder.append(cBORObject.toString());
                        bl = false;
                    }
                    stringBuilder.append("]");
                    break block40;
                }
                case 4: {
                    if (stringBuilder == null) {
                        StringBuilder stringBuilder2 = GeneratedOutlineSupport.outline24((String)"\"");
                        stringBuilder2.append(this.AsString());
                        stringBuilder2.append("\"");
                        return stringBuilder2.toString();
                    }
                    stringBuilder.append('\"');
                    stringBuilder.append(this.AsString());
                    stringBuilder.append('\"');
                    break block40;
                }
                case 3: {
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder();
                    }
                    stringBuilder.append("h'");
                    byte[] arrby = (byte[])this.getThisItem();
                    Objects.requireNonNull((Object)arrby, (String)"data");
                    int n6 = arrby.length;
                    while (n5 < n6) {
                        stringBuilder.append("0123456789ABCDEF".charAt(15 & arrby[n5] >> 4));
                        stringBuilder.append("0123456789ABCDEF".charAt(15 & arrby[n5]));
                        ++n5;
                    }
                    stringBuilder.append("'");
                    break block40;
                }
                case 1: 
                case 2: {
                    if (this.isTrue()) {
                        if (stringBuilder == null) {
                            return "true";
                        }
                        stringBuilder.append("true");
                    } else if (this.isFalse()) {
                        if (stringBuilder == null) {
                            return "false";
                        }
                        stringBuilder.append("false");
                    } else if (this.isNull()) {
                        if (stringBuilder == null) {
                            return "null";
                        }
                        stringBuilder.append("null");
                    } else if (this.isUndefined()) {
                        if (stringBuilder == null) {
                            return "undefined";
                        }
                        stringBuilder.append("undefined");
                    } else {
                        if (stringBuilder == null) {
                            stringBuilder = new StringBuilder();
                        }
                        stringBuilder.append("simple(");
                        stringBuilder.append(CBORUtilities.LongToString(((Integer)this.getThisItem()).intValue()));
                        stringBuilder.append(")");
                    }
                    break block40;
                }
            }
            stringBuilder.append(this.getThisItem().toString());
        }
        if (this.isTagged()) {
            CBORObject cBORObject = this;
            while (cBORObject.isTagged()) {
                stringBuilder.append(')');
                cBORObject = (CBORObject)cBORObject.itemValue;
            }
        }
        return stringBuilder.toString();
    }
}

