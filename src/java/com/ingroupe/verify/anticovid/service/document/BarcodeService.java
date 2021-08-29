/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.preference.PreferenceManager
 *  com.google.gson.Gson
 *  com.google.gson.reflect.TypeToken
 *  com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils$getSpecificList
 *  com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils$getSpecificList$itemType
 *  com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils$getSpecificList$itemType$1
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.Map
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.service.document;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ingroupe.verify.anticovid.common.Constants$SpecificList;
import com.ingroupe.verify.anticovid.common.Constants$SpecificValues;
import com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public abstract class BarcodeService {
    public static final int getSV(Context context, Constants$SpecificValues constants$SpecificValues) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)((Object)constants$SpecificValues), (String)"svEnum");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)((Object)constants$SpecificValues), (String)"svEnum");
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        Intrinsics.checkExpressionValueIsNotNull((Object)sharedPreferences, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)");
        return sharedPreferences.getInt(constants$SpecificValues.getText(), constants$SpecificValues.getDefault());
    }

    public static final boolean isValuePresent(String string, String string2, Context context, Constants$SpecificList constants$SpecificList, Map<String, String> map) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"field");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)((Object)constants$SpecificList), (String)"slEnum");
        Intrinsics.checkNotNullParameter(map, (String)"mappedDynamicData");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)((Object)constants$SpecificList), (String)"svEnum");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"key");
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        Intrinsics.checkExpressionValueIsNotNull((Object)sharedPreferences, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)");
        String string3 = sharedPreferences.getString(constants$SpecificList.getText(), "{}");
        Object object = new Gson().fromJson(string3, new SynchronisationUtils.getSpecificList.itemType.1().type);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"gson.fromJson(jsonMap, itemType)");
        String string4 = (String)((Map)object).get((Object)string2);
        if (string4 != null) {
            map.put((Object)string, (Object)string4);
            return true;
        }
        map.put((Object)string, (Object)string2);
        return false;
    }
}

