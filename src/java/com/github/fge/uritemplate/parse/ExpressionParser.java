/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.common.base.CharMatcher
 *  com.google.common.base.CharMatcher$Is
 *  com.google.common.base.Joiner
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableMap$Builder
 *  java.lang.Character
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.CharBuffer
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 */
package com.github.fge.uritemplate.parse;

import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import com.github.fge.uritemplate.URITemplateMessageBundle;
import com.github.fge.uritemplate.URITemplateParseException;
import com.github.fge.uritemplate.expression.ExpressionType;
import com.github.fge.uritemplate.expression.TemplateExpression;
import com.github.fge.uritemplate.expression.URITemplateExpression;
import com.github.fge.uritemplate.parse.CharMatchers;
import com.github.fge.uritemplate.parse.TemplateParser;
import com.github.fge.uritemplate.parse.VariableSpecParser;
import com.github.fge.uritemplate.vars.specs.ExplodedVariable;
import com.github.fge.uritemplate.vars.specs.PrefixVariable;
import com.github.fge.uritemplate.vars.specs.SimpleVariable;
import com.github.fge.uritemplate.vars.specs.VariableSpec;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ExpressionParser
implements TemplateParser {
    public static final MessageBundle BUNDLE = MessageBundles.getBundle(URITemplateMessageBundle.class);
    public static final CharMatcher COMMA = new CharMatcher.Is(',');
    public static final CharMatcher END_EXPRESSION = new CharMatcher.Is('}');
    public static final Map<Character, ExpressionType> EXPRESSION_TYPE_MAP;

    public static {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        ExpressionType expressionType = ExpressionType.RESERVED;
        builder.put((Object)Character.valueOf((char)'+'), (Object)expressionType);
        ExpressionType expressionType2 = ExpressionType.FRAGMENT;
        builder.put((Object)Character.valueOf((char)'#'), (Object)expressionType2);
        ExpressionType expressionType3 = ExpressionType.NAME_LABELS;
        builder.put((Object)Character.valueOf((char)'.'), (Object)expressionType3);
        ExpressionType expressionType4 = ExpressionType.PATH_SEGMENTS;
        builder.put((Object)Character.valueOf((char)'/'), (Object)expressionType4);
        ExpressionType expressionType5 = ExpressionType.PATH_PARAMETERS;
        builder.put((Object)Character.valueOf((char)';'), (Object)expressionType5);
        ExpressionType expressionType6 = ExpressionType.QUERY_STRING;
        builder.put((Object)Character.valueOf((char)'?'), (Object)expressionType6);
        ExpressionType expressionType7 = ExpressionType.QUERY_CONT;
        builder.put((Object)Character.valueOf((char)'&'), (Object)expressionType7);
        EXPRESSION_TYPE_MAP = builder.build();
    }

    @Override
    public URITemplateExpression parse(CharBuffer charBuffer) throws URITemplateParseException {
        block14 : {
            charBuffer.get();
            if (!charBuffer.hasRemaining()) break block14;
            ExpressionType expressionType = ExpressionType.SIMPLE;
            Map<Character, ExpressionType> map = EXPRESSION_TYPE_MAP;
            char c2 = charBuffer.charAt(0);
            if (map.containsKey((Object)Character.valueOf((char)c2))) {
                expressionType = (ExpressionType)((Object)map.get((Object)Character.valueOf((char)charBuffer.get())));
            }
            ArrayList arrayList = new ArrayList();
            block3 : do {
                ArrayList arrayList2 = new ArrayList();
                do {
                    block15 : {
                        VariableSpec variableSpec;
                        block17 : {
                            String string;
                            block19 : {
                                block20 : {
                                    block13 : {
                                        char c3;
                                        char c4;
                                        int n;
                                        block18 : {
                                            block16 : {
                                                char c5;
                                                StringBuilder stringBuilder = new StringBuilder();
                                                while (charBuffer.hasRemaining() && VariableSpecParser.VARCHAR.matches(c5 = charBuffer.charAt(0))) {
                                                    stringBuilder.append(charBuffer.get());
                                                    if (!CharMatchers.PERCENT.matches(c5)) continue;
                                                    if (charBuffer.remaining() >= 2) {
                                                        CharMatcher charMatcher = CharMatchers.HEXDIGIT;
                                                        char c6 = charBuffer.get();
                                                        if (charMatcher.matches(c6)) {
                                                            char c7 = charBuffer.get();
                                                            if (charMatcher.matches(c7)) {
                                                                stringBuilder.append(c6);
                                                                stringBuilder.append(c7);
                                                                continue;
                                                            }
                                                            throw new URITemplateParseException(VariableSpecParser.BUNDLE.getMessage("parse.percentIllegal"), charBuffer, true);
                                                        }
                                                        throw new URITemplateParseException(VariableSpecParser.BUNDLE.getMessage("parse.percentIllegal"), charBuffer, true);
                                                    }
                                                    throw new URITemplateParseException(VariableSpecParser.BUNDLE.getMessage("paser.percentShortRead"), charBuffer, true);
                                                }
                                                String string2 = stringBuilder.toString();
                                                if (string2.isEmpty()) break block3;
                                                arrayList2.add((Object)string2);
                                                if (charBuffer.hasRemaining() && VariableSpecParser.DOT.matches(charBuffer.charAt(0))) break block15;
                                                string = VariableSpecParser.JOINER.join((Iterable)arrayList2);
                                                if (charBuffer.hasRemaining()) break block16;
                                                variableSpec = new SimpleVariable(string);
                                                break block17;
                                            }
                                            c3 = charBuffer.charAt(0);
                                            if (!VariableSpecParser.STAR.matches(c3)) break block18;
                                            charBuffer.get();
                                            variableSpec = new ExplodedVariable(string);
                                            break block17;
                                        }
                                        if (!VariableSpecParser.COLON.matches(c3)) break block19;
                                        charBuffer.get();
                                        StringBuilder stringBuilder = new StringBuilder();
                                        while (charBuffer.hasRemaining() && VariableSpecParser.DIGIT.matches(c4 = charBuffer.charAt(0))) {
                                            stringBuilder.append(charBuffer.get());
                                        }
                                        String string3 = stringBuilder.toString();
                                        if (string3.isEmpty()) break block20;
                                        try {
                                            n = Integer.parseInt((String)string3);
                                            if (n > 10000) break block13;
                                        }
                                        catch (NumberFormatException numberFormatException) {
                                            throw new URITemplateParseException(VariableSpecParser.BUNDLE.getMessage("parse.prefixTooLarge"), charBuffer, true);
                                        }
                                        variableSpec = new PrefixVariable(string, n);
                                        break block17;
                                    }
                                    throw new NumberFormatException();
                                }
                                throw new URITemplateParseException(VariableSpecParser.BUNDLE.getMessage("parse.emptyPrefix"), charBuffer, true);
                            }
                            variableSpec = new SimpleVariable(string);
                        }
                        arrayList.add((Object)variableSpec);
                        if (charBuffer.hasRemaining()) {
                            char c8 = charBuffer.get();
                            if (COMMA.matches(c8)) continue block3;
                            if (END_EXPRESSION.matches(c8)) {
                                return new TemplateExpression(expressionType, (List<VariableSpec>)arrayList);
                            }
                            throw new URITemplateParseException(BUNDLE.getMessage("parse.unexpectedToken"), charBuffer, true);
                        }
                        throw new URITemplateParseException(BUNDLE.getMessage("parse.unexpectedEOF"), charBuffer, true);
                    }
                    charBuffer.get();
                } while (true);
                break;
            } while (true);
            throw new URITemplateParseException(VariableSpecParser.BUNDLE.getMessage("parse.emptyVarname"), charBuffer);
        }
        throw new URITemplateParseException(BUNDLE.getMessage("parse.unexpectedEOF"), charBuffer, true);
    }
}

