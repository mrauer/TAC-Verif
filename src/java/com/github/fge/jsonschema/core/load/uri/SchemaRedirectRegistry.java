/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Function
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URI
 */
package com.github.fge.jsonschema.core.load.uri;

import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.util.ArgumentChecker;
import com.github.fge.jsonschema.core.util.Registry;
import com.github.fge.jsonschema.core.util.URIUtils;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import com.google.common.base.Function;
import java.net.URI;

public final class SchemaRedirectRegistry
extends Registry<URI, URI> {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);

    public SchemaRedirectRegistry() {
        super(URIUtils.schemaURINormalizer(), URIUtils.schemaURIChecker(), URIUtils.schemaURINormalizer(), URIUtils.schemaURIChecker());
    }

    @Override
    public void checkEntry(URI uRI, URI uRI2) {
        BUNDLE.checkArgumentFormat(true ^ uRI.equals((Object)uRI2), "schemaRedirect.selfRedirect", new Object[]{uRI});
    }
}

