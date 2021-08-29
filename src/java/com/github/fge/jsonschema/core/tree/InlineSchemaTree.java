/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.MissingNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  com.google.common.collect.ImmutableMap
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 */
package com.github.fge.jsonschema.core.tree;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.JacksonUtils;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.tree.BaseSchemaTree;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.tree.key.SchemaKey;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class InlineSchemaTree
extends BaseSchemaTree {
    private final Map<JsonRef, JsonPointer> absRefs;
    private final Map<JsonRef, JsonPointer> otherRefs;

    @Deprecated
    public InlineSchemaTree(JsonNode jsonNode) {
        this(SchemaKey.anonymousKey(), jsonNode);
    }

    @Deprecated
    public InlineSchemaTree(JsonRef jsonRef, JsonNode jsonNode) {
        this(SchemaKey.forJsonRef(jsonRef), jsonNode);
    }

    private InlineSchemaTree(InlineSchemaTree inlineSchemaTree, JsonPointer jsonPointer) {
        super(inlineSchemaTree, jsonPointer);
        this.absRefs = inlineSchemaTree.absRefs;
        this.otherRefs = inlineSchemaTree.otherRefs;
    }

    public InlineSchemaTree(SchemaKey schemaKey, JsonNode jsonNode) {
        JsonPointer jsonPointer = JsonPointer.EMPTY;
        super(schemaKey, jsonNode, jsonPointer);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        InlineSchemaTree.walk(schemaKey.getLoadingRef(), jsonNode, jsonPointer, (Map<JsonRef, JsonPointer>)hashMap, (Map<JsonRef, JsonPointer>)hashMap2);
        this.absRefs = ImmutableMap.copyOf((Map)hashMap);
        this.otherRefs = ImmutableMap.copyOf((Map)hashMap2);
    }

    private JsonPointer getMatchingPointer(JsonRef jsonRef) {
        if (this.otherRefs.containsKey((Object)jsonRef)) {
            return (JsonPointer)this.otherRefs.get((Object)jsonRef);
        }
        if (!jsonRef.isLegal()) {
            return null;
        }
        return this.refMatchingPointer(jsonRef);
    }

    private JsonPointer refMatchingPointer(JsonRef jsonRef) {
        JsonPointer jsonPointer = jsonRef.getPointer();
        for (Map.Entry entry : this.absRefs.entrySet()) {
            if (!((JsonRef)entry.getKey()).contains(jsonRef)) continue;
            return ((JsonPointer)entry.getValue()).append(jsonPointer);
        }
        if (this.key.getLoadingRef().contains(jsonRef)) {
            return jsonPointer;
        }
        return null;
    }

    private static void walk(JsonRef jsonRef, JsonNode jsonNode, JsonPointer jsonPointer, Map<JsonRef, JsonPointer> map, Map<JsonRef, JsonPointer> map2) {
        Objects.requireNonNull((Object)jsonNode);
        if (!(jsonNode instanceof ObjectNode)) {
            return;
        }
        JsonRef jsonRef2 = BaseSchemaTree.idFromNode(jsonNode);
        if (jsonRef2 != null) {
            Map<JsonRef, JsonPointer> map3 = (jsonRef = jsonRef.resolve(jsonRef2)).isAbsolute() ? map : map2;
            map3.put((Object)jsonRef, (Object)jsonPointer);
        }
        for (Map.Entry entry : ((HashMap)JacksonUtils.asMap(jsonNode)).entrySet()) {
            InlineSchemaTree.walk(jsonRef, (JsonNode)entry.getValue(), jsonPointer.append((String)entry.getKey()), map, map2);
        }
    }

    @Override
    public SchemaTree append(JsonPointer jsonPointer) {
        return new InlineSchemaTree(this, this.pointer.append(jsonPointer));
    }

    @Override
    public boolean containsRef(JsonRef jsonRef) {
        return this.getMatchingPointer(jsonRef) != null;
    }

    @Override
    public JsonPointer matchingPointer(JsonRef jsonRef) {
        JsonPointer jsonPointer = this.getMatchingPointer(jsonRef);
        if (jsonPointer == null) {
            return null;
        }
        JsonNode jsonNode = jsonPointer.path(this.baseNode);
        Objects.requireNonNull((Object)jsonNode);
        if (jsonNode instanceof MissingNode) {
            jsonPointer = null;
        }
        return jsonPointer;
    }

    @Override
    public SchemaTree setPointer(JsonPointer jsonPointer) {
        return new InlineSchemaTree(this, jsonPointer);
    }
}

