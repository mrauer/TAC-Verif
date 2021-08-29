/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.nio.CharBuffer
 */
package com.github.fge.uritemplate.parse;

import com.github.fge.uritemplate.URITemplateParseException;
import com.github.fge.uritemplate.expression.URITemplateExpression;
import java.nio.CharBuffer;

public interface TemplateParser {
    public URITemplateExpression parse(CharBuffer var1) throws URITemplateParseException;
}

