/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.fge.jsonschema.keyword.validator.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;

public abstract class PositiveIntegerValidator
extends AbstractKeywordValidator {
    public final int intValue;

    public PositiveIntegerValidator(String string, JsonNode jsonNode) {
        super(string);
        this.intValue = jsonNode.get(string).intValue();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.keyword);
        stringBuilder.append(": ");
        stringBuilder.append(this.intValue);
        return stringBuilder.toString();
    }
}

