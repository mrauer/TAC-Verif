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
import com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration;
import com.github.fge.jsonschema.core.load.configuration.LoadingConfigurationBuilder;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.examples.Utils;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonSchemaFactoryBuilder;
import java.io.IOException;
import java.io.PrintStream;

public final class Example10 {
    private static final String URI_BASE = "xxx://foo.bar/path/to/";

    public static /* varargs */ void main(String ... arrstring) throws IOException, ProcessingException {
        LoadingConfigurationBuilder loadingConfigurationBuilder = LoadingConfiguration.newBuilder();
        loadingConfigurationBuilder.preloadSchema("xxx://foo.bar/path/to/fstab.json", Utils.loadResource("/split/fstab.json"));
        loadingConfigurationBuilder.preloadSchema("xxx://foo.bar/path/to/mntent.json", Utils.loadResource("/split/mntent.json"));
        JsonSchema jsonSchema = JsonSchemaFactory.newBuilder().setLoadingConfiguration(loadingConfigurationBuilder.freeze()).freeze().getJsonSchema("xxx://foo.bar/path/to/fstab.json");
        JsonNode jsonNode = Utils.loadResource("/fstab-good.json");
        JsonNode jsonNode2 = Utils.loadResource("/fstab-bad.json");
        JsonNode jsonNode3 = Utils.loadResource("/fstab-bad2.json");
        ProcessingReport processingReport = jsonSchema.validate(jsonNode);
        System.out.println((Object)processingReport);
        ProcessingReport processingReport2 = jsonSchema.validate(jsonNode2);
        System.out.println((Object)processingReport2);
        ProcessingReport processingReport3 = jsonSchema.validate(jsonNode3);
        System.out.println((Object)processingReport3);
    }
}

