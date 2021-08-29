/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  com.google.gson.Gson
 *  com.google.gson.reflect.TypeToken
 *  com.ingroupe.verify.anticovid.synchronization.elements.Blacklist$isBlacklisted
 *  com.ingroupe.verify.anticovid.synchronization.elements.Blacklist$isBlacklisted$itemType
 *  com.ingroupe.verify.anticovid.synchronization.elements.Blacklist$isBlacklisted$itemType$1
 *  dalvik.annotation.SourceDebugExtension
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.synchronization.elements;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ingroupe.verify.anticovid.synchronization.elements.-$$Lambda$Blacklist$fMRL67-IRTVJlGVnQNleQYc9gRM;
import com.ingroupe.verify.anticovid.synchronization.elements.Blacklist;
import dalvik.annotation.SourceDebugExtension;
import j$.time.LocalDateTime;
import j$.util.Collection$-EL;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

@SourceDebugExtension(value="SMAP\nBlacklist.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Blacklist.kt\ncom/ingroupe/verify/anticovid/synchronization/elements/Blacklist\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,141:1\n1#2:142\n*E\n")
public final class Blacklist {
    public static final Blacklist INSTANCE;
    public static final Map<String, LocalDateTime> mapHashDuplicate;

    public static {
        mapHashDuplicate = new LinkedHashMap();
    }

    public static final void cleanDuplicateMap(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        LocalDateTime localDateTime = LocalDateTime.now().minusMinutes(context.getSharedPreferences("com.ingroupe.verify.BLACKLIST_KEY", 0).getLong("DUPLICATE_RETENTION_PERIOD", 5L));
        Collection$-EL.removeIf(mapHashDuplicate.values(), new -$$Lambda$Blacklist$fMRL67-IRTVJlGVnQNleQYc9gRM(localDateTime));
    }

    public static final boolean isBlacklisted(Context context, BlacklistType blacklistType, String string) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)((Object)blacklistType), (String)"blacklistType");
        Intrinsics.checkNotNullParameter((Object)string, (String)"hash");
        String string2 = context.getSharedPreferences("com.ingroupe.verify.BLACKLIST_KEY", 0).getString(blacklistType.getText(), "[]");
        Object object = new Gson().fromJson(string2, new isBlacklisted.itemType.1().type);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"gson.fromJson(jsonMap, itemType)");
        return ((ArrayList)object).contains((Object)string);
    }

    public static final boolean isHashDuplicate(String string, Context context) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"hash");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Blacklist.cleanDuplicateMap(context);
        if (!context.getSharedPreferences("com.ingroupe.verify.BLACKLIST_KEY", 0).getBoolean("DUPLICATE_ACTIVATE", false)) {
            return false;
        }
        Map<String, LocalDateTime> map = mapHashDuplicate;
        Object object = map.get((Object)string);
        boolean bl = false;
        if (object != null) {
            bl = true;
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        Intrinsics.checkNotNullExpressionValue((Object)localDateTime, (String)"now()");
        map.put((Object)string, (Object)localDateTime);
        return bl;
    }

    public static final class BlacklistType
    extends Enum<BlacklistType> {
        private static final /* synthetic */ BlacklistType[] $VALUES;
        public static final /* enum */ BlacklistType BLACKLIST_2DDOC;
        public static final /* enum */ BlacklistType BLACKLIST_DCC;
        private final String text;

        public static {
            BlacklistType blacklistType;
            BlacklistType blacklistType2;
            BLACKLIST_DCC = blacklistType2 = new BlacklistType("BLACKLIST_DCC");
            BLACKLIST_2DDOC = blacklistType = new BlacklistType("BLACKLIST_2DDOC");
            $VALUES = new BlacklistType[]{blacklistType2, blacklistType};
        }

        public BlacklistType(String string2) {
            this.text = string2;
        }

        public static BlacklistType valueOf(String string) {
            return (BlacklistType)Enum.valueOf(BlacklistType.class, (String)string);
        }

        public static BlacklistType[] values() {
            return (BlacklistType[])$VALUES.clone();
        }

        public final String getText() {
            return this.text;
        }
    }

    public static final class Message
    extends Enum<Message> {
        private static final /* synthetic */ Message[] $VALUES;
        public static final /* enum */ Message BLACKLIST_LITE;
        public static final /* enum */ Message BLACKLIST_OT;
        public static final /* enum */ Message DUPLICATE;
        private final int keyDetail;
        private final int keyTitle;

        public static {
            Message message;
            Message message2;
            Message message3;
            BLACKLIST_LITE = message = new Message(2131820760, 2131820759);
            BLACKLIST_OT = message2 = new Message(2131820762, 2131820761);
            DUPLICATE = message3 = new Message(2131820767, 2131820766);
            $VALUES = new Message[]{message, message2, message3};
        }

        public Message(int n3, int n4) {
            this.keyTitle = n3;
            this.keyDetail = n4;
        }

        public static Message valueOf(String string) {
            return (Message)Enum.valueOf(Message.class, (String)string);
        }

        public static Message[] values() {
            return (Message[])$VALUES.clone();
        }

        public final int getKeyDetail() {
            return this.keyDetail;
        }

        public final int getKeyTitle() {
            return this.keyTitle;
        }
    }

}

