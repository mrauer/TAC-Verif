/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  com.github.fge.jsonschema.keyword.validator.ReflectionKeywordValidatorFactory
 *  com.github.fge.jsonschema.keyword.validator.common.AdditionalItemsValidator
 *  com.github.fge.jsonschema.keyword.validator.common.AdditionalPropertiesValidator
 *  com.github.fge.jsonschema.keyword.validator.common.EnumValidator
 *  com.github.fge.jsonschema.keyword.validator.common.MaxItemsValidator
 *  com.github.fge.jsonschema.keyword.validator.common.MaxLengthValidator
 *  com.github.fge.jsonschema.keyword.validator.common.MaximumValidator
 *  com.github.fge.jsonschema.keyword.validator.common.MinItemsValidator
 *  com.github.fge.jsonschema.keyword.validator.common.MinLengthValidator
 *  com.github.fge.jsonschema.keyword.validator.common.MinimumValidator
 *  com.github.fge.jsonschema.keyword.validator.common.PatternValidator
 *  com.github.fge.jsonschema.keyword.validator.common.UniqueItemsValidator
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
import com.github.fge.jsonschema.keyword.validator.common.AdditionalItemsValidator;
import com.github.fge.jsonschema.keyword.validator.common.AdditionalPropertiesValidator;
import com.github.fge.jsonschema.keyword.validator.common.EnumValidator;
import com.github.fge.jsonschema.keyword.validator.common.MaxItemsValidator;
import com.github.fge.jsonschema.keyword.validator.common.MaxLengthValidator;
import com.github.fge.jsonschema.keyword.validator.common.MaximumValidator;
import com.github.fge.jsonschema.keyword.validator.common.MinItemsValidator;
import com.github.fge.jsonschema.keyword.validator.common.MinLengthValidator;
import com.github.fge.jsonschema.keyword.validator.common.MinimumValidator;
import com.github.fge.jsonschema.keyword.validator.common.PatternValidator;
import com.github.fge.jsonschema.keyword.validator.common.UniqueItemsValidator;

public final class CommonValidatorDictionary {
    private static final Dictionary<KeywordValidatorFactory> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addEntry("additionalItems", (Object)CommonValidatorDictionary.factory("additionalItems", AdditionalItemsValidator.class));
        dictionaryBuilder.addEntry("minItems", (Object)CommonValidatorDictionary.factory("minItems", MinItemsValidator.class));
        dictionaryBuilder.addEntry("maxItems", (Object)CommonValidatorDictionary.factory("maxItems", MaxItemsValidator.class));
        dictionaryBuilder.addEntry("uniqueItems", (Object)CommonValidatorDictionary.factory("uniqueItems", UniqueItemsValidator.class));
        dictionaryBuilder.addEntry("minimum", (Object)CommonValidatorDictionary.factory("minimum", MinimumValidator.class));
        dictionaryBuilder.addEntry("maximum", (Object)CommonValidatorDictionary.factory("maximum", MaximumValidator.class));
        dictionaryBuilder.addEntry("additionalProperties", (Object)CommonValidatorDictionary.factory("additionalProperties", AdditionalPropertiesValidator.class));
        dictionaryBuilder.addEntry("minLength", (Object)CommonValidatorDictionary.factory("minLength", MinLengthValidator.class));
        dictionaryBuilder.addEntry("maxLength", (Object)CommonValidatorDictionary.factory("maxLength", MaxLengthValidator.class));
        dictionaryBuilder.addEntry("pattern", (Object)CommonValidatorDictionary.factory("pattern", PatternValidator.class));
        dictionaryBuilder.addEntry("enum", (Object)CommonValidatorDictionary.factory("enum", EnumValidator.class));
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private CommonValidatorDictionary() {
    }

    private static KeywordValidatorFactory factory(String string, Class<? extends KeywordValidator> class_) {
        return new ReflectionKeywordValidatorFactory(string, class_);
    }

    public static Dictionary<KeywordValidatorFactory> get() {
        return DICTIONARY;
    }
}

