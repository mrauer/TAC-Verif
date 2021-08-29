/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jackson.jsonpointer.JsonPointer
 *  com.google.common.collect.ImmutableList
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Objects
 */
package com.github.fge.jsonschema.processors.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.Objects;

public final class ArraySchemaSelector {
    private static final JsonPointer ADDITIONAL_ITEMS;
    private static final JsonPointer ITEMS;
    private final boolean hasAdditional;
    private final boolean hasItems;
    private final boolean itemsIsArray;
    private final int itemsSize;

    public static {
        ITEMS = JsonPointer.of((Object)"items", (Object[])new Object[0]);
        ADDITIONAL_ITEMS = JsonPointer.of((Object)"additionalItems", (Object[])new Object[0]);
    }

    public ArraySchemaSelector(JsonNode jsonNode) {
        this.hasItems = jsonNode.get("hasItems").booleanValue();
        this.itemsIsArray = jsonNode.get("itemsIsArray").booleanValue();
        this.itemsSize = jsonNode.get("itemsSize").intValue();
        this.hasAdditional = jsonNode.get("hasAdditional").booleanValue();
    }

    public Iterable<JsonPointer> selectSchemas(int n3) {
        if (!this.hasItems) {
            if (this.hasAdditional) {
                return ImmutableList.of((Object)ADDITIONAL_ITEMS);
            }
            return Collections.emptyList();
        }
        if (!this.itemsIsArray) {
            return ImmutableList.of((Object)ITEMS);
        }
        if (n3 < this.itemsSize) {
            JsonPointer jsonPointer = ITEMS;
            Objects.requireNonNull((Object)jsonPointer);
            return ImmutableList.of((Object)jsonPointer.append(Integer.toString((int)n3)));
        }
        if (this.hasAdditional) {
            return ImmutableList.of((Object)ADDITIONAL_ITEMS);
        }
        return Collections.emptyList();
    }
}

