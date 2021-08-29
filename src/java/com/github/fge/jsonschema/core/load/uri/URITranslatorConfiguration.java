/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  java.lang.Object
 *  java.net.URI
 *  java.util.Map
 */
package com.github.fge.jsonschema.core.load.uri;

import com.github.fge.Frozen;
import com.github.fge.Thawed;
import com.github.fge.jsonschema.core.load.uri.PathRedirectRegistry;
import com.github.fge.jsonschema.core.load.uri.SchemaRedirectRegistry;
import com.github.fge.jsonschema.core.load.uri.URITranslatorConfigurationBuilder;
import com.google.common.collect.ImmutableMap;
import java.net.URI;
import java.util.Map;

public final class URITranslatorConfiguration
implements Frozen<URITranslatorConfigurationBuilder> {
    public final URI namespace;
    public final Map<URI, URI> pathRedirects;
    public final Map<URI, URI> schemaRedirects;

    public URITranslatorConfiguration(URITranslatorConfigurationBuilder uRITranslatorConfigurationBuilder) {
        this.namespace = uRITranslatorConfigurationBuilder.namespace;
        this.pathRedirects = ImmutableMap.copyOf(uRITranslatorConfigurationBuilder.pathRedirects.build());
        this.schemaRedirects = ImmutableMap.copyOf(uRITranslatorConfigurationBuilder.schemaRedirects.build());
    }

    public static URITranslatorConfiguration byDefault() {
        return URITranslatorConfiguration.newBuilder().freeze();
    }

    public static URITranslatorConfigurationBuilder newBuilder() {
        return new URITranslatorConfigurationBuilder();
    }

    public URITranslatorConfigurationBuilder thaw() {
        return new URITranslatorConfigurationBuilder(this);
    }
}

