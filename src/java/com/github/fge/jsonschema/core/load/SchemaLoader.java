/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.core.load.SchemaLoader$1
 *  com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration
 *  com.github.fge.jsonschema.core.load.uri.URITranslatorConfiguration
 *  com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle
 *  com.github.fge.jsonschema.core.report.ProcessingMessage
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.google.common.cache.CacheBuilder
 *  com.google.common.cache.CacheLoader
 *  com.google.common.cache.LoadingCache
 *  com.google.common.cache.LocalCache
 *  com.google.common.cache.LocalCache$LocalLoadingCache
 *  com.google.common.collect.ImmutableMap
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.URI
 *  java.util.Map
 *  java.util.concurrent.ExecutionException
 */
package com.github.fge.jsonschema.core.load;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.load.Dereferencing;
import com.github.fge.jsonschema.core.load.SchemaLoader;
import com.github.fge.jsonschema.core.load.URIManager;
import com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration;
import com.github.fge.jsonschema.core.load.uri.URITranslator;
import com.github.fge.jsonschema.core.load.uri.URITranslatorConfiguration;
import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import com.google.android.material.R;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.LocalCache;
import com.google.common.collect.ImmutableMap;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public final class SchemaLoader {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    private final LoadingCache<URI, JsonNode> cache;
    private final Dereferencing dereferencing;
    private final URIManager manager;
    private final Map<URI, JsonNode> preloadedSchemas;
    private final URITranslator translator;

    public SchemaLoader() {
        this(LoadingConfiguration.byDefault());
    }

    public SchemaLoader(LoadingConfiguration loadingConfiguration) {
        this.translator = new URITranslator(loadingConfiguration.getTranslatorConfiguration());
        this.dereferencing = loadingConfiguration.getDereferencing();
        this.manager = new URIManager(loadingConfiguration);
        this.preloadedSchemas = ImmutableMap.copyOf((Map)loadingConfiguration.getPreloadedSchemas());
        CacheBuilder cacheBuilder = new CacheBuilder();
        if (loadingConfiguration.getCacheSize() != -1) {
            cacheBuilder.maximumSize((long)loadingConfiguration.getCacheSize());
        }
        1 var3_3 = new 1(this);
        R.style.checkState((boolean)true, (Object)"maximumWeight requires weigher");
        this.cache = new LocalCache.LocalLoadingCache(cacheBuilder, (CacheLoader)var3_3);
    }

    public static /* synthetic */ URIManager access$000(SchemaLoader schemaLoader) {
        return schemaLoader.manager;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public SchemaTree get(URI uRI) throws ProcessingException {
        JsonNode jsonNode;
        JsonRef jsonRef = JsonRef.fromURI(this.translator.translate(uRI));
        if (!jsonRef.isAbsolute()) throw new ProcessingException(new ProcessingMessage().setMessage(BUNDLE.getMessage("refProcessing.uriNotAbsolute")).putArgument("uri", (Object)jsonRef));
        URI uRI2 = jsonRef.toURI();
        try {
            jsonNode = (JsonNode)this.preloadedSchemas.get((Object)uRI2);
            if (jsonNode != null) return this.dereferencing.newTree(jsonRef, jsonNode);
        }
        catch (ExecutionException executionException) {
            throw (ProcessingException)executionException.getCause();
        }
        jsonNode = (JsonNode)((LocalCache.LocalLoadingCache)this.cache).get((Object)uRI2);
        return this.dereferencing.newTree(jsonRef, jsonNode);
    }

    public SchemaTree load(JsonNode jsonNode) {
        BUNDLE.checkNotNull((Object)jsonNode, "loadingCfg.nullSchema");
        return this.dereferencing.newTree(jsonNode);
    }

    public String toString() {
        return this.cache.toString();
    }
}

