/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.text.FieldPosition
 *  java.text.MessageFormat
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.IllegalFormatException
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 */
package com.github.fge.msgsimple.bundle;

import com.github.fge.Frozen;
import com.github.fge.msgsimple.InternalBundle;
import com.github.fge.msgsimple.bundle.MessageBundleBuilder;
import com.github.fge.msgsimple.provider.MessageSourceProvider;
import com.github.fge.msgsimple.source.MessageSource;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class MessageBundle
implements Frozen<MessageBundleBuilder> {
    public static final InternalBundle BUNDLE = InternalBundle.INSTANCE;
    public final List<MessageSourceProvider> providers;

    public MessageBundle(MessageBundleBuilder messageBundleBuilder) {
        ArrayList arrayList;
        this.providers = arrayList = new ArrayList();
        arrayList.addAll(messageBundleBuilder.providers);
    }

    public void checkArgument(boolean bl, String string) {
        Locale locale = Locale.getDefault();
        if (bl) {
            return;
        }
        throw new IllegalArgumentException(this.getMessage(locale, string));
    }

    public /* varargs */ void checkArgumentFormat(boolean bl, String string, Object ... arrobject) {
        String string2;
        Locale locale = Locale.getDefault();
        if (bl) {
            return;
        }
        string2 = this.getMessage(locale, string);
        try {
            string2 = new MessageFormat(string2, locale).format(arrobject, new StringBuffer(string2.length()), null).toString();
        }
        catch (IllegalArgumentException illegalArgumentException) {}
        throw new IllegalArgumentException(string2);
    }

    public /* varargs */ void checkArgumentPrintf(boolean bl, String string, Object ... arrobject) {
        String string2;
        Locale locale = Locale.getDefault();
        if (bl) {
            return;
        }
        string2 = this.getMessage(locale, string);
        try {
            string2 = String.format((Locale)locale, (String)string2, (Object[])arrobject);
        }
        catch (IllegalFormatException illegalFormatException) {}
        throw new IllegalArgumentException(string2);
    }

    public <T> T checkNotNull(T t, String string) {
        Locale locale = Locale.getDefault();
        if (t != null) {
            return t;
        }
        throw new NullPointerException(this.getMessage(locale, string));
    }

    public /* varargs */ <T> T checkNotNullPrintf(T t, String string, Object ... arrobject) {
        String string2;
        Locale locale = Locale.getDefault();
        if (t != null) {
            return t;
        }
        string2 = this.getMessage(locale, string);
        try {
            string2 = String.format((Locale)locale, (String)string2, (Object[])arrobject);
        }
        catch (IllegalFormatException illegalFormatException) {}
        throw new NullPointerException(string2);
    }

    public String getMessage(String string) {
        return this.getMessage(Locale.getDefault(), string);
    }

    public String getMessage(Locale locale, String string) {
        Locale locale2;
        Locale locale3;
        InternalBundle internalBundle = BUNDLE;
        internalBundle.checkNotNull(string, "query.nullKey");
        internalBundle.checkNotNull(locale, "query.nullLocale");
        String string2 = locale.getLanguage();
        String string3 = locale.getCountry();
        String string4 = locale.getVariant();
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)locale);
        if (!string4.isEmpty() && !(locale2 = new Locale(string2, string3)).equals((Object)Locale.ROOT)) {
            arrayList.add((Object)locale2);
        }
        if (!string3.isEmpty() && !(locale3 = new Locale(string2)).equals((Object)Locale.ROOT)) {
            arrayList.add((Object)locale3);
        }
        if (!string2.isEmpty()) {
            arrayList.add((Object)Locale.ROOT);
        }
        for (Locale locale4 : arrayList) {
            Iterator iterator = this.providers.iterator();
            while (iterator.hasNext()) {
                String string5;
                MessageSource messageSource = ((MessageSourceProvider)iterator.next()).getMessageSource(locale4);
                if (messageSource == null || (string5 = messageSource.getKey(string)) == null) continue;
                return string5;
            }
        }
        return string;
    }

    public /* varargs */ String printf(Locale locale, String string, Object ... arrobject) {
        String string2 = this.getMessage(locale, string);
        try {
            String string3 = String.format((Locale)locale, (String)string2, (Object[])arrobject);
            return string3;
        }
        catch (IllegalFormatException illegalFormatException) {
            return string2;
        }
    }
}

