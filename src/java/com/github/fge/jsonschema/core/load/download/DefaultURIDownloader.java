/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.net.URI
 *  java.net.URL
 */
package com.github.fge.jsonschema.core.load.download;

import com.github.fge.jsonschema.core.load.download.URIDownloader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public final class DefaultURIDownloader
implements URIDownloader {
    private static final URIDownloader INSTANCE = new DefaultURIDownloader();

    private DefaultURIDownloader() {
    }

    public static URIDownloader getInstance() {
        return INSTANCE;
    }

    @Override
    public InputStream fetch(URI uRI) throws IOException {
        return uRI.toURL().openStream();
    }
}

