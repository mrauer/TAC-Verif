/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URI
 */
package com.github.fge.jsonschema.core.load.download;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.fge.jsonschema.core.load.download.URIDownloader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public final class ResourceURIDownloader
implements URIDownloader {
    private static final URIDownloader INSTANCE;
    private static final Class<ResourceURIDownloader> MYSELF;

    public static {
        MYSELF = ResourceURIDownloader.class;
        INSTANCE = new ResourceURIDownloader();
    }

    private ResourceURIDownloader() {
    }

    public static URIDownloader getInstance() {
        return INSTANCE;
    }

    @Override
    public InputStream fetch(URI uRI) throws IOException {
        String string = uRI.getPath();
        InputStream inputStream = MYSELF.getResourceAsStream(string);
        if (inputStream != null) {
            return inputStream;
        }
        throw new IOException(GeneratedOutlineSupport.outline19((String)"resource ", (String)string, (String)" not found"));
    }
}

