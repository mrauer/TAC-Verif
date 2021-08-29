/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
 */
package com.github.fge.jsonschema.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;

public interface JsonSchema {
    public boolean validInstance(JsonNode var1) throws ProcessingException;

    public boolean validInstanceUnchecked(JsonNode var1);

    public ProcessingReport validate(JsonNode var1) throws ProcessingException;

    public ProcessingReport validate(JsonNode var1, boolean var2) throws ProcessingException;

    public ProcessingReport validateUnchecked(JsonNode var1);

    public ProcessingReport validateUnchecked(JsonNode var1, boolean var2);
}

