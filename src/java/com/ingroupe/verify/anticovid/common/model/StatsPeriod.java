/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  com.google.gson.Gson
 *  dalvik.annotation.SourceDebugExtension
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.common.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.ingroupe.verify.anticovid.common.model.StatsDay;
import dalvik.annotation.SourceDebugExtension;
import j$.time.LocalDate;
import j$.time.chrono.ChronoLocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

@SourceDebugExtension(value="SMAP\nStatsPeriod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StatsPeriod.kt\ncom/ingroupe/verify/anticovid/common/model/StatsPeriod\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,71:1\n461#2,7:72\n*S KotlinDebug\n*F\n+ 1 StatsPeriod.kt\ncom/ingroupe/verify/anticovid/common/model/StatsPeriod\n*L\n61#1:72,7\n*E\n")
public final class StatsPeriod {
    public Map<Long, StatsDay> map = new LinkedHashMap();

    public final void cleanOldStatsAndSave(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Map<Long, StatsDay> map = this.map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (!LocalDate.ofEpochDay(((Number)entry.getKey()).longValue()).plusDays(15L).isAfter(LocalDate.now())) continue;
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        this.map = ArraysKt___ArraysJvmKt.toMutableMap((Map)linkedHashMap);
        String string = new Gson().toJson(this.map);
        SharedPreferences.Editor editor = context.getSharedPreferences("com.ingroupe.verify.LOCAL_STAT_KEY", 0).edit();
        editor.putString("STATS_PERIOD", string);
        editor.apply();
    }

    public final StatsDay getStatsDay(LocalDate localDate) {
        Intrinsics.checkNotNullParameter((Object)localDate, (String)"date");
        long l3 = localDate.toEpochDay();
        StatsDay statsDay = (StatsDay)this.map.get((Object)l3);
        if (statsDay == null) {
            statsDay = new StatsDay();
            this.map.put((Object)l3, (Object)statsDay);
        }
        return statsDay;
    }
}

