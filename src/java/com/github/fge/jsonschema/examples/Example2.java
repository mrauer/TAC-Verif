/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration
 *  com.github.fge.jsonschema.core.load.configuration.LoadingConfigurationBuilder
 *  com.github.fge.jsonschema.main.JsonSchemaFactory
 *  com.github.fge.jsonschema.main.JsonSchemaFactoryBuilder
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.github.fge.jsonschema.examples;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.load.Dereferencing;
import com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration;
import com.github.fge.jsonschema.core.load.configuration.LoadingConfigurationBuilder;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.examples.Utils;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonSchemaFactoryBuilder;
import java.io.IOException;
import java.io.PrintStream;

public final class Example2 {
    public static /* varargs */ void main(String ... arrstring) throws IOException, ProcessingException {
        JsonNode jsonNode = Utils.loadResource("/fstab-inline.json");
        JsonNode jsonNode2 = Utils.loadResource("/fstab-good.json");
        JsonNode jsonNode3 = Utils.loadResource("/fstab-bad.json");
        JsonNode jsonNode4 = Utils.loadResource("/fstab-bad2.json");
        LoadingConfiguration loadingConfiguration = LoadingConfiguration.newBuilder().dereferencing(Dereferencing.INLINE).freeze();
        JsonSchema jsonSchema = JsonSchemaFactory.newBuilder().setLoadingConfiguration(loadingConfiguration).freeze().getJsonSchema(jsonNode);
        ProcessingReport processingReport = jsonSchema.validate(jsonNode2);
        System.out.println((Object)processingReport);
        ProcessingReport processingReport2 = jsonSchema.validate(jsonNode3);
        System.out.println((Object)processingReport2);
        ProcessingReport processingReport3 = jsonSchema.validate(jsonNode4);
        System.out.println((Object)processingReport3);
    }
}

