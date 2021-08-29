/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.library;

import com.github.fge.Frozen;
import com.github.fge.Thawed;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.github.fge.jsonschema.keyword.validator.KeywordValidatorFactory;
import com.github.fge.jsonschema.library.KeywordBuilder;

public final class Keyword
implements Frozen<KeywordBuilder> {
    public final Digester digester;
    public final String name;
    public final SyntaxChecker syntaxChecker;
    public final KeywordValidatorFactory validatorFactory;

    public Keyword(KeywordBuilder keywordBuilder) {
        this.name = keywordBuilder.name;
        this.syntaxChecker = keywordBuilder.syntaxChecker;
        this.digester = keywordBuilder.digester;
        this.validatorFactory = keywordBuilder.validatorFactory;
    }

    public static KeywordBuilder newBuilder(String string) {
        return new KeywordBuilder(string);
    }

    public KeywordBuilder thaw() {
        return new KeywordBuilder(this);
    }
}

