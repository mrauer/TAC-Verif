/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.util.Range
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  j
 *  java.lang.Comparable
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Comparator
 *  java.util.List
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.source;

import android.annotation.TargetApi;
import android.util.Range;
import com.android.tools.r8.GeneratedOutlineSupport;
import j$.util.Comparator;
import j$.util.Comparator$-CC;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

public final class ac {
    public static final /* synthetic */ int $r8$clinit;

    @TargetApi(value=21)
    public static final Range<Integer> a(Range<Integer>[] arrrange, float f2) {
        Intrinsics.checkNotNullParameter(arrrange, (String)"frameRateRanges");
        ArrayList arrayList = new ArrayList(arrrange.length);
        for (Range<Integer> range : arrrange) {
            Comparable comparable = range.getLower();
            Intrinsics.checkNotNullExpressionValue((Object)comparable, (String)"it.lower");
            int n2 = ((Number)comparable).intValue();
            Comparable comparable2 = range.getUpper();
            Intrinsics.checkNotNullExpressionValue((Object)comparable2, (String)"it.upper");
            arrayList.add((Object)new c(n2, ((Number)comparable2).intValue()));
        }
        c c2 = ac.a((List<c>)arrayList, f2);
        if (c2 != null) {
            return new Range((Comparable)Integer.valueOf((int)c2.a), (Comparable)Integer.valueOf((int)c2.b));
        }
        return null;
    }

    public static final c a(List<c> list, float f2) {
        Intrinsics.checkNotNullParameter(list, (String)"frameRateRanges");
        ArrayList arrayList = new ArrayList();
        for (Object object : list) {
            boolean bl = (float)((c)object).b <= f2;
            if (!bl) continue;
            arrayList.add(object);
        }
        return (c)ArraysKt___ArraysJvmKt.firstOrNull((List)ArraysKt___ArraysJvmKt.sortedWith((Iterable)arrayList, (java.util.Comparator)a.a));
    }

    public static final class c {
        public final int a;
        public final int b;

        public c(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }

        public final boolean equals(Object object) {
            block2 : {
                block3 : {
                    if (this == object) break block2;
                    if (!(object instanceof c)) break block3;
                    c c2 = (c)object;
                    if (this.a == c2.a && this.b == c2.b) break block2;
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return 31 * this.a + this.b;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("FrameRateRange(min=");
            stringBuilder.append(this.a);
            stringBuilder.append(", max=");
            return GeneratedOutlineSupport.outline20((StringBuilder)stringBuilder, (int)this.b, (String)")");
        }
    }

}

