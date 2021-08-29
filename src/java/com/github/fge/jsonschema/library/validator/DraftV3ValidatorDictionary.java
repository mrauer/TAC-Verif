/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  com.github.fge.jsonschema.keyword.validator.ReflectionKeywordValidatorFactory
 *  com.github.fge.jsonschema.keyword.validator.common.DependenciesValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv3.DisallowKeywordValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv3.DivisibleByValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv3.DraftV3TypeValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv3.ExtendsValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv3.PropertiesValidator
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.library.validator;

import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;
import com.github.fge.jsonschema.keyword.validator.KeywordValidator;
import com.github.fge.jsonschema.keyword.validator.KeywordValidatorFactory;
import com.github.fge.jsonschema.keyword.validator.ReflectionKeywordValidatorFactory;
import com.github.fge.jsonschema.keyword.validator.common.DependenciesValidator;
import com.github.fge.jsonschema.keyword.validator.draftv3.DisallowKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.draftv3.DivisibleByValidator;
import com.github.fge.jsonschema.keyword.validator.draftv3.DraftV3TypeValidator;
import com.github.fge.jsonschema.keyword.validator.draftv3.ExtendsValidator;
import com.github.fge.jsonschema.keyword.validator.draftv3.PropertiesValidator;
import com.github.fge.jsonschema.library.validator.CommonValidatorDictionary;

public final class DraftV3ValidatorDictionary {
    private static final Dictionary<KeywordValidatorFactory> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addAll(CommonValidatorDictionary.get());
        dictionaryBuilder.addEntry("divisibleBy", (Object)DraftV3ValidatorDictionary.factory("divisibleBy", DivisibleByValidator.class));
        dictionaryBuilder.addEntry("properties", (Object)DraftV3ValidatorDictionary.factory("properties", PropertiesValidator.class));
        dictionaryBuilder.addEntry("dependencies", (Object)DraftV3ValidatorDictionary.factory("dependencies", DependenciesValidator.class));
        dictionaryBuilder.addEntry("type", (Object)DraftV3ValidatorDictionary.factory("type", DraftV3TypeValidator.class));
        dictionaryBuilder.addEntry("disallow", (Object)DraftV3ValidatorDictionary.factory("disallow", DisallowKeywordValidator.class));
        dictionaryBuilder.addEntry("extends", (Object)DraftV3ValidatorDictionary.factory("extends", ExtendsValidator.class));
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private DraftV3ValidatorDictionary() {
    }

    private static KeywordValidatorFactory factory(String string, Class<? extends KeywordValidator> class_) {
        return new ReflectionKeywordValidatorFactory(string, class_);
    }

    public static Dictionary<KeywordValidatorFactory> get() {
        return DICTIONARY;
    }
}

