/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.upokecenter.numbers.EInteger
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 */
package com.upokecenter.cbor;

import com.google.android.material.R;
import com.upokecenter.cbor.CBORException;
import com.upokecenter.cbor.CBORNumber;
import com.upokecenter.cbor.CBORObject;
import com.upokecenter.cbor.CBORType;
import com.upokecenter.cbor.JSONOptions;
import com.upokecenter.cbor.StringOutput;
import com.upokecenter.numbers.EInteger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class CBORJson {
    public static void WriteJSONStringUnquoted(String string, StringOutput stringOutput, JSONOptions jSONOptions) throws IOException {
        boolean bl = true;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 != '\\' && c2 != '\"') {
                if (c2 >= ' ' && (c2 < '' || c2 != '\u2028' && c2 != '\u2029' && (c2 < '' || c2 > '\u00a0') && c2 != '\ufeff' && c2 != '\ufffe' && c2 != '\uffff')) {
                    if ((c2 & 64512) == 55296 && (i2 >= string.length() - 1 || (64512 & string.charAt(i2 + 1)) != 56320)) {
                        Objects.requireNonNull((Object)jSONOptions);
                        throw new CBORException("Unpaired surrogate in String");
                    }
                    if (bl) continue;
                    if ((64512 & c2) == 55296) {
                        stringOutput.builder.append((CharSequence)string, i2, i2 + 2);
                        ++i2;
                        continue;
                    }
                    stringOutput.WriteCodePoint(c2);
                    continue;
                }
                if (bl) {
                    stringOutput.builder.append((CharSequence)string, 0, i2 + 0);
                    bl = false;
                }
                if (c2 == '\r') {
                    stringOutput.builder.append("\\r");
                    continue;
                }
                if (c2 == '\n') {
                    stringOutput.builder.append("\\n");
                    continue;
                }
                if (c2 == '\b') {
                    stringOutput.builder.append("\\b");
                    continue;
                }
                if (c2 == '\f') {
                    stringOutput.builder.append("\\f");
                    continue;
                }
                if (c2 == '\t') {
                    stringOutput.builder.append("\\t");
                    continue;
                }
                if (c2 == '\u0085') {
                    stringOutput.builder.append("\\u0085");
                    continue;
                }
                if (c2 >= '\u0100') {
                    stringOutput.builder.append("\\u");
                    stringOutput.WriteCodePoint("0123456789ABCDEF".charAt(15 & c2 >> 12));
                    stringOutput.WriteCodePoint("0123456789ABCDEF".charAt(15 & c2 >> 8));
                    stringOutput.WriteCodePoint("0123456789ABCDEF".charAt(15 & c2 >> 4));
                    stringOutput.WriteCodePoint("0123456789ABCDEF".charAt(c2 & 15));
                    continue;
                }
                stringOutput.builder.append("\\u00");
                stringOutput.WriteCodePoint("0123456789ABCDEF".charAt(c2 >> 4));
                stringOutput.WriteCodePoint("0123456789ABCDEF".charAt(c2 & 15));
                continue;
            }
            if (bl) {
                stringOutput.builder.append((CharSequence)string, 0, i2 + 0);
                bl = false;
            }
            stringOutput.WriteCodePoint(92);
            stringOutput.WriteCodePoint(c2);
        }
        if (bl) {
            stringOutput.builder.append(string);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static void WriteJSONToInternal(CBORObject var0, StringOutput var1_1, JSONOptions var2_2) throws IOException {
        block41 : {
            block40 : {
                var3_3 = CBORNumber.IsUntaggedInteger(var0);
                var4_4 = 1;
                if (var3_3 || !var0.isTagged() && var0.getType() == CBORType.FloatingPoint) ** GOTO lbl-1000
                if (var0.HasOneTag(2) || var0.HasOneTag(3)) ** GOTO lbl38
                if (var0.HasOneTag(4) || var0.HasOneTag(5) || var0.HasOneTag(264) || var0.HasOneTag(265) || var0.HasOneTag(268) || var0.HasOneTag(269)) ** GOTO lbl22
                if (!var0.HasOneTag(30) && !var0.HasOneTag(270)) break block40;
                var43_5 = var0.getMostOuterTag().ToInt32Checked();
                if (var0.getType() != CBORType.Array || (var43_5 != 270 ? var0.size() != 2 : var0.size() != 3 || CBORNumber.IsUntaggedInteger(var0.get(2)) == false)) break block40;
                if (!CBORNumber.IsUntaggedIntegerOrBignum(var0.get(0)) || !CBORNumber.IsUntaggedIntegerOrBignum(var0.get(var4_4)) || (var44_6 = CBORNumber.IntegerOrBignum(var0.get(var4_4))).signum() <= 0) break block40;
                if (var43_5 != 270) ** GOTO lbl-1000
                var45_7 = CBORNumber.IntegerOrBignum(var0.get(0));
                if (var45_7.signum() < 0 || !var0.get(2).CanValueFitInInt32()) break block40;
                block0 : switch (var0.get(2).AsInt32Value()) {
                    default: {
                        break;
                    }
                    case 4: 
                    case 5: 
                    case 6: 
                    case 7: {
                        if (var44_6.compareTo(var4_4) != 0) break;
                        ** GOTO lbl-1000
                    }
                    case 2: 
                    case 3: {
                        if (!var45_7.isZero() || var44_6.compareTo(var4_4) != 0) break;
                        ** GOTO lbl-1000
                    }
lbl22: // 1 sources:
                    var40_8 = var0.getMostOuterTag().ToInt32Checked();
                    if (var0.getType() != CBORType.Array || (var40_8 == 268 || var40_8 == 269 ? var0.size() != 3 || CBORNumber.IsUntaggedInteger(var0.get(2)) == false : var0.size() != 2)) break;
                    if ((var40_8 == 4 || var40_8 == 5 ? CBORNumber.IsUntaggedInteger(var0.get(0)) == false : CBORNumber.IsUntaggedIntegerOrBignum(var0.get(0)) == false) || !CBORNumber.IsUntaggedIntegerOrBignum(var0.get(var4_4))) break;
                    if (var40_8 != 268 && var40_8 != 269) ** GOTO lbl-1000
                    var41_9 = CBORNumber.IntegerOrBignum(var0.get(0));
                    var42_10 = CBORNumber.IntegerOrBignum(var0.get(var4_4));
                    if (var42_10.signum() < 0 || !var0.get(2).CanValueFitInInt32()) break;
                    switch (var0.get(2).AsInt32Value()) {
                        default: {
                            break block0;
                        }
                        case 4: 
                        case 5: 
                        case 6: 
                        case 7: {
                            var5_11 = var41_9.isZero() ? 1 : 0;
                            break block41;
                        }
                        case 2: 
                        case 3: {
                            if (!var41_9.isZero() || !var42_10.isZero()) break block0;
                            ** GOTO lbl39
                        }
lbl38: // 1 sources:
                        if (var0.getType() != CBORType.ByteString) break block0;
lbl39: // 3 sources:
                        case 0: 
                        case 1: lbl-1000: // 5 sources:
                        {
                            case 0: 
                            case 1: lbl-1000: // 3 sources:
                            {
                                var5_11 = var4_4;
                                break block41;
                            }
                        }
                    }
                }
            }
            var5_11 = 0;
        }
        if (var5_11 != 0) {
            var38_12 = CBORNumber.FromCBORObject(var0).ToJSONString();
            var1_1.builder.append(var38_12);
            return;
        }
        switch (var0.getType().ordinal()) {
            default: {
                throw new IllegalStateException("Unexpected item type");
            }
            case 7: 
            case 8: {
                var36_13 = CBORNumber.FromCBORObject(var0.Untag()).ToJSONString();
                var1_1.builder.append(var36_13);
                return;
            }
            case 6: {
                var17_14 = var0.AsMap();
                var18_15 = var17_14.entrySet().iterator();
                while (var18_15.hasNext()) {
                    var35_16 = (CBORObject)((Map.Entry)var18_15.next()).getKey();
                    if (var35_16.getType() == CBORType.TextString && !var35_16.isTagged()) continue;
                    var19_17 = var4_4;
                    ** GOTO lbl66
                }
                var19_17 = 0;
lbl66: // 2 sources:
                if (var19_17 == 0) {
                    var1_1.WriteCodePoint(123);
                    var31_18 = var17_14.entrySet().iterator();
                    do {
                        if (!var31_18.hasNext()) {
                            var1_1.WriteCodePoint(125);
                            return;
                        }
                        var32_19 = (Map.Entry)var31_18.next();
                        var33_20 = (CBORObject)var32_19.getKey();
                        var34_21 = (CBORObject)var32_19.getValue();
                        if (var4_4 == 0) {
                            var1_1.WriteCodePoint(44);
                        }
                        var1_1.WriteCodePoint(34);
                        CBORJson.WriteJSONStringUnquoted(var33_20.AsString(), var1_1, var2_2);
                        var1_1.WriteCodePoint(34);
                        var1_1.WriteCodePoint(58);
                        CBORJson.WriteJSONToInternal(var34_21, var1_1, var2_2);
                        var4_4 = 0;
                    } while (true);
                }
                var20_22 = new HashMap();
                for (Map.Entry var26_24 : var17_14.entrySet()) {
                    var27_25 = (CBORObject)var26_24.getKey();
                    var28_26 = (CBORObject)var26_24.getValue();
                    var29_27 = var27_25.getType() == CBORType.TextString ? var27_25.AsString() : var27_25.ToJSONString();
                    if (var20_22.containsKey((Object)var29_27) != false) throw new CBORException("Duplicate JSON String equivalents of map keys");
                    var20_22.put((Object)var29_27, (Object)var28_26);
                }
                var1_1.WriteCodePoint(123);
                var22_28 = var20_22.entrySet().iterator();
                do {
                    if (!var22_28.hasNext()) {
                        var1_1.WriteCodePoint(125);
                        return;
                    }
                    var23_29 = (Map.Entry)var22_28.next();
                    var24_30 = (String)var23_29.getKey();
                    var25_31 = (CBORObject)var23_29.getValue();
                    if (var4_4 == 0) {
                        var1_1.WriteCodePoint(44);
                    }
                    var1_1.WriteCodePoint(34);
                    CBORJson.WriteJSONStringUnquoted(var24_30, var1_1, var2_2);
                    var1_1.WriteCodePoint(34);
                    var1_1.WriteCodePoint(58);
                    CBORJson.WriteJSONToInternal(var25_31, var1_1, var2_2);
                    var4_4 = 0;
                } while (true);
            }
            case 5: {
                var1_1.WriteCodePoint(91);
                var15_32 = var0.AsList().iterator();
                do {
                    if (!var15_32.hasNext()) {
                        var1_1.WriteCodePoint(93);
                        return;
                    }
                    var16_33 = (CBORObject)var15_32.next();
                    if (var4_4 == 0) {
                        var1_1.WriteCodePoint(44);
                    }
                    CBORJson.WriteJSONToInternal(var16_33, var1_1, var2_2);
                    var4_4 = 0;
                } while (true);
            }
            case 4: {
                var13_34 = var0.AsString();
                if (var13_34.length() == 0) {
                    var1_1.builder.append("\"\"");
                    return;
                }
                var1_1.WriteCodePoint(34);
                CBORJson.WriteJSONStringUnquoted(var13_34, var1_1, var2_2);
                var1_1.WriteCodePoint(34);
                return;
            }
            case 3: {
                var9_35 = var0.GetByteString();
                if (var9_35.length == 0) {
                    var1_1.builder.append("\"\"");
                    return;
                }
                var1_1.WriteCodePoint(34);
                if (var0.HasTag(22)) {
                    R.style.WriteBase64((StringOutput)var1_1, (byte[])var9_35, (int)0, (int)var9_35.length, (boolean)true, (boolean)true);
                } else {
                    var10_36 = var0.HasTag(23);
                    if (var10_36) {
                        for (var11_37 = 0; var11_37 < var9_35.length; ++var11_37) {
                            var1_1.WriteCodePoint("0123456789ABCDEF".charAt(15 & var9_35[var11_37] >> 4));
                            var1_1.WriteCodePoint("0123456789ABCDEF".charAt(15 & var9_35[var11_37]));
                        }
                    } else {
                        R.style.WriteBase64((StringOutput)var1_1, (byte[])var9_35, (int)0, (int)var9_35.length, (boolean)false, (boolean)false);
                    }
                }
                var1_1.WriteCodePoint(34);
                return;
            }
            case 2: {
                var1_1.builder.append("null");
                return;
            }
            case 1: 
        }
        if (var0.isTrue()) {
            var1_1.builder.append("true");
            return;
        }
        if (var0.isFalse() == false) return;
        var1_1.builder.append("false");
    }
}

