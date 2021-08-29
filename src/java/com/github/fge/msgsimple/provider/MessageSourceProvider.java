/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Locale
 */
package com.github.fge.msgsimple.provider;

import com.github.fge.msgsimple.source.MessageSource;
import java.util.Locale;

public interface MessageSourceProvider {
    public MessageSource getMessageSource(Locale var1);
}

