/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.tree.JsonTree
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.processors.data;

import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.util.AsJson;

public final class FullData
implements MessageProvider {
    private final boolean deepCheck;
    private final JsonTree instance;
    private final SchemaTree schema;

    @Deprecated
    public FullData(SchemaTree schemaTree) {
        this(schemaTree, null);
    }

    public FullData(SchemaTree schemaTree, JsonTree jsonTree) {
        this(schemaTree, jsonTree, false);
    }

    public FullData(SchemaTree schemaTree, JsonTree jsonTree, boolean bl) {
        this.schema = schemaTree;
        this.instance = jsonTree;
        this.deepCheck = bl;
    }

    public JsonTree getInstance() {
        return this.instance;
    }

    public SchemaTree getSchema() {
        return this.schema;
    }

    public boolean isDeepCheck() {
        return this.deepCheck;
    }

    @Override
    public ProcessingMessage newMessage() {
        JsonTree jsonTree;
        ProcessingMessage processingMessage = new ProcessingMessage();
        SchemaTree schemaTree = this.schema;
        if (schemaTree != null) {
            processingMessage.put("schema", (AsJson)schemaTree);
        }
        if ((jsonTree = this.instance) != null) {
            processingMessage.put("instance", (AsJson)jsonTree);
        }
        return processingMessage;
    }

    public FullData withInstance(JsonTree jsonTree) {
        return new FullData(this.schema, jsonTree, this.deepCheck);
    }

    public FullData withSchema(SchemaTree schemaTree) {
        return new FullData(schemaTree, this.instance, this.deepCheck);
    }
}

