/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.core.tree.JsonTree
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.processors.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.util.AsJson;
import com.github.fge.jsonschema.processors.data.FullData;

public final class SchemaContext
implements MessageProvider {
    private final NodeType instanceType;
    private final SchemaTree schema;

    public SchemaContext(SchemaTree schemaTree, NodeType nodeType) {
        this.schema = schemaTree;
        this.instanceType = nodeType;
    }

    public SchemaContext(FullData fullData) {
        this.schema = fullData.getSchema();
        JsonTree jsonTree = fullData.getInstance();
        NodeType nodeType = jsonTree != null ? NodeType.getNodeType(jsonTree.getNode()) : null;
        this.instanceType = nodeType;
    }

    public NodeType getInstanceType() {
        return this.instanceType;
    }

    public SchemaTree getSchema() {
        return this.schema;
    }

    @Override
    public ProcessingMessage newMessage() {
        return new ProcessingMessage().put("schema", (AsJson)this.schema);
    }
}

