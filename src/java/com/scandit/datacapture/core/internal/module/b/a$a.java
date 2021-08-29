/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.hardware.camera2.params.MeteringRectangle
 *  com.scandit.datacapture.core.ui.animation.SpringAnimation
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt__IndentKt
 */
package com.scandit.datacapture.core.internal.module.b;

import android.hardware.camera2.params.MeteringRectangle;
import com.scandit.datacapture.core.common.geometry.Point;
import com.scandit.datacapture.core.common.geometry.Rect;
import com.scandit.datacapture.core.common.geometry.Size2;
import com.scandit.datacapture.core.internal.module.b.a.a.b;
import com.scandit.datacapture.core.ui.animation.SpringAnimation;
import com.scandit.datacapture.core.ui.animation.SpringForce;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

public class a$a {
    public static /* synthetic */ MeteringRectangle a(Rect rect, android.graphics.Rect rect2) {
        int n2;
        int n3;
        int n4 = rect2.width();
        int n5 = rect2.height();
        float f2 = n4;
        Point point = rect.getOrigin();
        Intrinsics.checkNotNullExpressionValue((Object)point, (String)"origin");
        float f3 = f2 * point.getX();
        float f4 = n5;
        Point point2 = rect.getOrigin();
        Intrinsics.checkNotNullExpressionValue((Object)point2, (String)"origin");
        float f5 = f4 * point2.getY();
        Size2 size2 = rect.getSize();
        Intrinsics.checkNotNullExpressionValue((Object)size2, (String)"size");
        float f6 = f2 * size2.getWidth();
        Size2 size22 = rect.getSize();
        Intrinsics.checkNotNullExpressionValue((Object)size22, (String)"size");
        float f7 = f4 * size22.getHeight();
        int n6 = (int)f3;
        int n7 = (int)f5;
        int n8 = (int)f6;
        int n9 = (int)f7;
        if (n6 == 0) {
            --n8;
            n2 = 1;
        } else {
            n2 = n6;
        }
        if (n7 == 0) {
            --n9;
            n3 = 1;
        } else {
            n3 = n7;
        }
        if (n8 + n2 == rect2.width()) {
            --n8;
        }
        int n10 = n8;
        if (n9 + n3 == rect2.height()) {
            --n9;
        }
        int n11 = n9;
        MeteringRectangle meteringRectangle = new MeteringRectangle(n2, n3, n10, n11, 1000);
        return meteringRectangle;
    }

    public static void a(SpringAnimation springAnimation) {
        SpringForce springForce = new SpringForce();
        springForce.a = 1.0f;
        springForce.c = false;
        springForce.b = Math.sqrt((double)200.0f);
        springForce.c = false;
        springAnimation.f = springForce;
    }

