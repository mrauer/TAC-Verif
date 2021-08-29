/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.adapter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;
import j$.time.LocalDate;
import j$.time.format.DateTimeFormatter;
import kotlin.jvm.internal.Intrinsics;

public final class StatisticAdapter$drawChart$xFormatter$1
extends ValueFormatter {
    @Override
    public String getAxisLabel(float f2, AxisBase axisBase) {
        Intrinsics.checkNotNullParameter((Object)axisBase, (String)"axis");
        String string = LocalDate.ofEpochDay((long)f2).format(DateTimeFormatter.ofPattern("dd/MM"));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"date.format(DateTimeFormatter.ofPattern(\"dd/MM\"))");
        return string;
    }
}

