/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.JsonParser
 *  com.fasterxml.jackson.core.JsonParser$Feature
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.google.common.collect.ImmutableMap
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URI
 *  java.util.EnumSet
 *  java.util.Iterator
 *  java.util.Map
 */
package com.github.fge.jsonschema.core.load.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.Frozen;
import com.github.fge.Thawed;
import com.github.fge.jackson.JacksonUtils;
import com.github.fge.jackson.JsonNodeReader;
import com.github.fge.jsonschema.core.load.Dereferencing;
import com.github.fge.jsonschema.core.load.configuration.LoadingConfigurationBuilder;
import com.github.fge.jsonschema.core.load.configuration.URIDownloadersRegistry;
import com.github.fge.jsonschema.core.load.download.URIDownloader;
import com.github.fge.jsonschema.core.load.uri.URITranslatorConfiguration;
import com.google.common.collect.ImmutableMap;
import java.net.URI;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

public final class LoadingConfiguration
implements Frozen<LoadingConfigurationBuilder> {
    public final int cacheSize;
    public final Dereferencing dereferencing;
    public final Map<String, URIDownloader> downloaders;
    public final EnumSet<JsonParser.Feature> parserFeatures;
    public final Map<URI, JsonNode> preloadedSchemas;
    private final JsonNodeReader reader;
    public final URITranslatorConfiguration translatorCfg;

    public LoadingConfiguration(LoadingConfigurationBuilder loadingConfigurationBuilder) {
        this.downloaders = loadingConfigurationBuilder.downloaders.build();
        this.translatorCfg = loadingConfigurationBuilder.translatorCfg;
        this.dereferencing = loadingConfigurationBuilder.dereferencing;
        this.preloadedSchemas = ImmutableMap.copyOf(loadingConfigurationBuilder.preloadedSchemas);
        this.parserFeatures = EnumSet.copyOf(loadingConfigurationBuilder.parserFeatures);
        this.reader = this.buildReader();
        this.cacheSize = loadingConfigurationBuilder.cacheSize;
    }

    private JsonNodeReader buildReader() {
        ObjectMapper objectMapper = JacksonUtils.newMapper();
        Iterator iterator = this.parserFeatures.iterator();
        while (iterator.hasNext()) {
            objectMapper.configure((JsonParser.Feature)iterator.next(), true);
        }
        return new JsonNodeReader(objectMapper);
    }

    public static LoadingConfiguration byDefault() {
        return new LoadingConfigurationBuilder().freeze();
    }

    public static LoadingConfigurationBuilder newBuilder() {
        return new LoadingConfigurationBuilder();
    }

    public int getCacheSize() {
        return this.cacheSize;
    }

    public Dereferencing getDereferencing() {
        return this.dereferencing;
    }

    public Map<String, URIDownloader> getDownloaderMap() {
        return this.downloaders;
    }

    @Deprecated
    public boolean getEnableCache() {
        return this.cacheSize != 0;
    }

    public Map<URI, JsonNode> getPreloadedSchemas() {
        return this.preloadedSchemas;
    }

    public JsonNodeReader getReader() {
        return this.reader;
    }

    public URITranslatorConfiguration getTranslatorConfiguration() {
        return this.translatorCfg;
    }

    public LoadingConfigurationBuilder thaw() {
        return new LoadingConfigurationBuilder(this);
    }
}

