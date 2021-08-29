/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.net.URI
 */
package com.github.fge.jsonschema.core.load.download;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public interface URIDownloader {
    public InputStream fetch(URI var1) throws IOException;
}

