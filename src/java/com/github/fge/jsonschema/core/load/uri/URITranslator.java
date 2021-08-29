/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.load.uri.URITranslatorConfiguration
 *  com.google.common.collect.ImmutableMap
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.github.fge.jsonschema.core.load.uri;

import com.github.fge.jsonschema.core.load.uri.URITranslatorConfiguration;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.util.URIUtils;
import com.google.common.collect.ImmutableMap;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

public final class URITranslator {
    private final URI namespace;
    private final Map<URI, URI> pathRedirects;
    private final Map<URI, URI> schemaRedirects;

    public URITranslator(URITranslatorConfiguration uRITranslatorConfiguration) {
        this.namespace = uRITranslatorConfiguration.namespace;
        this.pathRedirects = ImmutableMap.copyOf((Map)uRITranslatorConfiguration.pathRedirects);
        this.schemaRedirects = ImmutableMap.copyOf((Map)uRITranslatorConfiguration.schemaRedirects);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public URI translate(URI uRI) {
        URI uRI2 = URIUtils.normalizeURI(this.namespace.resolve(uRI));
        String string = uRI2.getFragment();
        URI uRI3 = new URI(uRI2.getScheme(), uRI2.getSchemeSpecificPart(), null);
        for (Map.Entry entry : this.pathRedirects.entrySet()) {
            URI uRI4 = ((URI)entry.getKey()).relativize(uRI3);
            if (uRI4.equals((Object)uRI3)) continue;
            uRI3 = ((URI)entry.getValue()).resolve(uRI4);
        }
        URI uRI5 = JsonRef.fromURI(uRI3).getLocator();
        if (this.schemaRedirects.containsKey((Object)uRI5)) {
            uRI5 = (URI)this.schemaRedirects.get((Object)uRI5);
        }
        try {
            return new URI(uRI5.getScheme(), uRI5.getSchemeSpecificPart(), string);
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new IllegalStateException("How did I get there??", (Throwable)uRISyntaxException);
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new IllegalStateException("How did I get there??", (Throwable)uRISyntaxException);
        }
    }
}

