/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.HashMap
 *  java.util.Locale
 *  java.util.Map
 */
package com.github.fge.msgsimple.provider;

import com.github.fge.msgsimple.InternalBundle;
import com.github.fge.msgsimple.provider.MessageSourceProvider;
import com.github.fge.msgsimple.provider.StaticMessageSourceProvider;
import com.github.fge.msgsimple.source.MessageSource;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class StaticMessageSourceProvider
implements MessageSourceProvider {
    public static final InternalBundle BUNDLE = InternalBundle.INSTANCE;
    public final MessageSource defaultSource;
    public final Map<Locale, MessageSource> sources;

    public StaticMessageSourceProvider(Builder builder, 1 var2_2) {
        this.defaultSource = builder.defaultSource;
        this.sources = new HashMap(builder.sources);
    }

    @Override
    public MessageSource getMessageSource(Locale locale) {
        if (this.sources.containsKey((Object)locale)) {
            return (MessageSource)this.sources.get((Object)locale);
        }
        return this.defaultSource;
    }

}

