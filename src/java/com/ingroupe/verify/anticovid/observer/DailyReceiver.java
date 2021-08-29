/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  com.google.gson.Gson
 *  com.google.gson.reflect.TypeToken
 *  com.ingroupe.verify.anticovid.common.model.StatsPeriod$Companion
 *  com.ingroupe.verify.anticovid.common.model.StatsPeriod$Companion$getStatsPeriod
 *  com.ingroupe.verify.anticovid.common.model.StatsPeriod$Companion$getStatsPeriod$itemType
 *  com.ingroupe.verify.anticovid.common.model.StatsPeriod$Companion$getStatsPeriod$itemType$1
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.observer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ingroupe.verify.anticovid.common.model.StatsDay;
import com.ingroupe.verify.anticovid.common.model.StatsPeriod;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lcom/ingroupe/verify/anticovid/observer/DailyReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "<init>", "()V", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class DailyReceiver
extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context == null) {
            return;
        }
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        String string = context.getSharedPreferences("com.ingroupe.verify.LOCAL_STAT_KEY", 0).getString("STATS_PERIOD", "");
        StatsPeriod statsPeriod = new StatsPeriod();
        if (!Intrinsics.areEqual((Object)string, (Object)"")) {
            Gson gson = new Gson();
            new LinkedHashMap();
            Object object = gson.fromJson(string, new StatsPeriod.Companion.getStatsPeriod.itemType.1().type);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"gson.fromJson(jsonMap, itemType)");
            Map map = (Map)object;
            Intrinsics.checkNotNullParameter((Object)map, (String)"<set-?>");
            statsPeriod.map = map;
        }
        statsPeriod.cleanOldStatsAndSave(context);
    }
}

