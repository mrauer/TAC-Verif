/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Calendar
 *  java.util.Objects
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.observer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ingroupe.verify.anticovid.observer.DailyReceiver;
import java.util.Calendar;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lcom/ingroupe/verify/anticovid/observer/StartReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "<init>", "()V", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class StartReceiver
extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String string = intent == null ? null : intent.getAction();
        if (Intrinsics.areEqual((Object)string, (Object)"android.intent.action.BOOT_COMPLETED")) {
            if (context == null) {
                return;
            }
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Object object = context.getSystemService("alarm");
            Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type android.app.AlarmManager");
            AlarmManager alarmManager = (AlarmManager)object;
            Calendar calendar = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue((Object)calendar, (String)"getInstance()");
            calendar.set(11, 0);
            calendar.set(12, 2);
            Intent intent2 = new Intent(context, DailyReceiver.class);
            intent2.getAction();
            PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)context, (int)11, (Intent)intent2, (int)134217728);
            Intrinsics.checkNotNullExpressionValue((Object)pendingIntent, (String)"getBroadcast(\n                context,\n                Constants.DAILY_RECEIVER_RC,\n                intent,\n                PendingIntent.FLAG_UPDATE_CURRENT\n            )");
            alarmManager.setInexactRepeating(1, calendar.getTimeInMillis(), 86400000L, pendingIntent);
        }
    }
}

