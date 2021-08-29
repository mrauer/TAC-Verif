/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  com.github.fge.uritemplate.URITemplateMessageBundle
 *  com.google.common.base.CharMatcher
 *  com.google.common.base.CharMatcher$Is
 *  java.lang.Object
 */
package com.github.fge.uritemplate.parse;

import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import com.github.fge.uritemplate.URITemplateMessageBundle;
import com.google.common.base.CharMatcher;

public final class URITemplateParser {
    public static final CharMatcher BEGIN_EXPRESSION;
    public static final MessageBundle BUNDLE;

    public static {
        BUNDLE = MessageBundles.getBundle(URITemplateMessageBundle.class);
        BEGIN_EXPRESSION = new CharMatcher.Is('{');
    }
}