    public static boolean a(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"normalizedModel");
        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
        if (!Intrinsics.areEqual((Object)string, (Object)"s31")) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"model");
            if (!Intrinsics.areEqual((Object)string, (Object)"s41")) {
                Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                if (!Intrinsics.areEqual((Object)string, (Object)"s48c")) {
                    Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                    if (!Intrinsics.areEqual((Object)string, (Object)"s50c")) {
                        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                        if (!Intrinsics.areEqual((Object)string, (Object)"s60")) {
                            Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                            if (!Intrinsics.areEqual((Object)string, (Object)"core-x3")) {
                                Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-a520", (boolean)false, (int)2)) {
                                    Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                    if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-a205", (boolean)false, (int)2)) {
                                        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                        if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-a705fn", (boolean)false, (int)2)) {
                                            Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                            boolean bl = StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-j3109", (boolean)false, (int)2) || StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-j320", (boolean)false, (int)2) || StringsKt__IndentKt.startsWith$default((String)string, (String)"samsung-sm-j32", (boolean)false, (int)2);
                                            if (!bl) {
                                                Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-j530", (boolean)false, (int)2)) {
                                                    Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                    if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-j737", (boolean)false, (int)2)) {
                                                        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                        if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-j337", (boolean)false, (int)2)) {
                                                            Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                            boolean bl2 = Intrinsics.areEqual((Object)string, (Object)"gt-i9500") || Intrinsics.areEqual((Object)string, (Object)"gt-i9502") || Intrinsics.areEqual((Object)string, (Object)"gt-i9505") || Intrinsics.areEqual((Object)string, (Object)"sc-04e") || Intrinsics.areEqual((Object)string, (Object)"sch-i545") || Intrinsics.areEqual((Object)string, (Object)"sch-i959") || Intrinsics.areEqual((Object)string, (Object)"sch-r970") || Intrinsics.areEqual((Object)string, (Object)"sgh-i337") || Intrinsics.areEqual((Object)string, (Object)"sgh-m919") || Intrinsics.areEqual((Object)string, (Object)"shv-e300k") || Intrinsics.areEqual((Object)string, (Object)"shv-e300s") || Intrinsics.areEqual((Object)string, (Object)"sph-l720");
                                                            if (!bl2) {
                                                                Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-g973f", (boolean)false, (int)2)) {
                                                                    Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                    if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-t395", (boolean)false, (int)2)) {
                                                                        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                        if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-t54", (boolean)false, (int)2)) {
                                                                            Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                            if (!Intrinsics.areEqual((Object)string, (Object)"ct60")) {
                                                                                Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                boolean bl3 = StringsKt__IndentKt.startsWith$default((String)string, (String)"huawei gra-", (boolean)false, (int)2) || StringsKt__IndentKt.startsWith$default((String)string, (String)"ale-", (boolean)false, (int)2);
                                                                                if (!bl3) {
                                                                                    Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                    if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"huawei vns-l", (boolean)false, (int)2)) {
                                                                                        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                        boolean bl4 = Intrinsics.areEqual((Object)string, (Object)"ane-lx2j") || Intrinsics.areEqual((Object)string, (Object)"hwv32");
                                                                                        if (!bl4) {
                                                                                            Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                            if (!Intrinsics.areEqual((Object)string, (Object)"kc-s701")) {
                                                                                                Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                boolean bl5 = Intrinsics.areEqual((Object)string, (Object)"e6810") || Intrinsics.areEqual((Object)string, (Object)"kyocera-e6820");
                                                                                                if (!bl5) {
                                                                                                    Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                    if (!Intrinsics.areEqual((Object)string, (Object)"fz-n1")) {
                                                                                                        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                        boolean bl6 = StringsKt__IndentKt.startsWith$default((String)string, (String)"lg-f800", (boolean)false, (int)2) || StringsKt__IndentKt.startsWith$default((String)string, (String)"lg-h91", (boolean)false, (int)2) || StringsKt__IndentKt.startsWith$default((String)string, (String)"lg-h99", (boolean)false, (int)2) || StringsKt__IndentKt.startsWith$default((String)string, (String)"lg-ls99", (boolean)false, (int)2) || StringsKt__IndentKt.startsWith$default((String)string, (String)"lg-uS99", (boolean)false, (int)2) || Intrinsics.areEqual((Object)string, (Object)"lgv34") || Intrinsics.areEqual((Object)string, (Object)"vs995");
                                                                                                        if (!bl6) {
                                                                                                            Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                            boolean bl7 = Intrinsics.areEqual((Object)string, (Object)"ta-1054") || Intrinsics.areEqual((Object)string, (Object)"ta-1050") || Intrinsics.areEqual((Object)string, (Object)"ta-1043");
                                                                                                            if (!bl7) {
                                                                                                                Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-n920", (boolean)false, (int)2)) {
                                                                                                                    Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                    boolean bl8 = Intrinsics.areEqual((Object)string, (Object)"xp6700") || Intrinsics.areEqual((Object)string, (Object)"ex-handy 209");
                                                                                                                    if (!bl8) {
                                                                                                                        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                        boolean bl9 = Intrinsics.areEqual((Object)string, (Object)"xp7700") || Intrinsics.areEqual((Object)string, (Object)"smart-ex 201");
                                                                                                                        if (!bl9) {
                                                                                                                            Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                            if (!Intrinsics.areEqual((Object)string, (Object)"xp8800")) {
                                                                                                                                Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-g390", (boolean)false, (int)2)) {
                                                                                                                                    Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                    if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-g398fn", (boolean)false, (int)2)) {
                                                                                                                                        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                        if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"mi 8", (boolean)false, (int)2)) {
                                                                                                                                            Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                            boolean bl10 = Intrinsics.areEqual((Object)string, (Object)"501so") || Intrinsics.areEqual((Object)string, (Object)"e6603") || Intrinsics.areEqual((Object)string, (Object)"e6653") || Intrinsics.areEqual((Object)string, (Object)"so-01h") || Intrinsics.areEqual((Object)string, (Object)"sov32") || Intrinsics.areEqual((Object)string, (Object)"e5803") || Intrinsics.areEqual((Object)string, (Object)"e5823") || Intrinsics.areEqual((Object)string, (Object)"so-02h") || Intrinsics.areEqual((Object)string, (Object)"e6853") || Intrinsics.areEqual((Object)string, (Object)"so-03h") || Intrinsics.areEqual((Object)string, (Object)"e6833") || Intrinsics.areEqual((Object)string, (Object)"e6883") || Intrinsics.areEqual((Object)string, (Object)"e6633") || Intrinsics.areEqual((Object)string, (Object)"e6683");
                                                                                                                                            if (!bl10) {
                                                                                                                                                Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                if (!Intrinsics.areEqual((Object)string, (Object)"tc20")) {
                                                                                                                                                    Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                    if (!Intrinsics.areEqual((Object)string, (Object)"tc52")) {
                                                                                                                                                        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                        if (!Intrinsics.areEqual((Object)string, (Object)"tc55")) {
                                                                                                                                                            Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                            if (!Intrinsics.areEqual((Object)string, (Object)"tc56")) {
                                                                                                                                                                Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                                if (!Intrinsics.areEqual((Object)string, (Object)"tc72")) {
                                                                                                                                                                    Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                                    if (!Intrinsics.areEqual((Object)string, (Object)"pixel 2")) {
                                                                                                                                                                        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                                        if (!Intrinsics.areEqual((Object)string, (Object)"ale-l21")) {
                                                                                                                                                                            Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                                            if (!Intrinsics.areEqual((Object)string, (Object)"704kc")) {
                                                                                                                                                                                Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                                                if (!Intrinsics.areEqual((Object)string, (Object)"e6910")) {
                                                                                                                                                                                    Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                                                    if (!Intrinsics.areEqual((Object)string, (Object)"rg650")) {
                                                                                                                                                                                        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                                                        if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-a510", (boolean)false, (int)2)) {
                                                                                                                                                                                            Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                                                            if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-g531f", (boolean)false, (int)2)) {
                                                                                                                                                                                                Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                                                                if (!StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-g390f", (boolean)false, (int)2) && !b.a.v(string)) {
                                                                                                                                                                                                    Intrinsics.checkNotNullParameter((Object)string, (String)"model");
                                                                                                                                                                                                    return Intrinsics.areEqual((Object)string, (Object)"mi a3");
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean b(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"normalizedModel");
        return b.a.v(string);
    }
}

