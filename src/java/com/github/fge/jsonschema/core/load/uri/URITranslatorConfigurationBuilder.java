/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URI
 *  java.util.Map
 */
package com.github.fge.jsonschema.core.load.uri;

import com.github.fge.Frozen;
import com.github.fge.Thawed;
import com.github.fge.jsonschema.core.load.uri.PathRedirectRegistry;
import com.github.fge.jsonschema.core.load.uri.SchemaRedirectRegistry;
import com.github.fge.jsonschema.core.load.uri.URITranslatorConfiguration;
import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.util.Registry;
import com.github.fge.jsonschema.core.util.URIUtils;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import java.net.URI;
import java.util.Map;

public final class URITranslatorConfigurationBuilder
implements Thawed<URITranslatorConfiguration> {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    private static final URI EMPTY = URI.create((String)"");
    public URI namespace = EMPTY;
    public final PathRedirectRegistry pathRedirects;
    public final SchemaRedirectRegistry schemaRedirects;

    public URITranslatorConfigurationBuilder() {
        this.pathRedirects = new PathRedirectRegistry();
        this.schemaRedirects = new SchemaRedirectRegistry();
    }

    public URITranslatorConfigurationBuilder(URITranslatorConfiguration uRITranslatorConfiguration) {
        PathRedirectRegistry pathRedirectRegistry;
        SchemaRedirectRegistry schemaRedirectRegistry;
        this.pathRedirects = pathRedirectRegistry = new PathRedirectRegistry();
        this.schemaRedirects = schemaRedirectRegistry = new SchemaRedirectRegistry();
        this.namespace = uRITranslatorConfiguration.namespace;
        pathRedirectRegistry.putAll(uRITranslatorConfiguration.pathRedirects);
        schemaRedirectRegistry.putAll(uRITranslatorConfiguration.schemaRedirects);
    }

    public URITranslatorConfigurationBuilder addPathRedirect(String string, String string2) {
        MessageBundle messageBundle = BUNDLE;
        messageBundle.checkNotNull(string, "uriChecks.nullInput");
        messageBundle.checkNotNull(string2, "uriChecks.nullInput");
        return this.addPathRedirect(URI.create((String)string), URI.create((String)string2));
    }

    public URITranslatorConfigurationBuilder addPathRedirect(URI uRI, URI uRI2) {
        this.pathRedirects.put(uRI, uRI2);
        return this;
    }

    public URITranslatorConfigurationBuilder addSchemaRedirect(String string, String string2) {
        MessageBundle messageBundle = BUNDLE;
        messageBundle.checkNotNull(string, "uriChecks.nullInput");
        messageBundle.checkNotNull(string2, "uriChecks.nullInput");
        return this.addSchemaRedirect(URI.create((String)string), URI.create((String)string2));
    }

    public URITranslatorConfigurationBuilder addSchemaRedirect(URI uRI, URI uRI2) {
        this.schemaRedirects.put(uRI, uRI2);
        return this;
    }

    public URITranslatorConfiguration freeze() {
        return new URITranslatorConfiguration(this);
    }

    public URITranslatorConfigurationBuilder setNamespace(String string) {
        BUNDLE.checkNotNull(string, "uriChecks.nullInput");
        return this.setNamespace(URI.create((String)string));
    }

    public URITranslatorConfigurationBuilder setNamespace(URI uRI) {
        BUNDLE.checkNotNull(uRI, "uriChecks.nullInput");
        URI uRI2 = URIUtils.normalizeURI(uRI);
        URIUtils.checkPathURI(uRI2);
        this.namespace = uRI2;
        return this;
    }
}

