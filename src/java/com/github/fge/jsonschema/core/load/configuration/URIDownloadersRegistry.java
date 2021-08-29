/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Function
 *  com.google.common.base.Functions
 *  com.google.common.base.Functions$IdentityFunction
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableMap$Builder
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.github.fge.jsonschema.core.load.configuration;

import com.github.fge.jsonschema.core.load.download.DefaultURIDownloader;
import com.github.fge.jsonschema.core.load.download.ResourceURIDownloader;
import com.github.fge.jsonschema.core.load.download.URIDownloader;
import com.github.fge.jsonschema.core.util.ArgumentChecker;
import com.github.fge.jsonschema.core.util.Registry;
import com.github.fge.jsonschema.core.util.URIUtils;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public final class URIDownloadersRegistry
extends Registry<String, URIDownloader> {
    private static final Map<String, URIDownloader> DEFAULT_DOWNLOADERS;

    public static {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        builder.put((Object)"http", (Object)DefaultURIDownloader.getInstance());
        builder.put((Object)"https", (Object)DefaultURIDownloader.getInstance());
        builder.put((Object)"file", (Object)DefaultURIDownloader.getInstance());
        builder.put((Object)"ftp", (Object)DefaultURIDownloader.getInstance());
        builder.put((Object)"jar", (Object)DefaultURIDownloader.getInstance());
        builder.put((Object)"resource", (Object)ResourceURIDownloader.getInstance());
        DEFAULT_DOWNLOADERS = builder.build();
    }

    public URIDownloadersRegistry() {
        super(URIUtils.schemeNormalizer(), URIUtils.schemeChecker(), Functions.IdentityFunction.INSTANCE, ArgumentChecker.anythingGoes());
        this.putAll(DEFAULT_DOWNLOADERS);
    }

    @Override
    public void checkEntry(String string, URIDownloader uRIDownloader) {
    }
}

