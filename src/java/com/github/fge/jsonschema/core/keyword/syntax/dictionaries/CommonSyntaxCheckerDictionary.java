/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.common.AdditionalSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.common.EnumSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.common.ExclusiveMaximumSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.common.ExclusiveMinimumSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.common.PatternPropertiesSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.common.PatternSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.PositiveIntegerSyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.TypeOnlySyntaxChecker
 *  com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.URISyntaxChecker
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.keyword.syntax.dictionaries;

import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.common.AdditionalSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.common.EnumSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.common.ExclusiveMaximumSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.common.ExclusiveMinimumSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.common.PatternPropertiesSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.common.PatternSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.PositiveIntegerSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.TypeOnlySyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.URISyntaxChecker;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;

public final class CommonSyntaxCheckerDictionary {
    private static final Dictionary<SyntaxChecker> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addEntry("additionalItems", (Object)new AdditionalSyntaxChecker("additionalItems"));
        dictionaryBuilder.addEntry("minItems", (Object)new PositiveIntegerSyntaxChecker("minItems"));
        dictionaryBuilder.addEntry("maxItems", (Object)new PositiveIntegerSyntaxChecker("maxItems"));
        NodeType nodeType = NodeType.BOOLEAN;
        dictionaryBuilder.addEntry("uniqueItems", (Object)new TypeOnlySyntaxChecker("uniqueItems", nodeType, new NodeType[0]));
        NodeType nodeType2 = NodeType.INTEGER;
        NodeType nodeType3 = NodeType.NUMBER;
        NodeType[] arrnodeType = new NodeType[]{nodeType3};
        dictionaryBuilder.addEntry("minimum", (Object)new TypeOnlySyntaxChecker("minimum", nodeType2, arrnodeType));
        dictionaryBuilder.addEntry("exclusiveMinimum", (Object)ExclusiveMinimumSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("maximum", (Object)new TypeOnlySyntaxChecker("maximum", nodeType2, new NodeType[]{nodeType3}));
        dictionaryBuilder.addEntry("exclusiveMaximum", (Object)ExclusiveMaximumSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("additionalProperties", (Object)new AdditionalSyntaxChecker("additionalProperties"));
        dictionaryBuilder.addEntry("patternProperties", (Object)PatternPropertiesSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("required", (Object)new TypeOnlySyntaxChecker("required", nodeType, new NodeType[0]));
        dictionaryBuilder.addEntry("minLength", (Object)new PositiveIntegerSyntaxChecker("minLength"));
        dictionaryBuilder.addEntry("maxLength", (Object)new PositiveIntegerSyntaxChecker("maxLength"));
        dictionaryBuilder.addEntry("pattern", (Object)PatternSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("$schema", (Object)new URISyntaxChecker("$schema"));
        dictionaryBuilder.addEntry("$ref", (Object)new URISyntaxChecker("$ref"));
        dictionaryBuilder.addEntry("id", (Object)new URISyntaxChecker("id"));
        NodeType nodeType4 = NodeType.STRING;
        dictionaryBuilder.addEntry("description", (Object)new TypeOnlySyntaxChecker("description", nodeType4, new NodeType[0]));
        dictionaryBuilder.addEntry("title", (Object)new TypeOnlySyntaxChecker("title", nodeType4, new NodeType[0]));
        dictionaryBuilder.addEntry("enum", (Object)EnumSyntaxChecker.getInstance());
        dictionaryBuilder.addEntry("format", (Object)new TypeOnlySyntaxChecker("format", nodeType4, new NodeType[0]));
        dictionaryBuilder.addEntry("default", (Object)new TypeOnlySyntaxChecker("default", NodeType.ARRAY, NodeType.values()));
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private CommonSyntaxCheckerDictionary() {
    }

    public static Dictionary<SyntaxChecker> get() {
        return DICTIONARY;
    }
}

