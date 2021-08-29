/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URI
 *  java.util.List
 */
package com.github.fge.jsonschema.core.ref;

import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jackson.jsonpointer.TokenResolver;
import com.github.fge.jackson.jsonpointer.TreePointer;
import com.github.fge.jsonschema.core.ref.JsonRef;
import java.net.URI;
import java.util.List;

public final class JarJsonRef
extends JsonRef {
    private final String jarPrefix;
    private final URI pathURI;

    public JarJsonRef(URI uRI) {
        super(uRI);
        String string = uRI.toString();
        int n = 1 + string.indexOf(33);
        this.jarPrefix = string.substring(0, n);
        this.pathURI = URI.create((String)string.substring(n));
    }

    private JarJsonRef(URI uRI, String string, URI uRI2) {
        super(uRI);
        this.jarPrefix = string;
        this.pathURI = uRI2;
    }

    @Override
    public boolean isAbsolute() {
        return this.legal && this.pointer.tokenResolvers.isEmpty();
    }

    @Override
    public JsonRef resolve(JsonRef jsonRef) {
        if (jsonRef.uri.isAbsolute()) {
            return jsonRef;
        }
        URI uRI = this.pathURI.resolve(jsonRef.uri);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.jarPrefix);
        stringBuilder.append(uRI.toString());
        return new JarJsonRef(URI.create((String)stringBuilder.toString()), this.jarPrefix, uRI);
    }
}

