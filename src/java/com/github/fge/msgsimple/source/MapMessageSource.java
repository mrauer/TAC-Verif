/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.github.fge.msgsimple.source;

import com.github.fge.msgsimple.InternalBundle;
import com.github.fge.msgsimple.source.MapMessageSource;
import com.github.fge.msgsimple.source.MessageSource;
import java.util.HashMap;
import java.util.Map;

public final class MapMessageSource
implements MessageSource {
    public static final InternalBundle BUNDLE = InternalBundle.INSTANCE;
    public final Map<String, String> messages;

    public MapMessageSource(Builder builder, 1 var2_2) {
        this.messages = new HashMap(builder.messages);
    }

    @Override
    public String getKey(String string) {
        return (String)this.messages.get((Object)string);
    }

}

