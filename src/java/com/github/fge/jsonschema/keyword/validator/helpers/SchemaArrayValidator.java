/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  java.lang.String
 */
package com.github.fge.jsonschema.keyword.validator.helpers;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;

public abstract class SchemaArrayValidator
extends AbstractKeywordValidator {
    public static final JsonNodeFactory FACTORY = JsonNodeFactory.instance;

    public SchemaArrayValidator(String string) {
        super(string);
    }

    @Override
    public final String toString() {
        return this.keyword;
    }
}

