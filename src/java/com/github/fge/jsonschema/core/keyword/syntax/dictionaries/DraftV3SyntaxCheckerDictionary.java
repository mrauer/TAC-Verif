/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3.DraftV3DependenciesSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3.DraftV3ItemsSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3.DraftV3PropertiesSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3.DraftV3TypeKeywordSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3.ExtendsSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.DivisorSyntaxChecker
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.keyword.syntax.dictionaries;

import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3.DraftV3DependenciesSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3.DraftV3ItemsSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3.DraftV3PropertiesSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3.DraftV3TypeKeywordSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3.ExtendsSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.DivisorSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.dictionaries.CommonSyntaxCheckerDictionary;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;

public final class DraftV3SyntaxCheckerDictionary {
    private static final Dictionary<SyntaxChecker> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addAll(CommonSyntaxCheckerDictionary.get());
        dictionaryBuilder.addEntry("items", (Object)DraftV3ItemsSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("divisibleBy", (Object)new DivisorSyntaxChecker("divisibleBy"));
        dictionaryBuilder.addEntry("properties", (Object)DraftV3PropertiesSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("dependencies", (Object)DraftV3DependenciesSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("extends", (Object)ExtendsSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("type", (Object)new DraftV3TypeKeywordSyntaxChecker("type"));
        dictionaryBuilder.addEntry("disallow", (Object)new DraftV3TypeKeywordSyntaxChecker("disallow"));
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private DraftV3SyntaxCheckerDictionary() {
    }

    public static Dictionary<SyntaxChecker> get() {
        return DICTIONARY;
    }
}

