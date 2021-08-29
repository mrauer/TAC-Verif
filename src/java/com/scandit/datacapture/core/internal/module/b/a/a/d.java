/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$Parameters
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.core.internal.module.b.a.a.b.i.a
 *  com.scandit.datacapture.core.internal.module.b.a.a.b.o.ac
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.RegexOption
 */
package com.scandit.datacapture.core.internal.module.b.a.a;

import android.hardware.Camera;
import com.google.android.material.R;
import com.scandit.datacapture.core.internal.module.b.a.a.a;
import com.scandit.datacapture.core.internal.module.b.a.a.b;
import com.scandit.datacapture.core.internal.module.b.a.a.b.o.ac;
import com.scandit.datacapture.core.internal.module.b.a.a.e;
import com.scandit.datacapture.core.internal.module.source.NativeCameraApi;
import com.scandit.datacapture.core.internal.module.source.ac;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.RegexOption;

public abstract class d
implements b {
    public final e b;
    public final a c;

    public d() {
        e e2;
        this.b = e2 = new e(false, false, false, 0.0f, false, false, false, 127);
        this.c = new a("continuous-picture", "continuous-video", "auto");
    }

    public static void a(Camera.Parameters parameters, float f2) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        float f3 = f2 * 1000.0f;
        List list = parameters.getSupportedPreviewFpsRange();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"supportedFpsRange");
        ArrayList arrayList = new ArrayList(R.style.collectionSizeOrDefault((Iterable)list, (int)10));
        for (int[] arrn : list) {
            arrayList.add((Object)new ac.c(arrn[0], arrn[1]));
        }
        Intrinsics.checkNotNullParameter((Object)arrayList, (String)"frameRateRanges");
        ArrayList arrayList2 = new ArrayList();
        for (Object object : arrayList) {
            boolean bl = (float)((ac.c)object).b <= f3;
            if (!bl) continue;
            arrayList2.add(object);
        }
        ac.c c2 = (ac.c)ArraysKt___ArraysJvmKt.firstOrNull((List)ArraysKt___ArraysJvmKt.sortedWith((Iterable)arrayList2, (Comparator)ac.b.a));
        if (c2 != null) {
            parameters.setPreviewFpsRange(c2.a, c2.b);
        }
    }

    public static void a(Camera.Parameters parameters, float f2, boolean bl) {
        ac.c c2;
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        float f3 = f2 * 1000.0f;
        List list = parameters.getSupportedPreviewFpsRange();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"supportedFpsRange");
        ArrayList arrayList = new ArrayList(R.style.collectionSizeOrDefault((Iterable)list, (int)10));
        for (int[] arrn : list) {
            arrayList.add((Object)new ac.c(arrn[0], arrn[1]));
        }
        if (bl) {
            Object object;
            Intrinsics.checkNotNullParameter((Object)arrayList, (String)"frameRateRanges");
            ArrayList arrayList2 = new ArrayList();
            for (Object object2 : arrayList) {
                boolean bl2 = (float)((ac.c)object2).b <= f3;
                if (!bl2) continue;
                arrayList2.add(object2);
            }
            Iterator iterator = arrayList2.iterator();
            if (!iterator.hasNext()) {
                object = null;
            } else {
                object = iterator.next();
                if (iterator.hasNext()) {
                    int n2 = ((ac.c)object).b;
                    do {
                        Object object3 = iterator.next();
                        int n3 = ((ac.c)object3).b;
                        if (n2 >= n3) continue;
                        object = object3;
                        n2 = n3;
                    } while (iterator.hasNext());
                }
            }
            ac.c c3 = (ac.c)object;
            Integer n4 = c3 != null ? Integer.valueOf((int)c3.b) : null;
            c2 = null;
            if (n4 != null) {
                n4.intValue();
                c2 = new ac.c(n4, n4);
            }
        } else {
            c2 = com.scandit.datacapture.core.internal.module.source.ac.a((List<ac.c>)arrayList, f3);
        }
        if (c2 != null) {
            parameters.setPreviewFpsRange(c2.a, c2.b);
        }
    }

    @Override
    public void a(Camera.Parameters parameters, float f2, float f3) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
    }

    @Override
    public final boolean a(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
        Intrinsics.checkNotNullParameter((Object)string, (String)"model");
        String string2 = this.a();
        RegexOption regexOption = RegexOption.IGNORE_CASE;
        Intrinsics.checkNotNullParameter((Object)string2, (String)"pattern");
        Intrinsics.checkNotNullParameter((Object)regexOption, (String)"option");
        int n2 = regexOption.getValue();
        if ((n2 & 2) != 0) {
            n2 |= 64;
        }
        Pattern pattern = Pattern.compile((String)string2, (int)n2);
        Intrinsics.checkNotNullExpressionValue((Object)pattern, (String)"Pattern.compile(pattern,\u2026nicodeCase(option.value))");
        Intrinsics.checkNotNullParameter((Object)pattern, (String)"nativePattern");
        Intrinsics.checkNotNullParameter((Object)string, (String)"input");
        return pattern.matcher((CharSequence)string).matches();
    }

    @Override
    public e b() {
        return this.b;
    }

    public final void b(Camera.Parameters parameters, float f2) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        float f3 = parameters.getExposureCompensationStep();
        int n2 = parameters.getMinExposureCompensation();
        parameters.setExposureCompensation(Math.min((int)parameters.getMaxExposureCompensation(), (int)Math.max((int)n2, (int)Math.round((float)(f2 / f3)))));
    }

    @Override
    public NativeCameraApi c() {
        return NativeCameraApi.CAMERA1;
    }

    @Override
    public boolean d() {
        return this instanceof ac;
    }

    @Override
    public boolean e() {
        return this instanceof com.scandit.datacapture.core.internal.module.b.a.a.b.i.a;
    }
}

