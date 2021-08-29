/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Member
 *  java.lang.reflect.Method
 *  java.lang.reflect.Type
 *  java.util.AbstractMap
 *  java.util.AbstractMap$SimpleEntry
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 */
package com.upokecenter.cbor;

import com.upokecenter.cbor.CBORException;
import com.upokecenter.cbor.CBORUtilities;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PropertyMap {
    public static Map<Class<?>, List<MethodData>> propertyLists = new HashMap();
    public static Map<Class<?>, List<MethodData>> setterPropertyList = new HashMap();

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static Iterable<Map.Entry<String, Object>> GetProperties(Object var0, boolean var1_1) {
        block44 : {
            block41 : {
                block43 : {
                    block42 : {
                        block40 : {
                            var2_2 = new ArrayList();
                            var3_3 = var0.getClass();
                            var4_4 = var3_3.getName();
                            var5_5 = var4_4.startsWith("java.");
                            var6_6 = 1;
                            if (!var5_5 && !var4_4.startsWith("javax.") && !var4_4.startsWith("com.sun.")) break block42;
                            var7_7 = var3_3.getInterfaces();
                            var8_8 = var7_7.length;
                            for (var9_9 = 0; var9_9 < var8_8; ++var9_9) {
                                if (!var7_7[var9_9].equals(Serializable.class)) continue;
                                var10_10 = true;
                                break block40;
                            }
                            var10_10 = false;
                        }
                        if (!var10_10) ** GOTO lbl-1000
                    }
                    if (!(Type.class.isAssignableFrom(var3_3) || Method.class.isAssignableFrom(var3_3) || Field.class.isAssignableFrom(var3_3) || Constructor.class.isAssignableFrom(var3_3) || var4_4.startsWith("org.springframework.") || var4_4.startsWith("java.io.") || var4_4.startsWith("java.lang.annotation.") || var4_4.startsWith("java.security.SignedObject") || var4_4.startsWith("com.sun.rowset") || var4_4.startsWith("com.sun.org.apache.") || var4_4.startsWith("org.apache.xalan.") || var4_4.startsWith("org.apache.xpath.") || var4_4.startsWith("org.codehaus.groovy.") || var4_4.startsWith("com.sun.jndi.") || var4_4.startsWith("groovy.util.Expando") || var4_4.startsWith("java.util.logging.") || var4_4.startsWith("com.mchange.v2.c3p0."))) {
                        var11_11 = false;
                    } else lbl-1000: // 2 sources:
                    {
                        var11_11 = true;
                    }
                    if (var11_11) {
                        return var2_2;
                    }
                    var12_12 = var0.getClass();
                    var76_14 = var13_13 = PropertyMap.propertyLists;
                    // MONITORENTER : var76_14
                    var15_15 = (List)PropertyMap.propertyLists.get((Object)var12_12);
                    if (var15_15 == null) break block43;
                    // MONITOREXIT : var76_14
                    var16_16 = var2_2;
                    break block44;
                }
                var15_15 = new ArrayList();
                var28_17 = new ArrayList();
                var29_18 = new ArrayList();
                var30_19 = new ArrayList();
                var31_20 = new HashMap();
                var32_21 = new HashMap();
                var33_22 = new HashMap();
                var34_23 = var12_12.getMethods();
                var35_24 = var34_23.length;
                var36_25 = 0;
                do {
                    block48 : {
                        block46 : {
                            block45 : {
                                block47 : {
                                    if (var36_25 >= var35_24) break block45;
                                    var37_26 = var34_23[var36_25];
                                    var38_27 = var37_26.getModifiers();
                                    var39_28 = var34_23;
                                    var40_29 = var38_27 & 9;
                                    var41_30 = var35_24;
                                    if (var40_29 != 1) break block46;
                                    var42_31 = var37_26.getName();
                                    var43_32 = MethodData.RemoveGetSetIs(var42_31);
                                    if (!MethodData.IsGetMethod(var42_31)) break block47;
                                    if (var37_26.getParameterTypes().length != 0) break block46;
                                    var51_34 = var37_26.getReturnType();
                                    var44_33 = var2_2;
                                    if (!var51_34.equals((Object)Void.TYPE)) {
                                        if (var31_20.containsKey((Object)var43_32)) {
                                            var31_20.put((Object)var43_32, (Object)(1 + (Integer)var31_20.get((Object)var43_32)));
                                        } else {
                                            var31_20.put((Object)var43_32, (Object)var6_6);
                                        }
                                        var28_17.add((Object)var37_26);
                                    }
                                    break block48;
                                }
                                var44_33 = var2_2;
                                if (MethodData.IsIsMethod(var42_31)) {
                                    if (var37_26.getParameterTypes().length == 0 && !var37_26.getReturnType().equals((Object)Void.TYPE)) {
                                        if (var31_20.containsKey((Object)var43_32)) {
                                            var31_20.put((Object)var43_32, (Object)(1 + (Integer)var31_20.get((Object)var43_32)));
                                        } else {
                                            var31_20.put((Object)var43_32, (Object)var6_6);
                                        }
                                        var30_19.add((Object)var37_26);
                                    }
                                } else if (MethodData.IsSetMethod(var42_31) && var37_26.getParameterTypes().length == 1 && var37_26.getReturnType().equals((Object)Void.TYPE)) {
                                    if (var32_21.containsKey((Object)var43_32)) {
                                        var32_21.put((Object)var43_32, (Object)(1 + (Integer)var32_21.get((Object)var43_32)));
                                    } else {
                                        var32_21.put((Object)var43_32, (Object)var6_6);
                                    }
                                    var29_18.add((Object)var37_26);
                                }
                                break block48;
                            }
                            var16_16 = var2_2;
                            var55_35 = var28_17.iterator();
                            break;
                        }
                        var44_33 = var2_2;
                    }
                    ++var36_25;
                    var35_24 = var41_30;
                    var34_23 = var39_28;
                    var2_2 = var44_33;
                } while (true);
                while (var55_35.hasNext()) {
                    var74_36 = (Method)var55_35.next();
                    if ((Integer)var31_20.get((Object)MethodData.RemoveGetSetIs(var74_36.getName())) > 1) continue;
                    var15_15.add((Object)new MethodData(var74_36.getName(), (Member)var74_36));
                }
                for (Method var72_38 : var30_19) {
                    if ((Integer)var31_20.get((Object)MethodData.RemoveGetSetIs(var72_38.getName())) > 1) continue;
                    var15_15.add((Object)new MethodData(var72_38.getName(), (Member)var72_38));
                }
                var57_39 = var12_12.getFields();
                var58_40 = var57_39.length;
                var59_41 = 0;
                do {
                    block50 : {
                        block49 : {
                            block51 : {
                                if (var59_41 >= var58_40) break block49;
                                var60_42 = var57_39[var59_41];
                                if ((25 & var60_42.getModifiers()) != 1) break block50;
                                var61_43 = var60_42.getName();
                                if (MethodData.IsIsMethod(var61_43)) {
                                    var61_43 = var61_43.substring(2);
                                }
                                if (var31_20.containsKey((Object)var61_43) || var32_21.containsKey((Object)var61_43)) break block51;
                                var15_15.add((Object)new MethodData(var60_42.getName(), (Member)var60_42));
                                break block50;
                            }
                            var62_44 = var33_22.containsKey((Object)var61_43) != false ? (Integer)var33_22.get((Object)var61_43) : -1;
                            if (var62_44 < 0) break block50;
                            var15_15.set(var62_44, null);
                            break block50;
                        }
                        var65_45 = var15_15.iterator();
                        while (var65_45.hasNext()) {
                            if (var65_45.next() != null) continue;
                            var66_46 = true;
                            break block41;
                        }
                        break;
                    }
                    ++var59_41;
                } while (true);
                var66_46 = false;
            }
            if (var66_46) {
                var67_47 = new ArrayList();
                for (Object var70_49 : var15_15) {
                    if (var70_49 == null) continue;
                    var67_47.add(var70_49);
                }
                var15_15 = var67_47;
            }
            PropertyMap.propertyLists.put((Object)var12_12, (Object)var15_15);
            // MONITOREXIT : var76_14
        }
        var17_50 = var15_15.iterator();
        while (var17_50.hasNext() != false) {
            var18_51 = (MethodData)var17_50.next();
            if (var18_51.method instanceof Field) {
                if (var1_1) {
                    var27_57 = var18_51.name;
                    if (MethodData.IsIsMethod(var27_57)) {
                        var27_57 = var27_57.substring(2);
                    }
                    var20_53 = CBORUtilities.FirstCharLower(var27_57);
                } else {
                    var20_53 = CBORUtilities.FirstCharUpper(var18_51.name);
                }
            } else if (var1_1) {
                var20_53 = CBORUtilities.FirstCharLower(MethodData.RemoveGetSetIs(var18_51.name));
            } else {
                var19_52 = var18_51.name;
                if (MethodData.IsSetMethod(var19_52)) {
                    var19_52 = var19_52.substring(3);
                } else if (MethodData.IsGetMethod(var19_52)) {
                    var19_52 = var19_52.substring(3);
                }
                var20_53 = CBORUtilities.FirstCharUpper(var19_52);
            }
            var23_54 = var18_51.method;
            var24_55 = var23_54 instanceof Method != false ? ((Method)var23_54).invoke(var0, new Object[0]) : (var23_54 instanceof Field != false ? ((Field)var23_54).get(var0) : null);
            var25_56 = new AbstractMap.SimpleEntry((Object)var20_53, var24_55);
            var16_16.add((Object)var25_56);
        }
        return var16_16;
        catch (IllegalAccessException var22_58) {
            throw (RuntimeException)new CBORException("").initCause((Throwable)var22_58);
        }
        catch (InvocationTargetException var21_59) {
            throw (RuntimeException)new CBORException("").initCause((Throwable)var21_59);
        }
    }

    public static class MethodData {
        public Member method;
        public String name;

        public MethodData(String string, Member member) {
            this.name = string;
            this.method = member;
        }

        public static boolean IsGetMethod(String string) {
            return CBORUtilities.NameStartsWithWord(string, "get") && !string.equals((Object)"getClass");
        }

        public static boolean IsIsMethod(String string) {
            return CBORUtilities.NameStartsWithWord(string, "is");
        }

        public static boolean IsSetMethod(String string) {
            return CBORUtilities.NameStartsWithWord(string, "set");
        }

        public static String RemoveGetSetIs(String string) {
            if (MethodData.IsSetMethod(string)) {
                return string.substring(3);
            }
            if (MethodData.IsGetMethod(string)) {
                return string.substring(3);
            }
            if (MethodData.IsIsMethod(string)) {
                string = string.substring(2);
            }
            return string;
        }
    }

}

