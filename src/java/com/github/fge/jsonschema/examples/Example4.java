/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.main.JsonSchemaFactory
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.github.fge.jsonschema.examples;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.examples.Utils;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.IOException;
import java.io.PrintStream;

public final class Example4 {
    private static final String SCHEMA_URI = "resource:/com/github/fge/jsonschema/examples/fstab-sub.json#/fstab";

    public static /* varargs */ void main(String ... arrstring) throws IOException, ProcessingException {
        JsonNode jsonNode = Utils.loadResource("/fstab-good.json");
        JsonNode jsonNode2 = Utils.loadResource("/fstab-bad.json");
        JsonNode jsonNode3 = Utils.loadResource("/fstab-bad2.json");
        JsonSchema jsonSchema = JsonSchemaFactory.byDefault().getJsonSchema(SCHEMA_URI);
        ProcessingReport processingReport = jsonSchema.validate(jsonNode);
        System.out.println((Object)processingReport);
        ProcessingReport processingReport2 = jsonSchema.validate(jsonNode2);
        System.out.println((Object)processingReport2);
        ProcessingReport processingReport3 = jsonSchema.validate(jsonNode3);
        System.out.println((Object)processingReport3);
    }
}

