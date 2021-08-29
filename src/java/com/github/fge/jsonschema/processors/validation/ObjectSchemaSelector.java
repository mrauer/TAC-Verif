/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jackson.jsonpointer.JsonPointer
 *  com.google.common.collect.ImmutableList
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package com.github.fge.jsonschema.processors.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.util.RegexECMA262Helper;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ObjectSchemaSelector {
    private static final JsonPointer ADDITIONALPROPERTIES;
    private static final JsonPointer PATTERNPROPERTIES;
    private static final JsonPointer PROPERTIES;
    private final boolean hasAdditional;
    private final List<String> patternProperties;
    private final List<String> properties;

    public static {
        PROPERTIES = JsonPointer.of((Object)"properties", (Object[])new Object[0]);
        PATTERNPROPERTIES = JsonPointer.of((Object)"patternProperties", (Object[])new Object[0]);
        ADDITIONALPROPERTIES = JsonPointer.of((Object)"additionalProperties", (Object[])new Object[0]);
    }

    public ObjectSchemaSelector(JsonNode jsonNode) {
        this.hasAdditional = jsonNode.get("hasAdditional").booleanValue();
        ArrayList arrayList = new ArrayList();
        Iterator iterator = jsonNode.get("properties").elements();
        while (iterator.hasNext()) {
            arrayList.add((Object)((JsonNode)iterator.next()).textValue());
        }
        this.properties = ImmutableList.copyOf((Collection)arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator2 = jsonNode.get("patternProperties").elements();
        while (iterator2.hasNext()) {
            arrayList2.add((Object)((JsonNode)iterator2.next()).textValue());
        }
        this.patternProperties = ImmutableList.copyOf((Collection)arrayList2);
    }

    public Iterable<JsonPointer> selectSchemas(String string) {
        ArrayList arrayList = new ArrayList();
        if (this.properties.contains((Object)string)) {
            arrayList.add((Object)PROPERTIES.append(string));
        }
        for (String string2 : this.patternProperties) {
            if (!RegexECMA262Helper.regMatch(string2, string)) continue;
            arrayList.add((Object)PATTERNPROPERTIES.append(string2));
        }
        if (!arrayList.isEmpty()) {
            return ImmutableList.copyOf((Collection)arrayList);
        }
        if (this.hasAdditional) {
            return ImmutableList.of((Object)ADDITIONALPROPERTIES);
        }
        return Collections.emptyList();
    }
}

