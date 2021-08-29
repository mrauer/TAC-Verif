/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  com.scandit.datacapture.core.internal.module.source.k
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.source;

import android.annotation.TargetApi;
import com.scandit.datacapture.core.internal.module.source.k;
import kotlin.jvm.internal.Intrinsics;

@TargetApi(value=21)
public final class o {
    public static final int[] k = new int[]{-1, -2, -1, 0, 0, 0, 1, 2, 1};
    public static final int[] l = new int[]{-1, 0, 1, -2, 0, 2, -1, 0, 1};
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;

    public o(k k2) {
        Intrinsics.checkNotNullParameter((Object)k2, (String)"delegate");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final boolean a(byte[] var1_1, int var2_2, int var3_3) {
        block14 : {
            block12 : {
                block10 : {
                    block13 : {
                        block11 : {
                            Intrinsics.checkNotNullParameter((Object)var1_1, (String)"yBuffer");
                            var4_4 = var2_2 - 1;
                            var5_5 = var3_3 - 1;
                            var7_7 = 0;
                            for (var6_6 = 1; var6_6 < var4_4; ++var6_6) {
                                var24_8 = 1;
                                while (var24_8 < var5_5) {
                                    var25_9 = var24_8 - 1;
                                    var26_10 = var6_6 - 1;
                                    var27_11 = var24_8 + 1;
                                    var28_12 = var6_6 + 1;
                                    var29_13 = var25_9 * var2_2;
                                    var30_14 = 255 & 128 + var1_1[var29_13 + var26_10];
                                    var31_15 = 255 & 128 + var1_1[var29_13 + var6_6];
                                    var32_16 = 255 & 128 + var1_1[var29_13 + var28_12];
                                    var33_17 = var24_8 * var2_2;
                                    var34_18 = 255 & 128 + var1_1[var33_17 + var26_10];
                                    var35_19 = 255 & 128 + var1_1[var33_17 + var6_6];
                                    var36_20 = 255 & 128 + var1_1[var33_17 + var28_12];
                                    var37_21 = var2_2 * var27_11;
                                    var38_22 = 255 & 128 + var1_1[var37_21 + var26_10];
                                    var39_23 = 255 & 128 + var1_1[var37_21 + var6_6];
                                    var40_24 = 255 & 128 + var1_1[var37_21 + var28_12];
                                    var41_25 = o.k;
                                    var42_26 = var30_14 * var41_25[0] + var31_15 * var41_25[1] + var32_16 * var41_25[2] + var34_18 * var41_25[3] + var35_19 * var41_25[4] + var36_20 * var41_25[5] + var38_22 * var41_25[6] + var39_23 * var41_25[7] + var40_24 * var41_25[8];
                                    var43_27 = o.l;
                                    var44_28 = var30_14 * var43_27[0] + var31_15 * var43_27[1] + var32_16 * var43_27[2] + var34_18 * var43_27[3] + var35_19 * var43_27[4] + var36_20 * var43_27[5] + var38_22 * var43_27[6] + var39_23 * var43_27[7] + var40_24 * var43_27[8];
                                    var7_7 += (int)(0.5f + (float)Math.sqrt((double)(var42_26 * var42_26 + var44_28 * var44_28)));
                                    var24_8 = var27_11;
                                }
                            }
                            var8_29 = (int)(0.5 + (double)(var7_7 / (var4_4 * var5_5)));
                            this.a = var9_30 = (int)(0.5 + (double)((var8_29 + 9 * this.a) / 10));
                            var10_31 = this.c > 3 ? Math.abs((int)(var9_30 - var8_29)) * Math.abs((int)(this.b - var8_29)) : 0;
                            this.b = var8_29;
                            this.e = var11_32 = (int)(0.5 + (double)((var10_31 + 3 * this.e) / 4));
                            var12_33 = Math.abs((int)(var11_32 - var10_31));
                            var13_34 = Math.abs((int)(var10_31 - this.f));
                            var14_35 = 0.0f;
                            if (var13_34 > 0) {
                                var14_35 = (float)var12_33 / (float)var13_34;
                            }
                            var16_37 = (var15_36 = this.c) > 3;
                            var17_38 = this.g;
                            if (var17_38 <= 0) ** GOTO lbl49
                            if (var15_36 < var17_38 + 12) {
                                var18_39 = false;
                            } else {
                                this.g = 0;
lbl49: // 2 sources:
                                var18_39 = var16_37;
                            }
                            if (!var18_39) break block10;
                            var21_40 = this.f;
                            if (var10_31 < var21_40 && this.d == var15_36 - 1) {
                                var23_41 = this.h;
                                if (var23_41 == 0 && var14_35 > 0.6f) {
                                    ++var23_41;
                                }
                                this.h = var23_41;
                                this.h = var23_41 + 1;
                            } else {
                                this.h = 0;
                            }
                            if (this.h > 2) break block11;
                            var22_42 = this.i;
                            var19_43 = false;
                            if (!var22_42) break block12;
                        }
                        var19_43 = false;
                        if (var10_31 >= 50) break block12;
                        this.h = 0;
                        if (!this.i) break block13;
                        var19_43 = false;
                        if (var10_31 < 70) {
                            var19_43 = false;
                            if (var21_40 > 40) {
                                this.i = false;
                                this.g = var15_36;
                                var19_43 = true;
                            }
                        }
                        break block12;
                    }
                    var20_44 = 1;
                    this.i = var20_44;
                    var19_43 = false;
                    break block14;
                }
                var19_43 = false;
            }
            var20_44 = 1;
        }
        this.d = var15_36;
        this.f = var10_31;
        this.c = var15_36 + var20_44;
        return var19_43;
    }
}

