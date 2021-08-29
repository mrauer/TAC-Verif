/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  com.github.fge.jsonschema.keyword.digest.common.AdditionalItemsDigester
 *  com.github.fge.jsonschema.keyword.digest.common.AdditionalPropertiesDigester
 *  com.github.fge.jsonschema.keyword.digest.common.MaximumDigester
 *  com.github.fge.jsonschema.keyword.digest.common.MinimumDigester
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
import com.github.fge.jsonschema.keyword.digest.common.AdditionalItemsDigester;
import com.github.fge.jsonschema.keyword.digest.common.AdditionalPropertiesDigester;
import com.github.fge.jsonschema.keyword.digest.common.MaximumDigester;
import com.github.fge.jsonschema.keyword.digest.common.MinimumDigester;
import com.github.fge.jsonschema.keyword.digest.helpers.NullDigester;
import com.github.fge.jsonschema.keyword.digest.helpers.SimpleDigester;

public final class CommonDigesterDictionary {
    private static final Dictionary<Digester> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addEntry("additionalItems", (Object)AdditionalItemsDigester.getInstance());
        NodeType nodeType = NodeType.ARRAY;
        dictionaryBuilder.addEntry("minItems", (Object)new SimpleDigester("minItems", nodeType, new NodeType[0]));
        dictionaryBuilder.addEntry("maxItems", (Object)new SimpleDigester("maxItems", nodeType, new NodeType[0]));
        dictionaryBuilder.addEntry("uniqueItems", (Object)new SimpleDigester("uniqueItems", nodeType, new NodeType[0]));
        dictionaryBuilder.addEntry("minimum", (Object)MinimumDigester.getInstance());
        dictionaryBuilder.addEntry("maximum", (Object)MaximumDigester.getInstance());
        dictionaryBuilder.addEntry("additionalProperties", (Object)AdditionalPropertiesDigester.getInstance());
        NodeType nodeType2 = NodeType.STRING;
        dictionaryBuilder.addEntry("minLength", (Object)new SimpleDigester("minLength", nodeType2, new NodeType[0]));
        dictionaryBuilder.addEntry("maxLength", (Object)new SimpleDigester("maxLength", nodeType2, new NodeType[0]));
        dictionaryBuilder.addEntry("pattern", (Object)new NullDigester("pattern", nodeType2, new NodeType[0]));
        dictionaryBuilder.addEntry("enum", (Object)new SimpleDigester("enum", nodeType, NodeType.values()));
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private CommonDigesterDictionary() {
    }

    public static Dictionary<Digester> get() {
        return DICTIONARY;
    }
}

