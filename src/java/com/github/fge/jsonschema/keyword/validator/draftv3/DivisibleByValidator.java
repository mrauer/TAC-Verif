/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.String
 */
package com.github.fge.jsonschema.keyword.validator.draftv3;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.keyword.validator.helpers.DivisorValidator;

public final class DivisibleByValidator
extends DivisorValidator {
    public DivisibleByValidator(JsonNode jsonNode) {
        super("divisibleBy", jsonNode);
    }
}

