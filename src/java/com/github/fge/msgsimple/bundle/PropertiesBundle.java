/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  com.github.fge.msgsimple.bundle.MessageBundleBuilder
 *  com.github.fge.msgsimple.bundle.PropertiesBundle$1
 *  com.github.fge.msgsimple.provider.LoadingMessageSourceProvider
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.util.List
 *  java.util.Map
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.github.fge.msgsimple.bundle;

import com.github.fge.msgsimple.InternalBundle;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.bundle.MessageBundleBuilder;
import com.github.fge.msgsimple.bundle.PropertiesBundle;
import com.github.fge.msgsimple.provider.LoadingMessageSourceProvider;
import com.github.fge.msgsimple.provider.MessageSourceLoader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PropertiesBundle {
    public static final InternalBundle BUNDLE = InternalBundle.INSTANCE;
    public static final Pattern SUFFIX;
    public static final Charset UTF8;

    public static {
        UTF8 = Charset.forName((String)"UTF-8");
        Charset.forName((String)"ISO-8859-1");
        SUFFIX = Pattern.compile((String)"\\.properties$");
    }

    public static MessageBundle forPath(String string) {
        Charset charset = UTF8;
        InternalBundle internalBundle = BUNDLE;
        internalBundle.checkNotNull(string, "cfg.nullResourcePath");
        internalBundle.checkNotNull(charset, "cfg.nullCharset");
        if (!string.startsWith("/")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('/');
            stringBuilder.append(string);
            string = stringBuilder.toString();
        }
        1 var8_4 = new 1(SUFFIX.matcher((CharSequence)string).replaceFirst(""), charset);
        LoadingMessageSourceProvider.Builder builder = new LoadingMessageSourceProvider.Builder(null);
        InternalBundle internalBundle2 = LoadingMessageSourceProvider.BUNDLE;
        internalBundle2.checkNotNull(var8_4, "cfg.nullLoader");
        builder.loader = var8_4;
        builder.expiryDuration = 0L;
        if (true) {
            LoadingMessageSourceProvider loadingMessageSourceProvider = new LoadingMessageSourceProvider(builder, null);
            MessageBundleBuilder messageBundleBuilder = new MessageBundleBuilder();
            MessageBundleBuilder.BUNDLE.checkNotNull(loadingMessageSourceProvider, "cfg.nullProvider");
            messageBundleBuilder.providers.add((Object)loadingMessageSourceProvider);
            return new MessageBundle(messageBundleBuilder);
        }
        throw new IllegalArgumentException((String)internalBundle2.messages.get((Object)"cfg.noLoader"));
    }
}

