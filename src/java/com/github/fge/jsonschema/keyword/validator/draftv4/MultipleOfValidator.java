/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.String
 */
package com.github.fge.jsonschema.keyword.validator.draftv4;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.keyword.validator.helpers.DivisorValidator;

public final class MultipleOfValidator
extends DivisorValidator {
    public MultipleOfValidator(JsonNode jsonNode) {
        super("multipleOf", jsonNode);
    }
}

