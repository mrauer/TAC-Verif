/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.JsonParser
 *  com.fasterxml.jackson.core.JsonParser$Feature
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URI
 *  java.util.EnumSet
 *  java.util.HashMap
 *  java.util.Map
 */
package com.github.fge.jsonschema.core.load.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.Frozen;
import com.github.fge.Thawed;
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.core.exceptions.JsonReferenceException;
import com.github.fge.jsonschema.core.load.Dereferencing;
import com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration;
import com.github.fge.jsonschema.core.load.configuration.URIDownloadersRegistry;
import com.github.fge.jsonschema.core.load.download.URIDownloader;
import com.github.fge.jsonschema.core.load.uri.URITranslatorConfiguration;
import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.util.Registry;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import java.net.URI;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public final class LoadingConfigurationBuilder
implements Thawed<LoadingConfiguration> {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    private static final int DEFAULT_CACHE_SIZE = 512;
    private static final EnumSet<JsonParser.Feature> DEFAULT_PARSER_FEATURES = EnumSet.noneOf(JsonParser.Feature.class);
    public int cacheSize;
    public Dereferencing dereferencing;
    public final URIDownloadersRegistry downloaders;
    public final EnumSet<JsonParser.Feature> parserFeatures;
    public final Map<URI, JsonNode> preloadedSchemas;
    public URITranslatorConfiguration translatorCfg;

    public static {
        JsonParser.Feature[] arrfeature = JsonParser.Feature.values();
        for (int i = 0; i < 15; ++i) {
            JsonParser.Feature feature = arrfeature[i];
            if (!feature.enabledByDefault()) continue;
            DEFAULT_PARSER_FEATURES.add((Object)feature);
        }
    }

    public LoadingConfigurationBuilder() {
        this.downloaders = new URIDownloadersRegistry();
        this.cacheSize = 512;
        this.translatorCfg = URITranslatorConfiguration.byDefault();
        this.dereferencing = Dereferencing.CANONICAL;
        this.preloadedSchemas = new HashMap();
        SchemaVersion[] arrschemaVersion = SchemaVersion.values();
        for (int i = 0; i < 3; ++i) {
            SchemaVersion schemaVersion = arrschemaVersion[i];
            this.preloadedSchemas.put((Object)schemaVersion.getLocation(), (Object)schemaVersion.getSchema());
        }
        this.parserFeatures = EnumSet.copyOf(DEFAULT_PARSER_FEATURES);
    }

    public LoadingConfigurationBuilder(LoadingConfiguration loadingConfiguration) {
        URIDownloadersRegistry uRIDownloadersRegistry;
        this.downloaders = uRIDownloadersRegistry = new URIDownloadersRegistry();
        this.cacheSize = 512;
        uRIDownloadersRegistry.putAll(loadingConfiguration.downloaders);
        this.translatorCfg = loadingConfiguration.translatorCfg;
        this.dereferencing = loadingConfiguration.dereferencing;
        this.preloadedSchemas = new HashMap(loadingConfiguration.preloadedSchemas);
        this.parserFeatures = EnumSet.copyOf(loadingConfiguration.parserFeatures);
        this.cacheSize = loadingConfiguration.cacheSize;
    }

    private static URI getLocator(String string) {
        JsonRef jsonRef;
        try {
            jsonRef = JsonRef.fromString(string);
        }
        catch (JsonReferenceException jsonReferenceException) {
            throw new IllegalArgumentException(jsonReferenceException.getMessage());
        }
        BUNDLE.checkArgumentPrintf(jsonRef.isAbsolute(), "jsonRef.notAbsolute", jsonRef);
        return jsonRef.getLocator();
    }

    public LoadingConfigurationBuilder addParserFeature(JsonParser.Feature feature) {
        BUNDLE.checkNotNull(feature, "loadingCfg.nullJsonParserFeature");
        this.parserFeatures.add((Object)feature);
        return this;
    }

    public LoadingConfigurationBuilder addScheme(String string, URIDownloader uRIDownloader) {
        this.downloaders.put(string, uRIDownloader);
        return this;
    }

    public LoadingConfigurationBuilder dereferencing(Dereferencing dereferencing) {
        BUNDLE.checkNotNull(dereferencing, "loadingCfg.nullDereferencingMode");
        this.dereferencing = dereferencing;
        return this;
    }

    public LoadingConfiguration freeze() {
        return new LoadingConfiguration(this);
    }

    public LoadingConfigurationBuilder preloadSchema(JsonNode jsonNode) {
        JsonNode jsonNode2 = jsonNode.path("id");
        BUNDLE.checkArgument(jsonNode2.isTextual(), "loadingCfg.noIDInSchema");
        return this.preloadSchema(jsonNode2.textValue(), jsonNode);
    }

    public LoadingConfigurationBuilder preloadSchema(String string, JsonNode jsonNode) {
        MessageBundle messageBundle = BUNDLE;
        messageBundle.checkNotNull(jsonNode, "loadingCfg.nullSchema");
        URI uRI = LoadingConfigurationBuilder.getLocator(string);
        boolean bl = this.preloadedSchemas.put((Object)uRI, (Object)jsonNode) == null;
        messageBundle.checkArgumentPrintf(bl, "loadingCfg.duplicateURI", new Object[]{uRI});
        return this;
    }

    public LoadingConfigurationBuilder removeParserFeature(JsonParser.Feature feature) {
        BUNDLE.checkNotNull(feature, "loadingCfg.nullJsonParserFeature");
        if (feature != JsonParser.Feature.AUTO_CLOSE_SOURCE) {
            this.parserFeatures.remove((Object)feature);
        }
        return this;
    }

    public LoadingConfigurationBuilder removeScheme(String string) {
        this.downloaders.remove(string);
        return this;
    }

    public LoadingConfigurationBuilder setCacheSize(int n) {
        this.cacheSize = n;
        return this;
    }

    @Deprecated
    public LoadingConfigurationBuilder setEnableCache(boolean bl) {
        int n = bl ? 512 : 0;
        this.cacheSize = n;
        return this;
    }

    public LoadingConfigurationBuilder setURITranslatorConfiguration(URITranslatorConfiguration uRITranslatorConfiguration) {
        this.translatorCfg = uRITranslatorConfiguration;
        return this;
    }
}

