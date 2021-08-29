/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Map
 */
package com.upokecenter.cbor;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class OptionsParser {
    public final Map<String, String> dict;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public OptionsParser(String var1_1) {
        block9 : {
            super();
            this.dict = new HashMap();
            if (var1_1.length() <= 0) return;
            if (var1_1.length() != 0) break block9;
            var2_2 = new String[]{""};
            ** GOTO lbl20
        }
        var10_3 = null;
        var11_4 = 0;
        var12_5 = true;
        do {
            block10 : {
                if ((var13_6 = var1_1.indexOf(";", var11_4)) >= 0) break block10;
                if (var12_5) {
                    var2_2 = new String[]{var1_1};
                } else {
                    if (var10_3 == null) {
                        var10_3 = new ArrayList();
                    }
                    var10_3.add((Object)var1_1.substring(var11_4));
                    var2_2 = (String[])var10_3.toArray((Object[])new String[0]);
                }
lbl20: // 3 sources:
                var3_8 = var2_2.length;
                var4_9 = 0;
                while (var4_9 < var3_8) {
                    var5_10 = var2_2[var4_9];
                    var6_11 = var5_10.indexOf(61);
                    if (var6_11 < 0) throw new IllegalArgumentException(GeneratedOutlineSupport.outline18((String)"Invalid options String: ", (String)var1_1));
                    var7_12 = R.style.ToLowerCaseAscii((String)var5_10.substring(0, var6_11));
                    var8_13 = var5_10.substring(var6_11 + 1);
                    this.dict.put((Object)var7_12, (Object)var8_13);
                    ++var4_9;
                }
                return;
            }
            var14_7 = var1_1.substring(var11_4, var11_4 + (var13_6 - var11_4));
            if (var10_3 == null) {
                var10_3 = new ArrayList();
            }
            var10_3.add((Object)var14_7);
            var11_4 = var13_6 + 1;
            var12_5 = false;
        } while (true);
    }

    public boolean GetBoolean(String string, boolean bl) {
        String string2 = R.style.ToLowerCaseAscii((String)string);
        if (this.dict.containsKey((Object)string2)) {
            String string3 = R.style.ToLowerCaseAscii((String)((String)this.dict.get((Object)string2)));
            return string3.equals((Object)"1") || string3.equals((Object)"yes") || string3.equals((Object)"on") || string3.equals((Object)"true");
            {
            }
        }
        return bl;
    }
}

