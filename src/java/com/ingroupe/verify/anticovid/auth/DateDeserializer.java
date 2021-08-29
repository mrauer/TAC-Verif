/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.gson.JsonDeserializationContext
 *  com.google.gson.JsonDeserializer
 *  com.google.gson.JsonElement
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.text.ParseException
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.TimeZone
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.auth;

import android.util.Log;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lcom/ingroupe/verify/anticovid/auth/DateDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Ljava/util/Date;", "<init>", "()V", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class DateDeserializer
implements JsonDeserializer<Date> {
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter((Object)jsonElement, (String)"element");
        String string = jsonElement.getAsString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        try {
            Date date = simpleDateFormat.parse(string);
            return date;
        }
        catch (ParseException parseException) {
            Log.e((String)"DateDeserializer", (String)"ParseError", (Throwable)parseException);
            return null;
        }
    }
}

