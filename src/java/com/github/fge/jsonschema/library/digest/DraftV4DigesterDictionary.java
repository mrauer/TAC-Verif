/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  com.github.fge.jsonschema.keyword.digest.draftv4.DraftV4DependenciesDigester
 *  com.github.fge.jsonschema.keyword.digest.draftv4.DraftV4TypeDigester
 *  com.github.fge.jsonschema.keyword.digest.draftv4.MultipleOfDigester
 *  com.github.fge.jsonschema.keyword.digest.draftv4.RequiredDigester
 *  com.github.fge.jsonschema.keyword.digest.helpers.NullDigester
 *  com.github.fge.jsonschema.keyword.digest.helpers.SimpleDigester
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.library.digest;

import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.github.fge.jsonschema.keyword.digest.draftv4.DraftV4DependenciesDigester;
import com.github.fge.jsonschema.keyword.digest.draftv4.DraftV4TypeDigester;
import com.github.fge.jsonschema.keyword.digest.draftv4.MultipleOfDigester;
import com.github.fge.jsonschema.keyword.digest.draftv4.RequiredDigester;
import com.github.fge.jsonschema.keyword.digest.helpers.NullDigester;
import com.github.fge.jsonschema.keyword.digest.helpers.SimpleDigester;
import com.github.fge.jsonschema.library.digest.CommonDigesterDictionary;

public final class DraftV4DigesterDictionary {
    private static final Dictionary<Digester> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addAll(CommonDigesterDictionary.get());
        dictionaryBuilder.addEntry("multipleOf", (Object)MultipleOfDigester.getInstance());
        NodeType nodeType = NodeType.OBJECT;
        dictionaryBuilder.addEntry("minProperties", (Object)new SimpleDigester("minProperties", nodeType, new NodeType[0]));
        dictionaryBuilder.addEntry("maxProperties", (Object)new SimpleDigester("maxProperties", nodeType, new NodeType[0]));
        dictionaryBuilder.addEntry("required", (Object)RequiredDigester.getInstance());
        dictionaryBuilder.addEntry("dependencies", (Object)DraftV4DependenciesDigester.getInstance());
        NodeType nodeType2 = NodeType.ARRAY;
        dictionaryBuilder.addEntry("anyOf", (Object)new NullDigester("anyOf", nodeType2, NodeType.values()));
        dictionaryBuilder.addEntry("allOf", (Object)new NullDigester("allOf", nodeType2, NodeType.values()));
        dictionaryBuilder.addEntry("oneOf", (Object)new NullDigester("oneOf", nodeType2, NodeType.values()));
        dictionaryBuilder.addEntry("not", (Object)new NullDigester("not", nodeType2, NodeType.values()));
        dictionaryBuilder.addEntry("type", (Object)DraftV4TypeDigester.getInstance());
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private DraftV4DigesterDictionary() {
    }

    public static Dictionary<Digester> get() {
        return DICTIONARY;
    }
}

