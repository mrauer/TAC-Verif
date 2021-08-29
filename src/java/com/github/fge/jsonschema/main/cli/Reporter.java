/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.main.cli;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.cli.RetCode;
import com.github.fge.jsonschema.processors.syntax.SyntaxValidator;
import java.io.IOException;

public interface Reporter {
    public RetCode validateInstance(JsonSchema var1, String var2, JsonNode var3) throws IOException, ProcessingException;

    public RetCode validateSchema(SyntaxValidator var1, String var2, JsonNode var3) throws IOException;
}

