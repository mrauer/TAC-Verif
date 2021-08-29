/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.github.fge.jsonschema.library;

import com.github.fge.Frozen;
import com.github.fge.Thawed;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.github.fge.jsonschema.keyword.validator.KeywordValidatorFactory;
import com.github.fge.jsonschema.library.LibraryBuilder;

public final class Library
implements Frozen<LibraryBuilder> {
    public final Dictionary<Digester> digesters;
    public final Dictionary<FormatAttribute> formatAttributes;
    public final Dictionary<SyntaxChecker> syntaxCheckers;
    public final Dictionary<KeywordValidatorFactory> validators;

    public Library(Dictionary<SyntaxChecker> dictionary, Dictionary<Digester> dictionary2, Dictionary<KeywordValidatorFactory> dictionary3, Dictionary<FormatAttribute> dictionary4) {
        this.syntaxCheckers = dictionary;
        this.digesters = dictionary2;
        this.validators = dictionary3;
        this.formatAttributes = dictionary4;
    }

    public Library(LibraryBuilder libraryBuilder) {
        this.syntaxCheckers = libraryBuilder.syntaxCheckers.freeze();
        this.digesters = libraryBuilder.digesters.freeze();
        this.validators = libraryBuilder.validators.freeze();
        this.formatAttributes = libraryBuilder.formatAttributes.freeze();
    }

    public static LibraryBuilder newBuilder() {
        return new LibraryBuilder();
    }

    public Dictionary<Digester> getDigesters() {
        return this.digesters;
    }

    public Dictionary<FormatAttribute> getFormatAttributes() {
        return this.formatAttributes;
    }

    public Dictionary<SyntaxChecker> getSyntaxCheckers() {
        return this.syntaxCheckers;
    }

    public Dictionary<KeywordValidatorFactory> getValidators() {
        return this.validators;
    }

    public LibraryBuilder thaw() {
        return new LibraryBuilder(this);
    }
}

