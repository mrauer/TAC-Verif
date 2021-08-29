/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.MissingNode
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.util.Objects
 */
package com.github.fge.jsonschema.core.tree;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.tree.BaseSchemaTree;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.tree.key.SchemaKey;
import java.util.Objects;

public final class CanonicalSchemaTree
extends BaseSchemaTree {
    @Deprecated
    public CanonicalSchemaTree(JsonNode jsonNode) {
        this(SchemaKey.anonymousKey(), jsonNode);
    }

    @Deprecated
    public CanonicalSchemaTree(JsonRef jsonRef, JsonNode jsonNode) {
        this(SchemaKey.forJsonRef(jsonRef), jsonNode);
    }

    private CanonicalSchemaTree(CanonicalSchemaTree canonicalSchemaTree, JsonPointer jsonPointer) {
        super(canonicalSchemaTree, jsonPointer);
    }

    public CanonicalSchemaTree(SchemaKey schemaKey, JsonNode jsonNode) {
        super(schemaKey, jsonNode, JsonPointer.EMPTY);
    }

    @Override
    public SchemaTree append(JsonPointer jsonPointer) {
        return new CanonicalSchemaTree(this, this.pointer.append(jsonPointer));
    }

    @Override
    public boolean containsRef(JsonRef jsonRef) {
        return this.key.getLoadingRef().contains(jsonRef);
    }

    @Override
    public JsonPointer matchingPointer(JsonRef jsonRef) {
        if (!jsonRef.isLegal()) {
            return null;
        }
        JsonPointer jsonPointer = jsonRef.getPointer();
        JsonNode jsonNode = jsonPointer.path(this.baseNode);
        Objects.requireNonNull((Object)jsonNode);
        if (jsonNode instanceof MissingNode) {
            return null;
        }
        return jsonPointer;
    }

    @Override
    public SchemaTree setPointer(JsonPointer jsonPointer) {
        return new CanonicalSchemaTree(this, jsonPointer);
    }
}

