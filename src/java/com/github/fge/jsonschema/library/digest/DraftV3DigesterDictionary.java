/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  com.github.fge.jsonschema.keyword.digest.draftv3.DivisibleByDigester
 *  com.github.fge.jsonschema.keyword.digest.draftv3.DraftV3DependenciesDigester
 *  com.github.fge.jsonschema.keyword.digest.draftv3.DraftV3PropertiesDigester
 *  com.github.fge.jsonschema.keyword.digest.helpers.DraftV3TypeKeywordDigester
 *  com.github.fge.jsonschema.keyword.digest.helpers.NullDigester
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.library.digest;

import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.github.fge.jsonschema.keyword.digest.draftv3.DivisibleByDigester;
import com.github.fge.jsonschema.keyword.digest.draftv3.DraftV3DependenciesDigester;
import com.github.fge.jsonschema.keyword.digest.draftv3.DraftV3PropertiesDigester;
import com.github.fge.jsonschema.keyword.digest.helpers.DraftV3TypeKeywordDigester;
import com.github.fge.jsonschema.keyword.digest.helpers.NullDigester;
import com.github.fge.jsonschema.library.digest.CommonDigesterDictionary;

public final class DraftV3DigesterDictionary {
    private static final Dictionary<Digester> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addAll(CommonDigesterDictionary.get());
        dictionaryBuilder.addEntry("divisibleBy", (Object)DivisibleByDigester.getInstance());
        dictionaryBuilder.addEntry("properties", (Object)DraftV3PropertiesDigester.getInstance());
        dictionaryBuilder.addEntry("dependencies", (Object)DraftV3DependenciesDigester.getInstance());
        dictionaryBuilder.addEntry("type", (Object)new DraftV3TypeKeywordDigester("type"));
        dictionaryBuilder.addEntry("disallow", (Object)new DraftV3TypeKeywordDigester("disallow"));
        dictionaryBuilder.addEntry("extends", (Object)new NullDigester("extends", NodeType.ARRAY, NodeType.values()));
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private DraftV3DigesterDictionary() {
    }

    public static Dictionary<Digester> get() {
        return DICTIONARY;
    }
}

