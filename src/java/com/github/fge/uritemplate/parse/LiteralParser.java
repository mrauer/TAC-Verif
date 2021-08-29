/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.common.base.CharMatcher
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.CharBuffer
 */
package com.github.fge.uritemplate.parse;

import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import com.github.fge.uritemplate.URITemplateMessageBundle;
import com.github.fge.uritemplate.URITemplateParseException;
import com.github.fge.uritemplate.expression.TemplateLiteral;
import com.github.fge.uritemplate.expression.URITemplateExpression;
import com.github.fge.uritemplate.parse.CharMatchers;
import com.github.fge.uritemplate.parse.TemplateParser;
import com.google.common.base.CharMatcher;
import java.nio.CharBuffer;

public final class LiteralParser
implements TemplateParser {
    public static final MessageBundle BUNDLE = MessageBundles.getBundle(URITemplateMessageBundle.class);

    @Override
    public URITemplateExpression parse(CharBuffer charBuffer) throws URITemplateParseException {
        char c2;
        StringBuilder stringBuilder = new StringBuilder();
        while (charBuffer.hasRemaining() && CharMatchers.LITERALS.matches(c2 = charBuffer.charAt(0))) {
            stringBuilder.append(charBuffer.get());
            if (!CharMatchers.PERCENT.matches(c2)) continue;
            if (charBuffer.remaining() >= 2) {
                CharMatcher charMatcher = CharMatchers.HEXDIGIT;
                char c3 = charBuffer.get();
                if (charMatcher.matches(c3)) {
                    char c4 = charBuffer.get();
                    if (charMatcher.matches(c4)) {
                        stringBuilder.append(c3);
                        stringBuilder.append(c4);
                        continue;
                    }
                    throw new URITemplateParseException(BUNDLE.getMessage("parse.percentIllegal"), charBuffer, true);
                }
                throw new URITemplateParseException(BUNDLE.getMessage("parse.percentIllegal"), charBuffer, true);
            }
            throw new URITemplateParseException(BUNDLE.getMessage("paser.percentShortRead"), charBuffer, true);
        }
        return new TemplateLiteral(stringBuilder.toString());
    }
}

