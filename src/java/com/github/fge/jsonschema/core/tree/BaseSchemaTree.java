/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.NullNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  com.fasterxml.jackson.databind.node.TextNode
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Objects
 */
package com.github.fge.jsonschema.core.tree;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jackson.jsonpointer.TokenResolver;
import com.github.fge.jsonschema.core.exceptions.JsonReferenceException;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.tree.key.SchemaKey;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public abstract class BaseSchemaTree
implements SchemaTree {
    private static final JsonNodeFactory FACTORY = JsonNodeFactory.instance;
    public final JsonNode baseNode;
    private final JsonRef currentRef;
    private final JsonRef dollarSchema;
    public final SchemaKey key;
    private final JsonNode node;
    public final JsonPointer pointer;
    private final JsonRef startingRef;

    @Deprecated
    public BaseSchemaTree(JsonRef jsonRef, JsonNode jsonNode, JsonPointer jsonPointer) {
        this.dollarSchema = BaseSchemaTree.extractDollarSchema(jsonNode);
        SchemaKey schemaKey = jsonRef.equals(JsonRef.emptyRef()) ? SchemaKey.anonymousKey() : SchemaKey.forJsonRef(jsonRef);
        this.key = schemaKey;
        this.baseNode = jsonNode;
        this.pointer = jsonPointer;
        this.node = jsonPointer.path(jsonNode);
        JsonRef jsonRef2 = BaseSchemaTree.idFromNode(jsonNode);
        if (jsonRef2 != null) {
            jsonRef = jsonRef.resolve(jsonRef2);
        }
        this.startingRef = jsonRef;
        this.currentRef = BaseSchemaTree.nextRef(jsonRef, jsonPointer, jsonNode);
    }

    public BaseSchemaTree(BaseSchemaTree baseSchemaTree, JsonPointer jsonPointer) {
        JsonRef jsonRef;
        JsonNode jsonNode;
        this.key = baseSchemaTree.key;
        this.dollarSchema = baseSchemaTree.dollarSchema;
        this.baseNode = jsonNode = baseSchemaTree.baseNode;
        this.pointer = jsonPointer;
        this.node = jsonPointer.path(jsonNode);
        this.startingRef = jsonRef = baseSchemaTree.startingRef;
        this.currentRef = BaseSchemaTree.nextRef(jsonRef, jsonPointer, jsonNode);
    }

    public BaseSchemaTree(SchemaKey schemaKey, JsonNode jsonNode, JsonPointer jsonPointer) {
        Objects.requireNonNull((Object)schemaKey);
        Objects.requireNonNull((Object)jsonNode);
        Objects.requireNonNull((Object)jsonPointer);
        this.key = schemaKey;
        this.dollarSchema = BaseSchemaTree.extractDollarSchema(jsonNode);
        this.baseNode = jsonNode;
        this.pointer = jsonPointer;
        this.node = jsonPointer.path(jsonNode);
        JsonRef jsonRef = schemaKey.getLoadingRef();
        JsonRef jsonRef2 = BaseSchemaTree.idFromNode(jsonNode);
        if (jsonRef2 != null) {
            jsonRef = jsonRef.resolve(jsonRef2);
        }
        this.startingRef = jsonRef;
        this.currentRef = BaseSchemaTree.nextRef(jsonRef, jsonPointer, jsonNode);
    }

    private static JsonRef extractDollarSchema(JsonNode jsonNode) {
        block4 : {
            JsonNode jsonNode2 = jsonNode.path("$schema");
            if (!jsonNode2.isTextual()) {
                return JsonRef.emptyRef();
            }
            try {
                JsonRef jsonRef = JsonRef.fromString(jsonNode2.textValue());
                if (!jsonRef.isAbsolute()) break block4;
                return jsonRef;
            }
            catch (JsonReferenceException jsonReferenceException) {
                return JsonRef.emptyRef();
            }
        }
        JsonRef jsonRef = JsonRef.emptyRef();
        return jsonRef;
    }

    public static JsonRef idFromNode(JsonNode jsonNode) {
        if (!jsonNode.path("id").isTextual()) {
            return null;
        }
        try {
            JsonRef jsonRef = JsonRef.fromString(jsonNode.get("id").textValue());
            return jsonRef;
        }
        catch (JsonReferenceException jsonReferenceException) {
            return null;
        }
    }

    private static JsonRef nextRef(JsonRef jsonRef, JsonPointer jsonPointer, JsonNode jsonNode) {
        Iterator iterator = jsonPointer.iterator();
        while (iterator.hasNext()) {
            jsonNode = ((TokenResolver)iterator.next()).get(jsonNode);
            if (jsonNode == null) {
                return jsonRef;
            }
            JsonRef jsonRef2 = BaseSchemaTree.idFromNode(jsonNode);
            if (jsonRef2 == null) continue;
            jsonRef = jsonRef.resolve(jsonRef2);
        }
        return jsonRef;
    }

    @Override
    public final JsonNode asJson() {
        JsonNodeFactory jsonNodeFactory = FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        TextNode textNode = jsonNodeFactory.textNode(this.key.getLoadingRef().toString());
        if (textNode == null) {
            objectNode.nullNode();
            textNode = NullNode.instance;
        }
        objectNode._children.put((Object)"loadingURI", (Object)textNode);
        TextNode textNode2 = jsonNodeFactory.textNode(this.pointer.toString());
        if (textNode2 == null) {
            objectNode.nullNode();
            textNode2 = NullNode.instance;
        }
        objectNode._children.put((Object)"pointer", (Object)textNode2);
        return objectNode;
    }

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!(object instanceof BaseSchemaTree)) {
            return false;
        }
        BaseSchemaTree baseSchemaTree = (BaseSchemaTree)object;
        boolean bl = this.key.equals(baseSchemaTree.key);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = this.pointer.equals(baseSchemaTree.pointer);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    public final JsonNode getBaseNode() {
        return this.baseNode;
    }

    @Override
    public final JsonRef getContext() {
        return this.currentRef;
    }

    @Override
    public final JsonRef getDollarSchema() {
        return this.dollarSchema;
    }

    @Deprecated
    @Override
    public final long getId() {
        return this.key.getId();
    }

    @Override
    public final JsonRef getLoadingRef() {
        return this.key.getLoadingRef();
    }

    @Override
    public final JsonNode getNode() {
        return this.node;
    }

    @Override
    public final JsonPointer getPointer() {
        return this.pointer;
    }

    public final int hashCode() {
        return this.key.hashCode() ^ this.pointer.hashCode();
    }

    @Override
    public final JsonRef resolve(JsonRef jsonRef) {
        return this.currentRef.resolve(jsonRef);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append("{");
        stringBuilder.append("key");
        stringBuilder.append("=");
        stringBuilder.append((Object)this.key);
        stringBuilder.append(", pointer");
        stringBuilder.append("=");
        stringBuilder.append((Object)this.pointer);
        stringBuilder.append(", URI context");
        stringBuilder.append("=");
        stringBuilder.append((Object)this.currentRef);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

