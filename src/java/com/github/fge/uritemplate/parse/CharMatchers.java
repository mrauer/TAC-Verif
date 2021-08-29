/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.common.base.CharMatcher
 *  com.google.common.base.CharMatcher$InRange
 *  com.google.common.base.CharMatcher$Is
 *  com.google.common.base.CharMatcher$JavaIsoControl
 *  com.google.common.base.CharMatcher$Negated
 *  com.google.common.base.CharMatcher$Or
 *  com.google.common.base.CharMatcher$Whitespace
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package com.github.fge.uritemplate.parse;

import com.google.common.base.CharMatcher;

public final class CharMatchers {
    public static final CharMatcher HEXDIGIT;
    public static final CharMatcher LITERALS;
    public static final CharMatcher PERCENT;

    public static {
        PERCENT = new CharMatcher.Is('%');
        HEXDIGIT = new CharMatcher.Or((CharMatcher)new CharMatcher.Or((CharMatcher)new CharMatcher.InRange('0', '9'), (CharMatcher)new CharMatcher.InRange('a', 'f')), (CharMatcher)new CharMatcher.InRange('A', 'F')).precomputed();
        CharMatcher.JavaIsoControl javaIsoControl = CharMatcher.JavaIsoControl.INSTANCE;
        CharMatcher.Whitespace whitespace = CharMatcher.Whitespace.INSTANCE;
        CharMatcher charMatcher = CharMatcher.anyOf((CharSequence)"\"'<>\\^`{|}");
        LITERALS = new CharMatcher.Negated((CharMatcher)new CharMatcher.Or((CharMatcher)new CharMatcher.Or((CharMatcher)javaIsoControl, (CharMatcher)whitespace), charMatcher)).precomputed();
    }
}

