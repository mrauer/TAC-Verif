/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
 */
package com.github.fge.jsonschema.keyword.validator;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.keyword.validator.KeywordValidator;

public interface KeywordValidatorFactory {
    public KeywordValidator getKeywordValidator(JsonNode var1) throws ProcessingException;
}

