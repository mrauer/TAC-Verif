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
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.github.fge.jsonschema.keyword.validator.KeywordValidatorFactory;
import com.github.fge.jsonschema.library.Keyword;
import com.github.fge.jsonschema.library.Library;
import com.github.fge.jsonschema.messages.JsonSchemaConfigurationBundle;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;

public final class LibraryBuilder
implements Thawed<Library> {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaConfigurationBundle.class);
    public final DictionaryBuilder<Digester> digesters;
    public final DictionaryBuilder<FormatAttribute> formatAttributes;
    public final DictionaryBuilder<SyntaxChecker> syntaxCheckers;
    public final DictionaryBuilder<KeywordValidatorFactory> validators;

    public LibraryBuilder() {
        this.syntaxCheckers = Dictionary.newBuilder();
        this.digesters = Dictionary.newBuilder();
        this.validators = Dictionary.newBuilder();
        this.formatAttributes = Dictionary.newBuilder();
    }

    public LibraryBuilder(Library library) {
        this.syntaxCheckers = library.syntaxCheckers.thaw();
        this.digesters = library.digesters.thaw();
        this.validators = library.validators.thaw();
        this.formatAttributes = library.formatAttributes.thaw();
    }

    public LibraryBuilder addFormatAttribute(String string, FormatAttribute formatAttribute) {
        this.removeFormatAttribute(string);
        BUNDLE.checkNotNullPrintf(formatAttribute, "nullAttribute", string);
        this.formatAttributes.addEntry(string, formatAttribute);
        return this;
    }

    public LibraryBuilder addKeyword(Keyword keyword) {
        BUNDLE.checkNotNull(keyword, "nullKeyword");
        String string = keyword.name;
        this.removeKeyword(string);
        this.syntaxCheckers.addEntry(string, keyword.syntaxChecker);
        if (keyword.validatorFactory != null) {
            this.digesters.addEntry(string, keyword.digester);
            this.validators.addEntry(string, keyword.validatorFactory);
        }
        return this;
    }

    public Library freeze() {
        return new Library(this);
    }

    public LibraryBuilder removeFormatAttribute(String string) {
        BUNDLE.checkNotNull(string, "nullFormat");
        this.formatAttributes.removeEntry(string);
        return this;
    }

    public LibraryBuilder removeKeyword(String string) {
        BUNDLE.checkNotNull(string, "nullName");
        this.syntaxCheckers.removeEntry(string);
        this.digesters.removeEntry(string);
        this.validators.removeEntry(string);
        return this;
    }
}

