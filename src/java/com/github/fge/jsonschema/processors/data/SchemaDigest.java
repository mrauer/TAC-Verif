/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.google.common.collect.ImmutableMap
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.github.fge.jsonschema.processors.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.processors.data.SchemaContext;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public final class SchemaDigest
implements MessageProvider {
    private final SchemaContext context;
    private final Map<String, JsonNode> digested;

    public SchemaDigest(SchemaContext schemaContext, Map<String, JsonNode> map) {
        this.context = schemaContext;
        this.digested = ImmutableMap.copyOf(map);
    }

    public SchemaContext getContext() {
        return this.context;
    }

    public Map<String, JsonNode> getDigests() {
        return this.digested;
    }

    @Override
    public ProcessingMessage newMessage() {
        return this.context.newMessage();
    }
}

