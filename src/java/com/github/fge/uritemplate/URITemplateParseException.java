/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.CharBuffer
 */
package com.github.fge.uritemplate;

import java.nio.CharBuffer;

public final class URITemplateParseException
extends Exception {
    public final int offset;

    public URITemplateParseException(String string, CharBuffer charBuffer) {
        super(string);
        this.offset = charBuffer.position();
    }

    public URITemplateParseException(String string, CharBuffer charBuffer, boolean bl) {
        super(string);
        int n3 = charBuffer.position();
        if (bl) {
            --n3;
        }
        this.offset = n3;
    }

    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getMessage());
        stringBuilder.append(" (at offset ");
        stringBuilder.append(this.offset);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

