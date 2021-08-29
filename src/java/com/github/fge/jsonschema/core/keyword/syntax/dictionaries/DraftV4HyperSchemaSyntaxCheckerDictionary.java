/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.TypeOnlySyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.URISyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.hyperschema.LinksSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.hyperschema.MediaSyntaxChecker
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.keyword.syntax.dictionaries;

import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.TypeOnlySyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.URISyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.hyperschema.LinksSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.hyperschema.MediaSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.dictionaries.DraftV4SyntaxCheckerDictionary;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;

public final class DraftV4HyperSchemaSyntaxCheckerDictionary {
    private static final Dictionary<SyntaxChecker> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addAll(DraftV4SyntaxCheckerDictionary.get());
        dictionaryBuilder.addEntry("pathStart", (Object)new URISyntaxChecker("pathStart"));
        dictionaryBuilder.addEntry("fragmentResolution", (Object)new TypeOnlySyntaxChecker("fragmentResolution", NodeType.STRING, new NodeType[0]));
        dictionaryBuilder.addEntry("media", (Object)MediaSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("links", (Object)LinksSyntaxChecker.getInstance());
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private DraftV4HyperSchemaSyntaxCheckerDictionary() {
    }

    public static Dictionary<SyntaxChecker> get() {
        return DICTIONARY;
    }
}

