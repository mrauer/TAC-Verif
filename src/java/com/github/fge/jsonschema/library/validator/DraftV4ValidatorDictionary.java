/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  com.github.fge.jsonschema.keyword.validator.ReflectionKeywordValidatorFactory
 *  com.github.fge.jsonschema.keyword.validator.common.DependenciesValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv4.AllOfValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv4.AnyOfValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv4.DraftV4TypeValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv4.MaxPropertiesValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv4.MinPropertiesValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv4.MultipleOfValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv4.NotValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv4.OneOfValidator
 *  com.github.fge.jsonschema.keyword.validator.draftv4.RequiredKeywordValidator
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
import com.github.fge.jsonschema.keyword.validator.draftv4.AllOfValidator;
import com.github.fge.jsonschema.keyword.validator.draftv4.AnyOfValidator;
import com.github.fge.jsonschema.keyword.validator.draftv4.DraftV4TypeValidator;
import com.github.fge.jsonschema.keyword.validator.draftv4.MaxPropertiesValidator;
import com.github.fge.jsonschema.keyword.validator.draftv4.MinPropertiesValidator;
import com.github.fge.jsonschema.keyword.validator.draftv4.MultipleOfValidator;
import com.github.fge.jsonschema.keyword.validator.draftv4.NotValidator;
import com.github.fge.jsonschema.keyword.validator.draftv4.OneOfValidator;
import com.github.fge.jsonschema.keyword.validator.draftv4.RequiredKeywordValidator;
import com.github.fge.jsonschema.library.validator.CommonValidatorDictionary;

public final class DraftV4ValidatorDictionary {
    private static final Dictionary<KeywordValidatorFactory> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addAll(CommonValidatorDictionary.get());
        dictionaryBuilder.addEntry("multipleOf", (Object)DraftV4ValidatorDictionary.factory("multipleOf", MultipleOfValidator.class));
        dictionaryBuilder.addEntry("minProperties", (Object)DraftV4ValidatorDictionary.factory("minProperties", MinPropertiesValidator.class));
        dictionaryBuilder.addEntry("maxProperties", (Object)DraftV4ValidatorDictionary.factory("maxProperties", MaxPropertiesValidator.class));
        dictionaryBuilder.addEntry("required", (Object)DraftV4ValidatorDictionary.factory("required", RequiredKeywordValidator.class));
        dictionaryBuilder.addEntry("dependencies", (Object)DraftV4ValidatorDictionary.factory("dependencies", DependenciesValidator.class));
        dictionaryBuilder.addEntry("anyOf", (Object)DraftV4ValidatorDictionary.factory("anyOf", AnyOfValidator.class));
        dictionaryBuilder.addEntry("allOf", (Object)DraftV4ValidatorDictionary.factory("allOf", AllOfValidator.class));
        dictionaryBuilder.addEntry("oneOf", (Object)DraftV4ValidatorDictionary.factory("oneOf", OneOfValidator.class));
        dictionaryBuilder.addEntry("not", (Object)DraftV4ValidatorDictionary.factory("not", NotValidator.class));
        dictionaryBuilder.addEntry("type", (Object)DraftV4ValidatorDictionary.factory("type", DraftV4TypeValidator.class));
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private DraftV4ValidatorDictionary() {
    }

    private static KeywordValidatorFactory factory(String string, Class<? extends KeywordValidator> class_) {
        return new ReflectionKeywordValidatorFactory(string, class_);
    }

    public static Dictionary<KeywordValidatorFactory> get() {
        return DICTIONARY;
    }
}

