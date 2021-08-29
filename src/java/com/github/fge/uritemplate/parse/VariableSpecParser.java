/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  com.github.fge.uritemplate.URITemplateMessageBundle
 *  com.google.common.base.CharMatcher
 *  com.google.common.base.CharMatcher$InRange
 *  com.google.common.base.CharMatcher$Is
 *  com.google.common.base.CharMatcher$Or
 *  com.google.common.base.Joiner
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.uritemplate.parse;

import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import com.github.fge.uritemplate.URITemplateMessageBundle;
import com.github.fge.uritemplate.parse.CharMatchers;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;

public final class VariableSpecParser {
    public static final MessageBundle BUNDLE = MessageBundles.getBundle(URITemplateMessageBundle.class);
    public static final CharMatcher COLON;
    public static final CharMatcher DIGIT;
    public static final CharMatcher DOT;
    public static final Joiner JOINER;
    public static final CharMatcher STAR;
    public static final CharMatcher VARCHAR;

    public static {
        JOINER = new Joiner(String.valueOf((char)'.'));
        VARCHAR = new CharMatcher.Or((CharMatcher)new CharMatcher.Or((CharMatcher)new CharMatcher.Or((CharMatcher)new CharMatcher.Or((CharMatcher)new CharMatcher.InRange('0', '9'), (CharMatcher)new CharMatcher.InRange('a', 'z')), (CharMatcher)new CharMatcher.InRange('A', 'Z')), (CharMatcher)new CharMatcher.Is('_')), CharMatchers.PERCENT).precomputed();
        DOT = new CharMatcher.Is('.');
        COLON = new CharMatcher.Is(':');
        STAR = new CharMatcher.Is('*');
        DIGIT = new CharMatcher.InRange('0', '9');
    }
}

