/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package com.github.fge.msgsimple.bundle;

import com.github.fge.Thawed;
import com.github.fge.msgsimple.InternalBundle;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.provider.MessageSourceProvider;
import com.github.fge.msgsimple.provider.StaticMessageSourceProvider;
import com.github.fge.msgsimple.source.MessageSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class MessageBundleBuilder
implements Thawed<MessageBundle> {
    public static final InternalBundle BUNDLE = InternalBundle.INSTANCE;
    public final List<MessageSourceProvider> providers;

    public MessageBundleBuilder() {
        this.providers = new ArrayList();
    }

    public MessageBundleBuilder(MessageBundle messageBundle) {
        ArrayList arrayList;
        this.providers = arrayList = new ArrayList();
        arrayList.addAll(messageBundle.providers);
    }

    public MessageBundleBuilder appendSource(MessageSource messageSource) {
        Object object = new Object(null){
            public MessageSource defaultSource;
            public final java.util.Map<java.util.Locale, MessageSource> sources;
            {
                this.sources = new java.util.HashMap();
            }
        };
        StaticMessageSourceProvider.BUNDLE.checkNotNull(messageSource, "cfg.nullDefaultSource");
        object.defaultSource = messageSource;
        StaticMessageSourceProvider staticMessageSourceProvider = new StaticMessageSourceProvider(object, null);
        this.providers.add((Object)staticMessageSourceProvider);
        return this;
    }
}

