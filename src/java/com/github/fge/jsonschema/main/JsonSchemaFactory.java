/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.core.load.RefResolver
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  com.google.common.base.Equivalence
 *  com.google.common.base.Function
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.github.fge.jsonschema.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.Frozen;
import com.github.fge.Thawed;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jackson.jsonpointer.JsonPointerException;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.load.RefResolver;
import com.github.fge.jsonschema.core.load.SchemaLoader;
import com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration;
import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.processing.CachingProcessor;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.processing.ProcessorMap;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.report.ReportProvider;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.library.Library;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactoryBuilder;
import com.github.fge.jsonschema.main.JsonValidator;
import com.github.fge.jsonschema.messages.JsonSchemaConfigurationBundle;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.jsonschema.processors.data.SchemaContext;
import com.github.fge.jsonschema.processors.data.ValidatorList;
import com.github.fge.jsonschema.processors.syntax.SyntaxValidator;
import com.github.fge.jsonschema.processors.validation.SchemaContextEquivalence;
import com.github.fge.jsonschema.processors.validation.ValidationChain;
import com.github.fge.jsonschema.processors.validation.ValidationProcessor;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import java.util.Map;
import java.util.Set;

public final class JsonSchemaFactory
implements Frozen<JsonSchemaFactoryBuilder> {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaConfigurationBundle.class);
    private static final MessageBundle CORE_BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    private static final Function<SchemaContext, JsonRef> FUNCTION = new Function<SchemaContext, JsonRef>(){

        public JsonRef apply(SchemaContext schemaContext) {
            return schemaContext.getSchema().getDollarSchema();
        }
    };
    private final SchemaLoader loader;
    public final LoadingConfiguration loadingCfg;
    public final ReportProvider reportProvider;
    private final SyntaxValidator syntaxValidator;
    public final ValidationConfiguration validationCfg;
    private final JsonValidator validator;

    public JsonSchemaFactory(JsonSchemaFactoryBuilder jsonSchemaFactoryBuilder) {
        SchemaLoader schemaLoader;
        LoadingConfiguration loadingConfiguration;
        ReportProvider reportProvider;
        ValidationConfiguration validationConfiguration;
        this.reportProvider = reportProvider = jsonSchemaFactoryBuilder.reportProvider;
        this.loadingCfg = loadingConfiguration = jsonSchemaFactoryBuilder.loadingCfg;
        this.validationCfg = validationConfiguration = jsonSchemaFactoryBuilder.validationCfg;
        this.loader = schemaLoader = new SchemaLoader(loadingConfiguration);
        this.validator = new JsonValidator(schemaLoader, new ValidationProcessor(validationConfiguration, this.buildProcessor()), reportProvider);
        this.syntaxValidator = new SyntaxValidator(validationConfiguration);
    }

    private Processor<SchemaContext, ValidatorList> buildProcessor() {
        RefResolver refResolver = new RefResolver(this.loader);
        Map<JsonRef, Library> map = this.validationCfg.getLibraries();
        ValidationChain validationChain = new ValidationChain(refResolver, this.validationCfg.getDefaultLibrary(), this.validationCfg);
        ProcessorMap<JsonRef, SchemaContext, ValidatorList> processorMap = new ProcessorMap<JsonRef, SchemaContext, ValidatorList>(FUNCTION);
        processorMap.setDefaultProcessor(validationChain);
        for (Map.Entry entry : map.entrySet()) {
            processorMap.addEntry((JsonRef)entry.getKey(), new ValidationChain(refResolver, (Library)entry.getValue(), this.validationCfg));
        }
        return new CachingProcessor<SchemaContext, ValidatorList>(processorMap.getProcessor(), SchemaContextEquivalence.getInstance(), this.validationCfg.getCacheSize());
    }

    public static JsonSchemaFactory byDefault() {
        return JsonSchemaFactory.newBuilder().freeze();
    }

    public static JsonSchemaFactoryBuilder newBuilder() {
        return new JsonSchemaFactoryBuilder();
    }

    public JsonSchema getJsonSchema(JsonNode jsonNode) throws ProcessingException {
        BUNDLE.checkNotNull(jsonNode, "nullSchema");
        return this.validator.buildJsonSchema(jsonNode, JsonPointer.EMPTY);
    }

    public JsonSchema getJsonSchema(JsonNode jsonNode, String string) throws ProcessingException {
        BUNDLE.checkNotNull(jsonNode, "nullSchema");
        CORE_BUNDLE.checkNotNull(string, "nullPointer");
        try {
            JsonPointer jsonPointer = new JsonPointer(string);
            JsonSchema jsonSchema = this.validator.buildJsonSchema(jsonNode, jsonPointer);
            return jsonSchema;
        }
        catch (JsonPointerException jsonPointerException) {
            throw new IllegalStateException("How did I get there??");
        }
    }

    public JsonSchema getJsonSchema(String string) throws ProcessingException {
        CORE_BUNDLE.checkNotNull(string, "nullURI");
        return this.validator.buildJsonSchema(string);
    }

    public Processor<FullData, FullData> getProcessor() {
        return this.validator.getProcessor();
    }

    public SyntaxValidator getSyntaxValidator() {
        return this.syntaxValidator;
    }

    public JsonValidator getValidator() {
        return this.validator;
    }

    public JsonSchemaFactoryBuilder thaw() {
        return new JsonSchemaFactoryBuilder(this);
    }

}

