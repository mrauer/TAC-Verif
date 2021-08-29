/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.DefinitionsSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.DraftV4DependenciesSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.DraftV4ItemsSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.DraftV4PropertiesSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.DraftV4TypeSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.NotSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.RequiredSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.DivisorSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.PositiveIntegerSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.SchemaArraySyntaxChecker
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.keyword.syntax.dictionaries;

import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.DefinitionsSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.DraftV4DependenciesSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.DraftV4ItemsSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.DraftV4PropertiesSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.DraftV4TypeSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.NotSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4.RequiredSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.DivisorSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.PositiveIntegerSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.SchemaArraySyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.dictionaries.CommonSyntaxCheckerDictionary;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;

public final class DraftV4SyntaxCheckerDictionary {
    private static final Dictionary<SyntaxChecker> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addAll(CommonSyntaxCheckerDictionary.get());
        dictionaryBuilder.addEntry("items", (Object)DraftV4ItemsSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("multipleOf", (Object)new DivisorSyntaxChecker("multipleOf"));
        dictionaryBuilder.addEntry("minProperties", (Object)new PositiveIntegerSyntaxChecker("minProperties"));
        dictionaryBuilder.addEntry("maxProperties", (Object)new PositiveIntegerSyntaxChecker("maxProperties"));
        dictionaryBuilder.addEntry("properties", (Object)DraftV4PropertiesSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("required", (Object)RequiredSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("dependencies", (Object)DraftV4DependenciesSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("allOf", (Object)new SchemaArraySyntaxChecker("allOf"));
        dictionaryBuilder.addEntry("anyOf", (Object)new SchemaArraySyntaxChecker("anyOf"));
        dictionaryBuilder.addEntry("oneOf", (Object)new SchemaArraySyntaxChecker("oneOf"));
        dictionaryBuilder.addEntry("not", (Object)NotSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("definitions", (Object)DefinitionsSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("type", (Object)DraftV4TypeSyntaxChecker.getInstance());
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private DraftV4SyntaxCheckerDictionary() {
    }

    public static Dictionary<SyntaxChecker> get() {
        return DICTIONARY;
    }
}

